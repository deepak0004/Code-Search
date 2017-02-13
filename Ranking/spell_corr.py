import math, snowballstemmer, operator, os, glob
from string import ascii_lowercase
from nltk.stem.wordnet import WordNetLemmatizer
from nltk.corpus import stopwords
from math import log

import sys
reload(sys)
sys.setdefaultencoding("utf-8")

# initialize stemmer
stemmer = snowballstemmer.EnglishStemmer()

# grab stopword list, extend it a bit, and then turn it into a set for later
stop = stopwords.words('english')
stoplist = stemmer.stemWords(stop)
stop = set(sorted(stop + list(stoplist))) 

def isdigit( strr ):
    for i in range( len(strr) ):
        if( strr[i]=='0' or strr[i]=='1' or strr[i]=='2' or strr[i]=='3' or strr[i]=='4' or strr[i]=='5' or strr[i]=='6' or strr[i]=='7' or strr[i]=='8' or strr[i]=='9' or strr[i]=='/' or strr[i]=='\\' ):
            return 0
     
    return 1;  

lmtzr = WordNetLemmatizer()

names_of_doc = []
doc_list = []
pos_array = []
tokens = []
all_words = []

index_array = {}
word_arr = {}
doc_count = {}

j = 0

def edit_distance(str1, str2):          

    mm = len(str1)                        
    nn = len(str2)                           

    memo = [[0 for x in range(nn+1)] for x in range(mm+1)]
    
    len11 = range(mm+1)
    len22 = range(nn+1)
    for vari in len11:
        for varj in len22:
            
            if( vari == 0 ):     
                memo[ vari ][ varj ] = varj    
                continue
            
            if( j == 0 ):
                memo[ vari ][ varj ] = vari    
                continue
            
            if( str1[vari-1] == str2[varj-1] ):
                memo[vari][varj] = memo[vari-1][varj-1]
            
            else:   
                memo[vari][varj] = 1 + min( min( memo[vari][varj-1], memo[vari-1][varj] ), memo[vari-1][varj-1] )    
 
    return memo[mm][nn]

def read():
    for filename in glob.glob(os.path.join("/home/user/Desktop/Ranking/Documents", '*.txt')):
        names_of_doc.append( os.path.basename(filename) )
        para = ""
        f = open( filename,'r' )
        para = f.readlines()
        # you may also want to remove whitespace characters like `\n` at the end of each line
        para = [x.strip() for x in para]  
        doc_list.append( str(para) )
        
read()
documents = doc_list

for doc in documents:
    index_array = {}
    tokens = doc.split(" ") 
    pos = 0
    for tok in tokens:
        pos += 1
        tok = tok.lower()
        if( (tok not in stop) and len(tok)>2 and isdigit(tok)==1 ):
            try:
                oioi = lmtzr.lemmatize(tok)
            except:
                continue
            word_without_unicode = oioi.encode('ascii', 'ignore')
            word_without_unicode = word_without_unicode.replace(",", "")
            word_without_unicode = word_without_unicode.replace("(", "")
            word_without_unicode = word_without_unicode.replace(")", "")
            word_without_unicode = word_without_unicode.replace("'", "")
            word_without_unicode = word_without_unicode.replace(".", "")
            tok = word_without_unicode 
            if tok in index_array:
                index_array[tok].append(pos)
            else:
                index_array[tok] = [pos]
    word_arr[ names_of_doc[j] ] = index_array 
    doc_count[ names_of_doc[j] ] = len(tokens)
    j += 1

ask_for_query = raw_input("Search: ")
ask_for_query = ask_for_query.lower()
query = ask_for_query.split(" ")
test = query    
query = []

for qq in test:
    if( qq not in stop ):
        query.append( qq )

test = query 

expand_q = []
scoringgg = {}

for qr in test:
    checker = 0
    for dox in word_arr:
        for identt, value in word_arr[dox].items():
            temp = qr[0]
            if( len(identt)>=4 ):
                if( identt[0] == temp ):       # first character same
                    if( edit_distance(qr, identt)<=2 ):
                        if( edit_distance(qr, identt)==0 ):
                            checker = 1
                            break
                        if( identt not in expand_q ):
                            expand_q.append(identt)                
                            
    if( checker==1 ):
       query = [qr]
    else:
       query = expand_q
       
    for query_word in query:
        coun = 0
        for doc in word_arr:
            if( query_word in word_arr[doc] ):
                coun += 1
        coun = max(coun, 1)
        
        idff = math.log(float(len(word_arr)) / coun) / log(10)
       
        for doc in word_arr:
            if( query_word in word_arr[doc] ):
                term_freq = float( len(word_arr[doc][query_word]) )
                term_freq = log(1 + term_freq) 
            else:
                term_freq = 0
            if( doc in scoringgg ):
                scoringgg[doc] += idff*term_freq
            else:
                scoringgg[doc] = idff*term_freq 
       
    expand_q = []            
            
sort_dict = sorted( scoringgg.items(), key=operator.itemgetter(1), reverse=True )

le = 0

for i in range( len(sort_dict) ):
   if( ( sort_dict[i][1]!=0 ) and ( le<min(11, len(sort_dict)) ) ):
       le += 1
       print sort_dict[i][0]

if( le==0 ):
    print( 'No documents' )
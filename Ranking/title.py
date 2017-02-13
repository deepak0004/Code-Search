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
stop = set( sorted(stop + list(stoplist)) ) 

lmtzr = WordNetLemmatizer()

names_of_doc = []
doc_list = []
pos_array = []
tokens = []
all_words = []
first_add = []

scoringgg = {}
title_dict = {}
arr_ind = {}
word_arr_ind = {}
doc_count = {}
title_main_dict = {}

j = 0

def read():
    for filename in glob.glob(os.path.join("/home/user/Desktop/IR/Documents", '*.txt')):
        names_of_doc.append( os.path.basename(filename) )
        para = ""
        f = open( filename,'r' )
        para = f.readlines()
        # you may also want to remove whitespace characters like `\n` at the end of each line
        para = [x.strip() for x in para]  
        doc_list.append( str(para) )
        just_title = para[0].split("_")
        title_dict[os.path.basename(filename)] = just_title   # file_name -> file name splitted_
        
read() 
documents = doc_list

for doc in documents:
    arr_ind = {}
    tokens = doc.split(" ") 
    pos = 0
    for tok in tokens:
        pos_array = []
        pos += 1
        tok = tok.lower()
        if( (tok not in stop) and len(tok)>2 ):
            try:
                oioi = lmtzr.lemmatize(tok)
            except:
                continue
            word_without_unicode = oioi.encode('ascii', 'ignore')
            tok = word_without_unicode 
            if tok in arr_ind:
                arr_ind[tok].append(pos)
            else:
                arr_ind[tok] = [pos]
    word_arr_ind[ names_of_doc[j] ] = arr_ind 
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

def func():
    for qr in query:    
        title_dict = {}
        counc = 0
        for dox in title_dict:
            if qr in title_dict[dox]:
                tf = title_dict[dox].count(qr) 
                title_dict[dox] = tf  # document_name -> term frequency
                counc += 1
                
        for tfs in title_dict:                                                         
            yoyo = title_dict[tfs]
            title_compute_tf = log(1 + yoyo) / log(10)
            idff = log( float(len(title_dict)) / counc ) / log(10)
            scoree = title_compute_tf * idff
            if tfs in title_main_dict:
                title_main_dict[tfs] += scoree
            else:
                title_main_dict[tfs] = scoree

func()
for query_word in query:
    coun = 0
    
    for doc in word_arr_ind:
        if( query_word in word_arr_ind[doc] ):
            coun += 1
    
    coun = max(coun, 1)
    idff = log(float(len(word_arr_ind)) / coun) / log(10)
  
    for doc in word_arr_ind:
        if( query_word in word_arr_ind[doc] ):
            term_freq = float( len(word_arr_ind[doc][query_word]) )
            term_freq = log(1 + term_freq) 
        else:
            term_freq = 0
        if( doc in scoringgg ):
            scoringgg[doc] += idff*term_freq
        else:
            scoringgg[doc] = idff*term_freq

sort_dict = sorted( scoringgg.items(), key=operator.itemgetter(1), reverse=True )
sorted_title_dict = sorted(title_main_dict.items(), key=operator.itemgetter(1), reverse=True)

le = 0

for i in range( len(sorted_title_dict) ):
   if( sorted_title_dict[i][1] != 0 and ( le<min(11, len(sort_dict)) ) ):
       le += 1
       first_add.append( sorted_title_dict[i][0] )
       print sorted_title_dict[i][0]

for i in range( len(sort_dict) ):
   if( ( sort_dict[i][1]!=0 ) and ( le<min(11, len(sort_dict)) ) and ( sort_dict[i][0] not in first_add ) ):
       le += 1
       print sort_dict[i][0]

if( le==0 ):
   print( 'No documents' )
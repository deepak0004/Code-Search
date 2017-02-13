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
stop = stopwords.words('english')
stop.extend(['may','also','zero','one','two','three','four','five','six','seven','eight','nine','ten','across','among','beside','however','yet','within']+list(ascii_lowercase))
stop.extend(['using', 'way', 'would', 'use', 'i', 'don\'t', 'type', 'it', 'i\'m', 'is', 'get', '<a', 'want', 'another', 'could', '+', 'something', 'used', 'it\'s', 'like', '=', '-', '+', 'see', 'look', 'id', 'make', 'size', 'getting', 'let', 'height', 'maybe', 'know', 'thanks', 'fine', 'always', 'stored', 'us', 'bit', 'called', 'create', 'hand', 'menu'])
stop.extend( ['warn', 'main', 'localhost', 'http', 'startstop', 'bio', 'info', 'cluster', 'finest', 'chatapp', 'disabled', 'new', 'clientoutboundchannel', 'appenders', 'run', 'okdebug', 'monkey_', 'successful', 'finer', 'apr', 'edt', 'audit', 'jul', 'heartbeat', 'reconnection', 'uma', 'disconnected', 'ping', 'serv', 'jgroups', 'javawsapplicationmain'])
stop.extend( ['discovered', 'severe', 'remote', 'dc', 'maig', 'trace', 'wrappermanager', 'cest', 'connection', 'elasticsearch', 'maynard', 'roottracer', 'tiboldt', 'djavax', 'livebeansview', 'control', 'temporarily', 'completed', 'asyncio', 'bootstrap', 'cancelling', 'wthlnap', 'shutting', 'infowrapper', 'mchange', 'feb', 'cfpvednfsg'])
stop.extend( ['logged', 'appeventdao', 'datasourceutils', 'forwarding', 'elasticsearchmaynard', 'imyf', 'appeventdao', 'datasourceutils', 'forwarding', 'elasticsearchmaynard', 'imyf', 'connection[', 'unwanted', 'localvalue', 'exited', 'newsession', 'srvmain', 'gradle\\', 'lient', 'defuncting', 'org', 'errorexit', 'upclsch', 'permessage', 'httpsessionsecuritycontextrepository'] )
stop.extend( ['ulimit', '_auth', 'stdout', 'dwrapper', 'org', 'inflight', 'setdebug', 'defaulting', 'debugfilter', 'wrapperinfo', 'alive', 'simplejdbccall', 'logpath', '\\hellogluon\\', 'jlogger', 'multicast', 'ramlprocessor', 'false[chatapp', 'servicemetadata', 'openglrenderer', 'jackrabbit', 'appthread', 'setuseparenthandlers', 'getprotocol', 'loginfo', 'cookie', 'isloggable', 'multicast' ] )

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
tf_array = {}
doc_count = {}
scoringg = {}

j = 0

def read():
    for filename in glob.glob(os.path.join("/home/user/Desktop/Ranking/Documents", '*.txt')):
        names_of_doc.append( os.path.basename(filename) )
        para = ""
        f = open( filename,'r' )
        para = f.readlines()
        # you may also want to remove whitespace characters like `\n` at the end of each line
        para = [x.strip() for x in para]  
        doc_list.append( str(para) )
        
print( 'reading' )
read() 
documents = doc_list

for doc in documents:
    index_array = {}
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
            if( isdigit(word_without_unicode)==1 ):
                tok = word_without_unicode 
                if tok in index_array:
                    index_array[tok].append(pos)
                else:
                    index_array[tok] = [pos]
    tf_array[ names_of_doc[j] ] = index_array 
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
    for query_word in query:
        coun = 0
        for doc in tf_array:
            if( query_word in tf_array[doc] ):
                coun += 1
        coun = max(coun, 1)
        idff = log(float(len(tf_array)) / coun) / log(10)
        for doc in tf_array:
            if( query_word in tf_array[doc] ):
                term_freq = float( len(tf_array[doc][query_word]) )
                term_freq = log(1 + term_freq) 
            else:
                term_freq = 0
            if( doc in scoringg ):
                scoringg[doc] += idff*term_freq
            else:
                scoringg[doc] = idff*term_freq

func()
sort_dict = sorted( scoringg.items(), key=operator.itemgetter(1), reverse=True )

le = 0
for i in range( len(sort_dict) ):
   if( ( sort_dict[i][1]!=0 ) and ( le<min(11, len(sort_dict)) ) ):
       le += 1
       print sort_dict[i][0]

if( le==0 ):
    print( 'No documents' )
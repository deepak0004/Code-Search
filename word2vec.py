# import modules & set up logging
import logging
import gensim, os, snowballstemmer
from nltk.corpus import stopwords
from gensim.models import Word2Vec
from string import ascii_lowercase
from nltk.stem.wordnet import WordNetLemmatizer

import sys
reload(sys)
sys.setdefaultencoding("utf-8")

logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s', level=logging.INFO)

# initialize stemmer
stemmer = snowballstemmer.EnglishStemmer()

# grab stopword list, extend it a bit, and then turn it into a set for later
stop = stopwords.words('english')
mapp = {'advice':'advise'}
stop.extend(['may','also','zero','one','two','three','four','five','six','seven','eight','nine','ten','across','among','beside','however','yet','within']+list(ascii_lowercase))
stop.extend(['using', 'way', 'would', 'use', 'i', 'don\'t', 'type', 'it', 'i\'m', 'is', 'get', '<a', 'want', 'another', 'could', '+', 'something', 'used', 'it\'s', 'like', '=', '-', '+', 'see', 'look', 'id', 'make', 'size', 'getting', 'let', 'height', 'maybe', 'know', 'thanks', 'fine', 'always', 'stored', 'us', 'bit', 'called', 'create', 'hand', 'menu'])
stop.extend( ['warn', 'main', 'localhost', 'http', 'startstop', 'bio', 'info', 'cluster', 'finest', 'chatapp', 'disabled', 'new', 'clientoutboundchannel', 'appenders', 'run', 'okdebug', 'monkey_', 'successful', 'finer', 'apr', 'edt', 'audit', 'jul', 'heartbeat', 'reconnection', 'uma', 'disconnected', 'ping', 'serv', 'jgroups', 'javawsapplicationmain'])
stop.extend( ['discovered', 'severe', 'remote', 'dc', 'maig', 'trace', 'wrappermanager', 'cest', 'connection', 'elasticsearch', 'maynard', 'roottracer', 'tiboldt', 'djavax', 'livebeansview', 'control', 'temporarily', 'completed', 'asyncio', 'bootstrap', 'cancelling', 'wthlnap', 'shutting', 'infowrapper', 'mchange', 'feb', 'cfpvednfsg'])
stop.extend( ['logged', 'appeventdao', 'datasourceutils', 'forwarding', 'elasticsearchmaynard', 'imyf', 'appeventdao', 'datasourceutils', 'forwarding', 'elasticsearchmaynard', 'imyf', 'connection[', 'unwanted', 'localvalue', 'exited', 'newsession', 'srvmain', 'gradle\\', 'lient', 'defuncting', 'org', 'errorexit', 'upclsch', 'permessage', 'httpsessionsecuritycontextrepository'] )
stop.extend( ['ulimit', '_auth', 'stdout', 'dwrapper', 'org'] )
stoplist = stemmer.stemWords(stop)
stoplist = set(stoplist)
stop = set(sorted(stop + list(stoplist))) 
stop.remove('how')

lmtzr = WordNetLemmatizer()

class MySentences(object):
    def __init__(self, dirname):
        self.dirname = dirname
 
    def __iter__(self):
        for fname in os.listdir(self.dirname):
            for line in open(os.path.join(self.dirname, fname)):
                splitted = line.split();
                wordd = []
                for jj in splitted:
                    if ( len(jj)>3 ):
                        if( jj[0]=='[' ):
                                jj = jj.replace('[', "")
                        if( jj[ len( jj )-1 ]==']' ):
                                jj = jj.replace(']', "")                            
    
                        jj = jj.lower()
                        if( (jj not in stop) and len(jj)>2 ):
                            try:
                                oioi = lmtzr.lemmatize(jj)
                            except:
                               continue 
                            word_without_unicode = oioi.encode('ascii', 'ignore')
                            if( word_without_unicode in mapp ):
                                word_without_unicode = mapp[word_without_unicode]
                            wordd.append( word_without_unicode )   
                #print wordd.split() 
                if( len( wordd )!=0 ):
                    yield wordd
  
sentences = MySentences('/home/user/Desktop/textll/') # a memory-friendly iterator
model = gensim.models.Word2Vec(sentences)

model = Word2Vec(sentences, window=10)            # default value is 5
model = Word2Vec(sentences, min_count=10)            # default value is 5
model = Word2Vec(sentences, size=200)                # default value is 100
model = Word2Vec(sentences, workers=4)               # default = 1 worker = no parallelization

model.save('/home/user/Desktop/modd/mymodel')
print model.most_similar('suggest', topn=10)
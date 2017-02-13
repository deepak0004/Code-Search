# import modules & set up logging
import logging
import gensim, os, snowballstemmer
from nltk.corpus import stopwords
from gensim.models import Doc2Vec
from string import ascii_lowercase
from nltk.stem.wordnet import WordNetLemmatizer

import sys
reload(sys)
sys.setdefaultencoding("utf-8")

logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s', level=logging.INFO)

# initialize stemmer
stemmer = snowballstemmer.EnglishStemmer()

mapp = {'advice':'advise'}
# grab stopword list, extend it a bit, and then turn it into a set for later
stop = stopwords.words('english')
stop.extend(['may','also','zero','one','two','three','four','five','six','seven','eight','nine','ten','across','among','beside','however','yet','within']+list(ascii_lowercase))
stop.extend(['using', 'way', 'would', 'use', 'i', 'don\'t', 'type', 'it', 'i\'m', 'is', 'get', '<a', 'want', 'another', 'could', '+', 'something', 'used', 'it\'s', 'like', '=', '-', '+', 'see', 'look', 'id', 'make', 'size', 'getting', 'let', 'height', 'maybe', 'know', 'thanks', 'fine', 'always', 'stored', 'us', 'bit', 'called', 'create', 'hand', 'menu'])
stop.extend( ['warn', 'main', 'localhost', 'http', 'startstop', 'bio', 'info', 'cluster', 'finest', 'chatapp', 'disabled', 'new', 'clientoutboundchannel', 'appenders', 'run', 'okdebug', 'monkey_', 'successful', 'finer', 'apr', 'edt', 'audit', 'jul', 'heartbeat', 'reconnection', 'uma', 'disconnected', 'ping', 'serv', 'jgroups', 'javawsapplicationmain'])
stop.extend( ['discovered', 'severe', 'remote', 'dc', 'maig', 'trace', 'wrappermanager', 'cest', 'connection', 'elasticsearch', 'maynard', 'roottracer', 'tiboldt', 'djavax', 'livebeansview', 'control', 'temporarily', 'completed', 'asyncio', 'bootstrap', 'cancelling', 'wthlnap', 'shutting', 'infowrapper', 'mchange', 'feb', 'cfpvednfsg'])
stop.extend( ['logged', 'appeventdao', 'datasourceutils', 'forwarding', 'elasticsearchmaynard', 'imyf', 'appeventdao', 'datasourceutils', 'forwarding', 'elasticsearchmaynard', 'imyf', 'connection[', 'unwanted', 'localvalue', 'exited', 'newsession', 'srvmain', 'gradle\\', 'lient', 'defuncting', 'org', 'errorexit', 'upclsch', 'permessage', 'httpsessionsecuritycontextrepository'] )
stop.extend( ['ulimit', '_auth', 'stdout', 'dwrapper', 'org'] )
stoplist = stemmer.stemWords(stop)
stoplist
stop = set(sorted(stop + list(stoplist))) 
stop.remove('how')

lmtzr = WordNetLemmatizer()

class MySentences(object):
    def __init__(self, dirname):
        self.dirname = dirname
 
    def __iter__(self):
        for fname in os.listdir(self.dirname):
            for uid, line in enumerate(open(os.path.join(self.dirname, fname))):
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
                        yield gensim.models.doc2vec.TaggedDocument(words=wordd, tags=['SENT_%s' % uid])
  
sentences = MySentences('/home/user/Desktop/textll/') # a memory-friendly iterator

model = Doc2Vec(alpha=0.025, min_alpha=0.025)  # use fixed learning rate
model.build_vocab(sentences)
for epoch in range(10):
    model.train(sentences)
    model.alpha -= 0.002           # decrease the learning rate
    model.min_alpha = model.alpha  # fix the learning rate, no decay

model = Doc2Vec(sentences)
# store the model to mmap-able files
model.save('/home/user/Desktop/modd/mymodel2')
# load the model back
model_loaded = Doc2Vec.load('/home/user/Desktop/modd/mymodel2')

print model_loaded.most_similar('suggest', topn=10)
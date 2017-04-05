package lucene;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
   String indexDir = "./docs_index/";
   String dataDir = "./docs";
   Indexer indexer;
   Searcher searcher;

   public static void main(String[] args) {
      LuceneTester tester;
      Scanner reader = new Scanner(System.in); 
      try {
         tester = new LuceneTester();
         tester.createIndex();
         String query = reader.nextLine();
         tester.search(query);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }

   private void createIndex() throws IOException{
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }

   private void search(String searchQuery) throws IOException, ParseException{
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
            + doc.get(LuceneFilesDir.FILE_PATH) + scoreDoc);
      }
      searcher.close();
   }
   
   public class TextFileFilter implements FileFilter {

	   @Override
	   public boolean accept(File pathname) {
	      return pathname.getName().toLowerCase().endsWith(".java") || pathname.getName().toLowerCase().endsWith(".cpp") || pathname.getName().toLowerCase().endsWith(".c");
	   }
	   
	}
}

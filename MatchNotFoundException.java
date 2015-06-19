package folder1.folder2;
public class MatchNotFoundException extends Exception{
      static int count = 0;

      public MatchNotFoundException(){
            super();
            count++;
      }
      public MatchNotFoundException(String n){
            //n indicates retreive an object without increasing the count!
            //purpose to invoke the getCount();
            super();

      }
      public String getMessage(){
            return "A match was not found";
      }
      public int getCount(){
            return count;
      }
}

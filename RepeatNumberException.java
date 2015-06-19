package folder1.folder2;
public class RepeatNumberException extends Exception{
      static int count = 0;
      public RepeatNumberException(){
            super();
            count++;
      }
      public RepeatNumberException(String n){
            //n indicates retreive an object without increasing the count!
            //purpose to invoke the getCount();
            super();
      }
      public String getMessage(int n){
            return "THIS NUMBER " + n +" IS A DUPLICATE" + "\nThis number has been awarded previously";
      }
      public int getCount(){
            return count;
      }
}

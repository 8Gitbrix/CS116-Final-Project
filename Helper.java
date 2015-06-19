package folder1.folder2;
public class Helper{
      Helper(){
      }
      //binary search for existing lottery numbers
      public int binarySearch(int[] a, int key){
            int start =0, end = a.length-1;
            while(end>=start){
                  int middle = (start+end)/2;
                  if(a[middle]==key)
                        return middle;
                  else if(a[middle]>key)
                        end = middle-1;
                  else
                        start = middle+1;
            }
            return -1;
      }
}

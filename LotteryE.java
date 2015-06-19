package folder1.folder2;
import java.util.Random;
//Exponential
public class LotteryE extends Lottery{
      String name = "Exponential";
      public int draw (String name){
            int p =0;
            double avg =5.5;
            try{
                  p = (int)(-avg*Math.log(Math.random()));
                  Lottery.takenNums.add(p);
                  //check if lottery not found:
                  Helper h = new Helper();
                  if(h.binarySearch(lotteryNums,p)==-1)
                        throw new MatchNotFoundException();
                  //use a vector for marked numbers!
                  if(Lottery.takenNums.size()>0){
                        for(int i=0; i<Lottery.takenNums.size();i++){
                              if(p== (int)Lottery.takenNums.get(i))
                                    throw new RepeatNumberException();
                        }
                  }
                  Lottery.takenNums.add(p);
            }
            catch(MatchNotFoundException mn){
                  System.out.println(mn.getMessage());
                  System.out.println("The invalid number drawn is: " + p+ " Using probability Exponential");
                  p = -1;
            }
            catch(RepeatNumberException re){
                  System.out.println(re.getMessage(p));
                  System.out.println("The invalid number drawn is: " + p+ " Using probability Exponential");
                  p = -1;
            }
            return p;
      }
      public String getName(){
            return name;
      }
}

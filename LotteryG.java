package folder1.folder2;
import java.util.Random;
//Gaussian
public class LotteryG extends Lottery{
      String name = "Gaussian";
      public int draw(String name){
            int p = 0;
            double avg = 0;
            double standard = 0;
            if(name.equals("Saturn of North Chicago")){
                  avg = 40.5;
                  standard = 3.02765;
            }
            else{
                  avg = 3;
                  standard = 1.58114;
            }
            try{
                  Random r = new Random();
                  double val = r.nextGaussian() *standard + avg;
                  p = (int) val;
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
                  System.out.println("The invalid number drawn is: " + p+ " Using probability Gaussian");
                  p = -1;
            }
            catch(RepeatNumberException re){
                  System.out.println(re.getMessage(p));
                  System.out.println("The invalid number drawn is: " + p+ " Using probability Gaussian");
                  p = -1;
            }
            return p;
      }
      public String getName(){
            return name;
      }
}

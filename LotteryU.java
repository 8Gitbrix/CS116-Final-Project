package folder1.folder2;
import java.util.Random;
//uniform probability
public class LotteryU extends Lottery{
      String name = "Uniform";
      public int draw(String name){
            int p =0;
            int min = 0;
            int max = 0;
            if(name.equals("Chicago Buick")){
                  min = 1;
                  max = 40;
            }
            else if(name.equals("South Suburbs Pontiac")){
                  min = 1;
                  max = 20;
            }
            try{
                  p = (int)(min+Math.random()*(max));
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
                  System.out.println("The invalid number drawn is: " + p+ " Using probability Uniform");
                  p = -1;
            }
            catch(RepeatNumberException re){
                  System.out.println(re.getMessage(p));
                  System.out.println("The invalid number drawn is: " + p+ " Using probability Uniform");
                  p = -1;
            }
            return p;
      }
      public String getName(){
            return name;
      }
}

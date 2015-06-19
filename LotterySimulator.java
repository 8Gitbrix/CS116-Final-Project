package folder1;
import folder1.folder2.*;
import java.util.Random;
import java.util.Vector;
import java.util.ArrayList;

public class LotterySimulator{
      public static void main (String []args){
            Vector takenNums = new Vector();
            int max = 100;
            int min = 1;
            int timeCount = 0;
            int num = 0;
            int event = 1;
            int gm = 0;
            Lottery lot;

            LotteryE loe = new LotteryE();
            lot = loe;
            int priceTotal = 0;
            //create all the objects:
            lot.writeFile();
            //retrieve objects:
            ArrayList <Dealership> ds = lot.readFile("Dealership");
            ArrayList<Customer> cr = lot.readFile("Customer");
            ArrayList<Vehicle> ve = lot.readFile("Vehicle");

            while(ve.size()!=0){
                  System.out.println("THIS IS LOTTERY EVENT: " + event);
                  System.out.println("Starting time of lottery process = " + timeCount);
                  num = (int) (min+Math.random()*(max));
                  System.out.println("The lottery event #" + event + " has been determined that will occur at time= " + num);
                  System.out.println("Lottery Iteration #: " + event);

                  do{
                        timeCount++;
                  }while (timeCount!=num);

                  min = num;
                  max = num+100;
                  //GM choose dealership
                  gm = (int) (1+Math.random()*5);
                  int lNum = 0;
                  System.out.println("The dealership number is " + gm);
                  //choose vehicle
                  int index = (int) (0+Math.random()*(ve.size()-1));
                  if(gm==1){
                        System.out.println("The dealership name is Glen Ellyn Chevrolet");
                        lNum = lot.draw("Glen Ellyn Chevrolet");
                        ve.get(index).setDealership(ds.get(0));
                        ve.get(index).calculatePrice();
                  }
                  else if(gm==2){
                        System.out.println("The dealership name is South Suburbs Pontiac");
                        LotteryU lou = new LotteryU();
                        lot = lou;
                        lNum = lot.draw("South Suburbs Pontiac");
                        ve.get(index).setDealership(ds.get(1));
                        ve.get(index).calculatePrice();
                  }
                  else if(gm==3){
                        System.out.println("The dealership name is Chicago Buick");
                        LotteryU lou = new LotteryU();
                        lot = lou;
                        lNum = lot.draw("Chicago Buick");
                        ve.get(index).setDealership(ds.get(2));
                        ve.get(index).calculatePrice();
                  }
                  else if(gm==4){
                        System.out.println("The dealership name is Schaumburg Cadillac");
                        LotteryG log = new LotteryG();
                        lot = log;
                        lNum = lot.draw("Schaumburg Cadillac");
                        ve.get(index).setDealership(ds.get(3));
                        ve.get(index).calculatePrice();
                  }
                  else if(gm==5){
                        System.out.println("The dealership name is Saturn of North Chicago");
                        LotteryG log = new LotteryG();
                        lot = log;
                        lNum = lot.draw("Saturn of North Chicago");
                        ve.get(index).setDealership(ds.get(4));
                        ve.get(index).calculatePrice();
                  }
                  if(lNum==-1)
                        System.out.println("The Lottery EVENT " + event + " has to be repeated");
                  //continue lottery inside the else
                  else{
                        System.out.println("The lottery number drawn is " + lNum);
                        System.out.println("The probability used was " + lot.getName());
                        for(Customer r: cr){
                              if(lNum== r.getLotteryNum()){
                                    System.out.println("Dear customer " + r.getLastName() + " You have won a vehicle");
                                    System.out.println("the number of vehicle chosen for the dealership out of the list of vehicles is=" + index);
                                    int id = ve.get(index).getId();
                                    //write to output.txt
                                    lot.writeText("id of vehicle: " + id);
                                    lot.writeText("Time: " + timeCount);
                                    lot.writeText("EVENT# : " + event);
                                    lot.writeText("Customer id: " + r.getId());
                                    lot.writeText("dealership: " + ds.get(gm-1).getName());
                                    lot.writeText("\n");
                                    //set vehicle of customer:
                                    r.setVehicle(ve.get(index));
                                    ve.get(index).setCustomer(r);
                                    ve.get(index).setAwardTime(timeCount);
                                    System.out.println("The vehicle was awarded at time " + timeCount);
                                    System.out.println("WON VEHICLE INFORMATION");
                                    System.out.println(ve.get(index).toString());
                                    System.out.println("WINNING CUSTOMER INFORMATION");
                                    System.out.println(r.toString());
                                    priceTotal+=ve.get(index).getPrice();
                                    if(ve.size()==1){
                                          System.out.println("The cost of all vehicles awarded is:" + priceTotal);
                                          //add exceptions to output.txt
                                          RepeatNumberException rn = new RepeatNumberException("");
                                          MatchNotFoundException mn = new MatchNotFoundException("");
                                          lot.writeText("The exception: MatchNotFoundException was thrown " + mn.getCount() + " times");
                                          lot.writeText("\n");
                                          lot.writeText("The exception: RepeatNumberException was thrown " + rn.getCount()+ " times");
                                    }
                                    ve.remove(index);
                              }
                        }
                  }
                  event++;
            }
      }
}

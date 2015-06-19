package folder1.folder2;
import java.io.Serializable;
public class Customer implements Serializable{
      CustomerType ct = null;
      String firstName;
      String lastName;
      int lotteryNum;
      int id=0;
      Vehicle vl=null;
      boolean status = false;
      static int statId =0;
      public Customer(String f, String l, int lo){
            firstName = f;
            lastName = l;
            lotteryNum = lo;
            statId++;
            id = statId;
      }
      public void setCustomerType(CustomerType ce){
            ct = ce;
      }
      public CustomerType getCustomerType(){
            return ct;
      }
      public Vehicle getVehicle(){
            return vl;
      }
      public void setVehicle(Vehicle vi){
            vl = vi;
      }
      public int getLotteryNum(){
            return lotteryNum;
      }
      public String getFirstName(){
            return firstName;
      }
      public String getLastName(){
            return lastName;
      }
      public void setStatus(boolean b){
            status = b;
      }
      public int getId(){
            return id;
      }
      public String toString(){
            return "First Name= " + firstName + " Last Name= " + lastName + " PersonID=" + id + " The car id assigned to this person is:" +vl.getId() + " By dealership: " +vl.getDealership().getName();
      }
}

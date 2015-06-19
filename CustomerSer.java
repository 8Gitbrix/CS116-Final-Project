package folder1.folder2;
import java.util.ArrayList;
//create + read ser file for Customer
import java.io.*;
public class CustomerSer{
      public void writeObjects(){
            ArrayList<Customer> cr = new ArrayList<Customer>();
            for(int i=1; i<10; i++){
                  String a = "John" + i;
                  String b = "Dow" + i;
                  Customer cu = new Customer("John"+i,"Dow"+i,i);
                  if(i>=1 && i<=5)
                        cu.setCustomerType(CustomerType.A);
                  else if(i>=6 && i<=10){
                        cu.setCustomerType(CustomerType.B);
                  }
                  cr.add(cu);
            }
            for(int i=11;i<15;i++){
                  Customer cu = new Customer("John"+i,"Dow"+i,i+9);
                  cu.setCustomerType(CustomerType.C);
                  cr.add(cu);
            }
            for(int i=16; i<25; i++){
                  Customer cu = new Customer("John"+i,"Dow"+i,i+20);
                  if(i>=16 && i<=20)
                        cu.setCustomerType(CustomerType.D);
                  else if(i>=21 && i<=25)
                        cu.setCustomerType(CustomerType.E);
                  cr.add(cu);
            }
            try{
                  FileOutputStream fs = new FileOutputStream("Customer.ser");
                  ObjectOutputStream os = new ObjectOutputStream(fs);
                  for(Customer r: cr){
                        os.writeObject(r);
                  }
                  os.close();
                  fs.close();
            }
            catch(IOException ioe){
                  System.out.println("Error");
            }
      }
      public ArrayList<Customer> readObjects(){
            ArrayList<Customer> cr = new ArrayList<Customer>();
            try{
                  FileInputStream fi = new FileInputStream("Customer.ser");
                  ObjectInputStream oi = new ObjectInputStream(fi);
                  try{
                        while(true){
                              Customer ces =(Customer) oi.readObject();
                              cr.add(ces);
                        }
                  }
                  catch(EOFException en){
                        System.out.println();
                  }
                  catch(ClassNotFoundException cn){
				System.out.println("Class not Found");
			}
            }
            catch(IOException in){
                  System.out.println("error");
            }
            return cr;
      }
}

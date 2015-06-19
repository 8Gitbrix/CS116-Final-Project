package folder1.folder2;
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;
public abstract class Lottery extends DealershipSer implements INT1, INT2{
      public int lotteryNums[] = {1,2,3,4,5,6,7,8,9,10,11,20,21,22,23,24,36,37,38,39,40,41,42,43,44,45};
      public static Vector takenNums = new Vector();
      public abstract String getName();
      public abstract int draw(String dealershipName);

      public void writeFile(){
            CustomerImpl cl = new CustomerImpl();
            cl.writeFile();
            VehicleImpl vl = new VehicleImpl();
            vl.writeFile();
            writeObjects();
      }
      public ArrayList readFile(String g){
            ArrayList t = new ArrayList();
            if(g.equals("Vehicle")){
                  VehicleImpl vl = new VehicleImpl();
                  t = vl.readFile("Vehicle");
            }
            else if(g.equals("Customer")){
                  CustomerImpl cl = new CustomerImpl();
                  t = cl.readFile("Customer");
            }
            else if(g.equals("Dealership")){
                  t = readObjects();
            }
            return t;
      }
      public void writeText(String n){
            try{
                  FileOutputStream f = new FileOutputStream("Output.txt",true);
                  OutputStreamWriter ow = new OutputStreamWriter(new BufferedOutputStream(f));
                  if(!n.equals("\n"))
                        ow.write("\t"+n);
                  else
                        ow.write("\n");
                  ow.flush();
                  f.close();
            }
            catch(IOException ioe){
                  System.out.println("Error");
            }
      }
}

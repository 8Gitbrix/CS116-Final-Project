package folder1.folder2;
import java.util.ArrayList;
//create + read ser file for dealership
import java.io.*;
public class DealershipSer{
      public void writeObjects(){
            ArrayList<Dealership> de = new ArrayList<Dealership>();
            Dealership di = new Dealership("Glen Ellyn Chevrolet",DealershipType.CHEVROLET);
            de.add(di);
            di = new Dealership("South Suburbs Pontiac",DealershipType.PONTIAC);
            de.add(di);
            di = new Dealership("Chicago Buick",DealershipType.BUICK);
            de.add(di);
            di = new Dealership("Schaumburg Cadillac",DealershipType.CADILLAC);
            de.add(di);
            di = new Dealership("Saturn of North Chicago",DealershipType.SATURN);
            de.add(di);
            try{
                  FileOutputStream fs = new FileOutputStream("Dealership.ser");
                  ObjectOutputStream os = new ObjectOutputStream(fs);
                  for(Dealership q: de){
                        os.writeObject(q);
                  }
                  os.close();
                  fs.close();
            }
            catch(IOException ioe){
                  System.out.println("Error");
            }
      }
      public ArrayList<Dealership> readObjects(){
            ArrayList<Dealership> de = new ArrayList<Dealership>();
            try{
                  FileInputStream fi = new FileInputStream("Dealership.ser");
                  ObjectInputStream oi = new ObjectInputStream(fi);
                  try{
                        while(true){
                              Dealership des =(Dealership) oi.readObject();
                              de.add(des);
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
            return de;
      }
}

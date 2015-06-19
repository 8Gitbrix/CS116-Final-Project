package folder1.folder2;
import java.util.ArrayList;
//create + read ser file for vehicle
import java.io.*;
public class VehicleSer{

      public void writeObjects(){
            ArrayList<Vehicle> v = new ArrayList<Vehicle>();
            Vehicle ve = new Vehicle(VehicleType.FOUR_DOOR_SEDAN,1,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.FOUR_DOOR_SEDAN,2,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.TWO_DOOR_COUPE,3,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.TWO_DOOR_COUPE,4,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.TRUCK,5,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.TRUCK,6,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.SUV,7,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.SPORT,8,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.SPORT,9,1,0,0);
            v.add(ve);
            ve = new Vehicle(VehicleType.MINI_VAN,10,1,0,0);
            v.add(ve);
            try{
                  FileOutputStream fs = new FileOutputStream("Vehicles.ser");
                  ObjectOutputStream os = new ObjectOutputStream(fs);
                  for(Vehicle e: v){
                        os.writeObject(e);
                  }
                  os.close();
                  fs.close();
            }
            catch(IOException ioe){
                  System.out.println("Error");
            }
      }
      public ArrayList<Vehicle> readObjects(){
            ArrayList<Vehicle> v = new ArrayList<Vehicle>();
            try{
                  FileInputStream fi = new FileInputStream("Vehicles.ser");
                  ObjectInputStream oi = new ObjectInputStream(fi);
                  try{
                        while(true){
                              Vehicle ves =(Vehicle) oi.readObject();
                              v.add(ves);
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
            return v;
      }
}

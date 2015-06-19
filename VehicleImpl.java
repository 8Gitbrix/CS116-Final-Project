package folder1.folder2;
import java.util.ArrayList;
public class VehicleImpl extends VehicleSer implements INT1, INT2{
      public void writeFile(){
            writeObjects();
      }
      public ArrayList<Vehicle> readFile(String g){
            return readObjects();
      }
}

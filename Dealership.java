package folder1.folder2;
import java.io.Serializable;
public class Dealership implements Serializable{
	String name = " ";
	DealershipType dt = null;
	int id=0;
      static int statId =0;

	public Dealership(String ty, DealershipType dy){
		name = ty;
		dt = dy;
		statId++;
		id = statId;
	}
	public String getName(){
		return name;
	}
	public void setName(String na){
		name = na;
	}
	public DealershipType getDealershipType(){
		return dt;
	}
	public void setDealershipType(DealershipType dp){
		dt = dp;
	}
	public int getId(){
		return id;
	}
	public void setId(int ii){
		id = ii;
	}
}

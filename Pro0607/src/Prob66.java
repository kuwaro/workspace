
public class Prob66 {
public static void main(String[] args) {
	double latitude[]=new double[2];
	double longitude[]=new double[2];

	latitude[0]=Double.parseDouble(args[0]);
	longitude[0]=Double.parseDouble(args[1]);
	latitude[1]=Double.parseDouble(args[2]);
	longitude[1]=Double.parseDouble(args[3]);

	double tube=Math.sin(Math.toRadians((latitude[1]-latitude[0])/2))
			*Math.sin(Math.toRadians((latitude[1]-latitude[0])/2))
			+Math.cos(Math.toRadians(latitude[0]))*Math.cos(Math.toRadians(latitude[1]))
			*Math.sin(Math.toRadians((longitude[1]-longitude[0])/2))
			*Math.sin(Math.toRadians((longitude[1]-longitude[0])/2));

	//double d=2*6371*Math.toDegrees(Math.asin(Math.sqrt(tube)));
	double d=2*6371*(Math.asin(Math.sqrt(tube)));
	System.out.println(d);
}
}

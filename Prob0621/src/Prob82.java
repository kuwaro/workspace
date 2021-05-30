import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class Prob82{
public static void main(String[] args) throws IOException{
	Prob82 app=new Prob82();
	int count=0;
	String[] buf=new String[100];
    String filename = "message.txt";
    try (BufferedReader in = new BufferedReader(new FileReader(new File(filename)))){
        for(int i=0;(buf[i] = in.readLine()) != null;i++) {
			count++;
        	}
    } catch (FileNotFoundException e){
        e.printStackTrace();
        System.exit(-1);
    } catch (IOException e){
        e.printStackTrace();
        System.exit(-1);
    }
   @SuppressWarnings("resource")
BufferedWriter out =new BufferedWriter(new FileWriter(new File("output82.txt")));
PrintWriter pw=new PrintWriter(out);
  for(int i=0;i<count;i++) {
    		pw.println(app.processInput(buf[i]));
    	};
    	pw.close();
}
private String processInput(String inString) {
	String[] tango = inString.split("\\s+");
	String[] moji =inString.split("");
	if(moji[0].equals("")) {
		inString=("0 0:"+inString);
		return inString;
	}else {
		inString=(tango.length+" "+moji.length+":"+inString);
		return inString;
	}
}
}
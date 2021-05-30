import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class Prob83{
public static void main(String[] args) throws IOException{
	Prob83 app=new Prob83();
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
BufferedWriter out =new BufferedWriter(new FileWriter(new File("output83.txt")));
PrintWriter pw=new PrintWriter(out);
  for(int i=0;i<count;i++) {
    		pw.println(app.processInput(buf[i]));
    	};
    	pw.close();
}
private String processInput(String inString) {
	String[] moji =inString.split("");
String[] moji2 =new String[moji.length];
    for(int i=moji.length-1;i>=0;i--) {
    	moji2[moji.length-1-i]=moji[i];
    }
	String ans=String.join("", moji2);
	return ans;
	}
}

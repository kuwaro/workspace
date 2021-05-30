import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Prob95 {
@SuppressWarnings("null")
public static void main(String[] args) {
	try {
		int[] num=new int[1024];
List<String> list = Files.readAllLines(Paths.get("message.txt"));
BufferedWriter output = Files.newBufferedWriter(Paths.get("output95.txt"));
String[] tango = new String[1024];
String[] tango2 = new String[1024];
int count=1;
String alline="";
for (String line : list) {
	alline+=line;
	alline+=" ";
}
tango=alline.split("\\s+");
tango2[0]=tango[0];

for(int i=1;i<tango.length;i++) {
	for(int j=0;j<count;j++) {
	if(tango[i].equalsIgnoreCase(tango2[j])
			||tango[i].equalsIgnoreCase(tango2[j]+".")
			||tango[i].equalsIgnoreCase(tango2[j]+",")) {
		num[j]++;
		break;
	}
	if(j==count-1) {
		tango2[j+1]=tango[i];
		count++;
		break;
	}
	}
}
for(int i=0;i<count-1;i++) {
	for(int j=0;j<count-1;j++) {
		if(num[j+1]>num[j]) {
			int tmp=num[j+1];
			num[j+1]=num[j];
			num[j]=tmp;
			String tmp2=tango2[j+1];
			tango2[j+1]=tango2[j];
			tango2[j]=tmp2;
		}
	}
}


for(int i=0;i<count;i++) {
	if(num[i]>=1) {
		System.out.println(tango2[i]+" "+(num[i]+1));
	output.write(tango2[i]+" "+(num[i]+1));
	}

output.newLine();

}
output.close();
} catch(IOException e) {
System.err.println("IOException " + e.toString()); }
}}
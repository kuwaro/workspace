import java.util.Scanner;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        int b[] = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = N - 1; i >= 0; i--){
            int c = 0;
            for(int j = 2; (i + 1) * j <= N; j++){
                c += b[((i + 1) * j) - 1];
            }
            if(c % 2 == a[i]){
                b[i] = 0;
            }else{
                b[i] = 1;
                count++;
            }
        }
        System.out.println(count);
        for(int i = 0; i < N; i++){
            if(b[i] == 1){
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}

import java.util.*;
public class Primehappy {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int sum=0;
		int n=sc.nextInt();
		boolean arr[]=new boolean[n];
		for(int i=2;i*i<n;i+=1) {
		  if(arr[i]==false) {
			for(int j=i*i;j<n;j+=i) {
				arr[j]=true;
				}
			}
		}
		for(int i=2;i<n;i++) {
			if(arr[i]==false) {
				sum+=i;
			}
		}
		if(sum%n==0)
				System.out.println(1 + " Happy primes");
		else
			System.out.println(0 + " Not happy prime");
		sc.close();
	}

}
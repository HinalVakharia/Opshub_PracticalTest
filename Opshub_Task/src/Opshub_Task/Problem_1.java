package Opshub_Task;
import java.io.*;

public class Problem_1 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		String matrixInpt[] = br.readLine().trim().split(" ");
		int arr[][] = new int[n][n];
		int k = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(matrixInpt[k]);
				k++;
			}
		}
		
		System.out.println(desiredOutput(arr,n));
	}
	
	public static String desiredOutput(int arr[][], int n) {
		
		int temp = 0;
		for(int i = 0; i < n-1; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				if(arr[i][j] == arr[j][i])
					continue;
				else
				{
					temp++;
					break;
				}
			}
		}
		
		if(temp > 0)
			return "Impossible";
		else
			return "Possible";
	}
	
}

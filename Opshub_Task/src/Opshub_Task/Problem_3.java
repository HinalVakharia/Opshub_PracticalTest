package Opshub_Task;
import java.io.*;
import java.util.*;

public class Problem_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter choice from Enqueue, Dequeue, Get front element or Exit: ");
		String input = br.readLine();
		StackToQueue sq = new StackToQueue();
		do
		{
			switch (input)
			{
			case "Enqueue":
				System.out.print("Insert an element to queue: ");
				int x = Integer.parseInt(br.readLine());
				sq.Enqueue(x);
				break;
			case "Dequeue":
				System.out.println("Deleted element " + sq.Dequeue());
				break;
			case "Get front element":
				System.out.println("Front Element " + sq.GetFrontElement());
				break;
			default:
				System.out.println("No such operation found");
				break;
			}
			System.out.print("Enter choice from Enqueue, Dequeue, Get front element or Exit: ");
			input = br.readLine();
			
		}while(!input.equals("Exit"));
		
	}
}
class StackToQueue {
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public void Enqueue(int x) {
		s1.push(x);
	}
	
	public int Dequeue() {
		while(!s1.isEmpty())
			s2.push(s1.pop());
	    if(s2.isEmpty())
	    	return -1;
	    int k= s2.pop();
	    while(!s2.isEmpty())
	    	s1.push(s2.pop());
		return k;
	}
	
	public int GetFrontElement() {
		while(!s1.isEmpty())
			s2.push(s1.pop());
	    if(s2.isEmpty())
	    	return -1;
	    int k= s2.pop();
	    s1.push(k);
	    while(!s2.isEmpty())
	    	s1.push(s2.pop());
		return k;
	}
}


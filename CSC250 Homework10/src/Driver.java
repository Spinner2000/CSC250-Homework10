import java.util.Random;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		Random r=new Random();
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Please Enter An Age:");
		int ageInput=input.nextInt();
		input.close();
		
		String[] pName={"Jackie Robinson", "Babe Ruth","Pete Rose","Johnny Bench","Lou Gehrig"};
		
		int[] age=new int[5];
		for(int i = 0; i < age.length; i++)
		{
			age[i] = r.nextInt(70);
		}
		
		mergeSort(age,0,age.length-1);
		
		int results=binarySort(age,0,age.length,ageInput);
		
		if(results==-1) {
			System.out.println("Please Enter Another Age");
		}
		else {
			System.out.println(pName[results]);
			System.out.println(age[results]);
		}
		
	}
	
	static void mergeSort(int[] age, int begin, int end){
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + ((end - begin)/2);
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSort(age, begin1, end1);
			mergeSort(age, begin2, end2);
			merge(age, begin1, end1, begin2, end2);
		}
	}
	
	static void merge(int[] age, int begin1, int end1, int begin2, int end2){
		int[] temp = new int[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(age[pos1] < age[pos2])
				{
					temp[i] = age[pos1];
					pos1++;
				}
				else
				{
					temp[i] = age[pos2];
					pos2++;
				}
			}
			else
			{
				if(pos1 > end1)
				{
					temp[i] = age[pos2];
					pos2++;
				}
				else
				{
					temp[i] = age[pos1];
					pos1++;
				}
			}
		} 
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++)
		{
			age[i] = temp[posInTemp];
			posInTemp++;
		}
	}
	
	static int binarySort(int[] age,int start,int length,int input) {
		
		if(length>=1) {
			int middle=start+(length-1)/2;
			if (age[middle] == input) {
                return middle; 
			}
			
			if (age[middle] > input) { 
				return binarySort(age, start, middle - 1, input);
		    }
			else {
				return binarySort(age, middle + 1, length, input);
			}
		}
		
		return -1;
	}
}

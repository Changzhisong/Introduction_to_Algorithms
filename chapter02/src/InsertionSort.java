package song.sort;


public class InsertionSort {
	public static void main(String [] args){
		
		int[] nums ={5,2,4,6,1,3};
		for(int i =1;i<nums.length;i++){
			int key = nums[i];
			int j =i-1;
			while(j>=0&&nums[j]>key){
				nums[j+1]=nums[j];
				j--;
			}
			nums[j+1]=key;
		}
		
		for (int num:nums){
			System.out.print(num +" ");
		}
		
	}
	

	
}

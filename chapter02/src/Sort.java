package song.sort;

public class Sort {
	
	public int[] nums = {15,20,4,6,19,3,33,45,23,1,45,16,89};
	
	public static void main(String[] args) {
		Sort s = new Sort();
		long start = System.currentTimeMillis();
		
//		s.insertionSort();
//		s.selectionSort();
//		s.mergeSort(0, s.nums.length-1);
		s.bubbleSort();
		long end = System.currentTimeMillis();
		
		s.show();
		System.out.println();
		System.out.println("运行时间："+(end-start)+" ms");
		
				
	}
	
	//插入排序
	public void insertionSort(){
		for(int j = 1;j<nums.length;j++){
			int key =nums[j];
			int i= j-1;
			while(i>=0 &&nums[i]>key){
				nums[i+1] = nums[i];
				i--;
			}
			nums[i+1]=key;
		}
	}
	
	//选择排序
	public void selectionSort(){
		for (int j = 0;j<nums.length-1;j++){
			int min = j;
			//选择最小的元素对应的索引
			for(int i =j+1;i<nums.length;i++){
				if(nums[i]<nums[min]){
					min=i;
				}
			}
			//交换第j小的放到第j个位置
			int temp =nums[j];
			nums[j]=nums[min];
			nums[min]=temp;
		}
	}
	
	//归并排序
	public void mergeSort(int p,int r){ //nums[p..r]
//		int p =0;
//		int r = nums.length;	
		if (p<r){
			int q = (p+r)/2;
			mergeSort(p,q);
			mergeSort(q+1,r);
			merge(p,q,r);
		}else{
			return;
		}
	}
	public void merge(int p , int q, int r){ //nums[p..q]  nums[p+1..r]
		int [] L =new int[q-p+2];
		int [] R = new int[r-q+1];
		for (int i=0 ;i<L.length-1;i++){
			L[i] = nums[p+i];
		}
		for(int i =0 ;i<R.length-1;i++){
			R[i] = nums[q+1+i];
		}
		L[q-p+1]=Integer.MAX_VALUE;//“哨兵”的作用
		R[r-q]=Integer.MAX_VALUE;
		int i =0,j =0;
		for (int k=p;k<=r;k++){
			if(L[i]<=R[j]){
				nums[k]=L[i];
				i++;
			}else{
				nums[k]=R[j];
				j++;						
			}
		}			
	}
	
	//冒泡排序
	public void bubbleSort(){
		for (int i = 0;i<nums.length-1;i++){
			for(int j =nums.length-1;j>i;j--){
				if(nums[j]<nums[j-1]){
					int temp =nums[j];
					nums[j]=nums[j-1];
					nums[j-1]=temp;
				}
			}
		}
	}
	
	//显示
	public void show(){
		for (int num :nums){
			System.out.print(num+" ");
		}
	}
}

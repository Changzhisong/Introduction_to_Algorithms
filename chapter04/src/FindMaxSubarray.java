package song.sort;

import java.util.Random;

import javax.swing.plaf.ComponentInputMapUIResource;

public class FindMaxSubarray {
	public static final int MIX_POINT = 133;

	public static void main(String[] args) {

//		 int[] A = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22,		 15, -4, 7 };
//
//		int[] A = new int[10000];
//		Random rd = new Random();
//		for (int i = 0; i < 10000; i++) {
//			A[i] = rd.nextInt(100) - 50;
////			System.out.print(A[i]+" ");
//		}
//		System.out.println();
		int [] A={-5,-1,-1,-4,-5,-6,-4,-3,-6};
//		int [] A={16};
		FindMaxSubarray fms = new FindMaxSubarray();
//		long start = System.nanoTime();
//		// 暴力
//		int[] result = new int[3];
//		for (int i = 0; i < 10000; i++) {
//			result = fms.bruteForceFind(A, 0, A.length - 1);
//		}
		long end = System.nanoTime();
		// 递归
		int[] result1 = new int[3];
		for (int i = 0; i < 10000; i++) {
			result1 = fms.findMaxSubarray(A, 0, A.length - 1);
		}
		long end1 = System.nanoTime();
		// 混合

		int[] result2 = new int[3];
		for (int i = 0; i < 10000; i++) {
			result2 = fms.findMaxSubarrayMix(A, 0, A.length - 1);
		}
		long end2 = System.nanoTime();

		
		int[] result3 = new int[3];
		for (int i = 0; i < 10000; i++) {
			result3 = fms.linerFind(A, 0, A.length - 1);
		}
		long end3 = System.nanoTime();

		
//		System.out.println("暴力法的解：" + result[0] + "  **  " + result[1] + "  **  " + result[2]);
		System.out.println("递归法的解：" + result1[0] + "  **  " + result1[1] + "  **  " + result1[2]);
		System.out.println("混合法的解：" + result2[0] + "  **  " + result2[1] + "  **  " + result2[2]);
		System.out.println("线性法的解：" + result3[0] + "  **  " + result3[1] + "  **  " + result3[2]);
//		System.out.println("暴力法时间：" + (end - start) / 1000000.0 + " ms");
		System.out.println("递归法时间：" + (end1 - end) / 1000000.0 + " ms");
		System.out.println("混合法时间：" + (end2 - end1) / 1000000.0 + " ms");
		System.out.println("线性法时间：" + (end3 - end2) / 1000000.0 + " ms");
	}

	// 暴力法求解最大子数组问题 O(n^2)
	public int[] bruteForceFind(int[] A, int low, int high) {
		int left = 0;
		int right = 0;
		int sum = Integer.MIN_VALUE;
		for (int i = low; i <= high; i++) {
			int currentSum = 0;
			for (int j = i; j <= high; j++) {
				currentSum += A[j];
				if(currentSum==0&&currentSum <sum){
					break;
				}
				if (currentSum >sum) {
					sum = currentSum;
					left = i;
					right = j;
				}
			}
		}
		// 输出结果，0-数组开始索引，1-数组结束索引，2-数组元素和
		int[] result = new int[3];
		result[0] = left;
		result[1] = right;
		result[2] = sum;
		return result;
	}

	// 递归法求解最大子数组问题 O(nlgn)
	public int[] findMaxSubarray(int[] A, int low, int high) {
		int[] result = new int[3];

		if (low == high) {
			result[0] = low;
			result[1] = high;
			result[2] = A[low];
			return result;
		} else {
			int mid = (low + high) / 2;
			int[] leftResult = findMaxSubarray(A, low, mid); // 递归调用
			int[] rightResult = findMaxSubarray(A, mid + 1, high);
			int[] crossResult = findMaxCrossingSubarray(A, low, mid, high);
			
			
			
			// 判断返回三种情况中的元素和较大者
			if (leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2]) {
				return leftResult;
			} else if (crossResult[2] >= rightResult[2] && crossResult[2] >= leftResult[2]) {
				return crossResult;
			} else {
				return rightResult;
			}
		}
	}

	public int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
		// 左半部分
		int leftsum = Integer.MIN_VALUE;
		int sum = 0;
		int left = mid;
		for (int i = mid; i >= low; i--) {
			sum += A[i];
			if (sum > leftsum) {
				leftsum = sum;
				left = i;
			}
		}
		// 右半部分
		int rightsum = Integer.MIN_VALUE;
		sum = 0;
		int right = mid;
		for (int i = mid + 1; i <= high; i++) {
			sum += A[i];
			if (sum > rightsum) {
				rightsum = sum;
				right = i;
			}
		}
		// 输出结果，0-数组开始索引，1-数组结束索引，2-数组元素和
		int[] result = new int[3];
		result[0] = left;
		result[1] = right;
		result[2] = leftsum + rightsum;

		return result;
	}

	// 递归法与暴力法混合
	public int[] findMaxSubarrayMix(int[] A, int low, int high) {
		// int[] result = new int[3];

		if (high - low + 1 < MIX_POINT) {

			return bruteForceFind(A, low, high);
		} else {
			int mid = (low + high) / 2;
			int[] leftResult = findMaxSubarray(A, low, mid); // 递归调用
			int[] rightResult = findMaxSubarray(A, mid + 1, high);
			int[] crossResult = findMaxCrossingSubarray(A, low, mid, high);

			// 判断返回三种情况中的元素和较大者
			if (leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2]) {
				return leftResult;
			} else if (crossResult[2] >= rightResult[2] && crossResult[2] >= leftResult[2]) {
				return crossResult;
			} else {
				return rightResult;
			}
		}
	}
	
	
	//线性解法
	public int[] linerFind(int[] A ,int low ,int high){
		int sum=0;
		int left=0;
		int right = 0;
		int maxSum=A[low];
		int temp=0;
		for (int i=low;i<=high;i++){
			sum +=A[i];
			if(sum>maxSum){
				maxSum = sum;
				right = i;
				temp=left;	
			}
			
			if(sum<=0){
				sum = 0;
				left = i+1;
			}
			
		}
		if(sum<=maxSum){
			left=temp;
		}
//		System.out.println(sum);
		if(maxSum<0){
			left =right;
		}
//		if(maxSum==0){
//			 maxSum=Integer.MIN_VALUE;
//			for (int i=low;i<=high;i++){
//				if(A[i]>maxSum){
//					maxSum = A[i];
//					left=i;
//					right =i;
//				}
//			}
//		}
//		System.out.println(right);
		// 输出结果，0-数组开始索引，1-数组结束索引，2-数组元素和
		int[] result = new int[3];
		result[0] = left;
		result[1] = right;
		result[2] = maxSum;

		return result;
		
	
	}
	
	
	
	
	
	
}

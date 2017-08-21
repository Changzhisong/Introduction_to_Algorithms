算法导论代码实现
========

算法导论日常更新中。。。
****
### Author:Song
### E-mail:Z.S.Chang@qq.com
****
## 目录
* [chapter02](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter02 "跳转到chapter02")
	* 插入排序
	* 选择排序
	* 归并排序
	* 冒泡排序
* [chapter03](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter03 "跳转到chapter03")
	* 渐进记号的定义
	* 渐近记号Θ、Ο、Ω、o、ω之间的关系
* [chapter04](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter04 "跳转到chapter04")
	* ***更新中...***
	
	
***
---
___

更新日志
-------
#### \######2017-8-12######
* ### 插入排序【O($n^2$)】  
	通过构建有序序列，在已经排序的序列中从后面向前扫描，找到相应的位置并插入。
		换句话说，每次从剩余数组中拎出一个元素，与有序数组从后往前对比，直到插入合
		适的位置，然后剩余数组缩小规模在循环插入。（类似于抓牌后整理牌）  
![动画演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter02/Doc/Insertion-sort1.gif)  
* ### 选择排序【O($n^2$)】  
	找出数组A中最小的元素并将其与A[0]进行交换，接着，找出A中第二小的元素与A[1]
		交换。对A中前n-1个元素按该方式交换。  
![动画演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter02/Doc/Selection-Sort.gif)  

-----
#### \######2017-8-15######
* ### 归并排序【O(nlgn)】  
	***分治思想：***  
	将原问题分解为n个规模较小但类似于原问题的子问题，递归地求解这些子问题，然后
	再合并这些子问题的解来建立原问题的解。  
		***合并思想：***  
		有两组各自有序的数组及两个指针且两个指针分别指向两个数组的首位置。首先两个0
		位置的数进行比较，较小的放到新数组中，且该数组指针+1，然后再比较两个指针指向
		的数组的元素，将小的放到新数组中，指针+1，最后直到某一组的哨兵（+∞）出现（也
		可以不使用哨兵，但需判断两个数组的长度），则另外一组的剩余的元素全部加入到新
		的数组中。    
		***优化***  
		在归并排序中对小的子数组采用插入排序：  
		在排序长度为k的n/k个子数组采用插入排序，使得最后整个排序运行时间为 ***O(nk+nlg(n/k))***  
![动画演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter02/Doc/Merge-sort.gif)
		
* ### 冒泡排序【O($n^2$)】  
	重复的走访要排列的序列，依次比较相邻的两个元素，如果顺序相反就交换过来，直到
		没有需要再交换。  
![动画演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter02/Doc/Bubble-Sort.gif)  

-----
### \######2017-8-17######
* ### 渐进记号的定义  
	* #### ***Θ(big-theta)***  
		`定义1：`设f(n)和g(n)是定义域为自然数集合的函数。如果$\mathop{\lim}\limits_{x\to ∞}\frac{f(n)}{g(n)}$存在，并且等于某个常数c(c>0)，那么f(n)=Θ(g(n))。通俗理解为f(n)和g(n)同阶，Θ用来表示算法的精确阶。  
		`定义2：`Θ(g(n))={f(n):存在正常量$c_1$、$c_2$和$n_0$，使得对所有n≥$n_0$，有 **0≤$c_1$g(n)≤f(n)≤$c_2$g(n)}**  若存在正常量$c_1$、$c_2$，使得对于足够大的n，函数f(n)能“夹入”$c_1$g(n)与$c_2$g(n)之间，则f(n)属于集合Θ(g(n))，记作f(n)∈Θ(g(n))。作为代替，我们通常记“f(n)=Θ(g(n))”。  
		<br>
	* #### ***O(big-oh)***  
		设f(n)和g(n)是定义域为自然数集N上的函数。若存在正数c和$n_0$，使得对一切n≥$n_0$都有 **0≤f(n)≤cg(n)** 成立，则称f(n)的渐进的上界是g(n)，记作f(n)=O(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶不高于函数g(n)。  
		通常有：***O(1)<O(log(n))<O(n)<O(nlogn)<O($n^2$)<O($2^n$)<O(n!)<O($n^n$)***  
		<br>
	* #### ***Ω(big-omege)***  
		设f(n)和g(n)是定义域为自然数集N上的函数。若存在正数c和$n_0$，使得对一切n≥$n_0$都有 **0≤cg(n)≤f(n)** 成立，则称f(n)的渐进的下界是g(n)，记作f(n)=Ω(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶不低于函数g(n)。  
		 <br>
	* #### ***o(小-oh)***  
		`定义1：`设f(n)和g(n)是定义域为自然数集合N的函数。如果$\mathop{\lim}\limits_{x\to ∞}\frac{f(n)}{g(n)}=0$，那么f(n)=o(g(n))。通俗理解为f(n)低于g(n)的阶。  
		`定义2：`若对于任意正数c，都存在$n_0$，使得对一切n≥$n_0$都有 **0≤f(n)<cg(n)** 成立，则称f(n)的渐进的非紧确上界是g(n)，记作f(n)=o(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶低于函数g(n)。  
		<br>
	* #### ***ω(小-omege)***  
		`定义1：`设f(n)和g(n)是定义域为自然数集合的函数。如果$\mathop{\lim}\limits_{x\to ∞}\frac{f(n)}{g(n)}=∞$，那么f(n)=o(g(n))。通俗理解为f(n)高于g(n)的阶。  
		`定义2：`设f(n)和g(n)是定义域为自然数集N上的函数。若对于任意正数c，都存在$n_0$，使得对一切n≥n0都有 **0≤cg(n)<f(n)** 成立，则称f(n)的渐进的非紧确下界是g(n)，记作f(n)=ω(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶高于函数g(n)。   
* ### 渐近记号Θ、Ο、Ω、o、ω之间的关系

| 记号 | 含义  | 通俗理解 |
|:---------:|:-------------:|:-------------:|
| Θ | 紧确界 | 相当于”=” |
| O | 上界   | 相当于”<=” |
| Ω | 下界   | 相当于”>=”|
| o | 非紧的上界   |  相当于”<” |
| ω | 非紧的下界   |  相当于”>” |

-----
### \######2017-8-19######
* ### 最大子数组问题  
	在一个序列中，有正数、负数、零若干个，从中找到一个连续若干个（大于等于1个）元素相加之和最大的子数组  
	* **暴力求解法【O($n^2$)】**  
		从n个元素中尝试任意$C_n^2$种组合，即从n各元素中找到某个最佳的组合方式，该组合方式为首尾两个元素之间的元素（包括首尾）之和最大。  
		<br>
	* **分治递归法【O(nlgn)】**  
		我们知道，A[low..high]的任何连续子数组A[i..j]所处的位置必然是以下三种情况之一：1.位于A[low..mid]中；2.位于A[mid+1..high];3.跨越了中点，low<=i<=mid<=j<=high。前两种情况递归调用求解最大子数组即可，而第3种情况采用以下思想： **从mid开始分别向左右两边查找，分别找到左边的最大子数组A[i..mid]和右边最大子数组A[mid+1..j],然后再把两者加起来。  
		思想：递归地求解三种情况下的最大子数组并从中选取最大的一个子数组。  
		<br>
	* **线性求解法（Kadane算法）【O(n)】**	  
		若已知A[1..j]的最大子数组，扩展到A[1..j+1]时，A[1..j+1]的最大子数组要么是A[1..j]的最大子数组，要么是某个子数组A[i..j+1]（1<=i<=j,以j+1结尾）。  
		最大子数组元素个数大于等于2时，其元素和必定大于0  
		最大子数组元素个数为1时，该元素为序列中最大元素。  
		思想：将数组从头开始累加，如果碰到累加和小于等于0，则前面的元素全部舍弃，从下一个元素重新开始累加。  
		tips：算法实现过程中需注意一些细节，比如最大子数组的left索引是否会在最大子数组找到后还更新、最大子数组为一个元素的时候、还有累加过程中，要用一个变量（maxSum）记录所获的过的最大值等  
		<br>
	* **衍生问题**  
		如果相加改为相乘如何解决、限制子数组的长度等  
* ### 矩阵乘法的Strassen算法  
	已知矩阵A=($a_{ij}$)和B=($b_{ij}$)是nxn的方阵，求解C=${A}\cdot{B}$。
	* **朴素求解法【O($n^3$)】**  
		利用公式$c_{ij}=\mathop{\sum}\limits\_{k=0}\limits^n {a_ik}\cdot{b_kj}$求解
	* **分治递归法【O($n^3$)】**  
		利用以下公式递归调用求解  
		$\begin{bmatrix}C_11 &C_12  \\\  C_21& C_22 \end{matrix}=\begin{bmatrix}A_11 &A_12  \\\  A_21& A_22 \end{matrix}+\begin{bmatrix}B_11 &B_12  \\\ B_21& B_22 \\\end{matrix}  
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/矩阵相乘（递归）.jpg)   
	* **Strassen算法**
		Strassen算法的核心思想是令递归树不那么茂盛，即只递归进行7次而不是8次了。但代价是增加了几次矩阵之间的加分。
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/矩阵相乘（Strassen算法）.jpg)   
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/矩阵相乘（Strassen算法效率）.jpg)  
		从实用的角度看，Strassen算法的效果可能还没有朴素方法好，那是因为常数因子大、对于稀疏矩阵，专用算法比这快、稳定性不如朴素好，累积误差大、生成的子矩阵消耗较多的空间。  

-----
### \######2017-8-21######
		
		
		
		
		
		
		
		
		
		

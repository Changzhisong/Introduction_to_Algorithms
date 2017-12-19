算法导论代码实现
========

**算法导论日常更新中...**
****
### Author:Song
### E-mail:Z.S.Chang@qq.com
****
## 目录
* [chapter02](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter02 "跳转到chapter02")
	* [插入排序](#插入排序on2)
	* [选择排序](#选择排序on2)
	* [归并排序](#归并排序onlgn)
	* [冒泡排序](#冒泡排序on2)
* [chapter03](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter03 "跳转到chapter03")
	* [渐进记号的定义](#渐进记号的定义)
	* [渐近记号Θ、Ο、Ω、o、ω之间的关系](#渐近记号ΘΟΩoω之间的关系)
* [chapter04](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter04 "跳转到chapter04")
	* [最大子数组问题](#最大子数组问题)  
	暴力求解法  
	分治递归法  
	线性求解法（Kadane算法）  
	* [矩阵乘法](#矩阵乘法)  
	朴素求解法  
	分治递归法  
	Strassen算法  
	* [求解递归式](#代入法求解递归式)  
	代入法  
	递归树  
	主方法  
* [chapter05](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter05 "跳转到chapter05")
	* [随机化排列数组](#随机化排列数组)  
	优先级法随机排列  
	原址法随机排列
* [chapter06](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter06 "跳转到chapter06")
	* [堆](#堆)  
	堆排序  
	* [优先队列](#优先队列)  
	* [TopK问题](#topk问题)
* [chapter07](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter07 "跳转到chapter07")
	* [快速排序](#快速排序)
* [chapter08](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter08 "跳转到chapter08")  
	* [线性时间排序](#线性时间排序)  
	计数排序  
	基数排序  
	桶排序  
* [chapter09](https://github.com/Changzhisong/Introduction_to_Algorithms/tree/master/chapter09 "跳转到chapter09")  
	* 
***
---
___

更新日志
-------
#### ######2017-8-12######
* ### 插入排序【O($n^2$)】  
	通过构建有序序列，在已经排序的序列中从后面向前扫描，找到相应的位置并插入。
		换句话说，每次从剩余数组中拎出一个元素，与有序数组从后往前对比，直到插入合
		适的位置，然后剩余数组缩小规模在循环插入。是一种原址排序算法（类似于抓牌后整理牌）  
![动画演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter02/Doc/Insertion-sort1.gif)  
* ### 选择排序【O($n^2$)】  
	找出数组A中最小的元素并将其与A[0]进行交换，接着，找出A中第二小的元素与A[1]
		交换。对A中前n-1个元素按该方式交换。  
![动画演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter02/Doc/Selection-Sort.gif)  

-----
#### ######2017-8-15######
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
	* #### ***O(big-oh)***  
		设f(n)和g(n)是定义域为自然数集N上的函数。若存在正数c和$n_0$，使得对一切n≥$n_0$都有 **0≤f(n)≤cg(n)** 成立，则称f(n)的渐进的上界是g(n)，记作f(n)=O(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶不高于函数g(n)。  
		通常有：***O(1)<O(log(n))<O(n)<O(nlogn)<O($n^2$)<O($2^n$)<O(n!)<O($n^n$)***  
	* #### ***Ω(big-omege)***  
		设f(n)和g(n)是定义域为自然数集N上的函数。若存在正数c和$n_0$，使得对一切n≥$n_0$都有 **0≤cg(n)≤f(n)** 成立，则称f(n)的渐进的下界是g(n)，记作f(n)=Ω(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶不低于函数g(n)。  
	* #### ***o(小-oh)***  
		`定义1：`设f(n)和g(n)是定义域为自然数集合N的函数。如果$\mathop{\lim}\limits_{x\to ∞}\frac{f(n)}{g(n)}=0$，那么f(n)=o(g(n))。通俗理解为f(n)低于g(n)的阶。  
		`定义2：`若对于任意正数c，都存在$n_0$，使得对一切n≥$n_0$都有 **0≤f(n)<cg(n)** 成立，则称f(n)的渐进的非紧确上界是g(n)，记作f(n)=o(g(n))。通俗的说n满足一定条件范围内，函数f(n)的阶低于函数g(n)。  
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
		从n个元素中尝试任意$C_n^2$种组合，即从n个元素中找到某个最佳的组合方式，该组合方式为首尾两个元素之间的元素（包括首尾）之和最大。  
		<br>
	* **分治递归法【O(nlgn)】**  
		我们知道，A[low..high]的任何连续子数组A[i..j]所处的位置必然是以下三种情况之一：  
		1.位于A[low..mid]中；  
		2.位于A[mid+1..high];  
		3.跨越了中点，low<=i<=mid<=j<=high。  
		前两种情况递归调用求解最大子数组即可，而第3种情况采用以下思想： **从mid开始分别向左右两边查找，分别找到左边的最大子数组A[i..mid]和右边最大子数组A[mid+1..j],然后再把两者加起来。**  
		`思想：`递归地求解三种情况下的最大子数组并从中选取最大的一个子数组。  
		<br>
	* **线性求解法（Kadane算法）【O(n)】**	  
		若已知A[1..j]的最大子数组，扩展到A[1..j+1]时，A[1..j+1]的最大子数组要么是A[1..j]的最大子数组，要么是某个子数组A[i..j+1]（1<=i<=j,以j+1结尾）。同时有：  
		1.最大子数组元素个数大于等于2时，其元素和必定大于0  
		2.最大子数组元素个数为1时，该元素为序列中最大元素。  
		`思想：`将数组从头开始累加，如果碰到累加和小于等于0，则前面的元素全部舍弃，从下一个元素重新开始累加。  
		`tips：`算法实现过程中需注意一些细节，比如最大子数组的left索引是否会在最大子数组找到后还更新、最大子数组为一个元素的时候、还有累加过程中，要用一个变量（maxSum）记录所获的过的最大值等  
		<br>
	* **衍生问题**  
		如果相加改为相乘如何解决、限制子数组的长度等  
* ### 矩阵乘法  
	已知矩阵A=($a_{ij}$)和B=($b_{ij}$)是nxn的方阵，求解C=${A}\cdot{B}$。
	* **朴素求解法【O($n^3$)】**  
		利用公式$c_{ij}=\mathop{\sum}\limits\_{k=0}\limits^n {a_ik}\cdot{b_kj}$求解
	* **分治递归法【O($n^3$)】**  
		利用以下公式递归调用求解  
		$\begin{bmatrix}C_{11} &C_{12}  \\\  C_{21}& C_{22} \end{bmatrix}=\begin{bmatrix}A_{11} &A_{12}  \\\  A_{21}&A_{22}  \end{bmatrix}+\begin{bmatrix}B_{11} &B_{12}  \\\  B_{21}& B_{22} \end{bmatrix}$  
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/矩阵相乘（递归）.jpg)   
	* **Strassen算法【O($n^{lg7}$)=O($n^{2.81}$)】**  
		Strassen算法的核心思想是令递归树不那么茂盛，即只递归进行7次而不是8次了。但代价是增加了几次矩阵之间的加法。  
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/矩阵相乘（Strassen算法）.jpg)   
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/矩阵相乘（Strassen算法效率）.jpg)  

		从实用的角度看，Strassen算法的效果可能还没有朴素方法好，那是因为常数因子大、对于稀疏矩阵，专用算法比这快、稳定性不如朴素好，累积误差大、生成的子矩阵消耗较多的空间。  

-----
### \######2017-8-21######
* ### 代入法求解递归式  
	1.　猜测解的形式  
	2.　用数学归纳法求出解中的常数，并证明解是正确的。  
* ### 递归树方法求解  
	递归树用于得到一个猜测的解，然后一般需要用代入法验证，如：  
	$$T(n)=3T(n/4)+n^2$$
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/recursion-tree.jpg)   
* ### 主方法求解  
	令a≥1和b>1是常数，f(n)是一个函数，T(n)是定义在非负整数上的递归式：  
	$$T(n)=aT(n/b)+f(n)$$
![ppt演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter04/Doc/master.jpg)   
	主方法并不是使用任何情况，当（1）和（3）的情况中不是多项式意义上的小于或者大于，就会在（1）与（2）或者（2）与（3）之间的间隙中。  
	`多项式意义上大于：`f(x)多项式大于g(x):存在实数$\varepsilon >0$,使得$f(x)>g(x)*n^\varepsilon$  

-----
### \######2017-9-9######
* ### 随机化排列数组  
	* **优先级法随机排列【Ω(nlgn)】**  
		根据随机构造的某个等大小的数组中的元素大小来决定随机化排列的优先级，然后按照该优先级排列数组。
	* **原址法随机排列【O(n)】**  
		在进行第i次迭代时，元素A[i]是从A[i]到A[n]中随机选取，然后交换得到。  
		`swap A[i] with A[random(i,n)]`

-----
### \######2017-9-10######
* ### 堆  
	堆是一个数组，可以被看成是一个近似的完全二叉树（除了最底层外，该树是完全充满的，而且是从左向右填充），树上的每个节点对应数组中的一个元素，但不一定一一对应，因为heapSize不一定等于A.length。  

	如果根节点在数组中的位置是1，第i个位置的子节点分别在2i和 2i+1。可分为最大堆和最小堆：  
	**最大堆：** 除根节点外的任何节点的值小于等于父节点的值  
	**最小堆：** 除根节点外的任何节点的值大于等于父节点的值  
	以下以最大堆为例：  
![图片演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter06/doc/heap.jpg)   
	* **维护堆的性质【O(lgn)】**  
		节点i与其左右孩子的值对比选出最大者交换至i处，若最大者为i则结束否则向下递归直至子树都满足最大堆性质。且假定以其左右孩子为堆顶的堆均已是最大堆。
	* **建堆【O(n)】**  
		利用自底向上的方法及维护堆的性质的过程，把一个大小为A.length的数组A[1..n]转换为最大堆。  
		因为$A[\lfloor n/2 \rfloor+1..n]$中的元素为树的叶子节点，所以就可以直接把$A[\lfloor n/2 \rfloor+1..n]$中的元素看成只包含一个元素的堆，从$\lfloor n/2 \rfloor$往1开始递减来维护堆的性质即可建成堆。  
	*删除根节点用于堆排序。*
	* **堆排序【O(nlgn)】**  
		在建堆后，可得根节点A[1]为数组A的最大值，互换A[1]和A[n]后，控制heapSize的值来去掉堆的节点n,重新维护堆的性质，形成将A[1..n-1]上构成新的最大堆，然后重复直到A.HeapSize为2，即堆中只剩两个元素了。
![图片演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter06/doc/heapSort.jpg)   
* ### 优先队列  
	优先队列是一种用来维护（插入元素、寻找最值...）由一组元素构成的集合S的数据结构。  
	　　**普通队列**是一种先进先出的数据结构，元素在队列尾追加，而从队列头删除。在**优先队列**中，元素被赋予优先级，当访问元素时，具有最高优先级（最值）的最先被删除（最高级先出）。  
	通常支持以下操作（以最大优先队列为例）：

	| 操作 | 解释 | 方法 | 时间复杂度 |
	|:---------:|:-------------:| :-------------: | :-------------: |
	| Maximum(S) | 返回S中最大元素 | 直接返回堆顶元素A[1] | Θ(n) |
	| ExtractMax(S) | 返回并删除S中最大元素 | 将堆顶元素交换至n处，然后控制heapSize的值来去掉堆的节点n，再维护堆的性质 | O(lgn) |
	| IncreaseKey(S,x,k) | 将x元素的值增加到k | 增加到k后与其父节点对比，大于就交换（上浮操作） | O(lgn) |
	| Insert(S,x) | 将元素x插入到集合S中 | 先插入堆尾一个-∞，然后调用IncreaseKey将其增加至x | O(lgn) |
* ### TopK问题  
	`问题描述：`求N个数中，前K大/小的数或第K大/小的数  
	`方法:`  
		　1.　数据量较小时，采用常规排序解决即可  
		　2.　数据量较大时，采用最小/大堆、快速选择等方法  
	`用最小/大堆解决TopK问题的思想：`**【O(nlgK)】**  
	　　假设求解一个第K大的数，第一步先选取前K个数，建成 **最小堆**，然后从第K+1个数开始，与堆顶元素进行比较，如果比堆顶元素小，则舍弃，否则如果比堆顶元素大则舍弃当前堆顶元素，而将这个数作为新的堆顶，再维护堆的性质，重复处理K+2...N的数。  
	　　此时的堆顶为第K大的数，且此时的堆为前K大的数所构成。  

-----
### \######2017-9-12######
* ### 快速排序   
	采用分治思想：  
	　1.　从数列中选择一个元素，称为基准（一般选择列首或者列尾）；  
	　2.　重新排列数列。把所有比基准小的元素放到其前面，大的放到其后面（分区操作）；  
	　3.　递归地把两个分区的子数列排序。  
	递归到最底部时，数列的大小是零或者是1，即已经排好序了。  
	伪代码如下：
    ```
	QuickSort(A,p,r)   
    if p<r  
        q=Partion(A，p,r)    //分区操作
        QuickSort(A,p,q-1)    //左边递归
        QuickSort(A,q+1,r)    //右边递归
    ```
	其中分区操作Partition部分是代码的核心:
    ````
    Partition(A,p,r)
    x=A[r]    //基准
    i=p-1    //i用来分隔基准左边与右边
    for j=p to r-1
        if A[j]<=x
            i=i+1
            exchange A[i] with A[j]
    exchange A[i+1] with A[r]
    return i+1
    ````
	分区时的两种情况：  
	　　　　　　![图片演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter07/doc/partition.jpg)  
	**时间：** 在最坏情况下为$Θ(n^2)$,但这种情况并不常见，期望时间复杂度为$O(nlgn)$,这个时间通常比同等$O(nlgn)$的排序算法快，因为其隐含的常数因子小。且该算法是原址排序，比较实用。
	* **随机化快速排序**  
		只需在选择基准的时候采用随机化选择数列的某一个作为基准。然后与末位或者首位元素进行交换，在调用Partition(A,p,r)即可。

-----
### \######2017-9-13######
* ### 线性时间排序  
	在最坏情况下， **任何比较排序算法都需要做Ω(nlgn)次比较**  
	除了比较排序算法，还有一些非比较排序算法，如下三种：
	* **计数排序【Θ(n+k)】**  
		对于每一个输入元素x，确定小于x的元素的个数，则可以确定x的正确排序的位置。例如：有100个人，统计出21个人的年龄比A小，因此A的年龄就应该排在第9位。用这个方法可以得到每个元素的位置，也就排好序了。  
		`步骤：`  
		　1.　找出待排序数组A的最大元素k;  
		　2.　新建数组$C[0..k]$,统计待排序数组中每个元素i出现的次数，并保存到$C[i]$;  
		　3.　对所有计数累加（从C的第一个元素开始，每一项和前一项相加）；  
		　4.　反向填充目标数组$B[1..n]$,将A中每个元素i放到B的第$C[i]$项，每放一个$C[i]$减一。//有$C[A[j]]$个元素小于等于$A[j]$,因此$A[j]$应在B的$C[A[j]]$的位置处。
![图片演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter08/doc/countingSort.gif)  
	* **基数排序【Θ(d(n+k))】**  
		按位数进行排序，先所有个位开始排序，在十位，在百位...一直到最高位，数列即可完成排序。  
		在每位进行排序时，采用稳定排序算法，一般采用计数排序作为子算法进行。  
![图片演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter08/doc/radixSort.gif)
	* **桶排序【最坏：$Θ(n^2)$期望：$Θ(n)$】**  
		将数列相邻的若干各元素分担到桶里，然后在对每一个桶进行排序（使用插入排序或者其他排序算法），最后将各个桶合并起来。  
		`例如：`若 $value*NumberofElements/(Maximum+1)$ 值相同的元素可以放到等于该值的桶里。  
![图片演示](https://github.com/Changzhisong/Introduction_to_Algorithms/blob/master/chapter08/doc/bucketSort.gif)
		

-----
### \######2017-9-18######
* ### 选择算法(TopK问题)
	找出第K小/大的元素
	* 期望为线性时间的选择算法
		`思想:`利用快速排序中Randomised-QuicjSort中的模型，每次划分操作可以返回第**q-p+1**小的元素的索引，然后判断与k值的大小，递归，直到得到第k小的元素的索引。
	```
    Randomised-Select(A,p,r,k)
    if p==r
        return A[p]
    q=Randomised-Partition(A,p,r)
    t=q-p+1
    if k==t
        return A[q]
    else if k<t
        return Randomised-Selsect(A,p,q-1,k)
    else return Randomised-Select(A,q+1,r,k-t)
    ````
	**时间：** 在最坏情况下为$Θ(n^2)$,期望时间复杂度为$O(n)$  
	* 最坏情况为线性时间的选择算法  
	`思想：`将数列分别为5组，每组利用插入排序找出中位数，在递归调用Select算法找出$\lceil n/5 \rceil$个中位数的中位数x,利用修改的Parttition按x对数列划分。根据x的索引判断x是第几小元素然后与k比较，在递归。  
	`注：` 这种方法主要思想是防止Randomised-Select算法出现总是按余下的元素的最大划分数列的最坏情况。  

-----
### \######2017-9-25######
* ### 栈和队列  
	**栈:** 后进先出（LIFO）  
	**队列:** 先进先出（FIFO）  
	* **栈的基本操作**  
		1.　insert操作(PUSH压入)：  
        ```
        PUSH(S,x)
        S.top=s.top+1
        S[s.top]=x  
        ```
		2.　delect操作(POP弹出)：  
        ```
        Pop(S)
        if stack-Emply(S)  
            error "underflow"
        else S.top=S.top-1
            return S[S.top+1]
        ```
		S.top=0,表明栈是空的。  
	* **队列的基本操作** 
		1.　insert操作（enqueue入队）
        ```
        Enqueue(Q,x)
        Q[Q.tail]=x
        if Q.tail ==Q.length
            Q.tail =1
        else Q.tail++
        ```
		2.　Deldect操作（Dequeue出队）
		```
        x=Q[Q.head]
        if Q.head ==Q.length
            Q.head=1
        else Q.head=Q.Head+1
        return x
        ```
		`注意：`元素可在最后的位置环绕，即感觉位置1是紧邻位置n后面。利用Q[1..n]来实现最多n-1个元素的队列  
		Q.head=Q.tail,表明队列为空；Q.head = Q.tail+1 ,表明队列满了。  


-----
### \######2017-10-14######
*             得更新了吧
package Demos;

public class SortMethods {
	/**
	 * 稳定排序算法：冒泡排序，插入排序，合并排序
	 * 不稳定排序算法：选择排序，希尔排序，快速排序，堆排序
	 * 
	 * /
	
	
	/*
	 * 冒泡排序
	 * 算法思想
	 * 1）从数组第一个元素开始，以此进行相邻连个元素大小的比较，
	 * 如果a[i]>a[i+1],则交换个两个元素的值，使得值大的元素后移
	 * 然后下标加1，比较第二元元素与第三个元素的值，重复上边的操作
	 * 平均时间复杂度 O(n^2);
	 * 
	 * */
	
	
	
	public static void bubbleSort(int[] a){
		
		int temp;
		for (int i = 1; i<=a.length;i++){
			for (int j = 0; j<a.length-i;j++){
				
				if (a[j]>a[j+1]){
					 temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
				
			}
			//printArray(a,i);
		}
		
		
	}
	
	
	/*
	 * 快速排序 （冒泡排序的改进）
	 * 算法思想：
	 * 1）首先选定一个分界值，一般选为数组的第一个元素或者随机位置位置元素： f=（left+right)/2 
	 * 2）首先从右侧开始扫描，找到第一个小于分界值的元素，
	 *    然后将其与左边数组的元素互换，
	 * 3）然后再从左边开始于分界值比较，找到第一个大于分界值的元素，然后和右边数组元素互换
	 * 4）直到left>=right，把分界值赋给a[right];
	 * 5) 这样第一轮排序完成，接着继续左右子数组排序
	 * 平均时间复杂度为O(nlogn),最坏是为O(n^2)
	 * 
	 * */
	
	public static void quickSort(int[] a, int left, int right){
		if (left >= right)
			return;
		
		
		
		//pick up the first one element as the pivot number;
		int baseValue = a[left];
		int leftPos = left;
		int rightPos = right;
		
		
		//System.out.println("The base value index is "+(left+right)/2+", baseValue="+baseValue);
		
		while (leftPos < rightPos){
			
			//先从右边开始扫描，找到第一个小于分界值的元素
			while (a[rightPos]>=baseValue && rightPos >leftPos){
				
				rightPos--;
			}
			
			a[leftPos]=a[rightPos];
		
			while (a[leftPos]<=baseValue && leftPos< rightPos){
				
				leftPos++;
			}
			a[rightPos]=a[leftPos];
			
			
															
		}
		//循环的最终 leftPos==rightPos,此时也是分界值排序后所应在的位置。
		a[rightPos]=baseValue;
//		System.out.println("LeftPos="+leftPos+",rightPos="+rightPos);
//		System.out.println("baseValue="+baseValue);
////		for (int e : a){
//			
//			System.out.print(e+",");
//		}
//		System.out.println();
		
		int index = rightPos;
	
		quickSort(a,index+1,right);	//分界值右侧排序							
		quickSort(a,left,index-1); //分界值左侧排序
									
		
	}
	
	/*
	 * 选择排序
	 * 算法思想：
	 * 1）首先选择元素a[0]一次与数组中的元素a[1]比较，如果a[0]>a[1],则交换两个元素的值。
	 * 2）然后a[0]继续与元素a[2]比较，如果a[0]>a[2],则交换元素的值，
	 * 3）一次类推，通过第一轮排序之后，得到数组中最小的值
	 * 4）然后从a[1]开始第二轮排序，一次类推。。。
	 * 平均时间复杂度为O(n^2)
	 * 
	 * */
	public static void selectionSort(int[] a){
		
		int temp;
		for (int i = 0; i < a.length-1;i++){
			for (int j=i+1;j<a.length;j++){
				if (a[i]>a[j]){
					temp = a[i];
					a[i]=a[j];
					a[j]=temp;
					
				}
				
			}
			
			//printArray(a,i);
		}
		
	}
	
	
	/*
	 * 堆是一种重要的数据结构，为一棵完全二叉树, 底层如果用数组存储数据的话，
	 * 假设某个元素为序号为i(Java数组从0开始,i为0到n-1),如果它有左子树，
	 * 那么左子树的位置是2i+1，如果有右子树，右子树的位置是2i+2，
	 * 如果有父节点，父节点的位置是(n-1)/2取整。分为最大堆和最小堆，
	 * 最大堆的任意子树根节点不小于任意子结点，最小堆的根节点不大于任意子结点。
	 * 所谓堆排序就是利用堆这种数据结构来对数组排序，我们使用的是最大堆。
	 * 处理的思想和冒泡排序，选择排序非常的类似，一层层封顶，只是最大元素的选取使用了最大堆。
	 * 最大堆的最大元素一定在第0位置，构建好堆之后，交换0位置元素与顶即可。
	 * 堆排序为原位排序(空间小), 且最坏运行时间是O(nlgn)，是渐进最优的比较排序算法。
	 * 
	 * 堆排序的大概步骤如下:
	 * 构建最大堆。
	 * 选择顶，并与第0位置元素交换
	 * 由于步骤2的的交换可能破环了最大堆的性质，第0不再是最大元素，需要调用maxHeap调整堆(沉降法)，
	 * 如果需要重复步骤2
	 * 堆排序中最重要的算法就是maxHeap，该函数假设一个元素的两个子节点都满足最大堆的性质
	 * (左右子树都是最大堆)，只有跟元素可能违反最大堆性质，
	 * 那么把该元素以及左右子节点的最大元素找出来，如果该元素已经最大，
	 * 那么整棵树都是最大堆，程序退出，否则交换跟元素与最大元素的位置，
	 * 继续调用maxHeap原最大元素所在的子树。该算法是分治法的典型应用。
	 * 
	 * 
	 * */
	public static void heapSort(int[] array) {  
        if (array == null || array.length <= 1) {  
            return;  
        }  

        buildMaxHeap(array);  

        for (int i = array.length - 1; i >= 1; i--) {  
            exchangeElements(array, 0, i);  

            maxHeap(array, i, 0);  
        }  
    }  

    private static void buildMaxHeap(int[] array) {  
        if (array == null || array.length <= 1) {  
            return;  
        }  

        int half = array.length / 2;  
        for (int i = half; i >= 0; i--) {  
            maxHeap(array, array.length, i);  
        }  
    }  

    private static void maxHeap(int[] array, int heapSize, int index) {  
        int left = index * 2 + 1;  //左子树的位置是2i+1
        int right = index * 2 + 2;  //右子树的位置是2i+2

        int largest = index;  
        if (left < heapSize && array[left] > array[index]) {  
            largest = left;  
        }  

        if (right < heapSize && array[right] > array[largest]) {  
            largest = right;  
        }  

        if (index != largest) {  
            exchangeElements(array, index, largest);  

            maxHeap(array, heapSize, largest);  
        }  
    }  
	
	
	
	
	
	/*
	 * 插入排序
	 * 算法思想：
	 * 1) 首先对数组的前两个元素进行排序，
	 * 2）然后将第三个元素插入到前两个排序好的两个元素的合适位置
	 * 3）继续讲第四个元素插入到前三个排序好的数组的合适位置
	 * 以此类推到每个元素。
	 * 平均时间复杂度为 O(n^2)
	 * 
	 * */
	
	public static void insertionSort(int[] a){
		
		
		int t;
		
		for (int i=0;i<a.length-1;i++){
			t = a[i+1];
			for (int j=i;j>=0;j--){
				
				if(t<a[j]){
					a[j+1] = a[j];
					a[j]=t;
					
										
				}
				
			}
			//printArray(a,i+1);
		}
	}
	
	
	/*
	 * 希尔排序 (插入排序的改进)
	 * 算法思想:严格来说是基于插入排序的思想
	 * 1）将有n个元素的数组分成n/2个子序列，
	 * 2）第一个元素和第n/2+1个元素为一对排好序
	 * 3）然后再变为n/4个序列，再次排序
	 * 4） 不断重复上述过程
	 * 平均时间复杂度为O(n^3/2)->O(n^2)
	 * 需要注意的是，增量序列的最后一个增量值必须等于1才行。
	 * 另外，由于记录是跳跃式的移动，希尔排序并不是一种稳定的排序算法。
	 * 
	 * */
	public static void shellSort(int[] a){
		
		int t;
		int count = 0;
		
		for (int i = a.length/2; i>=1; i /= 2){
			//System.out.println("The step increament is "+i);
			
			//下边的每次循环就是一个插入排序
			for (int j = i;j<a.length;j++){
				 t = a[j];
				for (int r = j; r>=0; r -= i ){
					if (a[r]>t){
						a[r+i]=a[r];
						a[r]=t;										
					}									
				}				
			}
			count++;
			//printArray(a,count);
		}
		
		
	}
	
	//希尔排序，网络上的算法
	public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < data.length; i++) {
                
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp; //???
            }
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + " ");
        }
    }
	
	
	 public static void exchangeElements(int[] array, int index1, int index2) {  
         int temp = array[index1];  
         array[index1] = array[index2];  
         array[index2] = temp;  
     }  
	
	public static void printArray(int[] a, int i){
		
		System.out.print("The "+i+" round sort result is ");
		for (int e : a){
			
			System.out.print(e+",");
		}
		System.out.println();
	}
	
	public static void printArray(int[] array){
			
		System.out.print("{");  
	    for (int i = 0; i < array.length; i++) {  
	        System.out.print(array[i]);  
	        if (i < array.length - 1) {  
	            System.out.print(", ");  
	        }  
	    }  
	    System.out.println("}");  
	}
	
	public static void main (String[] args) {
		
		final int SIZE = 100000;
		
		int[] a = new int[SIZE];
		
		for (int i = 0; i<SIZE;i++){
			
			a[i] = (int) (0+Math.random()*(100000+1));
		}
//		
//		int [] a = {125,105,171,107,183,123,106,107,187,140};
		System.out.print("the inital array is: ");
		for (int e : a){
			System.out.print(e+",");
			
		}
		System.out.println();
		
		//SortMethods.bubbleSort(a);
		//SortMethods.selectionSort(a);
		//SortMethods.insertionSort(a);
		//SortMethods.shellSort(a);
		//SortMethods.shellSortSmallToBig(a);
		
		//SortMethods.quickSort(a, 0, a.length-1);
		//QuickSort.quickSort(a, 0, a.length-1);
		
		SortMethods.heapSort(a);
		
		System.out.print("The final sorted result is ");
		for (int e : a){
			System.out.print(e+",");
		
		}
		System.out.println();
				
				

	
	}

}

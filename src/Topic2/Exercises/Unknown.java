public class Unknown{
	public static void main(String[] args){
		int[] A = new int[]{1, 2, 3, 1, 2, 3, 5, 6};
		System.out.println(A);
		doIt(A);
		System.out.println(A);
	}

	public static void doIt(int[] A){
		int max = A[0], min = A[0];
		for(int i = 0; i < A.length; i++){
			max = Math.max(max, A[i]);
			min = Math.min(min, A[i]);
		}

		int C[] = new int[max + 1 - min];
		for(int i = 0; i < A.length; i++) C[A[i] - min]++;

		for(int i = 0, k = 0; i < C.length; i++)
			while(--C[i] >= 0) A[k++] = i + min;
	}
}
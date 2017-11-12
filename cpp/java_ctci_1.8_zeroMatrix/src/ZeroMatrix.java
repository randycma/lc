import java.util.HashSet;

public class ZeroMatrix {

	// 1. store separate hashtables noting which rows and cols have an element that is == 0
	// 2. iterate through above container, then set those rows and cols to 0
	public static void zeroMatrix(int[][] arr)
	{
		HashSet<Integer> rowsWithZero = new HashSet<Integer>();
		HashSet<Integer> colsWithZero = new HashSet<Integer>();
		
		for(int row = 0; row < arr.length; ++row)
		{
			for(int col = 0; col < arr[0].length; ++col)
			{
				if(arr[row][col] == 0)
				{
					rowsWithZero.add(row);
					colsWithZero.add(col);
				}
			}
		}
		
		for(int row : rowsWithZero)
		{
			for(int col = 0; col < arr[0].length; ++col)
			{
				arr[row][col] = 0;
			}
		}
		
		for(int col : colsWithZero)
		{
			for(int row = 0; row < arr.length; ++row)
			{
				arr[row][col] = 0;
			}
		}
	}
	
	public static void zeroRow(int[][] arr, int row)
	{
		for(int col = 0; col < arr[0].length; ++col)
		{
			arr[row][col] = 0;
		}
	}
		
	public static void zeroCol(int[][] arr, int col)
	{
		for(int row = 1; row < arr.length; ++row)
		{
			arr[row][col] = 0;
		}
	}
	
	public static void zeroMatrix2(int[][] arr)
	{
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		
		// See if there are any 0s in first row
		for(int col = 0; col < arr[0].length; ++col)
		{
			if(arr[0][col] == 0)
			{
				firstRowHasZero = true;; 
				break;
			}
		}
		
		for(int row = 0; row < arr.length; ++row)
		{
			if(arr[row][0] == 0)
			{
				firstColHasZero = true;; 
				break;
			}
		}
		
		// Use first row and first column to mark zeros
		for(int row = 1; row < arr.length; ++row)
		{
			for(int col = 1; col < arr[0].length; ++col)
			{
				if(arr[row][col] == 0)
				{
					arr[row][0] = 0;
					arr[0][col] = 0;
				}
			}
		}
		
		// Zero rows and columns based on values in first row/column.
		// We start indexing at 1 because we are treating first row/column separately (with those booleans)
		for(int row = 1; row < arr.length; ++row)
		{
			if(arr[row][0] == 0)
				zeroRow(arr, row);
		}
		
		for(int col = 1; col < arr[0].length; ++col)
		{
			if(arr[0][col] == 0)
				zeroCol(arr, col);
		}
		
		if(firstRowHasZero)
			zeroRow(arr, 0);
		
		if(firstColHasZero)
			zeroCol(arr, 0);
	}
	
	public static void printArr(int[][] arr)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < arr.length; ++i)
		{
			for(int j=0; j < arr[0].length; ++j)
			{
				sb.append(arr[i][j]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		int arr[][] = { {0,2,3,4,5}, {5,6,0,8,9}, {9,8,7,6,5}, {5,4,3,2,1}, {1,2,3,4,5} };
		printArr(arr);
				
		zeroMatrix2(arr);
		
		printArr(arr);
	}

}

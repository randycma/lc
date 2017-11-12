
public class RotateMatrix {

	public static int[][] rotateImage(int[][] image)
	{
		if(image.length == 0)
			return new int[0][0];
		
		int[][] rotated = new int[image.length][image[0].length];
		
		for(int i=0; i < rotated.length; ++i)
		{
			for(int j=0; j < rotated[0].length; ++j)
			{
				rotated[i][j] = image[(-j + rotated.length - 1) % rotated.length][i];
			}
		}
		return rotated;
	}
	
	public static void rotateImageInplace(int[][] image)
	{
		// define layer as "rings" of the 2d matrix
		for(int layer=0; layer < image.length / 2; ++layer)
		{
			int lenLayer = image.length - 2*layer;
			
			// we need to rotate the values from the beginning of the layer to the second last element of this layer row
			// we skip the last element because that element is already rotated along with the first element
			for(int index = layer; index < image.length - layer - 1; ++index)
			{
				// Swap the four elements
				int oppositeLayer = image.length - layer - 1;
				int oppositeIndex = lenLayer - index - 1 + layer + layer;
				
				int temp = image[layer][index];
				
				image[layer][index] = image[oppositeIndex][layer];
				image[oppositeIndex][layer] = image[oppositeLayer][oppositeIndex];
				image[oppositeLayer][oppositeIndex] = image[index][oppositeLayer];
				image[index][oppositeLayer] = temp;
			}
		}
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
		int arr[][] = { {1,2,3,4,5}, {5,6,7,8,9}, {9,8,7,6,5}, {5,4,3,2,1}, {1,2,3,4,5} };
		printArr(arr);
		printArr(rotateImage(arr));
		
		rotateImageInplace(arr);
		
		printArr(arr);
	}

}


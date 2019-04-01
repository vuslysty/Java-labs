import javax.lang.model.type.NullType;
import java.io.File;
import java.util.Scanner;

public class GetMatrix
{
	static public Matrix	getM(String path)
	{
		Matrix	matrix;

		matrix = null;
		try
		{
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			matrix = new Matrix(rows, cols);
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
					matrix.matrix[i][j] = scanner.nextInt();
		}
		catch (Exception e){
			System.out.println("Something goes wrong!");
		}
		return (matrix);
	}
}

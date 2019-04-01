import com.sun.jdi.event.ExceptionEvent;

import java.util.ArrayList;

public class MultMatrix
{
	ArrayList <MultThread> threadsArr;
	Matrix matrix;
	Matrix m1;
	Matrix m2;
	int	step;

	MultMatrix(Matrix m1, Matrix m2, int numThreads)
	{
		this.m1 = m1;
		this.m2 = m2;
		matrix = new Matrix(m1.getRows(), m2.getCols());
		if (numThreads > matrix.getRows())
			step = 1;
		else
			step = matrix.getRows() / numThreads;
		threadsArr = new ArrayList<>(numThreads + 1);
	}

	public Matrix startMult()
	{
		int row = 0;
		int	i;

		i = 0;
		while (row < matrix.getRows())
		{
			threadsArr.add(new MultThread(matrix, row, m1, m2, step));
			threadsArr.get(i).start();
			row += step;
			i++;
		}
		for (MultThread item : threadsArr)
		{
			try
			{
				item.join();
			}
			catch (Exception e){}
		}
		return (matrix);
	}
}

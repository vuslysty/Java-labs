import java.util.Formatter;

public class lab_1_4
{
	public static void main(String[] args)
	{
		int numThreads = 1;
		System.out.println("Parsing...");
		Matrix m1 = GetMatrix.getM("matrix1");
		Matrix m2 = GetMatrix.getM("matrix2");
//		try
//		{
//			int i;
//			Formatter f = new Formatter("ThreadSpeedTest.txt");
//			while (numThreads <= 15)
//			{
//				i = 0;
//				f.format("Tests for %d threads:\n", numThreads);
//				System.out.printf("Test for %d threads:\n", numThreads);
//				while (i++ < 1)
//				{
//					long start = System.nanoTime();
//					new MultMatrix(m1, m2, numThreads).startMult();
//					long end = System.nanoTime();
//					long res = ((end - start) / 1_000_000);
//					f.format("   test %2d: %d milliseconds\n", i, res);
//					System.out.printf("   test %2d: %d milliseconds\n", i, res);
//				}
//				numThreads++;
//			}
//			f.close();
//		}
//		catch (Exception e){};
//

		Matrix	res = new MultMatrix(m1, m2, numThreads).startMult();
		PrintMatrix.print(res);
	}
}

class PrintMatrix
{
	static void print(Matrix m)
	{
		int col;
		int row = 0;
		while (row < m.getRows())
		{
			col = 0;
			while (col < m.getCols())
			{
				System.out.printf("%5d", m.matrix[row][col]);
				col++;
			}
			System.out.println();
			row++;
		}
	}
}

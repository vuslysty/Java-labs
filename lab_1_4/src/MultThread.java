class MultThread extends Thread
{
	Matrix 		res_m;
	Matrix		m1;
	Matrix		m2;
	private int row;
	private int step;

	MultThread(Matrix m, int row, Matrix m1, Matrix m2, int step)
	{
		this.step = step;
		res_m = m;
		this.row = row;
		this.m1 = m1;
		this.m2 = m2;
	}

	public void run()
	{
		int res;
		int i;
		int col;

		while (step-- > 0 && row < res_m.getRows())
		{
			col = 0;
			while (col < res_m.getCols())
			{
				i = 0;
				res = 0;
				while (i < m1.getCols())
				{
					res = res + (m1.matrix[row][i] * m2.matrix[i][col]);
					i++;
				}
				res_m.matrix[row][col] = res;
				col++;
			}
			row++;
		}
	}
}

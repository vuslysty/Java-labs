public class Matrix
{
	Integer[][] matrix;
	private	int	cols;
	private int rows;

	public Matrix(int row, int col)
	{
		cols = col;
		rows = row;
		matrix = new Integer[row][col];
	}

	public int getCols(){
		return cols;
	}

	public int getRows()
	{
		return rows;
	}
}

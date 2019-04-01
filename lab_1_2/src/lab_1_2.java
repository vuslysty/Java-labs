
class MyThread extends Thread
{
	private char	sym;
	private int		counter;
	Operation		oper;

	MyThread(String name, Operation op)
	{
		oper = op;
		setName(name);
		sym = '|';
		counter = 0;
	}

	void incrementCounter()
	{
		counter++;
	}

	@Override
	public void run()
	{
		while (counter < 10)
		{
			oper.print_sym(this);
			try
			{
				sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

class Operation
{
	private boolean flag;

	Operation(boolean flag)
	{
		this.flag = flag;
	}

	synchronized void print_sym(MyThread my)
	{
		if (!flag && my.getName().equals("minus"))
		{
			System.out.print('-');
			my.incrementCounter();
			flag = !flag;
		}
		else if (flag && my.getName().equals("stick"))
		{
			System.out.println('|');
			my.incrementCounter();
			flag = !flag;
		}
	}
}

public class lab_1_2
{

	public static void	main(String[] args)
	{
		Operation	oper	= new Operation(false);
		MyThread minus = new MyThread("minus", oper);
		MyThread stick = new MyThread("stick", oper);
		System.out.println("Start!!!");
		minus.start();
		stick.start();
	}
}
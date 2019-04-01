public class lab_1_3
{

	public static void	main(String[] args)
	{
		Counter	counter	= new Counter();
		MyThread increment = new MyThread(false, counter);
		MyThread decrement = new MyThread(true, counter);
		System.out.println("Start!!!");
		increment.start();
		decrement.start();
		try
		{
			increment.join();
			decrement.join();
		}
		catch (Exception e){}
		System.out.println("Counter at end: " + counter.getI());
	}
}

class MyThread extends Thread
{
	private boolean	flag;
	private Counter	counter;

	MyThread(boolean f, Counter c)
	{
		flag = f;
		counter = c;
	}

	@Override
	public void run()
	{
		if (!flag)
			counter.increment();
		else
			counter.decrement();
	}
}

class Counter
{
	private int		i;

	int getI()
	{
		return i;
	}

	void	increment()
	{
		int counter;

		counter = 0;
		while (counter++ < 1000)
		{
			synchronized (this)
			{
				System.out.println(i++);
				try
				{
					Thread.sleep(1);
				}
				catch (Exception e)
				{
				}
			}
		}
	}

	void	decrement()
	{
		int counter;

		counter = 0;
		while (counter++ < 1000)
		{
			synchronized (this)
			{
				System.out.println(i--);
				try
				{
					Thread.sleep(1);
				}
				catch (Exception e)
				{
				}
			}
		}
	}
}
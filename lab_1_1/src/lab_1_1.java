import java.util.Scanner;

public class lab_1_1
{
	public static void	main(String[] args)
	{
		Scanner sc = new Scanner("We have the java learning course!");
		while (sc.hasNext())
		{
			System.out.print(sc.next() + " ");
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				System.out.println("Error");
			}
		}
	}
}

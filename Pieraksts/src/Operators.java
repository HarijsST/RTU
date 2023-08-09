import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Operators extends Pielikums{
	public void oper() {
		Pielikums pie = new Pielikums();
		try {
			pie.test();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean x = true;
		while (x) {
			System.out.println("Ko vēlaties darīt ar pierakstu? 1 - akceptēt, 2 - noraidīt");
			Scanner scan = new Scanner(System.in);

			int a = scan.nextInt();
			if (a == 1) {
				String[] arr = { "10:00", "12:00", "13:15", "14:30", "17:15" };
				Random rand = new Random();
				int randomNumber = rand.nextInt(arr.length);
				System.out.println("Pieraksta laiks ir plkst. " + arr[randomNumber]);
				x = false;
			} else if (a == 2) {
				System.out.println("Pieraksts ir attcelts");
				 File pieraksts = new File("D:\\Eclipse\\Eclipse-workspace\\Pieraksts"); 
				    if (pieraksts.delete()) { 
				      System.out.println("Pieraksta pieteikums ir dzēsts: " + pieraksts.getName());
				    } else {
				      System.out.println("Neizdevās dzēst pieraksta pieteikumu");
				    } 
				x = false;
			} else {
				System.out.println("Nepareiza ievade");
			}
		}
	}	
}

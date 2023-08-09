import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Pielikums {
	public void test() throws IOException {
		try {
			File f = new File("D:\\Eclipse\\Eclipse-workspace\\Pieraksts");
			String[] files = f.list();
			System.out.println("Pieejamie faili:");
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i]);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Kuru failu vēlaties atvērt?");
		Scanner scan = new Scanner(System.in);
		int openFile = scan.nextInt();

		try {
			File myObj = new File("D:\\Eclipse\\Eclipse-workspace\\Pieraksts\\" + openFile + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pieteikums {

	public static void main(String[] args) throws ParseException, IOException {
		Scanner scan = new Scanner(System.in);
		String name = null;
		String phoneStr = null;
		String dateStr = "";

		boolean fizz = true;
		while (fizz) {
			System.out.println("Pierakstīties kā Lietotājam vai Operātoram L/O");
			char a = scan.next().charAt(0);
			switch (a) {
			case 'l', 'L':
				name = getName(name, scan);
				phoneStr = getPhone(phoneStr, scan);
				dateStr = getDate(dateStr, scan);
				writer(name, phoneStr, dateStr);
				fizz = false;
				break;
			case 'o', 'O':
				Operators op = new Operators();
				op.oper();
				fizz = false;
				break;
			default:
				System.out.println("Šāds variants netiek akceptēts!");
			}
		}
	}

	public static String getName(String name, Scanner scan) {
		System.out.print("Ievadīt vārdu: ");
		name = scan.next();
		String namef = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		System.out.println("Jūsu vārds: " + namef);
		return namef;
	}

	public static String getPhone(String phoneStr, Scanner scan) {
		boolean c = true;
		while (c) {
			System.out.print("Ievadīt telefona Nr.: ");
			phoneStr = scan.next();
			if (isValidMobileNo(phoneStr)) {
				System.out.println("Tālruņa Nr.: " + phoneStr);
				c = false;
			} else {
				System.out.println("Ievadītais tālruņa Nr. ir nepareizs.");
			}
		}
		return phoneStr;
	}

	public static boolean isValidMobileNo(String phoneStr) {
		Pattern ptrn = Pattern.compile("[0-9]{8}");
		Matcher match = ptrn.matcher(phoneStr);
		return (match.find() && match.group().equals(phoneStr));
	}

	public static String getDate(String dateStr, Scanner scan) throws ParseException {
		System.out.print("Ievadīt vēlamo datumu: dd/MM/yyyy - ");
		Scanner sc = new Scanner(System.in);
		dateStr = sc.nextLine();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("Datums nav pieejams ");
		}

		DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG);

		String finalDate = df2.format(date);

		System.out.println("Vēlamais datums ir: " + finalDate);
		return finalDate;
	}

	public static void writer(String namef, String phoneStr, String finalDate) throws IOException {
		Random ran = new Random();
		int viziteNum = ran.nextInt(10);
		File vizite = new File(viziteNum + ".txt");
		if (vizite.createNewFile()) {
			System.out.println("Pieraksts ir izveidots!");
		} else {
			System.out.println("Fails jau eksistē!");
		}
		try {
			FileWriter writer = new FileWriter(vizite.getPath());
			writer.write("Vārds: " + namef + "\n");
			writer.write("Tālruņa numurs: " + phoneStr + "\n");
			writer.write("Vizītes datums: " + finalDate + "\n");
			writer.close();
		} catch (Exception e) {
			System.out.println("Neizdevās ierakstīt failā!");
		}
	}
}

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
	Controller controller = new Controller();
	controller.readQueries();
    }

	public static void program() throws FileNotFoundException, IOException {
		Controller controller = new Controller();
		controller.readFile("transportation_network.inp");
		int choose = 0;
		Scanner scan = new Scanner(System.in);
		while (choose == 0) {
		  String query = scan.nextLine();
		  if (query.equals("1")) {
			  String query2 = scan.nextLine();
			  controller.queryRead(query2);} 
		  else if (query.equals("2")) {
			  choose = 1;} 
		}
		scan.close();
	}
}

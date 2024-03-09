import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public boolean readFile(String filename, ArrayList<String> cities, ArrayList<ArrayList<Integer>> highwayMatrix,
	ArrayList<ArrayList<Integer>> airwayMatrix, ArrayList<ArrayList<Integer>> railwayMatrix)
	throws FileNotFoundException, IOException {
	int counterForCitiesDuplicate = 0;
	try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	String line;
	while ((line = br.readLine()) != null) {
	    counterForCitiesDuplicate++;
		if (line.equals("Highway") || line.equals("Airway") || line.equals("Railway")) {
		br.readLine();
		ArrayList<ArrayList<Integer>> currentMatrix = null;
		switch (line) {
		case "Highway":
		currentMatrix = highwayMatrix;
		break;
		case "Airway":
		currentMatrix = airwayMatrix;
		break;
		case "Railway":
		currentMatrix = railwayMatrix;
		break;}

String matrixLine;
		while ((matrixLine = br.readLine()) != null && !matrixLine.isEmpty()) {
		String[] parts = matrixLine.split(" ");
		String city = parts[0];
		if (counterForCitiesDuplicate < 2)
		cities.add(city);
		ArrayList<Integer> row = new ArrayList<>();
		for (int i = 1; i < parts.length; i++) {
		row.add(Integer.parseInt(parts[i]));}
		currentMatrix.add(row);}}}}
		return false;}

public boolean writeOutput(String text) {
	try {
		FileWriter fileWriter = new FileWriter("output.txt", true);
		fileWriter.write(text);
		fileWriter.write("\n");
		fileWriter.close();
		} catch (IOException e) {
		e.printStackTrace();}
		return false;}

public boolean resetOutputFile() {
	try {
		FileWriter fileWriter = new FileWriter("output.txt", false);
		fileWriter.write("");
		fileWriter.close();
		} catch (IOException e) {
		e.printStackTrace();}
		return false;}

public ArrayList<String> readQFile(String filename) throws FileNotFoundException, IOException {
	ArrayList<String> queries = new ArrayList<>();
	try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		String line;
		while ((line = br.readLine()) != null) {
		queries.add(line);}}
		return queries;}
}

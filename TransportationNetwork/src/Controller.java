import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
	FileManager fileManager = new FileManager();
	ArrayList<ArrayList<Integer>> highwayMatrix = new ArrayList<>();
	ArrayList<ArrayList<Integer>> airwayMatrix = new ArrayList<>();
	ArrayList<ArrayList<Integer>> railwayMatrix = new ArrayList<>();
	ArrayList<String> cities = new ArrayList<String>();
	Graph gr = new Graph();

public boolean readFile(String filename) throws FileNotFoundException, IOException {
	fileManager.resetOutputFile();
	fileManager.readFile("transportation_network.inp", cities, highwayMatrix, airwayMatrix, railwayMatrix);
	gr.buildGraph(cities, highwayMatrix, airwayMatrix, railwayMatrix);
	return false;}

public boolean queryRead(String Query) {
	String[] parts = Query.split(" ");
	String queryType = parts[0];
	fileManager.writeOutput("Query " + Query);
	switch (queryType) {
	case "Q1":
	query1(parts[1], parts[2], parts[3], parts[4], parts[5]);
	break;
	case "Q2":
	query2(parts[1], parts[2], Integer.parseInt(parts[3]));
	break;
	case "Q3":
	query3(parts[1], parts[2], parts[3]);
	break;}
	return false;}

public void readQueries() throws FileNotFoundException, IOException {
	readFile("transportation_network.inp");
	ArrayList<String> result = fileManager.readQFile("query.inp");
	for (String query : result) {
	queryRead(query);}}

private void printPath(ArrayList<ArrayList<String>> allPaths) {
	String path = "";
	for (ArrayList<String> p : allPaths) {{
	path += String.join(" ", p) + "\n";}}
	System.out.println(path);
	fileManager.writeOutput(path);}

private void printFormattedPath(ArrayList<City> path, char[] tOrder, int[] iterationOrder) {
	int counter = 0;
	int segment = 0;
	String output = "";
	for (int i = 0; i < path.size() - 1; i++) {
	City city = path.get(i);
	output += city.getName();
	if (counter < iterationOrder[segment]) {
	output += " " + tOrder[segment] + " ";
	counter++;}
	if (counter == iterationOrder[segment] && segment < tOrder.length - 1) {
	segment++;
	counter = 0;}}
	output += path.get(path.size() - 1).getName() + "\n";
	System.out.println(output);
	fileManager.writeOutput(output);}

private boolean query1(String city1, String city2, String firstT, String secondT, String thirdT) {
	char[] transportationOrder = { firstT.charAt(0), secondT.charAt(0), thirdT.charAt(0) };
	int[] iterationOrder = { Character.getNumericValue(firstT.charAt(1)),
	Character.getNumericValue(secondT.charAt(1)), Character.getNumericValue(thirdT.charAt(1)) };
	ArrayList<City> path = gr.runQuery1(city1, city2, transportationOrder, iterationOrder);
	printFormattedPath(path, transportationOrder, iterationOrder);
	return false;}

private boolean query2(String city1, String city2, int cityCount) {
	ArrayList<ArrayList<String>> allPaths = gr.runQuery2(city1, city2, cityCount);
	printPath(allPaths);
	return false;}

private boolean query3(String city1, String city2, String transportationType) {
	ArrayList<ArrayList<String>> allPaths = gr.runQuery3(city1, city2, transportationType.charAt(0));
	printPath(allPaths);
	return false;}

}

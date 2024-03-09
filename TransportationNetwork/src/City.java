import java.util.ArrayList;

public class City {
	String nameCity;
	ArrayList<City> highwayNeighbors = new ArrayList<>();
	ArrayList<City> airwayNeighbors = new ArrayList<>();
	ArrayList<City> railwayNeighbors = new ArrayList<>();

public String getName() {
	return nameCity;}

public void setName(String name) {
	this.nameCity = name;}

public ArrayList<City> getHighwayNeighbors() {
	return highwayNeighbors;}

public void setHighwayNeighbors(ArrayList<City> highwayNeighbors) {
	this.highwayNeighbors = highwayNeighbors;}

public ArrayList<City> getAirwayNeighbors() {
	return airwayNeighbors;}

public void setAirwayNeighbors(ArrayList<City> airwayNeighbors) {
	this.airwayNeighbors = airwayNeighbors;}

public ArrayList<City> getRailwayNeighbors() {
	return railwayNeighbors;}

public void setRailwayNeighbors(ArrayList<City> railwayNeighbors) {
	this.railwayNeighbors = railwayNeighbors;}

public ArrayList<City> getNeighbors(char transportType) {
	switch (transportType) {
	case 'H':
	return new ArrayList<>(this.highwayNeighbors);
	case 'A':
	return new ArrayList<>(this.airwayNeighbors);
	case 'R':
	return new ArrayList<>(this.railwayNeighbors);
	default:
	return new ArrayList<>();}}
}

import java.util.*;

public class TravelingSalesman {
    static String[] cityNames = {"Dublin", "San Ramon", "Castro Valley"};
    static int numCities = cityNames.length;
    static int[][] cityDistances = new int[numCities][numCities];

    public static void main (String[] args) {

        List<Integer> citiesToVisit = new ArrayList<>(); // cities left to visit
        List<Integer> currPath = new ArrayList<>(); // current path traveled

        // initialize distances
        cityDistances[0][0] = 0; // Dublin -> Dublin
        cityDistances[0][1] = 110; // Dublin -> San Ramon
        cityDistances[0][2] = 320; // Dublin -> Castro Valley
        cityDistances[1][0] = 110; // San Ramon -> Dublin
        cityDistances[1][1] = 0; // San Ramon -> San Ramon
        cityDistances[1][2] = 420; // San Ramon -> Castro Valley
        cityDistances[2][0] = 320; // Castro Valley -> Dublin
        cityDistances[2][1] = 420; // Castro Valley -> San Ramon 
        cityDistances[2][2] = 0; // Castro Valley -> Castro Valley

        citiesToVisit.add(0); // Dublin
        citiesToVisit.add(1); // San Ramon
        citiesToVisit.add(2); // Castro Valley

        // explore different paths
        travelPaths(currPath, citiesToVisit);

    }

    static void travelPaths(List<Integer> currPath, List<Integer> citiesToVisit) {
        int distance;
        int tempCity;
        
        if (currPath.size() == numCities) {
            distance = 0;

            for (int i = 0; i < currPath.size(); i++) {
                System.out.print(cityNames[currPath.get(i)] + " ");

                if (i > 0) {
                    distance += cityDistances[currPath.get(i-1)][currPath.get(i)];
                }
            }
            
            System.out.println("= " + distance);
        }
        else {
            for (int i = 0; i < citiesToVisit.size(); i++) {
                // add city to travel path
                tempCity = citiesToVisit.get(i);
                citiesToVisit.remove(i);
                currPath.add(tempCity);

                travelPaths(currPath, citiesToVisit);

                // remove city from travel path
                citiesToVisit.add(i, tempCity);
                currPath.remove(currPath.size()-1);
            }
        }
    }
}

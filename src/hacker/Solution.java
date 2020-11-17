package hacker;
import java.util.*;
class AppRatingModel{
    int numberOfRatings;
    double avgRating;
    String appName;
    List<Integer> ratingList = new ArrayList();

}
public class Solution {

    public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
        public  Map<String,AppRatingModel> ratingMap = new HashMap<String,AppRatingModel>();

        @Override
        public void putNewRating(String app, int rating){
            if(ratingMap.containsKey(app)){
                AppRatingModel appRatingModel = ratingMap.get(app);
                appRatingModel.numberOfRatings++;
                appRatingModel.ratingList.add(rating);
                double sumOfRatings = 0;
                for(int i:  appRatingModel.ratingList){
                    System.out.println(i);
                    sumOfRatings = sumOfRatings+i;
                }

                appRatingModel.avgRating = sumOfRatings/appRatingModel.numberOfRatings;

            } else {
                AppRatingModel appRatingModel= new AppRatingModel();
                appRatingModel.appName = app;
                appRatingModel.avgRating = rating;
                appRatingModel.numberOfRatings = 1;
                appRatingModel.ratingList.add(rating);
                ratingMap.put(app,appRatingModel);
            }

        }

        @Override
        public double getAverageRating(String app){
            if(ratingMap.containsKey(app)){
                return(ratingMap.get(app).avgRating);
            } else
                return 0.0;
        }

        @Override
        public int getRatingsCount(String app){
            if(ratingMap.containsKey(app)){
                return(ratingMap.get(app).numberOfRatings);
            } else
                return 0;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface RatingStatisticsCollector {
        // Ratings feed will call this method when new app rating information is received. This is input to your class. ratings is a non negative integer between 0 to 10.
        public void putNewRating(String app, int rating);

        // Report the average rating of the app. 
        public double getAverageRating(String app);

        // Report the total number of rating for an app.
        public int getRatingsCount(String app);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
            final Set<String> apps = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String app = tokens[0];
                apps.add(app);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewRating(app, runs);

            }

            for (String app : apps) {
                System.out.println(
                        String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
            }

        }
        scanner.close();

    }
}
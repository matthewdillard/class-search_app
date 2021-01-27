import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("JHU - WSE - CS Dpt.");
        System.out.println("Spring 2021");
        System.out.println("Class Search");
        System.out.println("Enter your search query");
        String query = input.nextLine();

        search(query);
    }

    private static void search(String query) {
        final String BASE_URL = "https://sis.jhu.edu/api/classes?key=";
        final String ADVANCED_URL = "&School=Whiting%20School%20of%20Engineering&Department=EN%20Computer%20Science&CourseTitle=";
        final String KEY = System.getenv("JHU_API_KEY");

        String endpoint = BASE_URL + KEY + ADVANCED_URL + query;
        HttpResponse<JsonNode> jsonResponse = Unirest.get(endpoint).asJson();
        System.out.println(jsonResponse.getBody().toString());
    }
}

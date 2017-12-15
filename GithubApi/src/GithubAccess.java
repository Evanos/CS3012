import java.text.MessageFormat;
import java.util.Scanner;
import java.io.*;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.repos;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;



public class GithubAccess {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter username:");
		Scanner input = new Scanner (System.in);   //ask user for chosen username 
		String username = input.next();
		input.close();
		User user = getUser(username);  //send username to getUser function
		System.out.println("Information on this user:\nLogin: "
							+ user.getLogin() + "\nName: "
							+ user.getName() + "\nEmail: "
							+ user.getEmail() + "\nUser URL: "
							+ user.getUrl() + "\nFollowers: "
							+ user.getFollowers() + "\nFollowing: "
							+ user.getFollowing() + "\nPublic Repos: "
							+ user.getPublicRepos() + "\nPublic Gists: "
							+ user.getPublicGists());					
		
		System.out.println("Users repositories with creation date: ");
		repos repos = new repos();
		repos.printRepos(username); //print repositories from printRepos function
		
		String getName = user.getName();  //initialize information for draw function
		String email = user.getEmail();
		String url = user.getUrl();
		int followers = user.getFollowers();
		int following = user.getFollowing();
		int publicRepos = user.getPublicRepos();
		int publicGists = user.getPublicGists();
		draw(followers,username,following,publicRepos,publicGists,getName,email,url);
		
	}
		
	private static void draw(int followers, String username, int following, int publicRepos, int publicGists, String getName,
			String email, String url){
		
		StdDraw.picture(.5, .5, "github4.png"); //use .png for backgroud
		
		StdDraw.setPenColor(StdDraw.WHITE);   //Draw Graph A with title
		StdDraw.line(0.02,0.09, 0.445, 0.09);
		StdDraw.line(0.02,0.09, 0.02, 0.92);	
		StdDraw.setPenRadius(0.003);  
		StdDraw.line(.19, .938, .25, .938);
		StdDraw.setPenRadius();
		StdDraw.text(.2196,.95, "Graph A");
	
		
		double x = 0.0001;
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);   //Draw Rectangles where centre point moves according to growth in size
		StdDraw.filledRectangle(0.13, 0.1+(x * followers), 0.1, x * followers);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledRectangle(0.34, 0.1+(x*following), 0.1, x * following);
		StdDraw.setPenColor(StdDraw.WHITE);		//draw unfilled rectangles to act as outline
		StdDraw.setPenRadius(0.002);
		StdDraw.rectangle(0.34, 0.1+(x*following), 0.1, x * following);
		StdDraw.rectangle(0.13, 0.1+(x * followers), 0.1, x * followers);
		
		StdDraw.setPenRadius();
		StdDraw.setNumberFont();
		StdDraw.text(0.005,0.1,"0");   //draw Y-axis
		StdDraw.text(0.0005,0.2,"500");
		StdDraw.text(0.00000001,0.3,"1000");
		StdDraw.text(0.00000001,0.4,"1500");
		StdDraw.text(0.00000001,0.5,"2000");
		StdDraw.text(0.00000001,0.6,"2500");
		StdDraw.text(0.00000001,0.7,"3000");
		StdDraw.text(0.00000001,0.8,"3500");
		StdDraw.text(0.00000001,0.9,"4000");
		
		
		StdDraw.setFont();
		StdDraw.line(0.55,0.09, 0.98, 0.09);   //Draw Graph B
		StdDraw.line(0.55,0.09, 0.55, 0.72);
		StdDraw.setPenRadius(0.003);
		StdDraw.line(.7379, .738, .7979, .738);
		StdDraw.setPenRadius();
		StdDraw.text(.7675,.75,"Graph B");
		
		
		
		double y = 0.001;
		
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);  //Draw Rectangles where centre point moves according to growth in size
		StdDraw.filledRectangle(0.66, 0.1+(y*publicRepos), 0.1, y * publicRepos);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledRectangle(0.87, 0.1+(y*publicGists), 0.1, y * publicGists);
		StdDraw.setPenColor(StdDraw.WHITE);    //draw unfilled rectangles to act as outline
		StdDraw.setPenRadius(0.002);
		StdDraw.rectangle(0.66, 0.1+(y*publicRepos), 0.1, y * publicRepos);
		StdDraw.rectangle(0.87, 0.1+(y*publicGists), 0.1, y * publicGists);
		
		
		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setNumberFont();
		StdDraw.text(0.53,0.1,"0");  //Draw Y-axis
		StdDraw.text(0.53,0.2,"50");
		StdDraw.text(0.53,0.3,"100");
		StdDraw.text(0.53,0.4,"150");
		StdDraw.text(0.53,0.5,"200");
		StdDraw.text(0.53,0.6,"250");
		StdDraw.text(0.53,0.7,"300");
		
		StdDraw.setPenColor(StdDraw.WHITE);  //Draw information Rectangle
		StdDraw.rectangle(0.79, 0.92,0.25,0.12);
		
		StdDraw.setFont();
		StdDraw.text(0.13,0.05,"Followers (" +followers + ")" );   //place name throughout
		StdDraw.text(0.34,0.05,"Following (" +following + ")");
		StdDraw.text(0.66,0.05,"Public Repos (" +publicRepos + ")");
		StdDraw.text(0.87,0.05,"Public Gists (" +publicGists + ")");;
		StdDraw.textLeft(0.55,.94, "Username - " + username );
		StdDraw.textLeft(0.55,.9, "Name - " + getName);
		StdDraw.textLeft(0.55,.86, "Email - " + email);
		StdDraw.textLeft(0.55,.82,"URL - " + url);
		StdDraw.text(0.79, 1, "User Details ");
		StdDraw.setPenRadius(0.003);
		StdDraw.line(.7404, .988, .838, .988);
	
	}
	
	
	private static User getUser(String login) throws IOException{  //Get user login using user 
		UserService user = new UserService();
		return user.getUser(login);
		
	}

	public void printRepos(String username) throws IOException{  //print repositions and the date they were created
		final String format = "{0}) {1}- created on {2}";
		int count = 1;
		RepositoryService service = new RepositoryService();
		for (Repository repo : service.getRepositories(username))
			System.out.println(MessageFormat.format(format, count++,
					repo.getName(), repo.getCreatedAt()));
	}
}
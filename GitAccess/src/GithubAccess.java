import java.util.Scanner;
import java.io.*;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.UserService;



public class GithubAccess {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter username:");
		Scanner input = new Scanner (System.in);   //ask user for chosen username 
		String username = input.next();
		input.close();
		User user = getUser(username);
		System.out.println("Information on this user:\nLogin: "
							+ user.getLogin() + "\nName: "
							+ user.getName() + "\nFollowers: "
							+ user.getFollowers() + "\nFollowing: "
							+ user.getFollowing() + "\nPublic Repos: "
							+ user.getPublicRepos()); 
	}
	
	private static User getUser(String login) throws IOException{  //Get user login
		UserService user = new UserService();
		return user.getUser(login);
		
	}
}
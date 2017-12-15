package org.eclipse.egit.github.core;

import java.io.IOException;
import java.text.MessageFormat;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

public class repos {
	
	public repos(){
		
	}
	public void printRepos(String username)throws IOException {
		final String format = "{0}) {1}- created on {2}";
		int count = 1;
		RepositoryService service = new RepositoryService();
		for (Repository repo : service.getRepositories(username))
			System.out.println(MessageFormat.format(format, count++,
					repo.getName(), repo.getCreatedAt()));
	}
}

package fr.triinoxys.test;

import java.io.IOException;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterator;


public class GithubAPI{
    
    private static GHRepository repo;

    public static void main(String[] args) throws IOException{
        try{
            repo = GitHub.connectAnonymously().getUser("TriiNoxYs").getRepository("CallMe");
        }catch(IOException e){
            e.printStackTrace();
        }
        
        System.out.println("VERSIONS:");
        
        PagedIterator<GHRelease> releases = repo.listReleases().iterator();
        while(releases.hasNext()){
            String ver = releases.next().getTagName().replaceAll("v", "");
            System.out.println("- " + ver);
        }
    }
}

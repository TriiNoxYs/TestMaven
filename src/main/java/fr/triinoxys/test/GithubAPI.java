/*******************************************************************************
 * Copyright (C) 2017 TriiNoxYs
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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

//Test gpg sign with cmd line
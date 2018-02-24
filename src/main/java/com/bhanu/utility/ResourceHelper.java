
package com.bhanu.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class ResourceHelper {

	/**
	 * This method will return resource path
	 * @param resource
	 * @return
	 */
	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}
	
	/**
	 * This method will return project location
	 * irrespective of driver location
	 * @return
	 */
	public static String getBaseResourcePath() {
		// user.dir will give us project location
		//Users/bsingh5/git/excel-tutorial-with-dataDrivenFramework
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(ResourceHelper.getResourcePath(path));
	}

}

package getProcessId;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws Exception {
       
        
        Properties prop = System.getProperties();

        String os = prop.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("linux") > -1) {
        	 System.out.println("Yes, it is linux!");
        	 Process process = Runtime.getRuntime().exec(  
	                 new String[] { "dmidecode","-t", "4", "|", "grep", "ID"});  
	         process.getOutputStream().close();  
	         Scanner sc = new Scanner(process.getInputStream());
	         String property = sc.next();
	         String serial = sc.next();
	         System.out.println(property + ": " + serial);
	         System.out.println("length" + ": " + serial.length());
        } else {
        	 System.out.println("No, it is windows!");
        	 
	    	 Process process = Runtime.getRuntime().exec(  
	                 new String[] { "wmic", "cpu", "get", "ProcessorId" });  
	         process.getOutputStream().close();  
	         Scanner sc = new Scanner(process.getInputStream());
	         String property = sc.next();
	         String serial = sc.next();
	         System.out.println(property + ": " + serial);
	         System.out.println("length" + ": " + serial.length());
	         
        }
	}
}

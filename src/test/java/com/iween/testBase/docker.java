package com.iween.testBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class docker 
{
	@BeforeTest
public void startDockerGrid() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec("cmd /c start start-dockergrid.bat");
    Thread.sleep(60000);
//		Process p = Runtime.getRuntime().exec("cmd /c start-dockergrid.bat");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//
//		String line;
//		while ((line = reader.readLine()) != null) {
//		    System.out.println(line);
//		}
//		while ((line = errorReader.readLine()) != null) {
//		    System.err.println(line);
//		}
//		int exitCode = p.waitFor();
//		if(exitCode != 0){
//		    throw new RuntimeException("start-dockergrid.bat failed with exit code " + exitCode);
//		}


}
@AfterTest
public void stopDockerGrid() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec("cmd /c start stop-dockergrid.bat");
    Thread.sleep(5000);	
    Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
//	Process p = Runtime.getRuntime().exec("cmd /c stop-dockergrid.bat");
//	BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//	BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//
//	String line;
//	while ((line = reader.readLine()) != null) {
//	    System.out.println(line);
//	}
//	while ((line = errorReader.readLine()) != null) {
//	    System.err.println(line);
//	}
//	int exitCode = p.waitFor();
//	if(exitCode != 0){
//	    throw new RuntimeException("stop-dockergrid.bat failed with exit code " + exitCode);
//	}



}
}

package com.qf.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTool {
	static public String getFileStr(String path) throws IOException {
		
        File file = new File(path);
        
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));   	
        StringBuilder sb = new StringBuilder(); 
        String s = "";
        while ((s =bReader.readLine()) != null) {  
            sb.append(s + "\n");
        }
        bReader.close();
        String str = sb.toString();	
		return str;
	}
	
}

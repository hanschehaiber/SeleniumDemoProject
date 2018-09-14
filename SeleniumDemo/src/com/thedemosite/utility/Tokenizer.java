package com.thedemosite.utility;

import java.util.ArrayList;
/*
 * This class provides an algorithm I developed to tokenize a string
 */
public class Tokenizer {
	public ArrayList<String> tokenizeString(String str){
		
		 //Tokenize the string
		str = str.replace(System.getProperty("line.separator"), " ");
        ArrayList<String> strList = new ArrayList<String>();
		String word = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '|| ((int)str.charAt(i) == 10)){
                word += String.valueOf(str.charAt(i));
            } else {
                strList.add(word);
                word = "";
            }
            if(i == str.length()-1){
                strList.add(word);
            }
            
        }
		return strList;
	}
}

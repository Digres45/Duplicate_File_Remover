/*PROGRAM TO DELETE DUPLICATION OF FILES WITH IN SPECIFIC DIRECTORY FOR WINDOWS */

import java.io.*;
import java.util.ArrayList;

class DuplicateRemover{
	File f;
	File[] files;
	String fname;
	ArrayList<String> fileNames = new ArrayList<String>(); 
	
	//REMOVING "COPY" FROM FILE NAME
	String getFname(String str){
		int index;
		int lastindex;
		
		if((index = str.lastIndexOf(" - Copy")) == -1){
			index= str.lastIndexOf(".");
		}else{
			index = str.lastIndexOf(" - Copy");
		}
		
		lastindex = str.lastIndexOf(".");
		str = str.substring(0,index)+str.substring(lastindex);
		
		return str;
	}
	
	void remove(){
		f = new File("PATH_OF_FILE_WITH");
		files = f.listFiles();
		String fname1,fname2;	// DECLARING TWO FILE NAMES
		long size1,size2;
		
		for(int i=0;i<files.length;i++){
			
			//SCANNING FILES IN GIVEN DIRECTORY
			
			if(files[i].isFile()){
				//System.out.println(files[i].getName()+"  is File  Size is : "+files[i].length()+" bytes");
				fileNames.add(files[i].toString());
			}
		}

		for(int i=0;i<fileNames.size()-1;i++){
			fname1 = getFname(fileNames.get(i));
			size1 = files[i].length();
			
			fname2 =getFname(fileNames.get(i+1));
			
			
			//CHECK WHETHER ADJACENT FILES HAVING SAME AND SIZE OR NOT
			
			if(fname1.equals(fname2)){
				for(int j=i+1;j<fileNames.size();j++){
					size2 = files[j].length();
					fname2 =getFname(fileNames.get(j));
					if(!fname1.equals(fname2)){
						break;
					}
					if((size1 == size2) && fname1.equals(fname2)){
						System.out.println(fileNames.get(i)+" and "+fileNames.get(j)+"  are same!! Delete them..");
						
				
						// CHEAKING WHETHER FILE EXISTS OR NOT
						
						/*if(new File(fileNames.get(i)).exists()){
							
							System.out.println("The file exists"); 
						}
						else{
							System.out.println("The file does not exists"); 
						}*/
						
						
						//DELETING A DUPLICATE FILE
						
						boolean success = (new File(fileNames.get(i))).delete();
						if (success) {
				            System.out.println("The file has been successfully deleted"); 
				            
				         }
						else{
							System.out.println("The file cannot be deleted");
						}
						
						
					}
					
				}
			}
						
		}
		
	}
}

public class Duplicate_File_Remover {

	public static void main(String[] args) {
		
		DuplicateRemover dr = new DuplicateRemover();
		dr.remove();
	}

}

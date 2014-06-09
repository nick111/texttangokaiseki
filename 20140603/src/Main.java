

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		String fileAddress = "out.txt";
		String allOutAddress = "allOut.txt";
		String nounOutAddress = "nounOut.txt";
		String verbOutAddress = "verbOut.txt";
		String adjectiveOutAddress = "adjectiveOut.txt";
		
		  
		  HashMap<String,Integer> mapAll = new HashMap<String,Integer>();
		  HashMap<String,Integer> mapNoun = new HashMap<String,Integer>();
		  HashMap<String,Integer> mapVerb = new HashMap<String,Integer>();
		  HashMap<String,Integer> mapAdjective = new HashMap<String,Integer>();

		  
		  try {
			  FileInputStream fis = new FileInputStream(fileAddress); 
			  InputStreamReader in = new InputStreamReader(fis,"EUC-JP"); 
			  BufferedReader br = new BufferedReader(in);
			String oneLineStr;
			while((oneLineStr = br.readLine()) != null){
				String[] txtbytab = oneLineStr.split("\t");
				if(txtbytab.length < 2) continue;
				String key = txtbytab[0];
				String[] vlist = txtbytab[1].split(",");
				
				Integer numAll = mapAll.get(key);
				
				
				if(vlist[0].equals("–¼ŽŒ")){
					Integer numNoun = mapNoun.get(key);
					if(numNoun == null){
						mapNoun.put(key, 1);
						mapAll.put(key, 1);
					}else{
						mapNoun.put(key, numNoun + 1);
						mapAll.put(key, numAll + 1);
					}
				}else if(vlist[0].equals("“®ŽŒ")){
					Integer numVerb = mapVerb.get(key);
					if(numVerb == null){
						mapVerb.put(key, 1);
						mapAll.put(key, 1);
					}else{
						mapVerb.put(key, numVerb + 1);
						mapAll.put(key, numAll + 1);
					}
				}else if(vlist[0].equals("Œ`—eŽŒ")){
					Integer numAdjective = mapAdjective.get(key);
					if(numAdjective == null){
						mapAdjective.put(key, 1);
						mapAll.put(key, 1);
					}else{
						mapAdjective.put(key, numAdjective + 1);
						mapAll.put(key, numAll + 1);
					}
				}	
			}
			
			writeFileWithSorting(mapAll, allOutAddress, 30);
			writeFileWithSorting(mapNoun, nounOutAddress, 30);
			writeFileWithSorting(mapVerb, verbOutAddress, 30);
			writeFileWithSorting(mapAdjective, adjectiveOutAddress, 30);
			

		  } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private static boolean checkBeforeWritefile(File file){
		if (file.exists()){
			if (file.isFile() && file.canWrite()){
				return true;
				}
			}
		return false;
		}

	public static void writeFileWithSorting(HashMap<String,Integer> map, String outFileName, int leastNum){
		
		List<Map.Entry<String, Integer>> entries = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				Map.Entry<String, Integer> entry1 = (Map.Entry<String, Integer>) o1;
				Map.Entry<String, Integer> entry2 = (Map.Entry<String, Integer>) o2;
				Integer int1 = (Integer) entry1.getValue();
				Integer int2 = (Integer) entry2.getValue();
				return int2 - int1;
			}
		});
		
		File file = new File(outFileName);
		  
		int k = 0;
		
		  try {
			  if (!checkBeforeWritefile(file)){
				  FileOutputStream fos = new FileOutputStream(outFileName); 
				  OutputStreamWriter out = new OutputStreamWriter(fos,"EUC-JP"); 
				  BufferedWriter bw = new BufferedWriter(out);
				  
				  for (Map.Entry<String, Integer> entry : entries) {
					  if(k <= leastNum){
						  bw.write(entry.getKey() + " " + entry.getValue());
						  bw.newLine();
						  k++;
					  }else{
						  break;
					  }
				  }
				  
				  bw.close();
				  
			}
		  }catch (IOException e) {
			  e.printStackTrace();
			  }
		
	}
	
	
}



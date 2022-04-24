package compulsory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public List<String> wordsList=new ArrayList<>();
    public boolean isWord(String str) {
        try{
            for(int i=0;i<wordsList.size();i++){
                if(wordsList.get(i).compareTo(str)==0){
                    return true;
                }
            }
        }catch (NullPointerException e){
            return false;
        }
        return false;
    }
    public void populateList(){
        BufferedReader reader;
        try{
            reader=new BufferedReader(
                    new FileReader(
                            "src\\compulsory\\words.txt"
                    ));
            String word=reader.readLine();
            wordsList.add(word);
            while(word != null){
                word=reader.readLine();
                wordsList.add(word);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


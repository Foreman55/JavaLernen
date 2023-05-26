package de.willi.text_to_vocabulary_trainer.literature;

import de.willi.text_to_vocabulary_trainer.literature.beans.UniqueWord;

public class WordCount {

    public WordsResult countWord(String [] textArray){
        WordsResult wordsResult = new WordsResult();
        int wordCount= 1;
        for(int i=0;i<textArray.length;i++)
        {
            for(int j=i+1;j<textArray.length;j++)
            {
                if(textArray[i].equals(textArray[j]))
                {
                    wordCount=wordCount+1;
                    textArray[j]="0";
                }
            }
            if(textArray[i]!="0") {
                //System.out.println(textArray[i] + "--" + wordCount);
                UniqueWord uniqueWord = new UniqueWord();
                uniqueWord.setUniqueName(textArray[i]);
                uniqueWord.setWordFrequency(wordCount);
                wordsResult.addUniqueWord(uniqueWord);
            }
            wordCount=1;
        }
        return wordsResult;
    }
}

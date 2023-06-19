package de.willi.text_to_vocabulary_trainer.bucket.beans;

import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCards;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bucket {


    private List<Vocabulary> vocabularyList;
    private static Bucket bucket;

    private Bucket() {
        this.vocabularyList = new ArrayList<>();
        readVocabulary();
    }

    public static Bucket getInstance() {
        if (bucket == null){
            bucket = new Bucket();
        }
        return bucket;
    }

    public List<Vocabulary> getVocabularyList() {
        return vocabularyList;
    }

    public void setVocabularyList(List<Vocabulary> vocabularyList) {
        this.vocabularyList = vocabularyList;
    }
    
    public void save(String word){
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWord(word);
        vocabularyList.add(vocabulary);
        saveVocabulary();
    }

    public void unsave(String word)  {
        for(Vocabulary voc: vocabularyList){
            if(voc.getWord().equals(word)){
                vocabularyList.remove(voc);
            }
        }
        saveVocabulary();
    }

    private void saveVocabulary()  {
        try {
            File file = new File("/Users/williamhall/IdeaProjects/JavaLernen/wordLists/vokabel.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            for (Vocabulary vc : vocabularyList) {
                bf.write(vc.getWord() + "," + vc.getTranslation() + "\n");

            }
            bf.flush();
            bf.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readVocabulary()  {
        try {
            this.vocabularyList = new ArrayList<>();
            File file = new File("/Users/williamhall/IdeaProjects/JavaLernen/wordLists/vokabel.txt");
            if (file.exists()) {
                BufferedReader bf = new BufferedReader(new FileReader(file));
                while (true) {
                    String line = bf.readLine();
                    if (line == null || line.isEmpty()) break;
                    String[] col = line.split(",");
                    String word = col[0];
                    String translation = col[1];
                    Vocabulary vocabulary = new Vocabulary();
                    vocabulary.setWord(word);
                    vocabulary.setTranslation(translation);
                    this.vocabularyList.add(vocabulary);
                }
            } else {
                file.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

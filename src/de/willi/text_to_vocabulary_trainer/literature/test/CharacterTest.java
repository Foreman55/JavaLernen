package de.willi.text_to_vocabulary_trainer.literature.test;

import de.willi.text_to_vocabulary_trainer.literature.beans.IndividualCharacter;
import de.willi.text_to_vocabulary_trainer.literature.service.LituratureService;

import java.util.List;

public class CharacterTest {
    public static void main(String[] args) {
        char [] test = {'a' ,'a' ,'b' , 'c' , 'd' , 'e' , 'e' , 'e'};
        LituratureService lituratureService =  LituratureService.getInstance();
        List<IndividualCharacter> indChar = lituratureService.frecuencyCharBuilder(test);
        for(IndividualCharacter i: indChar){
            System.out.println(i.getCharFrequency() + " = " + i.getIndividualCharacter());

        }
    }
}

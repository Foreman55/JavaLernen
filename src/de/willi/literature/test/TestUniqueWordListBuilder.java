package de.willi.literature.test;

import de.willi.literature.service.LituratureService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUniqueWordListBuilder {
    public static void main(String[] args) {
        String [] list = {"c","c","a", "b","a","b", "z","y","t","g"};

        LituratureService service = LituratureService.getInstance();
        List<String> hi =service.uniqueWordListBuilder(list);
        System.out.println("list"+ hi);

    }
}

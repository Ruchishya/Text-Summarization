/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Home
 */
public class Features {

    private static Integer maxLength;
	private static HashSet<String> ss;
	private static HashSet<String> ss2;
	private static ArrayList<String> tlst;

    public static Double titleFeature(ArrayList<String> s, ArrayList<String> t) {
        ss2 = new HashSet<>();
        Integer fc = 0;
        Integer sz = t.size();
        for (String term: s) {
            if (t.indexOf(term) >= 0) {
                fc++;
            }
        }
        return fc.doubleValue() / sz.doubleValue();
    }

    public static Double similarity(ArrayList<String> s1, ArrayList<String> s2) {
        ss = new HashSet<>();
        Integer fc = 0;
        Integer sz = s2.size();
        for (String term : s1) {
            if (s2.indexOf(term) >= 0) {
                fc++;
            }
        }
        return fc.doubleValue() / sz.doubleValue();
    }

    public static void findMaxlength(ArrayList<ArrayList<String>> sentances) {
        maxLength = 0;
        for (ArrayList<String> s : sentances) {
            if (s.size() > maxLength) {
                maxLength = s.size();
            }
        }
    }

    public static Double findSentanceLength(Integer size) {
        return size.doubleValue() / maxLength.doubleValue();
    }

    public static HashMap<String, Double> findTermWeight(HashSet<String> allTerms, ArrayList<ArrayList<String>> sentances) {
        HashMap<String, Double> tweights = new HashMap<>();
        for (String term : allTerms) {
            Double tr = 0.0D;
            Double sr = 0.0D;
            for (ArrayList<String> s : sentances) {
                boolean found = false;
                for (String t : s) {
                    if (t.trim().equalsIgnoreCase(term.trim())) {
                        tr++;
                        found = true;

                    }
                  //  System.out.println(term + " : " + t);
                }
                if (found) {
                    sr++;
                }

            }

          //  System.out.println("Term Weight of " + term + " is " + tr * Math.log((double) sentances.size() / sr));
            tweights.put(term, tr * Math.log((double) sentances.size() / sr));
        }
        return tweights;
    }

    public static ArrayList<String> findThematicWords(HashMap<String, Double> tfMap, Integer tt) {
        ArrayList<String> lst = new ArrayList<>();
        tlst = new ArrayList<>();
        HashMap<String, Double> tfm = new HashMap<>();
        tfm.putAll(tfMap);
        for (int i = 0; i < tt; i++) {
            Double tf = 0.0D;
            String key = "";
            
            for (String k : tfm.keySet()) {
                 if(lst.contains(k)) continue;
                if (tfm.get(k) > tf) {
                    tf = tfm.get(k);
                    key = k;
                }
            }
            
            lst.add(key);
            tfm.remove(key);
        }
        System.out.println("Thematic Words: "+lst);
        return lst;
    }
    public static Double findProperNounScore(ArrayList<String> s) {
        Double nc=0.0D;
        for(String t:s){
           if(NounFinder.isNoun(t))nc++;
        }
        return nc/(double)s.size();
    }
}

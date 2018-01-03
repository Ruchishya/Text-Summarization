/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author welly
 */
public class NounFinder {

    public static boolean isNoun(String ip) {
        System.setProperty("wordnet.database.dir", "C:/WordNet/dict/");
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] res = database.getSynsets(ip, SynsetType.NOUN);
//        HashSet<String> syns = new HashSet<String>();
//        for (Synset s : res) {
//
//            syns.addAll(Arrays.asList(s.getWordForms()));
//        }
//        Object[] fin = syns.toArray();
//        String temp;
//        for (Object o : fin) {
//            temp = (String) o;
//            if (temp.indexOf(" ") >= 0) {
//                syns.remove(temp);
//            }
//        }
//        String[] fres = null;
//        fin = syns.toArray();
//        if (fin != null && fin.length > 0) {
//            System.out.println(Arrays.toString(fin));
//        }
//        return fin;
        //   }
        return res.length > 0;
    }
}

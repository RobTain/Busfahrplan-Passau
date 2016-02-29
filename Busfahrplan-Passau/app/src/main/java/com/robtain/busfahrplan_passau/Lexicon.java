package com.robtain.busfahrplan_passau;
import android.util.Log;

import java.util.LinkedList;

/**
 * Created by RobTain on 27.01.2016.
 */
public class Lexicon {
    LinkedList lexicon = new LinkedList();


    public Lexicon() {
        setLexicon();

    }

    /**
     * search lexicon for searched entry
     *
     * @param searchword entered input
     */
    public LexiconEntry findEntry(String searchword) {
        Object o = new Object();
        LexiconEntry lexiconEntry = null;
        String[] entries;
        boolean foundEntry = false;

        for (int i = 0; i < lexicon.size(); i++) {
            o = lexicon.get(i);
            lexiconEntry = (LexiconEntry) o;
            entries = lexiconEntry.getKeywords();
            for (int j = 0; j < entries.length; j++) {

                if (entries[j].toLowerCase().contains(searchword)) {
                    foundEntry = true;
                    break;
                }
            }
            if (foundEntry) {
                break;
            }
        }

        if (!foundEntry) {
            lexiconEntry = null;
        }
        return lexiconEntry;
    }


    /**
     * creating sublist with selected entries by topic keyword
     *
     * @param e Topic enum
     * @return found entries
     */
    public LinkedList getSublist(Enum e) {
        LinkedList sublexicon = new LinkedList();
        String[] values;
        LexiconEntry lexiconEntry;
        Object o = new Object();
        for (int i = 0; i < lexicon.size(); i++) {
            o = lexicon.get(i);
            lexiconEntry = (LexiconEntry) o;
            if (lexiconEntry.getTopic().equals(e)) {

                sublexicon.add(lexiconEntry);
            }
        }
        return sublexicon;
    }

    public LinkedList getLexicon() {
        return lexicon;
    }

    /**
     * filling entries into the lexicon
     */
    private void setLexicon() {
        /**
         * -----------------------------------------------------------------
         * Mathematics Entries
         * -----------------------------------------------------------------
         */

        String[] keywords = {"Grundrechenarten","Addition", "Multiplikation",
                "Subtraktion", "Division","subtrahieren", "addieren",
                "multiplizieren","dividieren"};
        LexiconEntry entry = new LexiconEntry("Grundrechenarten",
                "grundrechenarten",
                false,
                keywords, Topic.Math);
        lexicon.add(entry);
        keywords = new String[]{"Titanic"};
        entry = new LexiconEntry("Hans", "warning", false, keywords, Topic
                .Chemistry);
        lexicon.add(entry);

    }


}

package project;



	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */

	import features.Features;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

	import javax.swing.JFileChooser;

	import textprocess.Stemmer;
import textprocess.Stopwords;

	/**
	 *
	 * @author Home
	 */
	public class Trygsm extends javax.swing.JFrame {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private File inputFile;
	    private ArrayList<ArrayList<String>> sentances;
	    private String docTitle;
	    private ArrayList<String> ttl;
	    private ArrayList<Double> titleFeatures;
	    private ArrayList<Double> sentanceLengths;
	    private HashSet<String> allTerms;
	    private HashMap<String, Double> tfMap;
	    private ArrayList<Double> stermWeights;
	    private ArrayList<Double> termWeights;
	    private ArrayList<Double> sentancePositions;
	    private static String[] lines;
	    private ArrayList<Double> s2sSimilarity;
	    private int thematicThreshold;
	    private ArrayList<Double> thematicWords;
	    private ArrayList<Double> numaricData;
	    private ArrayList<Double> properNouns;

	    /**
	     * Creates new form TextSummarizationByFuzzyGenetic
	     */
	    public Trygsm() {
	        initComponents();
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel2 = new javax.swing.JLabel();
	        jTextField2 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();
	        jLabel3 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setText("Title of The Document:");

	        jTextField1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField1ActionPerformed(evt);
	            }
	        });

	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	        jLabel2.setText("Document:");

	        jButton1.setText("Browse");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jButton2.setText("Preprocessing");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Feature Extraction");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton4.setText("Apply Fuzzy");
	        
	        

	        jButton5.setText("apply GA");

	        jLabel3.setText("thematic Threshold:");

	        jTextField3.setText("10");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jButton2)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jTextField1)
	                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel3)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(63, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton1))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton2)
	                    .addComponent(jButton3)
	                    .addComponent(jButton4)
	                    .addComponent(jButton5))
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
	        // TODO add your handling code here:
	    }//GEN-LAST:event_jTextField1ActionPerformed

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        JFileChooser jfc = new JFileChooser(new File("./"));
	        String[] ftypes = {"txt", "dat"};
	        jfc.setFileFilter(new ACFiles(ftypes));
	        //jfc.showOpenDialog(this);
	        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	            inputFile = jfc.getSelectedFile();
	            jTextArea1.setText("File to be Summarize " + inputFile.getAbsolutePath() + " loaded successfully..\n");
	            jTextField2.setText(inputFile.getAbsolutePath());
	            //  jButton1.setEnabled(false);
	            jButton2.setEnabled(true);

	        }
	    }//GEN-LAST:event_jButton1ActionPerformed

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

	        docTitle = jTextField1.getText().trim().toLowerCase();
	        FileInputStream fis = null;
	        sentances = new ArrayList<>();
	        try {
	            fis = new FileInputStream(inputFile);
	            byte[] bytes = new byte[fis.available()];
	            fis.read(bytes);
	            String data = new String(bytes);
	            data = data.trim().toLowerCase();

	            lines = data.split("\\.[ \r\n\t^0-9]");
	            // lines = data.split("(?i)(?<=[.?!])\\S+(?=[a-z])");

	            for (String line : lines) {
	                System.out.println(line);
	            }

	            Stopwords sw = new Stopwords();
	            ttl = Stemmer.stem(sw.removeStopwords(docTitle.trim()));
	           // ttl = sw.removeStopwords(docTitle.trim());
	            System.out.println("Processed title");
	            jTextArea1.append("\nProcessed title");
	            System.out.println("\t" + ttl);
	            jTextArea1.append("\n\t" + ttl);

	            for (String line : lines) {
//	                String[] tokens = line.trim().split("[ \t]");
	                sentances.add(Stemmer.stem(sw.removeStopwords(line)));
	              //  sentances.add((sw.removeStopwords(line)));

	            }
	            System.out.println("Processed sentences");
	            jTextArea1.append("\nProcessed sentences");
	            for (ArrayList<String> sentance : sentances) {
	                System.out.println("\t" + sentance);
	                jTextArea1.append("\n\t" + sentance);

	            }
	            jTextArea1.append("\n");

	            /**
	             * @param args the command line arguments / * @param args the
	             * command line arguments
	             */
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                fis.close();
	            } catch (IOException ex) {
	                Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }//GEN-LAST:event_jButton2ActionPerformed

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed	     
	    	titleFeatures = new ArrayList<>();
	        for (ArrayList<String> s : sentances) {
	            titleFeatures.add(Features.titleFeature(s, ttl));
	        }
	        jTextArea1.append("\n");
	        Features.findMaxlength(sentances);
	        sentanceLengths = new ArrayList<>();
	        for (ArrayList<String> s : sentances) {
	            sentanceLengths.add(Features.findSentanceLength(s.size()));
	        }
	        allTerms = new HashSet<String>();
	        for (ArrayList<String> s : sentances) {
	            allTerms.addAll(s);
	        }
	        tfMap = new HashMap<>();
	       
	        tfMap = Features.findTermWeight(allTerms, sentances);
	        stermWeights = new ArrayList<>();
	        Double mstw = 0.0D;
	        for (ArrayList<String> s : sentances) {
	            Double stw = 0.0D;
	            for (String t : s) {
	                stw += tfMap.get(t);
	            }
	            stermWeights.add(stw);
	            if (stw > mstw) {
	                mstw = stw;
	            }
	        }
	        termWeights = new ArrayList<>();
	        sentancePositions = new ArrayList<>();
	        Integer sz = sentances.size();
	        for (Integer i = 0; i < sz; i++) {
	            sentancePositions.add((sz.doubleValue() - i.doubleValue()) / sz.doubleValue());
	        }
	        s2sSimilarity = new ArrayList<>();
	        for (int i = 0; i < sentances.size(); i++) {
	            Double sss = 0.0D;
	            for (int j = 0; j < sentances.size(); j++) {
	                if (i != j) {
	                    sss += Features.similarity(sentances.get(i), sentances.get(j));

	                }
	            }
	            s2sSimilarity.add(sss / sz.doubleValue());
	        }
	        
	        ArrayList<String> tlst;
	        thematicThreshold = Integer.parseInt(jTextField3.getText().trim());
	        thematicWords = new ArrayList<>();
	        numaricData=new ArrayList<>();
	        tlst = Features.findThematicWords(tfMap, thematicThreshold);
	        for (ArrayList<String> s : sentances) {
	            thematicWords.add(Features.similarity(s, tlst));
	        }
	        for (ArrayList<String> s : sentances) {
	            Integer nc = 0;
	            for (String t : s) {
	                if (t.matches("[0-9\\.]+")) {
	                    nc++;
	                }
	            }
	            jTextArea1.append("\n"); 
		        properNouns=new ArrayList<>();
		        for(ArrayList<String> s1:sentances){
		            properNouns.add(Features.findProperNounScore(s1));
		        }
		        
	        System.out.println("Title feature: \tSentence Length \t term frequiences \t termweight \t sentence position \t senentenceto sentence similarity  \t thematicword \t numeric data \t proper noun  ");
	        jTextArea1.append("\nTitle feature: \tSentence Length \t term frequiences \t termweight \t sentence position \t senentenceto sentence similarity  \t thematicword \t numeric data \t proper noun ");
	        int idx = 1;
	        for (Double tf : titleFeatures) {
	            System.out.println("sentence " + idx + ": " + tf);
	            jTextArea1.append("\nsentence " + idx + ": " + tf);  
	            idx++;
	           
	        }
	      /*  jTextArea1.append("\n");
	        Features.findMaxlength(sentances);
	        sentanceLengths = new ArrayList<>();
	        for (ArrayList<String> s : sentances) {
	            sentanceLengths.add(Features.findSentanceLength(s.size()));
	        }
	        System.out.println("Sentence Length:");
	        jTextArea1.append("\nSentence Length:");
	        idx = 1;*/
	        for (Double sl : sentanceLengths) {
	            System.out.println("sentence " + idx + ": " + sl);
	            jTextArea1.append("\nsentence " + idx + ": " + sl);
	            idx++;
	        }
	      /*  jTextArea1.append("\n");
	        allTerms = new HashSet<String>();
	        for (ArrayList<String> s : sentances) {
	            allTerms.addAll(s);
	        }
	        tfMap = new HashMap<>();
	       
	        tfMap = Features.findTermWeight(allTerms, sentances);*/
	        System.out.println("Term Frequencies:");
	        jTextArea1.append("\nTerm Frequencies:");
	         for (String key : tfMap.keySet()) {
	            System.out.println(key + ": " + tfMap.get(key));
	            jTextArea1.append("\n" + key + ": " + tfMap.get(key));
	        }
	        jTextArea1.append("\n");
	        
	   /*     stermWeights = new ArrayList<>();
	        Double mstw = 0.0D;
	        for (ArrayList<String> s : sentances) {
	            Double stw = 0.0D;
	            for (String t : s) {
	                stw += tfMap.get(t);
	            }
	            stermWeights.add(stw);
	            if (stw > mstw) {
	                mstw = stw;
	            }
	        }
	        termWeights = new ArrayList<>();
*/
	        for (Double sw : stermWeights) {
	            termWeights.add(sw / mstw);
	        }
	        System.out.println("Term Weights:");
	        jTextArea1.append("\nTerm Weights:");
	        idx = 1;
	        for (Double tw : termWeights) {
	            System.out.println("sentence " + idx + ": " + tw);
	            jTextArea1.append("\nsentence " + idx + ": " + tw);
	            idx++;
	        }
	        jTextArea1.append("\n");
	        sentancePositions = new ArrayList<>();
	       /* Integer sz = sentances.size();
	        for (Integer i = 0; i < sz; i++) {
	            sentancePositions.add((sz.doubleValue() - i.doubleValue()) / sz.doubleValue());
	        }*/
	        
	         System.out.println("Sentance Position:");
	        jTextArea1.append("\nSentance Position:");
	        idx = 1;
	        for (Double sp : sentancePositions) {
	            System.out.println("sentence " + idx + ": " + sp);
	            jTextArea1.append("\nsentence " + idx + ": " + sp);
	            idx++;
	        }
	        jTextArea1.append("\n");
	        
	      /*  s2sSimilarity = new ArrayList<>();
	        for (int i = 0; i < sentances.size(); i++) {
	            Double sss = 0.0D;
	            for (int j = 0; j < sentances.size(); j++) {
	                if (i != j) {
	                    sss += Features.similarity(sentances.get(i), sentances.get(j));

	                }
	            }
	            s2sSimilarity.add(sss / sz.doubleValue());
	        }*/
	         System.out.println("Sentance To Sentance Similarity:");
	        jTextArea1.append("\nSentance To Sentance Similarity:");
	         idx = 1;
	        for (Double sp : s2sSimilarity) {
	            System.out.println("sentence " + idx + ": " + sp);
	            jTextArea1.append("\nsentence " + idx + ": " + sp);
	            idx++;
	        }
	        jTextArea1.append("\n");
	        
	       /* ArrayList<String> tlst;
	        thematicThreshold = Integer.parseInt(jTextField3.getText().trim());
	        thematicWords = new ArrayList<>();
	        numaricData=new ArrayList<>();
	        tlst = Features.findThematicWords(tfMap, thematicThreshold);
	        for (ArrayList<String> s : sentances) {
	            thematicWords.add(Features.similarity(s, tlst));
	        }
	        for (ArrayList<String> s : sentances) {
	            Integer nc = 0;
	            for (String t : s) {
	                if (t.matches("[0-9\\.]+")) {
	                    nc++;
	                }
	            }*/
	            numaricData.add(nc.doubleValue() / (double) s.size());
	        }
	       System.out.println("Thematic Word:");
	        jTextArea1.append("\nThematic Word:");
	        int idx = 1;
	        for (Double sp : thematicWords) {
	            System.out.println("sentence " + idx + ": " + sp);
	            jTextArea1.append("\nsentence " + idx + ": " + sp);
	            idx++;
	        }
	        jTextArea1.append("\n"); 
	        
	        System.out.println("Numaric Data:");
	        jTextArea1.append("\nNumaric Data:");
	         idx = 1;
	        for (Double sp : numaricData) {
	            System.out.println("sentence " + idx + ": " + sp);
	            jTextArea1.append("\nsentence " + idx + ": " + sp);
	            idx++;
	        }
	       /* jTextArea1.append("\n"); 
	        properNouns=new ArrayList<>();
	        for(ArrayList<String> s:sentances){
	            properNouns.add(Features.findProperNounScore(s));
	        }
	        */
	        System.out.println("Proper Noun Score:");
	        jTextArea1.append("\nProper Noun Score:");
	         idx = 1;
	        for (Double sp : properNouns) {
	            System.out.println("sentence " + idx + ": " + sp);
	            jTextArea1.append("\nsentence " + idx + ": " + sp);
	            idx++;
	        }
	        jTextArea1.append("\n");
	       


	    }//GEN-LAST:event_jButton3ActionPerformed

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(TextSummarizationByFuzzyGenetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new TextSummarizationByFuzzyGenetic().setVisible(true);
	            }
	        });
	       
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    // End of variables declaration//GEN-END:variables
	}

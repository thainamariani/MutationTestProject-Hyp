/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import experiment.HyperHeuristicType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import util.ManageResults;
import static util.ManageResults.calculateKruskalWallisForAlgorithms;
import static util.ManageResults.calculatePFTrue;

/**
 *
 * @author Prado Lima
 */
public class HyperHeuristicsResults {

    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {
        int numberOfObjectives = 2;
        int numberOfExecutions = 30;        
        
        ManageResults manageResults = new ManageResults();
        List<String> instances = new ArrayList<>();
        
        instances.add("fourballs");
        instances.add("guizzo_cas");
        instances.add("guizzo_james");
        instances.add("guizzo_save");
        instances.add("guizzo_weatherstation");
        instances.add("mid");
        instances.add("trityp");

        List<String> algorithms = new ArrayList<>();
<<<<<<< HEAD
        algorithms.add(HyperHeuristicType.HHIBEA.toString());
        algorithms.add("IBEA");
        algorithms.add("R-HHIBEA");

//        algorithms.add(HyperHeuristicType.HHNSGAIII.toString());
//        algorithms.add("NSGAIII");
//        algorithms.add("R-HHNSGAIII");

        //manageResults.calculateHypervolumeResults(instances, algorithms, numberOfObjectives, numberOfExecutions);
        //calculateKruskalWallisForTuning(instances, algorithms, numberOfExecutions);
        //calculateKruskalWallisForAlgorithms(instances, algorithms, numberOfExecutions);
        calculatePFTrue(instances, algorithms);
=======
        
        algorithms.add(HyperHeuristicType.HHNSGAII.toString());
        algorithms.add("NSGAII");
        algorithms.add("R-HHNSGAII");
                       
        //manageResults.calculateHypervolumeResults(instances, algorithms, numberOfObjectives, numberOfExecutions);
        //manageResults.calculateKruskalWallisForTuning(instances, algorithms, numberOfExecutions);
        //manageResults.calculateKruskalWallisForAlgorithms(instances, algorithms, numberOfExecutions);
        //manageResults.calculatePFTrue(instances, algorithms);
        
        algorithms = new ArrayList<>();
        
        algorithms.add(HyperHeuristicType.HHSPEA2.toString());
        algorithms.add("SPEA2");
        algorithms.add("R-HHSPEA2");
                        
        //manageResults.calculateKruskalWallisForAlgorithms(instances, algorithms, numberOfExecutions);
        manageResults.calculatePFTrue(instances, algorithms);
>>>>>>> 8c0bfebb9ce8908327fddd6af0bf9d109ff5e4f4
    }
}

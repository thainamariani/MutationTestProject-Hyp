/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiment;

import algorithm.HyperHeuristic;
import algorithm.hhibea.HHIBEA;
import algorithm.hhnsgaII.HHNSGAII;
import algorithm.hhspea2.HHSPEA2;
import jmetal.core.Algorithm;
import jmetal.core.Problem;

/**
 * Class that contains the parameters encapsulated
 *
 * @author Prado Lima
 */
public class Parameters {

    private String instance;
    private HyperHeuristicType algo;
    private int populationSize;
    private int generations;
    private String[] crossoverOperator;
    private String[] mutationOperator;
    private String selectionOperator;
    private int executions;
    private String context;
    private double beta;

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public HyperHeuristic getAlgorithmInstance(Problem problem) {
        switch (getAlgo()) {
            case HHIBEA:
                return new HHIBEA(problem);
            case HHNSGAII:
                return new HHNSGAII(problem);
            case HHSPEA2:
                return new HHSPEA2(problem);
            case RHHIBEA:
                return new HHIBEA(problem);
            case RHHNSGAII:
                return new HHNSGAII(problem);
            case RHHSPEA2:
                return new HHSPEA2(problem);
            default:
                throw new AssertionError();
        }
    }

    public void PrintParameters() {
        System.out.println("Parameters Information");
        System.out.println("----------------------------------------------------");
        System.out.println("Instance: " + getInstance());
        System.out.println("Algorithm: " + getAlgo());
        System.out.println("Population: " + getPopulationSize());
        System.out.println("maxEvaluations: " + getPopulationSize() * getGenerations());
        System.out.println("beta: " +getBeta());

        for (String crossoverOperator1 : crossoverOperator) {
            System.out.println("crossoverOperator: " + crossoverOperator1);
        }

        for (String mutationOperator1 : mutationOperator) {
            System.out.println("mutationOperator: " + mutationOperator1);
        }

        System.out.println("selectionOperator: " + getSelectionOperator());
        System.out.println("executions: " + getExecutions());
        System.out.println("----------------------------------------------------");
    }

    public static synchronized String generateAlgorithmId(final HyperHeuristicType algorithm, final int populationSize, final int generations, final String crossoverOperator, final String mutationOperator, final int executions, final String selectionOperator) {
        return String.format("%s_%s_%s_%s_%s_%s", populationSize, generations, crossoverOperator, mutationOperator, selectionOperator, executions);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    /**
     * @return the instance
     */
    public String getInstance() {
        return instance;
    }

    /**
     * @param instance the instance to set
     */
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * @return the algo
     */
    public HyperHeuristicType getAlgo() {
        return algo;
    }

    /**
     * @param algo the algo to set
     */
    public void setAlgo(HyperHeuristicType algo) {
        this.algo = algo;
    }

    /**
     * @return the populationSize
     */
    public int getPopulationSize() {
        return populationSize;
    }

    /**
     * @param populationSize the populationSize to set
     */
    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    /**
     * @return the generations
     */
    public int getGenerations() {
        return generations;
    }

    /**
     * @param generations the generations to set
     */
    public void setGenerations(int generations) {
        this.generations = generations;
    }

    /**
     * @return the crossoverOperator
     */
    public String[] getCrossoverOperator() {
        return crossoverOperator;
    }

    /**
     * @param crossoverOperator the crossoverOperator to set
     */
    public void setCrossoverOperator(String[] crossoverOperator) {
        this.crossoverOperator = crossoverOperator;
    }

    /**
     * @return the mutationOperator
     */
    public String[] getMutationOperator() {
        return mutationOperator;
    }

    /**
     * @param mutationOperator the mutationOperator to set
     */
    public void setMutationOperator(String[] mutationOperator) {
        this.mutationOperator = mutationOperator;
    }

    /**
     * @return the selectionOperator
     */
    public String getSelectionOperator() {
        return selectionOperator;
    }

    /**
     * @param selectionOperator the selectionOperator to set
     */
    public void setSelectionOperator(String selectionOperator) {
        this.selectionOperator = selectionOperator;
    }

    /**
     * @return the executions
     */
    public int getExecutions() {
        return executions;
    }

    /**
     * @param executions the executions to set
     */
    public void setExecutions(int executions) {
        this.executions = executions;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }

    //</editor-fold>
    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }
}

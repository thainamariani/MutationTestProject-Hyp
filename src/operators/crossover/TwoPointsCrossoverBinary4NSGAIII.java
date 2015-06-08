//  TwoPointsCrossover.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
//
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
package operators.crossover;

import jmetal.operators.crossover.*;
import jmetal.core.Solution;
import jmetal.util.Configuration;
import jmetal.util.JMException;
import jmetal.util.PseudoRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.solution.BinarySolution;

import jmetal.encodings.solutionType.BinarySolutionType;
import jmetal.encodings.variable.Binary;

/**
 * This class allows to apply a two points crossover operator using two parent
 * solutions. NOTE: the type of the solutions must be Binary..
 */
public class TwoPointsCrossoverBinary4NSGAIII implements CrossoverOperator<List<BinarySolution>, List<BinarySolution>> {

    /**
     * Valid solution types to apply this operator
     */
    private static final List VALID_TYPES = Arrays.asList(BinarySolutionType.class);

    private Double crossoverProbability_ = null;
    
    HashMap<String, Object> parameters;

    /**
     * Constructor Creates a new intance of the two point crossover operator
     */
    public TwoPointsCrossoverBinary4NSGAIII(HashMap<String, Object> parameters) {
        this.parameters = parameters;

        if (parameters.get("probability") != null) {
            crossoverProbability_ = (Double) parameters.get("probability");
        }
    } // TwoPointsCrossover

    /**
     * Constructor
     *
     * @param A properties containing the Operator parameters Creates a new
     * intance of the two point crossover operator
     */
    //public TwoPointsCrossover(Properties properties) {
    //	this();
    //}
    /**
     * Perform the crossover operation
     *
     * @param probability Crossover probability
     * @param parent1 The first parent
     * @param parent2 The second parent
     * @return Two offspring solutions
     * @throws JMException
     */
    public BinarySolution[] doCrossover(double probability, BinarySolution parent1, BinarySolution parent2) throws JMException {

    	BinarySolution[] offspring = new BinarySolution[2];

        //copy parents solutions into offsprings
        offspring[0] = (BinarySolution) parent1.copy();
        offspring[1] = (BinarySolution) parent2.copy();
        if (PseudoRandom.randDouble() < probability) {
        	int numberOfBits = parent1.getNumberOfBits(0);
//            int numberOfBits = ((Binary) parent1.getDecisionVariables()[0]).getNumberOfBits();

            // STEP 1: Get two cutting points
            //initial point
            int crosspoint1 = PseudoRandom.randInt(1, numberOfBits - 2);
            //final point
            int crosspoint2 = PseudoRandom.randInt(1, numberOfBits - 2);

            while (crosspoint2 == crosspoint1) {
                crosspoint2 = PseudoRandom.randInt(1, numberOfBits - 2);
            }
            createOffsprings(parent1, parent2, crosspoint1, crosspoint2, offspring);
        }

        return offspring;
    }

    public void createOffsprings(BinarySolution parent1, BinarySolution parent2, int crosspoint1, int crosspoint2, BinarySolution[] offspring) {

        if (crosspoint1 > crosspoint2) {
            int swap;
            swap = crosspoint1;
            crosspoint1 = crosspoint2;
            crosspoint2 = swap;
        }
        // STEP 2: Obtain the first child
        for (int i = crosspoint1; i <= crosspoint2; i++) {
            boolean value = (parent2.getVariableValue(0)).get(i);
            offspring[0].getVariableValue(0).set(i, value);
        }
        // STEP 3: Obtain the second child
        for (int i = crosspoint1; i <= crosspoint2; i++) {
        	boolean value = (parent1.getVariableValue(0)).get(i);
            //boolean value = ((Binary) parent1.getDecisionVariables()[0]).getIth(i);
//            ((Binary) offspring[1].getDecisionVariables()[0]).setIth(i, value);
        	offspring[1].getVariableValue(0).set(i, value);
        }
    }

    public List<BinarySolution> execute(List<BinarySolution> object) {
    	BinarySolution[] parents = new BinarySolution[2];
        
        parents[0] = (BinarySolution) object.get(0);
        parents[1] = (BinarySolution) object.get(1);
        
        Double  crossoverProbability = (Double) parameters.get("probability");

        if (parents.length < 2) {
            Configuration.logger_.severe("TwoPointsCrossoverBinary4NSGAII.execute: operator needs two "
                    + "parents");
            Class<String> cls = java.lang.String.class;
            String name = cls.getName();
        }

        BinarySolution[] offspring = null;
		try {
			offspring = doCrossover(crossoverProbability_, parents[0],parents[1]);
		} catch (JMException e) {
			e.printStackTrace();
		}
        
        List<BinarySolution> s = new ArrayList<BinarySolution>();
        
        s.add((BinarySolution) offspring[0]);
        s.add((BinarySolution) offspring[1]);

        return s;
    }

//	@Override
//	public List<BinarySolution> execute(List<BinarySolution> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

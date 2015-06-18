//  MutationFactory.java
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

package jmetal.operators.mutation;

import jmetal.util.Configuration;
import jmetal.util.JMException;

import java.util.HashMap;

import operators.mutation.OneChangeMutation;
import operators.mutation.SwapMutationBinary;

/**
 * Class implementing a factory for Mutation objects.
 */
public class MutationFactory {
  
  /**
   * Gets a crossover operator through its name.
   * @param name of the operator
   * @return the operator
   * @throws JMException 
   */
  public static Mutation getMutationOperator(String name, HashMap parameters) throws JMException{
 
    if (name.equalsIgnoreCase("PolynomialMutation"))
      return new PolynomialMutation(parameters);
    else if (name.equalsIgnoreCase("BitFlipMutation"))
      return new BitFlipMutation(parameters);
    else if (name.equalsIgnoreCase("NonUniformMutation"))
      return new NonUniformMutation(parameters);
    else if (name.equalsIgnoreCase("SwapMutation"))
      return new SwapMutation(parameters);
    else if (name.equalsIgnoreCase("SwapMutationBinary"))
      return new SwapMutationBinary(parameters);
    else if (name.equalsIgnoreCase("OneChangeMutation"))
        return new OneChangeMutation(parameters);
    else
    {
      return null;
    }        
  } // getMutationOperator
} // MutationFactory

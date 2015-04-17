package atharrison.sandbox.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    
    public String solve() {
        
        long num = 600851475143L;
        
        List<Long> factors = new ArrayList<Long>();
        
        ArrayList<Long> primeCandidates = generatePrimeCandidates(num);
        System.out.println(primeCandidates);
        
        int[] coefficients = new int[primeCandidates.size()];
        Arrays.fill(coefficients, 0);
        
        int maxC = 4;
        int cTerm = 0;
        long result = 0;
        int size = primeCandidates.size();
        int attempts = 0;
        coefficients[0] = 1;
        
        // This is not a sufficient algorithm, but solved the problem above.
        while(result != num && attempts < 30) {
            result = calculate(primeCandidates, coefficients);
            outputArray(result, coefficients);
            if( result < num) {
                if (cTerm < size - 1) {
                    cTerm += 1;
                    coefficients[cTerm] = Math.min(maxC, coefficients[cTerm] + 1);
                } else {
                    cTerm = 0;
                    coefficients[cTerm] += 1;
                }
            } else if (result > num) {
                if(cTerm < size - 1) {
                    coefficients[cTerm] = Math.max(0, coefficients[cTerm] - 1);
                    cTerm += 1;
                } else {
                    coefficients[cTerm] -= 1;
                    cTerm = 0;
                }
            }
            
            attempts+=1;
        }
        
        System.out.println("attempts: "+attempts);
        return combine(primeCandidates, coefficients);
    }
    
    private long calculate(ArrayList<Long> primeCandidates, int[] coefficients) {
        long result = 1;
        for(int i=0; i<primeCandidates.size(); i++) {
            if(coefficients[i] > 0) {
                result = result * primeCandidates.get(i) * coefficients[i];
            }
        }
        return result;
    }
    
    private ArrayList<Long> generatePrimeCandidates(long num) {
        ArrayList<Long> primeCandidates = new ArrayList<Long>();
        
        for(long i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0) {
                primeCandidates.add(i);
            }
        }
        return primeCandidates;
    }
    
    private void outputArray(long result, int[] arr) {
        System.out.print(result +" == ");
        for(int item : arr) {
            System.out.print(item);
        }
        System.out.println();
    }
    
    private String combine(List<Long> candidates, int[] coefficients) {
        
        String result = "";
        for(int i = 0; i < candidates.size(); i++) {
            if(coefficients[i] > 0) {
                result += candidates.get(i) + "x"+coefficients[i] + ", ";
            }
        }
        
        return result;
    }
}

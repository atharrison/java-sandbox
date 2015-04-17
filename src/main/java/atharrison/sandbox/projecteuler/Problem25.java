package atharrison.sandbox.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 Hence the first 12 terms will be:

 F1 = 1
 F2 = 1
 F3 = 2
 F4 = 3
 F5 = 5
 F6 = 8
 F7 = 13
 F8 = 21
 F9 = 34
 F10 = 55
 F11 = 89
 F12 = 144
 The 12th term, F12, is the first term to contain three digits.

 What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 {
    
    public String solve() {

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = nextFib(a, b);
        int term = 3;
        int digitCount = digits(c);
        while(digitCount < 1000) { // && term < 20) {
            System.out.println(term + "\t" + digitCount + "\t"+c.toString(10));
            term += 1;
            BigInteger prevC = new BigInteger(c.toString());
            c = nextFib(b, c);
            b = prevC;

            digitCount = digits(c);
        }
        return Integer.valueOf(term).toString();
    }

    public BigInteger nextFib(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    public int digits(BigInteger i) {
        return i.toString().length();
    }
}

package com.company;

public class Day200414 {

    /**
     * @author seongwou
     * @since 2020/04/14 11:32 오전
     * <p>
     * Given two strings S and T, each of which represents a non-negative rational number, return True if and only if they represent the same number.
     * The strings may use parentheses to denote the repeating part of the rational number.
     * <p>
     * In general a rational number can be represented using up to three parts: an integer part, a non-repeating part, and a repeating part.
     * The number will be represented in one of the following three ways:
     *
     * <IntegerPart> (e.g. 0, 12, 123)
     * <IntegerPart><.><NonRepeatingPart>  (e.g. 0.5, 1., 2.12, 2.0001)
     * <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)> (e.g. 0.1(6), 0.9(9), 0.00(1212))
     * The repeating portion of a decimal expansion is conventionally denoted within a pair of round brackets.  For example:
     * <p>
     * 1 / 6 = 0.16666666... = 0.1(6) = 0.1666(6) = 0.166(66)
     * <p>
     * Both 0.1(6) or 0.1666(6) or 0.166(66) are correct representations of 1 / 6.
     **/
    public boolean isRationalEqual(String s, String t) {
        Fraction f1 = Rational.parse(s).toFraction();
        Fraction f2 = Rational.parse(t).toFraction();
        return f1.p * f2.q == f2.p * f1.q;
    }

    private static class Rational {
        private final String integer, nonRepeating, repeating;

        private Rational(String integer, String nonRepeating, String repeating) {
            this.integer = integer;
            this.nonRepeating = nonRepeating;
            this.repeating = repeating;
        }

        public static Rational parse(String s) {
            // HACK: quick and dirty parsing assuming inputs are always valid
            // this usually needs more thorough validation
            String[] parts = s.split("[.()]");
            return new Rational(
                    parts.length >= 1 ? parts[0] : "",
                    parts.length >= 2 ? parts[1] : "",
                    parts.length >= 3 ? parts[2] : ""
            );
        }

        public Fraction toFraction() {
            long a = tenpow(nonRepeating.length());
            long i = Long.parseLong(integer + nonRepeating); // = a * number
            if (repeating.length() == 0) {
                return new Fraction(i, a);
            }
            else {
                long b = tenpow(nonRepeating.length() + repeating.length());
                long j = Long.parseLong(integer + nonRepeating + repeating); // = b * number
                return new Fraction(j - i, b - a);
            }
        }

        public String toString() {
            return String.format("%s.%s(%s)", integer, nonRepeating, repeating);
        }
    }

    // represents p/q
    private static class Fraction {
        private final long p, q;

        private Fraction(long p, long q) {
            this.p = p;
            this.q = q;
        }

        public String toString() {
            return String.format("%d/%d", p, q);
        }
    }

    // 10^x
    private static long tenpow(int x) {
        assert x >= 0;
        long r = 1;
        while (--x >= 0) {
            r *= 10;
        }
        return r;
    }


    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
    }




}

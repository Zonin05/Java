class BSIL {
    public static void main(String[] args) {
        long[] testCases = {-150, 150000, 1500000000L, 2133333333333333333L, -100};

        for (long x : testCases) {
            System.out.println(x + " can be fitted in:");
            
            if (x >= -128 && x <= 127) System.out.println("* byte");
            if (x >= -32768 && x <= 32767) System.out.println("* short");
            if (x >= -2147483648L && x <= 2147483647L) System.out.println("* int");
            System.out.println("* long");
        }
    }
}

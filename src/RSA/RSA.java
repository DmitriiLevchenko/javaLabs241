package RSA;

import java.util.Random;
import java.math.BigInteger;

public class RSA {
    private final int BITLENGHT = 1024;

    private BigInteger a; // first number
    private BigInteger b; // second number
    private BigInteger mod; // (mod) p*q
    private BigInteger ef; //(a-1)*(b-1)
    private BigInteger e; // exp
    private BigInteger esc; //secret exp
    private Random r;

    public RSA() {
        super();
        this.init();
    }

    public RSA(BigInteger e, BigInteger d, BigInteger N) {
        super();
        this.e = e;
        this.esc = d;
        this.mod = N;
    }

    public void init() {
        r = new Random();
        a = BigInteger.probablePrime(BITLENGHT, r);
        b = BigInteger.probablePrime(BITLENGHT, r);
        mod = a.multiply(b);
        ef = a.subtract(BigInteger.ONE).multiply(b.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(BITLENGHT / 2, r);
        while (ef.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(ef) < 0) {
            e.add(BigInteger.ONE);
        }
        esc = e.modInverse(ef);
    }


    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, mod).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(esc, mod).toByteArray();
    }
}


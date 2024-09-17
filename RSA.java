/**
 * RSA
 */
import java.math.*;
import java.util.*;

public class RSA {

    public static int gcd(int e,int z){
        if(e==0){
            return z;
        }
        else 
            return gcd(z%e, e);
    }

    public static void main(String[] args) {
        int p,q,n,z,d=0,e,i;
        int msg;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the message:");
        msg=sc.nextInt();

        double c;
        BigInteger msgback;

        // 1st prime number p
        System.out.println("Enter the first prime number:");
        p=sc.nextInt();

        // 2nd prime q
        System.out.println("enter the 2nd prime number:");
        q=sc.nextInt();

        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("the value of z = "+z);

        for(e=2;e<z;e++){
            if(gcd(e,z)==1)
                break;
        }

        for(i=0;i<=9;i++){
            int x=1+(i*z);
            //d is for private key exponent
            if(x%e==0){
                d=x/e;
                break;
            }
                
        }
        System.out.println("the value of d="+d);
        
        c=(Math.pow(msg,e))%n;
        System.out.println("Encrypted message is: "+c);

        BigInteger N=BigInteger.valueOf(n);

        BigInteger C=BigDecimal.valueOf(c).toBigInteger();
        msgback=(C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "+msgback);

        sc.close();

    }
    
}
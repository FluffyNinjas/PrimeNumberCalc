import java.util.Scanner;

public class Sieve extends ArrayQueue<Integer>{
    private int n;
    private ArrayQueue<Integer> primes;
    private ArrayQueue<Integer> numbers;
    private ArrayQueue<Integer> k;

    public Sieve(int n1){
        n = n1;
    }
    public void primeTo(int n3){
        n3=n;
        numbers = new ArrayQueue<Integer>(n3);
        primes = new ArrayQueue<Integer>(n3);
        k = new ArrayQueue<Integer>(n3);

        int p = 2;
        for(int i = 2; i<n3+1;i++){
            numbers.enqueue(i);
        }

        while(p <= java.lang.Math.sqrt(n3)){
            primes.enqueue(p);
            while (numbers.isEmpty()==false){
                if(numbers.first() % p==0){
                    numbers.dequeue();
                }
                else if(numbers.first()% p !=0){
                    k.enqueue(numbers.dequeue());
                }

            }
            while(k.isEmpty()==false){
                numbers.enqueue(k.dequeue());
            }

            p=numbers.first();

        }

        System.out.print("Primes up to "+n+" are:");
        while(primes.isEmpty()==false){
            System.out.print(primes.dequeue()+" ");
        }
        while(numbers.isEmpty()==false){
            System.out.print(numbers.dequeue()+" ");
        }






    }

    public static void main(String[] args) {
        int j = 0;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter an upperbound");
        j = myObj.nextInt();
        if(j<2){
            System.out.println("Error:Please something over 2");
        }
        else{
            Sieve nv = new Sieve(j);
            nv.primeTo(j);
        }



    }

}

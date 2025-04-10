import java.util.Scanner;
import java.util.Random;


class Esercizio {
  

    public static void BubbleSort(int[] V, int N){
        boolean trovato;
        int i = 0;
        int j;

        trovato = false;

        while(i < N && !trovato){
            j = 0;
            trovato = true;
            while(j < (N - 1) - i){
                if(V[j] > V[j+1]){
                    int t = V[j];
                    V[j] = V[j+1];
                    V[j+1] = t;
                    trovato = false;
                }
                j++;
            }
            i++; 
        }

    }

    public static void Merge(int[] V, int[] R, int numV, int numR, int[] V_merge){
   
        int i, j, k;

        i = 0;
        j = 0;
        k = 0;

        while((i < numV) && (j < numR)){
            if(V[i] <= R[j]){
                V_merge[k] = V[i]; 
                i++;
            }else{
                V_merge[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < numV){
            V_merge[k] = V[i];
            k++;
            i++;
        }

        while(j < numR){
            V_merge[k] = R[j];
            k++;
            j++;
        }

    }

    public static int Ricerca_binaria(int[] V, int N, int numero){
        int inizio, fine, medio = 0, i = -1;
        boolean trovato = false;

        inizio = 0;
        fine = N - 1;
        while(inizio <= fine && !trovato){
            medio = inizio + (fine - inizio) / 2;
            if(V[medio] == numero){
                trovato = true;
                i = medio;
            }else if(V[medio] < numero){
                inizio = medio + 1;
            }else{
                fine = medio - 1;
            }
        }

        return i;
    }

    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
    
        int N, num, numP, numD, index;

        System.out.print("Inserire il numero di numeri da generare: ");
        N = in.nextInt();

        int[] temp_P = new int[N];
        int[] temp_D = new int[N];

        numD = 0;
        numP = 0;

        
        for(int i = 0; i < N; ++i){
            num = rand.nextInt(100);
            if(num % 2 == 0){
                temp_P[numP] = num;
                numP ++;
            }else{
                temp_D[numD] = num;
                numD++;
            }
        }

        int[] P = new int[numP];
        int[] D = new int[numD];

        for (int i = 0; i < numP; i++) {
            P[i] = temp_P[i];
        }
        
        for (int i = 0; i < numD; i++) {
            D[i] = temp_D[i];
        }

        BubbleSort(D, numD);
        BubbleSort(P, numP);

        int[] V_merge = new int[N];

        Merge(D, P, numD, numP, V_merge);
        System.out.println("Vettore unito e ordinato: ");
        for(int i = 0; i < N; ++i){
            System.out.println(i + ":" +  V_merge[i] + " ");
        }

        int numeroRicerca;

        System.out.print("Inserire numero da ricercare nel vettore: ");
        numeroRicerca = in.nextInt();

        index = Ricerca_binaria(V_merge, N, numeroRicerca);

        if(index != -1){
            System.out.println("Il numero: " + V_merge[index] + " si trova nella posizione: " + index + "!");
        }else{
            System.out.println("Numero non trovato!");
        }
    }   
}


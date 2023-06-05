/*Java dilinde, dizideki elemanları küçükten büyüğe sıralayan programı yazınız. Dizinin boyutunu ve dizinin elemanlarını kullanıcıdan alınız.

Senaryo
Dizinin boyutu n : 5
Dizinin elemanlarını giriniz :
1. Elemanı : 99
2. Elemanı : -2
3. Elemanı : -2121
4. Elemanı : 1
5. Elemanı : 0
Sıralama : -2121 -2 0 1 99*/

import java.sql.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Dizinin boyutu n : ");
        int n = input.nextInt();
        int arr[] = new int[n];
        int temp[] = new int[n];
        System.out.println("Dizinin elemanlarini giriniz :");

        for(int i=0; i<n; i++){
            System.out.print((i+1) + ". Elemani : ");
            arr[i] = input.nextInt();
        }

        int counter = 0;
        int min = 9999;
        for(int i=0; i<n; i++){
            if(min > arr[i])
                temp[counter++] = arr[i];
        }

    }
}

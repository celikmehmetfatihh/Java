/*
Java dilinde, çok boyutlu diziler ile oluşturulmuş matrisin transpozunu bulan programı yazınız.

Matrisin transpozunu (devriğini) almak, matrisin aynı numaralı satırları ile sütunlarının yer değiştirmesi demektir. Bu işlem sonucu elde edilen matris, başlangıçtaki matrisin transpozudur (devriğidir). Bu aşamada kxn’lik bir matrisin transpozu (devriği) nxk’lik bir matris olur. Örneğin bir A matrisimiz olsun. Bu A matrisinin transpozu (devriği), A^T (A üzeri T) ile gösterilir.

Örneğin aşağıdaki 2x3’lik A matrisinin transpozu (devriği), 2x3’lük bir A^T matrisidir.





Senaryo
Matris :
2    3    4
5    6    4
Transpoze :
2    5
3    6
4    4    */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the dimension of the matrix x:x :");
        int x,y;
        x = input.nextInt();
        y = input.nextInt();

        int[][] matrix = new int[x][y];

        System.out.println("Enter the numbers of the matrix: ");
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.println("Your matrix: ");
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

      /*  for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                try {
                    matrix[i][j] = matrix[j][i];
                }
                catch(ArrayIndexOutOfBoundsException e){
                    if(y>x)
                        matrix[i][j] = matrix[j-1][i];
                    else
                        matrix[i][j] = matrix[j][i-1];
                }
            }
        }*/

        System.out.println("Transpozed version of your matrix: ");
        for(int j=0; j<y; j++){
            for(int i=0; i<x; i++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }
}

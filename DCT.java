// Java program to perform discrete cosine transform 
  
import java.util.*; 
  
class DCT  
{ 
    public static int u = 8, v = 8; 
    public static double pi = 3.142857; 
      
    // Function to find discrete cosine transform and print it 
    static strictfp void dctTransform(int matrix[][]) 
    { 
        int i, j, k, l; 
   
        // dct will store the discrete cosine transform 
        double[][] dct = new double[u][v]; 
   
        double ci, cj, dct1, sum; 
   
        for (i = 0; i < u; i++)  
        { 
            for (j = 0; j < v; j++)  
            { 
                // ci and cj depends on frequency as well as 
                // number of row and columns of specified matrix 
                if (i == 0) 
                    ci = 1 / Math.sqrt(2); 
                else
                    ci = 1; 
                      
                if (j == 0) 
                    cj = 1 / Math.sqrt(2); 
                else
                    cj = 1; 
   
                // sum will temporarily store the sum of  
                // cosine signals 
                sum = 0; 
                for (k = 0; k < u; k++)  
                { 
                    for (l = 0; l < v; l++)  
                    { 
                        dct1 = matrix[k][l] *  
                               Math.cos((2 * k + 1) * i * pi / (2 * u)) *  
                               Math.cos((2 * l + 1) * j * pi / (2 * v)); 
                        sum = sum + dct1; 
                    } 
                } 
                dct[i][j] = 0.25 * ci * cj * sum; 
            } 
        } 
   
        for (i = 0; i < u; i++)  
        { 
            for (j = 0; j < v; j++)  
                System.out.printf("%f\t", dct[i][j]); 
            System.out.println(); 
        } 
    } 

    // driver program 
    public static void main (String[] args)  
    { 
        int matrix[][] = { { -81, -81, -78, -84, -83, -84, -85, -87 }, 
                         { -80, -75, -64, -61, -81, -90, -85, -87 }, 
                         { -80, -75, -64, -61, -81, -90, -85, -87 }, 
                         { -68, -55, -43, -33, -28, -39, -37, -32 }, 
                         { -56, -45, -41, -39, -37, -29, -32, -17 }, 
                         { -42, -30, -27, -30, -23, -21, -17, -15 }, 
                         { -36, -28, -22, -24, -26, -24, -12, -18 }, 
                         { -43, -42, -33, -34, -29, -24, -35, -23 } }; 
        dctTransform(matrix); 
    } 
} 
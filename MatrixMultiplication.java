
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) throws IOException{
        System.out.println("1. Use a file");
        System.out.println("2. Create matrix");
        
        Scanner options = new Scanner(System.in);
        int choice = options.nextInt();

        if(choice == 1)
        {
           file();
        }

       if(choice == 2)
        {
            create();
        }
        
        options.close();
    }

    public static void create() throws IOException
    {
        //User inputs number of rows
        System.out.print("Enter the number of rows/columns of your matrix: ");

        Scanner number = new Scanner(System.in);
        int x = number.nextInt();
        int y = x;
        
        number.close();

        //Make two matrices
        int[][] m1 = new int[x][y];
        int[][] m2 = new int[x][y];
        
        //Assign values

        int i;
        int j;
        
        for(i = 0; i < x; i++)
        {
            for(j = 0; j < y; j++)
            {
                Random rand = new Random();
                int randomNumber = rand.nextInt(10);
                m1[i][j] = randomNumber;
            }
        }

        
        for(i = 0; i < x; i++)
        {
            for(j = 0; j < y; j++)
            {
                Random rand = new Random();
                int randomNumber = rand.nextInt(10);
                m2[i][j] = randomNumber;
            }
        }

        //Write to files
        String file1 = "matrix1.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
       
        for (i = 0; i < x; i++)
        {
            for (j = 0; j < y; j++) 
            {
                writer.write(m1[i][j] + " ");
            }
            writer.newLine();
        }
        writer.close();
    

        String file2 = "matrix2.txt";
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2));
        for (i = 0; i < x; i++)
        {
            for (j = 0; j < y; j++) 
            {
                writer2.write(m2[i][j] + " ");
            }
            writer2.newLine();
        }
        writer2.close();
        

        //Multiply!
        int m3[][] = new int[x][y];
        for (i = 0; i < x; i++)
        {
            for (j = 0; j < y; j++) 
                {
                    for(int k = 0; k < x; k++)
                    {
                        m3[i][j] += m1[i][k] * m2[k][j];
                    }
                }
        }

        //Write to file
        String file3 = "matrix3.txt";
        BufferedWriter writer3 = new BufferedWriter(new FileWriter(file3));
        for (i = 0; i < x; i++)
        {
            for (j = 0; j < y; j++) 
            {
                writer3.write(m3[i][j] + " ");
            }
            writer3.newLine();
        }
        writer3.close();
        
        System.out.print("Product matrix successfully wrritten to file!");
    }



    public static void file() throws IOException
    {
        //Read from file
        File file1 = new File("matrix1.txt");
        Scanner Reader = new Scanner(file1);

        //Determine size
        int w = 0;
        int h = 0;
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            String numbers[] = line.split(" ");
            h = numbers.length;
            w++;
        }

        int[][] matrix1 = new int[w][h];

        //Add elements
        Reader = new Scanner(new File("matrix1.txt")); 
 
        int x = 0;
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            String[] numbers = line.split(" ");
            for (int y = 0; y < numbers.length; y++) {
                matrix1[x][y] = Integer.parseInt(numbers[y]);
            }
            x++;
        }

        Reader.close();


        //File 2's turn
        File file2 = new File("matrix2.txt");
        Scanner Reader2 = new Scanner(file2);

        int w2 = 0;
        int h2 = 0;
        while (Reader2.hasNextLine()) {
            String line2 = Reader2.nextLine();
            String numbers2[] = line2.split(" ");
            h2 = numbers2.length;
            w2++;
        }

        int[][] matrix2 = new int[w2][h2];

        //Add elements
        Reader2 = new Scanner(new File("matrix2.txt")); 
 
        int x2 = 0;
        while (Reader2.hasNextLine()) {
            String line2 = Reader2.nextLine();
            String[] numbers2 = line2.split(" ");
            for (int y2 = 0; y2 < numbers2.length; y2++) {
                matrix2[x2][y2] = Integer.parseInt(numbers2[y2]);
            }
            x2++;
        }

        Reader2.close();



        //Multiply!
        int row = w;
        int col = h2;
        if(h != w2)
        {
            System.out.print("Cannot be multiplied");
        }

        int matrix3[][] = new int[row][col];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++) 
                {
                    for(int k = 0; k < x; k++)
                    {
                        matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
        }

    
        //Write to file
        String file3 = "matrix3.txt";
        BufferedWriter writer3 = new BufferedWriter(new FileWriter(file3));
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++) 
            {
                writer3.write(matrix3[i][j] + " ");
            }
            writer3.newLine();
        }
        writer3.close();
        System.out.print("Product matrix successfully wrritten to file!");

    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagedev;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File miDir = new File (".");
        try {
            System.out.println ("Directorio actual: " + miDir.getCanonicalPath()+"\n");
        }catch(Exception e) {
            e.printStackTrace();
        }

        String rutaFichOrigen="./example001.bmp";//origen
        String rutaFichDestino="./example001cp.bmp"; //destino
        File ficheroOrigen=new File(rutaFichOrigen);//objeto con la ruta origen.
        File ficheroDestino=new File(rutaFichDestino);//objeto con la ruta destino.
        BufferedInputStream lectorFichero;//flujo buffer de lectura .
        BufferedOutputStream escritorFichero;//buffer de escritura.
        try{
            lectorFichero=new BufferedInputStream(new FileInputStream(ficheroOrigen));//Inicializa el buffer de lectura con un FileInputStream
            escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));//Inicializa el buffer de escritura con un FileOutputStream
            int bytes;

            String read, inv;

            int[] intRead, invInt;

            long conv;
            
            //-----------------------HEADER-------------------------------------
            
            System.out.println("-- HEADER --");
            
            // HEADER FIELD
            intRead = new int[2];
            intRead=recoverNext(2,lectorFichero, escritorFichero);

            System.out.print("Type: ");
            printArrayIntInHex(intRead);
            System.out.println("");

            
            // SIZE
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Size: ");
            printArrayIntInHex(invInt);
            System.out.println("");

            
            // RESERVED (2)
            intRead = new int[2];
            intRead=recoverNext(2,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Reserved (2): ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // RESERVED (2)
            intRead = new int[2];
            intRead=recoverNext(2,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Reserved (2): ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // OFFSET
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Offset: ");
            printArrayIntInHex(invInt);
            System.out.println("\n");
            
            
            System.out.println("-- HEADER COMPLEMENTARIO --");
            // SIZE OF COMPLEMENTARY HEADER
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Size of Header: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // WIDTH
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Width: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // HEIGHT
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Height: ");
            printArrayIntInHex(invInt);
            System.out.println("");


            // NUMBER OF COLOR PLANES
            intRead = new int[2];
            intRead=recoverNext(2,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Number of Planes: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // BITS PER PIXEL
            intRead = new int[2];
            intRead=recoverNext(2,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Bits per Pixel: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // COMPRESSION METHOD
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Compression Method: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // IMAGE SIZE
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Image Size: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // HORIZONTAL RESOLUTION
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Horizontal Resolution: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // VERTICAL RESOLUTION
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Vertical Resolution: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // NUMBER OF COLORS
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Number of Colors: ");
            printArrayIntInHex(invInt);
            System.out.println("");
            
            
            // NUMBER OF IMPORTANT COLORS
            intRead = new int[4];
            intRead=recoverNext(4,lectorFichero, escritorFichero);

            invInt = new int[intRead.length];
            invInt=reverseInt(intRead);

            System.out.print("Number of Important Colors: ");
            printArrayIntInHex(invInt);
            System.out.println("\n");           
            
            
            
            //-----------------------RAW DATA------------------------------------
            System.out.println("-- RAW DATA --");
            for(int fila=0; fila<26; fila++){
                
                for(int columna=0; columna<10; columna++){                    
                    intRead = new int[3];
                    intRead=recoverNext(3, lectorFichero, escritorFichero);

                    invInt = new int[intRead.length];
                    invInt=reverseInt(intRead);
                    
                    System.out.print("| ");
                    printArrayIntInHex(invInt);
                }
                
                System.out.println("|");                                                
            }
            
            
            lectorFichero.close();
            escritorFichero.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    static int[] recoverNext(int nextBytes,BufferedInputStream lectorFichero, BufferedOutputStream escritorFichero){
        int[] bytesRecovered= new int[nextBytes];
        String byteRead="";
        int count=0;
        int byteRecovered;
        try{
            if(nextBytes>0){
                while(count<nextBytes){
                    if((byteRecovered=lectorFichero.read())!=-1){
                       //System.out.println("Leido: "+byteRecovered);

                       bytesRecovered[count]=byteRecovered;
                       writeToFile(escritorFichero, byteRecovered);
                    }
                    count++;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return(bytesRecovered);
    }

    static int[] reverseInt(int[] bytes){
        int[] revString= new int[bytes.length];
        int index=0;
        for (int x=bytes.length-1;x>=0;x--){
            revString[index++] = bytes[x];
        }
        return(revString);
    }

    static void printArrayInt(int[] intArray){
        for (int x=0; x<intArray.length;x++){
            System.out.print(intArray[x]+" ");
        }
    }

    static void printArrayIntInHex(int[] intArray){
        for (int x=0; x<intArray.length;x++){
            //System.out.print(Integer.toHexString(intArray[x])+" ");
            System.out.print(String.format("%02X",intArray[x])+" ");
        }
    }

    static long StringToInt(String bytes){
        long value=0;

        value=Long.parseLong(bytes, 16);

        return(value);
    }

    static void writeToFile(BufferedOutputStream escritorFichero, int bytes){
        try{
            escritorFichero.write(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

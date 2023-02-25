import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            /**
             *Создал первый файл C:\My\numIsh.txt
             */
            File folderMy = new File("C:\\My");
            folderMy.mkdir();//Создаю папку My (Без этого не работало)

            File fileOne=new File("C:\\My\\numIsh.txt");
            fileOne.createNewFile();

            /**
             *Заполняю первый файл
             */

            Scanner in = new Scanner(System.in, "cp1251");
            DataOutputStream wr = new DataOutputStream(new FileOutputStream(fileOne.getAbsolutePath()));
            System.out.printf("Сколько записать вещественных чисел в файл?");
            int count = in.nextInt();
            System.out.printf("Введите числа: ");
            for(int i = 0; i < count; i++){
                wr.writeFloat(in.nextFloat());
            }
            wr.flush();
            wr.close();

            /**
             *Создал второй файл C:\My\numRez.txt
             */

            File fileTwo=new File("C:\\My\\numRez.txt");
            fileTwo.createNewFile();

            /**
             * Создаю поток чтения из файла и записываю во второй файл
             */

            DataInputStream rd = new DataInputStream(new FileInputStream(fileOne.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(fileTwo.getAbsolutePath()));
            try{
                while(true){
                    float num = rd.readFloat();
                    wr.writeFloat(num);
                    System.out.printf("Число - " + num + "\n");
                }
            }catch(EOFException ex){

                //Игнор))))
            }

        }catch(IOException e){
            System.out.printf("End of file");
        }
    }
}
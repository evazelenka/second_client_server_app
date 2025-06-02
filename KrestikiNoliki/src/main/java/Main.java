import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] ar2 = {0,1,2,3,0,1,2,3,0};
        byte[] arr = compressArraySize9(ar2);
        try(FileOutputStream fos = new FileOutputStream("C:\\Users\\evaze\\OneDrive\\Desktop\\test.txt"); FileInputStream fis = new FileInputStream("C:\\Users\\evaze\\OneDrive\\Desktop\\test.txt")){
            fos.write(arr);
            int[] b = decompressArraySize9(fis.readAllBytes());
            System.out.println(Arrays.toString(b));
        }
    }
    private static byte[] compressArraySize9(int[] arrI){
        byte[] arrB = new byte[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrB[i] += (byte) arrI[3*i + j] << (j*2);
            }
        }
        return arrB;
    }

    private static int[] decompressArraySize9(byte[] arrB){
        int[] arrI = new int[9];
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; ++j) {
                int s = arrI[c++] = arrB[i] >> (j*2) & 3;
            }
        }
        return arrI;
    }
}

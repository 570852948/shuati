package Document_classification;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Document_classification {

    public static void main(String[] args) {
        String path = "D:\\360安全浏览器下载\\KinhDown   版本2.5.08\\下载\\java面试\\test";
        File file = new File(path);
        File[] files = file.listFiles();
        String folderName = "";
        for (File f : files) {
            if (f.isDirectory()) {
                continue;
            }
            int l = f.getName().indexOf('_');
            if (l == -1) {
                continue;
            }
            int k = f.getName().indexOf(' ');
            folderName = f.getName().substring(k, l);
            String s1 = path + "\\" + f.getName();
            //String newDirectory =
            String s2 = NewFolder(folderName.substring(0,folderName.indexOf('-'))) + "\\" + f.getName();
            //移动文件
            try {
                Files.move(Paths.get(s1), Paths.get(s2), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //NewFolder(folderName)

            System.out.println(f.getName());
        }


        List<File> list = new ArrayList<File>();

    }

    //新建文件夹
    public static String NewFolder(String folderName) {


        StringBuffer sb = new StringBuffer("D:\\360安全浏览器下载\\KinhDown   版本2.5.08\\下载\\java面试\\test");


        sb.append("\\" + folderName.replaceAll(" ",""));
        File f = new File(sb.toString());
        if (!f.exists()) {
            f.mkdir();
        }

        return sb.toString();
    }
}

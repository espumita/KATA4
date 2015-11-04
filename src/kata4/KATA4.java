package kata4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class KATA4 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "C:\\Users\\usuario\\Documents";
        File file = new File(fileName);
        String[] filesArray = file.list();
      //  for (String files : filesArray) {
            //System.out.println(files);
        //}
      //  print(file.listFiles(),"");
        
        
        String from = "C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv";
        String to = "C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife(1).wmv ";
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        byte[] buffer = new byte[1024];
        Date date = new Date();
        while (true){
            int read = input.read(buffer);
            if(read < 0) break;
            output.write(buffer);
        }
        System.out.println(new Date().getTime()-date.getTime()+"msg");
        input.close();
        output.flush();
        output.close();
    }
    //C:\Users\Public\Videos\Sample Videos\Wildlife.wmv 
    private static void print(File[] listFiles, String ident) {
        if (listFiles == null ) return;
        for (File listFile : listFiles) {
            System.out.println(ident+(listFile.isDirectory()? "+" : "  " )+listFile.getName());
            if(!listFile.isDirectory() || listFile.isHidden()) continue;
            print(listFile.listFiles(),ident+" ");
        }
    }
}

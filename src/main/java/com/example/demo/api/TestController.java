package com.example.demo.api;

import com.example.demo.service.RequestService;
import com.example.demo.util.HanyuPinyin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class TestController {
    @RequestMapping(value = "point/{a}/{b}")
    public String getPoint(@PathVariable int a, @PathVariable int b) {
        return new RequestService().getPoly(a, b);
    }

    public static void main(String[] args) {
        String filePath = "F:\\Projects\\Java\\example\\src\\main\\resources\\static\\db.txt";
        String fileString = FileHepler.readerFile(filePath);
        System.out.println(fileString);
        FileHepler.writeFile(filePath,fileString);
    }
}
class FileHepler {
    public  static  void writeFile(String filePath,String string) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
    public static String readerFile(String filePath) {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO temp111(_database,_tablename,_cnname,_enname)\n" +
                "VALUES");
        BufferedReader bufferedReader = null;
        try {
            FileReader reader = new FileReader(filePath);
            bufferedReader = new BufferedReader(reader);
            if (bufferedReader.ready()) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] strings = line.split(",");
                    builder.append("(");
                    for (int i = 0; i <strings.length ; i++) {
                        if(i==2)
                        {
                            builder.append("'");
                            builder.append(strings[i]);
                            builder.append("'");
                            String str = HanyuPinyin.getFirstLettersLo(strings[i]);
                            builder.append(",'");
                            builder.append(str);
                            if (str.length()>=5)
                            {
                                builder.append("_?");
                            }
                            builder.append("'");
                            builder.append("\n");
                        }
                        else
                        {
                            builder.append("'");
                            builder.append(strings[i]);
                            builder.append("',");
                        }
                    }
                    builder.append("),");
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {

                }
            }
        }
        return  builder.toString();
    }
}


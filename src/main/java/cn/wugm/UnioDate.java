package cn.wugm;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UnioDate {

    public static String getUnioDate(String filePath) throws IOException {

        File file = new File(filePath);

        ArrayList<String> strings = new ArrayList<>();
        if(file.isDirectory()){
            File[] files = file.listFiles();

            int num = 0;
            int aan = 0;
            HashMap<String, Integer> hashMap = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (File file1 : files) {
                if(file1.isDirectory()){
                    File[] files1 = file1.listFiles();
                    for (File file2 : files1) {
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        String aa = "";
                        while ((aa = bufferedReader.readLine()) != null){
                            if(!aa.startsWith("#")){
                                String[] s = aa.split(" ");
                                strings.add(s[1]);
                                stringBuilder.append(s[1] + "\n");
                                if(!hashMap.containsKey(s[1])){
                                    hashMap.put(s[1],1);
                                }else {
                                    hashMap.put(s[1],hashMap.get(s[1]) + 1);
                                }


                                if(s[1].equals("114")){
                                    ++num;
                                }else if(s[1].equals("342")){
                                    ++aan;
                                }
                            }
                        }
                    }
                }else{
                    FileInputStream fileInputStream = new FileInputStream(file1);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String aa = "";
                    while ((aa = bufferedReader.readLine()) != null){
                        if(!aa.startsWith("#")){
                            String[] s = aa.split(" ");
                            strings.add(s[1]);
                            stringBuilder.append(s[1] + "\n");
                            if(!hashMap.containsKey(s[1])){
                                hashMap.put(s[1],1);
                            }else {
                                hashMap.put(s[1],hashMap.get(s[1]) + 1);
                            }


                            if(s[1].equals("114")){
                                ++num;
                            }else if(s[1].equals("342")){
                                ++aan;
                            }
                        }
                    }
                }




            }


            System.out.println(hashMap.toString());

            System.out.println(aan);
            return hashMap.toString();
           /* File file1 = new File("D:\\ddd.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(stringBuilder.toString().getBytes());*/





        }
        return null;

    }



    public void test(){

    }

}

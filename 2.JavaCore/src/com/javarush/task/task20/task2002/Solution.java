package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter writer = new PrintWriter(outputStream);
            int size = users.size();
            writer.println(size);

            if(size>0) {


                for(User user : users) {


                        String isFirstName = user.getFirstName() != null ? "yes" : "no";
                        writer.println(isFirstName);
                        if (user.getFirstName() != null)
                            writer.println(user.getFirstName());

                        String isLastName = user.getLastName() != null ? "yes" : "no";
                        if (user.getLastName() != null)
                            writer.println(isLastName);
                        writer.println(user.getLastName());

                        String isBirthDate = user.getBirthDate() != null ? "yes" : "no";
                        if (user.getBirthDate() != null)
                            writer.println(isBirthDate);
                        writer.println(user.getBirthDate().getTime());

                        writer.println(user.isMale());

                        String isCountry = user.getCountry() != null ? "yes" : "no";
                        if (user.getCountry() != null)
                            writer.println(isCountry);
                        writer.println(user.getCountry());

                }


            }

            writer.flush();



            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while(reader.ready()) {
                int size = Integer.parseInt(reader.readLine());

                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        User user = new User();
                        if (reader.readLine().equals("yes"))
                            user.setFirstName(reader.readLine());

                        if (reader.readLine().equals("yes"))
                            user.setLastName(reader.readLine());

                        if (reader.readLine().equals("yes"))
                            user.setBirthDate(new Date(Long.parseLong(reader.readLine())));

                        user.setMale(Boolean.parseBoolean(reader.readLine()));

                        if (reader.readLine().equals("yes"))
                            user.setCountry(User.Country.valueOf(reader.readLine()));

                        users.add(user);
                    }

                }
            }









            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

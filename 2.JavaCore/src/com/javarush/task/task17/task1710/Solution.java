package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    /*
    -c name sex bd
    -u id name sex bd
    -d id
    -i id
     */
    public static void main(String[] args) throws ParseException {
        String parameter = args[0];

        if(parameter.equals("-c")) {
            String sex = args[2];
            if (sex.equals("м")) {
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                System.out.println(allPeople.size()-1);
            } else if(sex.equals("ж")) {
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                System.out.println(allPeople.size()-1);
            }
        }
        else if(parameter.equals("-u")) {

            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));

        }
        else if(parameter.equals("-d")) {

            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);


        }
        else if(parameter.equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            StringBuilder builder = new StringBuilder();
            builder.append(person.getName());

            builder.append(person.getSex()==Sex.MALE ? " м " : " ж ");

            builder.append(dateFormat.format(person.getBirthDay()));
            System.out.println(builder.toString());

        }

        //start here - начни тут
    }
}

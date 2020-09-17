/*
    Given two strings, write a function to determine if the secon String is an anagram of the first. An
    anagram is a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from
    iceman
    eg :
    valid('aaz','zza');//fasle
    valid('anagram','nagaram')//true
    valid('rat','cat')//false
*/
import java.util.*;

class CheckForAnagram{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First String");
        String s1 = sc.nextLine();
        System.out.println("Enter the next String");
        String s2 =sc.nextLine();
        boolean status;
        sc.close();
        if(s1.length()!=s2.length()){
            status=false;
        }else{
            char arrS1[]=s1.toLowerCase().toCharArray();
            char arrS2[]=s2.toLowerCase().toCharArray();
            Arrays.sort(arrS1);
            Arrays.sort(arrS2);
            status  = Arrays.equals(arrS1,arrS2);
        }
        if(status){
            System.out.println("true");
        }else{
            System.out.println("False");
        }


    }

}
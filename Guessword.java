import java.util.Random;
import java.util.Scanner;

public class Guessword {
    private String [] str = {"anniversary", "amphitheater", "bankruptcy", "development", "judgment", "marshmallow", "millennium", "consequences", "irreversible", "extraordinary"};
    private int tries = 10;
    private int index = 0;
    String correct = "";
    String s = "";
    String miss = "";
    String guess = "";
    public String gameStart(){
        int min = 0;
        int max = str.length-1;
        int random = min + (int)(Math.random() * ((max - min) + 1));
        String ans = str[random];
        for (int i = 0; i < ans.length(); i++){
            if (i % 3 != 0){
                s += ans.charAt(i);
            }
            else{
                s += "*";
                correct += ans.charAt(i);
            }
        }
        return(s);
    }

    public boolean getCharfromUser(String s) throws Exception {
        boolean flag = false;
        guess = s;
        if (s.matches("[0-9]")){
            throw new Exception("Input is mismatched");
        }
        else{
            tries--;
        }
        if (s.matches(String.valueOf(correct.charAt(index)))){
            index++;
            flag = true;
        }
        else{
            miss += s;

        }
        System.out.println("Miss: "+ miss);
        System.out.println("Try: "+ tries);
        System.out.println("Guess: "+ guess);
        return(flag);
    }

    public boolean isGameFinished(){
        boolean flag = tries != 0;
        return flag;
    }


    public static void main(String[] args) {
        Guessword g = new Guessword();
        String s = g.gameStart();
        Scanner sc = new Scanner(System.in);

        while(g.isGameFinished() && s.indexOf("*") != -1) {
            System.out.println("Word: " + s);
            try {
                String s1 = sc.next();
                boolean b = g.getCharfromUser(s1);
                if (b){
                    int c = s.indexOf("*");
                    s = s.substring(0, c)+s1+s.substring(c+1);
                }

            } catch (Exception e) {
                if (e.getMessage().equals("Input is mismatched")) {
                    System.out.println("Input is mismatced");
                }
            }
        }
        if(!g.isGameFinished() && s.indexOf("*") != -1){
            System.out.println("Game Over!");
        }
        else{
            System.out.println("Congratulations! The word is: "+ s);
        }

    }
}

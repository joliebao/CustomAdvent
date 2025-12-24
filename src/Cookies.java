import java.util.ArrayList;
import java.util.Arrays;

public class Cookies {
    ArrayList<String> votes = new ArrayList<String>();
    String[][] arr;
    int sugar;
    int butter;
    int chocolateChip;
    int gingerBread;

    int sug = 0;
    int but = 0;
    int choc = 0;
    int ging = 0;

    public Cookies(ArrayList<String> lines){
        votes = lines;
    }

    // part 1
    private void tally(){
        for (String row: votes){
            while (!row.isBlank()) {
                if (row.contains("O")) {
                    sugar++;
                    row = row.substring(0, row.indexOf("O")) + row.substring(row.indexOf("O")+1);
                } else if (row.contains("*")) {
                    butter++;
                    row = row.substring(0, row.indexOf("*")) + row.substring(row.indexOf("*")+1);
                } else if (row.contains("@")) {
                    chocolateChip++;
                    row = row.substring(0, row.indexOf("@")) + row.substring(row.indexOf("@")+1);
                } else {
                    gingerBread++;
                    row = row.substring(0, row.indexOf("0")) + row.substring(row.indexOf("0")+1);
                }
            }
        }
    }

    public int mostCookie(){
        tally();
        // List cookie counts
        System.out.println("Sugar: " + sugar);
        System.out.println("Butter: " + butter);
        System.out.println("Chocolate Chip: " + chocolateChip);
        System.out.println("Gingerbread: " + gingerBread);
        System.out.println();
        int cookie = Math.max(sugar, Math.max(butter, Math.max(chocolateChip, gingerBread)));
        // clearing for part 2
        sugar = 0;
        butter = 0;
        chocolateChip = 0;
        gingerBread = 0;
        return cookie;
    }

    // part 2
    private String[][] makeArray(){
        int arrSize = (votes.getFirst().length() + 1) / 2;
        String[][] twoDArray = new String[arrSize][arrSize];

        for (int r = 0; r < votes.size(); r++){
            String[] array = votes.get(r).split(" ");
            for (int c = 0; c < twoDArray[0].length; c++){
                twoDArray[r][c] = array[c];
            }
        }

        return twoDArray;
    }

    private void checkSpot(int r, int c){
        if (arr[r][c].equals("O")){
            sug ++;
        } else if (arr[r][c].equals("*")){
            but++;
        } else if (arr[r][c].equals("@")){
            choc++;
        } else if (arr[r][c].equals("0")){
            ging++;
        }
    }

    private void checkSides(int r, int c){
        // reset values
        sug = 0;
        but = 0;
        choc = 0;
        ging = 0;

        checkSpot(r-1, c-1);
        checkSpot(r-1,c);
        checkSpot(r-1, c+1);
        checkSpot(r,c+1);
        checkSpot(r, c-1);
        checkSpot(r-1,c+1);
        checkSpot(r-1, c);
        checkSpot(r-1,c-1);

        int majority = Math.max(sug, Math.max(but, Math.max(choc, ging)));

        if (majority == sug) {
            sugar++;
        } else if (majority == but) {
            butter++;
        } else if (majority == choc) {
            chocolateChip++;
        } else if (majority == ging){
            gingerBread++;
        }
    }

    public int clusteredMostCookie(){
        arr = makeArray();
        for (int r = 1; r < arr.length; r+=3){
            for (int c = 1; c < arr[0].length; c+=3){
                checkSides(r, c);
            }
        }
        // List cookie counts
        System.out.println("Sugar: " + sugar);
        System.out.println("Butter: " + butter);
        System.out.println("Chocolate Chip: " + chocolateChip);
        System.out.println("Gingerbread: " + gingerBread);
        System.out.println();

        return Math.max(sugar, Math.max(butter, Math.max(chocolateChip, gingerBread)));
    }
}

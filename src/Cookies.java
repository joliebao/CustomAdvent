import java.util.ArrayList;

public class Cookies {
    ArrayList<String> votes = new ArrayList<String>();
    int sugar;
    int butter;
    int chocolateChip;
    int gingerBread;

    public Cookies(ArrayList<String> lines){
        votes = lines;
    }

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
        int cookie = Math.max(sugar, Math.max(butter, Math.max(chocolateChip, gingerBread)));
        return cookie;
    }

//    public long totalCookie() {
//
//    }
//
//    private long factorial(int elves){
//        if (elves > 0){
//            factorial(elves - 1);
//        }
//    }
}

public class InputMaker {
    String input = "";

    public InputMaker() {
        for (int i = 1; i <= Math.pow(120,2); i++) {
            double r = Math.random();
            if (r <= 0.25){
                input += "O ";
            } else if (r <= .5){
                input += "* ";
            } else if (r <= .75){
                input += "@ ";
            } else {
                input += "0 ";
            }
            if (i % 120 == 0){
                input += "\n";
            }
        }
    }

    public void getInput(){
        System.out.println(input);
    }
}

public class InputMaker {
    String input = "";

    public InputMaker() {
        for (int i = 0; i < Math.pow(120,2); i++) {
            double r = Math.random();
            if (r <= 0.25){
                input += "O";
            }
            if (i % 120 == 0){
                input += "\n";
            }
        }
    }

    public String getInput(){
        return input;
    }
}

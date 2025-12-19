public class InputMaker {
    String input = "";

    public InputMaker() {
        for (int i = 0; i < Math.pow(120,2); i++) {
            
            if (i % 120 == 0){
                input += "\n";
            }
        }
    }

    public String getInput(){
        return input;
    }
}

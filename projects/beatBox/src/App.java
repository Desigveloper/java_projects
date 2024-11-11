public class App {
    public static void main(String[] args) {
        //new BeatBox().buildGui();
        DailyAdviceServer server = new DailyAdviceServer();
        server.connect();
        
        DailyDevAdviceClient client = new DailyDevAdviceClient();
        client.printAdvice();
    }
}
package menus;

public class WelcomeScreen {

    public static void display() {
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println("                Welcome to ZaikaBharat CLI  ");
        System.out.println("               --- Tales Woven in Flavors ---");
        System.out.println("══════════════════════════════════════════════════════════\n");

        System.out.println("A command-line journey through India's rich culinary traditions.");
        System.out.println("Brought to you by:");
        System.out.println("--Ishita_Awasthi   --id: S24CSEU0690");
        System.out.println("--Jagriti_Shukla   --id: S24CSEU0684");
        System.out.println("--Jai_Gupta        --id: S24CSEU0683");
        System.out.println("--Kaavya_K_Yadav   --id: S24CSEU0651");
        System.out.println("Connect: linkedin.com/in/yourprofile | instagram.com/yourprofile");

        System.out.println("\n══════════════════════════════════════════════════════════\n");

        simulateLoading();
    }

    private static void simulateLoading() {
        String[] loadingStages = {
                "Loading delicious recipes... 🍲",
                "█▒▒▒▒▒▒▒▒▒▒ 10%",
                "███▒▒▒▒▒▒▒▒ 30%",
                "█████▒▒▒▒▒▒ 50%",
                "███████▒▒▒▒ 70%",
                "███████████ 100%",
                "Ready to cook! 🍽️\n"
        };

        try {
            for (String stage : loadingStages) {
                System.out.println(stage);
                Thread.sleep(400);  // 400 milliseconds pause
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

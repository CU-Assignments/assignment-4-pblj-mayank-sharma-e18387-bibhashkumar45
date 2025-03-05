import java.util.*;

class CardCollection {
    private Map<String, List<String>> cards = new HashMap<>();

    public void add(String symbol, String card) {
        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(card);
    }

    public List<String> find(String symbol) {
        return cards.getOrDefault(symbol, Collections.emptyList());
    }
}

public class CardSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardCollection cc = new CardCollection();

        cc.add("Hearts", "Ace");
        cc.add("Hearts", "King");
        cc.add("Spades", "Queen");
        cc.add("Diamonds", "Jack");

        System.out.print("Enter symbol to search (Hearts/Spades/Diamonds): ");
        String symbol = sc.nextLine();
        List<String> result = cc.find(symbol);

        if (result.isEmpty()) {
            System.out.println("No cards found for " + symbol);
        } else {
            System.out.println(symbol + " Cards: " + result);
        }
        sc.close();
    }
}

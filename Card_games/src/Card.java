
public class Card{
    String suit;
    int value;
    
    public Card(String suit,String value){
        String[] cardNames = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        this.value = 999;  // if invalid face string is given set 999
        for(int i=0;i<cardNames.length;i++){
            if(cardNames[i].equals(value.trim())){
                this.value = i;
                break;
            }
        }
        this.suit=suit;
    }
}

import java.util.ArrayList;

public class Main{
	
     //returns the sequence of the cards are correct or not
    public static boolean checkSequence(String cards){
        //split all the cards and store in card array
        String[] cardArray = cards.split(",");
        //convert card array into card object arrayList
        ArrayList<Card> cardList = new ArrayList<Card>();
        int numCards = cardArray.length;
        //if there is less than 3 cards eliminate deck
        if(numCards < 3) return false;
        //store suit and face value in card object
        for(int i=0;i<numCards;i++){
            Card c = new Card(cardArray[i].split("#")[0].trim(),cardArray[i].split("#")[1].trim());
            cardList.add(c);
        }
        int i=0;
        String cardSuit="",nextCardSuit="";
        int cardValue=-1,nextCardValue=-1,prevCardValue = -1;
        
        //loop till penultimate card
        for(i=0; i<numCards-1 ;i++){  
            
            cardValue = cardList.get(i).value;
            nextCardValue = cardList.get(i+1).value;
            cardSuit = cardList.get(i).suit;
            nextCardSuit = cardList.get(i+1).suit;
            
            //suit check
            if(!cardSuit.equals(nextCardSuit)) return false;
            
            //card check
            if(cardValue != nextCardValue-1){
                
                //exception only for queen followed by king followed by ace
                if(!(prevCardValue==11 && cardValue == 12 && nextCardValue ==0)){
                    return false;
                }
            }
            //execption for king followed by ace followed by 2
            if(prevCardValue == 12 && cardValue == 0 && nextCardValue==1)  return false;
            prevCardValue = cardValue;
        }
        
        return true;
    }

     
     
     public static void main(String []args){
         
         String seq1 = "H#Q,H#K,H#A";
         String seq2= "C#Q,C#K,C#A,C#2";
         
         if(checkSequence(seq1)){
             System.out.println("ok");
         }else{
             System.out.println("not ok");
         }
        
     }
}


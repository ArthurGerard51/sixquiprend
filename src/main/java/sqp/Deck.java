package sqp;

import java.util.ArrayList;
import java.util.Collections;

import static sqp.Card.*;

public class Deck {

    private final ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
        addCardsToDeck();
        Collections.shuffle(deck);
    }

    private void addCardsToDeck() {
        deck.add(C_1);
        deck.add(C_2);
        deck.add(C_3);
        deck.add(C_4);
        deck.add(C_5);
        deck.add(C_6);
        deck.add(C_7);
        deck.add(C_8);
        deck.add(C_9);
        deck.add(C_10);
        deck.add(C_11);
        deck.add(C_12);
        deck.add(C_13);
        deck.add(C_14);
        deck.add(C_15);
        deck.add(C_16);
        deck.add(C_17);
        deck.add(C_18);
        deck.add(C_19);
        deck.add(C_20);
        deck.add(C_21);
        deck.add(C_22);
        deck.add(C_23);
        deck.add(C_24);
        deck.add(C_25);
        deck.add(C_26);
        deck.add(C_27);
        deck.add(C_28);
        deck.add(C_29);
        deck.add(C_30);
        deck.add(C_31);
        deck.add(C_32);
        deck.add(C_33);
        deck.add(C_34);
        deck.add(C_35);
        deck.add(C_36);
        deck.add(C_37);
        deck.add(C_38);
        deck.add(C_39);
        deck.add(C_40);
        deck.add(C_41);
        deck.add(C_42);
        deck.add(C_43);
        deck.add(C_44);
        deck.add(C_45);
        deck.add(C_46);
        deck.add(C_47);
        deck.add(C_48);
        deck.add(C_49);
        deck.add(C_50);
        deck.add(C_51);
        deck.add(C_52);
        deck.add(C_53);
        deck.add(C_54);
        deck.add(C_55);
        deck.add(C_56);
        deck.add(C_57);
        deck.add(C_58);
        deck.add(C_59);
        deck.add(C_60);
        deck.add(C_61);
        deck.add(C_62);
        deck.add(C_63);
        deck.add(C_64);
        deck.add(C_65);
        deck.add(C_66);
        deck.add(C_67);
        deck.add(C_68);
        deck.add(C_69);
        deck.add(C_70);
        deck.add(C_71);
        deck.add(C_72);
        deck.add(C_73);
        deck.add(C_74);
        deck.add(C_75);
        deck.add(C_76);
        deck.add(C_77);
        deck.add(C_78);
        deck.add(C_79);
        deck.add(C_80);
        deck.add(C_81);
        deck.add(C_82);
        deck.add(C_83);
        deck.add(C_84);
        deck.add(C_85);
        deck.add(C_86);
        deck.add(C_87);
        deck.add(C_88);
        deck.add(C_89);
        deck.add(C_90);
        deck.add(C_91);
        deck.add(C_92);
        deck.add(C_93);
        deck.add(C_94);
        deck.add(C_95);
        deck.add(C_96);
        deck.add(C_97);
        deck.add(C_98);
        deck.add(C_99);
        deck.add(C_100);
        deck.add(C_101);
        deck.add(C_102);
        deck.add(C_103);
        deck.add(C_104);
    }

    public Card drawTopCard(){
        Card drawnCard = deck.get(0);
        deck.remove(0);
        return drawnCard;
    }

}

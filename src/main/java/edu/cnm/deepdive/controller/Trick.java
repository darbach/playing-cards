package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Pile;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class Trick {

  public static final String PILE_FORMAT = "%s pile: %s%n";
  private final Pile redPile;
  private final Pile blackPile;

  public Trick() {
    this.redPile = new Pile();
    this.blackPile = new Pile();
  }

  public static void main(String[] args) {

    Deck deck = new Deck();
    Trick trick = new Trick();
    Random rng = new SecureRandom();

    //split the deck into our two piles
    deck.shuffle(rng);
    trick.split(deck);
    trick.swap(rng);
    trick.sort();
    trick.display();
  }

  private void split(Deck deck) {
    boolean routing = false; // Are we blindly adding card to a Pile?
    Pile destination = null;
    for (Card card : deck) {
      if (routing) {
        destination.add(card);
      } else { // not routing
        switch (card.getSuit()) {
          case CLUBS:
          case SPADES:
            destination = blackPile;
            break;
          case DIAMONDS:
          case HEARTS:
            destination = redPile;
            break;
        }
      }
      routing = !routing;
    }
  }

  private void swap (Random rng) {
    //size of the smaller pile is the most number of times we can swap a card
    int swapCount = rng.nextInt(1 + Math.min(redPile.size(), blackPile.size()));
    for(int i = 0; i < swapCount; i++) {
      //draw from the front and put on back of other pile
      blackPile.add(redPile.draw());
      redPile.add(blackPile.draw());
    }
  }

  private void sort() {
    //compare colors
    Comparator<Card> comparator = Comparator.comparing((Card card) -> card.getSuit().getColor())
        .thenComparing(Card::getSuit) // same, so compare suit
        .thenComparing(Card::getRank); // same suit, look at rank
    redPile.sort(comparator);
    blackPile.sort(comparator);
  }

  private void display() {
    System.out.printf(PILE_FORMAT, "Red", redPile);
    System.out.printf(PILE_FORMAT, "Black", blackPile);
  }

}

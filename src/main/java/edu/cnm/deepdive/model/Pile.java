package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Pile {

  private final List<Card> cards;

  /**
   * Constructor
   */
  public Pile() {
    this.cards = new ArrayList<>();
  }

  /**
   * Add a card to the Pile.
   * @param card
   */
  public void add(Card card) {
    cards.add(card);
  }

  /**
   * Remove a card from the pile.
   * @return The card that is drawn.
   */
  public Card draw() {
    return cards.remove(0);
  }

  /**
   * Shuffle the pile.
   * @param rng Provided Random object.
   */
  public void shuffle(Random rng) {
    Collections.shuffle(cards, rng);
  }

  /**
   * Sort the pile by suit and rank.
   */
  public void sort() {
    Collections.sort(cards);
  }

  /**
   * Sort the pile using a comparator for Card class.
   * @param comparator
   */
  public void sort(Comparator<Card> comparator) {
    cards.sort(comparator);
  }

  /**
   * Removes all Cards from the Pile.
   */
  public void clear() {
    cards.clear();
  }

  /**
   * Number of cards in the Pile.
   * @return
   */
  public int size() {
    return cards.size();
  }

  /**
   * Get the String output of a Pile.
   * @return
   */
  @Override
  public String toString() {
    return cards.toString();
  }
}

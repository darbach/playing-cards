package edu.cnm.deepdive.model;

public class Card implements Comparable<Card> {

  private final Rank rank;
  private final Suit suit;

  /**
   *
   * @param rank
   * @param suit
   */
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  /**
   *
   * @return The Rank for this card.
   */
  public Rank getRank() {
    return rank;
  }

  /**
   *
   * @return
   */
  public Suit getSuit() {
    return suit;
  }

  public String getSymbol() {
    return String.format("%s%s", rank.symbol(), suit.symbol());
  }

  @Override
  public String toString() {
//    return String.format("%s %s", rank, suit);
    return getSymbol();
  }

  /**
   * Sorts by shrink-wrap order (i.e. brand new decks).
   * @param other
   * @return
   */
  @Override
  public int compareTo(Card other) {
    int comparison = suit.compareTo(other.suit);
    if (comparison == 0) {
      comparison = rank.compareTo(other.rank);
    }
    return comparison;
  }
}

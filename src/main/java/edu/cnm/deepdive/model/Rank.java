package edu.cnm.deepdive.model;

public enum Rank {
  ACE("A"),
  ONE("1"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  JACK("J"),
  QUEEN("Q"),
  KING("K");

  private final String symbol;

  Rank(String symbol) {
      this.symbol = symbol;
  }

  /**
   * Get the letter/number symbol associated with a card's Rank.
   * @return
   */
  public String getSymbol() {
    return symbol;
  }
}
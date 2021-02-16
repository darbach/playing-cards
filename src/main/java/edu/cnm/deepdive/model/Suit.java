package edu.cnm.deepdive.model;

public enum Suit {

  CLUBS('\u2663', Color.BLACK),
  DIAMONDS('\u2662', Color.RED),
  HEARTS('\u2661', Color.RED),
  SPADES('\u2660', Color.BLACK);

  private final char symbol;
  private final Color color;

  Suit(char symbol, Color color) {
    this.symbol = symbol;
    this.color = color;
  }

  /**
   * Get the Suit's unicode character symbol.
   * @return
   */
  public char getSymbol() {
    return symbol;
  }

  /**
   * Get the enum Color associated with the Suit.
   * @return
   */
  public Color getColor() {
    return color;
  }

  public enum Color {
    BLACK, RED
  }
}

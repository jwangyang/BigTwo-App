package com.example.bigtwo;

public class Card {
	
	private int comboPriority;
	private int rankValue, suitValue;
	private char rank, suit;
	
	public Card(char rank, char s) {
		if (rank != 'J' && rank != 'Q' && rank != 'K' && rank != 'A') {
			if (rank == 2) {
				rankValue = 15;
			} else {
				rankValue = rank;
			}
		} else {
			switch(rank) {
				case 'J':
					rankValue = 11;
					break;
				case 'Q':
					rankValue = 12;
					break;
				case 'K':
					rankValue = 13;
					break;
				case 'A':
					rankValue = 14;
					break;
				default:
					rankValue = 0;
			}
		}	
			
		suit = s;
		switch(suit) {
			case 'd':
				suitValue = 1;
				break;
			case 'c':
				suitValue = 2;
				break;
			case 'h':
				suitValue = 3;
				break;
			case 's':
				suitValue = 4;
				break;
			default: 
				suitValue = 0;
		}
		
		/*
		 * Priorities:
		 * 3-7 = 1
		 * 8-10 = 4
		 * J-K = 16
		 * A-2 = 64
		 */
		if (rankValue >= 3 && rankValue <= 7) {
			comboPriority = 1 + suitValue;
		} else {
			if (rankValue >= 8 && rankValue <= 10) {
				comboPriority = 4 + suitValue;
			} else {
				if (rankValue >= 11 && rankValue <= 13) {
					comboPriority = 16 + suitValue;
				} else {
					if (rankValue == 14 || rankValue == 15) {
						comboPriority = 64 + suitValue;
					}
				}
			}
			
		}
		
	}
	
	// assume we cannot compare a card with the exact same card
	public boolean isGreater(Card other) {
		if (this.rankValue < other.rankValue) {
			return false;
		}
		if (this.rankValue > other.rankValue) {
			return true;
		}
		if (this.suitValue > other.suitValue) {
			return true;
		}
		return false;
	}
	
	public String displayCard(Card c) {
		return "[" + this.rank + this.suit + "]";
	}
	
}
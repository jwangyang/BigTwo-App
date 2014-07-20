package com.example.bigtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
	
	private List<Card> hand;
	
	public Hand(List<Card> initialHand) {
		hand = new ArrayList<Card>();
		for(Card c: initialHand) {
			hand.add(c);
		}
	}
	
	// used randomized quickSort to sort the hand
	public void sortHand(int start, int end) {
		if ((end - start) < 2) {
			return;
		}
		Random tempRand = new Random();
		int pivotIndex = tempRand.nextInt((end - start) + 1) + start;
		Card pivot = hand.get(pivotIndex);
		swap(start, pivotIndex);
		// pivot is now the first Card in the hand
		int counter = start + 1;
		pivotIndex = 0;
		while (counter < end) {
			if (pivot.isGreater(hand.get(counter))) {
				Card temp = hand.get(counter);
				hand.remove(counter);
				// loop invariant: counter is always to the right of pivotIndex 
				for (int i = counter - 1; i >= pivotIndex; i--) {
					hand.set(i + 1, hand.get(i));
				}
				hand.add(pivotIndex, temp);
				counter++;
				pivotIndex++;
			} else {
				counter++;
			}
		}	
		sortHand(start, pivotIndex);
		sortHand(pivotIndex + 1, end);
		return;
	}
	
	public void swap(int i, int j) {
		if (i != j) {
			Card temp = hand.get(i);
			hand.set(i, hand.get(j));
			hand.set(j, temp);
		}	
	}
	
	public int getSize() {
		
		return hand.size();
	
	}
}
package com.liquidforte.rats

import java.util.Random;

class Rat extends Enemy {
	static Random random = new Random()
	static int MAX_HEALTH = 5
	int health = MAX_HEALTH
	
	static int MIN_DAMAGE = 0
	static int MAX_DAMAGE = 3
	
	static int MIN_GOLD = 1
	static int MAX_GOLD = 10
	
	static int MIN_GEMS = 0
	static int MAX_GEMS = 3
	
	static int MIN_EXP = 1
	static int MAX_EXP = 5
	
	int getMaxHealth() {
		return MAX_HEALTH
	}
	
	int getMinDamage() {
		return MIN_DAMAGE
	}
	
	int getMaxDamage() {
		return MAX_DAMAGE
	}
	
	int getGold() {
		return MIN_GOLD + random.nextInt(MAX_GOLD - MIN_GOLD)
	}
	
	int getGems() {
		return MIN_GEMS + random.nextInt(MAX_GEMS - MIN_GEMS)
	}
	
	int getExp() {
		return MIN_EXP + random.nextInt(MAX_EXP - MIN_EXP)
	}
}

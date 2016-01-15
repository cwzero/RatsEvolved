package com.liquidforte.rats

import java.util.Random

class Player extends Entity {
	static Random random = new Random()
	static int[] MAX_HEALTH = [20, 25, 30, 35, 40]
	int health = MAX_HEALTH[0]
	
	static int[] MIN_DAMAGE = [1, 2, 3, 4, 5]
	static int[] MAX_DAMAGE = [8, 12, 16, 20, 24]
	
	int gold = 0
	int gems = 0
	int potions = 0
	
	int deaths = 0
	int kills = 0
	
	static int MAX_LEVEL = 5
	static int[] LEVEL_XP = [20, 40, 80, 160, 320]
	
	int experience = 0
	int level = 0
	int[] damageReduction = [0, 1, 2, 3, 4]
	
	Armor armor = null
	Weapon weapon = null
	
	Armor getArmor() {
		return armor
	}
	
	Weapon getWeapon() {
		return weapon
	}
	
	int getMaxHealth() {
		return MAX_HEALTH[level] + armor.getBonusHealth()
	}
	
	int getMinDamage() {
		return MIN_DAMAGE[level] + getWeapon().getMinDamage()
	}
	
	int getMaxDamage() {
		return MAX_DAMAGE[level] + getWeapon().getMaxDamage()
	}
	
	int getDamageReduction() {
		return damageReduction[level] + armor.getDamageReduction()
	}

	void usePotion() {
		if (potions >= 1) {
			potions--
			health = getMaxHealth()
			println('You drink a potion, restoring your health to maximum.')
		} else {
			println('You don\'t have any potions to drink.')
		}
	}

	void playerDeath() {
		println('You have died. You lose all gold, gems and potions.')
		gold = 0
		gems = 0
		potions = 0
		deaths++
		health = getMaxHealth()
	}
}

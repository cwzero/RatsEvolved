package com.liquidforte.rats

abstract class Entity {
	abstract int getHealth()
	abstract int getMaxHealth()

	abstract int getMaxDamage()
	abstract int getMinDamage()

	static Random random = new Random()

	int getDamage() {
		return getMinDamage() + random.nextInt(getMaxDamage() - getMinDamage())
	}
}

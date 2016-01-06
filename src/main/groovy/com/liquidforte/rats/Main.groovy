package com.liquidforte.rats

class Main {
	static Random random = new Random()
	static boolean finished = false

	static Player player = new Player()
	static Rat rat

	static Reader reader = System.in.newReader()

	static main(args) {
		println('Welcome to Rats Evolved.')
		println('-----------------------------------------------------------')
		println()
		println('A rat appears.')
		rat = new Rat()
		while (!finished)
			menu()
	}

	static menu() {
		println()
		println('You have killed ' + player.kills + ' rats, and died ' + player.deaths + ' times.')
		println('Rat health: ' + rat.health + ' / ' + rat.MAX_HEALTH + ' health.')
		println('Player health: ' + player.health + ' / ' + player.MAX_HEALTH[player.level] + ' health.')
		println('You have ' + player.gold + ' gold, ' + player.gems + ' gems, and ' + player.potions + ' potions.')
		println('You have ' + player.experience + ' experience and are level ' + (player.level + 1) + '.')
		println()
		println('Menu:')
		println('1) Attack (a)')
		println('2) Drink a potion (p)')
		println('3) Store (s)')
		println('4) Quit (q)')
		print('Choose an option: ')
		String option = reader.readLine()
		println('-----------------------------------------------------------')
		println()
		switch (option.toLowerCase().charAt(0)) {
			case 'a':
			case '1':
				attack()
				break
			case 'p':
			case '2':
				player.usePotion()
				break
			case 's':
			case '3':
				Store.store()
				break
			case 'q':
			case '4':
				quit()
				break
			default:
				menu()
				break
		}
	}

	static attack() {
		int damage = player.getDamage()
		rat.health -= damage
		if (rat.health > 0) {
			println ('You attack the rat, doing ' + damage + ' damage. The rat has ' + rat.health + ' / ' + rat.MAX_HEALTH + ' health.' )
		} else {
			println ('You attack the rat, doing ' + damage + ' damage and killing it.')
			ratKill()
		}
		ratTurn()
	}

	static ratTurn() {
		int ratDamage = rat.getDamage()
		player.health -= ratDamage
		if (player.health > 0) {
			println ('The rat attacks you, doing ' + ratDamage + ' damage. You have ' + player.health + ' / ' + player.MAX_HEALTH + ' health.')
		} else {
			println ('The rat attacks you, doing ' + ratDamage + ' damage and killing you.')
			player.playerDeath()
		}
	}

	static ratKill() {
		player.kills++
		int gold = rat.getGold()
		int gems = rat.getGems()
		int exp = rat.getExp()

		println('You find ' + gold + ' gold and ' + gems + ' gems.')
		player.gold += gold
		player.gems += gems

		player.experience += exp
		println('You gain ' + exp + ' experience and now have ' + player.experience + ' experience.')
		if (player.experience > Player.LEVEL_XP[player.level]) {
			player.level++
			player.health = Player.MAX_HEALTH[player.level]
			println('You have gained a level! You are now level ' + (player.level + 1) + '. You now have ' + player.health + 'health.')
		}
		println('You have ' + player.gold + ' gold and ' + player.gems + ' gems.')
		println ('A new rat appears.')

		rat = new Rat()
	}

	static quit() {
		finished = true
	}
}

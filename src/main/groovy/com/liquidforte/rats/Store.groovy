package com.liquidforte.rats

class Store {
	static store() {
		println('Store Menu:')
		println('You have ' + Main.player.gold + ' gold and ' + Main.player.gems + ' gems, and ' + Main.player.potions + ' potions.')
		println('1) Buy Potion - 20 Gold (p)')
		println('2) Back (b)')
		print('Choose an option: ')
		String option = Main.reader.readLine()
		println('-----------------------------------------------------------')
		println()
		switch (option.toLowerCase().charAt(0)) {
			case '1':
			case 'p':
				buyPotion()
			break
			case '2':
			case 'b':
				Main.menu()
			break
			default:
				store()
			break
		}
	}
	
	static buyPotion() {
		if (Main.player.gold >= 20) {
			Main.player.gold -= 20
			Main.player.potions++
			println('You buy a potion. You now have ' + Main.player.potions + ' potions.')
		} else {
			println('You don\'t have the gold for a potion.')
		}
		store()
	}
}

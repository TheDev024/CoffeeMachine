package machine

enum class State {
    CHOOSING_ACTION, CHOOSING_COFFEE_TYPE
}

class CoffeeMachine(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var coffee: Int = 120,
    private var cups: Int = 9,
    private var money: Int = 550,
) {

    private var state: State

    init {
        state = State.CHOOSING_ACTION
        start()
    }

    private fun start() {
        while (true) {
            // get user input
            println(
                if (state == State.CHOOSING_ACTION) "Write action (buy, fill, take, remaining, exit):"
                else "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
            )
            val userInput = readln()

            when (state) {
                State.CHOOSING_ACTION -> {
                    when (userInput) {
                        "buy" -> state = State.CHOOSING_COFFEE_TYPE

                        "fill" -> fillMachine()

                        "take" -> takeMoney()

                        "remaining" -> printRemaining()

                        "exit" -> break
                    }
                }

                State.CHOOSING_COFFEE_TYPE -> {
                    state = State.CHOOSING_ACTION
                    if (userInput == "back") continue
                    else buyCoffee(userInput.toInt())
                }
            }
        }
    }

    private fun makeCoffee(coffeeType: Int) {
        this.cups -= 1

        when (coffeeType) {
            1 -> {
                this.water -= 250
                this.coffee -= 16
                this.money += 4
            }

            2 -> {
                this.water -= 350
                this.milk -= 75
                this.coffee -= 20
                this.money += 7
            }

            3 -> {
                this.water -= 200
                this.milk -= 100
                this.coffee -= 12
                this.money += 6
            }
        }
    }

    private fun hasEnoughResource(coffeeType: Int): Boolean {
        val waterReq: Int
        val milkReq: Int
        val coffeeReq: Int
        val cupsReq = 1

        when (coffeeType) {
            1 -> {
                waterReq = 250
                milkReq = 0
                coffeeReq = 16
            }

            2 -> {
                waterReq = 350
                milkReq = 75
                coffeeReq = 20
            }

            else -> {
                waterReq = 200
                milkReq = 100
                coffeeReq = 12
            }
        }

        when {
            this.water < waterReq -> {
                println("Sorry, not enough water!")
                return false
            }

            this.milk < milkReq -> {
                println("Sorry, not enough milk!")
                return false
            }

            this.coffee < coffeeReq -> {
                println("Sorry, not enough coffee beans!")
                return false
            }

            this.cups < cupsReq -> {
                println("Sorry, not enough disposable cups!")
                return false
            }

            else -> {
                println("I have enough resources, making you a coffee!")
                return true
            }
        }
    }

    private fun buyCoffee(coffeeType: Int) {
        if (hasEnoughResource(coffeeType)) makeCoffee(coffeeType)
    }

    private fun printRemaining() {
        println(
            "The coffee machine has:\n" +
                    "${this.water} ml of water\n" +
                    "${this.milk} ml of milk\n" +
                    "${this.coffee} g of coffee beans\n" +
                    "${this.cups} disposable cups\n" +
                    "\$${this.money} of money\n"
        )
    }

    private fun takeMoney() {
        println("I gave you \$${this.money}")
        this.money = 0
    }

    private fun fillMachine() {
        println("Write how many ml of water you want to add:")
        this.water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        this.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        this.coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        this.cups += readln().toInt()
    }
}

fun main() {
    val machine = CoffeeMachine()
}

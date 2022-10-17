// write your class here
class LewisCarrollBook(
    name: String = "",
    author: String = "Lewis Carroll",
    price: Int = 0
) {
    var name: String = name
        get() {
            println("The name of the book is $field")
            return field
        }
        set(value) {
            field = value
            println("Now, a book called $value")
        }
    var author: String = author
        get() {
            println("The author of the book is $field")
            return field
        }

    var price: Int = price
        set(value) {
            println("Putting a new price...\nThe new price is $value")
            field = value
        }
}

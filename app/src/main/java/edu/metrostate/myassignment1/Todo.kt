package edu.metrostate.myassignment1

data class Todo(
    var index: Int,
    var item: String
)

fun getInitialList(): List<Todo> {
    return listOf<Todo>(
        Todo(1,"Clean the bathroom"),
        Todo(2,"Wash the car"),
        Todo(3,"Do the laundry"),
        Todo(4,"Take out the trash"),
        Todo(5,"Water the garden")
    )
}


package edu.yeditepe.courserplanner.week3example

fun main(args : Array<String>){

    val stud1 = Student(1,"Engin", "Kandıran")
    val stud2 = Student(2)
    val stud3  = Student(name = "Mehmet",id = 5,surname= "Yazgin")
    val stud4 = Student(10,3.0)
    println(stud1.gpa)
    val stud5 = GraduateStudent(20,"Ayse","Basarir",
                   "Engin Kandiran")

    println(stud5.name)
}


open class Student(val id: Int,
    var name: String = "Name",
    var surname: String = "Surname",
    var department: String = "SD"
    ){
    var gpa: Double = -1.0
    val fullName : String
        get() = "$name $surname"//custom getter example
    constructor(id: Int, gpa: Double): this(id){
        this.gpa = gpa
    }
    init{
        println("New Student is instantiated!!!")

    }

    fun summary(): String{

        return "Student[ name: $name\n" +
                "surname: $surname\n" +
                "gpa: $gpa\n" +
                "]\n"

    }


}

class GraduateStudent(id: Int,
                      name: String,
                      surname: String,
                       val advisor: String="Advisor"): Student(
                           id,
                           name,
                           surname
                       )

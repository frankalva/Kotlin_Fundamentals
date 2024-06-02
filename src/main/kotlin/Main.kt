import java.lang.NumberFormatException

fun variables(){
    /*
    String
    Int
    Double
    Float
    variable = var
    constate = val
     */

    val v1 : Int = 1 //constante cuando no va cambiar
    println(v1)
    var v2 = 2.1 // cuando va cambiar
    println(v2)
    v2 = 4.5
    println(v2)
    val text1 = "Hola"
    val text2 = "Mundo"
    println(text1 + text2)
}
fun nullSafety(){
    var x : String? = null
//    x = "Hola"
    x?.let {
        println("Hola mundo")
    }

    var id : Int? = null
    id?.let {
        println("Tiene valor")
    }
}

fun changeTypeData(){
    // cambio de tipos de datos
    val num1 = 5
    val num2 = "10"
    val res = num1+ num2.toInt()
    println(res)
    val t1 = "Hola"
    val t2 = "Mundo"
    val texto = t1 + " " + t2
    println(texto)
    println("Soy el numero: $num1")
    val resultado = t1.plus(" ").plus(t2)
    println(resultado)
    val array = arrayOf("Hola","Mundo")
    val res2 = array.joinToString(" ") //add sepatator to the array
    println(res2)
}
fun TryandWhile(){
    // escribir en la consola
    // try catch

    //bucle while
    var n1 : Double
    var n2 : Double
    while (true){
        try {
            println("Escribe el primer valor")
            n1 = readln().toDouble()
            println("Escribe el segundo valor")
            n2 = readln().toDouble()
            println("La suma de los dos valores es ${n1+n2}")
            break
        }catch (e: NumberFormatException){
            println("Ahi un error en al digitacion $e")
        }
    }
}

fun arrays(){
    var array = arrayOf("Frank","Diego",2,4,true)
    println(array.contentToString())
    var numbers = intArrayOf(2,3,1,8,4)
    numbers.sort()
    println(numbers.contentToString())
    var numbers_duplicates = intArrayOf(2,3,1,2,3,3,6,5,3,1)
    val duplicate = numbers_duplicates.groupBy { it }.filter { it.value.size > 1 }.keys //entendible :D
    println(duplicate)
}
fun listas(){
    val lista = listOf(1,2,3,4,5)
    println(lista)
    println(lista[0])
    val list = mutableListOf(1,2,3,4,5)  // estas si se pueden agregar
    list.add(6)
    list.remove(3)

    //eliminar en un array
    val array = arrayOf(1,2,3,4,5)
    val array2 = array.toMutableList()
    array2.remove(5)
}

fun bucleForandForEach(){
    //for
//    for (i in 1..5){
//        println(i)
//    }
//    for (i in 'a'..'c'){
//        println(i)
//    }
//    for (b in 'f' downTo 'a'){
//        println(b)
//    }
    val users = arrayOf("Luis","Ramon","Frank","Diana")
    for (i in users){
        println(i)
    }
    for (y in users.indices){
        println("[$y, ${users[y]}]")
    }

    val list = listOf(1,2,3,4,5)
    list.forEach{
        println(it)
    }

    list.forEachIndexed { index, element -> println("Posicion ${index}, valor ${element}")  }
}
fun switchWhen(){
    //switch, when

    var dia = 1
    when(dia){
        1 -> println("Lunes")
        1 -> println("Martes")
        1 -> println("Miercoles")
        1 -> println("Jueves")
        1 -> println("Viernes")
        else -> println("El numero no es valido")
    }

    val x = 5
    when(x){
        in 1..10 -> println("Esta en el rango")
        in 10..20 -> println("Esta fuera del rango")
    }
}

fun funciones(){

    // funciones lambda
    val sum = {x:Int, y:Int -> x + y}
    sum(2,3)
    // funciones con retorno

    fun division(va1:Int, va2:Int) : Int{
        return va1+va2
    }
}

class Persona(){
    // atributos (variables)
    var nombre = ""
    var edad = 0
    // constructor secundario
    constructor(nombre : String, edad: Int) : this() {
        this.edad = edad
        this.nombre = nombre
    }
    // metodos
    fun hola(){
        println("Hola me llamo $nombre y tengo $edad anios")
    }
}

class Usuarios(private var name: String, private var email: String){
    fun hola(){
        println("Tu nombre es $name y tu correo es $email")
    }
}
fun clasesitas(){
    val persona = Persona("Frank", 21)
    persona.hola()
    val user1 = Usuarios("Diego", "diego@gmail.com")
    println(user1.hola())
}

//ejemplo de programacion funcional (imperativa y declarativa)
fun sumarLista(lista: List<Int>): Int{
    //programacion imperativa
//    var resultado = 0
//    for (i in lista){
//        resultado += i
//    }
//    return resultado
    // programacion declarativa
    return lista.sum()

}

fun filtrarPares(lista: List<Int>): List<Int>{
    // programacion imperativa
//    var pares = mutableListOf<Int>()
//    for (i in lista){
//        if (i % 2 == 0){
//            pares.add(i)
//        }
//    }
//    return pares
    //programacion declarativa
    return lista.filter { it % 2 == 0 }.toList()

}

fun programacionDeclaraYImperati(){
    val lista = listOf(1,2,3,4,5)
    val resultado = sumarLista(lista)
    println(resultado)


    val lista_pares = listOf(2,3,6,7,8,12)
    val result_pares = filtrarPares(lista_pares)
    println(result_pares)
}

fun main() {

    // filter
    val nombre = listOf("Pedro","Juan","Maria","Frank")
    val filters = nombre.filter { it.contains("a", ignoreCase = true) }.sorted()
    println(filters)

    val clases = listOf(
        User("Jorge", 69),
        User("Diego", 20),
        User("Frank", 31),
        User("Mario", 12)
    )
    val results = clases.filter { it.edad > 20 }.map { it.nombre }.sorted()
    println(results)
    // map
    println("----------------MAP------------------")
    val mapeo_usuarios = clases.map { it.edad } //edades
    val mapeo_nombres = clases.map { it.nombre }
    val count_name_in = clases.map { it.nombre.length }

    println(count_name_in)

    val palabras = listOf("hola","how","are","you" )

    // reduce

    println("-------------REDUCE---------------")
    val num = listOf(3,5,1,2)
    val num_reduce = num.reduce { acc, i -> acc * i  } // 3*5 = 15 -> 15 *1 -> 15 *2 -> 30
    println(num_reduce)
}

data class User(val nombre: String, val edad: Int)
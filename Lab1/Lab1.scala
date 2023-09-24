import scala.util.Random

object Main1 {

  val inputLength: Int = 10
  val iterationsCount: Int = 5

  def handleNegative(inputString: String): String = {
    var result = inputString.tail
    val index = result.indexOf('1')
    if (index != -1) {
      result = result.updated(index, '0')
    }
    result
  }

  def updateLength(inputString: String): String = {
    val paddedString = ("1" * (inputLength - inputString.length)) + inputString
    paddedString
  }

  def main(args: Array[String]): Unit = {
    var numberString = ""
    var a = 0
    var b = 0
    var c = 0
    var rez = 0.0f
    var z = 0

    while (numberString.isEmpty || !numberString.forall(_.isDigit)) {
      println("Enter the number: ")
      numberString = scala.io.StdIn.readLine()

      if (numberString.isEmpty) {
        println("No input")
      } else if (!numberString.matches("^-?\\d+$") || numberString.length() != inputLength + (if (numberString.charAt(0) == '-') 1 else 0)) {
        println("Incorrect number")
        numberString = ""
      }
    }

    for (i <- 1 to iterationsCount) {
      if (numberString.charAt(0) == '-') {
        numberString = Main1.handleNegative(numberString)
      }
      numberString = updateLength(numberString)
      z = numberString.toInt
      println(numberString)
      a = numberString.substring(0, 5).toInt
      b = numberString.substring(5, 10).toInt
      c = a * b
      rez = c.toString().substring(0, 3).toFloat / 1000
      z += c
      println("a = " + a)
      println("b = " + b)
      println("c = " + c)
      println("rez = " + rez)
      println("z = " + z)
      numberString = z.toString
    }
  }
}

object Main2 {
  def main(args: Array[String]): Unit = {
    var numberString: String = ""
    var a: Long = 0L
    var b: Long = 0L
    var c: Long = 0L
    var result: Float = 0.0f
    var z: Long = 0L

    while (numberString.isEmpty || !numberString.matches("^-?\\d+$") || numberString.length() < 16 || numberString.charAt(0) == '-') {
      println("Enter the number: ")
      numberString = scala.io.StdIn.readLine()

      if (numberString.isEmpty) {
        println("No input")
      } else if (!numberString.matches("^-?\\d+$")) {
        println("Incorrecct input: Non-numeric characters found")
      } else if (numberString.length() < 16) {
        println("Incorrect number: Number length must be at least 16 digits")
      } else if (numberString.startsWith("-")) {
        println("Incorrect input: Number should not start with a minus sign")
      }
    }

    z = numberString.toLong

    // var resultsSet = Set.empty[Float]

    //while (resultsSet.size != 15) {
    // numberString = z.toString.stripPrefix("-").take(16)

    /*    while (numberString.length < 16) {
      val random = new Random()
      val randomDigit = random.nextInt(10)
      numberString += randomDigit
    }

    a = numberString.substring(0, 8).toInt
    b = numberString.substring(8, 16).toInt
    c = a * b
    result = c.toString().substring(0, 3).toFloat / 1000
    z *= c

    if (!resultsSet.contains(result)) {
      resultsSet += result

      //println(s"a = $a")
      //println(s"b = $b")
      //println(s"c = $c")
      //println(s"z = $z")
      println(s"result = $result")
    }
  }*/

    for (i <- 1 to 5) {
      numberString = z.toString.stripPrefix("-").take(16)

      while (numberString.length < 16) {
        val random = new Random()
        val randomDigit = random.nextInt(10)
        numberString += randomDigit
      }

      a = numberString.substring(0, 8).toInt
      b = numberString.substring(8, 16).toInt
      c = a * b
      result = c.toString().substring(0, 3).toFloat / 1000
      z *= c

      println(s"a = $a")
      println(s"b = $b")
      println(s"c = $c")
      println(s"z = $z")
      println(s"result = $result")
    }
  }

}
package com.h7d1w0

object PattenMatchingExample {
  def main(args: Array[String]): Unit ={
    val emp1 = Employee("Tom", 35)
    val emp2 = Employee("Jerry", 30)
    val group = TwoEmployeeGroup(emp1, emp2)
    val twoNames = TwoEmployeeNames("Tom", "Jerry")

    //Constant pattern - numerical literal
    val valueToTest1: Any = 1
    val result1 = valueToTest1 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case _ => "other"
    }
    println("result1:" + result1)

    //Constant pattern - string literal
    val valueToTest2: Any = "abcd"
    val result2 = valueToTest2 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case _ => "other"
    }
    println("result2:" + result2)

    //
    val valueToTest3: Any = emp1
    val result3 = valueToTest3 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case variableCanBeReferredTo@Employee("Tom", 35) => "An Employee object:  " + variableCanBeReferredTo
      case _ => "other"
    }
    println("result3:" + result3)

    val valueToTest4: Any = group
    val result4 = valueToTest4 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case TwoEmployeeGroup(empNotExist1, empNotExist2) => empNotExist2.toString
      case _ => "other"
    }
    println("result4:" + result4)

    val valueToTest5: Any = twoNames
    val result5 = valueToTest5 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case TwoEmployeeGroup(empNotExist1, empNotExist2) => "A group match"
      case TwoEmployeeNames("Tom", "Jerry") => "A name match"
      case _ => "other"
    }
    println("result5:" + result5)

    //
    val valueToTest6: Any = twoNames
    val result6 = valueToTest6 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case TwoEmployeeGroup(empNotExist1, empNotExist2) => "A group match"
      case TwoEmployeeNames(_, _) => "A name match"
      case _ => "other"
    }
    println("result6:" + result6)

    //
    val valueToTest7_1 = Array(1,2,3)
    println("valueToTest7_1: " + findType(valueToTest7_1))
    val valueToTest7_2 = 10
    println("valueToTest7_2: " + findType(valueToTest7_2))
    val valueToTest7_3 = 10L
    println("valueToTest7_3: " + findType(valueToTest7_3))
    val valueToTest7_4 = Map("abc" -> 1, "bcd" -> 3)
    println("valueToTest7_4: " + findType(valueToTest7_4))
    val valueToTest7_5 = ("abc", "bcd" , "efg")
    println("valueToTest7_5: " + findType(valueToTest7_5))

    //
    println("valueToTest7_4: " + findElementType(valueToTest7_4))
    println("valueToTest7_1: " + findElementType(valueToTest7_1))

    val valueToTest8 = Array("t","r","a","i","n")
    println("valueToTest8: " + findElementType(valueToTest8))
  }

  def findType(x: Any): String = {
    x match {
      case v: Int => "Integer Type"
      case v: String => "String Type"
      case v: Long => "Long Type"
      case v: Map[_, _] => "Map type"
      case (_, _, _) => "A tuple"
      case v: Array[_] => "Array Type"
      case _ => "other"
    }
  }

  def findElementType(x: Any): String = {
    x match {
      case v: Map[String, String] => "Map[String] type"
      case v: Array[String] => "Array[String] Type"
      case _ => "other"
    }
  }

}

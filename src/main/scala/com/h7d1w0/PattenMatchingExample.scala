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

    //variable pattern
    val valueToTest2_2: Any = "abcd"
    val result2_2 = valueToTest2_2 match {
      case 1 => "Digital number one "
      case Employee("Tom", 35) => "An Employee object"
      case v => "other"
    }
    println("result2_2:" + result2_2)


    //constructor pattern
    val valueToTest3: Any = emp1
    val result3 = valueToTest3 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case variableCanBeReferredTo @ Employee("Tom", 35) => "An Employee object:  " + variableCanBeReferredTo
      case _ => "other"
    }
    println("result3:" + result3)

    //constructor pattern - with variable pattern of parameters
    val valueToTest4: Any = group
    val result4 = valueToTest4 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case TwoEmployeeGroup(employee1, employee2) => "A name match: constructor pattern - with variable pattern for parameters"
      case _ => "other"
    }
    println("result4:" + result4)

    //constructor pattern - with constant pattern of parameters
    val valueToTest5: Any = twoNames
    val result5 = valueToTest5 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case TwoEmployeeGroup(empNotExist1, empNotExist2) => "A group match"
      case TwoEmployeeNames("Tom", "Jerry") => "A name match: constructor pattern - with constant pattern for parameters"
      case _ => "other"
    }
    println("result5:" + result5)

    //constructor pattern - with wildcard pattern of parameters
    val valueToTest6: Any = twoNames
    val result6 = valueToTest6 match {
      case 1 => "Digital number one "
      case "abcd" => "Alphabic sequence"
      case Employee("Tom", 35) => "An Employee object"
      case TwoEmployeeGroup(employee1, employee2) => "A group match"
      case TwoEmployeeNames(_, _) => "A name match: constructor pattern - with wildcard pattern for parameters"
      case _ => "other"
    }
    println("result6:" + result6)

    //Typed pattern
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

    //Typed pattern
    println("valueToTest7_4: " + findElementType(valueToTest7_4))
    println("valueToTest7_1: " + findElementType(valueToTest7_1))

    val valueToTest8 = Array("t","r","a","i","n")
    println("valueToTest8: " + findElementType(valueToTest8))


    //Pattern guard
    val impossibleGroup = TwoEmployeeGroup(emp1, emp1)
    val result7 = impossibleGroup match {
      case TwoEmployeeGroup(employee1, employee2) if employee1==employee2 => "This group is impossible"
      case _ => "other"
    }
    println("result6:" + result7)

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

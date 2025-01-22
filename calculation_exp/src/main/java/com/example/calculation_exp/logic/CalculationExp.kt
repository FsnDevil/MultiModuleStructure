package com.example.calculation_exp.logic

class CalculationExp {
    companion object {
        fun addNumber(num1:Int,num2:Int):Int{
            return num1+num2
        }

        fun minusNumber(num1:Int,num2:Int):Int{
            return num1-num2
        }

        fun multiplyNumber(num1:Int,num2:Int):Int{
            return num1*num2
        }

        fun divideNumber(num1:Int,num2:Int):Int{
            return num1/num2
        }

        fun giveMeYourName():String{
            return "My name is Calcy";
        }
    }
}
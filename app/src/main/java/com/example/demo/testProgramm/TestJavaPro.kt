package com.example.demo.testProgramm

object TestJavaPro {

    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println("test java programm")
        testArray()
    }

    @JvmStatic
    fun testArray() {
        val data = arrayOf(11, 4, 5, 1, 1, 6, 7)

        data.sort()
    }
}
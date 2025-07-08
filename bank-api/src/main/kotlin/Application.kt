package com.jisu.bank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.jisu.bank"])
class BankApplication

fun main(args: Array<String>) {
    runApplication<BankApplication>(*args)
}
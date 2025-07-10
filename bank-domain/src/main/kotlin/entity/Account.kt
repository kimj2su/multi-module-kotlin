package com.jisu.bank.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "accounts")
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(nullable = false, unique = true)
    val accountNumber: String,

    @Column(nullable = false)
    var balance: BigDecimal,

    @Column(nullable = false)
    val accountHolderName: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
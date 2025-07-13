package com.jisu.bank.domain.repository

import com.jisu.bank.domain.entity.Account
import com.jisu.bank.domain.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable

@Repository
interface TransactionRepository : JpaRepository<Transaction, Long> {
    fun findByAccountOrderByCreatedAtDesc(account: Account): List<Transaction>
    fun findTopByAccountOrderByCreatedAtDesc(account: Account, pageable: Pageable): List<Transaction>
}
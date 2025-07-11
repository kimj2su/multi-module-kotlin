package com.jisu.bank.event.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncConfig {

    @Bean(name = ["taskExecutor"])
    fun taskExecutor() : Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2 // 최소 2개의 스레드
        executor.maxPoolSize = 5 // 최대 5개의 스레드
        executor.queueCapacity = 100 // 대기 큐의 크기
        executor.setThreadNamePrefix("bank-event")
        executor.initialize()
        return executor
    }
}


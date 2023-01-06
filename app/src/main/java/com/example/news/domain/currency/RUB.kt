package com.example.news.domain.currency

data class RUB(
    val buy_value: String,
    val created_at: String,
    val currency_code: String,
    val id: String,
    val money_transfer_buy_value: String,
    val money_transfer_trade_value: String,
    val name: String,
    val nbt_value: String,
    val non_cash_buy_value: String,
    val non_cash_sell_value: String,
    val sell_value: String,
    val updated_at: String,
    val visa_buy_value: String,
    val visa_sell_value: String
)
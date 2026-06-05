package com.atech.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atech.core.data.local.expense.CategoryEntity
import com.atech.core.data.local.expense.ExpenseDao
import com.atech.core.data.local.expense.ExpenseEntity
import com.atech.core.data.local.expense.ExpenseEntryEntity
import com.atech.core.data.local.expense.PaymentTypeEntity

@Database(
    entities = [
        // Expense related entities
        ExpenseEntity::class,
        CategoryEntity::class,
        PaymentTypeEntity::class,
        ExpenseEntryEntity::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class CurrentsDatabase : RoomDatabase(){
    abstract val expenseDao: ExpenseDao
}
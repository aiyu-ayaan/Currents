package com.atech.core.data.local.expense

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.atech.core.utils.TableNames
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    // Insert and update operations for ExpenseEntity, CategoryEntity, PaymentTypeEntity, and ExpenseEntryEntity
    @Upsert
    suspend fun upsertExpenseBook(expenseEntity: ExpenseEntity): Long

    @Upsert
    suspend fun upsertCategory(categoryEntity: CategoryEntity): Long

    @Upsert
    suspend fun upsertPaymentType(paymentTypeEntity: PaymentTypeEntity): Long

    @Upsert
    suspend fun upsertExpenseEntry(expenseEntryEntity: ExpenseEntryEntity): Long


    // Delete operations for ExpenseEntity, CategoryEntity, PaymentTypeEntity, and ExpenseEntryEntity

    @Delete
    suspend fun deleteExpenseBook(expenseEntity: ExpenseEntity) : Int

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoryEntity) : Int

    @Delete
    suspend fun deletePaymentType(paymentTypeEntity: PaymentTypeEntity) : Int

    @Delete
    suspend fun deleteExpenseEntry(expenseEntryEntity: ExpenseEntryEntity) : Int

    @Query("DELETE FROM ${TableNames.Expense.EXPENSE_ENTRY} WHERE expense_book_id = :expenseBookId")
    suspend fun deleteAllExpenseEntriesForExpenseBook(expenseBookId: Long)


    @Transaction
    suspend fun deleteExpenseBookWithEntries(expenseEntity: ExpenseEntity) : Int {
        deleteAllExpenseEntriesForExpenseBook(expenseEntity.id)
        return deleteExpenseBook(expenseEntity)
    }

    // Query operations to fetch data

    @Query("SELECT * FROM ${TableNames.Expense.EXPENSE_BOOK} ORDER BY created_at DESC")
    fun getAllExpenseBooks(): Flow<List<ExpenseEntity>>

    @Query("SELECT * FROM ${TableNames.Expense.CATEGORY} ORDER BY created_at DESC")
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM ${TableNames.Expense.PAYMENT_TYPE} ORDER BY created_at DESC")
    fun getAllPaymentTypes(): Flow<List<PaymentTypeEntity>>

    @Transaction
    @Query("""
    SELECT * 
    FROM ${TableNames.Expense.EXPENSE_ENTRY}
    WHERE expense_book_id = :expenseBookId
    ORDER BY timestamp DESC
""")
    fun getExpenseEntriesForExpenseBookWithDetails(
        expenseBookId: Int
    ): Flow<List<ExpenseEntryWithDetails>>

}
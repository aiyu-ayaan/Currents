package com.atech.core.data.local.expense

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.atech.core.data.local.common.AuditFields
import com.atech.core.data.local.common.IconsFields
import com.atech.core.utils.TableNames


/**
 * ExpenseEntity represents an expense book, which can contain multiple expense entries.
 * It includes details such as the name of the expense book, the total budget allocated,
 * the amount spent, and the default currency used for transactions.
 * The entity also includes embedded fields for icons and audit information to track creation and updates.
 * @see CategoryEntity
 * @see PaymentTypeEntity
 */


@Entity(
    tableName = TableNames.Expense.EXPENSE_BOOK,
    indices = [Index(value = ["expense_book_name"], unique = true)]
)
data class ExpenseEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "expense_book_name")
    val expenseBookName: String,
    @ColumnInfo(name = "budget")
    val budget: Double,
    @ColumnInfo(name = "spent")
    val spent: Double,
    @ColumnInfo(name = "default_currency")
    var defaultCurrency: String,
    @Embedded
    val iconsFields: IconsFields,
    @Embedded
    val auditFields: AuditFields
)

@Entity(
    tableName = TableNames.Expense.CATEGORY,
    indices = [Index(value = ["category_name"], unique = true)]
)
data class CategoryEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "category_name")
    val categoryName: String,
    @Embedded
    val iconsFields: IconsFields,
    @Embedded
    val auditFields: AuditFields
)

@Entity(
    tableName = TableNames.Expense.PAYMENT_TYPE,
    indices = [Index(value = ["payment_type_name"], unique = true)]
)
data class PaymentTypeEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "payment_type_name")
    val paymentTypeName: String,
    @Embedded
    val iconsFields: IconsFields,
    @Embedded
    val auditFields: AuditFields
)

@Entity(
    tableName = TableNames.Expense.EXPENSE_ENTRY,
    foreignKeys = [
        androidx.room.ForeignKey(
            entity = ExpenseEntity::class,
            parentColumns = ["id"],
            childColumns = ["expense_book_id"],
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        androidx.room.ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = androidx.room.ForeignKey.SET_NULL
        ),
        androidx.room.ForeignKey(
            entity = PaymentTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["payment_type_id"],
            onDelete = androidx.room.ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("expense_book_id"),
        Index("category_id"),
        Index("payment_type_id")
    ]
)
data class ExpenseEntryEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "expense_book_id")
    val expenseBookId: Int,
    @ColumnInfo(name = "amount")
    val amount: Double,
    @ColumnInfo(name = "category_id")
    val categoryId: Int?,
    @ColumnInfo(name = "payment_type_id")
    val paymentTypeId: Int?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long,
    @Embedded
    val auditFields: AuditFields
)

data class ExpenseEntryWithDetails(
    @Embedded
    val expenseEntry: ExpenseEntryEntity,

    @Relation(
        parentColumn = "category_id",
        entityColumn = "id"
    )
    val category: CategoryEntity?,

    @Relation(
        parentColumn = "payment_type_id",
        entityColumn = "id"
    )
    val paymentType: PaymentTypeEntity?
)
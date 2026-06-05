package com.atech.core.module

import android.content.Context
import androidx.room.Room
import com.atech.core.data.local.db.CurrentsDatabase
import com.atech.core.utils.TableNames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): CurrentsDatabase =
        Room.databaseBuilder(
            context,
            CurrentsDatabase::class.java,
            TableNames.DatabaseName
        )
            .fallbackToDestructiveMigration(false)
            .build()

    @Provides
    @Singleton
    fun provideExpenseDao(database: CurrentsDatabase) = database.expenseDao
}
package mx.edu.dsi_code.notasmvvm.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mx.edu.dsi_code.notasmvvm.data.NoteDatabase
import mx.edu.dsi_code.notasmvvm.data.NoteDatabaseDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun  providesNotesDao(noteDatabase: NoteDatabase):NoteDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase
    = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "notas_db"
    ).fallbackToDestructiveMigration()
    .build()

}
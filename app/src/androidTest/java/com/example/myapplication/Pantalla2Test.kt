package com.example.myapplication

import org.junit.*
import java.io.File

class Pantalla2Test{

    private var fileManager = Pantalla2()
    private val modoFacil = Pantalla3()
    private val modoIntermedio = Modo_Intermedio()
    private val modoDificil = Pantalla3_Dificil()
    private val modoPvP = PantallaTresEnRaya()
    private val namesOfFiles = arrayOf("modo_Facil.txt", "modo_Intermedio.txt", "modo_Dificil.txt", "modo_PvP.txt")

    @Test
    fun testModoFacil(){
        fileManager.setFile(namesOfFiles.get(0))
        modoFacil.setPantalla2(fileManager)
        modoFacil.guardarArchivo("Facil")
        val fileData = fileManager.leerArchivo()
        assert(fileData.startsWith("Facil"))
        fileManager.destroyThisFile()
    }

    @Test
    fun testModoIntermedio(){
        fileManager.setFile(namesOfFiles.get(1))
        modoIntermedio.setPantalla2(fileManager)
        modoIntermedio.guardarArchivo("Intermedio")
        val fileData = fileManager.leerArchivo()
        assert(fileData.startsWith("Intermedio"))
        fileManager.destroyThisFile()
    }

    @Test
    fun testModoDificil(){
        fileManager.setFile(namesOfFiles.get(2))
        modoDificil.setPantalla2(fileManager)
        modoDificil.guardarArchivo("Dificil")
        val fileData = fileManager.leerArchivo()
        assert(fileData.startsWith("Dificil"))
        fileManager.destroyThisFile()
    }

    @Test
    fun testModoPvP(){
        fileManager.setFile(namesOfFiles.get(3))
        modoPvP.setPantalla2(fileManager)
        modoPvP.guardarArchivo("PvP")
        val fileData = fileManager.leerArchivo()
        assert(fileData.startsWith("PvP"))
        fileManager.destroyThisFile()
    }

    @After
    fun deleteAllSampleFiles(){
        for (nameFile in namesOfFiles){
            val fileToDelete = File(nameFile)
            fileToDelete.delete()
        }
    }

}
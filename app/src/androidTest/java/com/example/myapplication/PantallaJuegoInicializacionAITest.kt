
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.myapplication.Modo_Intermedio
import com.example.myapplication.Pantalla3
import com.example.myapplication.Pantalla3_Dificil
import com.example.myapplication.PantallaTresEnRaya
import com.example.myapplication.R
import com.example.myapplication.pantallaSeleccionModo
import org.junit.After
import org.junit.Before
import org.junit.Test

class PantallaJuegoInicializacionAITest {

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun onClick_buttonMiddModeStartsPantallaActivity() {
        // Lanza la actividad PantallaSeleccionModo
        ActivityScenario.launch(pantallaSeleccionModo::class.java)

        // Realiza clic en el botón con ID button_hardMode
        onView(withId(R.id.button_middMode)).perform(click())

        // Verifica que se inicie correctamente la actividad Pantalla3_Dificil
        intended(hasComponent(Modo_Intermedio::class.java.name))
    }

    @Test
    fun onClick_buttonVsPlyStartsPantallaActivity() {
        // Lanza la actividad PantallaSeleccionModo
        ActivityScenario.launch(pantallaSeleccionModo::class.java)

        // Realiza clic en el botón con ID button_hardMode
        onView(withId(R.id.button_vsPly)).perform(click())

        // Verifica que se inicie correctamente la actividad Pantalla3_Dificil
        intended(hasComponent(PantallaTresEnRaya::class.java.name))
    }

    @Test
    fun onClick_buttonVsPMachStartsPantallaActivity() {
        // Lanza la actividad PantallaSeleccionModo
        ActivityScenario.launch(pantallaSeleccionModo::class.java)

        // Realiza clic en el botón con ID button_hardMode
        onView(withId(R.id.button_vsPMach)).perform(click())

        // Verifica que se inicie correctamente la actividad Pantalla3_Dificil
        intended(hasComponent(Pantalla3::class.java.name))
    }

    @Test
    fun onClick_buttonHardModeStartsPantallaActivity() {
        // Lanza la actividad PantallaSeleccionModo
        ActivityScenario.launch(pantallaSeleccionModo::class.java)

        // Realiza clic en el botón con ID button_hardMode
        onView(withId(R.id.button_hardMode)).perform(click())

        // Verifica que se inicie correctamente la actividad Pantalla3_Dificil
        intended(hasComponent(Pantalla3_Dificil::class.java.name))
    }

}

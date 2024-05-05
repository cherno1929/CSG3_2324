package test.stepdefinitions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.myapplication.Tablero;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PruebaSteps {

    private Tablero tablero;
    private Character[][] elements;

    @Given("Tengo un tablero")
    public void tengo_un_tablero() {
        tablero = new Tablero();
    }

    @When("Pulso una posicion")
    public void pulso_una_posicion() {
        tablero.markCircle(1, 1);
    }

    @Then("Se marca un circulo")
    public void probando3() {
        assertEquals('o', tablero.getPos(1, 1));
    }

    @When("Pido los datos del tablero")
    public void pido_los_datos_del_tablero() {
        elements = tablero.getElements();
    }

    @Then("Se devuelven los datos del tablero")
    public void se_devuelven_los_datos_del_tablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(Character.valueOf('-'), elements[i][j]);
            }
        }
    }

    @When("Lleno el tablero")
    public void el_tablero_esta_lleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero.markCircle(i, j);
            }
        }
    }

    @Then("Compruebo si esta lleno")
    public void tablero_lleno() {
        assertTrue(tablero.isFull());
    }

    @Then("Me dice que no esta vacio")
    public void tablero_no_vacio() {
        assertFalse(tablero.isEmpty(1, 1));
    }

}


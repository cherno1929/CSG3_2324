Feature: Marcar círculo
  Scenario: Cuando soy el usuario circulo, quiero que se marque un circulo en la posicion que elija
    Given Tengo un tablero
    When Pulso una posicion
    Then Se marca un circulo


Feature: El tablero esta vacio
  Scenario: Quiero saber si el tablero esta vacio
    Given Tengo un tablero
    When Pulso una posicion
    Then Me dice que no esta vacio
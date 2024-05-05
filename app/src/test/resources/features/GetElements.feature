Feature: Recibir los elementos del tablero
  Scenario: Quiero poder recibir la disposicion de los elementos en el tablero
    Given Tengo un tablero
    When Pido los datos del tablero
    Then Se devuelven los datos del tablero
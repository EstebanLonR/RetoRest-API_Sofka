#author:Juan Esteban

Feature: Consultar Pokemon


  Scenario: Consulta de nombre pokemon por id
    When el usuario envia la peticion con el path "/pokemon/" get con el recurso "802"
    Then el sistema debera mostrarle el nombre del pokemon "marshadow"

  Scenario: Consulta id de movimiento
    When el usuario envia la peticion get con el path "/move/" y el recurso del movimiento "thunder-shock"
    Then el sistema debera mostrarle el id del movimiento "84"
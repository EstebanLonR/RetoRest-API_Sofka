Feature: Consmo de servicios
 Como usuario requiero realizar el consumo de los servios de registor y eliminacion


  Scenario:  consumo del servicio registro exitoso
    When el usuario envia la peticion de registro
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Then entonces el debera ver el codigo de respuesta y el mensaje

  Scenario:  consumo la peticion de eliminar exitoso
    When el  envia la peticion de eliminar el usuario "2"
    Then el debera ver el codigo de respuesta

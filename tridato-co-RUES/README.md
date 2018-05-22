
#### Run
```sh
    docker build .
    docker run -p 3334:3334 <Built_imageID>
```

###### Now go to 0.0.0.0:3334/rue/<givenID> and you will receive a response like this:

```json
{
    "page": 1,
    "codigo_error": "0000",
    "mensaje_error": "",
    "records": 1,
    "rows": [
        {
            "categoria_matricula": "PERSONA NATURAL",
            "clase_identificacion": "C.C.",
            "codigo_camara": "00",
            "codigo_estado": "00",
            "identificacion": "C.C. 11111111",
            "estado": "CANCELADA",
            "matricula": "2222222",
            "nombre_camara": "BOGOTA ",
            "organizacion_juridica": "PERSONA NATURAL",
            "razon_social": "PEREZ GOMEZ JUAN",
            "tipo": "SOCIEDAD COMERCIAL",
            "enlaceVer": "<i class='fa fa-address-card c-blue'></i>&nbsp;<a class='c-blue' href=\"javascript:ConsultarDetalle('XXXXXX')\" >Ver Detalle</a>"
        }
    ]
}
```


#### Run

```sh
    docker build .
    docker run -p 3435:3435 <Built_imageID>
```

###### Now go to 0.0.0.0:3435/api/v1/curp/<given_curp> and you will receive a response like this:


```json
{
    "curp": "AACJ960403HNTLLN03",
    "first_name": "JUAN MANUEL",
    "last_name": "ALATORRE CALDERON",
    "birth_date": "03/04/1996",
    "birth_place": "NAYARIT"
}

```

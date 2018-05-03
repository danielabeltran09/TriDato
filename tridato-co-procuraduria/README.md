# PROCURADURIA MICROSERVICE DOCKER CONTAINER

## BUILD DOCKER IMAGE

To run this microservice build the docker image by running the following command FROM THIS FOLDER

```sh
docker build .
```

After the image is built, run
```
docker images
```
The most recent entry is the one we need, copy the IMAGE ID
We will refer to it as procuraduriaImageID

## RUN CONTAINER

```sh
docker run -d -p 5000:5000 procuraduriaImageID
```

## USE THE MICROSERVICE

### Testing

Go to localhost:5000/ and you should see "Alive" as a response

### Production

To query user data, use localhost:5000/cc/<dniNumber>
You will receive a json response in the following format

```javascript
{
id: 0000000,
name: John Doe,
data: ""
}
```

The "data" field contains the html tables in base64. If the data is not "" (empty), it means the citizen has data worth showing. 

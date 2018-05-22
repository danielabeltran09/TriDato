FROM golang:latest 
RUN mkdir /app 
ADD . /app/ 
EXPOSE 3334
WORKDIR /app 
RUN go get github.com/gin-gonic/gin
RUN go build -o main . 
CMD ["/app/main"]

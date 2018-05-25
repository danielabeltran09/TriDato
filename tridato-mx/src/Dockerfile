FROM golang:latest
RUN mkdir /app
RUN mkdir /app/src
ADD . /app/src
EXPOSE 3334
WORKDIR /app/src
ENV GOPATH "/app/"
RUN go get github.com/gin-gonic/gin
RUN go get github.com/PuerkitoBio/goquery
RUN cd /app/src
RUN go build main.go
CMD ["./main"]

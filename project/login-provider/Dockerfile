FROM golang:1.8
RUN mkdir /app
ADD server /app/
ADD templates /app/templates

WORKDIR /app
CMD ["./server"]

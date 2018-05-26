package main

import "sipso"
import "github.com/gin-gonic/gin"

func main() {
	router := gin.Default()
	router.GET("/api/v1/curp/:curp", func(c *gin.Context) {
		response := sipso.GetData(c.Param("curp"))
		c.JSON(200, response)
	})

	router.Run(":3435")

}

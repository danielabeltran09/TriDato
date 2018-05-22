package main

import "fmt"
import "sipso"
import "github.com/gin-gonic/gin"

//import "encoding/json"

func main() {
	router := gin.Default()
	//sipso := sipso.GetData("AACJ960403HNTLLN03")
	//fmt.Println(sipso)
	router.GET("/sipso/:curb", func(c *gin.Context) {
		fmt.Println(c.Param("curb"))
		response := sipso.GetData(c.Param("curb"))
		//fmt.Println(response)
		c.JSON(200, response)
	})

	router.Run(":8080")

}

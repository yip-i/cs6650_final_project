package main

import (
	"fmt"
	"log"
	"net/http"
	"strconv"
	"strings"
)

func helloHandler(w http.ResponseWriter, r *http.Request) {

	if r.Method != "GET" {
		http.Error(w, "Method is not supported.", http.StatusNotFound)
		return
	}
	s := strings.Split(r.URL.Path, "/")
	fmt.Fprintf(w, s[1]+"\n")
	fmt.Fprintf(w, s[2])
}

func skierHandler(w http.ResponseWriter, r *http.Request) {
	if r.Method == "GET" {
		skierGet(w, r)
		return
	} else if r.Method == "POST" {
		skierPost(w, r)
		return
	}
}

func skierGet(w http.ResponseWriter, r *http.Request) {
	url := r.URL.Path
	urlSplit := strings.Split(url, "/")

	resortID, _ := strconv.Atoi(urlSplit[2])

	seasonID, _ := strconv.Atoi(urlSplit[4])
	dayID, _ := strconv.Atoi(urlSplit[6])
	skierID, _ := strconv.Atoi(urlSplit[8])

	fmt.Fprintf(w, strconv.Itoa(resortID)+"\n")
	fmt.Fprintf(w, strconv.Itoa(seasonID)+"\n")
	fmt.Fprintf(w, strconv.Itoa(dayID)+"\n")
	fmt.Fprintf(w, strconv.Itoa(skierID)+"\n")
	return
}

func skierPost(w http.ResponseWriter, r *http.Request) {
	// url := r.URL.Path
	// urlSplit := strings.Split(url, "/")

	// resortID, _ := strconv.Atoi(urlSplit[2])

	// seasonID, _ := strconv.Atoi(urlSplit[4])
	// dayID, _ := strconv.Atoi(urlSplit[6])
	// skierID, _ := strconv.Atoi(urlSplit[8])

	w.WriteHeader(http.StatusCreated)

	// fmt.Fprintf(w, strconv.Itoa(resortID)+"\n")
	// fmt.Fprintf(w, strconv.Itoa(seasonID)+"\n")
	// fmt.Fprintf(w, strconv.Itoa(dayID)+"\n")
	// fmt.Fprintf(w, strconv.Itoa(skierID)+"\n")
	return
}

func main() {
	http.HandleFunc("/hello/", helloHandler)

	http.HandleFunc("/skiers/", skierHandler)

	fmt.Printf("Starting server at port 8080\n")
	if err := http.ListenAndServe(":8080", nil); err != nil {
		log.Fatal(err)
	}
}

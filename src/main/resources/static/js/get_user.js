const url = "http:localhost:8080/authenticate"
fetch(url)
    .then(res => res.json())
    .then(data => console.log(data))
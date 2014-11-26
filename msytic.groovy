// We notice two methods: save(map) and world(closure).
// The methods:
def world(callable) {
	//calls the callable
    def result = callable()
    "Hello $result world!"
}
def say(map) {
	//prints out the key "hello" of the map "map"
    result << "Say '${map.hello}'"
}

//list
result = []


// Mystic expressions: (see assert for outcome)

// say([hello: world({ 'Groovy' })])
say hello:world {
	'Groovy' 
}
// say([hello: world({ 'Java' })])
say hello:world {
    'Java'
}

println result
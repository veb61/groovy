String.metaClass.call = { range ->
    println "call is called"
    delegate[range]
}

def value = 'Groovy is Gr8'

assert value(0) == 'G'
assert value(10) == 'G'
assert value(4) == value[4]
assert value.call(1) == value(1)
assert value(0..5) == 'Groovy'

class StringConverter {
    def value
    def value(s) {
        value = s
		this 
	}
    
    /** Convert characters in value property if cond is true */
    def upper(cond) {
        value = value.collect { cond(it) ? it.toUpperCase() : it }.join()
    }
    
    def call(callable) {
        callable
	} 
}


def converter = new StringConverter()

converter.with {
    value('jdriven') upper { it == 'j' || it == 'd' }
    assert value == 'JDriven'
}
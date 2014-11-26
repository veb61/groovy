/**
 * Simple interface with one method to
 * transform a String value.
 */
interface Transformer {
    String transform(String input)
}

/** Default trait will return the input value unchanged. */
trait DefaultTransformer implements Transformer {
    String transform(String input) {
    	println "NORMAL"
        input
	} 
}

/** Transform the String value to upper case */
trait Upper implements Transformer {
    String transform(String input) {
    	println "UPPER CASE"
        super.transform(input.toUpperCase())	
	} 
}

/** Remove 'mr' from input String value. */
trait Filter implements Transformer {
    String transform(String input) {
    	println "Remove MR"
        super.transform(input - 'mr')
	} 
}

/*No super transform - it stop stop here!!!*/
trait MyTraitFilter
{
	String transform(String input)
	{
		println "MyTrait Filter"
		input - 'mr'
	}
}

/**
 * Simple class uses three traits. The value property get method
 * returns the transformed value.
 */
class StringTransformer implements DefaultTransformer, Upper, Filter {
    String value
    String getValue() { transform(value) }
}

// Create StringTransformer instance.
def transformer = new StringTransformer(value: 'mrhaki')
println transformer.value // OUTPUT: HAKI

// Use same traits, but in different order.
class OtherStringTransformer implements DefaultTransformer, Filter, Upper {
	String value
    String getValue() { transform(value) }
}

// Create OtherStringTransformer instance.
def otherTransformer = new OtherStringTransformer(value: 'mrhaki')
println otherTransformer.value

/**
 * Stops by executing MyTrait , doesn't execute Upper and DefaultTransformer
 */
class StringTransformer1 implements   DefaultTransformer, Upper,MyTraitFilter, Filter{
    String value
    String getValue() { transform(value) }
}

// Create StringTransformer instance.
def transformer1 = new StringTransformer1(value: 'mrhaki')
// The Filter trait cannot find 'mr',
// because the String value is already in
// upper case after the Upper trait.
println transformer1.value 

/** Only chain input values smaller than 5 characters. */
trait SmallFilter implements Transformer {
    String transform(String input) {
        if (input.size() < 5) {
            super.transform(input)
        } else {
			'' 
		}
	}
}

class SmallStringTransformer implements DefaultTransformer, Upper, SmallFilter {
    String value
    String getValue() { transform(value) }
}
def smallTransformer = new SmallStringTransformer(value: 'mrhaki')
assert smallTransformer.value == ''

smallTransformer.value = 'haki'
assert smallTransformer.value == 'HAKI'


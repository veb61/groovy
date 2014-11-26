int x = 0b101
assert x == 5

long longNumber = 1230_3910_1929_182931
assert longNumber == 123039101929182931

int length = 5_10
assert length == 510

long hex = 0x00_ff
assert hex == 255



import java.lang.reflect.*
// Multicatch.
@groovy.transform.ToString

class Person {
	String name
}

//We can define a multi-catch exception in Groovy 2. 
//We specify more than exception in the catch clause separated by a pipe (|) symbol:
try {
    final Person p = new Person(name: 'mrhaki')
    final Method toString = p.class.getMethod("toString1", null)
    final Object result = toString.invoke(p, null)
} catch (NoSuchMethodException | IllegalAccessException |
         IllegalArgumentException | InvocationTargetException e) {
	assert e 
}
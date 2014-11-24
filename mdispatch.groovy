// We start off by some very simple class definitions
// with a one-level hierarchy amongst them.
abstract class Person {
	String name 
}
class Parent extends Person {}
class Child extends Person {}

// Now we define methods to return the name with some extra info.

def printName(Parent parent) { "printName(Parent): $parent.name"}
def printName(Person person) { "printName(Person): $person.name" }
def printName(Child child) { "printName(Child): $child.name" }
def printName(p) { "printName(p): $p.name" }

// Create new Parent and Child objects but use Person type reference.
Person parent1 = new Parent(name: 'parent1')
Person child1 = new Child(name: 'child1')

// printName(Parent): parent1, if "def printName(Parent parent)" didn't existed it would print printName(Person): parent1,
println printName(parent1) 
// This is not what Java would do!!
println printName(child1) // printName(Child): child1
// Same as what Java would do with printName(child1)
println printName(child1 as Person) //printName(Person): child1

// Create objects with type reference is equal to object.
Parent parent2 = new Parent(name: 'parent2')
Child child2 = new Child(name: 'child2')
assert 'printName(Person): parent2' == printName(parent2 as Person)
assert 'printName(Child): child2' == printName(child2)

// Use class outside Person hierarchy.
class Dog {
	String name 
}
assert 'printName(p): buck' == printName(new Dog(name: 'buck'))
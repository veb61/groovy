class Person
{
	String name
	int age

	Person()
	{
		/*this doesn't go through set*/
		/*more of .@ kind.!*/
		name = "Veli"
		age= 33
	}

	void setAge(age)
	{
		println "AGE IS SET"
		this.age = age
	}
	
	String toString()
	{
		"AGE : $age , name: $name"

	}
	//For assignment from object to variables
	Object getAt(int index)
	{
		index == 0 ? name : age;
	}
}

//this goes through setProperty
def p1 = new Person(name: 'ben', age: 44)
println p1

def p = new Person()
println p

/*both goes through set*/
p.age = 35
println p

p.setAge(24)
println p

def (username, age) = p;
println  "USERNAME:$username, AGE:$age"


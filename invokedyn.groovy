class Dog {
  def bark() { println "woof!" }
  def sit() { println "(sitting)" }
  def jump() { println "boing!" }
}

def doAction( animal, action ) {
  animal."$action"()                  //action name is passed at invocation
}

def rex = new Dog()

def methods=["bark","sit","jump"]

for (i in methods)
{
	doAction(rex,i)
}
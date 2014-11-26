interface Simple{}

class Sample implements Simple
{
	String info
	String displayInfo() {"info from $Sample.name"}
}

println Sample.name //Sample 
println Sample.interfaces.name //[Simple, groovy.lang.GroovyObject]

//[invokeMethod, getMetaClass, setMetaClass, getInfo, __$swapInit, displayInfo,
// this$dist$invoke$1, this$dist$set$1, this$dist$get$1, setInfo, super$1$notify, 
//super$1$hashCode, super$1$toString, super$1$clone, super$1$wait, super$1$wait, 
//super$1$wait, super$1$notifyAll, super$1$equals, super$1$finalize, super$1$getClass, 
//setProperty, getProperty, wait, wait, wait, equals, toString, hashCode, getClass,
// notify, notifyAll]
println Sample.methods.name

def s = new Sample()
println s.displayInfo()

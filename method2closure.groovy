
/*Simple java class with one static method*/
public class JavaObject {
    public static void javaSays(final String s) {
        System.out.println("Java says: Hello " + s + "!");
    }
}

// Simple list with names.
def names = ['groovy', 'grails', 'mrhaki']

// Simple closure.
names.each { println 'Normal closure says: Hello ' + it + '!' }

// Groovy method to convert to closure.
def groovySays(s) {
    "Groovy says: Hello ${s}!"
}
// Use .& syntax to convert method to closure.
names.each(this.&groovySays)


// Convert Java method to closure and use it.
def javaSays = JavaObject.&javaSays
names.each javaSays
trait Id {
    Long id
}
trait Version {
    Long version = 0
}

trait Active {
    Date from = new Date()
    Date to = null
    boolean isActive() {
        final Date now = new Date()
        from < now && (!to || to > now)
	} 
}

class Person {
    String username
}

def person = new Person(username: 'mrhaki')
def domainPerson = person.withTraits Id, Version, Active

domainPerson.id = 1
assert domainPerson.username == 'mrhaki'
assert domainPerson.id == 1
assert domainPerson.version == 0
assert domainPerson.active
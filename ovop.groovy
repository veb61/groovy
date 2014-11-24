class Event {
    List<Person> attendees = []
    List<Session> sessions = []
    Event leftShift(final Person person) {
        attendees << person
        this
	}	
    Event leftShift(final Session session) {
        sessions << session
        this
	} 	
}

class Session { String title }
class Person { String name }

final Event gr8Conf = new Event()

gr8Conf << new Person(name: 'mrhaki') << new Session(title: /Groovy's Hidden Gems/)
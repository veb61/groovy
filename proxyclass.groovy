class User
{
	String name
	String email
	String password

	String displayName()
	{
		name
	}
}

class UserProxy extends groovy.util.Proxy
{
	List fields

	//Override getProperty for custom behaviour by the proxy
	Object getProperty(String propertyName)
	{
		if(propertyName in fields)
		{
			/*get user*/
			getAdaptee().getProperty(propertyName)
		}else
		{
			throw new MissingPropertyException("Unknown property $propertyName")
		}
	}
}


def user = new User(name: "mrhaki", email: "private@localhost",password:"secret")
//wrap
def userProxy = new UserProxy(fields: ['name']).wrap(user)

//this goes through getProperty.
println userProxy.name
//println userProxy.email - this is not going to fly.
println userProxy.getEmail()
//doesn't go through getProperty.
println userProxy.getPassword()

package org.grails.samples

class User {

	String username
	String password
	
	static constraints = {
		username blank: false
		password blank: false
	}
}

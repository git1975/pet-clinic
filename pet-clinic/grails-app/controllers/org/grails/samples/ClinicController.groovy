package org.grails.samples

class ClinicController {

	def index() {}

	def tutorial() {}

	def vets() {
		[vets: Vet.list()]
	}
	
	def users() {
		[users: User.list()]
	}
	
	def delete() {
		for(Iterator itr = params.findAll().iterator(); itr.hasNext();){
			String key = itr.next();
			System.out.println "->" + key;
		}
	}
}

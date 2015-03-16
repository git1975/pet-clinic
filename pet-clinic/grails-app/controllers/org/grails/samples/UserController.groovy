package org.grails.samples

class UserController {

	def petclinicService
	
	def showUsers() {
		[users: User.list()]
	}

	def add() {
		if (request.method == 'GET') {
			return [userBean: new User()]
		}

		def user = petclinicService.createUser(params.user_username, params.user_password)

		if (user.hasErrors()) {
			return [userBean: user]
		}

		//redirect action: 'show', id: user.id
		redirect action: 'showUsers'
	}

	def delete() {
		/*for(Iterator itr = params.iterator(); itr.hasNext();){
			String key = itr.next();
			System.out.println "->" + key.toString();
		}*/
		
		for(User user : User.list()){
			Object obj = params.get("users." + user.id)
			if(obj != null){
				if("on".equals(obj.toString())){
					System.out.println "Delete user: " + user;
					user.delete(flush: true);
				}
			}
		}
		redirect action: 'showUsers'
	}

	def edit() {
		def owner = Owner.get(params.id)
		if (request.method == 'GET') {
			render view: 'add', model: [ownerBean: owner]
			return
		}

		petclinicService.updateOwner(Owner.get(params.id), params.owner?.firstName, params.owner?.lastName,
				params.owner?.address, params.owner?.city, params.owner?.telephone)

		if (owner.hasErrors()) {
			render view: 'add', model: [ownerBean: owner]
			return
		}

		redirect action: 'show', id: owner.id
	}

	def find() {
		if (!request.post) {
			return
		}

		def owners = Owner.findAllByLastName(params.lastName)
		if (!owners) {
			return [message: 'owners.not.found']
		}

		if (owners.size() > 1) {
			render view: 'selection', model: [owners: owners]
		}
		else {
			redirect action: 'show', id: owners[0].id
		}
	}
}

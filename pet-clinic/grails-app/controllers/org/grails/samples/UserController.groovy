package org.grails.samples

class UserController {

	def petclinicService
	
	def users() {
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
		redirect controller:'clinic', action: 'users'
	}

	def show() {
		def user = User.get(params.id)
		if (!user) {
			response.sendError 404
			return
		}

		[userBean: user]
	}

	def delete() {
		for(Iterator itr = params.findAll().iterator(); itr.hasNext();){
			String key = itr.next();
			System.out.println "->" + key;
		}
		
		Object obj = params.get("format");
		
		System.out.println checkedUsers;
		
		//get list of users. this will return only the selected user
		def selectedUsers = User.getAll(checkedUsers)

		for(user in selectedUsers){
			user.delete()
		}
		redirect controller:'clinic', action: 'users'
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

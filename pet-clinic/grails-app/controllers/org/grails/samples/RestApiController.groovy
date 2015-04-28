package org.grails.samples

import grails.rest.RestfulController

class RestApiController extends RestfulController {
	static responseFormats = ['json', 'xml']
	RestApiController() {
		super(User)
	}

	@Override
	def show() {
		// We pass which fields to be rendered with the includes attributes,
		// we exclude the class property for all responses.
		respond queryForResource(params.id)
	}
}

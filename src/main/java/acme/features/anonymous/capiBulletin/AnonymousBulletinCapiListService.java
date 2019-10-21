
package acme.features.anonymous.capiBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.capiBulletin.CapiBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousBulletinCapiListService implements AbstractListService<Anonymous, CapiBulletin> {

	//Internal state

	@Autowired
	private AnonymousBulletinCapiRepository repository;


	//AbstractListService<Anonymous,CapiBulletin> interface

	@Override
	public boolean authorise(final Request<CapiBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<CapiBulletin> request, final CapiBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");
	}

	@Override
	public Collection<CapiBulletin> findMany(final Request<CapiBulletin> request) {

		assert request != null;

		Collection<CapiBulletin> result;

		result = this.repository.findMany();
		return result;
	}

}

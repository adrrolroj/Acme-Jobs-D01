
package acme.features.anonymous.luisBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.luisBulletin.LuisBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousBulletinLuisListService implements AbstractListService<Anonymous, LuisBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinLuisRepository repository;


	//AbstractListService<Anonymous, LuisBulletin> interface ----------
	@Override
	public boolean authorise(final Request<LuisBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<LuisBulletin> request, final LuisBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public Collection<LuisBulletin> findMany(final Request<LuisBulletin> request) {
		assert request != null;

		Collection<LuisBulletin> result;

		result = this.repository.findMany();
		return result;
	}

}

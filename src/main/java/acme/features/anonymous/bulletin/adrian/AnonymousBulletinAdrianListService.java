
package acme.features.anonymous.bulletin.adrian;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.adrian.AdrianBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousBulletinAdrianListService implements AbstractListService<Anonymous, AdrianBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinAdrianRepository repository;


	//AbstractListService<Anonymous, AdrianBulletin> interface ----------
	@Override
	public boolean authorise(final Request<AdrianBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AdrianBulletin> request, final AdrianBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public Collection<AdrianBulletin> findMany(final Request<AdrianBulletin> request) {
		assert request != null;

		Collection<AdrianBulletin> result;

		result = this.repository.findMany();
		return result;
	}

}

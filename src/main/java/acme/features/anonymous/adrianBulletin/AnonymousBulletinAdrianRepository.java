
package acme.features.anonymous.adrianBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.adrianBulletin.AdrianBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousBulletinAdrianRepository extends AbstractRepository {

	@Query("select a from AdrianBulletin a")
	Collection<AdrianBulletin> findMany();
}

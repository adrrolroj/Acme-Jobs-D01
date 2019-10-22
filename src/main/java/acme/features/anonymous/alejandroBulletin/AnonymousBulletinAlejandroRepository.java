
package acme.features.anonymous.alejandroBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.alejandroBulletin.AlejandroBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousBulletinAlejandroRepository extends AbstractRepository {

	@Query("select a from AlejandroBulletin a")
	Collection<AlejandroBulletin> findMany();
}

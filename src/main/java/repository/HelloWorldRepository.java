package repository;

import com.HelloWorld;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Faisal on 2018-02-25.
 */
@RepositoryRestResource(collectionResourceRel = "hello", path="hello")
public interface HelloWorldRepository extends CrudRepository<HelloWorld, Long>{
}

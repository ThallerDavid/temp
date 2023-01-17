package at.htl.control;

import at.htl.boundary.PersonRepo;
import at.htl.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;


@Path("/api/person")
public class PersonApi {

    @Inject
    PersonRepo personRepo;

    @GET
    public List<Person> listAll(){
        return personRepo.listAll();
    }
}

package org.test.service;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.test.dto.AddressDto;
import org.test.dto.PersonDto;
import org.test.entity.Address;
import org.test.entity.Person;
import org.test.respository.PersonRepository;

@ApplicationScoped
public class TestService {


    @Inject
    PersonRepository personRepository;


    public Uni<PersonDto> createPerson(PersonDto personDto) {

        Person person =  new Person();
        person.setPersonId(personDto.getPersonId());
        person.setName(personDto.getName());

        Address address = new Address();
        address.setAddress1(personDto.getAddress().getAddress1());
        address.setAddress2(personDto.getAddress().getAddress2());
        address.setState(personDto.getAddress().getState());

        person.setAddress(address);

        return Person.persist(person)
                .onItem()
                .transform(unused -> personDto);
    }

    public Uni<PersonDto> getPersonObject(Integer personId){

       return  Person.findByPersonId(personId)
                .onItem()
                .transform(personOpt -> {

                    if(personOpt.isPresent()){
                        Person person = personOpt.get();
                        PersonDto personDto = new PersonDto();
                        personDto.setName(person.getName());
                        personDto.setPersonId(person.getPersonId());

                        AddressDto addressDto = new AddressDto();
                        addressDto.setAddress1(person.getAddress().getAddress1());
                        addressDto.setAddress2(person.getAddress().getAddress2());
                        addressDto.setState(person.getAddress().getState());

                        personDto.setAddress(addressDto);
                        return personDto;
                    }else{

                        return new PersonDto();
                    }


                });
    }
}

package com.example.tamagochirest.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.tamagochi_api_contract.dto.PetResponse;
import com.example.tamagochirest.controllers.OwnerContoller;
import com.example.tamagochirest.controllers.TamagochiController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TamagochiModelAssembler implements RepresentationModelAssembler<PetResponse, EntityModel<PetResponse>>{
    
    @Override
    public EntityModel<PetResponse> toModel(PetResponse pet) {
        EntityModel<PetResponse> model = EntityModel.of(pet,
            linkTo(methodOn(TamagochiController.class).getPetById(pet.getId())).withSelfRel(),
            linkTo(methodOn(TamagochiController.class).getAllPets(null, null, null, null, 0, 20)).withRel("collection")
        );
        if(pet.getOwner() != null) {
            model.add(linkTo(methodOn(OwnerContoller.class)
                    .getOwnerById(pet.getOwner().getId())).withRel("owner"));
        }
        return model;
    }
}

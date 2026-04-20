package com.example.tamagochirest.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.tamagochi_api_contract.api.PetApi;
import com.example.tamagochi_api_contract.dto.PagedResponse;
import com.example.tamagochi_api_contract.dto.PatchPetRequest;
import com.example.tamagochi_api_contract.dto.PetRequest;
import com.example.tamagochi_api_contract.dto.PetResponse;
import com.example.tamagochi_api_contract.dto.UpdatePetRequest;
import com.example.tamagochirest.assemblers.TamagochiModelAssembler;
import com.example.tamagochirest.service.TamagochiService;

import jakarta.validation.Valid;

@RestController
public class TamagochiController implements PetApi{
    
    private final TamagochiService tamagochiService;
    private final TamagochiModelAssembler tamagochiModelAssembler;
    private final PagedResourcesAssembler<PetResponse> pagedResourcesAssembler;
    
    public TamagochiController(TamagochiService tamagochiService, TamagochiModelAssembler tamagochiModelAssembler,
            PagedResourcesAssembler<PetResponse> pagedResourcesAssembler) {
        this.tamagochiService = tamagochiService;
        this.tamagochiModelAssembler = tamagochiModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @Override
    public EntityModel<PetResponse> getPetById(Long id) {
        return tamagochiModelAssembler.toModel(tamagochiService.findPetById(id));
    }

    @Override
    public PagedModel<EntityModel<PetResponse>> getAllPets(Long authorId, String color, String species,
            String nameSearch, int page, int size) {
        PagedResponse<PetResponse> paged = tamagochiService.findAllPets(authorId, species, null, nameSearch, page, size);
        Page<PetResponse> springPage = new PageImpl<>(
                paged.content(),
                PageRequest.of(paged.pageNumber(), paged.pageSize()),
                paged.totalElements()
        );
        return pagedResourcesAssembler.toModel(springPage, tamagochiModelAssembler);
    }

    @Override
    public ResponseEntity<EntityModel<PetResponse>> createBook(@Valid PetRequest request) {
        PetResponse created = tamagochiService.createPet(request);
        EntityModel<PetResponse> model = tamagochiModelAssembler.toModel(created);
        return ResponseEntity
                .created(model.getRequiredLink("self").toUri())
                .body(model);
    }

    @Override
    public EntityModel<PetResponse> updatePet(Long id, @Valid UpdatePetRequest request) {
        return tamagochiModelAssembler.toModel(tamagochiService.updaPet(id, request));
    }

    @Override
    public EntityModel<PetResponse> patchPet(Long id, @Valid PatchPetRequest request) {
        return tamagochiModelAssembler.toModel(tamagochiService.patcPet(id, request));
    }

    @Override
    public void deleteBook(Long id) {
        tamagochiService.deletePet(id);        
    }

    
    
    
}

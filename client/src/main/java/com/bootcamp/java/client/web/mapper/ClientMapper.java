package com.bootcamp.java.client.web.mapper;

import com.bootcamp.java.client.domain.Client;
import com.bootcamp.java.client.web.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    //Permite crear un modelo a una entidad de dominio
    Client modelToEntity (ClientModel model);
    //de un dominio a una entidad de modelo para navegar entre las capas
    ClientModel entityToModel (Client event);
    //actualizar una entidad existente con otra
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Client entity, Client updateEntity);

}

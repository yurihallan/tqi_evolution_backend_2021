package com.tqi.SCred_TQI.mapper;

import com.tqi.SCred_TQI.DTO.request.EnderecoDTO;
import com.tqi.SCred_TQI.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EnderecoMapper {

    public static final EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    public abstract Endereco toModel(EnderecoDTO enderecoDTO);

    public abstract EnderecoDTO toDTO(Endereco endereco);
}

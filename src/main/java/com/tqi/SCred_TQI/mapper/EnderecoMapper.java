package com.tqi.SCred_TQI.mapper;

import com.tqi.SCred_TQI.DTO.request.EnderecoDTO;
import com.tqi.SCred_TQI.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);


    Endereco toModel(EnderecoDTO enderecoDTO);

    EnderecoDTO toDTO(Endereco endereco);
}

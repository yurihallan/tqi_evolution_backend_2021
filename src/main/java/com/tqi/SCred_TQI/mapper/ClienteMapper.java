package com.tqi.SCred_TQI.mapper;


import com.tqi.SCred_TQI.DTO.request.ClienteDTO;
import com.tqi.SCred_TQI.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public abstract Cliente toModel(ClienteDTO clienteDTO);

    public abstract ClienteDTO toDTO(Cliente cliente);
}

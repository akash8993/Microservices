package com.akash.organizationservice.service;

import com.akash.organizationservice.dto.OrganizationDto;
import com.akash.organizationservice.entity.Organization;
import com.akash.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationDto saveOrganization(OrganizationDto organizationDto)
    {
        Organization organization= modelMapper.map(organizationDto, Organization.class);
        return modelMapper.map(organizationRepository.save(organization), OrganizationDto.class);
    }

    public OrganizationDto getOrganizationByCode(String code)
    {
        return modelMapper.map(organizationRepository.findByOrganizationCode(code),OrganizationDto.class);
    }
}

package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.CompanyDTO;
import by.senla.tatianabakach.entity.Company;
import by.senla.tatianabakach.mapper.CompanyMapper;
import by.senla.tatianabakach.repository.AddressRepository;
import by.senla.tatianabakach.repository.CompanyRepository;
import by.senla.tatianabakach.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends CrudServiceImpl<Company, CompanyDTO, CompanyMapper, CompanyRepository>
        implements CompanyService {

    private final AddressRepository addressRepository;

    protected CompanyServiceImpl(CompanyRepository repository, CompanyMapper mapper, AddressRepository addressRepository) {

        super(repository, mapper, Company.class);
        this.addressRepository = addressRepository;
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = Company.builder()
                .name(companyDTO.getName())
                .type(companyDTO.getType())
                .payerRegistrationNumber(companyDTO.getPayerRegistrationNumber())
                .legalAddress(addressRepository.getReferenceById(companyDTO.getLegalAddress().getId()))
                .postAddress(addressRepository.getReferenceById(companyDTO.getPostAddress().getId()))
                .bankData(companyDTO.getBankData())
                .email(companyDTO.getEmail())
                .phone(companyDTO.getPhone())
                .build();
        return mapper.toDto(repository.save(company));
    }
}

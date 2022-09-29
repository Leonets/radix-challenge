 package rdx.gateway.challenge.util.mapper;

 import org.mapstruct.InheritInverseConfiguration;
 import org.mapstruct.Mapper;
 import org.mapstruct.factory.Mappers;
 import rdx.gateway.challenge.model.TokenTransfer;
 import rdx.gateway.challenge.model.Transfers;

 import java.util.List;

@Mapper
public interface TransfersMapper {

    TransfersMapper MAPPER = Mappers.getMapper(TransfersMapper.class);

    List<TokenTransfer> toTransfersList(List<Transfers> transfers);

    @InheritInverseConfiguration
    List<Transfers> fromTransfersList(List<TokenTransfer> errorList);
}

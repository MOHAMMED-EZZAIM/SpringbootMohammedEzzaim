package usa.harvard.tp1_commande.ws.convertie;
import org.springframework.stereotype.Component;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.ws.dto.PaiementDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class PaiementConverture {

//    public PaiementDto toDto(Paiement paiement){
//        PaiementDto paiementDto=new PaiementDto();
//        paiementDto.setId(paiement.getId());
//        paiementDto.setCode(paiement.getCode());
//        paiementDto.setTypePaiement(paiement.getTypePaiement());
//        paiementDto.setDatePaiement(paiement.getDatePaiement());
//        paiementDto.setEncaissement(paiement.isEncaissement());
//        return  paiementDto;
//    }
//    public Paiement toBean(PaiementDto paiementDto){
//        Paiement paiement=new Paiement();
//        paiement.setId(paiementDto.getId());
//        paiement.setCode(paiementDto.getCode());
//        paiement.setCommande(paiementDto.getCommande());
//        paiement.setTypePaiement(paiementDto.getTypePaiement());
//        paiement.setEncaissement(paiementDto.isEncaissement());
//        paiement.setDatePaiement(paiementDto.getDatePaiement());
//        return paiement;
//    }
//    public List<Paiement> toBean(List<PaiementDto> dtos){
//        List<Paiement> result = new ArrayList<>();
//        for(PaiementDto dto : dtos){
//            result.add(toBean(dto));
//        }
//        return  result ;
//    }
//    public List<PaiementDto> toDto(List<Paiement> beans){
//        return beans.stream().map(this::toDto).collect(Collectors.toList());
//    }
}

package usa.harvard.tp1_commande.ws.convertie;

import org.springframework.stereotype.Component;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.ws.dto.TypePaiementDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypePaiementConverture {
//    public TypePaiementDto toDto(TypePaiement typePaiement){
//        TypePaiementDto typePaiementDto=new TypePaiementDto();
//        typePaiementDto.setId(typePaiement.getId());
//        typePaiementDto.setCode(typePaiement.getCode());
//        typePaiementDto.setLibelle(typePaiement.getLibelle());
//       return  typePaiementDto;
//    }
//    public TypePaiement toBean(TypePaiementDto typePaiementDto){
//        TypePaiement typePaiement=new TypePaiement();
//        typePaiement.setId(typePaiementDto.getId());
//        typePaiement.setCode(typePaiementDto.getCode());
//        typePaiement.setLibelle(typePaiementDto.getLibelle());
//        return  typePaiement;
//    }
//    public  List<TypePaiement> toBean(List<TypePaiementDto> typePaiementDtoList){
//        List<TypePaiement> typePaiements=new ArrayList<>();
//        typePaiementDtoList.forEach(type->{
//            typePaiements.add(toBean(type));
//        });
//        return typePaiements;
//    }
//    public  List<TypePaiementDto> toDto(List<TypePaiement> typePaiements){
//        List<TypePaiementDto> typePaiementDtoList=new ArrayList<>();
//        typePaiements.forEach(type->{
//            typePaiementDtoList.add(toDto(type));
//        });
//        return typePaiementDtoList;
//    }
}

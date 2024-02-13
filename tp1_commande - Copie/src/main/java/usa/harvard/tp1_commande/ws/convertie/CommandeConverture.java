package usa.harvard.tp1_commande.ws.convertie;

import org.springframework.stereotype.Component;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.dao.CommandeDao;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandeConverture {
//    public Commande toBean(CommandeDto commandeDto){
//        Commande bean=new Commande();
//        bean.setId(commandeDto.getId());
//        bean.setRef(commandeDto.getRef());
//        bean.setTotal(commandeDto.getTotal());
//        bean.setTotalPayer(commandeDto.getTotalPayer());
//        return  bean;
//    }
//    public CommandeDto toDto(Commande commande){
//        CommandeDto commandeDto=new CommandeDto();
//        commandeDto.setId(commande.getId());
//        commandeDto.setRef(commande.getRef());
//        commandeDto.setTotal(commande.getTotal());
//        commandeDto.setTotalPayer(commande.getTotalPayer());
//        return commandeDto;
//    }
//    public List<Commande> toBean(List<CommandeDto> dtos){
//        List<Commande> result = new ArrayList<>();
//        for (CommandeDto dto : dtos) {
//            result.add(toBean(dto));
//        }
//        return result;
//    }
//    public List<CommandeDto> toDto(List<Commande> beans) {
//        List<CommandeDto> result = new ArrayList<>();
//        for (Commande dto : beans) {
//            result.add(toDto(dto));
//        }
//        return result;    }

}

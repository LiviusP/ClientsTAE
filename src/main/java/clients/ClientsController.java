package clients; /**
 * Created by Livius on 5/27/2017.
 */
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ClientsController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/clients", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }



    @RequestMapping(value="/createclient", method = RequestMethod.POST)
    @ResponseBody
    public String saveClient(@RequestParam String name){

        Client client = new Client();
        client.setclientName(name);
        client.setClientOrders(0);
        clientRepository.save(client);

        return client.getclientId().toString();
    }

    @RequestMapping(value = "/removeclient", method = RequestMethod.POST)
    @ResponseBody
    public String removeClient(@RequestParam Long Id){
        clientRepository.delete(Id);
        return Id.toString();
    }

    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    @ResponseBody
    public String addOrder(@RequestParam Long Id){

        Client client = clientRepository.findOne(Id);
        client.setClientOrders(client.getClientOrders() + 1);
        clientRepository.save(client);

        Map<String, Object> returnData = new HashMap<String, Object>(){{put("Id", Id);
                        put("orders", client.getClientOrders());}};

        return Utils.createJsonString(returnData);
    }
}

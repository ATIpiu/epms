package com.epms.webController;

import com.epms.entity.Client;
import com.epms.entity.Staff;
import com.epms.service.ClientService;
import com.epms.service.StaffService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/frontDesk")
public class FrontDeskController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private ClientService clientService;

    @RequestMapping("getAllClient")
    public Result getClients(@RequestParam(value = "keyWord", required = false, defaultValue = "") String key,
                             @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (key != "")
            return clientService.getAllClients(page, pageSize);
        else return clientService.queryClientByKeyword(key, page, pageSize);
    }

    @RequestMapping("getAllStaff")
    public Result getStaffs(@RequestParam(value = "keyWord", required = false, defaultValue = "") String key,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (key != "")
            return staffService.getAllStaffs(page, pageSize);
        else return staffService.queryStaffByKeyword(key, page, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/updateClientInfo", method = RequestMethod.POST)
    public Result updateInfo(Client client) {
        return clientService.updateClient(client);
    }

    @ResponseBody
    @RequestMapping(value = "/updateStaffInfo", method = RequestMethod.POST)
    public Result updateInfo(Staff staff) {
        return staffService.updateStaff(staff);
    }

    @ResponseBody
    @RequestMapping(value = "/addStaff",method = RequestMethod.POST)
    public Result addStaff(Staff staff){
        return staffService.addStaff(staff);
    }

    @ResponseBody
    @RequestMapping(value = "/addClient",method = RequestMethod.POST)
    public Result addClient(Client client){
        return clientService.addClient(client);
    }
    @ResponseBody
    @RequestMapping(value = "/getChoose",method = RequestMethod.POST)
    public Result getChoose(){
        try {
            List<Client> clientList= (List<Client>) clientService.getAllClients(1,20).getData().get("clientList");
            List<Staff> staffList= (List<Staff>) staffService.getAllStaffs(1,20).getData().get("staffList");
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("staffList",staffList);
            map.put("clientList",clientList);
            return Result.ok().data(map);
        }catch ( Exception e){
            return Result.error().message(e.toString());
        }

    }

}

package works.hop.dbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class DemoDbController {

    @GetMapping("/date")
    public String date(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy @ hh:mm:ss");
        return sdf.format(new Date());
    }
}

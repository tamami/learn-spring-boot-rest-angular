package lab.aikibo.springservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tamami on 11/12/16.
 */
@Controller
public class HomeController {

  @RequestMapping("/home")
  public String home() {
    return "index";
  }

}

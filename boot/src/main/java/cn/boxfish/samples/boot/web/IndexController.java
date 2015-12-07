package cn.boxfish.samples.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by undancer on 15/12/7.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public void home() {
    }
}

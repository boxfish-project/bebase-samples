package cn.boxfish.samples.emoji.web;

import cn.boxfish.samples.emoji.entity.jpa.ArticleJpaRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by undancer on 15/5/8.
 */
@Controller
@RequestMapping("/")
public class ContentController {

    private String content = "";

    @Autowired
    ArticleJpaRepository articleJpaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String page(String content, Model model) {
        model.addAttribute("content", content);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@RequestParam("content") String content) {
        return new ModelAndView(new RedirectView("/"), ImmutableMap.of("content", content));
    }

}

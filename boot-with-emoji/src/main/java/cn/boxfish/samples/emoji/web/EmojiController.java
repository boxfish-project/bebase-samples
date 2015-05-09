package cn.boxfish.samples.emoji.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by undancer on 15/5/8.
 */
@RestController
@RequestMapping("/emoji")
public class EmojiController implements InitializingBean {

    private String content;

    public void afterPropertiesSet() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.appendCodePoint(128127);
        sb.trimToSize();
        content = sb.toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity home() {
        return new ResponseEntity<>(
                ImmutableMap.of("content", content),
                HttpStatus.OK
        );
    }


}

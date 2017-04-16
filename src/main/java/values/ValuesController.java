package values;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eli on 4/14/2017.
 */

@RestController
public class ValuesController {

    Values values;

    ValuesController() {
        values = new Values();
    }

    @RequestMapping(value ="/api/values", method = RequestMethod.POST)
    public String values(@RequestParam(value="value") Integer value) {
        System.err.println(value);
        return values.addVal(value);
    }

    @RequestMapping(value = "/api/sum/values", method = RequestMethod.GET)
    public Integer sum() {
        return values.sum();
    }

    @RequestMapping(value = "/api/values", method = RequestMethod.DELETE)
    public String delete() {
        return values.delVal();
    }


}

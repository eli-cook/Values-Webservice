package values;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eli on 4/14/2017.
 * Defines the class ValuesController which receives HTTP requests and maps them to their appropriate Values method.
 */

@RestController
public class ValuesController {

    Values values;

    // initializes the controller and creates a new Values object.
    ValuesController() {
        values = new Values();
    }

    // accepts a POST request with a value parameter and then calls the addVal method which adds the value to the array of values.
    @RequestMapping(value ="/api/values", method = RequestMethod.POST)
    public String values(@RequestParam(value="value") Integer value) {
        return values.addVal(value);
    }

    // accepts a GET requests and calls the sum method, then returns the sum of added values.
    @RequestMapping(value = "/api/sum/values", method = RequestMethod.GET)
    public Integer sum() {
        return values.sum();
    }

    // accepts a DELETE request and calls the delVal method which deletes all values in the array.
    @RequestMapping(value = "/api/values", method = RequestMethod.DELETE)
    public String delete() {
        return values.delVal();
    }


}

package statisticanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import statisticanalyzer.controller.dto.Matrix;
import statisticanalyzer.domain.Message;
import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;

/**
 * Created by Igor on 24.06.2016.
 */

@RestController
public class HelloController {

    private static final int ROUND_PLACES = 3;

    @Autowired
    private Normalization normalization;

    @RequestMapping(value = "/main/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping("/main/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.

        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

    @RequestMapping("/main/hello")
    public Message wow(@PathVariable String player) {
        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

    @RequestMapping("/main/matrix")
    public double[][] returnMatrix() {//REST Endpoint.
        return new double[][]{{0, 1, 3}, {2, 3, 5}};
    }

    @RequestMapping("/main/norm")
    public Matrix returnNormMatrix() {
        Matrix matrix = new Matrix(normalization.norm(new double[][]{{0, 1, 3}, {2, 3, 5}}));
        return matrix;
    }

    @RequestMapping(path = "/normalize", method = RequestMethod.POST)
    public double[][] normalizeMatrix(@RequestBody Matrix matrix) {
        double[][] normalizedData = normalization.norm(matrix.getMatrix());
        return MathUtils.roundMatrix(normalizedData, ROUND_PLACES);
    }

}

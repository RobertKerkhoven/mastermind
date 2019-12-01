package eu.datagraphics.demo.controller;



import eu.datagraphics.demo.service.MathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CombinationsControllerIT {

    @MockBean
    private CombinationsController controller;

    @Autowired
    private MathService mathService;

    @Test
    public void controllerInitializedCorrectly() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getShuffledCombinationTest(){
        List<String> combinations =  mathService.getShuffledCombinations("aabb");
        assertThat(combinations.get(0)).isEqualTo("123");
    }
}
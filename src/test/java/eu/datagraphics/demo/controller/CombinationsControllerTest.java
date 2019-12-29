package eu.datagraphics.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.datagraphics.demo.controller.advice.Violation;
import eu.datagraphics.demo.dto.MasterMindDTO;
import eu.datagraphics.demo.service.MathService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.when;
import org.junit.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CombinationsController.class)
@ActiveProfiles("test")
public class CombinationsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MathService mathService;

    @Value("${pinholes}")
    Integer amountPinholes;

    private JacksonTester<MasterMindDTO> jsonContentA;
    private JacksonTester<ArrayList<String>> jsonResponse;
    private JacksonTester<HashMap<String, ArrayList<Violation>>> jsonResponseViolation;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void TestOk() throws Exception {

        MasterMindDTO input = new MasterMindDTO();
        input.setChellange("4455");

        ArrayList<String> output = new ArrayList<>();
        output.add("22");output.add("33");

        when(mathService.getShuffledCombinations("4455")).thenReturn(output);

        mvc.perform(MockMvcRequestBuilders.post("/mastermind/getcombinations")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContentA.write(input).getJson()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding("UTF-8"))
                .andExpect(content().string(jsonResponse.write(output).getJson()))
                .andDo(print());
    }

    @Test
    public void TestBadRequest_Input_Not_In_Range() throws Exception {

        MasterMindDTO input = new MasterMindDTO();
        input.setChellange("445555");

        ArrayList<Violation> violations = new ArrayList<>();

        violations.add(new Violation("chellange","Should contain 4 guesses"));
        HashMap s = new HashMap();
        s.put("violations", violations);

        ArrayList<String> output = new ArrayList<>();
        output.add("22");output.add("33");

        when(mathService.getShuffledCombinations("4455555")).thenReturn(output);

        mvc.perform(MockMvcRequestBuilders.post("/mastermind/getcombinations")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContentA.write(input).getJson()))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding("UTF-8"))
                .andExpect(content().string(jsonResponseViolation.write(s).getJson()))
                .andDo(print());
    }

    @Test
    public void TestBadRequest_No_Input() throws Exception {

        MasterMindDTO input = new MasterMindDTO();

        ArrayList<Violation> violations = new ArrayList<>();

        violations.add(new Violation("chellange","Can not be empty"));
        HashMap s = new HashMap();
        s.put("violations", violations);

        ArrayList<String> output = new ArrayList<>();
        output.add("22");output.add("33");

        mvc.perform(MockMvcRequestBuilders.post("/mastermind/getcombinations")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContentA.write(input).getJson()))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding("UTF-8"))
                .andExpect(content().string(jsonResponseViolation.write(s).getJson()))
                .andDo(print());
    }
}

package com.buchdemo.buchcontrol.controllerTest;

import com.buchdemo.buchcontrol.control.BuchController;
import com.buchdemo.buchcontrol.model.Buch;
import com.buchdemo.buchcontrol.service.BuchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(BuchController.class)
public class BuchControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BuchService buchService;

    @Test
    public void ifFoundTitle_return () throws Exception {
        Buch newB = new Buch("abc","HORROR","any");
        List<Buch> allBooks = Arrays.asList(newB);

        given(buchService.findByTitel("horror")).willReturn(allBooks);

        mockMvc.perform(get("suchenTitel/{titel}")).andExpect(status().isOk());
    }
}

package com.example.beeline;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = BeelineApplication.class)
@AutoConfigureMockMvc
class AccountRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Check transfer")
    void testTransferMoney() throws Exception {
        Integer amount = 1000, accountFrom = 11111116, accountTo = 11111111;
        this.mockMvc.perform(get("/transferMoney").param("amount", String.valueOf(amount))
                .param("accountFrom", String.valueOf(accountFrom))
                .param("accountTo", String.valueOf(accountTo)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Check transfer fake amount")
    void testTransferMoneyFakeAmount() throws Exception {
        Integer amount = 10000, accountFrom = 11111116, accountTo = 11111111;
        this.mockMvc.perform(get("/transferMoney").param("amount", String.valueOf(amount))
                .param("accountFrom", String.valueOf(accountFrom))
                .param("accountTo", String.valueOf(accountTo)))

                .andExpect(status().isMultiStatus())
        .andDo(print());
    }

    @Test
    @DisplayName("Check transfer fake account from")
    void testTransferMoneyFakeAccountFrom() throws Exception {
        Integer amount = 10000, accountFrom = 11111110, accountTo = 11111111;
        this.mockMvc.perform(get("/transferMoney").param("amount", String.valueOf(amount))
                .param("accountFrom", String.valueOf(accountFrom))
                .param("accountTo", String.valueOf(accountTo)))

                .andExpect(status().isMultiStatus())
                .andDo(print());
    }

    @Test
    @DisplayName("Check transfer fake account to")
    void testTransferMoneyFakeAccountTo() throws Exception {
        Integer amount = 10000, accountFrom = 11111111, accountTo = 11111110;
        this.mockMvc.perform(get("/transferMoney").param("amount", String.valueOf(amount))
                .param("accountFrom", String.valueOf(accountFrom))
                .param("accountTo", String.valueOf(accountTo)))

                .andExpect(status().isMultiStatus())
                .andDo(print());
    }
}
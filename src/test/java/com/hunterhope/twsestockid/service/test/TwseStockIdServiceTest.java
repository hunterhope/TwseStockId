package com.hunterhope.twsestockid.service.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.hunterhope.jsonrequest.service.JsonRequestService;
import com.hunterhope.twsestockid.data.SuggestionInfo;
import com.hunterhope.twsestockid.service.TwseStockIdService;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

/**
 *
 * @author user
 */
public class TwseStockIdServiceTest {

    private JsonRequestService jrs = Mockito.mock(JsonRequestService.class);

    public TwseStockIdServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testUser_normal_input() throws Exception {
        System.out.print("測試使用者輸入一字串對網路發出請求:");
        //準備物件
        String input = "2323";
        TwseStockIdService tsis = new TwseStockIdService(jrs);
        //模擬依賴物件
        SuggestionInfo si = new SuggestionInfo();
        si.setSuggestions(List.of("2323\t中環",
                "2323A\t環甲特",
                "2323R\t中環甲",
                "2323S\t中環乙",
                "2323T\t中環丙",
                "2323V\t中環戊",
                "2323W\t中環己",
                "2323X\t中環庚"));
        Mockito.when(jrs.getData(Mockito.any(), Mockito.eq(SuggestionInfo.class))).thenReturn(si);
        //跑起來
        List<String> suggestions = tsis.suggestStockId(input);
        //驗證
        List<String> exp = List.of("2323 中環", "2323A 環甲特", "2323R 中環甲", "2323S 中環乙", "2323T 中環丙", "2323V 中環戊", "2323W 中環己", "2323X 中環庚");
        assertEquals(exp, suggestions);
        /*預期結果
        json格式
        {
            "query": "2323",
            "suggestions": [
            "2323\t中環",
            "2323A\t環甲特",
            "2323R\t中環甲",
            "2323S\t中環乙",
            "2323T\t中環丙",
            "2323V\t中環戊",
            "2323W\t中環己",
            "2323X\t中環庚"
            ]
        }
        轉成list
        {"2323 中環","2323A 環甲特","2323R 中環甲","2323S 中環乙","2323T 中環丙","2323V 中環戊","2323W 中環己","2323X 中環庚"}
         */
        System.out.println("成功");
    }
}

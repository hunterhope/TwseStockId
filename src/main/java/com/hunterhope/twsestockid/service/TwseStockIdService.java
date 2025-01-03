/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hunterhope.twsestockid.service;

import com.hunterhope.jsonrequest.exception.DataClassFieldNameErrorException;
import com.hunterhope.jsonrequest.exception.NoInternetException;
import com.hunterhope.jsonrequest.exception.ResponseEmptyException;
import com.hunterhope.jsonrequest.exception.ServerMaintainException;
import com.hunterhope.jsonrequest.service.JsonRequestService;
import com.hunterhope.jsonrequest.service.UrlAndQueryString;
import com.hunterhope.twsestockid.data.SuggestionInfo;
import com.hunterhope.twsestockid.exception.TwseStockIdException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author user
 */
public class TwseStockIdService {
    private final JsonRequestService jrs;

    public TwseStockIdService() {
        this.jrs = new JsonRequestService();
    }

    public TwseStockIdService(JsonRequestService jrs) {
        this.jrs = jrs;
    }    
    
    public List<String> suggestStockId(String input) throws TwseStockIdException {
        //建立查詢字串
        UrlAndQueryString qs = new UrlAndQueryString("https://www.twse.com.tw/rwd/zh/api/codeQuery");
        qs.addParam("query", input);
        
        try {
            //發出網路請求
            SuggestionInfo result = jrs.getData(qs,SuggestionInfo.class);
            //消除網路回傳資料的空格
            return result.getSuggestions().stream().map(e->e.replace("\t", " ")).collect(Collectors.toList());
        } catch (NoInternetException | ServerMaintainException | DataClassFieldNameErrorException | ResponseEmptyException ex) {
            throw new TwseStockIdException(ex);
        }
    }
    
}

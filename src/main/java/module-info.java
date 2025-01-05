/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module TwseStockId {
    requires JsonRequest;
    exports com.hunterhope.twsestockid.service;
    exports com.hunterhope.twsestockid.exception;
    opens com.hunterhope.twsestockid.data;
    exports com.hunterhope.twsestockid.data to TwseStockIdTest;
}

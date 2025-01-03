/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module TwseStockIdTest {
    requires TwseStockId;
    requires JsonRequest;
    requires org.mockito;
    requires org.junit.jupiter.api;
    opens com.hunterhope.twsestockid.service.test;
}

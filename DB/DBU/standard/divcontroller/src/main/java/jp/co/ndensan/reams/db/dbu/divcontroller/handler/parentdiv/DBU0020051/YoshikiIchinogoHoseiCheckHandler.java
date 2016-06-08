/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020051;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.YoshikiIchinogoHoseiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBUMN91003_事業報告（月報）補正発行_様式１の５補正
 *
 * @reamsid_L DBU-1100-050 quxiaodong
 */
public class YoshikiIchinogoHoseiCheckHandler {

    private final YoshikiIchinogoHoseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YoshikiIchinogoHoseiDiv
     */
    public YoshikiIchinogoHoseiCheckHandler(YoshikiIchinogoHoseiDiv div) {
        this.div = div;
    }

    /**
     * 画面項目「計」で入力された値の整合性1をチェックします。
     *
     * @return boolean チェック結果
     */
    public boolean is整合性チェック1() {
        return (is要介護要支援整合性() && is居宅介護要支援整合性() && is地域密着型要支援整合性() && is施設介護要支援整合性());
    }

    private boolean is要介護要支援整合性() {
        return (is要介護1要支援整合性()
                && is要介護2要支援整合性() && is要介護3要支援整合性() && is要介護4要支援整合性() && is要介護5要支援整合性());
    }

    private boolean is要介護1要支援整合性() {
        RString 要介護要支援1_1 = div.getPnl11().getTxt110202().getValue();
        RString 要介護要支援1_2 = div.getPnl11().getTxt110203().getValue();
        RString 要介護要支援1_3 = div.getPnl11().getTxt110204().getValue();
        Decimal d要介護要支援1_1 = (null == 要介護要支援1_1 || 要介護要支援1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援1_1.toString());
        Decimal d要介護要支援1_2 = (null == 要介護要支援1_2 || 要介護要支援1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援1_2.toString());
        Decimal d要介護要支援1_3 = (null == 要介護要支援1_3 || 要介護要支援1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援1_3.toString());
        return d要介護要支援1_3.equals(d要介護要支援1_1.add(d要介護要支援1_2));
    }

    private boolean is要介護2要支援整合性() {
        RString 要介護要支援2_1 = div.getPnl11().getTxt110302().getValue();
        RString 要介護要支援2_2 = div.getPnl11().getTxt110303().getValue();
        RString 要介護要支援2_3 = div.getPnl11().getTxt110304().getValue();
        Decimal d要介護要支援2_1 = (null == 要介護要支援2_1 || 要介護要支援2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援2_1.toString());
        Decimal d要介護要支援2_2 = (null == 要介護要支援2_2 || 要介護要支援2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援2_2.toString());
        Decimal d要介護要支援2_3 = (null == 要介護要支援2_3 || 要介護要支援2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援2_3.toString());
        return d要介護要支援2_3.equals(d要介護要支援2_1.add(d要介護要支援2_2));
    }

    private boolean is要介護3要支援整合性() {
        RString 要介護要支援3_1 = div.getPnl11().getTxt11040().getValue();
        RString 要介護要支援3_2 = div.getPnl11().getTxt110403().getValue();
        RString 要介護要支援3_3 = div.getPnl11().getTxt110404().getValue();
        Decimal d要介護要支援3_1 = (null == 要介護要支援3_1 || 要介護要支援3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援3_1.toString());
        Decimal d要介護要支援3_2 = (null == 要介護要支援3_2 || 要介護要支援3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援3_2.toString());
        Decimal d要介護要支援3_3 = (null == 要介護要支援3_3 || 要介護要支援3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援3_3.toString());
        return d要介護要支援3_3.equals(d要介護要支援3_1.add(d要介護要支援3_2));
    }

    private boolean is要介護4要支援整合性() {
        RString 要介護要支援4_1 = div.getPnl11().getTxt110502().getValue();
        RString 要介護要支援4_2 = div.getPnl11().getTxt110503().getValue();
        RString 要介護要支援4_3 = div.getPnl11().getTxt110504().getValue();
        Decimal d要介護要支援4_1 = (null == 要介護要支援4_1 || 要介護要支援4_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援4_1.toString());
        Decimal d要介護要支援4_2 = (null == 要介護要支援4_2 || 要介護要支援4_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援4_2.toString());
        Decimal d要介護要支援4_3 = (null == 要介護要支援4_3 || 要介護要支援4_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援4_3.toString());
        return d要介護要支援4_3.equals(d要介護要支援4_1.add(d要介護要支援4_2));
    }

    private boolean is要介護5要支援整合性() {
        RString 要介護要支援5_1 = div.getPnl11().getTxt110602().getValue();
        RString 要介護要支援5_2 = div.getPnl11().getTxt110603().getValue();
        RString 要介護要支援5_3 = div.getPnl11().getTxt110604().getValue();
        Decimal d要介護要支援5_1 = (null == 要介護要支援5_1 || 要介護要支援5_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援5_1.toString());
        Decimal d要介護要支援5_2 = (null == 要介護要支援5_2 || 要介護要支援5_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援5_2.toString());
        Decimal d要介護要支援5_3 = (null == 要介護要支援5_3 || 要介護要支援5_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要支援5_3.toString());
        return d要介護要支援5_3.equals(d要介護要支援5_1.add(d要介護要支援5_2));
    }

    private boolean is居宅介護要支援整合性() {
        return (is居宅介護1要支援整合性()
                && is居宅介護2要支援整合性() && is居宅介護3要支援整合性());
    }

    private boolean is居宅介護1要支援整合性() {
        RString 居宅介護要支援1_1 = div.getPnl12().getTxt120302().getValue();
        RString 居宅介護要支援1_2 = div.getPnl12().getTxt120303().getValue();
        RString 居宅介護要支援1_3 = div.getPnl12().getTxt120304().getValue();
        Decimal d居宅介護要支援1_1 = (null == 居宅介護要支援1_1 || 居宅介護要支援1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援1_1.toString());
        Decimal d居宅介護要支援1_2 = (null == 居宅介護要支援1_2 || 居宅介護要支援1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援1_2.toString());
        Decimal d居宅介護要支援1_3 = (null == 居宅介護要支援1_3 || 居宅介護要支援1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援1_3.toString());
        return d居宅介護要支援1_3.equals(d居宅介護要支援1_1.add(d居宅介護要支援1_2));
    }

    private boolean is居宅介護2要支援整合性() {
        RString 居宅介護要支援2_1 = div.getPnl12().getTxt120402().getValue();
        RString 居宅介護要支援2_2 = div.getPnl12().getTxt120403().getValue();
        RString 居宅介護要支援2_3 = div.getPnl12().getTxt120404().getValue();
        Decimal d居宅介護要支援2_1 = (null == 居宅介護要支援2_1 || 居宅介護要支援2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援2_1.toString());
        Decimal d居宅介護要支援2_2 = (null == 居宅介護要支援2_2 || 居宅介護要支援2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援2_2.toString());
        Decimal d居宅介護要支援2_3 = (null == 居宅介護要支援2_3 || 居宅介護要支援2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援2_3.toString());
        return d居宅介護要支援2_3.equals(d居宅介護要支援2_1.add(d居宅介護要支援2_2));
    }

    private boolean is居宅介護3要支援整合性() {
        RString 居宅介護要支援3_1 = div.getPnl12().getTxt120502().getValue();
        RString 居宅介護要支援3_2 = div.getPnl12().getTxt120503().getValue();
        RString 居宅介護要支援3_3 = div.getPnl12().getTxt120504().getValue();
        Decimal d居宅介護要支援3_1 = (null == 居宅介護要支援3_1 || 居宅介護要支援3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援3_1.toString());
        Decimal d居宅介護要支援3_2 = (null == 居宅介護要支援3_2 || 居宅介護要支援3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援3_2.toString());
        Decimal d居宅介護要支援3_3 = (null == 居宅介護要支援3_3 || 居宅介護要支援3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要支援3_3.toString());
        return d居宅介護要支援3_3.equals(d居宅介護要支援3_1.add(d居宅介護要支援3_2));
    }

    private boolean is地域密着型要支援整合性() {
        return (is地域密着型1要支援整合性()
                && is地域密着型2要支援整合性() && is地域密着型3要支援整合性());
    }

    private boolean is地域密着型1要支援整合性() {
        RString 地域密着型要支援1_1 = div.getPnl13().getTxt130302().getValue();
        RString 地域密着型要支援1_2 = div.getPnl13().getTxt130303().getValue();
        RString 地域密着型要支援1_3 = div.getPnl13().getTxt130304().getValue();
        Decimal d地域密着型要支援1_1 = (null == 地域密着型要支援1_1 || 地域密着型要支援1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援1_1.toString());
        Decimal d地域密着型要支援1_2 = (null == 地域密着型要支援1_2 || 地域密着型要支援1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援1_2.toString());
        Decimal d地域密着型要支援1_3 = (null == 地域密着型要支援1_3 || 地域密着型要支援1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援1_3.toString());
        return d地域密着型要支援1_3.equals(d地域密着型要支援1_1.add(d地域密着型要支援1_2));
    }

    private boolean is地域密着型2要支援整合性() {
        RString 地域密着型要支援2_1 = div.getPnl13().getTxt130402().getValue();
        RString 地域密着型要支援2_2 = div.getPnl13().getTxt130403().getValue();
        RString 地域密着型要支援2_3 = div.getPnl13().getTxt130404().getValue();
        Decimal d地域密着型要支援2_1 = (null == 地域密着型要支援2_1 || 地域密着型要支援2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援2_1.toString());
        Decimal d地域密着型要支援2_2 = (null == 地域密着型要支援2_2 || 地域密着型要支援2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援2_2.toString());
        Decimal d地域密着型要支援2_3 = (null == 地域密着型要支援2_3 || 地域密着型要支援2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援2_3.toString());
        return d地域密着型要支援2_3.equals(d地域密着型要支援2_1.add(d地域密着型要支援2_2));
    }

    private boolean is地域密着型3要支援整合性() {
        RString 地域密着型要支援3_1 = div.getPnl13().getTxt130502().getValue();
        RString 地域密着型要支援3_2 = div.getPnl13().getTxt130503().getValue();
        RString 地域密着型要支援3_3 = div.getPnl13().getTxt130504().getValue();
        Decimal d地域密着型要支援3_1 = (null == 地域密着型要支援3_1 || 地域密着型要支援3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援3_1.toString());
        Decimal d地域密着型要支援3_2 = (null == 地域密着型要支援3_2 || 地域密着型要支援3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援3_2.toString());
        Decimal d地域密着型要支援3_3 = (null == 地域密着型要支援3_3 || 地域密着型要支援3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要支援3_3.toString());
        return d地域密着型要支援3_3.equals(d地域密着型要支援3_1.add(d地域密着型要支援3_2));
    }

    private boolean is施設介護要支援整合性() {
        return (is施設介護1要支援整合性() && is施設介護2要支援整合性() && is施設介護3要支援整合性()
                && is施設介護4要支援整合性() && is施設介護5要支援整合性() && is施設介護6要支援整合性()
                && is施設介護7要支援整合性() && is施設介護8要支援整合性() && is施設介護9要支援整合性()
                && is施設介護10要支援整合性());
    }

    private boolean is施設介護1要支援整合性() {
        RString 施設介護要支援1_1 = div.getPnl14().getTxt140302().getValue();
        RString 施設介護要支援1_2 = div.getPnl14().getTxt140303().getValue();
        RString 施設介護要支援1_3 = div.getPnl14().getTxt140304().getValue();
        Decimal d施設介護要支援1_1 = (null == 施設介護要支援1_1 || 施設介護要支援1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援1_1.toString());
        Decimal d施設介護要支援1_2 = (null == 施設介護要支援1_2 || 施設介護要支援1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援1_2.toString());
        Decimal d施設介護要支援1_3 = (null == 施設介護要支援1_3 || 施設介護要支援1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援1_3.toString());
        return d施設介護要支援1_3.equals(d施設介護要支援1_1.add(d施設介護要支援1_2));
    }

    private boolean is施設介護2要支援整合性() {

        RString 施設介護要支援2_1 = div.getPnl14().getTxt140402().getValue();
        RString 施設介護要支援2_2 = div.getPnl14().getTxt140403().getValue();
        RString 施設介護要支援2_3 = div.getPnl14().getTxt140404().getValue();
        Decimal d施設介護要支援2_1 = (null == 施設介護要支援2_1 || 施設介護要支援2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援2_1.toString());
        Decimal d施設介護要支援2_2 = (null == 施設介護要支援2_2 || 施設介護要支援2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援2_2.toString());
        Decimal d施設介護要支援2_3 = (null == 施設介護要支援2_3 || 施設介護要支援2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援2_3.toString());
        return d施設介護要支援2_3.equals(d施設介護要支援2_1.add(d施設介護要支援2_2));
    }

    private boolean is施設介護3要支援整合性() {
        RString 施設介護要支援3_1 = div.getPnl14().getTxt140502().getValue();
        RString 施設介護要支援3_2 = div.getPnl14().getTxt140503().getValue();
        RString 施設介護要支援3_3 = div.getPnl14().getTxt140504().getValue();
        Decimal d施設介護要支援3_1 = (null == 施設介護要支援3_1 || 施設介護要支援3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援3_1.toString());
        Decimal d施設介護要支援3_2 = (null == 施設介護要支援3_2 || 施設介護要支援3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援3_2.toString());
        Decimal d施設介護要支援3_3 = (null == 施設介護要支援3_3 || 施設介護要支援3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援3_3.toString());
        return d施設介護要支援3_3.equals(d施設介護要支援3_1.add(d施設介護要支援3_2));
    }

    private boolean is施設介護4要支援整合性() {
        RString 施設介護要支援4_1 = div.getPnl14().getTxt140602().getValue();
        RString 施設介護要支援4_2 = div.getPnl14().getTxt140603().getValue();
        RString 施設介護要支援4_3 = div.getPnl14().getTxt140604().getValue();
        Decimal d施設介護要支援4_1 = (null == 施設介護要支援4_1 || 施設介護要支援4_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援4_1.toString());
        Decimal d施設介護要支援4_2 = (null == 施設介護要支援4_2 || 施設介護要支援4_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援4_2.toString());
        Decimal d施設介護要支援4_3 = (null == 施設介護要支援4_3 || 施設介護要支援4_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援4_3.toString());
        return d施設介護要支援4_3.equals(d施設介護要支援4_1.add(d施設介護要支援4_2));
    }

    private boolean is施設介護5要支援整合性() {
        RString 施設介護要支援5_1 = div.getPnl14().getTxt140702().getValue();
        RString 施設介護要支援5_2 = div.getPnl14().getTxt140703().getValue();
        RString 施設介護要支援5_3 = div.getPnl14().getTxt140704().getValue();
        Decimal d施設介護要支援5_1 = (null == 施設介護要支援5_1 || 施設介護要支援5_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援5_1.toString());
        Decimal d施設介護要支援5_2 = (null == 施設介護要支援5_2 || 施設介護要支援5_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援5_2.toString());
        Decimal d施設介護要支援5_3 = (null == 施設介護要支援5_3 || 施設介護要支援5_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援5_3.toString());
        return d施設介護要支援5_3.equals(d施設介護要支援5_1.add(d施設介護要支援5_2));
    }

    private boolean is施設介護6要支援整合性() {
        RString 施設介護要支援6_1 = div.getPnl14().getTxt140802().getValue();
        RString 施設介護要支援6_2 = div.getPnl14().getTxt140803().getValue();
        RString 施設介護要支援6_3 = div.getPnl14().getTxt140804().getValue();
        Decimal d施設介護要支援6_1 = (null == 施設介護要支援6_1 || 施設介護要支援6_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援6_1.toString());
        Decimal d施設介護要支援6_2 = (null == 施設介護要支援6_2 || 施設介護要支援6_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援6_2.toString());
        Decimal d施設介護要支援6_3 = (null == 施設介護要支援6_3 || 施設介護要支援6_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援6_3.toString());
        return d施設介護要支援6_3.equals(d施設介護要支援6_1.add(d施設介護要支援6_2));
    }

    private boolean is施設介護7要支援整合性() {
        RString 施設介護要支援7_1 = div.getPnl14().getTxt140902().getValue();
        RString 施設介護要支援7_2 = div.getPnl14().getTxt140903().getValue();
        RString 施設介護要支援7_3 = div.getPnl14().getTxt140904().getValue();
        Decimal d施設介護要支援7_1 = (null == 施設介護要支援7_1 || 施設介護要支援7_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援7_1.toString());
        Decimal d施設介護要支援7_2 = (null == 施設介護要支援7_2 || 施設介護要支援7_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援7_2.toString());
        Decimal d施設介護要支援7_3 = (null == 施設介護要支援7_3 || 施設介護要支援7_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援7_3.toString());
        return d施設介護要支援7_3.equals(d施設介護要支援7_1.add(d施設介護要支援7_2));
    }

    private boolean is施設介護8要支援整合性() {
        RString 施設介護要支援8_1 = div.getPnl14().getTxt141002().getValue();
        RString 施設介護要支援8_2 = div.getPnl14().getTxt141003().getValue();
        RString 施設介護要支援8_3 = div.getPnl14().getTxt141004().getValue();
        Decimal d施設介護要支援8_1 = (null == 施設介護要支援8_1 || 施設介護要支援8_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援8_1.toString());
        Decimal d施設介護要支援8_2 = (null == 施設介護要支援8_2 || 施設介護要支援8_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援8_2.toString());
        Decimal d施設介護要支援8_3 = (null == 施設介護要支援8_3 || 施設介護要支援8_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援8_3.toString());
        return d施設介護要支援8_3.equals(d施設介護要支援8_1.add(d施設介護要支援8_2));
    }

    private boolean is施設介護9要支援整合性() {
        RString 施設介護要支援9_1 = div.getPnl14().getTxt141102().getValue();
        RString 施設介護要支援9_2 = div.getPnl14().getTxt141103().getValue();
        RString 施設介護要支援9_3 = div.getPnl14().getTxt141104().getValue();
        Decimal d施設介護要支援9_1 = (null == 施設介護要支援9_1 || 施設介護要支援9_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援9_1.toString());
        Decimal d施設介護要支援9_2 = (null == 施設介護要支援9_2 || 施設介護要支援9_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援9_2.toString());
        Decimal d施設介護要支援9_3 = (null == 施設介護要支援9_3 || 施設介護要支援9_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援9_3.toString());
        return d施設介護要支援9_3.equals(d施設介護要支援9_1.add(d施設介護要支援9_2));
    }

    private boolean is施設介護10要支援整合性() {
        RString 施設介護要支援10_1 = div.getPnl14().getTxt141202().getValue();
        RString 施設介護要支援10_2 = div.getPnl14().getTxt141203().getValue();
        RString 施設介護要支援10_3 = div.getPnl14().getTxt141204().getValue();
        Decimal d施設介護要支援10_1 = (null == 施設介護要支援10_1 || 施設介護要支援10_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援10_1.toString());
        Decimal d施設介護要支援10_2 = (null == 施設介護要支援10_2 || 施設介護要支援10_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援10_2.toString());
        Decimal d施設介護要支援10_3 = (null == 施設介護要支援10_3 || 施設介護要支援10_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要支援10_3.toString());
        return d施設介護要支援10_3.equals(d施設介護要支援10_1.add(d施設介護要支援10_2));
    }

    /**
     * 画面項目「計」で入力された値の整合性2をチェックします。
     *
     * @return boolean チェック結果
     */
    public boolean is整合性チェック2() {
        return (is要介護要介護整合性() && is居宅介護要介護整合性() && is地域密着型要介護整合性() && is施設介護要介護整合性());
    }

    private boolean is要介護要介護整合性() {
        return (is要介護1要介護整合性()
                && is要介護2要介護整合性() && is要介護3要介護整合性() && is要介護4要介護整合性() && is要介護5要介護整合性());
    }

    private boolean is要介護1要介護整合性() {
        RString 要介護要介護1_1 = div.getPnl11().getTxt110206().getValue();
        RString 要介護要介護1_2 = div.getPnl11().getTxt110207().getValue();
        RString 要介護要介護1_3 = div.getPnl11().getTxt110208().getValue();
        RString 要介護要介護1_4 = div.getPnl11().getTxt110209().getValue();
        RString 要介護要介護1_5 = div.getPnl11().getTxt110210().getValue();
        RString 要介護要介護1_6 = div.getPnl11().getTxt110211().getValue();
        Decimal d要介護要介護1_1 = (null == 要介護要介護1_1 || 要介護要介護1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護1_1.toString());
        Decimal d要介護要介護1_2 = (null == 要介護要介護1_2 || 要介護要介護1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護1_2.toString());
        Decimal d要介護要介護1_3 = (null == 要介護要介護1_3 || 要介護要介護1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護1_3.toString());
        Decimal d要介護要介護1_4 = (null == 要介護要介護1_4 || 要介護要介護1_4.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護1_4.toString());
        Decimal d要介護要介護1_5 = (null == 要介護要介護1_5 || 要介護要介護1_5.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護1_5.toString());
        Decimal d要介護要介護1_6 = (null == 要介護要介護1_6 || 要介護要介護1_6.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護1_6.toString());
        return d要介護要介護1_6.equals(d要介護要介護1_1.add(d要介護要介護1_2).add(d要介護要介護1_3).
                add(d要介護要介護1_4).add(d要介護要介護1_5));
    }

    private boolean is要介護2要介護整合性() {
        RString 要介護要介護2_1 = div.getPnl11().getTxt110306().getValue();
        RString 要介護要介護2_2 = div.getPnl11().getTxt110307().getValue();
        RString 要介護要介護2_3 = div.getPnl11().getTxt110308().getValue();
        RString 要介護要介護2_4 = div.getPnl11().getTxt110309().getValue();
        RString 要介護要介護2_5 = div.getPnl11().getTxt110310().getValue();
        RString 要介護要介護2_6 = div.getPnl11().getTxt110311().getValue();
        Decimal d要介護要介護2_1 = (null == 要介護要介護2_1 || 要介護要介護2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護2_1.toString());
        Decimal d要介護要介護2_2 = (null == 要介護要介護2_2 || 要介護要介護2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護2_2.toString());
        Decimal d要介護要介護2_3 = (null == 要介護要介護2_3 || 要介護要介護2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護2_3.toString());
        Decimal d要介護要介護2_4 = (null == 要介護要介護2_4 || 要介護要介護2_4.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護2_4.toString());
        Decimal d要介護要介護2_5 = (null == 要介護要介護2_5 || 要介護要介護2_5.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護2_5.toString());
        Decimal d要介護要介護2_6 = (null == 要介護要介護2_6 || 要介護要介護2_6.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護2_6.toString());
        return d要介護要介護2_6.equals(d要介護要介護2_1.add(d要介護要介護2_2).add(d要介護要介護2_3).
                add(d要介護要介護2_4).add(d要介護要介護2_5));
    }

    private boolean is要介護3要介護整合性() {
        RString 要介護要介護3_1 = div.getPnl11().getTxt110406().getValue();
        RString 要介護要介護3_2 = div.getPnl11().getTxt110407().getValue();
        RString 要介護要介護3_3 = div.getPnl11().getTxt110408().getValue();
        RString 要介護要介護3_4 = div.getPnl11().getTxt110409().getValue();
        RString 要介護要介護3_5 = div.getPnl11().getTxt110410().getValue();
        RString 要介護要介護3_6 = div.getPnl11().getTxt110411().getValue();
        Decimal d要介護要介護3_1 = (null == 要介護要介護3_1 || 要介護要介護3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護3_1.toString());
        Decimal d要介護要介護3_2 = (null == 要介護要介護3_2 || 要介護要介護3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護3_2.toString());
        Decimal d要介護要介護3_3 = (null == 要介護要介護3_3 || 要介護要介護3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護3_3.toString());
        Decimal d要介護要介護3_4 = (null == 要介護要介護3_4 || 要介護要介護3_4.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護3_4.toString());
        Decimal d要介護要介護3_5 = (null == 要介護要介護3_5 || 要介護要介護3_5.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護3_5.toString());
        Decimal d要介護要介護3_6 = (null == 要介護要介護3_6 || 要介護要介護3_6.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護3_6.toString());
        return d要介護要介護3_6.equals(d要介護要介護3_1.add(d要介護要介護3_2).add(d要介護要介護3_3).
                add(d要介護要介護3_4).add(d要介護要介護3_5));
    }

    private boolean is要介護4要介護整合性() {
        RString 要介護要介護4_1 = div.getPnl11().getTxt110506().getValue();
        RString 要介護要介護4_2 = div.getPnl11().getTxt110507().getValue();
        RString 要介護要介護4_3 = div.getPnl11().getTxt110508().getValue();
        RString 要介護要介護4_4 = div.getPnl11().getTxt110509().getValue();
        RString 要介護要介護4_5 = div.getPnl11().getTxt110510().getValue();
        RString 要介護要介護4_6 = div.getPnl11().getTxt110511().getValue();
        Decimal d要介護要介護4_1 = (null == 要介護要介護4_1 || 要介護要介護4_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護4_1.toString());
        Decimal d要介護要介護4_2 = (null == 要介護要介護4_2 || 要介護要介護4_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護4_2.toString());
        Decimal d要介護要介護4_3 = (null == 要介護要介護4_3 || 要介護要介護4_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護4_3.toString());
        Decimal d要介護要介護4_4 = (null == 要介護要介護4_4 || 要介護要介護4_4.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護4_4.toString());
        Decimal d要介護要介護4_5 = (null == 要介護要介護4_5 || 要介護要介護4_5.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護4_5.toString());
        Decimal d要介護要介護4_6 = (null == 要介護要介護4_6 || 要介護要介護4_6.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護4_6.toString());
        return d要介護要介護4_6.equals(d要介護要介護4_1.add(d要介護要介護4_2).add(d要介護要介護4_3).
                add(d要介護要介護4_4).add(d要介護要介護4_5));
    }

    private boolean is要介護5要介護整合性() {
        RString 要介護要介護5_1 = div.getPnl11().getTxt110606().getValue();
        RString 要介護要介護5_2 = div.getPnl11().getTxt110607().getValue();
        RString 要介護要介護5_3 = div.getPnl11().getTxt110608().getValue();
        RString 要介護要介護5_4 = div.getPnl11().getTxt110609().getValue();
        RString 要介護要介護5_5 = div.getPnl11().getTxt110610().getValue();
        RString 要介護要介護5_6 = div.getPnl11().getTxt110611().getValue();
        Decimal d要介護要介護5_1 = (null == 要介護要介護5_1 || 要介護要介護5_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護5_1.toString());
        Decimal d要介護要介護5_2 = (null == 要介護要介護5_2 || 要介護要介護5_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護5_2.toString());
        Decimal d要介護要介護5_3 = (null == 要介護要介護5_3 || 要介護要介護5_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護5_3.toString());
        Decimal d要介護要介護5_4 = (null == 要介護要介護5_4 || 要介護要介護5_4.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護5_4.toString());
        Decimal d要介護要介護5_5 = (null == 要介護要介護5_5 || 要介護要介護5_5.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護5_5.toString());
        Decimal d要介護要介護5_6 = (null == 要介護要介護5_6 || 要介護要介護5_6.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護要介護5_6.toString());
        return d要介護要介護5_6.equals(d要介護要介護5_1.add(d要介護要介護5_2).add(d要介護要介護5_3).
                add(d要介護要介護5_4).add(d要介護要介護5_5));
    }

    private boolean is居宅介護要介護整合性() {
        return (is居宅介護1要介護整合性()
                && is居宅介護2要介護整合性() && is居宅介護3要介護整合性());
    }

    private boolean is居宅介護1要介護整合性() {
        RString 居宅介護要介護1_1 = div.getPnl12().getTxt120306().getValue();
        RString 居宅介護要介護1_2 = div.getPnl12().getTxt120307().getValue();
        RString 居宅介護要介護1_3 = div.getPnl12().getTxt120308().getValue();
        RString 居宅介護要介護1_4 = div.getPnl12().getTxt120309().getValue();
        RString 居宅介護要介護1_5 = div.getPnl12().getTxt120310().getValue();
        RString 居宅介護要介護1_6 = div.getPnl12().getTxt120311().getValue();
        Decimal d居宅介護要介護1_1 = (null == 居宅介護要介護1_1 || 居宅介護要介護1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護1_1.toString());
        Decimal d居宅介護要介護1_2 = (null == 居宅介護要介護1_2 || 居宅介護要介護1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護1_2.toString());
        Decimal d居宅介護要介護1_3 = (null == 居宅介護要介護1_3 || 居宅介護要介護1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護1_3.toString());
        Decimal d居宅介護要介護1_4 = (null == 居宅介護要介護1_4 || 居宅介護要介護1_4.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護1_4.toString());
        Decimal d居宅介護要介護1_5 = (null == 居宅介護要介護1_5 || 居宅介護要介護1_5.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護1_5.toString());
        Decimal d居宅介護要介護1_6 = (null == 居宅介護要介護1_6 || 居宅介護要介護1_6.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護1_6.toString());
        return d居宅介護要介護1_6.equals(d居宅介護要介護1_1.add(d居宅介護要介護1_2).add(d居宅介護要介護1_3).
                add(d居宅介護要介護1_4).add(d居宅介護要介護1_5));
    }

    private boolean is居宅介護2要介護整合性() {
        RString 居宅介護要介護2_1 = div.getPnl12().getTxt120406().getValue();
        RString 居宅介護要介護2_2 = div.getPnl12().getTxt120407().getValue();
        RString 居宅介護要介護2_3 = div.getPnl12().getTxt120408().getValue();
        RString 居宅介護要介護2_4 = div.getPnl12().getTxt120409().getValue();
        RString 居宅介護要介護2_5 = div.getPnl12().getTxt120410().getValue();
        RString 居宅介護要介護2_6 = div.getPnl12().getTxt120411().getValue();
        Decimal d居宅介護要介護2_1 = (null == 居宅介護要介護2_1 || 居宅介護要介護2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護2_1.toString());
        Decimal d居宅介護要介護2_2 = (null == 居宅介護要介護2_2 || 居宅介護要介護2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護2_2.toString());
        Decimal d居宅介護要介護2_3 = (null == 居宅介護要介護2_3 || 居宅介護要介護2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護2_3.toString());
        Decimal d居宅介護要介護2_4 = (null == 居宅介護要介護2_4 || 居宅介護要介護2_4.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護2_4.toString());
        Decimal d居宅介護要介護2_5 = (null == 居宅介護要介護2_5 || 居宅介護要介護2_5.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護2_5.toString());
        Decimal d居宅介護要介護2_6 = (null == 居宅介護要介護2_6 || 居宅介護要介護2_6.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護2_6.toString());
        return d居宅介護要介護2_6.equals(d居宅介護要介護2_1.add(d居宅介護要介護2_2).add(d居宅介護要介護2_3).
                add(d居宅介護要介護2_4).add(d居宅介護要介護2_5));
    }

    private boolean is居宅介護3要介護整合性() {
        RString 居宅介護要介護3_1 = div.getPnl12().getTxt120506().getValue();
        RString 居宅介護要介護3_2 = div.getPnl12().getTxt120507().getValue();
        RString 居宅介護要介護3_3 = div.getPnl12().getTxt120508().getValue();
        RString 居宅介護要介護3_4 = div.getPnl12().getTxt120509().getValue();
        RString 居宅介護要介護3_5 = div.getPnl12().getTxt120510().getValue();
        RString 居宅介護要介護3_6 = div.getPnl12().getTxt120511().getValue();
        Decimal d居宅介護要介護3_1 = (null == 居宅介護要介護3_1 || 居宅介護要介護3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護3_1.toString());
        Decimal d居宅介護要介護3_2 = (null == 居宅介護要介護3_2 || 居宅介護要介護3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護3_2.toString());
        Decimal d居宅介護要介護3_3 = (null == 居宅介護要介護3_3 || 居宅介護要介護3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護3_3.toString());
        Decimal d居宅介護要介護3_4 = (null == 居宅介護要介護3_4 || 居宅介護要介護3_4.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護3_4.toString());
        Decimal d居宅介護要介護3_5 = (null == 居宅介護要介護3_5 || 居宅介護要介護3_5.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護3_5.toString());
        Decimal d居宅介護要介護3_6 = (null == 居宅介護要介護3_6 || 居宅介護要介護3_6.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護要介護3_6.toString());
        return d居宅介護要介護3_6.equals(d居宅介護要介護3_1.add(d居宅介護要介護3_2).add(d居宅介護要介護3_3).
                add(d居宅介護要介護3_4).add(d居宅介護要介護3_5));
    }

    private boolean is地域密着型要介護整合性() {
        return (is地域密着型1要介護整合性()
                && is地域密着型2要介護整合性() && is地域密着型3要介護整合性());
    }

    private boolean is地域密着型1要介護整合性() {
        RString 地域密着型要介護1_1 = div.getPnl13().getTxt130306().getValue();
        RString 地域密着型要介護1_2 = div.getPnl13().getTxt130307().getValue();
        RString 地域密着型要介護1_3 = div.getPnl13().getTxt130308().getValue();
        RString 地域密着型要介護1_4 = div.getPnl13().getTxt130309().getValue();
        RString 地域密着型要介護1_5 = div.getPnl13().getTxt130310().getValue();
        RString 地域密着型要介護1_6 = div.getPnl13().getTxt130311().getValue();
        Decimal d地域密着型要介護1_1 = (null == 地域密着型要介護1_1 || 地域密着型要介護1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護1_1.toString());
        Decimal d地域密着型要介護1_2 = (null == 地域密着型要介護1_2 || 地域密着型要介護1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護1_2.toString());
        Decimal d地域密着型要介護1_3 = (null == 地域密着型要介護1_3 || 地域密着型要介護1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護1_3.toString());
        Decimal d地域密着型要介護1_4 = (null == 地域密着型要介護1_4 || 地域密着型要介護1_4.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護1_4.toString());
        Decimal d地域密着型要介護1_5 = (null == 地域密着型要介護1_5 || 地域密着型要介護1_5.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護1_5.toString());
        Decimal d地域密着型要介護1_6 = (null == 地域密着型要介護1_6 || 地域密着型要介護1_6.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護1_6.toString());
        return d地域密着型要介護1_6.equals(d地域密着型要介護1_1.add(d地域密着型要介護1_2).add(d地域密着型要介護1_3).
                add(d地域密着型要介護1_4).add(d地域密着型要介護1_5));
    }

    private boolean is地域密着型2要介護整合性() {
        RString 地域密着型要介護2_1 = div.getPnl13().getTxt130406().getValue();
        RString 地域密着型要介護2_2 = div.getPnl13().getTxt130407().getValue();
        RString 地域密着型要介護2_3 = div.getPnl13().getTxt130408().getValue();
        RString 地域密着型要介護2_4 = div.getPnl13().getTxt130409().getValue();
        RString 地域密着型要介護2_5 = div.getPnl13().getTxt130410().getValue();
        RString 地域密着型要介護2_6 = div.getPnl13().getTxt130411().getValue();
        Decimal d地域密着型要介護2_1 = (null == 地域密着型要介護2_1 || 地域密着型要介護2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護2_1.toString());
        Decimal d地域密着型要介護2_2 = (null == 地域密着型要介護2_2 || 地域密着型要介護2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護2_2.toString());
        Decimal d地域密着型要介護2_3 = (null == 地域密着型要介護2_3 || 地域密着型要介護2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護2_3.toString());
        Decimal d地域密着型要介護2_4 = (null == 地域密着型要介護2_4 || 地域密着型要介護2_4.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護2_4.toString());
        Decimal d地域密着型要介護2_5 = (null == 地域密着型要介護2_5 || 地域密着型要介護2_5.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護2_5.toString());
        Decimal d地域密着型要介護2_6 = (null == 地域密着型要介護2_6 || 地域密着型要介護2_6.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護2_6.toString());
        return d地域密着型要介護2_6.equals(d地域密着型要介護2_1.add(d地域密着型要介護2_2).add(d地域密着型要介護2_3).
                add(d地域密着型要介護2_4).add(d地域密着型要介護2_5));
    }

    private boolean is地域密着型3要介護整合性() {
        RString 地域密着型要介護3_1 = div.getPnl13().getTxt130506().getValue();
        RString 地域密着型要介護3_2 = div.getPnl13().getTxt130507().getValue();
        RString 地域密着型要介護3_3 = div.getPnl13().getTxt130508().getValue();
        RString 地域密着型要介護3_4 = div.getPnl13().getTxt130509().getValue();
        RString 地域密着型要介護3_5 = div.getPnl13().getTxt130510().getValue();
        RString 地域密着型要介護3_6 = div.getPnl13().getTxt1305011().getValue();
        Decimal d地域密着型要介護3_1 = (null == 地域密着型要介護3_1 || 地域密着型要介護3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護3_1.toString());
        Decimal d地域密着型要介護3_2 = (null == 地域密着型要介護3_2 || 地域密着型要介護3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護3_2.toString());
        Decimal d地域密着型要介護3_3 = (null == 地域密着型要介護3_3 || 地域密着型要介護3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護3_3.toString());
        Decimal d地域密着型要介護3_4 = (null == 地域密着型要介護3_4 || 地域密着型要介護3_4.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護3_4.toString());
        Decimal d地域密着型要介護3_5 = (null == 地域密着型要介護3_5 || 地域密着型要介護3_5.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護3_5.toString());
        Decimal d地域密着型要介護3_6 = (null == 地域密着型要介護3_6 || 地域密着型要介護3_6.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型要介護3_6.toString());
        return d地域密着型要介護3_6.equals(d地域密着型要介護3_1.add(d地域密着型要介護3_2).add(d地域密着型要介護3_3).
                add(d地域密着型要介護3_4).add(d地域密着型要介護3_5));
    }

    private boolean is施設介護要介護整合性() {
        return (is施設介護1要介護整合性() && is施設介護2要介護整合性() && is施設介護3要介護整合性()
                && is施設介護4要介護整合性() && is施設介護5要介護整合性() && is施設介護6要介護整合性()
                && is施設介護7要介護整合性() && is施設介護8要介護整合性() && is施設介護9要介護整合性()
                && is施設介護10要介護整合性());
    }

    private boolean is施設介護1要介護整合性() {
        RString 施設介護要介護1_1 = div.getPnl14().getTxt140306().getValue();
        RString 施設介護要介護1_2 = div.getPnl14().getTxt140307().getValue();
        RString 施設介護要介護1_3 = div.getPnl14().getTxt140308().getValue();
        RString 施設介護要介護1_4 = div.getPnl14().getTxt140309().getValue();
        RString 施設介護要介護1_5 = div.getPnl14().getTxt140310().getValue();
        RString 施設介護要介護1_6 = div.getPnl14().getTxt140311().getValue();
        Decimal d施設介護要介護1_1 = (null == 施設介護要介護1_1 || 施設介護要介護1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護1_1.toString());
        Decimal d施設介護要介護1_2 = (null == 施設介護要介護1_2 || 施設介護要介護1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護1_2.toString());
        Decimal d施設介護要介護1_3 = (null == 施設介護要介護1_3 || 施設介護要介護1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護1_3.toString());
        Decimal d施設介護要介護1_4 = (null == 施設介護要介護1_4 || 施設介護要介護1_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護1_4.toString());
        Decimal d施設介護要介護1_5 = (null == 施設介護要介護1_5 || 施設介護要介護1_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護1_5.toString());
        Decimal d施設介護要介護1_6 = (null == 施設介護要介護1_6 || 施設介護要介護1_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護1_6.toString());
        return d施設介護要介護1_6.equals(d施設介護要介護1_1.add(d施設介護要介護1_2).add(d施設介護要介護1_3).
                add(d施設介護要介護1_4).add(d施設介護要介護1_5));
    }

    private boolean is施設介護2要介護整合性() {
        RString 施設介護要介護2_1 = div.getPnl14().getTxt140406().getValue();
        RString 施設介護要介護2_2 = div.getPnl14().getTxt140407().getValue();
        RString 施設介護要介護2_3 = div.getPnl14().getTxt140408().getValue();
        RString 施設介護要介護2_4 = div.getPnl14().getTxt140409().getValue();
        RString 施設介護要介護2_5 = div.getPnl14().getTxt140410().getValue();
        RString 施設介護要介護2_6 = div.getPnl14().getTxt140411().getValue();
        Decimal d施設介護要介護2_1 = (null == 施設介護要介護2_1 || 施設介護要介護2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護2_1.toString());
        Decimal d施設介護要介護2_2 = (null == 施設介護要介護2_2 || 施設介護要介護2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護2_2.toString());
        Decimal d施設介護要介護2_3 = (null == 施設介護要介護2_3 || 施設介護要介護2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護2_3.toString());
        Decimal d施設介護要介護2_4 = (null == 施設介護要介護2_4 || 施設介護要介護2_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護2_4.toString());
        Decimal d施設介護要介護2_5 = (null == 施設介護要介護2_5 || 施設介護要介護2_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護2_5.toString());
        Decimal d施設介護要介護2_6 = (null == 施設介護要介護2_6 || 施設介護要介護2_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護2_6.toString());
        return d施設介護要介護2_6.equals(d施設介護要介護2_1.add(d施設介護要介護2_2).add(d施設介護要介護2_3).
                add(d施設介護要介護2_4).add(d施設介護要介護2_5));
    }

    private boolean is施設介護3要介護整合性() {
        RString 施設介護要介護3_1 = div.getPnl14().getTxt140506().getValue();
        RString 施設介護要介護3_2 = div.getPnl14().getTxt140507().getValue();
        RString 施設介護要介護3_3 = div.getPnl14().getTxt140508().getValue();
        RString 施設介護要介護3_4 = div.getPnl14().getTxt140509().getValue();
        RString 施設介護要介護3_5 = div.getPnl14().getTxt140510().getValue();
        RString 施設介護要介護3_6 = div.getPnl14().getTxt140511().getValue();
        Decimal d施設介護要介護3_1 = (null == 施設介護要介護3_1 || 施設介護要介護3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護3_1.toString());
        Decimal d施設介護要介護3_2 = (null == 施設介護要介護3_2 || 施設介護要介護3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護3_2.toString());
        Decimal d施設介護要介護3_3 = (null == 施設介護要介護3_3 || 施設介護要介護3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護3_3.toString());
        Decimal d施設介護要介護3_4 = (null == 施設介護要介護3_4 || 施設介護要介護3_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護3_4.toString());
        Decimal d施設介護要介護3_5 = (null == 施設介護要介護3_5 || 施設介護要介護3_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護3_5.toString());
        Decimal d施設介護要介護3_6 = (null == 施設介護要介護3_6 || 施設介護要介護3_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護3_6.toString());
        return d施設介護要介護3_6.equals(d施設介護要介護3_1.add(d施設介護要介護3_2).add(d施設介護要介護3_3).
                add(d施設介護要介護3_4).add(d施設介護要介護3_5));
    }

    private boolean is施設介護4要介護整合性() {
        RString 施設介護要介護4_1 = div.getPnl14().getTxt140606().getValue();
        RString 施設介護要介護4_2 = div.getPnl14().getTxt140607().getValue();
        RString 施設介護要介護4_3 = div.getPnl14().getTxt140608().getValue();
        RString 施設介護要介護4_4 = div.getPnl14().getTxt140609().getValue();
        RString 施設介護要介護4_5 = div.getPnl14().getTxt140610().getValue();
        RString 施設介護要介護4_6 = div.getPnl14().getTxt140611().getValue();
        Decimal d施設介護要介護4_1 = (null == 施設介護要介護4_1 || 施設介護要介護4_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護4_1.toString());
        Decimal d施設介護要介護4_2 = (null == 施設介護要介護4_2 || 施設介護要介護4_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護4_2.toString());
        Decimal d施設介護要介護4_3 = (null == 施設介護要介護4_3 || 施設介護要介護4_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護4_3.toString());
        Decimal d施設介護要介護4_4 = (null == 施設介護要介護4_4 || 施設介護要介護4_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護4_4.toString());
        Decimal d施設介護要介護4_5 = (null == 施設介護要介護4_5 || 施設介護要介護4_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護4_5.toString());
        Decimal d施設介護要介護4_6 = (null == 施設介護要介護4_6 || 施設介護要介護4_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護4_6.toString());
        return d施設介護要介護4_6.equals(d施設介護要介護4_1.add(d施設介護要介護4_2).add(d施設介護要介護4_3).
                add(d施設介護要介護4_4).add(d施設介護要介護4_5));
    }

    private boolean is施設介護5要介護整合性() {
        RString 施設介護要介護5_1 = div.getPnl14().getTxt140706().getValue();
        RString 施設介護要介護5_2 = div.getPnl14().getTxt140707().getValue();
        RString 施設介護要介護5_3 = div.getPnl14().getTxt140708().getValue();
        RString 施設介護要介護5_4 = div.getPnl14().getTxt140709().getValue();
        RString 施設介護要介護5_5 = div.getPnl14().getTxt140710().getValue();
        RString 施設介護要介護5_6 = div.getPnl14().getTxt140711().getValue();
        Decimal d施設介護要介護5_1 = (null == 施設介護要介護5_1 || 施設介護要介護5_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護5_1.toString());
        Decimal d施設介護要介護5_2 = (null == 施設介護要介護5_2 || 施設介護要介護5_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護5_2.toString());
        Decimal d施設介護要介護5_3 = (null == 施設介護要介護5_3 || 施設介護要介護5_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護5_3.toString());
        Decimal d施設介護要介護5_4 = (null == 施設介護要介護5_4 || 施設介護要介護5_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護5_4.toString());
        Decimal d施設介護要介護5_5 = (null == 施設介護要介護5_5 || 施設介護要介護5_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護5_5.toString());
        Decimal d施設介護要介護5_6 = (null == 施設介護要介護5_6 || 施設介護要介護5_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護5_6.toString());
        return d施設介護要介護5_6.equals(d施設介護要介護5_1.add(d施設介護要介護5_2).add(d施設介護要介護5_3).
                add(d施設介護要介護5_4).add(d施設介護要介護5_5));
    }

    private boolean is施設介護6要介護整合性() {
        RString 施設介護要介護6_1 = div.getPnl14().getTxt140806().getValue();
        RString 施設介護要介護6_2 = div.getPnl14().getTxt140807().getValue();
        RString 施設介護要介護6_3 = div.getPnl14().getTxt140808().getValue();
        RString 施設介護要介護6_4 = div.getPnl14().getTxt140809().getValue();
        RString 施設介護要介護6_5 = div.getPnl14().getTxt140810().getValue();
        RString 施設介護要介護6_6 = div.getPnl14().getTxt140811().getValue();
        Decimal d施設介護要介護6_1 = (null == 施設介護要介護6_1 || 施設介護要介護6_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護6_1.toString());
        Decimal d施設介護要介護6_2 = (null == 施設介護要介護6_2 || 施設介護要介護6_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護6_2.toString());
        Decimal d施設介護要介護6_3 = (null == 施設介護要介護6_3 || 施設介護要介護6_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護6_3.toString());
        Decimal d施設介護要介護6_4 = (null == 施設介護要介護6_4 || 施設介護要介護6_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護6_4.toString());
        Decimal d施設介護要介護6_5 = (null == 施設介護要介護6_5 || 施設介護要介護6_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護6_5.toString());
        Decimal d施設介護要介護6_6 = (null == 施設介護要介護6_6 || 施設介護要介護6_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護6_6.toString());
        return d施設介護要介護6_6.equals(d施設介護要介護6_1.add(d施設介護要介護6_2).add(d施設介護要介護6_3).
                add(d施設介護要介護6_4).add(d施設介護要介護6_5));
    }

    private boolean is施設介護7要介護整合性() {
        RString 施設介護要介護7_1 = div.getPnl14().getTxt140906().getValue();
        RString 施設介護要介護7_2 = div.getPnl14().getTxt140907().getValue();
        RString 施設介護要介護7_3 = div.getPnl14().getTxt140908().getValue();
        RString 施設介護要介護7_4 = div.getPnl14().getTxt140909().getValue();
        RString 施設介護要介護7_5 = div.getPnl14().getTxt140910().getValue();
        RString 施設介護要介護7_6 = div.getPnl14().getTxt140911().getValue();
        Decimal d施設介護要介護7_1 = (null == 施設介護要介護7_1 || 施設介護要介護7_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護7_1.toString());
        Decimal d施設介護要介護7_2 = (null == 施設介護要介護7_2 || 施設介護要介護7_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護7_2.toString());
        Decimal d施設介護要介護7_3 = (null == 施設介護要介護7_3 || 施設介護要介護7_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護7_3.toString());
        Decimal d施設介護要介護7_4 = (null == 施設介護要介護7_4 || 施設介護要介護7_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護7_4.toString());
        Decimal d施設介護要介護7_5 = (null == 施設介護要介護7_5 || 施設介護要介護7_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護7_5.toString());
        Decimal d施設介護要介護7_6 = (null == 施設介護要介護7_6 || 施設介護要介護7_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護7_6.toString());
        return d施設介護要介護7_6.equals(d施設介護要介護7_1.add(d施設介護要介護7_2).add(d施設介護要介護7_3).
                add(d施設介護要介護7_4).add(d施設介護要介護7_5));
    }

    private boolean is施設介護8要介護整合性() {
        RString 施設介護要介護8_1 = div.getPnl14().getTxt141006().getValue();
        RString 施設介護要介護8_2 = div.getPnl14().getTxt141007().getValue();
        RString 施設介護要介護8_3 = div.getPnl14().getTxt141008().getValue();
        RString 施設介護要介護8_4 = div.getPnl14().getTxt141009().getValue();
        RString 施設介護要介護8_5 = div.getPnl14().getTxt141010().getValue();
        RString 施設介護要介護8_6 = div.getPnl14().getTxt141011().getValue();
        Decimal d施設介護要介護8_1 = (null == 施設介護要介護8_1 || 施設介護要介護8_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護8_1.toString());
        Decimal d施設介護要介護8_2 = (null == 施設介護要介護8_2 || 施設介護要介護8_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護8_2.toString());
        Decimal d施設介護要介護8_3 = (null == 施設介護要介護8_3 || 施設介護要介護8_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護8_3.toString());
        Decimal d施設介護要介護8_4 = (null == 施設介護要介護8_4 || 施設介護要介護8_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護8_4.toString());
        Decimal d施設介護要介護8_5 = (null == 施設介護要介護8_5 || 施設介護要介護8_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護8_5.toString());
        Decimal d施設介護要介護8_6 = (null == 施設介護要介護8_6 || 施設介護要介護8_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護8_6.toString());
        return d施設介護要介護8_6.equals(d施設介護要介護8_1.add(d施設介護要介護8_2).add(d施設介護要介護8_3).
                add(d施設介護要介護8_4).add(d施設介護要介護8_5));
    }

    private boolean is施設介護9要介護整合性() {
        RString 施設介護要介護9_1 = div.getPnl14().getTxt141106().getValue();
        RString 施設介護要介護9_2 = div.getPnl14().getTxt141107().getValue();
        RString 施設介護要介護9_3 = div.getPnl14().getTxt141108().getValue();
        RString 施設介護要介護9_4 = div.getPnl14().getTxt141109().getValue();
        RString 施設介護要介護9_5 = div.getPnl14().getTxt141110().getValue();
        RString 施設介護要介護9_6 = div.getPnl14().getTxt141111().getValue();
        Decimal d施設介護要介護9_1 = (null == 施設介護要介護9_1 || 施設介護要介護9_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護9_1.toString());
        Decimal d施設介護要介護9_2 = (null == 施設介護要介護9_2 || 施設介護要介護9_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護9_2.toString());
        Decimal d施設介護要介護9_3 = (null == 施設介護要介護9_3 || 施設介護要介護9_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護9_3.toString());
        Decimal d施設介護要介護9_4 = (null == 施設介護要介護9_4 || 施設介護要介護9_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護9_4.toString());
        Decimal d施設介護要介護9_5 = (null == 施設介護要介護9_5 || 施設介護要介護9_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護9_5.toString());
        Decimal d施設介護要介護9_6 = (null == 施設介護要介護9_6 || 施設介護要介護9_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護9_6.toString());
        return d施設介護要介護9_6.equals(d施設介護要介護9_1.add(d施設介護要介護9_2).add(d施設介護要介護9_3).
                add(d施設介護要介護9_4).add(d施設介護要介護9_5));
    }

    private boolean is施設介護10要介護整合性() {
        RString 施設介護要介護10_1 = div.getPnl14().getTxt141206().getValue();
        RString 施設介護要介護10_2 = div.getPnl14().getTxt141207().getValue();
        RString 施設介護要介護10_3 = div.getPnl14().getTxt141208().getValue();
        RString 施設介護要介護10_4 = div.getPnl14().getTxt141209().getValue();
        RString 施設介護要介護10_5 = div.getPnl14().getTxt141210().getValue();
        RString 施設介護要介護10_6 = div.getPnl14().getTxt141211().getValue();
        Decimal d施設介護要介護10_1 = (null == 施設介護要介護10_1 || 施設介護要介護10_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護10_1.toString());
        Decimal d施設介護要介護10_2 = (null == 施設介護要介護10_2 || 施設介護要介護10_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護10_2.toString());
        Decimal d施設介護要介護10_3 = (null == 施設介護要介護10_3 || 施設介護要介護10_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護10_3.toString());
        Decimal d施設介護要介護10_4 = (null == 施設介護要介護10_4 || 施設介護要介護10_4.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護10_4.toString());
        Decimal d施設介護要介護10_5 = (null == 施設介護要介護10_5 || 施設介護要介護10_5.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護10_5.toString());
        Decimal d施設介護要介護10_6 = (null == 施設介護要介護10_6 || 施設介護要介護10_6.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護要介護10_6.toString());
        return d施設介護要介護10_6.equals(d施設介護要介護10_1.add(d施設介護要介護10_2).add(d施設介護要介護10_3).
                add(d施設介護要介護10_4).add(d施設介護要介護10_5));
    }

    /**
     * 画面項目「計」で入力された値の整合性3をチェックします。
     *
     * @return boolean チェック結果
     */
    public boolean is整合性チェック3() {
        return (is要介護合計整合性() && is居宅介護合計整合性() && is地域密着型合計整合性() && is施設介護合計整合性());
    }

    private boolean is要介護合計整合性() {
        return (is要介護1合計整合性()
                && is要介護2合計整合性() && is要介護3合計整合性() && is要介護4合計整合性() && is要介護5合計整合性());
    }

    private boolean is要介護1合計整合性() {
        RString 要介護合計1_1 = div.getPnl11().getTxt110204().getValue();
        RString 要介護合計1_2 = div.getPnl11().getTxt110211().getValue();
        RString 要介護合計1_3 = div.getPnl11().getTxt110212().getValue();
        Decimal d要介護合計1_1 = (null == 要介護合計1_1 || 要介護合計1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計1_1.toString());
        Decimal d要介護合計1_2 = (null == 要介護合計1_2 || 要介護合計1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計1_2.toString());
        Decimal d要介護合計1_3 = (null == 要介護合計1_3 || 要介護合計1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計1_3.toString());
        return d要介護合計1_3.equals(d要介護合計1_1.add(d要介護合計1_2));
    }

    private boolean is要介護2合計整合性() {
        RString 要介護合計2_1 = div.getPnl11().getTxt110304().getValue();
        RString 要介護合計2_2 = div.getPnl11().getTxt110311().getValue();
        RString 要介護合計2_3 = div.getPnl11().getTxt110312().getValue();
        Decimal d要介護合計2_1 = (null == 要介護合計2_1 || 要介護合計2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計2_1.toString());
        Decimal d要介護合計2_2 = (null == 要介護合計2_2 || 要介護合計2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計2_2.toString());
        Decimal d要介護合計2_3 = (null == 要介護合計2_3 || 要介護合計2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計2_3.toString());
        return d要介護合計2_3.equals(d要介護合計2_1.add(d要介護合計2_2));
    }

    private boolean is要介護3合計整合性() {
        RString 要介護合計3_1 = div.getPnl11().getTxt110404().getValue();
        RString 要介護合計3_2 = div.getPnl11().getTxt110411().getValue();
        RString 要介護合計3_3 = div.getPnl11().getTxt110412().getValue();
        Decimal d要介護合計3_1 = (null == 要介護合計3_1 || 要介護合計3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計3_1.toString());
        Decimal d要介護合計3_2 = (null == 要介護合計3_2 || 要介護合計3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計3_2.toString());
        Decimal d要介護合計3_3 = (null == 要介護合計3_3 || 要介護合計3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計3_3.toString());
        return d要介護合計3_3.equals(d要介護合計3_1.add(d要介護合計3_2));
    }

    private boolean is要介護4合計整合性() {
        RString 要介護合計4_1 = div.getPnl11().getTxt110504().getValue();
        RString 要介護合計4_2 = div.getPnl11().getTxt110511().getValue();
        RString 要介護合計4_3 = div.getPnl11().getTxt110512().getValue();
        Decimal d要介護合計4_1 = (null == 要介護合計4_1 || 要介護合計4_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計4_1.toString());
        Decimal d要介護合計4_2 = (null == 要介護合計4_2 || 要介護合計4_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計4_2.toString());
        Decimal d要介護合計4_3 = (null == 要介護合計4_3 || 要介護合計4_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計4_3.toString());
        return d要介護合計4_3.equals(d要介護合計4_1.add(d要介護合計4_2));
    }

    private boolean is要介護5合計整合性() {
        RString 要介護合計5_1 = div.getPnl11().getTxt110604().getValue();
        RString 要介護合計5_2 = div.getPnl11().getTxt110611().getValue();
        RString 要介護合計5_3 = div.getPnl11().getTxt110612().getValue();
        Decimal d要介護合計5_1 = (null == 要介護合計5_1 || 要介護合計5_1.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計5_1.toString());
        Decimal d要介護合計5_2 = (null == 要介護合計5_2 || 要介護合計5_2.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計5_2.toString());
        Decimal d要介護合計5_3 = (null == 要介護合計5_3 || 要介護合計5_3.isEmpty())
                ? Decimal.ZERO : new Decimal(要介護合計5_3.toString());
        return d要介護合計5_3.equals(d要介護合計5_1.add(d要介護合計5_2));
    }

    private boolean is居宅介護合計整合性() {
        return (is居宅介護1合計整合性()
                && is居宅介護2合計整合性() && is居宅介護3合計整合性());
    }

    private boolean is居宅介護1合計整合性() {
        RString 居宅介護合計1_1 = div.getPnl12().getTxt120304().getValue();
        RString 居宅介護合計1_2 = div.getPnl12().getTxt120311().getValue();
        RString 居宅介護合計1_3 = div.getPnl12().getTxt120312().getValue();
        Decimal d居宅介護合計1_1 = (null == 居宅介護合計1_1 || 居宅介護合計1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計1_1.toString());
        Decimal d居宅介護合計1_2 = (null == 居宅介護合計1_2 || 居宅介護合計1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計1_2.toString());
        Decimal d居宅介護合計1_3 = (null == 居宅介護合計1_3 || 居宅介護合計1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計1_3.toString());
        return d居宅介護合計1_3.equals(d居宅介護合計1_1.add(d居宅介護合計1_2));
    }

    private boolean is居宅介護2合計整合性() {
        RString 居宅介護合計2_1 = div.getPnl12().getTxt120404().getValue();
        RString 居宅介護合計2_2 = div.getPnl12().getTxt120411().getValue();
        RString 居宅介護合計2_3 = div.getPnl12().getTxt120412().getValue();
        Decimal d居宅介護合計2_1 = (null == 居宅介護合計2_1 || 居宅介護合計2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計2_1.toString());
        Decimal d居宅介護合計2_2 = (null == 居宅介護合計2_2 || 居宅介護合計2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計2_2.toString());
        Decimal d居宅介護合計2_3 = (null == 居宅介護合計2_3 || 居宅介護合計2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計2_3.toString());
        return d居宅介護合計2_3.equals(d居宅介護合計2_1.add(d居宅介護合計2_2));
    }

    private boolean is居宅介護3合計整合性() {
        RString 居宅介護合計3_1 = div.getPnl12().getTxt120504().getValue();
        RString 居宅介護合計3_2 = div.getPnl12().getTxt120511().getValue();
        RString 居宅介護合計3_3 = div.getPnl12().getTxt120512().getValue();
        Decimal d居宅介護合計3_1 = (null == 居宅介護合計3_1 || 居宅介護合計3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計3_1.toString());
        Decimal d居宅介護合計3_2 = (null == 居宅介護合計3_2 || 居宅介護合計3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計3_2.toString());
        Decimal d居宅介護合計3_3 = (null == 居宅介護合計3_3 || 居宅介護合計3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(居宅介護合計3_3.toString());
        return d居宅介護合計3_3.equals(d居宅介護合計3_1.add(d居宅介護合計3_2));
    }

    private boolean is地域密着型合計整合性() {
        return (is地域密着型1合計整合性()
                && is地域密着型2合計整合性() && is地域密着型3合計整合性());
    }

    private boolean is地域密着型1合計整合性() {
        RString 地域密着型合計1_1 = div.getPnl13().getTxt130304().getValue();
        RString 地域密着型合計1_2 = div.getPnl13().getTxt130311().getValue();
        RString 地域密着型合計1_3 = div.getPnl13().getTxt130312().getValue();
        Decimal d地域密着型合計1_1 = (null == 地域密着型合計1_1 || 地域密着型合計1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計1_1.toString());
        Decimal d地域密着型合計1_2 = (null == 地域密着型合計1_2 || 地域密着型合計1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計1_2.toString());
        Decimal d地域密着型合計1_3 = (null == 地域密着型合計1_3 || 地域密着型合計1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計1_3.toString());
        return d地域密着型合計1_3.equals(d地域密着型合計1_1.add(d地域密着型合計1_2));
    }

    private boolean is地域密着型2合計整合性() {
        RString 地域密着型合計2_1 = div.getPnl13().getTxt130404().getValue();
        RString 地域密着型合計2_2 = div.getPnl13().getTxt130411().getValue();
        RString 地域密着型合計2_3 = div.getPnl13().getTxt130412().getValue();
        Decimal d地域密着型合計2_1 = (null == 地域密着型合計2_1 || 地域密着型合計2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計2_1.toString());
        Decimal d地域密着型合計2_2 = (null == 地域密着型合計2_2 || 地域密着型合計2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計2_2.toString());
        Decimal d地域密着型合計2_3 = (null == 地域密着型合計2_3 || 地域密着型合計2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計2_3.toString());
        return d地域密着型合計2_3.equals(d地域密着型合計2_1.add(d地域密着型合計2_2));
    }

    private boolean is地域密着型3合計整合性() {
        RString 地域密着型合計3_1 = div.getPnl13().getTxt130504().getValue();
        RString 地域密着型合計3_2 = div.getPnl13().getTxt1305011().getValue();
        RString 地域密着型合計3_3 = div.getPnl13().getTxt130512().getValue();
        Decimal d地域密着型合計3_1 = (null == 地域密着型合計3_1 || 地域密着型合計3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計3_1.toString());
        Decimal d地域密着型合計3_2 = (null == 地域密着型合計3_2 || 地域密着型合計3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計3_2.toString());
        Decimal d地域密着型合計3_3 = (null == 地域密着型合計3_3 || 地域密着型合計3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型合計3_3.toString());
        return d地域密着型合計3_3.equals(d地域密着型合計3_1.add(d地域密着型合計3_2));
    }

    private boolean is施設介護合計整合性() {
        return (is施設介護1合計整合性() && is施設介護2合計整合性() && is施設介護3合計整合性()
                && is施設介護4合計整合性() && is施設介護5合計整合性() && is施設介護6合計整合性()
                && is施設介護7合計整合性() && is施設介護8合計整合性() && is施設介護9合計整合性()
                && is施設介護10合計整合性());
    }

    private boolean is施設介護1合計整合性() {
        RString 施設介護合計1_1 = div.getPnl14().getTxt140304().getValue();
        RString 施設介護合計1_2 = div.getPnl14().getTxt140311().getValue();
        RString 施設介護合計1_3 = div.getPnl14().getTxt140312().getValue();
        Decimal d施設介護合計1_1 = (null == 施設介護合計1_1 || 施設介護合計1_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計1_1.toString());
        Decimal d施設介護合計1_2 = (null == 施設介護合計1_2 || 施設介護合計1_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計1_2.toString());
        Decimal d施設介護合計1_3 = (null == 施設介護合計1_3 || 施設介護合計1_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計1_3.toString());
        return d施設介護合計1_3.equals(d施設介護合計1_1.add(d施設介護合計1_2));
    }

    private boolean is施設介護2合計整合性() {

        RString 施設介護合計2_1 = div.getPnl14().getTxt140404().getValue();
        RString 施設介護合計2_2 = div.getPnl14().getTxt140411().getValue();
        RString 施設介護合計2_3 = div.getPnl14().getTxt140412().getValue();
        Decimal d施設介護合計2_1 = (null == 施設介護合計2_1 || 施設介護合計2_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計2_1.toString());
        Decimal d施設介護合計2_2 = (null == 施設介護合計2_2 || 施設介護合計2_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計2_2.toString());
        Decimal d施設介護合計2_3 = (null == 施設介護合計2_3 || 施設介護合計2_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計2_3.toString());
        return d施設介護合計2_3.equals(d施設介護合計2_1.add(d施設介護合計2_2));
    }

    private boolean is施設介護3合計整合性() {
        RString 施設介護合計3_1 = div.getPnl14().getTxt140504().getValue();
        RString 施設介護合計3_2 = div.getPnl14().getTxt140511().getValue();
        RString 施設介護合計3_3 = div.getPnl14().getTxt140512().getValue();
        Decimal d施設介護合計3_1 = (null == 施設介護合計3_1 || 施設介護合計3_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計3_1.toString());
        Decimal d施設介護合計3_2 = (null == 施設介護合計3_2 || 施設介護合計3_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計3_2.toString());
        Decimal d施設介護合計3_3 = (null == 施設介護合計3_3 || 施設介護合計3_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計3_3.toString());
        return d施設介護合計3_3.equals(d施設介護合計3_1.add(d施設介護合計3_2));
    }

    private boolean is施設介護4合計整合性() {
        RString 施設介護合計4_1 = div.getPnl14().getTxt140604().getValue();
        RString 施設介護合計4_2 = div.getPnl14().getTxt140611().getValue();
        RString 施設介護合計4_3 = div.getPnl14().getTxt140612().getValue();
        Decimal d施設介護合計4_1 = (null == 施設介護合計4_1 || 施設介護合計4_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計4_1.toString());
        Decimal d施設介護合計4_2 = (null == 施設介護合計4_2 || 施設介護合計4_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計4_2.toString());
        Decimal d施設介護合計4_3 = (null == 施設介護合計4_3 || 施設介護合計4_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計4_3.toString());
        return d施設介護合計4_3.equals(d施設介護合計4_1.add(d施設介護合計4_2));
    }

    private boolean is施設介護5合計整合性() {
        RString 施設介護合計5_1 = div.getPnl14().getTxt140704().getValue();
        RString 施設介護合計5_2 = div.getPnl14().getTxt140711().getValue();
        RString 施設介護合計5_3 = div.getPnl14().getTxt140712().getValue();
        Decimal d施設介護合計5_1 = (null == 施設介護合計5_1 || 施設介護合計5_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計5_1.toString());
        Decimal d施設介護合計5_2 = (null == 施設介護合計5_2 || 施設介護合計5_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計5_2.toString());
        Decimal d施設介護合計5_3 = (null == 施設介護合計5_3 || 施設介護合計5_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計5_3.toString());
        return d施設介護合計5_3.equals(d施設介護合計5_1.add(d施設介護合計5_2));
    }

    private boolean is施設介護6合計整合性() {
        RString 施設介護合計6_1 = div.getPnl14().getTxt140804().getValue();
        RString 施設介護合計6_2 = div.getPnl14().getTxt140811().getValue();
        RString 施設介護合計6_3 = div.getPnl14().getTxt140812().getValue();
        Decimal d施設介護合計6_1 = (null == 施設介護合計6_1 || 施設介護合計6_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計6_1.toString());
        Decimal d施設介護合計6_2 = (null == 施設介護合計6_2 || 施設介護合計6_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計6_2.toString());
        Decimal d施設介護合計6_3 = (null == 施設介護合計6_3 || 施設介護合計6_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計6_3.toString());
        return d施設介護合計6_3.equals(d施設介護合計6_1.add(d施設介護合計6_2));
    }

    private boolean is施設介護7合計整合性() {
        RString 施設介護合計7_1 = div.getPnl14().getTxt140904().getValue();
        RString 施設介護合計7_2 = div.getPnl14().getTxt140911().getValue();
        RString 施設介護合計7_3 = div.getPnl14().getTxt140912().getValue();
        Decimal d施設介護合計7_1 = (null == 施設介護合計7_1 || 施設介護合計7_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計7_1.toString());
        Decimal d施設介護合計7_2 = (null == 施設介護合計7_2 || 施設介護合計7_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計7_2.toString());
        Decimal d施設介護合計7_3 = (null == 施設介護合計7_3 || 施設介護合計7_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計7_3.toString());
        return d施設介護合計7_3.equals(d施設介護合計7_1.add(d施設介護合計7_2));
    }

    private boolean is施設介護8合計整合性() {
        RString 施設介護合計8_1 = div.getPnl14().getTxt141004().getValue();
        RString 施設介護合計8_2 = div.getPnl14().getTxt141011().getValue();
        RString 施設介護合計8_3 = div.getPnl14().getTxt141012().getValue();
        Decimal d施設介護合計8_1 = (null == 施設介護合計8_1 || 施設介護合計8_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計8_1.toString());
        Decimal d施設介護合計8_2 = (null == 施設介護合計8_2 || 施設介護合計8_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計8_2.toString());
        Decimal d施設介護合計8_3 = (null == 施設介護合計8_3 || 施設介護合計8_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計8_3.toString());
        return d施設介護合計8_3.equals(d施設介護合計8_1.add(d施設介護合計8_2));
    }

    private boolean is施設介護9合計整合性() {
        RString 施設介護合計9_1 = div.getPnl14().getTxt141104().getValue();
        RString 施設介護合計9_2 = div.getPnl14().getTxt141111().getValue();
        RString 施設介護合計9_3 = div.getPnl14().getTxt141112().getValue();
        Decimal d施設介護合計9_1 = (null == 施設介護合計9_1 || 施設介護合計9_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計9_1.toString());
        Decimal d施設介護合計9_2 = (null == 施設介護合計9_2 || 施設介護合計9_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計9_2.toString());
        Decimal d施設介護合計9_3 = (null == 施設介護合計9_3 || 施設介護合計9_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計9_3.toString());
        return d施設介護合計9_3.equals(d施設介護合計9_1.add(d施設介護合計9_2));
    }

    private boolean is施設介護10合計整合性() {
        RString 施設介護合計10_1 = div.getPnl14().getTxt141204().getValue();
        RString 施設介護合計10_2 = div.getPnl14().getTxt141211().getValue();
        RString 施設介護合計10_3 = div.getPnl14().getTxt141212().getValue();
        Decimal d施設介護合計10_1 = (null == 施設介護合計10_1 || 施設介護合計10_1.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計10_1.toString());
        Decimal d施設介護合計10_2 = (null == 施設介護合計10_2 || 施設介護合計10_2.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計10_2.toString());
        Decimal d施設介護合計10_3 = (null == 施設介護合計10_3 || 施設介護合計10_3.isEmpty())
                ? Decimal.ZERO : new Decimal(施設介護合計10_3.toString());
        return d施設介護合計10_3.equals(d施設介護合計10_1.add(d施設介護合計10_2));
    }

}

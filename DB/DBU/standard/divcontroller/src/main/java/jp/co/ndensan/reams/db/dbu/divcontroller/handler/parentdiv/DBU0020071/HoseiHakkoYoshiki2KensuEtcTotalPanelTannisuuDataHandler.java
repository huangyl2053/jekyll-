/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuDataHandler {

    private static final Decimal 横番号_1 = new Decimal("1");
    private static final Decimal 横番号_2 = new Decimal("2");
    private static final Decimal 横番号_3 = new Decimal("3");
    private static final Decimal 横番号_4 = new Decimal("4");
    private static final Decimal 横番号_5 = new Decimal("5");
    private static final Decimal 横番号_6 = new Decimal("6");
    private static final Decimal 横番号_7 = new Decimal("7");
    private static final Decimal 横番号_8 = new Decimal("8");
    private static final Decimal 横番号_9 = new Decimal("9");
    private static final Decimal 横番号_10 = new Decimal("10");
    private static final Decimal 横番号_11 = new Decimal("11");
    private static final Decimal 横番号_12 = new Decimal("12");
    private static final Decimal 縦番号_1 = new Decimal("1");
    private static final Decimal 縦番号_2 = new Decimal("2");
    private static final Decimal 縦番号_3 = new Decimal("3");
    private static final Decimal 縦番号_6 = new Decimal("6");
    private static final Decimal 縦番号_7 = new Decimal("7");
    private static final Decimal 縦番号_8 = new Decimal("8");
    private static final Decimal 縦番号_9 = new Decimal("9");
    private static final Decimal 縦番号_10 = new Decimal("10");
    private static final Decimal 縦番号_11 = new Decimal("11");
    private static final Decimal 縦番号_12 = new Decimal("12");
    private static final Decimal 縦番号_13 = new Decimal("13");
    private static final Decimal 縦番号_14 = new Decimal("14");
    private static final Decimal 縦番号_15 = new Decimal("15");
    private static final Decimal 縦番号_16 = new Decimal("16");
    private static final Decimal 縦番号_17 = new Decimal("17");
    private static final Decimal 縦番号_18 = new Decimal("18");
    private static final Decimal 縦番号_19 = new Decimal("19");
    private static final Decimal 縦番号_20 = new Decimal("20");
    private static final Decimal 縦番号_21 = new Decimal("21");
    private static final Decimal 縦番号_22 = new Decimal("22");
    private static final Decimal 縦番号_23 = new Decimal("23");
    private static final Decimal 縦番号_24 = new Decimal("24");
    private static final Decimal 縦番号_25 = new Decimal("25");
    private static final Decimal 縦番号_26 = new Decimal("26");
    private static final Decimal 縦番号_27 = new Decimal("27");
    private static final Decimal 縦番号_28 = new Decimal("28");
    private static final Decimal 縦番号_29 = new Decimal("29");
    private static final Decimal 縦番号_30 = new Decimal("30");
    private static final Decimal 縦番号_31 = new Decimal("31");
    private static final Decimal 縦番号_32 = new Decimal("32");
    private static final Decimal 縦番号_33 = new Decimal("33");
    private static final Decimal 縦番号_34 = new Decimal("34");
    private static final Decimal 縦番号_35 = new Decimal("35");
    private static final Decimal 縦番号_36 = new Decimal("36");
    private static final Decimal 縦番号_37 = new Decimal("37");
    private static final Decimal 縦番号_38 = new Decimal("38");
    private static final RString 単位数総数 = new RString("01");
    private static final RString 単位数第２号被保険者分再掲 = new RString("02");
    private static final RString 単位数総数特例分 = new RString("03");
    private static final RString 単位数第２号被保険者分再掲特例分 = new RString("04");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuDataHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面から修正データリストをDBに更新のメソッドます。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     */
    public void update(List<JigyoHokokuTokeiData> 修正データリスト) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.updateJigyoHokokuGeppoEntity(修正データリスト);
    }

    /**
     * is整合性チェック_NG_件数のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_件数_NG3() {

        return is整合性チェック_NG_件数_整合3_1() || is整合性チェック_NG_件数_整合3_2()
                || is整合性チェック_NG_件数_整合3_3();
    }

    private boolean is整合性チェック_NG_件数_整合3_1() {
        return is整合性チェック_NG_件数_3_1() || is整合性チェック_NG_件数_3_2()
                || is整合性チェック_NG_件数_3_3() || is整合性チェック_NG_件数_3_4()
                || is整合性チェック_NG_件数_3_5() || is整合性チェック_NG_件数_3_6()
                || is整合性チェック_NG_件数_3_7() || is整合性チェック_NG_件数_3_8()
                || is整合性チェック_NG_件数_3_9() || is整合性チェック_NG_件数_3_10()
                || is整合性チェック_NG_件数_3_11() || is整合性チェック_NG_件数_3_12()
                || is整合性チェック_NG_件数_3_13();
    }

    private boolean is整合性チェック_NG_件数_整合3_2() {
        return is整合性チェック_NG_件数_3_14() || is整合性チェック_NG_件数_3_15()
                || is整合性チェック_NG_件数_3_16() || is整合性チェック_NG_件数_3_17()
                || is整合性チェック_NG_件数_3_18() || is整合性チェック_NG_件数_3_19()
                || is整合性チェック_NG_件数_3_20() || is整合性チェック_NG_件数_3_21()
                || is整合性チェック_NG_件数_3_22() || is整合性チェック_NG_件数_3_23()
                || is整合性チェック_NG_件数_3_24() || is整合性チェック_NG_件数_3_25()
                || is整合性チェック_NG_件数_3_26();
    }

    private boolean is整合性チェック_NG_件数_整合3_3() {
        return is整合性チェック_NG_件数_3_27() || is整合性チェック_NG_件数_3_28()
                || is整合性チェック_NG_件数_3_29() || is整合性チェック_NG_件数_3_30()
                || is整合性チェック_NG_件数_3_31() || is整合性チェック_NG_件数_3_32()
                || is整合性チェック_NG_件数_3_33() || is整合性チェック_NG_件数_3_34()
                || is整合性チェック_NG_件数_3_35() || is整合性チェック_NG_件数_3_36()
                || is整合性チェック_NG_件数_3_37() || is整合性チェック_NG_件数_3_38();
    }

    private boolean is整合性チェック_NG_件数_3_1() {

        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl1().getTextBox3().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl1().getTextBox10().getValue();
        Decimal 居宅介護予防サービス合計 = div.getPnlMain().getTbl1().getTextBox11().getValue();

        return 入力チェック3(居宅介護予防サービス要支援計, 居宅介護予防サービス要介護計, 居宅介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_2() {

        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl1().getTextBox14().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl1().getTextBox21().getValue();
        Decimal 訪問サービス合計 = div.getPnlMain().getTbl1().getTextBox22().getValue();

        return 入力チェック3(訪問サービス要支援計, 訪問サービス要介護計, 訪問サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_3() {

        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl1().getTextBox25().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl1().getTextBox32().getValue();
        Decimal 訪問介護合計 = div.getPnlMain().getTbl1().getTextBox33().getValue();

        return 入力チェック3(訪問介護要支援計, 訪問介護要介護計, 訪問介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_4() {

        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl1().getTextBox37().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl1().getTextBox44().getValue();
        Decimal 訪問入浴介護合計 = div.getPnlMain().getTbl1().getTextBox45().getValue();

        return 入力チェック3(訪問入浴介護要支援計, 訪問入浴介護要介護計, 訪問入浴介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_5() {

        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl1().getTextBox47().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl1().getTextBox54().getValue();
        Decimal 訪問看護要合計 = div.getPnlMain().getTbl1().getTextBox55().getValue();

        return 入力チェック3(訪問看護要支援計, 訪問看護要介護計, 訪問看護要合計);
    }

    private boolean is整合性チェック_NG_件数_3_6() {

        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl1().getTextBox58().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl1().getTextBox65().getValue();
        Decimal 訪問リハビリテーション合計 = div.getPnlMain().getTbl1().getTextBox66().getValue();

        return 入力チェック3(訪問リハビリテーション要支援計, 訪問リハビリテーション要介護計, 訪問リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_件数_3_7() {

        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl1().getTextBox69().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl1().getTextBox76().getValue();
        Decimal 居宅療養管理指導合計 = div.getPnlMain().getTbl1().getTextBox77().getValue();

        return 入力チェック3(居宅療養管理指導要支援計, 居宅療養管理指導要介護計, 居宅療養管理指導合計);
    }

    private boolean is整合性チェック_NG_件数_3_8() {

        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl1().getTextBox80().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl1().getTextBox87().getValue();
        Decimal 通所サービス要合計 = div.getPnlMain().getTbl1().getTextBox88().getValue();

        return 入力チェック3(通所サービス要支援計, 通所サービス要介護計, 通所サービス要合計);
    }

    private boolean is整合性チェック_NG_件数_3_9() {

        Decimal 通所介護要支援計 = div.getPnlMain().getTbl1().getTextBox91().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl1().getTextBox98().getValue();
        Decimal 通所介護合計 = div.getPnlMain().getTbl1().getTextBox99().getValue();

        return 入力チェック3(通所介護要支援計, 通所介護要介護計, 通所介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_10() {

        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl1().getTextBox102().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl1().getTextBox109().getValue();
        Decimal 通所リハビリテーション合計 = div.getPnlMain().getTbl1().getTextBox110().getValue();

        return 入力チェック3(通所リハビリテーション要支援計, 通所リハビリテーション要介護計, 通所リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_件数_3_11() {

        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl1().getTextBox113().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl1().getTextBox120().getValue();
        Decimal 短期入所サービス合計 = div.getPnlMain().getTbl1().getTextBox121().getValue();

        return 入力チェック3(短期入所サービス要支援計, 短期入所サービス要介護計, 短期入所サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_12() {

        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox124().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox131().getValue();
        Decimal 短期入所生活介護合計 = div.getPnlMain().getTbl1().getTextBox132().getValue();

        return 入力チェック3(短期入所生活介護要支援計, 短期入所生活介護要介護計, 短期入所生活介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl1().getTextBox135().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl1().getTextBox142().getValue();
        Decimal 短期入所療養介護介護老人保健施設合計 = div.getPnlMain().getTbl1().getTextBox143().getValue();

        return 入力チェック3(短期入所療養介護介護老人保健施設要支援計,
                短期入所療養介護介護老人保健施設要介護計, 短期入所療養介護介護老人保健施設合計);
    }

    private boolean is整合性チェック_NG_件数_3_14() {

        Decimal 短期入所療養介護介護療養型医療施設要支援計 = div.getPnlMain().getTbl1().getTextBox146().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl1().getTextBox153().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等合計 = div.getPnlMain().getTbl1().getTextBox154().getValue();

        return 入力チェック3(短期入所療養介護介護療養型医療施設要支援計, 短期入所療養介護介護療養型医療施設等要介護計,
                短期入所療養介護介護療養型医療施設等合計);
    }

    private boolean is整合性チェック_NG_件数_3_15() {

        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl1().getTextBox157().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl1().getTextBox164().getValue();
        Decimal 福祉用具住宅改修サービス合計 = div.getPnlMain().getTbl1().getTextBox165().getValue();

        return 入力チェック3(福祉用具住宅改修サービス要支援計, 福祉用具住宅改修サービス要介護計, 福祉用具住宅改修サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_16() {

        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl1().getTextBox168().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl1().getTextBox175().getValue();
        Decimal 福祉用具貸与合計 = div.getPnlMain().getTbl1().getTextBox176().getValue();

        return 入力チェック3(福祉用具貸与要支援計, 福祉用具貸与要介護計, 福祉用具貸与合計);
    }

    private boolean is整合性チェック_NG_件数_3_17() {

        Decimal 福祉用具購入費要支援計 = div.getPnlMain().getTbl1().getTextBox179().getValue();
        Decimal 福祉用具購入費要介護計 = div.getPnlMain().getTbl1().getTextBox186().getValue();
        Decimal 福祉用具購入費合計 = div.getPnlMain().getTbl1().getTextBox187().getValue();

        return 入力チェック3(福祉用具購入費要支援計, 福祉用具購入費要介護計, 福祉用具購入費合計);
    }

    private boolean is整合性チェック_NG_件数_3_18() {

        Decimal 住宅改修費要支援計 = div.getPnlMain().getTbl1().getTextBox190().getValue();
        Decimal 住宅改修費要介護計 = div.getPnlMain().getTbl1().getTextBox197().getValue();
        Decimal 住宅改修費合計 = div.getPnlMain().getTbl1().getTextBox198().getValue();

        return 入力チェック3(住宅改修費要支援計, 住宅改修費要介護計, 住宅改修費合計);
    }

    private boolean is整合性チェック_NG_件数_3_19() {

        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox201().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox208().getValue();
        Decimal 特定施設入居者生活介護合計 = div.getPnlMain().getTbl1().getTextBox209().getValue();

        return 入力チェック3(特定施設入居者生活介護要支援計, 特定施設入居者生活介護要介護計, 特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_20() {

        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl1().getTextBox212().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl1().getTextBox219().getValue();
        Decimal 介護予防支援居宅介護支援合計 = div.getPnlMain().getTbl1().getTextBox220().getValue();

        return 入力チェック3(介護予防支援居宅介護支援要支援計, 介護予防支援居宅介護支援要介護計, 介護予防支援居宅介護支援合計);
    }

    private boolean is整合性チェック_NG_件数_3_21() {

        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl1().getTextBox223().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl1().getTextBox230().getValue();
        Decimal 地域密着型介護予防サービス合計 = div.getPnlMain().getTbl1().getTextBox231().getValue();

        return 入力チェック3(地域密着型介護予防サービス要支援計,
                地域密着型介護予防サービス要介護計, 地域密着型介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl1().getTextBox234().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl1().getTextBox240().getValue();
        Decimal 定期巡回随時対応型訪問介護看護合計 = div.getPnlMain().getTbl1().getTextBox241().getValue();

        return 入力チェック3(定期巡回随時対応型訪問介護看護要支援計,
                定期巡回随時対応型訪問介護看護要介護計, 定期巡回随時対応型訪問介護看護合計);
    }

    private boolean is整合性チェック_NG_件数_3_23() {

        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl1().getTextBox244().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl1().getTextBox250().getValue();
        Decimal 夜間対応型訪問介護合計 = div.getPnlMain().getTbl1().getTextBox251().getValue();

        return 入力チェック3(夜間対応型訪問介護要支援計, 夜間対応型訪問介護要介護計, 夜間対応型訪問介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_24() {

        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl1().getTextBox254().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl1().getTextBox261().getValue();
        Decimal 認知症対応型通所介護合計 = div.getPnlMain().getTbl1().getTextBox262().getValue();

        return 入力チェック3(認知症対応型通所介護要支援計, 認知症対応型通所介護要介護計, 認知症対応型通所介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_25() {

        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl1().getTextBox265().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl1().getTextBox272().getValue();
        Decimal 小規模多機能型居宅介護合計 = div.getPnlMain().getTbl1().getTextBox273().getValue();

        return 入力チェック3(小規模多機能型居宅介護要支援計, 小規模多機能型居宅介護要介護計, 小規模多機能型居宅介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_26() {

        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox276().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox282().getValue();
        Decimal 認知症対応型共同生活介護合計 = div.getPnlMain().getTbl1().getTextBox283().getValue();

        return 入力チェック3(認知症対応型共同生活介護要支援計, 認知症対応型共同生活介護要介護計, 認知症対応型共同生活介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox286().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox292().getValue();
        Decimal 地域密着型特定施設入居者生活介護合計 = div.getPnlMain().getTbl1().getTextBox293().getValue();

        return 入力チェック3(地域密着型特定施設入居者生活介護要支援計,
                地域密着型特定施設入居者生活介護要介護計, 地域密着型特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox296().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox302().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護合計 = div.getPnlMain().getTbl1().getTextBox303().getValue();

        return 入力チェック3(地域密着型介護老人福祉施設入所者生活介護要支援計, 地域密着型介護老人福祉施設入所者生活介護要介護計,
                地域密着型介護老人福祉施設入所者生活介護合計);
    }

    private boolean is整合性チェック_NG_件数_3_29() {

        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl1().getTextBox306().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl1().getTextBox312().getValue();
        Decimal 複合型サービス合計 = div.getPnlMain().getTbl1().getTextBox313().getValue();

        return 入力チェック3(複合型サービス要支援計, 複合型サービス要介護計, 複合型サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_30() {

        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl1().getTextBox316().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl1().getTextBox323().getValue();
        Decimal 施設サービス合計 = div.getPnlMain().getTbl1().getTextBox324().getValue();

        return 入力チェック3(施設サービス要支援計, 施設サービス要介護計, 施設サービス合計);
    }

    private boolean is整合性チェック_NG_件数_3_31() {

        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl1().getTextBox327().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl1().getTextBox334().getValue();
        Decimal 介護老人福祉施設_1_合計 = div.getPnlMain().getTbl1().getTextBox335().getValue();

        return 入力チェック3(介護老人福祉施設_1_要支援計, 介護老人福祉施設_1_要介護計, 介護老人福祉施設_1_合計);
    }

    private boolean is整合性チェック_NG_件数_3_32() {

        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl1().getTextBox338().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl1().getTextBox344().getValue();
        Decimal 介護老人保健施設_1_合計 = div.getPnlMain().getTbl1().getTextBox345().getValue();

        return 入力チェック3(介護老人保健施設_1_要支援計, 介護老人保健施設_1_要介護計, 介護老人保健施設_1_合計);
    }

    private boolean is整合性チェック_NG_件数_3_33() {

        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl1().getTextBox348().getValue();
        Decimal 介護療養型医療施設要介護計 = div.getPnlMain().getTbl1().getTextBox354().getValue();
        Decimal 介護療養型医療施設合計 = div.getPnlMain().getTbl1().getTextBox355().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_件数_3_34() {

        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl1().getTextBox358().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl1().getTextBox365().getValue();
        Decimal 食事提供費用再掲合計 = div.getPnlMain().getTbl1().getTextBox366().getValue();

        return 入力チェック3(食事提供費用再掲要支援計, 食事提供費用再掲要介護計, 食事提供費用再掲合計);
    }

    private boolean is整合性チェック_NG_件数_3_35() {

        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl1().getTextBox369().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl1().getTextBox376().getValue();
        Decimal 介護老人福祉施設_2_合計 = div.getPnlMain().getTbl1().getTextBox377().getValue();

        return 入力チェック3(介護老人福祉施設_2_要支援計, 介護老人福祉施設_2_要介護計, 介護老人福祉施設_2_合計);
    }

    private boolean is整合性チェック_NG_件数_3_36() {

        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl1().getTextBox380().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl1().getTextBox386().getValue();
        Decimal 介護老人保健施設_2_合計 = div.getPnlMain().getTbl1().getTextBox387().getValue();

        return 入力チェック3(介護老人保健施設_2_要支援計, 介護老人保健施設_2_要介護計, 介護老人保健施設_2_合計);
    }

    private boolean is整合性チェック_NG_件数_3_37() {

        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl1().getTextBox390().getValue();
        Decimal 介護療養型医療施設要介護計 = div.getPnlMain().getTbl1().getTextBox396().getValue();
        Decimal 介護療養型医療施設合計 = div.getPnlMain().getTbl1().getTextBox397().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_件数_3_38() {

        Decimal 総計要支援計 = div.getPnlMain().getTbl1().getTextBox400().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl1().getTextBox408().getValue();
        Decimal 総計合計 = div.getPnlMain().getTbl1().getTextBox409().getValue();

        return 入力チェック3(総計要支援計, 総計要介護計, 総計合計);
    }

    /**
     * is整合性チェック_NG_単位数のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_単位数_NG3() {

        return is整合性チェック_NG_単位数_整合3_1() || is整合性チェック_NG_単位数_整合3_2()
                || is整合性チェック_NG_単位数_整合3_3();
    }

    private boolean is整合性チェック_NG_単位数_整合3_1() {
        return is整合性チェック_NG_単位数_3_1() || is整合性チェック_NG_単位数_3_2()
                || is整合性チェック_NG_単位数_3_3() || is整合性チェック_NG_単位数_3_4()
                || is整合性チェック_NG_単位数_3_5() || is整合性チェック_NG_単位数_3_6()
                || is整合性チェック_NG_単位数_3_7() || is整合性チェック_NG_単位数_3_8()
                || is整合性チェック_NG_単位数_3_9() || is整合性チェック_NG_単位数_3_10()
                || is整合性チェック_NG_単位数_3_11() || is整合性チェック_NG_単位数_3_12()
                || is整合性チェック_NG_単位数_3_13();
    }

    private boolean is整合性チェック_NG_単位数_整合3_2() {
        return is整合性チェック_NG_単位数_3_14() || is整合性チェック_NG_単位数_3_15()
                || is整合性チェック_NG_単位数_3_16() || is整合性チェック_NG_単位数_3_19()
                || is整合性チェック_NG_単位数_3_20() || is整合性チェック_NG_単位数_3_21()
                || is整合性チェック_NG_単位数_3_22() || is整合性チェック_NG_単位数_3_23()
                || is整合性チェック_NG_単位数_3_24() || is整合性チェック_NG_単位数_3_25()
                || is整合性チェック_NG_単位数_3_26();
    }

    private boolean is整合性チェック_NG_単位数_整合3_3() {
        return is整合性チェック_NG_単位数_3_27() || is整合性チェック_NG_単位数_3_28()
                || is整合性チェック_NG_単位数_3_29() || is整合性チェック_NG_単位数_3_30()
                || is整合性チェック_NG_単位数_3_31() || is整合性チェック_NG_単位数_3_32()
                || is整合性チェック_NG_単位数_3_33() || is整合性チェック_NG_単位数_3_34()
                || is整合性チェック_NG_単位数_3_35() || is整合性チェック_NG_単位数_3_36()
                || is整合性チェック_NG_単位数_3_37() || is整合性チェック_NG_単位数_3_38();
    }

    private boolean is整合性チェック_NG_単位数_3_1() {

        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl2().getTextBox412().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl2().getTextBox419().getValue();
        Decimal 居宅介護予防サービス合計 = div.getPnlMain().getTbl2().getTextBox420().getValue();

        return 入力チェック3(居宅介護予防サービス要支援計, 居宅介護予防サービス要介護計, 居宅介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_2() {

        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl2().getTextBox423().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl2().getTextBox430().getValue();
        Decimal 訪問サービス合計 = div.getPnlMain().getTbl2().getTextBox431().getValue();

        return 入力チェック3(訪問サービス要支援計, 訪問サービス要介護計, 訪問サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_3() {

        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl2().getTextBox434().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl2().getTextBox441().getValue();
        Decimal 訪問介護合計 = div.getPnlMain().getTbl2().getTextBox442().getValue();

        return 入力チェック3(訪問介護要支援計, 訪問介護要介護計, 訪問介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_4() {

        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl2().getTextBox445().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl2().getTextBox452().getValue();
        Decimal 訪問入浴介護合計 = div.getPnlMain().getTbl2().getTextBox453().getValue();

        return 入力チェック3(訪問入浴介護要支援計, 訪問入浴介護要介護計, 訪問入浴介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_5() {

        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl2().getTextBox456().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl2().getTextBox463().getValue();
        Decimal 訪問看護要合計 = div.getPnlMain().getTbl2().getTextBox464().getValue();

        return 入力チェック3(訪問看護要支援計, 訪問看護要介護計, 訪問看護要合計);
    }

    private boolean is整合性チェック_NG_単位数_3_6() {

        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl2().getTextBox467().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl2().getTextBox474().getValue();
        Decimal 訪問リハビリテーション合計 = div.getPnlMain().getTbl2().getTextBox475().getValue();

        return 入力チェック3(訪問リハビリテーション要支援計, 訪問リハビリテーション要介護計, 訪問リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_単位数_3_7() {

        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl2().getTextBox478().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl2().getTextBox485().getValue();
        Decimal 居宅療養管理指導合計 = div.getPnlMain().getTbl2().getTextBox486().getValue();

        return 入力チェック3(居宅療養管理指導要支援計, 居宅療養管理指導要介護計, 居宅療養管理指導合計);
    }

    private boolean is整合性チェック_NG_単位数_3_8() {

        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl2().getTextBox489().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl2().getTextBox496().getValue();
        Decimal 通所サービス要合計 = div.getPnlMain().getTbl2().getTextBox497().getValue();

        return 入力チェック3(通所サービス要支援計, 通所サービス要介護計, 通所サービス要合計);
    }

    private boolean is整合性チェック_NG_単位数_3_9() {

        Decimal 通所介護要支援計 = div.getPnlMain().getTbl2().getTextBox500().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl2().getTextBox507().getValue();
        Decimal 通所介護合計 = div.getPnlMain().getTbl2().getTextBox508().getValue();

        return 入力チェック3(通所介護要支援計, 通所介護要介護計, 通所介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_10() {

        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl2().getTextBox511().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl2().getTextBox518().getValue();
        Decimal 通所リハビリテーション合計 = div.getPnlMain().getTbl2().getTextBox519().getValue();

        return 入力チェック3(通所リハビリテーション要支援計, 通所リハビリテーション要介護計, 通所リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_単位数_3_11() {

        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl2().getTextBox522().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl2().getTextBox529().getValue();
        Decimal 短期入所サービス合計 = div.getPnlMain().getTbl2().getTextBox530().getValue();

        return 入力チェック3(短期入所サービス要支援計, 短期入所サービス要介護計, 短期入所サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_12() {

        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox533().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox540().getValue();
        Decimal 短期入所生活介護合計 = div.getPnlMain().getTbl2().getTextBox541().getValue();

        return 入力チェック3(短期入所生活介護要支援計, 短期入所生活介護要介護計, 短期入所生活介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl2().getTextBox544().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl2().getTextBox551().getValue();
        Decimal 短期入所療養介護介護老人保健施設合計 = div.getPnlMain().getTbl2().getTextBox552().getValue();

        return 入力チェック3(短期入所療養介護介護老人保健施設要支援計,
                短期入所療養介護介護老人保健施設要介護計, 短期入所療養介護介護老人保健施設合計);
    }

    private boolean is整合性チェック_NG_単位数_3_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl2().getTextBox555().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl2().getTextBox562().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等合計 = div.getPnlMain().getTbl2().getTextBox563().getValue();

        return 入力チェック3(短期入所療養介護介護療養型医療施設等要支援計, 短期入所療養介護介護療養型医療施設等要介護計,
                短期入所療養介護介護療養型医療施設等合計);
    }

    private boolean is整合性チェック_NG_単位数_3_15() {

        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl2().getTextBox566().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl2().getTextBox573().getValue();
        Decimal 福祉用具住宅改修サービス合計 = div.getPnlMain().getTbl2().getTextBox574().getValue();

        return 入力チェック3(福祉用具住宅改修サービス要支援計, 福祉用具住宅改修サービス要介護計, 福祉用具住宅改修サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_16() {

        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl2().getTextBox577().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl2().getTextBox584().getValue();
        Decimal 福祉用具貸与合計 = div.getPnlMain().getTbl2().getTextBox585().getValue();

        return 入力チェック3(福祉用具貸与要支援計, 福祉用具貸与要介護計, 福祉用具貸与合計);
    }

    private boolean is整合性チェック_NG_単位数_3_19() {

        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox610().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox617().getValue();
        Decimal 特定施設入居者生活介護合計 = div.getPnlMain().getTbl2().getTextBox618().getValue();

        return 入力チェック3(特定施設入居者生活介護要支援計, 特定施設入居者生活介護要介護計, 特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_20() {

        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl2().getTextBox621().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl2().getTextBox628().getValue();
        Decimal 介護予防支援居宅介護支援合計 = div.getPnlMain().getTbl2().getTextBox629().getValue();

        return 入力チェック3(介護予防支援居宅介護支援要支援計, 介護予防支援居宅介護支援要介護計, 介護予防支援居宅介護支援合計);
    }

    private boolean is整合性チェック_NG_単位数_3_21() {

        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl2().getTextBox632().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl2().getTextBox639().getValue();
        Decimal 地域密着型介護予防サービス合計 = div.getPnlMain().getTbl2().getTextBox640().getValue();

        return 入力チェック3(地域密着型介護予防サービス要支援計,
                地域密着型介護予防サービス要介護計, 地域密着型介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl2().getTextBox643().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl2().getTextBox649().getValue();
        Decimal 定期巡回随時対応型訪問介護看護合計 = div.getPnlMain().getTbl2().getTextBox650().getValue();

        return 入力チェック3(定期巡回随時対応型訪問介護看護要支援計,
                定期巡回随時対応型訪問介護看護要介護計, 定期巡回随時対応型訪問介護看護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_23() {

        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl2().getTextBox653().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl2().getTextBox659().getValue();
        Decimal 夜間対応型訪問介護合計 = div.getPnlMain().getTbl2().getTextBox660().getValue();

        return 入力チェック3(夜間対応型訪問介護要支援計, 夜間対応型訪問介護要介護計, 夜間対応型訪問介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_24() {

        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl2().getTextBox663().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl2().getTextBox670().getValue();
        Decimal 認知症対応型通所介護合計 = div.getPnlMain().getTbl2().getTextBox671().getValue();

        return 入力チェック3(認知症対応型通所介護要支援計, 認知症対応型通所介護要介護計, 認知症対応型通所介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_25() {

        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl2().getTextBox674().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl2().getTextBox681().getValue();
        Decimal 小規模多機能型居宅介護合計 = div.getPnlMain().getTbl2().getTextBox682().getValue();

        return 入力チェック3(小規模多機能型居宅介護要支援計, 小規模多機能型居宅介護要介護計, 小規模多機能型居宅介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_26() {

        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox685().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox691().getValue();
        Decimal 認知症対応型共同生活介護合計 = div.getPnlMain().getTbl2().getTextBox692().getValue();

        return 入力チェック3(認知症対応型共同生活介護要支援計, 認知症対応型共同生活介護要介護計, 認知症対応型共同生活介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox695().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox701().getValue();
        Decimal 地域密着型特定施設入居者生活介護合計 = div.getPnlMain().getTbl2().getTextBox702().getValue();

        return 入力チェック3(地域密着型特定施設入居者生活介護要支援計,
                地域密着型特定施設入居者生活介護要介護計, 地域密着型特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox705().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox711().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護合計 = div.getPnlMain().getTbl2().getTextBox712().getValue();

        return 入力チェック3(地域密着型介護老人福祉施設入所者生活介護要支援計, 地域密着型介護老人福祉施設入所者生活介護要介護計,
                地域密着型介護老人福祉施設入所者生活介護合計);
    }

    private boolean is整合性チェック_NG_単位数_3_29() {

        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl2().getTextBox715().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl2().getTextBox721().getValue();
        Decimal 複合型サービス合計 = div.getPnlMain().getTbl2().getTextBox722().getValue();

        return 入力チェック3(複合型サービス要支援計, 複合型サービス要介護計, 複合型サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_30() {

        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl2().getTextBox725().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl2().getTextBox732().getValue();
        Decimal 施設サービス合計 = div.getPnlMain().getTbl2().getTextBox733().getValue();

        return 入力チェック3(施設サービス要支援計, 施設サービス要介護計, 施設サービス合計);
    }

    private boolean is整合性チェック_NG_単位数_3_31() {

        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl2().getTextBox736().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl2().getTextBox743().getValue();
        Decimal 介護老人福祉施設_1_合計 = div.getPnlMain().getTbl2().getTextBox744().getValue();

        return 入力チェック3(介護老人福祉施設_1_要支援計, 介護老人福祉施設_1_要介護計, 介護老人福祉施設_1_合計);
    }

    private boolean is整合性チェック_NG_単位数_3_32() {

        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl2().getTextBox747().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl2().getTextBox753().getValue();
        Decimal 介護老人保健施設_1_合計 = div.getPnlMain().getTbl2().getTextBox754().getValue();

        return 入力チェック3(介護老人保健施設_1_要支援計, 介護老人保健施設_1_要介護計, 介護老人保健施設_1_合計);
    }

    private boolean is整合性チェック_NG_単位数_3_33() {

        Decimal 介護療養型医療施設_1_要支援計 = div.getPnlMain().getTbl2().getTextBox757().getValue();
        Decimal 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl2().getTextBox763().getValue();
        Decimal 介護療養型医療施設_1_合計 = div.getPnlMain().getTbl2().getTextBox764().getValue();

        return 入力チェック3(介護療養型医療施設_1_要支援計, 介護療養型医療施設_1_要介護計, 介護療養型医療施設_1_合計);
    }

    private boolean is整合性チェック_NG_単位数_3_34() {

        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl2().getTextBox757().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl2().getTextBox774().getValue();
        Decimal 食事提供費用再掲合計 = div.getPnlMain().getTbl2().getTextBox775().getValue();

        return 入力チェック3(食事提供費用再掲要支援計, 食事提供費用再掲要介護計, 食事提供費用再掲合計);
    }

    private boolean is整合性チェック_NG_単位数_3_35() {

        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl2().getTextBox778().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl2().getTextBox785().getValue();
        Decimal 介護老人福祉施設_2_合計 = div.getPnlMain().getTbl2().getTextBox786().getValue();

        return 入力チェック3(介護老人福祉施設_2_要支援計, 介護老人福祉施設_2_要介護計, 介護老人福祉施設_2_合計);
    }

    private boolean is整合性チェック_NG_単位数_3_36() {

        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl2().getTextBox789().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl2().getTextBox795().getValue();
        Decimal 介護老人保健施設_2_合計 = div.getPnlMain().getTbl2().getTextBox796().getValue();

        return 入力チェック3(介護老人保健施設_2_要支援計, 介護老人保健施設_2_要介護計, 介護老人保健施設_2_合計);
    }

    private boolean is整合性チェック_NG_単位数_3_37() {

        Decimal 介護療養型医療施設_2_要支援計 = div.getPnlMain().getTbl2().getTextBox799().getValue();
        Decimal 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl2().getTextBox805().getValue();
        Decimal 介護療養型医療施設_2_合計 = div.getPnlMain().getTbl2().getTextBox806().getValue();

        return 入力チェック3(介護療養型医療施設_2_要支援計, 介護療養型医療施設_2_要介護計, 介護療養型医療施設_2_合計);
    }

    private boolean is整合性チェック_NG_単位数_3_38() {

        Decimal 総計要支援計 = div.getPnlMain().getTbl2().getTextBox809().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl2().getTextBox817().getValue();
        Decimal 総計合計 = div.getPnlMain().getTbl2().getTextBox818().getValue();

        return 入力チェック3(総計要支援計, 総計要介護計, 総計合計);
    }

    private boolean 入力チェック3(Decimal 入力要支援計,
            Decimal 入力要介護計,
            Decimal 入力合計) {
        Decimal 要支援計 = 入力要支援計 == null ? Decimal.ZERO : 入力要支援計;
        Decimal 要介護計 = 入力要介護計 == null ? Decimal.ZERO : 入力要介護計;
        Decimal 合計 = 入力合計 == null ? Decimal.ZERO : 入力合計;
        return !要支援計.add(要介護計).equals(合計);
    }

    /**
     * 修正データリストを取得のメソッドます。
     *
     * @param 単位数引き継ぎデータ List<JigyoHokokuTokeiData>
     * @param 事業報告基本データ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get単位数修正データリスト(List<JigyoHokokuTokeiData> 単位数引き継ぎデータ,
            JigyoHokokuGeppoParameter 事業報告基本データ) {

        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト = new ArrayList<>();
//        RString 集計番号 = new RString(事業報告基本データ.get集計番号().toString());
        if (事業報告基本データ.get行集計番号().startsWith(単位数総数)) {
            事業報告月報詳細データリスト = 単位数引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(単位数第２号被保険者分再掲)) {
            事業報告月報詳細データリスト = 単位数引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(単位数総数特例分)) {
            事業報告月報詳細データリスト = 単位数引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(単位数第２号被保険者分再掲特例分)) {
            事業報告月報詳細データリスト = 単位数引き継ぎデータ;
        }

        修正データリスト = get事業報告修正データリスト(事業報告月報詳細データリスト, 修正データリスト);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト1(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_15,
                div.getPnlMain().getTbl2().getTextBox410().getValue(),
                div.getPnlMain().getTbl2().getTextBox411().getValue(),
                div.getPnlMain().getTbl2().getTextBox412().getValue(),
                div.getPnlMain().getTbl2().getTextBox413().getValue(),
                div.getPnlMain().getTbl2().getTextBox414().getValue(),
                div.getPnlMain().getTbl2().getTextBox415().getValue(),
                div.getPnlMain().getTbl2().getTextBox416().getValue(),
                div.getPnlMain().getTbl2().getTextBox417().getValue(),
                div.getPnlMain().getTbl2().getTextBox418().getValue(),
                div.getPnlMain().getTbl2().getTextBox419().getValue(),
                div.getPnlMain().getTbl2().getTextBox420().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_1,
                div.getPnlMain().getTbl2().getTextBox421().getValue(),
                div.getPnlMain().getTbl2().getTextBox422().getValue(),
                div.getPnlMain().getTbl2().getTextBox423().getValue(),
                div.getPnlMain().getTbl2().getTextBox424().getValue(),
                div.getPnlMain().getTbl2().getTextBox425().getValue(),
                div.getPnlMain().getTbl2().getTextBox426().getValue(),
                div.getPnlMain().getTbl2().getTextBox427().getValue(),
                div.getPnlMain().getTbl2().getTextBox428().getValue(),
                div.getPnlMain().getTbl2().getTextBox429().getValue(),
                div.getPnlMain().getTbl2().getTextBox430().getValue(),
                div.getPnlMain().getTbl2().getTextBox431().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_16,
                div.getPnlMain().getTbl2().getTextBox432().getValue(),
                div.getPnlMain().getTbl2().getTextBox433().getValue(),
                div.getPnlMain().getTbl2().getTextBox434().getValue(),
                div.getPnlMain().getTbl2().getTextBox435().getValue(),
                div.getPnlMain().getTbl2().getTextBox436().getValue(),
                div.getPnlMain().getTbl2().getTextBox437().getValue(),
                div.getPnlMain().getTbl2().getTextBox438().getValue(),
                div.getPnlMain().getTbl2().getTextBox439().getValue(),
                div.getPnlMain().getTbl2().getTextBox440().getValue(),
                div.getPnlMain().getTbl2().getTextBox441().getValue(),
                div.getPnlMain().getTbl2().getTextBox442().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_17,
                div.getPnlMain().getTbl2().getTextBox443().getValue(),
                div.getPnlMain().getTbl2().getTextBox444().getValue(),
                div.getPnlMain().getTbl2().getTextBox445().getValue(),
                div.getPnlMain().getTbl2().getTextBox446().getValue(),
                div.getPnlMain().getTbl2().getTextBox447().getValue(),
                div.getPnlMain().getTbl2().getTextBox448().getValue(),
                div.getPnlMain().getTbl2().getTextBox449().getValue(),
                div.getPnlMain().getTbl2().getTextBox450().getValue(),
                div.getPnlMain().getTbl2().getTextBox451().getValue(),
                div.getPnlMain().getTbl2().getTextBox452().getValue(),
                div.getPnlMain().getTbl2().getTextBox453().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト2(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_18,
                div.getPnlMain().getTbl2().getTextBox454().getValue(),
                div.getPnlMain().getTbl2().getTextBox455().getValue(),
                div.getPnlMain().getTbl2().getTextBox456().getValue(),
                div.getPnlMain().getTbl2().getTextBox457().getValue(),
                div.getPnlMain().getTbl2().getTextBox458().getValue(),
                div.getPnlMain().getTbl2().getTextBox459().getValue(),
                div.getPnlMain().getTbl2().getTextBox460().getValue(),
                div.getPnlMain().getTbl2().getTextBox461().getValue(),
                div.getPnlMain().getTbl2().getTextBox462().getValue(),
                div.getPnlMain().getTbl2().getTextBox463().getValue(),
                div.getPnlMain().getTbl2().getTextBox464().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_19,
                div.getPnlMain().getTbl2().getTextBox465().getValue(),
                div.getPnlMain().getTbl2().getTextBox466().getValue(),
                div.getPnlMain().getTbl2().getTextBox467().getValue(),
                div.getPnlMain().getTbl2().getTextBox468().getValue(),
                div.getPnlMain().getTbl2().getTextBox469().getValue(),
                div.getPnlMain().getTbl2().getTextBox470().getValue(),
                div.getPnlMain().getTbl2().getTextBox471().getValue(),
                div.getPnlMain().getTbl2().getTextBox472().getValue(),
                div.getPnlMain().getTbl2().getTextBox473().getValue(),
                div.getPnlMain().getTbl2().getTextBox474().getValue(),
                div.getPnlMain().getTbl2().getTextBox475().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_26,
                div.getPnlMain().getTbl2().getTextBox476().getValue(),
                div.getPnlMain().getTbl2().getTextBox477().getValue(),
                div.getPnlMain().getTbl2().getTextBox478().getValue(),
                div.getPnlMain().getTbl2().getTextBox479().getValue(),
                div.getPnlMain().getTbl2().getTextBox480().getValue(),
                div.getPnlMain().getTbl2().getTextBox481().getValue(),
                div.getPnlMain().getTbl2().getTextBox482().getValue(),
                div.getPnlMain().getTbl2().getTextBox483().getValue(),
                div.getPnlMain().getTbl2().getTextBox484().getValue(),
                div.getPnlMain().getTbl2().getTextBox485().getValue(),
                div.getPnlMain().getTbl2().getTextBox486().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_30,
                div.getPnlMain().getTbl2().getTextBox487().getValue(),
                div.getPnlMain().getTbl2().getTextBox488().getValue(),
                div.getPnlMain().getTbl2().getTextBox489().getValue(),
                div.getPnlMain().getTbl2().getTextBox490().getValue(),
                div.getPnlMain().getTbl2().getTextBox491().getValue(),
                div.getPnlMain().getTbl2().getTextBox492().getValue(),
                div.getPnlMain().getTbl2().getTextBox493().getValue(),
                div.getPnlMain().getTbl2().getTextBox494().getValue(),
                div.getPnlMain().getTbl2().getTextBox495().getValue(),
                div.getPnlMain().getTbl2().getTextBox496().getValue(),
                div.getPnlMain().getTbl2().getTextBox497().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト3(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_20,
                div.getPnlMain().getTbl2().getTextBox498().getValue(),
                div.getPnlMain().getTbl2().getTextBox499().getValue(),
                div.getPnlMain().getTbl2().getTextBox500().getValue(),
                div.getPnlMain().getTbl2().getTextBox501().getValue(),
                div.getPnlMain().getTbl2().getTextBox502().getValue(),
                div.getPnlMain().getTbl2().getTextBox503().getValue(),
                div.getPnlMain().getTbl2().getTextBox504().getValue(),
                div.getPnlMain().getTbl2().getTextBox505().getValue(),
                div.getPnlMain().getTbl2().getTextBox506().getValue(),
                div.getPnlMain().getTbl2().getTextBox507().getValue(),
                div.getPnlMain().getTbl2().getTextBox508().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_21,
                div.getPnlMain().getTbl2().getTextBox509().getValue(),
                div.getPnlMain().getTbl2().getTextBox510().getValue(),
                div.getPnlMain().getTbl2().getTextBox511().getValue(),
                div.getPnlMain().getTbl2().getTextBox512().getValue(),
                div.getPnlMain().getTbl2().getTextBox513().getValue(),
                div.getPnlMain().getTbl2().getTextBox514().getValue(),
                div.getPnlMain().getTbl2().getTextBox515().getValue(),
                div.getPnlMain().getTbl2().getTextBox516().getValue(),
                div.getPnlMain().getTbl2().getTextBox517().getValue(),
                div.getPnlMain().getTbl2().getTextBox518().getValue(),
                div.getPnlMain().getTbl2().getTextBox519().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_2,
                div.getPnlMain().getTbl2().getTextBox520().getValue(),
                div.getPnlMain().getTbl2().getTextBox521().getValue(),
                div.getPnlMain().getTbl2().getTextBox522().getValue(),
                div.getPnlMain().getTbl2().getTextBox523().getValue(),
                div.getPnlMain().getTbl2().getTextBox524().getValue(),
                div.getPnlMain().getTbl2().getTextBox525().getValue(),
                div.getPnlMain().getTbl2().getTextBox526().getValue(),
                div.getPnlMain().getTbl2().getTextBox527().getValue(),
                div.getPnlMain().getTbl2().getTextBox528().getValue(),
                div.getPnlMain().getTbl2().getTextBox529().getValue(),
                div.getPnlMain().getTbl2().getTextBox530().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_23,
                div.getPnlMain().getTbl2().getTextBox531().getValue(),
                div.getPnlMain().getTbl2().getTextBox532().getValue(),
                div.getPnlMain().getTbl2().getTextBox533().getValue(),
                div.getPnlMain().getTbl2().getTextBox534().getValue(),
                div.getPnlMain().getTbl2().getTextBox535().getValue(),
                div.getPnlMain().getTbl2().getTextBox536().getValue(),
                div.getPnlMain().getTbl2().getTextBox537().getValue(),
                div.getPnlMain().getTbl2().getTextBox538().getValue(),
                div.getPnlMain().getTbl2().getTextBox539().getValue(),
                div.getPnlMain().getTbl2().getTextBox540().getValue(),
                div.getPnlMain().getTbl2().getTextBox541().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト4(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_24,
                div.getPnlMain().getTbl2().getTextBox542().getValue(),
                div.getPnlMain().getTbl2().getTextBox543().getValue(),
                div.getPnlMain().getTbl2().getTextBox544().getValue(),
                div.getPnlMain().getTbl2().getTextBox545().getValue(),
                div.getPnlMain().getTbl2().getTextBox546().getValue(),
                div.getPnlMain().getTbl2().getTextBox547().getValue(),
                div.getPnlMain().getTbl2().getTextBox548().getValue(),
                div.getPnlMain().getTbl2().getTextBox549().getValue(),
                div.getPnlMain().getTbl2().getTextBox550().getValue(),
                div.getPnlMain().getTbl2().getTextBox551().getValue(),
                div.getPnlMain().getTbl2().getTextBox552().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_25,
                div.getPnlMain().getTbl2().getTextBox553().getValue(),
                div.getPnlMain().getTbl2().getTextBox554().getValue(),
                div.getPnlMain().getTbl2().getTextBox555().getValue(),
                div.getPnlMain().getTbl2().getTextBox556().getValue(),
                div.getPnlMain().getTbl2().getTextBox557().getValue(),
                div.getPnlMain().getTbl2().getTextBox558().getValue(),
                div.getPnlMain().getTbl2().getTextBox559().getValue(),
                div.getPnlMain().getTbl2().getTextBox560().getValue(),
                div.getPnlMain().getTbl2().getTextBox561().getValue(),
                div.getPnlMain().getTbl2().getTextBox562().getValue(),
                div.getPnlMain().getTbl2().getTextBox563().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_3,
                div.getPnlMain().getTbl2().getTextBox564().getValue(),
                div.getPnlMain().getTbl2().getTextBox565().getValue(),
                div.getPnlMain().getTbl2().getTextBox566().getValue(),
                div.getPnlMain().getTbl2().getTextBox567().getValue(),
                div.getPnlMain().getTbl2().getTextBox568().getValue(),
                div.getPnlMain().getTbl2().getTextBox569().getValue(),
                div.getPnlMain().getTbl2().getTextBox570().getValue(),
                div.getPnlMain().getTbl2().getTextBox571().getValue(),
                div.getPnlMain().getTbl2().getTextBox572().getValue(),
                div.getPnlMain().getTbl2().getTextBox573().getValue(),
                div.getPnlMain().getTbl2().getTextBox574().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_22,
                div.getPnlMain().getTbl2().getTextBox575().getValue(),
                div.getPnlMain().getTbl2().getTextBox576().getValue(),
                div.getPnlMain().getTbl2().getTextBox577().getValue(),
                div.getPnlMain().getTbl2().getTextBox578().getValue(),
                div.getPnlMain().getTbl2().getTextBox579().getValue(),
                div.getPnlMain().getTbl2().getTextBox580().getValue(),
                div.getPnlMain().getTbl2().getTextBox581().getValue(),
                div.getPnlMain().getTbl2().getTextBox582().getValue(),
                div.getPnlMain().getTbl2().getTextBox583().getValue(),
                div.getPnlMain().getTbl2().getTextBox584().getValue(),
                div.getPnlMain().getTbl2().getTextBox585().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト5(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_28,
                div.getPnlMain().getTbl2().getTextBox608().getValue(),
                div.getPnlMain().getTbl2().getTextBox609().getValue(),
                div.getPnlMain().getTbl2().getTextBox610().getValue(),
                div.getPnlMain().getTbl2().getTextBox611().getValue(),
                div.getPnlMain().getTbl2().getTextBox612().getValue(),
                div.getPnlMain().getTbl2().getTextBox613().getValue(),
                div.getPnlMain().getTbl2().getTextBox614().getValue(),
                div.getPnlMain().getTbl2().getTextBox615().getValue(),
                div.getPnlMain().getTbl2().getTextBox616().getValue(),
                div.getPnlMain().getTbl2().getTextBox617().getValue(),
                div.getPnlMain().getTbl2().getTextBox618().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_29,
                div.getPnlMain().getTbl2().getTextBox619().getValue(),
                div.getPnlMain().getTbl2().getTextBox620().getValue(),
                div.getPnlMain().getTbl2().getTextBox621().getValue(),
                div.getPnlMain().getTbl2().getTextBox622().getValue(),
                div.getPnlMain().getTbl2().getTextBox623().getValue(),
                div.getPnlMain().getTbl2().getTextBox624().getValue(),
                div.getPnlMain().getTbl2().getTextBox625().getValue(),
                div.getPnlMain().getTbl2().getTextBox626().getValue(),
                div.getPnlMain().getTbl2().getTextBox627().getValue(),
                div.getPnlMain().getTbl2().getTextBox628().getValue(),
                div.getPnlMain().getTbl2().getTextBox629().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト6(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_31,
                div.getPnlMain().getTbl2().getTextBox630().getValue(),
                div.getPnlMain().getTbl2().getTextBox631().getValue(),
                div.getPnlMain().getTbl2().getTextBox632().getValue(),
                div.getPnlMain().getTbl2().getTextBox633().getValue(),
                div.getPnlMain().getTbl2().getTextBox634().getValue(),
                div.getPnlMain().getTbl2().getTextBox635().getValue(),
                div.getPnlMain().getTbl2().getTextBox636().getValue(),
                div.getPnlMain().getTbl2().getTextBox637().getValue(),
                div.getPnlMain().getTbl2().getTextBox638().getValue(),
                div.getPnlMain().getTbl2().getTextBox639().getValue(),
                div.getPnlMain().getTbl2().getTextBox640().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_37,
                div.getPnlMain().getTbl2().getTextBox641().getValue(),
                div.getPnlMain().getTbl2().getTextBox642().getValue(),
                div.getPnlMain().getTbl2().getTextBox643().getValue(),
                div.getPnlMain().getTbl2().getTextBox644().getValue(),
                div.getPnlMain().getTbl2().getTextBox645().getValue(),
                div.getPnlMain().getTbl2().getTextBox646().getValue(),
                div.getPnlMain().getTbl2().getTextBox647().getValue(),
                div.getPnlMain().getTbl2().getTextBox648().getValue(),
                div.getPnlMain().getTbl2().getTextBox649().getValue(),
                div.getPnlMain().getTbl2().getTextBox650().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_32,
                div.getPnlMain().getTbl2().getTextBox651().getValue(),
                div.getPnlMain().getTbl2().getTextBox652().getValue(),
                div.getPnlMain().getTbl2().getTextBox653().getValue(),
                div.getPnlMain().getTbl2().getTextBox654().getValue(),
                div.getPnlMain().getTbl2().getTextBox655().getValue(),
                div.getPnlMain().getTbl2().getTextBox656().getValue(),
                div.getPnlMain().getTbl2().getTextBox657().getValue(),
                div.getPnlMain().getTbl2().getTextBox658().getValue(),
                div.getPnlMain().getTbl2().getTextBox659().getValue(),
                div.getPnlMain().getTbl2().getTextBox660().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_33,
                div.getPnlMain().getTbl2().getTextBox661().getValue(),
                div.getPnlMain().getTbl2().getTextBox662().getValue(),
                div.getPnlMain().getTbl2().getTextBox663().getValue(),
                div.getPnlMain().getTbl2().getTextBox664().getValue(),
                div.getPnlMain().getTbl2().getTextBox665().getValue(),
                div.getPnlMain().getTbl2().getTextBox666().getValue(),
                div.getPnlMain().getTbl2().getTextBox667().getValue(),
                div.getPnlMain().getTbl2().getTextBox668().getValue(),
                div.getPnlMain().getTbl2().getTextBox669().getValue(),
                div.getPnlMain().getTbl2().getTextBox670().getValue(),
                div.getPnlMain().getTbl2().getTextBox671().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト7(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_34,
                div.getPnlMain().getTbl2().getTextBox672().getValue(),
                div.getPnlMain().getTbl2().getTextBox673().getValue(),
                div.getPnlMain().getTbl2().getTextBox674().getValue(),
                div.getPnlMain().getTbl2().getTextBox675().getValue(),
                div.getPnlMain().getTbl2().getTextBox676().getValue(),
                div.getPnlMain().getTbl2().getTextBox677().getValue(),
                div.getPnlMain().getTbl2().getTextBox678().getValue(),
                div.getPnlMain().getTbl2().getTextBox679().getValue(),
                div.getPnlMain().getTbl2().getTextBox680().getValue(),
                div.getPnlMain().getTbl2().getTextBox681().getValue(),
                div.getPnlMain().getTbl2().getTextBox682().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_27,
                div.getPnlMain().getTbl2().getTextBox683().getValue(),
                div.getPnlMain().getTbl2().getTextBox684().getValue(),
                div.getPnlMain().getTbl2().getTextBox685().getValue(),
                div.getPnlMain().getTbl2().getTextBox686().getValue(),
                div.getPnlMain().getTbl2().getTextBox687().getValue(),
                div.getPnlMain().getTbl2().getTextBox688().getValue(),
                div.getPnlMain().getTbl2().getTextBox689().getValue(),
                div.getPnlMain().getTbl2().getTextBox690().getValue(),
                div.getPnlMain().getTbl2().getTextBox691().getValue(),
                div.getPnlMain().getTbl2().getTextBox692().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_35,
                div.getPnlMain().getTbl2().getTextBox693().getValue(),
                div.getPnlMain().getTbl2().getTextBox694().getValue(),
                div.getPnlMain().getTbl2().getTextBox695().getValue(),
                div.getPnlMain().getTbl2().getTextBox696().getValue(),
                div.getPnlMain().getTbl2().getTextBox697().getValue(),
                div.getPnlMain().getTbl2().getTextBox698().getValue(),
                div.getPnlMain().getTbl2().getTextBox699().getValue(),
                div.getPnlMain().getTbl2().getTextBox700().getValue(),
                div.getPnlMain().getTbl2().getTextBox701().getValue(),
                div.getPnlMain().getTbl2().getTextBox702().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_36,
                div.getPnlMain().getTbl2().getTextBox703().getValue(),
                div.getPnlMain().getTbl2().getTextBox704().getValue(),
                div.getPnlMain().getTbl2().getTextBox705().getValue(),
                div.getPnlMain().getTbl2().getTextBox706().getValue(),
                div.getPnlMain().getTbl2().getTextBox707().getValue(),
                div.getPnlMain().getTbl2().getTextBox708().getValue(),
                div.getPnlMain().getTbl2().getTextBox709().getValue(),
                div.getPnlMain().getTbl2().getTextBox710().getValue(),
                div.getPnlMain().getTbl2().getTextBox711().getValue(),
                div.getPnlMain().getTbl2().getTextBox712().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト8(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_38,
                div.getPnlMain().getTbl2().getTextBox713().getValue(),
                div.getPnlMain().getTbl2().getTextBox714().getValue(),
                div.getPnlMain().getTbl2().getTextBox715().getValue(),
                div.getPnlMain().getTbl2().getTextBox716().getValue(),
                div.getPnlMain().getTbl2().getTextBox717().getValue(),
                div.getPnlMain().getTbl2().getTextBox718().getValue(),
                div.getPnlMain().getTbl2().getTextBox719().getValue(),
                div.getPnlMain().getTbl2().getTextBox720().getValue(),
                div.getPnlMain().getTbl2().getTextBox721().getValue(),
                div.getPnlMain().getTbl2().getTextBox722().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_6,
                div.getPnlMain().getTbl2().getTextBox723().getValue(),
                div.getPnlMain().getTbl2().getTextBox724().getValue(),
                div.getPnlMain().getTbl2().getTextBox725().getValue(),
                div.getPnlMain().getTbl2().getTextBox726().getValue(),
                div.getPnlMain().getTbl2().getTextBox727().getValue(),
                div.getPnlMain().getTbl2().getTextBox728().getValue(),
                div.getPnlMain().getTbl2().getTextBox729().getValue(),
                div.getPnlMain().getTbl2().getTextBox730().getValue(),
                div.getPnlMain().getTbl2().getTextBox731().getValue(),
                div.getPnlMain().getTbl2().getTextBox732().getValue(),
                div.getPnlMain().getTbl2().getTextBox733().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_7,
                div.getPnlMain().getTbl2().getTextBox734().getValue(),
                div.getPnlMain().getTbl2().getTextBox735().getValue(),
                div.getPnlMain().getTbl2().getTextBox736().getValue(),
                div.getPnlMain().getTbl2().getTextBox737().getValue(),
                div.getPnlMain().getTbl2().getTextBox738().getValue(),
                div.getPnlMain().getTbl2().getTextBox739().getValue(),
                div.getPnlMain().getTbl2().getTextBox740().getValue(),
                div.getPnlMain().getTbl2().getTextBox741().getValue(),
                div.getPnlMain().getTbl2().getTextBox742().getValue(),
                div.getPnlMain().getTbl2().getTextBox743().getValue(),
                div.getPnlMain().getTbl2().getTextBox744().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_8,
                div.getPnlMain().getTbl2().getTextBox745().getValue(),
                div.getPnlMain().getTbl2().getTextBox746().getValue(),
                div.getPnlMain().getTbl2().getTextBox747().getValue(),
                div.getPnlMain().getTbl2().getTextBox748().getValue(),
                div.getPnlMain().getTbl2().getTextBox749().getValue(),
                div.getPnlMain().getTbl2().getTextBox750().getValue(),
                div.getPnlMain().getTbl2().getTextBox751().getValue(),
                div.getPnlMain().getTbl2().getTextBox752().getValue(),
                div.getPnlMain().getTbl2().getTextBox753().getValue(),
                div.getPnlMain().getTbl2().getTextBox754().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト9(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_9,
                div.getPnlMain().getTbl2().getTextBox755().getValue(),
                div.getPnlMain().getTbl2().getTextBox756().getValue(),
                div.getPnlMain().getTbl2().getTextBox757().getValue(),
                div.getPnlMain().getTbl2().getTextBox758().getValue(),
                div.getPnlMain().getTbl2().getTextBox759().getValue(),
                div.getPnlMain().getTbl2().getTextBox760().getValue(),
                div.getPnlMain().getTbl2().getTextBox761().getValue(),
                div.getPnlMain().getTbl2().getTextBox762().getValue(),
                div.getPnlMain().getTbl2().getTextBox763().getValue(),
                div.getPnlMain().getTbl2().getTextBox764().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_10,
                div.getPnlMain().getTbl2().getTextBox765().getValue(),
                div.getPnlMain().getTbl2().getTextBox766().getValue(),
                div.getPnlMain().getTbl2().getTextBox767().getValue(),
                div.getPnlMain().getTbl2().getTextBox768().getValue(),
                div.getPnlMain().getTbl2().getTextBox769().getValue(),
                div.getPnlMain().getTbl2().getTextBox770().getValue(),
                div.getPnlMain().getTbl2().getTextBox771().getValue(),
                div.getPnlMain().getTbl2().getTextBox772().getValue(),
                div.getPnlMain().getTbl2().getTextBox773().getValue(),
                div.getPnlMain().getTbl2().getTextBox774().getValue(),
                div.getPnlMain().getTbl2().getTextBox775().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_11,
                div.getPnlMain().getTbl2().getTextBox776().getValue(),
                div.getPnlMain().getTbl2().getTextBox777().getValue(),
                div.getPnlMain().getTbl2().getTextBox778().getValue(),
                div.getPnlMain().getTbl2().getTextBox779().getValue(),
                div.getPnlMain().getTbl2().getTextBox780().getValue(),
                div.getPnlMain().getTbl2().getTextBox781().getValue(),
                div.getPnlMain().getTbl2().getTextBox782().getValue(),
                div.getPnlMain().getTbl2().getTextBox783().getValue(),
                div.getPnlMain().getTbl2().getTextBox784().getValue(),
                div.getPnlMain().getTbl2().getTextBox785().getValue(),
                div.getPnlMain().getTbl2().getTextBox786().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_12,
                div.getPnlMain().getTbl2().getTextBox787().getValue(),
                div.getPnlMain().getTbl2().getTextBox788().getValue(),
                div.getPnlMain().getTbl2().getTextBox789().getValue(),
                div.getPnlMain().getTbl2().getTextBox790().getValue(),
                div.getPnlMain().getTbl2().getTextBox791().getValue(),
                div.getPnlMain().getTbl2().getTextBox792().getValue(),
                div.getPnlMain().getTbl2().getTextBox793().getValue(),
                div.getPnlMain().getTbl2().getTextBox794().getValue(),
                div.getPnlMain().getTbl2().getTextBox795().getValue(),
                div.getPnlMain().getTbl2().getTextBox796().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト10(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_13,
                div.getPnlMain().getTbl2().getTextBox797().getValue(),
                div.getPnlMain().getTbl2().getTextBox798().getValue(),
                div.getPnlMain().getTbl2().getTextBox799().getValue(),
                div.getPnlMain().getTbl2().getTextBox800().getValue(),
                div.getPnlMain().getTbl2().getTextBox801().getValue(),
                div.getPnlMain().getTbl2().getTextBox802().getValue(),
                div.getPnlMain().getTbl2().getTextBox803().getValue(),
                div.getPnlMain().getTbl2().getTextBox804().getValue(),
                div.getPnlMain().getTbl2().getTextBox805().getValue(),
                div.getPnlMain().getTbl2().getTextBox806().getValue());
        修正データリスト = get事業報告修正データ_3(事業報告月報詳細データリスト, 修正データリスト, 縦番号_14,
                div.getPnlMain().getTbl2().getTextBox807().getValue(),
                div.getPnlMain().getTbl2().getTextBox808().getValue(),
                div.getPnlMain().getTbl2().getTextBox809().getValue(),
                div.getPnlMain().getTbl2().getTextBox810().getValue(),
                div.getPnlMain().getTbl2().getTextBox811().getValue(),
                div.getPnlMain().getTbl2().getTextBox812().getValue(),
                div.getPnlMain().getTbl2().getTextBox813().getValue(),
                div.getPnlMain().getTbl2().getTextBox814().getValue(),
                div.getPnlMain().getTbl2().getTextBox815().getValue(),
                div.getPnlMain().getTbl2().getTextBox816().getValue(),
                div.getPnlMain().getTbl2().getTextBox817().getValue(),
                div.getPnlMain().getTbl2().getTextBox818().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データリスト(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = editor修正データリスト1(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト2(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト3(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト4(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト5(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト6(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト7(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト8(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト9(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor修正データリスト10(事業報告月報詳細データリスト, 修正データリスト);

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_3(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10,
            Decimal 集計結果値11,
            Decimal 集計結果値12) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_1, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_2, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値11, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値12, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_2(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10,
            Decimal 集計結果値11) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_1, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値11, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_1(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10,
            Decimal 集計結果値11) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_2, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値11, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> set集計結果値(
            Decimal 集計結果値,
            List<JigyoHokokuTokeiData> 修正データリスト,
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            Decimal 横番号,
            Decimal 縦番号) {
        JigyoHokokuTokeiData entity = check事業報告統計データ(事業報告月報詳細データリスト, 横番号, 縦番号);
        if (集計結果値 == null) {
            if (entity != null && entity.get集計結果値() != null) {
                entity = entity.createBuilderForEdit().set集計結果値(null).build();
                entity = entity.modifiedModel();
                修正データリスト.add(entity);
                return 修正データリスト;
            }
        } else {
            if (entity == null) {
                entity = set事業報告統計データ(事業報告月報詳細データリスト, 横番号, 縦番号, 集計結果値);
                修正データリスト.add(entity);
                return 修正データリスト;
            } else if (entity.get集計結果値() == null) {
                entity = entity.createBuilderForEdit().set集計結果値(集計結果値).build();
                entity = entity.modifiedModel();
                修正データリスト.add(entity);
                return 修正データリスト;
            } else if (!entity.get集計結果値().equals(集計結果値)) {
                entity = entity.createBuilderForEdit().set集計結果値(集計結果値).build();
                entity = entity.modifiedModel();
                修正データリスト.add(entity);
                return 修正データリスト;
            }
        }
        return 修正データリスト;
    }

    private JigyoHokokuTokeiData set事業報告統計データ(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 集計結果値) {
        JigyoHokokuTokeiData entity = 事業報告月報詳細データリスト.get(0).createBuilderForEdit()
                .set横番号(横番号)
                .set縦番号(縦番号)
                .set集計結果値(集計結果値)
                .set集計項目名称(null)
                .set縦項目コード(null)
                .set横項目コード(null).build();
        entity = entity.addedModel();
        return entity;
    }

    private JigyoHokokuTokeiData check事業報告統計データ(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            Decimal 横番号,
            Decimal 縦番号) {
        for (JigyoHokokuTokeiData entity : 事業報告月報詳細データリスト) {
            if (entity.get縦番号().equals(縦番号) && entity.get横番号().equals(横番号)) {
                return entity;
            }
        }
        return null;
    }

}

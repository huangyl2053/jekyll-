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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuCheckHandler {

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
    private static final Decimal 縦番号_4 = new Decimal("4");
    private static final Decimal 縦番号_5 = new Decimal("5");
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
    private static final RString 費用額総数 = new RString("01");
    private static final RString 費用額第２号被保険者分再掲 = new RString("02");
    private static final RString 費用額総数特例分 = new RString("03");
    private static final RString 費用額第２号被保険者分再掲特例分 = new RString("04");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuCheckHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * is整合性チェック_NG_単位数のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_単位数_NG1() {

        return is整合性チェック_単位数_NG_整合_単位数1_1() || is整合性チェック_単位数_NG_整合_単位数1_2()
                || is整合性チェック_単位数_NG_整合_単位数1_3();
    }

    /**
     * is整合性チェック_NG_単位数のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_単位数_NG2() {

        return is整合性チェック_単位数_NG_整合_単位数2_1() || is整合性チェック_単位数_NG_整合_単位数2_2()
                || is整合性チェック_単位数_NG_整合_単位数2_3();
    }

    private boolean is整合性チェック_単位数_NG_整合_単位数1_1() {
        return is整合性チェック_単位数_NG_1() || is整合性チェック_単位数_NG_2()
                || is整合性チェック_単位数_NG_3() || is整合性チェック_単位数_NG_4()
                || is整合性チェック_単位数_NG_5() || is整合性チェック_単位数_NG_6()
                || is整合性チェック_単位数_NG_7() || is整合性チェック_単位数_NG_8()
                || is整合性チェック_単位数_NG_9() || is整合性チェック_単位数_NG_10()
                || is整合性チェック_単位数_NG_11() || is整合性チェック_単位数_NG_12()
                || is整合性チェック_単位数_NG_13();

    }

    private boolean is整合性チェック_単位数_NG_整合_単位数1_2() {
        return is整合性チェック_単位数_NG_14() || is整合性チェック_単位数_NG_15()
                || is整合性チェック_単位数_NG_16() || is整合性チェック_単位数_NG_19()
                || is整合性チェック_単位数_NG_20() || is整合性チェック_単位数_NG_21()
                || is整合性チェック_単位数_NG_22() || is整合性チェック_単位数_NG_23()
                || is整合性チェック_単位数_NG_24() || is整合性チェック_単位数_NG_25()
                || is整合性チェック_単位数_NG_26();
    }

    private boolean is整合性チェック_単位数_NG_整合_単位数1_3() {
        return is整合性チェック_単位数_NG_27() || is整合性チェック_単位数_NG_28()
                || is整合性チェック_単位数_NG_29() || is整合性チェック_単位数_NG_30()
                || is整合性チェック_単位数_NG_31() || is整合性チェック_単位数_NG_32()
                || is整合性チェック_単位数_NG_33() || is整合性チェック_単位数_NG_34()
                || is整合性チェック_単位数_NG_35() || is整合性チェック_単位数_NG_36()
                || is整合性チェック_単位数_NG_37() || is整合性チェック_単位数_NG_38();
    }

    private boolean is整合性チェック_単位数_NG_整合_単位数2_1() {
        return is整合性チェック_単位数_NG_1_1() || is整合性チェック_単位数_NG_1_2()
                || is整合性チェック_単位数_NG_1_3() || is整合性チェック_単位数_NG_1_4()
                || is整合性チェック_単位数_NG_1_5() || is整合性チェック_単位数_NG_1_6()
                || is整合性チェック_単位数_NG_1_7() || is整合性チェック_単位数_NG_1_8()
                || is整合性チェック_単位数_NG_1_9() || is整合性チェック_単位数_NG_1_10()
                || is整合性チェック_単位数_NG_1_11() || is整合性チェック_単位数_NG_1_12()
                || is整合性チェック_単位数_NG_1_13();

    }

    private boolean is整合性チェック_単位数_NG_整合_単位数2_2() {
        return is整合性チェック_単位数_NG_1_14() || is整合性チェック_単位数_NG_1_15() || is整合性チェック_単位数_NG_1_16()
                || is整合性チェック_単位数_NG_1_19() || is整合性チェック_単位数_NG_1_20()
                || is整合性チェック_単位数_NG_1_21() || is整合性チェック_単位数_NG_1_22()
                || is整合性チェック_単位数_NG_1_23() || is整合性チェック_単位数_NG_1_24()
                || is整合性チェック_単位数_NG_1_25() || is整合性チェック_単位数_NG_1_26();
    }

    private boolean is整合性チェック_単位数_NG_整合_単位数2_3() {
        return is整合性チェック_単位数_NG_1_27() || is整合性チェック_単位数_NG_1_28()
                || is整合性チェック_単位数_NG_1_29() || is整合性チェック_単位数_NG_1_30()
                || is整合性チェック_単位数_NG_1_31() || is整合性チェック_単位数_NG_1_32()
                || is整合性チェック_単位数_NG_1_33() || is整合性チェック_単位数_NG_1_34()
                || is整合性チェック_単位数_NG_1_35() || is整合性チェック_単位数_NG_1_36()
                || is整合性チェック_単位数_NG_1_37() || is整合性チェック_単位数_NG_1_38();
    }

    private boolean is整合性チェック_単位数_NG_1_1() {

        Decimal 居宅介護予防サービス経過的要介護 = div.getPnlMain().getTbl2().getTextBox413().getValue();
        Decimal 居宅介護予防サービス要会護１ = div.getPnlMain().getTbl2().getTextBox414().getValue();
        Decimal 居宅介護予防サービス要介護２ = div.getPnlMain().getTbl2().getTextBox415().getValue();
        Decimal 居宅介護予防サービス要介護３ = div.getPnlMain().getTbl2().getTextBox416().getValue();
        Decimal 居宅介護予防サービス要介護４ = div.getPnlMain().getTbl2().getTextBox417().getValue();
        Decimal 居宅介護予防サービス要介護５ = div.getPnlMain().getTbl2().getTextBox418().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl2().getTextBox419().getValue();

        return 入力チェック2(居宅介護予防サービス経過的要介護,
                居宅介護予防サービス要会護１, 居宅介護予防サービス要介護２,
                居宅介護予防サービス要介護３, 居宅介護予防サービス要介護４,
                居宅介護予防サービス要介護５, 居宅介護予防サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_2() {

        Decimal 訪問サービス経過的要介護 = div.getPnlMain().getTbl2().getTextBox424().getValue();
        Decimal 訪問サービス要会護１ = div.getPnlMain().getTbl2().getTextBox425().getValue();
        Decimal 訪問サービス要介護２ = div.getPnlMain().getTbl2().getTextBox426().getValue();
        Decimal 訪問サービス要介護３ = div.getPnlMain().getTbl2().getTextBox427().getValue();
        Decimal 訪問サービス要介護４ = div.getPnlMain().getTbl2().getTextBox428().getValue();
        Decimal 訪問サービス要介護５ = div.getPnlMain().getTbl2().getTextBox429().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl2().getTextBox430().getValue();

        return 入力チェック2(訪問サービス経過的要介護, 訪問サービス要会護１, 訪問サービス要介護２,
                訪問サービス要介護３, 訪問サービス要介護４, 訪問サービス要介護５, 訪問サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_3() {

        Decimal 訪問介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox435().getValue();
        Decimal 訪問介護要会護１ = div.getPnlMain().getTbl2().getTextBox436().getValue();
        Decimal 訪問介護要介護２ = div.getPnlMain().getTbl2().getTextBox437().getValue();
        Decimal 訪問介護要介護３ = div.getPnlMain().getTbl2().getTextBox438().getValue();
        Decimal 訪問介護要介護４ = div.getPnlMain().getTbl2().getTextBox439().getValue();
        Decimal 訪問介護要介護５ = div.getPnlMain().getTbl2().getTextBox440().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl2().getTextBox441().getValue();

        return 入力チェック2(訪問介護経過的要介護, 訪問介護要会護１, 訪問介護要介護２,
                訪問介護要介護３, 訪問介護要介護４, 訪問介護要介護５, 訪問介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_4() {

        Decimal 訪問入浴介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox446().getValue();
        Decimal 訪問入浴介護要会護１ = div.getPnlMain().getTbl2().getTextBox447().getValue();
        Decimal 訪問入浴介護要介護２ = div.getPnlMain().getTbl2().getTextBox448().getValue();
        Decimal 訪問入浴介護要介護３ = div.getPnlMain().getTbl2().getTextBox449().getValue();
        Decimal 訪問入浴介護要介護４ = div.getPnlMain().getTbl2().getTextBox450().getValue();
        Decimal 訪問入浴介護要介護５ = div.getPnlMain().getTbl2().getTextBox451().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl2().getTextBox452().getValue();

        return 入力チェック2(訪問入浴介護経過的要介護, 訪問入浴介護要会護１, 訪問入浴介護要介護２,
                訪問入浴介護要介護３, 訪問入浴介護要介護４, 訪問入浴介護要介護５, 訪問入浴介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_5() {

        Decimal 訪問看護経過的要介護 = div.getPnlMain().getTbl2().getTextBox457().getValue();
        Decimal 訪問看護要会護１ = div.getPnlMain().getTbl2().getTextBox458().getValue();
        Decimal 訪問看護要介護２ = div.getPnlMain().getTbl2().getTextBox459().getValue();
        Decimal 訪問看護要介護３ = div.getPnlMain().getTbl2().getTextBox460().getValue();
        Decimal 訪問看護要介護４ = div.getPnlMain().getTbl2().getTextBox461().getValue();
        Decimal 訪問看護要介護５ = div.getPnlMain().getTbl2().getTextBox462().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl2().getTextBox463().getValue();

        return 入力チェック2(訪問看護経過的要介護, 訪問看護要会護１, 訪問看護要介護２,
                訪問看護要介護３, 訪問看護要介護４, 訪問看護要介護５, 訪問看護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_6() {

        Decimal 訪問リハビリテーション経過的要介護 = div.getPnlMain().getTbl2().getTextBox468().getValue();
        Decimal 訪問リハビリテーション要会護１ = div.getPnlMain().getTbl2().getTextBox469().getValue();
        Decimal 訪問リハビリテーション要介護２ = div.getPnlMain().getTbl2().getTextBox470().getValue();
        Decimal 訪問リハビリテーション要介護３ = div.getPnlMain().getTbl2().getTextBox471().getValue();
        Decimal 訪問リハビリテーション要介護４ = div.getPnlMain().getTbl2().getTextBox472().getValue();
        Decimal 訪問リハビリテーション要介護５ = div.getPnlMain().getTbl2().getTextBox473().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl2().getTextBox474().getValue();

        return 入力チェック2(訪問リハビリテーション経過的要介護,
                訪問リハビリテーション要会護１, 訪問リハビリテーション要介護２,
                訪問リハビリテーション要介護３, 訪問リハビリテーション要介護４,
                訪問リハビリテーション要介護５, 訪問リハビリテーション要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_7() {

        Decimal 居宅療養管理指導経過的要介護 = div.getPnlMain().getTbl2().getTextBox479().getValue();
        Decimal 居宅療養管理指導要会護１ = div.getPnlMain().getTbl2().getTextBox480().getValue();
        Decimal 居宅療養管理指導要介護２ = div.getPnlMain().getTbl2().getTextBox481().getValue();
        Decimal 居宅療養管理指導要介護３ = div.getPnlMain().getTbl2().getTextBox482().getValue();
        Decimal 居宅療養管理指導要介護４ = div.getPnlMain().getTbl2().getTextBox483().getValue();
        Decimal 居宅療養管理指導要介護５ = div.getPnlMain().getTbl2().getTextBox484().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl2().getTextBox485().getValue();

        return 入力チェック2(居宅療養管理指導経過的要介護, 居宅療養管理指導要会護１, 居宅療養管理指導要介護２,
                居宅療養管理指導要介護３, 居宅療養管理指導要介護４, 居宅療養管理指導要介護５, 居宅療養管理指導要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_8() {

        Decimal 通所サービス経過的要介護 = div.getPnlMain().getTbl2().getTextBox490().getValue();
        Decimal 通所サービス要会護１ = div.getPnlMain().getTbl2().getTextBox491().getValue();
        Decimal 通所サービス要介護２ = div.getPnlMain().getTbl2().getTextBox492().getValue();
        Decimal 通所サービス要介護３ = div.getPnlMain().getTbl2().getTextBox493().getValue();
        Decimal 通所サービス要介護４ = div.getPnlMain().getTbl2().getTextBox494().getValue();
        Decimal 通所サービス要介護５ = div.getPnlMain().getTbl2().getTextBox495().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl2().getTextBox496().getValue();

        return 入力チェック2(通所サービス経過的要介護, 通所サービス要会護１, 通所サービス要介護２, 通所サービス要介護３,
                通所サービス要介護４, 通所サービス要介護５, 通所サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_9() {

        Decimal 通所介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox501().getValue();
        Decimal 通所介護要会護１ = div.getPnlMain().getTbl2().getTextBox502().getValue();
        Decimal 通所介護要介護２ = div.getPnlMain().getTbl2().getTextBox503().getValue();
        Decimal 通所介護要介護３ = div.getPnlMain().getTbl2().getTextBox504().getValue();
        Decimal 通所介護要介護４ = div.getPnlMain().getTbl2().getTextBox505().getValue();
        Decimal 通所介護要介護５ = div.getPnlMain().getTbl2().getTextBox506().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl2().getTextBox507().getValue();

        return 入力チェック2(通所介護経過的要介護, 通所介護要会護１, 通所介護要介護２,
                通所介護要介護３, 通所介護要介護４, 通所介護要介護５, 通所介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_10() {

        Decimal 通所リハビリテーション経過的要介護 = div.getPnlMain().getTbl2().getTextBox512().getValue();
        Decimal 通所リハビリテーション要会護１ = div.getPnlMain().getTbl2().getTextBox513().getValue();
        Decimal 通所リハビリテーション要介護２ = div.getPnlMain().getTbl2().getTextBox514().getValue();
        Decimal 通所リハビリテーション要介護３ = div.getPnlMain().getTbl2().getTextBox515().getValue();
        Decimal 通所リハビリテーション要介護４ = div.getPnlMain().getTbl2().getTextBox516().getValue();
        Decimal 通所リハビリテーション要介護５ = div.getPnlMain().getTbl2().getTextBox517().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl2().getTextBox518().getValue();

        return 入力チェック2(通所リハビリテーション経過的要介護,
                通所リハビリテーション要会護１, 通所リハビリテーション要介護２,
                通所リハビリテーション要介護３, 通所リハビリテーション要介護４,
                通所リハビリテーション要介護５, 通所リハビリテーション要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_11() {

        Decimal 短期入所サービス経過的要介護 = div.getPnlMain().getTbl2().getTextBox523().getValue();
        Decimal 短期入所サービス要会護１ = div.getPnlMain().getTbl2().getTextBox524().getValue();
        Decimal 短期入所サービス要介護２ = div.getPnlMain().getTbl2().getTextBox525().getValue();
        Decimal 短期入所サービス要介護３ = div.getPnlMain().getTbl2().getTextBox526().getValue();
        Decimal 短期入所サービス要介護４ = div.getPnlMain().getTbl2().getTextBox527().getValue();
        Decimal 短期入所サービス要介護５ = div.getPnlMain().getTbl2().getTextBox528().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl2().getTextBox529().getValue();

        return 入力チェック2(短期入所サービス経過的要介護, 短期入所サービス要会護１, 短期入所サービス要介護２,
                短期入所サービス要介護３, 短期入所サービス要介護４, 短期入所サービス要介護５, 短期入所サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_12() {

        Decimal 短期入所生活介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox534().getValue();
        Decimal 短期入所生活介護要会護１ = div.getPnlMain().getTbl2().getTextBox535().getValue();
        Decimal 短期入所生活介護要介護２ = div.getPnlMain().getTbl2().getTextBox536().getValue();
        Decimal 短期入所生活介護要介護３ = div.getPnlMain().getTbl2().getTextBox537().getValue();
        Decimal 短期入所生活介護要介護４ = div.getPnlMain().getTbl2().getTextBox538().getValue();
        Decimal 短期入所生活介護要介護５ = div.getPnlMain().getTbl2().getTextBox539().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox540().getValue();

        return 入力チェック2(短期入所生活介護経過的要介護, 短期入所生活介護要会護１, 短期入所生活介護要介護２,
                短期入所生活介護要介護３, 短期入所生活介護要介護４, 短期入所生活介護要介護５, 短期入所生活介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_13() {

        Decimal 短期入所療養介護介護老人保健施設経過的要介護 = div.getPnlMain().getTbl2().getTextBox545().getValue();
        Decimal 短期入所療養介護介護老人保健施設要会護１ = div.getPnlMain().getTbl2().getTextBox546().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護２ = div.getPnlMain().getTbl2().getTextBox547().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護３ = div.getPnlMain().getTbl2().getTextBox548().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護４ = div.getPnlMain().getTbl2().getTextBox549().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護５ = div.getPnlMain().getTbl2().getTextBox550().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl2().getTextBox551().getValue();

        return 入力チェック2(短期入所療養介護介護老人保健施設経過的要介護, 短期入所療養介護介護老人保健施設要会護１,
                短期入所療養介護介護老人保健施設要介護２, 短期入所療養介護介護老人保健施設要介護３,
                短期入所療養介護介護老人保健施設要介護４, 短期入所療養介護介護老人保健施設要介護５,
                短期入所療養介護介護老人保健施設要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_14() {

        Decimal 短期入所療養介護介護療養型医療施設等経過的要介護 = div.getPnlMain().getTbl2().getTextBox556().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要会護１ = div.getPnlMain().getTbl2().getTextBox557().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護２ = div.getPnlMain().getTbl2().getTextBox558().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護３ = div.getPnlMain().getTbl2().getTextBox559().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護４ = div.getPnlMain().getTbl2().getTextBox560().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護５ = div.getPnlMain().getTbl2().getTextBox561().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl2().getTextBox562().getValue();

        return 入力チェック2(短期入所療養介護介護療養型医療施設等経過的要介護, 短期入所療養介護介護療養型医療施設等要会護１,
                短期入所療養介護介護療養型医療施設等要介護２, 短期入所療養介護介護療養型医療施設等要介護３,
                短期入所療養介護介護療養型医療施設等要介護４, 短期入所療養介護介護療養型医療施設等要介護５,
                短期入所療養介護介護療養型医療施設等要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_15() {

        Decimal 福祉用具住宅改修サービス経過的要介護 = div.getPnlMain().getTbl2().getTextBox567().getValue();
        Decimal 福祉用具住宅改修サービス要会護１ = div.getPnlMain().getTbl2().getTextBox568().getValue();
        Decimal 福祉用具住宅改修サービス要介護２ = div.getPnlMain().getTbl2().getTextBox569().getValue();
        Decimal 福祉用具住宅改修サービス要介護３ = div.getPnlMain().getTbl2().getTextBox570().getValue();
        Decimal 福祉用具住宅改修サービス要介護４ = div.getPnlMain().getTbl2().getTextBox571().getValue();
        Decimal 福祉用具住宅改修サービス要介護５ = div.getPnlMain().getTbl2().getTextBox572().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl2().getTextBox573().getValue();

        return 入力チェック2(福祉用具住宅改修サービス経過的要介護, 福祉用具住宅改修サービス要会護１,
                福祉用具住宅改修サービス要介護２, 福祉用具住宅改修サービス要介護３,
                福祉用具住宅改修サービス要介護４, 福祉用具住宅改修サービス要介護５, 福祉用具住宅改修サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_16() {

        Decimal 福祉用具貸与経過的要介護 = div.getPnlMain().getTbl2().getTextBox578().getValue();
        Decimal 福祉用具貸与要会護１ = div.getPnlMain().getTbl2().getTextBox579().getValue();
        Decimal 福祉用具貸与要介護２ = div.getPnlMain().getTbl2().getTextBox580().getValue();
        Decimal 福祉用具貸与要介護３ = div.getPnlMain().getTbl2().getTextBox581().getValue();
        Decimal 福祉用具貸与要介護４ = div.getPnlMain().getTbl2().getTextBox582().getValue();
        Decimal 福祉用具貸与要介護５ = div.getPnlMain().getTbl2().getTextBox583().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl2().getTextBox584().getValue();

        return 入力チェック2(福祉用具貸与経過的要介護, 福祉用具貸与要会護１, 福祉用具貸与要介護２, 福祉用具貸与要介護３,
                福祉用具貸与要介護４, 福祉用具貸与要介護５, 福祉用具貸与要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_19() {

        Decimal 特定施設入居者生活介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox611().getValue();
        Decimal 特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl2().getTextBox612().getValue();
        Decimal 特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl2().getTextBox613().getValue();
        Decimal 特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl2().getTextBox614().getValue();
        Decimal 特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl2().getTextBox615().getValue();
        Decimal 特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl2().getTextBox616().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox617().getValue();

        return 入力チェック2(特定施設入居者生活介護経過的要介護,
                特定施設入居者生活介護要会護１, 特定施設入居者生活介護要介護２,
                特定施設入居者生活介護要介護３, 特定施設入居者生活介護要介護４,
                特定施設入居者生活介護要介護５, 特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_20() {

        Decimal 介護予防支援居宅介護支援経過的要介護 = div.getPnlMain().getTbl2().getTextBox622().getValue();
        Decimal 介護予防支援居宅介護支援要会護１ = div.getPnlMain().getTbl2().getTextBox623().getValue();
        Decimal 介護予防支援居宅介護支援要介護２ = div.getPnlMain().getTbl2().getTextBox624().getValue();
        Decimal 介護予防支援居宅介護支援要介護３ = div.getPnlMain().getTbl2().getTextBox625().getValue();
        Decimal 介護予防支援居宅介護支援要介護４ = div.getPnlMain().getTbl2().getTextBox626().getValue();
        Decimal 介護予防支援居宅介護支援要介護５ = div.getPnlMain().getTbl2().getTextBox627().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl2().getTextBox628().getValue();

        return 入力チェック2(介護予防支援居宅介護支援経過的要介護,
                介護予防支援居宅介護支援要会護１, 介護予防支援居宅介護支援要介護２,
                介護予防支援居宅介護支援要介護３, 介護予防支援居宅介護支援要介護４,
                介護予防支援居宅介護支援要介護５, 介護予防支援居宅介護支援要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_21() {

        Decimal 地域密着型介護予防サービス経過的要介護 = div.getPnlMain().getTbl2().getTextBox633().getValue();
        Decimal 地域密着型介護予防サービス要会護１ = div.getPnlMain().getTbl2().getTextBox634().getValue();
        Decimal 地域密着型介護予防サービス要介護２ = div.getPnlMain().getTbl2().getTextBox635().getValue();
        Decimal 地域密着型介護予防サービス要介護３ = div.getPnlMain().getTbl2().getTextBox636().getValue();
        Decimal 地域密着型介護予防サービス要介護４ = div.getPnlMain().getTbl2().getTextBox637().getValue();
        Decimal 地域密着型介護予防サービス要介護５ = div.getPnlMain().getTbl2().getTextBox638().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl2().getTextBox639().getValue();

        return 入力チェック2(地域密着型介護予防サービス経過的要介護,
                地域密着型介護予防サービス要会護１, 地域密着型介護予防サービス要介護２,
                地域密着型介護予防サービス要介護３, 地域密着型介護予防サービス要介護４,
                地域密着型介護予防サービス要介護５, 地域密着型介護予防サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_22() {

        Decimal 定期巡回随時対応型訪問介護看護経過的要介護 = Decimal.ZERO;
        Decimal 定期巡回随時対応型訪問介護看護要会護１ = div.getPnlMain().getTbl2().getTextBox644().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護２ = div.getPnlMain().getTbl2().getTextBox645().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護３ = div.getPnlMain().getTbl2().getTextBox646().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護４ = div.getPnlMain().getTbl2().getTextBox647().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護５ = div.getPnlMain().getTbl2().getTextBox648().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl2().getTextBox649().getValue();

        return 入力チェック2(定期巡回随時対応型訪問介護看護経過的要介護,
                定期巡回随時対応型訪問介護看護要会護１, 定期巡回随時対応型訪問介護看護要介護２,
                定期巡回随時対応型訪問介護看護要介護３, 定期巡回随時対応型訪問介護看護要介護４,
                定期巡回随時対応型訪問介護看護要介護５, 定期巡回随時対応型訪問介護看護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_23() {

        Decimal 夜間対応型訪問介護経過的要介護 = Decimal.ZERO;
        Decimal 夜間対応型訪問介護要会護１ = div.getPnlMain().getTbl2().getTextBox654().getValue();
        Decimal 夜間対応型訪問介護要介護２ = div.getPnlMain().getTbl2().getTextBox655().getValue();
        Decimal 夜間対応型訪問介護要介護３ = div.getPnlMain().getTbl2().getTextBox656().getValue();
        Decimal 夜間対応型訪問介護要介護４ = div.getPnlMain().getTbl2().getTextBox657().getValue();
        Decimal 夜間対応型訪問介護要介護５ = div.getPnlMain().getTbl2().getTextBox658().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl2().getTextBox659().getValue();

        return 入力チェック2(夜間対応型訪問介護経過的要介護, 夜間対応型訪問介護要会護１,
                夜間対応型訪問介護要介護２, 夜間対応型訪問介護要介護３,
                夜間対応型訪問介護要介護４, 夜間対応型訪問介護要介護５, 夜間対応型訪問介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_24() {

        Decimal 認知症対応型通所介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox664().getValue();
        Decimal 認知症対応型通所介護要会護１ = div.getPnlMain().getTbl2().getTextBox665().getValue();
        Decimal 認知症対応型通所介護要介護２ = div.getPnlMain().getTbl2().getTextBox666().getValue();
        Decimal 認知症対応型通所介護要介護３ = div.getPnlMain().getTbl2().getTextBox667().getValue();
        Decimal 認知症対応型通所介護要介護４ = div.getPnlMain().getTbl2().getTextBox668().getValue();
        Decimal 認知症対応型通所介護要介護５ = div.getPnlMain().getTbl2().getTextBox669().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl2().getTextBox670().getValue();

        return 入力チェック2(認知症対応型通所介護経過的要介護, 認知症対応型通所介護要会護１,
                認知症対応型通所介護要介護２, 認知症対応型通所介護要介護３,
                認知症対応型通所介護要介護４, 認知症対応型通所介護要介護５, 認知症対応型通所介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_25() {

        Decimal 小規模多機能型居宅介護経過的要介護 = div.getPnlMain().getTbl2().getTextBox675().getValue();
        Decimal 小規模多機能型居宅介護要会護１ = div.getPnlMain().getTbl2().getTextBox676().getValue();
        Decimal 小規模多機能型居宅介護要介護２ = div.getPnlMain().getTbl2().getTextBox677().getValue();
        Decimal 小規模多機能型居宅介護要介護３ = div.getPnlMain().getTbl2().getTextBox678().getValue();
        Decimal 小規模多機能型居宅介護要介護４ = div.getPnlMain().getTbl2().getTextBox679().getValue();
        Decimal 小規模多機能型居宅介護要介護５ = div.getPnlMain().getTbl2().getTextBox680().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl2().getTextBox681().getValue();

        return 入力チェック2(小規模多機能型居宅介護経過的要介護, 小規模多機能型居宅介護要会護１,
                小規模多機能型居宅介護要介護２, 小規模多機能型居宅介護要介護３,
                小規模多機能型居宅介護要介護４, 小規模多機能型居宅介護要介護５, 小規模多機能型居宅介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_26() {

        Decimal 認知症対応型共同生活介護経過的要介護 = Decimal.ZERO;
        Decimal 認知症対応型共同生活介護要会護１ = div.getPnlMain().getTbl2().getTextBox686().getValue();
        Decimal 認知症対応型共同生活介護要介護２ = div.getPnlMain().getTbl2().getTextBox687().getValue();
        Decimal 認知症対応型共同生活介護要介護３ = div.getPnlMain().getTbl2().getTextBox688().getValue();
        Decimal 認知症対応型共同生活介護要介護４ = div.getPnlMain().getTbl2().getTextBox689().getValue();
        Decimal 認知症対応型共同生活介護要介護５ = div.getPnlMain().getTbl2().getTextBox690().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox691().getValue();

        return 入力チェック2(認知症対応型共同生活介護経過的要介護,
                認知症対応型共同生活介護要会護１, 認知症対応型共同生活介護要介護２,
                認知症対応型共同生活介護要介護３, 認知症対応型共同生活介護要介護４,
                認知症対応型共同生活介護要介護５, 認知症対応型共同生活介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_27() {

        Decimal 地域密着型特定施設入居者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl2().getTextBox696().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl2().getTextBox697().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl2().getTextBox698().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl2().getTextBox699().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl2().getTextBox700().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox701().getValue();

        return 入力チェック2(地域密着型特定施設入居者生活介護経過的要介護,
                地域密着型特定施設入居者生活介護要会護１, 地域密着型特定施設入居者生活介護要介護２,
                地域密着型特定施設入居者生活介護要介護３, 地域密着型特定施設入居者生活介護要介護４,
                地域密着型特定施設入居者生活介護要介護５, 地域密着型特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型介護老人福祉施設入所者生活介護要会護１ = div.getPnlMain().getTbl2().getTextBox706().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護２ = div.getPnlMain().getTbl2().getTextBox707().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護３ = div.getPnlMain().getTbl2().getTextBox708().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護４ = div.getPnlMain().getTbl2().getTextBox709().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護５ = div.getPnlMain().getTbl2().getTextBox710().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl2().getTextBox711().getValue();

        return 入力チェック2(地域密着型介護老人福祉施設入所者生活介護経過的要介護,
                地域密着型介護老人福祉施設入所者生活介護要会護１, 地域密着型介護老人福祉施設入所者生活介護要介護２,
                地域密着型介護老人福祉施設入所者生活介護要介護３, 地域密着型介護老人福祉施設入所者生活介護要介護４,
                地域密着型介護老人福祉施設入所者生活介護要介護５, 地域密着型介護老人福祉施設入所者生活介護要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_29() {

        Decimal 複合型サービス経過的要介護 = Decimal.ZERO;
        Decimal 複合型サービス要会護１ = div.getPnlMain().getTbl2().getTextBox716().getValue();
        Decimal 複合型サービス要介護２ = div.getPnlMain().getTbl2().getTextBox717().getValue();
        Decimal 複合型サービス要介護３ = div.getPnlMain().getTbl2().getTextBox718().getValue();
        Decimal 複合型サービス要介護４ = div.getPnlMain().getTbl2().getTextBox719().getValue();
        Decimal 複合型サービス要介護５ = div.getPnlMain().getTbl2().getTextBox720().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl2().getTextBox721().getValue();

        return 入力チェック2(複合型サービス経過的要介護,
                複合型サービス要会護１, 複合型サービス要介護２, 複合型サービス要介護３,
                複合型サービス要介護４, 複合型サービス要介護５, 複合型サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_30() {

        Decimal 施設サービス経過的要介護 = Decimal.ZERO;
        Decimal 施設サービス要会護１ = div.getPnlMain().getTbl2().getTextBox727().getValue();
        Decimal 施設サービス要介護２ = div.getPnlMain().getTbl2().getTextBox728().getValue();
        Decimal 施設サービス要介護３ = div.getPnlMain().getTbl2().getTextBox729().getValue();
        Decimal 施設サービス要介護４ = div.getPnlMain().getTbl2().getTextBox730().getValue();
        Decimal 施設サービス要介護５ = div.getPnlMain().getTbl2().getTextBox731().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl2().getTextBox732().getValue();

        return 入力チェック2(施設サービス経過的要介護, 施設サービス要会護１, 施設サービス要介護２, 施設サービス要介護３,
                施設サービス要介護４, 施設サービス要介護５, 施設サービス要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_31() {

        Decimal 介護老人福祉施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_1_要会護１ = div.getPnlMain().getTbl2().getTextBox738().getValue();
        Decimal 介護老人福祉施設_1_要介護２ = div.getPnlMain().getTbl2().getTextBox739().getValue();
        Decimal 介護老人福祉施設_1_要介護３ = div.getPnlMain().getTbl2().getTextBox740().getValue();
        Decimal 介護老人福祉施設_1_要介護４ = div.getPnlMain().getTbl2().getTextBox741().getValue();
        Decimal 介護老人福祉施設_1_要介護５ = div.getPnlMain().getTbl2().getTextBox742().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl2().getTextBox743().getValue();

        return 入力チェック2(介護老人福祉施設_1_経過的要介護,
                介護老人福祉施設_1_要会護１, 介護老人福祉施設_1_要介護２,
                介護老人福祉施設_1_要介護３, 介護老人福祉施設_1_要介護４,
                介護老人福祉施設_1_要介護５, 介護老人福祉施設_1_要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_32() {

        Decimal 介護老人保健施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_1_要会護１ = div.getPnlMain().getTbl2().getTextBox748().getValue();
        Decimal 介護老人保健施設_1_要介護２ = div.getPnlMain().getTbl2().getTextBox749().getValue();
        Decimal 介護老人保健施設_1_要介護３ = div.getPnlMain().getTbl2().getTextBox750().getValue();
        Decimal 介護老人保健施設_1_要介護４ = div.getPnlMain().getTbl2().getTextBox751().getValue();
        Decimal 介護老人保健施設_1_要介護５ = div.getPnlMain().getTbl2().getTextBox752().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl2().getTextBox753().getValue();

        return 入力チェック2(介護老人保健施設_1_経過的要介護, 介護老人保健施設_1_要会護１, 介護老人保健施設_1_要介護２,
                介護老人保健施設_1_要介護３, 介護老人保健施設_1_要介護４,
                介護老人保健施設_1_要介護５, 介護老人保健施設_1_要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_33() {

        Decimal 介護療養型医療施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_1_要会護１ = div.getPnlMain().getTbl2().getTextBox758().getValue();
        Decimal 介護療養型医療施設_1_要介護２ = div.getPnlMain().getTbl2().getTextBox759().getValue();
        Decimal 介護療養型医療施設_1_要介護３ = div.getPnlMain().getTbl2().getTextBox760().getValue();
        Decimal 介護療養型医療施設_1_要介護４ = div.getPnlMain().getTbl2().getTextBox761().getValue();
        Decimal 介護療養型医療施設_1_要介護５ = div.getPnlMain().getTbl2().getTextBox762().getValue();
        Decimal 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl2().getTextBox763().getValue();

        return 入力チェック2(介護療養型医療施設_1_経過的要介護,
                介護療養型医療施設_1_要会護１, 介護療養型医療施設_1_要介護２,
                介護療養型医療施設_1_要介護３, 介護療養型医療施設_1_要介護４,
                介護療養型医療施設_1_要介護５, 介護療養型医療施設_1_要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_34() {

        Decimal 食事提供費用再掲経過的要介護 = Decimal.ZERO;
        Decimal 食事提供費用再掲要会護１ = div.getPnlMain().getTbl2().getTextBox769().getValue();
        Decimal 食事提供費用再掲要介護２ = div.getPnlMain().getTbl2().getTextBox770().getValue();
        Decimal 食事提供費用再掲要介護３ = div.getPnlMain().getTbl2().getTextBox771().getValue();
        Decimal 食事提供費用再掲要介護４ = div.getPnlMain().getTbl2().getTextBox772().getValue();
        Decimal 食事提供費用再掲要介護５ = div.getPnlMain().getTbl2().getTextBox773().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl2().getTextBox774().getValue();

        return 入力チェック2(食事提供費用再掲経過的要介護, 食事提供費用再掲要会護１,
                食事提供費用再掲要介護２, 食事提供費用再掲要介護３,
                食事提供費用再掲要介護４, 食事提供費用再掲要介護５, 食事提供費用再掲要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_35() {

        Decimal 介護老人福祉施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_2_要会護１ = div.getPnlMain().getTbl2().getTextBox780().getValue();
        Decimal 介護老人福祉施設_2_要介護２ = div.getPnlMain().getTbl2().getTextBox781().getValue();
        Decimal 介護老人福祉施設_2_要介護３ = div.getPnlMain().getTbl2().getTextBox782().getValue();
        Decimal 介護老人福祉施設_2_要介護４ = div.getPnlMain().getTbl2().getTextBox783().getValue();
        Decimal 介護老人福祉施設_2_要介護５ = div.getPnlMain().getTbl2().getTextBox784().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl2().getTextBox785().getValue();

        return 入力チェック2(介護老人福祉施設_2_経過的要介護, 介護老人福祉施設_2_要会護１, 介護老人福祉施設_2_要介護２,
                介護老人福祉施設_2_要介護３, 介護老人福祉施設_2_要介護４,
                介護老人福祉施設_2_要介護５, 介護老人福祉施設_2_要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_36() {

        Decimal 介護老人保健施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_2_要会護１ = div.getPnlMain().getTbl2().getTextBox790().getValue();
        Decimal 介護老人保健施設_2_要介護２ = div.getPnlMain().getTbl2().getTextBox791().getValue();
        Decimal 介護老人保健施設_2_要介護３ = div.getPnlMain().getTbl2().getTextBox792().getValue();
        Decimal 介護老人保健施設_2_要介護４ = div.getPnlMain().getTbl2().getTextBox793().getValue();
        Decimal 介護老人保健施設_2_要介護５ = div.getPnlMain().getTbl2().getTextBox794().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl2().getTextBox795().getValue();

        return 入力チェック2(介護老人保健施設_2_経過的要介護,
                介護老人保健施設_2_要会護１, 介護老人保健施設_2_要介護２,
                介護老人保健施設_2_要介護３, 介護老人保健施設_2_要介護４,
                介護老人保健施設_2_要介護５, 介護老人保健施設_2_要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_37() {

        Decimal 介護療養型医療施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_2_要会護１ = div.getPnlMain().getTbl2().getTextBox800().getValue();
        Decimal 介護療養型医療施設_2_要介護２ = div.getPnlMain().getTbl2().getTextBox801().getValue();
        Decimal 介護療養型医療施設_2_要介護３ = div.getPnlMain().getTbl2().getTextBox802().getValue();
        Decimal 介護療養型医療施設_2_要介護４ = div.getPnlMain().getTbl2().getTextBox803().getValue();
        Decimal 介護療養型医療施設_2_要介護５ = div.getPnlMain().getTbl2().getTextBox804().getValue();
        Decimal 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl2().getTextBox805().getValue();

        return 入力チェック2(介護療養型医療施設_2_経過的要介護,
                介護療養型医療施設_2_要会護１, 介護療養型医療施設_2_要介護２,
                介護療養型医療施設_2_要介護３, 介護療養型医療施設_2_要介護４,
                介護療養型医療施設_2_要介護５, 介護療養型医療施設_2_要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1_38() {

        Decimal 総計経過的要介護 = div.getPnlMain().getTbl2().getTextBox812().getValue();
        Decimal 総計要会護１ = div.getPnlMain().getTbl2().getTextBox813().getValue();
        Decimal 総計要介護２ = div.getPnlMain().getTbl2().getTextBox814().getValue();
        Decimal 総計要介護３ = div.getPnlMain().getTbl2().getTextBox815().getValue();
        Decimal 総計要介護４ = div.getPnlMain().getTbl2().getTextBox816().getValue();
        Decimal 総計要介護５ = div.getPnlMain().getTbl2().getTextBox817().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl2().getTextBox818().getValue();

        return 入力チェック2(総計経過的要介護, 総計要会護１, 総計要介護２,
                総計要介護３, 総計要介護４, 総計要介護５, 総計要介護計);
    }

    private boolean is整合性チェック_単位数_NG_1() {

        Decimal 居宅介護予防サービス要支援１ = div.getPnlMain().getTbl2().getTextBox410().getValue();
        Decimal 居宅介護予防サービス要支援２ = div.getPnlMain().getTbl2().getTextBox411().getValue();
        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl2().getTextBox412().getValue();

        return 入力チェック1(居宅介護予防サービス要支援１, 居宅介護予防サービス要支援２, 居宅介護予防サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_2() {

        Decimal 訪問サービス要支援１ = div.getPnlMain().getTbl2().getTextBox421().getValue();
        Decimal 訪問サービス要支援２ = div.getPnlMain().getTbl2().getTextBox422().getValue();
        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl2().getTextBox423().getValue();

        return 入力チェック1(訪問サービス要支援１, 訪問サービス要支援２, 訪問サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_3() {

        Decimal 訪問介護要支援１ = div.getPnlMain().getTbl2().getTextBox432().getValue();
        Decimal 訪問介護要支援２ = div.getPnlMain().getTbl2().getTextBox433().getValue();
        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl2().getTextBox434().getValue();

        return 入力チェック1(訪問介護要支援１, 訪問介護要支援２, 訪問介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_4() {

        Decimal 訪問入浴介護要支援１ = div.getPnlMain().getTbl2().getTextBox443().getValue();
        Decimal 訪問入浴介護要支援２ = div.getPnlMain().getTbl2().getTextBox444().getValue();
        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl2().getTextBox445().getValue();

        return 入力チェック1(訪問入浴介護要支援１, 訪問入浴介護要支援２, 訪問入浴介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_5() {

        Decimal 訪問看護要支援１ = div.getPnlMain().getTbl2().getTextBox454().getValue();
        Decimal 訪問看護要支援２ = div.getPnlMain().getTbl2().getTextBox455().getValue();
        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl2().getTextBox456().getValue();

        return 入力チェック1(訪問看護要支援１, 訪問看護要支援２, 訪問看護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_6() {

        Decimal 訪問リハビリテーション要支援１ = div.getPnlMain().getTbl2().getTextBox465().getValue();
        Decimal 訪問リハビリテーション要支援２ = div.getPnlMain().getTbl2().getTextBox466().getValue();
        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl2().getTextBox467().getValue();

        return 入力チェック1(訪問リハビリテーション要支援１, 訪問リハビリテーション要支援２, 訪問リハビリテーション要支援計);
    }

    private boolean is整合性チェック_単位数_NG_7() {

        Decimal 居宅療養管理指導要支援１ = div.getPnlMain().getTbl2().getTextBox476().getValue();
        Decimal 居宅療養管理指導要支援２ = div.getPnlMain().getTbl2().getTextBox477().getValue();
        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl2().getTextBox478().getValue();

        return 入力チェック1(居宅療養管理指導要支援１, 居宅療養管理指導要支援２, 居宅療養管理指導要支援計);
    }

    private boolean is整合性チェック_単位数_NG_8() {

        Decimal 通所サービス要支援１ = div.getPnlMain().getTbl2().getTextBox487().getValue();
        Decimal 通所サービス要支援２ = div.getPnlMain().getTbl2().getTextBox488().getValue();
        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl2().getTextBox489().getValue();

        return 入力チェック1(通所サービス要支援１, 通所サービス要支援２, 通所サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_9() {

        Decimal 通所介護要支援１ = div.getPnlMain().getTbl2().getTextBox498().getValue();
        Decimal 通所介護要支援２ = div.getPnlMain().getTbl2().getTextBox499().getValue();
        Decimal 通所介護要支援計 = div.getPnlMain().getTbl2().getTextBox500().getValue();

        return 入力チェック1(通所介護要支援１, 通所介護要支援２, 通所介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_10() {

        Decimal 通所リハビリテーション要支援１ = div.getPnlMain().getTbl2().getTextBox509().getValue();
        Decimal 通所リハビリテーション要支援２ = div.getPnlMain().getTbl2().getTextBox510().getValue();
        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl2().getTextBox511().getValue();

        return 入力チェック1(通所リハビリテーション要支援１, 通所リハビリテーション要支援２, 通所リハビリテーション要支援計);
    }

    private boolean is整合性チェック_単位数_NG_11() {

        Decimal 短期入所サービス要支援１ = div.getPnlMain().getTbl2().getTextBox520().getValue();
        Decimal 短期入所サービス要支援２ = div.getPnlMain().getTbl2().getTextBox521().getValue();
        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl2().getTextBox522().getValue();

        return 入力チェック1(短期入所サービス要支援１, 短期入所サービス要支援２, 短期入所サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_12() {

        Decimal 短期入所生活介護要支援１ = div.getPnlMain().getTbl2().getTextBox531().getValue();
        Decimal 短期入所生活介護要支援２ = div.getPnlMain().getTbl2().getTextBox532().getValue();
        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox533().getValue();

        return 入力チェック1(短期入所生活介護要支援１, 短期入所生活介護要支援２, 短期入所生活介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援１ = div.getPnlMain().getTbl2().getTextBox542().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援２ = div.getPnlMain().getTbl2().getTextBox543().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl2().getTextBox544().getValue();

        return 入力チェック1(短期入所療養介護介護老人保健施設要支援１,
                短期入所療養介護介護老人保健施設要支援２, 短期入所療養介護介護老人保健施設要支援計);
    }

    private boolean is整合性チェック_単位数_NG_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援１ = div.getPnlMain().getTbl2().getTextBox553().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援２ = div.getPnlMain().getTbl2().getTextBox554().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl2().getTextBox555().getValue();

        return 入力チェック1(短期入所療養介護介護療養型医療施設等要支援１, 短期入所療養介護介護療養型医療施設等要支援２,
                短期入所療養介護介護療養型医療施設等要支援計);
    }

    private boolean is整合性チェック_単位数_NG_15() {

        Decimal 福祉用具住宅改修サービス要支援１ = div.getPnlMain().getTbl2().getTextBox564().getValue();
        Decimal 福祉用具住宅改修サービス要支援２ = div.getPnlMain().getTbl2().getTextBox565().getValue();
        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl2().getTextBox566().getValue();

        return 入力チェック1(福祉用具住宅改修サービス要支援１,
                福祉用具住宅改修サービス要支援２, 福祉用具住宅改修サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_16() {

        Decimal 福祉用具貸与要支援１ = div.getPnlMain().getTbl2().getTextBox575().getValue();
        Decimal 福祉用具貸与要支援２ = div.getPnlMain().getTbl2().getTextBox576().getValue();
        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl2().getTextBox577().getValue();

        return 入力チェック1(福祉用具貸与要支援１, 福祉用具貸与要支援２, 福祉用具貸与要支援計);
    }

    private boolean is整合性チェック_単位数_NG_19() {

        Decimal 特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl2().getTextBox608().getValue();
        Decimal 特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl2().getTextBox609().getValue();
        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox610().getValue();

        return 入力チェック1(特定施設入居者生活介護要支援１, 特定施設入居者生活介護要支援２, 特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_20() {

        Decimal 介護予防支援居宅介護支援要支援１ = div.getPnlMain().getTbl2().getTextBox619().getValue();
        Decimal 介護予防支援居宅介護支援要支援２ = div.getPnlMain().getTbl2().getTextBox620().getValue();
        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl2().getTextBox621().getValue();

        return 入力チェック1(介護予防支援居宅介護支援要支援１,
                介護予防支援居宅介護支援要支援２, 介護予防支援居宅介護支援要支援計);
    }

    private boolean is整合性チェック_単位数_NG_21() {

        Decimal 地域密着型介護予防サービス要支援１ = div.getPnlMain().getTbl2().getTextBox630().getValue();
        Decimal 地域密着型介護予防サービス要支援２ = div.getPnlMain().getTbl2().getTextBox631().getValue();
        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl2().getTextBox632().getValue();

        return 入力チェック1(地域密着型介護予防サービス要支援１,
                地域密着型介護予防サービス要支援２, 地域密着型介護予防サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援１ = div.getPnlMain().getTbl2().getTextBox641().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援２ = div.getPnlMain().getTbl2().getTextBox642().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl2().getTextBox643().getValue();

        return 入力チェック1(定期巡回随時対応型訪問介護看護要支援１,
                定期巡回随時対応型訪問介護看護要支援２, 定期巡回随時対応型訪問介護看護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_23() {

        Decimal 夜間対応型訪問介護要支援１ = div.getPnlMain().getTbl2().getTextBox651().getValue();
        Decimal 夜間対応型訪問介護要支援２ = div.getPnlMain().getTbl2().getTextBox652().getValue();
        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl2().getTextBox653().getValue();

        return 入力チェック1(夜間対応型訪問介護要支援１, 夜間対応型訪問介護要支援２, 夜間対応型訪問介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_24() {

        Decimal 認知症対応型通所介護要支援１ = div.getPnlMain().getTbl2().getTextBox661().getValue();
        Decimal 認知症対応型通所介護要支援２ = div.getPnlMain().getTbl2().getTextBox662().getValue();
        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl2().getTextBox663().getValue();

        return 入力チェック1(認知症対応型通所介護要支援１, 認知症対応型通所介護要支援２, 認知症対応型通所介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_25() {

        Decimal 小規模多機能型居宅介護要支援１ = div.getPnlMain().getTbl2().getTextBox672().getValue();
        Decimal 小規模多機能型居宅介護要支援２ = div.getPnlMain().getTbl2().getTextBox673().getValue();
        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl2().getTextBox674().getValue();

        return 入力チェック1(小規模多機能型居宅介護要支援１, 小規模多機能型居宅介護要支援２, 小規模多機能型居宅介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_26() {

        Decimal 認知症対応型共同生活介護要支援１ = div.getPnlMain().getTbl2().getTextBox683().getValue();
        Decimal 認知症対応型共同生活介護要支援２ = div.getPnlMain().getTbl2().getTextBox684().getValue();
        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox685().getValue();

        return 入力チェック1(認知症対応型共同生活介護要支援１,
                認知症対応型共同生活介護要支援２, 認知症対応型共同生活介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl2().getTextBox693().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl2().getTextBox694().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox695().getValue();

        return 入力チェック1(地域密着型特定施設入居者生活介護要支援１,
                地域密着型特定施設入居者生活介護要支援２, 地域密着型特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援１ = div.getPnlMain().getTbl2().getTextBox703().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援２ = div.getPnlMain().getTbl2().getTextBox704().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl2().getTextBox705().getValue();

        return 入力チェック1(地域密着型介護老人福祉施設入所者生活介護要支援１,
                地域密着型介護老人福祉施設入所者生活介護要支援２,
                地域密着型介護老人福祉施設入所者生活介護要支援計);
    }

    private boolean is整合性チェック_単位数_NG_29() {

        Decimal 複合型サービス要支援１ = div.getPnlMain().getTbl2().getTextBox713().getValue();
        Decimal 複合型サービス要支援２ = div.getPnlMain().getTbl2().getTextBox714().getValue();
        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl2().getTextBox715().getValue();

        return 入力チェック1(複合型サービス要支援１, 複合型サービス要支援２, 複合型サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_30() {

        Decimal 施設サービス要支援１ = div.getPnlMain().getTbl2().getTextBox723().getValue();
        Decimal 施設サービス要支援２ = div.getPnlMain().getTbl2().getTextBox724().getValue();
        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl2().getTextBox725().getValue();

        return 入力チェック1(施設サービス要支援１, 施設サービス要支援２, 施設サービス要支援計);
    }

    private boolean is整合性チェック_単位数_NG_31() {

        Decimal 介護老人福祉施設_1_要支援１ = div.getPnlMain().getTbl2().getTextBox734().getValue();
        Decimal 介護老人福祉施設_1_要支援２ = div.getPnlMain().getTbl2().getTextBox735().getValue();
        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl2().getTextBox736().getValue();

        return 入力チェック1(介護老人福祉施設_1_要支援１, 介護老人福祉施設_1_要支援２, 介護老人福祉施設_1_要支援計);
    }

    private boolean is整合性チェック_単位数_NG_32() {

        Decimal 介護老人保健施設_1_要支援１ = div.getPnlMain().getTbl2().getTextBox745().getValue();
        Decimal 介護老人保健施設_1_要支援２ = div.getPnlMain().getTbl2().getTextBox746().getValue();
        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl2().getTextBox747().getValue();

        return 入力チェック1(介護老人保健施設_1_要支援１, 介護老人保健施設_1_要支援２, 介護老人保健施設_1_要支援計);
    }

    private boolean is整合性チェック_単位数_NG_33() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl2().getTextBox755().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl2().getTextBox756().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl2().getTextBox757().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_単位数_NG_34() {

        Decimal 食事提供費用再掲要支援１ = div.getPnlMain().getTbl2().getTextBox765().getValue();
        Decimal 食事提供費用再掲要支援２ = div.getPnlMain().getTbl2().getTextBox766().getValue();
        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl2().getTextBox767().getValue();

        return 入力チェック1(食事提供費用再掲要支援１, 食事提供費用再掲要支援２, 食事提供費用再掲要支援計);
    }

    private boolean is整合性チェック_単位数_NG_35() {

        Decimal 介護老人福祉施設_2_要支援１ = div.getPnlMain().getTbl2().getTextBox776().getValue();
        Decimal 介護老人福祉施設_2_要支援２ = div.getPnlMain().getTbl2().getTextBox777().getValue();
        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl2().getTextBox778().getValue();

        return 入力チェック1(介護老人福祉施設_2_要支援１, 介護老人福祉施設_2_要支援２, 介護老人福祉施設_2_要支援計);
    }

    private boolean is整合性チェック_単位数_NG_36() {

        Decimal 介護老人保健施設_2_要支援１ = div.getPnlMain().getTbl2().getTextBox787().getValue();
        Decimal 介護老人保健施設_2_要支援２ = div.getPnlMain().getTbl2().getTextBox788().getValue();
        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl2().getTextBox789().getValue();

        return 入力チェック1(介護老人保健施設_2_要支援１, 介護老人保健施設_2_要支援２, 介護老人保健施設_2_要支援計);
    }

    private boolean is整合性チェック_単位数_NG_37() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl2().getTextBox797().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl2().getTextBox798().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl2().getTextBox799().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_単位数_NG_38() {

        Decimal 総計要支援１ = div.getPnlMain().getTbl2().getTextBox807().getValue();
        Decimal 総計要支援２ = div.getPnlMain().getTbl2().getTextBox808().getValue();
        Decimal 総計要支援計 = div.getPnlMain().getTbl2().getTextBox809().getValue();

        return 入力チェック1(総計要支援１, 総計要支援２, 総計要支援計);
    }

    private boolean 入力チェック1(Decimal 入力要支援１,
            Decimal 入力要支援２,
            Decimal 入力要支援計) {
        Decimal 要支援１ = 入力要支援１ == null ? Decimal.ZERO : 入力要支援１;
        Decimal 要支援2 = 入力要支援２ == null ? Decimal.ZERO : 入力要支援２;
        Decimal 支援計 = 入力要支援計 == null ? Decimal.ZERO : 入力要支援計;

        return !要支援１.add(要支援2).equals(支援計);
    }

    private boolean 入力チェック2(Decimal 入力経過的要介護,
            Decimal 入力要会護１,
            Decimal 入力要介護２,
            Decimal 入力要介護３,
            Decimal 入力要介護４,
            Decimal 入力要介護５,
            Decimal 入力要介護計) {
        Decimal 経過的要介護 = 入力経過的要介護 == null ? Decimal.ZERO : 入力経過的要介護;
        Decimal 要会護１ = 入力要会護１ == null ? Decimal.ZERO : 入力要会護１;
        Decimal 要介護２ = 入力要介護２ == null ? Decimal.ZERO : 入力要介護２;
        Decimal 要会護３ = 入力要介護３ == null ? Decimal.ZERO : 入力要介護３;
        Decimal 要介護４ = 入力要介護４ == null ? Decimal.ZERO : 入力要介護４;
        Decimal 要会護５ = 入力要介護５ == null ? Decimal.ZERO : 入力要介護５;
        Decimal 要介護計 = 入力要介護計 == null ? Decimal.ZERO : 入力要介護計;

        return !経過的要介護.add(要会護１).add(要介護２).add(要会護３).add(要介護４).add(要会護５).equals(要介護計);
    }

    /**
     * 修正データリストを取得のメソッドます。
     *
     * @param 費用額引き継ぎデータ List<JigyoHokokuTokeiData>
     * @param 事業報告基本データ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get費用額修正データリスト(List<JigyoHokokuTokeiData> 費用額引き継ぎデータ,
            JigyoHokokuGeppoParameter 事業報告基本データ) {

        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト = new ArrayList<>();
        if (事業報告基本データ.get行集計番号().startsWith(費用額総数)) {
            事業報告月報詳細データリスト = 費用額引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(費用額第２号被保険者分再掲)) {
            事業報告月報詳細データリスト = 費用額引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(費用額総数特例分)) {
            事業報告月報詳細データリスト = 費用額引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(費用額第２号被保険者分再掲特例分)) {
            事業報告月報詳細データリスト = 費用額引き継ぎデータ;
        }
        修正データリスト = get事業報告費用額修正データリスト(事業報告月報詳細データリスト, 修正データリスト);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告費用額修正データリスト(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = editor費用額修正データリスト1(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト2(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト3(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト4(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト5(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト6(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト7(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト8(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト9(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor費用額修正データリスト10(事業報告月報詳細データリスト, 修正データリスト);

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト1(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_15,
                div.getPnlMain().getTbl3().getTextBox586().getValue(),
                div.getPnlMain().getTbl3().getTextBox587().getValue(),
                div.getPnlMain().getTbl3().getTextBox588().getValue(),
                div.getPnlMain().getTbl3().getTextBox589().getValue(),
                div.getPnlMain().getTbl3().getTextBox590().getValue(),
                div.getPnlMain().getTbl3().getTextBox591().getValue(),
                div.getPnlMain().getTbl3().getTextBox592().getValue(),
                div.getPnlMain().getTbl3().getTextBox593().getValue(),
                div.getPnlMain().getTbl3().getTextBox594().getValue(),
                div.getPnlMain().getTbl3().getTextBox595().getValue(),
                div.getPnlMain().getTbl3().getTextBox596().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_1,
                div.getPnlMain().getTbl3().getTextBox597().getValue(),
                div.getPnlMain().getTbl3().getTextBox598().getValue(),
                div.getPnlMain().getTbl3().getTextBox599().getValue(),
                div.getPnlMain().getTbl3().getTextBox600().getValue(),
                div.getPnlMain().getTbl3().getTextBox601().getValue(),
                div.getPnlMain().getTbl3().getTextBox602().getValue(),
                div.getPnlMain().getTbl3().getTextBox603().getValue(),
                div.getPnlMain().getTbl3().getTextBox604().getValue(),
                div.getPnlMain().getTbl3().getTextBox605().getValue(),
                div.getPnlMain().getTbl3().getTextBox606().getValue(),
                div.getPnlMain().getTbl3().getTextBox607().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_16,
                div.getPnlMain().getTbl3().getTextBox819().getValue(),
                div.getPnlMain().getTbl3().getTextBox820().getValue(),
                div.getPnlMain().getTbl3().getTextBox821().getValue(),
                div.getPnlMain().getTbl3().getTextBox822().getValue(),
                div.getPnlMain().getTbl3().getTextBox823().getValue(),
                div.getPnlMain().getTbl3().getTextBox824().getValue(),
                div.getPnlMain().getTbl3().getTextBox825().getValue(),
                div.getPnlMain().getTbl3().getTextBox826().getValue(),
                div.getPnlMain().getTbl3().getTextBox827().getValue(),
                div.getPnlMain().getTbl3().getTextBox828().getValue(),
                div.getPnlMain().getTbl3().getTextBox829().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_17,
                div.getPnlMain().getTbl3().getTextBox830().getValue(),
                div.getPnlMain().getTbl3().getTextBox831().getValue(),
                div.getPnlMain().getTbl3().getTextBox832().getValue(),
                div.getPnlMain().getTbl3().getTextBox833().getValue(),
                div.getPnlMain().getTbl3().getTextBox834().getValue(),
                div.getPnlMain().getTbl3().getTextBox835().getValue(),
                div.getPnlMain().getTbl3().getTextBox836().getValue(),
                div.getPnlMain().getTbl3().getTextBox837().getValue(),
                div.getPnlMain().getTbl3().getTextBox838().getValue(),
                div.getPnlMain().getTbl3().getTextBox839().getValue(),
                div.getPnlMain().getTbl3().getTextBox840().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト2(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_18,
                div.getPnlMain().getTbl3().getTextBox841().getValue(),
                div.getPnlMain().getTbl3().getTextBox842().getValue(),
                div.getPnlMain().getTbl3().getTextBox843().getValue(),
                div.getPnlMain().getTbl3().getTextBox844().getValue(),
                div.getPnlMain().getTbl3().getTextBox845().getValue(),
                div.getPnlMain().getTbl3().getTextBox846().getValue(),
                div.getPnlMain().getTbl3().getTextBox847().getValue(),
                div.getPnlMain().getTbl3().getTextBox848().getValue(),
                div.getPnlMain().getTbl3().getTextBox849().getValue(),
                div.getPnlMain().getTbl3().getTextBox850().getValue(),
                div.getPnlMain().getTbl3().getTextBox851().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_19,
                div.getPnlMain().getTbl3().getTextBox852().getValue(),
                div.getPnlMain().getTbl3().getTextBox853().getValue(),
                div.getPnlMain().getTbl3().getTextBox854().getValue(),
                div.getPnlMain().getTbl3().getTextBox855().getValue(),
                div.getPnlMain().getTbl3().getTextBox856().getValue(),
                div.getPnlMain().getTbl3().getTextBox857().getValue(),
                div.getPnlMain().getTbl3().getTextBox858().getValue(),
                div.getPnlMain().getTbl3().getTextBox859().getValue(),
                div.getPnlMain().getTbl3().getTextBox860().getValue(),
                div.getPnlMain().getTbl3().getTextBox861().getValue(),
                div.getPnlMain().getTbl3().getTextBox862().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_26,
                div.getPnlMain().getTbl3().getTextBox863().getValue(),
                div.getPnlMain().getTbl3().getTextBox864().getValue(),
                div.getPnlMain().getTbl3().getTextBox865().getValue(),
                div.getPnlMain().getTbl3().getTextBox866().getValue(),
                div.getPnlMain().getTbl3().getTextBox867().getValue(),
                div.getPnlMain().getTbl3().getTextBox868().getValue(),
                div.getPnlMain().getTbl3().getTextBox869().getValue(),
                div.getPnlMain().getTbl3().getTextBox870().getValue(),
                div.getPnlMain().getTbl3().getTextBox871().getValue(),
                div.getPnlMain().getTbl3().getTextBox872().getValue(),
                div.getPnlMain().getTbl3().getTextBox873().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_30,
                div.getPnlMain().getTbl3().getTextBox874().getValue(),
                div.getPnlMain().getTbl3().getTextBox875().getValue(),
                div.getPnlMain().getTbl3().getTextBox876().getValue(),
                div.getPnlMain().getTbl3().getTextBox877().getValue(),
                div.getPnlMain().getTbl3().getTextBox878().getValue(),
                div.getPnlMain().getTbl3().getTextBox879().getValue(),
                div.getPnlMain().getTbl3().getTextBox880().getValue(),
                div.getPnlMain().getTbl3().getTextBox881().getValue(),
                div.getPnlMain().getTbl3().getTextBox882().getValue(),
                div.getPnlMain().getTbl3().getTextBox883().getValue(),
                div.getPnlMain().getTbl3().getTextBox884().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト3(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_20,
                div.getPnlMain().getTbl3().getTextBox885().getValue(),
                div.getPnlMain().getTbl3().getTextBox886().getValue(),
                div.getPnlMain().getTbl3().getTextBox887().getValue(),
                div.getPnlMain().getTbl3().getTextBox888().getValue(),
                div.getPnlMain().getTbl3().getTextBox889().getValue(),
                div.getPnlMain().getTbl3().getTextBox890().getValue(),
                div.getPnlMain().getTbl3().getTextBox891().getValue(),
                div.getPnlMain().getTbl3().getTextBox892().getValue(),
                div.getPnlMain().getTbl3().getTextBox893().getValue(),
                div.getPnlMain().getTbl3().getTextBox894().getValue(),
                div.getPnlMain().getTbl3().getTextBox895().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_21,
                div.getPnlMain().getTbl3().getTextBox896().getValue(),
                div.getPnlMain().getTbl3().getTextBox897().getValue(),
                div.getPnlMain().getTbl3().getTextBox898().getValue(),
                div.getPnlMain().getTbl3().getTextBox899().getValue(),
                div.getPnlMain().getTbl3().getTextBox900().getValue(),
                div.getPnlMain().getTbl3().getTextBox901().getValue(),
                div.getPnlMain().getTbl3().getTextBox902().getValue(),
                div.getPnlMain().getTbl3().getTextBox903().getValue(),
                div.getPnlMain().getTbl3().getTextBox904().getValue(),
                div.getPnlMain().getTbl3().getTextBox905().getValue(),
                div.getPnlMain().getTbl3().getTextBox906().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_2,
                div.getPnlMain().getTbl3().getTextBox907().getValue(),
                div.getPnlMain().getTbl3().getTextBox908().getValue(),
                div.getPnlMain().getTbl3().getTextBox909().getValue(),
                div.getPnlMain().getTbl3().getTextBox910().getValue(),
                div.getPnlMain().getTbl3().getTextBox911().getValue(),
                div.getPnlMain().getTbl3().getTextBox912().getValue(),
                div.getPnlMain().getTbl3().getTextBox913().getValue(),
                div.getPnlMain().getTbl3().getTextBox914().getValue(),
                div.getPnlMain().getTbl3().getTextBox915().getValue(),
                div.getPnlMain().getTbl3().getTextBox916().getValue(),
                div.getPnlMain().getTbl3().getTextBox917().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_23,
                div.getPnlMain().getTbl3().getTextBox918().getValue(),
                div.getPnlMain().getTbl3().getTextBox919().getValue(),
                div.getPnlMain().getTbl3().getTextBox920().getValue(),
                div.getPnlMain().getTbl3().getTextBox921().getValue(),
                div.getPnlMain().getTbl3().getTextBox922().getValue(),
                div.getPnlMain().getTbl3().getTextBox923().getValue(),
                div.getPnlMain().getTbl3().getTextBox924().getValue(),
                div.getPnlMain().getTbl3().getTextBox925().getValue(),
                div.getPnlMain().getTbl3().getTextBox926().getValue(),
                div.getPnlMain().getTbl3().getTextBox927().getValue(),
                div.getPnlMain().getTbl3().getTextBox928().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト4(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_24,
                div.getPnlMain().getTbl3().getTextBox929().getValue(),
                div.getPnlMain().getTbl3().getTextBox930().getValue(),
                div.getPnlMain().getTbl3().getTextBox931().getValue(),
                div.getPnlMain().getTbl3().getTextBox932().getValue(),
                div.getPnlMain().getTbl3().getTextBox933().getValue(),
                div.getPnlMain().getTbl3().getTextBox934().getValue(),
                div.getPnlMain().getTbl3().getTextBox935().getValue(),
                div.getPnlMain().getTbl3().getTextBox936().getValue(),
                div.getPnlMain().getTbl3().getTextBox937().getValue(),
                div.getPnlMain().getTbl3().getTextBox938().getValue(),
                div.getPnlMain().getTbl3().getTextBox939().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_25,
                div.getPnlMain().getTbl3().getTextBox940().getValue(),
                div.getPnlMain().getTbl3().getTextBox941().getValue(),
                div.getPnlMain().getTbl3().getTextBox942().getValue(),
                div.getPnlMain().getTbl3().getTextBox943().getValue(),
                div.getPnlMain().getTbl3().getTextBox944().getValue(),
                div.getPnlMain().getTbl3().getTextBox945().getValue(),
                div.getPnlMain().getTbl3().getTextBox946().getValue(),
                div.getPnlMain().getTbl3().getTextBox947().getValue(),
                div.getPnlMain().getTbl3().getTextBox948().getValue(),
                div.getPnlMain().getTbl3().getTextBox949().getValue(),
                div.getPnlMain().getTbl3().getTextBox950().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_3,
                div.getPnlMain().getTbl3().getTextBox951().getValue(),
                div.getPnlMain().getTbl3().getTextBox952().getValue(),
                div.getPnlMain().getTbl3().getTextBox953().getValue(),
                div.getPnlMain().getTbl3().getTextBox954().getValue(),
                div.getPnlMain().getTbl3().getTextBox955().getValue(),
                div.getPnlMain().getTbl3().getTextBox956().getValue(),
                div.getPnlMain().getTbl3().getTextBox957().getValue(),
                div.getPnlMain().getTbl3().getTextBox958().getValue(),
                div.getPnlMain().getTbl3().getTextBox959().getValue(),
                div.getPnlMain().getTbl3().getTextBox960().getValue(),
                div.getPnlMain().getTbl3().getTextBox961().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_22,
                div.getPnlMain().getTbl3().getTextBox962().getValue(),
                div.getPnlMain().getTbl3().getTextBox963().getValue(),
                div.getPnlMain().getTbl3().getTextBox964().getValue(),
                div.getPnlMain().getTbl3().getTextBox965().getValue(),
                div.getPnlMain().getTbl3().getTextBox966().getValue(),
                div.getPnlMain().getTbl3().getTextBox967().getValue(),
                div.getPnlMain().getTbl3().getTextBox968().getValue(),
                div.getPnlMain().getTbl3().getTextBox969().getValue(),
                div.getPnlMain().getTbl3().getTextBox970().getValue(),
                div.getPnlMain().getTbl3().getTextBox971().getValue(),
                div.getPnlMain().getTbl3().getTextBox972().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト5(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_4,
                div.getPnlMain().getTbl3().getTextBox973().getValue(),
                div.getPnlMain().getTbl3().getTextBox974().getValue(),
                div.getPnlMain().getTbl3().getTextBox975().getValue(),
                div.getPnlMain().getTbl3().getTextBox976().getValue(),
                div.getPnlMain().getTbl3().getTextBox977().getValue(),
                div.getPnlMain().getTbl3().getTextBox978().getValue(),
                div.getPnlMain().getTbl3().getTextBox979().getValue(),
                div.getPnlMain().getTbl3().getTextBox980().getValue(),
                div.getPnlMain().getTbl3().getTextBox981().getValue(),
                div.getPnlMain().getTbl3().getTextBox982().getValue(),
                div.getPnlMain().getTbl3().getTextBox983().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_5,
                div.getPnlMain().getTbl3().getTextBox984().getValue(),
                div.getPnlMain().getTbl3().getTextBox985().getValue(),
                div.getPnlMain().getTbl3().getTextBox986().getValue(),
                div.getPnlMain().getTbl3().getTextBox987().getValue(),
                div.getPnlMain().getTbl3().getTextBox988().getValue(),
                div.getPnlMain().getTbl3().getTextBox989().getValue(),
                div.getPnlMain().getTbl3().getTextBox990().getValue(),
                div.getPnlMain().getTbl3().getTextBox991().getValue(),
                div.getPnlMain().getTbl3().getTextBox992().getValue(),
                div.getPnlMain().getTbl3().getTextBox993().getValue(),
                div.getPnlMain().getTbl3().getTextBox994().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_28,
                div.getPnlMain().getTbl3().getTextBox995().getValue(),
                div.getPnlMain().getTbl3().getTextBox996().getValue(),
                div.getPnlMain().getTbl3().getTextBox997().getValue(),
                div.getPnlMain().getTbl3().getTextBox998().getValue(),
                div.getPnlMain().getTbl3().getTextBox999().getValue(),
                div.getPnlMain().getTbl3().getTextBox1000().getValue(),
                div.getPnlMain().getTbl3().getTextBox1001().getValue(),
                div.getPnlMain().getTbl3().getTextBox1002().getValue(),
                div.getPnlMain().getTbl3().getTextBox1003().getValue(),
                div.getPnlMain().getTbl3().getTextBox1004().getValue(),
                div.getPnlMain().getTbl3().getTextBox1005().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_29,
                div.getPnlMain().getTbl3().getTextBox1006().getValue(),
                div.getPnlMain().getTbl3().getTextBox1007().getValue(),
                div.getPnlMain().getTbl3().getTextBox1008().getValue(),
                div.getPnlMain().getTbl3().getTextBox1009().getValue(),
                div.getPnlMain().getTbl3().getTextBox1010().getValue(),
                div.getPnlMain().getTbl3().getTextBox1011().getValue(),
                div.getPnlMain().getTbl3().getTextBox1012().getValue(),
                div.getPnlMain().getTbl3().getTextBox1013().getValue(),
                div.getPnlMain().getTbl3().getTextBox1014().getValue(),
                div.getPnlMain().getTbl3().getTextBox1015().getValue(),
                div.getPnlMain().getTbl3().getTextBox1016().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト6(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_31,
                div.getPnlMain().getTbl3().getTextBox1017().getValue(),
                div.getPnlMain().getTbl3().getTextBox1018().getValue(),
                div.getPnlMain().getTbl3().getTextBox1019().getValue(),
                div.getPnlMain().getTbl3().getTextBox1020().getValue(),
                div.getPnlMain().getTbl3().getTextBox1021().getValue(),
                div.getPnlMain().getTbl3().getTextBox1022().getValue(),
                div.getPnlMain().getTbl3().getTextBox1023().getValue(),
                div.getPnlMain().getTbl3().getTextBox1024().getValue(),
                div.getPnlMain().getTbl3().getTextBox1025().getValue(),
                div.getPnlMain().getTbl3().getTextBox1026().getValue(),
                div.getPnlMain().getTbl3().getTextBox1027().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_37,
                div.getPnlMain().getTbl3().getTextBox1028().getValue(),
                div.getPnlMain().getTbl3().getTextBox1029().getValue(),
                div.getPnlMain().getTbl3().getTextBox1030().getValue(),
                div.getPnlMain().getTbl3().getTextBox1031().getValue(),
                div.getPnlMain().getTbl3().getTextBox1032().getValue(),
                div.getPnlMain().getTbl3().getTextBox1033().getValue(),
                div.getPnlMain().getTbl3().getTextBox1034().getValue(),
                div.getPnlMain().getTbl3().getTextBox1035().getValue(),
                div.getPnlMain().getTbl3().getTextBox1036().getValue(),
                div.getPnlMain().getTbl3().getTextBox1037().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_32,
                div.getPnlMain().getTbl3().getTextBox1038().getValue(),
                div.getPnlMain().getTbl3().getTextBox1039().getValue(),
                div.getPnlMain().getTbl3().getTextBox1040().getValue(),
                div.getPnlMain().getTbl3().getTextBox1041().getValue(),
                div.getPnlMain().getTbl3().getTextBox1042().getValue(),
                div.getPnlMain().getTbl3().getTextBox1043().getValue(),
                div.getPnlMain().getTbl3().getTextBox1044().getValue(),
                div.getPnlMain().getTbl3().getTextBox1045().getValue(),
                div.getPnlMain().getTbl3().getTextBox1046().getValue(),
                div.getPnlMain().getTbl3().getTextBox1047().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_33,
                div.getPnlMain().getTbl3().getTextBox1048().getValue(),
                div.getPnlMain().getTbl3().getTextBox1049().getValue(),
                div.getPnlMain().getTbl3().getTextBox1050().getValue(),
                div.getPnlMain().getTbl3().getTextBox1051().getValue(),
                div.getPnlMain().getTbl3().getTextBox1052().getValue(),
                div.getPnlMain().getTbl3().getTextBox1053().getValue(),
                div.getPnlMain().getTbl3().getTextBox1054().getValue(),
                div.getPnlMain().getTbl3().getTextBox1055().getValue(),
                div.getPnlMain().getTbl3().getTextBox1056().getValue(),
                div.getPnlMain().getTbl3().getTextBox1057().getValue(),
                div.getPnlMain().getTbl3().getTextBox1058().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト7(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_34,
                div.getPnlMain().getTbl3().getTextBox1059().getValue(),
                div.getPnlMain().getTbl3().getTextBox1060().getValue(),
                div.getPnlMain().getTbl3().getTextBox1061().getValue(),
                div.getPnlMain().getTbl3().getTextBox1062().getValue(),
                div.getPnlMain().getTbl3().getTextBox1063().getValue(),
                div.getPnlMain().getTbl3().getTextBox1064().getValue(),
                div.getPnlMain().getTbl3().getTextBox1065().getValue(),
                div.getPnlMain().getTbl3().getTextBox1066().getValue(),
                div.getPnlMain().getTbl3().getTextBox1067().getValue(),
                div.getPnlMain().getTbl3().getTextBox1068().getValue(),
                div.getPnlMain().getTbl3().getTextBox1069().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_27,
                div.getPnlMain().getTbl3().getTextBox1070().getValue(),
                div.getPnlMain().getTbl3().getTextBox1071().getValue(),
                div.getPnlMain().getTbl3().getTextBox1072().getValue(),
                div.getPnlMain().getTbl3().getTextBox1073().getValue(),
                div.getPnlMain().getTbl3().getTextBox1074().getValue(),
                div.getPnlMain().getTbl3().getTextBox1075().getValue(),
                div.getPnlMain().getTbl3().getTextBox1076().getValue(),
                div.getPnlMain().getTbl3().getTextBox1077().getValue(),
                div.getPnlMain().getTbl3().getTextBox1078().getValue(),
                div.getPnlMain().getTbl3().getTextBox1079().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_35,
                div.getPnlMain().getTbl3().getTextBox1080().getValue(),
                div.getPnlMain().getTbl3().getTextBox1081().getValue(),
                div.getPnlMain().getTbl3().getTextBox1082().getValue(),
                div.getPnlMain().getTbl3().getTextBox1083().getValue(),
                div.getPnlMain().getTbl3().getTextBox1084().getValue(),
                div.getPnlMain().getTbl3().getTextBox1085().getValue(),
                div.getPnlMain().getTbl3().getTextBox1086().getValue(),
                div.getPnlMain().getTbl3().getTextBox1087().getValue(),
                div.getPnlMain().getTbl3().getTextBox1088().getValue(),
                div.getPnlMain().getTbl3().getTextBox1089().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_36,
                div.getPnlMain().getTbl3().getTextBox1090().getValue(),
                div.getPnlMain().getTbl3().getTextBox1091().getValue(),
                div.getPnlMain().getTbl3().getTextBox1092().getValue(),
                div.getPnlMain().getTbl3().getTextBox1093().getValue(),
                div.getPnlMain().getTbl3().getTextBox1094().getValue(),
                div.getPnlMain().getTbl3().getTextBox1095().getValue(),
                div.getPnlMain().getTbl3().getTextBox1096().getValue(),
                div.getPnlMain().getTbl3().getTextBox1097().getValue(),
                div.getPnlMain().getTbl3().getTextBox1098().getValue(),
                div.getPnlMain().getTbl3().getTextBox1099().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト8(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_38,
                div.getPnlMain().getTbl3().getTextBox1100().getValue(),
                div.getPnlMain().getTbl3().getTextBox1101().getValue(),
                div.getPnlMain().getTbl3().getTextBox1102().getValue(),
                div.getPnlMain().getTbl3().getTextBox1103().getValue(),
                div.getPnlMain().getTbl3().getTextBox1104().getValue(),
                div.getPnlMain().getTbl3().getTextBox1105().getValue(),
                div.getPnlMain().getTbl3().getTextBox1106().getValue(),
                div.getPnlMain().getTbl3().getTextBox1107().getValue(),
                div.getPnlMain().getTbl3().getTextBox1108().getValue(),
                div.getPnlMain().getTbl3().getTextBox1109().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_6,
                div.getPnlMain().getTbl3().getTextBox1110().getValue(),
                div.getPnlMain().getTbl3().getTextBox1111().getValue(),
                div.getPnlMain().getTbl3().getTextBox1112().getValue(),
                div.getPnlMain().getTbl3().getTextBox1113().getValue(),
                div.getPnlMain().getTbl3().getTextBox1114().getValue(),
                div.getPnlMain().getTbl3().getTextBox1115().getValue(),
                div.getPnlMain().getTbl3().getTextBox1116().getValue(),
                div.getPnlMain().getTbl3().getTextBox1117().getValue(),
                div.getPnlMain().getTbl3().getTextBox1118().getValue(),
                div.getPnlMain().getTbl3().getTextBox1119().getValue(),
                div.getPnlMain().getTbl3().getTextBox1120().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_7,
                div.getPnlMain().getTbl3().getTextBox1121().getValue(),
                div.getPnlMain().getTbl3().getTextBox1122().getValue(),
                div.getPnlMain().getTbl3().getTextBox1123().getValue(),
                div.getPnlMain().getTbl3().getTextBox1124().getValue(),
                div.getPnlMain().getTbl3().getTextBox1125().getValue(),
                div.getPnlMain().getTbl3().getTextBox1126().getValue(),
                div.getPnlMain().getTbl3().getTextBox1127().getValue(),
                div.getPnlMain().getTbl3().getTextBox1128().getValue(),
                div.getPnlMain().getTbl3().getTextBox1129().getValue(),
                div.getPnlMain().getTbl3().getTextBox1130().getValue(),
                div.getPnlMain().getTbl3().getTextBox1131().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_8,
                div.getPnlMain().getTbl3().getTextBox1132().getValue(),
                div.getPnlMain().getTbl3().getTextBox1133().getValue(),
                div.getPnlMain().getTbl3().getTextBox1134().getValue(),
                div.getPnlMain().getTbl3().getTextBox1135().getValue(),
                div.getPnlMain().getTbl3().getTextBox1136().getValue(),
                div.getPnlMain().getTbl3().getTextBox1137().getValue(),
                div.getPnlMain().getTbl3().getTextBox1138().getValue(),
                div.getPnlMain().getTbl3().getTextBox1139().getValue(),
                div.getPnlMain().getTbl3().getTextBox1140().getValue(),
                div.getPnlMain().getTbl3().getTextBox1141().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト9(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_9,
                div.getPnlMain().getTbl3().getTextBox1142().getValue(),
                div.getPnlMain().getTbl3().getTextBox1143().getValue(),
                div.getPnlMain().getTbl3().getTextBox1144().getValue(),
                div.getPnlMain().getTbl3().getTextBox1145().getValue(),
                div.getPnlMain().getTbl3().getTextBox1146().getValue(),
                div.getPnlMain().getTbl3().getTextBox1147().getValue(),
                div.getPnlMain().getTbl3().getTextBox1148().getValue(),
                div.getPnlMain().getTbl3().getTextBox1149().getValue(),
                div.getPnlMain().getTbl3().getTextBox1150().getValue(),
                div.getPnlMain().getTbl3().getTextBox1151().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_10,
                div.getPnlMain().getTbl3().getTextBox1152().getValue(),
                div.getPnlMain().getTbl3().getTextBox1153().getValue(),
                div.getPnlMain().getTbl3().getTextBox1154().getValue(),
                div.getPnlMain().getTbl3().getTextBox1155().getValue(),
                div.getPnlMain().getTbl3().getTextBox1156().getValue(),
                div.getPnlMain().getTbl3().getTextBox1157().getValue(),
                div.getPnlMain().getTbl3().getTextBox1158().getValue(),
                div.getPnlMain().getTbl3().getTextBox1159().getValue(),
                div.getPnlMain().getTbl3().getTextBox1160().getValue(),
                div.getPnlMain().getTbl3().getTextBox1161().getValue(),
                div.getPnlMain().getTbl3().getTextBox1162().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_11,
                div.getPnlMain().getTbl3().getTextBox1163().getValue(),
                div.getPnlMain().getTbl3().getTextBox1164().getValue(),
                div.getPnlMain().getTbl3().getTextBox1165().getValue(),
                div.getPnlMain().getTbl3().getTextBox1166().getValue(),
                div.getPnlMain().getTbl3().getTextBox1167().getValue(),
                div.getPnlMain().getTbl3().getTextBox1168().getValue(),
                div.getPnlMain().getTbl3().getTextBox1169().getValue(),
                div.getPnlMain().getTbl3().getTextBox1170().getValue(),
                div.getPnlMain().getTbl3().getTextBox1171().getValue(),
                div.getPnlMain().getTbl3().getTextBox1172().getValue(),
                div.getPnlMain().getTbl3().getTextBox1173().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_12,
                div.getPnlMain().getTbl3().getTextBox1174().getValue(),
                div.getPnlMain().getTbl3().getTextBox1175().getValue(),
                div.getPnlMain().getTbl3().getTextBox1176().getValue(),
                div.getPnlMain().getTbl3().getTextBox1177().getValue(),
                div.getPnlMain().getTbl3().getTextBox1178().getValue(),
                div.getPnlMain().getTbl3().getTextBox1179().getValue(),
                div.getPnlMain().getTbl3().getTextBox1180().getValue(),
                div.getPnlMain().getTbl3().getTextBox1181().getValue(),
                div.getPnlMain().getTbl3().getTextBox1182().getValue(),
                div.getPnlMain().getTbl3().getTextBox1183().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor費用額修正データリスト10(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_13,
                div.getPnlMain().getTbl3().getTextBox1184().getValue(),
                div.getPnlMain().getTbl3().getTextBox1185().getValue(),
                div.getPnlMain().getTbl3().getTextBox1186().getValue(),
                div.getPnlMain().getTbl3().getTextBox1187().getValue(),
                div.getPnlMain().getTbl3().getTextBox1188().getValue(),
                div.getPnlMain().getTbl3().getTextBox1189().getValue(),
                div.getPnlMain().getTbl3().getTextBox1190().getValue(),
                div.getPnlMain().getTbl3().getTextBox1191().getValue(),
                div.getPnlMain().getTbl3().getTextBox1192().getValue(),
                div.getPnlMain().getTbl3().getTextBox1193().getValue());
        修正データリスト = get事業報告修正データ_3(事業報告月報詳細データリスト, 修正データリスト, 縦番号_14,
                div.getPnlMain().getTbl3().getTextBox1194().getValue(),
                div.getPnlMain().getTbl3().getTextBox1195().getValue(),
                div.getPnlMain().getTbl3().getTextBox1196().getValue(),
                div.getPnlMain().getTbl3().getTextBox1197().getValue(),
                div.getPnlMain().getTbl3().getTextBox1198().getValue(),
                div.getPnlMain().getTbl3().getTextBox1199().getValue(),
                div.getPnlMain().getTbl3().getTextBox1200().getValue(),
                div.getPnlMain().getTbl3().getTextBox1201().getValue(),
                div.getPnlMain().getTbl3().getTextBox1202().getValue(),
                div.getPnlMain().getTbl3().getTextBox1203().getValue(),
                div.getPnlMain().getTbl3().getTextBox1204().getValue(),
                div.getPnlMain().getTbl3().getTextBox1205().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_3(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
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

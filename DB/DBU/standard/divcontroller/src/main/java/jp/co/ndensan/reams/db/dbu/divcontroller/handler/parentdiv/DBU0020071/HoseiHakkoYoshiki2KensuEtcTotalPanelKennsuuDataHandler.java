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
public class HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler {

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
    private static final RString 件数総数 = new RString("01");
    private static final RString 件数第２号被保険者分再掲 = new RString("02");
    private static final RString 件数総数特例分 = new RString("03");
    private static final RString 件数第２号被保険者分再掲特例分 = new RString("04");
    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * 修正データリストより、修正データがないかどうかを判断する。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     * @return 判断結果
     */
    public boolean is修正データ無し(List<JigyoHokokuTokeiData> 修正データリスト) {
        return 修正データリスト.isEmpty();
    }

    /**
     * is整合性チェック_NG_件数のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_件数_NG1() {

        return is整合性チェック_件数_NG_整合_件数1_1() || is整合性チェック_件数_NG_整合_件数1_2()
                || is整合性チェック_件数_NG_整合_件数1_3();
    }

    /**
     * is整合性チェック_NG_件数のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_件数_NG2() {

        return is整合性チェック_件数_NG_整合_件数2_1() || is整合性チェック_件数_NG_整合_件数2_2()
                || is整合性チェック_件数_NG_整合_件数2_3();
    }

    private boolean is整合性チェック_件数_NG_整合_件数1_1() {
        return is整合性チェック_件数_NG_1() || is整合性チェック_件数_NG_2()
                || is整合性チェック_件数_NG_3() || is整合性チェック_件数_NG_4()
                || is整合性チェック_件数_NG_5() || is整合性チェック_件数_NG_6()
                || is整合性チェック_件数_NG_7() || is整合性チェック_件数_NG_8()
                || is整合性チェック_件数_NG_9() || is整合性チェック_件数_NG_10()
                || is整合性チェック_件数_NG_11() || is整合性チェック_件数_NG_12()
                || is整合性チェック_件数_NG_13();

    }

    private boolean is整合性チェック_件数_NG_整合_件数1_2() {
        return is整合性チェック_件数_NG_14() || is整合性チェック_件数_NG_15()
                || is整合性チェック_件数_NG_16() || is整合性チェック_件数_NG_17()
                || is整合性チェック_件数_NG_18() || is整合性チェック_件数_NG_19()
                || is整合性チェック_件数_NG_20() || is整合性チェック_件数_NG_21()
                || is整合性チェック_件数_NG_22() || is整合性チェック_件数_NG_23()
                || is整合性チェック_件数_NG_24() || is整合性チェック_件数_NG_25()
                || is整合性チェック_件数_NG_26();
    }

    private boolean is整合性チェック_件数_NG_整合_件数1_3() {
        return is整合性チェック_件数_NG_27() || is整合性チェック_件数_NG_28()
                || is整合性チェック_件数_NG_29() || is整合性チェック_件数_NG_30()
                || is整合性チェック_件数_NG_31() || is整合性チェック_件数_NG_32()
                || is整合性チェック_件数_NG_33() || is整合性チェック_件数_NG_34()
                || is整合性チェック_件数_NG_35() || is整合性チェック_件数_NG_36()
                || is整合性チェック_件数_NG_37() || is整合性チェック_件数_NG_38();
    }

    private boolean is整合性チェック_件数_NG_整合_件数2_1() {
        return is整合性チェック_件数_NG_1_1() || is整合性チェック_件数_NG_1_2()
                || is整合性チェック_件数_NG_1_3() || is整合性チェック_件数_NG_1_4()
                || is整合性チェック_件数_NG_1_5() || is整合性チェック_件数_NG_1_6()
                || is整合性チェック_件数_NG_1_7() || is整合性チェック_件数_NG_1_8()
                || is整合性チェック_件数_NG_1_9() || is整合性チェック_件数_NG_1_10()
                || is整合性チェック_件数_NG_1_11() || is整合性チェック_件数_NG_1_12()
                || is整合性チェック_件数_NG_1_13();

    }

    private boolean is整合性チェック_件数_NG_整合_件数2_2() {
        return is整合性チェック_件数_NG_1_14() || is整合性チェック_件数_NG_1_15()
                || is整合性チェック_件数_NG_1_16() || is整合性チェック_件数_NG_1_17()
                || is整合性チェック_件数_NG_1_18() || is整合性チェック_件数_NG_1_19()
                || is整合性チェック_件数_NG_1_20() || is整合性チェック_件数_NG_1_21()
                || is整合性チェック_件数_NG_1_22() || is整合性チェック_件数_NG_1_23()
                || is整合性チェック_件数_NG_1_24() || is整合性チェック_件数_NG_1_25()
                || is整合性チェック_件数_NG_1_26();
    }

    private boolean is整合性チェック_件数_NG_整合_件数2_3() {
        return is整合性チェック_件数_NG_1_27() || is整合性チェック_件数_NG_1_28()
                || is整合性チェック_件数_NG_1_29() || is整合性チェック_件数_NG_1_30()
                || is整合性チェック_件数_NG_1_31() || is整合性チェック_件数_NG_1_32()
                || is整合性チェック_件数_NG_1_33() || is整合性チェック_件数_NG_1_34()
                || is整合性チェック_件数_NG_1_35() || is整合性チェック_件数_NG_1_36()
                || is整合性チェック_件数_NG_1_37() || is整合性チェック_件数_NG_1_38();
    }

    private boolean is整合性チェック_件数_NG_1_1() {

        Decimal 居宅介護予防サービス経過的要介護 = div.getPnlMain().getTbl1().getTextBox4().getValue();
        Decimal 居宅介護予防サービス要会護１ = div.getPnlMain().getTbl1().getTextBox5().getValue();
        Decimal 居宅介護予防サービス要介護２ = div.getPnlMain().getTbl1().getTextBox6().getValue();
        Decimal 居宅介護予防サービス要介護３ = div.getPnlMain().getTbl1().getTextBox7().getValue();
        Decimal 居宅介護予防サービス要介護４ = div.getPnlMain().getTbl1().getTextBox8().getValue();
        Decimal 居宅介護予防サービス要介護５ = div.getPnlMain().getTbl1().getTextBox9().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl1().getTextBox10().getValue();

        return 入力チェック2(居宅介護予防サービス経過的要介護, 居宅介護予防サービス要会護１,
                居宅介護予防サービス要介護２, 居宅介護予防サービス要介護３,
                居宅介護予防サービス要介護４, 居宅介護予防サービス要介護５, 居宅介護予防サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_2() {

        Decimal 訪問サービス経過的要介護 = div.getPnlMain().getTbl1().getTextBox15().getValue();
        Decimal 訪問サービス要会護１ = div.getPnlMain().getTbl1().getTextBox16().getValue();
        Decimal 訪問サービス要介護２ = div.getPnlMain().getTbl1().getTextBox17().getValue();
        Decimal 訪問サービス要介護３ = div.getPnlMain().getTbl1().getTextBox18().getValue();
        Decimal 訪問サービス要介護４ = div.getPnlMain().getTbl1().getTextBox19().getValue();
        Decimal 訪問サービス要介護５ = div.getPnlMain().getTbl1().getTextBox20().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl1().getTextBox21().getValue();

        return 入力チェック2(訪問サービス経過的要介護, 訪問サービス要会護１,
                訪問サービス要介護２, 訪問サービス要介護３, 訪問サービス要介護４,
                訪問サービス要介護５, 訪問サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_3() {

        Decimal 訪問介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox26().getValue();
        Decimal 訪問介護要会護１ = div.getPnlMain().getTbl1().getTextBox27().getValue();
        Decimal 訪問介護要介護２ = div.getPnlMain().getTbl1().getTextBox28().getValue();
        Decimal 訪問介護要介護３ = div.getPnlMain().getTbl1().getTextBox29().getValue();
        Decimal 訪問介護要介護４ = div.getPnlMain().getTbl1().getTextBox30().getValue();
        Decimal 訪問介護要介護５ = div.getPnlMain().getTbl1().getTextBox31().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl1().getTextBox32().getValue();

        return 入力チェック2(訪問介護経過的要介護, 訪問介護要会護１, 訪問介護要介護２,
                訪問介護要介護３, 訪問介護要介護４, 訪問介護要介護５, 訪問介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_4() {

        Decimal 訪問入浴介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox38().getValue();
        Decimal 訪問入浴介護要会護１ = div.getPnlMain().getTbl1().getTextBox39().getValue();
        Decimal 訪問入浴介護要介護２ = div.getPnlMain().getTbl1().getTextBox40().getValue();
        Decimal 訪問入浴介護要介護３ = div.getPnlMain().getTbl1().getTextBox41().getValue();
        Decimal 訪問入浴介護要介護４ = div.getPnlMain().getTbl1().getTextBox42().getValue();
        Decimal 訪問入浴介護要介護５ = div.getPnlMain().getTbl1().getTextBox43().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl1().getTextBox44().getValue();

        return 入力チェック2(訪問入浴介護経過的要介護, 訪問入浴介護要会護１, 訪問入浴介護要介護２,
                訪問入浴介護要介護３, 訪問入浴介護要介護４, 訪問入浴介護要介護５, 訪問入浴介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_5() {

        Decimal 訪問看護経過的要介護 = div.getPnlMain().getTbl1().getTextBox48().getValue();
        Decimal 訪問看護要会護１ = div.getPnlMain().getTbl1().getTextBox49().getValue();
        Decimal 訪問看護要介護２ = div.getPnlMain().getTbl1().getTextBox50().getValue();
        Decimal 訪問看護要介護３ = div.getPnlMain().getTbl1().getTextBox51().getValue();
        Decimal 訪問看護要介護４ = div.getPnlMain().getTbl1().getTextBox52().getValue();
        Decimal 訪問看護要介護５ = div.getPnlMain().getTbl1().getTextBox53().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl1().getTextBox54().getValue();

        return 入力チェック2(訪問看護経過的要介護, 訪問看護要会護１, 訪問看護要介護２,
                訪問看護要介護３, 訪問看護要介護４, 訪問看護要介護５, 訪問看護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_6() {

        Decimal 訪問リハビリテーション経過的要介護 = div.getPnlMain().getTbl1().getTextBox59().getValue();
        Decimal 訪問リハビリテーション要会護１ = div.getPnlMain().getTbl1().getTextBox60().getValue();
        Decimal 訪問リハビリテーション要介護２ = div.getPnlMain().getTbl1().getTextBox61().getValue();
        Decimal 訪問リハビリテーション要介護３ = div.getPnlMain().getTbl1().getTextBox62().getValue();
        Decimal 訪問リハビリテーション要介護４ = div.getPnlMain().getTbl1().getTextBox63().getValue();
        Decimal 訪問リハビリテーション要介護５ = div.getPnlMain().getTbl1().getTextBox64().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl1().getTextBox65().getValue();

        return 入力チェック2(訪問リハビリテーション経過的要介護,
                訪問リハビリテーション要会護１, 訪問リハビリテーション要介護２,
                訪問リハビリテーション要介護３, 訪問リハビリテーション要介護４,
                訪問リハビリテーション要介護５, 訪問リハビリテーション要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_7() {

        Decimal 居宅療養管理指導経過的要介護 = div.getPnlMain().getTbl1().getTextBox70().getValue();
        Decimal 居宅療養管理指導要会護１ = div.getPnlMain().getTbl1().getTextBox71().getValue();
        Decimal 居宅療養管理指導要介護２ = div.getPnlMain().getTbl1().getTextBox72().getValue();
        Decimal 居宅療養管理指導要介護３ = div.getPnlMain().getTbl1().getTextBox73().getValue();
        Decimal 居宅療養管理指導要介護４ = div.getPnlMain().getTbl1().getTextBox74().getValue();
        Decimal 居宅療養管理指導要介護５ = div.getPnlMain().getTbl1().getTextBox75().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl1().getTextBox76().getValue();

        return 入力チェック2(居宅療養管理指導経過的要介護, 居宅療養管理指導要会護１, 居宅療養管理指導要介護２,
                居宅療養管理指導要介護３, 居宅療養管理指導要介護４, 居宅療養管理指導要介護５, 居宅療養管理指導要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_8() {

        Decimal 通所サービス経過的要介護 = div.getPnlMain().getTbl1().getTextBox81().getValue();
        Decimal 通所サービス要会護１ = div.getPnlMain().getTbl1().getTextBox82().getValue();
        Decimal 通所サービス要介護２ = div.getPnlMain().getTbl1().getTextBox83().getValue();
        Decimal 通所サービス要介護３ = div.getPnlMain().getTbl1().getTextBox84().getValue();
        Decimal 通所サービス要介護４ = div.getPnlMain().getTbl1().getTextBox85().getValue();
        Decimal 通所サービス要介護５ = div.getPnlMain().getTbl1().getTextBox86().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl1().getTextBox87().getValue();

        return 入力チェック2(通所サービス経過的要介護, 通所サービス要会護１, 通所サービス要介護２, 通所サービス要介護３,
                通所サービス要介護４, 通所サービス要介護５, 通所サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_9() {

        Decimal 通所介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox92().getValue();
        Decimal 通所介護要会護１ = div.getPnlMain().getTbl1().getTextBox93().getValue();
        Decimal 通所介護要介護２ = div.getPnlMain().getTbl1().getTextBox94().getValue();
        Decimal 通所介護要介護３ = div.getPnlMain().getTbl1().getTextBox95().getValue();
        Decimal 通所介護要介護４ = div.getPnlMain().getTbl1().getTextBox96().getValue();
        Decimal 通所介護要介護５ = div.getPnlMain().getTbl1().getTextBox97().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl1().getTextBox98().getValue();

        return 入力チェック2(通所介護経過的要介護, 通所介護要会護１,
                通所介護要介護２, 通所介護要介護３, 通所介護要介護４, 通所介護要介護５, 通所介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_10() {

        Decimal 通所リハビリテーション経過的要介護 = div.getPnlMain().getTbl1().getTextBox103().getValue();
        Decimal 通所リハビリテーション要会護１ = div.getPnlMain().getTbl1().getTextBox104().getValue();
        Decimal 通所リハビリテーション要介護２ = div.getPnlMain().getTbl1().getTextBox105().getValue();
        Decimal 通所リハビリテーション要介護３ = div.getPnlMain().getTbl1().getTextBox106().getValue();
        Decimal 通所リハビリテーション要介護４ = div.getPnlMain().getTbl1().getTextBox107().getValue();
        Decimal 通所リハビリテーション要介護５ = div.getPnlMain().getTbl1().getTextBox108().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl1().getTextBox109().getValue();

        return 入力チェック2(通所リハビリテーション経過的要介護,
                通所リハビリテーション要会護１, 通所リハビリテーション要介護２,
                通所リハビリテーション要介護３, 通所リハビリテーション要介護４,
                通所リハビリテーション要介護５, 通所リハビリテーション要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_11() {

        Decimal 短期入所サービス経過的要介護 = div.getPnlMain().getTbl1().getTextBox114().getValue();
        Decimal 短期入所サービス要会護１ = div.getPnlMain().getTbl1().getTextBox115().getValue();
        Decimal 短期入所サービス要介護２ = div.getPnlMain().getTbl1().getTextBox116().getValue();
        Decimal 短期入所サービス要介護３ = div.getPnlMain().getTbl1().getTextBox117().getValue();
        Decimal 短期入所サービス要介護４ = div.getPnlMain().getTbl1().getTextBox118().getValue();
        Decimal 短期入所サービス要介護５ = div.getPnlMain().getTbl1().getTextBox119().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl1().getTextBox120().getValue();

        return 入力チェック2(短期入所サービス経過的要介護, 短期入所サービス要会護１,
                短期入所サービス要介護２, 短期入所サービス要介護３,
                短期入所サービス要介護４, 短期入所サービス要介護５, 短期入所サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_12() {

        Decimal 短期入所生活介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox125().getValue();
        Decimal 短期入所生活介護要会護１ = div.getPnlMain().getTbl1().getTextBox126().getValue();
        Decimal 短期入所生活介護要介護２ = div.getPnlMain().getTbl1().getTextBox127().getValue();
        Decimal 短期入所生活介護要介護３ = div.getPnlMain().getTbl1().getTextBox128().getValue();
        Decimal 短期入所生活介護要介護４ = div.getPnlMain().getTbl1().getTextBox129().getValue();
        Decimal 短期入所生活介護要介護５ = div.getPnlMain().getTbl1().getTextBox130().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox131().getValue();

        return 入力チェック2(短期入所生活介護経過的要介護, 短期入所生活介護要会護１, 短期入所生活介護要介護２,
                短期入所生活介護要介護３, 短期入所生活介護要介護４, 短期入所生活介護要介護５, 短期入所生活介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_13() {

        Decimal 短期入所療養介護介護老人保健施設経過的要介護 = div.getPnlMain().getTbl1().getTextBox136().getValue();
        Decimal 短期入所療養介護介護老人保健施設要会護１ = div.getPnlMain().getTbl1().getTextBox137().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護２ = div.getPnlMain().getTbl1().getTextBox138().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護３ = div.getPnlMain().getTbl1().getTextBox139().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護４ = div.getPnlMain().getTbl1().getTextBox140().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護５ = div.getPnlMain().getTbl1().getTextBox141().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl1().getTextBox142().getValue();

        return 入力チェック2(短期入所療養介護介護老人保健施設経過的要介護, 短期入所療養介護介護老人保健施設要会護１,
                短期入所療養介護介護老人保健施設要介護２, 短期入所療養介護介護老人保健施設要介護３,
                短期入所療養介護介護老人保健施設要介護４, 短期入所療養介護介護老人保健施設要介護５,
                短期入所療養介護介護老人保健施設要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_14() {

        Decimal 短期入所療養介護介護療養型医療施設等経過的要介護 = div.getPnlMain().getTbl1().getTextBox147().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要会護１ = div.getPnlMain().getTbl1().getTextBox148().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護２ = div.getPnlMain().getTbl1().getTextBox149().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護３ = div.getPnlMain().getTbl1().getTextBox150().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護４ = div.getPnlMain().getTbl1().getTextBox151().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護５ = div.getPnlMain().getTbl1().getTextBox152().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl1().getTextBox153().getValue();

        return 入力チェック2(短期入所療養介護介護療養型医療施設等経過的要介護, 短期入所療養介護介護療養型医療施設等要会護１,
                短期入所療養介護介護療養型医療施設等要介護２, 短期入所療養介護介護療養型医療施設等要介護３,
                短期入所療養介護介護療養型医療施設等要介護４, 短期入所療養介護介護療養型医療施設等要介護５,
                短期入所療養介護介護療養型医療施設等要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_15() {

        Decimal 福祉用具住宅改修サービス経過的要介護 = div.getPnlMain().getTbl1().getTextBox158().getValue();
        Decimal 福祉用具住宅改修サービス要会護１ = div.getPnlMain().getTbl1().getTextBox159().getValue();
        Decimal 福祉用具住宅改修サービス要介護２ = div.getPnlMain().getTbl1().getTextBox160().getValue();
        Decimal 福祉用具住宅改修サービス要介護３ = div.getPnlMain().getTbl1().getTextBox161().getValue();
        Decimal 福祉用具住宅改修サービス要介護４ = div.getPnlMain().getTbl1().getTextBox162().getValue();
        Decimal 福祉用具住宅改修サービス要介護５ = div.getPnlMain().getTbl1().getTextBox163().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl1().getTextBox164().getValue();

        return 入力チェック2(福祉用具住宅改修サービス経過的要介護, 福祉用具住宅改修サービス要会護１,
                福祉用具住宅改修サービス要介護２, 福祉用具住宅改修サービス要介護３, 福祉用具住宅改修サービス要介護４,
                福祉用具住宅改修サービス要介護５, 福祉用具住宅改修サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_16() {

        Decimal 福祉用具貸与経過的要介護 = div.getPnlMain().getTbl1().getTextBox169().getValue();
        Decimal 福祉用具貸与要会護１ = div.getPnlMain().getTbl1().getTextBox170().getValue();
        Decimal 福祉用具貸与要介護２ = div.getPnlMain().getTbl1().getTextBox171().getValue();
        Decimal 福祉用具貸与要介護３ = div.getPnlMain().getTbl1().getTextBox172().getValue();
        Decimal 福祉用具貸与要介護４ = div.getPnlMain().getTbl1().getTextBox173().getValue();
        Decimal 福祉用具貸与要介護５ = div.getPnlMain().getTbl1().getTextBox174().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl1().getTextBox175().getValue();

        return 入力チェック2(福祉用具貸与経過的要介護, 福祉用具貸与要会護１, 福祉用具貸与要介護２, 福祉用具貸与要介護３,
                福祉用具貸与要介護４, 福祉用具貸与要介護５, 福祉用具貸与要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_17() {

        Decimal 福祉用具購入費経過的要介護 = div.getPnlMain().getTbl1().getTextBox180().getValue();
        Decimal 福祉用具購入費要会護１ = div.getPnlMain().getTbl1().getTextBox181().getValue();
        Decimal 福祉用具購入費要介護２ = div.getPnlMain().getTbl1().getTextBox182().getValue();
        Decimal 福祉用具購入費要介護３ = div.getPnlMain().getTbl1().getTextBox183().getValue();
        Decimal 福祉用具購入費要介護４ = div.getPnlMain().getTbl1().getTextBox184().getValue();
        Decimal 福祉用具購入費要介護５ = div.getPnlMain().getTbl1().getTextBox185().getValue();
        Decimal 福祉用具購入費要介護計 = div.getPnlMain().getTbl1().getTextBox186().getValue();

        return 入力チェック2(福祉用具購入費経過的要介護, 福祉用具購入費要会護１, 福祉用具購入費要介護２, 福祉用具購入費要介護３,
                福祉用具購入費要介護４, 福祉用具購入費要介護５, 福祉用具購入費要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_18() {

        Decimal 住宅改修費経過的要介護 = div.getPnlMain().getTbl1().getTextBox191().getValue();
        Decimal 住宅改修費要会護１ = div.getPnlMain().getTbl1().getTextBox192().getValue();
        Decimal 住宅改修費要介護２ = div.getPnlMain().getTbl1().getTextBox193().getValue();
        Decimal 住宅改修費要介護３ = div.getPnlMain().getTbl1().getTextBox194().getValue();
        Decimal 住宅改修費要介護４ = div.getPnlMain().getTbl1().getTextBox195().getValue();
        Decimal 住宅改修費要介護５ = div.getPnlMain().getTbl1().getTextBox196().getValue();
        Decimal 住宅改修費要介護計 = div.getPnlMain().getTbl1().getTextBox197().getValue();

        return 入力チェック2(住宅改修費経過的要介護, 住宅改修費要会護１,
                住宅改修費要介護２, 住宅改修費要介護３, 住宅改修費要介護４,
                住宅改修費要介護５, 住宅改修費要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_19() {

        Decimal 特定施設入居者生活介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox202().getValue();
        Decimal 特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl1().getTextBox203().getValue();
        Decimal 特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl1().getTextBox204().getValue();
        Decimal 特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl1().getTextBox205().getValue();
        Decimal 特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl1().getTextBox206().getValue();
        Decimal 特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl1().getTextBox207().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox208().getValue();

        return 入力チェック2(特定施設入居者生活介護経過的要介護,
                特定施設入居者生活介護要会護１, 特定施設入居者生活介護要介護２,
                特定施設入居者生活介護要介護３, 特定施設入居者生活介護要介護４,
                特定施設入居者生活介護要介護５, 特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_20() {

        Decimal 介護予防支援居宅介護支援経過的要介護 = div.getPnlMain().getTbl1().getTextBox213().getValue();
        Decimal 介護予防支援居宅介護支援要会護１ = div.getPnlMain().getTbl1().getTextBox214().getValue();
        Decimal 介護予防支援居宅介護支援要介護２ = div.getPnlMain().getTbl1().getTextBox215().getValue();
        Decimal 介護予防支援居宅介護支援要介護３ = div.getPnlMain().getTbl1().getTextBox216().getValue();
        Decimal 介護予防支援居宅介護支援要介護４ = div.getPnlMain().getTbl1().getTextBox217().getValue();
        Decimal 介護予防支援居宅介護支援要介護５ = div.getPnlMain().getTbl1().getTextBox218().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl1().getTextBox219().getValue();

        return 入力チェック2(介護予防支援居宅介護支援経過的要介護,
                介護予防支援居宅介護支援要会護１, 介護予防支援居宅介護支援要介護２,
                介護予防支援居宅介護支援要介護３, 介護予防支援居宅介護支援要介護４,
                介護予防支援居宅介護支援要介護５, 介護予防支援居宅介護支援要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_21() {

        Decimal 地域密着型介護予防サービス経過的要介護 = div.getPnlMain().getTbl1().getTextBox224().getValue();
        Decimal 地域密着型介護予防サービス要会護１ = div.getPnlMain().getTbl1().getTextBox225().getValue();
        Decimal 地域密着型介護予防サービス要介護２ = div.getPnlMain().getTbl1().getTextBox226().getValue();
        Decimal 地域密着型介護予防サービス要介護３ = div.getPnlMain().getTbl1().getTextBox227().getValue();
        Decimal 地域密着型介護予防サービス要介護４ = div.getPnlMain().getTbl1().getTextBox228().getValue();
        Decimal 地域密着型介護予防サービス要介護５ = div.getPnlMain().getTbl1().getTextBox229().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl1().getTextBox230().getValue();

        return 入力チェック2(地域密着型介護予防サービス経過的要介護,
                地域密着型介護予防サービス要会護１, 地域密着型介護予防サービス要介護２,
                地域密着型介護予防サービス要介護３, 地域密着型介護予防サービス要介護４, 地域密着型介護予防サービス要介護５,
                地域密着型介護予防サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_22() {

        Decimal 定期巡回随時対応型訪問介護看護経過的要介護 = Decimal.ZERO;
        Decimal 定期巡回随時対応型訪問介護看護要会護１ = div.getPnlMain().getTbl1().getTextBox235().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護２ = div.getPnlMain().getTbl1().getTextBox236().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護３ = div.getPnlMain().getTbl1().getTextBox237().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護４ = div.getPnlMain().getTbl1().getTextBox238().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護５ = div.getPnlMain().getTbl1().getTextBox239().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl1().getTextBox240().getValue();

        return 入力チェック2(定期巡回随時対応型訪問介護看護経過的要介護, 定期巡回随時対応型訪問介護看護要会護１,
                定期巡回随時対応型訪問介護看護要介護２, 定期巡回随時対応型訪問介護看護要介護３,
                定期巡回随時対応型訪問介護看護要介護４, 定期巡回随時対応型訪問介護看護要介護５,
                定期巡回随時対応型訪問介護看護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_23() {

        Decimal 夜間対応型訪問介護経過的要介護 = Decimal.ZERO;
        Decimal 夜間対応型訪問介護要会護１ = div.getPnlMain().getTbl1().getTextBox245().getValue();
        Decimal 夜間対応型訪問介護要介護２ = div.getPnlMain().getTbl1().getTextBox246().getValue();
        Decimal 夜間対応型訪問介護要介護３ = div.getPnlMain().getTbl1().getTextBox247().getValue();
        Decimal 夜間対応型訪問介護要介護４ = div.getPnlMain().getTbl1().getTextBox248().getValue();
        Decimal 夜間対応型訪問介護要介護５ = div.getPnlMain().getTbl1().getTextBox249().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl1().getTextBox250().getValue();

        return 入力チェック2(夜間対応型訪問介護経過的要介護, 夜間対応型訪問介護要会護１,
                夜間対応型訪問介護要介護２, 夜間対応型訪問介護要介護３,
                夜間対応型訪問介護要介護４, 夜間対応型訪問介護要介護５, 夜間対応型訪問介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_24() {

        Decimal 認知症対応型通所介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox255().getValue();
        Decimal 認知症対応型通所介護要会護１ = div.getPnlMain().getTbl1().getTextBox256().getValue();
        Decimal 認知症対応型通所介護要介護２ = div.getPnlMain().getTbl1().getTextBox257().getValue();
        Decimal 認知症対応型通所介護要介護３ = div.getPnlMain().getTbl1().getTextBox258().getValue();
        Decimal 認知症対応型通所介護要介護４ = div.getPnlMain().getTbl1().getTextBox259().getValue();
        Decimal 認知症対応型通所介護要介護５ = div.getPnlMain().getTbl1().getTextBox260().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl1().getTextBox261().getValue();

        return 入力チェック2(認知症対応型通所介護経過的要介護, 認知症対応型通所介護要会護１,
                認知症対応型通所介護要介護２, 認知症対応型通所介護要介護３,
                認知症対応型通所介護要介護４, 認知症対応型通所介護要介護５, 認知症対応型通所介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_25() {

        Decimal 小規模多機能型居宅介護経過的要介護 = div.getPnlMain().getTbl1().getTextBox266().getValue();
        Decimal 小規模多機能型居宅介護要会護１ = div.getPnlMain().getTbl1().getTextBox267().getValue();
        Decimal 小規模多機能型居宅介護要介護２ = div.getPnlMain().getTbl1().getTextBox268().getValue();
        Decimal 小規模多機能型居宅介護要介護３ = div.getPnlMain().getTbl1().getTextBox269().getValue();
        Decimal 小規模多機能型居宅介護要介護４ = div.getPnlMain().getTbl1().getTextBox270().getValue();
        Decimal 小規模多機能型居宅介護要介護５ = div.getPnlMain().getTbl1().getTextBox271().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl1().getTextBox272().getValue();

        return 入力チェック2(小規模多機能型居宅介護経過的要介護, 小規模多機能型居宅介護要会護１,
                小規模多機能型居宅介護要介護２, 小規模多機能型居宅介護要介護３, 小規模多機能型居宅介護要介護４,
                小規模多機能型居宅介護要介護５, 小規模多機能型居宅介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_26() {

        Decimal 認知症対応型共同生活介護経過的要介護 = Decimal.ZERO;
        Decimal 認知症対応型共同生活介護要会護１ = div.getPnlMain().getTbl1().getTextBox277().getValue();
        Decimal 認知症対応型共同生活介護要介護２ = div.getPnlMain().getTbl1().getTextBox278().getValue();
        Decimal 認知症対応型共同生活介護要介護３ = div.getPnlMain().getTbl1().getTextBox279().getValue();
        Decimal 認知症対応型共同生活介護要介護４ = div.getPnlMain().getTbl1().getTextBox280().getValue();
        Decimal 認知症対応型共同生活介護要介護５ = div.getPnlMain().getTbl1().getTextBox281().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox282().getValue();

        return 入力チェック2(認知症対応型共同生活介護経過的要介護, 認知症対応型共同生活介護要会護１,
                認知症対応型共同生活介護要介護２, 認知症対応型共同生活介護要介護３, 認知症対応型共同生活介護要介護４,
                認知症対応型共同生活介護要介護５, 認知症対応型共同生活介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_27() {

        Decimal 地域密着型特定施設入居者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl1().getTextBox287().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl1().getTextBox288().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl1().getTextBox289().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl1().getTextBox290().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl1().getTextBox291().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox292().getValue();

        return 入力チェック2(地域密着型特定施設入居者生活介護経過的要介護,
                地域密着型特定施設入居者生活介護要会護１, 地域密着型特定施設入居者生活介護要介護２,
                地域密着型特定施設入居者生活介護要介護３, 地域密着型特定施設入居者生活介護要介護４,
                地域密着型特定施設入居者生活介護要介護５, 地域密着型特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型介護老人福祉施設入所者生活介護要会護１ = div.getPnlMain().getTbl1().getTextBox297().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護２ = div.getPnlMain().getTbl1().getTextBox298().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護３ = div.getPnlMain().getTbl1().getTextBox299().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護４ = div.getPnlMain().getTbl1().getTextBox300().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護５ = div.getPnlMain().getTbl1().getTextBox301().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl1().getTextBox302().getValue();

        return 入力チェック2(地域密着型介護老人福祉施設入所者生活介護経過的要介護,
                地域密着型介護老人福祉施設入所者生活介護要会護１, 地域密着型介護老人福祉施設入所者生活介護要介護２,
                地域密着型介護老人福祉施設入所者生活介護要介護３, 地域密着型介護老人福祉施設入所者生活介護要介護４,
                地域密着型介護老人福祉施設入所者生活介護要介護５, 地域密着型介護老人福祉施設入所者生活介護要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_29() {

        Decimal 複合型サービス経過的要介護 = Decimal.ZERO;
        Decimal 複合型サービス要会護１ = div.getPnlMain().getTbl1().getTextBox307().getValue();
        Decimal 複合型サービス要介護２ = div.getPnlMain().getTbl1().getTextBox308().getValue();
        Decimal 複合型サービス要介護３ = div.getPnlMain().getTbl1().getTextBox309().getValue();
        Decimal 複合型サービス要介護４ = div.getPnlMain().getTbl1().getTextBox310().getValue();
        Decimal 複合型サービス要介護５ = div.getPnlMain().getTbl1().getTextBox311().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl1().getTextBox312().getValue();

        return 入力チェック2(複合型サービス経過的要介護, 複合型サービス要会護１, 複合型サービス要介護２, 複合型サービス要介護３,
                複合型サービス要介護４, 複合型サービス要介護５, 複合型サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_30() {

        Decimal 施設サービス経過的要介護 = Decimal.ZERO;
        Decimal 施設サービス要会護１ = div.getPnlMain().getTbl1().getTextBox318().getValue();
        Decimal 施設サービス要介護２ = div.getPnlMain().getTbl1().getTextBox319().getValue();
        Decimal 施設サービス要介護３ = div.getPnlMain().getTbl1().getTextBox320().getValue();
        Decimal 施設サービス要介護４ = div.getPnlMain().getTbl1().getTextBox321().getValue();
        Decimal 施設サービス要介護５ = div.getPnlMain().getTbl1().getTextBox322().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl1().getTextBox323().getValue();

        return 入力チェック2(施設サービス経過的要介護, 施設サービス要会護１,
                施設サービス要介護２, 施設サービス要介護３, 施設サービス要介護４,
                施設サービス要介護５, 施設サービス要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_31() {

        Decimal 介護老人福祉施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_1_要会護１ = div.getPnlMain().getTbl1().getTextBox329().getValue();
        Decimal 介護老人福祉施設_1_要介護２ = div.getPnlMain().getTbl1().getTextBox330().getValue();
        Decimal 介護老人福祉施設_1_要介護３ = div.getPnlMain().getTbl1().getTextBox331().getValue();
        Decimal 介護老人福祉施設_1_要介護４ = div.getPnlMain().getTbl1().getTextBox332().getValue();
        Decimal 介護老人福祉施設_1_要介護５ = div.getPnlMain().getTbl1().getTextBox333().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl1().getTextBox334().getValue();

        return 入力チェック2(介護老人福祉施設_1_経過的要介護, 介護老人福祉施設_1_要会護１, 介護老人福祉施設_1_要介護２,
                介護老人福祉施設_1_要介護３, 介護老人福祉施設_1_要介護４,
                介護老人福祉施設_1_要介護５, 介護老人福祉施設_1_要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_32() {

        Decimal 介護老人保健施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_1_要会護１ = div.getPnlMain().getTbl1().getTextBox339().getValue();
        Decimal 介護老人保健施設_1_要介護２ = div.getPnlMain().getTbl1().getTextBox340().getValue();
        Decimal 介護老人保健施設_1_要介護３ = div.getPnlMain().getTbl1().getTextBox341().getValue();
        Decimal 介護老人保健施設_1_要介護４ = div.getPnlMain().getTbl1().getTextBox342().getValue();
        Decimal 介護老人保健施設_1_要介護５ = div.getPnlMain().getTbl1().getTextBox343().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl1().getTextBox344().getValue();

        return 入力チェック2(介護老人保健施設_1_経過的要介護, 介護老人保健施設_1_要会護１,
                介護老人保健施設_1_要介護２, 介護老人保健施設_1_要介護３,
                介護老人保健施設_1_要介護４, 介護老人保健施設_1_要介護５, 介護老人保健施設_1_要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_33() {

        Decimal 介護療養型医療施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_1_要会護１ = div.getPnlMain().getTbl1().getTextBox349().getValue();
        Decimal 介護療養型医療施設_1_要介護２ = div.getPnlMain().getTbl1().getTextBox350().getValue();
        Decimal 介護療養型医療施設_1_要介護３ = div.getPnlMain().getTbl1().getTextBox351().getValue();
        Decimal 介護療養型医療施設_1_要介護４ = div.getPnlMain().getTbl1().getTextBox352().getValue();
        Decimal 介護療養型医療施設_1_要介護５ = div.getPnlMain().getTbl1().getTextBox353().getValue();
        Decimal 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl1().getTextBox354().getValue();

        return 入力チェック2(介護療養型医療施設_1_経過的要介護, 介護療養型医療施設_1_要会護１,
                介護療養型医療施設_1_要介護２, 介護療養型医療施設_1_要介護３,
                介護療養型医療施設_1_要介護４, 介護療養型医療施設_1_要介護５, 介護療養型医療施設_1_要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_34() {

        Decimal 食事提供費用再掲経過的要介護 = Decimal.ZERO;
        Decimal 食事提供費用再掲要会護１ = div.getPnlMain().getTbl1().getTextBox360().getValue();
        Decimal 食事提供費用再掲要介護２ = div.getPnlMain().getTbl1().getTextBox361().getValue();
        Decimal 食事提供費用再掲要介護３ = div.getPnlMain().getTbl1().getTextBox362().getValue();
        Decimal 食事提供費用再掲要介護４ = div.getPnlMain().getTbl1().getTextBox363().getValue();
        Decimal 食事提供費用再掲要介護５ = div.getPnlMain().getTbl1().getTextBox364().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl1().getTextBox365().getValue();

        return 入力チェック2(食事提供費用再掲経過的要介護, 食事提供費用再掲要会護１,
                食事提供費用再掲要介護２, 食事提供費用再掲要介護３,
                食事提供費用再掲要介護４, 食事提供費用再掲要介護５, 食事提供費用再掲要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_35() {

        Decimal 介護老人福祉施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_2_要会護１ = div.getPnlMain().getTbl1().getTextBox371().getValue();
        Decimal 介護老人福祉施設_2_要介護２ = div.getPnlMain().getTbl1().getTextBox372().getValue();
        Decimal 介護老人福祉施設_2_要介護３ = div.getPnlMain().getTbl1().getTextBox373().getValue();
        Decimal 介護老人福祉施設_2_要介護４ = div.getPnlMain().getTbl1().getTextBox374().getValue();
        Decimal 介護老人福祉施設_2_要介護５ = div.getPnlMain().getTbl1().getTextBox375().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl1().getTextBox376().getValue();

        return 入力チェック2(介護老人福祉施設_2_経過的要介護, 介護老人福祉施設_2_要会護１,
                介護老人福祉施設_2_要介護２, 介護老人福祉施設_2_要介護３,
                介護老人福祉施設_2_要介護４, 介護老人福祉施設_2_要介護５, 介護老人福祉施設_2_要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_36() {

        Decimal 介護老人保健施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_2_要会護１ = div.getPnlMain().getTbl1().getTextBox381().getValue();
        Decimal 介護老人保健施設_2_要介護２ = div.getPnlMain().getTbl1().getTextBox382().getValue();
        Decimal 介護老人保健施設_2_要介護３ = div.getPnlMain().getTbl1().getTextBox383().getValue();
        Decimal 介護老人保健施設_2_要介護４ = div.getPnlMain().getTbl1().getTextBox384().getValue();
        Decimal 介護老人保健施設_2_要介護５ = div.getPnlMain().getTbl1().getTextBox385().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl1().getTextBox386().getValue();

        return 入力チェック2(介護老人保健施設_2_経過的要介護, 介護老人保健施設_2_要会護１,
                介護老人保健施設_2_要介護２, 介護老人保健施設_2_要介護３,
                介護老人保健施設_2_要介護４, 介護老人保健施設_2_要介護５, 介護老人保健施設_2_要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_37() {

        Decimal 介護療養型医療施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_2_要会護１ = div.getPnlMain().getTbl1().getTextBox391().getValue();
        Decimal 介護療養型医療施設_2_要介護２ = div.getPnlMain().getTbl1().getTextBox392().getValue();
        Decimal 介護療養型医療施設_2_要介護３ = div.getPnlMain().getTbl1().getTextBox393().getValue();
        Decimal 介護療養型医療施設_2_要介護４ = div.getPnlMain().getTbl1().getTextBox394().getValue();
        Decimal 介護療養型医療施設_2_要介護５ = div.getPnlMain().getTbl1().getTextBox395().getValue();
        Decimal 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl1().getTextBox396().getValue();

        return 入力チェック2(介護療養型医療施設_2_経過的要介護, 介護療養型医療施設_2_要会護１,
                介護療養型医療施設_2_要介護２, 介護療養型医療施設_2_要介護３,
                介護療養型医療施設_2_要介護４, 介護療養型医療施設_2_要介護５, 介護療養型医療施設_2_要介護計);
    }

    private boolean is整合性チェック_件数_NG_1_38() {

        Decimal 総計経過的要介護 = div.getPnlMain().getTbl1().getTextBox402().getValue();
        Decimal 総計要会護１ = div.getPnlMain().getTbl1().getTextBox403().getValue();
        Decimal 総計要介護２ = div.getPnlMain().getTbl1().getTextBox404().getValue();
        Decimal 総計要介護３ = div.getPnlMain().getTbl1().getTextBox405().getValue();
        Decimal 総計要介護４ = div.getPnlMain().getTbl1().getTextBox406().getValue();
        Decimal 総計要介護５ = div.getPnlMain().getTbl1().getTextBox407().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl1().getTextBox408().getValue();

        return 入力チェック2(総計経過的要介護, 総計要会護１, 総計要介護２,
                総計要介護３, 総計要介護４, 総計要介護５, 総計要介護計);
    }

    private boolean is整合性チェック_件数_NG_1() {

        Decimal 居宅介護予防サービス要支援１ = div.getPnlMain().getTbl1().getTextBox1().getValue();
        Decimal 居宅介護予防サービス要支援２ = div.getPnlMain().getTbl1().getTextBox2().getValue();
        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl1().getTextBox3().getValue();

        return 入力チェック1(居宅介護予防サービス要支援１, 居宅介護予防サービス要支援２, 居宅介護予防サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_2() {

        Decimal 訪問サービス要支援１ = div.getPnlMain().getTbl1().getTextBox12().getValue();
        Decimal 訪問サービス要支援２ = div.getPnlMain().getTbl1().getTextBox13().getValue();
        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl1().getTextBox14().getValue();

        return 入力チェック1(訪問サービス要支援１, 訪問サービス要支援２, 訪問サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_3() {

        Decimal 訪問介護要支援１ = div.getPnlMain().getTbl1().getTextBox23().getValue();
        Decimal 訪問介護要支援２ = div.getPnlMain().getTbl1().getTextBox24().getValue();
        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl1().getTextBox25().getValue();

        return 入力チェック1(訪問介護要支援１, 訪問介護要支援２, 訪問介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_4() {

        Decimal 訪問入浴介護要支援１ = div.getPnlMain().getTbl1().getTextBox35().getValue();
        Decimal 訪問入浴介護要支援２ = div.getPnlMain().getTbl1().getTextBox36().getValue();
        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl1().getTextBox37().getValue();

        return 入力チェック1(訪問入浴介護要支援１, 訪問入浴介護要支援２, 訪問入浴介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_5() {

        Decimal 訪問看護要支援１ = div.getPnlMain().getTbl1().getTextBox45().getValue();
        Decimal 訪問看護要支援２ = div.getPnlMain().getTbl1().getTextBox46().getValue();
        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl1().getTextBox47().getValue();

        return 入力チェック1(訪問看護要支援１, 訪問看護要支援２, 訪問看護要支援計);
    }

    private boolean is整合性チェック_件数_NG_6() {

        Decimal 訪問リハビリテーション要支援１ = div.getPnlMain().getTbl1().getTextBox56().getValue();
        Decimal 訪問リハビリテーション要支援２ = div.getPnlMain().getTbl1().getTextBox57().getValue();
        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl1().getTextBox58().getValue();

        return 入力チェック1(訪問リハビリテーション要支援１, 訪問リハビリテーション要支援２, 訪問リハビリテーション要支援計);
    }

    private boolean is整合性チェック_件数_NG_7() {

        Decimal 居宅療養管理指導要支援１ = div.getPnlMain().getTbl1().getTextBox67().getValue();
        Decimal 居宅療養管理指導要支援２ = div.getPnlMain().getTbl1().getTextBox68().getValue();
        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl1().getTextBox69().getValue();

        return 入力チェック1(居宅療養管理指導要支援１, 居宅療養管理指導要支援２, 居宅療養管理指導要支援計);
    }

    private boolean is整合性チェック_件数_NG_8() {

        Decimal 通所サービス要支援１ = div.getPnlMain().getTbl1().getTextBox78().getValue();
        Decimal 通所サービス要支援２ = div.getPnlMain().getTbl1().getTextBox79().getValue();
        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl1().getTextBox80().getValue();

        return 入力チェック1(通所サービス要支援１, 通所サービス要支援２, 通所サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_9() {

        Decimal 通所介護要支援１ = div.getPnlMain().getTbl1().getTextBox89().getValue();
        Decimal 通所介護要支援２ = div.getPnlMain().getTbl1().getTextBox90().getValue();
        Decimal 通所介護要支援計 = div.getPnlMain().getTbl1().getTextBox91().getValue();

        return 入力チェック1(通所介護要支援１, 通所介護要支援２, 通所介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_10() {

        Decimal 通所リハビリテーション要支援１ = div.getPnlMain().getTbl1().getTextBox100().getValue();
        Decimal 通所リハビリテーション要支援２ = div.getPnlMain().getTbl1().getTextBox101().getValue();
        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl1().getTextBox102().getValue();

        return 入力チェック1(通所リハビリテーション要支援１, 通所リハビリテーション要支援２, 通所リハビリテーション要支援計);
    }

    private boolean is整合性チェック_件数_NG_11() {

        Decimal 短期入所サービス要支援１ = div.getPnlMain().getTbl1().getTextBox111().getValue();
        Decimal 短期入所サービス要支援２ = div.getPnlMain().getTbl1().getTextBox112().getValue();
        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl1().getTextBox113().getValue();

        return 入力チェック1(短期入所サービス要支援１, 短期入所サービス要支援２, 短期入所サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_12() {

        Decimal 短期入所生活介護要支援１ = div.getPnlMain().getTbl1().getTextBox122().getValue();
        Decimal 短期入所生活介護要支援２ = div.getPnlMain().getTbl1().getTextBox123().getValue();
        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox124().getValue();

        return 入力チェック1(短期入所生活介護要支援１, 短期入所生活介護要支援２, 短期入所生活介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援１ = div.getPnlMain().getTbl1().getTextBox133().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援２ = div.getPnlMain().getTbl1().getTextBox134().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl1().getTextBox135().getValue();

        return 入力チェック1(短期入所療養介護介護老人保健施設要支援１,
                短期入所療養介護介護老人保健施設要支援２, 短期入所療養介護介護老人保健施設要支援計);
    }

    private boolean is整合性チェック_件数_NG_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援１ = div.getPnlMain().getTbl1().getTextBox144().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援２ = div.getPnlMain().getTbl1().getTextBox145().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl1().getTextBox146().getValue();

        return 入力チェック1(短期入所療養介護介護療養型医療施設等要支援１, 短期入所療養介護介護療養型医療施設等要支援２,
                短期入所療養介護介護療養型医療施設等要支援計);
    }

    private boolean is整合性チェック_件数_NG_15() {

        Decimal 福祉用具住宅改修サービス要支援１ = div.getPnlMain().getTbl1().getTextBox155().getValue();
        Decimal 福祉用具住宅改修サービス要支援２ = div.getPnlMain().getTbl1().getTextBox156().getValue();
        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl1().getTextBox157().getValue();

        return 入力チェック1(福祉用具住宅改修サービス要支援１,
                福祉用具住宅改修サービス要支援２, 福祉用具住宅改修サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_16() {

        Decimal 福祉用具貸与要支援１ = div.getPnlMain().getTbl1().getTextBox166().getValue();
        Decimal 福祉用具貸与要支援２ = div.getPnlMain().getTbl1().getTextBox167().getValue();
        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl1().getTextBox168().getValue();

        return 入力チェック1(福祉用具貸与要支援１, 福祉用具貸与要支援２, 福祉用具貸与要支援計);
    }

    private boolean is整合性チェック_件数_NG_17() {

        Decimal 福祉用具購入費要支援１ = div.getPnlMain().getTbl1().getTextBox177().getValue();
        Decimal 福祉用具購入費要支援２ = div.getPnlMain().getTbl1().getTextBox178().getValue();
        Decimal 福祉用具購入費要支援計 = div.getPnlMain().getTbl1().getTextBox179().getValue();

        return 入力チェック1(福祉用具購入費要支援１, 福祉用具購入費要支援２, 福祉用具購入費要支援計);
    }

    private boolean is整合性チェック_件数_NG_18() {

        Decimal 住宅改修費要支援１ = div.getPnlMain().getTbl1().getTextBox188().getValue();
        Decimal 住宅改修費要支援２ = div.getPnlMain().getTbl1().getTextBox189().getValue();
        Decimal 住宅改修費要支援計 = div.getPnlMain().getTbl1().getTextBox190().getValue();

        return 入力チェック1(住宅改修費要支援１, 住宅改修費要支援２, 住宅改修費要支援計);
    }

    private boolean is整合性チェック_件数_NG_19() {

        Decimal 特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl1().getTextBox199().getValue();
        Decimal 特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl1().getTextBox200().getValue();
        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox201().getValue();

        return 入力チェック1(特定施設入居者生活介護要支援１, 特定施設入居者生活介護要支援２, 特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_20() {

        Decimal 介護予防支援居宅介護支援要支援１ = div.getPnlMain().getTbl1().getTextBox210().getValue();
        Decimal 介護予防支援居宅介護支援要支援２ = div.getPnlMain().getTbl1().getTextBox211().getValue();
        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl1().getTextBox212().getValue();

        return 入力チェック1(介護予防支援居宅介護支援要支援１,
                介護予防支援居宅介護支援要支援２, 介護予防支援居宅介護支援要支援計);
    }

    private boolean is整合性チェック_件数_NG_21() {

        Decimal 地域密着型介護予防サービス要支援１ = div.getPnlMain().getTbl1().getTextBox221().getValue();
        Decimal 地域密着型介護予防サービス要支援２ = div.getPnlMain().getTbl1().getTextBox222().getValue();
        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl1().getTextBox223().getValue();

        return 入力チェック1(地域密着型介護予防サービス要支援１,
                地域密着型介護予防サービス要支援２, 地域密着型介護予防サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援１ = div.getPnlMain().getTbl1().getTextBox232().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援２ = div.getPnlMain().getTbl1().getTextBox233().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl1().getTextBox234().getValue();

        return 入力チェック1(定期巡回随時対応型訪問介護看護要支援１,
                定期巡回随時対応型訪問介護看護要支援２, 定期巡回随時対応型訪問介護看護要支援計);
    }

    private boolean is整合性チェック_件数_NG_23() {

        Decimal 夜間対応型訪問介護要支援１ = div.getPnlMain().getTbl1().getTextBox242().getValue();
        Decimal 夜間対応型訪問介護要支援２ = div.getPnlMain().getTbl1().getTextBox243().getValue();
        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl1().getTextBox244().getValue();

        return 入力チェック1(夜間対応型訪問介護要支援１, 夜間対応型訪問介護要支援２, 夜間対応型訪問介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_24() {

        Decimal 認知症対応型通所介護要支援１ = div.getPnlMain().getTbl1().getTextBox252().getValue();
        Decimal 認知症対応型通所介護要支援２ = div.getPnlMain().getTbl1().getTextBox253().getValue();
        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl1().getTextBox254().getValue();

        return 入力チェック1(認知症対応型通所介護要支援１, 認知症対応型通所介護要支援２, 認知症対応型通所介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_25() {

        Decimal 小規模多機能型居宅介護要支援１ = div.getPnlMain().getTbl1().getTextBox263().getValue();
        Decimal 小規模多機能型居宅介護要支援２ = div.getPnlMain().getTbl1().getTextBox264().getValue();
        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl1().getTextBox265().getValue();

        return 入力チェック1(小規模多機能型居宅介護要支援１, 小規模多機能型居宅介護要支援２, 小規模多機能型居宅介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_26() {

        Decimal 認知症対応型共同生活介護要支援１ = div.getPnlMain().getTbl1().getTextBox274().getValue();
        Decimal 認知症対応型共同生活介護要支援２ = div.getPnlMain().getTbl1().getTextBox275().getValue();
        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox276().getValue();

        return 入力チェック1(認知症対応型共同生活介護要支援１,
                認知症対応型共同生活介護要支援２, 認知症対応型共同生活介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl1().getTextBox284().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl1().getTextBox285().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox286().getValue();

        return 入力チェック1(地域密着型特定施設入居者生活介護要支援１,
                地域密着型特定施設入居者生活介護要支援２, 地域密着型特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援１ = div.getPnlMain().getTbl1().getTextBox294().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援２ = div.getPnlMain().getTbl1().getTextBox295().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl1().getTextBox296().getValue();

        return 入力チェック1(地域密着型介護老人福祉施設入所者生活介護要支援１, 地域密着型介護老人福祉施設入所者生活介護要支援２,
                地域密着型介護老人福祉施設入所者生活介護要支援計);
    }

    private boolean is整合性チェック_件数_NG_29() {

        Decimal 複合型サービス要支援１ = div.getPnlMain().getTbl1().getTextBox304().getValue();
        Decimal 複合型サービス要支援２ = div.getPnlMain().getTbl1().getTextBox305().getValue();
        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl1().getTextBox306().getValue();

        return 入力チェック1(複合型サービス要支援１, 複合型サービス要支援２, 複合型サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_30() {

        Decimal 施設サービス要支援１ = div.getPnlMain().getTbl1().getTextBox314().getValue();
        Decimal 施設サービス要支援２ = div.getPnlMain().getTbl1().getTextBox315().getValue();
        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl1().getTextBox316().getValue();

        return 入力チェック1(施設サービス要支援１, 施設サービス要支援２, 施設サービス要支援計);
    }

    private boolean is整合性チェック_件数_NG_31() {

        Decimal 介護老人福祉施設_1_要支援１ = div.getPnlMain().getTbl1().getTextBox325().getValue();
        Decimal 介護老人福祉施設_1_要支援２ = div.getPnlMain().getTbl1().getTextBox326().getValue();
        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl1().getTextBox327().getValue();

        return 入力チェック1(介護老人福祉施設_1_要支援１, 介護老人福祉施設_1_要支援２, 介護老人福祉施設_1_要支援計);
    }

    private boolean is整合性チェック_件数_NG_32() {

        Decimal 介護老人保健施設_1_要支援１ = div.getPnlMain().getTbl1().getTextBox336().getValue();
        Decimal 介護老人保健施設_1_要支援２ = div.getPnlMain().getTbl1().getTextBox337().getValue();
        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl1().getTextBox338().getValue();

        return 入力チェック1(介護老人保健施設_1_要支援１, 介護老人保健施設_1_要支援２, 介護老人保健施設_1_要支援計);
    }

    private boolean is整合性チェック_件数_NG_33() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl1().getTextBox346().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl1().getTextBox347().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl1().getTextBox348().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_件数_NG_34() {

        Decimal 食事提供費用再掲要支援１ = div.getPnlMain().getTbl1().getTextBox356().getValue();
        Decimal 食事提供費用再掲要支援２ = div.getPnlMain().getTbl1().getTextBox357().getValue();
        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl1().getTextBox358().getValue();

        return 入力チェック1(食事提供費用再掲要支援１, 食事提供費用再掲要支援２, 食事提供費用再掲要支援計);
    }

    private boolean is整合性チェック_件数_NG_35() {

        Decimal 介護老人福祉施設_2_要支援１ = div.getPnlMain().getTbl1().getTextBox367().getValue();
        Decimal 介護老人福祉施設_2_要支援２ = div.getPnlMain().getTbl1().getTextBox368().getValue();
        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl1().getTextBox369().getValue();

        return 入力チェック1(介護老人福祉施設_2_要支援１, 介護老人福祉施設_2_要支援２, 介護老人福祉施設_2_要支援計);
    }

    private boolean is整合性チェック_件数_NG_36() {

        Decimal 介護老人保健施設_2_要支援１ = div.getPnlMain().getTbl1().getTextBox378().getValue();
        Decimal 介護老人保健施設_2_要支援２ = div.getPnlMain().getTbl1().getTextBox379().getValue();
        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl1().getTextBox380().getValue();

        return 入力チェック1(介護老人保健施設_2_要支援１, 介護老人保健施設_2_要支援２, 介護老人保健施設_2_要支援計);
    }

    private boolean is整合性チェック_件数_NG_37() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl1().getTextBox388().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl1().getTextBox389().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl1().getTextBox390().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_件数_NG_38() {

        Decimal 総計要支援１ = div.getPnlMain().getTbl1().getTextBox398().getValue();
        Decimal 総計要支援２ = div.getPnlMain().getTbl1().getTextBox399().getValue();
        Decimal 総計要支援計 = div.getPnlMain().getTbl1().getTextBox400().getValue();

        return 入力チェック1(総計要支援１, 総計要支援２, 総計要支援計);
    }

    private boolean 入力チェック1(Decimal 入力要支援１,
            Decimal 入力要支援２,
            Decimal 入力要支援計) {
        Decimal 要支援１ = 入力要支援１ == null ? Decimal.ZERO : 入力要支援１;
        Decimal 要支援２ = 入力要支援２ == null ? Decimal.ZERO : 入力要支援２;
        Decimal 支援計 = 入力要支援計 == null ? Decimal.ZERO : 入力要支援計;

        return !要支援１.add(要支援２).equals(支援計);
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
     * @param 件数引き継ぎデータ List<JigyoHokokuTokeiData>
     * @param 事業報告基本データ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get件数修正データリスト(List<JigyoHokokuTokeiData> 件数引き継ぎデータ,
            JigyoHokokuGeppoParameter 事業報告基本データ) {

        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト = new ArrayList<>();
        if (事業報告基本データ.get行集計番号().startsWith(件数総数)) {
            事業報告月報詳細データリスト = 件数引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(件数第２号被保険者分再掲)) {
            事業報告月報詳細データリスト = 件数引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(件数総数特例分)) {
            事業報告月報詳細データリスト = 件数引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(件数第２号被保険者分再掲特例分)) {
            事業報告月報詳細データリスト = 件数引き継ぎデータ;
        }
        修正データリスト = get事業報告修正データリスト(事業報告月報詳細データリスト, 修正データリスト);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト1(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_15,
                div.getPnlMain().getTbl1().getTextBox1().getValue(),
                div.getPnlMain().getTbl1().getTextBox2().getValue(),
                div.getPnlMain().getTbl1().getTextBox3().getValue(),
                div.getPnlMain().getTbl1().getTextBox4().getValue(),
                div.getPnlMain().getTbl1().getTextBox5().getValue(),
                div.getPnlMain().getTbl1().getTextBox6().getValue(),
                div.getPnlMain().getTbl1().getTextBox7().getValue(),
                div.getPnlMain().getTbl1().getTextBox8().getValue(),
                div.getPnlMain().getTbl1().getTextBox9().getValue(),
                div.getPnlMain().getTbl1().getTextBox10().getValue(),
                div.getPnlMain().getTbl1().getTextBox11().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_1,
                div.getPnlMain().getTbl1().getTextBox12().getValue(),
                div.getPnlMain().getTbl1().getTextBox13().getValue(),
                div.getPnlMain().getTbl1().getTextBox14().getValue(),
                div.getPnlMain().getTbl1().getTextBox15().getValue(),
                div.getPnlMain().getTbl1().getTextBox16().getValue(),
                div.getPnlMain().getTbl1().getTextBox17().getValue(),
                div.getPnlMain().getTbl1().getTextBox18().getValue(),
                div.getPnlMain().getTbl1().getTextBox19().getValue(),
                div.getPnlMain().getTbl1().getTextBox20().getValue(),
                div.getPnlMain().getTbl1().getTextBox21().getValue(),
                div.getPnlMain().getTbl1().getTextBox22().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_16,
                div.getPnlMain().getTbl1().getTextBox23().getValue(),
                div.getPnlMain().getTbl1().getTextBox24().getValue(),
                div.getPnlMain().getTbl1().getTextBox25().getValue(),
                div.getPnlMain().getTbl1().getTextBox26().getValue(),
                div.getPnlMain().getTbl1().getTextBox27().getValue(),
                div.getPnlMain().getTbl1().getTextBox28().getValue(),
                div.getPnlMain().getTbl1().getTextBox29().getValue(),
                div.getPnlMain().getTbl1().getTextBox30().getValue(),
                div.getPnlMain().getTbl1().getTextBox31().getValue(),
                div.getPnlMain().getTbl1().getTextBox32().getValue(),
                div.getPnlMain().getTbl1().getTextBox33().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_17,
                div.getPnlMain().getTbl1().getTextBox35().getValue(),
                div.getPnlMain().getTbl1().getTextBox36().getValue(),
                div.getPnlMain().getTbl1().getTextBox37().getValue(),
                div.getPnlMain().getTbl1().getTextBox38().getValue(),
                div.getPnlMain().getTbl1().getTextBox39().getValue(),
                div.getPnlMain().getTbl1().getTextBox40().getValue(),
                div.getPnlMain().getTbl1().getTextBox41().getValue(),
                div.getPnlMain().getTbl1().getTextBox42().getValue(),
                div.getPnlMain().getTbl1().getTextBox43().getValue(),
                div.getPnlMain().getTbl1().getTextBox44().getValue(),
                div.getPnlMain().getTbl1().getTextBox34().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト2(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_18,
                div.getPnlMain().getTbl1().getTextBox45().getValue(),
                div.getPnlMain().getTbl1().getTextBox46().getValue(),
                div.getPnlMain().getTbl1().getTextBox47().getValue(),
                div.getPnlMain().getTbl1().getTextBox48().getValue(),
                div.getPnlMain().getTbl1().getTextBox49().getValue(),
                div.getPnlMain().getTbl1().getTextBox50().getValue(),
                div.getPnlMain().getTbl1().getTextBox51().getValue(),
                div.getPnlMain().getTbl1().getTextBox52().getValue(),
                div.getPnlMain().getTbl1().getTextBox53().getValue(),
                div.getPnlMain().getTbl1().getTextBox54().getValue(),
                div.getPnlMain().getTbl1().getTextBox55().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_19,
                div.getPnlMain().getTbl1().getTextBox56().getValue(),
                div.getPnlMain().getTbl1().getTextBox57().getValue(),
                div.getPnlMain().getTbl1().getTextBox58().getValue(),
                div.getPnlMain().getTbl1().getTextBox59().getValue(),
                div.getPnlMain().getTbl1().getTextBox60().getValue(),
                div.getPnlMain().getTbl1().getTextBox61().getValue(),
                div.getPnlMain().getTbl1().getTextBox62().getValue(),
                div.getPnlMain().getTbl1().getTextBox63().getValue(),
                div.getPnlMain().getTbl1().getTextBox64().getValue(),
                div.getPnlMain().getTbl1().getTextBox65().getValue(),
                div.getPnlMain().getTbl1().getTextBox66().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_26,
                div.getPnlMain().getTbl1().getTextBox67().getValue(),
                div.getPnlMain().getTbl1().getTextBox68().getValue(),
                div.getPnlMain().getTbl1().getTextBox69().getValue(),
                div.getPnlMain().getTbl1().getTextBox70().getValue(),
                div.getPnlMain().getTbl1().getTextBox71().getValue(),
                div.getPnlMain().getTbl1().getTextBox72().getValue(),
                div.getPnlMain().getTbl1().getTextBox73().getValue(),
                div.getPnlMain().getTbl1().getTextBox74().getValue(),
                div.getPnlMain().getTbl1().getTextBox75().getValue(),
                div.getPnlMain().getTbl1().getTextBox76().getValue(),
                div.getPnlMain().getTbl1().getTextBox77().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_30,
                div.getPnlMain().getTbl1().getTextBox78().getValue(),
                div.getPnlMain().getTbl1().getTextBox79().getValue(),
                div.getPnlMain().getTbl1().getTextBox80().getValue(),
                div.getPnlMain().getTbl1().getTextBox81().getValue(),
                div.getPnlMain().getTbl1().getTextBox82().getValue(),
                div.getPnlMain().getTbl1().getTextBox83().getValue(),
                div.getPnlMain().getTbl1().getTextBox84().getValue(),
                div.getPnlMain().getTbl1().getTextBox85().getValue(),
                div.getPnlMain().getTbl1().getTextBox86().getValue(),
                div.getPnlMain().getTbl1().getTextBox87().getValue(),
                div.getPnlMain().getTbl1().getTextBox88().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト3(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_20,
                div.getPnlMain().getTbl1().getTextBox89().getValue(),
                div.getPnlMain().getTbl1().getTextBox90().getValue(),
                div.getPnlMain().getTbl1().getTextBox91().getValue(),
                div.getPnlMain().getTbl1().getTextBox92().getValue(),
                div.getPnlMain().getTbl1().getTextBox93().getValue(),
                div.getPnlMain().getTbl1().getTextBox94().getValue(),
                div.getPnlMain().getTbl1().getTextBox95().getValue(),
                div.getPnlMain().getTbl1().getTextBox96().getValue(),
                div.getPnlMain().getTbl1().getTextBox97().getValue(),
                div.getPnlMain().getTbl1().getTextBox98().getValue(),
                div.getPnlMain().getTbl1().getTextBox99().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_21,
                div.getPnlMain().getTbl1().getTextBox100().getValue(),
                div.getPnlMain().getTbl1().getTextBox101().getValue(),
                div.getPnlMain().getTbl1().getTextBox102().getValue(),
                div.getPnlMain().getTbl1().getTextBox103().getValue(),
                div.getPnlMain().getTbl1().getTextBox104().getValue(),
                div.getPnlMain().getTbl1().getTextBox105().getValue(),
                div.getPnlMain().getTbl1().getTextBox106().getValue(),
                div.getPnlMain().getTbl1().getTextBox107().getValue(),
                div.getPnlMain().getTbl1().getTextBox108().getValue(),
                div.getPnlMain().getTbl1().getTextBox109().getValue(),
                div.getPnlMain().getTbl1().getTextBox110().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_2,
                div.getPnlMain().getTbl1().getTextBox111().getValue(),
                div.getPnlMain().getTbl1().getTextBox112().getValue(),
                div.getPnlMain().getTbl1().getTextBox113().getValue(),
                div.getPnlMain().getTbl1().getTextBox114().getValue(),
                div.getPnlMain().getTbl1().getTextBox115().getValue(),
                div.getPnlMain().getTbl1().getTextBox116().getValue(),
                div.getPnlMain().getTbl1().getTextBox117().getValue(),
                div.getPnlMain().getTbl1().getTextBox118().getValue(),
                div.getPnlMain().getTbl1().getTextBox119().getValue(),
                div.getPnlMain().getTbl1().getTextBox120().getValue(),
                div.getPnlMain().getTbl1().getTextBox121().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_23,
                div.getPnlMain().getTbl1().getTextBox122().getValue(),
                div.getPnlMain().getTbl1().getTextBox123().getValue(),
                div.getPnlMain().getTbl1().getTextBox124().getValue(),
                div.getPnlMain().getTbl1().getTextBox125().getValue(),
                div.getPnlMain().getTbl1().getTextBox126().getValue(),
                div.getPnlMain().getTbl1().getTextBox127().getValue(),
                div.getPnlMain().getTbl1().getTextBox128().getValue(),
                div.getPnlMain().getTbl1().getTextBox129().getValue(),
                div.getPnlMain().getTbl1().getTextBox130().getValue(),
                div.getPnlMain().getTbl1().getTextBox131().getValue(),
                div.getPnlMain().getTbl1().getTextBox132().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト4(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_24,
                div.getPnlMain().getTbl1().getTextBox133().getValue(),
                div.getPnlMain().getTbl1().getTextBox134().getValue(),
                div.getPnlMain().getTbl1().getTextBox135().getValue(),
                div.getPnlMain().getTbl1().getTextBox136().getValue(),
                div.getPnlMain().getTbl1().getTextBox137().getValue(),
                div.getPnlMain().getTbl1().getTextBox138().getValue(),
                div.getPnlMain().getTbl1().getTextBox139().getValue(),
                div.getPnlMain().getTbl1().getTextBox140().getValue(),
                div.getPnlMain().getTbl1().getTextBox141().getValue(),
                div.getPnlMain().getTbl1().getTextBox142().getValue(),
                div.getPnlMain().getTbl1().getTextBox143().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_25,
                div.getPnlMain().getTbl1().getTextBox144().getValue(),
                div.getPnlMain().getTbl1().getTextBox145().getValue(),
                div.getPnlMain().getTbl1().getTextBox146().getValue(),
                div.getPnlMain().getTbl1().getTextBox147().getValue(),
                div.getPnlMain().getTbl1().getTextBox148().getValue(),
                div.getPnlMain().getTbl1().getTextBox149().getValue(),
                div.getPnlMain().getTbl1().getTextBox150().getValue(),
                div.getPnlMain().getTbl1().getTextBox151().getValue(),
                div.getPnlMain().getTbl1().getTextBox152().getValue(),
                div.getPnlMain().getTbl1().getTextBox153().getValue(),
                div.getPnlMain().getTbl1().getTextBox154().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_3,
                div.getPnlMain().getTbl1().getTextBox155().getValue(),
                div.getPnlMain().getTbl1().getTextBox156().getValue(),
                div.getPnlMain().getTbl1().getTextBox157().getValue(),
                div.getPnlMain().getTbl1().getTextBox158().getValue(),
                div.getPnlMain().getTbl1().getTextBox159().getValue(),
                div.getPnlMain().getTbl1().getTextBox160().getValue(),
                div.getPnlMain().getTbl1().getTextBox161().getValue(),
                div.getPnlMain().getTbl1().getTextBox162().getValue(),
                div.getPnlMain().getTbl1().getTextBox163().getValue(),
                div.getPnlMain().getTbl1().getTextBox164().getValue(),
                div.getPnlMain().getTbl1().getTextBox165().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_22,
                div.getPnlMain().getTbl1().getTextBox166().getValue(),
                div.getPnlMain().getTbl1().getTextBox167().getValue(),
                div.getPnlMain().getTbl1().getTextBox168().getValue(),
                div.getPnlMain().getTbl1().getTextBox169().getValue(),
                div.getPnlMain().getTbl1().getTextBox170().getValue(),
                div.getPnlMain().getTbl1().getTextBox171().getValue(),
                div.getPnlMain().getTbl1().getTextBox172().getValue(),
                div.getPnlMain().getTbl1().getTextBox173().getValue(),
                div.getPnlMain().getTbl1().getTextBox174().getValue(),
                div.getPnlMain().getTbl1().getTextBox175().getValue(),
                div.getPnlMain().getTbl1().getTextBox176().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト5(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_4,
                div.getPnlMain().getTbl1().getTextBox177().getValue(),
                div.getPnlMain().getTbl1().getTextBox178().getValue(),
                div.getPnlMain().getTbl1().getTextBox179().getValue(),
                div.getPnlMain().getTbl1().getTextBox180().getValue(),
                div.getPnlMain().getTbl1().getTextBox181().getValue(),
                div.getPnlMain().getTbl1().getTextBox182().getValue(),
                div.getPnlMain().getTbl1().getTextBox183().getValue(),
                div.getPnlMain().getTbl1().getTextBox184().getValue(),
                div.getPnlMain().getTbl1().getTextBox185().getValue(),
                div.getPnlMain().getTbl1().getTextBox186().getValue(),
                div.getPnlMain().getTbl1().getTextBox187().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_5,
                div.getPnlMain().getTbl1().getTextBox188().getValue(),
                div.getPnlMain().getTbl1().getTextBox189().getValue(),
                div.getPnlMain().getTbl1().getTextBox190().getValue(),
                div.getPnlMain().getTbl1().getTextBox191().getValue(),
                div.getPnlMain().getTbl1().getTextBox192().getValue(),
                div.getPnlMain().getTbl1().getTextBox193().getValue(),
                div.getPnlMain().getTbl1().getTextBox194().getValue(),
                div.getPnlMain().getTbl1().getTextBox195().getValue(),
                div.getPnlMain().getTbl1().getTextBox196().getValue(),
                div.getPnlMain().getTbl1().getTextBox197().getValue(),
                div.getPnlMain().getTbl1().getTextBox198().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_28,
                div.getPnlMain().getTbl1().getTextBox199().getValue(),
                div.getPnlMain().getTbl1().getTextBox200().getValue(),
                div.getPnlMain().getTbl1().getTextBox201().getValue(),
                div.getPnlMain().getTbl1().getTextBox202().getValue(),
                div.getPnlMain().getTbl1().getTextBox203().getValue(),
                div.getPnlMain().getTbl1().getTextBox204().getValue(),
                div.getPnlMain().getTbl1().getTextBox205().getValue(),
                div.getPnlMain().getTbl1().getTextBox206().getValue(),
                div.getPnlMain().getTbl1().getTextBox207().getValue(),
                div.getPnlMain().getTbl1().getTextBox208().getValue(),
                div.getPnlMain().getTbl1().getTextBox209().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_29,
                div.getPnlMain().getTbl1().getTextBox210().getValue(),
                div.getPnlMain().getTbl1().getTextBox211().getValue(),
                div.getPnlMain().getTbl1().getTextBox212().getValue(),
                div.getPnlMain().getTbl1().getTextBox213().getValue(),
                div.getPnlMain().getTbl1().getTextBox214().getValue(),
                div.getPnlMain().getTbl1().getTextBox215().getValue(),
                div.getPnlMain().getTbl1().getTextBox216().getValue(),
                div.getPnlMain().getTbl1().getTextBox217().getValue(),
                div.getPnlMain().getTbl1().getTextBox218().getValue(),
                div.getPnlMain().getTbl1().getTextBox219().getValue(),
                div.getPnlMain().getTbl1().getTextBox220().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト6(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_31,
                div.getPnlMain().getTbl1().getTextBox221().getValue(),
                div.getPnlMain().getTbl1().getTextBox222().getValue(),
                div.getPnlMain().getTbl1().getTextBox223().getValue(),
                div.getPnlMain().getTbl1().getTextBox224().getValue(),
                div.getPnlMain().getTbl1().getTextBox225().getValue(),
                div.getPnlMain().getTbl1().getTextBox226().getValue(),
                div.getPnlMain().getTbl1().getTextBox227().getValue(),
                div.getPnlMain().getTbl1().getTextBox228().getValue(),
                div.getPnlMain().getTbl1().getTextBox229().getValue(),
                div.getPnlMain().getTbl1().getTextBox230().getValue(),
                div.getPnlMain().getTbl1().getTextBox231().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_37,
                div.getPnlMain().getTbl1().getTextBox232().getValue(),
                div.getPnlMain().getTbl1().getTextBox233().getValue(),
                div.getPnlMain().getTbl1().getTextBox234().getValue(),
                div.getPnlMain().getTbl1().getTextBox235().getValue(),
                div.getPnlMain().getTbl1().getTextBox236().getValue(),
                div.getPnlMain().getTbl1().getTextBox237().getValue(),
                div.getPnlMain().getTbl1().getTextBox238().getValue(),
                div.getPnlMain().getTbl1().getTextBox239().getValue(),
                div.getPnlMain().getTbl1().getTextBox240().getValue(),
                div.getPnlMain().getTbl1().getTextBox241().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_32,
                div.getPnlMain().getTbl1().getTextBox242().getValue(),
                div.getPnlMain().getTbl1().getTextBox243().getValue(),
                div.getPnlMain().getTbl1().getTextBox244().getValue(),
                div.getPnlMain().getTbl1().getTextBox245().getValue(),
                div.getPnlMain().getTbl1().getTextBox246().getValue(),
                div.getPnlMain().getTbl1().getTextBox247().getValue(),
                div.getPnlMain().getTbl1().getTextBox248().getValue(),
                div.getPnlMain().getTbl1().getTextBox249().getValue(),
                div.getPnlMain().getTbl1().getTextBox250().getValue(),
                div.getPnlMain().getTbl1().getTextBox251().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_33,
                div.getPnlMain().getTbl1().getTextBox252().getValue(),
                div.getPnlMain().getTbl1().getTextBox253().getValue(),
                div.getPnlMain().getTbl1().getTextBox254().getValue(),
                div.getPnlMain().getTbl1().getTextBox255().getValue(),
                div.getPnlMain().getTbl1().getTextBox256().getValue(),
                div.getPnlMain().getTbl1().getTextBox257().getValue(),
                div.getPnlMain().getTbl1().getTextBox258().getValue(),
                div.getPnlMain().getTbl1().getTextBox259().getValue(),
                div.getPnlMain().getTbl1().getTextBox260().getValue(),
                div.getPnlMain().getTbl1().getTextBox261().getValue(),
                div.getPnlMain().getTbl1().getTextBox262().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト7(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_34,
                div.getPnlMain().getTbl1().getTextBox263().getValue(),
                div.getPnlMain().getTbl1().getTextBox264().getValue(),
                div.getPnlMain().getTbl1().getTextBox265().getValue(),
                div.getPnlMain().getTbl1().getTextBox266().getValue(),
                div.getPnlMain().getTbl1().getTextBox267().getValue(),
                div.getPnlMain().getTbl1().getTextBox268().getValue(),
                div.getPnlMain().getTbl1().getTextBox269().getValue(),
                div.getPnlMain().getTbl1().getTextBox270().getValue(),
                div.getPnlMain().getTbl1().getTextBox271().getValue(),
                div.getPnlMain().getTbl1().getTextBox272().getValue(),
                div.getPnlMain().getTbl1().getTextBox273().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_27,
                div.getPnlMain().getTbl1().getTextBox274().getValue(),
                div.getPnlMain().getTbl1().getTextBox275().getValue(),
                div.getPnlMain().getTbl1().getTextBox276().getValue(),
                div.getPnlMain().getTbl1().getTextBox277().getValue(),
                div.getPnlMain().getTbl1().getTextBox278().getValue(),
                div.getPnlMain().getTbl1().getTextBox279().getValue(),
                div.getPnlMain().getTbl1().getTextBox280().getValue(),
                div.getPnlMain().getTbl1().getTextBox281().getValue(),
                div.getPnlMain().getTbl1().getTextBox282().getValue(),
                div.getPnlMain().getTbl1().getTextBox283().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_35,
                div.getPnlMain().getTbl1().getTextBox284().getValue(),
                div.getPnlMain().getTbl1().getTextBox285().getValue(),
                div.getPnlMain().getTbl1().getTextBox286().getValue(),
                div.getPnlMain().getTbl1().getTextBox287().getValue(),
                div.getPnlMain().getTbl1().getTextBox288().getValue(),
                div.getPnlMain().getTbl1().getTextBox289().getValue(),
                div.getPnlMain().getTbl1().getTextBox290().getValue(),
                div.getPnlMain().getTbl1().getTextBox291().getValue(),
                div.getPnlMain().getTbl1().getTextBox292().getValue(),
                div.getPnlMain().getTbl1().getTextBox293().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_36,
                div.getPnlMain().getTbl1().getTextBox294().getValue(),
                div.getPnlMain().getTbl1().getTextBox295().getValue(),
                div.getPnlMain().getTbl1().getTextBox296().getValue(),
                div.getPnlMain().getTbl1().getTextBox297().getValue(),
                div.getPnlMain().getTbl1().getTextBox298().getValue(),
                div.getPnlMain().getTbl1().getTextBox299().getValue(),
                div.getPnlMain().getTbl1().getTextBox300().getValue(),
                div.getPnlMain().getTbl1().getTextBox301().getValue(),
                div.getPnlMain().getTbl1().getTextBox302().getValue(),
                div.getPnlMain().getTbl1().getTextBox303().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト8(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_38,
                div.getPnlMain().getTbl1().getTextBox304().getValue(),
                div.getPnlMain().getTbl1().getTextBox305().getValue(),
                div.getPnlMain().getTbl1().getTextBox306().getValue(),
                div.getPnlMain().getTbl1().getTextBox307().getValue(),
                div.getPnlMain().getTbl1().getTextBox308().getValue(),
                div.getPnlMain().getTbl1().getTextBox309().getValue(),
                div.getPnlMain().getTbl1().getTextBox310().getValue(),
                div.getPnlMain().getTbl1().getTextBox311().getValue(),
                div.getPnlMain().getTbl1().getTextBox312().getValue(),
                div.getPnlMain().getTbl1().getTextBox313().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_6,
                div.getPnlMain().getTbl1().getTextBox314().getValue(),
                div.getPnlMain().getTbl1().getTextBox315().getValue(),
                div.getPnlMain().getTbl1().getTextBox316().getValue(),
                div.getPnlMain().getTbl1().getTextBox317().getValue(),
                div.getPnlMain().getTbl1().getTextBox318().getValue(),
                div.getPnlMain().getTbl1().getTextBox319().getValue(),
                div.getPnlMain().getTbl1().getTextBox320().getValue(),
                div.getPnlMain().getTbl1().getTextBox321().getValue(),
                div.getPnlMain().getTbl1().getTextBox322().getValue(),
                div.getPnlMain().getTbl1().getTextBox323().getValue(),
                div.getPnlMain().getTbl1().getTextBox324().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_7,
                div.getPnlMain().getTbl1().getTextBox325().getValue(),
                div.getPnlMain().getTbl1().getTextBox326().getValue(),
                div.getPnlMain().getTbl1().getTextBox327().getValue(),
                div.getPnlMain().getTbl1().getTextBox328().getValue(),
                div.getPnlMain().getTbl1().getTextBox329().getValue(),
                div.getPnlMain().getTbl1().getTextBox330().getValue(),
                div.getPnlMain().getTbl1().getTextBox331().getValue(),
                div.getPnlMain().getTbl1().getTextBox332().getValue(),
                div.getPnlMain().getTbl1().getTextBox333().getValue(),
                div.getPnlMain().getTbl1().getTextBox334().getValue(),
                div.getPnlMain().getTbl1().getTextBox335().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_8,
                div.getPnlMain().getTbl1().getTextBox336().getValue(),
                div.getPnlMain().getTbl1().getTextBox337().getValue(),
                div.getPnlMain().getTbl1().getTextBox338().getValue(),
                div.getPnlMain().getTbl1().getTextBox339().getValue(),
                div.getPnlMain().getTbl1().getTextBox340().getValue(),
                div.getPnlMain().getTbl1().getTextBox341().getValue(),
                div.getPnlMain().getTbl1().getTextBox342().getValue(),
                div.getPnlMain().getTbl1().getTextBox343().getValue(),
                div.getPnlMain().getTbl1().getTextBox344().getValue(),
                div.getPnlMain().getTbl1().getTextBox345().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト9(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_9,
                div.getPnlMain().getTbl1().getTextBox346().getValue(),
                div.getPnlMain().getTbl1().getTextBox347().getValue(),
                div.getPnlMain().getTbl1().getTextBox348().getValue(),
                div.getPnlMain().getTbl1().getTextBox349().getValue(),
                div.getPnlMain().getTbl1().getTextBox350().getValue(),
                div.getPnlMain().getTbl1().getTextBox351().getValue(),
                div.getPnlMain().getTbl1().getTextBox352().getValue(),
                div.getPnlMain().getTbl1().getTextBox353().getValue(),
                div.getPnlMain().getTbl1().getTextBox354().getValue(),
                div.getPnlMain().getTbl1().getTextBox355().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_10,
                div.getPnlMain().getTbl1().getTextBox356().getValue(),
                div.getPnlMain().getTbl1().getTextBox357().getValue(),
                div.getPnlMain().getTbl1().getTextBox358().getValue(),
                div.getPnlMain().getTbl1().getTextBox359().getValue(),
                div.getPnlMain().getTbl1().getTextBox360().getValue(),
                div.getPnlMain().getTbl1().getTextBox361().getValue(),
                div.getPnlMain().getTbl1().getTextBox362().getValue(),
                div.getPnlMain().getTbl1().getTextBox363().getValue(),
                div.getPnlMain().getTbl1().getTextBox364().getValue(),
                div.getPnlMain().getTbl1().getTextBox365().getValue(),
                div.getPnlMain().getTbl1().getTextBox366().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_11,
                div.getPnlMain().getTbl1().getTextBox367().getValue(),
                div.getPnlMain().getTbl1().getTextBox368().getValue(),
                div.getPnlMain().getTbl1().getTextBox369().getValue(),
                div.getPnlMain().getTbl1().getTextBox370().getValue(),
                div.getPnlMain().getTbl1().getTextBox371().getValue(),
                div.getPnlMain().getTbl1().getTextBox372().getValue(),
                div.getPnlMain().getTbl1().getTextBox373().getValue(),
                div.getPnlMain().getTbl1().getTextBox374().getValue(),
                div.getPnlMain().getTbl1().getTextBox375().getValue(),
                div.getPnlMain().getTbl1().getTextBox376().getValue(),
                div.getPnlMain().getTbl1().getTextBox377().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_12,
                div.getPnlMain().getTbl1().getTextBox378().getValue(),
                div.getPnlMain().getTbl1().getTextBox379().getValue(),
                div.getPnlMain().getTbl1().getTextBox380().getValue(),
                div.getPnlMain().getTbl1().getTextBox381().getValue(),
                div.getPnlMain().getTbl1().getTextBox382().getValue(),
                div.getPnlMain().getTbl1().getTextBox383().getValue(),
                div.getPnlMain().getTbl1().getTextBox384().getValue(),
                div.getPnlMain().getTbl1().getTextBox385().getValue(),
                div.getPnlMain().getTbl1().getTextBox386().getValue(),
                div.getPnlMain().getTbl1().getTextBox387().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor修正データリスト10(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_13,
                div.getPnlMain().getTbl1().getTextBox388().getValue(),
                div.getPnlMain().getTbl1().getTextBox389().getValue(),
                div.getPnlMain().getTbl1().getTextBox390().getValue(),
                div.getPnlMain().getTbl1().getTextBox391().getValue(),
                div.getPnlMain().getTbl1().getTextBox392().getValue(),
                div.getPnlMain().getTbl1().getTextBox393().getValue(),
                div.getPnlMain().getTbl1().getTextBox394().getValue(),
                div.getPnlMain().getTbl1().getTextBox395().getValue(),
                div.getPnlMain().getTbl1().getTextBox396().getValue(),
                div.getPnlMain().getTbl1().getTextBox397().getValue());
        修正データリスト = get事業報告修正データ_3(事業報告月報詳細データリスト, 修正データリスト, 縦番号_14,
                div.getPnlMain().getTbl1().getTextBox398().getValue(),
                div.getPnlMain().getTbl1().getTextBox399().getValue(),
                div.getPnlMain().getTbl1().getTextBox400().getValue(),
                div.getPnlMain().getTbl1().getTextBox401().getValue(),
                div.getPnlMain().getTbl1().getTextBox402().getValue(),
                div.getPnlMain().getTbl1().getTextBox403().getValue(),
                div.getPnlMain().getTbl1().getTextBox404().getValue(),
                div.getPnlMain().getTbl1().getTextBox405().getValue(),
                div.getPnlMain().getTbl1().getTextBox406().getValue(),
                div.getPnlMain().getTbl1().getTextBox407().getValue(),
                div.getPnlMain().getTbl1().getTextBox408().getValue(),
                div.getPnlMain().getTbl1().getTextBox409().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データリスト(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
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

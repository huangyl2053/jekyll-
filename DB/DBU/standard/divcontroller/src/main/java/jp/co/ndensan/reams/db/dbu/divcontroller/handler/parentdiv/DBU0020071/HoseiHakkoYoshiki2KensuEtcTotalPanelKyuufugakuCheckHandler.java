/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告（月報）補正発行_様式２費用額、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuCheckHandler {

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuCheckHandler(
            HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * is整合性チェック_NG_給付額のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_給付額_NG1() {

        return is整合性チェック_給付額_NG_整合_給付額1_1() || is整合性チェック_給付額_NG_整合_給付額1_2()
                || is整合性チェック_給付額_NG_整合_給付額1_3();
    }

    /**
     * is整合性チェック_NG_給付額のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_給付額_NG2() {

        return is整合性チェック_給付額_NG_整合_給付額2_1() || is整合性チェック_給付額_NG_整合_給付額2_2()
                || is整合性チェック_給付額_NG_整合_給付額2_3();
    }

    private boolean is整合性チェック_給付額_NG_整合_給付額1_1() {
        return is整合性チェック_給付額_NG_1() || is整合性チェック_給付額_NG_2()
                || is整合性チェック_給付額_NG_3() || is整合性チェック_給付額_NG_4()
                || is整合性チェック_給付額_NG_5() || is整合性チェック_給付額_NG_6()
                || is整合性チェック_給付額_NG_7() || is整合性チェック_給付額_NG_8()
                || is整合性チェック_給付額_NG_9() || is整合性チェック_給付額_NG_10()
                || is整合性チェック_給付額_NG_11() || is整合性チェック_給付額_NG_12()
                || is整合性チェック_給付額_NG_13();

    }

    private boolean is整合性チェック_給付額_NG_整合_給付額1_2() {
        return is整合性チェック_給付額_NG_14() || is整合性チェック_給付額_NG_15()
                || is整合性チェック_給付額_NG_16() || is整合性チェック_給付額_NG_17()
                || is整合性チェック_給付額_NG_18() || is整合性チェック_給付額_NG_19()
                || is整合性チェック_給付額_NG_20() || is整合性チェック_給付額_NG_21()
                || is整合性チェック_給付額_NG_22() || is整合性チェック_給付額_NG_23()
                || is整合性チェック_給付額_NG_24() || is整合性チェック_給付額_NG_25()
                || is整合性チェック_給付額_NG_26();
    }

    private boolean is整合性チェック_給付額_NG_整合_給付額1_3() {
        return is整合性チェック_給付額_NG_27() || is整合性チェック_給付額_NG_28()
                || is整合性チェック_給付額_NG_29() || is整合性チェック_給付額_NG_30()
                || is整合性チェック_給付額_NG_31() || is整合性チェック_給付額_NG_32()
                || is整合性チェック_給付額_NG_33() || is整合性チェック_給付額_NG_34()
                || is整合性チェック_給付額_NG_35() || is整合性チェック_給付額_NG_36()
                || is整合性チェック_給付額_NG_37() || is整合性チェック_給付額_NG_38();
    }

    private boolean is整合性チェック_給付額_NG_整合_給付額2_1() {
        return is整合性チェック_給付額_NG_1_1() || is整合性チェック_給付額_NG_1_2()
                || is整合性チェック_給付額_NG_1_3() || is整合性チェック_給付額_NG_1_4()
                || is整合性チェック_給付額_NG_1_5() || is整合性チェック_給付額_NG_1_6()
                || is整合性チェック_給付額_NG_1_7() || is整合性チェック_給付額_NG_1_8()
                || is整合性チェック_給付額_NG_1_9() || is整合性チェック_給付額_NG_1_10()
                || is整合性チェック_給付額_NG_1_11() || is整合性チェック_給付額_NG_1_12()
                || is整合性チェック_給付額_NG_1_13();

    }

    private boolean is整合性チェック_給付額_NG_整合_給付額2_2() {
        return is整合性チェック_給付額_NG_1_14() || is整合性チェック_給付額_NG_1_15()
                || is整合性チェック_給付額_NG_1_16() || is整合性チェック_給付額_NG_1_17()
                || is整合性チェック_給付額_NG_1_18() || is整合性チェック_給付額_NG_1_19()
                || is整合性チェック_給付額_NG_1_20() || is整合性チェック_給付額_NG_1_21()
                || is整合性チェック_給付額_NG_1_22() || is整合性チェック_給付額_NG_1_23()
                || is整合性チェック_給付額_NG_1_24() || is整合性チェック_給付額_NG_1_25()
                || is整合性チェック_給付額_NG_1_26();
    }

    private boolean is整合性チェック_給付額_NG_整合_給付額2_3() {
        return is整合性チェック_給付額_NG_1_27() || is整合性チェック_給付額_NG_1_28()
                || is整合性チェック_給付額_NG_1_29() || is整合性チェック_給付額_NG_1_30()
                || is整合性チェック_給付額_NG_1_31() || is整合性チェック_給付額_NG_1_32()
                || is整合性チェック_給付額_NG_1_33() || is整合性チェック_給付額_NG_1_34()
                || is整合性チェック_給付額_NG_1_35() || is整合性チェック_給付額_NG_1_36()
                || is整合性チェック_給付額_NG_1_37() || is整合性チェック_給付額_NG_1_38();
    }

    private boolean is整合性チェック_給付額_NG_1_1() {

        RString 居宅介護予防サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1209().getValue();
        RString 居宅介護予防サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1210().getValue();
        RString 居宅介護予防サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1211().getValue();
        RString 居宅介護予防サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1212().getValue();
        RString 居宅介護予防サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1213().getValue();
        RString 居宅介護予防サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1214().getValue();
        RString 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1215().getValue();

        return 入力チェック2(居宅介護予防サービス経過的要介護,
                居宅介護予防サービス要会護１, 居宅介護予防サービス要介護２, 居宅介護予防サービス要介護３,
                居宅介護予防サービス要介護４, 居宅介護予防サービス要介護５, 居宅介護予防サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_2() {

        RString 訪問サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1220().getValue();
        RString 訪問サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1221().getValue();
        RString 訪問サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1222().getValue();
        RString 訪問サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1223().getValue();
        RString 訪問サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1224().getValue();
        RString 訪問サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1225().getValue();
        RString 訪問サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1226().getValue();

        return 入力チェック2(訪問サービス経過的要介護, 訪問サービス要会護１,
                訪問サービス要介護２, 訪問サービス要介護３, 訪問サービス要介護４,
                訪問サービス要介護５, 訪問サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_3() {

        RString 訪問介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1231().getValue();
        RString 訪問介護要会護１ = div.getPnlMain().getTbl4().getTextBox1232().getValue();
        RString 訪問介護要介護２ = div.getPnlMain().getTbl4().getTextBox1233().getValue();
        RString 訪問介護要介護３ = div.getPnlMain().getTbl4().getTextBox1234().getValue();
        RString 訪問介護要介護４ = div.getPnlMain().getTbl4().getTextBox1235().getValue();
        RString 訪問介護要介護５ = div.getPnlMain().getTbl4().getTextBox1236().getValue();
        RString 訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1237().getValue();

        return 入力チェック2(訪問介護経過的要介護, 訪問介護要会護１, 訪問介護要介護２,
                訪問介護要介護３, 訪問介護要介護４, 訪問介護要介護５, 訪問介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_4() {

        RString 訪問入浴介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1242().getValue();
        RString 訪問入浴介護要会護１ = div.getPnlMain().getTbl4().getTextBox1243().getValue();
        RString 訪問入浴介護要介護２ = div.getPnlMain().getTbl4().getTextBox1244().getValue();
        RString 訪問入浴介護要介護３ = div.getPnlMain().getTbl4().getTextBox1245().getValue();
        RString 訪問入浴介護要介護４ = div.getPnlMain().getTbl4().getTextBox1246().getValue();
        RString 訪問入浴介護要介護５ = div.getPnlMain().getTbl4().getTextBox1247().getValue();
        RString 訪問入浴介護要介護計 = div.getPnlMain().getTbl4().getTextBox1248().getValue();

        return 入力チェック2(訪問入浴介護経過的要介護, 訪問入浴介護要会護１, 訪問入浴介護要介護２,
                訪問入浴介護要介護３, 訪問入浴介護要介護４, 訪問入浴介護要介護５, 訪問入浴介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_5() {

        RString 訪問看護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1253().getValue();
        RString 訪問看護要会護１ = div.getPnlMain().getTbl4().getTextBox1254().getValue();
        RString 訪問看護要介護２ = div.getPnlMain().getTbl4().getTextBox1255().getValue();
        RString 訪問看護要介護３ = div.getPnlMain().getTbl4().getTextBox1256().getValue();
        RString 訪問看護要介護４ = div.getPnlMain().getTbl4().getTextBox1257().getValue();
        RString 訪問看護要介護５ = div.getPnlMain().getTbl4().getTextBox1258().getValue();
        RString 訪問看護要介護計 = div.getPnlMain().getTbl4().getTextBox1259().getValue();

        return 入力チェック2(訪問看護経過的要介護, 訪問看護要会護１, 訪問看護要介護２,
                訪問看護要介護３, 訪問看護要介護４, 訪問看護要介護５, 訪問看護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_6() {

        RString 訪問リハビリテーション経過的要介護 = div.getPnlMain().getTbl4().getTextBox1264().getValue();
        RString 訪問リハビリテーション要会護１ = div.getPnlMain().getTbl4().getTextBox1265().getValue();
        RString 訪問リハビリテーション要介護２ = div.getPnlMain().getTbl4().getTextBox1266().getValue();
        RString 訪問リハビリテーション要介護３ = div.getPnlMain().getTbl4().getTextBox1267().getValue();
        RString 訪問リハビリテーション要介護４ = div.getPnlMain().getTbl4().getTextBox1268().getValue();
        RString 訪問リハビリテーション要介護５ = div.getPnlMain().getTbl4().getTextBox1269().getValue();
        RString 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1270().getValue();

        return 入力チェック2(訪問リハビリテーション経過的要介護,
                訪問リハビリテーション要会護１, 訪問リハビリテーション要介護２,
                訪問リハビリテーション要介護３, 訪問リハビリテーション要介護４,
                訪問リハビリテーション要介護５, 訪問リハビリテーション要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_7() {

        RString 居宅療養管理指導経過的要介護 = div.getPnlMain().getTbl4().getTextBox1275().getValue();
        RString 居宅療養管理指導要会護１ = div.getPnlMain().getTbl4().getTextBox1276().getValue();
        RString 居宅療養管理指導要介護２ = div.getPnlMain().getTbl4().getTextBox1277().getValue();
        RString 居宅療養管理指導要介護３ = div.getPnlMain().getTbl4().getTextBox1278().getValue();
        RString 居宅療養管理指導要介護４ = div.getPnlMain().getTbl4().getTextBox1279().getValue();
        RString 居宅療養管理指導要介護５ = div.getPnlMain().getTbl4().getTextBox1280().getValue();
        RString 居宅療養管理指導要介護計 = div.getPnlMain().getTbl4().getTextBox1281().getValue();

        return 入力チェック2(居宅療養管理指導経過的要介護, 居宅療養管理指導要会護１, 居宅療養管理指導要介護２,
                居宅療養管理指導要介護３, 居宅療養管理指導要介護４, 居宅療養管理指導要介護５, 居宅療養管理指導要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_8() {

        RString 通所サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1286().getValue();
        RString 通所サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1287().getValue();
        RString 通所サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1288().getValue();
        RString 通所サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1289().getValue();
        RString 通所サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1290().getValue();
        RString 通所サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1291().getValue();
        RString 通所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1292().getValue();

        return 入力チェック2(通所サービス経過的要介護, 通所サービス要会護１, 通所サービス要介護２, 通所サービス要介護３,
                通所サービス要介護４, 通所サービス要介護５, 通所サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_9() {

        RString 通所介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1297().getValue();
        RString 通所介護要会護１ = div.getPnlMain().getTbl4().getTextBox1298().getValue();
        RString 通所介護要介護２ = div.getPnlMain().getTbl4().getTextBox1299().getValue();
        RString 通所介護要介護３ = div.getPnlMain().getTbl4().getTextBox1300().getValue();
        RString 通所介護要介護４ = div.getPnlMain().getTbl4().getTextBox1301().getValue();
        RString 通所介護要介護５ = div.getPnlMain().getTbl4().getTextBox1302().getValue();
        RString 通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1303().getValue();

        return 入力チェック2(通所介護経過的要介護, 通所介護要会護１, 通所介護要介護２,
                通所介護要介護３, 通所介護要介護４, 通所介護要介護５, 通所介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_10() {

        RString 通所リハビリテーション経過的要介護 = div.getPnlMain().getTbl4().getTextBox1308().getValue();
        RString 通所リハビリテーション要会護１ = div.getPnlMain().getTbl4().getTextBox1309().getValue();
        RString 通所リハビリテーション要介護２ = div.getPnlMain().getTbl4().getTextBox1310().getValue();
        RString 通所リハビリテーション要介護３ = div.getPnlMain().getTbl4().getTextBox1311().getValue();
        RString 通所リハビリテーション要介護４ = div.getPnlMain().getTbl4().getTextBox1312().getValue();
        RString 通所リハビリテーション要介護５ = div.getPnlMain().getTbl4().getTextBox1313().getValue();
        RString 通所リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1314().getValue();

        return 入力チェック2(通所リハビリテーション経過的要介護,
                通所リハビリテーション要会護１, 通所リハビリテーション要介護２,
                通所リハビリテーション要介護３, 通所リハビリテーション要介護４,
                通所リハビリテーション要介護５, 通所リハビリテーション要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_11() {

        RString 短期入所サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1319().getValue();
        RString 短期入所サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1320().getValue();
        RString 短期入所サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1321().getValue();
        RString 短期入所サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1322().getValue();
        RString 短期入所サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1323().getValue();
        RString 短期入所サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1324().getValue();
        RString 短期入所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1325().getValue();

        return 入力チェック2(短期入所サービス経過的要介護,
                短期入所サービス要会護１, 短期入所サービス要介護２, 短期入所サービス要介護３,
                短期入所サービス要介護４, 短期入所サービス要介護５, 短期入所サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_12() {

        RString 短期入所生活介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1330().getValue();
        RString 短期入所生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1331().getValue();
        RString 短期入所生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1332().getValue();
        RString 短期入所生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1333().getValue();
        RString 短期入所生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1334().getValue();
        RString 短期入所生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1335().getValue();
        RString 短期入所生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1336().getValue();

        return 入力チェック2(短期入所生活介護経過的要介護, 短期入所生活介護要会護１, 短期入所生活介護要介護２,
                短期入所生活介護要介護３, 短期入所生活介護要介護４, 短期入所生活介護要介護５, 短期入所生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_13() {

        RString 短期入所療養介護介護老人保健施設経過的要介護 = div.getPnlMain().getTbl4().getTextBox1341().getValue();
        RString 短期入所療養介護介護老人保健施設要会護１ = div.getPnlMain().getTbl4().getTextBox1342().getValue();
        RString 短期入所療養介護介護老人保健施設要介護２ = div.getPnlMain().getTbl4().getTextBox1343().getValue();
        RString 短期入所療養介護介護老人保健施設要介護３ = div.getPnlMain().getTbl4().getTextBox1344().getValue();
        RString 短期入所療養介護介護老人保健施設要介護４ = div.getPnlMain().getTbl4().getTextBox1345().getValue();
        RString 短期入所療養介護介護老人保健施設要介護５ = div.getPnlMain().getTbl4().getTextBox1346().getValue();
        RString 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl4().getTextBox1347().getValue();

        return 入力チェック2(短期入所療養介護介護老人保健施設経過的要介護, 短期入所療養介護介護老人保健施設要会護１,
                短期入所療養介護介護老人保健施設要介護２, 短期入所療養介護介護老人保健施設要介護３,
                短期入所療養介護介護老人保健施設要介護４, 短期入所療養介護介護老人保健施設要介護５,
                短期入所療養介護介護老人保健施設要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_14() {

        RString 短期入所療養介護介護療養型医療施設等経過的要介護 = div.getPnlMain().getTbl4().getTextBox1352().getValue();
        RString 短期入所療養介護介護療養型医療施設等要会護１ = div.getPnlMain().getTbl4().getTextBox1353().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護２ = div.getPnlMain().getTbl4().getTextBox1354().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護３ = div.getPnlMain().getTbl4().getTextBox1355().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護４ = div.getPnlMain().getTbl4().getTextBox1356().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護５ = div.getPnlMain().getTbl4().getTextBox1357().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl4().getTextBox1358().getValue();

        return 入力チェック2(短期入所療養介護介護療養型医療施設等経過的要介護, 短期入所療養介護介護療養型医療施設等要会護１,
                短期入所療養介護介護療養型医療施設等要介護２, 短期入所療養介護介護療養型医療施設等要介護３,
                短期入所療養介護介護療養型医療施設等要介護４, 短期入所療養介護介護療養型医療施設等要介護５,
                短期入所療養介護介護療養型医療施設等要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_15() {

        RString 福祉用具住宅改修サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1363().getValue();
        RString 福祉用具住宅改修サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1364().getValue();
        RString 福祉用具住宅改修サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1365().getValue();
        RString 福祉用具住宅改修サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1366().getValue();
        RString 福祉用具住宅改修サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1367().getValue();
        RString 福祉用具住宅改修サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1368().getValue();
        RString 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1369().getValue();

        return 入力チェック2(福祉用具住宅改修サービス経過的要介護,
                福祉用具住宅改修サービス要会護１, 福祉用具住宅改修サービス要介護２,
                福祉用具住宅改修サービス要介護３, 福祉用具住宅改修サービス要介護４,
                福祉用具住宅改修サービス要介護５, 福祉用具住宅改修サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_16() {

        RString 福祉用具貸与経過的要介護 = div.getPnlMain().getTbl4().getTextBox1374().getValue();
        RString 福祉用具貸与要会護１ = div.getPnlMain().getTbl4().getTextBox1375().getValue();
        RString 福祉用具貸与要介護２ = div.getPnlMain().getTbl4().getTextBox1376().getValue();
        RString 福祉用具貸与要介護３ = div.getPnlMain().getTbl4().getTextBox1377().getValue();
        RString 福祉用具貸与要介護４ = div.getPnlMain().getTbl4().getTextBox1378().getValue();
        RString 福祉用具貸与要介護５ = div.getPnlMain().getTbl4().getTextBox1379().getValue();
        RString 福祉用具貸与要介護計 = div.getPnlMain().getTbl4().getTextBox1380().getValue();

        return 入力チェック2(福祉用具貸与経過的要介護, 福祉用具貸与要会護１, 福祉用具貸与要介護２, 福祉用具貸与要介護３,
                福祉用具貸与要介護４, 福祉用具貸与要介護５, 福祉用具貸与要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_17() {

        RString 福祉用具購入費経過的要介護 = div.getPnlMain().getTbl4().getTextBox1385().getValue();
        RString 福祉用具購入費要会護１ = div.getPnlMain().getTbl4().getTextBox1386().getValue();
        RString 福祉用具購入費要介護２ = div.getPnlMain().getTbl4().getTextBox1387().getValue();
        RString 福祉用具購入費要介護３ = div.getPnlMain().getTbl4().getTextBox1388().getValue();
        RString 福祉用具購入費要介護４ = div.getPnlMain().getTbl4().getTextBox1389().getValue();
        RString 福祉用具購入費要介護５ = div.getPnlMain().getTbl4().getTextBox1390().getValue();
        RString 福祉用具購入費要介護計 = div.getPnlMain().getTbl4().getTextBox1391().getValue();

        return 入力チェック2(福祉用具購入費経過的要介護,
                福祉用具購入費要会護１, 福祉用具購入費要介護２, 福祉用具購入費要介護３,
                福祉用具購入費要介護４, 福祉用具購入費要介護５, 福祉用具購入費要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_18() {

        RString 住宅改修費経過的要介護 = div.getPnlMain().getTbl4().getTextBox1396().getValue();
        RString 住宅改修費要会護１ = div.getPnlMain().getTbl4().getTextBox1397().getValue();
        RString 住宅改修費要介護２ = div.getPnlMain().getTbl4().getTextBox1398().getValue();
        RString 住宅改修費要介護３ = div.getPnlMain().getTbl4().getTextBox1399().getValue();
        RString 住宅改修費要介護４ = div.getPnlMain().getTbl4().getTextBox1400().getValue();
        RString 住宅改修費要介護５ = div.getPnlMain().getTbl4().getTextBox1401().getValue();
        RString 住宅改修費要介護計 = div.getPnlMain().getTbl4().getTextBox1402().getValue();

        return 入力チェック2(住宅改修費経過的要介護, 住宅改修費要会護１,
                住宅改修費要介護２, 住宅改修費要介護３, 住宅改修費要介護４,
                住宅改修費要介護５, 住宅改修費要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_19() {

        RString 特定施設入居者生活介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1407().getValue();
        RString 特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1408().getValue();
        RString 特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1409().getValue();
        RString 特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1410().getValue();
        RString 特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1411().getValue();
        RString 特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1412().getValue();
        RString 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1413().getValue();

        return 入力チェック2(特定施設入居者生活介護経過的要介護,
                特定施設入居者生活介護要会護１, 特定施設入居者生活介護要介護２,
                特定施設入居者生活介護要介護３, 特定施設入居者生活介護要介護４,
                特定施設入居者生活介護要介護５, 特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_20() {

        RString 介護予防支援居宅介護支援経過的要介護 = div.getPnlMain().getTbl4().getTextBox1418().getValue();
        RString 介護予防支援居宅介護支援要会護１ = div.getPnlMain().getTbl4().getTextBox1419().getValue();
        RString 介護予防支援居宅介護支援要介護２ = div.getPnlMain().getTbl4().getTextBox1420().getValue();
        RString 介護予防支援居宅介護支援要介護３ = div.getPnlMain().getTbl4().getTextBox1421().getValue();
        RString 介護予防支援居宅介護支援要介護４ = div.getPnlMain().getTbl4().getTextBox1422().getValue();
        RString 介護予防支援居宅介護支援要介護５ = div.getPnlMain().getTbl4().getTextBox1423().getValue();
        RString 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl4().getTextBox1424().getValue();

        return 入力チェック2(介護予防支援居宅介護支援経過的要介護,
                介護予防支援居宅介護支援要会護１, 介護予防支援居宅介護支援要介護２,
                介護予防支援居宅介護支援要介護３, 介護予防支援居宅介護支援要介護４,
                介護予防支援居宅介護支援要介護５, 介護予防支援居宅介護支援要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_21() {

        RString 地域密着型介護予防サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1429().getValue();
        RString 地域密着型介護予防サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1430().getValue();
        RString 地域密着型介護予防サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1431().getValue();
        RString 地域密着型介護予防サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1432().getValue();
        RString 地域密着型介護予防サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1433().getValue();
        RString 地域密着型介護予防サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1434().getValue();
        RString 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1435().getValue();

        return 入力チェック2(地域密着型介護予防サービス経過的要介護,
                地域密着型介護予防サービス要会護１, 地域密着型介護予防サービス要介護２,
                地域密着型介護予防サービス要介護３, 地域密着型介護予防サービス要介護４, 地域密着型介護予防サービス要介護５,
                地域密着型介護予防サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_22() {

        RString 定期巡回随時対応型訪問介護看護経過的要介護 = RString.EMPTY;
        RString 定期巡回随時対応型訪問介護看護要会護１ = div.getPnlMain().getTbl4().getTextBox1440().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護２ = div.getPnlMain().getTbl4().getTextBox1441().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護３ = div.getPnlMain().getTbl4().getTextBox1442().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護４ = div.getPnlMain().getTbl4().getTextBox1443().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護５ = div.getPnlMain().getTbl4().getTextBox1444().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl4().getTextBox1445().getValue();

        return 入力チェック2(定期巡回随時対応型訪問介護看護経過的要介護,
                定期巡回随時対応型訪問介護看護要会護１, 定期巡回随時対応型訪問介護看護要介護２,
                定期巡回随時対応型訪問介護看護要介護３, 定期巡回随時対応型訪問介護看護要介護４,
                定期巡回随時対応型訪問介護看護要介護５, 定期巡回随時対応型訪問介護看護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_23() {

        RString 夜間対応型訪問介護経過的要介護 = RString.EMPTY;
        RString 夜間対応型訪問介護要会護１ = div.getPnlMain().getTbl4().getTextBox1450().getValue();
        RString 夜間対応型訪問介護要介護２ = div.getPnlMain().getTbl4().getTextBox1451().getValue();
        RString 夜間対応型訪問介護要介護３ = div.getPnlMain().getTbl4().getTextBox1452().getValue();
        RString 夜間対応型訪問介護要介護４ = div.getPnlMain().getTbl4().getTextBox1453().getValue();
        RString 夜間対応型訪問介護要介護５ = div.getPnlMain().getTbl4().getTextBox1454().getValue();
        RString 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1455().getValue();

        return 入力チェック2(夜間対応型訪問介護経過的要介護, 夜間対応型訪問介護要会護１,
                夜間対応型訪問介護要介護２, 夜間対応型訪問介護要介護３,
                夜間対応型訪問介護要介護４, 夜間対応型訪問介護要介護５, 夜間対応型訪問介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_24() {

        RString 認知症対応型通所介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1460().getValue();
        RString 認知症対応型通所介護要会護１ = div.getPnlMain().getTbl4().getTextBox1461().getValue();
        RString 認知症対応型通所介護要介護２ = div.getPnlMain().getTbl4().getTextBox1462().getValue();
        RString 認知症対応型通所介護要介護３ = div.getPnlMain().getTbl4().getTextBox1463().getValue();
        RString 認知症対応型通所介護要介護４ = div.getPnlMain().getTbl4().getTextBox1464().getValue();
        RString 認知症対応型通所介護要介護５ = div.getPnlMain().getTbl4().getTextBox1465().getValue();
        RString 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1466().getValue();

        return 入力チェック2(認知症対応型通所介護経過的要介護,
                認知症対応型通所介護要会護１, 認知症対応型通所介護要介護２, 認知症対応型通所介護要介護３,
                認知症対応型通所介護要介護４, 認知症対応型通所介護要介護５, 認知症対応型通所介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_25() {

        RString 小規模多機能型居宅介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1471().getValue();
        RString 小規模多機能型居宅介護要会護１ = div.getPnlMain().getTbl4().getTextBox1472().getValue();
        RString 小規模多機能型居宅介護要介護２ = div.getPnlMain().getTbl4().getTextBox1473().getValue();
        RString 小規模多機能型居宅介護要介護３ = div.getPnlMain().getTbl4().getTextBox1474().getValue();
        RString 小規模多機能型居宅介護要介護４ = div.getPnlMain().getTbl4().getTextBox1475().getValue();
        RString 小規模多機能型居宅介護要介護５ = div.getPnlMain().getTbl4().getTextBox1476().getValue();
        RString 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl4().getTextBox1477().getValue();

        return 入力チェック2(小規模多機能型居宅介護経過的要介護,
                小規模多機能型居宅介護要会護１, 小規模多機能型居宅介護要介護２,
                小規模多機能型居宅介護要介護３, 小規模多機能型居宅介護要介護４,
                小規模多機能型居宅介護要介護５, 小規模多機能型居宅介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_26() {

        RString 認知症対応型共同生活介護経過的要介護 = RString.EMPTY;
        RString 認知症対応型共同生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1482().getValue();
        RString 認知症対応型共同生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1483().getValue();
        RString 認知症対応型共同生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1484().getValue();
        RString 認知症対応型共同生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1485().getValue();
        RString 認知症対応型共同生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1486().getValue();
        RString 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1487().getValue();

        return 入力チェック2(認知症対応型共同生活介護経過的要介護,
                認知症対応型共同生活介護要会護１, 認知症対応型共同生活介護要介護２,
                認知症対応型共同生活介護要介護３, 認知症対応型共同生活介護要介護４,
                認知症対応型共同生活介護要介護５, 認知症対応型共同生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_27() {

        RString 地域密着型特定施設入居者生活介護経過的要介護 = RString.EMPTY;
        RString 地域密着型特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1492().getValue();
        RString 地域密着型特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1493().getValue();
        RString 地域密着型特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1494().getValue();
        RString 地域密着型特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1495().getValue();
        RString 地域密着型特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1496().getValue();
        RString 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1497().getValue();

        return 入力チェック2(地域密着型特定施設入居者生活介護経過的要介護,
                地域密着型特定施設入居者生活介護要会護１, 地域密着型特定施設入居者生活介護要介護２,
                地域密着型特定施設入居者生活介護要介護３, 地域密着型特定施設入居者生活介護要介護４,
                地域密着型特定施設入居者生活介護要介護５, 地域密着型特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_28() {

        RString 地域密着型介護老人福祉施設入所者生活介護経過的要介護 = RString.EMPTY;
        RString 地域密着型介護老人福祉施設入所者生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1502().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1503().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1504().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1505().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1506().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1507().getValue();

        return 入力チェック2(地域密着型介護老人福祉施設入所者生活介護経過的要介護,
                地域密着型介護老人福祉施設入所者生活介護要会護１, 地域密着型介護老人福祉施設入所者生活介護要介護２,
                地域密着型介護老人福祉施設入所者生活介護要介護３, 地域密着型介護老人福祉施設入所者生活介護要介護４,
                地域密着型介護老人福祉施設入所者生活介護要介護５, 地域密着型介護老人福祉施設入所者生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_29() {

        RString 複合型サービス経過的要介護 = RString.EMPTY;
        RString 複合型サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1512().getValue();
        RString 複合型サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1513().getValue();
        RString 複合型サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1514().getValue();
        RString 複合型サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1515().getValue();
        RString 複合型サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1516().getValue();
        RString 複合型サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1517().getValue();

        return 入力チェック2(複合型サービス経過的要介護,
                複合型サービス要会護１, 複合型サービス要介護２, 複合型サービス要介護３,
                複合型サービス要介護４, 複合型サービス要介護５, 複合型サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_30() {

        RString 施設サービス経過的要介護 = RString.EMPTY;
        RString 施設サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1523().getValue();
        RString 施設サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1524().getValue();
        RString 施設サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1525().getValue();
        RString 施設サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1526().getValue();
        RString 施設サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1527().getValue();
        RString 施設サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1528().getValue();

        return 入力チェック2(施設サービス経過的要介護, 施設サービス要会護１,
                施設サービス要介護２, 施設サービス要介護３, 施設サービス要介護４,
                施設サービス要介護５, 施設サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_31() {

        RString 介護老人福祉施設_1_経過的要介護 = RString.EMPTY;
        RString 介護老人福祉施設_1_要会護１ = div.getPnlMain().getTbl4().getTextBox1534().getValue();
        RString 介護老人福祉施設_1_要介護２ = div.getPnlMain().getTbl4().getTextBox1535().getValue();
        RString 介護老人福祉施設_1_要介護３ = div.getPnlMain().getTbl4().getTextBox1536().getValue();
        RString 介護老人福祉施設_1_要介護４ = div.getPnlMain().getTbl4().getTextBox1537().getValue();
        RString 介護老人福祉施設_1_要介護５ = div.getPnlMain().getTbl4().getTextBox1538().getValue();
        RString 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1539().getValue();

        return 入力チェック2(介護老人福祉施設_1_経過的要介護,
                介護老人福祉施設_1_要会護１, 介護老人福祉施設_1_要介護２,
                介護老人福祉施設_1_要介護３, 介護老人福祉施設_1_要介護４,
                介護老人福祉施設_1_要介護５, 介護老人福祉施設_1_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_32() {

        RString 介護老人保健施設_1_経過的要介護 = RString.EMPTY;
        RString 介護老人保健施設_1_要会護１ = div.getPnlMain().getTbl4().getTextBox1544().getValue();
        RString 介護老人保健施設_1_要介護２ = div.getPnlMain().getTbl4().getTextBox1545().getValue();
        RString 介護老人保健施設_1_要介護３ = div.getPnlMain().getTbl4().getTextBox1546().getValue();
        RString 介護老人保健施設_1_要介護４ = div.getPnlMain().getTbl4().getTextBox1547().getValue();
        RString 介護老人保健施設_1_要介護５ = div.getPnlMain().getTbl4().getTextBox1548().getValue();
        RString 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1549().getValue();

        return 入力チェック2(介護老人保健施設_1_経過的要介護,
                介護老人保健施設_1_要会護１, 介護老人保健施設_1_要介護２, 介護老人保健施設_1_要介護３,
                介護老人保健施設_1_要介護４, 介護老人保健施設_1_要介護５, 介護老人保健施設_1_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_33() {

        RString 介護療養型医療施設_1_経過的要介護 = RString.EMPTY;
        RString 介護療養型医療施設_1_要会護１ = div.getPnlMain().getTbl4().getTextBox1554().getValue();
        RString 介護療養型医療施設_1_要介護２ = div.getPnlMain().getTbl4().getTextBox1555().getValue();
        RString 介護療養型医療施設_1_要介護３ = div.getPnlMain().getTbl4().getTextBox1556().getValue();
        RString 介護療養型医療施設_1_要介護４ = div.getPnlMain().getTbl4().getTextBox1557().getValue();
        RString 介護療養型医療施設_1_要介護５ = div.getPnlMain().getTbl4().getTextBox1558().getValue();
        RString 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1559().getValue();

        return 入力チェック2(介護療養型医療施設_1_経過的要介護,
                介護療養型医療施設_1_要会護１, 介護療養型医療施設_1_要介護２, 介護療養型医療施設_1_要介護３,
                介護療養型医療施設_1_要介護４, 介護療養型医療施設_1_要介護５, 介護療養型医療施設_1_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_34() {

        RString 食事提供費用再掲経過的要介護 = RString.EMPTY;
        RString 食事提供費用再掲要会護１ = div.getPnlMain().getTbl4().getTextBox1565().getValue();
        RString 食事提供費用再掲要介護２ = div.getPnlMain().getTbl4().getTextBox1566().getValue();
        RString 食事提供費用再掲要介護３ = div.getPnlMain().getTbl4().getTextBox1567().getValue();
        RString 食事提供費用再掲要介護４ = div.getPnlMain().getTbl4().getTextBox1568().getValue();
        RString 食事提供費用再掲要介護５ = div.getPnlMain().getTbl4().getTextBox1569().getValue();
        RString 食事提供費用再掲要介護計 = div.getPnlMain().getTbl4().getTextBox1570().getValue();

        return 入力チェック2(食事提供費用再掲経過的要介護,
                食事提供費用再掲要会護１, 食事提供費用再掲要介護２, 食事提供費用再掲要介護３,
                食事提供費用再掲要介護４, 食事提供費用再掲要介護５, 食事提供費用再掲要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_35() {

        RString 介護老人福祉施設_2_経過的要介護 = RString.EMPTY;
        RString 介護老人福祉施設_2_要会護１ = div.getPnlMain().getTbl4().getTextBox1576().getValue();
        RString 介護老人福祉施設_2_要介護２ = div.getPnlMain().getTbl4().getTextBox1577().getValue();
        RString 介護老人福祉施設_2_要介護３ = div.getPnlMain().getTbl4().getTextBox1578().getValue();
        RString 介護老人福祉施設_2_要介護４ = div.getPnlMain().getTbl4().getTextBox1579().getValue();
        RString 介護老人福祉施設_2_要介護５ = div.getPnlMain().getTbl4().getTextBox1580().getValue();
        RString 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1581().getValue();

        return 入力チェック2(介護老人福祉施設_2_経過的要介護,
                介護老人福祉施設_2_要会護１, 介護老人福祉施設_2_要介護２, 介護老人福祉施設_2_要介護３,
                介護老人福祉施設_2_要介護４, 介護老人福祉施設_2_要介護５, 介護老人福祉施設_2_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_36() {

        RString 介護老人保健施設_2_経過的要介護 = RString.EMPTY;
        RString 介護老人保健施設_2_要会護１ = div.getPnlMain().getTbl4().getTextBox1586().getValue();
        RString 介護老人保健施設_2_要介護２ = div.getPnlMain().getTbl4().getTextBox1587().getValue();
        RString 介護老人保健施設_2_要介護３ = div.getPnlMain().getTbl4().getTextBox1588().getValue();
        RString 介護老人保健施設_2_要介護４ = div.getPnlMain().getTbl4().getTextBox1589().getValue();
        RString 介護老人保健施設_2_要介護５ = div.getPnlMain().getTbl4().getTextBox1590().getValue();
        RString 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1591().getValue();

        return 入力チェック2(介護老人保健施設_2_経過的要介護,
                介護老人保健施設_2_要会護１, 介護老人保健施設_2_要介護２, 介護老人保健施設_2_要介護３,
                介護老人保健施設_2_要介護４, 介護老人保健施設_2_要介護５, 介護老人保健施設_2_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_37() {

        RString 介護療養型医療施設_2_経過的要介護 = RString.EMPTY;
        RString 介護療養型医療施設_2_要会護１ = div.getPnlMain().getTbl4().getTextBox1596().getValue();
        RString 介護療養型医療施設_2_要介護２ = div.getPnlMain().getTbl4().getTextBox1597().getValue();
        RString 介護療養型医療施設_2_要介護３ = div.getPnlMain().getTbl4().getTextBox1598().getValue();
        RString 介護療養型医療施設_2_要介護４ = div.getPnlMain().getTbl4().getTextBox1599().getValue();
        RString 介護療養型医療施設_2_要介護５ = div.getPnlMain().getTbl4().getTextBox1600().getValue();
        RString 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1601().getValue();

        return 入力チェック2(介護療養型医療施設_2_経過的要介護,
                介護療養型医療施設_2_要会護１, 介護療養型医療施設_2_要介護２, 介護療養型医療施設_2_要介護３,
                介護療養型医療施設_2_要介護４, 介護療養型医療施設_2_要介護５, 介護療養型医療施設_2_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_38() {

        RString 総計経過的要介護 = div.getPnlMain().getTbl4().getTextBox1608().getValue();
        RString 総計要会護１ = div.getPnlMain().getTbl4().getTextBox1609().getValue();
        RString 総計要介護２ = div.getPnlMain().getTbl4().getTextBox1610().getValue();
        RString 総計要介護３ = div.getPnlMain().getTbl4().getTextBox1611().getValue();
        RString 総計要介護４ = div.getPnlMain().getTbl4().getTextBox1612().getValue();
        RString 総計要介護５ = div.getPnlMain().getTbl4().getTextBox1613().getValue();
        RString 総計要介護計 = div.getPnlMain().getTbl4().getTextBox1614().getValue();

        return 入力チェック2(総計経過的要介護, 総計要会護１, 総計要介護２,
                総計要介護３, 総計要介護４, 総計要介護５, 総計要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1() {

        RString 居宅介護予防サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1206().getValue();
        RString 居宅介護予防サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1207().getValue();
        RString 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1208().getValue();

        return 入力チェック1(居宅介護予防サービス要支援１,
                居宅介護予防サービス要支援２, 居宅介護予防サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_2() {

        RString 訪問サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1217().getValue();
        RString 訪問サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1218().getValue();
        RString 訪問サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1219().getValue();

        return 入力チェック1(訪問サービス要支援１, 訪問サービス要支援２, 訪問サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_3() {

        RString 訪問介護要支援１ = div.getPnlMain().getTbl4().getTextBox1228().getValue();
        RString 訪問介護要支援２ = div.getPnlMain().getTbl4().getTextBox1229().getValue();
        RString 訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1230().getValue();

        return 入力チェック1(訪問介護要支援１, 訪問介護要支援２, 訪問介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_4() {

        RString 訪問入浴介護要支援１ = div.getPnlMain().getTbl4().getTextBox1239().getValue();
        RString 訪問入浴介護要支援２ = div.getPnlMain().getTbl4().getTextBox1240().getValue();
        RString 訪問入浴介護要支援計 = div.getPnlMain().getTbl4().getTextBox1241().getValue();

        return 入力チェック1(訪問入浴介護要支援１, 訪問入浴介護要支援２, 訪問入浴介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_5() {

        RString 訪問看護要支援１ = div.getPnlMain().getTbl4().getTextBox1250().getValue();
        RString 訪問看護要支援２ = div.getPnlMain().getTbl4().getTextBox1251().getValue();
        RString 訪問看護要支援計 = div.getPnlMain().getTbl4().getTextBox1252().getValue();

        return 入力チェック1(訪問看護要支援１, 訪問看護要支援２, 訪問看護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_6() {

        RString 訪問リハビリテーション要支援１ = div.getPnlMain().getTbl4().getTextBox1261().getValue();
        RString 訪問リハビリテーション要支援２ = div.getPnlMain().getTbl4().getTextBox1262().getValue();
        RString 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1263().getValue();

        return 入力チェック1(訪問リハビリテーション要支援１,
                訪問リハビリテーション要支援２, 訪問リハビリテーション要支援計);
    }

    private boolean is整合性チェック_給付額_NG_7() {

        RString 居宅療養管理指導要支援１ = div.getPnlMain().getTbl4().getTextBox1272().getValue();
        RString 居宅療養管理指導要支援２ = div.getPnlMain().getTbl4().getTextBox1273().getValue();
        RString 居宅療養管理指導要支援計 = div.getPnlMain().getTbl4().getTextBox1274().getValue();

        return 入力チェック1(居宅療養管理指導要支援１, 居宅療養管理指導要支援２, 居宅療養管理指導要支援計);
    }

    private boolean is整合性チェック_給付額_NG_8() {

        RString 通所サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1283().getValue();
        RString 通所サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1284().getValue();
        RString 通所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1285().getValue();

        return 入力チェック1(通所サービス要支援１, 通所サービス要支援２, 通所サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_9() {

        RString 通所介護要支援１ = div.getPnlMain().getTbl4().getTextBox1294().getValue();
        RString 通所介護要支援２ = div.getPnlMain().getTbl4().getTextBox1295().getValue();
        RString 通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1296().getValue();

        return 入力チェック1(通所介護要支援１, 通所介護要支援２, 通所介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_10() {

        RString 通所リハビリテーション要支援１ = div.getPnlMain().getTbl4().getTextBox1305().getValue();
        RString 通所リハビリテーション要支援２ = div.getPnlMain().getTbl4().getTextBox1306().getValue();
        RString 通所リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1307().getValue();

        return 入力チェック1(通所リハビリテーション要支援１, 通所リハビリテーション要支援２, 通所リハビリテーション要支援計);
    }

    private boolean is整合性チェック_給付額_NG_11() {

        RString 短期入所サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1316().getValue();
        RString 短期入所サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1317().getValue();
        RString 短期入所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1318().getValue();

        return 入力チェック1(短期入所サービス要支援１, 短期入所サービス要支援２, 短期入所サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_12() {

        RString 短期入所生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1327().getValue();
        RString 短期入所生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1328().getValue();
        RString 短期入所生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1329().getValue();

        return 入力チェック1(短期入所生活介護要支援１, 短期入所生活介護要支援２, 短期入所生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_13() {

        RString 短期入所療養介護介護老人保健施設要支援１ = div.getPnlMain().getTbl4().getTextBox1338().getValue();
        RString 短期入所療養介護介護老人保健施設要支援２ = div.getPnlMain().getTbl4().getTextBox1339().getValue();
        RString 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl4().getTextBox1340().getValue();

        return 入力チェック1(短期入所療養介護介護老人保健施設要支援１,
                短期入所療養介護介護老人保健施設要支援２, 短期入所療養介護介護老人保健施設要支援計);
    }

    private boolean is整合性チェック_給付額_NG_14() {

        RString 短期入所療養介護介護療養型医療施設等要支援１ = div.getPnlMain().getTbl4().getTextBox1349().getValue();
        RString 短期入所療養介護介護療養型医療施設等要支援２ = div.getPnlMain().getTbl4().getTextBox1350().getValue();
        RString 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl4().getTextBox1351().getValue();

        return 入力チェック1(短期入所療養介護介護療養型医療施設等要支援１, 短期入所療養介護介護療養型医療施設等要支援２,
                短期入所療養介護介護療養型医療施設等要支援計);
    }

    private boolean is整合性チェック_給付額_NG_15() {

        RString 福祉用具住宅改修サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1360().getValue();
        RString 福祉用具住宅改修サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1361().getValue();
        RString 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1362().getValue();

        return 入力チェック1(福祉用具住宅改修サービス要支援１,
                福祉用具住宅改修サービス要支援２, 福祉用具住宅改修サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_16() {

        RString 福祉用具貸与要支援１ = div.getPnlMain().getTbl4().getTextBox1371().getValue();
        RString 福祉用具貸与要支援２ = div.getPnlMain().getTbl4().getTextBox1372().getValue();
        RString 福祉用具貸与要支援計 = div.getPnlMain().getTbl4().getTextBox1373().getValue();

        return 入力チェック1(福祉用具貸与要支援１, 福祉用具貸与要支援２, 福祉用具貸与要支援計);
    }

    private boolean is整合性チェック_給付額_NG_17() {

        RString 福祉用具購入費要支援１ = div.getPnlMain().getTbl4().getTextBox1382().getValue();
        RString 福祉用具購入費要支援２ = div.getPnlMain().getTbl4().getTextBox1383().getValue();
        RString 福祉用具購入費要支援計 = div.getPnlMain().getTbl4().getTextBox1384().getValue();

        return 入力チェック1(福祉用具購入費要支援１, 福祉用具購入費要支援２, 福祉用具購入費要支援計);
    }

    private boolean is整合性チェック_給付額_NG_18() {

        RString 住宅改修費要支援１ = div.getPnlMain().getTbl4().getTextBox1393().getValue();
        RString 住宅改修費要支援２ = div.getPnlMain().getTbl4().getTextBox1394().getValue();
        RString 住宅改修費要支援計 = div.getPnlMain().getTbl4().getTextBox1395().getValue();

        return 入力チェック1(住宅改修費要支援１, 住宅改修費要支援２, 住宅改修費要支援計);
    }

    private boolean is整合性チェック_給付額_NG_19() {

        RString 特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1404().getValue();
        RString 特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1405().getValue();
        RString 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1406().getValue();

        return 入力チェック1(特定施設入居者生活介護要支援１, 特定施設入居者生活介護要支援２, 特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_20() {

        RString 介護予防支援居宅介護支援要支援１ = div.getPnlMain().getTbl4().getTextBox1415().getValue();
        RString 介護予防支援居宅介護支援要支援２ = div.getPnlMain().getTbl4().getTextBox1416().getValue();
        RString 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl4().getTextBox1417().getValue();

        return 入力チェック1(介護予防支援居宅介護支援要支援１,
                介護予防支援居宅介護支援要支援２, 介護予防支援居宅介護支援要支援計);
    }

    private boolean is整合性チェック_給付額_NG_21() {

        RString 地域密着型介護予防サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1426().getValue();
        RString 地域密着型介護予防サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1427().getValue();
        RString 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1428().getValue();

        return 入力チェック1(地域密着型介護予防サービス要支援１,
                地域密着型介護予防サービス要支援２, 地域密着型介護予防サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_22() {

        RString 定期巡回随時対応型訪問介護看護要支援１ = div.getPnlMain().getTbl4().getTextBox1437().getValue();
        RString 定期巡回随時対応型訪問介護看護要支援２ = div.getPnlMain().getTbl4().getTextBox1438().getValue();
        RString 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl4().getTextBox1439().getValue();

        return 入力チェック1(定期巡回随時対応型訪問介護看護要支援１,
                定期巡回随時対応型訪問介護看護要支援２, 定期巡回随時対応型訪問介護看護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_23() {

        RString 夜間対応型訪問介護要支援１ = div.getPnlMain().getTbl4().getTextBox1447().getValue();
        RString 夜間対応型訪問介護要支援２ = div.getPnlMain().getTbl4().getTextBox1448().getValue();
        RString 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1449().getValue();

        return 入力チェック1(夜間対応型訪問介護要支援１, 夜間対応型訪問介護要支援２, 夜間対応型訪問介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_24() {

        RString 認知症対応型通所介護要支援１ = div.getPnlMain().getTbl4().getTextBox1457().getValue();
        RString 認知症対応型通所介護要支援２ = div.getPnlMain().getTbl4().getTextBox1458().getValue();
        RString 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1459().getValue();

        return 入力チェック1(認知症対応型通所介護要支援１, 認知症対応型通所介護要支援２, 認知症対応型通所介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_25() {

        RString 小規模多機能型居宅介護要支援１ = div.getPnlMain().getTbl4().getTextBox1468().getValue();
        RString 小規模多機能型居宅介護要支援２ = div.getPnlMain().getTbl4().getTextBox1469().getValue();
        RString 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl4().getTextBox1470().getValue();

        return 入力チェック1(小規模多機能型居宅介護要支援１, 小規模多機能型居宅介護要支援２, 小規模多機能型居宅介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_26() {

        RString 認知症対応型共同生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1479().getValue();
        RString 認知症対応型共同生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1480().getValue();
        RString 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1481().getValue();

        return 入力チェック1(認知症対応型共同生活介護要支援１,
                認知症対応型共同生活介護要支援２, 認知症対応型共同生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_27() {

        RString 地域密着型特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1489().getValue();
        RString 地域密着型特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1490().getValue();
        RString 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1491().getValue();

        return 入力チェック1(地域密着型特定施設入居者生活介護要支援１,
                地域密着型特定施設入居者生活介護要支援２, 地域密着型特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_28() {

        RString 地域密着型介護老人福祉施設入所者生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1499().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1500().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1501().getValue();

        return 入力チェック1(地域密着型介護老人福祉施設入所者生活介護要支援１, 地域密着型介護老人福祉施設入所者生活介護要支援２,
                地域密着型介護老人福祉施設入所者生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_29() {

        RString 複合型サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1509().getValue();
        RString 複合型サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1510().getValue();
        RString 複合型サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1511().getValue();

        return 入力チェック1(複合型サービス要支援１, 複合型サービス要支援２, 複合型サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_30() {

        RString 施設サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1519().getValue();
        RString 施設サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1520().getValue();
        RString 施設サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1521().getValue();

        return 入力チェック1(施設サービス要支援１, 施設サービス要支援２, 施設サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_31() {

        RString 介護老人福祉施設_1_要支援１ = div.getPnlMain().getTbl4().getTextBox1530().getValue();
        RString 介護老人福祉施設_1_要支援２ = div.getPnlMain().getTbl4().getTextBox1531().getValue();
        RString 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1532().getValue();

        return 入力チェック1(介護老人福祉施設_1_要支援１, 介護老人福祉施設_1_要支援２, 介護老人福祉施設_1_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_32() {

        RString 介護老人保健施設_1_要支援１ = div.getPnlMain().getTbl4().getTextBox1541().getValue();
        RString 介護老人保健施設_1_要支援２ = div.getPnlMain().getTbl4().getTextBox1542().getValue();
        RString 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1543().getValue();

        return 入力チェック1(介護老人保健施設_1_要支援１, 介護老人保健施設_1_要支援２, 介護老人保健施設_1_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_33() {

        RString 介護療養型医療施設要支援１ = div.getPnlMain().getTbl4().getTextBox1551().getValue();
        RString 介護療養型医療施設要支援２ = div.getPnlMain().getTbl4().getTextBox1552().getValue();
        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1553().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_給付額_NG_34() {

        RString 食事提供費用再掲要支援１ = div.getPnlMain().getTbl4().getTextBox1561().getValue();
        RString 食事提供費用再掲要支援２ = div.getPnlMain().getTbl4().getTextBox1562().getValue();
        RString 食事提供費用再掲要支援計 = div.getPnlMain().getTbl4().getTextBox1563().getValue();

        return 入力チェック1(食事提供費用再掲要支援１, 食事提供費用再掲要支援２, 食事提供費用再掲要支援計);
    }

    private boolean is整合性チェック_給付額_NG_35() {

        RString 介護老人福祉施設_2_要支援１ = div.getPnlMain().getTbl4().getTextBox1572().getValue();
        RString 介護老人福祉施設_2_要支援２ = div.getPnlMain().getTbl4().getTextBox1573().getValue();
        RString 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1574().getValue();

        return 入力チェック1(介護老人福祉施設_2_要支援１, 介護老人福祉施設_2_要支援２, 介護老人福祉施設_2_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_36() {

        RString 介護老人保健施設_2_要支援１ = div.getPnlMain().getTbl4().getTextBox1583().getValue();
        RString 介護老人保健施設_2_要支援２ = div.getPnlMain().getTbl4().getTextBox1584().getValue();
        RString 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1585().getValue();

        return 入力チェック1(介護老人保健施設_2_要支援１, 介護老人保健施設_2_要支援２, 介護老人保健施設_2_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_37() {

        RString 介護療養型医療施設要支援１ = div.getPnlMain().getTbl4().getTextBox1593().getValue();
        RString 介護療養型医療施設要支援２ = div.getPnlMain().getTbl4().getTextBox1594().getValue();
        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1595().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_給付額_NG_38() {

        RString 総計要支援１ = div.getPnlMain().getTbl4().getTextBox1603().getValue();
        RString 総計要支援２ = div.getPnlMain().getTbl4().getTextBox1604().getValue();
        RString 総計要支援計 = div.getPnlMain().getTbl4().getTextBox1605().getValue();

        return 入力チェック1(総計要支援１, 総計要支援２, 総計要支援計);
    }

    private boolean 入力チェック1(RString 入力要支援１,
            RString 入力要支援２,
            RString 入力要支援計) {
        Decimal 要支援１ = (入力要支援１ == null || 入力要支援１.isEmpty()
                ? Decimal.ZERO : new Decimal(入力要支援１.toString()));
        Decimal 要支援2 = (入力要支援２ == null || 入力要支援２.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要支援２.toString());
        Decimal 支援計 = (入力要支援計 == null || 入力要支援計.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要支援計.toString());

        return !要支援１.add(要支援2).equals(支援計);
    }

    private boolean 入力チェック2(RString 入力経過的要介護,
            RString 入力要会護１,
            RString 入力要介護２,
            RString 入力要介護３,
            RString 入力要介護４,
            RString 入力要介護５,
            RString 入力要介護計) {
        Decimal 経過的要介護 = (入力経過的要介護 == null || 入力経過的要介護.isEmpty()
                ? Decimal.ZERO : new Decimal(入力経過的要介護.toString()));
        Decimal 要会護１ = (入力要会護１ == null || 入力要会護１.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要会護１.toString());
        Decimal 要介護２ = (入力要介護２ == null || 入力要介護２.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要介護２.toString());
        Decimal 要会護３ = (入力要介護３ == null || 入力要介護３.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要介護３.toString());
        Decimal 要介護４ = (入力要介護４ == null || 入力要介護４.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要介護４.toString());
        Decimal 要会護５ = (入力要介護５ == null || 入力要介護５.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要介護５.toString());
        Decimal 要介護計 = (入力要介護計 == null || 入力要介護計.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要介護計.toString());

        return !経過的要介護.add(要会護１).add(要介護２).add(要会護３).add(要介護４).add(要会護５).equals(要介護計);
    }

    /**
     * is整合性チェック_NG_給付額のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_給付額_NG3() {

        return is整合性チェック_NG_給付額_整合3_1() || is整合性チェック_NG_給付額_整合3_2()
                || is整合性チェック_NG_給付額_整合3_3();
    }

    private boolean is整合性チェック_NG_給付額_整合3_1() {
        return is整合性チェック_NG_給付額_3_1() || is整合性チェック_NG_給付額_3_2()
                || is整合性チェック_NG_給付額_3_3() || is整合性チェック_NG_給付額_3_4()
                || is整合性チェック_NG_給付額_3_5() || is整合性チェック_NG_給付額_3_6()
                || is整合性チェック_NG_給付額_3_7() || is整合性チェック_NG_給付額_3_8()
                || is整合性チェック_NG_給付額_3_9() || is整合性チェック_NG_給付額_3_10()
                || is整合性チェック_NG_給付額_3_11() || is整合性チェック_NG_給付額_3_12()
                || is整合性チェック_NG_給付額_3_13();
    }

    private boolean is整合性チェック_NG_給付額_整合3_2() {
        return is整合性チェック_NG_給付額_3_14() || is整合性チェック_NG_給付額_3_15()
                || is整合性チェック_NG_給付額_3_16() || is整合性チェック_NG_給付額_3_17()
                || is整合性チェック_NG_給付額_3_18() || is整合性チェック_NG_給付額_3_19()
                || is整合性チェック_NG_給付額_3_20() || is整合性チェック_NG_給付額_3_21()
                || is整合性チェック_NG_給付額_3_22() || is整合性チェック_NG_給付額_3_23()
                || is整合性チェック_NG_給付額_3_24() || is整合性チェック_NG_給付額_3_25()
                || is整合性チェック_NG_給付額_3_26();
    }

    private boolean is整合性チェック_NG_給付額_整合3_3() {
        return is整合性チェック_NG_給付額_3_27() || is整合性チェック_NG_給付額_3_28()
                || is整合性チェック_NG_給付額_3_29() || is整合性チェック_NG_給付額_3_30()
                || is整合性チェック_NG_給付額_3_31() || is整合性チェック_NG_給付額_3_32()
                || is整合性チェック_NG_給付額_3_33() || is整合性チェック_NG_給付額_3_34()
                || is整合性チェック_NG_給付額_3_35() || is整合性チェック_NG_給付額_3_36()
                || is整合性チェック_NG_給付額_3_37() || is整合性チェック_NG_給付額_3_38();
    }

    private boolean is整合性チェック_NG_給付額_3_1() {

        RString 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1208().getValue();
        RString 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1215().getValue();
        RString 居宅介護予防サービス合計 = div.getPnlMain().getTbl4().getTextBox1216().getValue();

        return 入力チェック3(居宅介護予防サービス要支援計, 居宅介護予防サービス要介護計, 居宅介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_2() {

        RString 訪問サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1219().getValue();
        RString 訪問サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1226().getValue();
        RString 訪問サービス合計 = div.getPnlMain().getTbl4().getTextBox1227().getValue();

        return 入力チェック3(訪問サービス要支援計, 訪問サービス要介護計, 訪問サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_3() {

        RString 訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1230().getValue();
        RString 訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1237().getValue();
        RString 訪問介護合計 = div.getPnlMain().getTbl4().getTextBox1238().getValue();

        return 入力チェック3(訪問介護要支援計, 訪問介護要介護計, 訪問介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_4() {

        RString 訪問入浴介護要支援計 = div.getPnlMain().getTbl4().getTextBox1241().getValue();
        RString 訪問入浴介護要介護計 = div.getPnlMain().getTbl4().getTextBox1248().getValue();
        RString 訪問入浴介護合計 = div.getPnlMain().getTbl4().getTextBox1249().getValue();

        return 入力チェック3(訪問入浴介護要支援計, 訪問入浴介護要介護計, 訪問入浴介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_5() {

        RString 訪問看護要支援計 = div.getPnlMain().getTbl4().getTextBox1252().getValue();
        RString 訪問看護要介護計 = div.getPnlMain().getTbl4().getTextBox1259().getValue();
        RString 訪問看護要合計 = div.getPnlMain().getTbl4().getTextBox1260().getValue();

        return 入力チェック3(訪問看護要支援計, 訪問看護要介護計, 訪問看護要合計);
    }

    private boolean is整合性チェック_NG_給付額_3_6() {

        RString 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1263().getValue();
        RString 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1270().getValue();
        RString 訪問リハビリテーション合計 = div.getPnlMain().getTbl4().getTextBox1271().getValue();

        return 入力チェック3(訪問リハビリテーション要支援計, 訪問リハビリテーション要介護計, 訪問リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_給付額_3_7() {

        RString 居宅療養管理指導要支援計 = div.getPnlMain().getTbl4().getTextBox1274().getValue();
        RString 居宅療養管理指導要介護計 = div.getPnlMain().getTbl4().getTextBox1281().getValue();
        RString 居宅療養管理指導合計 = div.getPnlMain().getTbl4().getTextBox1282().getValue();

        return 入力チェック3(居宅療養管理指導要支援計, 居宅療養管理指導要介護計, 居宅療養管理指導合計);
    }

    private boolean is整合性チェック_NG_給付額_3_8() {

        RString 通所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1285().getValue();
        RString 通所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1292().getValue();
        RString 通所サービス要合計 = div.getPnlMain().getTbl4().getTextBox1293().getValue();

        return 入力チェック3(通所サービス要支援計, 通所サービス要介護計, 通所サービス要合計);
    }

    private boolean is整合性チェック_NG_給付額_3_9() {

        RString 通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1296().getValue();
        RString 通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1303().getValue();
        RString 通所介護合計 = div.getPnlMain().getTbl4().getTextBox1304().getValue();

        return 入力チェック3(通所介護要支援計, 通所介護要介護計, 通所介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_10() {

        RString 通所リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1307().getValue();
        RString 通所リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1314().getValue();
        RString 通所リハビリテーション合計 = div.getPnlMain().getTbl4().getTextBox1315().getValue();

        return 入力チェック3(通所リハビリテーション要支援計, 通所リハビリテーション要介護計, 通所リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_給付額_3_11() {

        RString 短期入所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1318().getValue();
        RString 短期入所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1325().getValue();
        RString 短期入所サービス合計 = div.getPnlMain().getTbl4().getTextBox1326().getValue();

        return 入力チェック3(短期入所サービス要支援計, 短期入所サービス要介護計, 短期入所サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_12() {

        RString 短期入所生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1329().getValue();
        RString 短期入所生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1336().getValue();
        RString 短期入所生活介護合計 = div.getPnlMain().getTbl4().getTextBox1337().getValue();

        return 入力チェック3(短期入所生活介護要支援計, 短期入所生活介護要介護計, 短期入所生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_13() {

        RString 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl4().getTextBox1340().getValue();
        RString 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl4().getTextBox1347().getValue();
        RString 短期入所療養介護介護老人保健施設合計 = div.getPnlMain().getTbl4().getTextBox1348().getValue();

        return 入力チェック3(短期入所療養介護介護老人保健施設要支援計,
                短期入所療養介護介護老人保健施設要介護計, 短期入所療養介護介護老人保健施設合計);
    }

    private boolean is整合性チェック_NG_給付額_3_14() {

        RString 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl4().getTextBox1351().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl4().getTextBox1358().getValue();
        RString 短期入所療養介護介護療養型医療施設等合計 = div.getPnlMain().getTbl4().getTextBox1359().getValue();

        return 入力チェック3(短期入所療養介護介護療養型医療施設等要支援計, 短期入所療養介護介護療養型医療施設等要介護計,
                短期入所療養介護介護療養型医療施設等合計);
    }

    private boolean is整合性チェック_NG_給付額_3_15() {

        RString 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1362().getValue();
        RString 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1369().getValue();
        RString 福祉用具住宅改修サービス合計 = div.getPnlMain().getTbl4().getTextBox1370().getValue();

        return 入力チェック3(福祉用具住宅改修サービス要支援計, 福祉用具住宅改修サービス要介護計, 福祉用具住宅改修サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_16() {

        RString 福祉用具貸与要支援計 = div.getPnlMain().getTbl4().getTextBox1373().getValue();
        RString 福祉用具貸与要介護計 = div.getPnlMain().getTbl4().getTextBox1380().getValue();
        RString 福祉用具貸与合計 = div.getPnlMain().getTbl4().getTextBox1381().getValue();

        return 入力チェック3(福祉用具貸与要支援計, 福祉用具貸与要介護計, 福祉用具貸与合計);
    }

    private boolean is整合性チェック_NG_給付額_3_17() {

        RString 福祉用具購入費要支援計 = div.getPnlMain().getTbl4().getTextBox1384().getValue();
        RString 福祉用具購入費要介護計 = div.getPnlMain().getTbl4().getTextBox1391().getValue();
        RString 福祉用具購入費合計 = div.getPnlMain().getTbl4().getTextBox1392().getValue();

        return 入力チェック3(福祉用具購入費要支援計, 福祉用具購入費要介護計, 福祉用具購入費合計);
    }

    private boolean is整合性チェック_NG_給付額_3_18() {

        RString 住宅改修費要支援計 = div.getPnlMain().getTbl4().getTextBox1395().getValue();
        RString 住宅改修費要介護計 = div.getPnlMain().getTbl4().getTextBox1402().getValue();
        RString 住宅改修費合計 = div.getPnlMain().getTbl4().getTextBox1403().getValue();

        return 入力チェック3(住宅改修費要支援計, 住宅改修費要介護計, 住宅改修費合計);
    }

    private boolean is整合性チェック_NG_給付額_3_19() {

        RString 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1406().getValue();
        RString 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1413().getValue();
        RString 特定施設入居者生活介護合計 = div.getPnlMain().getTbl4().getTextBox1414().getValue();

        return 入力チェック3(特定施設入居者生活介護要支援計, 特定施設入居者生活介護要介護計, 特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_20() {

        RString 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl4().getTextBox1417().getValue();
        RString 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl4().getTextBox1424().getValue();
        RString 介護予防支援居宅介護支援合計 = div.getPnlMain().getTbl4().getTextBox1425().getValue();

        return 入力チェック3(介護予防支援居宅介護支援要支援計, 介護予防支援居宅介護支援要介護計, 介護予防支援居宅介護支援合計);
    }

    private boolean is整合性チェック_NG_給付額_3_21() {

        RString 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1428().getValue();
        RString 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1435().getValue();
        RString 地域密着型介護予防サービス合計 = div.getPnlMain().getTbl4().getTextBox1436().getValue();

        return 入力チェック3(地域密着型介護予防サービス要支援計, 地域密着型介護予防サービス要介護計, 地域密着型介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_22() {

        RString 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl4().getTextBox1439().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl4().getTextBox1445().getValue();
        RString 定期巡回随時対応型訪問介護看護合計 = div.getPnlMain().getTbl4().getTextBox1446().getValue();

        return 入力チェック3(定期巡回随時対応型訪問介護看護要支援計,
                定期巡回随時対応型訪問介護看護要介護計, 定期巡回随時対応型訪問介護看護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_23() {

        RString 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1449().getValue();
        RString 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1455().getValue();
        RString 夜間対応型訪問介護合計 = div.getPnlMain().getTbl4().getTextBox1456().getValue();

        return 入力チェック3(夜間対応型訪問介護要支援計, 夜間対応型訪問介護要介護計, 夜間対応型訪問介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_24() {

        RString 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1459().getValue();
        RString 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1466().getValue();
        RString 認知症対応型通所介護合計 = div.getPnlMain().getTbl4().getTextBox1467().getValue();

        return 入力チェック3(認知症対応型通所介護要支援計, 認知症対応型通所介護要介護計, 認知症対応型通所介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_25() {

        RString 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl4().getTextBox1470().getValue();
        RString 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl4().getTextBox1477().getValue();
        RString 小規模多機能型居宅介護合計 = div.getPnlMain().getTbl4().getTextBox1478().getValue();

        return 入力チェック3(小規模多機能型居宅介護要支援計, 小規模多機能型居宅介護要介護計, 小規模多機能型居宅介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_26() {

        RString 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1481().getValue();
        RString 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1487().getValue();
        RString 認知症対応型共同生活介護合計 = div.getPnlMain().getTbl4().getTextBox1488().getValue();

        return 入力チェック3(認知症対応型共同生活介護要支援計, 認知症対応型共同生活介護要介護計, 認知症対応型共同生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_27() {

        RString 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1491().getValue();
        RString 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1497().getValue();
        RString 地域密着型特定施設入居者生活介護合計 = div.getPnlMain().getTbl4().getTextBox1498().getValue();

        return 入力チェック3(地域密着型特定施設入居者生活介護要支援計,
                地域密着型特定施設入居者生活介護要介護計, 地域密着型特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_28() {

        RString 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1501().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1507().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護合計 = div.getPnlMain().getTbl4().getTextBox1508().getValue();

        return 入力チェック3(地域密着型介護老人福祉施設入所者生活介護要支援計, 地域密着型介護老人福祉施設入所者生活介護要介護計,
                地域密着型介護老人福祉施設入所者生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_29() {

        RString 複合型サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1511().getValue();
        RString 複合型サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1517().getValue();
        RString 複合型サービス合計 = div.getPnlMain().getTbl4().getTextBox1518().getValue();

        return 入力チェック3(複合型サービス要支援計, 複合型サービス要介護計, 複合型サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_30() {

        RString 施設サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1521().getValue();
        RString 施設サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1528().getValue();
        RString 施設サービス合計 = div.getPnlMain().getTbl4().getTextBox1529().getValue();

        return 入力チェック3(施設サービス要支援計, 施設サービス要介護計, 施設サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_31() {

        RString 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1532().getValue();
        RString 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1539().getValue();
        RString 介護老人福祉施設_1_合計 = div.getPnlMain().getTbl4().getTextBox1540().getValue();

        return 入力チェック3(介護老人福祉施設_1_要支援計, 介護老人福祉施設_1_要介護計, 介護老人福祉施設_1_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_32() {

        RString 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1543().getValue();
        RString 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1549().getValue();
        RString 介護老人保健施設_1_合計 = div.getPnlMain().getTbl4().getTextBox1550().getValue();

        return 入力チェック3(介護老人保健施設_1_要支援計, 介護老人保健施設_1_要介護計, 介護老人保健施設_1_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_33() {

        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1553().getValue();
        RString 介護療養型医療施設要介護計 = div.getPnlMain().getTbl4().getTextBox1559().getValue();
        RString 介護療養型医療施設合計 = div.getPnlMain().getTbl4().getTextBox1560().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_給付額_3_34() {

        RString 食事提供費用再掲要支援計 = div.getPnlMain().getTbl4().getTextBox1563().getValue();
        RString 食事提供費用再掲要介護計 = div.getPnlMain().getTbl4().getTextBox1570().getValue();
        RString 食事提供費用再掲合計 = div.getPnlMain().getTbl4().getTextBox1571().getValue();

        return 入力チェック3(食事提供費用再掲要支援計, 食事提供費用再掲要介護計, 食事提供費用再掲合計);
    }

    private boolean is整合性チェック_NG_給付額_3_35() {

        RString 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1574().getValue();
        RString 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1581().getValue();
        RString 介護老人福祉施設_2_合計 = div.getPnlMain().getTbl4().getTextBox1582().getValue();

        return 入力チェック3(介護老人福祉施設_2_要支援計, 介護老人福祉施設_2_要介護計, 介護老人福祉施設_2_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_36() {

        RString 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1585().getValue();
        RString 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1591().getValue();
        RString 介護老人保健施設_2_合計 = div.getPnlMain().getTbl4().getTextBox1592().getValue();

        return 入力チェック3(介護老人保健施設_2_要支援計, 介護老人保健施設_2_要介護計, 介護老人保健施設_2_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_37() {

        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1595().getValue();
        RString 介護療養型医療施設要介護計 = div.getPnlMain().getTbl4().getTextBox1601().getValue();
        RString 介護療養型医療施設合計 = div.getPnlMain().getTbl4().getTextBox1602().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_給付額_3_38() {

        RString 総計要支援計 = div.getPnlMain().getTbl4().getTextBox1605().getValue();
        RString 総計要介護計 = div.getPnlMain().getTbl4().getTextBox1613().getValue();
        RString 総計合計 = div.getPnlMain().getTbl4().getTextBox1614().getValue();

        return 入力チェック3(総計要支援計, 総計要介護計, 総計合計);
    }

    private boolean 入力チェック3(RString 入力要支援計,
            RString 入力要介護計,
            RString 入力合計) {
        Decimal 要支援計 = (入力要支援計 == null || 入力要支援計.isEmpty()
                ? Decimal.ZERO : new Decimal(入力要支援計.toString()));
        Decimal 要介護計 = (入力要介護計 == null || 入力要介護計.isEmpty())
                ? Decimal.ZERO : new Decimal(入力要介護計.toString());
        Decimal 合計 = (入力合計 == null || 入力合計.isEmpty())
                ? Decimal.ZERO : new Decimal(入力合計.toString());
        return !要支援計.add(要介護計).equals(合計);
    }

}

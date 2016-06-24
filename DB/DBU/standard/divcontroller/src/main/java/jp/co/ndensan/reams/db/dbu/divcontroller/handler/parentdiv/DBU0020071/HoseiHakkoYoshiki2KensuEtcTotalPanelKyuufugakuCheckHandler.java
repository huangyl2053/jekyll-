/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
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

        Decimal 居宅介護予防サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1209().getValue();
        Decimal 居宅介護予防サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1210().getValue();
        Decimal 居宅介護予防サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1211().getValue();
        Decimal 居宅介護予防サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1212().getValue();
        Decimal 居宅介護予防サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1213().getValue();
        Decimal 居宅介護予防サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1214().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1215().getValue();

        return 入力チェック2(居宅介護予防サービス経過的要介護,
                居宅介護予防サービス要会護１, 居宅介護予防サービス要介護２, 居宅介護予防サービス要介護３,
                居宅介護予防サービス要介護４, 居宅介護予防サービス要介護５, 居宅介護予防サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_2() {

        Decimal 訪問サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1220().getValue();
        Decimal 訪問サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1221().getValue();
        Decimal 訪問サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1222().getValue();
        Decimal 訪問サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1223().getValue();
        Decimal 訪問サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1224().getValue();
        Decimal 訪問サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1225().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1226().getValue();

        return 入力チェック2(訪問サービス経過的要介護, 訪問サービス要会護１,
                訪問サービス要介護２, 訪問サービス要介護３, 訪問サービス要介護４,
                訪問サービス要介護５, 訪問サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_3() {

        Decimal 訪問介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1231().getValue();
        Decimal 訪問介護要会護１ = div.getPnlMain().getTbl4().getTextBox1232().getValue();
        Decimal 訪問介護要介護２ = div.getPnlMain().getTbl4().getTextBox1233().getValue();
        Decimal 訪問介護要介護３ = div.getPnlMain().getTbl4().getTextBox1234().getValue();
        Decimal 訪問介護要介護４ = div.getPnlMain().getTbl4().getTextBox1235().getValue();
        Decimal 訪問介護要介護５ = div.getPnlMain().getTbl4().getTextBox1236().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1237().getValue();

        return 入力チェック2(訪問介護経過的要介護, 訪問介護要会護１, 訪問介護要介護２,
                訪問介護要介護３, 訪問介護要介護４, 訪問介護要介護５, 訪問介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_4() {

        Decimal 訪問入浴介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1242().getValue();
        Decimal 訪問入浴介護要会護１ = div.getPnlMain().getTbl4().getTextBox1243().getValue();
        Decimal 訪問入浴介護要介護２ = div.getPnlMain().getTbl4().getTextBox1244().getValue();
        Decimal 訪問入浴介護要介護３ = div.getPnlMain().getTbl4().getTextBox1245().getValue();
        Decimal 訪問入浴介護要介護４ = div.getPnlMain().getTbl4().getTextBox1246().getValue();
        Decimal 訪問入浴介護要介護５ = div.getPnlMain().getTbl4().getTextBox1247().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl4().getTextBox1248().getValue();

        return 入力チェック2(訪問入浴介護経過的要介護, 訪問入浴介護要会護１, 訪問入浴介護要介護２,
                訪問入浴介護要介護３, 訪問入浴介護要介護４, 訪問入浴介護要介護５, 訪問入浴介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_5() {

        Decimal 訪問看護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1253().getValue();
        Decimal 訪問看護要会護１ = div.getPnlMain().getTbl4().getTextBox1254().getValue();
        Decimal 訪問看護要介護２ = div.getPnlMain().getTbl4().getTextBox1255().getValue();
        Decimal 訪問看護要介護３ = div.getPnlMain().getTbl4().getTextBox1256().getValue();
        Decimal 訪問看護要介護４ = div.getPnlMain().getTbl4().getTextBox1257().getValue();
        Decimal 訪問看護要介護５ = div.getPnlMain().getTbl4().getTextBox1258().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl4().getTextBox1259().getValue();

        return 入力チェック2(訪問看護経過的要介護, 訪問看護要会護１, 訪問看護要介護２,
                訪問看護要介護３, 訪問看護要介護４, 訪問看護要介護５, 訪問看護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_6() {

        Decimal 訪問リハビリテーション経過的要介護 = div.getPnlMain().getTbl4().getTextBox1264().getValue();
        Decimal 訪問リハビリテーション要会護１ = div.getPnlMain().getTbl4().getTextBox1265().getValue();
        Decimal 訪問リハビリテーション要介護２ = div.getPnlMain().getTbl4().getTextBox1266().getValue();
        Decimal 訪問リハビリテーション要介護３ = div.getPnlMain().getTbl4().getTextBox1267().getValue();
        Decimal 訪問リハビリテーション要介護４ = div.getPnlMain().getTbl4().getTextBox1268().getValue();
        Decimal 訪問リハビリテーション要介護５ = div.getPnlMain().getTbl4().getTextBox1269().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1270().getValue();

        return 入力チェック2(訪問リハビリテーション経過的要介護,
                訪問リハビリテーション要会護１, 訪問リハビリテーション要介護２,
                訪問リハビリテーション要介護３, 訪問リハビリテーション要介護４,
                訪問リハビリテーション要介護５, 訪問リハビリテーション要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_7() {

        Decimal 居宅療養管理指導経過的要介護 = div.getPnlMain().getTbl4().getTextBox1275().getValue();
        Decimal 居宅療養管理指導要会護１ = div.getPnlMain().getTbl4().getTextBox1276().getValue();
        Decimal 居宅療養管理指導要介護２ = div.getPnlMain().getTbl4().getTextBox1277().getValue();
        Decimal 居宅療養管理指導要介護３ = div.getPnlMain().getTbl4().getTextBox1278().getValue();
        Decimal 居宅療養管理指導要介護４ = div.getPnlMain().getTbl4().getTextBox1279().getValue();
        Decimal 居宅療養管理指導要介護５ = div.getPnlMain().getTbl4().getTextBox1280().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl4().getTextBox1281().getValue();

        return 入力チェック2(居宅療養管理指導経過的要介護, 居宅療養管理指導要会護１, 居宅療養管理指導要介護２,
                居宅療養管理指導要介護３, 居宅療養管理指導要介護４, 居宅療養管理指導要介護５, 居宅療養管理指導要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_8() {

        Decimal 通所サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1286().getValue();
        Decimal 通所サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1287().getValue();
        Decimal 通所サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1288().getValue();
        Decimal 通所サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1289().getValue();
        Decimal 通所サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1290().getValue();
        Decimal 通所サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1291().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1292().getValue();

        return 入力チェック2(通所サービス経過的要介護, 通所サービス要会護１, 通所サービス要介護２, 通所サービス要介護３,
                通所サービス要介護４, 通所サービス要介護５, 通所サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_9() {

        Decimal 通所介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1297().getValue();
        Decimal 通所介護要会護１ = div.getPnlMain().getTbl4().getTextBox1298().getValue();
        Decimal 通所介護要介護２ = div.getPnlMain().getTbl4().getTextBox1299().getValue();
        Decimal 通所介護要介護３ = div.getPnlMain().getTbl4().getTextBox1300().getValue();
        Decimal 通所介護要介護４ = div.getPnlMain().getTbl4().getTextBox1301().getValue();
        Decimal 通所介護要介護５ = div.getPnlMain().getTbl4().getTextBox1302().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1303().getValue();

        return 入力チェック2(通所介護経過的要介護, 通所介護要会護１, 通所介護要介護２,
                通所介護要介護３, 通所介護要介護４, 通所介護要介護５, 通所介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_10() {

        Decimal 通所リハビリテーション経過的要介護 = div.getPnlMain().getTbl4().getTextBox1308().getValue();
        Decimal 通所リハビリテーション要会護１ = div.getPnlMain().getTbl4().getTextBox1309().getValue();
        Decimal 通所リハビリテーション要介護２ = div.getPnlMain().getTbl4().getTextBox1310().getValue();
        Decimal 通所リハビリテーション要介護３ = div.getPnlMain().getTbl4().getTextBox1311().getValue();
        Decimal 通所リハビリテーション要介護４ = div.getPnlMain().getTbl4().getTextBox1312().getValue();
        Decimal 通所リハビリテーション要介護５ = div.getPnlMain().getTbl4().getTextBox1313().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1314().getValue();

        return 入力チェック2(通所リハビリテーション経過的要介護,
                通所リハビリテーション要会護１, 通所リハビリテーション要介護２,
                通所リハビリテーション要介護３, 通所リハビリテーション要介護４,
                通所リハビリテーション要介護５, 通所リハビリテーション要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_11() {

        Decimal 短期入所サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1319().getValue();
        Decimal 短期入所サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1320().getValue();
        Decimal 短期入所サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1321().getValue();
        Decimal 短期入所サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1322().getValue();
        Decimal 短期入所サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1323().getValue();
        Decimal 短期入所サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1324().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1325().getValue();

        return 入力チェック2(短期入所サービス経過的要介護,
                短期入所サービス要会護１, 短期入所サービス要介護２, 短期入所サービス要介護３,
                短期入所サービス要介護４, 短期入所サービス要介護５, 短期入所サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_12() {

        Decimal 短期入所生活介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1330().getValue();
        Decimal 短期入所生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1331().getValue();
        Decimal 短期入所生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1332().getValue();
        Decimal 短期入所生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1333().getValue();
        Decimal 短期入所生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1334().getValue();
        Decimal 短期入所生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1335().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1336().getValue();

        return 入力チェック2(短期入所生活介護経過的要介護, 短期入所生活介護要会護１, 短期入所生活介護要介護２,
                短期入所生活介護要介護３, 短期入所生活介護要介護４, 短期入所生活介護要介護５, 短期入所生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_13() {

        Decimal 短期入所療養介護介護老人保健施設経過的要介護 = div.getPnlMain().getTbl4().getTextBox1341().getValue();
        Decimal 短期入所療養介護介護老人保健施設要会護１ = div.getPnlMain().getTbl4().getTextBox1342().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護２ = div.getPnlMain().getTbl4().getTextBox1343().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護３ = div.getPnlMain().getTbl4().getTextBox1344().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護４ = div.getPnlMain().getTbl4().getTextBox1345().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護５ = div.getPnlMain().getTbl4().getTextBox1346().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl4().getTextBox1347().getValue();

        return 入力チェック2(短期入所療養介護介護老人保健施設経過的要介護, 短期入所療養介護介護老人保健施設要会護１,
                短期入所療養介護介護老人保健施設要介護２, 短期入所療養介護介護老人保健施設要介護３,
                短期入所療養介護介護老人保健施設要介護４, 短期入所療養介護介護老人保健施設要介護５,
                短期入所療養介護介護老人保健施設要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_14() {

        Decimal 短期入所療養介護介護療養型医療施設等経過的要介護 = div.getPnlMain().getTbl4().getTextBox1352().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要会護１ = div.getPnlMain().getTbl4().getTextBox1353().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護２ = div.getPnlMain().getTbl4().getTextBox1354().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護３ = div.getPnlMain().getTbl4().getTextBox1355().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護４ = div.getPnlMain().getTbl4().getTextBox1356().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護５ = div.getPnlMain().getTbl4().getTextBox1357().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl4().getTextBox1358().getValue();

        return 入力チェック2(短期入所療養介護介護療養型医療施設等経過的要介護, 短期入所療養介護介護療養型医療施設等要会護１,
                短期入所療養介護介護療養型医療施設等要介護２, 短期入所療養介護介護療養型医療施設等要介護３,
                短期入所療養介護介護療養型医療施設等要介護４, 短期入所療養介護介護療養型医療施設等要介護５,
                短期入所療養介護介護療養型医療施設等要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_15() {

        Decimal 福祉用具住宅改修サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1363().getValue();
        Decimal 福祉用具住宅改修サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1364().getValue();
        Decimal 福祉用具住宅改修サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1365().getValue();
        Decimal 福祉用具住宅改修サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1366().getValue();
        Decimal 福祉用具住宅改修サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1367().getValue();
        Decimal 福祉用具住宅改修サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1368().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1369().getValue();

        return 入力チェック2(福祉用具住宅改修サービス経過的要介護,
                福祉用具住宅改修サービス要会護１, 福祉用具住宅改修サービス要介護２,
                福祉用具住宅改修サービス要介護３, 福祉用具住宅改修サービス要介護４,
                福祉用具住宅改修サービス要介護５, 福祉用具住宅改修サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_16() {

        Decimal 福祉用具貸与経過的要介護 = div.getPnlMain().getTbl4().getTextBox1374().getValue();
        Decimal 福祉用具貸与要会護１ = div.getPnlMain().getTbl4().getTextBox1375().getValue();
        Decimal 福祉用具貸与要介護２ = div.getPnlMain().getTbl4().getTextBox1376().getValue();
        Decimal 福祉用具貸与要介護３ = div.getPnlMain().getTbl4().getTextBox1377().getValue();
        Decimal 福祉用具貸与要介護４ = div.getPnlMain().getTbl4().getTextBox1378().getValue();
        Decimal 福祉用具貸与要介護５ = div.getPnlMain().getTbl4().getTextBox1379().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl4().getTextBox1380().getValue();

        return 入力チェック2(福祉用具貸与経過的要介護, 福祉用具貸与要会護１, 福祉用具貸与要介護２, 福祉用具貸与要介護３,
                福祉用具貸与要介護４, 福祉用具貸与要介護５, 福祉用具貸与要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_17() {

        Decimal 福祉用具購入費経過的要介護 = div.getPnlMain().getTbl4().getTextBox1385().getValue();
        Decimal 福祉用具購入費要会護１ = div.getPnlMain().getTbl4().getTextBox1386().getValue();
        Decimal 福祉用具購入費要介護２ = div.getPnlMain().getTbl4().getTextBox1387().getValue();
        Decimal 福祉用具購入費要介護３ = div.getPnlMain().getTbl4().getTextBox1388().getValue();
        Decimal 福祉用具購入費要介護４ = div.getPnlMain().getTbl4().getTextBox1389().getValue();
        Decimal 福祉用具購入費要介護５ = div.getPnlMain().getTbl4().getTextBox1390().getValue();
        Decimal 福祉用具購入費要介護計 = div.getPnlMain().getTbl4().getTextBox1391().getValue();

        return 入力チェック2(福祉用具購入費経過的要介護,
                福祉用具購入費要会護１, 福祉用具購入費要介護２, 福祉用具購入費要介護３,
                福祉用具購入費要介護４, 福祉用具購入費要介護５, 福祉用具購入費要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_18() {

        Decimal 住宅改修費経過的要介護 = div.getPnlMain().getTbl4().getTextBox1396().getValue();
        Decimal 住宅改修費要会護１ = div.getPnlMain().getTbl4().getTextBox1397().getValue();
        Decimal 住宅改修費要介護２ = div.getPnlMain().getTbl4().getTextBox1398().getValue();
        Decimal 住宅改修費要介護３ = div.getPnlMain().getTbl4().getTextBox1399().getValue();
        Decimal 住宅改修費要介護４ = div.getPnlMain().getTbl4().getTextBox1400().getValue();
        Decimal 住宅改修費要介護５ = div.getPnlMain().getTbl4().getTextBox1401().getValue();
        Decimal 住宅改修費要介護計 = div.getPnlMain().getTbl4().getTextBox1402().getValue();

        return 入力チェック2(住宅改修費経過的要介護, 住宅改修費要会護１,
                住宅改修費要介護２, 住宅改修費要介護３, 住宅改修費要介護４,
                住宅改修費要介護５, 住宅改修費要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_19() {

        Decimal 特定施設入居者生活介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1407().getValue();
        Decimal 特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1408().getValue();
        Decimal 特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1409().getValue();
        Decimal 特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1410().getValue();
        Decimal 特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1411().getValue();
        Decimal 特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1412().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1413().getValue();

        return 入力チェック2(特定施設入居者生活介護経過的要介護,
                特定施設入居者生活介護要会護１, 特定施設入居者生活介護要介護２,
                特定施設入居者生活介護要介護３, 特定施設入居者生活介護要介護４,
                特定施設入居者生活介護要介護５, 特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_20() {

        Decimal 介護予防支援居宅介護支援経過的要介護 = div.getPnlMain().getTbl4().getTextBox1418().getValue();
        Decimal 介護予防支援居宅介護支援要会護１ = div.getPnlMain().getTbl4().getTextBox1419().getValue();
        Decimal 介護予防支援居宅介護支援要介護２ = div.getPnlMain().getTbl4().getTextBox1420().getValue();
        Decimal 介護予防支援居宅介護支援要介護３ = div.getPnlMain().getTbl4().getTextBox1421().getValue();
        Decimal 介護予防支援居宅介護支援要介護４ = div.getPnlMain().getTbl4().getTextBox1422().getValue();
        Decimal 介護予防支援居宅介護支援要介護５ = div.getPnlMain().getTbl4().getTextBox1423().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl4().getTextBox1424().getValue();

        return 入力チェック2(介護予防支援居宅介護支援経過的要介護,
                介護予防支援居宅介護支援要会護１, 介護予防支援居宅介護支援要介護２,
                介護予防支援居宅介護支援要介護３, 介護予防支援居宅介護支援要介護４,
                介護予防支援居宅介護支援要介護５, 介護予防支援居宅介護支援要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_21() {

        Decimal 地域密着型介護予防サービス経過的要介護 = div.getPnlMain().getTbl4().getTextBox1429().getValue();
        Decimal 地域密着型介護予防サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1430().getValue();
        Decimal 地域密着型介護予防サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1431().getValue();
        Decimal 地域密着型介護予防サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1432().getValue();
        Decimal 地域密着型介護予防サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1433().getValue();
        Decimal 地域密着型介護予防サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1434().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1435().getValue();

        return 入力チェック2(地域密着型介護予防サービス経過的要介護,
                地域密着型介護予防サービス要会護１, 地域密着型介護予防サービス要介護２,
                地域密着型介護予防サービス要介護３, 地域密着型介護予防サービス要介護４, 地域密着型介護予防サービス要介護５,
                地域密着型介護予防サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_22() {

        Decimal 定期巡回随時対応型訪問介護看護経過的要介護 = Decimal.ZERO;
        Decimal 定期巡回随時対応型訪問介護看護要会護１ = div.getPnlMain().getTbl4().getTextBox1440().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護２ = div.getPnlMain().getTbl4().getTextBox1441().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護３ = div.getPnlMain().getTbl4().getTextBox1442().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護４ = div.getPnlMain().getTbl4().getTextBox1443().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護５ = div.getPnlMain().getTbl4().getTextBox1444().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl4().getTextBox1445().getValue();

        return 入力チェック2(定期巡回随時対応型訪問介護看護経過的要介護,
                定期巡回随時対応型訪問介護看護要会護１, 定期巡回随時対応型訪問介護看護要介護２,
                定期巡回随時対応型訪問介護看護要介護３, 定期巡回随時対応型訪問介護看護要介護４,
                定期巡回随時対応型訪問介護看護要介護５, 定期巡回随時対応型訪問介護看護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_23() {

        Decimal 夜間対応型訪問介護経過的要介護 = Decimal.ZERO;
        Decimal 夜間対応型訪問介護要会護１ = div.getPnlMain().getTbl4().getTextBox1450().getValue();
        Decimal 夜間対応型訪問介護要介護２ = div.getPnlMain().getTbl4().getTextBox1451().getValue();
        Decimal 夜間対応型訪問介護要介護３ = div.getPnlMain().getTbl4().getTextBox1452().getValue();
        Decimal 夜間対応型訪問介護要介護４ = div.getPnlMain().getTbl4().getTextBox1453().getValue();
        Decimal 夜間対応型訪問介護要介護５ = div.getPnlMain().getTbl4().getTextBox1454().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1455().getValue();

        return 入力チェック2(夜間対応型訪問介護経過的要介護, 夜間対応型訪問介護要会護１,
                夜間対応型訪問介護要介護２, 夜間対応型訪問介護要介護３,
                夜間対応型訪問介護要介護４, 夜間対応型訪問介護要介護５, 夜間対応型訪問介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_24() {

        Decimal 認知症対応型通所介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1460().getValue();
        Decimal 認知症対応型通所介護要会護１ = div.getPnlMain().getTbl4().getTextBox1461().getValue();
        Decimal 認知症対応型通所介護要介護２ = div.getPnlMain().getTbl4().getTextBox1462().getValue();
        Decimal 認知症対応型通所介護要介護３ = div.getPnlMain().getTbl4().getTextBox1463().getValue();
        Decimal 認知症対応型通所介護要介護４ = div.getPnlMain().getTbl4().getTextBox1464().getValue();
        Decimal 認知症対応型通所介護要介護５ = div.getPnlMain().getTbl4().getTextBox1465().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1466().getValue();

        return 入力チェック2(認知症対応型通所介護経過的要介護,
                認知症対応型通所介護要会護１, 認知症対応型通所介護要介護２, 認知症対応型通所介護要介護３,
                認知症対応型通所介護要介護４, 認知症対応型通所介護要介護５, 認知症対応型通所介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_25() {

        Decimal 小規模多機能型居宅介護経過的要介護 = div.getPnlMain().getTbl4().getTextBox1471().getValue();
        Decimal 小規模多機能型居宅介護要会護１ = div.getPnlMain().getTbl4().getTextBox1472().getValue();
        Decimal 小規模多機能型居宅介護要介護２ = div.getPnlMain().getTbl4().getTextBox1473().getValue();
        Decimal 小規模多機能型居宅介護要介護３ = div.getPnlMain().getTbl4().getTextBox1474().getValue();
        Decimal 小規模多機能型居宅介護要介護４ = div.getPnlMain().getTbl4().getTextBox1475().getValue();
        Decimal 小規模多機能型居宅介護要介護５ = div.getPnlMain().getTbl4().getTextBox1476().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl4().getTextBox1477().getValue();

        return 入力チェック2(小規模多機能型居宅介護経過的要介護,
                小規模多機能型居宅介護要会護１, 小規模多機能型居宅介護要介護２,
                小規模多機能型居宅介護要介護３, 小規模多機能型居宅介護要介護４,
                小規模多機能型居宅介護要介護５, 小規模多機能型居宅介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_26() {

        Decimal 認知症対応型共同生活介護経過的要介護 = Decimal.ZERO;
        Decimal 認知症対応型共同生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1482().getValue();
        Decimal 認知症対応型共同生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1483().getValue();
        Decimal 認知症対応型共同生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1484().getValue();
        Decimal 認知症対応型共同生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1485().getValue();
        Decimal 認知症対応型共同生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1486().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1487().getValue();

        return 入力チェック2(認知症対応型共同生活介護経過的要介護,
                認知症対応型共同生活介護要会護１, 認知症対応型共同生活介護要介護２,
                認知症対応型共同生活介護要介護３, 認知症対応型共同生活介護要介護４,
                認知症対応型共同生活介護要介護５, 認知症対応型共同生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_27() {

        Decimal 地域密着型特定施設入居者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1492().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1493().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1494().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1495().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1496().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1497().getValue();

        return 入力チェック2(地域密着型特定施設入居者生活介護経過的要介護,
                地域密着型特定施設入居者生活介護要会護１, 地域密着型特定施設入居者生活介護要介護２,
                地域密着型特定施設入居者生活介護要介護３, 地域密着型特定施設入居者生活介護要介護４,
                地域密着型特定施設入居者生活介護要介護５, 地域密着型特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型介護老人福祉施設入所者生活介護要会護１ = div.getPnlMain().getTbl4().getTextBox1502().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護２ = div.getPnlMain().getTbl4().getTextBox1503().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護３ = div.getPnlMain().getTbl4().getTextBox1504().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護４ = div.getPnlMain().getTbl4().getTextBox1505().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護５ = div.getPnlMain().getTbl4().getTextBox1506().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1507().getValue();

        return 入力チェック2(地域密着型介護老人福祉施設入所者生活介護経過的要介護,
                地域密着型介護老人福祉施設入所者生活介護要会護１, 地域密着型介護老人福祉施設入所者生活介護要介護２,
                地域密着型介護老人福祉施設入所者生活介護要介護３, 地域密着型介護老人福祉施設入所者生活介護要介護４,
                地域密着型介護老人福祉施設入所者生活介護要介護５, 地域密着型介護老人福祉施設入所者生活介護要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_29() {

        Decimal 複合型サービス経過的要介護 = Decimal.ZERO;
        Decimal 複合型サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1512().getValue();
        Decimal 複合型サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1513().getValue();
        Decimal 複合型サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1514().getValue();
        Decimal 複合型サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1515().getValue();
        Decimal 複合型サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1516().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1517().getValue();

        return 入力チェック2(複合型サービス経過的要介護,
                複合型サービス要会護１, 複合型サービス要介護２, 複合型サービス要介護３,
                複合型サービス要介護４, 複合型サービス要介護５, 複合型サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_30() {

        Decimal 施設サービス経過的要介護 = Decimal.ZERO;
        Decimal 施設サービス要会護１ = div.getPnlMain().getTbl4().getTextBox1523().getValue();
        Decimal 施設サービス要介護２ = div.getPnlMain().getTbl4().getTextBox1524().getValue();
        Decimal 施設サービス要介護３ = div.getPnlMain().getTbl4().getTextBox1525().getValue();
        Decimal 施設サービス要介護４ = div.getPnlMain().getTbl4().getTextBox1526().getValue();
        Decimal 施設サービス要介護５ = div.getPnlMain().getTbl4().getTextBox1527().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1528().getValue();

        return 入力チェック2(施設サービス経過的要介護, 施設サービス要会護１,
                施設サービス要介護２, 施設サービス要介護３, 施設サービス要介護４,
                施設サービス要介護５, 施設サービス要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_31() {

        Decimal 介護老人福祉施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_1_要会護１ = div.getPnlMain().getTbl4().getTextBox1534().getValue();
        Decimal 介護老人福祉施設_1_要介護２ = div.getPnlMain().getTbl4().getTextBox1535().getValue();
        Decimal 介護老人福祉施設_1_要介護３ = div.getPnlMain().getTbl4().getTextBox1536().getValue();
        Decimal 介護老人福祉施設_1_要介護４ = div.getPnlMain().getTbl4().getTextBox1537().getValue();
        Decimal 介護老人福祉施設_1_要介護５ = div.getPnlMain().getTbl4().getTextBox1538().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1539().getValue();

        return 入力チェック2(介護老人福祉施設_1_経過的要介護,
                介護老人福祉施設_1_要会護１, 介護老人福祉施設_1_要介護２,
                介護老人福祉施設_1_要介護３, 介護老人福祉施設_1_要介護４,
                介護老人福祉施設_1_要介護５, 介護老人福祉施設_1_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_32() {

        Decimal 介護老人保健施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_1_要会護１ = div.getPnlMain().getTbl4().getTextBox1544().getValue();
        Decimal 介護老人保健施設_1_要介護２ = div.getPnlMain().getTbl4().getTextBox1545().getValue();
        Decimal 介護老人保健施設_1_要介護３ = div.getPnlMain().getTbl4().getTextBox1546().getValue();
        Decimal 介護老人保健施設_1_要介護４ = div.getPnlMain().getTbl4().getTextBox1547().getValue();
        Decimal 介護老人保健施設_1_要介護５ = div.getPnlMain().getTbl4().getTextBox1548().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1549().getValue();

        return 入力チェック2(介護老人保健施設_1_経過的要介護,
                介護老人保健施設_1_要会護１, 介護老人保健施設_1_要介護２, 介護老人保健施設_1_要介護３,
                介護老人保健施設_1_要介護４, 介護老人保健施設_1_要介護５, 介護老人保健施設_1_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_33() {

        Decimal 介護療養型医療施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_1_要会護１ = div.getPnlMain().getTbl4().getTextBox1554().getValue();
        Decimal 介護療養型医療施設_1_要介護２ = div.getPnlMain().getTbl4().getTextBox1555().getValue();
        Decimal 介護療養型医療施設_1_要介護３ = div.getPnlMain().getTbl4().getTextBox1556().getValue();
        Decimal 介護療養型医療施設_1_要介護４ = div.getPnlMain().getTbl4().getTextBox1557().getValue();
        Decimal 介護療養型医療施設_1_要介護５ = div.getPnlMain().getTbl4().getTextBox1558().getValue();
        Decimal 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1559().getValue();

        return 入力チェック2(介護療養型医療施設_1_経過的要介護,
                介護療養型医療施設_1_要会護１, 介護療養型医療施設_1_要介護２, 介護療養型医療施設_1_要介護３,
                介護療養型医療施設_1_要介護４, 介護療養型医療施設_1_要介護５, 介護療養型医療施設_1_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_34() {

        Decimal 食事提供費用再掲経過的要介護 = Decimal.ZERO;
        Decimal 食事提供費用再掲要会護１ = div.getPnlMain().getTbl4().getTextBox1565().getValue();
        Decimal 食事提供費用再掲要介護２ = div.getPnlMain().getTbl4().getTextBox1566().getValue();
        Decimal 食事提供費用再掲要介護３ = div.getPnlMain().getTbl4().getTextBox1567().getValue();
        Decimal 食事提供費用再掲要介護４ = div.getPnlMain().getTbl4().getTextBox1568().getValue();
        Decimal 食事提供費用再掲要介護５ = div.getPnlMain().getTbl4().getTextBox1569().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl4().getTextBox1570().getValue();

        return 入力チェック2(食事提供費用再掲経過的要介護,
                食事提供費用再掲要会護１, 食事提供費用再掲要介護２, 食事提供費用再掲要介護３,
                食事提供費用再掲要介護４, 食事提供費用再掲要介護５, 食事提供費用再掲要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_35() {

        Decimal 介護老人福祉施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_2_要会護１ = div.getPnlMain().getTbl4().getTextBox1576().getValue();
        Decimal 介護老人福祉施設_2_要介護２ = div.getPnlMain().getTbl4().getTextBox1577().getValue();
        Decimal 介護老人福祉施設_2_要介護３ = div.getPnlMain().getTbl4().getTextBox1578().getValue();
        Decimal 介護老人福祉施設_2_要介護４ = div.getPnlMain().getTbl4().getTextBox1579().getValue();
        Decimal 介護老人福祉施設_2_要介護５ = div.getPnlMain().getTbl4().getTextBox1580().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1581().getValue();

        return 入力チェック2(介護老人福祉施設_2_経過的要介護,
                介護老人福祉施設_2_要会護１, 介護老人福祉施設_2_要介護２, 介護老人福祉施設_2_要介護３,
                介護老人福祉施設_2_要介護４, 介護老人福祉施設_2_要介護５, 介護老人福祉施設_2_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_36() {

        Decimal 介護老人保健施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_2_要会護１ = div.getPnlMain().getTbl4().getTextBox1586().getValue();
        Decimal 介護老人保健施設_2_要介護２ = div.getPnlMain().getTbl4().getTextBox1587().getValue();
        Decimal 介護老人保健施設_2_要介護３ = div.getPnlMain().getTbl4().getTextBox1588().getValue();
        Decimal 介護老人保健施設_2_要介護４ = div.getPnlMain().getTbl4().getTextBox1589().getValue();
        Decimal 介護老人保健施設_2_要介護５ = div.getPnlMain().getTbl4().getTextBox1590().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1591().getValue();

        return 入力チェック2(介護老人保健施設_2_経過的要介護,
                介護老人保健施設_2_要会護１, 介護老人保健施設_2_要介護２, 介護老人保健施設_2_要介護３,
                介護老人保健施設_2_要介護４, 介護老人保健施設_2_要介護５, 介護老人保健施設_2_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_37() {

        Decimal 介護療養型医療施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_2_要会護１ = div.getPnlMain().getTbl4().getTextBox1596().getValue();
        Decimal 介護療養型医療施設_2_要介護２ = div.getPnlMain().getTbl4().getTextBox1597().getValue();
        Decimal 介護療養型医療施設_2_要介護３ = div.getPnlMain().getTbl4().getTextBox1598().getValue();
        Decimal 介護療養型医療施設_2_要介護４ = div.getPnlMain().getTbl4().getTextBox1599().getValue();
        Decimal 介護療養型医療施設_2_要介護５ = div.getPnlMain().getTbl4().getTextBox1600().getValue();
        Decimal 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1601().getValue();

        return 入力チェック2(介護療養型医療施設_2_経過的要介護,
                介護療養型医療施設_2_要会護１, 介護療養型医療施設_2_要介護２, 介護療養型医療施設_2_要介護３,
                介護療養型医療施設_2_要介護４, 介護療養型医療施設_2_要介護５, 介護療養型医療施設_2_要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1_38() {

        Decimal 総計経過的要介護 = div.getPnlMain().getTbl4().getTextBox1608().getValue();
        Decimal 総計要会護１ = div.getPnlMain().getTbl4().getTextBox1609().getValue();
        Decimal 総計要介護２ = div.getPnlMain().getTbl4().getTextBox1610().getValue();
        Decimal 総計要介護３ = div.getPnlMain().getTbl4().getTextBox1611().getValue();
        Decimal 総計要介護４ = div.getPnlMain().getTbl4().getTextBox1612().getValue();
        Decimal 総計要介護５ = div.getPnlMain().getTbl4().getTextBox1613().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl4().getTextBox1614().getValue();

        return 入力チェック2(総計経過的要介護, 総計要会護１, 総計要介護２,
                総計要介護３, 総計要介護４, 総計要介護５, 総計要介護計);
    }

    private boolean is整合性チェック_給付額_NG_1() {

        Decimal 居宅介護予防サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1206().getValue();
        Decimal 居宅介護予防サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1207().getValue();
        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1208().getValue();

        return 入力チェック1(居宅介護予防サービス要支援１,
                居宅介護予防サービス要支援２, 居宅介護予防サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_2() {

        Decimal 訪問サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1217().getValue();
        Decimal 訪問サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1218().getValue();
        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1219().getValue();

        return 入力チェック1(訪問サービス要支援１, 訪問サービス要支援２, 訪問サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_3() {

        Decimal 訪問介護要支援１ = div.getPnlMain().getTbl4().getTextBox1228().getValue();
        Decimal 訪問介護要支援２ = div.getPnlMain().getTbl4().getTextBox1229().getValue();
        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1230().getValue();

        return 入力チェック1(訪問介護要支援１, 訪問介護要支援２, 訪問介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_4() {

        Decimal 訪問入浴介護要支援１ = div.getPnlMain().getTbl4().getTextBox1239().getValue();
        Decimal 訪問入浴介護要支援２ = div.getPnlMain().getTbl4().getTextBox1240().getValue();
        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl4().getTextBox1241().getValue();

        return 入力チェック1(訪問入浴介護要支援１, 訪問入浴介護要支援２, 訪問入浴介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_5() {

        Decimal 訪問看護要支援１ = div.getPnlMain().getTbl4().getTextBox1250().getValue();
        Decimal 訪問看護要支援２ = div.getPnlMain().getTbl4().getTextBox1251().getValue();
        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl4().getTextBox1252().getValue();

        return 入力チェック1(訪問看護要支援１, 訪問看護要支援２, 訪問看護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_6() {

        Decimal 訪問リハビリテーション要支援１ = div.getPnlMain().getTbl4().getTextBox1261().getValue();
        Decimal 訪問リハビリテーション要支援２ = div.getPnlMain().getTbl4().getTextBox1262().getValue();
        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1263().getValue();

        return 入力チェック1(訪問リハビリテーション要支援１,
                訪問リハビリテーション要支援２, 訪問リハビリテーション要支援計);
    }

    private boolean is整合性チェック_給付額_NG_7() {

        Decimal 居宅療養管理指導要支援１ = div.getPnlMain().getTbl4().getTextBox1272().getValue();
        Decimal 居宅療養管理指導要支援２ = div.getPnlMain().getTbl4().getTextBox1273().getValue();
        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl4().getTextBox1274().getValue();

        return 入力チェック1(居宅療養管理指導要支援１, 居宅療養管理指導要支援２, 居宅療養管理指導要支援計);
    }

    private boolean is整合性チェック_給付額_NG_8() {

        Decimal 通所サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1283().getValue();
        Decimal 通所サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1284().getValue();
        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1285().getValue();

        return 入力チェック1(通所サービス要支援１, 通所サービス要支援２, 通所サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_9() {

        Decimal 通所介護要支援１ = div.getPnlMain().getTbl4().getTextBox1294().getValue();
        Decimal 通所介護要支援２ = div.getPnlMain().getTbl4().getTextBox1295().getValue();
        Decimal 通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1296().getValue();

        return 入力チェック1(通所介護要支援１, 通所介護要支援２, 通所介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_10() {

        Decimal 通所リハビリテーション要支援１ = div.getPnlMain().getTbl4().getTextBox1305().getValue();
        Decimal 通所リハビリテーション要支援２ = div.getPnlMain().getTbl4().getTextBox1306().getValue();
        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1307().getValue();

        return 入力チェック1(通所リハビリテーション要支援１, 通所リハビリテーション要支援２, 通所リハビリテーション要支援計);
    }

    private boolean is整合性チェック_給付額_NG_11() {

        Decimal 短期入所サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1316().getValue();
        Decimal 短期入所サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1317().getValue();
        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1318().getValue();

        return 入力チェック1(短期入所サービス要支援１, 短期入所サービス要支援２, 短期入所サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_12() {

        Decimal 短期入所生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1327().getValue();
        Decimal 短期入所生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1328().getValue();
        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1329().getValue();

        return 入力チェック1(短期入所生活介護要支援１, 短期入所生活介護要支援２, 短期入所生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援１ = div.getPnlMain().getTbl4().getTextBox1338().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援２ = div.getPnlMain().getTbl4().getTextBox1339().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl4().getTextBox1340().getValue();

        return 入力チェック1(短期入所療養介護介護老人保健施設要支援１,
                短期入所療養介護介護老人保健施設要支援２, 短期入所療養介護介護老人保健施設要支援計);
    }

    private boolean is整合性チェック_給付額_NG_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援１ = div.getPnlMain().getTbl4().getTextBox1349().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援２ = div.getPnlMain().getTbl4().getTextBox1350().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl4().getTextBox1351().getValue();

        return 入力チェック1(短期入所療養介護介護療養型医療施設等要支援１, 短期入所療養介護介護療養型医療施設等要支援２,
                短期入所療養介護介護療養型医療施設等要支援計);
    }

    private boolean is整合性チェック_給付額_NG_15() {

        Decimal 福祉用具住宅改修サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1360().getValue();
        Decimal 福祉用具住宅改修サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1361().getValue();
        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1362().getValue();

        return 入力チェック1(福祉用具住宅改修サービス要支援１,
                福祉用具住宅改修サービス要支援２, 福祉用具住宅改修サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_16() {

        Decimal 福祉用具貸与要支援１ = div.getPnlMain().getTbl4().getTextBox1371().getValue();
        Decimal 福祉用具貸与要支援２ = div.getPnlMain().getTbl4().getTextBox1372().getValue();
        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl4().getTextBox1373().getValue();

        return 入力チェック1(福祉用具貸与要支援１, 福祉用具貸与要支援２, 福祉用具貸与要支援計);
    }

    private boolean is整合性チェック_給付額_NG_17() {

        Decimal 福祉用具購入費要支援１ = div.getPnlMain().getTbl4().getTextBox1382().getValue();
        Decimal 福祉用具購入費要支援２ = div.getPnlMain().getTbl4().getTextBox1383().getValue();
        Decimal 福祉用具購入費要支援計 = div.getPnlMain().getTbl4().getTextBox1384().getValue();

        return 入力チェック1(福祉用具購入費要支援１, 福祉用具購入費要支援２, 福祉用具購入費要支援計);
    }

    private boolean is整合性チェック_給付額_NG_18() {

        Decimal 住宅改修費要支援１ = div.getPnlMain().getTbl4().getTextBox1393().getValue();
        Decimal 住宅改修費要支援２ = div.getPnlMain().getTbl4().getTextBox1394().getValue();
        Decimal 住宅改修費要支援計 = div.getPnlMain().getTbl4().getTextBox1395().getValue();

        return 入力チェック1(住宅改修費要支援１, 住宅改修費要支援２, 住宅改修費要支援計);
    }

    private boolean is整合性チェック_給付額_NG_19() {

        Decimal 特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1404().getValue();
        Decimal 特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1405().getValue();
        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1406().getValue();

        return 入力チェック1(特定施設入居者生活介護要支援１, 特定施設入居者生活介護要支援２, 特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_20() {

        Decimal 介護予防支援居宅介護支援要支援１ = div.getPnlMain().getTbl4().getTextBox1415().getValue();
        Decimal 介護予防支援居宅介護支援要支援２ = div.getPnlMain().getTbl4().getTextBox1416().getValue();
        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl4().getTextBox1417().getValue();

        return 入力チェック1(介護予防支援居宅介護支援要支援１,
                介護予防支援居宅介護支援要支援２, 介護予防支援居宅介護支援要支援計);
    }

    private boolean is整合性チェック_給付額_NG_21() {

        Decimal 地域密着型介護予防サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1426().getValue();
        Decimal 地域密着型介護予防サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1427().getValue();
        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1428().getValue();

        return 入力チェック1(地域密着型介護予防サービス要支援１,
                地域密着型介護予防サービス要支援２, 地域密着型介護予防サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援１ = div.getPnlMain().getTbl4().getTextBox1437().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援２ = div.getPnlMain().getTbl4().getTextBox1438().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl4().getTextBox1439().getValue();

        return 入力チェック1(定期巡回随時対応型訪問介護看護要支援１,
                定期巡回随時対応型訪問介護看護要支援２, 定期巡回随時対応型訪問介護看護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_23() {

        Decimal 夜間対応型訪問介護要支援１ = div.getPnlMain().getTbl4().getTextBox1447().getValue();
        Decimal 夜間対応型訪問介護要支援２ = div.getPnlMain().getTbl4().getTextBox1448().getValue();
        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1449().getValue();

        return 入力チェック1(夜間対応型訪問介護要支援１, 夜間対応型訪問介護要支援２, 夜間対応型訪問介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_24() {

        Decimal 認知症対応型通所介護要支援１ = div.getPnlMain().getTbl4().getTextBox1457().getValue();
        Decimal 認知症対応型通所介護要支援２ = div.getPnlMain().getTbl4().getTextBox1458().getValue();
        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1459().getValue();

        return 入力チェック1(認知症対応型通所介護要支援１, 認知症対応型通所介護要支援２, 認知症対応型通所介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_25() {

        Decimal 小規模多機能型居宅介護要支援１ = div.getPnlMain().getTbl4().getTextBox1468().getValue();
        Decimal 小規模多機能型居宅介護要支援２ = div.getPnlMain().getTbl4().getTextBox1469().getValue();
        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl4().getTextBox1470().getValue();

        return 入力チェック1(小規模多機能型居宅介護要支援１, 小規模多機能型居宅介護要支援２, 小規模多機能型居宅介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_26() {

        Decimal 認知症対応型共同生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1479().getValue();
        Decimal 認知症対応型共同生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1480().getValue();
        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1481().getValue();

        return 入力チェック1(認知症対応型共同生活介護要支援１,
                認知症対応型共同生活介護要支援２, 認知症対応型共同生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1489().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1490().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1491().getValue();

        return 入力チェック1(地域密着型特定施設入居者生活介護要支援１,
                地域密着型特定施設入居者生活介護要支援２, 地域密着型特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援１ = div.getPnlMain().getTbl4().getTextBox1499().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援２ = div.getPnlMain().getTbl4().getTextBox1500().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1501().getValue();

        return 入力チェック1(地域密着型介護老人福祉施設入所者生活介護要支援１, 地域密着型介護老人福祉施設入所者生活介護要支援２,
                地域密着型介護老人福祉施設入所者生活介護要支援計);
    }

    private boolean is整合性チェック_給付額_NG_29() {

        Decimal 複合型サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1509().getValue();
        Decimal 複合型サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1510().getValue();
        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1511().getValue();

        return 入力チェック1(複合型サービス要支援１, 複合型サービス要支援２, 複合型サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_30() {

        Decimal 施設サービス要支援１ = div.getPnlMain().getTbl4().getTextBox1519().getValue();
        Decimal 施設サービス要支援２ = div.getPnlMain().getTbl4().getTextBox1520().getValue();
        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1521().getValue();

        return 入力チェック1(施設サービス要支援１, 施設サービス要支援２, 施設サービス要支援計);
    }

    private boolean is整合性チェック_給付額_NG_31() {

        Decimal 介護老人福祉施設_1_要支援１ = div.getPnlMain().getTbl4().getTextBox1530().getValue();
        Decimal 介護老人福祉施設_1_要支援２ = div.getPnlMain().getTbl4().getTextBox1531().getValue();
        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1532().getValue();

        return 入力チェック1(介護老人福祉施設_1_要支援１, 介護老人福祉施設_1_要支援２, 介護老人福祉施設_1_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_32() {

        Decimal 介護老人保健施設_1_要支援１ = div.getPnlMain().getTbl4().getTextBox1541().getValue();
        Decimal 介護老人保健施設_1_要支援２ = div.getPnlMain().getTbl4().getTextBox1542().getValue();
        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1543().getValue();

        return 入力チェック1(介護老人保健施設_1_要支援１, 介護老人保健施設_1_要支援２, 介護老人保健施設_1_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_33() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl4().getTextBox1551().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl4().getTextBox1552().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1553().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_給付額_NG_34() {

        Decimal 食事提供費用再掲要支援１ = div.getPnlMain().getTbl4().getTextBox1561().getValue();
        Decimal 食事提供費用再掲要支援２ = div.getPnlMain().getTbl4().getTextBox1562().getValue();
        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl4().getTextBox1563().getValue();

        return 入力チェック1(食事提供費用再掲要支援１, 食事提供費用再掲要支援２, 食事提供費用再掲要支援計);
    }

    private boolean is整合性チェック_給付額_NG_35() {

        Decimal 介護老人福祉施設_2_要支援１ = div.getPnlMain().getTbl4().getTextBox1572().getValue();
        Decimal 介護老人福祉施設_2_要支援２ = div.getPnlMain().getTbl4().getTextBox1573().getValue();
        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1574().getValue();

        return 入力チェック1(介護老人福祉施設_2_要支援１, 介護老人福祉施設_2_要支援２, 介護老人福祉施設_2_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_36() {

        Decimal 介護老人保健施設_2_要支援１ = div.getPnlMain().getTbl4().getTextBox1583().getValue();
        Decimal 介護老人保健施設_2_要支援２ = div.getPnlMain().getTbl4().getTextBox1584().getValue();
        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1585().getValue();

        return 入力チェック1(介護老人保健施設_2_要支援１, 介護老人保健施設_2_要支援２, 介護老人保健施設_2_要支援計);
    }

    private boolean is整合性チェック_給付額_NG_37() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl4().getTextBox1593().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl4().getTextBox1594().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1595().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_給付額_NG_38() {

        Decimal 総計要支援１ = div.getPnlMain().getTbl4().getTextBox1603().getValue();
        Decimal 総計要支援２ = div.getPnlMain().getTbl4().getTextBox1604().getValue();
        Decimal 総計要支援計 = div.getPnlMain().getTbl4().getTextBox1605().getValue();

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

        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1208().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1215().getValue();
        Decimal 居宅介護予防サービス合計 = div.getPnlMain().getTbl4().getTextBox1216().getValue();

        return 入力チェック3(居宅介護予防サービス要支援計, 居宅介護予防サービス要介護計, 居宅介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_2() {

        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1219().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1226().getValue();
        Decimal 訪問サービス合計 = div.getPnlMain().getTbl4().getTextBox1227().getValue();

        return 入力チェック3(訪問サービス要支援計, 訪問サービス要介護計, 訪問サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_3() {

        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1230().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1237().getValue();
        Decimal 訪問介護合計 = div.getPnlMain().getTbl4().getTextBox1238().getValue();

        return 入力チェック3(訪問介護要支援計, 訪問介護要介護計, 訪問介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_4() {

        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl4().getTextBox1241().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl4().getTextBox1248().getValue();
        Decimal 訪問入浴介護合計 = div.getPnlMain().getTbl4().getTextBox1249().getValue();

        return 入力チェック3(訪問入浴介護要支援計, 訪問入浴介護要介護計, 訪問入浴介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_5() {

        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl4().getTextBox1252().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl4().getTextBox1259().getValue();
        Decimal 訪問看護要合計 = div.getPnlMain().getTbl4().getTextBox1260().getValue();

        return 入力チェック3(訪問看護要支援計, 訪問看護要介護計, 訪問看護要合計);
    }

    private boolean is整合性チェック_NG_給付額_3_6() {

        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1263().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1270().getValue();
        Decimal 訪問リハビリテーション合計 = div.getPnlMain().getTbl4().getTextBox1271().getValue();

        return 入力チェック3(訪問リハビリテーション要支援計, 訪問リハビリテーション要介護計, 訪問リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_給付額_3_7() {

        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl4().getTextBox1274().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl4().getTextBox1281().getValue();
        Decimal 居宅療養管理指導合計 = div.getPnlMain().getTbl4().getTextBox1282().getValue();

        return 入力チェック3(居宅療養管理指導要支援計, 居宅療養管理指導要介護計, 居宅療養管理指導合計);
    }

    private boolean is整合性チェック_NG_給付額_3_8() {

        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1285().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1292().getValue();
        Decimal 通所サービス要合計 = div.getPnlMain().getTbl4().getTextBox1293().getValue();

        return 入力チェック3(通所サービス要支援計, 通所サービス要介護計, 通所サービス要合計);
    }

    private boolean is整合性チェック_NG_給付額_3_9() {

        Decimal 通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1296().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1303().getValue();
        Decimal 通所介護合計 = div.getPnlMain().getTbl4().getTextBox1304().getValue();

        return 入力チェック3(通所介護要支援計, 通所介護要介護計, 通所介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_10() {

        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl4().getTextBox1307().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl4().getTextBox1314().getValue();
        Decimal 通所リハビリテーション合計 = div.getPnlMain().getTbl4().getTextBox1315().getValue();

        return 入力チェック3(通所リハビリテーション要支援計, 通所リハビリテーション要介護計, 通所リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_給付額_3_11() {

        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1318().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1325().getValue();
        Decimal 短期入所サービス合計 = div.getPnlMain().getTbl4().getTextBox1326().getValue();

        return 入力チェック3(短期入所サービス要支援計, 短期入所サービス要介護計, 短期入所サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_12() {

        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1329().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1336().getValue();
        Decimal 短期入所生活介護合計 = div.getPnlMain().getTbl4().getTextBox1337().getValue();

        return 入力チェック3(短期入所生活介護要支援計, 短期入所生活介護要介護計, 短期入所生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl4().getTextBox1340().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl4().getTextBox1347().getValue();
        Decimal 短期入所療養介護介護老人保健施設合計 = div.getPnlMain().getTbl4().getTextBox1348().getValue();

        return 入力チェック3(短期入所療養介護介護老人保健施設要支援計,
                短期入所療養介護介護老人保健施設要介護計, 短期入所療養介護介護老人保健施設合計);
    }

    private boolean is整合性チェック_NG_給付額_3_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl4().getTextBox1351().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl4().getTextBox1358().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等合計 = div.getPnlMain().getTbl4().getTextBox1359().getValue();

        return 入力チェック3(短期入所療養介護介護療養型医療施設等要支援計, 短期入所療養介護介護療養型医療施設等要介護計,
                短期入所療養介護介護療養型医療施設等合計);
    }

    private boolean is整合性チェック_NG_給付額_3_15() {

        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1362().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1369().getValue();
        Decimal 福祉用具住宅改修サービス合計 = div.getPnlMain().getTbl4().getTextBox1370().getValue();

        return 入力チェック3(福祉用具住宅改修サービス要支援計, 福祉用具住宅改修サービス要介護計, 福祉用具住宅改修サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_16() {

        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl4().getTextBox1373().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl4().getTextBox1380().getValue();
        Decimal 福祉用具貸与合計 = div.getPnlMain().getTbl4().getTextBox1381().getValue();

        return 入力チェック3(福祉用具貸与要支援計, 福祉用具貸与要介護計, 福祉用具貸与合計);
    }

    private boolean is整合性チェック_NG_給付額_3_17() {

        Decimal 福祉用具購入費要支援計 = div.getPnlMain().getTbl4().getTextBox1384().getValue();
        Decimal 福祉用具購入費要介護計 = div.getPnlMain().getTbl4().getTextBox1391().getValue();
        Decimal 福祉用具購入費合計 = div.getPnlMain().getTbl4().getTextBox1392().getValue();

        return 入力チェック3(福祉用具購入費要支援計, 福祉用具購入費要介護計, 福祉用具購入費合計);
    }

    private boolean is整合性チェック_NG_給付額_3_18() {

        Decimal 住宅改修費要支援計 = div.getPnlMain().getTbl4().getTextBox1395().getValue();
        Decimal 住宅改修費要介護計 = div.getPnlMain().getTbl4().getTextBox1402().getValue();
        Decimal 住宅改修費合計 = div.getPnlMain().getTbl4().getTextBox1403().getValue();

        return 入力チェック3(住宅改修費要支援計, 住宅改修費要介護計, 住宅改修費合計);
    }

    private boolean is整合性チェック_NG_給付額_3_19() {

        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1406().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1413().getValue();
        Decimal 特定施設入居者生活介護合計 = div.getPnlMain().getTbl4().getTextBox1414().getValue();

        return 入力チェック3(特定施設入居者生活介護要支援計, 特定施設入居者生活介護要介護計, 特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_20() {

        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl4().getTextBox1417().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl4().getTextBox1424().getValue();
        Decimal 介護予防支援居宅介護支援合計 = div.getPnlMain().getTbl4().getTextBox1425().getValue();

        return 入力チェック3(介護予防支援居宅介護支援要支援計, 介護予防支援居宅介護支援要介護計, 介護予防支援居宅介護支援合計);
    }

    private boolean is整合性チェック_NG_給付額_3_21() {

        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1428().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1435().getValue();
        Decimal 地域密着型介護予防サービス合計 = div.getPnlMain().getTbl4().getTextBox1436().getValue();

        return 入力チェック3(地域密着型介護予防サービス要支援計, 地域密着型介護予防サービス要介護計, 地域密着型介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl4().getTextBox1439().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl4().getTextBox1445().getValue();
        Decimal 定期巡回随時対応型訪問介護看護合計 = div.getPnlMain().getTbl4().getTextBox1446().getValue();

        return 入力チェック3(定期巡回随時対応型訪問介護看護要支援計,
                定期巡回随時対応型訪問介護看護要介護計, 定期巡回随時対応型訪問介護看護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_23() {

        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl4().getTextBox1449().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl4().getTextBox1455().getValue();
        Decimal 夜間対応型訪問介護合計 = div.getPnlMain().getTbl4().getTextBox1456().getValue();

        return 入力チェック3(夜間対応型訪問介護要支援計, 夜間対応型訪問介護要介護計, 夜間対応型訪問介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_24() {

        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl4().getTextBox1459().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl4().getTextBox1466().getValue();
        Decimal 認知症対応型通所介護合計 = div.getPnlMain().getTbl4().getTextBox1467().getValue();

        return 入力チェック3(認知症対応型通所介護要支援計, 認知症対応型通所介護要介護計, 認知症対応型通所介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_25() {

        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl4().getTextBox1470().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl4().getTextBox1477().getValue();
        Decimal 小規模多機能型居宅介護合計 = div.getPnlMain().getTbl4().getTextBox1478().getValue();

        return 入力チェック3(小規模多機能型居宅介護要支援計, 小規模多機能型居宅介護要介護計, 小規模多機能型居宅介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_26() {

        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1481().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1487().getValue();
        Decimal 認知症対応型共同生活介護合計 = div.getPnlMain().getTbl4().getTextBox1488().getValue();

        return 入力チェック3(認知症対応型共同生活介護要支援計, 認知症対応型共同生活介護要介護計, 認知症対応型共同生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1491().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1497().getValue();
        Decimal 地域密着型特定施設入居者生活介護合計 = div.getPnlMain().getTbl4().getTextBox1498().getValue();

        return 入力チェック3(地域密着型特定施設入居者生活介護要支援計,
                地域密着型特定施設入居者生活介護要介護計, 地域密着型特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl4().getTextBox1501().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl4().getTextBox1507().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護合計 = div.getPnlMain().getTbl4().getTextBox1508().getValue();

        return 入力チェック3(地域密着型介護老人福祉施設入所者生活介護要支援計, 地域密着型介護老人福祉施設入所者生活介護要介護計,
                地域密着型介護老人福祉施設入所者生活介護合計);
    }

    private boolean is整合性チェック_NG_給付額_3_29() {

        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1511().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1517().getValue();
        Decimal 複合型サービス合計 = div.getPnlMain().getTbl4().getTextBox1518().getValue();

        return 入力チェック3(複合型サービス要支援計, 複合型サービス要介護計, 複合型サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_30() {

        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl4().getTextBox1521().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl4().getTextBox1528().getValue();
        Decimal 施設サービス合計 = div.getPnlMain().getTbl4().getTextBox1529().getValue();

        return 入力チェック3(施設サービス要支援計, 施設サービス要介護計, 施設サービス合計);
    }

    private boolean is整合性チェック_NG_給付額_3_31() {

        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1532().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1539().getValue();
        Decimal 介護老人福祉施設_1_合計 = div.getPnlMain().getTbl4().getTextBox1540().getValue();

        return 入力チェック3(介護老人福祉施設_1_要支援計, 介護老人福祉施設_1_要介護計, 介護老人福祉施設_1_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_32() {

        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl4().getTextBox1543().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl4().getTextBox1549().getValue();
        Decimal 介護老人保健施設_1_合計 = div.getPnlMain().getTbl4().getTextBox1550().getValue();

        return 入力チェック3(介護老人保健施設_1_要支援計, 介護老人保健施設_1_要介護計, 介護老人保健施設_1_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_33() {

        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1553().getValue();
        Decimal 介護療養型医療施設要介護計 = div.getPnlMain().getTbl4().getTextBox1559().getValue();
        Decimal 介護療養型医療施設合計 = div.getPnlMain().getTbl4().getTextBox1560().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_給付額_3_34() {

        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl4().getTextBox1563().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl4().getTextBox1570().getValue();
        Decimal 食事提供費用再掲合計 = div.getPnlMain().getTbl4().getTextBox1571().getValue();

        return 入力チェック3(食事提供費用再掲要支援計, 食事提供費用再掲要介護計, 食事提供費用再掲合計);
    }

    private boolean is整合性チェック_NG_給付額_3_35() {

        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1574().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1581().getValue();
        Decimal 介護老人福祉施設_2_合計 = div.getPnlMain().getTbl4().getTextBox1582().getValue();

        return 入力チェック3(介護老人福祉施設_2_要支援計, 介護老人福祉施設_2_要介護計, 介護老人福祉施設_2_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_36() {

        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl4().getTextBox1585().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl4().getTextBox1591().getValue();
        Decimal 介護老人保健施設_2_合計 = div.getPnlMain().getTbl4().getTextBox1592().getValue();

        return 入力チェック3(介護老人保健施設_2_要支援計, 介護老人保健施設_2_要介護計, 介護老人保健施設_2_合計);
    }

    private boolean is整合性チェック_NG_給付額_3_37() {

        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl4().getTextBox1595().getValue();
        Decimal 介護療養型医療施設要介護計 = div.getPnlMain().getTbl4().getTextBox1601().getValue();
        Decimal 介護療養型医療施設合計 = div.getPnlMain().getTbl4().getTextBox1602().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_給付額_3_38() {

        Decimal 総計要支援計 = div.getPnlMain().getTbl4().getTextBox1605().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl4().getTextBox1613().getValue();
        Decimal 総計合計 = div.getPnlMain().getTbl4().getTextBox1614().getValue();

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

}

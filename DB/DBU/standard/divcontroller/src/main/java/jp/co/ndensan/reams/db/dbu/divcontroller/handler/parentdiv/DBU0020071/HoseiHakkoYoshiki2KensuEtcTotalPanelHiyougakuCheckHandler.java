/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuCheckHandler {

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuCheckHandler(
            HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * is整合性チェック_NG_費用額のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_費用額_NG1() {

        return is整合性チェック_費用額_NG_整合_費用額1_1() || is整合性チェック_費用額_NG_整合_費用額1_2()
                || is整合性チェック_費用額_NG_整合_費用額1_3();
    }

    /**
     * is整合性チェック_NG_費用額のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_費用額_NG2() {

        return is整合性チェック_費用額_NG_整合_費用額2_1() || is整合性チェック_費用額_NG_整合_費用額2_2()
                || is整合性チェック_費用額_NG_整合_費用額2_3();
    }

    private boolean is整合性チェック_費用額_NG_整合_費用額1_1() {
        return is整合性チェック_費用額_NG_1() || is整合性チェック_費用額_NG_2()
                || is整合性チェック_費用額_NG_3() || is整合性チェック_費用額_NG_4()
                || is整合性チェック_費用額_NG_5() || is整合性チェック_費用額_NG_6()
                || is整合性チェック_費用額_NG_7() || is整合性チェック_費用額_NG_8()
                || is整合性チェック_費用額_NG_9() || is整合性チェック_費用額_NG_10()
                || is整合性チェック_費用額_NG_11() || is整合性チェック_費用額_NG_12()
                || is整合性チェック_費用額_NG_13();

    }

    private boolean is整合性チェック_費用額_NG_整合_費用額1_2() {
        return is整合性チェック_費用額_NG_14() || is整合性チェック_費用額_NG_15()
                || is整合性チェック_費用額_NG_16() || is整合性チェック_費用額_NG_17()
                || is整合性チェック_費用額_NG_18() || is整合性チェック_費用額_NG_19()
                || is整合性チェック_費用額_NG_20() || is整合性チェック_費用額_NG_21()
                || is整合性チェック_費用額_NG_22() || is整合性チェック_費用額_NG_23()
                || is整合性チェック_費用額_NG_24() || is整合性チェック_費用額_NG_25()
                || is整合性チェック_費用額_NG_26();
    }

    private boolean is整合性チェック_費用額_NG_整合_費用額1_3() {
        return is整合性チェック_費用額_NG_27() || is整合性チェック_費用額_NG_28()
                || is整合性チェック_費用額_NG_29() || is整合性チェック_費用額_NG_30()
                || is整合性チェック_費用額_NG_31() || is整合性チェック_費用額_NG_32()
                || is整合性チェック_費用額_NG_33() || is整合性チェック_費用額_NG_34()
                || is整合性チェック_費用額_NG_35() || is整合性チェック_費用額_NG_36()
                || is整合性チェック_費用額_NG_37() || is整合性チェック_費用額_NG_38();
    }

    private boolean is整合性チェック_費用額_NG_整合_費用額2_1() {
        return is整合性チェック_費用額_NG_1_1() || is整合性チェック_費用額_NG_1_2()
                || is整合性チェック_費用額_NG_1_3() || is整合性チェック_費用額_NG_1_4()
                || is整合性チェック_費用額_NG_1_5() || is整合性チェック_費用額_NG_1_6()
                || is整合性チェック_費用額_NG_1_7() || is整合性チェック_費用額_NG_1_8()
                || is整合性チェック_費用額_NG_1_9() || is整合性チェック_費用額_NG_1_10()
                || is整合性チェック_費用額_NG_1_11() || is整合性チェック_費用額_NG_1_12()
                || is整合性チェック_費用額_NG_1_13();

    }

    private boolean is整合性チェック_費用額_NG_整合_費用額2_2() {
        return is整合性チェック_費用額_NG_1_14() || is整合性チェック_費用額_NG_1_15()
                || is整合性チェック_費用額_NG_1_16() || is整合性チェック_費用額_NG_1_17()
                || is整合性チェック_費用額_NG_1_18() || is整合性チェック_費用額_NG_1_19()
                || is整合性チェック_費用額_NG_1_20() || is整合性チェック_費用額_NG_1_21()
                || is整合性チェック_費用額_NG_1_22() || is整合性チェック_費用額_NG_1_23()
                || is整合性チェック_費用額_NG_1_24() || is整合性チェック_費用額_NG_1_25()
                || is整合性チェック_費用額_NG_1_26();
    }

    private boolean is整合性チェック_費用額_NG_整合_費用額2_3() {
        return is整合性チェック_費用額_NG_1_27() || is整合性チェック_費用額_NG_1_28()
                || is整合性チェック_費用額_NG_1_29() || is整合性チェック_費用額_NG_1_30()
                || is整合性チェック_費用額_NG_1_31() || is整合性チェック_費用額_NG_1_32()
                || is整合性チェック_費用額_NG_1_33() || is整合性チェック_費用額_NG_1_34()
                || is整合性チェック_費用額_NG_1_35() || is整合性チェック_費用額_NG_1_36()
                || is整合性チェック_費用額_NG_1_37() || is整合性チェック_費用額_NG_1_38();
    }

    private boolean is整合性チェック_費用額_NG_1_1() {

        Decimal 居宅介護予防サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox589().getValue();
        Decimal 居宅介護予防サービス要会護１ = div.getPnlMain().getTbl3().getTextBox590().getValue();
        Decimal 居宅介護予防サービス要介護２ = div.getPnlMain().getTbl3().getTextBox591().getValue();
        Decimal 居宅介護予防サービス要介護３ = div.getPnlMain().getTbl3().getTextBox592().getValue();
        Decimal 居宅介護予防サービス要介護４ = div.getPnlMain().getTbl3().getTextBox593().getValue();
        Decimal 居宅介護予防サービス要介護５ = div.getPnlMain().getTbl3().getTextBox594().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox595().getValue();

        return 入力チェック2(居宅介護予防サービス経過的要介護,
                居宅介護予防サービス要会護１, 居宅介護予防サービス要介護２, 居宅介護予防サービス要介護３,
                居宅介護予防サービス要介護４, 居宅介護予防サービス要介護５, 居宅介護予防サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_2() {

        Decimal 訪問サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox600().getValue();
        Decimal 訪問サービス要会護１ = div.getPnlMain().getTbl3().getTextBox601().getValue();
        Decimal 訪問サービス要介護２ = div.getPnlMain().getTbl3().getTextBox602().getValue();
        Decimal 訪問サービス要介護３ = div.getPnlMain().getTbl3().getTextBox603().getValue();
        Decimal 訪問サービス要介護４ = div.getPnlMain().getTbl3().getTextBox604().getValue();
        Decimal 訪問サービス要介護５ = div.getPnlMain().getTbl3().getTextBox605().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl3().getTextBox606().getValue();

        return 入力チェック2(訪問サービス経過的要介護, 訪問サービス要会護１,
                訪問サービス要介護２, 訪問サービス要介護３, 訪問サービス要介護４,
                訪問サービス要介護５, 訪問サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_3() {

        Decimal 訪問介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox822().getValue();
        Decimal 訪問介護要会護１ = div.getPnlMain().getTbl3().getTextBox823().getValue();
        Decimal 訪問介護要介護２ = div.getPnlMain().getTbl3().getTextBox824().getValue();
        Decimal 訪問介護要介護３ = div.getPnlMain().getTbl3().getTextBox825().getValue();
        Decimal 訪問介護要介護４ = div.getPnlMain().getTbl3().getTextBox826().getValue();
        Decimal 訪問介護要介護５ = div.getPnlMain().getTbl3().getTextBox827().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox828().getValue();

        return 入力チェック2(訪問介護経過的要介護, 訪問介護要会護１,
                訪問介護要介護２, 訪問介護要介護３, 訪問介護要介護４, 訪問介護要介護５, 訪問介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_4() {

        Decimal 訪問入浴介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox833().getValue();
        Decimal 訪問入浴介護要会護１ = div.getPnlMain().getTbl3().getTextBox834().getValue();
        Decimal 訪問入浴介護要介護２ = div.getPnlMain().getTbl3().getTextBox835().getValue();
        Decimal 訪問入浴介護要介護３ = div.getPnlMain().getTbl3().getTextBox836().getValue();
        Decimal 訪問入浴介護要介護４ = div.getPnlMain().getTbl3().getTextBox837().getValue();
        Decimal 訪問入浴介護要介護５ = div.getPnlMain().getTbl3().getTextBox838().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl3().getTextBox839().getValue();

        return 入力チェック2(訪問入浴介護経過的要介護, 訪問入浴介護要会護１, 訪問入浴介護要介護２,
                訪問入浴介護要介護３, 訪問入浴介護要介護４, 訪問入浴介護要介護５, 訪問入浴介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_5() {

        Decimal 訪問看護経過的要介護 = div.getPnlMain().getTbl3().getTextBox844().getValue();
        Decimal 訪問看護要会護１ = div.getPnlMain().getTbl3().getTextBox845().getValue();
        Decimal 訪問看護要介護２ = div.getPnlMain().getTbl3().getTextBox846().getValue();
        Decimal 訪問看護要介護３ = div.getPnlMain().getTbl3().getTextBox847().getValue();
        Decimal 訪問看護要介護４ = div.getPnlMain().getTbl3().getTextBox848().getValue();
        Decimal 訪問看護要介護５ = div.getPnlMain().getTbl3().getTextBox849().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl3().getTextBox850().getValue();

        return 入力チェック2(訪問看護経過的要介護, 訪問看護要会護１,
                訪問看護要介護２, 訪問看護要介護３, 訪問看護要介護４, 訪問看護要介護５, 訪問看護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_6() {

        Decimal 訪問リハビリテーション経過的要介護 = div.getPnlMain().getTbl3().getTextBox855().getValue();
        Decimal 訪問リハビリテーション要会護１ = div.getPnlMain().getTbl3().getTextBox856().getValue();
        Decimal 訪問リハビリテーション要介護２ = div.getPnlMain().getTbl3().getTextBox857().getValue();
        Decimal 訪問リハビリテーション要介護３ = div.getPnlMain().getTbl3().getTextBox858().getValue();
        Decimal 訪問リハビリテーション要介護４ = div.getPnlMain().getTbl3().getTextBox859().getValue();
        Decimal 訪問リハビリテーション要介護５ = div.getPnlMain().getTbl3().getTextBox860().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox861().getValue();

        return 入力チェック2(訪問リハビリテーション経過的要介護,
                訪問リハビリテーション要会護１, 訪問リハビリテーション要介護２,
                訪問リハビリテーション要介護３, 訪問リハビリテーション要介護４,
                訪問リハビリテーション要介護５, 訪問リハビリテーション要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_7() {

        Decimal 居宅療養管理指導経過的要介護 = div.getPnlMain().getTbl3().getTextBox866().getValue();
        Decimal 居宅療養管理指導要会護１ = div.getPnlMain().getTbl3().getTextBox867().getValue();
        Decimal 居宅療養管理指導要介護２ = div.getPnlMain().getTbl3().getTextBox868().getValue();
        Decimal 居宅療養管理指導要介護３ = div.getPnlMain().getTbl3().getTextBox869().getValue();
        Decimal 居宅療養管理指導要介護４ = div.getPnlMain().getTbl3().getTextBox870().getValue();
        Decimal 居宅療養管理指導要介護５ = div.getPnlMain().getTbl3().getTextBox871().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl3().getTextBox872().getValue();

        return 入力チェック2(居宅療養管理指導経過的要介護, 居宅療養管理指導要会護１, 居宅療養管理指導要介護２,
                居宅療養管理指導要介護３, 居宅療養管理指導要介護４, 居宅療養管理指導要介護５, 居宅療養管理指導要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_8() {

        Decimal 通所サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox877().getValue();
        Decimal 通所サービス要会護１ = div.getPnlMain().getTbl3().getTextBox878().getValue();
        Decimal 通所サービス要介護２ = div.getPnlMain().getTbl3().getTextBox879().getValue();
        Decimal 通所サービス要介護３ = div.getPnlMain().getTbl3().getTextBox880().getValue();
        Decimal 通所サービス要介護４ = div.getPnlMain().getTbl3().getTextBox881().getValue();
        Decimal 通所サービス要介護５ = div.getPnlMain().getTbl3().getTextBox882().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox883().getValue();

        return 入力チェック2(通所サービス経過的要介護, 通所サービス要会護１, 通所サービス要介護２, 通所サービス要介護３,
                通所サービス要介護４, 通所サービス要介護５, 通所サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_9() {

        Decimal 通所介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox888().getValue();
        Decimal 通所介護要会護１ = div.getPnlMain().getTbl3().getTextBox889().getValue();
        Decimal 通所介護要介護２ = div.getPnlMain().getTbl3().getTextBox890().getValue();
        Decimal 通所介護要介護３ = div.getPnlMain().getTbl3().getTextBox891().getValue();
        Decimal 通所介護要介護４ = div.getPnlMain().getTbl3().getTextBox892().getValue();
        Decimal 通所介護要介護５ = div.getPnlMain().getTbl3().getTextBox893().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox894().getValue();

        return 入力チェック2(通所介護経過的要介護, 通所介護要会護１,
                通所介護要介護２, 通所介護要介護３, 通所介護要介護４, 通所介護要介護５, 通所介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_10() {

        Decimal 通所リハビリテーション経過的要介護 = div.getPnlMain().getTbl3().getTextBox899().getValue();
        Decimal 通所リハビリテーション要会護１ = div.getPnlMain().getTbl3().getTextBox900().getValue();
        Decimal 通所リハビリテーション要介護２ = div.getPnlMain().getTbl3().getTextBox901().getValue();
        Decimal 通所リハビリテーション要介護３ = div.getPnlMain().getTbl3().getTextBox902().getValue();
        Decimal 通所リハビリテーション要介護４ = div.getPnlMain().getTbl3().getTextBox903().getValue();
        Decimal 通所リハビリテーション要介護５ = div.getPnlMain().getTbl3().getTextBox904().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox905().getValue();

        return 入力チェック2(通所リハビリテーション経過的要介護,
                通所リハビリテーション要会護１, 通所リハビリテーション要介護２,
                通所リハビリテーション要介護３, 通所リハビリテーション要介護４,
                通所リハビリテーション要介護５, 通所リハビリテーション要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_11() {

        Decimal 短期入所サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox910().getValue();
        Decimal 短期入所サービス要会護１ = div.getPnlMain().getTbl3().getTextBox911().getValue();
        Decimal 短期入所サービス要介護２ = div.getPnlMain().getTbl3().getTextBox912().getValue();
        Decimal 短期入所サービス要介護３ = div.getPnlMain().getTbl3().getTextBox913().getValue();
        Decimal 短期入所サービス要介護４ = div.getPnlMain().getTbl3().getTextBox914().getValue();
        Decimal 短期入所サービス要介護５ = div.getPnlMain().getTbl3().getTextBox915().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox916().getValue();

        return 入力チェック2(短期入所サービス経過的要介護, 短期入所サービス要会護１,
                短期入所サービス要介護２, 短期入所サービス要介護３,
                短期入所サービス要介護４, 短期入所サービス要介護５, 短期入所サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_12() {

        Decimal 短期入所生活介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox921().getValue();
        Decimal 短期入所生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox922().getValue();
        Decimal 短期入所生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox923().getValue();
        Decimal 短期入所生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox924().getValue();
        Decimal 短期入所生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox925().getValue();
        Decimal 短期入所生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox926().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox927().getValue();

        return 入力チェック2(短期入所生活介護経過的要介護, 短期入所生活介護要会護１, 短期入所生活介護要介護２,
                短期入所生活介護要介護３, 短期入所生活介護要介護４, 短期入所生活介護要介護５, 短期入所生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_13() {

        Decimal 短期入所療養介護介護老人保健施設経過的要介護 = div.getPnlMain().getTbl3().getTextBox932().getValue();
        Decimal 短期入所療養介護介護老人保健施設要会護１ = div.getPnlMain().getTbl3().getTextBox933().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護２ = div.getPnlMain().getTbl3().getTextBox934().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護３ = div.getPnlMain().getTbl3().getTextBox935().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護４ = div.getPnlMain().getTbl3().getTextBox936().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護５ = div.getPnlMain().getTbl3().getTextBox937().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl3().getTextBox938().getValue();

        return 入力チェック2(短期入所療養介護介護老人保健施設経過的要介護, 短期入所療養介護介護老人保健施設要会護１,
                短期入所療養介護介護老人保健施設要介護２, 短期入所療養介護介護老人保健施設要介護３,
                短期入所療養介護介護老人保健施設要介護４, 短期入所療養介護介護老人保健施設要介護５,
                短期入所療養介護介護老人保健施設要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_14() {

        Decimal 短期入所療養介護介護療養型医療施設等経過的要介護 = div.getPnlMain().getTbl3().getTextBox943().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要会護１ = div.getPnlMain().getTbl3().getTextBox944().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護２ = div.getPnlMain().getTbl3().getTextBox945().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護３ = div.getPnlMain().getTbl3().getTextBox946().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護４ = div.getPnlMain().getTbl3().getTextBox947().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護５ = div.getPnlMain().getTbl3().getTextBox948().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl3().getTextBox949().getValue();

        return 入力チェック2(短期入所療養介護介護療養型医療施設等経過的要介護, 短期入所療養介護介護療養型医療施設等要会護１,
                短期入所療養介護介護療養型医療施設等要介護２, 短期入所療養介護介護療養型医療施設等要介護３,
                短期入所療養介護介護療養型医療施設等要介護４, 短期入所療養介護介護療養型医療施設等要介護５,
                短期入所療養介護介護療養型医療施設等要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_15() {

        Decimal 福祉用具住宅改修サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox954().getValue();
        Decimal 福祉用具住宅改修サービス要会護１ = div.getPnlMain().getTbl3().getTextBox955().getValue();
        Decimal 福祉用具住宅改修サービス要介護２ = div.getPnlMain().getTbl3().getTextBox956().getValue();
        Decimal 福祉用具住宅改修サービス要介護３ = div.getPnlMain().getTbl3().getTextBox957().getValue();
        Decimal 福祉用具住宅改修サービス要介護４ = div.getPnlMain().getTbl3().getTextBox958().getValue();
        Decimal 福祉用具住宅改修サービス要介護５ = div.getPnlMain().getTbl3().getTextBox959().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl3().getTextBox960().getValue();

        return 入力チェック2(福祉用具住宅改修サービス経過的要介護,
                福祉用具住宅改修サービス要会護１, 福祉用具住宅改修サービス要介護２,
                福祉用具住宅改修サービス要介護３, 福祉用具住宅改修サービス要介護４,
                福祉用具住宅改修サービス要介護５, 福祉用具住宅改修サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_16() {

        Decimal 福祉用具貸与経過的要介護 = div.getPnlMain().getTbl3().getTextBox965().getValue();
        Decimal 福祉用具貸与要会護１ = div.getPnlMain().getTbl3().getTextBox966().getValue();
        Decimal 福祉用具貸与要介護２ = div.getPnlMain().getTbl3().getTextBox967().getValue();
        Decimal 福祉用具貸与要介護３ = div.getPnlMain().getTbl3().getTextBox968().getValue();
        Decimal 福祉用具貸与要介護４ = div.getPnlMain().getTbl3().getTextBox969().getValue();
        Decimal 福祉用具貸与要介護５ = div.getPnlMain().getTbl3().getTextBox970().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl3().getTextBox971().getValue();

        return 入力チェック2(福祉用具貸与経過的要介護, 福祉用具貸与要会護１, 福祉用具貸与要介護２, 福祉用具貸与要介護３,
                福祉用具貸与要介護４, 福祉用具貸与要介護５, 福祉用具貸与要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_17() {

        Decimal 福祉用具購入費経過的要介護 = div.getPnlMain().getTbl3().getTextBox976().getValue();
        Decimal 福祉用具購入費要会護１ = div.getPnlMain().getTbl3().getTextBox977().getValue();
        Decimal 福祉用具購入費要介護２ = div.getPnlMain().getTbl3().getTextBox978().getValue();
        Decimal 福祉用具購入費要介護３ = div.getPnlMain().getTbl3().getTextBox979().getValue();
        Decimal 福祉用具購入費要介護４ = div.getPnlMain().getTbl3().getTextBox980().getValue();
        Decimal 福祉用具購入費要介護５ = div.getPnlMain().getTbl3().getTextBox981().getValue();
        Decimal 福祉用具購入費要介護計 = div.getPnlMain().getTbl3().getTextBox982().getValue();

        return 入力チェック2(福祉用具購入費経過的要介護, 福祉用具購入費要会護１,
                福祉用具購入費要介護２, 福祉用具購入費要介護３,
                福祉用具購入費要介護４, 福祉用具購入費要介護５, 福祉用具購入費要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_18() {

        Decimal 住宅改修費経過的要介護 = div.getPnlMain().getTbl3().getTextBox987().getValue();
        Decimal 住宅改修費要会護１ = div.getPnlMain().getTbl3().getTextBox988().getValue();
        Decimal 住宅改修費要介護２ = div.getPnlMain().getTbl3().getTextBox989().getValue();
        Decimal 住宅改修費要介護３ = div.getPnlMain().getTbl3().getTextBox990().getValue();
        Decimal 住宅改修費要介護４ = div.getPnlMain().getTbl3().getTextBox991().getValue();
        Decimal 住宅改修費要介護５ = div.getPnlMain().getTbl3().getTextBox992().getValue();
        Decimal 住宅改修費要介護計 = div.getPnlMain().getTbl3().getTextBox993().getValue();

        return 入力チェック2(住宅改修費経過的要介護, 住宅改修費要会護１,
                住宅改修費要介護２, 住宅改修費要介護３, 住宅改修費要介護４,
                住宅改修費要介護５, 住宅改修費要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_19() {

        Decimal 特定施設入居者生活介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox998().getValue();
        Decimal 特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox999().getValue();
        Decimal 特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1000().getValue();
        Decimal 特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1001().getValue();
        Decimal 特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1002().getValue();
        Decimal 特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1003().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1004().getValue();

        return 入力チェック2(特定施設入居者生活介護経過的要介護,
                特定施設入居者生活介護要会護１, 特定施設入居者生活介護要介護２,
                特定施設入居者生活介護要介護３, 特定施設入居者生活介護要介護４,
                特定施設入居者生活介護要介護５, 特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_20() {

        Decimal 介護予防支援居宅介護支援経過的要介護 = div.getPnlMain().getTbl3().getTextBox1009().getValue();
        Decimal 介護予防支援居宅介護支援要会護１ = div.getPnlMain().getTbl3().getTextBox1010().getValue();
        Decimal 介護予防支援居宅介護支援要介護２ = div.getPnlMain().getTbl3().getTextBox1011().getValue();
        Decimal 介護予防支援居宅介護支援要介護３ = div.getPnlMain().getTbl3().getTextBox1012().getValue();
        Decimal 介護予防支援居宅介護支援要介護４ = div.getPnlMain().getTbl3().getTextBox1013().getValue();
        Decimal 介護予防支援居宅介護支援要介護５ = div.getPnlMain().getTbl3().getTextBox1014().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl3().getTextBox1015().getValue();

        return 入力チェック2(介護予防支援居宅介護支援経過的要介護,
                介護予防支援居宅介護支援要会護１, 介護予防支援居宅介護支援要介護２,
                介護予防支援居宅介護支援要介護３, 介護予防支援居宅介護支援要介護４,
                介護予防支援居宅介護支援要介護５, 介護予防支援居宅介護支援要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_21() {

        Decimal 地域密着型介護予防サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox1020().getValue();
        Decimal 地域密着型介護予防サービス要会護１ = div.getPnlMain().getTbl3().getTextBox1021().getValue();
        Decimal 地域密着型介護予防サービス要介護２ = div.getPnlMain().getTbl3().getTextBox1022().getValue();
        Decimal 地域密着型介護予防サービス要介護３ = div.getPnlMain().getTbl3().getTextBox1023().getValue();
        Decimal 地域密着型介護予防サービス要介護４ = div.getPnlMain().getTbl3().getTextBox1024().getValue();
        Decimal 地域密着型介護予防サービス要介護５ = div.getPnlMain().getTbl3().getTextBox1025().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1026().getValue();

        return 入力チェック2(地域密着型介護予防サービス経過的要介護,
                地域密着型介護予防サービス要会護１, 地域密着型介護予防サービス要介護２,
                地域密着型介護予防サービス要介護３, 地域密着型介護予防サービス要介護４,
                地域密着型介護予防サービス要介護５, 地域密着型介護予防サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_22() {

        Decimal 定期巡回随時対応型訪問介護看護経過的要介護 = Decimal.ZERO;
        Decimal 定期巡回随時対応型訪問介護看護要会護１ = div.getPnlMain().getTbl3().getTextBox1031().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護２ = div.getPnlMain().getTbl3().getTextBox1032().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護３ = div.getPnlMain().getTbl3().getTextBox1033().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護４ = div.getPnlMain().getTbl3().getTextBox1034().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護５ = div.getPnlMain().getTbl3().getTextBox1035().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl3().getTextBox1036().getValue();

        return 入力チェック2(定期巡回随時対応型訪問介護看護経過的要介護,
                定期巡回随時対応型訪問介護看護要会護１, 定期巡回随時対応型訪問介護看護要介護２,
                定期巡回随時対応型訪問介護看護要介護３, 定期巡回随時対応型訪問介護看護要介護４,
                定期巡回随時対応型訪問介護看護要介護５, 定期巡回随時対応型訪問介護看護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_23() {

        Decimal 夜間対応型訪問介護経過的要介護 = Decimal.ZERO;
        Decimal 夜間対応型訪問介護要会護１ = div.getPnlMain().getTbl3().getTextBox1041().getValue();
        Decimal 夜間対応型訪問介護要介護２ = div.getPnlMain().getTbl3().getTextBox1042().getValue();
        Decimal 夜間対応型訪問介護要介護３ = div.getPnlMain().getTbl3().getTextBox1043().getValue();
        Decimal 夜間対応型訪問介護要介護４ = div.getPnlMain().getTbl3().getTextBox1044().getValue();
        Decimal 夜間対応型訪問介護要介護５ = div.getPnlMain().getTbl3().getTextBox1045().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox1046().getValue();

        return 入力チェック2(夜間対応型訪問介護経過的要介護,
                夜間対応型訪問介護要会護１, 夜間対応型訪問介護要介護２, 夜間対応型訪問介護要介護３,
                夜間対応型訪問介護要介護４, 夜間対応型訪問介護要介護５, 夜間対応型訪問介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_24() {

        Decimal 認知症対応型通所介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox1051().getValue();
        Decimal 認知症対応型通所介護要会護１ = div.getPnlMain().getTbl3().getTextBox1052().getValue();
        Decimal 認知症対応型通所介護要介護２ = div.getPnlMain().getTbl3().getTextBox1053().getValue();
        Decimal 認知症対応型通所介護要介護３ = div.getPnlMain().getTbl3().getTextBox1054().getValue();
        Decimal 認知症対応型通所介護要介護４ = div.getPnlMain().getTbl3().getTextBox1055().getValue();
        Decimal 認知症対応型通所介護要介護５ = div.getPnlMain().getTbl3().getTextBox1056().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox1057().getValue();

        return 入力チェック2(認知症対応型通所介護経過的要介護,
                認知症対応型通所介護要会護１, 認知症対応型通所介護要介護２, 認知症対応型通所介護要介護３,
                認知症対応型通所介護要介護４, 認知症対応型通所介護要介護５, 認知症対応型通所介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_25() {

        Decimal 小規模多機能型居宅介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox1062().getValue();
        Decimal 小規模多機能型居宅介護要会護１ = div.getPnlMain().getTbl3().getTextBox1063().getValue();
        Decimal 小規模多機能型居宅介護要介護２ = div.getPnlMain().getTbl3().getTextBox1064().getValue();
        Decimal 小規模多機能型居宅介護要介護３ = div.getPnlMain().getTbl3().getTextBox1065().getValue();
        Decimal 小規模多機能型居宅介護要介護４ = div.getPnlMain().getTbl3().getTextBox1066().getValue();
        Decimal 小規模多機能型居宅介護要介護５ = div.getPnlMain().getTbl3().getTextBox1067().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl3().getTextBox1068().getValue();

        return 入力チェック2(小規模多機能型居宅介護経過的要介護,
                小規模多機能型居宅介護要会護１, 小規模多機能型居宅介護要介護２,
                小規模多機能型居宅介護要介護３, 小規模多機能型居宅介護要介護４,
                小規模多機能型居宅介護要介護５, 小規模多機能型居宅介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_26() {

        Decimal 認知症対応型共同生活介護経過的要介護 = Decimal.ZERO;
        Decimal 認知症対応型共同生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox1073().getValue();
        Decimal 認知症対応型共同生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1074().getValue();
        Decimal 認知症対応型共同生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1075().getValue();
        Decimal 認知症対応型共同生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1076().getValue();
        Decimal 認知症対応型共同生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1077().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1078().getValue();

        return 入力チェック2(認知症対応型共同生活介護経過的要介護,
                認知症対応型共同生活介護要会護１, 認知症対応型共同生活介護要介護２,
                認知症対応型共同生活介護要介護３, 認知症対応型共同生活介護要介護４,
                認知症対応型共同生活介護要介護５, 認知症対応型共同生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_27() {

        Decimal 地域密着型特定施設入居者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox1083().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1084().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1085().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1086().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1087().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1088().getValue();

        return 入力チェック2(地域密着型特定施設入居者生活介護経過的要介護,
                地域密着型特定施設入居者生活介護要会護１, 地域密着型特定施設入居者生活介護要介護２,
                地域密着型特定施設入居者生活介護要介護３, 地域密着型特定施設入居者生活介護要介護４,
                地域密着型特定施設入居者生活介護要介護５, 地域密着型特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護経過的要介護 = Decimal.ZERO;
        Decimal 地域密着型介護老人福祉施設入所者生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox1093().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1094().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1095().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1096().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1097().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1098().getValue();

        return 入力チェック2(地域密着型介護老人福祉施設入所者生活介護経過的要介護,
                地域密着型介護老人福祉施設入所者生活介護要会護１, 地域密着型介護老人福祉施設入所者生活介護要介護２,
                地域密着型介護老人福祉施設入所者生活介護要介護３, 地域密着型介護老人福祉施設入所者生活介護要介護４,
                地域密着型介護老人福祉施設入所者生活介護要介護５, 地域密着型介護老人福祉施設入所者生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_29() {

        Decimal 複合型サービス経過的要介護 = Decimal.ZERO;
        Decimal 複合型サービス要会護１ = div.getPnlMain().getTbl3().getTextBox1103().getValue();
        Decimal 複合型サービス要介護２ = div.getPnlMain().getTbl3().getTextBox1104().getValue();
        Decimal 複合型サービス要介護３ = div.getPnlMain().getTbl3().getTextBox1105().getValue();
        Decimal 複合型サービス要介護４ = div.getPnlMain().getTbl3().getTextBox1106().getValue();
        Decimal 複合型サービス要介護５ = div.getPnlMain().getTbl3().getTextBox1107().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1108().getValue();

        return 入力チェック2(複合型サービス経過的要介護,
                複合型サービス要会護１, 複合型サービス要介護２, 複合型サービス要介護３,
                複合型サービス要介護４, 複合型サービス要介護５, 複合型サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_30() {

        Decimal 施設サービス経過的要介護 = Decimal.ZERO;
        Decimal 施設サービス要会護１ = div.getPnlMain().getTbl3().getTextBox1114().getValue();
        Decimal 施設サービス要介護２ = div.getPnlMain().getTbl3().getTextBox1115().getValue();
        Decimal 施設サービス要介護３ = div.getPnlMain().getTbl3().getTextBox1116().getValue();
        Decimal 施設サービス要介護４ = div.getPnlMain().getTbl3().getTextBox1117().getValue();
        Decimal 施設サービス要介護５ = div.getPnlMain().getTbl3().getTextBox1118().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1119().getValue();

        return 入力チェック2(施設サービス経過的要介護, 施設サービス要会護１,
                施設サービス要介護２, 施設サービス要介護３, 施設サービス要介護４,
                施設サービス要介護５, 施設サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_31() {

        Decimal 介護老人福祉施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_1_要会護１ = div.getPnlMain().getTbl3().getTextBox1125().getValue();
        Decimal 介護老人福祉施設_1_要介護２ = div.getPnlMain().getTbl3().getTextBox1126().getValue();
        Decimal 介護老人福祉施設_1_要介護３ = div.getPnlMain().getTbl3().getTextBox1127().getValue();
        Decimal 介護老人福祉施設_1_要介護４ = div.getPnlMain().getTbl3().getTextBox1128().getValue();
        Decimal 介護老人福祉施設_1_要介護５ = div.getPnlMain().getTbl3().getTextBox1129().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1130().getValue();

        return 入力チェック2(介護老人福祉施設_1_経過的要介護, 介護老人福祉施設_1_要会護１, 介護老人福祉施設_1_要介護２,
                介護老人福祉施設_1_要介護３, 介護老人福祉施設_1_要介護４,
                介護老人福祉施設_1_要介護５, 介護老人福祉施設_1_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_32() {

        Decimal 介護老人保健施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_1_要会護１ = div.getPnlMain().getTbl3().getTextBox1135().getValue();
        Decimal 介護老人保健施設_1_要介護２ = div.getPnlMain().getTbl3().getTextBox1136().getValue();
        Decimal 介護老人保健施設_1_要介護３ = div.getPnlMain().getTbl3().getTextBox1137().getValue();
        Decimal 介護老人保健施設_1_要介護４ = div.getPnlMain().getTbl3().getTextBox1138().getValue();
        Decimal 介護老人保健施設_1_要介護５ = div.getPnlMain().getTbl3().getTextBox1139().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1140().getValue();

        return 入力チェック2(介護老人保健施設_1_経過的要介護, 介護老人保健施設_1_要会護１,
                介護老人保健施設_1_要介護２, 介護老人保健施設_1_要介護３,
                介護老人保健施設_1_要介護４, 介護老人保健施設_1_要介護５, 介護老人保健施設_1_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_33() {

        Decimal 介護療養型医療施設_1_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_1_要会護１ = div.getPnlMain().getTbl3().getTextBox1145().getValue();
        Decimal 介護療養型医療施設_1_要介護２ = div.getPnlMain().getTbl3().getTextBox1146().getValue();
        Decimal 介護療養型医療施設_1_要介護３ = div.getPnlMain().getTbl3().getTextBox1147().getValue();
        Decimal 介護療養型医療施設_1_要介護４ = div.getPnlMain().getTbl3().getTextBox1148().getValue();
        Decimal 介護療養型医療施設_1_要介護５ = div.getPnlMain().getTbl3().getTextBox1149().getValue();
        Decimal 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1150().getValue();

        return 入力チェック2(介護療養型医療施設_1_経過的要介護, 介護療養型医療施設_1_要会護１,
                介護療養型医療施設_1_要介護２, 介護療養型医療施設_1_要介護３,
                介護療養型医療施設_1_要介護４, 介護療養型医療施設_1_要介護５, 介護療養型医療施設_1_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_34() {

        Decimal 食事提供費用再掲経過的要介護 = Decimal.ZERO;
        Decimal 食事提供費用再掲要会護１ = div.getPnlMain().getTbl3().getTextBox1156().getValue();
        Decimal 食事提供費用再掲要介護２ = div.getPnlMain().getTbl3().getTextBox1157().getValue();
        Decimal 食事提供費用再掲要介護３ = div.getPnlMain().getTbl3().getTextBox1158().getValue();
        Decimal 食事提供費用再掲要介護４ = div.getPnlMain().getTbl3().getTextBox1159().getValue();
        Decimal 食事提供費用再掲要介護５ = div.getPnlMain().getTbl3().getTextBox1160().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl3().getTextBox1161().getValue();

        return 入力チェック2(食事提供費用再掲経過的要介護, 食事提供費用再掲要会護１,
                食事提供費用再掲要介護２, 食事提供費用再掲要介護３,
                食事提供費用再掲要介護４, 食事提供費用再掲要介護５, 食事提供費用再掲要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_35() {

        Decimal 介護老人福祉施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人福祉施設_2_要会護１ = div.getPnlMain().getTbl3().getTextBox1167().getValue();
        Decimal 介護老人福祉施設_2_要介護２ = div.getPnlMain().getTbl3().getTextBox1168().getValue();
        Decimal 介護老人福祉施設_2_要介護３ = div.getPnlMain().getTbl3().getTextBox1169().getValue();
        Decimal 介護老人福祉施設_2_要介護４ = div.getPnlMain().getTbl3().getTextBox1170().getValue();
        Decimal 介護老人福祉施設_2_要介護５ = div.getPnlMain().getTbl3().getTextBox1171().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1172().getValue();

        return 入力チェック2(介護老人福祉施設_2_経過的要介護, 介護老人福祉施設_2_要会護１,
                介護老人福祉施設_2_要介護２, 介護老人福祉施設_2_要介護３,
                介護老人福祉施設_2_要介護４, 介護老人福祉施設_2_要介護５, 介護老人福祉施設_2_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_36() {

        Decimal 介護老人保健施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護老人保健施設_2_要会護１ = div.getPnlMain().getTbl3().getTextBox1177().getValue();
        Decimal 介護老人保健施設_2_要介護２ = div.getPnlMain().getTbl3().getTextBox1178().getValue();
        Decimal 介護老人保健施設_2_要介護３ = div.getPnlMain().getTbl3().getTextBox1179().getValue();
        Decimal 介護老人保健施設_2_要介護４ = div.getPnlMain().getTbl3().getTextBox1180().getValue();
        Decimal 介護老人保健施設_2_要介護５ = div.getPnlMain().getTbl3().getTextBox1181().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1182().getValue();

        return 入力チェック2(介護老人保健施設_2_経過的要介護, 介護老人保健施設_2_要会護１,
                介護老人保健施設_2_要介護２, 介護老人保健施設_2_要介護３,
                介護老人保健施設_2_要介護４, 介護老人保健施設_2_要介護５, 介護老人保健施設_2_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_37() {

        Decimal 介護療養型医療施設_2_経過的要介護 = Decimal.ZERO;
        Decimal 介護療養型医療施設_2_要会護１ = div.getPnlMain().getTbl3().getTextBox1187().getValue();
        Decimal 介護療養型医療施設_2_要介護２ = div.getPnlMain().getTbl3().getTextBox1188().getValue();
        Decimal 介護療養型医療施設_2_要介護３ = div.getPnlMain().getTbl3().getTextBox1189().getValue();
        Decimal 介護療養型医療施設_2_要介護４ = div.getPnlMain().getTbl3().getTextBox1190().getValue();
        Decimal 介護療養型医療施設_2_要介護５ = div.getPnlMain().getTbl3().getTextBox1191().getValue();
        Decimal 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1192().getValue();

        return 入力チェック2(介護療養型医療施設_2_経過的要介護,
                介護療養型医療施設_2_要会護１, 介護療養型医療施設_2_要介護２, 介護療養型医療施設_2_要介護３,
                介護療養型医療施設_2_要介護４, 介護療養型医療施設_2_要介護５, 介護療養型医療施設_2_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_38() {

        Decimal 総計経過的要介護 = div.getPnlMain().getTbl3().getTextBox1199().getValue();
        Decimal 総計要会護１ = div.getPnlMain().getTbl3().getTextBox1200().getValue();
        Decimal 総計要介護２ = div.getPnlMain().getTbl3().getTextBox1201().getValue();
        Decimal 総計要介護３ = div.getPnlMain().getTbl3().getTextBox1202().getValue();
        Decimal 総計要介護４ = div.getPnlMain().getTbl3().getTextBox1203().getValue();
        Decimal 総計要介護５ = div.getPnlMain().getTbl3().getTextBox1204().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl3().getTextBox1205().getValue();

        return 入力チェック2(総計経過的要介護, 総計要会護１,
                総計要介護２, 総計要介護３, 総計要介護４, 総計要介護５, 総計要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1() {

        Decimal 居宅介護予防サービス要支援１ = div.getPnlMain().getTbl3().getTextBox586().getValue();
        Decimal 居宅介護予防サービス要支援２ = div.getPnlMain().getTbl3().getTextBox587().getValue();
        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox588().getValue();

        return 入力チェック1(居宅介護予防サービス要支援１, 居宅介護予防サービス要支援２, 居宅介護予防サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_2() {

        Decimal 訪問サービス要支援１ = div.getPnlMain().getTbl3().getTextBox597().getValue();
        Decimal 訪問サービス要支援２ = div.getPnlMain().getTbl3().getTextBox598().getValue();
        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl3().getTextBox599().getValue();

        return 入力チェック1(訪問サービス要支援１, 訪問サービス要支援２, 訪問サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_3() {

        Decimal 訪問介護要支援１ = div.getPnlMain().getTbl3().getTextBox819().getValue();
        Decimal 訪問介護要支援２ = div.getPnlMain().getTbl3().getTextBox820().getValue();
        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox821().getValue();

        return 入力チェック1(訪問介護要支援１, 訪問介護要支援２, 訪問介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_4() {

        Decimal 訪問入浴介護要支援１ = div.getPnlMain().getTbl3().getTextBox830().getValue();
        Decimal 訪問入浴介護要支援２ = div.getPnlMain().getTbl3().getTextBox831().getValue();
        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl3().getTextBox832().getValue();

        return 入力チェック1(訪問入浴介護要支援１, 訪問入浴介護要支援２, 訪問入浴介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_5() {

        Decimal 訪問看護要支援１ = div.getPnlMain().getTbl3().getTextBox841().getValue();
        Decimal 訪問看護要支援２ = div.getPnlMain().getTbl3().getTextBox842().getValue();
        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl3().getTextBox843().getValue();

        return 入力チェック1(訪問看護要支援１, 訪問看護要支援２, 訪問看護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_6() {

        Decimal 訪問リハビリテーション要支援１ = div.getPnlMain().getTbl3().getTextBox852().getValue();
        Decimal 訪問リハビリテーション要支援２ = div.getPnlMain().getTbl3().getTextBox853().getValue();
        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox854().getValue();

        return 入力チェック1(訪問リハビリテーション要支援１, 訪問リハビリテーション要支援２, 訪問リハビリテーション要支援計);
    }

    private boolean is整合性チェック_費用額_NG_7() {

        Decimal 居宅療養管理指導要支援１ = div.getPnlMain().getTbl3().getTextBox863().getValue();
        Decimal 居宅療養管理指導要支援２ = div.getPnlMain().getTbl3().getTextBox864().getValue();
        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl3().getTextBox865().getValue();

        return 入力チェック1(居宅療養管理指導要支援１, 居宅療養管理指導要支援２, 居宅療養管理指導要支援計);
    }

    private boolean is整合性チェック_費用額_NG_8() {

        Decimal 通所サービス要支援１ = div.getPnlMain().getTbl3().getTextBox874().getValue();
        Decimal 通所サービス要支援２ = div.getPnlMain().getTbl3().getTextBox875().getValue();
        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox876().getValue();

        return 入力チェック1(通所サービス要支援１, 通所サービス要支援２, 通所サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_9() {

        Decimal 通所介護要支援１ = div.getPnlMain().getTbl3().getTextBox885().getValue();
        Decimal 通所介護要支援２ = div.getPnlMain().getTbl3().getTextBox886().getValue();
        Decimal 通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox887().getValue();

        return 入力チェック1(通所介護要支援１, 通所介護要支援２, 通所介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_10() {

        Decimal 通所リハビリテーション要支援１ = div.getPnlMain().getTbl3().getTextBox896().getValue();
        Decimal 通所リハビリテーション要支援２ = div.getPnlMain().getTbl3().getTextBox897().getValue();
        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox898().getValue();

        return 入力チェック1(通所リハビリテーション要支援１, 通所リハビリテーション要支援２, 通所リハビリテーション要支援計);
    }

    private boolean is整合性チェック_費用額_NG_11() {

        Decimal 短期入所サービス要支援１ = div.getPnlMain().getTbl3().getTextBox907().getValue();
        Decimal 短期入所サービス要支援２ = div.getPnlMain().getTbl3().getTextBox908().getValue();
        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox909().getValue();

        return 入力チェック1(短期入所サービス要支援１, 短期入所サービス要支援２, 短期入所サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_12() {

        Decimal 短期入所生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox918().getValue();
        Decimal 短期入所生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox919().getValue();
        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox920().getValue();

        return 入力チェック1(短期入所生活介護要支援１, 短期入所生活介護要支援２, 短期入所生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援１ = div.getPnlMain().getTbl3().getTextBox929().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援２ = div.getPnlMain().getTbl3().getTextBox930().getValue();
        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl3().getTextBox931().getValue();

        return 入力チェック1(短期入所療養介護介護老人保健施設要支援１,
                短期入所療養介護介護老人保健施設要支援２, 短期入所療養介護介護老人保健施設要支援計);
    }

    private boolean is整合性チェック_費用額_NG_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援１ = div.getPnlMain().getTbl3().getTextBox940().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援２ = div.getPnlMain().getTbl3().getTextBox941().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl3().getTextBox942().getValue();

        return 入力チェック1(短期入所療養介護介護療養型医療施設等要支援１, 短期入所療養介護介護療養型医療施設等要支援２,
                短期入所療養介護介護療養型医療施設等要支援計);
    }

    private boolean is整合性チェック_費用額_NG_15() {

        Decimal 福祉用具住宅改修サービス要支援１ = div.getPnlMain().getTbl3().getTextBox951().getValue();
        Decimal 福祉用具住宅改修サービス要支援２ = div.getPnlMain().getTbl3().getTextBox952().getValue();
        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl3().getTextBox953().getValue();

        return 入力チェック1(福祉用具住宅改修サービス要支援１,
                福祉用具住宅改修サービス要支援２, 福祉用具住宅改修サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_16() {

        Decimal 福祉用具貸与要支援１ = div.getPnlMain().getTbl3().getTextBox962().getValue();
        Decimal 福祉用具貸与要支援２ = div.getPnlMain().getTbl3().getTextBox963().getValue();
        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl3().getTextBox964().getValue();

        return 入力チェック1(福祉用具貸与要支援１, 福祉用具貸与要支援２, 福祉用具貸与要支援計);
    }

    private boolean is整合性チェック_費用額_NG_17() {

        Decimal 福祉用具購入費要支援１ = div.getPnlMain().getTbl3().getTextBox973().getValue();
        Decimal 福祉用具購入費要支援２ = div.getPnlMain().getTbl3().getTextBox974().getValue();
        Decimal 福祉用具購入費要支援計 = div.getPnlMain().getTbl3().getTextBox975().getValue();

        return 入力チェック1(福祉用具購入費要支援１, 福祉用具購入費要支援２, 福祉用具購入費要支援計);
    }

    private boolean is整合性チェック_費用額_NG_18() {

        Decimal 住宅改修費要支援１ = div.getPnlMain().getTbl3().getTextBox984().getValue();
        Decimal 住宅改修費要支援２ = div.getPnlMain().getTbl3().getTextBox985().getValue();
        Decimal 住宅改修費要支援計 = div.getPnlMain().getTbl3().getTextBox986().getValue();

        return 入力チェック1(住宅改修費要支援１, 住宅改修費要支援２, 住宅改修費要支援計);
    }

    private boolean is整合性チェック_費用額_NG_19() {

        Decimal 特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox995().getValue();
        Decimal 特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox996().getValue();
        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox997().getValue();

        return 入力チェック1(特定施設入居者生活介護要支援１,
                特定施設入居者生活介護要支援２, 特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_20() {

        Decimal 介護予防支援居宅介護支援要支援１ = div.getPnlMain().getTbl3().getTextBox1006().getValue();
        Decimal 介護予防支援居宅介護支援要支援２ = div.getPnlMain().getTbl3().getTextBox1007().getValue();
        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl3().getTextBox1008().getValue();

        return 入力チェック1(介護予防支援居宅介護支援要支援１,
                介護予防支援居宅介護支援要支援２, 介護予防支援居宅介護支援要支援計);
    }

    private boolean is整合性チェック_費用額_NG_21() {

        Decimal 地域密着型介護予防サービス要支援１ = div.getPnlMain().getTbl3().getTextBox1017().getValue();
        Decimal 地域密着型介護予防サービス要支援２ = div.getPnlMain().getTbl3().getTextBox1018().getValue();
        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1019().getValue();

        return 入力チェック1(地域密着型介護予防サービス要支援１,
                地域密着型介護予防サービス要支援２, 地域密着型介護予防サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援１ = div.getPnlMain().getTbl3().getTextBox1028().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援２ = div.getPnlMain().getTbl3().getTextBox1029().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl3().getTextBox1030().getValue();

        return 入力チェック1(定期巡回随時対応型訪問介護看護要支援１,
                定期巡回随時対応型訪問介護看護要支援２, 定期巡回随時対応型訪問介護看護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_23() {

        Decimal 夜間対応型訪問介護要支援１ = div.getPnlMain().getTbl3().getTextBox1038().getValue();
        Decimal 夜間対応型訪問介護要支援２ = div.getPnlMain().getTbl3().getTextBox1039().getValue();
        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox1040().getValue();

        return 入力チェック1(夜間対応型訪問介護要支援１, 夜間対応型訪問介護要支援２, 夜間対応型訪問介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_24() {

        Decimal 認知症対応型通所介護要支援１ = div.getPnlMain().getTbl3().getTextBox1048().getValue();
        Decimal 認知症対応型通所介護要支援２ = div.getPnlMain().getTbl3().getTextBox1049().getValue();
        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox1050().getValue();

        return 入力チェック1(認知症対応型通所介護要支援１, 認知症対応型通所介護要支援２, 認知症対応型通所介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_25() {

        Decimal 小規模多機能型居宅介護要支援１ = div.getPnlMain().getTbl3().getTextBox1059().getValue();
        Decimal 小規模多機能型居宅介護要支援２ = div.getPnlMain().getTbl3().getTextBox1060().getValue();
        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl3().getTextBox1061().getValue();

        return 入力チェック1(小規模多機能型居宅介護要支援１, 小規模多機能型居宅介護要支援２, 小規模多機能型居宅介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_26() {

        Decimal 認知症対応型共同生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox1070().getValue();
        Decimal 認知症対応型共同生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox1071().getValue();
        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1072().getValue();

        return 入力チェック1(認知症対応型共同生活介護要支援１,
                認知症対応型共同生活介護要支援２, 認知症対応型共同生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox1080().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox1081().getValue();
        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1082().getValue();

        return 入力チェック1(地域密着型特定施設入居者生活介護要支援１,
                地域密着型特定施設入居者生活介護要支援２, 地域密着型特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox1090().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox1091().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1092().getValue();

        return 入力チェック1(地域密着型介護老人福祉施設入所者生活介護要支援１, 地域密着型介護老人福祉施設入所者生活介護要支援２,
                地域密着型介護老人福祉施設入所者生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_29() {

        Decimal 複合型サービス要支援１ = div.getPnlMain().getTbl3().getTextBox1100().getValue();
        Decimal 複合型サービス要支援２ = div.getPnlMain().getTbl3().getTextBox1101().getValue();
        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1102().getValue();

        return 入力チェック1(複合型サービス要支援１, 複合型サービス要支援２, 複合型サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_30() {

        Decimal 施設サービス要支援１ = div.getPnlMain().getTbl3().getTextBox1110().getValue();
        Decimal 施設サービス要支援２ = div.getPnlMain().getTbl3().getTextBox1111().getValue();
        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1112().getValue();

        return 入力チェック1(施設サービス要支援１, 施設サービス要支援２, 施設サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_31() {

        Decimal 介護老人福祉施設_1_要支援１ = div.getPnlMain().getTbl3().getTextBox1121().getValue();
        Decimal 介護老人福祉施設_1_要支援２ = div.getPnlMain().getTbl3().getTextBox1122().getValue();
        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1123().getValue();

        return 入力チェック1(介護老人福祉施設_1_要支援１, 介護老人福祉施設_1_要支援２, 介護老人福祉施設_1_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_32() {

        Decimal 介護老人保健施設_1_要支援１ = div.getPnlMain().getTbl3().getTextBox1132().getValue();
        Decimal 介護老人保健施設_1_要支援２ = div.getPnlMain().getTbl3().getTextBox1133().getValue();
        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1134().getValue();

        return 入力チェック1(介護老人保健施設_1_要支援１, 介護老人保健施設_1_要支援２, 介護老人保健施設_1_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_33() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl3().getTextBox1142().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl3().getTextBox1143().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1144().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_費用額_NG_34() {

        Decimal 食事提供費用再掲要支援１ = div.getPnlMain().getTbl3().getTextBox1152().getValue();
        Decimal 食事提供費用再掲要支援２ = div.getPnlMain().getTbl3().getTextBox1153().getValue();
        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl3().getTextBox1154().getValue();

        return 入力チェック1(食事提供費用再掲要支援１, 食事提供費用再掲要支援２, 食事提供費用再掲要支援計);
    }

    private boolean is整合性チェック_費用額_NG_35() {

        Decimal 介護老人福祉施設_2_要支援１ = div.getPnlMain().getTbl3().getTextBox1163().getValue();
        Decimal 介護老人福祉施設_2_要支援２ = div.getPnlMain().getTbl3().getTextBox1164().getValue();
        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1165().getValue();

        return 入力チェック1(介護老人福祉施設_2_要支援１, 介護老人福祉施設_2_要支援２, 介護老人福祉施設_2_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_36() {

        Decimal 介護老人保健施設_2_要支援１ = div.getPnlMain().getTbl3().getTextBox1174().getValue();
        Decimal 介護老人保健施設_2_要支援２ = div.getPnlMain().getTbl3().getTextBox1175().getValue();
        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1176().getValue();

        return 入力チェック1(介護老人保健施設_2_要支援１, 介護老人保健施設_2_要支援２, 介護老人保健施設_2_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_37() {

        Decimal 介護療養型医療施設要支援１ = div.getPnlMain().getTbl3().getTextBox1184().getValue();
        Decimal 介護療養型医療施設要支援２ = div.getPnlMain().getTbl3().getTextBox1185().getValue();
        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1186().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_費用額_NG_38() {

        Decimal 総計要支援１ = div.getPnlMain().getTbl3().getTextBox1194().getValue();
        Decimal 総計要支援２ = div.getPnlMain().getTbl3().getTextBox1195().getValue();
        Decimal 総計要支援計 = div.getPnlMain().getTbl3().getTextBox1196().getValue();

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
     * is整合性チェック_NG_費用額のメソッドます。
     *
     * @return 判断結果
     */
    public boolean is整合性チェック_費用額_NG3() {

        return is整合性チェック_NG_費用額_整合3_1() || is整合性チェック_NG_費用額_整合3_2()
                || is整合性チェック_NG_費用額_整合3_3();
    }

    private boolean is整合性チェック_NG_費用額_整合3_1() {
        return is整合性チェック_NG_費用額_3_1() || is整合性チェック_NG_費用額_3_2()
                || is整合性チェック_NG_費用額_3_3() || is整合性チェック_NG_費用額_3_4()
                || is整合性チェック_NG_費用額_3_5() || is整合性チェック_NG_費用額_3_6()
                || is整合性チェック_NG_費用額_3_7() || is整合性チェック_NG_費用額_3_8()
                || is整合性チェック_NG_費用額_3_9() || is整合性チェック_NG_費用額_3_10()
                || is整合性チェック_NG_費用額_3_11() || is整合性チェック_NG_費用額_3_12()
                || is整合性チェック_NG_費用額_3_13();
    }

    private boolean is整合性チェック_NG_費用額_整合3_2() {
        return is整合性チェック_NG_費用額_3_14() || is整合性チェック_NG_費用額_3_15()
                || is整合性チェック_NG_費用額_3_16() || is整合性チェック_NG_費用額_3_17()
                || is整合性チェック_NG_費用額_3_18() || is整合性チェック_NG_費用額_3_19()
                || is整合性チェック_NG_費用額_3_20() || is整合性チェック_NG_費用額_3_21()
                || is整合性チェック_NG_費用額_3_22() || is整合性チェック_NG_費用額_3_23()
                || is整合性チェック_NG_費用額_3_24() || is整合性チェック_NG_費用額_3_25()
                || is整合性チェック_NG_費用額_3_26();
    }

    private boolean is整合性チェック_NG_費用額_整合3_3() {
        return is整合性チェック_NG_費用額_3_27() || is整合性チェック_NG_費用額_3_28()
                || is整合性チェック_NG_費用額_3_29() || is整合性チェック_NG_費用額_3_30()
                || is整合性チェック_NG_費用額_3_31() || is整合性チェック_NG_費用額_3_32()
                || is整合性チェック_NG_費用額_3_33() || is整合性チェック_NG_費用額_3_34()
                || is整合性チェック_NG_費用額_3_35() || is整合性チェック_NG_費用額_3_36()
                || is整合性チェック_NG_費用額_3_37() || is整合性チェック_NG_費用額_3_38();
    }

    private boolean is整合性チェック_NG_費用額_3_1() {

        Decimal 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox588().getValue();
        Decimal 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox595().getValue();
        Decimal 居宅介護予防サービス合計 = div.getPnlMain().getTbl3().getTextBox596().getValue();

        return 入力チェック3(居宅介護予防サービス要支援計, 居宅介護予防サービス要介護計, 居宅介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_2() {

        Decimal 訪問サービス要支援計 = div.getPnlMain().getTbl3().getTextBox599().getValue();
        Decimal 訪問サービス要介護計 = div.getPnlMain().getTbl3().getTextBox606().getValue();
        Decimal 訪問サービス合計 = div.getPnlMain().getTbl3().getTextBox607().getValue();

        return 入力チェック3(訪問サービス要支援計, 訪問サービス要介護計, 訪問サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_3() {

        Decimal 訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox821().getValue();
        Decimal 訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox828().getValue();
        Decimal 訪問介護合計 = div.getPnlMain().getTbl3().getTextBox829().getValue();

        return 入力チェック3(訪問介護要支援計, 訪問介護要介護計, 訪問介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_4() {

        Decimal 訪問入浴介護要支援計 = div.getPnlMain().getTbl3().getTextBox832().getValue();
        Decimal 訪問入浴介護要介護計 = div.getPnlMain().getTbl3().getTextBox839().getValue();
        Decimal 訪問入浴介護合計 = div.getPnlMain().getTbl3().getTextBox840().getValue();

        return 入力チェック3(訪問入浴介護要支援計, 訪問入浴介護要介護計, 訪問入浴介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_5() {

        Decimal 訪問看護要支援計 = div.getPnlMain().getTbl3().getTextBox843().getValue();
        Decimal 訪問看護要介護計 = div.getPnlMain().getTbl3().getTextBox850().getValue();
        Decimal 訪問看護要合計 = div.getPnlMain().getTbl3().getTextBox851().getValue();

        return 入力チェック3(訪問看護要支援計, 訪問看護要介護計, 訪問看護要合計);
    }

    private boolean is整合性チェック_NG_費用額_3_6() {

        Decimal 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox854().getValue();
        Decimal 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox861().getValue();
        Decimal 訪問リハビリテーション合計 = div.getPnlMain().getTbl3().getTextBox862().getValue();

        return 入力チェック3(訪問リハビリテーション要支援計, 訪問リハビリテーション要介護計, 訪問リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_費用額_3_7() {

        Decimal 居宅療養管理指導要支援計 = div.getPnlMain().getTbl3().getTextBox865().getValue();
        Decimal 居宅療養管理指導要介護計 = div.getPnlMain().getTbl3().getTextBox872().getValue();
        Decimal 居宅療養管理指導合計 = div.getPnlMain().getTbl3().getTextBox873().getValue();

        return 入力チェック3(居宅療養管理指導要支援計, 居宅療養管理指導要介護計, 居宅療養管理指導合計);
    }

    private boolean is整合性チェック_NG_費用額_3_8() {

        Decimal 通所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox876().getValue();
        Decimal 通所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox883().getValue();
        Decimal 通所サービス要合計 = div.getPnlMain().getTbl3().getTextBox884().getValue();

        return 入力チェック3(通所サービス要支援計, 通所サービス要介護計, 通所サービス要合計);
    }

    private boolean is整合性チェック_NG_費用額_3_9() {

        Decimal 通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox887().getValue();
        Decimal 通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox894().getValue();
        Decimal 通所介護合計 = div.getPnlMain().getTbl3().getTextBox895().getValue();

        return 入力チェック3(通所介護要支援計, 通所介護要介護計, 通所介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_10() {

        Decimal 通所リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox898().getValue();
        Decimal 通所リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox905().getValue();
        Decimal 通所リハビリテーション合計 = div.getPnlMain().getTbl3().getTextBox906().getValue();

        return 入力チェック3(通所リハビリテーション要支援計, 通所リハビリテーション要介護計, 通所リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_費用額_3_11() {

        Decimal 短期入所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox909().getValue();
        Decimal 短期入所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox916().getValue();
        Decimal 短期入所サービス合計 = div.getPnlMain().getTbl3().getTextBox917().getValue();

        return 入力チェック3(短期入所サービス要支援計, 短期入所サービス要介護計, 短期入所サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_12() {

        Decimal 短期入所生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox920().getValue();
        Decimal 短期入所生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox927().getValue();
        Decimal 短期入所生活介護合計 = div.getPnlMain().getTbl3().getTextBox928().getValue();

        return 入力チェック3(短期入所生活介護要支援計, 短期入所生活介護要介護計, 短期入所生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_13() {

        Decimal 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl3().getTextBox931().getValue();
        Decimal 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl3().getTextBox938().getValue();
        Decimal 短期入所療養介護介護老人保健施設合計 = div.getPnlMain().getTbl3().getTextBox939().getValue();

        return 入力チェック3(短期入所療養介護介護老人保健施設要支援計,
                短期入所療養介護介護老人保健施設要介護計, 短期入所療養介護介護老人保健施設合計);
    }

    private boolean is整合性チェック_NG_費用額_3_14() {

        Decimal 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl3().getTextBox942().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl3().getTextBox949().getValue();
        Decimal 短期入所療養介護介護療養型医療施設等合計 = div.getPnlMain().getTbl3().getTextBox950().getValue();

        return 入力チェック3(短期入所療養介護介護療養型医療施設等要支援計, 短期入所療養介護介護療養型医療施設等要介護計,
                短期入所療養介護介護療養型医療施設等合計);
    }

    private boolean is整合性チェック_NG_費用額_3_15() {

        Decimal 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl3().getTextBox953().getValue();
        Decimal 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl3().getTextBox960().getValue();
        Decimal 福祉用具住宅改修サービス合計 = div.getPnlMain().getTbl3().getTextBox961().getValue();

        return 入力チェック3(福祉用具住宅改修サービス要支援計, 福祉用具住宅改修サービス要介護計, 福祉用具住宅改修サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_16() {

        Decimal 福祉用具貸与要支援計 = div.getPnlMain().getTbl3().getTextBox964().getValue();
        Decimal 福祉用具貸与要介護計 = div.getPnlMain().getTbl3().getTextBox971().getValue();
        Decimal 福祉用具貸与合計 = div.getPnlMain().getTbl3().getTextBox972().getValue();

        return 入力チェック3(福祉用具貸与要支援計, 福祉用具貸与要介護計, 福祉用具貸与合計);
    }

    private boolean is整合性チェック_NG_費用額_3_17() {

        Decimal 福祉用具購入費要支援計 = div.getPnlMain().getTbl3().getTextBox975().getValue();
        Decimal 福祉用具購入費要介護計 = div.getPnlMain().getTbl3().getTextBox982().getValue();
        Decimal 福祉用具購入費合計 = div.getPnlMain().getTbl3().getTextBox983().getValue();

        return 入力チェック3(福祉用具購入費要支援計, 福祉用具購入費要介護計, 福祉用具購入費合計);
    }

    private boolean is整合性チェック_NG_費用額_3_18() {

        Decimal 住宅改修費要支援計 = div.getPnlMain().getTbl3().getTextBox986().getValue();
        Decimal 住宅改修費要介護計 = div.getPnlMain().getTbl3().getTextBox993().getValue();
        Decimal 住宅改修費合計 = div.getPnlMain().getTbl3().getTextBox994().getValue();

        return 入力チェック3(住宅改修費要支援計, 住宅改修費要介護計, 住宅改修費合計);
    }

    private boolean is整合性チェック_NG_費用額_3_19() {

        Decimal 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox997().getValue();
        Decimal 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1004().getValue();
        Decimal 特定施設入居者生活介護合計 = div.getPnlMain().getTbl3().getTextBox1005().getValue();

        return 入力チェック3(特定施設入居者生活介護要支援計, 特定施設入居者生活介護要介護計, 特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_20() {

        Decimal 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl3().getTextBox1008().getValue();
        Decimal 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl3().getTextBox1015().getValue();
        Decimal 介護予防支援居宅介護支援合計 = div.getPnlMain().getTbl3().getTextBox1016().getValue();

        return 入力チェック3(介護予防支援居宅介護支援要支援計, 介護予防支援居宅介護支援要介護計, 介護予防支援居宅介護支援合計);
    }

    private boolean is整合性チェック_NG_費用額_3_21() {

        Decimal 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1019().getValue();
        Decimal 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1026().getValue();
        Decimal 地域密着型介護予防サービス合計 = div.getPnlMain().getTbl3().getTextBox1027().getValue();

        return 入力チェック3(地域密着型介護予防サービス要支援計,
                地域密着型介護予防サービス要介護計, 地域密着型介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_22() {

        Decimal 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl3().getTextBox1030().getValue();
        Decimal 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl3().getTextBox1036().getValue();
        Decimal 定期巡回随時対応型訪問介護看護合計 = div.getPnlMain().getTbl3().getTextBox1037().getValue();

        return 入力チェック3(定期巡回随時対応型訪問介護看護要支援計,
                定期巡回随時対応型訪問介護看護要介護計, 定期巡回随時対応型訪問介護看護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_23() {

        Decimal 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox1040().getValue();
        Decimal 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox1046().getValue();
        Decimal 夜間対応型訪問介護合計 = div.getPnlMain().getTbl3().getTextBox1047().getValue();

        return 入力チェック3(夜間対応型訪問介護要支援計, 夜間対応型訪問介護要介護計, 夜間対応型訪問介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_24() {

        Decimal 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox1050().getValue();
        Decimal 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox1057().getValue();
        Decimal 認知症対応型通所介護合計 = div.getPnlMain().getTbl3().getTextBox1058().getValue();

        return 入力チェック3(認知症対応型通所介護要支援計, 認知症対応型通所介護要介護計, 認知症対応型通所介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_25() {

        Decimal 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl3().getTextBox1061().getValue();
        Decimal 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl3().getTextBox1068().getValue();
        Decimal 小規模多機能型居宅介護合計 = div.getPnlMain().getTbl3().getTextBox1069().getValue();

        return 入力チェック3(小規模多機能型居宅介護要支援計, 小規模多機能型居宅介護要介護計, 小規模多機能型居宅介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_26() {

        Decimal 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1072().getValue();
        Decimal 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1078().getValue();
        Decimal 認知症対応型共同生活介護合計 = div.getPnlMain().getTbl3().getTextBox1079().getValue();

        return 入力チェック3(認知症対応型共同生活介護要支援計, 認知症対応型共同生活介護要介護計, 認知症対応型共同生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_27() {

        Decimal 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1082().getValue();
        Decimal 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1088().getValue();
        Decimal 地域密着型特定施設入居者生活介護合計 = div.getPnlMain().getTbl3().getTextBox1089().getValue();

        return 入力チェック3(地域密着型特定施設入居者生活介護要支援計,
                地域密着型特定施設入居者生活介護要介護計, 地域密着型特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_28() {

        Decimal 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1092().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1098().getValue();
        Decimal 地域密着型介護老人福祉施設入所者生活介護合計 = div.getPnlMain().getTbl3().getTextBox1099().getValue();

        return 入力チェック3(地域密着型介護老人福祉施設入所者生活介護要支援計, 地域密着型介護老人福祉施設入所者生活介護要介護計,
                地域密着型介護老人福祉施設入所者生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_29() {

        Decimal 複合型サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1102().getValue();
        Decimal 複合型サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1108().getValue();
        Decimal 複合型サービス合計 = div.getPnlMain().getTbl3().getTextBox1109().getValue();

        return 入力チェック3(複合型サービス要支援計, 複合型サービス要介護計, 複合型サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_30() {

        Decimal 施設サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1112().getValue();
        Decimal 施設サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1119().getValue();
        Decimal 施設サービス合計 = div.getPnlMain().getTbl3().getTextBox1120().getValue();

        return 入力チェック3(施設サービス要支援計, 施設サービス要介護計, 施設サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_31() {

        Decimal 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1123().getValue();
        Decimal 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1130().getValue();
        Decimal 介護老人福祉施設_1_合計 = div.getPnlMain().getTbl3().getTextBox1131().getValue();

        return 入力チェック3(介護老人福祉施設_1_要支援計, 介護老人福祉施設_1_要介護計, 介護老人福祉施設_1_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_32() {

        Decimal 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1134().getValue();
        Decimal 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1140().getValue();
        Decimal 介護老人保健施設_1_合計 = div.getPnlMain().getTbl3().getTextBox1141().getValue();

        return 入力チェック3(介護老人保健施設_1_要支援計, 介護老人保健施設_1_要介護計, 介護老人保健施設_1_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_33() {

        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1144().getValue();
        Decimal 介護療養型医療施設要介護計 = div.getPnlMain().getTbl3().getTextBox1150().getValue();
        Decimal 介護療養型医療施設合計 = div.getPnlMain().getTbl3().getTextBox1151().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_費用額_3_34() {

        Decimal 食事提供費用再掲要支援計 = div.getPnlMain().getTbl3().getTextBox1154().getValue();
        Decimal 食事提供費用再掲要介護計 = div.getPnlMain().getTbl3().getTextBox1161().getValue();
        Decimal 食事提供費用再掲合計 = div.getPnlMain().getTbl3().getTextBox1162().getValue();

        return 入力チェック3(食事提供費用再掲要支援計, 食事提供費用再掲要介護計, 食事提供費用再掲合計);
    }

    private boolean is整合性チェック_NG_費用額_3_35() {

        Decimal 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1165().getValue();
        Decimal 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1172().getValue();
        Decimal 介護老人福祉施設_2_合計 = div.getPnlMain().getTbl3().getTextBox1173().getValue();

        return 入力チェック3(介護老人福祉施設_2_要支援計, 介護老人福祉施設_2_要介護計, 介護老人福祉施設_2_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_36() {

        Decimal 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1176().getValue();
        Decimal 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1182().getValue();
        Decimal 介護老人保健施設_2_合計 = div.getPnlMain().getTbl3().getTextBox1183().getValue();

        return 入力チェック3(介護老人保健施設_2_要支援計, 介護老人保健施設_2_要介護計, 介護老人保健施設_2_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_37() {

        Decimal 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1186().getValue();
        Decimal 介護療養型医療施設要介護計 = div.getPnlMain().getTbl3().getTextBox1192().getValue();
        Decimal 介護療養型医療施設合計 = div.getPnlMain().getTbl3().getTextBox1193().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_費用額_3_38() {

        Decimal 総計要支援計 = div.getPnlMain().getTbl3().getTextBox1196().getValue();
        Decimal 総計要介護計 = div.getPnlMain().getTbl3().getTextBox1204().getValue();
        Decimal 総計合計 = div.getPnlMain().getTbl3().getTextBox1205().getValue();

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

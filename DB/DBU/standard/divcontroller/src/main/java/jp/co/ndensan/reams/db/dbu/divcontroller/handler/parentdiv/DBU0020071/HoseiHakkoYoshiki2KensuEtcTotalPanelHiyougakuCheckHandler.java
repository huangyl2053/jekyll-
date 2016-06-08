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

        RString 居宅介護予防サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox589().getValue();
        RString 居宅介護予防サービス要会護１ = div.getPnlMain().getTbl3().getTextBox590().getValue();
        RString 居宅介護予防サービス要介護２ = div.getPnlMain().getTbl3().getTextBox591().getValue();
        RString 居宅介護予防サービス要介護３ = div.getPnlMain().getTbl3().getTextBox592().getValue();
        RString 居宅介護予防サービス要介護４ = div.getPnlMain().getTbl3().getTextBox593().getValue();
        RString 居宅介護予防サービス要介護５ = div.getPnlMain().getTbl3().getTextBox594().getValue();
        RString 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox595().getValue();

        return 入力チェック2(居宅介護予防サービス経過的要介護,
                居宅介護予防サービス要会護１, 居宅介護予防サービス要介護２, 居宅介護予防サービス要介護３,
                居宅介護予防サービス要介護４, 居宅介護予防サービス要介護５, 居宅介護予防サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_2() {

        RString 訪問サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox600().getValue();
        RString 訪問サービス要会護１ = div.getPnlMain().getTbl3().getTextBox601().getValue();
        RString 訪問サービス要介護２ = div.getPnlMain().getTbl3().getTextBox602().getValue();
        RString 訪問サービス要介護３ = div.getPnlMain().getTbl3().getTextBox603().getValue();
        RString 訪問サービス要介護４ = div.getPnlMain().getTbl3().getTextBox604().getValue();
        RString 訪問サービス要介護５ = div.getPnlMain().getTbl3().getTextBox605().getValue();
        RString 訪問サービス要介護計 = div.getPnlMain().getTbl3().getTextBox606().getValue();

        return 入力チェック2(訪問サービス経過的要介護, 訪問サービス要会護１,
                訪問サービス要介護２, 訪問サービス要介護３, 訪問サービス要介護４,
                訪問サービス要介護５, 訪問サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_3() {

        RString 訪問介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox822().getValue();
        RString 訪問介護要会護１ = div.getPnlMain().getTbl3().getTextBox823().getValue();
        RString 訪問介護要介護２ = div.getPnlMain().getTbl3().getTextBox824().getValue();
        RString 訪問介護要介護３ = div.getPnlMain().getTbl3().getTextBox825().getValue();
        RString 訪問介護要介護４ = div.getPnlMain().getTbl3().getTextBox826().getValue();
        RString 訪問介護要介護５ = div.getPnlMain().getTbl3().getTextBox827().getValue();
        RString 訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox828().getValue();

        return 入力チェック2(訪問介護経過的要介護, 訪問介護要会護１,
                訪問介護要介護２, 訪問介護要介護３, 訪問介護要介護４, 訪問介護要介護５, 訪問介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_4() {

        RString 訪問入浴介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox833().getValue();
        RString 訪問入浴介護要会護１ = div.getPnlMain().getTbl3().getTextBox834().getValue();
        RString 訪問入浴介護要介護２ = div.getPnlMain().getTbl3().getTextBox835().getValue();
        RString 訪問入浴介護要介護３ = div.getPnlMain().getTbl3().getTextBox836().getValue();
        RString 訪問入浴介護要介護４ = div.getPnlMain().getTbl3().getTextBox837().getValue();
        RString 訪問入浴介護要介護５ = div.getPnlMain().getTbl3().getTextBox838().getValue();
        RString 訪問入浴介護要介護計 = div.getPnlMain().getTbl3().getTextBox839().getValue();

        return 入力チェック2(訪問入浴介護経過的要介護, 訪問入浴介護要会護１, 訪問入浴介護要介護２,
                訪問入浴介護要介護３, 訪問入浴介護要介護４, 訪問入浴介護要介護５, 訪問入浴介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_5() {

        RString 訪問看護経過的要介護 = div.getPnlMain().getTbl3().getTextBox844().getValue();
        RString 訪問看護要会護１ = div.getPnlMain().getTbl3().getTextBox845().getValue();
        RString 訪問看護要介護２ = div.getPnlMain().getTbl3().getTextBox846().getValue();
        RString 訪問看護要介護３ = div.getPnlMain().getTbl3().getTextBox847().getValue();
        RString 訪問看護要介護４ = div.getPnlMain().getTbl3().getTextBox848().getValue();
        RString 訪問看護要介護５ = div.getPnlMain().getTbl3().getTextBox849().getValue();
        RString 訪問看護要介護計 = div.getPnlMain().getTbl3().getTextBox850().getValue();

        return 入力チェック2(訪問看護経過的要介護, 訪問看護要会護１,
                訪問看護要介護２, 訪問看護要介護３, 訪問看護要介護４, 訪問看護要介護５, 訪問看護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_6() {

        RString 訪問リハビリテーション経過的要介護 = div.getPnlMain().getTbl3().getTextBox855().getValue();
        RString 訪問リハビリテーション要会護１ = div.getPnlMain().getTbl3().getTextBox856().getValue();
        RString 訪問リハビリテーション要介護２ = div.getPnlMain().getTbl3().getTextBox857().getValue();
        RString 訪問リハビリテーション要介護３ = div.getPnlMain().getTbl3().getTextBox858().getValue();
        RString 訪問リハビリテーション要介護４ = div.getPnlMain().getTbl3().getTextBox859().getValue();
        RString 訪問リハビリテーション要介護５ = div.getPnlMain().getTbl3().getTextBox860().getValue();
        RString 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox861().getValue();

        return 入力チェック2(訪問リハビリテーション経過的要介護,
                訪問リハビリテーション要会護１, 訪問リハビリテーション要介護２,
                訪問リハビリテーション要介護３, 訪問リハビリテーション要介護４,
                訪問リハビリテーション要介護５, 訪問リハビリテーション要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_7() {

        RString 居宅療養管理指導経過的要介護 = div.getPnlMain().getTbl3().getTextBox866().getValue();
        RString 居宅療養管理指導要会護１ = div.getPnlMain().getTbl3().getTextBox867().getValue();
        RString 居宅療養管理指導要介護２ = div.getPnlMain().getTbl3().getTextBox868().getValue();
        RString 居宅療養管理指導要介護３ = div.getPnlMain().getTbl3().getTextBox869().getValue();
        RString 居宅療養管理指導要介護４ = div.getPnlMain().getTbl3().getTextBox870().getValue();
        RString 居宅療養管理指導要介護５ = div.getPnlMain().getTbl3().getTextBox871().getValue();
        RString 居宅療養管理指導要介護計 = div.getPnlMain().getTbl3().getTextBox872().getValue();

        return 入力チェック2(居宅療養管理指導経過的要介護, 居宅療養管理指導要会護１, 居宅療養管理指導要介護２,
                居宅療養管理指導要介護３, 居宅療養管理指導要介護４, 居宅療養管理指導要介護５, 居宅療養管理指導要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_8() {

        RString 通所サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox877().getValue();
        RString 通所サービス要会護１ = div.getPnlMain().getTbl3().getTextBox878().getValue();
        RString 通所サービス要介護２ = div.getPnlMain().getTbl3().getTextBox879().getValue();
        RString 通所サービス要介護３ = div.getPnlMain().getTbl3().getTextBox880().getValue();
        RString 通所サービス要介護４ = div.getPnlMain().getTbl3().getTextBox881().getValue();
        RString 通所サービス要介護５ = div.getPnlMain().getTbl3().getTextBox882().getValue();
        RString 通所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox883().getValue();

        return 入力チェック2(通所サービス経過的要介護, 通所サービス要会護１, 通所サービス要介護２, 通所サービス要介護３,
                通所サービス要介護４, 通所サービス要介護５, 通所サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_9() {

        RString 通所介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox888().getValue();
        RString 通所介護要会護１ = div.getPnlMain().getTbl3().getTextBox889().getValue();
        RString 通所介護要介護２ = div.getPnlMain().getTbl3().getTextBox890().getValue();
        RString 通所介護要介護３ = div.getPnlMain().getTbl3().getTextBox891().getValue();
        RString 通所介護要介護４ = div.getPnlMain().getTbl3().getTextBox892().getValue();
        RString 通所介護要介護５ = div.getPnlMain().getTbl3().getTextBox893().getValue();
        RString 通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox894().getValue();

        return 入力チェック2(通所介護経過的要介護, 通所介護要会護１,
                通所介護要介護２, 通所介護要介護３, 通所介護要介護４, 通所介護要介護５, 通所介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_10() {

        RString 通所リハビリテーション経過的要介護 = div.getPnlMain().getTbl3().getTextBox899().getValue();
        RString 通所リハビリテーション要会護１ = div.getPnlMain().getTbl3().getTextBox900().getValue();
        RString 通所リハビリテーション要介護２ = div.getPnlMain().getTbl3().getTextBox901().getValue();
        RString 通所リハビリテーション要介護３ = div.getPnlMain().getTbl3().getTextBox902().getValue();
        RString 通所リハビリテーション要介護４ = div.getPnlMain().getTbl3().getTextBox903().getValue();
        RString 通所リハビリテーション要介護５ = div.getPnlMain().getTbl3().getTextBox904().getValue();
        RString 通所リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox905().getValue();

        return 入力チェック2(通所リハビリテーション経過的要介護,
                通所リハビリテーション要会護１, 通所リハビリテーション要介護２,
                通所リハビリテーション要介護３, 通所リハビリテーション要介護４,
                通所リハビリテーション要介護５, 通所リハビリテーション要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_11() {

        RString 短期入所サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox910().getValue();
        RString 短期入所サービス要会護１ = div.getPnlMain().getTbl3().getTextBox911().getValue();
        RString 短期入所サービス要介護２ = div.getPnlMain().getTbl3().getTextBox912().getValue();
        RString 短期入所サービス要介護３ = div.getPnlMain().getTbl3().getTextBox913().getValue();
        RString 短期入所サービス要介護４ = div.getPnlMain().getTbl3().getTextBox914().getValue();
        RString 短期入所サービス要介護５ = div.getPnlMain().getTbl3().getTextBox915().getValue();
        RString 短期入所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox916().getValue();

        return 入力チェック2(短期入所サービス経過的要介護, 短期入所サービス要会護１,
                短期入所サービス要介護２, 短期入所サービス要介護３,
                短期入所サービス要介護４, 短期入所サービス要介護５, 短期入所サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_12() {

        RString 短期入所生活介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox921().getValue();
        RString 短期入所生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox922().getValue();
        RString 短期入所生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox923().getValue();
        RString 短期入所生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox924().getValue();
        RString 短期入所生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox925().getValue();
        RString 短期入所生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox926().getValue();
        RString 短期入所生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox927().getValue();

        return 入力チェック2(短期入所生活介護経過的要介護, 短期入所生活介護要会護１, 短期入所生活介護要介護２,
                短期入所生活介護要介護３, 短期入所生活介護要介護４, 短期入所生活介護要介護５, 短期入所生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_13() {

        RString 短期入所療養介護介護老人保健施設経過的要介護 = div.getPnlMain().getTbl3().getTextBox932().getValue();
        RString 短期入所療養介護介護老人保健施設要会護１ = div.getPnlMain().getTbl3().getTextBox933().getValue();
        RString 短期入所療養介護介護老人保健施設要介護２ = div.getPnlMain().getTbl3().getTextBox934().getValue();
        RString 短期入所療養介護介護老人保健施設要介護３ = div.getPnlMain().getTbl3().getTextBox935().getValue();
        RString 短期入所療養介護介護老人保健施設要介護４ = div.getPnlMain().getTbl3().getTextBox936().getValue();
        RString 短期入所療養介護介護老人保健施設要介護５ = div.getPnlMain().getTbl3().getTextBox937().getValue();
        RString 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl3().getTextBox938().getValue();

        return 入力チェック2(短期入所療養介護介護老人保健施設経過的要介護, 短期入所療養介護介護老人保健施設要会護１,
                短期入所療養介護介護老人保健施設要介護２, 短期入所療養介護介護老人保健施設要介護３,
                短期入所療養介護介護老人保健施設要介護４, 短期入所療養介護介護老人保健施設要介護５,
                短期入所療養介護介護老人保健施設要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_14() {

        RString 短期入所療養介護介護療養型医療施設等経過的要介護 = div.getPnlMain().getTbl3().getTextBox943().getValue();
        RString 短期入所療養介護介護療養型医療施設等要会護１ = div.getPnlMain().getTbl3().getTextBox944().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護２ = div.getPnlMain().getTbl3().getTextBox945().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護３ = div.getPnlMain().getTbl3().getTextBox946().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護４ = div.getPnlMain().getTbl3().getTextBox947().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護５ = div.getPnlMain().getTbl3().getTextBox948().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl3().getTextBox949().getValue();

        return 入力チェック2(短期入所療養介護介護療養型医療施設等経過的要介護, 短期入所療養介護介護療養型医療施設等要会護１,
                短期入所療養介護介護療養型医療施設等要介護２, 短期入所療養介護介護療養型医療施設等要介護３,
                短期入所療養介護介護療養型医療施設等要介護４, 短期入所療養介護介護療養型医療施設等要介護５,
                短期入所療養介護介護療養型医療施設等要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_15() {

        RString 福祉用具住宅改修サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox954().getValue();
        RString 福祉用具住宅改修サービス要会護１ = div.getPnlMain().getTbl3().getTextBox955().getValue();
        RString 福祉用具住宅改修サービス要介護２ = div.getPnlMain().getTbl3().getTextBox956().getValue();
        RString 福祉用具住宅改修サービス要介護３ = div.getPnlMain().getTbl3().getTextBox957().getValue();
        RString 福祉用具住宅改修サービス要介護４ = div.getPnlMain().getTbl3().getTextBox958().getValue();
        RString 福祉用具住宅改修サービス要介護５ = div.getPnlMain().getTbl3().getTextBox959().getValue();
        RString 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl3().getTextBox960().getValue();

        return 入力チェック2(福祉用具住宅改修サービス経過的要介護,
                福祉用具住宅改修サービス要会護１, 福祉用具住宅改修サービス要介護２,
                福祉用具住宅改修サービス要介護３, 福祉用具住宅改修サービス要介護４,
                福祉用具住宅改修サービス要介護５, 福祉用具住宅改修サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_16() {

        RString 福祉用具貸与経過的要介護 = div.getPnlMain().getTbl3().getTextBox965().getValue();
        RString 福祉用具貸与要会護１ = div.getPnlMain().getTbl3().getTextBox966().getValue();
        RString 福祉用具貸与要介護２ = div.getPnlMain().getTbl3().getTextBox967().getValue();
        RString 福祉用具貸与要介護３ = div.getPnlMain().getTbl3().getTextBox968().getValue();
        RString 福祉用具貸与要介護４ = div.getPnlMain().getTbl3().getTextBox969().getValue();
        RString 福祉用具貸与要介護５ = div.getPnlMain().getTbl3().getTextBox970().getValue();
        RString 福祉用具貸与要介護計 = div.getPnlMain().getTbl3().getTextBox971().getValue();

        return 入力チェック2(福祉用具貸与経過的要介護, 福祉用具貸与要会護１, 福祉用具貸与要介護２, 福祉用具貸与要介護３,
                福祉用具貸与要介護４, 福祉用具貸与要介護５, 福祉用具貸与要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_17() {

        RString 福祉用具購入費経過的要介護 = div.getPnlMain().getTbl3().getTextBox976().getValue();
        RString 福祉用具購入費要会護１ = div.getPnlMain().getTbl3().getTextBox977().getValue();
        RString 福祉用具購入費要介護２ = div.getPnlMain().getTbl3().getTextBox978().getValue();
        RString 福祉用具購入費要介護３ = div.getPnlMain().getTbl3().getTextBox979().getValue();
        RString 福祉用具購入費要介護４ = div.getPnlMain().getTbl3().getTextBox980().getValue();
        RString 福祉用具購入費要介護５ = div.getPnlMain().getTbl3().getTextBox981().getValue();
        RString 福祉用具購入費要介護計 = div.getPnlMain().getTbl3().getTextBox982().getValue();

        return 入力チェック2(福祉用具購入費経過的要介護, 福祉用具購入費要会護１,
                福祉用具購入費要介護２, 福祉用具購入費要介護３,
                福祉用具購入費要介護４, 福祉用具購入費要介護５, 福祉用具購入費要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_18() {

        RString 住宅改修費経過的要介護 = div.getPnlMain().getTbl3().getTextBox987().getValue();
        RString 住宅改修費要会護１ = div.getPnlMain().getTbl3().getTextBox988().getValue();
        RString 住宅改修費要介護２ = div.getPnlMain().getTbl3().getTextBox989().getValue();
        RString 住宅改修費要介護３ = div.getPnlMain().getTbl3().getTextBox990().getValue();
        RString 住宅改修費要介護４ = div.getPnlMain().getTbl3().getTextBox991().getValue();
        RString 住宅改修費要介護５ = div.getPnlMain().getTbl3().getTextBox992().getValue();
        RString 住宅改修費要介護計 = div.getPnlMain().getTbl3().getTextBox993().getValue();

        return 入力チェック2(住宅改修費経過的要介護, 住宅改修費要会護１,
                住宅改修費要介護２, 住宅改修費要介護３, 住宅改修費要介護４,
                住宅改修費要介護５, 住宅改修費要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_19() {

        RString 特定施設入居者生活介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox998().getValue();
        RString 特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox999().getValue();
        RString 特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1000().getValue();
        RString 特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1001().getValue();
        RString 特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1002().getValue();
        RString 特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1003().getValue();
        RString 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1004().getValue();

        return 入力チェック2(特定施設入居者生活介護経過的要介護,
                特定施設入居者生活介護要会護１, 特定施設入居者生活介護要介護２,
                特定施設入居者生活介護要介護３, 特定施設入居者生活介護要介護４,
                特定施設入居者生活介護要介護５, 特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_20() {

        RString 介護予防支援居宅介護支援経過的要介護 = div.getPnlMain().getTbl3().getTextBox1009().getValue();
        RString 介護予防支援居宅介護支援要会護１ = div.getPnlMain().getTbl3().getTextBox1010().getValue();
        RString 介護予防支援居宅介護支援要介護２ = div.getPnlMain().getTbl3().getTextBox1011().getValue();
        RString 介護予防支援居宅介護支援要介護３ = div.getPnlMain().getTbl3().getTextBox1012().getValue();
        RString 介護予防支援居宅介護支援要介護４ = div.getPnlMain().getTbl3().getTextBox1013().getValue();
        RString 介護予防支援居宅介護支援要介護５ = div.getPnlMain().getTbl3().getTextBox1014().getValue();
        RString 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl3().getTextBox1015().getValue();

        return 入力チェック2(介護予防支援居宅介護支援経過的要介護,
                介護予防支援居宅介護支援要会護１, 介護予防支援居宅介護支援要介護２,
                介護予防支援居宅介護支援要介護３, 介護予防支援居宅介護支援要介護４,
                介護予防支援居宅介護支援要介護５, 介護予防支援居宅介護支援要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_21() {

        RString 地域密着型介護予防サービス経過的要介護 = div.getPnlMain().getTbl3().getTextBox1020().getValue();
        RString 地域密着型介護予防サービス要会護１ = div.getPnlMain().getTbl3().getTextBox1021().getValue();
        RString 地域密着型介護予防サービス要介護２ = div.getPnlMain().getTbl3().getTextBox1022().getValue();
        RString 地域密着型介護予防サービス要介護３ = div.getPnlMain().getTbl3().getTextBox1023().getValue();
        RString 地域密着型介護予防サービス要介護４ = div.getPnlMain().getTbl3().getTextBox1024().getValue();
        RString 地域密着型介護予防サービス要介護５ = div.getPnlMain().getTbl3().getTextBox1025().getValue();
        RString 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1026().getValue();

        return 入力チェック2(地域密着型介護予防サービス経過的要介護,
                地域密着型介護予防サービス要会護１, 地域密着型介護予防サービス要介護２,
                地域密着型介護予防サービス要介護３, 地域密着型介護予防サービス要介護４,
                地域密着型介護予防サービス要介護５, 地域密着型介護予防サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_22() {

        RString 定期巡回随時対応型訪問介護看護経過的要介護 = RString.EMPTY;
        RString 定期巡回随時対応型訪問介護看護要会護１ = div.getPnlMain().getTbl3().getTextBox1031().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護２ = div.getPnlMain().getTbl3().getTextBox1032().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護３ = div.getPnlMain().getTbl3().getTextBox1033().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護４ = div.getPnlMain().getTbl3().getTextBox1034().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護５ = div.getPnlMain().getTbl3().getTextBox1035().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl3().getTextBox1036().getValue();

        return 入力チェック2(定期巡回随時対応型訪問介護看護経過的要介護,
                定期巡回随時対応型訪問介護看護要会護１, 定期巡回随時対応型訪問介護看護要介護２,
                定期巡回随時対応型訪問介護看護要介護３, 定期巡回随時対応型訪問介護看護要介護４,
                定期巡回随時対応型訪問介護看護要介護５, 定期巡回随時対応型訪問介護看護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_23() {

        RString 夜間対応型訪問介護経過的要介護 = RString.EMPTY;
        RString 夜間対応型訪問介護要会護１ = div.getPnlMain().getTbl3().getTextBox1041().getValue();
        RString 夜間対応型訪問介護要介護２ = div.getPnlMain().getTbl3().getTextBox1042().getValue();
        RString 夜間対応型訪問介護要介護３ = div.getPnlMain().getTbl3().getTextBox1043().getValue();
        RString 夜間対応型訪問介護要介護４ = div.getPnlMain().getTbl3().getTextBox1044().getValue();
        RString 夜間対応型訪問介護要介護５ = div.getPnlMain().getTbl3().getTextBox1045().getValue();
        RString 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox1046().getValue();

        return 入力チェック2(夜間対応型訪問介護経過的要介護,
                夜間対応型訪問介護要会護１, 夜間対応型訪問介護要介護２, 夜間対応型訪問介護要介護３,
                夜間対応型訪問介護要介護４, 夜間対応型訪問介護要介護５, 夜間対応型訪問介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_24() {

        RString 認知症対応型通所介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox1051().getValue();
        RString 認知症対応型通所介護要会護１ = div.getPnlMain().getTbl3().getTextBox1052().getValue();
        RString 認知症対応型通所介護要介護２ = div.getPnlMain().getTbl3().getTextBox1053().getValue();
        RString 認知症対応型通所介護要介護３ = div.getPnlMain().getTbl3().getTextBox1054().getValue();
        RString 認知症対応型通所介護要介護４ = div.getPnlMain().getTbl3().getTextBox1055().getValue();
        RString 認知症対応型通所介護要介護５ = div.getPnlMain().getTbl3().getTextBox1056().getValue();
        RString 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox1057().getValue();

        return 入力チェック2(認知症対応型通所介護経過的要介護,
                認知症対応型通所介護要会護１, 認知症対応型通所介護要介護２, 認知症対応型通所介護要介護３,
                認知症対応型通所介護要介護４, 認知症対応型通所介護要介護５, 認知症対応型通所介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_25() {

        RString 小規模多機能型居宅介護経過的要介護 = div.getPnlMain().getTbl3().getTextBox1062().getValue();
        RString 小規模多機能型居宅介護要会護１ = div.getPnlMain().getTbl3().getTextBox1063().getValue();
        RString 小規模多機能型居宅介護要介護２ = div.getPnlMain().getTbl3().getTextBox1064().getValue();
        RString 小規模多機能型居宅介護要介護３ = div.getPnlMain().getTbl3().getTextBox1065().getValue();
        RString 小規模多機能型居宅介護要介護４ = div.getPnlMain().getTbl3().getTextBox1066().getValue();
        RString 小規模多機能型居宅介護要介護５ = div.getPnlMain().getTbl3().getTextBox1067().getValue();
        RString 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl3().getTextBox1068().getValue();

        return 入力チェック2(小規模多機能型居宅介護経過的要介護,
                小規模多機能型居宅介護要会護１, 小規模多機能型居宅介護要介護２,
                小規模多機能型居宅介護要介護３, 小規模多機能型居宅介護要介護４,
                小規模多機能型居宅介護要介護５, 小規模多機能型居宅介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_26() {

        RString 認知症対応型共同生活介護経過的要介護 = RString.EMPTY;
        RString 認知症対応型共同生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox1073().getValue();
        RString 認知症対応型共同生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1074().getValue();
        RString 認知症対応型共同生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1075().getValue();
        RString 認知症対応型共同生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1076().getValue();
        RString 認知症対応型共同生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1077().getValue();
        RString 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1078().getValue();

        return 入力チェック2(認知症対応型共同生活介護経過的要介護,
                認知症対応型共同生活介護要会護１, 認知症対応型共同生活介護要介護２,
                認知症対応型共同生活介護要介護３, 認知症対応型共同生活介護要介護４,
                認知症対応型共同生活介護要介護５, 認知症対応型共同生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_27() {

        RString 地域密着型特定施設入居者生活介護経過的要介護 = RString.EMPTY;
        RString 地域密着型特定施設入居者生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox1083().getValue();
        RString 地域密着型特定施設入居者生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1084().getValue();
        RString 地域密着型特定施設入居者生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1085().getValue();
        RString 地域密着型特定施設入居者生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1086().getValue();
        RString 地域密着型特定施設入居者生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1087().getValue();
        RString 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1088().getValue();

        return 入力チェック2(地域密着型特定施設入居者生活介護経過的要介護,
                地域密着型特定施設入居者生活介護要会護１, 地域密着型特定施設入居者生活介護要介護２,
                地域密着型特定施設入居者生活介護要介護３, 地域密着型特定施設入居者生活介護要介護４,
                地域密着型特定施設入居者生活介護要介護５, 地域密着型特定施設入居者生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_28() {

        RString 地域密着型介護老人福祉施設入所者生活介護経過的要介護 = RString.EMPTY;
        RString 地域密着型介護老人福祉施設入所者生活介護要会護１ = div.getPnlMain().getTbl3().getTextBox1093().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護２ = div.getPnlMain().getTbl3().getTextBox1094().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護３ = div.getPnlMain().getTbl3().getTextBox1095().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護４ = div.getPnlMain().getTbl3().getTextBox1096().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護５ = div.getPnlMain().getTbl3().getTextBox1097().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1098().getValue();

        return 入力チェック2(地域密着型介護老人福祉施設入所者生活介護経過的要介護,
                地域密着型介護老人福祉施設入所者生活介護要会護１, 地域密着型介護老人福祉施設入所者生活介護要介護２,
                地域密着型介護老人福祉施設入所者生活介護要介護３, 地域密着型介護老人福祉施設入所者生活介護要介護４,
                地域密着型介護老人福祉施設入所者生活介護要介護５, 地域密着型介護老人福祉施設入所者生活介護要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_29() {

        RString 複合型サービス経過的要介護 = RString.EMPTY;
        RString 複合型サービス要会護１ = div.getPnlMain().getTbl3().getTextBox1103().getValue();
        RString 複合型サービス要介護２ = div.getPnlMain().getTbl3().getTextBox1104().getValue();
        RString 複合型サービス要介護３ = div.getPnlMain().getTbl3().getTextBox1105().getValue();
        RString 複合型サービス要介護４ = div.getPnlMain().getTbl3().getTextBox1106().getValue();
        RString 複合型サービス要介護５ = div.getPnlMain().getTbl3().getTextBox1107().getValue();
        RString 複合型サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1108().getValue();

        return 入力チェック2(複合型サービス経過的要介護,
                複合型サービス要会護１, 複合型サービス要介護２, 複合型サービス要介護３,
                複合型サービス要介護４, 複合型サービス要介護５, 複合型サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_30() {

        RString 施設サービス経過的要介護 = RString.EMPTY;
        RString 施設サービス要会護１ = div.getPnlMain().getTbl3().getTextBox1114().getValue();
        RString 施設サービス要介護２ = div.getPnlMain().getTbl3().getTextBox1115().getValue();
        RString 施設サービス要介護３ = div.getPnlMain().getTbl3().getTextBox1116().getValue();
        RString 施設サービス要介護４ = div.getPnlMain().getTbl3().getTextBox1117().getValue();
        RString 施設サービス要介護５ = div.getPnlMain().getTbl3().getTextBox1118().getValue();
        RString 施設サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1119().getValue();

        return 入力チェック2(施設サービス経過的要介護, 施設サービス要会護１,
                施設サービス要介護２, 施設サービス要介護３, 施設サービス要介護４,
                施設サービス要介護５, 施設サービス要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_31() {

        RString 介護老人福祉施設_1_経過的要介護 = RString.EMPTY;
        RString 介護老人福祉施設_1_要会護１ = div.getPnlMain().getTbl3().getTextBox1125().getValue();
        RString 介護老人福祉施設_1_要介護２ = div.getPnlMain().getTbl3().getTextBox1126().getValue();
        RString 介護老人福祉施設_1_要介護３ = div.getPnlMain().getTbl3().getTextBox1127().getValue();
        RString 介護老人福祉施設_1_要介護４ = div.getPnlMain().getTbl3().getTextBox1128().getValue();
        RString 介護老人福祉施設_1_要介護５ = div.getPnlMain().getTbl3().getTextBox1129().getValue();
        RString 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1130().getValue();

        return 入力チェック2(介護老人福祉施設_1_経過的要介護, 介護老人福祉施設_1_要会護１, 介護老人福祉施設_1_要介護２,
                介護老人福祉施設_1_要介護３, 介護老人福祉施設_1_要介護４,
                介護老人福祉施設_1_要介護５, 介護老人福祉施設_1_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_32() {

        RString 介護老人保健施設_1_経過的要介護 = RString.EMPTY;
        RString 介護老人保健施設_1_要会護１ = div.getPnlMain().getTbl3().getTextBox1135().getValue();
        RString 介護老人保健施設_1_要介護２ = div.getPnlMain().getTbl3().getTextBox1136().getValue();
        RString 介護老人保健施設_1_要介護３ = div.getPnlMain().getTbl3().getTextBox1137().getValue();
        RString 介護老人保健施設_1_要介護４ = div.getPnlMain().getTbl3().getTextBox1138().getValue();
        RString 介護老人保健施設_1_要介護５ = div.getPnlMain().getTbl3().getTextBox1139().getValue();
        RString 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1140().getValue();

        return 入力チェック2(介護老人保健施設_1_経過的要介護, 介護老人保健施設_1_要会護１,
                介護老人保健施設_1_要介護２, 介護老人保健施設_1_要介護３,
                介護老人保健施設_1_要介護４, 介護老人保健施設_1_要介護５, 介護老人保健施設_1_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_33() {

        RString 介護療養型医療施設_1_経過的要介護 = RString.EMPTY;
        RString 介護療養型医療施設_1_要会護１ = div.getPnlMain().getTbl3().getTextBox1145().getValue();
        RString 介護療養型医療施設_1_要介護２ = div.getPnlMain().getTbl3().getTextBox1146().getValue();
        RString 介護療養型医療施設_1_要介護３ = div.getPnlMain().getTbl3().getTextBox1147().getValue();
        RString 介護療養型医療施設_1_要介護４ = div.getPnlMain().getTbl3().getTextBox1148().getValue();
        RString 介護療養型医療施設_1_要介護５ = div.getPnlMain().getTbl3().getTextBox1149().getValue();
        RString 介護療養型医療施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1150().getValue();

        return 入力チェック2(介護療養型医療施設_1_経過的要介護, 介護療養型医療施設_1_要会護１,
                介護療養型医療施設_1_要介護２, 介護療養型医療施設_1_要介護３,
                介護療養型医療施設_1_要介護４, 介護療養型医療施設_1_要介護５, 介護療養型医療施設_1_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_34() {

        RString 食事提供費用再掲経過的要介護 = RString.EMPTY;
        RString 食事提供費用再掲要会護１ = div.getPnlMain().getTbl3().getTextBox1156().getValue();
        RString 食事提供費用再掲要介護２ = div.getPnlMain().getTbl3().getTextBox1157().getValue();
        RString 食事提供費用再掲要介護３ = div.getPnlMain().getTbl3().getTextBox1158().getValue();
        RString 食事提供費用再掲要介護４ = div.getPnlMain().getTbl3().getTextBox1159().getValue();
        RString 食事提供費用再掲要介護５ = div.getPnlMain().getTbl3().getTextBox1160().getValue();
        RString 食事提供費用再掲要介護計 = div.getPnlMain().getTbl3().getTextBox1161().getValue();

        return 入力チェック2(食事提供費用再掲経過的要介護, 食事提供費用再掲要会護１,
                食事提供費用再掲要介護２, 食事提供費用再掲要介護３,
                食事提供費用再掲要介護４, 食事提供費用再掲要介護５, 食事提供費用再掲要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_35() {

        RString 介護老人福祉施設_2_経過的要介護 = RString.EMPTY;
        RString 介護老人福祉施設_2_要会護１ = div.getPnlMain().getTbl3().getTextBox1167().getValue();
        RString 介護老人福祉施設_2_要介護２ = div.getPnlMain().getTbl3().getTextBox1168().getValue();
        RString 介護老人福祉施設_2_要介護３ = div.getPnlMain().getTbl3().getTextBox1169().getValue();
        RString 介護老人福祉施設_2_要介護４ = div.getPnlMain().getTbl3().getTextBox1170().getValue();
        RString 介護老人福祉施設_2_要介護５ = div.getPnlMain().getTbl3().getTextBox1171().getValue();
        RString 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1172().getValue();

        return 入力チェック2(介護老人福祉施設_2_経過的要介護, 介護老人福祉施設_2_要会護１,
                介護老人福祉施設_2_要介護２, 介護老人福祉施設_2_要介護３,
                介護老人福祉施設_2_要介護４, 介護老人福祉施設_2_要介護５, 介護老人福祉施設_2_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_36() {

        RString 介護老人保健施設_2_経過的要介護 = RString.EMPTY;
        RString 介護老人保健施設_2_要会護１ = div.getPnlMain().getTbl3().getTextBox1177().getValue();
        RString 介護老人保健施設_2_要介護２ = div.getPnlMain().getTbl3().getTextBox1178().getValue();
        RString 介護老人保健施設_2_要介護３ = div.getPnlMain().getTbl3().getTextBox1179().getValue();
        RString 介護老人保健施設_2_要介護４ = div.getPnlMain().getTbl3().getTextBox1180().getValue();
        RString 介護老人保健施設_2_要介護５ = div.getPnlMain().getTbl3().getTextBox1181().getValue();
        RString 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1182().getValue();

        return 入力チェック2(介護老人保健施設_2_経過的要介護, 介護老人保健施設_2_要会護１,
                介護老人保健施設_2_要介護２, 介護老人保健施設_2_要介護３,
                介護老人保健施設_2_要介護４, 介護老人保健施設_2_要介護５, 介護老人保健施設_2_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_37() {

        RString 介護療養型医療施設_2_経過的要介護 = RString.EMPTY;
        RString 介護療養型医療施設_2_要会護１ = div.getPnlMain().getTbl3().getTextBox1187().getValue();
        RString 介護療養型医療施設_2_要介護２ = div.getPnlMain().getTbl3().getTextBox1188().getValue();
        RString 介護療養型医療施設_2_要介護３ = div.getPnlMain().getTbl3().getTextBox1189().getValue();
        RString 介護療養型医療施設_2_要介護４ = div.getPnlMain().getTbl3().getTextBox1190().getValue();
        RString 介護療養型医療施設_2_要介護５ = div.getPnlMain().getTbl3().getTextBox1191().getValue();
        RString 介護療養型医療施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1192().getValue();

        return 入力チェック2(介護療養型医療施設_2_経過的要介護,
                介護療養型医療施設_2_要会護１, 介護療養型医療施設_2_要介護２, 介護療養型医療施設_2_要介護３,
                介護療養型医療施設_2_要介護４, 介護療養型医療施設_2_要介護５, 介護療養型医療施設_2_要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1_38() {

        RString 総計経過的要介護 = div.getPnlMain().getTbl3().getTextBox1199().getValue();
        RString 総計要会護１ = div.getPnlMain().getTbl3().getTextBox1200().getValue();
        RString 総計要介護２ = div.getPnlMain().getTbl3().getTextBox1201().getValue();
        RString 総計要介護３ = div.getPnlMain().getTbl3().getTextBox1202().getValue();
        RString 総計要介護４ = div.getPnlMain().getTbl3().getTextBox1203().getValue();
        RString 総計要介護５ = div.getPnlMain().getTbl3().getTextBox1204().getValue();
        RString 総計要介護計 = div.getPnlMain().getTbl3().getTextBox1205().getValue();

        return 入力チェック2(総計経過的要介護, 総計要会護１,
                総計要介護２, 総計要介護３, 総計要介護４, 総計要介護５, 総計要介護計);
    }

    private boolean is整合性チェック_費用額_NG_1() {

        RString 居宅介護予防サービス要支援１ = div.getPnlMain().getTbl3().getTextBox586().getValue();
        RString 居宅介護予防サービス要支援２ = div.getPnlMain().getTbl3().getTextBox587().getValue();
        RString 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox588().getValue();

        return 入力チェック1(居宅介護予防サービス要支援１, 居宅介護予防サービス要支援２, 居宅介護予防サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_2() {

        RString 訪問サービス要支援１ = div.getPnlMain().getTbl3().getTextBox597().getValue();
        RString 訪問サービス要支援２ = div.getPnlMain().getTbl3().getTextBox598().getValue();
        RString 訪問サービス要支援計 = div.getPnlMain().getTbl3().getTextBox599().getValue();

        return 入力チェック1(訪問サービス要支援１, 訪問サービス要支援２, 訪問サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_3() {

        RString 訪問介護要支援１ = div.getPnlMain().getTbl3().getTextBox819().getValue();
        RString 訪問介護要支援２ = div.getPnlMain().getTbl3().getTextBox820().getValue();
        RString 訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox821().getValue();

        return 入力チェック1(訪問介護要支援１, 訪問介護要支援２, 訪問介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_4() {

        RString 訪問入浴介護要支援１ = div.getPnlMain().getTbl3().getTextBox830().getValue();
        RString 訪問入浴介護要支援２ = div.getPnlMain().getTbl3().getTextBox831().getValue();
        RString 訪問入浴介護要支援計 = div.getPnlMain().getTbl3().getTextBox832().getValue();

        return 入力チェック1(訪問入浴介護要支援１, 訪問入浴介護要支援２, 訪問入浴介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_5() {

        RString 訪問看護要支援１ = div.getPnlMain().getTbl3().getTextBox841().getValue();
        RString 訪問看護要支援２ = div.getPnlMain().getTbl3().getTextBox842().getValue();
        RString 訪問看護要支援計 = div.getPnlMain().getTbl3().getTextBox843().getValue();

        return 入力チェック1(訪問看護要支援１, 訪問看護要支援２, 訪問看護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_6() {

        RString 訪問リハビリテーション要支援１ = div.getPnlMain().getTbl3().getTextBox852().getValue();
        RString 訪問リハビリテーション要支援２ = div.getPnlMain().getTbl3().getTextBox853().getValue();
        RString 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox854().getValue();

        return 入力チェック1(訪問リハビリテーション要支援１, 訪問リハビリテーション要支援２, 訪問リハビリテーション要支援計);
    }

    private boolean is整合性チェック_費用額_NG_7() {

        RString 居宅療養管理指導要支援１ = div.getPnlMain().getTbl3().getTextBox863().getValue();
        RString 居宅療養管理指導要支援２ = div.getPnlMain().getTbl3().getTextBox864().getValue();
        RString 居宅療養管理指導要支援計 = div.getPnlMain().getTbl3().getTextBox865().getValue();

        return 入力チェック1(居宅療養管理指導要支援１, 居宅療養管理指導要支援２, 居宅療養管理指導要支援計);
    }

    private boolean is整合性チェック_費用額_NG_8() {

        RString 通所サービス要支援１ = div.getPnlMain().getTbl3().getTextBox874().getValue();
        RString 通所サービス要支援２ = div.getPnlMain().getTbl3().getTextBox875().getValue();
        RString 通所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox876().getValue();

        return 入力チェック1(通所サービス要支援１, 通所サービス要支援２, 通所サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_9() {

        RString 通所介護要支援１ = div.getPnlMain().getTbl3().getTextBox885().getValue();
        RString 通所介護要支援２ = div.getPnlMain().getTbl3().getTextBox886().getValue();
        RString 通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox887().getValue();

        return 入力チェック1(通所介護要支援１, 通所介護要支援２, 通所介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_10() {

        RString 通所リハビリテーション要支援１ = div.getPnlMain().getTbl3().getTextBox896().getValue();
        RString 通所リハビリテーション要支援２ = div.getPnlMain().getTbl3().getTextBox897().getValue();
        RString 通所リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox898().getValue();

        return 入力チェック1(通所リハビリテーション要支援１, 通所リハビリテーション要支援２, 通所リハビリテーション要支援計);
    }

    private boolean is整合性チェック_費用額_NG_11() {

        RString 短期入所サービス要支援１ = div.getPnlMain().getTbl3().getTextBox907().getValue();
        RString 短期入所サービス要支援２ = div.getPnlMain().getTbl3().getTextBox908().getValue();
        RString 短期入所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox909().getValue();

        return 入力チェック1(短期入所サービス要支援１, 短期入所サービス要支援２, 短期入所サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_12() {

        RString 短期入所生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox918().getValue();
        RString 短期入所生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox919().getValue();
        RString 短期入所生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox920().getValue();

        return 入力チェック1(短期入所生活介護要支援１, 短期入所生活介護要支援２, 短期入所生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_13() {

        RString 短期入所療養介護介護老人保健施設要支援１ = div.getPnlMain().getTbl3().getTextBox929().getValue();
        RString 短期入所療養介護介護老人保健施設要支援２ = div.getPnlMain().getTbl3().getTextBox930().getValue();
        RString 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl3().getTextBox931().getValue();

        return 入力チェック1(短期入所療養介護介護老人保健施設要支援１,
                短期入所療養介護介護老人保健施設要支援２, 短期入所療養介護介護老人保健施設要支援計);
    }

    private boolean is整合性チェック_費用額_NG_14() {

        RString 短期入所療養介護介護療養型医療施設等要支援１ = div.getPnlMain().getTbl3().getTextBox940().getValue();
        RString 短期入所療養介護介護療養型医療施設等要支援２ = div.getPnlMain().getTbl3().getTextBox941().getValue();
        RString 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl3().getTextBox942().getValue();

        return 入力チェック1(短期入所療養介護介護療養型医療施設等要支援１, 短期入所療養介護介護療養型医療施設等要支援２,
                短期入所療養介護介護療養型医療施設等要支援計);
    }

    private boolean is整合性チェック_費用額_NG_15() {

        RString 福祉用具住宅改修サービス要支援１ = div.getPnlMain().getTbl3().getTextBox951().getValue();
        RString 福祉用具住宅改修サービス要支援２ = div.getPnlMain().getTbl3().getTextBox952().getValue();
        RString 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl3().getTextBox953().getValue();

        return 入力チェック1(福祉用具住宅改修サービス要支援１,
                福祉用具住宅改修サービス要支援２, 福祉用具住宅改修サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_16() {

        RString 福祉用具貸与要支援１ = div.getPnlMain().getTbl3().getTextBox962().getValue();
        RString 福祉用具貸与要支援２ = div.getPnlMain().getTbl3().getTextBox963().getValue();
        RString 福祉用具貸与要支援計 = div.getPnlMain().getTbl3().getTextBox964().getValue();

        return 入力チェック1(福祉用具貸与要支援１, 福祉用具貸与要支援２, 福祉用具貸与要支援計);
    }

    private boolean is整合性チェック_費用額_NG_17() {

        RString 福祉用具購入費要支援１ = div.getPnlMain().getTbl3().getTextBox973().getValue();
        RString 福祉用具購入費要支援２ = div.getPnlMain().getTbl3().getTextBox974().getValue();
        RString 福祉用具購入費要支援計 = div.getPnlMain().getTbl3().getTextBox975().getValue();

        return 入力チェック1(福祉用具購入費要支援１, 福祉用具購入費要支援２, 福祉用具購入費要支援計);
    }

    private boolean is整合性チェック_費用額_NG_18() {

        RString 住宅改修費要支援１ = div.getPnlMain().getTbl3().getTextBox984().getValue();
        RString 住宅改修費要支援２ = div.getPnlMain().getTbl3().getTextBox985().getValue();
        RString 住宅改修費要支援計 = div.getPnlMain().getTbl3().getTextBox986().getValue();

        return 入力チェック1(住宅改修費要支援１, 住宅改修費要支援２, 住宅改修費要支援計);
    }

    private boolean is整合性チェック_費用額_NG_19() {

        RString 特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox995().getValue();
        RString 特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox996().getValue();
        RString 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox997().getValue();

        return 入力チェック1(特定施設入居者生活介護要支援１,
                特定施設入居者生活介護要支援２, 特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_20() {

        RString 介護予防支援居宅介護支援要支援１ = div.getPnlMain().getTbl3().getTextBox1006().getValue();
        RString 介護予防支援居宅介護支援要支援２ = div.getPnlMain().getTbl3().getTextBox1007().getValue();
        RString 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl3().getTextBox1008().getValue();

        return 入力チェック1(介護予防支援居宅介護支援要支援１,
                介護予防支援居宅介護支援要支援２, 介護予防支援居宅介護支援要支援計);
    }

    private boolean is整合性チェック_費用額_NG_21() {

        RString 地域密着型介護予防サービス要支援１ = div.getPnlMain().getTbl3().getTextBox1017().getValue();
        RString 地域密着型介護予防サービス要支援２ = div.getPnlMain().getTbl3().getTextBox1018().getValue();
        RString 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1019().getValue();

        return 入力チェック1(地域密着型介護予防サービス要支援１,
                地域密着型介護予防サービス要支援２, 地域密着型介護予防サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_22() {

        RString 定期巡回随時対応型訪問介護看護要支援１ = div.getPnlMain().getTbl3().getTextBox1028().getValue();
        RString 定期巡回随時対応型訪問介護看護要支援２ = div.getPnlMain().getTbl3().getTextBox1029().getValue();
        RString 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl3().getTextBox1030().getValue();

        return 入力チェック1(定期巡回随時対応型訪問介護看護要支援１,
                定期巡回随時対応型訪問介護看護要支援２, 定期巡回随時対応型訪問介護看護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_23() {

        RString 夜間対応型訪問介護要支援１ = div.getPnlMain().getTbl3().getTextBox1038().getValue();
        RString 夜間対応型訪問介護要支援２ = div.getPnlMain().getTbl3().getTextBox1039().getValue();
        RString 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox1040().getValue();

        return 入力チェック1(夜間対応型訪問介護要支援１, 夜間対応型訪問介護要支援２, 夜間対応型訪問介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_24() {

        RString 認知症対応型通所介護要支援１ = div.getPnlMain().getTbl3().getTextBox1048().getValue();
        RString 認知症対応型通所介護要支援２ = div.getPnlMain().getTbl3().getTextBox1049().getValue();
        RString 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox1050().getValue();

        return 入力チェック1(認知症対応型通所介護要支援１, 認知症対応型通所介護要支援２, 認知症対応型通所介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_25() {

        RString 小規模多機能型居宅介護要支援１ = div.getPnlMain().getTbl3().getTextBox1059().getValue();
        RString 小規模多機能型居宅介護要支援２ = div.getPnlMain().getTbl3().getTextBox1060().getValue();
        RString 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl3().getTextBox1061().getValue();

        return 入力チェック1(小規模多機能型居宅介護要支援１, 小規模多機能型居宅介護要支援２, 小規模多機能型居宅介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_26() {

        RString 認知症対応型共同生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox1070().getValue();
        RString 認知症対応型共同生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox1071().getValue();
        RString 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1072().getValue();

        return 入力チェック1(認知症対応型共同生活介護要支援１,
                認知症対応型共同生活介護要支援２, 認知症対応型共同生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_27() {

        RString 地域密着型特定施設入居者生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox1080().getValue();
        RString 地域密着型特定施設入居者生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox1081().getValue();
        RString 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1082().getValue();

        return 入力チェック1(地域密着型特定施設入居者生活介護要支援１,
                地域密着型特定施設入居者生活介護要支援２, 地域密着型特定施設入居者生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_28() {

        RString 地域密着型介護老人福祉施設入所者生活介護要支援１ = div.getPnlMain().getTbl3().getTextBox1090().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要支援２ = div.getPnlMain().getTbl3().getTextBox1091().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1092().getValue();

        return 入力チェック1(地域密着型介護老人福祉施設入所者生活介護要支援１, 地域密着型介護老人福祉施設入所者生活介護要支援２,
                地域密着型介護老人福祉施設入所者生活介護要支援計);
    }

    private boolean is整合性チェック_費用額_NG_29() {

        RString 複合型サービス要支援１ = div.getPnlMain().getTbl3().getTextBox1100().getValue();
        RString 複合型サービス要支援２ = div.getPnlMain().getTbl3().getTextBox1101().getValue();
        RString 複合型サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1102().getValue();

        return 入力チェック1(複合型サービス要支援１, 複合型サービス要支援２, 複合型サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_30() {

        RString 施設サービス要支援１ = div.getPnlMain().getTbl3().getTextBox1110().getValue();
        RString 施設サービス要支援２ = div.getPnlMain().getTbl3().getTextBox1111().getValue();
        RString 施設サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1112().getValue();

        return 入力チェック1(施設サービス要支援１, 施設サービス要支援２, 施設サービス要支援計);
    }

    private boolean is整合性チェック_費用額_NG_31() {

        RString 介護老人福祉施設_1_要支援１ = div.getPnlMain().getTbl3().getTextBox1121().getValue();
        RString 介護老人福祉施設_1_要支援２ = div.getPnlMain().getTbl3().getTextBox1122().getValue();
        RString 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1123().getValue();

        return 入力チェック1(介護老人福祉施設_1_要支援１, 介護老人福祉施設_1_要支援２, 介護老人福祉施設_1_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_32() {

        RString 介護老人保健施設_1_要支援１ = div.getPnlMain().getTbl3().getTextBox1132().getValue();
        RString 介護老人保健施設_1_要支援２ = div.getPnlMain().getTbl3().getTextBox1133().getValue();
        RString 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1134().getValue();

        return 入力チェック1(介護老人保健施設_1_要支援１, 介護老人保健施設_1_要支援２, 介護老人保健施設_1_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_33() {

        RString 介護療養型医療施設要支援１ = div.getPnlMain().getTbl3().getTextBox1142().getValue();
        RString 介護療養型医療施設要支援２ = div.getPnlMain().getTbl3().getTextBox1143().getValue();
        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1144().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_費用額_NG_34() {

        RString 食事提供費用再掲要支援１ = div.getPnlMain().getTbl3().getTextBox1152().getValue();
        RString 食事提供費用再掲要支援２ = div.getPnlMain().getTbl3().getTextBox1153().getValue();
        RString 食事提供費用再掲要支援計 = div.getPnlMain().getTbl3().getTextBox1154().getValue();

        return 入力チェック1(食事提供費用再掲要支援１, 食事提供費用再掲要支援２, 食事提供費用再掲要支援計);
    }

    private boolean is整合性チェック_費用額_NG_35() {

        RString 介護老人福祉施設_2_要支援１ = div.getPnlMain().getTbl3().getTextBox1163().getValue();
        RString 介護老人福祉施設_2_要支援２ = div.getPnlMain().getTbl3().getTextBox1164().getValue();
        RString 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1165().getValue();

        return 入力チェック1(介護老人福祉施設_2_要支援１, 介護老人福祉施設_2_要支援２, 介護老人福祉施設_2_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_36() {

        RString 介護老人保健施設_2_要支援１ = div.getPnlMain().getTbl3().getTextBox1174().getValue();
        RString 介護老人保健施設_2_要支援２ = div.getPnlMain().getTbl3().getTextBox1175().getValue();
        RString 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1176().getValue();

        return 入力チェック1(介護老人保健施設_2_要支援１, 介護老人保健施設_2_要支援２, 介護老人保健施設_2_要支援計);
    }

    private boolean is整合性チェック_費用額_NG_37() {

        RString 介護療養型医療施設要支援１ = div.getPnlMain().getTbl3().getTextBox1184().getValue();
        RString 介護療養型医療施設要支援２ = div.getPnlMain().getTbl3().getTextBox1185().getValue();
        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1186().getValue();

        return 入力チェック1(介護療養型医療施設要支援１, 介護療養型医療施設要支援２, 介護療養型医療施設要支援計);
    }

    private boolean is整合性チェック_費用額_NG_38() {

        RString 総計要支援１ = div.getPnlMain().getTbl3().getTextBox1194().getValue();
        RString 総計要支援２ = div.getPnlMain().getTbl3().getTextBox1195().getValue();
        RString 総計要支援計 = div.getPnlMain().getTbl3().getTextBox1196().getValue();

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

        RString 居宅介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox588().getValue();
        RString 居宅介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox595().getValue();
        RString 居宅介護予防サービス合計 = div.getPnlMain().getTbl3().getTextBox596().getValue();

        return 入力チェック3(居宅介護予防サービス要支援計, 居宅介護予防サービス要介護計, 居宅介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_2() {

        RString 訪問サービス要支援計 = div.getPnlMain().getTbl3().getTextBox599().getValue();
        RString 訪問サービス要介護計 = div.getPnlMain().getTbl3().getTextBox606().getValue();
        RString 訪問サービス合計 = div.getPnlMain().getTbl3().getTextBox607().getValue();

        return 入力チェック3(訪問サービス要支援計, 訪問サービス要介護計, 訪問サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_3() {

        RString 訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox821().getValue();
        RString 訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox828().getValue();
        RString 訪問介護合計 = div.getPnlMain().getTbl3().getTextBox829().getValue();

        return 入力チェック3(訪問介護要支援計, 訪問介護要介護計, 訪問介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_4() {

        RString 訪問入浴介護要支援計 = div.getPnlMain().getTbl3().getTextBox832().getValue();
        RString 訪問入浴介護要介護計 = div.getPnlMain().getTbl3().getTextBox839().getValue();
        RString 訪問入浴介護合計 = div.getPnlMain().getTbl3().getTextBox840().getValue();

        return 入力チェック3(訪問入浴介護要支援計, 訪問入浴介護要介護計, 訪問入浴介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_5() {

        RString 訪問看護要支援計 = div.getPnlMain().getTbl3().getTextBox843().getValue();
        RString 訪問看護要介護計 = div.getPnlMain().getTbl3().getTextBox850().getValue();
        RString 訪問看護要合計 = div.getPnlMain().getTbl3().getTextBox851().getValue();

        return 入力チェック3(訪問看護要支援計, 訪問看護要介護計, 訪問看護要合計);
    }

    private boolean is整合性チェック_NG_費用額_3_6() {

        RString 訪問リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox854().getValue();
        RString 訪問リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox861().getValue();
        RString 訪問リハビリテーション合計 = div.getPnlMain().getTbl3().getTextBox862().getValue();

        return 入力チェック3(訪問リハビリテーション要支援計, 訪問リハビリテーション要介護計, 訪問リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_費用額_3_7() {

        RString 居宅療養管理指導要支援計 = div.getPnlMain().getTbl3().getTextBox865().getValue();
        RString 居宅療養管理指導要介護計 = div.getPnlMain().getTbl3().getTextBox872().getValue();
        RString 居宅療養管理指導合計 = div.getPnlMain().getTbl3().getTextBox873().getValue();

        return 入力チェック3(居宅療養管理指導要支援計, 居宅療養管理指導要介護計, 居宅療養管理指導合計);
    }

    private boolean is整合性チェック_NG_費用額_3_8() {

        RString 通所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox876().getValue();
        RString 通所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox883().getValue();
        RString 通所サービス要合計 = div.getPnlMain().getTbl3().getTextBox884().getValue();

        return 入力チェック3(通所サービス要支援計, 通所サービス要介護計, 通所サービス要合計);
    }

    private boolean is整合性チェック_NG_費用額_3_9() {

        RString 通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox887().getValue();
        RString 通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox894().getValue();
        RString 通所介護合計 = div.getPnlMain().getTbl3().getTextBox895().getValue();

        return 入力チェック3(通所介護要支援計, 通所介護要介護計, 通所介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_10() {

        RString 通所リハビリテーション要支援計 = div.getPnlMain().getTbl3().getTextBox898().getValue();
        RString 通所リハビリテーション要介護計 = div.getPnlMain().getTbl3().getTextBox905().getValue();
        RString 通所リハビリテーション合計 = div.getPnlMain().getTbl3().getTextBox906().getValue();

        return 入力チェック3(通所リハビリテーション要支援計, 通所リハビリテーション要介護計, 通所リハビリテーション合計);
    }

    private boolean is整合性チェック_NG_費用額_3_11() {

        RString 短期入所サービス要支援計 = div.getPnlMain().getTbl3().getTextBox909().getValue();
        RString 短期入所サービス要介護計 = div.getPnlMain().getTbl3().getTextBox916().getValue();
        RString 短期入所サービス合計 = div.getPnlMain().getTbl3().getTextBox917().getValue();

        return 入力チェック3(短期入所サービス要支援計, 短期入所サービス要介護計, 短期入所サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_12() {

        RString 短期入所生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox920().getValue();
        RString 短期入所生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox927().getValue();
        RString 短期入所生活介護合計 = div.getPnlMain().getTbl3().getTextBox928().getValue();

        return 入力チェック3(短期入所生活介護要支援計, 短期入所生活介護要介護計, 短期入所生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_13() {

        RString 短期入所療養介護介護老人保健施設要支援計 = div.getPnlMain().getTbl3().getTextBox931().getValue();
        RString 短期入所療養介護介護老人保健施設要介護計 = div.getPnlMain().getTbl3().getTextBox938().getValue();
        RString 短期入所療養介護介護老人保健施設合計 = div.getPnlMain().getTbl3().getTextBox939().getValue();

        return 入力チェック3(短期入所療養介護介護老人保健施設要支援計,
                短期入所療養介護介護老人保健施設要介護計, 短期入所療養介護介護老人保健施設合計);
    }

    private boolean is整合性チェック_NG_費用額_3_14() {

        RString 短期入所療養介護介護療養型医療施設等要支援計 = div.getPnlMain().getTbl3().getTextBox942().getValue();
        RString 短期入所療養介護介護療養型医療施設等要介護計 = div.getPnlMain().getTbl3().getTextBox949().getValue();
        RString 短期入所療養介護介護療養型医療施設等合計 = div.getPnlMain().getTbl3().getTextBox950().getValue();

        return 入力チェック3(短期入所療養介護介護療養型医療施設等要支援計, 短期入所療養介護介護療養型医療施設等要介護計,
                短期入所療養介護介護療養型医療施設等合計);
    }

    private boolean is整合性チェック_NG_費用額_3_15() {

        RString 福祉用具住宅改修サービス要支援計 = div.getPnlMain().getTbl3().getTextBox953().getValue();
        RString 福祉用具住宅改修サービス要介護計 = div.getPnlMain().getTbl3().getTextBox960().getValue();
        RString 福祉用具住宅改修サービス合計 = div.getPnlMain().getTbl3().getTextBox961().getValue();

        return 入力チェック3(福祉用具住宅改修サービス要支援計, 福祉用具住宅改修サービス要介護計, 福祉用具住宅改修サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_16() {

        RString 福祉用具貸与要支援計 = div.getPnlMain().getTbl3().getTextBox964().getValue();
        RString 福祉用具貸与要介護計 = div.getPnlMain().getTbl3().getTextBox971().getValue();
        RString 福祉用具貸与合計 = div.getPnlMain().getTbl3().getTextBox972().getValue();

        return 入力チェック3(福祉用具貸与要支援計, 福祉用具貸与要介護計, 福祉用具貸与合計);
    }

    private boolean is整合性チェック_NG_費用額_3_17() {

        RString 福祉用具購入費要支援計 = div.getPnlMain().getTbl3().getTextBox975().getValue();
        RString 福祉用具購入費要介護計 = div.getPnlMain().getTbl3().getTextBox982().getValue();
        RString 福祉用具購入費合計 = div.getPnlMain().getTbl3().getTextBox983().getValue();

        return 入力チェック3(福祉用具購入費要支援計, 福祉用具購入費要介護計, 福祉用具購入費合計);
    }

    private boolean is整合性チェック_NG_費用額_3_18() {

        RString 住宅改修費要支援計 = div.getPnlMain().getTbl3().getTextBox986().getValue();
        RString 住宅改修費要介護計 = div.getPnlMain().getTbl3().getTextBox993().getValue();
        RString 住宅改修費合計 = div.getPnlMain().getTbl3().getTextBox994().getValue();

        return 入力チェック3(住宅改修費要支援計, 住宅改修費要介護計, 住宅改修費合計);
    }

    private boolean is整合性チェック_NG_費用額_3_19() {

        RString 特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox997().getValue();
        RString 特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1004().getValue();
        RString 特定施設入居者生活介護合計 = div.getPnlMain().getTbl3().getTextBox1005().getValue();

        return 入力チェック3(特定施設入居者生活介護要支援計, 特定施設入居者生活介護要介護計, 特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_20() {

        RString 介護予防支援居宅介護支援要支援計 = div.getPnlMain().getTbl3().getTextBox1008().getValue();
        RString 介護予防支援居宅介護支援要介護計 = div.getPnlMain().getTbl3().getTextBox1015().getValue();
        RString 介護予防支援居宅介護支援合計 = div.getPnlMain().getTbl3().getTextBox1016().getValue();

        return 入力チェック3(介護予防支援居宅介護支援要支援計, 介護予防支援居宅介護支援要介護計, 介護予防支援居宅介護支援合計);
    }

    private boolean is整合性チェック_NG_費用額_3_21() {

        RString 地域密着型介護予防サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1019().getValue();
        RString 地域密着型介護予防サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1026().getValue();
        RString 地域密着型介護予防サービス合計 = div.getPnlMain().getTbl3().getTextBox1027().getValue();

        return 入力チェック3(地域密着型介護予防サービス要支援計,
                地域密着型介護予防サービス要介護計, 地域密着型介護予防サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_22() {

        RString 定期巡回随時対応型訪問介護看護要支援計 = div.getPnlMain().getTbl3().getTextBox1030().getValue();
        RString 定期巡回随時対応型訪問介護看護要介護計 = div.getPnlMain().getTbl3().getTextBox1036().getValue();
        RString 定期巡回随時対応型訪問介護看護合計 = div.getPnlMain().getTbl3().getTextBox1037().getValue();

        return 入力チェック3(定期巡回随時対応型訪問介護看護要支援計,
                定期巡回随時対応型訪問介護看護要介護計, 定期巡回随時対応型訪問介護看護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_23() {

        RString 夜間対応型訪問介護要支援計 = div.getPnlMain().getTbl3().getTextBox1040().getValue();
        RString 夜間対応型訪問介護要介護計 = div.getPnlMain().getTbl3().getTextBox1046().getValue();
        RString 夜間対応型訪問介護合計 = div.getPnlMain().getTbl3().getTextBox1047().getValue();

        return 入力チェック3(夜間対応型訪問介護要支援計, 夜間対応型訪問介護要介護計, 夜間対応型訪問介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_24() {

        RString 認知症対応型通所介護要支援計 = div.getPnlMain().getTbl3().getTextBox1050().getValue();
        RString 認知症対応型通所介護要介護計 = div.getPnlMain().getTbl3().getTextBox1057().getValue();
        RString 認知症対応型通所介護合計 = div.getPnlMain().getTbl3().getTextBox1058().getValue();

        return 入力チェック3(認知症対応型通所介護要支援計, 認知症対応型通所介護要介護計, 認知症対応型通所介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_25() {

        RString 小規模多機能型居宅介護要支援計 = div.getPnlMain().getTbl3().getTextBox1061().getValue();
        RString 小規模多機能型居宅介護要介護計 = div.getPnlMain().getTbl3().getTextBox1068().getValue();
        RString 小規模多機能型居宅介護合計 = div.getPnlMain().getTbl3().getTextBox1069().getValue();

        return 入力チェック3(小規模多機能型居宅介護要支援計, 小規模多機能型居宅介護要介護計, 小規模多機能型居宅介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_26() {

        RString 認知症対応型共同生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1072().getValue();
        RString 認知症対応型共同生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1078().getValue();
        RString 認知症対応型共同生活介護合計 = div.getPnlMain().getTbl3().getTextBox1079().getValue();

        return 入力チェック3(認知症対応型共同生活介護要支援計, 認知症対応型共同生活介護要介護計, 認知症対応型共同生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_27() {

        RString 地域密着型特定施設入居者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1082().getValue();
        RString 地域密着型特定施設入居者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1088().getValue();
        RString 地域密着型特定施設入居者生活介護合計 = div.getPnlMain().getTbl3().getTextBox1089().getValue();

        return 入力チェック3(地域密着型特定施設入居者生活介護要支援計,
                地域密着型特定施設入居者生活介護要介護計, 地域密着型特定施設入居者生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_28() {

        RString 地域密着型介護老人福祉施設入所者生活介護要支援計 = div.getPnlMain().getTbl3().getTextBox1092().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護要介護計 = div.getPnlMain().getTbl3().getTextBox1098().getValue();
        RString 地域密着型介護老人福祉施設入所者生活介護合計 = div.getPnlMain().getTbl3().getTextBox1099().getValue();

        return 入力チェック3(地域密着型介護老人福祉施設入所者生活介護要支援計, 地域密着型介護老人福祉施設入所者生活介護要介護計,
                地域密着型介護老人福祉施設入所者生活介護合計);
    }

    private boolean is整合性チェック_NG_費用額_3_29() {

        RString 複合型サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1102().getValue();
        RString 複合型サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1108().getValue();
        RString 複合型サービス合計 = div.getPnlMain().getTbl3().getTextBox1109().getValue();

        return 入力チェック3(複合型サービス要支援計, 複合型サービス要介護計, 複合型サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_30() {

        RString 施設サービス要支援計 = div.getPnlMain().getTbl3().getTextBox1112().getValue();
        RString 施設サービス要介護計 = div.getPnlMain().getTbl3().getTextBox1119().getValue();
        RString 施設サービス合計 = div.getPnlMain().getTbl3().getTextBox1120().getValue();

        return 入力チェック3(施設サービス要支援計, 施設サービス要介護計, 施設サービス合計);
    }

    private boolean is整合性チェック_NG_費用額_3_31() {

        RString 介護老人福祉施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1123().getValue();
        RString 介護老人福祉施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1130().getValue();
        RString 介護老人福祉施設_1_合計 = div.getPnlMain().getTbl3().getTextBox1131().getValue();

        return 入力チェック3(介護老人福祉施設_1_要支援計, 介護老人福祉施設_1_要介護計, 介護老人福祉施設_1_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_32() {

        RString 介護老人保健施設_1_要支援計 = div.getPnlMain().getTbl3().getTextBox1134().getValue();
        RString 介護老人保健施設_1_要介護計 = div.getPnlMain().getTbl3().getTextBox1140().getValue();
        RString 介護老人保健施設_1_合計 = div.getPnlMain().getTbl3().getTextBox1141().getValue();

        return 入力チェック3(介護老人保健施設_1_要支援計, 介護老人保健施設_1_要介護計, 介護老人保健施設_1_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_33() {

        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1144().getValue();
        RString 介護療養型医療施設要介護計 = div.getPnlMain().getTbl3().getTextBox1150().getValue();
        RString 介護療養型医療施設合計 = div.getPnlMain().getTbl3().getTextBox1151().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_費用額_3_34() {

        RString 食事提供費用再掲要支援計 = div.getPnlMain().getTbl3().getTextBox1154().getValue();
        RString 食事提供費用再掲要介護計 = div.getPnlMain().getTbl3().getTextBox1161().getValue();
        RString 食事提供費用再掲合計 = div.getPnlMain().getTbl3().getTextBox1162().getValue();

        return 入力チェック3(食事提供費用再掲要支援計, 食事提供費用再掲要介護計, 食事提供費用再掲合計);
    }

    private boolean is整合性チェック_NG_費用額_3_35() {

        RString 介護老人福祉施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1165().getValue();
        RString 介護老人福祉施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1172().getValue();
        RString 介護老人福祉施設_2_合計 = div.getPnlMain().getTbl3().getTextBox1173().getValue();

        return 入力チェック3(介護老人福祉施設_2_要支援計, 介護老人福祉施設_2_要介護計, 介護老人福祉施設_2_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_36() {

        RString 介護老人保健施設_2_要支援計 = div.getPnlMain().getTbl3().getTextBox1176().getValue();
        RString 介護老人保健施設_2_要介護計 = div.getPnlMain().getTbl3().getTextBox1182().getValue();
        RString 介護老人保健施設_2_合計 = div.getPnlMain().getTbl3().getTextBox1183().getValue();

        return 入力チェック3(介護老人保健施設_2_要支援計, 介護老人保健施設_2_要介護計, 介護老人保健施設_2_合計);
    }

    private boolean is整合性チェック_NG_費用額_3_37() {

        RString 介護療養型医療施設要支援計 = div.getPnlMain().getTbl3().getTextBox1186().getValue();
        RString 介護療養型医療施設要介護計 = div.getPnlMain().getTbl3().getTextBox1192().getValue();
        RString 介護療養型医療施設合計 = div.getPnlMain().getTbl3().getTextBox1193().getValue();

        return 入力チェック3(介護療養型医療施設要支援計, 介護療養型医療施設要介護計, 介護療養型医療施設合計);
    }

    private boolean is整合性チェック_NG_費用額_3_38() {

        RString 総計要支援計 = div.getPnlMain().getTbl3().getTextBox1196().getValue();
        RString 総計要介護計 = div.getPnlMain().getTbl3().getTextBox1204().getValue();
        RString 総計合計 = div.getPnlMain().getTbl3().getTextBox1205().getValue();

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

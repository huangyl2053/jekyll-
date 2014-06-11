/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiHoshoninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiHoshoninKinmuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiServiceDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiTeishutsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseishaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinHenkoKariukeDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinHenkoKetteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKariukeHoshoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKariukeninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKetteiKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKetteiMadoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKetteiShiharaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKetteiShoninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KyufuhiKashitsukekinInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.tplKashitsukekinHenkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.tplKashitsukekinKariukeDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.tplKashitsukekinKetteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.tplKashitsukekinKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.tplKashitsukekinShinseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金詳細情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuhiKashitsukekinInfo {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("KyufuhiKashitsukekinInfo/KyufuhiKashitsukekinInfo.yml"));
    }

    private enum 支払方法 {

        窓口,
        口座;
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KyufuhiKashitsukekinInfoDiv> onLoad(KyufuhiKashitsukekinInfoDiv panel) {
        ResponseData<KyufuhiKashitsukekinInfoDiv> response = new ResponseData<>();

        setShinseiData(panel);
        setKetteiData(panel);
        setKariukeData(panel);
        setHenkoData(panel);
        setKozaData(panel);
        response.data = panel;
        return response;
    }

    private void setShinseiData(KyufuhiKashitsukekinInfoDiv panel) {
        tplKashitsukekinShinseiDiv div = panel.getTabKashitsukekinInfo().getTplKashitsukekinShinsei();

        ControlGenerator cg = new ControlGenerator(getYaml().get(0));

        div.getTxtShinseiYMD().setValue(cg.getAsRDate("申請日"));
        div.getTxtRiyoKikan().setFromValue(cg.getAsRDate("利用期間開始日"));
        div.getTxtRiyoKikan().setToValue(cg.getAsRDate("利用期間終了日"));
        div.getTxtSeikyugaku().setValue(cg.getAsDecimal("事業者の支払い請求額"));
        div.getTxtShinseiKingaku().setValue(cg.getAsDecimal("申請金額"));

        setShinseiTaishoServiceData(div);
        setShinseiShinseishaData(div);
        setShinseiHoshoninData(div);
        setShinseiKinmuData(div);
        setShinseiTeishutsuData(div);

    }

    private void setShinseiTaishoServiceData(tplKashitsukekinShinseiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));

        KashitsukeShinseiServiceDiv div = tpl.getKashitsukeShinseiService();
        div.getTxtService1().setValue(cg.getAsRString("対象サービス１"));
        div.getTxtService2().setValue(cg.getAsRString("対象サービス２"));
        div.getTxtService3().setValue(cg.getAsRString("対象サービス３"));
        div.getTxtService4().setValue(cg.getAsRString("対象サービス４"));
    }

    private void setShinseiShinseishaData(tplKashitsukekinShinseiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(2));

        KashitsukeShinseishaDiv div = tpl.getKashitsukeShinseisha();
        div.getTxtShinseishaName().setValue(cg.getAsRString("氏名"));
        div.getTxtShinseishaKana().setValue(cg.getAsRString("カナ"));
        div.getTxtShinseishaKankei().setValue(cg.getAsRString("被保険者との関係"));
        div.getTxtShinseishaYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
        div.getTxtShinseishaJusho().setValue(cg.getAsRString("住所"));
        div.getTxtShinseishaTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setShinseiHoshoninData(tplKashitsukekinShinseiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(3));

        KashitsukeShinseiHoshoninDiv div = tpl.getKashitsukeShinseiHoshonin();
        div.getTxtHoshoninName().setValue(cg.getAsRString("氏名"));
        div.getTxtHoshoninKana().setValue(cg.getAsRString("カナ"));
        div.getTxtHoshoninSeiYMD().setValue(cg.getAsRDate("生年月日"));
        div.getTxtHoshoninSeibetsu().setValue(cg.getAsRString("性別"));
        div.getTxtHoshoninKankei().setValue(cg.getAsRString("申請者との関係"));
        div.getTxtHoshoninYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
        div.getTxtHoshoninJusho().setValue(cg.getAsRString("住所"));
        div.getTxtHoshoninTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setShinseiKinmuData(tplKashitsukekinShinseiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));

        KashitsukeShinseiHoshoninKinmuDiv div = tpl.getKashitsukeShinseiHoshonin().getKashitsukeShinseiHoshoninKinmu();
        div.getTxtHoshoninKinmuName().setValue(cg.getAsRString("名称"));
        div.getTxtHoshoninKinmuJusho().setValue(cg.getAsRString("所在地"));
        div.getTxtHoshoninKinmuTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setShinseiTeishutsuData(tplKashitsukekinShinseiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(5));

        KashitsukeShinseiTeishutsuDiv div = tpl.getKashitsukeShinseiTeishutsu();
        div.getTxtSeikyuRyoshusho().setValue(cg.getAsRString("請求書領収書"));
        div.getTxtTeishutsuKanriNo().setValue(cg.getAsRString("提出物管理番号"));
    }

    private void setKetteiData(KyufuhiKashitsukekinInfoDiv panel) {
        tplKashitsukekinKetteiDiv div = panel.getTabKashitsukekinInfo().getTplKashitsukekinKettei();

        ControlGenerator cg = new ControlGenerator(getYaml().get(6));

        div.getTxtKetteiShoninKubun().setValue(cg.getAsRString("承認区分"));
        div.getTxtKetteiYMD().setValue(cg.getAsRDate("審査決定日"));
        div.getTxtKetteiFushoninRiyu().setValue(cg.getAsRString("不承認理由"));
        setKetteiShoninData(div);
        setKetteiShiharaiData(div);
    }

    private void setKetteiShoninData(tplKashitsukekinKetteiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(7));

        KashitsukekinKetteiShoninDiv div = tpl.getKashitsukekinKetteiShonin();
        div.getTxtShoninKanriNo().setValue(cg.getAsRString("管理番号"));
        div.getTxtKashitsukeKingaku().setValue(cg.getAsDecimal("貸付金額"));
        div.getTxtKashitsukeYMD().setValue(cg.getAsRDate("貸付日"));
        div.getTxtHenkanHoho().setValue(cg.getAsRString("返還方法"));
        div.getTxtShokanKigen().setValue(cg.getAsRDate("償還期限"));
        div.getTxtShiharaiKubun().setValue(cg.getAsRString("支払区分"));
    }

    private void setKetteiShiharaiData(tplKashitsukekinKetteiDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(8));

        KashitsukekinKetteiShiharaiDiv div = tpl.getKashitsukekinKetteiShonin().getKashitsukekinKetteiShiharai();
        KashitsukekinKetteiMadoDiv mado = div.getKashitsukekinKetteiMado();
        KashitsukekinKetteiKozaDiv koza = div.getKashitsukekinKetteiKoza();

        // N8187 久保田英男 デモ向けに支払い方法を"口座"として表示する。
        支払方法 hoho = 支払方法.口座;

        if (hoho.equals(支払方法.口座)) {
            mado.setVisible(false);
            mado.setDisplayNone(true);
            koza.setVisible(true);
            koza.setDisplayNone(false);

            mado.getTxtShiharaiBasho().clearValue();
            mado.getTxtKaishiYMD().clearValue();
            mado.getTxtKaishiH().clearValue();
            mado.getTxtKaishiM().clearValue();
            mado.getTxtShuryoYMD().clearValue();
            mado.getTxtShuryoH().clearValue();
            mado.getTxtShuryoM().clearValue();
            koza.getTxtKinyuKikanCode().setValue(cg.getAsRString("金融機関コード"));
            koza.getTxtKinyuKikanName().setValue(cg.getAsRString("金融機関名"));
            koza.getTxtKozaShubetsu().setValue(cg.getAsRString("口座種別"));
            koza.getTxtMeigininName().setValue(cg.getAsRString("名義人"));
            koza.getTxtShitenCode().setValue(cg.getAsRString("支店コード"));
            koza.getTxtShitenName().setValue(cg.getAsRString("支店名"));
            koza.getTxtKozaNo().setValue(cg.getAsRString("口座番号"));
            koza.getTxtMeigininKana().setValue(cg.getAsRString("カナ"));
        } else {
            mado.setVisible(true);
            mado.setDisplayNone(false);
            koza.setVisible(false);
            koza.setDisplayNone(true);

            mado.getTxtShiharaiBasho().setValue(cg.getAsRString("支払場所"));
            mado.getTxtKaishiYMD().setValue(cg.getAsRDate("開始日"));
            mado.getTxtKaishiH().setValue(cg.getAsDecimal("開始時"));
            mado.getTxtKaishiM().setValue(cg.getAsDecimal("開始分"));
            mado.getTxtShuryoYMD().setValue(cg.getAsRDate("終了日"));
            mado.getTxtShuryoH().setValue(cg.getAsDecimal("終了時"));
            mado.getTxtShuryoM().setValue(cg.getAsDecimal("終了分"));
            koza.getTxtKinyuKikanCode().clearValue();
            koza.getTxtKinyuKikanName().clearValue();
            koza.getTxtKozaShubetsu().clearValue();
            koza.getTxtMeigininName().clearValue();
            koza.getTxtShitenCode().clearValue();
            koza.getTxtShitenName().clearValue();
            koza.getTxtKozaNo().clearValue();
            koza.getTxtMeigininKana().clearValue();
        }
    }

    private void setKariukeData(KyufuhiKashitsukekinInfoDiv panel) {
        tplKashitsukekinKariukeDiv div = panel.getTabKashitsukekinInfo().getTplKashitsukekinKariuke();

        ControlGenerator cg = new ControlGenerator(getYaml().get(9));

        div.getTxtKariukeYMD().setValue(cg.getAsRDate("借受日"));
        setKariukeninData(div);
        setKariukeHoshoData(div);
    }

    private void setKariukeninData(tplKashitsukekinKariukeDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(10));

        KashitsukekinKariukeninDiv div = tpl.getKashitsukekinKariukenin();
        div.getTxtKariukeninName().setValue(cg.getAsRString("氏名"));
        div.getTxtKariukeninKana().setValue(cg.getAsRString("カナ"));
        div.getTxtKariukeninYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
        div.getTxtKariukeninJusho().setValue(cg.getAsRString("住所"));
        div.getTxtKariukeninTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setKariukeHoshoData(tplKashitsukekinKariukeDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(11));

        KashitsukekinKariukeHoshoDiv div = tpl.getKashitsukekinKariukeHosho();
        div.getTxtKariukeHoshoName().setValue(cg.getAsRString("氏名"));
        div.getTxtKariukeHoshoKana().setValue(cg.getAsRString("カナ"));
        div.getTxtKariukeHoshoYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
        div.getTxtKariukeHoshoJusho().setValue(cg.getAsRString("住所"));
        div.getTxtKariukeHoshoTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setHenkoData(KyufuhiKashitsukekinInfoDiv panel) {
        tplKashitsukekinHenkoDiv div = panel.getTabKashitsukekinInfo().getTplKashitsukekinHenko();

        ControlGenerator cg = new ControlGenerator(getYaml().get(12));

        div.getTxtEnchoShinseiYMD().setValue(cg.getAsRDate("延長申請日"));
        div.getTxtEnchoKikan().setFromValue(cg.getAsRDate("延長希望期間開始日"));
        div.getTxtEnchoKikan().setToValue(cg.getAsRDate("延長希望期間終了日"));
        div.getTxtMishokanKingaku().setValue(cg.getAsDecimal("未償還金額"));
        div.getTxtEnchoRiyu().setValue(cg.getAsRString("延長理由等"));

        setHenkoKariukeData(div);
        setHenkoKetteiData(div);
    }

    private void setHenkoKariukeData(tplKashitsukekinHenkoDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(13));

        KashitsukekinHenkoKariukeDiv div = tpl.getKashitsukekinHenkoKariuke();
        div.getTxtHenkoKariukeninName().setValue(cg.getAsRString("氏名"));
        div.getTxtHenkoKariukeninKana().setValue(cg.getAsRString("カナ"));
        div.getTxtHenkoKariukeninYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
        div.getTxtHenkoKariukeninJusho().setValue(cg.getAsRString("住所"));
        div.getTxtHenkoKariukeninTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setHenkoKetteiData(tplKashitsukekinHenkoDiv tpl) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(14));

        KashitsukekinHenkoKetteiDiv div = tpl.getKashitsukekinHenkoKettei();
        div.getTxtHenkoShoninKubun().setValue(cg.getAsRString("承認区分"));
        div.getTxtHenkoKetteiYMD().setValue(cg.getAsRDate("決定日"));
        div.getTxtHenkogoKigen().setValue(cg.getAsRDate("変更後償還期限"));
        div.getTxtHenkoFushoninRiyu().setValue(cg.getAsRString("不承認理由"));
    }

    private void setKozaData(KyufuhiKashitsukekinInfoDiv panel) {
        tplKashitsukekinKozaDiv div = panel.getTabKashitsukekinInfo().getTplKashitsukekinKoza();

        ControlGenerator cg = new ControlGenerator(getYaml().get(15));

        div.getTxtKojinKinyuKikanCode().setValue(cg.getAsRString("金融機関コード"));
        div.getTxtKojinKinyuKikanName().setValue(cg.getAsRString("金融機関名"));
        div.getTxtKojinKozaShubetsu().setValue(cg.getAsRString("口座種別"));
        div.getTxtKojinMeigininName().setValue(cg.getAsRString("名義人"));
        div.getTxtKojinShitenCode().setValue(cg.getAsRString("支店コード"));
        div.getTxtKojinShitenName().setValue(cg.getAsRString("支店名"));
        div.getTxtKojinKozaNo().setValue(cg.getAsRString("口座番号"));
        div.getTxtKojinMeigininKana().setValue(cg.getAsRString("カナ"));
    }

}

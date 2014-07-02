/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanChoshuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanKeisanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanRisokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanTsuchishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金返還徴収登録の給付費貸付金返還徴収情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KashitsukeHenkanInfo {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc1810000/KashitsukeHenkanInfo.yml"));
    }

    /**
     * 給付費貸付金一覧で行の「選択」を押下したときの給付費貸付金返還徴収情報パネルの処理です。
     *
     * @param info info
     * @return ResponseData
     */
    public ResponseData<KashitsukeHenkanInfoDiv> onSelectedHenkanList(KashitsukeHenkanInfoDiv info) {
        ResponseData<KashitsukeHenkanInfoDiv> response = new ResponseData<>();

        setSummary1Data(info);
        setServiceData(info);
        setSummary2Data(info);
        setRisokuKeisanData(info);
        setRisokuChoshuData(info);
        setHenkanChoshuData(info);
        setTeishutsuData(info);

        response.data = info;
        return response;
    }

    private void setSummary1Data(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        info.getTxtShinseiYMD().setValue(cg.getAsRDate("申請日"));
        info.getTxtRiyoKikan().setFromValue(cg.getAsRDate("利用期間開始日"));
        info.getTxtRiyoKikan().setToValue(cg.getAsRDate("利用期間終了日"));
        info.getTxtSeikyugaku().setValue(cg.getAsDecimal("事業者の支払請求額"));
        info.getTxtShinseiKingaku().setValue(cg.getAsDecimal("申請金額"));
    }

    private void setServiceData(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));

        info.getTxtService1().setValue(cg.getAsRString("対象サービス１"));
        info.getTxtService2().setValue(cg.getAsRString("対象サービス２"));
        info.getTxtService3().setValue(cg.getAsRString("対象サービス３"));
        info.getTxtService4().setValue(cg.getAsRString("対象サービス４"));
    }

    private void setSummary2Data(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));

        info.getTxtKetteiYMD().setValue(cg.getAsRDate("審査決定日"));
        info.getTxtShoninKubun().setValue(cg.getAsRString("承認区分"));
        info.getTxtKariukeYMD().setValue(cg.getAsRDate("借受日"));
        info.getTxtEnchoShinseiYMD().setValue(cg.getAsRDate("延長申請日"));
        info.getTxtEnchoKikan().setFromValue(cg.getAsRDate("延長期間開始日"));
        info.getTxtEnchoKikan().setToValue(cg.getAsRDate("延長期間終了日"));
        info.getTxtMishokanKingaku().setValue(cg.getAsDecimal("未償還金額"));
    }

    private void setRisokuKeisanData(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(2));
        KashitsukeHenkanKeisanDiv div = info.getKashitsukeHenkanKeisan();
        div.getTxtEntaiNissu().setValue(cg.getAsDecimal("延滞日数"));
        div.getTxtRisokugaku().setValue(cg.getAsDecimal("利息金額"));
    }

    private void setRisokuChoshuData(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(3));
        KashitsukeHenkanRisokuDiv div = info.getKashitsukeHenkanRisoku();
        div.getTxtRisokuChoshuYMD().setValue(cg.getAsRDate("徴収日"));
        div.getTxtRisokuChoshugaku().setValue(cg.getAsDecimal("徴収金額"));
    }

    private void setHenkanChoshuData(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));
        KashitsukeHenkanChoshuDiv div = info.getKashitsukeHenkanChoshu();
        div.getRadChoshuHoho().setSelectedItem(cg.getAsRString("徴収方法key"));
        div.getRadKafusokuKekka().setSelectedItem(cg.getAsRString("過不足結果key"));
        div.getTxtHenkanChoshuYMD().setValue(cg.getAsRDate("徴収日"));
        div.getTxtHenkanChoshugaku().setValue(cg.getAsDecimal("徴収金額"));
    }

    private void setTeishutsuData(KashitsukeHenkanInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(5));
        KashitsukeHenkanTsuchishoDiv div = info.getKashitsukeHenkanTsuchisho();
        div.getKashitsukeHenkanTsuchishoPrintSetting().getTxtIssueDate().setValue(RDate.getNowDate());
        div.getTxtNofuKigen().setValue(cg.getAsRDate("差引不足額納付期限"));
        div.getTxtShiharaiKigen().setValue(cg.getAsRDate("差引支給額支払期限"));
    }

}

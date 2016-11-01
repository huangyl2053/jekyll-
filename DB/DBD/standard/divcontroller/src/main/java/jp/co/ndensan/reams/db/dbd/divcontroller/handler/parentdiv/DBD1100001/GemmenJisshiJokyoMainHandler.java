/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1100001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD104010.DBD104010_JukyushaGemmenJisshiJokyoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.JukyushaGenmenJissijokyo.NinteijokyohyoKijyunbiKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1100001.GemmenJisshiJokyoMainDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者減免実施状況のHandlerです。
 *
 * @reamsid_L DBD-3770-010 x_liuwei
 */
public class GemmenJisshiJokyoMainHandler {

    private final GemmenJisshiJokyoMainDiv div;

    /**
     * コンストラクターです。
     *
     * @param div GemmenJisshiJokyoMainDiv
     */
    public GemmenJisshiJokyoMainHandler(GemmenJisshiJokyoMainDiv div) {
        this.div = div;
    }

    /**
     * 出力帳票onChange。
     */
    public void onChange_RadShutsuryokuChohyo() {
        RString key = div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().getSelectedKey();

        if ("1".equals(key.toString())) {
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().clearValue();
            div.getGemmenJisshiJokyoJoken().getRadKijunBi().setDisabled(true);
            div.getGemmenJisshiJokyoJoken().getRadKijunNengetsu().setDisabled(true);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(true);
            div.getRadKijunBi().setSelectedKey(new RString("1"));
            div.getRadKijunNengetsu().clearSelectedItem();
        } else {
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setValue(new Decimal(RDate.getNowDate().getDayValue()));
            div.getGemmenJisshiJokyoJoken().getRadKijunBi().setDisabled(false);
            div.getGemmenJisshiJokyoJoken().getRadKijunNengetsu().setDisabled(false);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(false);
            div.getRadKijunBi().setSelectedKey(new RString("1"));
            div.getRadKijunNengetsu().clearSelectedItem();
        }
    }

    /**
     * 基準年月と基準日onChange。
     */
    public void onChange_RadKijun() {
        RString key = div.getGemmenJisshiJokyoJoken().getRadKijunBi().getSelectedKey();
        if (null != key && "1".equals(key.toString())) {
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(false);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setDisabled(false);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setValue(new Decimal(RDate.getNowDate().getDayValue()));
        } else {
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().clearValue();
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(true);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setDisabled(true);
        }
    }

    /**
     * 「条件を保存する」ボタンを押下時、バッチパラメータを保存します。
     *
     * @return parameter
     */
    public DBD104010_JukyushaGemmenJisshiJokyoParameter onClick_btnBatchParameterSave() {
        DBD104010_JukyushaGemmenJisshiJokyoParameter parameter = new DBD104010_JukyushaGemmenJisshiJokyoParameter();
        parameter.set出力帳票(div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().getSelectedKey());
        parameter.set対象年度(new FlexibleYear(div.getGemmenJisshiJokyoJoken().getTxtTaishoNendo().getDomain().toDateString()));
        if ("1".equals(div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().getSelectedKey().toString())) {
            parameter.set基準日区分(new RString("0"));
        } else {
            RString key = div.getGemmenJisshiJokyoJoken().getRadKijunBi().getSelectedKey();
            if (null != key && "1".equals(key.toString())) {
                parameter.set基準日区分(NinteijokyohyoKijyunbiKubun.基準日.getコード());
            } else {
                parameter.set基準日区分(NinteijokyohyoKijyunbiKubun.基準年月.getコード());
            }
        }
        if ("1".equals(div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().getSelectedKey().toString())) {
            parameter.set基準日(new RString("00"));
        } else {
            RString key = div.getGemmenJisshiJokyoJoken().getRadKijunBi().getSelectedKey();
            if (null != key && "1".equals(key.toString())) {
                parameter.set基準日(new RString(div.getGemmenJisshiJokyoJoken().getTxtKijunBi().getValue().toString()));
            } else {
                parameter.set基準日(new RString("00"));
            }
        }
        if ("1".equals(div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().getSelectedKey().toString())) {
            parameter.set帳票ID(new ReportId("DBD300001_JukyushaGemmenTsukibetsuShinseiNinteiJokyohyo"));
        } else {
            parameter.set帳票ID(new ReportId("DBD300002_JukyushaGemmenTsukibetsuNinteishaJokyohyo"));
        }

        宛名抽出条件保存(parameter);

        return parameter;
    }

    /**
     * 「条件を復元する」ボタンを押下時、バッチパラメータを復元します。
     *
     */
    public void onClick_btnBatchParameterRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 出力帳票 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("出力帳票"));
        FlexibleYear 対象年度 = restoreBatchParameterMap.getParameterValue(FlexibleYear.class, new RString("対象年度"));
        RString 基準日区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("基準日区分"));
        RString 基準日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("基準日"));
        ReportId 帳票ID = restoreBatchParameterMap.getParameterValue(ReportId.class, new RString("帳票ID"));
        div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().setSelectedKey(出力帳票);
        div.getGemmenJisshiJokyoJoken().getTxtTaishoNendo().setDomain(new RYear(対象年度.toDateString()));
        if ("1".equals(出力帳票.toString())) {
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().clearValue();
            div.getGemmenJisshiJokyoJoken().getRadKijunBi().setDisabled(true);
            div.getGemmenJisshiJokyoJoken().getRadKijunNengetsu().setDisabled(true);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(true);
            div.getGemmenJisshiJokyoJoken().getRadKijunBi().setSelectedKey(new RString("1"));
        } else {
            div.getGemmenJisshiJokyoJoken().getRadKijunBi().setDisabled(false);
            div.getGemmenJisshiJokyoJoken().getRadKijunNengetsu().setDisabled(false);
            div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(false);
            if ("1".equals(基準日区分.toString())) {
                div.getGemmenJisshiJokyoJoken().getRadKijunBi().setSelectedKey(new RString("1"));
                div.getGemmenJisshiJokyoJoken().getRadKijunNengetsu().clearSelectedItem();
                div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setValue(new Decimal(基準日.toString()));
                div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(false);
                div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setDisabled(false);
            } else {
                div.getGemmenJisshiJokyoJoken().getRadKijunBi().clearSelectedItem();
                div.getGemmenJisshiJokyoJoken().getRadKijunNengetsu().setSelectedKey(new RString("2"));
                div.getGemmenJisshiJokyoJoken().getTxtKijunBi().clearValue();
                div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setReadOnly(true);
                div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setDisabled(false);
            }

        }
        div.getRadShutsuryokuChohyo().clearSelectedItem();
        if (new ReportId("DBD300001_JukyushaGemmenTsukibetsuShinseiNinteiJokyohyo").equals(帳票ID)) {
            div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().setSelectedKey(new RString("1"));
        } else {
            div.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo().setSelectedKey(new RString("2"));
        }
        宛名抽出条件復元(restoreBatchParameterMap);
    }

    private void 宛名抽出条件保存(DBD104010_JukyushaGemmenJisshiJokyoParameter parameter) {
        AtenaSelectBatchParameter 宛名抽出条件 = div.getGemmenJisshiJokyoJoken().getCcdAtenaJoken().get宛名抽出条件();

        宛名抽出条件.setChiku1_From(宛名抽出条件.getChiku1_From() != null ? 宛名抽出条件.getChiku1_From() : RString.EMPTY);
        宛名抽出条件.setChiku1_FromMesho(宛名抽出条件.getChiku1_FromMesho() != null ? 宛名抽出条件.getChiku1_FromMesho() : RString.EMPTY);
        宛名抽出条件.setChiku1_To(宛名抽出条件.getChiku1_To() != null ? 宛名抽出条件.getChiku1_To() : RString.EMPTY);
        宛名抽出条件.setChiku1_ToMesho(宛名抽出条件.getChiku1_ToMesho() != null ? 宛名抽出条件.getChiku1_ToMesho() : RString.EMPTY);
        宛名抽出条件.setChiku2_From(宛名抽出条件.getChiku2_From() != null ? 宛名抽出条件.getChiku2_From() : RString.EMPTY);
        宛名抽出条件.setChiku2_FromMesho(宛名抽出条件.getChiku2_FromMesho() != null ? 宛名抽出条件.getChiku2_FromMesho() : RString.EMPTY);
        宛名抽出条件.setChiku2_To(宛名抽出条件.getChiku2_To() != null ? 宛名抽出条件.getChiku2_To() : RString.EMPTY);
        宛名抽出条件.setChiku2_ToMesho(宛名抽出条件.getChiku2_ToMesho() != null ? 宛名抽出条件.getChiku2_ToMesho() : RString.EMPTY);
        宛名抽出条件.setChiku3_From(宛名抽出条件.getChiku3_From() != null ? 宛名抽出条件.getChiku3_From() : RString.EMPTY);
        宛名抽出条件.setChiku3_FromMesho(宛名抽出条件.getChiku3_FromMesho() != null ? 宛名抽出条件.getChiku3_FromMesho() : RString.EMPTY);
        宛名抽出条件.setChiku3_To(宛名抽出条件.getChiku3_To() != null ? 宛名抽出条件.getChiku3_To() : RString.EMPTY);
        rStringpart(宛名抽出条件);
        parameter.set宛名抽出条件(宛名抽出条件);
    }

    private void rStringpart(AtenaSelectBatchParameter 宛名抽出条件) {
        宛名抽出条件.setChiku3_ToMesho(宛名抽出条件.getChiku3_ToMesho() != null ? 宛名抽出条件.getChiku3_ToMesho() : RString.EMPTY);
        宛名抽出条件.setGyoseiku_From(宛名抽出条件.getGyoseiku_From() != null ? 宛名抽出条件.getGyoseiku_From() : RString.EMPTY);
        宛名抽出条件.setGyoseiku_FromMesho(宛名抽出条件.getGyoseiku_FromMesho() != null ? 宛名抽出条件.getGyoseiku_FromMesho() : RString.EMPTY);
        宛名抽出条件.setGyoseiku_To(宛名抽出条件.getGyoseiku_To() != null ? 宛名抽出条件.getGyoseiku_To() : RString.EMPTY);
        宛名抽出条件.setGyoseiku_ToMesho(宛名抽出条件.getGyoseiku_ToMesho() != null ? 宛名抽出条件.getGyoseiku_ToMesho() : RString.EMPTY);
        宛名抽出条件.setJusho_From(宛名抽出条件.getJusho_From() != null ? 宛名抽出条件.getJusho_From() : RString.EMPTY);
        宛名抽出条件.setJusho_FromMesho(宛名抽出条件.getJusho_FromMesho() != null ? 宛名抽出条件.getJusho_FromMesho() : RString.EMPTY);
        宛名抽出条件.setJusho_To(宛名抽出条件.getJusho_To() != null ? 宛名抽出条件.getJusho_To() : RString.EMPTY);
        宛名抽出条件.setJusho_ToMesho(宛名抽出条件.getJusho_ToMesho() != null ? 宛名抽出条件.getJusho_ToMesho() : RString.EMPTY);
        宛名抽出条件.setShichoson_Mesho(宛名抽出条件.getShichoson_Mesho() != null ? 宛名抽出条件.getShichoson_Mesho() : RString.EMPTY);
    }

    private void 宛名抽出条件復元(BatchParameterMap restoreBatchParameterMap) {
        AtenaSelectBatchParameter 宛名抽出条件 = restoreBatchParameterMap.getParameterValue(AtenaSelectBatchParameter.class, new RString("宛名抽出条件"));
        get宛名抽出条件div().set年齢層抽出方法(宛名抽出条件.getAgeSelectKijun().getコード());
        get宛名抽出条件div().onChange_SelectKijun();
        get宛名抽出条件div().set年齢開始(宛名抽出条件.getNenreiRange().getFrom());
        get宛名抽出条件div().set年齢終了(宛名抽出条件.getNenreiRange().getTo());
        get宛名抽出条件div().set年齢基準日(宛名抽出条件.getNenreiKijunbi());
        get宛名抽出条件div().set生年月日開始(宛名抽出条件.getSeinengappiRange().getFrom());
        get宛名抽出条件div().set生年月日終了(宛名抽出条件.getSeinengappiRange().getTo());
        get宛名抽出条件div().set地区(宛名抽出条件.getChiku_Kubun().getコード());
        get宛名抽出条件div().set保険者(宛名抽出条件.getShichoson_Code());
        get宛名抽出条件div().onChange_SelectChiku();
        get宛名抽出条件div().set住所開始(new ChoikiCode(宛名抽出条件.getJusho_From()));
        get宛名抽出条件div().set住所終了(new ChoikiCode(宛名抽出条件.getJusho_To()));
        get宛名抽出条件div().set行政区開始(new GyoseikuCode(宛名抽出条件.getGyoseiku_From()));
        get宛名抽出条件div().set行政区終了(new GyoseikuCode(宛名抽出条件.getGyoseiku_To()));
        get宛名抽出条件div().set地区１開始(new ChikuCode(宛名抽出条件.getChiku1_From()));
        get宛名抽出条件div().set地区１終了(new ChikuCode(宛名抽出条件.getChiku1_To()));
        get宛名抽出条件div().set地区２開始(new ChikuCode(宛名抽出条件.getChiku2_From()));
        get宛名抽出条件div().set地区２終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
        get宛名抽出条件div().set地区３開始(new ChikuCode(宛名抽出条件.getChiku3_From()));
        get宛名抽出条件div().set地区３終了(new ChikuCode(宛名抽出条件.getChiku2_To()));

    }

    private IHanyoListAtenaSelectDiv get宛名抽出条件div() {
        return div.getGemmenJisshiJokyoJoken().getCcdAtenaJoken();
    }
}

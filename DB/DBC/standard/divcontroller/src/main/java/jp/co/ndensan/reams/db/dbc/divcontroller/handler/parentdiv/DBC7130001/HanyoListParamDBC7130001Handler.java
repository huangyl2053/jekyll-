/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710130.DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7130001.HanyoListParamDBC7130001Div;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_短期入所拡大該当者のHandlerクラスです。
 *
 * @reamsid_L DBC-3111-010 xuyannan
 */
public class HanyoListParamDBC7130001Handler {

    private static final RString 導入形態_単一 = new RString("0");
    private static final RString 導入形態_広域 = new RString("1");
    private static final RString 全て市町村 = new RString("000000");
    private final HanyoListParamDBC7130001Div div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamDBC7130001Div
     */
    public HanyoListParamDBC7130001Handler(HanyoListParamDBC7130001Div div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param keitaiList 導入形態
     */
    public void onLoad(List<KaigoDonyuKeitai> keitaiList) {
        if (keitaiList.get(0).get導入形態コード().is単一()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(true);
            div.setHdnDonyuKeitai(導入形態_単一);
        } else if (keitaiList.get(0).get導入形態コード().is広域()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
            div.setHdnDonyuKeitai(導入形態_広域);
        }
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701013.getReportId());
        div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701013.getReportId().value(), SubGyomuCode.DBC介護給付);
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter
     */
    public DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter onClick_btnBatchParameterSave() {
        DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter parameter = new DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter();
        parameter.set帳票ID(div.getCcdShutsuryokujun().get帳票ID().value());
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            parameter.set出力順ID(div.getCcdShutsuryokujun().get出力順ID());
        }
        parameter.set出力順項目ID(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付編集 = false;
        List<RString> 編集方法List = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                is項目名付加 = true;
            } else if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                is連番付加 = true;
            } else if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                is日付編集 = true;
            }
        }
        parameter.set項目名付加(is項目名付加);
        parameter.set連番付加(is連番付加);
        parameter.set日付編集(is日付編集);
        RString 市町村コード = RString.EMPTY;
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())
                && div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード() != null) {
            if (!div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = 全て市町村;
            }
        }
        parameter.set保険者コード(市町村コード);
        parameter.set抽出区分(div.getChushutsuJokenPanel().getRadChushutsuKubun().getSelectedKey());
        if (div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().getFromValue() != null) {
            parameter.set適用開始年月From(div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().getFromValue().toDateString());
        }
        if (div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().getToValue() != null) {
            parameter.set適用開始年月To(div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().getToValue().toDateString());
        }
        if (div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().getFromValue() != null) {
            parameter.set適用終了年月From(div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().getFromValue().toDateString());
        }
        if (div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().getToValue() != null) {
            parameter.set適用終了年月To(div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().getToValue().toDateString());
        }
        parameter.set限度額管理期間数(div.getChushutsuJokenPanel().getRadGendogakuKanriKikansu().getSelectedKey());
        return parameter;
    }

    /**
     * 条件を復元するボタンを押下します。
     */
    public void onClick_btnBatchParameterRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getJokenFukugenHozonl().getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("is項目名付加"));
        if (is項目名付加) {
            編集方法.add(CSVSettings.項目名付加.getコード());
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("is連番付加"));
        if (is連番付加) {
            編集方法.add(CSVSettings.連番付加.getコード());
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("is日付編集"));
        if (is日付編集) {
            編集方法.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())) {
            if (全て市町村.equals(restoreBatchParameterMap.getParameterValue(RString.class, new RString("保険者コード")))) {
                div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
            } else {
                div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(
                        new LasdecCode(restoreBatchParameterMap.getParameterValue(RString.class, new RString("保険者コード"))));
            }
        }
        div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出区分")));
        RString 適用開始年月From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("適用開始年月From"));
        RString 適用開始年月To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("適用開始年月To"));
        RString 適用終了年月From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("適用終了年月From"));
        RString 適用終了年月To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("適用終了年月To"));
        if (!RString.isNullOrEmpty(適用開始年月From)) {
            div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().setFromValue(
                    new RDate(適用開始年月From.toString()));
        } else {
            div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().clearFromValue();
        }
        if (!RString.isNullOrEmpty(適用開始年月To)) {
            div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().setToValue(
                    new RDate(適用開始年月To.toString()));
        } else {
            div.getChushutsuJokenPanel().getTxtTekiyoKaishiNengetsu().clearToValue();
        }
        if (!RString.isNullOrEmpty(適用終了年月From)) {
            div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().setFromValue(
                    new RDate(適用終了年月From.toString()));
        } else {
            div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().clearFromValue();
        }
        if (!RString.isNullOrEmpty(適用終了年月To)) {
            div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().setToValue(
                    new RDate(適用終了年月To.toString()));
        } else {
            div.getChushutsuJokenPanel().getTxtTekiyoShuryoNengetsu().clearToValue();
        }
        div.getChushutsuJokenPanel().getRadGendogakuKanriKikansu().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("限度額管理期間数")));
    }
}

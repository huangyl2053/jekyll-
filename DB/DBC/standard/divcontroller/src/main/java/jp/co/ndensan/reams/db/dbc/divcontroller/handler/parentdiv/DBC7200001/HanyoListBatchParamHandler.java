/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710200.DBC710200_HanyoListKijunShunyugakuTekiyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kijunshunyugakutekiyo.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kijunshunyugakutekiyo.DataShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7200001.HanyoListBatchParamDiv;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト_基準収入額適用情報のHandlerクラスです。
 *
 * @reamsid_L DBC-5050-010 xuyannan
 */
public class HanyoListBatchParamHandler {

    private static final FlexibleYear 固定年度 = new FlexibleYear("2015");
    private static final RString KEY = new RString("key0");
    private final HanyoListBatchParamDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListBatchParamDiv
     */
    public HanyoListBatchParamHandler(HanyoListBatchParamDiv div) {
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
        } else if (keitaiList.get(0).get導入形態コード().is広域()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
        }
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701020.getReportId());
        div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701020.getReportId().value(), SubGyomuCode.DBC介護給付);
        FlexibleYear 所得年度 = new HizukeConfig().get所得年度();
        List<KeyValueDataSource> list = new ArrayList<>();
        if (所得年度 != null && !所得年度.isEmpty()) {
            if (!所得年度.isBefore(固定年度)) {
                KeyValueDataSource source = new KeyValueDataSource();
                source.setKey(KEY);
                source.setValue(所得年度.wareki().toDateString());
                list.add(source);
                for (int i = 0; i < 所得年度.getBetweenYears(固定年度); i++) {
                    KeyValueDataSource dataSource = new KeyValueDataSource();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append("key");
                    builder.append(i + 1);
                    dataSource.setKey(builder.toRString());
                    dataSource.setValue(所得年度.minusYear(i).wareki().toDateString());
                    list.add(dataSource);
                }
            }
        }
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setDataSource(list);
        div.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu().setDisabled(true);
        div.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun().setDisabled(true);
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter DBC710200_HanyoListKijunShunyugakuTekiyoParameter
     */
    public DBC710200_HanyoListKijunShunyugakuTekiyoParameter onClick_btnBatchParameterSave() {
        DBC710200_HanyoListKijunShunyugakuTekiyoParameter parameter = new DBC710200_HanyoListKijunShunyugakuTekiyoParameter();
        parameter.set帳票ID(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.set出力順ID(div.getCcdShutsuryokujun().get出力順ID());
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
        if (div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード() != null
                && !div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
            市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        }
        parameter.set保険者コード(市町村コード);
        parameter.set対象年度(div.getChushutsuJokenPanel().getDdlTaishoNendo().getSelectedValue());
        if (div.getChushutsuJokenPanel().getChkSakujyoDataChushutsu().getSelectedKeys().isEmpty()) {
            parameter.set削除含める(false);
        } else {
            parameter.set削除含める(true);
        }
        parameter.setデータ種別(div.getChushutsuJokenPanel().getDetaShubetsu().getRadDetaShubetsu().getSelectedValue());
        parameter.set抽出区分(div.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun().getSelectedValue());
        parameter.set基準年月(rDateToRString(div.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu().getValue()));
        parameter.set申請日From(rDateToRString(div.getChushutsuJokenPanel().getTxtSinseibi().getFromValue()));
        parameter.set申請日To(rDateToRString(div.getChushutsuJokenPanel().getTxtSinseibi().getToValue()));
        parameter.set決定日From(rDateToRString(div.getChushutsuJokenPanel().getTxtKetteibi().getFromValue()));
        parameter.set決定日To(rDateToRString(div.getChushutsuJokenPanel().getTxtKetteibi().getToValue()));
        return parameter;
    }

    /**
     * 条件を復元するボタンを押下します。
     */
    public void onClick_btnBatchParameterRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getJokenFukugenHozonl().getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komoukumei"));
        if (is項目名付加) {
            編集方法.add(CSVSettings.項目名付加.getコード());
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(CSVSettings.連番付加.getコード());
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("isdateedit"));
        if (is日付編集) {
            編集方法.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(
                new LasdecCode(restoreBatchParameterMap.getParameterValue(RString.class, new RString("honkenshaCode"))));
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setSelectedValue(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("taishonendo")));
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("isdeleteflag"))) {
            List<RString> list = new ArrayList<>();
            list.add(new RString("key0"));
            div.getChushutsuJokenPanel().getChkSakujyoDataChushutsu().setSelectedItemsByKey(list);
        }
        div.getChushutsuJokenPanel().getDetaShubetsu().getRadDetaShubetsu().setSelectedValue(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("datashubetsu")));
        div.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun().setSelectedValue(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("tyusyutuKubun")));
        RString 基準年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunYM"));
        RString 申請日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shinseiYMDFrom"));
        RString 申請日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shinseiYMDTo"));
        RString 決定日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kettiYMDFrom"));
        RString 決定日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kettiYMDTo"));
        if (!RString.isNullOrEmpty(基準年月)) {
            div.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu().setValue(
                    new RDate(基準年月.toString()));
        }
        if (!RString.isNullOrEmpty(申請日From)) {
            div.getChushutsuJokenPanel().getTxtSinseibi().setFromValue(
                    new RDate(申請日From.toString()));
        }
        if (!RString.isNullOrEmpty(申請日To)) {
            div.getChushutsuJokenPanel().getTxtSinseibi().setToValue(
                    new RDate(申請日To.toString()));
        }
        if (!RString.isNullOrEmpty(決定日From)) {
            div.getChushutsuJokenPanel().getTxtKetteibi().setFromValue(
                    new RDate(決定日From.toString()));
        }
        if (!RString.isNullOrEmpty(決定日To)) {
            div.getChushutsuJokenPanel().getTxtKetteibi().setToValue(
                    new RDate(決定日To.toString()));
        }
    }

    /**
     * データ種別RBTのonChangeを実施します。
     */
    public void set抽出区分の表示制御() {
        if (DataShubetsu.適用決定データ.get名称().equals(
                div.getChushutsuJokenPanel().getDetaShubetsu().getRadDetaShubetsu().getSelectedValue())) {
            div.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun().setDisabled(false);
        } else {
            div.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun().setDisabled(true);
        }
    }

    /**
     * 抽出区分RBTのonChangeを実施します。
     */
    public void set基準年月の表示制御() {
        if (ChushutsuKubun.基準年月時点のデータ.get名称().equals(
                div.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun().getSelectedValue())) {
            div.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu().setDisabled(false);
        } else {
            div.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu().setDisabled(true);
        }
    }

    private RString rDateToRString(RDate 日付) {
        if (日付 == null) {
            return RString.EMPTY;
        }
        return 日付.toDateString();
    }
}

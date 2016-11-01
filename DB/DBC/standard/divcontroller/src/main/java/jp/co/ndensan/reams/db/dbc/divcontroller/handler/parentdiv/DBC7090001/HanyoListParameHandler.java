/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710090.DBC710090_HanyoListKagoMoshitateParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_HokenshaKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7090001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7090001.HanyoListParameDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(過誤申立情報)のHandlerです。
 *
 * @reamsid_L DBC-3095-010 qinzhen
 */
public class HanyoListParameHandler {

    private final HanyoListParameDiv div;
    private static final RString 項目名 = new RString("1");
    private static final RString 連番 = new RString("2");
    private static final RString 日付 = new RString("3");
    private static final RString 事務広域 = new RString("111");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString すべて = new RString("key0");
    private static final RString 介護給付費 = new RString("key1");
    private static final RString 総合事業費_経過措置 = new RString("key2");
    private static final RString 総合事業費 = new RString("key3");
    private static final RString KEY_項目名付加 = new RString("項目名付加");
    private static final RString KEY_連番付加 = new RString("連番付加");
    private static final RString KEY_日付スラッシュ付加 = new RString("日付スラッシュ付加");
    private static final RString KEY_出力順 = new RString("出力順");
    private static final RString KEY_サービス提供年月開始 = new RString("サービス提供年月From");
    private static final RString KEY_サービス提供年月終了 = new RString("サービス提供年月To");
    private static final RString KEY_国保連送付年月FROM = new RString("国保連送付年月From");
    private static final RString KEY_国保連送付年月TO = new RString("国保連送付年月To");
    private static final RString KEY_過誤申立給付区分 = new RString("過誤申立給付区分");
    private static final RString KEY_事業者コード = new RString("事業者コード");
    private static final RString KEY_事業者名 = new RString("事業者名");
    private static final RString KEY_保険者コード = new RString("保険者コード");

    /**
     * コンストラクタ。
     *
     * @param div HanyoListParameDiv
     *
     */
    public HanyoListParameHandler(HanyoListParameDiv div) {
        this.div = div;
    }

    /**
     * initializeのメソッドです。
     *
     */
    public void initialize() {

        List<RString> selectKey = new ArrayList<>();
        selectKey.add(項目名);
        selectKey.add(日付);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(selectKey);

        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (事務広域.equals(市町村情報セキュリティ情報.get導入形態コード().value())) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(false);
        } else {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setVisible(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisabled(true);
        }

        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701009.getReportId());
    }

    /**
     * バッチパラメータ設定するメソッド。
     *
     * @return DBC710090_HanyoListKagoMoshitateParameter
     */
    public DBC710090_HanyoListKagoMoshitateParameter setBatchParameter() {
        DBC710090_HanyoListKagoMoshitateParameter parameter = new DBC710090_HanyoListKagoMoshitateParameter();
        ChushutsuJokenPanelDiv panel = div.getChushutsuJokenPanel();

        if (panel.getTxtKokuhorenSofuNengetu().getFromValue() != null) {
            parameter.set国保連送付年月From(new FlexibleYearMonth(panel.getTxtKokuhorenSofuNengetu().getFromValue().getYearMonth().toDateString()));
        } else {
            parameter.set国保連送付年月From(FlexibleYearMonth.EMPTY);
        }

        if (panel.getTxtKokuhorenSofuNengetu().getToValue() != null) {
            parameter.set国保連送付年月To(new FlexibleYearMonth(panel.getTxtKokuhorenSofuNengetu().getToValue().getYearMonth().toDateString()));
        } else {
            parameter.set国保連送付年月To(FlexibleYearMonth.EMPTY);
        }

        if (すべて.equals(panel.getRadKagoMoshitateKyufuKubun().getSelectedKey())) {
            parameter.set過誤申立給付区分(RString.EMPTY);
        } else if (介護給付費.equals(panel.getRadKagoMoshitateKyufuKubun().getSelectedKey())) {
            parameter.set過誤申立給付区分(KagoMoshitate_HokenshaKubun.介護給付費.getコード());
        } else if (総合事業費_経過措置.equals(panel.getRadKagoMoshitateKyufuKubun().getSelectedKey())) {
            parameter.set過誤申立給付区分(KagoMoshitate_HokenshaKubun.総合事業費_経過措置.getコード());
        } else {
            parameter.set過誤申立給付区分(KagoMoshitate_HokenshaKubun.総合事業費.getコード());
        }

        if (panel.getTxtSabisuTeikyoNengetu().getFromValue() != null) {
            parameter.setサービス提供年月From(new FlexibleYearMonth(panel.getTxtSabisuTeikyoNengetu().getFromValue().getYearMonth().toDateString()));
        } else {
            parameter.setサービス提供年月From(FlexibleYearMonth.EMPTY);
        }

        if (panel.getTxtSabisuTeikyoNengetu().getToValue() != null) {
            parameter.setサービス提供年月To(new FlexibleYearMonth(panel.getTxtSabisuTeikyoNengetu().getToValue().getYearMonth().toDateString()));
        } else {
            parameter.setサービス提供年月To(FlexibleYearMonth.EMPTY);
        }

        parameter.set事業者コード(panel.getCcdJigyoshaBango().getNyuryokuShisetsuKodo());
        parameter.set事業者名(panel.getCcdJigyoshaBango().getNyuryokuShisetsuMeisho());

        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
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
        parameter.set日付スラッシュ付加(is日付編集);

        if (!panel.getCcdHokenshaList().isDisabled() && !panel.getCcdHokenshaList().getSelectedItem().get市町村名称().equals(全市町村)) {
            parameter.set保険者コード(panel.getCcdHokenshaList().getSelectedItem().get市町村コード());

        }
        if (div.getCcdShutsuryokujun().get出力順ID() == null) {
            parameter.set出力順(RString.EMPTY);
        } else {
            parameter.set出力順(new RString(div.getCcdShutsuryokujun().get出力順ID()));
        }

        parameter.set出力項目(RString.EMPTY);
        return parameter;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     */
    public void pamaRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        restoreClear();
        FlexibleYearMonth 国保連送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_国保連送付年月FROM);
        if (国保連送付年月From != null && !国保連送付年月From.isEmpty()) {
            div.getTxtKokuhorenSofuNengetu().setFromValue(new RDate(国保連送付年月From.getYearValue(), 国保連送付年月From.getMonthValue(), 国保連送付年月From.getLastDay()));
        }
        FlexibleYearMonth 国保連送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_国保連送付年月TO);
        if (国保連送付年月To != null) {
            div.getTxtKokuhorenSofuNengetu().setToValue(new RDate(国保連送付年月To.getYearValue(), 国保連送付年月To.getMonthValue(), 国保連送付年月To.getLastDay()));
        }
        FlexibleYearMonth サービス提供年月F = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_サービス提供年月開始);
        if (サービス提供年月F != null && !サービス提供年月F.isEmpty()) {
            div.getTxtSabisuTeikyoNengetu().setFromValue(new RDate(サービス提供年月F.getYearValue(), サービス提供年月F.getMonthValue(), サービス提供年月F.getLastDay()));
        }
        FlexibleYearMonth サービス提供年月T = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_サービス提供年月終了);
        if (サービス提供年月T != null) {
            div.getTxtSabisuTeikyoNengetu().setToValue(new RDate(サービス提供年月T.getYearValue(), サービス提供年月T.getMonthValue(), サービス提供年月T.getLastDay()));
        }
        RString 過誤申立給付区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_過誤申立給付区分);
        if (過誤申立給付区分 != null) {
            div.getRadKagoMoshitateKyufuKubun().setSelectedKey(set過誤申立給付区分(過誤申立給付区分));
        }
        RString 事業者コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_事業者コード);
        if (事業者コード != null) {
            div.getCcdJigyoshaBango().setNyuryokuShisetsuKodo(事業者コード);
        }
        RString 事業者名 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_事業者名);
        if (事業者名 != null) {
            div.getCcdJigyoshaBango().setShisetsuMeisho(事業者名);
        }
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_項目名付加);
        if (項目名付加) {
            csv編集方法リスト.add(項目名);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_連番付加);
        if (連番付加) {
            csv編集方法リスト.add(連番);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_日付スラッシュ付加);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(日付);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        LasdecCode 保険者コード = restoreBatchParameterMap.getParameterValue(LasdecCode.class, KEY_保険者コード);
        if (保険者コード != null && !保険者コード.isEmpty()) {
            div.getCcdHokenshaList().setSelectedShichosonIfExist(保険者コード);
        }
        RString 出力順 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_出力順);
        if (出力順 != null && !出力順.isEmpty()) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701009.getReportId(),
                    Long.valueOf(出力順.toString()));
        }
    }

    private void restoreClear() {
        div.getTxtKokuhorenSofuNengetu().clearFromValue();
        div.getTxtKokuhorenSofuNengetu().clearToValue();
        div.getTxtSabisuTeikyoNengetu().clearFromValue();
        div.getTxtSabisuTeikyoNengetu().clearToValue();
        div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
    }

    private RString set過誤申立給付区分(RString 過誤申立給付区分) {
        if (KagoMoshitate_HokenshaKubun.介護給付費.getコード().equals(過誤申立給付区分)) {
            return 介護給付費;
        } else if (KagoMoshitate_HokenshaKubun.総合事業費_経過措置.getコード().equals(過誤申立給付区分)) {
            return 総合事業費_経過措置;
        } else if (KagoMoshitate_HokenshaKubun.総合事業費.getコード().equals(過誤申立給付区分)) {
            return 総合事業費;
        } else {
            return すべて;
        }
    }
}

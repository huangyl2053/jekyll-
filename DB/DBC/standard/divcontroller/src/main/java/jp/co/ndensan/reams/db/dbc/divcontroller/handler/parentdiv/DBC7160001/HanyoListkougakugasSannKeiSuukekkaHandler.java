/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710160.DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)のクラスです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public class HanyoListkougakugasSannKeiSuukekkaHandler {

    private final HanyoListkougakugasSannKeiSuukekkaDiv div;
    private static final int NUM_1 = 1;
    private static final RString すべて = new RString("すべて");
    private static final RString 最新履歴 = new RString("最新履歴");
    private static final RString 国保連作成 = new RString("国保連作成");
    private static final RString 保険者作成 = new RString("保険者作成");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_2 = new RString("key2");
    private static final RString 通常データ = new RString("通常データ");
    private static final RString 仮算定データ = new RString("仮算定データ");
    private static final RString 項目名付加キー = new RString("項目名付加");
    private static final RString 連番付加キー = new RString("連番付加");
    private static final RString 日付編集キー = new RString("日付編集");
    private static final int 調定年度を含めて8年分 = 8;
    private static final int VALUE = 1988;
    private static final RString KEY_抽出区分 = new RString("抽出区分");
    private static final RString KEY_データ区分 = new RString("データ区分");
    private static final RString KEY_データ種類 = new RString("データ種類");
    private static final RString KEY_対象年度 = new RString("対象年度");
    private static final RString KEY_受取年月FROM = new RString("受取年月From");
    private static final RString KEY_受取年月TO = new RString("受取年月To");
    private static final RString KEY_送付年月FROM = new RString("送付年月From");
    private static final RString KEY_送付年月TO = new RString("送付年月To");
    private static final RString KEY_項目名付加 = new RString("項目名付加");
    private static final RString KEY_連番付加 = new RString("連番付加");
    private static final RString KEY_日付スラッシュ付加 = new RString("日付スラッシュ付加");
    private static final RString KEY_保険者コード = new RString("保険者コード");
    private static final RString KEY_出力順 = new RString("出力順");
    private static final RString KEY_出力項目 = new RString("出力項目");

    /**
     * コンストラクタです。
     *
     * @param div HanyoListkougakugasSannKeiSuukekkaDiv
     */
    public HanyoListkougakugasSannKeiSuukekkaHandler(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     */
    public void initialize() {
        RDate nowdate = RDate.getNowDate();
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = shichosonSecurityJoho.get導入形態コード();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
        } else {
            div.getChushutsuJokenPanel().getTxtUketoriNengetsu().setDisplayNone(false);
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setDisplayNone(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisabled(true);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setVisible(false);
        }

        div.getCcdShutsuryokuKoumoku().setDisabled(true);
        div.getCcdShutsuryokuKoumoku().setDisplayNone(true);
        div.getCcdShutsuryokuKoumoku().setCanOpenAndClose(false);

        List<RString> keyList = new ArrayList<>();
        keyList.add(項目名付加キー);
        keyList.add(日付編集キー);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(keyList);

        RDate 日付関連_当初年度
                = new RDate(DbBusinessConfig.get(ConfigNameDBB.日付関連_当初年度, nowdate, SubGyomuCode.DBB介護賦課).toString());
        RDate 日付関連_調定年度
                = new RDate(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowdate, SubGyomuCode.DBB介護賦課).toString());
        List<KeyValueDataSource> datasource = new ArrayList<>();
        datasource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        datasource.add(new KeyValueDataSource(日付関連_調定年度.toDateString(), 日付関連_調定年度.getYear().wareki().toDateString()));
        for (int i = 0; i < 調定年度を含めて8年分; i++) {
            if (日付関連_当初年度.isBefore(日付関連_調定年度)) {
                日付関連_調定年度 = 日付関連_調定年度.minusYear(NUM_1);
                datasource.add(
                        new KeyValueDataSource(日付関連_調定年度.getYear().toDateString(), 日付関連_調定年度.getYear().wareki().toDateString()));
            } else {
                break;
            }
        }
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setDataSource(datasource);

        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701016.getReportId());
        div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701016.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付);

    }

    /**
     * 条件を復元するボタンのメソッドです。
     */
    public void 条件を復元() {

        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_抽出区分);
        if (RString.isNullOrEmpty(抽出区分)) {
            div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedValue(すべて);
        } else {
            div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedValue(最新履歴);
        }
        RString データ区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_データ区分);
        if (RString.isNullOrEmpty(データ区分)) {
            div.getChushutsuJokenPanel().getDdlDetaKubun().setSelectedValue(すべて);
        } else if (Kaigogassan_DataKubun.国保連作成.getコード().equals(データ区分)) {
            div.getChushutsuJokenPanel().getDdlDetaKubun().setSelectedValue(国保連作成);
        } else if (Kaigogassan_DataKubun.保険者作成.getコード().equals(データ区分)) {
            div.getChushutsuJokenPanel().getDdlDetaKubun().setSelectedValue(保険者作成);
        }
        setChange();
        RString データ種類 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_データ種類);
        if (RString.isNullOrEmpty(データ種類)) {
            div.getChushutsuJokenPanel().getRadDataShurui().setSelectedValue(すべて);
        } else if (Kaigogassan_DataShubetsu.通常.getコード().equals(データ種類)) {
            div.getChushutsuJokenPanel().getRadDataShurui().setSelectedValue(通常データ);
        } else if (Kaigogassan_DataShubetsu.仮算定.getコード().equals(データ種類)) {
            div.getChushutsuJokenPanel().getRadDataShurui().setSelectedValue(仮算定データ);
        }
        FlexibleYear 対象年度 = restoreBatchParameterMap.getParameterValue(FlexibleYear.class, KEY_対象年度);
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setSelectedKey(対象年度.toDateString());
        FlexibleYearMonth 受取年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_受取年月FROM);
        FlexibleYearMonth 受取年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_受取年月TO);
        FlexibleYearMonth 送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_送付年月FROM);
        FlexibleYearMonth 送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_送付年月TO);
        div.getChushutsuJokenPanel().getTxtUketoriNengetsu().clearFromValue();
        if (受取年月From != null && !受取年月From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtUketoriNengetsu().setFromValue(new RDate(受取年月From.toString()));
        }
        div.getChushutsuJokenPanel().getTxtUketoriNengetsu().clearToValue();
        if (受取年月To != null && !受取年月To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtUketoriNengetsu().setToValue(new RDate(受取年月To.toString()));
        }
        div.getChushutsuJokenPanel().getTxtSofuNengetsu().clearFromValue();
        if (送付年月From != null && !送付年月From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setFromValue(new RDate(送付年月From.toString()));
        }
        div.getChushutsuJokenPanel().getTxtSofuNengetsu().clearToValue();
        if (送付年月To != null && !送付年月To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setToValue(new RDate(送付年月To.toString()));
        }
        条件を復元Part2(restoreBatchParameterMap);

    }

    private void 条件を復元Part2(BatchParameterMap restoreBatchParameterMap) {
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_項目名付加);
        List<RString> 編集方法list = new ArrayList<>();
        if (項目名付加) {
            編集方法list.add(項目名付加キー);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_連番付加);
        if (連番付加) {
            編集方法list.add(連番付加キー);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_日付スラッシュ付加);
        if (日付スラッシュ付加) {
            編集方法list.add(日付編集キー);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法list);
        LasdecCode 保険者コード = restoreBatchParameterMap.getParameterValue(LasdecCode.class, KEY_保険者コード);
        div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
        if (保険者コード != null && !保険者コード.isEmpty()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(保険者コード);
        }
        Long 出力順 = restoreBatchParameterMap.getParameterValue(Long.class, KEY_出力順);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701016.getReportId(), 出力順);
        RString 出力項目 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_出力項目);
        if (RString.isNullOrEmpty(出力項目)) {
            div.getCcdShutsuryokuKoumoku().setDisabled(true);
        } else {
            div.getCcdShutsuryokuKoumoku().setDisabled(false);
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701016.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付, 出力項目);
        }

    }

    /**
     * 抽出条件画面項目の制御のメソッドです。
     */
    public void setChange() {
        RString データ区分 = div.getChushutsuJokenPanel().getDdlDetaKubun().getSelectedValue();
        if (すべて.equals(データ区分)) {
            List<KeyValueDataSource> datasource = new ArrayList<>();
            datasource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getChushutsuJokenPanel().getRadDataShurui().setDisabledItem(datasource);
            div.getChushutsuJokenPanel().getRadDataShurui().setDisabled(false);
            div.getChushutsuJokenPanel().getTxtUketoriNengetsu().setDisabled(false);
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setDisabled(false);
            div.getChushutsuJokenPanel().getRadDataShurui().setSelectedKey(KEY_1);
        } else if (保険者作成.equals(データ区分)) {
            List<KeyValueDataSource> datasource = new ArrayList<>();
            datasource.add(new KeyValueDataSource(KEY_0, すべて));
            datasource.add(new KeyValueDataSource(KEY_2, 仮算定データ));
            div.getChushutsuJokenPanel().getRadDataShurui().setDisabledItem(datasource);
            div.getChushutsuJokenPanel().getRadDataShurui().setSelectedKey(KEY_1);
            div.getChushutsuJokenPanel().getTxtUketoriNengetsu().setDisabled(true);
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setDisabled(false);
        } else if (国保連作成.equals(データ区分)) {
            List<KeyValueDataSource> datasource = new ArrayList<>();
            datasource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getChushutsuJokenPanel().getRadDataShurui().setDisabledItem(datasource);
            div.getChushutsuJokenPanel().getRadDataShurui().setDisabled(false);
            div.getChushutsuJokenPanel().getTxtUketoriNengetsu().setDisabled(false);
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setDisabled(true);
            div.getChushutsuJokenPanel().getRadDataShurui().setSelectedKey(KEY_1);
        }
    }

    /**
     * バッチパラメータの編集のメソッドです。
     *
     * @return parameter DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter
     */
    public DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter createBatchParameter() {
        DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter parameter
                = new DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter();
        RString 抽出区分 = div.getChushutsuJokenPanel().getRadChushutsuKubun().getSelectedValue();
        if (すべて.equals(抽出区分)) {
            parameter.set抽出区分(null);
        } else {
            parameter.set抽出区分(Kaigogassan_ChushutsuKubun.直近.getコード());
        }

        RString データ区分 = div.getChushutsuJokenPanel().getDdlDetaKubun().getSelectedValue();
        if (すべて.equals(データ区分)) {
            parameter.setデータ区分(null);
        } else if (国保連作成.equals(データ区分)) {
            parameter.setデータ区分(Kaigogassan_DataKubun.国保連作成.getコード());
        } else if (保険者作成.equals(データ区分)) {
            parameter.setデータ区分(Kaigogassan_DataKubun.保険者作成.getコード());
        }

        RString データ種類 = div.getChushutsuJokenPanel().getRadDataShurui().getSelectedValue();
        if (すべて.equals(データ種類)) {
            parameter.setデータ種類(null);
        } else if (通常データ.equals(データ種類)) {
            parameter.setデータ種類(Kaigogassan_DataShubetsu.通常.getコード());
        } else if (仮算定データ.equals(データ種類)) {
            parameter.setデータ種類(Kaigogassan_DataShubetsu.仮算定.getコード());
        }

        if (!div.getChushutsuJokenPanel().getDdlTaishoNendo().getSelectedValue().isEmpty()) {
            RString 年度 = div.getChushutsuJokenPanel().getDdlTaishoNendo().getSelectedValue();
            RString 対象年度
                    = new RString(Integer.parseInt(Pattern.compile(new RString("[^0-9]").toString()).matcher(年度).replaceAll("").trim()) + VALUE);
            parameter.set対象年度(new FlexibleYear(対象年度));
        }

        set送付_受取年月(parameter);

        List<RString> keyList = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        if (keyList.contains(項目名付加キー)) {
            parameter.set項目名付加(true);
        } else {
            parameter.set項目名付加(false);
        }

        if (keyList.contains(連番付加キー)) {
            parameter.set連番付加(true);
        } else {
            parameter.set連番付加(false);
        }

        if (keyList.contains(日付編集キー)) {
            parameter.set日付スラッシュ付加(true);
        } else {
            parameter.set日付スラッシュ付加(false);
        }
        if (div.getChushutsuJokenPanel().getCcdHokenshaList().isVisible()) {
            parameter.set保険者コード(div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード());
        }

        parameter.set出力順(div.getCcdShutsuryokujun().get出力順ID());
        if (!div.getCcdShutsuryokuKoumoku().isDisabled()) {
            parameter.set出力項目(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        } else {
            parameter.set出力項目(null);
        }
        return parameter;
    }

    private void set送付_受取年月(DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter parameter) {
        TextBoxDateRange 受取年月 = div.getChushutsuJokenPanel().getTxtUketoriNengetsu();
        if (受取年月.isDisabled()) {
            parameter.set受取年月From(FlexibleYearMonth.EMPTY);
            parameter.set受取年月To(FlexibleYearMonth.EMPTY);
        } else {
            if (受取年月.getFromValue() != null) {
                RString 年月From = 受取年月.getFromValue().getYearMonth().toDateString();
                parameter.set受取年月From(new FlexibleYearMonth(年月From));
            }
            if (受取年月.getToValue() != null) {
                RString 年月To = 受取年月.getToValue().getYearMonth().toDateString();
                parameter.set受取年月To(new FlexibleYearMonth(年月To));
            }
        }

        TextBoxDateRange 送付年月 = div.getChushutsuJokenPanel().getTxtSofuNengetsu();
        if (送付年月.isDisabled()) {
            parameter.set送付年月From(FlexibleYearMonth.EMPTY);
            parameter.set送付年月To(FlexibleYearMonth.EMPTY);
        } else {
            if (送付年月.getFromValue() != null) {
                RString 送付From = 送付年月.getFromValue().getYearMonth().toDateString();
                parameter.set送付年月From(new FlexibleYearMonth(送付From));
            }
            if (送付年月.getToValue() != null) {
                RString 送付To = 送付年月.getToValue().getYearMonth().toDateString();
                parameter.set送付年月To(new FlexibleYearMonth(送付To));
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7140001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710140.DBC710140_HanyoListKogakuGassanShinseishoJohoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiJokyoKbn;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.HanyoListParamForKougakuDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト出力(高額合算申請書情報)のHandlerです。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public class HanyoListParamForKougakuHandler {

    private final HanyoListParamForKougakuDiv div;
    private static final RString BLANK = new RString("0");
    private static final RString すべて = new RString("すべて");
    private static final RString 項目名付加 = new RString("1");
    private static final RString 連番付加 = new RString("2");
    private static final RString 日付 = new RString("3");
    private static final int 調定年度を含めて8年分 = 8;
    private static final int INDEX_ゼロ = 0;
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString KEY_CHUSHUTSU_KUBUN = new RString("chushutsuKubun");
    private static final RString KEY_KAIGOGASSAN_KUBUN = new RString("kaigoGassanShinseiJokyoKubun");
    private static final RString KEY_FLEXIBLE_YEAR = new RString("flexibleYear");
    private static final RString KEY_FLEXIBLE_DATE_FROM = new RString("flexibleDateFrom");
    private static final RString KEY_FLEXIBLE_DATE_TO = new RString("flexibleDateTo");
    private static final RString KEY_SHIKYU_FROM = new RString("shikyuShinseishoSeiriNoFrom");
    private static final RString KEY_SHIKYU_TO = new RString("shikyuShinseishoSeiriNoTo");
    private static final RString KEY_FLEXIBLE_FROM = new RString("flexibleYearMonthFrom");
    private static final RString KEY_FLEXIBLE_TO = new RString("flexibleYearMonthTo");
    private static final RString KEY_TOMOKUME_FUKA = new RString("tomokumeFuka");
    private static final RString KEY_REBAN_FUKA = new RString("rebanFuka");
    private static final RString KEY_SLASH_DATE = new RString("slashDate");
    private static final RString KEY_HOKENSHA_NO = new RString("hokenshaNo");
    private static final RString KEY_SHUTSURYOKUJU = new RString("shutsuryokuju");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト出力(高額合算申請書情報)画面のdiv
     */
    public HanyoListParamForKougakuHandler(HanyoListParamForKougakuDiv div) {
        this.div = div;
    }

    /**
     * initializeの初期化メソッドです。
     *
     */
    public void initialize() {
        ShichosonSecurityJoho 市町村セキュリティ情報
                = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        ChushutsuJokenPanelDiv panel = div.getChushutsuJokenPanel();
        if (null != 市町村セキュリティ情報) {
            if (市町村セキュリティ情報.get導入形態コード() != null
                    && 市町村セキュリティ情報.get導入形態コード().is広域()) {
                panel.getCcdHokenshaList().setDisplayNone(false);
                panel.getCcdHokenshaList().loadHokenshaList();
            } else {
                panel.getCcdHokenshaList().setDisabled(true);
                panel.getCcdHokenshaList().setVisible(false);
                panel.getCcdHokenshaList().setDisplayNone(true);
            }
        }
        div.getCcdShutsuryokuKoumoku().setDisabled(true);
        List<RString> keyList = new ArrayList<>();
        keyList.add(項目名付加);
        keyList.add(日付);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(keyList);
        panel.getDdlSinseiJokyoKubun().setDataSource(get申請状況区分リスト());
        panel.getDdlSinseiJokyoKubun().setSelectedIndex(INDEX_ゼロ);
        set調定年度();
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     */
    public void pamaRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        restoreClear();
        pamaRestore2(restoreBatchParameterMap);
        FlexibleDate 送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_FLEXIBLE_FROM);
        if (送付年月From != null && !送付年月From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setFromValue(new RDate(送付年月From.toString()));
        }
        FlexibleDate 送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_FLEXIBLE_TO);
        if (送付年月To != null && !送付年月To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSofuNengetsu().setToValue(new RDate(送付年月To.toString()));
        }
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_TOMOKUME_FUKA);
        if (項目名付加) {
            csv編集方法リスト.add(ONE);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_REBAN_FUKA);
        if (連番付加) {
            csv編集方法リスト.add(TWO);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_SLASH_DATE);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(THREE);
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        Long 出力順 = restoreBatchParameterMap.getParameterValue(Long.class, KEY_SHUTSURYOKUJU);
        if (出力順 != null) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701014.getReportId(), 出力順);
        }
        RString 保険者コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_HOKENSHA_NO);
        if (保険者コード != null && !保険者コード.isEmpty()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(new LasdecCode(保険者コード));
        }
    }

    private void pamaRestore2(BatchParameterMap restoreBatchParameterMap) throws IllegalArgumentException {
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_CHUSHUTSU_KUBUN);
        if (抽出区分 != null) {
            if (ONE.equals(抽出区分)) {
                div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedKey(KEY1);
            } else {
                div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedKey(KEY0);
            }
        }
        RString 申請状況区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_KAIGOGASSAN_KUBUN);
        if (申請状況区分 != null && !申請状況区分.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlSinseiJokyoKubun().setSelectedKey(申請状況区分);
        }
        RString 対象年度 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_FLEXIBLE_YEAR);
        if (対象年度 != null && !対象年度.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlTaishoNendo().setSelectedKey(対象年度);
        }
        FlexibleDate 申請年月日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_FLEXIBLE_DATE_FROM);
        if (申請年月日From != null && !申請年月日From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSinseibi().setFromValue(new RDate(申請年月日From.toString()));
        }
        FlexibleDate 申請年月日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_FLEXIBLE_DATE_TO);
        if (申請年月日To != null && !申請年月日To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSinseibi().setToValue(new RDate(申請年月日To.toString()));
        }
        RString 支給申請書整理番号From = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SHIKYU_FROM);
        if (支給申請書整理番号From != null && !支給申請書整理番号From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoKaishi().setValue(支給申請書整理番号From);
        }
        RString 支給申請書整理番号To = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SHIKYU_TO);
        if (支給申請書整理番号To != null && !支給申請書整理番号To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoShuryo().setValue(支給申請書整理番号To);
        }
    }

    private void restoreClear() {

        div.getDdlSinseiJokyoKubun().setSelectedValue(すべて);
        div.getDdlTaishoNendo().setSelectedKey(BLANK);
        div.getChushutsuJokenPanel().getRadChushutsuKubun().clearSelectedItem();
        div.getChushutsuJokenPanel().getTxtSinseibi().clearFromValue();
        div.getChushutsuJokenPanel().getTxtSinseibi().clearToValue();
        div.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoKaishi().clearValue();
        div.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoShuryo().clearValue();
        div.getChushutsuJokenPanel().getTxtSofuNengetsu().clearFromValue();
        div.getChushutsuJokenPanel().getTxtSofuNengetsu().clearToValue();
        div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return DBC710140_HanyoListKogakuGassanShinseishoJohoParameter 汎用リスト出力(高額合算申請書情報)_バッチパラメータクラスです
     */
    public DBC710140_HanyoListKogakuGassanShinseishoJohoParameter getBatchParamter() {

        DBC710140_HanyoListKogakuGassanShinseishoJohoParameter batchparam = new DBC710140_HanyoListKogakuGassanShinseishoJohoParameter();
        if (すべて.equals(div.getRadChushutsuKubun().getSelectedValue())) {
            batchparam.setChushutsuKubun(RString.EMPTY);
        } else if (KEY1.equals(div.getRadChushutsuKubun().getSelectedKey())) {
            batchparam.setChushutsuKubun(ONE);
        }
        if (すべて.equals(div.getDdlSinseiJokyoKubun().getSelectedValue())) {
            batchparam.setKaigoGassanShinseiJokyoKubun(RString.EMPTY);
        } else {
            batchparam.setKaigoGassanShinseiJokyoKubun(div.getDdlSinseiJokyoKubun().getSelectedKey());
        }
        if (!BLANK.equals(div.getDdlTaishoNendo().getSelectedKey())) {
            batchparam.setFlexibleYear(div.getDdlTaishoNendo().getSelectedKey());
        } else {
            batchparam.setFlexibleYear(null);
        }
        if (null != div.getTxtSinseibi().getFromValue()) {
            batchparam.setFlexibleDateFrom(new FlexibleDate(div.getTxtSinseibi().getFromValue().toString()));
        }
        if (null != div.getTxtSinseibi().getToValue()) {
            batchparam.setFlexibleDateTo(new FlexibleDate(div.getTxtSinseibi().getToValue().toString()));
        }
        if (null != div.getTxtSikyuSinseishoSeiriBangoKaishi()) {
            batchparam.setShikyuShinseishoSeiriNoFrom(div.getTxtSikyuSinseishoSeiriBangoKaishi().getValue());
        }
        if (null != div.getTxtSikyuSinseishoSeiriBangoShuryo()) {
            batchparam.setShikyuShinseishoSeiriNoTo(div.getTxtSikyuSinseishoSeiriBangoShuryo().getValue());
        }
        if (null != div.getTxtSofuNengetsu().getFromValue()) {
            batchparam.setFlexibleYearMonthFrom(new FlexibleYearMonth(div.getTxtSofuNengetsu().getFromValue().getYearMonth().toString()));
        }
        if (null != div.getTxtSofuNengetsu().getToValue()) {
            batchparam.setFlexibleYearMonthTo(new FlexibleYearMonth(div.getTxtSofuNengetsu().getToValue().getYearMonth().toString()));
        }
        List<RString> selectKey = div.getChkCsvHenshuHoho().getSelectedKeys();
        if (selectKey.contains(項目名付加)) {
            batchparam.setTomokumeFuka(true);
        } else {
            batchparam.setTomokumeFuka(false);
        }
        if (selectKey.contains(連番付加)) {
            batchparam.setRebanFuka(true);
        } else {
            batchparam.setRebanFuka(false);
        }
        if (selectKey.contains(日付)) {
            batchparam.setSlashDate(true);
        } else {
            batchparam.setSlashDate(false);
        }
        if (div.getChushutsuJokenPanel().getCcdHokenshaList().isVisible()) {
            batchparam.setHokenshaNo(div.getCcdHokenshaList().getSelectedItem().get市町村コード().getColumnValue());
        }
        if (null != div.getCcdShutsuryokujun().getSelected出力順()) {
            batchparam.setShutsuryokuju(div.getCcdShutsuryokujun().getSelected出力順().get出力順ID());
        }
        if (null != div.getCcdShutsuryokuKoumoku()) {
            batchparam.setShutsuryokuTomoku(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        } else {
            batchparam.setShutsuryokuTomoku(RString.EMPTY);
        }
        return batchparam;
    }

    private void set調定年度() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RDate rDate = RDate.getNowDate();
        RYear 日付関連_当初年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_当初年度,
                rDate, SubGyomuCode.DBB介護賦課).toString());
        RYear 日付関連_調定年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                rDate, SubGyomuCode.DBB介護賦課).toString());
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(BLANK, RString.EMPTY);
        dataSourceList.add(dataSourceBlank);
        for (int i = 日付関連_調定年度.getYearValue(); 日付関連_当初年度.getYearValue() <= i; i--) {
            if (i <= 日付関連_調定年度.getYearValue() - 調定年度を含めて8年分) {
                break;
            }
            KeyValueDataSource 調定年度Key = new KeyValueDataSource();
            調定年度Key.setKey(new RString(String.valueOf(i)));
            調定年度Key.setValue(new RYear(String.valueOf(i)).wareki().toDateString());
            dataSourceList.add(調定年度Key);
        }
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setDataSource(dataSourceList);
    }

    private List<KeyValueDataSource> get申請状況区分リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(BLANK, すべて);
        dataSourceList.add(dataSourceBlank);
        for (KaigoGassan_ShinseiJokyoKbn 申請状況区分 : KaigoGassan_ShinseiJokyoKbn.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請状況区分.getコード(), 申請状況区分.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

}

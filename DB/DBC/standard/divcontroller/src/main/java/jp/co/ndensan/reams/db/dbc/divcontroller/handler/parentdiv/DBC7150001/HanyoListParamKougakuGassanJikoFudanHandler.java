/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7150001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710150.DBC710150_HanyoListKogakuGassanJikoFutangakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001.HanyoListParamKougakuGassanJikoFudanDiv;
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
 * 汎用リスト(高額合算自己負担額情報)のHandlerです。
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class HanyoListParamKougakuGassanJikoFudanHandler {

    private final HanyoListParamKougakuGassanJikoFudanDiv div;
    private static final RString 国保連取込情報 = new RString("国保連取込情報");
    private static final RString 処理時作成_申請書有 = new RString("証明書計算処理時作成（申請書有）");
    private static final RString 処理時作成_全受給者 = new RString("証明書計算処理時作成（全受給者）");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString BLANK = new RString("0");
    private static final RString 仮算定データ = new RString("仮算定データ");
    private static final RString すべて = new RString("すべて");
    private static final RString 項目名付加 = new RString("1");
    private static final RString 連番付加 = new RString("2");
    private static final RString 日付 = new RString("3");
    private static final int 含めて8年分 = 8;
    private static final int INDEX_ゼロ = 0;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString KEY_CHUSHUTSU_KUBUN = new RString("chushutsuKubun");
    private static final RString KEY_DETA_SAKUSEI_KUBUN = new RString("detaSakuseiKubun");
    private static final RString KEY_DATA_SHURUI = new RString("dataShurui");
    private static final RString KEY_HOSEU_JOKYO = new RString("hoseuJokyo");
    private static final RString KEY_FLEXIBLE_YEAR = new RString("flexibleYear");
    private static final RString KEY_FLEXIBLE_DATE_FROM = new RString("flexibleDateFrom");
    private static final RString KEY_FLEXIBLE_DATE_TO = new RString("flexibleDateTo");
    private static final RString KEY_SHIKYU_FROM = new RString("shikyuShinseishoSeiriNoFrom");
    private static final RString KEY_SHIKYU_TO = new RString("shikyuShinseishoSeiriNoTo");
    private static final RString KEY_SOFU_TAISHOGAI_FUKUMU = new RString("sofuTaishogaiFukumu");
    private static final RString KEY_JIKO_FROM = new RString("jikoFutangakuKakuninFrom");
    private static final RString KEY_JIKO_TO = new RString("sofuTaishogaiFukumuTo");
    private static final RString KEY_HOSEIZUMI_FROM = new RString("hoseizumiJikoFutangakuFrom");
    private static final RString KEY_HOSEIZUMI_TO = new RString("hoseizumiJikoFutangakuTo");
    private static final RString KEY_JIKO_FUTANNGAKU_FROM = new RString("jikoFutanngakuShoumeishoFrom");
    private static final RString KEY_JIKO_FUTANNGAKU_TO = new RString("jikoFutanngakuShoumeishoTo");
    private static final RString KEY_TOMOKUME_FUKA = new RString("tomokumeFuka");
    private static final RString KEY_REBAN_FUKA = new RString("rebanFuka");
    private static final RString KEY_SLASH_DATE = new RString("slashDate");
    private static final RString KEY_HOKENSHA_NO = new RString("hokenshaNo");
    private static final RString KEY_SHUTSURYOKUJU = new RString("shutsuryokuju");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト(高額合算自己負担額情報)画面のdiv
     */
    public HanyoListParamKougakuGassanJikoFudanHandler(HanyoListParamKougakuGassanJikoFudanDiv div) {
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
        div.getCcdShutsuryokuKoumoku().setDisplayNone(true);
        List<RString> keyList = new ArrayList<>();
        keyList.add(項目名付加);
        keyList.add(日付);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(keyList);
        panel.getDdlDetaSakuseiKubun().setDataSource(getデータ作成区分());
        div.getChushutsuJokenPanel().getDdlDetaSakuseiKubun().setSelectedIndex(INDEX_ゼロ);
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
        pamaRestore3(restoreBatchParameterMap);
        pamaRestore4(restoreBatchParameterMap);
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加1 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_TOMOKUME_FUKA);
        if (項目名付加1) {
            csv編集方法リスト.add(ONE);
        }
        boolean 連番付加1 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_REBAN_FUKA);
        if (連番付加1) {
            csv編集方法リスト.add(TWO);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_SLASH_DATE);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(THREE);
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        Long 出力順 = restoreBatchParameterMap.getParameterValue(Long.class, KEY_SHUTSURYOKUJU);
        if (出力順 != null) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701015.getReportId(), 出力順);
        }
        RString 保険者コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_HOKENSHA_NO);
        if (保険者コード != null && !保険者コード.isEmpty()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(new LasdecCode(保険者コード));
        }
        getEditDdlDetaSakuseiKubun();
    }

    private void pamaRestore4(BatchParameterMap restoreBatchParameterMap) throws IllegalArgumentException {
        FlexibleDate 自己負担額確認情報受取年月From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_JIKO_FROM);
        if (自己負担額確認情報受取年月From != null && !自己負担額確認情報受取年月From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtJikoFutangakuKakunin().setFromValue(new RDate(自己負担額確認情報受取年月From.toString()));
        }
        FlexibleDate 自己負担額確認情報受取年月To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_JIKO_TO);
        if (自己負担額確認情報受取年月To != null && !自己負担額確認情報受取年月To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtJikoFutangakuKakunin().setToValue(new RDate(自己負担額確認情報受取年月To.toString()));
        }
        FlexibleDate 補正済自己負担額情報送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_HOSEIZUMI_FROM);
        if (補正済自己負担額情報送付年月From != null && !補正済自己負担額情報送付年月From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtHoseizumiJikoFutangaku().setFromValue(new RDate(補正済自己負担額情報送付年月From.toString()));
        }
        FlexibleDate 補正済自己負担額情報送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_HOSEIZUMI_TO);
        if (補正済自己負担額情報送付年月To != null && !補正済自己負担額情報送付年月To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtHoseizumiJikoFutangaku().setToValue(new RDate(補正済自己負担額情報送付年月To.toString()));
        }
        FlexibleDate 自己負担額証明書情報受取年月From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_JIKO_FUTANNGAKU_FROM);
        if (自己負担額証明書情報受取年月From != null && !自己負担額証明書情報受取年月From.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtJikoFutanngakuShoumeisho().setFromValue(new RDate(自己負担額証明書情報受取年月From.toString()));
        }
        FlexibleDate 自己負担額証明書情報受取年月To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_JIKO_FUTANNGAKU_TO);
        if (自己負担額証明書情報受取年月To != null && !自己負担額証明書情報受取年月To.isEmpty()) {
            div.getChushutsuJokenPanel().getTxtJikoFutanngakuShoumeisho().setToValue(new RDate(自己負担額証明書情報受取年月To.toString()));
        }
    }

    private void pamaRestore3(BatchParameterMap restoreBatchParameterMap) throws IllegalArgumentException {
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
        List<RString> 送付対象外リスト = new ArrayList<>();
        boolean 送付対象外 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_SOFU_TAISHOGAI_FUKUMU);
        if (送付対象外) {
            送付対象外リスト.add(KEY0);
        }
        div.getChushutsuJokenPanel().getChkSofuTaishogaiFukumu().setSelectedItemsByKey(送付対象外リスト);
    }

    private void pamaRestore2(BatchParameterMap restoreBatchParameterMap) {
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_CHUSHUTSU_KUBUN);
        if (抽出区分 != null) {
            if (ONE.equals(抽出区分)) {
                div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedKey(KEY1);
            } else {
                div.getChushutsuJokenPanel().getRadChushutsuKubun().setSelectedKey(KEY0);
            }
        }
        RString データ作成区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_DETA_SAKUSEI_KUBUN);
        if (データ作成区分 != null && !データ作成区分.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlDetaSakuseiKubun().setSelectedKey(データ作成区分);
        }
        RString データ種類 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_DATA_SHURUI);
        if (データ種類 != null) {
            if (ONE.equals(データ種類)) {
                div.getChushutsuJokenPanel().getRadDataShurui().setSelectedKey(KEY1);
            } else if (TWO.equals(データ種類)) {
                div.getChushutsuJokenPanel().getRadDataShurui().setSelectedKey(KEY2);
            } else {
                div.getChushutsuJokenPanel().getRadDataShurui().setSelectedKey(KEY0);
            }
        }
        RString 補正状況 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_HOSEU_JOKYO);
        if (補正状況 != null) {
            if (ONE.equals(補正状況)) {
                div.getChushutsuJokenPanel().getRadHoseuJokyo().setSelectedKey(KEY1);
            } else if (TWO.equals(補正状況)) {
                div.getChushutsuJokenPanel().getRadHoseuJokyo().setSelectedKey(KEY2);
            } else {
                div.getChushutsuJokenPanel().getRadHoseuJokyo().setSelectedKey(KEY0);
            }
        }
    }

    private void restoreClear() {
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setSelectedKey(BLANK);
        div.getDdlDetaSakuseiKubun().setSelectedValue(すべて);
        div.getChushutsuJokenPanel().getRadChushutsuKubun().clearSelectedItem();
        div.getChushutsuJokenPanel().getRadDataShurui().clearSelectedItem();
        div.getChushutsuJokenPanel().getRadHoseuJokyo().clearSelectedItem();
        div.getChushutsuJokenPanel().getTxtSinseibi().clearFromValue();
        div.getChushutsuJokenPanel().getTxtSinseibi().clearToValue();
        div.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoKaishi().clearValue();
        div.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoShuryo().clearValue();
        div.getChushutsuJokenPanel().getTxtJikoFutangakuKakunin().clearFromValue();
        div.getChushutsuJokenPanel().getTxtJikoFutangakuKakunin().clearToValue();
        div.getChushutsuJokenPanel().getTxtHoseizumiJikoFutangaku().clearFromValue();
        div.getChushutsuJokenPanel().getTxtHoseizumiJikoFutangaku().clearToValue();
        div.getChushutsuJokenPanel().getTxtJikoFutanngakuShoumeisho().clearFromValue();
        div.getChushutsuJokenPanel().getTxtJikoFutanngakuShoumeisho().clearToValue();
        div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();

    }

    /**
     * 「選択」ボタンを押すの場合
     */
    public void getEditDdlDetaSakuseiKubun() {
        if (すべて.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
            List<KeyValueDataSource> disabledItems = new ArrayList<>();
            div.getRadDataShurui().setDisabledItem(disabledItems);
            div.getTxtJikoFutangakuKakunin().setDisabled(false);
            div.getTxtHoseizumiJikoFutangaku().setDisabled(false);
            div.getTxtJikoFutanngakuShoumeisho().setDisabled(false);
        }
        if (国保連取込情報.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
            List<KeyValueDataSource> disabledItems = new ArrayList<>();
            div.getRadDataShurui().setDisabledItem(disabledItems);
            div.getTxtJikoFutangakuKakunin().setDisabled(false);
            div.getTxtHoseizumiJikoFutangaku().setDisabled(true);
            div.getTxtJikoFutanngakuShoumeisho().setDisabled(false);
        }
        if (処理時作成_申請書有.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
            List<KeyValueDataSource> disabledItems = new ArrayList<>();
            disabledItems.add(new KeyValueDataSource(KEY0, すべて));
            disabledItems.add(new KeyValueDataSource(KEY2, 仮算定データ));
            div.getRadDataShurui().setDisabledItem(disabledItems);
            div.getRadDataShurui().setSelectedKey(KEY1);
            div.getTxtJikoFutangakuKakunin().setDisabled(true);
            div.getTxtHoseizumiJikoFutangaku().setDisabled(false);
            div.getTxtJikoFutanngakuShoumeisho().setDisabled(true);
        }
        if (処理時作成_全受給者.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
            List<KeyValueDataSource> disabledItems = new ArrayList<>();
            disabledItems.add(new KeyValueDataSource(KEY0, すべて));
            disabledItems.add(new KeyValueDataSource(KEY2, 仮算定データ));
            div.getRadDataShurui().setDisabledItem(disabledItems);
            div.getRadDataShurui().setSelectedKey(KEY1);
            div.getTxtJikoFutangakuKakunin().setDisabled(true);
            div.getTxtHoseizumiJikoFutangaku().setDisabled(false);
            div.getTxtJikoFutanngakuShoumeisho().setDisabled(true);
        }
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return DBC710150_HanyoListKogakuGassanJikoFutangakuParameter 汎用リスト(高額合算自己負担額情報))_バッチパラメータクラスです
     */
    public DBC710150_HanyoListKogakuGassanJikoFutangakuParameter getBatchParamter() {

        DBC710150_HanyoListKogakuGassanJikoFutangakuParameter batchparam = new DBC710150_HanyoListKogakuGassanJikoFutangakuParameter();
        if (すべて.equals(div.getRadChushutsuKubun().getSelectedValue())) {
            batchparam.setChushutsuKubun(RString.EMPTY);
        } else if (KEY1.equals(div.getRadChushutsuKubun().getSelectedKey())) {
            batchparam.setChushutsuKubun(ONE);
        }
        if (すべて.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
            batchparam.setDetaSakuseiKubun(RString.EMPTY);
        } else {
            batchparam.setDetaSakuseiKubun(div.getDdlDetaSakuseiKubun().getSelectedKey());
        }
        if (すべて.equals(div.getRadDataShurui().getSelectedValue())) {
            batchparam.setDataShurui(RString.EMPTY);
        } else if (KEY1.equals(div.getRadDataShurui().getSelectedKey())) {
            batchparam.setDataShurui(ONE);
        } else if (KEY2.equals(div.getRadDataShurui().getSelectedKey())) {
            batchparam.setDataShurui(TWO);
        }
        batchparam = setFlexibleDate(batchparam);
        batchparam = setChkCsvHenshuHoho(batchparam);
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

    private DBC710150_HanyoListKogakuGassanJikoFutangakuParameter setFlexibleDate(DBC710150_HanyoListKogakuGassanJikoFutangakuParameter batchparam) {
        if (すべて.equals(div.getRadHoseuJokyo().getSelectedValue())) {
            batchparam.setHoseuJokyo(RString.EMPTY);
        } else if (KEY1.equals(div.getRadHoseuJokyo().getSelectedKey())) {
            batchparam.setHoseuJokyo(ONE);
        } else if (KEY2.equals(div.getRadHoseuJokyo().getSelectedKey())) {
            batchparam.setHoseuJokyo(TWO);
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
        if (div.getChkSofuTaishogaiFukumu().getSelectedKeys() != null && !div.getChkSofuTaishogaiFukumu().getSelectedKeys().isEmpty()) {
            batchparam.setSofuTaishogaiFukumu(true);
        }
        return batchparam;
    }

    private DBC710150_HanyoListKogakuGassanJikoFutangakuParameter setChkCsvHenshuHoho(DBC710150_HanyoListKogakuGassanJikoFutangakuParameter batchparam) {
        if (!div.getTxtJikoFutangakuKakunin().isDisabled() && null != div.getTxtJikoFutangakuKakunin().getFromValue()) {
            batchparam.setJikoFutangakuKakuninFrom(new FlexibleYearMonth(div.getTxtJikoFutangakuKakunin().getFromValue().getYearMonth().toString()));
        }
        if (!div.getTxtJikoFutangakuKakunin().isDisabled() && null != div.getTxtJikoFutangakuKakunin().getToValue()) {
            batchparam.setSofuTaishogaiFukumuTo(new FlexibleYearMonth(div.getTxtJikoFutangakuKakunin().getToValue().getYearMonth().toString()));
        }
        if (!div.getTxtHoseizumiJikoFutangaku().isDisabled() && null != div.getTxtHoseizumiJikoFutangaku().getFromValue()) {
            batchparam.setHoseizumiJikoFutangakuFrom(new FlexibleYearMonth(div.getTxtHoseizumiJikoFutangaku().getFromValue().getYearMonth().toString()));
        }
        if (!div.getTxtHoseizumiJikoFutangaku().isDisabled() && null != div.getTxtHoseizumiJikoFutangaku().getToValue()) {
            batchparam.setHoseizumiJikoFutangakuTo(new FlexibleYearMonth(div.getTxtHoseizumiJikoFutangaku().getToValue().getYearMonth().toString()));
        }
        if (!div.getTxtJikoFutanngakuShoumeisho().isDisabled() && null != div.getTxtJikoFutanngakuShoumeisho().getFromValue()) {
            batchparam.setJikoFutanngakuShoumeishoFrom(new FlexibleYearMonth(div.getTxtJikoFutanngakuShoumeisho().getFromValue().getYearMonth().toString()));
        }
        if (!div.getTxtJikoFutanngakuShoumeisho().isDisabled() && null != div.getTxtJikoFutanngakuShoumeisho().getToValue()) {
            batchparam.setJikoFutanngakuShoumeishoTo(new FlexibleYearMonth(div.getTxtJikoFutanngakuShoumeisho().getToValue().getYearMonth().toString()));
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
        return batchparam;
    }

    private List<KeyValueDataSource> getデータ作成区分() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(BLANK, すべて);
        dataSourceList.add(dataSourceBlank);
        for (Kaigogassan_DataSakuseiKubun データ作成 : Kaigogassan_DataSakuseiKubun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(データ作成.getコード(), データ作成.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
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
            if (i <= 日付関連_調定年度.getYearValue() - 含めて8年分) {
                break;
            }
            KeyValueDataSource 調定年度Key = new KeyValueDataSource();
            調定年度Key.setKey(new RString(String.valueOf(i)));
            調定年度Key.setValue(new RYear(String.valueOf(i)).wareki().toDateString());
            dataSourceList.add(調定年度Key);
        }
        div.getChushutsuJokenPanel().getDdlTaishoNendo().setDataSource(dataSourceList);

    }
}

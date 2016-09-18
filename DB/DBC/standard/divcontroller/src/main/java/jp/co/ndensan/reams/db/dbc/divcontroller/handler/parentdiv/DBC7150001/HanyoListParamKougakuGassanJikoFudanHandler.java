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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001.HanyoListParamKougakuGassanJikoFudanDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
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
    private static final RString 証明書計算処理時作成_申請書有 = new RString("証明書計算処理時作成（申請書有）");
    private static final RString 証明書計算処理時作成_全受給者 = new RString("証明書計算処理時作成（全受給者）");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString BLANK = new RString("0");
    private static final RString 仮算定データ = new RString("仮算定データ");
    private static final RString すべて = new RString("すべて");
    private static final RString 項目名付加 = new RString("1");
    private static final RString 連番付加 = new RString("2");
    private static final RString 日付 = new RString("3");
    private static final int 調定年度を含めて8年分 = 8;
    private static final int INDEX_ゼロ = 0;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

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
        List<RString> keyList = new ArrayList<>();
        keyList.add(項目名付加);
        keyList.add(日付);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(keyList);
        panel.getDdlDetaSakuseiKubun().setDataSource(getデータ作成区分());
        div.getChushutsuJokenPanel().getDdlDetaSakuseiKubun().setSelectedIndex(INDEX_ゼロ);
        set調定年度();
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
        if (証明書計算処理時作成_申請書有.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
            List<KeyValueDataSource> disabledItems = new ArrayList<>();
            disabledItems.add(new KeyValueDataSource(KEY0, すべて));
            disabledItems.add(new KeyValueDataSource(KEY2, 仮算定データ));
            div.getRadDataShurui().setDisabledItem(disabledItems);
            div.getRadDataShurui().setSelectedKey(KEY1);
            div.getTxtJikoFutangakuKakunin().setDisabled(true);
            div.getTxtHoseizumiJikoFutangaku().setDisabled(false);
            div.getTxtJikoFutanngakuShoumeisho().setDisabled(true);
        }
        if (証明書計算処理時作成_全受給者.equals(div.getDdlDetaSakuseiKubun().getSelectedValue())) {
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
     * @return DBC710150_HanyoListKogakuGassanJikoFutangakuParameter
     * 汎用リスト(高額合算自己負担額情報))_バッチパラメータクラスです
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

    private DBC710150_HanyoListKogakuGassanJikoFutangakuParameter setChkCsvHenshuHoho(DBC710150_HanyoListKogakuGassanJikoFutangakuParameter batchparam) {
        if (null != div.getTxtJikoFutangakuKakunin().getFromValue()) {
            batchparam.setJikoFutangakuKakuninFrom(new FlexibleYearMonth(div.getTxtJikoFutangakuKakunin().getFromValue().getYearMonth().toString()));
        }
        if (null != div.getTxtJikoFutangakuKakunin().getToValue()) {
            batchparam.setSofuTaishogaiFukumuTo(new FlexibleYearMonth(div.getTxtJikoFutangakuKakunin().getToValue().getYearMonth().toString()));
        }
        if (null != div.getTxtHoseizumiJikoFutangaku().getFromValue()) {
            batchparam.setHoseizumiJikoFutangakuFrom(new FlexibleYearMonth(div.getTxtHoseizumiJikoFutangaku().getFromValue().getYearMonth().toString()));
        }
        if (null != div.getTxtHoseizumiJikoFutangaku().getToValue()) {
            batchparam.setHoseizumiJikoFutangakuTo(new FlexibleYearMonth(div.getTxtHoseizumiJikoFutangaku().getToValue().getYearMonth().toString()));
        }
        if (null != div.getTxtJikoFutanngakuShoumeisho().getFromValue()) {
            batchparam.setJikoFutanngakuShoumeishoFrom(new FlexibleYearMonth(div.getTxtJikoFutanngakuShoumeisho().getFromValue().getYearMonth().toString()));
        }
        if (null != div.getTxtJikoFutanngakuShoumeisho().getToValue()) {
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
}

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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.HanyoListParamForKougakuDiv;
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
    private static final RString KEY1 = new RString("key1");
    private static final RString ONE = new RString("1");

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
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter DBC710140_HanyoListKogakuGassanShinseishoJohoParameter
     */
    public DBC710140_HanyoListKogakuGassanShinseishoJohoParameter onClick_btnKogakuParamSave() {
        return new DBC710140_HanyoListKogakuGassanShinseishoJohoParameter();
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnKogakuParamRestore() {

    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return DBC710140_HanyoListKogakuGassanShinseishoJohoParameter
     * 汎用リスト出力(高額合算申請書情報)_バッチパラメータクラスです
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

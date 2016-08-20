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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(高額合算申請書情報)のHandlerです。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public class HanyoListParamHandler {

    private final HanyoListParamDiv div;
    private static final RString BLANK = new RString("0");
    private static final RString すべて = new RString("すべて");
    private static final RString 広域 = new RString("広域");
    private static final RString 単一 = new RString("単一");
    private static final RString 項目名付加 = new RString("1");
    private static final RString 連番付加 = new RString("2");
    private static final RString 日付 = new RString("3");
    private static final RString 交付申請書整理番号 = new RString("交付申請書整理番号");
    private static final int 調定年度を含めて8年分 = 8;
    private static final int INDEX_ゼロ = 0;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト出力(高額合算申請書情報)画面のdiv
     */
    public HanyoListParamHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * initializeの初期化メソッドです。
     *
     * @return 市町村判定 RString
     */
    public RString initialize() {
        ShichosonSecurityJoho 市町村セキュリティ情報
                = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        ChushutsuJokenPanelDiv panel = div.getChushutsuJokenPanel();

        RString 市町村判定 = 単一;
        if (市町村セキュリティ情報 == null) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (市町村セキュリティ情報.get導入形態コード() != null
                && 市町村セキュリティ情報.get導入形態コード().is広域()) {
            市町村判定 = 広域;
            panel.getCcdHokenshaList().setDisplayNone(true);
            panel.getCcdHokenshaList().loadHokenshaList();
        } else {
            // TODO QA1263
            panel.getCcdHokenshaList().setDisplayNone(true);
        }
        panel.getDdlSinseiJokyoKubun().setDataSource(get申請状況区分リスト());
        panel.getDdlSinseiJokyoKubun().setSelectedIndex(INDEX_ゼロ);
        set調定年度();
        return 市町村判定;
    }

    /**
     * 入力チェックのメソッドです。
     *
     * @return ValidationMessageControlPairs
     *
     */
    public ValidationMessageControlPairs getCheckMessage() {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        RString 支給申請書整理番号From = div.getTxtSikyuSinseishoSeiriBangoKaishi().getLabelLText();
        RString 支給申請書整理番号To = div.getTxtSikyuSinseishoSeiriBangoKaishi().getLabelRText();
        if (null != 支給申請書整理番号From && null != 支給申請書整理番号To) {
            int 支給申請書整理番号F = Integer.parseInt(支給申請書整理番号From.toString());
            int 支給申請書整理番号T = Integer.parseInt(支給申請書整理番号To.toString());
            if (支給申請書整理番号T < 支給申請書整理番号F) {
                pairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.大小関係が不正, 交付申請書整理番号.toString())));
                return pairs;
            }
        }
        return pairs;
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter DBC710140_HanyoListKogakuGassanShinseishoJohoParameter
     */
    public DBC710140_HanyoListKogakuGassanShinseishoJohoParameter onClick_btnKogakuParamSave() {

        FlexibleDate 申請年月日From = null;
        if (null != div.getTxtSinseibi().getFromValue()) {
            申請年月日From = new FlexibleDate(div.getTxtSinseibi().getFromValue().toString());
        }
        FlexibleDate 申請年月日To = null;
        if (null != div.getTxtSinseibi().getToValue()) {
            申請年月日To = new FlexibleDate(div.getTxtSinseibi().getToValue().toString());
        }
        FlexibleDate 送付年月From = null;
        if (null != div.getTxtSofuNengetsu().getFromValue()) {
            送付年月From = new FlexibleDate(div.getTxtSofuNengetsu().getFromValue().toString());
        }
        FlexibleDate 送付年月To = null;
        if (null != div.getTxtSofuNengetsu().getToValue()) {
            送付年月To = new FlexibleDate(div.getTxtSofuNengetsu().getToValue().toString());
        }
        boolean 項目名 = false;
        boolean 連番 = false;
        boolean 日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                項目名 = true;
                continue;
            }
            if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                連番 = true;
                continue;
            }
            if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                日付編集 = true;
            }
        }
        return new DBC710140_HanyoListKogakuGassanShinseishoJohoParameter(
                div.getRadChushutsuKubun().getSelectedKey(),
                div.getDdlSinseiJokyoKubun().getSelectedKey(),
                div.getDdlTaishoNendo().getSelectedKey(),
                申請年月日From,
                申請年月日To,
                div.getTxtSikyuSinseishoSeiriBangoKaishi().getLabelLText(),
                div.getTxtSikyuSinseishoSeiriBangoKaishi().getLabelRText(),
                送付年月From,
                送付年月To,
                項目名,
                連番,
                日付編集,
                div.getCcdHokenshaList().getSelectedItem().get保険者区分().get名称(),
                div.getCcdShutsuryokujun().getSelected出力順().get出力順ID(),
                div.getCcdShutsuryokuKoumoku().get出力項目ID()
        );
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnKogakuParamRestore() {

        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsuKubun"));
        div.getRadChushutsuKubun().setSelectedKey(抽出区分);
        RString 申請状況区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kaigoGassanShinseiJokyoKubun"));
        div.getDdlSinseiJokyoKubun().setSelectedKey(申請状況区分);
        RString 対象年度 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("flexibleYear"));
        div.getDdlTaishoNendo().setSelectedKey(対象年度);
        FlexibleDate 申請年月日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("flexibleDateFrom"));
        div.getTxtSinseibi().setFromValue(new RDate(申請年月日From.toString()));
        FlexibleDate 申請年月日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("flexibleDateTo"));
        div.getTxtSinseibi().setToValue(new RDate(申請年月日To.toString()));
        RString 支給申請書整理番号From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shikyuShinseishoSeiriNoFrom"));
        div.getTxtSikyuSinseishoSeiriBangoKaishi().setLabelLText(支給申請書整理番号From);
        RString 支給申請書整理番号To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shikyuShinseishoSeiriNoTo"));
        div.getTxtSikyuSinseishoSeiriBangoKaishi().setLabelRText(支給申請書整理番号To);
        FlexibleDate 送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("flexibleYearMonthFrom"));
        div.getTxtSofuNengetsu().setFromValue(new RDate(送付年月From.toString()));
        FlexibleDate 送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("flexibleYearMonthTo"));
        div.getTxtSofuNengetsu().setToValue(new RDate(送付年月To.toString()));
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("tomokumeFuka"));
        if (is項目名付加) {
            編集方法.add(new RString("1"));
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("rebanFuka"));
        if (is連番付加) {
            編集方法.add(new RString("2"));
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("slashDate"));
        if (is日付編集) {
            編集方法.add(new RString("3"));
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        RString 保険者コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hokenshaNo"));
//        div.getCcdHokenshaList().setSelectedKey(保険者コード);

        RString 出力順 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shutsuryokuju"));
        div.getRadChushutsuKubun().setSelectedKey(出力順);
        RString 出力項目 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shutsuryokuTomoku"));
        div.getRadChushutsuKubun().setSelectedKey(出力項目);
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
        } else {
            batchparam.setChushutsuKubun(div.getRadChushutsuKubun().getSelectedKey());
        }
        if (すべて.equals(div.getDdlSinseiJokyoKubun().getSelectedValue())) {
            batchparam.setKaigoGassanShinseiJokyoKubun(RString.EMPTY);
        } else {
            batchparam.setKaigoGassanShinseiJokyoKubun(div.getDdlSinseiJokyoKubun().getSelectedKey());
        }
        batchparam.setFlexibleYear(div.getDdlTaishoNendo().getSelectedKey());
        batchparam.setFlexibleDateFrom(new FlexibleDate(div.getTxtSinseibi().getFromValue().toString()));
        batchparam.setFlexibleDateTo(new FlexibleDate(div.getTxtSinseibi().getToValue().toString()));
        batchparam.setShikyuShinseishoSeiriNoFrom(div.getTxtSikyuSinseishoSeiriBangoKaishi().getLabelLText());
        batchparam.setShikyuShinseishoSeiriNoTo(div.getTxtSikyuSinseishoSeiriBangoKaishi().getLabelRText());
        batchparam.setFlexibleYearMonthFrom(new FlexibleDate(div.getTxtSofuNengetsu().getFromValue().toString()));
        batchparam.setFlexibleYearMonthTo(new FlexibleDate(div.getTxtSofuNengetsu().getToValue().toString()));
        List<RString> selectKey = div.getChkCsvHenshuHoho().getSelectedKeys();
        if (selectKey.contains(項目名付加)) {
            batchparam.setRebanFuka(true);
        } else {
            batchparam.setRebanFuka(false);
        }
        if (selectKey.contains(連番付加)) {
            batchparam.setTomokumeFuka(true);
        } else {
            batchparam.setTomokumeFuka(false);
        }
        if (selectKey.contains(日付)) {
            batchparam.setSlashDate(true);
        } else {
            batchparam.setSlashDate(false);
        }
//        batchparam.setHokenshaNo(div.getCcdHokenshaList().);
        if (null != div.getCcdShutsuryokujun().getSelected出力順()) {
            batchparam.setShutsuryokuju(div.getCcdShutsuryokujun().getSelected出力順().get出力順ID());
        }
        if (false != div.getCcdShutsuryokuKoumoku().getEraseBorder()) {
            batchparam.setShutsuryokuTomoku(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        } else {
            batchparam.setShutsuryokuTomoku(RString.EMPTY);
        }
        return batchparam;
    }

    private void set調定年度() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RYear 日付関連_当初年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_当初年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        RYear 日付関連_調定年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
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

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

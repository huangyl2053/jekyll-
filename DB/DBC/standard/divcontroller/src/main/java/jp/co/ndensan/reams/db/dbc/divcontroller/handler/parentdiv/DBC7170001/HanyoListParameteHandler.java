/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7170001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710170.DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7170001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7170001.HanyoListParameteDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト出力(高額合算支給額決定情報)のHandlerです。
 *
 * @reamsid_L DBC-3101-010 qinzhen
 */
public class HanyoListParameteHandler {

    private final HanyoListParameteDiv div;
    private static final RString 項目名 = new RString("1");
    private static final RString 日付 = new RString("3");
    private static final RString 事務広域 = new RString("111");
    private static final RString すべて = new RString("key0");
    private static final RString 不支給 = new RString("Key2");
    private static final RString 窓口払 = new RString("key1");
    private static final RString BLANK = new RString("0");
    private static final RString 全市町村 = new RString("全市町村");
    private static final int 調定年度を含めて8年分 = 8;

    /**
     * コンストラクタ。
     *
     * @param div HanyoListParameteDiv
     *
     */
    public HanyoListParameteHandler(HanyoListParameteDiv div) {
        this.div = div;
    }

    /**
     * initializeのメソッドです。
     *
     */
    public void initialize() {

        set調定年度();

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

        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701017.getReportId());
    }

    /**
     * 支給区分の選択肢に応じて、画面・抽出条件項目の制御のメソッドです。
     *
     */
    public void set支給制御処理() {
        div.getChushutsuJokenPanel().getRadSiharaiHohoKubun().setDisabled(false);
        div.getChushutsuJokenPanel().getCcdKinyuKikan().setDisabled(false);

        if (不支給.equals(div.getChushutsuJokenPanel().getRadSikyuKubun().getSelectedKey())) {
            div.getChushutsuJokenPanel().getRadSiharaiHohoKubun().setDisabled(true);
            div.getChushutsuJokenPanel().getCcdKinyuKikan().setDisabled(true);
        }

    }

    /**
     * 支払方法区分の選択肢に応じて、画面・抽出条件項目の制御のメソッドです。
     *
     */
    public void set支払方法制御処理() {
        div.getChushutsuJokenPanel().getCcdKinyuKikan().setDisabled(false);

        if (窓口払.equals(div.getChushutsuJokenPanel().getRadSiharaiHohoKubun().getSelectedKey())) {
            div.getChushutsuJokenPanel().getCcdKinyuKikan().setDisabled(true);
        }
    }

    /**
     * バッチパラメータ設定するメソッド。
     *
     * @return DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter
     */
    public DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter setBatchParameter() {
        DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter parameter = new DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter();
        ChushutsuJokenPanelDiv panel = div.getChushutsuJokenPanel();

        if (すべて.equals(panel.getRadSikyuKubun().getSelectedKey())) {
            parameter.set支給区分(RString.EMPTY);
        } else if (不支給.equals(panel.getRadSikyuKubun().getSelectedKey())) {
            parameter.set支給区分(Kaigogassan_ShikyuFushikyuKubun.不支給.getコード());
        } else {
            parameter.set支給区分(Kaigogassan_ShikyuFushikyuKubun.支給.getコード());
        }

        if (すべて.equals(panel.getRadSiharaiHohoKubun().getSelectedKey())
                || 不支給.equals(panel.getRadSikyuKubun().getSelectedKey())) {
            parameter.set支払方法区分(RString.EMPTY);
        } else if (窓口払.equals(panel.getRadSiharaiHohoKubun().getSelectedKey())) {
            parameter.set支払方法区分(ShiharaiHohoKubun.窓口払.getコード());
        } else {
            parameter.set支払方法区分(ShiharaiHohoKubun.口座払.getコード());
        }

        if (panel.getCcdKinyuKikan().isDisabled()) {
            parameter.set金融機関コード(KinyuKikanCode.EMPTY);
            parameter.set金融機関名称(RString.EMPTY);
        } else {
            parameter.set金融機関コード(panel.getCcdKinyuKikan().getKinyuKikanCode());
            parameter.set金融機関名称(panel.getCcdKinyuKikan().get金融機関名());
        }

        parameter.set対象年度(panel.getDdlTaishoNendo().getSelectedKey());

        if (panel.getTxtKetteiJohoUketoriNengetsu().getFromValue() != null) {
            parameter.set決定情報受取年月From(new FlexibleYearMonth(panel.getTxtKetteiJohoUketoriNengetsu()
                    .getFromValue().getYearMonth().toDateString()));
        } else {
            parameter.set決定情報受取年月From(FlexibleYearMonth.EMPTY);
        }

        if (panel.getTxtKetteiJohoUketoriNengetsu().getToValue() != null) {
            parameter.set決定情報受取年月To(new FlexibleYearMonth(panel.getTxtKetteiJohoUketoriNengetsu()
                    .getToValue().getYearMonth().toDateString()));
        } else {
            parameter.set決定情報受取年月To(FlexibleYearMonth.EMPTY);
        }

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

}

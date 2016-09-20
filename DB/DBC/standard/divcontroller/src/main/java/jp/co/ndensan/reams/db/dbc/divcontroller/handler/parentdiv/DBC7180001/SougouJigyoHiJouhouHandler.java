/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7180001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sougoujigyohijouhou.SougouJigyoHiJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710180.DBC710180_HanyoListSogoJigyoHiParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7180001.SougouJigyoHiJouhouDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト出力(総合事業費情報)のHandlerです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
public class SougouJigyoHiJouhouHandler {

    private static final RString 導入形態_単一 = new RString("1");
    private static final RString 導入形態_広域 = new RString("2");
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 作成区分_KEY0 = new RString("key0");
    private static final RString 作成区分_KEY1 = new RString("key1");
    private static final RString 作成区分_KEY2 = new RString("key2");
    private static final RString 作成区分_KEY3 = new RString("key3");
    private static final RString 全て市町村 = new RString("000000");
    private final SougouJigyoHiJouhouDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SougouJigyoHiJouhouDiv
     */
    public SougouJigyoHiJouhouHandler(SougouJigyoHiJouhouDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param shichosonsecurityjoho ShichosonSecurityJoho
     */
    public void onLoad(ShichosonSecurityJoho shichosonsecurityjoho) {
        if (導入形態コード_111.equals(shichosonsecurityjoho.get導入形態コード().getColumnValue())) {
            div.setHdnDonyuKeitai(導入形態_広域);
            div.getChushutsuJokenPanel().setDisplayNone(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
        } else {
            div.setHdnDonyuKeitai(導入形態_単一);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(true);
        }
        div.getDdlSabisuSyurui().setReadOnly(true);
        ViewStateHolder.put(ViewStateKeys.事業者入力モード, new RString("事業者入力モード"));
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示無し"));
        div.getCcdJigyoshaBango().initialize();
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701018.getReportId());
        div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701018.getReportId().value(), SubGyomuCode.DBC介護給付);
    }

    /**
     * 作成区分のセットします。
     *
     * @param key RString
     * @param sougoujigyohijouhous List<SougouJigyoHiJouhouBusiness>
     */
    public void setサービス種類DDL(RString key, List<SougouJigyoHiJouhouBusiness> sougoujigyohijouhous) {
        List<KeyValueDataSource> list = new ArrayList();
        div.getDdlSabisuSyurui().getDataSource().clear();
        KeyValueDataSource source = new KeyValueDataSource();
        source.setKey(new RString("Empty"));
        source.setValue(new RString("すべて"));
        list.add(source);
        for (SougouJigyoHiJouhouBusiness sougoujigyohijouhou : sougoujigyohijouhous) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(sougoujigyohijouhou.getサービス種類コード());
            dataSource.setValue(sougoujigyohijouhou.getサービス種類名称());
            list.add(dataSource);
            div.getDdlSabisuSyurui().setDataSource(list);
        }
        div.getDdlSabisuSyurui().setSelectedKey(new RString("Empty"));
        div.getDdlSabisuSyurui().setReadOnly(false);
        if (作成区分_KEY0.equals(key)) {
            div.getDdlSabisuSyurui().setReadOnly(true);
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701018.getReportId().value(), SubGyomuCode.DBC介護給付);
        } else if (作成区分_KEY1.equals(key)) {
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701022.getReportId().value(), SubGyomuCode.DBC介護給付);
        } else if (作成区分_KEY2.equals(key)) {
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701023.getReportId().value(), SubGyomuCode.DBC介護給付);
        } else if (作成区分_KEY3.equals(key)) {
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701024.getReportId().value(), SubGyomuCode.DBC介護給付);
        }

    }

    /**
     * 画面条件を保存します。
     *
     * @return parameter DBC710180_HanyoListSogoJigyoHiParameter
     */
    public DBC710180_HanyoListSogoJigyoHiParameter onClick_btnBatchParameterSave() {
        DBC710180_HanyoListSogoJigyoHiParameter parameter = new DBC710180_HanyoListSogoJigyoHiParameter();
        parameter.set帳票ID(div.getCcdShutsuryokujun().get帳票ID().value());
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            parameter.set出力順ID(div.getCcdShutsuryokujun().get出力順ID());
        }
        parameter.set出力順項目ID(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付スラッシュ編集 = false;
        List<RString> 編集方法List = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                is項目名付加 = true;
            } else if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                is連番付加 = true;
            } else if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                is日付スラッシュ編集 = true;
            }
        }
        parameter.set項目名付加(is項目名付加);
        parameter.set連番付加(is連番付加);
        parameter.set日付スラッシュ付加(is日付スラッシュ編集);
        parameter.set事業者コード(div.getCcdJigyoshaBango().getJpControlName());
        parameter.setサービス種類コード(div.getDdlSabisuSyurui().getSelectedKey());
        RString 市町村コード = RString.EMPTY;
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())
                && !div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value().equals(全て市町村)) {
            市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            if (!div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = 全て市町村;
            }
        }
        parameter.set保険者コード(市町村コード);
        parameter.set抽出方法(div.getRadSakuseiKubun().getSelectedValue());
        if (div.getTxtSabisuTeikyoNengetsu().getFromValue() != null) {
            parameter.setサービス提供年月開始年月(rDateToRString(div.getTxtSabisuTeikyoNengetsu().getFromValue()));
        }
        if (div.getTxtSabisuTeikyoNengetsu().getToValue() != null) {
            parameter.setサービス提供年月終了年月(rDateToRString(div.getTxtSabisuTeikyoNengetsu().getToValue()));
        }
        if (div.getTxtSinsaNengetsu().getFromValue() != null) {
            parameter.set審査年月開始年月(rDateToRString(div.getTxtSinsaNengetsu().getFromValue()));
        }
        if (div.getTxtSinsaNengetsu().getToValue() != null) {
            parameter.set審査年月終了年月(rDateToRString(div.getTxtSinsaNengetsu().getToValue()));
        }
        if (div.getTxtTorikomiNengetsu().getFromValue() != null) {
            parameter.set取込年月開始年月(rDateToRString(div.getTxtTorikomiNengetsu().getFromValue()));
        }
        if (div.getTxtTorikomiNengetsu().getToValue() != null) {
            parameter.set取込年月終了年月(rDateToRString(div.getTxtTorikomiNengetsu().getToValue()));
        }
        return parameter;
    }

    /**
     * 画面条件を復元します。
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
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("is日付スラッシュ付加"));
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
        div.getRadSakuseiKubun().setSelectedValue(restoreBatchParameterMap.getParameterValue(
                RString.class, new RString("抽出方法")));
        div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(
                new LasdecCode(restoreBatchParameterMap.getParameterValue(RString.class, new RString("保険者コード"))));
        RString syuruicode = restoreBatchParameterMap.getParameterValue(RString.class, new RString("サービス種類コード"));
        if (!RString.isNullOrEmpty(syuruicode)) {
            div.getDdlSabisuSyurui().setSelectedKey(syuruicode);
        }
        RString jigyoshacode = restoreBatchParameterMap.getParameterValue(RString.class, new RString("事業者コード"));
        div.getCcdJigyoshaBango().setNyuryokuShisetsuKodo(jigyoshacode);
        RString サービス提供年月開始年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("サービス提供年月開始年月"));
        RString サービス提供年月終了年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("サービス提供年月終了年月"));
        RString 審査年月開始年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("審査年月開始年月"));
        RString 審査年月終了年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("審査年月終了年月"));
        RString 取込年月開始年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("取込年月開始年月"));
        RString 取込年月終了年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("取込年月終了年月"));
        if (!RString.isNullOrEmpty(サービス提供年月開始年月)) {
            div.getChushutsuJokenPanel().getTxtSabisuTeikyoNengetsu().setFromValue(new RDate(サービス提供年月開始年月.toString()));
        }
        if (!RString.isNullOrEmpty(サービス提供年月終了年月)) {
            div.getChushutsuJokenPanel().getTxtSabisuTeikyoNengetsu().setToValue(new RDate(サービス提供年月終了年月.toString()));
        }
        if (!RString.isNullOrEmpty(審査年月開始年月)) {
            div.getChushutsuJokenPanel().getTxtSinsaNengetsu().setFromValue(new RDate(審査年月開始年月.toString()));
        }
        if (!RString.isNullOrEmpty(審査年月終了年月)) {
            div.getChushutsuJokenPanel().getTxtSinsaNengetsu().setToValue(new RDate(審査年月終了年月.toString()));
        }
        if (!RString.isNullOrEmpty(取込年月開始年月)) {
            div.getChushutsuJokenPanel().getTxtTorikomiNengetsu().setFromValue(new RDate(取込年月開始年月.toString()));
        }
        if (!RString.isNullOrEmpty(取込年月終了年月)) {
            div.getChushutsuJokenPanel().getTxtTorikomiNengetsu().setToValue(new RDate(取込年月終了年月.toString()));
        }
    }

    private RString rDateToRString(RDate 日付) {
        if (日付 == null) {
            return RString.EMPTY;
        }
        return 日付.toDateString();
    }
}

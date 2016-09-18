/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710110.DBC710110_HanyoListSaishinsaMoshitateParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710120.DBC710120_HanyoListSaishinsaKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitateKekka_HokenshaKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7110001.HanyoListParamPanelDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 画面設計_DBCGM23011_汎用リスト 再審査申立情報のハンドラクラスです。
 *
 * @reamsid_L DBC-3106-010 zhengsongling
 */
public class HanyoListParamHandler {

    private static final RString 単一 = new RString("単一");
    private static final RString 広域 = new RString("広域");
    private static final RString 再審査申立情報 = new RString("再審査申立情報");
    private static final RString 再審査結果情報 = new RString("再審査結果情報");
    private static final RString 保険者区分_経過措置_総合事業費 = new RString("3");
    private static final LasdecCode 保険者コード_全市町村 = new LasdecCode("000000");
    private final HanyoListParamPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamPanelDiv
     */
    public HanyoListParamHandler(HanyoListParamPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     *
     * @param 導入形態 導入形態
     * @param モード モード
     */
    public void initialize(RString 導入形態, RString モード) {
        if (単一.equals(導入形態)) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(true);
        } else if (広域.equals(導入形態)) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
        }
        if (再審査申立情報.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701011.getReportId());
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701011.getReportId().value(), SubGyomuCode.DBC介護給付);
        } else if (再審査結果情報.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701012.getReportId());
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701012.getReportId().value(), SubGyomuCode.DBC介護給付);
            set保険者区分();
        }
        List<RString> listCSV = new ArrayList<>();
        listCSV.add(CSVSettings.項目名付加.getコード());
        listCSV.add(CSVSettings.日付スラッシュ編集.getコード());
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(listCSV);
    }

    private void set保険者区分() {
        List<KeyValueDataSource> list保険者区分 = new ArrayList<>();
        for (KagoMoshitateKekka_HokenshaKubun value : KagoMoshitateKekka_HokenshaKubun.values()) {
            if (!value.getコード().equals(保険者区分_経過措置_総合事業費)) {
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(value.getコード());
                dataSource.setValue(value.get略称());
                list保険者区分.add(dataSource);
            }
        }
        div.getChkHokenshaKubun().setDataSource(list保険者区分);
    }

    /**
     * 再審査申立情報の条件を保存する。
     *
     * @param 導入形態 導入形態
     * @return DBC710110_HanyoListSaishinsaMoshitateParameter
     */
    public DBC710110_HanyoListSaishinsaMoshitateParameter hanyoListSaishinsaMoshitateParamSave(RString 導入形態) {
        DBC710110_HanyoListSaishinsaMoshitateParameter param = new DBC710110_HanyoListSaishinsaMoshitateParameter();
        param.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        param.setShutsuryokuKomokuId(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        List<RString> list = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        if (list.contains(CSVSettings.項目名付加.getコード())) {
            param.setKomokumeiFuka(true);
        } else {
            param.setKomokumeiFuka(false);
        }
        if (list.contains(CSVSettings.連番付加.getコード())) {
            param.setRenbanFuka(true);
        } else {
            param.setRenbanFuka(false);
        }
        if (list.contains(CSVSettings.日付スラッシュ編集.getコード())) {
            param.setHitsukeHenshu(true);
        } else {
            param.setHitsukeHenshu(false);
        }
        if (単一.equals(導入形態)) {
            param.setHokenshacode(LasdecCode.EMPTY);
        } else {
            param.setHokenshacode(div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード());
        }

        param.setKokuhorensouhunengetsufrom(nullToEmpty(div.getTxtKokuhorenSofuNengetu().getFromValue()));
        param.setKokuhorensouhunengetsuto(nullToEmpty(div.getTxtKokuhorenSofuNengetu().getToValue()));
        param.setSeverteikyounengetsufrom(nullToEmpty(div.getTxtSabisuTeikyoNengetu().getFromValue()));
        param.setSeverteikyounengetsuto(nullToEmpty(div.getTxtSabisuTeikyoNengetu().getToValue()));
        param.setJigyoushabangou(div.getCcdJigyoshaBango().getNyuryokuShisetsuKodo());
        return param;
    }

    /**
     * 再審査申立情報の条件を復元する。
     *
     * @param 導入形態 導入形態
     */
    public void hanyoListSaishinsaMoshitate(RString 導入形態) {
        BatchParameterMap restoreBatchParameterMap = div.getBtnHanyoListSaishinsaMoshitateParamRestore().getRestoreBatchParameterMap();
        div.getTxtKokuhorenSofuNengetu().setFromValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("kokuhorensouhunengetsufrom")).toString()));
        div.getTxtKokuhorenSofuNengetu().setToValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("kokuhorensouhunengetsuto")).toString()));
        div.getTxtSabisuTeikyoNengetu().setFromValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("severteikyounengetsufrom")).toString()));
        div.getTxtSabisuTeikyoNengetu().setToValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("severteikyounengetsuto")).toString()));
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeiFuka"));
        if (is項目名付加) {
            編集方法.add(CSVSettings.項目名付加.getコード());
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(CSVSettings.連番付加.getコード());
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        if (広域.equals(導入形態)) {
            if (restoreBatchParameterMap.getParameterValue(LasdecCode.class, new RString("hokenshacode")).isEmpty()) {
                div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
            } else {
                div.getCcdHokenshaList().setSelectedShichosonIfExist(restoreBatchParameterMap.getParameterValue(LasdecCode.class, new RString("hokenshacode")));
            }
        }
        div.getCcdJigyoshaBango().setNyuryokuShisetsuKodo(restoreBatchParameterMap.getParameterValue(RString.class, new RString("jigyoushabangou")));
    }

    /**
     * 再審査結果情報の条件を保存する。
     *
     * @param 導入形態 導入形態
     * @return DBC710120_HanyoListSaishinsaKekkaParameter
     */
    public DBC710120_HanyoListSaishinsaKekkaParameter hanyoListSaishinsaKekkaParamSave(RString 導入形態) {
        DBC710120_HanyoListSaishinsaKekkaParameter param = new DBC710120_HanyoListSaishinsaKekkaParameter();
        param.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        param.setShutsuryokuKomokuId(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        List<RString> list = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        if (list.contains(CSVSettings.項目名付加.getコード())) {
            param.setKomokumeiFuka(true);
        } else {
            param.setKomokumeiFuka(false);
        }
        if (list.contains(CSVSettings.連番付加.getコード())) {
            param.setRenbanFuka(true);
        } else {
            param.setRenbanFuka(false);
        }
        if (list.contains(CSVSettings.日付スラッシュ編集.getコード())) {
            param.setHitsukeHenshu(true);
        } else {
            param.setHitsukeHenshu(false);
        }
        if (単一.equals(導入形態)) {
            param.setHokenshacode(LasdecCode.EMPTY);
        } else {
            param.setHokenshacode(div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード());
        }
        param.setKokuhorentoriatsukaifrom(nullToEmpty(div.getTxtKokuhorenToriatukaiNengetu().getFromValue()));
        param.setKokuhorentoriatsukainenetsuto(nullToEmpty(div.getTxtKokuhorenToriatukaiNengetu().getToValue()));
        param.setSeverteikyounengetsufrom(nullToEmpty(div.getTxtSabisuTeikyoNengetu().getFromValue()));
        param.setSeverteikyounengetsuto(nullToEmpty(div.getTxtSabisuTeikyoNengetu().getToValue()));
        param.setJigyoushabangou(div.getCcdJigyoshaBango().getNyuryokuShisetsuKodo());
        List<RString> listKey = div.getChkHokenshaKubun().getSelectedKeys();
        param.setHokenshakubun(listKey);
        return param;
    }

    /**
     * 再審査結果情報の条件を復元する。
     *
     * @param 導入形態 導入形態
     */
    public void hanyoListSaishinsaKekka(RString 導入形態) {
        BatchParameterMap restoreBatchParameterMap = div.getBtnHanyoListSaishinsaKekkaParamRestore().getRestoreBatchParameterMap();
        div.getTxtKokuhorenToriatukaiNengetu().setFromValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("kokuhorentoriatsukaifrom")).toString()));
        div.getTxtKokuhorenToriatukaiNengetu().setToValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("kokuhorentoriatsukainenetsuto")).toString()));
        div.getTxtSabisuTeikyoNengetu().setFromValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("severteikyounengetsufrom")).toString()));
        div.getTxtSabisuTeikyoNengetu().setToValue(nullToEmpty(restoreBatchParameterMap.getParameterValue(RString.class, new RString("severteikyounengetsuto")).toString()));
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeiFuka"));
        if (is項目名付加) {
            編集方法.add(CSVSettings.項目名付加.getコード());
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(CSVSettings.連番付加.getコード());
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        List<RString> list保険者区分 = new ArrayList<>();
        for (Object hokenshakubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("hokenshakubun"))) {
            list保険者区分.add(new RString(hokenshakubun.toString()));
        }
        div.getChkHokenshaKubun().setSelectedItemsByKey(list保険者区分);
        if (広域.equals(導入形態)) {
            if (restoreBatchParameterMap.getParameterValue(LasdecCode.class, new RString("hokenshacode")).isEmpty()) {
                div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
            } else {
                div.getCcdHokenshaList().setSelectedShichosonIfExist(restoreBatchParameterMap.getParameterValue(LasdecCode.class, new RString("hokenshacode")));
            }
        }
        div.getCcdJigyoshaBango().setNyuryokuShisetsuKodo(restoreBatchParameterMap.getParameterValue(RString.class, new RString("jigyoushabangou")));
    }

    /**
     * 再審査申立情報の実行です。
     *
     * @param 導入形態 導入形態
     * @return DBC710110_HanyoListSaishinsaMoshitateParameter
     */
    public DBC710110_HanyoListSaishinsaMoshitateParameter btnExecuteMoshitate(RString 導入形態) {
        RString 帳票ID = ReportIdDBC.DBC701011.getReportId().value();
        Long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
        RString 出力項目ID = div.getCcdShutsuryokuKoumoku().get出力項目ID();
        List<RString> list = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        boolean has項目名付加 = false;
        boolean has連番付加 = false;
        boolean has日付編集 = false;
        LasdecCode 保険者コード;
        if (list.contains(CSVSettings.項目名付加.getコード())) {
            has項目名付加 = true;
        }
        if (list.contains(CSVSettings.連番付加.getコード())) {
            has連番付加 = true;
        }
        if (list.contains(CSVSettings.日付スラッシュ編集.getコード())) {
            has日付編集 = true;
        }
        if (広域.equals(導入形態)) {
            保険者コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
            if (保険者コード.isEmpty()) {
                保険者コード = 保険者コード_全市町村;
            }
        } else {
            保険者コード = LasdecCode.EMPTY;
        }
        RString 国保連送付年月From = nullToEmpty(div.getTxtKokuhorenSofuNengetu().getFromValue());
        RString 国保連送付年月To = nullToEmpty(div.getTxtKokuhorenSofuNengetu().getToValue());
        RString サービス提供年月From = nullToEmpty(div.getTxtSabisuTeikyoNengetu().getFromValue());
        RString サービス提供年月To = nullToEmpty(div.getTxtSabisuTeikyoNengetu().getToValue());
        RString 事業者番号 = div.getCcdJigyoshaBango().getNyuryokuShisetsuKodo();
        return new DBC710110_HanyoListSaishinsaMoshitateParameter(
                帳票ID,
                出力順ID,
                出力項目ID,
                has項目名付加,
                has連番付加,
                has日付編集,
                保険者コード,
                国保連送付年月From,
                国保連送付年月To,
                サービス提供年月From,
                サービス提供年月To,
                事業者番号);
    }

    /**
     * 再審査結果情報の実行です。
     *
     * @param 導入形態 導入形態
     * @return DBC710120_HanyoListSaishinsaKekkaParameter
     */
    public DBC710120_HanyoListSaishinsaKekkaParameter btnExecuteKekka(RString 導入形態) {
        RString 帳票ID = ReportIdDBC.DBC701012.getReportId().value();
        Long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
        RString 出力項目ID = div.getCcdShutsuryokuKoumoku().get出力項目ID();
        boolean has項目名付加 = false;
        boolean has連番付加 = false;
        boolean has日付編集 = false;
        LasdecCode 保険者コード;
        List<RString> list = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        if (list.contains(CSVSettings.項目名付加.getコード())) {
            has項目名付加 = true;
        }
        if (list.contains(CSVSettings.連番付加.getコード())) {
            has連番付加 = true;
        }
        if (list.contains(CSVSettings.日付スラッシュ編集.getコード())) {
            has日付編集 = true;
        }
        if (広域.equals(導入形態)) {
            保険者コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
            if (保険者コード.isEmpty()) {
                保険者コード = 保険者コード_全市町村;
            }
        } else {
            保険者コード = LasdecCode.EMPTY;
        }
        RString 国保連取扱年月From = nullToEmpty(div.getTxtKokuhorenToriatukaiNengetu().getFromValue());
        RString 国保連取扱年月To = nullToEmpty(div.getTxtKokuhorenToriatukaiNengetu().getToValue());
        List<RString> list保険者区分 = div.getChkHokenshaKubun().getSelectedKeys();
        RString サービス提供年月From = nullToEmpty(div.getTxtSabisuTeikyoNengetu().getFromValue());
        RString サービス提供年月To = nullToEmpty(div.getTxtSabisuTeikyoNengetu().getToValue());
        RString 事業者番号 = div.getCcdJigyoshaBango().getNyuryokuShisetsuKodo();
        return new DBC710120_HanyoListSaishinsaKekkaParameter(
                帳票ID,
                出力順ID,
                出力項目ID,
                has項目名付加,
                has連番付加,
                has日付編集,
                保険者コード,
                国保連取扱年月From,
                国保連取扱年月To,
                list保険者区分,
                サービス提供年月From,
                サービス提供年月To,
                事業者番号);
    }

    private RString nullToEmpty(RDate obj) {
        if (obj != null) {
            return obj.getYearMonth().toDateString();
        }
        return RString.EMPTY;
    }

    private RDate nullToEmpty(String obj) {
        if (obj.isEmpty()) {
            return null;
        }
        return new RDate(obj);
    }
}

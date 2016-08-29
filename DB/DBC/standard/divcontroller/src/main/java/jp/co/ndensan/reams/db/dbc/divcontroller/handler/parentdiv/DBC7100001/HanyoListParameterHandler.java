/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710100.DBC710100_HanyoListKagoKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitateKekka_HokenshaKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7100001.ChushutsuJokenPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7100001.HanyoListParameterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(過誤結果情報)のHandlerです。
 *
 * @reamsid_L DBC-3094-010 qinzhen
 */
public class HanyoListParameterHandler {

    private final HanyoListParameterDiv div;
    private static final RString 項目名 = new RString("1");
    private static final RString 日付 = new RString("3");
    private static final RString 事務広域 = new RString("111");
    private static final RString すべて = new RString("key0");
    private static final RString 保険者 = new RString("key1");
    private static final RString 公費負担者 = new RString("key2");
    private static final RString 経過措置_総合事業費 = new RString("key3");
    private static final RString 保険者_総合事業費 = new RString("key4");
    private static final ReportId 帳票ID = new ReportId("DBC701010_HanyoList_KagoKekka");

    /**
     * コンストラクタ。
     *
     * @param div HanyoListParameterDiv
     *
     */
    public HanyoListParameterHandler(HanyoListParameterDiv div) {
        this.div = div;
    }

    /**
     * initializeのメソッドです。
     */
    public void initialize() {
        div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();

        List<RString> selectKey = new ArrayList<>();
        selectKey.add(項目名);
        selectKey.add(日付);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(selectKey);

        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (事務広域.equals(市町村情報セキュリティ情報.get導入形態コード().value())) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(false);
        } else {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setVisible(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisabled(true);
        }
        //TODO  QA1352
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
    }

    /**
     * バッチパラメータ設定するメソッド。
     *
     * @return DBC710100_HanyoListKagoKekkaParameter
     */
    public DBC710100_HanyoListKagoKekkaParameter setBatchParameter() {
        DBC710100_HanyoListKagoKekkaParameter parameter = new DBC710100_HanyoListKagoKekkaParameter();
        ChushutsuJokenPanelDiv panel = div.getChushutsuJokenPanel();

        if (panel.getTxtKokuhorenToriatukaiNengetu().getFromValue() != null) {
            parameter.set国保連取扱年月From(new FlexibleDate(panel.getTxtKokuhorenToriatukaiNengetu().getFromValue().toString()));
        } else {
            parameter.set国保連取扱年月From(FlexibleDate.EMPTY);
        }

        if (panel.getTxtKokuhorenToriatukaiNengetu().getToValue() != null) {
            parameter.set国保連取扱年月To(new FlexibleDate(panel.getTxtKokuhorenToriatukaiNengetu().getToValue().toString()));
        } else {
            parameter.set国保連取扱年月To(FlexibleDate.EMPTY);
        }

        if (すべて.equals(panel.getRadHokenshaKubun().getSelectedKey())) {
            parameter.set保険者区分(RString.EMPTY);
        } else if (保険者.equals(panel.getRadHokenshaKubun().getSelectedKey())) {
            parameter.set保険者区分(KagoMoshitateKekka_HokenshaKubun.保険者.getコード());
        } else if (公費負担者.equals(panel.getRadHokenshaKubun().getSelectedKey())) {
            parameter.set保険者区分(KagoMoshitateKekka_HokenshaKubun.公費負担者.getコード());
        } else if (経過措置_総合事業費.equals(panel.getRadHokenshaKubun().getSelectedKey())) {
            parameter.set保険者区分(KagoMoshitateKekka_HokenshaKubun.経過措置_総合事業費.getコード());
        } else if (保険者_総合事業費.equals(panel.getRadHokenshaKubun().getSelectedKey())) {
            parameter.set保険者区分(KagoMoshitateKekka_HokenshaKubun.保険者_総合事業費.getコード());
        } else {
            parameter.set保険者区分(KagoMoshitateKekka_HokenshaKubun.公費負担者_総合事業費.getコード());
        }

        if (panel.getTxtSabisuTeikyoNengetu().getFromValue() != null) {
            parameter.setサービス提供年月From(new FlexibleDate(panel.getTxtSabisuTeikyoNengetu().getFromValue().toString()));
        } else {
            parameter.setサービス提供年月From(FlexibleDate.EMPTY);
        }

        if (panel.getTxtSabisuTeikyoNengetu().getToValue() != null) {
            parameter.setサービス提供年月To(new FlexibleDate(panel.getTxtSabisuTeikyoNengetu().getToValue().toString()));
        } else {
            parameter.setサービス提供年月To(FlexibleDate.EMPTY);
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
        parameter.set保険者コード(panel.getCcdHokenshaList().getSelectedItem().get市町村コード());

        if (div.getCcdShutsuryokujun().get出力順ID() == null) {
            parameter.set出力順(RString.EMPTY);
        } else {
            parameter.set出力順(new RString(div.getCcdShutsuryokujun().get出力順ID()));
        }
        parameter.set出力項目(RString.EMPTY);
        return parameter;
    }
}

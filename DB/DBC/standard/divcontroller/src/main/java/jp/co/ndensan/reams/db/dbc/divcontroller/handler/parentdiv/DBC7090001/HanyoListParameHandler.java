/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710090.DBC710090_HanyoListKagoMoshitateParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_HokenshaKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7090001.HanyoListParameDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(過誤申立情報)のHandlerです。
 *
 * @reamsid_L DBC-3095-010 qinzhen
 */
public class HanyoListParameHandler {

    private final HanyoListParameDiv div;
    private static final RString 項目名 = new RString("1");
    private static final RString 日付 = new RString("3");
    private static final RString 事務広域 = new RString("111");
    private static final ReportId 帳票ID = new ReportId("DBC701009_HanyoList_KagoMoshitate");

    /**
     *
     * @param div HanyoListParameDiv
     *
     */
    public HanyoListParameHandler(HanyoListParameDiv div) {
        this.div = div;
    }

    /**
     * initializeのメソッドます。
     *
     */
    public void initialize() {
        div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();

        List<RString> selectKey = new ArrayList<>();
        selectKey.add(項目名);
        selectKey.add(日付);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(selectKey);

        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (事務広域.equals(市町村情報セキュリティ情報.get導入形態コード().value())) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(true);
        } else {
            //TODO QA1294
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisabled(true);
        }

        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
    }

    /**
     * バッチパラメータ
     *
     * @return DBC710090_HanyoListKagoMoshitateParameter
     */
    public DBC710090_HanyoListKagoMoshitateParameter setBatchParameter() {
        DBC710090_HanyoListKagoMoshitateParameter parameter = new DBC710090_HanyoListKagoMoshitateParameter();
        parameter.set国保連送付年月From(new FlexibleDate(div.getChushutsuJokenPanel().getTxtKokuhorenSofuNengetu().getFromValue().toString()));
        parameter.set国保連送付年月To(new FlexibleDate(div.getChushutsuJokenPanel().getTxtKokuhorenSofuNengetu().getToValue().toString()));

        if (div.getChushutsuJokenPanel().getRadKagoMoshitateKyufuKubun().getSelectedKey().equals(KagoMoshitate_HokenshaKubun.すべて.getコード())) {
            parameter.set過誤申立給付区分(null);
        } else {
            parameter.set過誤申立給付区分(div.getChushutsuJokenPanel().getRadKagoMoshitateKyufuKubun().getSelectedKey());
        }

        parameter.setサービス提供年月From(new FlexibleDate(div.getChushutsuJokenPanel().getTxtSabisuTeikyoNengetu().getFromValue().toString()));
        parameter.setサービス提供年月To(new FlexibleDate(div.getChushutsuJokenPanel().getTxtSabisuTeikyoNengetu().getToValue().toString()));
        parameter.set事業者コード(div.getChushutsuJokenPanel().getCcdJigyoshaBango().getNyuryokuShisetsuKodo());
        parameter.set事業者名(div.getChushutsuJokenPanel().getCcdJigyoshaBango().getNyuryokuShisetsuMeisho());

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
        parameter.set保険者コード(div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード());

        parameter.set出力順(new RString(div.getCcdShutsuryokujun().get出力順ID()));
        parameter.set出力項目(null);
        return parameter;
    }
}

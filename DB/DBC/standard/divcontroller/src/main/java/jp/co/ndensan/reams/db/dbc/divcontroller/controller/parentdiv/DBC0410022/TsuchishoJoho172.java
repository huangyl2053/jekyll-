/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410022;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120190.DBC120190_SaishinsaKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410022.TsuchishoJoho172Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 国保連情報受取データ取込_[172]介護給付費再審査決定通知書情報
 *
 * @reamsid_L DBC-0980-170 quxiaodong
 */
public class TsuchishoJoho172 {

    /**
     * onLoad事件
     *
     * @param div TsuchishoJoho162Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho172Div> onLoad(TsuchishoJoho172Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().
                get帳票分類管理(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200048.getReportId());
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho152Div
     * @return ResponseData
     */
    public ResponseData<DBC120190_SaishinsaKetteiHokenshaInParameter> onImplement(TsuchishoJoho172Div div) {
        DBC120190_SaishinsaKetteiHokenshaInParameter parameter = new DBC120190_SaishinsaKetteiHokenshaInParameter();
        if (div.getCcdKokurenJohoTorikomi().get処理年月() != null) {
            parameter.set処理年月(new FlexibleYearMonth(
                    div.getCcdKokurenJohoTorikomi().get処理年月().getYearMonth().toDateString()));
        }
        if (div.getCcdKokurenJohoTorikomi().get出力順ID() != null) {
            parameter.set出力順ID(new RString(div.getCcdKokurenJohoTorikomi().get出力順ID()));
        }
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.set再処理区分(SaiShoriKubun.再処理);
        } else {
            parameter.set再処理区分(SaiShoriKubun.空白);
        }
        return ResponseData.of(parameter).respond();
    }

}

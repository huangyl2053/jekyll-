/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410021;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120160.DBC120160_KagoKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410021.TsuchishoJoho171Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 *
 * DBCMNF2002_国保連情報受取データ取込_[171]介護給付費過誤決定通知書情報
 *
 * @reamsid_L DBC-0980-160 quxiaodong
 */
public class TsuchishoJoho171 {

    /**
     * onLoad事件
     *
     * @param div TsuchishoJoho171Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho171Div> onLoad(TsuchishoJoho171Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200050.getReportId());
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho171Div
     * @return ResponseData
     */
    public ResponseData<DBC120160_KagoKetteiHokenshaInParameter> onImplement(TsuchishoJoho171Div div) {
        DBC120160_KagoKetteiHokenshaInParameter parameter = new DBC120160_KagoKetteiHokenshaInParameter();
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
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120160_KagoKetteiHokenshaIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }
}

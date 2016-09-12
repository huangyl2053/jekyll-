/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410021;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kagoketteihokenshain.KagoKetteiHokenshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410021.TsuchishoJoho171Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
                new ReportId(new RString("DBC200050_KagoKetteitsuchishoTorikomiIchiranHokenshaBun")));
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
    public ResponseData<KagoKetteiHokenshaInBatchParameter> onImplement(TsuchishoJoho171Div div) {
        KagoKetteiHokenshaInBatchParameter parameter = new KagoKetteiHokenshaInBatchParameter();
        if (div.getCcdKokurenJohoTorikomi().get処理年月() != null) {
            parameter.setShoriYM(new FlexibleYearMonth(
                    div.getCcdKokurenJohoTorikomi().get処理年月().getYearMonth().toDateString()));
        }
        if (div.getCcdKokurenJohoTorikomi().get出力順ID() != null) {
            parameter.setShuturyokuJunn(div.getCcdKokurenJohoTorikomi().get出力順ID());
        }
        return ResponseData.of(parameter).respond();
    }
}

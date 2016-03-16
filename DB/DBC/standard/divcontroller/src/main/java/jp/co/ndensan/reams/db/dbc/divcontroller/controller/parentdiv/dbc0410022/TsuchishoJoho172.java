/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410022;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410022.TsuchishoJoho172Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 国保連情報受取データ取込_[172]介護給付費再審査決定通知書情報
 */
public class TsuchishoJoho172 {

    /**
     * onLoad事件
     *
     * @param div TsuchishoJoho162Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho172Div> onLoad(TsuchishoJoho172Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = new KokuhorenDataTorikomiViewStateClass(
                RDate.getNowDate().getYearMonth(), new RString("1"));
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200048_SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBun")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho152Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho172Div> onImplement(TsuchishoJoho172Div div) {
        //TODO
//        KokuhorenDataTorikomiBatchParameter  parameter =new KokuhorenDataTorikomiBatchParameter();

        div.getCcdKokurenJohoTorikomi().get再処理区分();
        div.getCcdKokurenJohoTorikomi().get処理対象情報();
        div.getCcdKokurenJohoTorikomi().get処理年月();
        div.getCcdKokurenJohoTorikomi().get出力順ID();
        ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage());

        return ResponseData.of(div).respond();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410014;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410014.TsuchishoJoho631Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 国保連情報受取データ取込_[631]介護給付費等請求額通知書（公費）情報
 */
public class TsuchishoJoho631 {

    /**
     * onLoad事件
     *
     * @param div TsuchishoJoho631Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho631Div> onLoad(TsuchishoJoho631Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = new KokuhorenDataTorikomiViewStateClass(
                RDate.getNowDate().getYearMonth(), new RString("1"));
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);
        div.getCcdKokurenJohoTorikomi().onLoadMode1();
        return ResponseData.of(div).respond();

    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho631Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho631Div> onImplement(TsuchishoJoho631Div div) {
        //TODO
        ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage());

        return ResponseData.of(div).respond();

    }

}

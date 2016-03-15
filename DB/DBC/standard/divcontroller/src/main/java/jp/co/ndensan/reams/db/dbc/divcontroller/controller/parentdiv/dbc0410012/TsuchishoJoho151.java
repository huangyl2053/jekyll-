/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012.TsuchishoJoho151Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 国保連情報受取データ取込_[151]介護給付費等請求額通知書情報 controller
 */
public class TsuchishoJoho151 {

    /**
     * onLoad事件
     *
     * @param div TsuchishoJoho151Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho151Div> onLoad(TsuchishoJoho151Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = new KokuhorenDataTorikomiViewStateClass(
                RDate.getNowDate().getYearMonth(), new RString("1"));
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);
        div.getCcdKokurenJohoTorikomi().onLoadMode1();
        return ResponseData.of(div).respond();

    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho151Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho151Div> onImplement(TsuchishoJoho151Div div) {
        //TODO
//        KokuhorenDataTorikomiBatchParameter  parameter =new KokuhorenDataTorikomiBatchParameter();

        div.getCcdKokurenJohoTorikomi().get再処理区分();
        div.getCcdKokurenJohoTorikomi().get処理対象情報();
        div.getCcdKokurenJohoTorikomi().get処理年月();

        return ResponseData.of(div).respond();

    }

}

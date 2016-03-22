/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012.TsuchishoJoho151Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

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
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        div.getCcdKokurenJohoTorikomi().get再処理区分();
        div.getCcdKokurenJohoTorikomi().get処理対象情報();
        div.getCcdKokurenJohoTorikomi().get処理年月();
        return ResponseData.of(div).respond();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410017;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410017.TsuchishoJoho122Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 国保連情報受取データ取込_(122)総合事業費資格総合表情報のクラスです。
 */
public class TsuchishoJoho122 {

    /**
     * 画面初期化のメソッド。
     *
     * @param div TsuchishoJoho122Div
     * @return 総合事業費資格総合表情報の画面。
     */
    public ResponseData<TsuchishoJoho122Div> onLoad(TsuchishoJoho122Div div) {

        div.getCcdKokurenJohoTorikomi().onLoadMode1();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下。
     *
     * @param div TsuchishoJoho122Div
     * @return TsuchishoJoho122Div
     */
    public ResponseData<TsuchishoJoho122Div> onClick_btnExcute(TsuchishoJoho122Div div) {

        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        div.getCcdKokurenJohoTorikomi().get再処理区分();
        div.getCcdKokurenJohoTorikomi().get処理年月();
        return ResponseData.of(div).respond();
    }
}

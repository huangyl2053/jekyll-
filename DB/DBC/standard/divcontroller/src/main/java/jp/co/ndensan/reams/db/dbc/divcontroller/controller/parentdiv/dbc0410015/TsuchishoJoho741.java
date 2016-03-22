/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410015.TsuchishoJoho741Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 国保連情報受取データ取込_[741]請求明細・給付管理票返戻（保留）一覧表情報のクラスです
 */
public class TsuchishoJoho741 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho741Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho741Div> onLoad(TsuchishoJoho741Div div) {
        div.getCcdKokurenJohoTorikomi().onLoadMode1();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho741Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho741Div> onClick_btnExcute(TsuchishoJoho741Div div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }
}

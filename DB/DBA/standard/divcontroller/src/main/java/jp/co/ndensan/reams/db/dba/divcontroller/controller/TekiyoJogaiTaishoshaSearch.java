/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.TekiyoJogaiTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.RootTitleSetter;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiTaishoshaSearch {

    /**
     * 読み込み時に実行し、親Divタイトルにメニュー名を設定します。
     *
     * @param taishoshaJohoDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onLoad(TekiyoJogaiTaishoshaSearchDiv taishoshaJohoDiv) {
        ResponseData<TekiyoJogaiTaishoshaSearchDiv> response = new ResponseData<>();
        response.setRootTitle(RootTitleSetter.getTitle());
        response.data = taishoshaJohoDiv;
        return response;
    }
}

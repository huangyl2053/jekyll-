/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010010Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 認定調査依頼対象者を一覧および指示ボタンを表示するパネルです。
 *
 * @author N8107 千秋雄
 */
public class DDBE2010010 {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param dDBE2010010p DDBE2010010Div
     * @return DDBE2010010DivのResponseData
     */
    public ResponseData getOnLoadData(DDBE2010010Div dDBE2010010p) {
        ResponseData response = new ResponseData<>();

        response.data = dDBE2010010p;

        return response;
    }
}

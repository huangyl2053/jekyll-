/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KoshinKakuninDialogDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * {@link KoshinKakuninDialogDiv}の制御クラスです。
 *
 * @author N3328 宮島 淳一
 */
public class KoshinKakunin {

    /**
     * {@link KoshinKakuninDialogDiv}にレスポンスデータを設定します。
     *
     * @param panel KoshinKakuninDialogDiv
     * @return {@link KoshinKakuninDialogDiv}を返します。
     */
    public ResponseData<KoshinKakuninDialogDiv> onLoad(KoshinKakuninDialogDiv panel) {
        ResponseData<KoshinKakuninDialogDiv> response = new ResponseData<>();

        response.data = panel;
        return response;
    }
}

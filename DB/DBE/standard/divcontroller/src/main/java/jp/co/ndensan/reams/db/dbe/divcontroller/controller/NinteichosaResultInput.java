/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaResultInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * NinteichosaResultInputを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultInput {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultsInputDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultInputDiv> onLoad(NinteichosaResultInputDiv div) {
        ResponseData<NinteichosaResultInputDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

}

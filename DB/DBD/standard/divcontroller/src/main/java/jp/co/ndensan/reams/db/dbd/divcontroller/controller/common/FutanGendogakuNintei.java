/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.FutanGendogakuNinteiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author N3327 三浦 凌
 */
public class FutanGendogakuNintei {

    /**
     * ロード時の処理です。
     *
     * @param div FutanGendogakuNinteiDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiDiv> onLoad(FutanGendogakuNinteiDiv div) {
        return _createResponseData(div);
    }

    public ResponseData<FutanGendogakuNinteiDiv> onStart(FutanGendogakuNinteiDiv div) {
        return _createResponseData(div);
    }

    public ResponseData<FutanGendogakuNinteiDiv> onClick_(FutanGendogakuNinteiDiv div) {
        return _createResponseData(div);
    }

    private ResponseData<FutanGendogakuNinteiDiv> _createResponseData(FutanGendogakuNinteiDiv div) {
        ResponseData<FutanGendogakuNinteiDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}

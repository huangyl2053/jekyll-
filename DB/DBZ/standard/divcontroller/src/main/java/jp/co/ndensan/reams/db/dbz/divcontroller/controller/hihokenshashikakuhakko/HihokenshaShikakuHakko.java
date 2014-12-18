/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.hihokenshashikakuhakko;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「被保険者証資格者証発行」のイベントを定義したDivControllerです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakko {

    /**
     * 画面ロード時に実行します。<br/>
     *
     * @param div {@link HihokenshaShikakuHakkoDiv 被保険者証資格者証発行Div}
     * @return 被保険者証資格者証発行Divを持つResponseData
     */
    public ResponseData<HihokenshaShikakuHakkoDiv> onLoad(HihokenshaShikakuHakkoDiv div) {

        // HihokenshaShikakuHakkoHandlerのinitialize()メソッドを呼び出す。
        return createResponseData(div);
    }

    private <T> ResponseData<T> createResponseData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}

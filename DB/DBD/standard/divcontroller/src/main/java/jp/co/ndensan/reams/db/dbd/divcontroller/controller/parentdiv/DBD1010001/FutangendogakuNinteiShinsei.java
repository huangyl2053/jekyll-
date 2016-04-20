/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001.FutangendogakuNinteiShinseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;

/**
 *
 * 負担限度額認定申請画面のDivControllerです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public class FutangendogakuNinteiShinsei {

    private static final RString 申請メニューID = new RString("DBDMN21004");

    /**
     * 画面初期化
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onLoad(FutangendogakuShinseiDiv div) {
        if (!getHandler(div).onLoad()) {
            ErrorMessage message = new ErrorMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private FutangendogakuNinteiShinseiHandler getHandler(FutangendogakuShinseiDiv div) {
        return new FutangendogakuNinteiShinseiHandler(div);
    }
}

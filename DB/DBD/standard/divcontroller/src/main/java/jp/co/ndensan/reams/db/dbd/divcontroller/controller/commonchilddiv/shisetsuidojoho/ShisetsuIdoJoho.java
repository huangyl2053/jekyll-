/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.shisetsuidojoho;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShisetsuIdoJoho.ShisetsuIdoJoho.ShisetsuIdoJohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【共有子Div】 施設入退のDivControllerです。
 *
 * @reamsid_L DBD-3560-120 wangjie2
 */
public class ShisetsuIdoJoho {

    /**
     * 画面初期化です。
     *
     * @param div ShisetsuIdoJohoDiv
     * @return ResponseData<ShisetsuIdoJohoDiv>
     */
    public ResponseData<ShisetsuIdoJohoDiv> onLoad(ShisetsuIdoJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (null == div.getHihokenshaNo() || div.getHihokenshaNo().isEmpty()) {
                throw new SystemException("被保険者番号が設定されていません。");
            }
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHihokenshaNo());
            if (!div.initializa(被保険者番号)) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるを押下します。
     *
     * @param div ShisetsuIdoJohoDiv
     * @return ResponseData<ShisetsuIdoJohoDiv>
     */
    public ResponseData<ShisetsuIdoJohoDiv> onClick_BtnClose(ShisetsuIdoJohoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

}

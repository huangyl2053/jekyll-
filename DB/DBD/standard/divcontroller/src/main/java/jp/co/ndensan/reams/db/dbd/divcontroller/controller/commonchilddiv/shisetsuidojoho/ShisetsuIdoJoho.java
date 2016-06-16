/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.shisetsuidojoho;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShisetsuIdoJoho.ShisetsuIdoJoho.ShisetsuIdoJohoDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

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
        if (null == div.getShikibetsuCode() || div.getShikibetsuCode().isEmpty()) {
            throw new SystemException("識別コードが設定されていません。");
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getShikibetsuCode());
        div.initializa(識別コード);
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

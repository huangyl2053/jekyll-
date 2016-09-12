/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.jigyotaishoshajoho;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.JigyoTaishoshaJoho.JigyoTaishoshaJoho.JigyoTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 【共有子Div】 事業対象者のDivControllerです。
 *
 * @reamsid_L DBD-3560-130 wangjie2
 */
public class JigyoTaishoshaJoho {

    /**
     * 画面初期化です。
     *
     * @param div JigyoTaishoshaJohoDiv
     * @return ResponseData<JigyoTaishoshaJohoDiv>
     */
    public ResponseData<JigyoTaishoshaJohoDiv> onLoad(JigyoTaishoshaJohoDiv div) {
        if (null == div.getHihokenshaNo() || div.getHihokenshaNo().isEmpty()) {
            throw new SystemException("被保険者番号が設定されていません。");
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHihokenshaNo());
        div.initializa(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるを押下します。
     *
     * @param div JigyoTaishoshaJohoDiv
     * @return ResponseData<JigyoTaishoshaJohoDiv>
     */
    public ResponseData<JigyoTaishoshaJohoDiv> onClick_BtnClose(JigyoTaishoshaJohoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

}

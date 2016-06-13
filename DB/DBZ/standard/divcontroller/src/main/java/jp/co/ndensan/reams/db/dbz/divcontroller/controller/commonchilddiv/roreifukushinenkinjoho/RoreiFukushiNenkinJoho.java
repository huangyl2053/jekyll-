/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.roreifukushinenkinjoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinJoho.RoreiFukushiNenkinJoho.RoreiFukushiNenkinJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 【共有子Div】 老齢福祉年金のDivControllerです。
 *
 * @reamsid_L DBD-3560-090 wangjie2
 */
public class RoreiFukushiNenkinJoho {

    /**
     * 画面初期化です。
     *
     * @param div RoreiFukushiNenkinJohoDiv
     * @return ResponseData<RoreiFukushiNenkinJohoDiv>
     */
    public ResponseData<RoreiFukushiNenkinJohoDiv> onLoad(RoreiFukushiNenkinJohoDiv div) {
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
     * @param div RoreiFukushiNenkinJohoDiv
     * @return ResponseData<RoreiFukushiNenkinJohoDiv>
     */
    public ResponseData<RoreiFukushiNenkinJohoDiv> onClick_BtnClose(RoreiFukushiNenkinJohoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

}

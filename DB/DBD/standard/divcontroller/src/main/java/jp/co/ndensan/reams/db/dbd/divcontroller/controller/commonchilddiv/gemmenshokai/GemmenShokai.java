/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.gemmenshokai;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai.GemmenShokaiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 【共有子Div】 減免照会のDivControllerです。
 */
public class GemmenShokai {

    /**
     * 画面初期化
     *
     * @param div GemmenShokaiDiv
     * @return ResponseData<GemmenShokaiDiv>
     */
    public ResponseData<GemmenShokaiDiv> onLoad(GemmenShokaiDiv div) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHihokenshaNo());
        div.initializa(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるを押下
     *
     * @param div GemmenShokaiDiv
     * @return ResponseData<GemmenShokaiDiv>
     */
    public ResponseData<GemmenShokaiDiv> onClick_BtnClose(GemmenShokaiDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

}

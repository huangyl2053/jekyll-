/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShikakuTokusoRireki;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「資格得喪履歴」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBA-0130-011 huangh
 */
public class ShikakuTokusoRireki {

    private static final RString 照会モード_Dialog = new RString("shokai_Dialog");

    /**
     * 資格得喪履歴の初期化処理します。
     *
     * @param div ShikakuTokusoRirekiDiv
     * @return 資格得喪履歴div
     */
    public ResponseData<ShikakuTokusoRirekiDiv> initialize(ShikakuTokusoRirekiDiv div) {

        if (div.getMode() != null && !div.getMode().isEmpty()) {
            if (div.getMode().equals(照会モード_Dialog)) {
                div.setDialogDisplay();
            } else {
                div.setMode_DisplayType(ShikakuTokusoRirekiDiv.DisplayType.valueOf(div.getMode().toString()));
            }
            div.initialize(new HihokenshaNo(div.getHdnHihokenshaNo()), new ShikibetsuCode(div.getHdnShikibetsuCode()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタン押下時の処理です。<br/>
     *
     * @param div {@link ShikakuTokusoRirekiDiv  資格得喪履歴Div}
     * @return 資格得喪履歴Divを持つResponseData
     */
    public ResponseData<ShikakuTokusoRirekiDiv> onClick_btnDelete(ShikakuTokusoRirekiDiv div) {

        return ResponseData.of(div).respond();
    }

}

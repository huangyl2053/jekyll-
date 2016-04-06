/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.shikakutokusorireki;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author 自動生成
 */
public class ShikakuTokusoRireki {

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

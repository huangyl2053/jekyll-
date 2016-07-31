/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4560011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011.KoshinKekkaKakuninDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム管理登録（利用者負担割合）のDivControllerクラスです。
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public class KoshinKekkaKakunin {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KoshinKekkaKakuninDiv
     * @return ResponseData<KoshinKekkaKakuninDiv>
     */
    public ResponseData<KoshinKekkaKakuninDiv> onLoad(KoshinKekkaKakuninDiv div) {
        div.getCcdKanryouMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).respond();
    }
}

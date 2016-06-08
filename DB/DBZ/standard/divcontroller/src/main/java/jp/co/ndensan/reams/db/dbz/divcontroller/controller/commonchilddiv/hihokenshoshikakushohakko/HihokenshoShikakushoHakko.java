/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 被保険者証・資格者証発行のDivControllerです。
 *
 * @reamsid_L DBA-1090-011 huangh
 */
public class HihokenshoShikakushoHakko {

    /**
     * onLoad時の処理です。<br/>
     *
     * @param div {@link HihokenshaShikakuHakkoDiv  被保険者証資格証発行Div}
     * @return 被保険者証資格証発行Divを持つResponseData
     */
    public ResponseData<HihokenshaShikakuHakkoDiv> onLoad(HihokenshaShikakuHakkoDiv div) {

        return ResponseData.of(div).respond();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAMN00000.JukyuShikakuShomeishoHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 *
 */
public class JukyuShikakuShomeishoHakko {

    /**
     * 被保険者証・資格者証発行。<br/>
     * 受給資格証明書発行情報を表示します。
     *
     * @param taishoshaJohoDiv 受給資格証明書発行共有子Div
     * @return レスポンス
     */
    public ResponseData onLoad(JukyuShikakuShomeishoHakkoDiv taishoshaJohoDiv) {
        ResponseData<JukyuShikakuShomeishoHakkoDiv> response = new ResponseData<>();
        taishoshaJohoDiv.getJukyuShikakuShomeishoHakkoDiv().initialize(new RString("100002"));
        response.data = taishoshaJohoDiv;
        return response;
    }

}

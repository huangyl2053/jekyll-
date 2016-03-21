/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shisetsunyushoinfo;

import jp.co.ndensan.reams.db.dbz.business.core.shisetsunyushoinfo.ShisetSunyushoInfoBusiness;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.ShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.shisetsunyushoinfo.ShisetSunyushoInfoManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入所情報のダイアログのDivControllerです
 *
 */
public class ShisetSunyushoInfoHandler {

    private final ShisetSunyushoInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShisetSunyushoInfoDiv
     */
    public ShisetSunyushoInfoHandler(ShisetSunyushoInfoDiv div) {
        this.div = div;
    }

    /**
     * 施設入所情報の初期化処理です。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void initialize(ShikibetsuCode 識別コード) {
        ShisetSunyushoInfoBusiness business = ShisetSunyushoInfoManager.createInstance().onLoad(識別コード);
        if (business != null) {
            div.getTxtNyushoShisetsuCode().setValue(
                    business.get入所施設コード() == null ? RString.EMPTY : business.get入所施設コード().value());
            div.getTxtNyushoShisetsuName().setValue(
                    business.get事業者名称() == null ? RString.EMPTY : new RString(business.get事業者名称().toString()));
            div.getTxtShisetsunyuShoDay().setValue(business.get入所年月日());
            div.getTxtShisetsuTaishoDay().setValue(business.get退所年月日());

        }

    }
}

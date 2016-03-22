/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.ShisetSunyushoInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shisetsunyushoinfo.ShisetSunyushoInfoBusiness;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.ShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.shisetsunyushoinfo.ShisetSunyushoInfoFinder;
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
        List<ShisetSunyushoInfoBusiness> businesslist = ShisetSunyushoInfoFinder.createInstance().onLoad(識別コード).records();

        for (ShisetSunyushoInfoBusiness shinsakaij : businesslist) {
            div.getTxtNyushoShisetsuCode().setValue(
                    shinsakaij.get入所施設コード() == null ? RString.EMPTY : shinsakaij.get入所施設コード().value());
            div.getTxtNyushoShisetsuName().setValue(
                    shinsakaij.get事業者名称() == null ? RString.EMPTY : shinsakaij.get事業者名称().value());
            div.getTxtShisetsunyuShoDay().setValue(shinsakaij.get入所年月日());
            div.getTxtShisetsuTaishoDay().setValue(shinsakaij.get退所年月日());
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.chosakekkainfogaikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyoHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果情報照会_概況調査取得処理。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyo {

    /**
     * 認定調査結果情報照会_概況調査_一覧情報。
     *
     * @param div 認定調査結果情報照会_概況調査_一覧情報Div
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onLoad(ChosaKekkaInfoGaikyoDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        int 認定調査依頼履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class).toString());
        RString 概況調査テキスト_イメージ区分 = ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class);
        ChosaKekkaInfoGaikyoParameter gaikyoParameter = ChosaKekkaInfoGaikyoParameter.
                createGamenParam(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキスト_イメージ区分);
        List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList
                = ChosaKekkaInfoGaikyoFinder.createInstance().getChosaKekkaInfoGaikyo(gaikyoParameter).records();
        List<RembanServiceJokyoBusiness> serviceJokyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().getRembanServiceJokyo(gaikyoParameter).records();
        List<NinteichosahyoShisetsuRiyo> shisetsuRiyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().get5210NinteichosahyoShisetsu(gaikyoParameter).records();
        getHandler(div).onLoad(chosaKekkaInfoGaikyoList, serviceJokyos, shisetsuRiyos);
        return createResponse(div);
    }

    /**
     * 戻るボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ChosaKekkaInfoGaikyoDiv>
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onClick_Moderu(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

    private ChosaKekkaInfoGaikyoHandler getHandler(ChosaKekkaInfoGaikyoDiv div) {
        return new ChosaKekkaInfoGaikyoHandler(div);
    }

    private ResponseData<ChosaKekkaInfoGaikyoDiv> createResponse(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

}

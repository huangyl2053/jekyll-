/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.chosakekkainfokihon;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.ChosaKekkaInfoKihonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.TokiJikouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfokihon.ChosaKekkaInfoKihonParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon.ChosaKekkaInfoKihonDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon.ChosaKekkaInfoKihonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfokihon.ChosaKekkaInfoKihonFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果情報照会_基本調査取得処理。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public class ChosaKekkaInfoKihon {

    /**
     * 認定調査結果情報照会_基本調査_一覧情報。
     *
     * @param div 認定調査結果情報照会_基本調査_一覧情報Div
     * @return ResponseData<ChosaKekkaInfoKihonDiv>
     */
    public ResponseData<ChosaKekkaInfoKihonDiv> onLoad(ChosaKekkaInfoKihonDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        int 認定調査依頼履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class).toString());
        ChosaKekkaInfoKihonParameter gaikyoParameter = ChosaKekkaInfoKihonParameter.
                createGamenParam(申請書管理番号, 認定調査依頼履歴番号);
        List<ChosaKekkaInfoKihonBusiness> infoKihonList
                = ChosaKekkaInfoKihonFinder.createInstance().getChosaKekkaInfoKihon(gaikyoParameter).records();
        List<TokiJikouBusiness> serviceJokyos
                = ChosaKekkaInfoKihonFinder.createInstance().getTokiJikou(gaikyoParameter).records();
        getHandler(div).onLoad(infoKihonList, serviceJokyos);
        return createResponse(div);
    }

    /**
     * 戻るボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ChosaKekkaInfoGaikyoDiv>
     */
    public ResponseData<ChosaKekkaInfoKihonDiv> onClick_Moderu(ChosaKekkaInfoKihonDiv div) {
        return ResponseData.of(div).respond();
    }

    private ChosaKekkaInfoKihonHandler getHandler(ChosaKekkaInfoKihonDiv div) {
        return new ChosaKekkaInfoKihonHandler(div);
    }

    private ResponseData<ChosaKekkaInfoKihonDiv> createResponse(ChosaKekkaInfoKihonDiv div) {
        return ResponseData.of(div).respond();
    }
}

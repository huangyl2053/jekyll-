/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0041011;

import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0041011.KyodoIdoRenrakuhyoHenkoDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0041011.KyodoIdoRenrakuhyoHenkoDetailHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共同処理用受給者異動連絡票情報照会のControllerです。
 *
 * @reamsid_L DBC-2990-010 chenaoqi
 */
public class KyodoIdoRenrakuhyoHenkoDetail {

    private static final RString MESSAGE = new RString("被保険者番号なし");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyodoIdoRenrakuhyoHenkoDetailDiv
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoHenkoDetailDiv> onLoad(KyodoIdoRenrakuhyoHenkoDetailDiv div) {
        KyodoJukyushaTaishoshaEntity 対象者一覧
                = ViewStateHolder.get(ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        if (対象者一覧 == null || 対象者一覧.get被保番号() == null) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(MESSAGE.toString()).evaluate());
        }
        getHandler(div).load共有子Div(対象者一覧);
        return createResponse(div);
    }

    private KyodoIdoRenrakuhyoHenkoDetailHandler getHandler(KyodoIdoRenrakuhyoHenkoDetailDiv div) {
        return new KyodoIdoRenrakuhyoHenkoDetailHandler(div);
    }

    private ResponseData<KyodoIdoRenrakuhyoHenkoDetailDiv> createResponse(KyodoIdoRenrakuhyoHenkoDetailDiv div) {
        return ResponseData.of(div).respond();
    }

}

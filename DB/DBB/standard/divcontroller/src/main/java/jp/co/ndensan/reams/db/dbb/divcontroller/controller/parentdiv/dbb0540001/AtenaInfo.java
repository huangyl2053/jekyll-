/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0540001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.AtenaInfoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0540001.AtenaInfoHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 徴収方法変更_ヘッダエリアのクラスです。
 */
public class AtenaInfo {

    /**
     * 画面初期化
     *
     * @param div AtenaInfoDiv
     * @return ResponseData
     */
    public ResponseData<AtenaInfoDiv> onLoad(AtenaInfoDiv div) {

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 該当者検索画面ViewState．被保険者番号
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(new RString("88888888")));
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);

        AtenaInfoHandler handler = new AtenaInfoHandler(div);
        handler.setヘッダエリア(識別コード, 被保険者番号);

        return ResponseData.of(div).respond();
    }
}

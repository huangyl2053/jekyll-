/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0540001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.AtenaInfoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 徴収方法変更_ヘッダエリアのハンドラクラスです。
 */
public class AtenaInfoHandler {

    private final AtenaInfoDiv div;
    private static final RString 再検索する = new RString("btnResearch");
    private static final RString 検索結果一覧へ = new RString("btnSearchResult");
    private static final RString 保存する = new RString("btnUpdate");

    /**
     * ChoshuInfoHandler
     *
     * @param div ChoshuInfoDiv
     */
    public AtenaInfoHandler(AtenaInfoDiv div) {
        this.div = div;
    }

    /**
     * 初期状態のヘッダエリア
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void setヘッダエリア(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
//        div.getKiagoAtenaInfo().onLoad(識別コード);
        // TODO QA
//        div.getKaigoFukaKihon().load(被保険者番号);
        this.set共通エリア();

    }

    private void set共通エリア() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
    }

}

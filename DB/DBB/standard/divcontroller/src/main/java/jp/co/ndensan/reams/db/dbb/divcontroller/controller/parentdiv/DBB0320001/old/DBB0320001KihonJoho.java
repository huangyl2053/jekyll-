/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001.old;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001KihonJohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会の基本情報Divです。
 *
 * @author N3317 塚田 萌
 */
public class DBB0320001KihonJoho {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBB0320001KihonJohoDiv> onLoad(DBB0320001KihonJohoDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBB0320001KihonJohoDiv> onActive(DBB0320001KihonJohoDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivの「状態」が遷移した際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBB0320001KihonJohoDiv> onStateTransition(DBB0320001KihonJohoDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<DBB0320001KihonJohoDiv> initialize(DBB0320001KihonJohoDiv div) {

        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();

        //div.getCcdKaigoAtenaInfo().set介護宛名賦課モード();
        div.getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());

        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                taishoshaKey.get通知書番号(),
                taishoshaKey.get賦課年度(),
                taishoshaKey.get市町村コード(),
                // new LasdecCode(taishoshaKey.get市町村コード().value()),
                taishoshaKey.get識別コード()).build();
        div.getCcdKaigoFukaKihon().load(searchKey);

        return createResponseData(div);
    }

    private ResponseData<DBB0320001KihonJohoDiv> createResponseData(DBB0320001KihonJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<DBB0320001KihonJohoDiv> onClick_btnZenkairesultHyoji(DBB0320001KihonJohoDiv div) {
        return clearViewStateKeys(div);
    }

    private ResponseData<DBB0320001KihonJohoDiv> clearViewStateKeys(DBB0320001KihonJohoDiv div) {
        FukaShokaiController.clearFukaTaishoshaKeyAndFukaShokaiKey();
        return ResponseData.of(div).respond();
    }

    public ResponseData<DBB0320001KihonJohoDiv> onClick_btnResearch(DBB0320001KihonJohoDiv div) {
        return clearViewStateKeys(div);
    }
}

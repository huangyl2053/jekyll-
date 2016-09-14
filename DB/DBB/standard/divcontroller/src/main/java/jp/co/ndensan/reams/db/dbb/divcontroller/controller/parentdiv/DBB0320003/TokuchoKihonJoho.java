/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320003;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.TokuchoKihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 賦課照会の基本情報Divです。
 *
 * @author N3317 塚田 萌
 */
public class TokuchoKihonJoho {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoKihonJohoDiv> onload(TokuchoKihonJohoDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoKihonJohoDiv> onActive(TokuchoKihonJohoDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoKihonJohoDiv> initialize(TokuchoKihonJohoDiv div) {

        // TODO 介護宛名情報（共有子Div）の賦課モードが実装してない
//        div.getCcdKaigoAtenaInfo().set介護宛名賦課モード();
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                taishoshaKey.get通知書番号(), taishoshaKey.get賦課年度(),
                new LasdecCode(taishoshaKey.get市町村コード().value()), taishoshaKey.get識別コード()).build();
        // 宛名情報の設定
        div.getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());
        // 賦課基本情報の設定
        div.getCcdKaigoFukaKihon().load(searchKey);
        return createResponseData(div);
    }

    private ResponseData<TokuchoKihonJohoDiv> createResponseData(TokuchoKihonJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link TokuchoKihonJohoDiv}
     * @return {@link ResponseData}
     */
    public ResponseData<TokuchoKihonJohoDiv> onClick_btnZenkairesultHyoji(TokuchoKihonJohoDiv div) {
        return clearViewStateKeys(div);
    }

    private ResponseData<TokuchoKihonJohoDiv> clearViewStateKeys(TokuchoKihonJohoDiv div) {
        FukaShokaiController.clearFukaTaishoshaKeyAndFukaShokaiKey();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link TokuchoKihonJohoDiv}
     * @return {@link ResponseData}
     */
    public ResponseData<TokuchoKihonJohoDiv> onClick_btnResearch(TokuchoKihonJohoDiv div) {
        return clearViewStateKeys(div);
    }
}

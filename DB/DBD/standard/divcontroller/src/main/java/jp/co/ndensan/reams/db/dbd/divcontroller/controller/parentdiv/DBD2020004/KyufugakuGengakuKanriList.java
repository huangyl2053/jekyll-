/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020004;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.kyufugakugengakukanrilist.KyufugakuGengakuKanriListFlowParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004.DBD2020004StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004.KyufugakuGengakuKanriListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020004.KyufugakuGengakuKanriListHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020004.KyufugakuGengakuKanriListValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付額減額管理リストのイベントを定義したDivControllerです。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
public class KyufugakuGengakuKanriList {

    /**
     * 給付額減額管理リストDivの初期化を表します。
     *
     * @param div KyufugakuGengakuKanriListDiv
     * @return ResponseData
     */
    public ResponseData<KyufugakuGengakuKanriListDiv> onLoad(KyufugakuGengakuKanriListDiv div) {

        createHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    private KyufugakuGengakuKanriListHandler createHandler(KyufugakuGengakuKanriListDiv div) {
        return new KyufugakuGengakuKanriListHandler(div);
    }

    /**
     * 登録者の「選択」処理です。
     *
     * @param div KyufugakuGengakuKanriListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<KyufugakuGengakuKanriListDiv> onChange_chushutuJoken(KyufugakuGengakuKanriListDiv div) {
        createHandler(div).onChange_chushutuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 減額適用中者チェックボックスの「選択」処理です。
     *
     * @param div KyufugakuGengakuKanriListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<KyufugakuGengakuKanriListDiv> onClick_chkGengakuTekiyochuSha(KyufugakuGengakuKanriListDiv div) {
        createHandler(div).onClick_chkGengakuTekiyochuSha();
        return ResponseData.of(div).respond();
    }

    /**
     * 減額終了日抽出チェックボックスの「選択」処理です。
     *
     * @param div KyufugakuGengakuKanriListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<KyufugakuGengakuKanriListDiv> onChange_chkGengakuShuryoDate(KyufugakuGengakuKanriListDiv div) {
        createHandler(div).onChange_chkGengakuShuryoDate();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン押下の処理です。
     *
     * @param div KyufugakuGengakuKanriListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<KyufugakuGengakuKanriListFlowParameter> onClick_batchParameter(KyufugakuGengakuKanriListDiv div) {
        ResponseData<KyufugakuGengakuKanriListFlowParameter> responseData = new ResponseData<>();
        responseData.data = createHandler(div).batchParameter();
        return responseData;
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div ChushutuJokenDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<KyufugakuGengakuKanriListDiv> onClick_btnCheck(KyufugakuGengakuKanriListDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor基準日の必須入力(pairs, div);
        getValidationHandler().validateFor減額終了日抽出_終了日が開始日以前(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        return ResponseData.of(div).setState(DBD2020004StateName.Default);
    }

    private KyufugakuGengakuKanriListValidationHandler getValidationHandler() {
        return new KyufugakuGengakuKanriListValidationHandler();
    }
}

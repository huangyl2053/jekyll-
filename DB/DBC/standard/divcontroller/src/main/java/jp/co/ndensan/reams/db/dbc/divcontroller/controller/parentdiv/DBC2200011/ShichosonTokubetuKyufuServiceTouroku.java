/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuValidationHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC2200011_市町村特別給付サービス内容登録のControllerクラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public class ShichosonTokubetuKyufuServiceTouroku {

    /**
     * 画面初期化を実行します。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onLoad(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onClick_btnDelete(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        getHandler(div).initialize削除モード();
        getHandler(div).選択行データ処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加する」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onClick_btnTsuika(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        getHandler(div).initialize追加モード();
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onClick_btnModify(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        getHandler(div).initialize修正モード();
        getHandler(div).選択行データ処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の行選択処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onSelect(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        getHandler(div).onSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除やめる」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onClick_cancelDelete(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        boolean is項目が変更 = getHandler(div).is項目が変更();
        if (is項目が変更) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).initialize();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加やめる」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onClick_cancelInsert(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).initialize();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正やめる」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onClick_cancelModify(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).initialize();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン処理です。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     * @return ResponseData
     */
    public ResponseData<ShichosonTokubetuKyufuServiceTourokuDiv> onSave(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save();
            return ResponseData.of(div).addMessage(DbzInformationMessages.保存処理完了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShichosonTokubetuKyufuServiceTourokuHandler getHandler(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        return new ShichosonTokubetuKyufuServiceTourokuHandler(div);
    }

    private ShichosonTokubetuKyufuServiceTourokuValidationHandler getValidationHandler(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        return new ShichosonTokubetuKyufuServiceTourokuValidationHandler(div);
    }
}

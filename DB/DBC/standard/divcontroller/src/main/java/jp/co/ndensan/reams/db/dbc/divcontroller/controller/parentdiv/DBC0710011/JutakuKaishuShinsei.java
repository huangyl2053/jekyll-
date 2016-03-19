/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0710011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.DBC0710011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.JutakuKaishuShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0710011.JutakuKaishuShinseiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 住宅改修費支給申請クラスです
 */
public class JutakuKaishuShinsei {

    private static final RString 画面モード_支給申請 = new RString("支給申請モード");
    private static final RString 画面モード_事前申請 = new RString("事前申請モード");
    private static final RString 申請区分事前申請 = new RString("1");
    private static final RString 申請区分取消 = new RString("9");

    /**
     * 画面ロードメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 画面初期化
     */
    public ResponseData<JutakuKaishuShinseiDiv> onLoad(JutakuKaishuShinseiDiv div) {
        // TODO ViewStateHolderから引き継ぎデータEntityを取得する
//        ViewStateHolder 引き継ぎデータEntity = ViewStateHolder.get(ViewStateKeys.パラメータ, XXX.class);
        //TODO 引き継ぎデータEntity.識別コード
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().onLoad(識別コード);
        //TODO 引き継ぎデータEntity.被保険者番号
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().onLoad(識別コード);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        JutakuKaishuShinseiHandler handler = getHandler(div);
        //TODO 引き継ぎデータEntity.画面モード
        RString 画面モード = new RString("事前申請モード");
        handler.onLoad(被保険者番号, 画面モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請を追加するメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 本画面
     */
    public ResponseData<JutakuKaishuShinseiDiv> onClick_btnAddShinsei(JutakuKaishuShinseiDiv div) {
        JutakuKaishuShinseiHandler handler = getHandler(div);
        handler.setAddMode();
        //TODO 引き継ぎデータEntity.画面モード
        RString 画面モード = new RString("支給申請モード");
        if (画面モード_支給申請.equalsIgnoreCase(画面モード)) {
            // TODO QA 466 住宅改修費支給申請登録画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        } else if (画面モード_事前申請.equalsIgnoreCase(画面モード)) {
            // TODO QA 466 住宅改修費事前申請登録画面へ遷移する
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 該当行の修正するメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 本画面
     */
    public ResponseData<JutakuKaishuShinseiDiv> onClick_btnModify(JutakuKaishuShinseiDiv div) {
        JutakuKaishuShinseiHandler handler = getHandler(div);
        //TODO 引き継ぎデータEntity.画面モード
        RString 画面モード = new RString("支給申請モード");
        handler.setModifyMode(画面モード);
        if (画面モード_支給申請.equalsIgnoreCase(画面モード)) {
            // TODO QA 466 住宅改修費支給申請登録画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        } else if (画面モード_事前申請.equalsIgnoreCase(画面モード)) {
            // TODO QA 466 住宅改修費事前申請登録画面へ遷移する
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 該当行の削除するメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 本画面
     */
    public ResponseData<JutakuKaishuShinseiDiv> onClick_btnDelete(JutakuKaishuShinseiDiv div) {
        JutakuKaishuShinseiHandler handler = getHandler(div);
        //TODO 引き継ぎデータEntity.画面モード
        RString 画面モード = new RString("支給申請モード");
        handler.setDeleteMode();
        RString 申請区分 = div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList().getClickedItem()
                .getTxtShinseiKubun();
        if (画面モード_支給申請.equalsIgnoreCase(画面モード) && !申請区分事前申請.equals(申請区分)) {
            // TODO QA 466 住宅改修費支給申請登録画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        } else if (画面モード_事前申請.equalsIgnoreCase(画面モード)
                || (画面モード_支給申請.equalsIgnoreCase(画面モード) && 申請区分事前申請.equals(申請区分))) {
            // TODO QA 466 住宅改修費事前申請登録画面へ遷移する
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 該当行の取り消しするメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 本画面
     */
    public ResponseData<JutakuKaishuShinseiDiv> onClick_btnCancel(JutakuKaishuShinseiDiv div) {
        RString 申請区分 = div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList().getClickedItem()
                .getTxtShinseiKubun();
        if (申請区分取消.equals(申請区分)) {
            // TODO QA番号：468
//            throw new ApplicationException(DbcErrorMessages.該当データが既に取消.getMessage());
        }
        JutakuKaishuShinseiHandler handler = getHandler(div);
        handler.setCancelMode();
        //TODO 引き継ぎデータEntity.画面モード
        RString 画面モード = new RString("支給申請モード");
        if (画面モード_支給申請.equalsIgnoreCase(画面モード)) {
            // TODO QA 466 住宅改修費支給申請登録画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        } else if (画面モード_事前申請.equalsIgnoreCase(画面モード)) {
            // TODO QA 466 住宅改修費事前申請登録画面へ遷移する
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 個人検索へ戻るメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 本画面
     */
    public ResponseData<JutakuKaishuShinseiDiv> onClick_btnBackSearch(JutakuKaishuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.検索条件).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 該当者一覧へ戻るメソッド
     *
     * @param div 住宅改修費支給申請DIV
     * @return 本画面
     */
    public ResponseData<JutakuKaishuShinseiDiv> onClick_btnBackResult(JutakuKaishuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0710011TransitionEventName.該当者一覧).respond();
        }
        return ResponseData.of(div).respond();
    }

    private JutakuKaishuShinseiHandler getHandler(JutakuKaishuShinseiDiv div) {
        return JutakuKaishuShinseiHandler.of(div);
    }
}

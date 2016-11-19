/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4520011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.DBC4520011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouFinder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManeger;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManegerHolder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護支援専門員登録画面 divcontrollerクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmonkaToroku {

    private static final LockingKey 前排他ロックキー = new LockingKey("DbT7064CareManeger");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString メニューID_追加 = new RString("DBCMNH2011");
    private static final RString メニューID_修正 = new RString("DBCMNH2012");
    private static final RString 追加タイトル = new RString("介護支援専門員登録・追加");
    private static final RString 修正タイトル = new RString("介護支援専門員登録・修正");

    private static final RString 事業者入力モード = new RString("事業者入力モード");

    private KaigoSienSenmonkaTorokuHandler getHandler(KaigoSienSenmonkaTorokuDiv div) {
        return new KaigoSienSenmonkaTorokuHandler(div);
    }

    private KaigoSienSenmonkaTorokuValidationHandler getValidationHandler(KaigoSienSenmonkaTorokuDiv div) {
        return new KaigoSienSenmonkaTorokuValidationHandler(div);
    }

    /**
     * 介護支援専門員登録画面 初期化を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onLoad(KaigoSienSenmonkaTorokuDiv div) {
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
        RString メニューID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 事業者入力モード);
        getHandler(div).onLoad();
        if (メニューID_追加.equals(メニューID)) {
            div.getKaigoShienSenmoninIchiran().getBtnTuika().setDisplayNone(false);
            return ResponseData.of(div).rootTitle(追加タイトル).respond();
        }
        if (メニューID_修正.equals(メニューID)) {
            div.getKaigoShienSenmoninIchiran().getBtnTuika().setDisplayNone(true);
            return ResponseData.of(div).rootTitle(修正タイトル).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 RAD選択を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_radChange(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_radChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「条件をクリアする」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnClear(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「検索する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnSearch(KaigoSienSenmonkaTorokuDiv div) {
        KaigoShienSenmoninJouhouParameter param = getHandler(div).getParameter();
        KaigoShienSenmoninJouhouFinder finder = KaigoShienSenmoninJouhouFinder.createInstance();
        List<KaigoShienSenmoninJouhouResult> resultList = finder.get介護支援専門員情報(param);
        List<CareManeger> careManagerList = new ArrayList<>();
        if (resultList != null && (!resultList.isEmpty())) {
            for (KaigoShienSenmoninJouhouResult result : resultList) {
                careManagerList.add(result.getCareManeger());
            }
            ViewStateHolder.put(ViewStateHolderName.介護支援専門員登録情報, new CareManegerHolder(careManagerList));
        }
        getHandler(div).onClick_btnSearch(resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「追加する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnTsuika(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnTsuika();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 介護支援専門員一覧DataGrid、「修正」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnModify(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnModify();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 介護支援専門員一覧DataGrid、「削除」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnDelete(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnDelete();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「保存する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnSave(KaigoSienSenmonkaTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (状態_追加.equals(div.getOperateState())) {
                ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
                if (pairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(pairs).respond();
                }
            }
            RString 介護支援専門員番号 = div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango().getValue();
            RString 介護支援専門員氏名 = div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().getValue();
            boolean isSuccess = getHandler(div).介護支援専門員登録情報を保存する(介護支援専門員番号);
            if (isSuccess) {
                onClick_btnSearch(div);
            }
            RString 完了メッセージ = isSuccess ? new RString(UrInformationMessages.保存終了.getMessage().evaluate())
                    : new RString(UrErrorMessages.異常終了.getMessage().evaluate());
            getHandler(div).介護完了メッセージパネルを表示する(完了メッセージ, 介護支援専門員番号, 介護支援専門員氏名, true);
            return ResponseData.of(div).setState(DBC4520011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件パネルにボタンの制御を設定します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onState(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onState(ResponseHolder.getState());
        return ResponseData.of(div).respond();
    }
}

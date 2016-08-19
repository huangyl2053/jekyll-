/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0250011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011.DBC0250011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011.DBC0250011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011.KyodoIdoRenrakuhyoTorokuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0250011.KyodoIdoRenrakuhyoTorokuMainHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN81003_共同処理用受給者異動連絡票登録のクラスです。
 *
 * @reamsid_L DBC-1950-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTorokuMain {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> onLoad(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        getHandler(div).initialize(被保険者番号, 識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡票を保存する」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> onClick_btnSave(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        boolean 保存の確認flag = new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        ValidationMessageControlPairs pairs = div.getKyodoIdoRenrakuhyoTorokuInfo().get一時差止日の入力チェック();
        pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().get一時差止日の関連チェック());
        pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().基本送付情報の異動日チェック());
        pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().償還送付情報の異動日チェック());
        pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().高額送付情報の異動日チェック());
        if (!ResponseHolder.isReRequest() && !保存の確認flag) {
            pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().基本送付情報の異動区分チェック());
            pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().償還送付情報の異動区分チェック());
            pairs.add(div.getKyodoIdoRenrakuhyoTorokuInfo().高額送付情報の異動区分チェック());
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!保存の確認flag) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            try {
                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                getHandler(div).データの登録(識別コード);
                List<RString> チェック状態 = getHandler(div).getチェックボックス状態();
                if (!チェック状態.isEmpty()) {
                    return ResponseData.of(div).respond();
                } else {
                    getHandler(div).set更新完了メッセージ();
                    return ResponseData.of(div).setState(DBC0250011StateName.更新完了);
                }
            } catch (SystemException | ApplicationException e) {
                throw new ApplicationException(e.getMessage());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        return ResponseData.of(getHandler(div).to帳票発行処理()).respond();
    }

    /**
     * 「発行」ボタンを更新完了に状態遷移のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> toAfterPrint(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        getHandler(div).set更新完了メッセージ();
        return ResponseData.of(div).setState(DBC0250011StateName.更新完了);
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> onClick_btnSearchResult(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        return getCheckMessage(div, DBC0250011TransitionEventName.検索結果一覧);
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> onClick_btnResearch(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        return getCheckMessage(div, DBC0250011TransitionEventName.再検索);
    }

    private ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> getCheckMessage(
            KyodoIdoRenrakuhyoTorokuMainDiv div,
            DBC0250011TransitionEventName eventName) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).前排他キーの解除(被保険者番号.getColumnValue());
                return ResponseData.of(div).forwardWithEventName(eventName).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        }
    }

    /**
     * 「完了する」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTorokuMainDiv> onClick_btnComplete(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0250011TransitionEventName.完了).respond();
    }

    private KyodoIdoRenrakuhyoTorokuMainHandler getHandler(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        return KyodoIdoRenrakuhyoTorokuMainHandler.of(div);
    }
}

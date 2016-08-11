/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0260012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011.DBC0250011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260012.DBC0260012StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260012.DBC0260012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260012.KyodoIdoRenrakuhyoHenkoMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260012.KyodoIdoRenrakuhyoHenkoMainHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共同処理用受給者訂正連絡票登録のクラスです。
 *
 * @reamsid_L DBC-1951-020 wangkanglei
 */
public class KyodoIdoRenrakuhyoHenkoMain {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoHenkoMainDiv> onLoad(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        KyodoJukyushaTaishoshaEntity 対象者一覧
                = ViewStateHolder.get(ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        HihokenshaNo 被保険者番号 = 対象者一覧.get被保番号();
        FlexibleDate 異動日 = 対象者一覧.get異動日();
        boolean 論理削除フラグ = 対象者一覧.is論理削除フラグ();
        FlexibleYearMonth 対象年月 = 対象者一覧.get対象年月();
        ShikibetsuCode 識別コード = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().get識別コード(被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = getHandler(div).initialize(
                被保険者番号, 異動日, 論理削除フラグ, 対象年月, 識別コード);
        ViewStateHolder.put(ViewStateKeys.共同処理用受給者異動情報, entity);
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡票を保存する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoHenkoMainDiv> onClick_btnSave(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        ValidationMessageControlPairs pairs = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get一時差止日の関連チェック();
        pairs.add(div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get一時差止日の入力チェック());
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            try {
                KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期受給者異動情報 = ViewStateHolder.get(
                        ViewStateKeys.共同処理用受給者異動情報, KyodoshoriyoJukyushaIdoRenrakuhyoParam.class);
                KyodoJukyushaTaishoshaEntity 対象者一覧
                        = ViewStateHolder.get(ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                getHandler(div).データの登録(初期受給者異動情報, 識別コード, 対象者一覧.is論理削除フラグ());
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
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        getHandler(div).set更新完了メッセージ();
        return ResponseData.of(getHandler(div).to帳票発行処理()).setState(DBC0260012StateName.更新完了);
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoHenkoMainDiv> onClick_btnSearchResult(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        return getCheckMessage(div, DBC0260012TransitionEventName.検索結果一覧);
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoHenkoMainDiv> onClick_btnResearch(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        return getCheckMessage(div, DBC0260012TransitionEventName.再検索);
    }

    private ResponseData<KyodoIdoRenrakuhyoHenkoMainDiv> getCheckMessage(
            KyodoIdoRenrakuhyoHenkoMainDiv div,
            DBC0260012TransitionEventName eventName) {
        KyodoJukyushaTaishoshaEntity 対象者一覧
                = ViewStateHolder.get(ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        HihokenshaNo 被保険者番号 = 対象者一覧.get被保番号();
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
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoHenkoMainDiv> onClick_btnComplete(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0260012TransitionEventName.完了).respond();
    }

    private KyodoIdoRenrakuhyoHenkoMainHandler getHandler(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        return KyodoIdoRenrakuhyoHenkoMainHandler.of(div);
    }
}

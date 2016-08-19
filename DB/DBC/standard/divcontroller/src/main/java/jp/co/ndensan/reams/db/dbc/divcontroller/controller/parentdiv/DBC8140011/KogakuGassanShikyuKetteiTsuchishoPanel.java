/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8140011;

import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KougakugassanShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.DBC8140011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.DBC8140011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.KogakuGassanShikyuKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8140011.KogakuGassanShikyuKetteiTsuchishoPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のクラスです。
 *
 * @reamsid_L DBC-4850-010 chenyadong
 */
public class KogakuGassanShikyuKetteiTsuchishoPanel {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onLoad(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (引き継ぎEntity.get被保険者番号() == null || 引き継ぎEntity.get被保険者番号().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcInformationMessages.被保険者でないデータ.getMessage()).respond();
            }
        }
        ShikibetsuCode 識別コード = 引き継ぎEntity.get識別コード();
        HihokenshaNo 被保険者番号 = 引き継ぎEntity.get被保険者番号();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        if (!getHandler(div).get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        ValidationMessageControlPairs validPairs = getHandler(div).initialize(被保険者番号, 識別コード);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 対象年度をonChangeします。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onChanged_ddlTaishoNendo(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = ViewStateHolder.get(ViewStateKeys.対象年度_連絡票整理番号Map, Map.class);
        getHandler(div).set連絡票整理番号(対象年度_連絡票整理番号);
        onChanged_ddlRearakuhyoSeiriNO(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡票整理番号をonChangeします。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onChanged_ddlRearakuhyoSeiriNO(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = ViewStateHolder.get(ViewStateKeys.連絡票整理番号_履歴番号Map, Map.class);
        getHandler(div).set履歴番号(連絡票整理番号_履歴番号);
        onChanged_ddlRirekiNO(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴番号をonChangeします。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onChanged_ddlRirekiNO(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        getHandler(div).set前回発行日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onClick_btnSearchResult(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        return getCheckMessage(div, DBC8140011TransitionEventName.検索結果一覧へ);
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onClick_btnResearch(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        return getCheckMessage(div, DBC8140011TransitionEventName.該当者検索へ);
    }

    private ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> getCheckMessage(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div,
            DBC8140011TransitionEventName eventName) {
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
     * 「発行」ボタン実行前、チェックを行います。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onClick_validate(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).入力項目チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        KougakugassanShikyuketteiTsuuchishoOutputEntity outputEntity = getHandler(div).editKougakugassanShikyuketteiTsuuchisho();
        RString データ有無 = outputEntity.getデータ有無();
        pairs = getHandler(div).高額合算支給情報存在エラーチェック(データ有無);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        KougakugassanShikyuketteiTsuuchishoOutputEntity outputEntity = getHandler(div).editKougakugassanShikyuketteiTsuuchisho();
        KogakuGassanShikyuKetteiTsuchisho tsuchisho = outputEntity.get事業分高額合算支給決定通知書();
        getHandler(div).データ更新();
        getHandler(div).set更新完了メッセージ();
        return ResponseData.of(getHandler(div).to帳票発行処理(tsuchisho)).setState(DBC8140011StateName.完了メッセージ);
    }

    /**
     * 「完了する」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onClick_btnComplete(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC8140011TransitionEventName.完了).respond();
    }

    private KogakuGassanShikyuKetteiTsuchishoPanelHandler getHandler(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        return new KogakuGassanShikyuKetteiTsuchishoPanelHandler(div);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8140011;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KougakugassanShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.DBC8140011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.DBC8140011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.KogakuGassanShikyuKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8140011.KogakuGassanShikyuKetteiTsuchishoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8140011.KogakuGassanShikyuKetteiTsuchishoPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
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

    private static final RString RSTRING_1 = new RString("1");

    /**
     * 画面初期化のメソッドです。
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
        RString 支払予定日印字有無 = getHandler(div).set支払予定日印字有無();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        if (!getHandler(div).get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initialize(被保険者番号, 識別コード, 支払予定日印字有無);
        List<JukyushaDaicho> 受給者台帳 = getHandler(div).get受給者台帳(被保険者番号);
        List<SogoJigyoTaishosha> 総合事業対象者 = getHandler(div).get総合事業対象者(被保険者番号);
        if (受給者台帳.isEmpty() || 総合事業対象者.isEmpty()) {
            getHandler(div).状態2();
            ValidationMessageControlPairs validPairs = getValidationHandler().受給共通_受給者登録なしチェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List = getHandler(div).
                get事業高額合算支給不支給決定List(被保険者番号);
        if (事業高額合算支給不支給決定List.isEmpty()) {
            getHandler(div).状態2();
            ValidationMessageControlPairs validPairs = getValidationHandler().高額合算支給不支給マスタデータなしチェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        initialize(div, 事業高額合算支給不支給決定List);
        return ResponseData.of(div).respond();

    }

    /**
     * 対象年度をonChangeです。
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
     * 連絡票整理番号をonChangeです。
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
     * 履歴番号をonChangeです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onChanged_ddlRirekiNO(
            KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List = ViewStateHolder.
                get(ViewStateKeys.事業高額合算支給不支給決定List, List.class);
        JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定 = getHandler(div)
                .get事業高額合算支給不支給決定(事業高額合算支給不支給決定List);
        ViewStateHolder.put(ViewStateKeys.事業高額合算支給不支給決定, 事業高額合算支給不支給決定);
        getHandler(div).set前回発行日(事業高額合算支給不支給決定);
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
     * 「発行」ボタン実行前、チェックを行いです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> onClick_validate(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定 = ViewStateHolder.
                get(ViewStateKeys.事業高額合算支給不支給決定, JigyoKogakuGassanShikyuFushikyuKettei.class);
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        if (getHandler(div).入力チェック(支払予定日印字有無)) {
            ValidationMessageControlPairs pairs = getValidationHandler().未入力チェック();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        KougakugassanShikyuketteiTsuuchishoOutputEntity outputEntity = getHandler(div).editKougakugassanShikyuketteiTsuuchisho(
                事業高額合算支給不支給決定, 識別コード, 被保険者番号, 支払予定日印字有無);
        RString データ有無 = outputEntity.getデータ有無();
        if (RSTRING_1.equals(データ有無)) {
            ValidationMessageControlPairs pairs = getValidationHandler().高額合算支給情報存在エラーチェック();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        if (div.getTxtZenkaiHakkoYMD().getValue() != null) {
            ValidationMessageControlPairs pairs = getValidationHandler().高額合算支給決定通知書発行済チェック();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
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
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定 = ViewStateHolder.
                get(ViewStateKeys.事業高額合算支給不支給決定, JigyoKogakuGassanShikyuFushikyuKettei.class);
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        KougakugassanShikyuketteiTsuuchishoOutputEntity outputEntity = getHandler(div).editKougakugassanShikyuketteiTsuuchisho(
                事業高額合算支給不支給決定, 識別コード, 被保険者番号, 支払予定日印字有無);
        KogakuGassanShikyuKetteiTsuchisho tsuchisho = outputEntity.get事業分高額合算支給決定通知書();
        getHandler(div).データ更新(事業高額合算支給不支給決定, 識別コード, 被保険者番号);
        return ResponseData.of(getHandler(div).to帳票発行処理(tsuchisho, 支払予定日印字有無)).respond();
    }

    /**
     * 「発行」ボタンを更新完了に状態遷移のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoPanelDiv> toAfterPrint(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).set更新完了メッセージ(識別コード, 被保険者番号);
        return ResponseData.of(div).setState(DBC8140011StateName.完了メッセージ);
    }

    private void initialize(KogakuGassanShikyuKetteiTsuchishoPanelDiv div,
            List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List) {
        List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List1 = getHandler(div).
                set事業高額合算支給不支給決定List(事業高額合算支給不支給決定List);
        ViewStateHolder.put(ViewStateKeys.事業高額合算支給不支給決定List, (Serializable) 事業高額合算支給不支給決定List1);
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = getHandler(div).put対象年度_連絡票整理番号(事業高額合算支給不支給決定List1);
        ViewStateHolder.put(ViewStateKeys.対象年度_連絡票整理番号Map, (Serializable) 対象年度_連絡票整理番号);
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = getHandler(div).put連絡票整理番号_履歴番号(事業高額合算支給不支給決定List1);
        ViewStateHolder.put(ViewStateKeys.連絡票整理番号_履歴番号Map, (Serializable) 連絡票整理番号_履歴番号);
        ViewStateHolder.put(ViewStateKeys.支払予定日印字有無, getHandler(div).set支払予定日印字有無());
        getHandler(div).set対象年度(対象年度_連絡票整理番号);
        getHandler(div).set連絡票整理番号(対象年度_連絡票整理番号);
        getHandler(div).set履歴番号(連絡票整理番号_履歴番号);
        JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定 = getHandler(div)
                .get事業高額合算支給不支給決定(事業高額合算支給不支給決定List1);
        ViewStateHolder.put(ViewStateKeys.事業高額合算支給不支給決定, 事業高額合算支給不支給決定);
        getHandler(div).set前回発行日(事業高額合算支給不支給決定);
    }

    private KogakuGassanShikyuKetteiTsuchishoPanelHandler getHandler(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        return new KogakuGassanShikyuKetteiTsuchishoPanelHandler(div);
    }

    private KogakuGassanShikyuKetteiTsuchishoPanelValidationHandler getValidationHandler() {
        return new KogakuGassanShikyuKetteiTsuchishoPanelValidationHandler();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1210011;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho.KogakuGassanShikyuKetteiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho.KogakuGassanShikyuKetteiTsuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1210011.DBC1210011PanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1210011.DBC1210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1210011.DBC1210011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1210011.DBC1210011PanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1210011.DBC1210011PanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN63003_高額合算支給決定通知書（単）のクラスです。
 *
 * @reamsid_L DBC-2310-010 chenyadong
 */
public class DBC1210011Panel {

    private static final RString RSTRING_1 = new RString("1");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onLoad(DBC1210011PanelDiv div) {
        if (ResponseHolder.isReRequest()
                && new RString(DbcInformationMessages.被保険者でないデータ
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if ((引き継ぎEntity.get被保険者番号() == null || RString.EMPTY.equals(
                引き継ぎEntity.get被保険者番号().getColumnValue())) && !ResponseHolder.isReRequest()) {
            ResponseData.of(div).addMessage(DbcInformationMessages.被保険者でないデータ.getMessage());
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
        RString 文書番号 = div.getCcdBunshoNO().get文書番号();
        ViewStateHolder.put(ViewStateKeys.文書番号, 文書番号);
        List<JukyushaDaicho> 受給者台帳 = getHandler(div).get受給者台帳(被保険者番号);
        List<SogoJigyoTaishosha> 総合事業対象者 = getHandler(div).get総合事業対象者(被保険者番号);
        if (受給者台帳.isEmpty() && 総合事業対象者.isEmpty()) {
            getHandler(div).状態2();
            ValidationMessageControlPairs validPairs = getValidationHandler().受給共通_受給者登録なしチェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List = getHandler(div).
                get高額合算支給不支給決定List(被保険者番号);
        List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List1 = getHandler(div).
                set高額合算支給不支給決定List(高額合算支給不支給決定List);
        if (高額合算支給不支給決定List1.isEmpty()) {
            getHandler(div).状態2();
            ValidationMessageControlPairs validPairs = getValidationHandler().高額合算支給不支給マスタデータなしチェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        initialize(div, 高額合算支給不支給決定List1);
        return ResponseData.of(div).respond();

    }

    /**
     * 対象年度をonChangeです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onChanged_ddlTaishoNendo(DBC1210011PanelDiv div) {
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = ViewStateHolder.get(ViewStateKeys.対象年度_連絡票整理番号Map, Map.class);
        getHandler(div).set連絡票整理番号(対象年度_連絡票整理番号);
        onChanged_ddlRearakuhyoSeiriNO(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡票整理番号をonChangeです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onChanged_ddlRearakuhyoSeiriNO(DBC1210011PanelDiv div) {
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = ViewStateHolder.get(ViewStateKeys.連絡票整理番号_履歴番号Map, Map.class);
        getHandler(div).set履歴番号(連絡票整理番号_履歴番号);
        onChanged_ddlRirekiNO(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴番号をonChangeです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onChanged_ddlRirekiNO(DBC1210011PanelDiv div) {
        List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List = ViewStateHolder.
                get(ViewStateKeys.高額合算支給不支給決定List, List.class);
        KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = getHandler(div)
                .get高額合算支給不支給決定(高額合算支給不支給決定List);
        ViewStateHolder.put(ViewStateKeys.高額合算支給不支給決定, 高額合算支給不支給決定);
        getHandler(div).set前回発行日(高額合算支給不支給決定);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onClick_btnSearchResult(DBC1210011PanelDiv div) {
        return getCheckMessage(div, DBC1210011TransitionEventName.検索結果一覧へ);
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onClick_btnResearch(DBC1210011PanelDiv div) {
        return getCheckMessage(div, DBC1210011TransitionEventName.該当者検索へ);
    }

    private ResponseData<DBC1210011PanelDiv> getCheckMessage(DBC1210011PanelDiv div, DBC1210011TransitionEventName eventName) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 文書番号 = ViewStateHolder.get(ViewStateKeys.文書番号, RString.class);
        if (被保険者番号 != null && !被保険者番号.isEmpty() && getHandler(div).is画面変更あり(div, 文書番号)) {
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
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onClick_validate(DBC1210011PanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = ViewStateHolder.
                get(ViewStateKeys.高額合算支給不支給決定, KogakuGassanShikyuFushikyuKettei.class);
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        if (!ResponseHolder.isReRequest()) {
            if (getHandler(div).入力チェック(支払予定日印字有無)) {
                WarningMessage message = new WarningMessage(
                        UrWarningMessages.未入力.getMessage().getCode(),
                        UrWarningMessages.未入力.getMessage().replace("支払予定日").evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(message).respond();
            } else if (div.getTxtZenkaiHakkoYMD().getValue() != null) {
                WarningMessage message = new WarningMessage(
                        DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().getCode(),
                        DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrWarningMessages.未入力.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && div.getTxtZenkaiHakkoYMD().getValue() != null) {
            WarningMessage message = new WarningMessage(
                    DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().getCode(),
                    DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();

        }
        if (new RString(DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        KogakuGassanShikyuKetteiTsuchishoOutputEntity outputEntity = getHandler(div).editKougakugassanShikyuketteiTsuuchisho(
                高額合算支給不支給決定, 識別コード, 被保険者番号, 支払予定日印字有無);
        RString データ有無 = outputEntity.getデータ有無();
        if (RSTRING_1.equals(データ有無)) {
            ValidationMessageControlPairs pairs = getValidationHandler().高額合算支給情報存在エラーチェック();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンのメソッドです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(DBC1210011PanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = ViewStateHolder.
                get(ViewStateKeys.高額合算支給不支給決定, KogakuGassanShikyuFushikyuKettei.class);
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        KogakuGassanShikyuKetteiTsuchishoOutputEntity outputEntity = getHandler(div).editKougakugassanShikyuketteiTsuuchisho(
                高額合算支給不支給決定, 識別コード, 被保険者番号, 支払予定日印字有無);
        KogakuGassanShikyuKetteiTsuchishoEntity entity = outputEntity.get高額合算支給決定通知書();
        getHandler(div).データ更新(高額合算支給不支給決定, 識別コード, 被保険者番号);
        return ResponseData.of(getHandler(div).to帳票発行処理(entity, 支払予定日印字有無)).respond();
    }

    /**
     * 「発行」ボタンを更新完了に状態遷移のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> toAfterPrint(DBC1210011PanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).set更新完了メッセージ(識別コード, 被保険者番号);
        return ResponseData.of(div).setState(DBC1210011StateName.完了メッセージ);
    }

    private void initialize(DBC1210011PanelDiv div,
            List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List) {
        ViewStateHolder.put(ViewStateKeys.高額合算支給不支給決定List, (Serializable) 高額合算支給不支給決定List);
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = getHandler(div).put対象年度_連絡票整理番号(高額合算支給不支給決定List);
        ViewStateHolder.put(ViewStateKeys.対象年度_連絡票整理番号Map, (Serializable) 対象年度_連絡票整理番号);
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = getHandler(div).put連絡票整理番号_履歴番号(高額合算支給不支給決定List);
        ViewStateHolder.put(ViewStateKeys.連絡票整理番号_履歴番号Map, (Serializable) 連絡票整理番号_履歴番号);
        ViewStateHolder.put(ViewStateKeys.支払予定日印字有無, getHandler(div).set支払予定日印字有無());
        getHandler(div).set対象年度(対象年度_連絡票整理番号);
        getHandler(div).set連絡票整理番号(対象年度_連絡票整理番号);
        getHandler(div).set履歴番号(連絡票整理番号_履歴番号);
        KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = getHandler(div)
                .get高額合算支給不支給決定(高額合算支給不支給決定List);
        ViewStateHolder.put(ViewStateKeys.高額合算支給不支給決定, 高額合算支給不支給決定);
        getHandler(div).set前回発行日(高額合算支給不支給決定);
    }

    /**
     * 「完了する」ボタンのメソッドです。
     *
     * @param div DBC1210011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1210011PanelDiv> onClick_btnComplete(DBC1210011PanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC1210011TransitionEventName.完了).respond();
    }

    private DBC1210011PanelHandler getHandler(DBC1210011PanelDiv div) {
        return new DBC1210011PanelHandler(div);
    }

    private DBC1210011PanelValidationHandler getValidationHandler() {
        return new DBC1210011PanelValidationHandler();
    }
}

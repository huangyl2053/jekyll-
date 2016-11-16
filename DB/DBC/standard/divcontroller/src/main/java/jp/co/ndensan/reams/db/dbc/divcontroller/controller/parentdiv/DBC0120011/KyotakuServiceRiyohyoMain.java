/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0120011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeDetails;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiNyushoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.DBC0120011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.DBC0120011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.KyotakuServiceRiyohyoMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.dgRiyoNentstsuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0120011.KyotakuServiceRiyohyoMainHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuTodokedeManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 居宅サービス自己作成サービス利用票登録のクラスです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class KyotakuServiceRiyohyoMain {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final RString 限度額対象外フラグ_0 = new RString("0");

    /**
     * 初期化のメソッドです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onLoad(KyotakuServiceRiyohyoMainDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 対象者.get識別コード();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
        KyotakuServiceRiyohyoMainHandler handler = getHandler(div);
        handler.initializeDisplay(被保険者番号);
        return ResponseData.of(div).setState(DBC0120011StateName.初期表示);
    }

    /**
     * 居宅サービス履歴一覧の「選択」ボタンのメソッドです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onSelect(KyotakuServiceRiyohyoMainDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        dgKyotakuServiceRirekiIchiran_Row row = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(
                row.getTaishoYM().getValue().getYearMonth().toDateString());
        int 履歴番号 = Integer.parseInt(row.getMaxRirekiNo().toString());
        KyotakuKeikakuTodokedeManager manager = new KyotakuKeikakuTodokedeManager();
        KyotakuKeikakuTodokede 居宅給付計画届出 = manager.get居宅給付計画届出(被保険者番号, 対象年月, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.居宅給付計画届出, 居宅給付計画届出);
        KyotakuServiceRiyohyoMainHandler handler = getHandler(div);
        handler.selectResult(被保険者番号, 居宅給付計画届出);
        return ResponseData.of(div).setState(DBC0120011StateName.届出表示);
    }

    /**
     * 対象情報一覧の「追加」ボタンのメソッドです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnAdd(KyotakuServiceRiyohyoMainDiv div) {
        KyotakuKeikakuTodokede 居宅給付計画届出
                = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出, KyotakuKeikakuTodokede.class);
        dgKyotakuServiceRirekiIchiran_Row row = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        RString 総合事業区分 = row.getKyotakuJigyo();
        HihokenshaNo 被保険者番号 = 居宅給付計画届出.get被保険者番号();
        FlexibleYearMonth 対象年月 = 居宅給付計画届出.get対象年月();
        int 履歴番号 = 居宅給付計画届出.get履歴番号();
        div.getCcdServiceRiyohyoInfo().initialize(追加, null, 対象年月, 被保険者番号, 総合事業区分, 履歴番号);
        init公開コントロール(div);
        return ResponseData.of(div).setState(DBC0120011StateName.明細表示);
    }

    /**
     * 居対象情報一覧の「修正」ボタンのメソッドです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnModify(KyotakuServiceRiyohyoMainDiv div) {
        KyotakuKeikakuTodokede 居宅給付計画届出
                = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出, KyotakuKeikakuTodokede.class);
        dgKyotakuServiceRirekiIchiran_Row kyotakuRow = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        dgRiyoNentstsuIchiran_Row riyoRow = div.getRiyotsukiIchiran().getDgRiyoNentstsuIchiran().getClickedItem();
        RString 総合事業区分 = kyotakuRow.getKyotakuJigyo();
        HihokenshaNo 被保険者番号 = 居宅給付計画届出.get被保険者番号();
        FlexibleYearMonth 対象年月 = 居宅給付計画届出.get対象年月();
        int 履歴番号 = 居宅給付計画届出.get履歴番号();
        div.getCcdServiceRiyohyoInfo().initialize(
                修正, new FlexibleYearMonth(riyoRow.getRiyoYM().getValue().getYearMonth().toString()),
                対象年月, 被保険者番号, 総合事業区分, 履歴番号);
        init公開コントロール(div);
        return ResponseData.of(div).setState(DBC0120011StateName.明細表示);
    }

    /**
     * 居対象情報一覧の「削除」ボタンのメソッドです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnDeleted(KyotakuServiceRiyohyoMainDiv div) {
        KyotakuKeikakuTodokede 居宅給付計画届出
                = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出, KyotakuKeikakuTodokede.class);
        dgKyotakuServiceRirekiIchiran_Row kyotakuRow = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        dgRiyoNentstsuIchiran_Row riyoRow = div.getRiyotsukiIchiran().getDgRiyoNentstsuIchiran().getClickedItem();
        RString 総合事業区分 = kyotakuRow.getKyotakuJigyo();
        HihokenshaNo 被保険者番号 = 居宅給付計画届出.get被保険者番号();
        FlexibleYearMonth 対象年月 = 居宅給付計画届出.get対象年月();
        int 履歴番号 = 居宅給付計画届出.get履歴番号();
        div.getCcdServiceRiyohyoInfo().initialize(
                削除, new FlexibleYearMonth(riyoRow.getRiyoYM().getValue().getYearMonth().toString()),
                対象年月, 被保険者番号, 総合事業区分, 履歴番号);
        init公開コントロール(div);
        return ResponseData.of(div).setState(DBC0120011StateName.明細表示);
    }

    /**
     * 「再検索する」ボタンクリック時の事件です。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnReSearch(
            KyotakuServiceRiyohyoMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0120011TransitionEventName.再検索).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnTaishoshaModoru(
            KyotakuServiceRiyohyoMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(
                DBC0120011TransitionEventName.検索結果一覧).respond();
    }

    /**
     * 「履歴一覧戻る」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnBackRirekiIchiran(
            KyotakuServiceRiyohyoMainDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        KyotakuServiceRiyohyoMainHandler handler = getHandler(div);
        handler.initializeDisplay(被保険者番号);
        return ResponseData.of(div).setState(DBC0120011StateName.初期表示);
    }

    /**
     * 「利用月一覧に戻る」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnBackRiyoNengetsuIchiran(
            KyotakuServiceRiyohyoMainDiv div) {
        return ResponseData.of(div).setState(DBC0120011StateName.届出表示);
    }

    /**
     * 「完了」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnComplete(
            KyotakuServiceRiyohyoMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0120011TransitionEventName.完了).respond();
    }

    /**
     * 子DIVの「保存する」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnUpdate(
            KyotakuServiceRiyohyoMainDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        RString 前排他キー = 排他キー.concat(被保険者番号.getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key) && !ResponseHolder.isReRequest()) {
            throw new PessimisticLockingException();
        }
        RString 表示モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        RString 居宅総合事業区分 = ViewStateHolder.get(ViewStateKeys.居宅総合事業区分, RString.class);
        TankiNyushoResult 短期入所情報 = ViewStateHolder.get(ViewStateKeys.短期入所情報, TankiNyushoResult.class);

        if (RString.isNullOrEmpty(ResponseHolder.getMessageCode())) {
            if (削除.equals(表示モード)) {
                return 削除処理(div, 居宅総合事業区分, 短期入所情報, key);
            } else if (追加.equals(表示モード)) {
                div.getCcdServiceRiyohyoInfo().DB追加処理(居宅総合事業区分, 短期入所情報);
            } else if (修正.equals(表示モード)) {
                div.getCcdServiceRiyohyoInfo().DB修正処理(居宅総合事業区分, 短期入所情報);
            }
        } else if (削除.equals(表示モード)) {
            return 削除処理(div, 居宅総合事業区分, 短期入所情報, key);
        }
        List<KyufuJikoSakuseiResult> サービス利用票情報 = div.getCcdServiceRiyohyoInfo().getサービス利用票情報();
        if (!div.getCcdServiceRiyohyoInfo().isChkZanteiKubunAllSelected()) {
            div.getCcdServiceRiyohyoInfo().データ整合性チェック(サービス利用票情報);
            return 総計チェック(div, 居宅総合事業区分, サービス利用票情報, key);
        }
        div.getCcdServiceRiyohyoInfo().init保存処理(居宅総合事業区分, サービス利用票情報);
        RealInitialLocker.release(key);
        div.getCcdKanryoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBC0120011StateName.完了);
    }

    /**
     * 「登録処理を続ける」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceRiyohyoMainDiv> onClick_btnContinue(
            KyotakuServiceRiyohyoMainDiv div) {
        return onLoad(div);
    }

    private ResponseData<KyotakuServiceRiyohyoMainDiv> 削除処理(KyotakuServiceRiyohyoMainDiv div, RString 居宅総合事業区分,
            TankiNyushoResult 短期入所情報, LockingKey key) {
        if (div.getCcdServiceRiyohyoInfo().getSofuYM() != null
                && KyufukanrihyoSakuseiKubun.新規.getコード().equals(div.getCcdServiceRiyohyoInfo().getKoshinKbn())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getCcdServiceRiyohyoInfo().DB削除処理(居宅総合事業区分, 短期入所情報);
                RealInitialLocker.release(key);
                div.getCcdKanryoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBC0120011StateName.完了);
            }
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbcQuestionMessages.自己作成_終了確認.getMessage().getCode(),
                        DbcQuestionMessages.自己作成_終了確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.自己作成_終了確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getCcdServiceRiyohyoInfo().DB削除処理(居宅総合事業区分, 短期入所情報);
                RealInitialLocker.release(key);
                div.getCcdKanryoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBC0120011StateName.完了);
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KyotakuServiceRiyohyoMainDiv> 総計チェック(KyotakuServiceRiyohyoMainDiv div,
            RString 居宅総合事業区分,
            List<KyufuJikoSakuseiResult> サービス利用票情報, LockingKey key) {
        List<ServiceTypeDetails> details = new ArrayList<>();
        for (KyufuJikoSakuseiResult result : サービス利用票情報) {
            ServiceTypeDetails detail = new ServiceTypeDetails();
            detail.setサービス単位(result.get給付計画単位数());
            detail.setサービス種類コード(result.getサービス種類コード());
            detail.setサービス項目コード(result.getサービス項目コード());
            detail.set限度額対象外フラグ(result.get限度額対象外フラグ());
            details.add(detail);
        }
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        RDate 利用年月 = div.getCcdServiceRiyohyoInfo().getRiyoYM();
        List<ServiceTypeTotal> サービス種類限度額統計 = jigoSakusei.getServiceTypeGendo(利用年月 == null ? null
                : new FlexibleYearMonth(利用年月.getYearMonth().toDateString()), details);
        for (KyufuJikoSakuseiResult result : サービス利用票情報) {
            if (result.is合計フラグ() && 限度額対象外フラグ_0.equals(result.get限度額対象外フラグ())) {
                Decimal 限度額 = Decimal.ZERO;
                サービス種類限度額統計(サービス種類限度額統計, result, 限度額);
            }
        }
        for (ServiceTypeTotal total : サービス種類限度額統計) {
            if (total.get合計単位数().compareTo(total.get限度額()) < 0 && !ResponseHolder.isReRequest()) {
                WarningMessage message = new WarningMessage(DbcQuestionMessages.限度余裕確認.getMessage().getCode(),
                        DbcQuestionMessages.限度余裕確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (total.get合計単位数().compareTo(total.get限度額()) < 0
                    && new RString(DbcQuestionMessages.限度余裕確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        div.getCcdServiceRiyohyoInfo().init保存処理(居宅総合事業区分, サービス利用票情報);
        RealInitialLocker.release(key);
        div.getCcdKanryoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBC0120011StateName.完了);
    }

    private void サービス種類限度額統計(List<ServiceTypeTotal> サービス種類限度額統計, KyufuJikoSakuseiResult result, Decimal 限度額)
            throws ApplicationException {
        if (サービス種類限度額統計.isEmpty()) {
            return;
        }
        for (ServiceTypeTotal total : サービス種類限度額統計) {
            if (result.getサービス種類コード().getColumnValue().equals(total.getサービス種類コード().getColumnValue())) {
                限度額 = total.get限度額();
                break;
            }
        }
        if (限度額.compareTo(nullToZero(result.get種類限度内単位())) < 0) {
            throw new ApplicationException(DbcErrorMessages.種類支給限度額不正.getMessage()
                    .replace(ServiceCategoryShurui.toValue(result.getサービス種類コード().getColumnValue())
                            .get名称().toString()).evaluate());
        }
    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
    }

    private void init公開コントロール(KyotakuServiceRiyohyoMainDiv div) {
        div.getCcdServiceRiyohyoInfo().setTodokedeYMD(div.getTxtTodokedeYmd().getValue());
        div.getCcdServiceRiyohyoInfo().setTekiyoKikanFrom(div.getTxtTekiyoKikan().getFromValue());
        div.getCcdServiceRiyohyoInfo().setTekiyoKikanTo(div.getTxtTekiyoKikan().getToValue());
    }

    private KyotakuServiceRiyohyoMainHandler getHandler(KyotakuServiceRiyohyoMainDiv div) {
        return KyotakuServiceRiyohyoMainHandler.of(div);
    }
}

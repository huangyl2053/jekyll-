/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0120011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.DBC0120011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.DBC0120011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.KyotakuServiceRiyohyoMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.dgRiyoNentstsuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0120011.KyotakuServiceRiyohyoMainHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuTodokedeManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    private KyotakuServiceRiyohyoMainHandler getHandler(KyotakuServiceRiyohyoMainDiv div) {
        return KyotakuServiceRiyohyoMainHandler.of(div);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0020011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.DBC0020011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.DBC0020011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgRiyoNentstsuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainHander;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuTodokedeManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC0020011_居宅サービス計画照会のクラスです。
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
public class KyotakuServiceKeikakuShokaiMain {

    private static final RString 照会 = new RString("照会");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onLoad(KyotakuServiceKeikakuShokaiMainDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        this.getHander(div).initialize(資格対象者);
        return ResponseData.of(div).setState(DBC0020011StateName.初期表示);
    }

    /**
     * 対象情報一覧を取得のメソッドます。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_dgKyotakuServiceRirekiIchiran(KyotakuServiceKeikakuShokaiMainDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        dgKyotakuServiceRirekiIchiran_Row row = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(
                row.getTaishoYM().getValue().getYearMonth().toDateString());
        int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
        KyotakuKeikakuTodokedeManager manager = new KyotakuKeikakuTodokedeManager();
        KyotakuKeikakuTodokede 居宅給付計画届出 = manager.get居宅給付計画届出(被保険者番号, 対象年月, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.居宅給付計画届出, 居宅給付計画届出);
        this.getHander(div).get対象情報一覧(被保険者番号, 居宅給付計画届出);
        return ResponseData.of(div).setState(DBC0020011StateName.届出表示);
    }

    /**
     * 対象情報一覧の「選択」ボタンのメソッドです。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_dgRiyoNentstsuIchiran(KyotakuServiceKeikakuShokaiMainDiv div) {
        KyotakuKeikakuTodokede 居宅給付計画届出
                = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出, KyotakuKeikakuTodokede.class);
        dgKyotakuServiceRirekiIchiran_Row kyotakuRow = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        dgRiyoNentstsuIchiran_Row riyoRow = div.getDgRiyoNentstsuIchiran().getClickedItem();
        RString 総合事業区分 = kyotakuRow.getKyotakuSogoJigyoKubun();
        HihokenshaNo 被保険者番号 = 居宅給付計画届出.get被保険者番号();
        FlexibleYearMonth 対象年月 = 居宅給付計画届出.get対象年月();
        int 履歴番号 = 居宅給付計画届出.get履歴番号();
        div.getCcdServiceRiyohyoInfo().initialize(
                照会, new FlexibleYearMonth(riyoRow.getRiyoYM().getValue().getYearMonth().toString()),
                対象年月, 被保険者番号, 総合事業区分, 履歴番号);
        return ResponseData.of(div).setState(DBC0020011StateName.明細表示);
    }

    /**
     * 「履歴一覧戻る」ボタン
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_btnBackRirekiIchiran(KyotakuServiceKeikakuShokaiMainDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        this.getHander(div).initialize(資格対象者);
        return ResponseData.of(div).setState(DBC0020011StateName.初期表示);
    }

    /**
     * 「履歴一覧戻る」ボタン
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_Over(KyotakuServiceKeikakuShokaiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(
                DBC0020011TransitionEventName.完了).respond();
    }

    private KyotakuServiceKeikakuShokaiMainHander getHander(KyotakuServiceKeikakuShokaiMainDiv div) {
        return new KyotakuServiceKeikakuShokaiMainHander(div);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0600011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.DBC0600011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.dgShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600011.PnlTotalHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraikettejoho.SyokanbaraiketteJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請_検索
 *
 * @reamsid_L DBC-1020-020 yangchenbing
 */
public class PnlTotal {

    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 参照 = new RString("参照");
    private static final RString 差止控除区分_20 = new RString("20");
    private static final RString 差止控除区分_21 = new RString("21");
    private static final RString 差止控除区分_10 = new RString("10");

    /**
     * 画面初期化
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請
     */
    public ResponseData<PnlTotalDiv> onLoad(PnlTotalDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = key.get識別コード();
        HihokenshaNo 被保険者番号 = key.get被保険者番号();
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        div.getKaigoCommonPanel().getCcdAtenaInfo().initialize(識別コード);
        div.getKaigoCommonPanel().getCcdShikakuKihon().initialize(被保険者番号);
        RString 要介護状態区分名称 = div.getKaigoCommonPanel().getCcdShikakuKihon().get要介護状態区分名称() == null
                ? RString.EMPTY : div.getKaigoCommonPanel().getCcdShikakuKihon().get要介護状態区分名称();
        RDate 認定開始年月日 = div.getKaigoCommonPanel().getCcdShikakuKihon().get認定開始年月日();
        RDate 認定終了年月日 = div.getKaigoCommonPanel().getCcdShikakuKihon().get認定終了年月日();
        if (RString.isNullOrEmpty(要介護状態区分名称)) {
            div.getYoguKonyuhiShikyuShinseiList().getBtnAddShikyuShinsei().setDisabled(true);
        }
        PnlTotalHandler handler = getHandler(div);
        List<FukushiyouguKonyuhiShikyuShinseiResult> list = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getShokanShikyuShinseiList(被保険者番号);
        handler.initializedgShikyuShinseiList(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請を追加
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_btnAddShikyuShinsei(PnlTotalDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return ResponseData.of(div).forwardWithEventName(DBC0600011TransitionEventName.明細情報).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請グレードの選択
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_byselectbutton(PnlTotalDiv div) {
        putViewStateHolder(div, 参照);
        return ResponseData.of(div).forwardWithEventName(DBC0600011TransitionEventName.明細情報).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請グレードの修正
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_dgShikyuShinseiList_modify(PnlTotalDiv div) {
        SyokanbaraiketteJohoManager manager = SyokanbaraiketteJohoManager.createInstance();
        HihokenshaNo hihokenshaNo = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        dgShikyuShinseiList_Row 選択行 = div.getYoguKonyuhiShikyuShinseiList().getDgShikyuShinseiList().getActiveRow();
        FlexibleYearMonth serviceTekyoYM = new FlexibleYearMonth(選択行.getServiceDate());
        RString seiriNo = 選択行.getTxtSerialNo();
        RString 差止控除区分 = manager.getShashitomeKojyoKubun(修正, hihokenshaNo, serviceTekyoYM, seiriNo);
        if (差止控除区分_20.equals(差止控除区分) || 差止控除区分_21.equals(差止控除区分)) {
            putViewStateHolder(div, 登録);
        } else if (差止控除区分_10.equals(差止控除区分)) {
            putViewStateHolder(div, 参照);
        } else {
            putViewStateHolder(div, 修正);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0600011TransitionEventName.明細情報).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請グレードの削除
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_dgShikyuShinseiList_delete(PnlTotalDiv div) {
        putViewStateHolder(div, 削除);
        return ResponseData.of(div).forwardWithEventName(DBC0600011TransitionEventName.明細情報).respond();
    }

    /**
     * 福祉用具購入費支給申請の該当者一覧画面へ遷移する。
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の一覧画面
     */
    public ResponseData<PnlTotalDiv> onClick_btnBackToIchiran(PnlTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0600011TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 福祉用具購入費支給申請の該当者検索画面へ遷移する。
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の検索へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_btnBackToKensaku(PnlTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0600011TransitionEventName.検索に戻る).respond();
    }

    private void putViewStateHolder(PnlTotalDiv div, RString 状態) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        PnlTotalParameter parameter = getHandler(div).getViesStateParameter(被保険者番号);
        ViewStateHolder.put(ViewStateKeys.契約番号検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
    }

    private PnlTotalHandler getHandler(PnlTotalDiv div) {
        return PnlTotalHandler.of(div);
    }
}

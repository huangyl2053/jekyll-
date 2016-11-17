/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820024;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.DBC0820024StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.DBC0820024TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820024.ServiceKeikakuHiPanelHandler;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(サービス計画費)のクラスです。
 *
 * @reamsid_L DBC-1030-010 gongliang
 */
public class ServiceKeikakuHiPanel {

    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final RString 登録モード = new RString("登録");
    private static final RString 削除モード = new RString("削除");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 確定するボタン = new RString("Element1");
    private static final RString 証明書入力未済あり = new RString("2");
    private static final RString 証明書入力未済ありエラー = new RString("請求額集計情報の未登録のサービス種類が存在します。\n\r請求額集計情報を登録して下さい。");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onLoad(ServiceKeikakuHiPanelDiv div) {
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        DbJohoViewState 開始時点の償還払サービス計画費 = ViewStateHolder.get(ViewStateKeys.開始時点の償還払サービス計画費, DbJohoViewState.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        if (null == 償還払ViewStateDB) {
            償還払ViewStateDB = new DbJohoViewState();
            ShokanKihon 基本情報 = new ShokanKihon(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            ArrayList<ShokanKihon> 償還払請求基本データList = new ArrayList<>();
            償還払請求基本データList.add(基本情報);
            償還払ViewStateDB.set償還払請求基本データList(償還払請求基本データList);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
        }
        if (null == 開始時点の償還払サービス計画費) {
            開始時点の償還払サービス計画費 = new DbJohoViewState();
            ViewStateHolder.put(ViewStateKeys.開始時点の償還払サービス計画費, 開始時点の償還払サービス計画費);
        }
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 画面モード = 登録モード;
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        if (明細番号 == null || 明細番号.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        }
        handler.set申請共通エリア(サービス年月, 申請日, 事業者番号, 明細番号, 様式番号);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(true);
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(true);
            div.getPanelServiceKeikakuhiDown().setDisplayNone(true);
            List<ShokanServicePlan200904Result> entity200904ResultList = 償還払ViewStateDB.get償還払請求サービス計画200904データResultList(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (checkNull(entity200904ResultList)) {
                entity200904ResultList = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200904(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                if (checkNull(entity200904ResultList)) {
                    handler.load事業者区分リスト200904();
                    return createResponse(div);
                }
                償還払ViewStateDB.add償還払請求サービス計画200904データResult(entity200904ResultList);
                開始時点の償還払サービス計画費.add償還払請求サービス計画200904データResult(entity200904ResultList);
            }
            handler.onLoad200904(entity200904ResultList, 画面モード);
        } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
            div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
            ShokanServicePlan200604Result entity200604Result = 償還払ViewStateDB.get償還払請求サービス計画200604データResult(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (null == entity200604Result) {
                List<ShokanServicePlan200604Result> entity200604ResultList = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200604(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                if (checkNull(entity200604ResultList)) {
                    handler.load事業者区分リスト200904前();
                    return createResponse(div);
                }
                entity200604Result = entity200604ResultList.get(0);
                償還払ViewStateDB.add償還払請求サービス計画200604データResult(entity200604Result);
                開始時点の償還払サービス計画費.add償還払請求サービス計画200604データResult(entity200604Result);
            }
            handler.onLoad200604(entity200604Result, 画面モード);
        } else {
            div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setDisplayNone(true);
            div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setDisplayNone(true);
            div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
            ShokanServicePlan200004Result entity200004Result = 償還払ViewStateDB.get償還払請求サービス計画200004データResult(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (null == entity200004Result) {
                List<ShokanServicePlan200004Result> entity200004ResultList
                        = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200004(
                                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                if (checkNull(entity200004ResultList)) {
                    handler.load事業者区分リスト200904前();
                    return createResponse(div);
                }
                entity200004Result = entity200004ResultList.get(0);
                償還払ViewStateDB.add償還払請求サービス計画200004データResult(entity200004Result);
                開始時点の償還払サービス計画費.add償還払請求サービス計画200004データResult(entity200004Result);
            }
            handler.onLoad200004(entity200004Result, 画面モード);
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
        ViewStateHolder.put(ViewStateKeys.開始時点の償還払サービス計画費, 開始時点の償還払サービス計画費);

        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(サービス年月, 様式番号);
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            ShoukanharaihishinseimeisaikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                    ShoukanharaihishinseimeisaikensakuParameter.class);
            handler.getボタンを制御(shikibetsuNoKanri, paramter);
        }
        if (削除モード.equals(画面モード)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(確定するボタン, true);
            return ResponseData.of(div).setState(DBC0820024StateName.削除モード);
        } else {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(確定するボタン, false);
            return ResponseData.of(div).setState(DBC0820024StateName.新規修正モード);
        }
    }

    /**
     * 追加するボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnAdd(ServiceKeikakuHiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).click追加();
        return createResponse(div);
    }

    /**
     * グリッドの修正ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_dgList_modify(ServiceKeikakuHiPanelDiv div) {
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        getHandler(div).click修正(row);
        return createResponse(div);
    }

    /**
     * グリッドの削除ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_dgList_delete(ServiceKeikakuHiPanelDiv div) {
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        getHandler(div).click削除(row);
        getHandler(div).set削除();
        return createResponse(div);
    }

    /**
     * 「計算する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKeisan(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).click計算Keisan();
        return createResponse(div);
    }

    /**
     * 「クリアする」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnClear(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).clickクリア();
        return createResponse(div);
    }

    /**
     * サービス計画費登録エリアの「取消する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnCancel(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).clickクリア();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(true);
        return createResponse(div);
    }

    /**
     * 「確定する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnConfirm(ServiceKeikakuHiPanelDiv div) {
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_登録();
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_修正();
        } else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_削除();
        }
        getHandler(div).clickクリア();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(true);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「計算する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnkeisan(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).click計算keisan();
        return createResponse(div);
    }

    /**
     * 共通エリア「証明書一覧へ戻る」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTorikeshi(ServiceKeikakuHiPanelDiv div) {
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (削除モード.equals(画面モード)) {
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        } else {
            boolean 変更;
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.
                    get(ViewStateKeys.明細検索キー,
                            ShoukanharaihishinseimeisaikensakuParameter.class);
            FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
            if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
                変更 = handler.変更チェック処理();
            } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
                ShokanServicePlan200604Result entity200604Result = 償還払ViewStateDB.get償還払請求サービス計画200604データResult(
                        meisaiPar.get被保険者番号(),
                        meisaiPar.getサービス年月(),
                        meisaiPar.get整理番号(),
                        meisaiPar.get事業者番号(),
                        meisaiPar.get様式番号(),
                        meisaiPar.get明細番号());
                変更 = handler.変更チェック処理200604(entity200604Result);
            } else {
                ShokanServicePlan200004Result entity200004Result = 償還払ViewStateDB.get償還払請求サービス計画200004データResult(
                        meisaiPar.get被保険者番号(),
                        meisaiPar.getサービス年月(),
                        meisaiPar.get整理番号(),
                        meisaiPar.get事業者番号(),
                        meisaiPar.get様式番号(),
                        meisaiPar.get明細番号());
                変更 = handler.変更チェック処理200004(entity200004Result);
            }
            return 登録モード変更処理(変更, div);
        }
    }

    /**
     * 確定ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請一覧画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKakutei(ServiceKeikakuHiPanelDiv div) {
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        boolean 変更;
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.
                get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        DbJohoViewState 開始時点の償還払サービス計画費 = ViewStateHolder.get(ViewStateKeys.開始時点の償還払サービス計画費, DbJohoViewState.class);
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            変更 = handler.変更チェック処理();
        } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
            ShokanServicePlan200604Result 開始時点のentity200604Result = 開始時点の償還払サービス計画費.get償還払請求サービス計画200604データResult(
                    meisaiPar.get被保険者番号(),
                    meisaiPar.getサービス年月(),
                    meisaiPar.get整理番号(),
                    meisaiPar.get事業者番号(),
                    meisaiPar.get様式番号(),
                    meisaiPar.get明細番号());
            変更 = handler.変更チェック処理200604(開始時点のentity200604Result);
        } else {
            ShokanServicePlan200004Result 開始時点のentity200004Result = 開始時点の償還払サービス計画費.get償還払請求サービス計画200004データResult(
                    meisaiPar.get被保険者番号(),
                    meisaiPar.getサービス年月(),
                    meisaiPar.get整理番号(),
                    meisaiPar.get事業者番号(),
                    meisaiPar.get様式番号(),
                    meisaiPar.get明細番号());
            変更 = handler.変更チェック処理200004(開始時点のentity200004Result);
        }
        if (!変更) {
            return saveOut(div);
        } else {
            return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.一覧に戻る);
        }
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> 保存処理(ServiceKeikakuHiPanelDiv div, DbJohoViewState 償還払ViewStateDB, DBC0820024TransitionEventName eventName) {
        try {
            if (!ResponseHolder.isReRequest()) {
                ShoukanharaihishinseimeisaikensakuParameter parameter = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                        ShoukanharaihishinseimeisaikensakuParameter.class);
                List<ShokanServicePlan200904Result> entity200904ResultList = 償還払ViewStateDB.get償還払請求サービス計画200904データResultList(
                        parameter.get被保険者番号(),
                        parameter.getサービス年月(),
                        parameter.get整理番号(),
                        parameter.get事業者番号(),
                        parameter.get様式番号(),
                        parameter.get明細番号());
                ShokanServicePlan200604Result entity200604Result = 償還払ViewStateDB.get償還払請求サービス計画200604データResult(
                        parameter.get被保険者番号(),
                        parameter.getサービス年月(),
                        parameter.get整理番号(),
                        parameter.get事業者番号(),
                        parameter.get様式番号(),
                        parameter.get明細番号());
                ShokanServicePlan200004Result entity200004Result = 償還払ViewStateDB.get償還払請求サービス計画200004データResult(
                        parameter.get被保険者番号(),
                        parameter.getサービス年月(),
                        parameter.get整理番号(),
                        parameter.get事業者番号(),
                        parameter.get様式番号(),
                        parameter.get明細番号());
                ShomeishoNyuryokuFlag 証明書入力済フラグ = ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class);
                ShomeishoHenkoFlag 証明書変更済フラグ = ViewStateHolder.get(ViewStateKeys.証明書変更済フラグ, ShomeishoHenkoFlag.class);
                entity200904ResultList = getHandler(div).saveサービス計画200904(parameter, entity200904ResultList);
                entity200604Result = getHandler(div).saveサービス計画200604(parameter, entity200604Result);
                entity200004Result = getHandler(div).saveサービス計画200004(parameter, entity200004Result);
                証明書入力済フラグ = getHandler(div).set証明書入力済フラグ(証明書入力済フラグ, entity200904ResultList, entity200604Result, entity200004Result);
                償還払ViewStateDB.add償還払請求サービス計画200904データResult(entity200904ResultList);
                償還払ViewStateDB.add償還払請求サービス計画200604データResult(entity200604Result);
                償還払ViewStateDB.add償還払請求サービス計画200004データResult(entity200004Result);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
                ViewStateHolder.put(ViewStateKeys.証明書入力済フラグ, 証明書入力済フラグ);
                ViewStateHolder.put(ViewStateKeys.証明書変更済フラグ, 証明書変更済フラグ);
                if (eventName.equals(DBC0820024TransitionEventName.一覧に戻る)) {
                    ShomeishoNyuryokuKanryoKubunType 証明書完了フラグ = SyokanbaraihiShikyuShinseiManager.createInstance().証明書InputCheck(
                            証明書入力済フラグ, parameter.get様式番号(), parameter.getサービス年月());
                    if (証明書入力未済あり.equals(証明書完了フラグ)) {
                        throw new ApplicationException(証明書入力未済ありエラー.toString());
                    }
                }
                return ResponseData.of(div).forwardWithEventName(eventName).respond();
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return ResponseData.of(div).forwardWithEventName(eventName).respond();
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> saveOut(ServiceKeikakuHiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> 登録モード変更処理(boolean 変更, ServiceKeikakuHiPanelDiv div) {
        if (!変更) {
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.
                        get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
                FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
                List<ShokanServicePlan200904Result> entity200904ResultList = ViewStateHolder.get(
                        ViewStateKeys.サービス計画費データ, List.class);
                ShokanServicePlan200604Result entity200604Result = ViewStateHolder.get(
                        ViewStateKeys.サービス計画費データ, ShokanServicePlan200604Result.class);
                ShokanServicePlan200004Result entity200004Result = ViewStateHolder.get(
                        ViewStateKeys.サービス計画費データ, ShokanServicePlan200004Result.class);
                RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
                getHandler(div).登録モード変更処理(サービス年月, entity200904ResultList, entity200604Result, entity200004Result, 画面モード);
                return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
            }
        }
        return createResponse(div);
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（基本情報）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKihonInfo(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.基本情報);
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（給付費明細）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKyufuhiMeisai(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.給付費明細);
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（特定診療費）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTokuteiShinryo(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.特定診療費);
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（特定入所者費用）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTokuteiNyushosha(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.特定入所者費用);
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（合計情報）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnGokeiInfo(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.合計情報);
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（給付費明細（住特）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.給付費明細_住特);
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（緊急時・所定疾患）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKinkyujiShoteiShikan(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.緊急時_所定疾患);
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（緊急時施設療養費）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKinkyujiShisetsu(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.緊急時施設療養費);
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（食事費用）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnShokujiHiyo(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.食事費用);
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（請求額集計）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnSeikyugakuShukei(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.請求額集計);
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（社福軽減額）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnShafukukeigenGaku(ServiceKeikakuHiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        return 保存処理(div, 償還払ViewStateDB, DBC0820024TransitionEventName.社福軽減額);
    }

    private boolean checkNull(List list) {
        return list == null || list.isEmpty();
    }

    private ServiceKeikakuHiPanelHandler getHandler(ServiceKeikakuHiPanelDiv div) {
        return new ServiceKeikakuHiPanelHandler(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> createResponse(ServiceKeikakuHiPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}

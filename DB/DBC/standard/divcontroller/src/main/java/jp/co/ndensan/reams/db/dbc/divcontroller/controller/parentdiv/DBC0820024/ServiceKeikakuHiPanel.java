/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820024;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.DBC0820024StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.DBC0820024TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820024.ServiceKeikakuHiPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 確定するボタン = new RString("Element1");
    private static final RString NUM1 = new RString("1");
    private static final RString NUM0 = new RString("0");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onLoad(ServiceKeikakuHiPanelDiv div) {
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        ShoukanharaihishinseimeisaikensakuParameter 明細キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (償還払ViewStateDB == null) {
            償還払ViewStateDB = new DbJohoViewState();
        }
        DbJohoViewState 開始時点の償還払サービス計画費 = ViewStateHolder.get(ViewStateKeys.開始時点の償還払サービス計画費, DbJohoViewState.class);
        HihokenshaNo 被保険者番号 = 明細キー.get被保険者番号();
        FlexibleYearMonth サービス年月 = 明細キー.getサービス年月();
        RString 整理番号 = 明細キー.get整理番号();
        JigyoshaNo 事業者番号 = 明細キー.get事業者番号();
        RString 様式番号 = 明細キー.get様式番号();
        RString 明細番号 = 明細キー.get明細番号();
        RDate 申請日 = 明細キー.get申請日();

        if (null == 開始時点の償還払サービス計画費) {
            開始時点の償還払サービス計画費 = new DbJohoViewState();
            ViewStateHolder.put(ViewStateKeys.開始時点の償還払サービス計画費, 開始時点の償還払サービス計画費);
        }
        ViewStateHolder.put(ViewStateKeys.判定結果, false);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        if (明細番号 == null || 明細番号.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        }
        handler.set申請共通エリア(サービス年月, 申請日, 事業者番号, 明細番号, 様式番号);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(true);
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            if (setサービス年月_200904(div, 償還払ViewStateDB, 明細キー,
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号,
                    明細番号, handler, 開始時点の償還払サービス計画費, 画面モード)) {
                ViewStateHolder.put(ViewStateKeys.判定結果, true);
                return createResponse(div);
            }
        } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
            if (setサービス年月_200604(div, 償還払ViewStateDB, 明細キー, 被保険者番号, サービス年月, 整理番号, 事業者番号,
                    様式番号, 明細番号, handler, 開始時点の償還払サービス計画費, 画面モード)) {
                ViewStateHolder.put(ViewStateKeys.判定結果, true);
                return createResponse(div);
            }
        } else if (setサービス年月_200903(div, 償還払ViewStateDB, 明細キー, 被保険者番号, サービス年月, 整理番号, 事業者番号,
                様式番号, 明細番号, handler, 開始時点の償還払サービス計画費, 画面モード)) {
            ViewStateHolder.put(ViewStateKeys.判定結果, true);
            return createResponse(div);
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

    private boolean setサービス年月_200903(ServiceKeikakuHiPanelDiv div, DbJohoViewState 償還払ViewStateDB,
            ShoukanharaihishinseimeisaikensakuParameter 明細キー, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, ServiceKeikakuHiPanelHandler handler,
            DbJohoViewState 開始時点の償還払サービス計画費, RString 画面モード) {
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setDisplayNone(true);
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setDisplayNone(true);
        div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
        ShokanServicePlan200004Result entity200004Result
                = 償還払ViewStateDB.get償還払請求サービス計画200004データResult(明細キー);
        if (null == entity200004Result) {
            List<ShokanServicePlan200004Result> entity200004ResultList
                    = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200004(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            ViewStateHolder.put(ViewStateKeys.サービス年月_200903, (Serializable) entity200004ResultList);
            if (checkNull(entity200004ResultList)) {
                handler.load事業者区分リスト200904前();
                return true;
            }
            entity200004Result = entity200004ResultList.get(0);
            償還払ViewStateDB.add償還払請求サービス計画200004データResult(entity200004Result);
            開始時点の償還払サービス計画費.add償還払請求サービス計画200004データResult(entity200004Result);
        }
        handler.onLoad200004(entity200004Result, 画面モード);
        return false;
    }

    private boolean setサービス年月_200604(ServiceKeikakuHiPanelDiv div, DbJohoViewState 償還払ViewStateDB,
            ShoukanharaihishinseimeisaikensakuParameter 明細キー, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, ServiceKeikakuHiPanelHandler handler,
            DbJohoViewState 開始時点の償還払サービス計画費, RString 画面モード) {
        div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
        ShokanServicePlan200604Result entity200604Result
                = 償還払ViewStateDB.get償還払請求サービス計画200604データResult(明細キー);
        if (null == entity200604Result) {
            List<ShokanServicePlan200604Result> entity200604ResultList = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200604(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            ViewStateHolder.put(ViewStateKeys.サービス年月_200604, (Serializable) entity200604ResultList);
            if (checkNull(entity200604ResultList)) {
                handler.load事業者区分リスト200904前();
                return true;
            }
            entity200604Result = entity200604ResultList.get(0);
            償還払ViewStateDB.add償還払請求サービス計画200604データResult(entity200604Result);
            開始時点の償還払サービス計画費.add償還払請求サービス計画200604データResult(entity200604Result);
        }
        handler.onLoad200604(entity200604Result, 画面モード);
        return false;
    }

    private boolean setサービス年月_200904(ServiceKeikakuHiPanelDiv div, DbJohoViewState 償還払ViewStateDB,
            ShoukanharaihishinseimeisaikensakuParameter 明細キー, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, ServiceKeikakuHiPanelHandler handler,
            DbJohoViewState 開始時点の償還払サービス計画費, RString 画面モード) {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(true);
        div.getPanelServiceKeikakuhiDown().setDisplayNone(true);
        handler.load事業者区分リスト200904();
        List<ShokanServicePlan200904Result> entity200904ResultList
                = 償還払ViewStateDB.get償還払請求サービス計画200904データResultList(明細キー);
        if (checkNull(entity200904ResultList)) {
            entity200904ResultList = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200904(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            ViewStateHolder.put(ViewStateKeys.サービス年月_200904, (Serializable) entity200904ResultList);
            if (checkNull(entity200904ResultList)) {
                return true;
            }
            償還払ViewStateDB.add償還払請求サービス計画200904データResult(entity200904ResultList);
            開始時点の償還払サービス計画費.add償還払請求サービス計画200904データResult(entity200904ResultList);
        }
        handler.onLoad200904(entity200904ResultList, 画面モード);
        return false;
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
        int maxRenban = 0;
        if (div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource() != null
                && !div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource().isEmpty()) {
            maxRenban = Integer.parseInt(div.getPanelServiceKeikakuhiUp()
                    .getDgdYichiran().getDataSource().get(0).getDefaultDataName7().toString());
        }
        List<ShokanServicePlan200904Result> entity200904ResultList
                = ViewStateHolder.get(ViewStateKeys.サービス年月_200904, ArrayList.class);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_登録(maxRenban);
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_修正(maxRenban, entity200904ResultList);
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
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (削除モード.equals(画面モード)) {
            resetKensakuData();
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode(),
                    DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState 償還払ViewStateDBBAK = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDBBAK);
            resetKensakuData();
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM0);
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        }
        return createResponse(div);
    }

    /**
     * 確定ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請一覧画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKakutei(ServiceKeikakuHiPanelDiv div) {
        boolean is変更 = 変更チェック(div);
        if (!is変更) {
            return saveOut(div);
        } else {
            resetKensakuData();
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM1);
            return 保存処理(div, DBC0820024TransitionEventName.一覧に戻る);
        }
    }

    private boolean 変更チェック(ServiceKeikakuHiPanelDiv div) {
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        boolean is変更;
        ShoukanharaihishinseimeisaikensakuParameter 明細キー = ViewStateHolder.
                get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 開始時点の償還払サービス計画費 = ViewStateHolder.get(ViewStateKeys.開始時点の償還払サービス計画費, DbJohoViewState.class);
        FlexibleYearMonth サービス年月 = 明細キー.getサービス年月();
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            is変更 = handler.変更チェック処理();
        } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
            ShokanServicePlan200604Result 開始時点のentity200604Result = 開始時点の償還払サービス計画費.get償還払請求サービス計画200604データResult(明細キー);
            is変更 = handler.変更チェック処理200604(開始時点のentity200604Result);
        } else {
            ShokanServicePlan200004Result 開始時点のentity200004Result = 開始時点の償還払サービス計画費.get償還払請求サービス計画200004データResult(明細キー);
            is変更 = handler.変更チェック処理200004(開始時点のentity200004Result);
        }
        return is変更;
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> 保存処理(ServiceKeikakuHiPanelDiv div, DBC0820024TransitionEventName eventName) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        List<ShokanServicePlan200904Result> entity200904ResultList = 償還払ViewStateDB.get償還払請求サービス計画200904データResultList(明細キー);
        if (償還払ViewStateDB.get償還払請求サービス計画200604データResultList() == null) {
            ArrayList<ShokanServicePlan200604Result> list200604Result = new ArrayList<>();
            償還払ViewStateDB.set償還払請求サービス計画200604データResultList(list200604Result);
        }
        ShokanServicePlan200604Result entity200604Result = 償還払ViewStateDB.get償還払請求サービス計画200604データResult(明細キー);

        if (償還払ViewStateDB.get償還払請求サービス計画200004データResultList() == null) {
            ArrayList<ShokanServicePlan200004Result> list200004Result = new ArrayList<>();
            償還払ViewStateDB.set償還払請求サービス計画200004データResultList(list200004Result);
        }
        ShokanServicePlan200004Result entity200004Result = 償還払ViewStateDB.get償還払請求サービス計画200004データResult(明細キー);
        if (entity200904ResultList != null && !entity200904ResultList.isEmpty()) {
            償還払ViewStateDB.get償還払請求サービス計画200904データResultList().removeAll(entity200904ResultList);
        }
        if (null != entity200604Result) {
            償還払ViewStateDB.get償還払請求サービス計画200604データResultList().remove(entity200604Result);
        }
        if (null != entity200004Result) {
            償還払ViewStateDB.get償還払請求サービス計画200004データResultList().remove(entity200004Result);
        }
        boolean 判定結果 = ViewStateHolder.get(ViewStateKeys.判定結果, boolean.class);
        entity200904ResultList = getHandler(div).saveサービス計画200904(明細キー, entity200904ResultList);
        entity200604Result = getHandler(div).saveサービス計画200604(明細キー, entity200604Result, 判定結果);
        entity200004Result = getHandler(div).saveサービス計画200004(明細キー, entity200004Result, 判定結果);
        ViewStateHolder.put(ViewStateKeys.判定結果, false);
        償還払ViewStateDB = set証明書フラグ(div, 償還払ViewStateDB, 明細キー, eventName);
        if (entity200904ResultList != null) {

            償還払ViewStateDB.add償還払請求サービス計画200904データResult(entity200904ResultList);
            List<ShokanServicePlan200904Result> newDataList = get償還払請求サービス計画200904データ(償還払ViewStateDB);
            if (償還払ViewStateDB.get償還払請求サービス計画200904データResultList() != null) {
                償還払ViewStateDB.get償還払請求サービス計画200904データResultList().clear();
                償還払ViewStateDB.add償還払請求サービス計画200904データResult(newDataList);
            } else {
                償還払ViewStateDB.add償還払請求サービス計画200904データResult(newDataList);
            }
        }
        if (entity200604Result != null) {
            if (!has同様償還払請求サービス計画200604データ(償還払ViewStateDB, entity200604Result)) {
                償還払ViewStateDB.add償還払請求サービス計画200604データResult(entity200604Result);
            }
        }
        if (entity200004Result != null) {
            if (!has同様償還払請求サービス計画200004データ(償還払ViewStateDB, entity200004Result)) {
                償還払ViewStateDB.add償還払請求サービス計画200004データResult(entity200004Result);
            }
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
        return ResponseData.of(div).forwardWithEventName(eventName).respond();
    }

    private List<ShokanServicePlan200904Result> get償還払請求サービス計画200904データ(DbJohoViewState 償還払ViewStateDB) {
        List<ShokanServicePlan200904Result> newDataList = new ArrayList<>();
        if (償還払ViewStateDB.get償還払請求サービス計画200904データResultList() != null
                && !償還払ViewStateDB.get償還払請求サービス計画200904データResultList().isEmpty()) {
            for (ShokanServicePlan200904Result data : 償還払ViewStateDB.get償還払請求サービス計画200904データResultList()) {
                if (newDataList.isEmpty()) {
                    newDataList.add(data);
                } else if (!hasデータ(newDataList, data)) {
                    newDataList.add(data);
                }
            }
        }
        return newDataList;
    }

    private boolean has同様償還払請求サービス計画200604データ(DbJohoViewState 償還払ViewStateDB,
            ShokanServicePlan200604Result entity200604Result) {
        if (償還払ViewStateDB.get償還払請求サービス計画200604データResultList() != null
                && !償還払ViewStateDB.get償還払請求サービス計画200604データResultList().isEmpty()) {
            for (ShokanServicePlan200604Result data : 償還払ViewStateDB.get償還払請求サービス計画200604データResultList()) {
                if (data.getEntity().get連番().equals(entity200604Result.getEntity().get連番())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean has同様償還払請求サービス計画200004データ(DbJohoViewState 償還払ViewStateDB, ShokanServicePlan200004Result entity200004Result) {
        if (償還払ViewStateDB.get償還払請求サービス計画200004データResultList() != null
                && !償還払ViewStateDB.get償還払請求サービス計画200004データResultList().isEmpty()) {
            for (ShokanServicePlan200004Result data : 償還払ViewStateDB.get償還払請求サービス計画200004データResultList()) {
                if (data.getEntity().get連番().equals(entity200004Result.getEntity().get連番())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasデータ(List<ShokanServicePlan200904Result> newDataList, ShokanServicePlan200904Result data) {
        for (ShokanServicePlan200904Result newData : newDataList) {
            if (data.getEntity().get連番().equals(newData.getEntity().get連番())) {
                return true;
            }
        }
        return false;
    }

    private DbJohoViewState set証明書フラグ(ServiceKeikakuHiPanelDiv div, DbJohoViewState 償還払ViewStateDB,
            ShoukanharaihishinseimeisaikensakuParameter 明細キー, DBC0820024TransitionEventName eventName) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        boolean is変更 = 変更チェック(div);
        if (登録モード.equals(画面モード)) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = 償還払ViewStateDB.get証明書入力済フラグMap();
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap = 償還払ViewStateDB.get証明書入力完了フラグMap();
            ShomeishoNyuryokuFlag 証明書入力済フラグ = 証明書入力済フラグMap.get(明細キー);
            証明書入力済フラグ.setサービス計画費_証明書入力済フラグ(is変更 ? ShomeishoNyuryokuKubunType.入力あり : ShomeishoNyuryokuKubunType.入力なし);
            証明書入力済フラグMap.put(明細キー, 証明書入力済フラグ);
            償還払ViewStateDB.set証明書入力済フラグMap(証明書入力済フラグMap);
            if (DBC0820024TransitionEventName.一覧に戻る == eventName) {
                set証明書完了フラグ(証明書入力済フラグ, 明細キー, 証明書入力完了フラグMap, 償還払ViewStateDB);
            }
        }
        if (修正モード.equals(画面モード)) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap = 償還払ViewStateDB.get証明書変更済フラグMap();
            if (証明書変更済フラグMap == null) {
                証明書変更済フラグMap = new HashMap<>();
            }
            ShomeishoHenkoFlag 証明書変更済フラグ = 証明書変更済フラグMap.get(明細キー);
            if (証明書変更済フラグ == null) {
                証明書変更済フラグ = new ShomeishoHenkoFlag();
            }
            証明書変更済フラグ.setサービス計画費_証明書変更済フラグ(is変更 ? ShomeishoHenkoKubunType.変更あり : ShomeishoHenkoKubunType.変更なし);
            証明書変更済フラグMap.put(明細キー, 証明書変更済フラグ);
            償還払ViewStateDB.set証明書変更済フラグMap(証明書変更済フラグMap);

            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = 償還払ViewStateDB.get証明書入力済フラグMap();
            if (償還払ViewStateDB.get証明書入力済フラグMap() == null) {
                証明書入力済フラグMap = new HashMap<>();
                償還払ViewStateDB.set証明書入力済フラグMap(証明書入力済フラグMap);
            }
            ShomeishoNyuryokuFlag 証明書入力済フラグ = 証明書入力済フラグMap.get(明細キー);
            if (証明書入力済フラグ == null) {
                証明書入力済フラグ = new ShomeishoNyuryokuFlag();
            }
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap = 償還払ViewStateDB.get証明書入力完了フラグMap();
            証明書入力済フラグ.setサービス計画費_証明書入力済フラグ(is変更 ? ShomeishoNyuryokuKubunType.入力あり : ShomeishoNyuryokuKubunType.入力なし);
            証明書入力済フラグMap.put(明細キー, 証明書入力済フラグ);
            償還払ViewStateDB.set証明書入力済フラグMap(証明書入力済フラグMap);
            if (DBC0820024TransitionEventName.一覧に戻る == eventName) {
                set証明書完了フラグ(証明書入力済フラグ, 明細キー, 証明書入力完了フラグMap, 償還払ViewStateDB);
            }
        }
        return 償還払ViewStateDB;
    }

    private void set証明書完了フラグ(ShomeishoNyuryokuFlag 証明書入力済フラグ, ShoukanharaihishinseimeisaikensakuParameter 明細キー,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap, DbJohoViewState 償還払ViewStateDB) {
        ShomeishoNyuryokuKanryoKubunType 証明書完了フラグ = SyokanbaraihiShikyuShinseiManager.createInstance().証明書InputCheck(
                証明書入力済フラグ, 明細キー.get様式番号(), 明細キー.getサービス年月());
        証明書入力完了フラグMap.put(明細キー, 証明書完了フラグ);
        償還払ViewStateDB.set証明書入力完了フラグMap(証明書入力完了フラグMap);
        if (ShomeishoNyuryokuKanryoKubunType.入力未完了 == 証明書完了フラグ) {
            throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage());
        }
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

    /**
     * 「基本情報」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（基本情報）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKihonInfo(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.基本情報);
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（給付費明細）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKyufuhiMeisai(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.給付費明細);
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（特定診療費）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTokuteiShinryo(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.特定診療費);
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（特定入所者費用）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTokuteiNyushosha(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.特定入所者費用);
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（合計情報）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnGokeiInfo(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.合計情報);
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（給付費明細（住特）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.給付費明細_住特);
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（緊急時・所定疾患）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKinkyujiShoteiShikan(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.緊急時_所定疾患);
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（緊急時施設療養費）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKinkyujiShisetsu(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.緊急時施設療養費);
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（食事費用）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnShokujiHiyo(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.食事費用);
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（請求額集計）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnSeikyugakuShukei(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.請求額集計);
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（社福軽減額）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnShafukukeigenGaku(ServiceKeikakuHiPanelDiv div) {
        resetKensakuData();
        return 保存処理(div, DBC0820024TransitionEventName.社福軽減額);
    }

    private void resetKensakuData() {
        ViewStateHolder.put(ViewStateKeys.サービス年月_200904, null);
        ViewStateHolder.put(ViewStateKeys.サービス年月_200604, null);
        ViewStateHolder.put(ViewStateKeys.サービス年月_200903, null);
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

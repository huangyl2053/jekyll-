/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820024;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.DBC0820024StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.DBC0820024TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820024.ServiceKeikakuHiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
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
    private static final RString 申請を保存するボタン = new RString("btnUpdate");
    private static final RString 申請を削除するボタン = new RString("btnDelete");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onLoad(ServiceKeikakuHiPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.申請年月日, 申請日);
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        ViewStateHolder.put(ViewStateKeys.画面モード, 登録モード);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        if (明細番号 == null || 明細番号.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        }
        handler.set申請共通エリア(サービス年月, 申請日, 事業者番号, 明細番号, 様式番号);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
            div.getPanelServiceKeikakuhiDown().setDisplayNone(true);
            List<ShokanServicePlan200904Result> entity200904List
                    = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200904(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (checkNull(entity200904List)) {
                handler.load事業者区分リスト200904();
                ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, null);
                return createResponse(div);
            }
            ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, (Serializable) entity200904List);
            handler.onLoad200904(entity200904List);
        } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
            div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
            List<ShokanServicePlan200604Result> entity200604
                    = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200604(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (checkNull(entity200604)) {
                handler.load事業者区分リスト200904前();
                ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, null);
                return createResponse(div);
            }
            ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, entity200604.get(0));
            handler.onLoad200604(entity200604.get(0));
        } else {
            div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setDisplayNone(true);
            div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setDisplayNone(true);
            div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
            List<ShokanServicePlan200004Result> entity200004
                    = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200004(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (checkNull(entity200004)) {
                handler.load事業者区分リスト200904前();
                ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, null);
                return createResponse(div);
            }
            ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, entity200004.get(0));
            handler.onLoad200004(entity200004.get(0));
        }

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            handler.getボタンを制御(shikibetsuNoKanri);
        }
        if (削除モード.equals(画面モード)) {
            return ResponseData.of(div).setState(DBC0820024StateName.削除モード);
        } else {
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
     * 「取消する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnCancel(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).clickクリア();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
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
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
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
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (削除モード.equals(画面モード)) {
            return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.一覧に戻る).respond();
        } else {
            boolean 変更 = false;
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.
                    get(ViewStateKeys.償還払費申請明細検索キー,
                            ShoukanharaihishinseimeisaikensakuParameter.class);
            FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
            if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
                変更 = handler.変更チェック処理();
            } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
                変更 = handler.変更チェック処理200604();
            } else {
                変更 = handler.変更チェック処理200004();
            }
            return 登録モード変更処理(変更, div);
        }
    }

    /**
     * 保存ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnUpdate(ServiceKeikakuHiPanelDiv div) {
        ServiceKeikakuHiPanelHandler handler = getHandler(div);
        boolean 変更 = false;
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.
                get(ViewStateKeys.償還払費申請明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            変更 = handler.変更チェック処理();
        } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
            変更 = handler.変更チェック処理200604();
        } else {
            変更 = handler.変更チェック処理200004();
        }
        if (!変更) {
            return saveOut(div);
        } else {
            return 保存処理(div);
        }
    }

    /**
     * 「申請を削除する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnDelete(ServiceKeikakuHiPanelDiv div) {
        // TODO QA712 異常メッセージを実装します。
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).保存処理(削除モード);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(削除モード.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除するボタン, true);
            return ResponseData.of(div).respond();
        }
        return createResponse(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> 保存処理(ServiceKeikakuHiPanelDiv div) {
        // TODO QA712 異常メッセージを実装します。
        try {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理(登録モード);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(登録.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存するボタン, true);
                return ResponseData.of(div).respond();
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return createResponse(div);
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
                        get(ViewStateKeys.償還払費申請明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
                FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
                getHandler(div).登録モード変更処理(サービス年月);
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
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（給付費明細）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKyufuhiMeisai(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（特定診療費）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTokuteiShinryo(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（特定入所者費用）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTokuteiNyushosha(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（合計情報）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnGokeiInfo(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（給付費明細（住特）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（緊急時・所定疾患）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKinkyujiShoteiShikan(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（緊急時施設療養費）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKinkyujiShisetsu(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（食事費用）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnShokujiHiyo(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（請求額集計）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnSeikyugakuShukei(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払支給申請_サービス提供証明書（社福軽減額）画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnShafukukeigenGaku(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
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

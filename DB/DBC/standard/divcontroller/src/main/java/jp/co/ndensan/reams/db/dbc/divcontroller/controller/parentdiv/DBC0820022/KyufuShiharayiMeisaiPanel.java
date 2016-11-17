/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820022;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.DBC0820022StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.DBC0820022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820022.KyufuShiharayiMeisaiValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細）
 *
 * @reamsid_L DBC-1030-040 quxiaodong
 */
public class KyufuShiharayiMeisaiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final ServiceShuruiCode サービス種類コード_50 = new ServiceShuruiCode("50");
    private static final RString 入力なし = new RString("0");
    private static final RString 入力あり = new RString("1");
    private static final RString 変更なし = new RString("0");
    private static final RString 変更あり = new RString("1");
    private static final RString 入力完了 = new RString("1");
    private static final RString 入力未完了 = new RString("2");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onLoad(KyufuShiharayiMeisaiPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
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
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(様式番号, サービス年月);
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);

        List<ShokanMeisaiResult> entityList = new ArrayList();
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (償還払ViewStateDB != null) {
            entityList = 償還払ViewStateDB.get償還払請求明細データList();
        }
        if (entityList.isEmpty()) {
            entityList = ShokanbaraiJyokyoShokai.createInstance().
                    getShokanbarayiSeikyuMeisayiShiteiIgaiList(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null, サービス種類コード_50);
        }
        div.getPanelThree().getPanelFour().setVisible(false);
        getHandler(div).initialize(entityList);
        ViewStateHolder.put(ViewStateKeys.給付費明細登録, (Serializable) entityList);
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {

            getHandler(div).getボタンを制御(shikibetsuNoKanri, meisaiPar);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelThree().getBtnAdd().setDisabled(true);
            div.getPanelThree().getDgdKyufuhiMeisai().setReadOnly(true);
            return ResponseData.of(div).setState(DBC0820022StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820022StateName.新規修正モード);
    }

    /**
     * onClick_btnAdd事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnAdd(KyufuShiharayiMeisaiPanelDiv div) {
        div.getPanelThree().getPanelFour().setVisible(true);
        getHandler(div).readOnly給付費明細登録(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).制御(true);
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_Modify事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_Modify(KyufuShiharayiMeisaiPanelDiv div) {
        div.getPanelThree().getPanelFour().setVisible(true);
        getHandler(div).readOnly給付費明細登録(false);
        getHandler(div).set給付費明細登録();
        getHandler(div).制御(true);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * onClick_Delete事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_Delete(KyufuShiharayiMeisaiPanelDiv div) {
        div.getPanelThree().getPanelFour().setVisible(true);
        getHandler(div).readOnly給付費明細登録(true);
        getHandler(div).set給付費明細登録();
        getHandler(div).制御(true);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * onClick_btnKeisan事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKeisan(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).click計算する();
        return createResponse(div);
    }

    /**
     * onClick_btnClear事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnClear(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_btnCancel事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnCancel(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        getHandler(div).制御(false);
        div.getPanelThree().getPanelFour().setVisible(false);
        return createResponse(div);
    }

    /**
     * onClick_btnFree事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnFree(KyufuShiharayiMeisaiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.一覧に戻る).respond();
        }
        return createResponse(div);
    }

    /**
     * onClick_btnConfirm事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnConfirm(KyufuShiharayiMeisaiPanelDiv div) {
        List<ShokanMeisaiResult> emptyList
                = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
        ValidationMessageControlPairs pairs = getValidationHandler(div).必須チェックValidate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        dgdKyufuhiMeisai_Row row;
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(state)) {
            row = new dgdKyufuhiMeisai_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        // getHandler(div).modifyRow(row, state, emptyList);
        setRowSort(div);
        getHandler(div).制御(false);
        return createResponse(div);
    }

    /**
     * onClick_btnSave事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
//    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnSave(KyufuShiharayiMeisaiPanelDiv div) {
//        boolean flag = getHandler(div).is内容変更状態();
//        if (flag) {
//            return 保存処理(div);
//        } else {
//            return notChanges(div);
//        }
//    }
    /**
     * 「申請を削除する」ボタンのメソッドます。
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
//    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnDelete(KyufuShiharayiMeisaiPanelDiv div) {
//        try {
//            if (!ResponseHolder.isReRequest()) {
//                ShoukanharaihishinseimeisaikensakuParameter meisaiPar
//                        = ViewStateHolder.get(ViewStateKeys.明細検索キー,
//                                ShoukanharaihishinseimeisaikensakuParameter.class);
//                RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
//                List<ShokanMeisaiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
//                getHandler(div).保存処理(meisaiPar, 処理モード, shkonlist);
//                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
//                        .replace(削除.toString())).respond();
//            }
//            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
//                return createResponse(div);
//            }
//            return ResponseData.of(div).respond();
//        } catch (Exception e) {
//            e.toString();
//            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
//        }
//    }
    private ArrayList<ShokanMeisaiResult> set保存処理(KyufuShiharayiMeisaiPanelDiv div) {
        try {
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar
                    = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                            ShoukanharaihishinseimeisaikensakuParameter.class);
            List<ShokanMeisaiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
            return getHandler(div).set保存処理(meisaiPar, shkonlist);
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ResponseData<KyufuShiharayiMeisaiPanelDiv> notChanges(KyufuShiharayiMeisaiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    /**
     * 「確定する」Commonボタンのメソッドます。
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnConfirmCommon(KyufuShiharayiMeisaiPanelDiv div) {
        ShomeishoNyuryokuFlag flag = new ShomeishoNyuryokuFlag();
        ShomeishoNyuryokuKubunType 入力済フラグ = getHandler(div).is入力済() ? flag.get給付費明細_証明書入力済フラグ().入力あり : flag.get給付費明細_証明書入力済フラグ().入力なし;
        RString 変更済フラグ = getHandler(div).is変更済() ? 変更あり : 変更なし;
        flag.set給付費明細_証明書入力済フラグ(入力済フラグ);
        ViewStateHolder.put(ViewStateKeys.証明書入力済フラグ, flag);
        ViewStateHolder.put(ViewStateKeys.証明書変更済フラグ, 変更済フラグ);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        償還払ViewStateDB.set償還払請求明細データList(set保存処理(div));
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
        set証明書入力済チェック();
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.一覧に戻る).respond(); //サービス提供証明書 画面へ遷移する。
    }

    /**
     * 基本情報ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKihonInfo(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.基本情報).respond();
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnTokuteiShinryohi(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnServiceKeikakuhi(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnTokuteiNyushosya(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnGoukeiInfo(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKinkyujiShoteiShikan(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKinkyujiShisetsuRyoyo(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnShokujiHiyo(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnSeikyugakuShukei(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnShafukukeigengaku(KyufuShiharayiMeisaiPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.社福軽減額).respond();
    }

    private KyufuShiharayiMeisaiPanelHandler getHandler(KyufuShiharayiMeisaiPanelDiv div) {
        return new KyufuShiharayiMeisaiPanelHandler(div);
    }

    private KyufuShiharayiMeisaiValidationHandler getValidationHandler(KyufuShiharayiMeisaiPanelDiv div) {
        return new KyufuShiharayiMeisaiValidationHandler(div);
    }

    private ResponseData<KyufuShiharayiMeisaiPanelDiv> createResponse(KyufuShiharayiMeisaiPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private void setViewState(KyufuShiharayiMeisaiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelTwo().getTxtShinseiYMD().getValue());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelTwo().getTxtJigyoshaBango().getValue()),
                div.getPanelTwo().getTxtShomeisho().getValue(),
                div.getPanelTwo().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }

    private void set証明書入力済チェック() {
        ShomeishoNyuryokuFlag 証明書入力済フラグ = ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 証明書入力済区分 = SyokanbaraihiShikyuShinseiManager.createInstance().証明書InputCheck(証明書入力済フラグ, 様式番号, サービス年月);

        if (入力完了.equals(証明書入力済区分)) {
            ViewStateHolder.put(ViewStateKeys.証明書入力完了フラグ, 入力完了);
        } else {
            ViewStateHolder.put(ViewStateKeys.証明書入力完了フラグ, 入力未完了);
        }

    }

    private void setRowSort(KyufuShiharayiMeisaiPanelDiv div) {
        List<dgdKyufuhiMeisai_Row> rowList = div.getPanelThree().getDgdKyufuhiMeisai().getDataSource();

        Collections.sort(rowList, new Comparator<dgdKyufuhiMeisai_Row>() {
            @Override
            public int compare(dgdKyufuhiMeisai_Row arg0, dgdKyufuhiMeisai_Row arg1) {
                int i = arg1.getDefaultDataName6().toInt() - (arg0.getDefaultDataName6().toInt());
                return i;
            }
        });
        div.getPanelThree().getDgdKyufuhiMeisai().setDataSource(rowList);
    }

}

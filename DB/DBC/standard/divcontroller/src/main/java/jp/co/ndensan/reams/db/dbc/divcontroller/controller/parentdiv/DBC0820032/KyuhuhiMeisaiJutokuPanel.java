/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820032;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.DBC0820032StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.DBC0820032TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.dgJushochiTokutei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
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
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細(住特））
 *
 * @reamsid_L DBC-1030-030 quxiaodong
 */
public class KyuhuhiMeisaiJutokuPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onLoad(KyuhuhiMeisaiJutokuPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(様式番号, サービス年月);
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPnlAtenaCommon().getCcdAtena().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPnlAtenaCommon().getCcdKaigoKihon().initialize(被保険者番号);
        } else {
            div.getPnlAtenaCommon().getCcdKaigoKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(false);

        List<ShokanMeisaiJushochiTokureiResult> entityList;
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (明細番号 == null || 明細番号.isEmpty()) {
            entityList = new ArrayList();
        } else if (null == 償還払ViewStateDB || null == 償還払ViewStateDB.get住所地特例データList() || 償還払ViewStateDB.get住所地特例データList().isEmpty()) {
            entityList = (ArrayList<ShokanMeisaiJushochiTokureiResult>) ShokanbaraiJyokyoShokai.createInstance().
                    getShokanbarayiSeikyuMeisayiJyutokuList(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        } else if (null != 償還払ViewStateDB.get住所地特例データList() && !償還払ViewStateDB.get住所地特例データList().isEmpty()) {
            entityList = 償還払ViewStateDB.get住所地特例データList();
        } else {
            entityList = new ArrayList();
        }
        ViewStateHolder.put(ViewStateKeys.給付費明細住特, (Serializable) entityList);
        getHandler(div).initialize(entityList);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(サービス年月, 様式番号);
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(shikibetsuNoKanri, meisaiPar);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPnlBtnDetail().getPnlKyufuhiMeisai().getBtnAdd().setDisabled(true);
            div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().setReadOnly(true);
            return ResponseData.of(div).setState(DBC0820032StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820032StateName.新規修正モード);
    }

    /**
     * onClick_btnAdd事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnAdd(KyuhuhiMeisaiJutokuPanelDiv div) {
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
        getHandler(div).readOnly給付費明細登録(false);
        getHandler(div).disabled給付費明細登録(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_Modify事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_Modify(KyuhuhiMeisaiJutokuPanelDiv div) {
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
        getHandler(div).readOnly給付費明細登録(false);
        getHandler(div).disabled給付費明細登録(false);
        getHandler(div).set給付費明細();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * onClick_Delete事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_Delete(KyuhuhiMeisaiJutokuPanelDiv div) {
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
        getHandler(div).readOnly給付費明細登録(true);
        getHandler(div).disabled給付費明細登録(true);
        getHandler(div).set給付費明細();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * onClick_btnKeisan事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKeisan(KyuhuhiMeisaiJutokuPanelDiv div) {
        getHandler(div).click計算する();
        return createResponse(div);
    }

    /**
     * onClick_btnClear事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnClear(KyuhuhiMeisaiJutokuPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_btnCancel事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnCancel(KyuhuhiMeisaiJutokuPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(false);
        return createResponse(div);
    }

    /**
     * 「証明書一覧へ戻る」ボタンのメソッドます。
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnBack(KyuhuhiMeisaiJutokuPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
        }
        return createResponse(div);
    }

    /**
     * onClick_btnConfirm事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnConfirm(KyuhuhiMeisaiJutokuPanelDiv div) {
        List<ShokanMeisaiJushochiTokureiResult> emptyList
                = ViewStateHolder.get(ViewStateKeys.給付費明細住特, List.class);
        dgJushochiTokutei_Row row;
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(state)) {
            row = new dgJushochiTokutei_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        ValidationMessageControlPairs validPairs = getCheckHandler(div).入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).modifyRow(row, state, emptyList);
        setRowSort(div);
        return createResponse(div);
    }

    private void setRowSort(KyuhuhiMeisaiJutokuPanelDiv div) {
        List<dgJushochiTokutei_Row> rowList = div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().getDataSource();
        if (!rowList.isEmpty()) {
            Collections.sort(rowList, new Comparator<dgJushochiTokutei_Row>() {
                @Override
                public int compare(dgJushochiTokutei_Row arg0, dgJushochiTokutei_Row arg1) {
                    int i = arg1.getDefaultDataName7().toInt() - (arg0.getDefaultDataName7().toInt());
                    return i;
                }
            });
        }
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().setDataSource(rowList);
    }

    /**
     * 「確定する」ボタンのメソッドます。
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnFree(KyuhuhiMeisaiJutokuPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar
                = ViewStateHolder.get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        set入力有無フラグ(div, 償還払ViewStateDB, meisaiPar);
        if (!削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
            List<ShokanMeisaiJushochiTokureiResult> shkonlist
                    = ViewStateHolder.get(ViewStateKeys.給付費明細住特, List.class);
            ArrayList<ShokanMeisaiJushochiTokureiResult> entityList = getHandler(div).保存処理(meisaiPar, 処理モード, shkonlist);
            if (null == 償還払ViewStateDB) {
                償還払ViewStateDB = new DbJohoViewState();
            }
            償還払ViewStateDB.set住所地特例データList(entityList);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
        }

        DbJohoViewState 償還払ViewStateDB1 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShomeishoNyuryokuFlag 証明書入力済フラグ = new ShomeishoNyuryokuFlag();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = get証明書入力済フラグMap(償還払ViewStateDB);
        if (null != 証明書入力済フラグMap.get(meisaiPar)) {
            証明書入力済フラグ = 償還払ViewStateDB1.get証明書入力済フラグMap().get(meisaiPar);
        }
        SikibetuNokennsakuki sikibetuKey
                = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        SyokanbaraihiShikyuShinseiManager 償還払い費支給申請
                = SyokanbaraihiShikyuShinseiManager.createInstance();
        ShomeishoNyuryokuKanryoKubunType 証明書入力完了区分 = 償還払い費支給申請.証明書InputCheck(証明書入力済フラグ, sikibetuKey.getSikibetuNo(), サービス年月);
        set証明書入力完了フラグ(証明書入力完了区分, 償還払ViewStateDB, meisaiPar);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
    }

    private Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> get証明書入力済フラグMap(DbJohoViewState 償還払ViewStateDB) {
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = 償還払ViewStateDB.get証明書入力済フラグMap();
        if (証明書入力済フラグMap == null) {
            証明書入力済フラグMap = new HashMap<>();
        }
        return 証明書入力済フラグMap;
    }

    private Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> get証明書変更済フラグMap(DbJohoViewState 償還払ViewStateDB) {
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap = 償還払ViewStateDB.get証明書変更済フラグMap();
        if (証明書変更済フラグMap == null) {
            証明書変更済フラグMap = new HashMap<>();
        }
        return 証明書変更済フラグMap;
    }

    private ShomeishoNyuryokuFlag set入力有無フラグ(
            KyuhuhiMeisaiJutokuPanelDiv div, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShomeishoNyuryokuFlag nyuryokuFlag = new ShomeishoNyuryokuFlag();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = get証明書入力済フラグMap(dbJoho);
        if (null != 証明書入力済フラグMap.get(kensakuParameter)) {
            nyuryokuFlag = 証明書入力済フラグMap.get(kensakuParameter);
        }
        set証明書フラグ(処理モード, getHandler(div).is内容変更状態(), nyuryokuFlag, 証明書入力済フラグMap, kensakuParameter, dbJoho);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
        return nyuryokuFlag;
    }

    private void set証明書フラグ(
            RString 処理モード, boolean is変更あり, ShomeishoNyuryokuFlag nyuryokuFlag,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, DbJohoViewState dbJoho
    ) {
        if (登録.equals(処理モード)) {
            if (is変更あり) {
                nyuryokuFlag.set給付費明細住特_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            } else {
                nyuryokuFlag.set給付費明細住特_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
            }
            証明書入力済フラグMap.put(kensakuParameter, nyuryokuFlag);
            dbJoho.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
    }

    private void set証明書入力完了フラグ(
            ShomeishoNyuryokuKanryoKubunType 証明書入力完了区分, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> kanryoFlagMap = dbJoho.get証明書入力完了フラグMap();
        if (kanryoFlagMap == null) {
            kanryoFlagMap = new HashMap<>();
        }
        if (証明書入力完了区分 == ShomeishoNyuryokuKanryoKubunType.入力未完了) {
            throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.toString());
        }
        kanryoFlagMap.put(kensakuParameter, ShomeishoNyuryokuKanryoKubunType.入力完了);
        dbJoho.set証明書入力完了フラグMap(kanryoFlagMap);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
    }

    /**
     * 基本情報ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKihonJoho(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKyufuhiMeisai(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnTokuteiShiryohi(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnServicePlanhi(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnTokuteiNyushoshaHi(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnGokeiJoho(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.合計情報).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKinkyujiShoteiShikan(
            KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKinkyuShisetsuRyoyouhi(
            KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnShokujiHi(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnShiseigakuShukei(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnShafukuGahenGaku(KyuhuhiMeisaiJutokuPanelDiv div) {
        edit入力有無チェック処理(div);
        edit入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.社福軽減額).respond();
    }

    private void edit入力内容保存(KyuhuhiMeisaiJutokuPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar
                = ViewStateHolder.get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (!削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
            List<ShokanMeisaiJushochiTokureiResult> shkonlist
                    = ViewStateHolder.get(ViewStateKeys.給付費明細住特, List.class);
            ArrayList<ShokanMeisaiJushochiTokureiResult> entityList = getHandler(div).保存処理(meisaiPar, 処理モード, shkonlist);
            if (null == 償還払ViewStateDB) {
                償還払ViewStateDB = new DbJohoViewState();
            }
            償還払ViewStateDB.set住所地特例データList(entityList);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
        }
    }

    private void edit入力有無チェック処理(KyuhuhiMeisaiJutokuPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
    }

    private KyuhuhiMeisaiJutokuPanelHandler getHandler(KyuhuhiMeisaiJutokuPanelDiv div) {
        return new KyuhuhiMeisaiJutokuPanelHandler(div);
    }

    private KyuhuhiMeisaiJutokuPanelValidationHandler getCheckHandler(KyuhuhiMeisaiJutokuPanelDiv div) {
        return new KyuhuhiMeisaiJutokuPanelValidationHandler(div);
    }

    private ResponseData<KyuhuhiMeisaiJutokuPanelDiv> createResponse(KyuhuhiMeisaiJutokuPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}

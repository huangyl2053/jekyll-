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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.DBC0820022StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.DBC0820022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820022.KyufuShiharayiMeisaiValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細）
 *
 * @reamsid_L DBC-1030-040 quxiaodong
 */
public class KyufuShiharayiMeisaiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 追加する = new RString("追加する");
    private static final RString 修正する = new RString("修正する");
    private static final RString 削除する = new RString("削除する");
    private static final ServiceShuruiCode サービス種類コード_50 = new ServiceShuruiCode("50");
    private static final RString エーラメッセージ = new RString("請求額集計情報の未登録のサービス種類が存在します。請求額集計情報を登録して下さい。");
    private static final RString 証明書戻り = new RString("0");
    private static final RString 確認戻り = new RString("1");

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
        List<ShokanMeisaiResult> johoList = new ArrayList();
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (償還払ViewStateDB.get償還払請求明細データList() != null) {
            johoList = 償還払ViewStateDB.get償還払請求明細データList();
        }
        johoList = getHandler(div).getUpdateList(johoList, meisaiPar);
        List<ShokanMeisaiResult> list = ShokanbaraiJyokyoShokai.createInstance().
                getShokanbarayiSeikyuMeisayiShiteiIgaiList(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null, サービス種類コード_50);
        for (ShokanMeisaiResult ryoyo : list) {
            boolean isModifiedorDeleted = false;
            for (ShokanMeisaiResult result : johoList) {
                if (result.getEntity().get連番().equals(result.getEntity().get連番())) {
                    if (result.getEntity().toEntity().getState() == EntityDataState.Modified) {
                        isModifiedorDeleted = true;
                        ryoyo.getEntity().toRealEntity().setState(EntityDataState.Modified);
                        entityList.add(ryoyo);
                        break;
                    }
                    if (result.getEntity().toEntity().getState() == EntityDataState.Deleted) {
                        isModifiedorDeleted = true;
                        ryoyo.getEntity().toRealEntity().setState(EntityDataState.Deleted);
                        entityList.add(ryoyo);
                        break;
                    }
                }
            }
            if (!isModifiedorDeleted) {
                ryoyo.getEntity().toRealEntity().setState(EntityDataState.Unchanged);
                entityList.add(ryoyo);
            }
        }
        for (ShokanMeisaiResult updateRyoyo : johoList) {
            if (updateRyoyo.getEntity().toEntity().getState() == EntityDataState.Added) {
                updateRyoyo.getEntity().toRealEntity().setState(EntityDataState.Added);
                entityList.add(updateRyoyo);
            }
        }
        div.getPanelThree().getPanelFour().setVisible(false);
        getHandler(div).initialize(entityList);
        setRowSort(div);
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
        getHandler(div).setDisabled給付費明細登録(false);
        div.getPanelThree().getPanelFour().getBtnConfirm().setText(追加する);
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
        div.getPanelThree().getPanelFour().getBtnConfirm().setText(修正する);
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
        div.getPanelThree().getPanelFour().getBtnConfirm().setText(削除する);
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

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
            ViewStateHolder.put(ViewStateKeys.証明書戻り, 証明書戻り);
            return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.一覧に戻る).respond();
        }

        return ResponseData.of(div).respond();
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
        div.getPanelThree().getPanelFour().getBtnClear().setDisabled(false);
        dgdKyufuhiMeisai_Row row;
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(state)) {
            row = new dgdKyufuhiMeisai_Row();
            row.setDefaultDataName6(getMax連番(div));
        } else {
            row = getHandler(div).selectRow();
        }
        getHandler(div).modifyRow(row, state, emptyList);
        setRowSort(div);
        getHandler(div).制御(false);
        return createResponse(div);
    }

    private ArrayList<ShokanMeisaiResult> set保存処理(KyufuShiharayiMeisaiPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar
                = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                        ShoukanharaihishinseimeisaikensakuParameter.class);
        List<ShokanMeisaiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
        return getHandler(div).set保存処理(meisaiPar, shkonlist);
    }

    /**
     * 「確定する」Commonボタンのメソッドます。
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnConfirmCommon(KyufuShiharayiMeisaiPanelDiv div) {
        set入力内容保存(div);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        ShomeishoNyuryokuFlag nyuryokuFlag = set証明書入力済チェック(div, 償還払ViewStateDB, kensakuParameter);
        if (登録.equals(処理モード)) {
            SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
            ShomeishoNyuryokuKanryoKubunType 証明書入力済区分 = manager.証明書InputCheck(
                    nyuryokuFlag, kensakuParameter.get様式番号(), kensakuParameter.getサービス年月());
            set証明書入力完了フラグ(証明書入力済区分, 償還払ViewStateDB, kensakuParameter);
        }
        ViewStateHolder.put(ViewStateKeys.証明書戻り, 確認戻り);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.一覧に戻る).respond();
    }

    private void set入力内容保存(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        償還払ViewStateDB.set償還払請求明細データList(set保存処理(div));
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
    }

    /**
     * 基本情報ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKihonInfo(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.基本情報).respond();
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnTokuteiShinryohi(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnServiceKeikakuhi(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnTokuteiNyushosya(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnGoukeiInfo(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKinkyujiShoteiShikan(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKinkyujiShisetsuRyoyo(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnShokujiHiyo(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnSeikyugakuShukei(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnShafukukeigengaku(KyufuShiharayiMeisaiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set証明書入力済チェック(div, dbJoho, kensakuParameter);
        set入力内容保存(div);
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

    private ShomeishoNyuryokuFlag set証明書入力済チェック(
            KyufuShiharayiMeisaiPanelDiv div, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShomeishoNyuryokuFlag nyuryokuFlag = new ShomeishoNyuryokuFlag();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = dbJoho.get証明書入力済フラグMap();
        if (証明書入力済フラグMap == null) {
            証明書入力済フラグMap = new HashMap<>();
        }
        nyuryokuFlag = set証明書入力済フラグMap(証明書入力済フラグMap, kensakuParameter, nyuryokuFlag);

        boolean is変更あり = getHandler(div).is内容変更状態();
        set証明書フラグ(処理モード, is変更あり, nyuryokuFlag, 証明書入力済フラグMap, kensakuParameter, dbJoho);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
        return nyuryokuFlag;
    }

    private ShomeishoNyuryokuFlag set証明書入力済フラグMap(
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, ShomeishoNyuryokuFlag nyuryokuFlag) {
        for (Map.Entry<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> mapValue : 証明書入力済フラグMap.entrySet()) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = mapValue.getKey();
            if (is同じキー(parameter, kensakuParameter)) {
                nyuryokuFlag = mapValue.getValue();
                証明書入力済フラグMap.remove(parameter);
            }
        }
        return nyuryokuFlag;
    }

    private boolean is同じキー(
            ShoukanharaihishinseimeisaikensakuParameter parameter, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        return parameter.getサービス年月().equals(kensakuParameter.getサービス年月())
                && parameter.get事業者番号().equals(kensakuParameter.get事業者番号())
                && parameter.get整理番号().equals(kensakuParameter.get整理番号())
                && parameter.get明細番号().equals(kensakuParameter.get明細番号())
                && parameter.get様式番号().equals(kensakuParameter.get様式番号())
                && parameter.get被保険者番号().equals(kensakuParameter.get被保険者番号());
    }

    private void set証明書フラグ(
            RString 処理モード, boolean is変更あり, ShomeishoNyuryokuFlag nyuryokuFlag,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, DbJohoViewState dbJoho) {
        if (登録.equals(処理モード)) {
            if (is変更あり) {
                nyuryokuFlag.set緊急時所定疾患_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            } else {
                nyuryokuFlag.set緊急時所定疾患_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
            }
            証明書入力済フラグMap.put(kensakuParameter, nyuryokuFlag);
            dbJoho.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
    }

    private void set証明書入力完了フラグ(
            ShomeishoNyuryokuKanryoKubunType 証明書入力済区分, DbJohoViewState dbJoho,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> kanryoFlagMap = dbJoho.get証明書入力完了フラグMap();
        if (kanryoFlagMap == null) {
            kanryoFlagMap = new HashMap<>();
        }
        for (Map.Entry<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> mapValue : kanryoFlagMap.entrySet()) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = mapValue.getKey();
            if (parameter.getサービス年月().equals(kensakuParameter.getサービス年月())
                    && parameter.get事業者番号().equals(kensakuParameter.get事業者番号())
                    && parameter.get整理番号().equals(kensakuParameter.get整理番号())
                    && parameter.get明細番号().equals(kensakuParameter.get明細番号())
                    && parameter.get様式番号().equals(kensakuParameter.get様式番号())
                    && parameter.get被保険者番号().equals(kensakuParameter.get被保険者番号())) {
                kanryoFlagMap.remove(parameter);
            }
        }
        kanryoFlagMap.put(kensakuParameter, ShomeishoNyuryokuKanryoKubunType.入力完了);
        dbJoho.set証明書入力完了フラグMap(kanryoFlagMap);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
        if (証明書入力済区分 == ShomeishoNyuryokuKanryoKubunType.入力未完了) {
            throw new ApplicationException(エーラメッセージ.toString());
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

    private RString getMax連番(KyufuShiharayiMeisaiPanelDiv div) {
        int max連番 = 0;
        for (dgdKyufuhiMeisai_Row meisai_Row : div.getPanelThree().getDgdKyufuhiMeisai().getDataSource()) {
            if (max連番 < Integer.valueOf(meisai_Row.getDefaultDataName6().toString())) {
                max連番 = Integer.valueOf(meisai_Row.getDefaultDataName6().toString());
            }
        }
        if (div.getPanelThree().getDgdKyufuhiMeisai().getDataSource().isEmpty()) {
            return new RString(max連番);
        }
        return new RString(++max連番);
    }
}

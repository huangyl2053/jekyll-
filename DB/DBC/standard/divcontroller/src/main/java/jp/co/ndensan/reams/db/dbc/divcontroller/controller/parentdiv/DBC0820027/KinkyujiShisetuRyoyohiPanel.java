/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820027;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027StateName.削除モード;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027StateName.新規修正モード;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面クラスです
 *
 * @reamsid_L DBC-1030-060 xupeng
 */
public class KinkyujiShisetuRyoyohiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");

    /**
     * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面初期化
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onLoad(KinkyujiShisetuRyoyohiPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter parameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getサービス年月();
        HihokenshaNo 被保険者番号 = parameter.get被保険者番号();
        RString 整理番号 = parameter.get整理番号();
        JigyoshaNo 事業者番号 = parameter.get事業者番号();
        RString 明細番号 = parameter.get明細番号();
        RString 証明書 = parameter.get様式番号();
        RString 様式番号 = parameter.get様式番号();
        RDate 申請日 = parameter.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.申請年月日, 申請日);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(様式番号, サービス年月);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanKinkyuShisetsuRyoyo> list = finder.
                getKinkyujiShisetsuRyoyoData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        ViewStateHolder.put(ViewStateKeys.緊急時施設療養DB, (Serializable) list);
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        List<ShokanKinkyuShisetsuRyoyo> updateList = new ArrayList<>();
        if (dbJoho != null && dbJoho.get償還払請求緊急時施設療養データList() != null) {
            updateList = getHandler(div).getUpdateList(dbJoho.get償還払請求緊急時施設療養データList(), parameter);
        }
        if (!updateList.isEmpty()) {
            getHandler(div).setRealList(list, updateList);
        } else {
            getHandler(div).initDgdKinkyujiShiseturyoyo(list);
        }
        getHandler(div).initPanelHead(被保険者番号, 整理番号, サービス年月, 申請日, 事業者番号,
                明細番号, 証明書, 様式番号, 識別コード);
        ShikibetsuNoKanri 識別番号管理情報 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(sikibetuKey.getServiceTeikyoYM(), sikibetuKey.getSikibetuNo());
        if (識別番号管理情報 != null) {
            int count = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            getHandler(div).getボタンを制御(識別番号管理情報, count);
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            getHandler(div).init_Delete();
            return ResponseData.of(div).setState(削除モード);
        } else {
            getHandler(div).init_Added();
            return ResponseData.of(div).setState(新規修正モード);
        }
    }

    /**
     * 追加する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnAdd(KinkyujiShisetuRyoyohiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).initAdd();
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btndgdModify(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).click_Modify();
        dgdKinkyujiShiseturyoyo_Row row = div.getDgdKinkyujiShiseturyoyo().getClickedItem();
        getHandler(div).set登録(row);
        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 修正);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタン
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btndgdDelete(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).click_Delete();
        dgdKinkyujiShiseturyoyo_Row row = div.getDgdKinkyujiShiseturyoyo().getClickedItem();
        getHandler(div).set登録(row);
        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録_削除);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 削除);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する①
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKeisan(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).cal1();
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する②
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnCal(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).cal2();
        return ResponseData.of(div).respond();
    }

    /**
     * クリアする
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnClear(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnCancel(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).click_Cancel();
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnConfirm(KinkyujiShisetuRyoyohiPanelDiv div) {
        for (ValidationMessageControlPairs pairs : getHandler(div).checkKakutei()) {
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        int maxRenban = 0;
        if (div.getDgdKinkyujiShiseturyoyo().getDataSource() != null && !div.getDgdKinkyujiShiseturyoyo().getDataSource().isEmpty()) {
            maxRenban = Integer.parseInt(div.getDgdKinkyujiShiseturyoyo().getDataSource().get(0).getDefaultDataName21().toString());
        }
        List<ShokanKinkyuShisetsuRyoyo> list = ViewStateHolder.get(ViewStateKeys.緊急時施設療養DB, ArrayList.class);
        getHandler(div).click_Confirm(state, maxRenban, list);
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 証明書一覧へ戻る
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnFree(KinkyujiShisetuRyoyohiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.一覧に戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
            return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.一覧に戻る).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンをクリックするのイベントです
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return 返すデータ
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKakutei(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShomeishoNyuryokuFlag nyuryokuFlag = set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        if (登録.equals(処理モード)) {
            SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
            ShomeishoNyuryokuKanryoKubunType 証明書入力済区分 = manager.証明書InputCheck(
                    nyuryokuFlag, kensakuParameter.get様式番号(), kensakuParameter.getサービス年月());
            set証明書入力完了フラグ(証明書入力済区分, dbJoho, kensakuParameter, div);
            for (ValidationMessageControlPairs pairs : getHandler(div).check証明書入力()) {
                if (pairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(pairs).respond();
                }
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.一覧に戻る).respond();
    }

    private void set入力内容保存(
            KinkyujiShisetuRyoyohiPanelDiv div, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        List<ShokanKinkyuShisetsuRyoyo> updateList = new ArrayList<>();
        if (dbJoho.get償還払請求緊急時施設療養データList() != null) {
            updateList = getHandler(div).removeLastData(dbJoho.get償還払請求緊急時施設療養データList(), kensakuParameter);
        }
        ShokanKihon kihon = null;
        Integer updateNum = null;
        List<ShokanKihon> kihonList = dbJoho.get償還払請求基本データList();
        if (kihonList == null) {
            kihonList = new ArrayList<>();
        }
        if (!kihonList.isEmpty()) {
            Map<Integer, ShokanKihon> map = getHandler(div).getShokanKihonMap(kihonList, kensakuParameter);
            for (Map.Entry<Integer, ShokanKihon> mapValue : map.entrySet()) {
                kihon = mapValue.getValue();
                updateNum = mapValue.getKey();
                break;
            }
        }

        List<ShokanKinkyuShisetsuRyoyo> list = ViewStateHolder.get(ViewStateKeys.緊急時施設療養DB, ArrayList.class);
        updateList = getHandler(div).get更新リスト(list, kensakuParameter, updateList);
        kihon = getHandler(div).set基本情報(kihon);

        dbJoho.set償還払請求緊急時施設療養データList(new ArrayList<>(updateList));
        if (kihon != null && updateNum != null) {
            kihonList.set(updateNum, kihon);
            dbJoho.set償還払請求基本データList(new ArrayList<>(kihonList));
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);

    }

    /**
     * 基本情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKihonInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.基本情報).respond();
    }

    /**
     * 給付費明細
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKyufuhiMeisai(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiShinryohi(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.特定診療費).respond();
    }

    /**
     * サービス計画費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnServiceKeikakuhi(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.サービス計画費).respond();
    }

    /**
     * 特定入所者費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiNyushosya(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 合計情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnGoukeiInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.合計情報).respond();
    }

    /**
     * 給付費明細(住所地特例)
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 緊急時・所定疾患
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKinkyujiShoteiShikan(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 食事費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnShokujiHiyo(KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.食事費用).respond();
    }

    /**
     * 請求額集計
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnSeikyugakuShukei(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.請求額集計).respond();
    }

    /**
     * 社福軽減額
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnShafukukeigenGaku(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        set入力内容保存(div, dbJoho, kensakuParameter);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.社福軽減額).respond();
    }

    private ShomeishoNyuryokuFlag set入力有無フラグ(
            KinkyujiShisetuRyoyohiPanelDiv div, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = dbJoho.get証明書入力済フラグMap();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap = dbJoho.get証明書変更済フラグMap();
        if (証明書入力済フラグMap == null) {
            証明書入力済フラグMap = new HashMap<>();
        }
        if (証明書変更済フラグMap == null) {
            証明書変更済フラグMap = new HashMap<>();
        }
        ShomeishoNyuryokuFlag nyuryokuFlag = 証明書入力済フラグMap.get(kensakuParameter);
        ShomeishoHenkoFlag henkoFlag = 証明書変更済フラグMap.get(kensakuParameter);

        boolean is変更あり = getHandler(div).isデータ変更();
        set証明書フラグ(処理モード, is変更あり, nyuryokuFlag, 証明書入力済フラグMap, kensakuParameter, dbJoho, henkoFlag, 証明書変更済フラグMap);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
        return nyuryokuFlag;
    }

    private void set証明書フラグ(
            RString 処理モード, boolean is変更あり, ShomeishoNyuryokuFlag nyuryokuFlag,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, DbJohoViewState dbJoho, ShomeishoHenkoFlag henkoFlag,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap) {
        if (nyuryokuFlag == null) {
            nyuryokuFlag = new ShomeishoNyuryokuFlag();
        }
        if (henkoFlag == null) {
            henkoFlag = new ShomeishoHenkoFlag();
        }
        if (登録.equals(処理モード)) {
            if (is変更あり) {
                nyuryokuFlag.set緊急時施設療養費_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            } else {
                nyuryokuFlag.set緊急時施設療養費_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
            }
            証明書入力済フラグMap.put(kensakuParameter, nyuryokuFlag);
            dbJoho.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
        if (修正.equals(処理モード)) {
            if (is変更あり) {
                henkoFlag.set緊急時施設療養費_証明書変更済フラグ(ShomeishoHenkoKubunType.変更あり);
            } else {
                henkoFlag.set緊急時施設療養費_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
            }
            証明書変更済フラグMap.put(kensakuParameter, henkoFlag);
            dbJoho.set証明書変更済フラグMap(証明書変更済フラグMap);
        }
    }

    private void set証明書入力完了フラグ(
            ShomeishoNyuryokuKanryoKubunType 証明書入力済区分, DbJohoViewState dbJoho,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, KinkyujiShisetuRyoyohiPanelDiv div) {
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
        div.setHdnShomeishoKanryoFlag(証明書入力済区分.getCode());
    }

    private KinkyujiShisetuRyoyohiPanelHandler getHandler(KinkyujiShisetuRyoyohiPanelDiv div) {
        return KinkyujiShisetuRyoyohiPanelHandler.of(div);
    }

}

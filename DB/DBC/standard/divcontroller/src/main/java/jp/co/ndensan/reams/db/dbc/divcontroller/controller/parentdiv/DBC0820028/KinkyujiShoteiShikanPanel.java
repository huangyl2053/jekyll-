/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820028;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.DBC0820028StateName.削除モード;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.DBC0820028StateName.新規修正モード;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.DBC0820028TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.dgdKinkyujiShoteiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
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
 * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患）画面クラスです
 *
 * @reamsid_L DBC-1030-050 xupeng
 */
public class KinkyujiShoteiShikanPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString エーラメッセージ = new RString("請求額集計情報の未登録のサービス種類が存在します。請求額集計情報を登録して下さい。");
    private static final RString NUM1 = new RString("1");
    private static final RString NUM0 = new RString("0");

    /**
     * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面初期化
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onLoad(KinkyujiShoteiShikanPanelDiv div) {
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
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ArrayList<ShokanShoteiShikkanShisetsuRyoyo> list = getHandler(div).initPanelHead(
                被保険者番号, 整理番号, サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号, 識別コード, 償還払ViewStateDB, parameter);

        getHandler(div).initDgdKinkyujiShoteiList(list);
        setRowSort(div);
        ViewStateHolder.put(ViewStateKeys.所定疾患施設療養費等データ, list);
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー,
                SikibetuNokennsakuki.class);
        ShikibetsuNoKanri 識別番号管理情報 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (識別番号管理情報 != null) {
            getHandler(div).getボタンを制御(識別番号管理情報, parameter);
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            getHandler(div).init_Delete();
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            return ResponseData.of(div).setState(削除モード);
        } else {
            return ResponseData.of(div).setState(新規修正モード);
        }
    }

    /**
     * 基本情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKihonInfo(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.基本情報).respond();
    }

    /**
     * 給付費明細
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKyufuhiMeisai(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnTokuteiShinryohi(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.特定診療費).respond();
    }

    /**
     * サービス計画費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnServiceKeikakuhi(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.サービス計画費).respond();
    }

    /**
     * 特定入所者費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnTokuteiNyushosya(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 合計情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnGoukeiInfo(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.合計情報).respond();
    }

    /**
     * 給付費明細(住所地特例)
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(
            KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 緊急時施設療養費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKinkyujiShisetsuRyoyohi(
            KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 食事費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnShokujiHiyo(KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.食事費用).respond();
    }

    /**
     * 請求額集計
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnSeikyugakuShukei(
            KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.請求額集計).respond();
    }

    /**
     * 社福軽減額
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnShafukukeigenGaku(
            KinkyujiShoteiShikanPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setViewState(div, kensakuParameter, dbJoho);
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.社福軽減額).respond();
    }

    /**
     * 追加する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnAdd(
            KinkyujiShoteiShikanPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).initAdd();
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnDgdModify(
            KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).click_Modify();
        dgdKinkyujiShoteiList_Row row = div.getDgdKinkyujiShoteiList().getClickedItem();
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
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnDgdDelete(
            KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).click_Delete();
        dgdKinkyujiShoteiList_Row row = div.getDgdKinkyujiShoteiList().getClickedItem();
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
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCal1(KinkyujiShoteiShikanPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check計算1();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).cal1();
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する②
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCal2(KinkyujiShoteiShikanPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check計算2();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).cal2();
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する③
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCal3(KinkyujiShoteiShikanPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check計算3();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).cal3();
        return ResponseData.of(div).respond();
    }

    /**
     * クリアする
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnClear(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCancel(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).click_Cancel();
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnConfirm(KinkyujiShoteiShikanPanelDiv div) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<ShokanShoteiShikkanShisetsuRyoyo> list = ViewStateHolder.get(
                ViewStateKeys.所定疾患施設療養費等データ, List.class);
        getHandler(div).click_Confirm(state, list);
        setRowSort(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 共通エリア_確定する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnSave(KinkyujiShoteiShikanPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter keys = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (登録.equals(処理モード) || 修正.equals(処理モード)) {
            return save(div, keys, 処理モード);
        }
        if (getHandler(div).get内容変更状態()) {
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM1);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.一覧に戻る).respond();
    }

    private ResponseData<KinkyujiShoteiShikanPanelDiv> save(KinkyujiShoteiShikanPanelDiv div,
            ShoukanharaihishinseimeisaikensakuParameter keys, RString 処理モード) {
        if (!ResponseHolder.isReRequest()) {
            List<ShokanShoteiShikkanShisetsuRyoyo> list = ViewStateHolder.get(
                    ViewStateKeys.所定疾患施設療養費等データ, List.class);
            DbJohoViewState dbJohoViewState = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB,
                    DbJohoViewState.class);
            dbJohoViewState = getHandler(div).保存処理(keys, list, dbJohoViewState);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJohoViewState);
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                    ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
            ShomeishoNyuryokuFlag nyuryokuFlag = set入力有無フラグ(div, dbJohoViewState, kensakuParameter);
            if (登録.equals(処理モード)) {
                SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
                ShomeishoNyuryokuKanryoKubunType 証明書入力済区分 = manager.証明書InputCheck(
                        nyuryokuFlag, kensakuParameter.get様式番号(), kensakuParameter.getサービス年月());
                set証明書入力完了フラグ(証明書入力済区分, dbJohoViewState, kensakuParameter);
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 証明書一覧へ
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnFree(KinkyujiShoteiShikanPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.一覧に戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM0);
            return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.一覧に戻る).respond();
        }

        return ResponseData.of(div).respond();
    }

    private void setRowSort(KinkyujiShoteiShikanPanelDiv div) {
        List<dgdKinkyujiShoteiList_Row> rowList = div.getDgdKinkyujiShoteiList().getDataSource();

        Collections.sort(rowList, new Comparator<dgdKinkyujiShoteiList_Row>() {
            @Override
            public int compare(dgdKinkyujiShoteiList_Row arg0, dgdKinkyujiShoteiList_Row arg1) {
                int i = arg1.getRenban().toInt() - (arg0.getRenban().toInt());
                return i;
            }
        });
        div.getDgdKinkyujiShoteiList().setDataSource(rowList);
    }

    private void setViewState(KinkyujiShoteiShikanPanelDiv div, ShoukanharaihishinseimeisaikensakuParameter keys,
            DbJohoViewState dbJohoViewState) {
        List<ShokanShoteiShikkanShisetsuRyoyo> list = ViewStateHolder.get(
                ViewStateKeys.所定疾患施設療養費等データ, List.class);
        dbJohoViewState = getHandler(div).保存処理(keys, list, dbJohoViewState);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJohoViewState);
    }

    private ShomeishoNyuryokuFlag set入力有無フラグ(
            KinkyujiShoteiShikanPanelDiv div, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShomeishoNyuryokuFlag nyuryokuFlag = new ShomeishoNyuryokuFlag();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = dbJoho.get証明書入力済フラグMap();
        if (証明書入力済フラグMap == null) {
            証明書入力済フラグMap = new HashMap<>();
        }
        nyuryokuFlag = set証明書入力済フラグMap(証明書入力済フラグMap, kensakuParameter, nyuryokuFlag);

        boolean is変更あり = getHandler(div).get内容変更状態();
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

    private KinkyujiShoteiShikanPanelHandler getHandler(KinkyujiShoteiShikanPanelDiv div) {
        return KinkyujiShoteiShikanPanelHandler.of(div);
    }

    private KinkyujiShoteiShikanPanelValidationHandler getCheckHandler(KinkyujiShoteiShikanPanelDiv div) {
        return new KinkyujiShoteiShikanPanelValidationHandler(div);
    }

}

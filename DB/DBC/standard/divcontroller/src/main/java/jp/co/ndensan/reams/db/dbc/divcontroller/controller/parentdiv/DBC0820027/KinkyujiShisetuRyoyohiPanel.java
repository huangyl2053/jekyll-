/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820027;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027StateName.削除モード;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027StateName.新規修正モード;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
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
    private static final RString 必要な分証明書入力済 = new RString("1");
    private static final RString 証明書入力未済あり = new RString("2");

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
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanKinkyuShisetsuRyoyo> list = finder.
                getKinkyujiShisetsuRyoyoData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<ShokanKinkyuShisetsuRyoyo> updateList = ViewStateHolder.get(ViewStateKeys.償還払請求緊急時施設療養データ, ArrayList.class);
        Map<RString, RString> map = ViewStateHolder.get(ViewStateKeys.緊急時施設療養_グリッドエリア, Map.class);
        if (map != null && updateList != null) {
            List<ShokanKinkyuShisetsuRyoyo> realList = getHandler(div).setRealList(list, updateList, map);
            ViewStateHolder.put(ViewStateKeys.緊急時施設療養, (Serializable) realList);
        } else {
            getHandler(div).initDgdKinkyujiShiseturyoyo(list);
            int maxRenban = getHandler(div).get最大連番(list);
            ViewStateHolder.put(ViewStateKeys.緊急時施設療養_最大連番, maxRenban);
            ViewStateHolder.put(ViewStateKeys.緊急時施設療養, (Serializable) list);
        }

        getHandler(div).initPanelHead(被保険者番号, 整理番号, サービス年月, 申請日, 事業者番号,
                明細番号, 証明書, 様式番号, 識別コード);
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー,
                SikibetuNokennsakuki.class);
        ShikibetsuNoKanri 識別番号管理情報 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
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
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        int maxRenban = ViewStateHolder.get(ViewStateKeys.緊急時施設療養_最大連番, Integer.class);
        boolean is追加 = getHandler(div).click_Confirm(state, maxRenban);
        if (is追加) {
            maxRenban = maxRenban + 1;
            ViewStateHolder.put(ViewStateKeys.緊急時施設療養_最大連番, maxRenban);
        }
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
        boolean flag = getHandler(div).get内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
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
        ShomeishoNyuryokuFlag flag = set入力有無フラグ(div);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = set入力内容保存(div);

        SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
//        RString 証明書入力済区分 = manager.緊急時施設療養証明書InputCheck(
//                flag.get緊急時施設療養費_証明書入力済フラグ().getCode(), kensakuParameter.get様式番号(), kensakuParameter.getサービス年月());
//        if (必要な分証明書入力済.equals(証明書入力済区分)) {
//            //TODO
//        }
//        if (証明書入力未済あり.equals(証明書入力済区分)) {
//            throw new ApplicationException("");
//        }

        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.一覧に戻る).respond();
    }

    private ShoukanharaihishinseimeisaikensakuParameter set入力内容保存(KinkyujiShisetuRyoyohiPanelDiv div) {
        List<ShokanKinkyuShisetsuRyoyo> updateList = ViewStateHolder.get(ViewStateKeys.償還払請求緊急時施設療養データ, ArrayList.class);
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        try {
            List<ShokanKinkyuShisetsuRyoyo> list = ViewStateHolder.get(ViewStateKeys.緊急時施設療養, ArrayList.class);
            updateList = getHandler(div).get更新リスト(list, kensakuParameter, updateList);
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.償還払請求緊急時施設療養データ, (Serializable) updateList);
        if (updateList != null && !updateList.isEmpty()) {
            Map<RString, RString> map = getHandler(div).getDataGridMap();
            ViewStateHolder.put(ViewStateKeys.緊急時施設療養_グリッドエリア, (Serializable) map);
        }
        return kensakuParameter;
    }

    /**
     * 基本情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKihonInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.基本情報).respond();
    }

    /**
     * 給付費明細
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKyufuhiMeisai(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiShinryohi(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.特定診療費).respond();
    }

    /**
     * サービス計画費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnServiceKeikakuhi(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.サービス計画費).respond();
    }

    /**
     * 特定入所者費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiNyushosya(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 合計情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnGoukeiInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
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
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
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
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 食事費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnShokujiHiyo(KinkyujiShisetuRyoyohiPanelDiv div) {
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
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
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
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
        set入力有無フラグ(div);
        putViewState(div);
        set入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.社福軽減額).respond();
    }

    private ShomeishoNyuryokuFlag set入力有無フラグ(KinkyujiShisetuRyoyohiPanelDiv div) {
        ShomeishoNyuryokuFlag flag = ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class);
        getHandler(div).set証明書入力有無フラグ(flag);
        //TODO 証明書変更済フラグ
        ViewStateHolder.put(ViewStateKeys.証明書入力済フラグ, flag);
        return flag;
    }

    private void putViewState(KinkyujiShisetuRyoyohiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ShoukanharaihishinseimeisaikensakuParameter para = getHandler(div).setParameter();
        ViewStateHolder.put(ViewStateKeys.申請日, para.get申請日());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                para.getサービス年月(),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                para.get事業者番号(),
                para.get様式番号(),
                para.get明細番号(),
                null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }

    private KinkyujiShisetuRyoyohiPanelHandler getHandler(KinkyujiShisetuRyoyohiPanelDiv div) {
        return KinkyujiShisetuRyoyohiPanelHandler.of(div);
    }

}

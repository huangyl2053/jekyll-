/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820027;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027StateName.削除モード;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027StateName.新規修正モード;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.DBC0820027TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
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
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");

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

        ArrayList<ShokanKinkyuShisetsuRyoyo> list = getHandler(div).initPanelHead(
                被保険者番号, 整理番号, サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号, 識別コード);

        getHandler(div).initDgdKinkyujiShiseturyoyo(list);
        ViewStateHolder.put(ViewStateKeys.緊急時施設療養, list);
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
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            getHandler(div).init_Delete();
            return ResponseData.of(div).setState(削除モード);
        } else {
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
        getHandler(div).click_Confirm(state);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請を保存する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnSave(KinkyujiShisetuRyoyohiPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter keys = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        try {
            if (削除.equals(処理モード)) {
                if (!ResponseHolder.isReRequest()) {
                    getHandler(div).保存処理(keys, 処理モード, null);
                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                            replace(削除.toString())).respond();
                }
                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
                    return createResponse(div);
                }
            } else {
                ValidationMessageControlPairs validPairs = getHandler(div).入力チェック();
                if (validPairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(validPairs).respond();
                }
                boolean flag = getHandler(div).get内容変更状態();
                if (flag) {
                    return save(div, keys, 処理モード);
                } else {
                    return noChange(div);
                }
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KinkyujiShisetuRyoyohiPanelDiv> save(KinkyujiShisetuRyoyohiPanelDiv div,
            ShoukanharaihishinseimeisaikensakuParameter keys, RString 処理モード) {
        if (!ResponseHolder.isReRequest()) {
            List<ShokanKinkyuShisetsuRyoyo> shokanKinkyuShisetsuRyoyoList = ViewStateHolder.get(
                    ViewStateKeys.緊急時施設療養, List.class);
            getHandler(div).保存処理(keys, 処理モード, shokanKinkyuShisetsuRyoyoList);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                    replace(登録.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<KinkyujiShisetuRyoyohiPanelDiv> noChange(KinkyujiShisetuRyoyohiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    /**
     * 共通エリア_取消する
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
     * 基本情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKihonInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.基本情報).respond();
    }

    /**
     * 給付費明細
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKyufuhiMeisai(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiShinryohi(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.特定診療費).respond();
    }

    /**
     * サービス計画費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnServiceKeikakuhi(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.サービス計画費).respond();
    }

    /**
     * 特定入所者費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiNyushosya(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 合計情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnGoukeiInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
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
        putViewState(div);
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
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 食事費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnShokujiHiyo(KinkyujiShisetuRyoyohiPanelDiv div) {
        putViewState(div);
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
        putViewState(div);
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
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820027TransitionEventName.社福軽減額).respond();
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

    private ResponseData<KinkyujiShisetuRyoyohiPanelDiv> createResponse(KinkyujiShisetuRyoyohiPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}

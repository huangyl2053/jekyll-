/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1000062;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KijunShunyugakuTekiyoKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.DBC1000062StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.DBC1000062TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.KijunShunyuShinseiTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000062.KijunShunyuShinseiTourokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000062.KijunShunyuShinseiTourokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * DBC1000062_基準収入額適用申請登録のクラスです。
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class KijunShunyuShinseiTouroku {

    private static final RString KEY_追加 = new RString("追加");
    private static final RString KEY_修正 = new RString("修正");
    private static final int NUM_0 = 0;
    private static final Decimal KEY_100億円 = new Decimal("10000000000");
    private static final Decimal KEY_99億円 = new Decimal("9999999999");
    private static final RString MESSAGE_合計 = new RString("所得情報の収入合計＞入力した収入合計になっています。");
    private static final RString MESSAGE_総収入金額算出 = new RString("総収入金額算出ボタンを押下してください。");
    private static final RString チェックなし = new RString("0");
    private static final RString チェック済み = new RString("1");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onLoad(KijunShunyuShinseiTourokuDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        SetaiCode 世帯コード = 引き継ぎ情報.get世帯コード();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.世帯コード, 世帯コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty() && !getHandler(div).get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        getHandler(div).set画面のdataSource();
        Map<RString, List<KijunShunyugakuTekiyoKanri>> 基準収入Map = getHandler(div).initialize(
                被保険者番号, 識別コード, 世帯コード);
        ViewStateHolder.put(ViewStateKeys.基準収入額適用管理情報, (Serializable) 基準収入Map);
        getHandler(div).set保存するボタンDisabled();
        return ResponseData.of(div).setState(DBC1000062StateName.一覧);
    }

    /**
     * 一覧追加ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnAdd_Ichiran(KijunShunyuShinseiTourokuDiv div) {
        SetaiCode 世帯コード = ViewStateHolder.get(ViewStateKeys.世帯コード, SetaiCode.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        ViewStateHolder.put(ViewStateKeys.画面状態, KEY_追加);
        getHandler(div).set明細パネル(KEY_追加, 世帯コード, 識別コード);
        return ResponseData.of(div).setState(DBC1000062StateName.明細追加);
    }

    /**
     * 一覧Grid修正ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnModify_Ichiran(KijunShunyuShinseiTourokuDiv div) {
        SetaiCode 世帯コード = ViewStateHolder.get(ViewStateKeys.世帯コード, SetaiCode.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        ViewStateHolder.put(ViewStateKeys.画面状態, KEY_修正);
        getHandler(div).set明細パネル(KEY_修正, 世帯コード, 識別コード);
        return ResponseData.of(div).setState(DBC1000062StateName.明細修正);
    }

    /**
     * 一覧Grid削除ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnDelete_Ichiran(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set一覧削除();
        getHandler(div).set保存するボタンDisabled();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧Grid取消ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnCancel_Ichiran(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set一覧取消();
        getHandler(div).set保存するボタンDisabled();
        return ResponseData.of(div).respond();
    }

    /**
     * 所得状況ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnBefore_ShotokuJokyo(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set所得状況隠し項目();
        return ResponseData.of(div).respond();
    }

    /**
     * 12/31状況ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnBefore_1231Jokyo(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set1231状況隠し項目();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnCommonUpdate(KijunShunyuShinseiTourokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).変更チェックValidate();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.保存の確認.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            Map<RString, List<KijunShunyugakuTekiyoKanri>> 基準収入Map = ViewStateHolder.get(
                    ViewStateKeys.基準収入額適用管理情報, Map.class);
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            try {
                getHandler(div).to保存(基準収入Map);
            } catch (SystemException | ApplicationException e) {
                throw new ApplicationException(e.getMessage());
            }
            AccessLogger.log(AccessLogType.更新, getHandler(div).toPersonalData(識別コード, 被保険者番号.getColumnValue()));
            getHandler(div).前排他キーの解除(被保険者番号.getColumnValue());
            div.getKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBC1000062StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnReSearch(KijunShunyuShinseiTourokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        return getHandler(div).getCheckMessage(div, DBC1000062TransitionEventName.再検索, 被保険者番号);
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnSearchResult(KijunShunyuShinseiTourokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        return getHandler(div).getCheckMessage(div, DBC1000062TransitionEventName.検索結果一覧, 被保険者番号);
    }

    /**
     * 世帯コードのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onBlur_txtSetaiCode(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set押下可能ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理年度のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onBlur_txtShoriNendo(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set押下可能ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯員把握基準日のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onBlur_txtSetaiinHaakuKijunYMD(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set押下可能ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯再算出ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnSetaiSaiSanshutsu(KijunShunyuShinseiTourokuDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).set世帯再算出(識別コード, 状態);
        return ResponseData.of(div).respond();
    }

    /**
     * 控除再算出ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnKojoSaiSanshutsu(KijunShunyuShinseiTourokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).実行時チェックValidate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).set控除算出(ViewStateHolder.get(ViewStateKeys.画面状態, RString.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 追加ボタン（明細）のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onOkClose_btnAddMeisai(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).setダイアログで選択された世帯員();
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯員Grid削除ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnDeleteMeisai(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set世帯員削除();
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯員Grid取消ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnCancelMeisai(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set世帯員取消();
        return ResponseData.of(div).respond();
    }

    /**
     * 総収入金額算出ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnCalcTotalShunyu(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set総収入金額();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnMeisaiCancel(KijunShunyuShinseiTourokuDiv div) {
        return ResponseData.of(div).setState(DBC1000062StateName.一覧);
    }

    /**
     * 確定ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnMeisaiKautei(KijunShunyuShinseiTourokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            div.setHdnFlag1(チェックなし);
            div.setHdnFlag2(チェックなし);
            div.setHdnFlag3(チェックなし);
            div.setHdnFlag4(チェックなし);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (!getHandler(div).is総収入額チェック()) {
            throw new ApplicationException(MESSAGE_総収入金額算出.toString());
        }

        ValidationMessageControlPairs validPairs = getValidationHandler(div).明細パネルチェックValidate();
        validPairs.add(getValidationHandler(div).明細確定時のチェック処理());
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        if (!チェック済み.equals(div.getHdnFlag1()) && getHandler(div).is収入額チェック()) {
            WarningMessage message = new WarningMessage(DbzWarningMessages.確認.getMessage().getCode(),
                    DbzWarningMessages.確認.getMessage().replace(MESSAGE_合計.toString()).evaluate());
            div.setHdnFlag1(チェック済み);
            return ResponseData.of(div).addMessage(message).respond();
        }

        validPairs = getValidationHandler(div).明細GridチェックValidate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        validPairs = getValidationHandler(div).世帯再算出チェックValidate();
        if (!チェック済み.equals(div.getHdnFlag2()) && validPairs.iterator().hasNext()) {
            div.setHdnFlag2(チェック済み);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        validPairs = getValidationHandler(div).受給者または事業対象者チェックValidate();
        if (!チェック済み.equals(div.getHdnFlag3()) && validPairs.iterator().hasNext()) {
            div.setHdnFlag3(チェック済み);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        validPairs = getValidationHandler(div).算定基準額チェックValidate();
        if (!チェック済み.equals(div.getHdnFlag4()) && validPairs.iterator().hasNext()) {
            div.setHdnFlag4(チェック済み);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        Decimal 総収入額 = div.getMeisai().getTxtTotalShunyu().getValue();
        if (KEY_100億円.compareTo(総収入額) < NUM_0) {
            div.getMeisai().getTxtTotalShunyu().setValue(KEY_99億円);
        }
        getHandler(div).get明細情報の反映(ViewStateHolder.get(ViewStateKeys.画面状態, RString.class));
        return ResponseData.of(div).setState(DBC1000062StateName.一覧);
    }

    /**
     * 完了ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnComplete(KijunShunyuShinseiTourokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC1000062TransitionEventName.完了).respond();
    }

    /**
     * 保存するボタン制御
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> onClick_btnSaveCheck(KijunShunyuShinseiTourokuDiv div) {
        getHandler(div).set保存するボタンDisabled();
        return ResponseData.of(div).respond();
    }

    private KijunShunyuShinseiTourokuHandler getHandler(KijunShunyuShinseiTourokuDiv div) {
        return KijunShunyuShinseiTourokuHandler.of(div);
    }

    private KijunShunyuShinseiTourokuValidationHandler getValidationHandler(KijunShunyuShinseiTourokuDiv div) {
        return new KijunShunyuShinseiTourokuValidationHandler(div);
    }

}

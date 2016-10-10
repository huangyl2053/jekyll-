/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1230011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHoseiResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.DBC1230011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.DBC1230011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc1230011.KogakuGassanShikyuKetteiHoseiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHosei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiPanel {

    private static final RString 高額合算支給決定情報補正 = new RString("高額合算支給決定情報補正（単）");
    private static final RString 事業高額合算支給決定情報補正 = new RString("事業分高額合算支給決定情報補正（単）");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 削除照会モード = new RString("削除照会モード");
    private static final RString 口座修正モード = new RString("口座修正モード");
    private static final RString フォーカスを = new RString("txtKensakuTaishoNendo");
    private static final RString 照会 = new RString("照会");
    private static final RString 処理不可 = new RString("処理不可");
    private static final int NUM_THREE = 3;
    private static final int NUM_FIVE = 5;
    private static final int NUM_ELEVEN = 11;

    /**
     * 画面初期化です。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onLoad(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        getHandler(div).set事業分フラグ();
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(DbcInformationMessages.被保険者でないデータ.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        if (識別コード != null && !識別コード.isEmpty()) {
            div.getCcdKaigoAtenaInfo().initialize(識別コード);
        }
        getHandler(div).getデータ存在チェック(被保険者番号);
        if (!getHandler(div).is前排他キーのセット(被保険者番号)) {
            throw new PessimisticLockingException();
        }
        AccessLogger.log(AccessLogType.照会,
                getHandler(div).toPersonalData(識別コード,
                        被保険者番号.getColumnValue()));
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        getHandler(div).set新規と検索条件登録パネル();
        List<KogakuGassanShikyuKetteiHoseiResult> result = new ArrayList<>();
        getHandler(div).set決定情報一覧グリッド(result);
        if (div.get事業分フラグ().equals(new RString(Boolean.FALSE.toString()))) {
            return ResponseData.of(ResponseData.of(div).setState(
                    DBC1230011StateName.支給決定情報一覧).data).rootTitle(高額合算支給決定情報補正).
                    focusId(フォーカスを).respond();
        } else {
            return ResponseData.of(ResponseData.of(div).setState(
                    DBC1230011StateName.支給決定情報一覧).data).rootTitle(事業高額合算支給決定情報補正).
                    focusId(フォーカスを).respond();
        }
    }

    /**
     * 「検索する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnKensaku(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        boolean 事業分フラグ = false;
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            事業分フラグ = true;
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYear 対象年度 = FlexibleYear.EMPTY;
        HokenshaNo 証記載保険者番号 = HokenshaNo.EMPTY;
        if (div.getSearchPanel().getTxtKensakuTaishoNendo().getValue() != null) {
            対象年度 = new FlexibleYear(div.getSearchPanel().getTxtKensakuTaishoNendo().
                    getValue().getYear().toDateString());
        }
        if (div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()) {
            証記載保険者番号 = new HokenshaNo(div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue());
        }
        List<KogakuGassanShikyuKetteiHoseiResult> result = KogakuGassanShikyuKetteiHosei.createInstance().
                selectShikyuKetteiHoseiList(被保険者番号, 対象年度, 証記載保険者番号, div.getSearchPanel().
                        getTxtKensakuShikyuSeiriNo().getValue(), 事業分フラグ);
        if (result == null || result.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.支給決定情報補正, (Serializable) result);
        getHandler(div).set決定情報一覧グリッド(result);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
    }

    /**
     * 「新規登録_対象年度」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtShinkiTaishoNendo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).validate新規登録対象年度();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「新規登録_証記載保険者番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtShinkiHihokenshaNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).validate新規登録証記載保険者番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「新規登録_連絡票整理番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtShinkiShikyuSeiriNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).validate新規登録連絡票整理番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() == null
                && div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()) {
            RDate date = new RDate(div.getShinkiPanel().
                    getTxtShinkiShikyuSeiriNo().getValue().substring(0, NUM_THREE).toString());
            div.getShinkiPanel().getTxtShinkiTaishoNendo().setValue(date);
        }
        if ((div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() == null
                || div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty())
                && div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()) {
            div.getShinkiPanel().getTxtShinkiHihokenshaNo().setValue(div.getShinkiPanel().
                    getTxtShinkiShikyuSeiriNo().getValue().substring(NUM_FIVE, NUM_ELEVEN));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件_対象年度」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtKensakuTaishoNendo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).validate検索条件対象年度();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件_証記載保険者番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtKensakuHihokenshaNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).validate検索条件証記載保険者番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件_連絡票整理番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtKensakuShikyuSeiriNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).validate検索条件連絡票整理番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「決定情報を追加する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnKetteiJohoAdd(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check決定情報を追加する();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 処理モー = getHandler(div).get処理モード(被保険者番号, 新規);
        if (処理不可.equals(処理モー)) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).set新規決定情報初期値(被保険者番号, 識別コード);
        ViewStateHolder.put(ViewStateKeys.画面モード, 新規);
        KogakuGassanShikyuKetteiHoseiDetailParameter parameter = getHandler(div).get決定情報タブ();
        ViewStateHolder.put(ViewStateKeys.詳細データ, parameter);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「決定情報を修正する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_modify(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 処理モー = getHandler(div).get処理モード(被保険者番号, 修正);
        if (処理不可.equals(処理モー)) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).set新規以外の決定情報初期値(修正, 識別コード);
        if (口座修正モード.equals(処理モー)) {
            getHandler(div).set状態_Three();
        } else {
            getHandler(div).set状態_One();
        }
        ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
        KogakuGassanShikyuKetteiHoseiDetailParameter parameter = getHandler(div).get決定情報タブ();
        ViewStateHolder.put(ViewStateKeys.詳細データ, parameter);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「決定情報を選択する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_select(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).set新規以外の決定情報初期値(照会, 識別コード);
        getHandler(div).set状態_Two();
        ViewStateHolder.put(ViewStateKeys.画面モード, 照会);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「決定情報を削除する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_delete(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 処理モー = getHandler(div).get処理モード(被保険者番号, 削除);
        if (処理不可.equals(処理モー)) {
            return ResponseData.of(div).respond();
        }
        if (削除照会モード.equals(処理モー)) {
            getHandler(div).set新規以外の決定情報初期値(照会, 識別コード);
        } else {
            getHandler(div).set新規以外の決定情報初期値(削除, 識別コード);
        }
        getHandler(div).set状態_Two();
        ViewStateHolder.put(ViewStateKeys.画面モード, 削除);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「支給区分RAD」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_radShikyuKubunCode(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        getHandler(div).set支給区分連動();
        return ResponseData.of(div).respond();
    }

    /**
     * 「決定情報一覧に戻する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnBackSearchResult(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        KogakuGassanShikyuKetteiHoseiDetailParameter para = ViewStateHolder.get(
                ViewStateKeys.詳細データ, KogakuGassanShikyuKetteiHoseiDetailParameter.class);
        boolean flag = false;
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))
                || 照会.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
        } else {
            flag = getHandler(div).is決定情報内容変更状態(para);
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).clear決定情報();
                getHandler(div).前排他キーの解除(被保険者番号);
                return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            getHandler(div).前排他キーの解除(被保険者番号);
            getHandler(div).clear決定情報();
            return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
        }
    }

    /**
     * 「検索結果一覧に戻する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnReturn(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        KogakuGassanShikyuKetteiHoseiDetailParameter para = ViewStateHolder.get(
                ViewStateKeys.詳細データ, KogakuGassanShikyuKetteiHoseiDetailParameter.class);
        boolean flag = false;
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))
                || 照会.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC1230011TransitionEventName.対象者検索に戻る).respond();
        } else {
            flag = getHandler(div).is決定情報内容変更状態(para);
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).前排他キーの解除(被保険者番号);
                return ResponseData.of(div).forwardWithEventName(
                        DBC1230011TransitionEventName.対象者検索に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            getHandler(div).前排他キーの解除(被保険者番号);
            return ResponseData.of(div).forwardWithEventName(DBC1230011TransitionEventName.検索結果一覧に戻る).respond();
        }
    }

    /**
     * 「検索結果一覧に戻する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnSearchResult(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).前排他キーの解除(被保険者番号);
        return ResponseData.of(div).forwardWithEventName(DBC1230011TransitionEventName.検索結果一覧に戻る).respond();
    }

    /**
     * 「対象者検索に戻るする」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnRevert(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).前排他キーの解除(被保険者番号);
        return ResponseData.of(div).forwardWithEventName(DBC1230011TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 「対象者検索に戻るする」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnBack(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        KogakuGassanShikyuKetteiHoseiDetailParameter para = ViewStateHolder.get(
                ViewStateKeys.詳細データ, KogakuGassanShikyuKetteiHoseiDetailParameter.class);
        boolean flag = false;
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))
                || 照会.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC1230011TransitionEventName.対象者検索に戻る).respond();
        } else {
            flag = getHandler(div).is決定情報内容変更状態(para);
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).前排他キーの解除(被保険者番号);
                return ResponseData.of(div).forwardWithEventName(
                        DBC1230011TransitionEventName.対象者検索に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            getHandler(div).前排他キーの解除(被保険者番号);
            return ResponseData.of(div).forwardWithEventName(DBC1230011TransitionEventName.対象者検索に戻る).respond();
        }
    }

    /**
     * 「決定情報一覧に戻する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnSave(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (削除.equals(画面モード) || 照会.equals(画面モード)) {
            return save決定情報登録(div, 画面モード);
        }
        KogakuGassanShikyuKetteiHoseiDetailParameter para = ViewStateHolder.get(
                ViewStateKeys.詳細データ, KogakuGassanShikyuKetteiHoseiDetailParameter.class);
        boolean flag = getHandler(div).is決定情報内容変更状態(para);
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check決定情報保存();
        if (flag) {
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            } else {
                return save決定情報登録(div, 画面モード);
            }
        } else {
            return notChanges(div);
        }
    }

    private ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> save決定情報登録(
            KogakuGassanShikyuKetteiHoseiPanelDiv div, RString 画面モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        FlexibleYear 対象年度 = new FlexibleYear(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtTaishoNendo().getValue().getYear().toDateString());
        HokenshaNo 保険者番号 = new HokenshaNo(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtHihokenshaNo().getValue());
        RString 支給申請書整理番号 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyuSeiriNo().getValue();
        if (!削除.equals(画面モード)) {
            try {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                            UrQuestionMessages.保存の確認.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    List<KogakuGassanShikyuKetteiHoseiResult> 決定情報list
                            = ViewStateHolder.get(ViewStateKeys.支給決定情報補正, List.class);
                    AccessLogger.log(AccessLogType.更新,
                            getHandler(div).toPersonalData(識別コード,
                                    被保険者番号.getColumnValue()));
                    getHandler(div).save決定情報(被保険者番号, 対象年度, 保険者番号,
                            支給申請書整理番号, 画面モード, 決定情報list);
                    getHandler(div).前排他キーの解除(被保険者番号);
                    getHandler(div).clear決定情報();
                    getHandler(div).set画面tap();
                    return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
                } else {
                    return ResponseData.of(div).respond();
                }
            } catch (Exception e) {
                throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
            }
        } else if (削除.equals(画面モード)) {
            try {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                            UrQuestionMessages.削除の確認.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    List<KogakuGassanShikyuKetteiHoseiResult> 決定情報list
                            = ViewStateHolder.get(ViewStateKeys.支給決定情報補正, List.class);
                    AccessLogger.log(AccessLogType.更新,
                            getHandler(div).toPersonalData(識別コード,
                                    被保険者番号.getColumnValue()));
                    getHandler(div).save決定情報(被保険者番号, 対象年度, 保険者番号,
                            支給申請書整理番号, 画面モード, 決定情報list);
                    getHandler(div).clear決定情報();
                    getHandler(div).set画面tap();
                    return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
                } else {
                    return ResponseData.of(div).respond();
                }
            } catch (Exception e) {
                throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> notChanges(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KogakuGassanShikyuKetteiHoseiPanelHandler getHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        return new KogakuGassanShikyuKetteiHoseiPanelHandler(div);
    }

    private KogakuGassanShikyuKetteiHoseiPanelValidationHandler getCheckHandler(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        return new KogakuGassanShikyuKetteiHoseiPanelValidationHandler(div);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0440011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011.DBC0440011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011.DBC0440011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011.KogakuSabisuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0440011.KogakuSabisuhiShikyuShinseiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0440011.KogakuSabisuhiShikyuShinseiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0440011.KogakuServicehiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTouroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
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
 * 画面設計_DBCMN42001_高額サービス費支給申請登録
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class KogakuSabisuhiShikyuShinseiPanel {

    private static final RString 被保険者番号なし = new RString("被保険者番号なし");
    private static final RString 追加モード = new RString("追加モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 送付済モード = new RString("送付済モード");
    private static final RString 明細編集モード = new RString("明細編集モード");
    private static final RString 定値_交換情報識別番号1 = new RString("111");
    private static final RString 定値_交換情報識別番号2 = new RString("113");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    /**
     * 申請情報検索_画面初期化です。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanel
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onLoad(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000014");
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        RString メニューID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.メニューID, メニューID);
        //TODO  QA988
        RString 導入形態コード = new RString("111");
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            throw new ApplicationException(
                    DbzErrorMessages.理由付き登録不可.getMessage().replace(被保険者番号なし.toString()));
        }
        if (!getHandler(div).is前排他キーのセット(被保険者番号)) {
            throw new PessimisticLockingException();
        }
        div.getCommonPanel().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        if (識別コード != null && !識別コード.isEmpty()) {
            div.getCommonPanel().getCcdKaigoAtenaInfo().initialize(識別コード);
        }
        getHandler(div).initialize申請情報検索(メニューID, 被保険者番号, 導入形態コード);
        return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
    }

    /**
     * 申請情報タブ、口座情報タブ、判定結果情報タブの初期化の初期化「追加モード」です。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnShinseiJohoTsuika(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        HokenshaNo 証記載保険者番号 = new HokenshaNo(ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class));
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        getHandler(div).initialize高額詳細内容(追加モード, メニューID,
                被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
        ViewStateHolder.put(ViewStateKeys.画面モード, 追加モード);
        KogakuServicehiDetailParameter 画面データ = getHandler(div).set申請情報登録画面データ();
        ViewStateHolder.put(ViewStateKeys.詳細データ, 画面データ);
        boolean 審査決定フラグ = div.getCcdKogakuShinseiList().is審査決定フラグ();
        boolean 支給区分フラグ = div.getCcdKogakuShinseiList().is支給区分フラグ();
        ViewStateHolder.put(ViewStateKeys.審査決定フラグ, 審査決定フラグ);
        ViewStateHolder.put(ViewStateKeys.支給区分フラグ, 支給区分フラグ);
        return ResponseData.of(div).setState(DBC0440011StateName.申請情報登録);
    }

    /**
     * 申請情報タブ、口座情報タブ、判定結果情報タブの初期化の初期化「修正モード」です。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_modify(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        HokenshaNo 証記載保険者番号 = new HokenshaNo(ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class));
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        boolean 審査決定フラグ = div.getCcdKogakuShinseiList().is審査決定フラグ();
        boolean 支給区分フラグ = div.getCcdKogakuShinseiList().is支給区分フラグ();
        boolean 決定情報フラグ = div.getCcdKogakuShinseiList().is決定情報フラグ();
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        if (TWO.equals(受託区分)) {
            if (審査決定フラグ) {
                getHandler(div).initialize高額詳細内容(送付済モード, メニューID,
                        被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
                ViewStateHolder.put(ViewStateKeys.画面モード, 送付済モード);
            }
            if (支給区分フラグ) {
                RString 画面モード = get支給区分场合のモード(被保険者番号, サービス年月, 証記載保険者番号);
                ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
                getHandler(div).initialize高額詳細内容(画面モード, メニューID,
                        被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
            }
            if (決定情報フラグ) {
                getHandler(div).initialize高額詳細内容(修正モード, メニューID,
                        被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
            }
        } else if (ONE.equals(受託区分)) {
            getHandler(div).initialize高額詳細内容(修正モード, メニューID,
                    被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
            ViewStateHolder.put(ViewStateKeys.画面モード, 修正モード);
        }
        KogakuServicehiDetailParameter 画面データ = getHandler(div).set申請情報登録画面データ();
        ViewStateHolder.put(ViewStateKeys.詳細データ, 画面データ);
        ViewStateHolder.put(ViewStateKeys.審査決定フラグ, 審査決定フラグ);
        ViewStateHolder.put(ViewStateKeys.支給区分フラグ, 支給区分フラグ);
        KougakuSabisuhiShousaiNaiyouResult result
                = div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get画面初期化データ();
        ViewStateHolder.put(ViewStateKeys.一覧データ, result);
        return ResponseData.of(div).setState(DBC0440011StateName.申請情報登録);
    }

    /**
     * 申請情報タブ、口座情報タブ、判定結果情報タブの初期化の初期化「削除モード」です。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_delete(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        HokenshaNo 証記載保険者番号 = new HokenshaNo(ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class));
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        getHandler(div).initialize高額詳細内容(削除モード, メニューID,
                被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
        ViewStateHolder.put(ViewStateKeys.画面モード, 削除モード);
        boolean 審査決定フラグ = div.getCcdKogakuShinseiList().is審査決定フラグ();
        boolean 支給区分フラグ = div.getCcdKogakuShinseiList().is支給区分フラグ();
        KogakuServicehiDetailParameter 画面データ = getHandler(div).set申請情報登録画面データ();
        ViewStateHolder.put(ViewStateKeys.詳細データ, 画面データ);
        ViewStateHolder.put(ViewStateKeys.審査決定フラグ, 審査決定フラグ);
        ViewStateHolder.put(ViewStateKeys.支給区分フラグ, 支給区分フラグ);
        KougakuSabisuhiShousaiNaiyouResult result
                = div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get画面初期化データ();
        ViewStateHolder.put(ViewStateKeys.一覧データ, result);
        return ResponseData.of(div).setState(DBC0440011StateName.申請情報登録);
    }

    /**
     * 「対象者情報を追加する」ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnTaishosyaJoho(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        getHandler(div).initialize高額介護サービス給付対象明細(
                メニューID, 明細編集モード, 被保険者番号, サービス年月, 1);
        ViewStateHolder.put(ViewStateKeys.画面モード, 明細編集モード);
        return ResponseData.of(div).setState(DBC0440011StateName.対象者情報登録);
    }

    private RString get支給区分场合のモード(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号) {
        KyufujissekiKogakuKaigoServicehi 給付実績entity = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                dealKyufujissekiDataShutoku(被保険者番号, サービス年月, 証記載保険者番号);
        RString 画面モード;
        if (null == 給付実績entity) {
            画面モード = 送付済モード;
        } else {
            if ((給付実績entity.get給付実績情報作成区分コード().equals(ONE)
                    || 給付実績entity.get給付実績情報作成区分コード().equals(TWO))
                    || (給付実績entity.get交換情報識別番号().value().startsWith(定値_交換情報識別番号1))
                    || (給付実績entity.get交換情報識別番号().value().startsWith(定値_交換情報識別番号2))) {
                画面モード = 修正モード;
            } else {
                画面モード = 送付済モード;
            }
        }
        return 画面モード;
    }

    /**
     * 申請情報「保存する」ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnUpdate(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        boolean 審査決定フラグ = ViewStateHolder.get(ViewStateKeys.審査決定フラグ, Boolean.class);
        ValidationMessageControlPairs validPairs = getCheckHandler(div).get入力チェック(画面モード, 審査決定フラグ);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (削除モード.equals(画面モード)) {
            return save申請情報登録(div, 画面モード);
        }
        KogakuServicehiDetailParameter para = ViewStateHolder.get(
                ViewStateKeys.詳細データ, KogakuServicehiDetailParameter.class);
        boolean flag = getHandler(div).is申請情報登録内容変更状態(para);
        if (flag) {
            return save申請情報登録(div, 画面モード);
        } else {
            return notChanges(div);
        }
    }

    /**
     * 対象者情報「保存する」ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnUpd(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        boolean flag = getHandler(div).is対象者情報登録内容変更状態();
        if (flag) {
            RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
            return save対象者情報(div, 画面モード);
        } else {
            return notChanges(div);
        }
    }

    private ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> save対象者情報(
            KogakuSabisuhiShikyuShinseiPanelDiv div, RString 画面モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        if (!削除モード.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                List<KogakuKyuufuTaishouListEntityResult> 高額給付対象一覧list
                        = ViewStateHolder.get(ViewStateKeys.高額給付対象一覧, List.class);
                getHandler(div).save対象者情報(被保険者番号, サービス年月, メニューID, 高額給付対象一覧list);
                getHandler(div).clear対象者情報();
                return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
            } else {
                return ResponseData.of(div).respond();
            }
        } else if (削除モード.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                List<KogakuKyuufuTaishouListEntityResult> 高額給付対象一覧list
                        = ViewStateHolder.get(ViewStateKeys.高額給付対象一覧, List.class);
                getHandler(div).save対象者情報(被保険者番号, サービス年月, メニューID, 高額給付対象一覧list);
                getHandler(div).clear対象者情報();
                return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> save申請情報登録(
            KogakuSabisuhiShikyuShinseiPanelDiv div, RString 画面モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        HokenshaNo 証記載保険者番号 = new HokenshaNo(ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class));
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        KougakuSabisuhiShousaiNaiyouResult result = ViewStateHolder.get(ViewStateKeys.一覧データ,
                KougakuSabisuhiShousaiNaiyouResult.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        if (!削除モード.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).save申請情報(被保険者番号, サービス年月,
                        証記載保険者番号, メニューID, 画面モード, 履歴番号, result);
                getHandler(div).clear申請情報();
                return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
            } else {
                return ResponseData.of(div).respond();
            }
        } else if (削除モード.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).save申請情報(被保険者番号, サービス年月,
                        証記載保険者番号, メニューID, 画面モード, 履歴番号, result);
                getHandler(div).clear申請情報();
                return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 該当者一覧画面に戻るです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnSerchResult(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0440011TransitionEventName.検索に戻る).respond();
    }

    /**
     * 「取消する」ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnFree(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        boolean flag = false;
        KogakuServicehiDetailParameter para = ViewStateHolder.get(
                ViewStateKeys.詳細データ, KogakuServicehiDetailParameter.class);
        if (削除モード.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            getHandler(div).clear申請情報();
            div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().release削除制御();
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        } else {
            flag = getHandler(div).is申請情報登録内容変更状態(para);
        }
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).clear申請情報();
                release送付済制御(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class), div);
                return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            getHandler(div).clear申請情報();
            release送付済制御(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class), div);
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        }
    }

    private void release送付済制御(RString 画面モード, KogakuSabisuhiShikyuShinseiPanelDiv div) {
        if (送付済モード.equals(画面モード)) {
            div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().release削除制御();
        }
    }

    /**
     * 「支給申請登録に戻る」ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnTorikeshi(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        boolean flag = false;
        if (削除モード.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            getHandler(div).clear対象者情報();
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        } else {
            flag = getHandler(div).is対象者情報登録内容変更状態();
        }
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).clear対象者情報();
                return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
            } else {
                getHandler(div).clear対象者情報();
                return ResponseData.of(div).respond();
            }
        } else {
            getHandler(div).clear対象者情報();
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        }
    }

    private ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> notChanges(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KogakuSabisuhiShikyuShinseiPanelHandler getHandler(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        return new KogakuSabisuhiShikyuShinseiPanelHandler(div);
    }

    private KogakuSabisuhiShikyuShinseiPanelValidationHandler
            getCheckHandler(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        return new KogakuSabisuhiShikyuShinseiPanelValidationHandler(div);
    }
}

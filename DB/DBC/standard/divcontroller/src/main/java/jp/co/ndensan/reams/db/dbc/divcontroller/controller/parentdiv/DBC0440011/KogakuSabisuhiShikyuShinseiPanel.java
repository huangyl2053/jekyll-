/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0440011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.JigyouKogakuKyuufuTaishouResult;
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
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
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
    private static final RString 高額サービス費支給申請書登録 = new RString("DBCMN42001");
    private static final RString 総合事業高額サービス費支給申請書登録 = new RString("DBCMNL2001");
    private static final RString 総合事業高額サービス費支給申請登録 = new RString("総合事業高額サービス費支給申請書登録");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 支給指定時は支給金額を入力してください = new RString("支給指定時は支給金額を入力してください。");

    /**
     * 申請情報検索_画面初期化です。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanel
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onLoad(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        RString メニューID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.メニューID, メニューID);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
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
        HokenshaNo 証記載保険者番号 = new HokenshaNo(div.getCcdKogakuShinseiList().getClickedRow().getData12());
        FlexibleYearMonth サービス年月 = new FlexibleDate(
                new RDate(div.getCcdKogakuShinseiList().getClickedRow().getData1().toString()).toString()).getYearMonth();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        boolean 審査決定フラグ = div.getCcdKogakuShinseiList().is審査決定フラグ();
        boolean 支給区分フラグ = div.getCcdKogakuShinseiList().is支給区分フラグ();
        boolean 決定情報フラグ = div.getCcdKogakuShinseiList().is決定情報フラグ();
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (総合事業高額サービス費支給申請書登録.equals(メニューID)) {
            受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        }
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        if (TWO.equals(受託区分)) {
            if (審査決定フラグ) {
                getHandler(div).initialize高額詳細内容(送付済モード, メニューID,
                        被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
                ViewStateHolder.put(ViewStateKeys.画面モード, 送付済モード);
            }
            if (支給区分フラグ) {
                RString 画面モード = get支給区分モード(被保険者番号, サービス年月, 証記載保険者番号);
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
        HokenshaNo 証記載保険者番号 = new HokenshaNo(div.getCcdKogakuShinseiList().getClickedRow().getData12());
        FlexibleYearMonth サービス年月 = new FlexibleDate(
                new RDate(div.getCcdKogakuShinseiList().getClickedRow().getData1().toString()).toString()).getYearMonth();
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

    private RString get支給区分モード(HihokenshaNo 被保険者番号,
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
        if (ONE.equals(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給区分())
                && Decimal.ZERO.equals(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額())) {
            throw new ApplicationException(支給指定時は支給金額を入力してください.toString());
        }
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

    /**
     * onStateTransition ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onStateTransition(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        div.getShinseiTorokuPanel().getSetaiJoho().setDisplayNone(true);
        RString メニューID = ResponseHolder.getMenuID();
        if (総合事業高額サービス費支給申請書登録.equals(メニューID)) {
            return ResponseData.of(div).rootTitle(総合事業高額サービス費支給申請登録).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> save対象者情報(
            KogakuSabisuhiShikyuShinseiPanelDiv div, RString 画面モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 氏名 = div.getCommonPanel().getCcdKaigoAtenaInfo().get氏名漢字();
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
                save対象者情報データ(div, 被保険者番号, サービス年月, メニューID);
                getHandler(div).clear対象者情報();
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        被保険者番号.getColumnValue(), 氏名, true);
                return ResponseData.of(div).setState(DBC0440011StateName.完了);
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
                save対象者情報データ(div, 被保険者番号, サービス年月, メニューID);
                getHandler(div).clear対象者情報();
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        被保険者番号.getColumnValue(), 氏名, true);
                return ResponseData.of(div).setState(DBC0440011StateName.完了);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private void save対象者情報データ(KogakuSabisuhiShikyuShinseiPanelDiv div,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString メニューID) {
        if (高額サービス費支給申請書登録.equals(メニューID)) {
            List<KogakuKyuufuTaishouListEntityResult> 高額給付対象一覧list
                    = ViewStateHolder.get(ViewStateKeys.高額給付対象一覧, List.class);
            getHandler(div).save対象者情報(被保険者番号, サービス年月, メニューID, 高額給付対象一覧list);
        } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)) {
            List<JigyouKogakuKyuufuTaishouResult> 事業高額給付対象一覧list
                    = ViewStateHolder.get(ViewStateKeys.事業高額給付対象一覧, List.class);
            getHandler(div).save事業高額対象者情報(被保険者番号, サービス年月, メニューID, 事業高額給付対象一覧list);
        }
    }

    private ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> save申請情報登録(
            KogakuSabisuhiShikyuShinseiPanelDiv div, RString 画面モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 氏名 = div.getCommonPanel().getCcdKaigoAtenaInfo().get氏名漢字();
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
                save申請情報データ(div, 被保険者番号, サービス年月, 証記載保険者番号, メニューID, 画面モード, 履歴番号, result);
                getHandler(div).clear申請情報();
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().set画面tap();
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        被保険者番号.getColumnValue(), 氏名, true);
                return ResponseData.of(div).setState(DBC0440011StateName.完了);
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
                save申請情報データ(div, 被保険者番号, サービス年月, 証記載保険者番号, メニューID, 画面モード, 履歴番号, result);
                getHandler(div).clear申請情報();
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().set画面tap();
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().release削除制御();
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        被保険者番号.getColumnValue(), 氏名, true);
                return ResponseData.of(div).setState(DBC0440011StateName.完了);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private void save申請情報データ(KogakuSabisuhiShikyuShinseiPanelDiv div,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号, RString メニューID, RString 画面モード,
            int 履歴番号, KougakuSabisuhiShousaiNaiyouResult result) {
        if (高額サービス費支給申請書登録.equals(メニューID)) {
            getHandler(div).save申請情報(被保険者番号, サービス年月,
                    証記載保険者番号, メニューID, 画面モード, 履歴番号, result);
        } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)) {
            getHandler(div).save事業高額申請情報(被保険者番号, サービス年月,
                    証記載保険者番号, メニューID, 画面モード, 履歴番号, result);
        }
    }

    /**
     * 該当者一覧画面に戻るです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnSerchResult(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).前排他キーの解除(被保険者番号);
        return ResponseData.of(div).forwardWithEventName(DBC0440011TransitionEventName.検索に戻る).respond();
    }

    /**
     * 再検索画面に戻るです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnReSearch(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).前排他キーの解除(被保険者番号);
        return ResponseData.of(div).forwardWithEventName(DBC0440011TransitionEventName.再検索).respond();
    }

    /**
     * 「世帯情報を表示する」ボタン
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnSetaiJohoHyoji(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().setDisplayNone(true);
        div.getShinseiTorokuPanel().getSetaiJoho().setDisplayNone(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(申請を保存する, true);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).initialize世帯所得一覧(識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「高額明細を表示する」ボタン
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnKogakuMeisaiHyoji(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        div.getShinseiTorokuPanel().getSetaiJoho().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(申請を保存する, false);
        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().setDisplayNone(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消する」ボタンです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnFree(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        if (削除モード.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            getHandler(div).clear申請情報();
            div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().release削除制御();
            div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().set画面tap();
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        }
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
            div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().set画面tap();
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「完了」ボタン押下時のメソッドです。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnComplete(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).前排他キーの解除(被保険者番号);
        return ResponseData.of(div).forwardWithEventName(DBC0440011TransitionEventName.完了).respond();
    }

    /**
     * 「処理を継続する」ボタンクリック時の事件です。
     *
     * @param div KogakuSabisuhiShikyuShinseiPanelDiv
     * @return ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<KogakuSabisuhiShikyuShinseiPanelDiv> onClick_btnContinue(
            KogakuSabisuhiShikyuShinseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        getHandler(div).initialize申請情報検索(メニューID, 被保険者番号, 導入形態コード);
        return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);

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
        if (削除モード.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            getHandler(div).clear対象者情報();
            return ResponseData.of(div).setState(DBC0440011StateName.申請情報検索);
        }
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

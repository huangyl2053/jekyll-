/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.DBD1040001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.DBD1040001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenService;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 画面設計_DBDGM21005_1_特別地域加算減免申請のDivControllerです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokuteiNyushoServiceHiShinsei {

    private final RString 申請メニュー = new RString("DBDMN21005");
    private final RString 承認メニュー = new RString("DBDMN22005");
    //private final RString 申請メニュー = new RString("menu1");
    //private final RString 承認メニュー = new RString("menu1");
    private final RString 保存する = new RString("btnUpdate");
    private final RString 追加 = new RString("追加");
    private final RString 申請メニュー_タイトル = new RString("特別地域加算減免申請");
    private final RString 承認メニュー_タイトル = new RString("特別地域加算減免申請承認");
    private static final RString 承認する_KEY = new RString("1");
    private static final RString 承認しない_KEY = new RString("0");

    /**
     * 画面初期化
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return ResponseData<TokuteiNyushoServiceHiShinseiDiv>
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onLoad(TokuteiNyushoServiceHiShinseiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        getHandler(div).initialize(資格対象者);
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        if (!ResponseHolder.isReRequest()
                && (被保険者番号 == null || 被保険者番号.getColumnValue().isEmpty())) {
            div.getShinsei().getBtnDispGemmenJoho().setDisabled(true);
            div.getShinsei().getShinseiList().getBtnAddShinsei().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            div.getShinsei().getShinseiList().getDgShinseiList().setDisabled(true);
            InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List = TokubetsuChiikiKasanGemmenService.createIntance()
                .get特別地域加算減免申請の情報(被保険者番号);
        if (特別地域加算減免申請の情報List != null) {
            ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請の情報List, new ArrayList<>(特別地域加算減免申請の情報List));
            ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList = new ArrayList<>();
            getHandler(div).申請一覧エリアの初期設定(特別地域加算減免申請の情報List, viewStateList);
            ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, viewStateList);
        }
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.照会, personalData);
        getHandler(div).前排他の設定(被保険者番号);
        ViewStateHolder.put(ViewStateKeys.新規履歴番号, 0);
        RString rootTitle;
        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            rootTitle = 申請メニュー_タイトル;
        } else {
            rootTitle = 承認メニュー_タイトル;
        }
        ResponseData<TokuteiNyushoServiceHiShinseiDiv> responseData = ResponseData.of(div).setState(DBD1040001StateName.一覧);
        responseData.setRootTitle(rootTitle);
        return responseData;
    }

    /**
     * 「世帯情報を表示する」の押した(onClick)イベントを行う。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onBeforeOpenDialog_btnDispSetaiJoho(TokuteiNyushoServiceHiShinseiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        YMDHMS 現在年月日日時時分秒 = YMDHMS.now();
        if (資格対象者 != null) {
            ShikibetsuCode 識別コード = 資格対象者.get識別コード();
            div.getShinsei().setTxtShikibetsuCode(識別コード.value());
        }
        div.getShinsei().setTxtShotokuKijunYMDHMS(現在年月日日時時分秒.toDateString());
        return ResponseData.of(div).respond();
    }

    /**
     * 「減免情報を表示する」の押した(onClick)イベントを行う。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onBeforeOpenDialog_btnDispGemmenJoho(TokuteiNyushoServiceHiShinseiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        if (資格対象者 != null) {
            HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
            if (被保険者番号 != null) {
                div.getShinsei().setHihokenshaNo(被保険者番号.value());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報/承認情報を追加する」の押した(onClick)イベントを行う。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnAddShinsei(TokuteiNyushoServiceHiShinseiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        getHandler(div).set追加するボタン押下(資格対象者);
        return ResponseData.of(div).setState(DBD1040001StateName.詳細);
    }

    /**
     * 「申請一覧の修正ボタンをクリック」の押した(onClick)イベントを行う。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnModify(TokuteiNyushoServiceHiShinseiDiv div) {
        dgShinseiList_Row row = div.getShinsei().getShinseiList().getDgShinseiList().getActiveRow();
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請の情報List, ArrayList.class);
        TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報 = getHandler(div).get特別地域加算減免申請の情報(row, 特別地域加算減免申請の情報List);
        if (特別地域加算減免申請の情報 != null) {
            ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請の情報, 特別地域加算減免申請の情報);
        }
        List<TokubetsuChiikiKasanGemmenViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請情報ListのViewState, ArrayList.class);
        TokubetsuChiikiKasanGemmenViewState 特別地域加算減免ViewState = getHandler(div).get該当申請のViewState(row, viewStateList);
        if (特別地域加算減免ViewState != null) {
            ViewStateHolder.put(ViewStateKeys.特別地域加算減免ViewState, 特別地域加算減免ViewState);
        }
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        getHandler(div).set申請一覧の修正ボタンをクリック(row, 資格対象者, 特別地域加算減免ViewState);
        return ResponseData.of(div).setState(DBD1040001StateName.詳細);
    }

    /**
     * 申請一覧の削除ボタン押下時の処理です。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnDelete(TokuteiNyushoServiceHiShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            dgShinseiList_Row row = div.getShinsei().getShinseiList().getDgShinseiList().getActiveRow();
            List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請の情報List, ArrayList.class);
            RString 元決定区分 = RString.EMPTY;
            TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報 = getHandler(div).get特別地域加算減免申請の情報(row, 特別地域加算減免申請の情報List);
            if (特別地域加算減免申請の情報 != null && 特別地域加算減免申請の情報.get決定区分() != null) {
                元決定区分 = 特別地域加算減免申請の情報.get決定区分();
            }
            if (!ResponseHolder.isReRequest() && !追加.equals(row.getJotai()) && !元決定区分.isEmpty()) {
                InformationMessage message = new InformationMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().getCode(),
                        DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (new RString(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())) {
                return ResponseData.of(div).respond();
            }
            ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請情報ListのViewState, ArrayList.class);
            ArrayList<TokubetsuChiikiKasanGemmenViewState> newViewStatesList = new ArrayList<>();
            getHandler(div).set申請一覧の削除ボタンをクリック(row, viewStateList, newViewStatesList);
            if (追加.equals(row.getJotai())) {
                ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, viewStateList);
            } else {
                ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, newViewStatesList);
            }
            return ResponseData.of(div).setState(DBD1040001StateName.一覧);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「決定区分」ボタン押下時の処理です。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onChange_radKetteiKubun(TokuteiNyushoServiceHiShinseiDiv div) {
        getHandler(div).onClick_radKetteiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onBeforeOpenDialog_btnHiShoninRiyu(TokuteiNyushoServiceHiShinseiDiv div) {
        div.getShinsei().setSubGyomuCode(SubGyomuCode.DBD介護受給.value());
        div.getShinsei().setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された承認しない理由を本画面にセットします。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onOkClose_btnHiShoninRiyu(TokuteiNyushoServiceHiShinseiDiv div) {
        div.getShinseiDetail().getTxtHiShoninRiyu().setValue(div.getShinsei().getSubBunsho());
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請一覧に戻る」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnBackToShinseiList(TokuteiNyushoServiceHiShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//            TaishoshaKey 資格対象者 = new TaishoshaKey(
//                    new HihokenshaNo(new RString("2190000001")),
//                    new ShikibetsuCode(new RString("000000000000010")),
//                    new SetaiCode(new RString("000000000000100")));
            getHandler(div).set申請一覧に戻る(資格対象者);
            return ResponseData.of(div).setState(DBD1040001StateName.一覧);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「申請情報を確定する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnDetermineShinsei(TokuteiNyushoServiceHiShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            set申請情報を確定す処理(div);
            return ResponseData.of(div).setState(DBD1040001StateName.一覧);
        }
        return ResponseData.of(div).respond();
    }

    private void set申請情報を確定す処理(TokuteiNyushoServiceHiShinseiDiv div) {
        ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請情報ListのViewState, ArrayList.class);
        if (viewStateList == null) {
            viewStateList = new ArrayList<>();
        }
        TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報 = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請の情報, TokubetsuchiikiKasanGemmen.class);
        TokubetsuChiikiKasanGemmenViewState 特別地域加算減免ViewState = ViewStateHolder.get(
                ViewStateKeys.特別地域加算減免ViewState, TokubetsuChiikiKasanGemmenViewState.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShoKisaiHokenshaNo 証記載保険者番号;
        int 履歴番号;
        EntityDataState state;
        GemmenGengakuShinsei gemmenGengakuShinsei;
        TokubetsuchiikiKasanGemmenBuilder builder;
        if (特別地域加算減免申請の情報 != null) {
            証記載保険者番号 = 特別地域加算減免申請の情報.get証記載保険者番号();
            履歴番号 = 特別地域加算減免申請の情報.get履歴番号();
            boolean 変更あり = getHandler(div).申請情報_変更あり(特別地域加算減免申請の情報);
            if (変更あり) {
                state = EntityDataState.Modified;
            } else {
                state = EntityDataState.Unchanged;
            }
            if (特別地域加算減免申請の情報.getGemmenGengakuShinseiList().size() > 0) {
                gemmenGengakuShinsei = 特別地域加算減免申請の情報.getGemmenGengakuShinseiList().get(0);
            } else {
                ViewStateHolder.put(ViewStateKeys.新規履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード(), 履歴番号);
            }
            builder = 特別地域加算減免申請の情報.createBuilderForEdit();
        } else {
            state = EntityDataState.Added;
            証記載保険者番号 = getHandler(div).get証記載保険者番号(div.getShinseiDetail().getTxtShinseiYMD().getValue());

            if (特別地域加算減免ViewState != null) {
                履歴番号 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().get履歴番号();
                gemmenGengakuShinsei = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0);
                builder = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().createBuilderForEdit();
            } else {
                Integer 新規履歴番号 = ViewStateHolder.get(ViewStateKeys.新規履歴番号, Integer.class);
                履歴番号 = 新規履歴番号 - 1; //TODO
                ViewStateHolder.put(ViewStateKeys.新規履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード(), 履歴番号);
                builder = new TokubetsuchiikiKasanGemmen(証記載保険者番号, 被保険者番号, 履歴番号).createBuilderForEdit();
            }
        }
        ArrayList<TokubetsuChiikiKasanGemmenViewState> newViewStateList = new ArrayList<>();
        getHandler(div).申請情報を確定するボタン押下(viewStateList, newViewStateList,
                state, gemmenGengakuShinsei, builder, 証記載保険者番号, 履歴番号, 資格対象者);

        ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, newViewStateList);

    }

    /**
     * 「承認情報を確定する」ボタン押下時の処理です。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnConfirm(TokuteiNyushoServiceHiShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            RString selectKey = div.getShinseiDetail().getRadKettaiKubun().getSelectedKey();
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            if (承認する_KEY.equals(selectKey)) {
                getValidationHandler().validateFor特別地域加算減免_適用開始日が法施行以前(pairs, div);
                getValidationHandler().validateFor特別地域加算減免_適用終了日が年度外(pairs, div);
                getValidationHandler().validateFor特別地域加算減免_適用終了日が開始日以前(pairs, div);
                getValidationHandler().validateFor特別地域加算減免_減免減額_確認番号が重複(pairs, div);
                getValidationHandler().validateFor特別地域加算減免_軽減率範囲外(pairs, div);
                getValidationHandler().validateFor受給共通_受給者登録なし(pairs, div);
//                getValidationHandler().validateFor申請日の必須入力(pairs, div);
//                getValidationHandler().validateFor決定区分の必須入力(pairs, div);
//                getValidationHandler().validateFor決定日の必須入力(pairs, div);
//                getValidationHandler().validateFor適用日の必須入力(pairs, div);
//                getValidationHandler().validateFor有効期限の必須入力(pairs, div);
//                getValidationHandler().validateFor軽減率の必須入力(pairs, div);
            } else if (承認しない_KEY.equals(selectKey)) {
                getValidationHandler().validateFor特別地域加算減免_適用開始日が法施行以前(pairs, div);
                getValidationHandler().validateFor特別地域加算減免_適用終了日が年度外(pairs, div);
                getValidationHandler().validateFor特別地域加算減免_適用終了日が開始日以前(pairs, div);
                getValidationHandler().validateFor受給共通_受給者登録なし(pairs, div);
//                getValidationHandler().validateFor申請日の必須入力(pairs, div);
//                getValidationHandler().validateFor決定区分の必須入力(pairs, div);
//                getValidationHandler().validateFor決定日の必須入力(pairs, div);
//                getValidationHandler().validateFor適用日の必須入力(pairs, div);
//                getValidationHandler().validateFor有効期限の必須入力(pairs, div);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            set承認情報を確定する処理(div);
            return ResponseData.of(div).setState(DBD1040001StateName.一覧);
        }
        return ResponseData.of(div).respond();
    }

    private void set承認情報を確定する処理(TokuteiNyushoServiceHiShinseiDiv div) {
        ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請情報ListのViewState, ArrayList.class);
        if (viewStateList == null) {
            viewStateList = new ArrayList<>();
        }
        TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報 = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請の情報, TokubetsuchiikiKasanGemmen.class);
        TokubetsuChiikiKasanGemmenViewState 特別地域加算減免ViewState = ViewStateHolder.get(
                ViewStateKeys.特別地域加算減免ViewState, TokubetsuChiikiKasanGemmenViewState.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShoKisaiHokenshaNo 証記載保険者番号;
        int 履歴番号;
        EntityDataState state;
        GemmenGengakuShinsei gemmenGengakuShinsei;
        TokubetsuchiikiKasanGemmenBuilder builder;
        if (特別地域加算減免申請の情報 != null) {
            証記載保険者番号 = 特別地域加算減免申請の情報.get証記載保険者番号();
            履歴番号 = 特別地域加算減免申請の情報.get履歴番号();
            boolean 変更あり = getHandler(div).申請情報_変更あり(特別地域加算減免申請の情報);
            if (変更あり) {
                state = EntityDataState.Modified;
            } else {
                state = EntityDataState.Unchanged;
            }
            if (特別地域加算減免申請の情報.getGemmenGengakuShinseiList().size() > 0) {
                gemmenGengakuShinsei = 特別地域加算減免申請の情報.getGemmenGengakuShinseiList().get(0);
            } else {
                ViewStateHolder.put(ViewStateKeys.新規履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード(), 履歴番号);
            }
            builder = 特別地域加算減免申請の情報.createBuilderForEdit();
        } else {
            state = EntityDataState.Added;
            証記載保険者番号 = getHandler(div).get証記載保険者番号(div.getShinseiDetail().getTxtShinseiYMD().getValue());

            if (特別地域加算減免ViewState != null) {
                履歴番号 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().get履歴番号();
                gemmenGengakuShinsei = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0);
                builder = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().createBuilderForEdit();
            } else {
                Integer 新規履歴番号 = ViewStateHolder.get(ViewStateKeys.新規履歴番号, Integer.class);
                履歴番号 = 新規履歴番号 - 1; //TODO
                ViewStateHolder.put(ViewStateKeys.新規履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード(), 履歴番号);
                builder = new TokubetsuchiikiKasanGemmen(証記載保険者番号, 被保険者番号, 履歴番号).createBuilderForEdit();
            }
        }
        ArrayList<TokubetsuChiikiKasanGemmenViewState> newViewStateList = new ArrayList<>();
        getHandler(div).承認情報を確定するボタン押下(viewStateList, newViewStateList,
                state, gemmenGengakuShinsei, builder, 証記載保険者番号, 履歴番号, 資格対象者);

        ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, newViewStateList);

    }

    /**
     * 「再検索する」ボタン押下時の処理です。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnReSearch(TokuteiNyushoServiceHiShinseiDiv div) {

        viewState破棄(div);
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD1040001TransitionEventName.検索処理へ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン押下時の処理です。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnToSearchResult(TokuteiNyushoServiceHiShinseiDiv div) {
        viewState破棄(div);
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD1040001TransitionEventName.検索結果一覧へ).respond();
    }

    /**
     * 「申請情報を保存する/承認情報を保存する」ボタン押下時の処理です。
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onClick_btnUpdate(TokuteiNyushoServiceHiShinseiDiv div) {
        if (ResponseHolder.isReRequest() && new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList = ViewStateHolder.get(
                ViewStateKeys.特別地域加算減免申請情報ListのViewState, ArrayList.class);
        boolean 変更あり = getHandler(div).申請一覧_変更あり(viewStateList);
        if (!変更あり) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor適用期間重複なし(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//            TaishoshaKey 資格対象者 = new TaishoshaKey(
//                    new HihokenshaNo(new RString("2190000001")),
//                    new ShikibetsuCode(new RString("000000000000010")),
//                    new SetaiCode(new RString("000000000000100")));
            PersonalData personalData = getHandler(div).toPersonalData(taishoshaKey);
            AccessLogger.log(AccessLogType.更新, personalData);

            保存処理();
            前排他キーの解除();
            div.getLin1().setDisplayNone(true);
            div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        } else if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).setState(DBD1040001StateName.完了);
    }

    /**
     * 「適用日」のonBlur処理に、有効期限を編集します。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onBlur_txtTekiyoYmd(TokuteiNyushoServiceHiShinseiDiv div) {
        getHandler(div).get有効期限By適用日();
        return ResponseData.of(div).respond();
    }

    private void viewState破棄(TokuteiNyushoServiceHiShinseiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, null);
        ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請の情報List, null);
        getHandler(div).入力情報をクリア(taishoshaKey);
    }

    private void 前排他キーの解除() {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        TaishoshaKey 資格対象者 = new TaishoshaKey(
//                new HihokenshaNo(new RString("2190000001")),
//                new ShikibetsuCode(new RString("000000000000010")),
//                new SetaiCode(new RString("000000000000100")));
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("TokuchiGemmen")));
        RealInitialLocker.release(排他キー);
    }

    private void 保存処理() {

        List<TokubetsuChiikiKasanGemmenViewState> orderViewStateList = new ArrayList<>();
        List<TokubetsuChiikiKasanGemmenViewState> 削除List = new ArrayList<>();
        履歴番号の修正(orderViewStateList, 削除List);

        List<TokubetsuChiikiKasanGemmenViewState> 追加List = new ArrayList<>();
        List<TokubetsuChiikiKasanGemmenViewState> 修正List = new ArrayList<>();
        List<TokubetsuChiikiKasanGemmenViewState> 履歴修正ありList = new ArrayList<>();
        for (TokubetsuChiikiKasanGemmenViewState viewState : orderViewStateList) {
            if (EntityDataState.Added == viewState.getState()) {
                追加List.add(viewState);
            } else if (EntityDataState.Modified == viewState.getState()
                    && viewState.getShorigoRirekiNo() == viewState.getTokubetsuchiikiKasanGemmen().get履歴番号()) {
                修正List.add(viewState);
            } else if (viewState.getShorigoRirekiNo() != viewState.getTokubetsuchiikiKasanGemmen().get履歴番号()) {
                履歴修正ありList.add(viewState);
            }
        }

        TokubetsuChiikiKasanGemmenService service = TokubetsuChiikiKasanGemmenService.createIntance();
        service.保存処理(削除List, 追加List, 修正List, 履歴修正ありList);
    }

    private void 履歴番号の修正(List<TokubetsuChiikiKasanGemmenViewState> orderViewStateList, List<TokubetsuChiikiKasanGemmenViewState> 削除List) {

        ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList
                = ViewStateHolder.get(ViewStateKeys.特別地域加算減免申請情報ListのViewState, ArrayList.class);
        //Collections.sort(viewStateList, new RiyoshaFutangakuGengakuComparator());

        int size = viewStateList.size();
        int minRirekiNo = Integer.MAX_VALUE;

        List<TokubetsuChiikiKasanGemmenViewState> not削除List = new ArrayList<>();
        TokubetsuChiikiKasanGemmenViewState joho;
        EntityDataState 状態;
        EntityDataState 始まり承認データ状態 = EntityDataState.Unchanged;
        for (int i = 0; i < size; i++) {
            joho = viewStateList.get(i);
            状態 = joho.getState();
            if (minRirekiNo > joho.getShorigoRirekiNo() && joho.getShorigoRirekiNo() >= 0) {
                minRirekiNo = joho.getShorigoRirekiNo();
                始まり承認データ状態 = 状態;
            }
            if (EntityDataState.Deleted == 状態) {
                削除List.add(joho);
            } else {
                not削除List.add(joho);
            }
        }
        if (minRirekiNo == Integer.MAX_VALUE && ResponseHolder.getMenuID().equals(承認メニュー)) {
            minRirekiNo = 1;
        } else if (minRirekiNo == Integer.MAX_VALUE) {
            minRirekiNo = 0;
        }
        if (ResponseHolder.getMenuID().equals(承認メニュー)
                && EntityDataState.Modified == 始まり承認データ状態 && minRirekiNo == 0) {
            minRirekiNo = 1;
        }

        int tmpRirekiNo;
        TokubetsuChiikiKasanGemmenViewState joho１;
        TokubetsuChiikiKasanGemmenViewState joho２;
        size = not削除List.size();
        for (int i = 0; i < size; i++) {

            joho１ = not削除List.get(i);
            tmpRirekiNo = joho１.getShorigoRirekiNo();

            if (joho１.getShorigoRirekiNo() < minRirekiNo && i == 0) {
                tmpRirekiNo = minRirekiNo;
            } else if (joho１.getShorigoRirekiNo() < 0) {
                tmpRirekiNo = not削除List.get(i - 1).getShorigoRirekiNo() + 1;
            }
            joho１ = joho１.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();

            if (i < size - 1) {
                joho２ = not削除List.get(i + 1);
                if (joho２.getShorigoRirekiNo() <= joho１.getShorigoRirekiNo()) {
                    tmpRirekiNo = tmpRirekiNo + 1;
                    joho２ = joho２.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();
                    not削除List.set(i + 1, joho２);
                }
            }
            orderViewStateList.add(joho１);
        }
    }

    private TokuteiNyushoServiceHiShinseiHandler getHandler(TokuteiNyushoServiceHiShinseiDiv div) {
        return new TokuteiNyushoServiceHiShinseiHandler(div);
    }

    private TokuteiNyushoServiceHiShinseiValidationHandler getValidationHandler() {
        return new TokuteiNyushoServiceHiShinseiValidationHandler();
    }
}

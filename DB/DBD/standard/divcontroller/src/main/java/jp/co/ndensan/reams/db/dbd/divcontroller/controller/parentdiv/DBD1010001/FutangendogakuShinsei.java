/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.DBD1010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.DBD1010001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001.FutangendogakuNinteiShinseiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001.NinteiShinseiValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 負担限度額認定申請画面のDivControllerです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public class FutangendogakuShinsei {

    private static final RString 配偶者の有無_無 = new RString("key1");
    private static final RString 申請メニューID = new RString("DBDMN21001");
    private static final RString 承認メニューID = new RString("DBDMN22001");
    private final RString 文字列_申請情報を表示する = new RString("申請情報を表示する");
    private final RString 文字列_承認情報を表示する = new RString("承認情報を表示する");

    /**
     * 画面初期化
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onLoad(FutangendogakuShinseiDiv div) {
        getHandler(div).onLoad();
        if (ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号() == null) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「減免情報を表示する」ボタンをクリック
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onBeforeOpenDialog_btnDispGemmenJoho(FutangendogakuShinseiDiv div) {
        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 「世帯情報を表示する」ボタンをクリック
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnDispSetaiJoho(FutangendogakuShinseiDiv div) {
        div.getBtnDispSetaiJoho().setDisplayNone(true);
        div.getBtnCloseSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisabled(false);
        if (DBD1010001StateName.一覧.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBD1010001StateName.世帯情報From一覧);
        } else if (DBD1010001StateName.詳細.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho()
                    .setText(申請メニューID.equals(ResponseHolder.getMenuID()) ? 文字列_申請情報を表示する : 文字列_承認情報を表示する);
            return ResponseData.of(div).setState(DBD1010001StateName.世帯情報From詳細);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 負担限度額認定申請画面を「申請一覧を表示する」を押下する。<br/>
     *
     * @param div {@link FutangendogakuShinseiDiv 負担限度額認定申請画面Div}
     * @return 負担限度額認定申請画面Divを持つResponseData
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnCloseSetaiJoho(FutangendogakuShinseiDiv div) {
        div.getBtnDispSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisplayNone(true);
        if (DBD1010001StateName.世帯情報From一覧.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBD1010001StateName.一覧);
        } else {
            return ResponseData.of(div).setState(DBD1010001StateName.詳細);
        }
    }

    /**
     * 「申請情報を追加する」ボタンを押下
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnAddShinsei(FutangendogakuShinseiDiv div) {
        getHandler(div).onClick_btnAddShinsei();
        return ResponseData.of(div).setState(DBD1010001StateName.詳細);
    }

    /**
     * 「申請一覧の修正」ボタンを押下
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onSelectByModifyButton(FutangendogakuShinseiDiv div) {
        getHandler(div).onSelectByModifyButton();
        return ResponseData.of(div).setState(DBD1010001StateName.詳細);
    }

    /**
     * 「申請一覧の削除」ボタンを押下
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onSelectByDeleteButton(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        if (new RString(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        if (!getHandler(div).onSelectByDeleteButton()) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage()).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「決定区分」ラジオボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_radKetteiKubun(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_radKetteiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onBeforeOpenDialog_btnHiShoninRiyu(FutangendogakuShinseiDiv div) {
        div.setSubGyomuCode(SubGyomuCode.DBD介護受給.getColumnValue());
        div.setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請一覧に戻る」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnBackToShinseiList(FutangendogakuShinseiDiv div) {
        return ResponseData.of(div).setState(DBD1010001StateName.一覧);
    }

    /**
     * 「申請情報を確定する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnShinseiKakutei(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).onClick_btnShinseiKakutei();
        return ResponseData.of(div).setState(DBD1010001StateName.一覧);
    }

    /**
     * 「承認情報を確定する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnShoninKakutei(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiShinseiValidationHandler validationHandler = getValidationHandler();
        pairs = validationHandler.負担限度額認定_適用開始日が法施行以前チェック(pairs, div);
        pairs = validationHandler.負担限度額認定_適用終了日が年度外チェック(pairs, div);
        pairs = validationHandler.負担限度額認定_適用終了日が開始日以前チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).onClick_btnShinseiKakutei();
        return ResponseData.of(div).setState(DBD1010001StateName.一覧);
    }

    /**
     * 「再検索する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnReSearch(FutangendogakuShinseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, null);
        ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, null);

        RealInitialLocker.release(new LockingKey(div.getLockKey()));
        return ResponseData.of(div).forwardWithEventName(DBD1010001TransitionEventName.検索処理へ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnToSearchResult(FutangendogakuShinseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, null);
        ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, null);
        getHandler(div).onClick_btnToSearchResult();
        RealInitialLocker.release(new LockingKey(div.getLockKey()));
        return ResponseData.of(div).forwardWithEventName(DBD1010001TransitionEventName.検索結果一覧へ).respond();
    }

    /**
     * 「申請情報を保存する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnUpdate(FutangendogakuShinseiDiv div) {
        if (承認メニューID.equals(ResponseHolder.getMenuID())) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            NinteiShinseiValidationHandler validationHandler = getValidationHandler();
            pairs = validationHandler.減免減額_適用期間重複チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        boolean is変更あり = false;
        List<dgShinseiList_Row> list = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : list) {
            if (!row.getJotai().isEmpty()) {
                is変更あり = true;
                break;
            }
        }
        if (!is変更あり) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).申請情報を保存する();
            div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBD1010001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 適用日入力の処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onBlur_txtTekiyoYMD(FutangendogakuShinseiDiv div) {
        div.getTxtYukoKigenYMD().setValue(FutangendogakuNinteiService.createInstance().estimate有効期限(div.getTxtTekiyoYMD().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 負担段階の編集
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_ddlRiyoshaFutanDankai(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_ddlRiyoshaFutanDankai();
        return ResponseData.of(div).respond();
    }

    /**
     * 「クリアする」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnHaigushaClear(FutangendogakuShinseiDiv div) {
        div.getTxtHaigushaShikibetsuCode().clearDomain();
        div.getTxtHaigushaShimeiKana().clearDomain();
        div.getTxtHaigushaShimei().clearDomain();
        div.getTxtHaigushaUmareYMD().clearValue();
        div.getTxtHaigushaRenrakusaki().clearDomain();
        div.getTxtHaigushaJusho1().clearDomain();
        div.getTxtHaigushaJusho2().clearDomain();
        div.getRadHaigushaUmu().setSelectedKey(配偶者の有無_無);
        return ResponseData.of(div).respond();
    }

    /**
     * 「情報を設定する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnHaigushaJohoSet(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return getHandler(div).onClick_btnHaigushaJohoSet();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「配偶者の有無」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_radHaigushaUmu(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_radHaigushaUmu();
        return ResponseData.of(div).respond();
    }

    private FutangendogakuNinteiShinseiHandler getHandler(FutangendogakuShinseiDiv div) {
        return new FutangendogakuNinteiShinseiHandler(div);
    }

    private NinteiShinseiValidationHandler getValidationHandler() {
        return new NinteiShinseiValidationHandler();
    }
}

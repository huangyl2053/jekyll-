/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.DBD8010003StateName.Default;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.DBD8010003StateName.complate;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.DBD8010003TransitionEventName.対象者検索条件へ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.DBD8010003TransitionEventName.対象者該当者一覧へ;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.HikazeiNenkinKenJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010003.HikazeiNenkinKenJohoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010003.HikazeiNenkinKenJohoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 非課税年金対象者情報登録画面のDivControllerです。
 *
 * @reamsid_L DBD-4930-010 wangjie2
 */
public class HikazeiNenkinKenJoho {

    private final RString 削除解除モード = new RString("削除解除");
    private final RString 新規モード = new RString("新規");
    private final RString 修正モード = new RString("修正モ");
    private final RString 保存する = new RString("btnUpdate");
    private final RString 検索結果一覧へ = new RString("btn_searchResult");
    private final RString 再検索する = new RString("btn_reSearch");

    /**
     * 画面初期化処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onLoad(HikazeiNenkinKenJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            ShikibetsuCode 識別コード = key.get識別コード();
            HihokenshaNo 被保険者番号 = key.get被保険者番号();
            if (getHandler(div).onLoad(識別コード, 被保険者番号)) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.調定年度が2016以前.getMessage()).respond();
            }
        }
        if (new RString(DbdInformationMessages.調定年度が2016以前.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            div.getDdlSex().setDisabled(true);
            div.getTbBirthday().setDisabled(true);
            div.getDdlYear().setDisabled(true);
            div.getBtnSearch().setDisabled(true);
            div.getBtnCreate().setDisabled(true);
            div.getBtnDisplay().setDisabled(true);
            div.getBtnDelete().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, true);
        }
        return ResponseData.of(div).setState(Default);
    }

    /**
     * 「検索」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_btnSearch(HikazeiNenkinKenJohoDiv div) {
        div.setHiddenHihokenshaNo(div.getCcdKaigoShikaku().get被保険者番号());
        div.setHiddenNendo(div.getDdlYear().getSelectedKey());
        //TODO 画面設計_HikazeiNenkinKensaku_非課税年金検索 未作成
        return ResponseData.of(div).respond();
    }

    /**
     * 「画面設計_HikazeiNenkinKensaku_非課税年金検索」を呼び出し、画面編集制御処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onOkClose(HikazeiNenkinKenJohoDiv div) {
        HousholdBusiness 非課税年金対象者情報
                = DataPassingConverter.deserialize(div.getHiddenLastInputHousehold(), HousholdBusiness.class);
        getHandler(div).画面編集制御処理(非課税年金対象者情報);
        ViewStateHolder.put(ViewStateKeys.非課税年金対象者一時テーブル, 非課税年金対象者情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「表示」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_btnDisplay(HikazeiNenkinKenJohoDiv div) {
        HikazeiNenkinKenJohoHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            HikazeiNenkinKenJohoValidationHandler validationHandler = getValidationHandler();
            validationHandler.年金保険者コードの未入力チェック(pairs, div);
            validationHandler.基礎年金番号の未入力チェック(pairs, div);
            validationHandler.年金コードの未入力チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            List<HousholdBusiness> 非課税年金対象情報List = handler.get非課税年金対象情報();
            if (非課税年金対象情報List.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdWarningMessages.既存データなし.getMessage()).respond();
            }
            handler.画面全項目活性制御初期化();
            HousholdBusiness 非課税年金対象情報 = 非課税年金対象情報List.get(0);
            if (div.getCcdKaigoShikaku().get被保険者番号().equals(非課税年金対象情報.get被保険者番号())) {
                return ResponseData.of(div).addMessage(DbdQuestionMessages.新規登録確認.getMessage()).respond();
            }
            if (非課税年金対象情報.get被保険者番号().isNullOrEmpty()) {
                handler.画面編集制御処理(非課税年金対象情報);
                ViewStateHolder.put(ViewStateKeys.非課税年金対象者一時テーブル, 非課税年金対象情報);
            } else {
                throw new ApplicationException(DbdErrorMessages.被保険者関連違い.getMessage()
                        .replace(非課税年金対象情報.get被保険者番号().toString()));
            }
        }
        if (new RString(DbdWarningMessages.既存データなし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            handler.新規編集画面制御処理();
        }
        if (new RString(DbdQuestionMessages.新規登録確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            handler.新規編集画面制御処理();
        }
        div.getTbYear().setDisabled(true);
        div.getTbNenkinHokenshaCode().setDisabled(true);
        div.getTbKisoNenkinNo().setDisabled(true);
        div.getTbNenkinCode().setDisabled(true);
        div.getBtnDisplay().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_commonButtonSearchResult(HikazeiNenkinKenJohoDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).前排他の解除(key.get被保険者番号());
        return ResponseData.of(div).forwardWithEventName(対象者該当者一覧へ).respond();
    }

    /**
     * 「再検索する」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_commonButtonReSearch(HikazeiNenkinKenJohoDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).前排他の解除(key.get被保険者番号());
        return ResponseData.of(div).forwardWithEventName(対象者検索条件へ).respond();
    }

    /**
     * 「保存する」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_btnUpdate(HikazeiNenkinKenJohoDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HikazeiNenkinKenJohoHandler handler = getHandler(div);
        HousholdBusiness 非課税年金対象者一時
                = ViewStateHolder.get(ViewStateKeys.非課税年金対象者一時テーブル, HousholdBusiness.class);

        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            HikazeiNenkinKenJohoValidationHandler validationHandler = getValidationHandler();

            validationHandler.現基礎年金番号の未入力チェック(pairs, div);
            validationHandler.月の未入力チェック(pairs, div);
            validationHandler.金額の未入力チェック(pairs, div);
            validationHandler.作成年月日の未入力チェック(pairs, div);
            validationHandler.対象年の未入力チェック(pairs, div);
            validationHandler.氏名カナの未入力チェック(pairs, div);
            validationHandler.性別の未入力チェック(pairs, div);
            validationHandler.生年月日の未入力チェック(pairs, div);
            validationHandler.氏名漢字の未入力チェック(pairs, div);
            validationHandler.住所漢字の未入力チェック(pairs, div);
            validationHandler.登録区分の未入力チェック(pairs, div);
            validationHandler.年金保険者コードの未入力チェック(pairs, div);
            validationHandler.基礎年金番号の未入力チェック(pairs, div);
            validationHandler.年金コードの未入力チェック(pairs, div);

            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (削除解除モード.equals(div.getHiddenModel())) {
                return ResponseData.of(div).addMessage(get削除解除Message(div)).respond();
            }
            if (!handler.画面項目と比較(非課税年金対象者一時)) {
                throw new ApplicationException(DbdErrorMessages.変更無し.getMessage());
            }
            int 重複チェック = handler.重複チェック();
            int pk変更 = handler.pk変更チェック(非課税年金対象者一時) ? 0 : 1;
            if (修正モード.equals(div.getHiddenModel())) {
                return ResponseData.of(div).addMessage(get修正モードMessage(div, 重複チェック, pk変更)).respond();
            }
            if (新規モード.equals(div.getHiddenModel())) {
                return ResponseData.of(div).addMessage(get新規モードMessage(div, 重複チェック)).respond();
            }
        }

        if (new RString(DbdQuestionMessages.被保険者関連解除確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            handler.削除解除_登録区分_取込_保存処理(非課税年金対象者一時);
            handler.前排他の解除(key.get被保険者番号());
            return ResponseData.of(div).setState(complate);
        }

        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            handler.削除解除_登録区分_画面登録_保存処理(非課税年金対象者一時);
            handler.前排他の解除(key.get被保険者番号());
            return ResponseData.of(div).setState(complate);
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            if (新規モード.equals(div.getHiddenModel())) {
                handler.新規_保存処理();
                handler.前排他の解除(key.get被保険者番号());
                return ResponseData.of(div).setState(complate);
            }
            if (TorokuKubun.取込.get名称().equals(div.getTbLoadCata().getValue())) {
                handler.修正_登録区分_取込_保存処理(非課税年金対象者一時);
                handler.前排他の解除(key.get被保険者番号());
                return ResponseData.of(div).setState(complate);
            } else {
                handler.修正_登録区分_画面登録_保存処理(非課税年金対象者一時);
                handler.前排他の解除(key.get被保険者番号());
                return ResponseData.of(div).setState(complate);
            }
        }

        return ResponseData.of(div).respond();

    }

    private Message get新規モードMessage(HikazeiNenkinKenJohoDiv div, int 重複チェック) {
        if (重複チェック >= 1) {
            throw new ApplicationException(DbdErrorMessages.データ重複チェック
                    .getMessage().replace(div.getTbTaishoNen().getValue().toString()));
        }
        return UrQuestionMessages.保存の確認.getMessage();
    }

    private Message get修正モードMessage(HikazeiNenkinKenJohoDiv div, int 重複チェック, int pk変更) {
        if (重複チェック - pk変更 >= 1) {
            throw new ApplicationException(DbdErrorMessages.データ重複チェック
                    .getMessage().replace(div.getTbTaishoNen().getValue().toString()));
        }
        return UrQuestionMessages.保存の確認.getMessage();
    }

    private Message get削除解除Message(HikazeiNenkinKenJohoDiv div) {
        if (TorokuKubun.取込.get名称().equals(div.getTbLoadCata().getValue())) {
            return DbdQuestionMessages.被保険者関連解除確認.getMessage();
        } else {
            return UrQuestionMessages.削除の確認.getMessage();
        }
    }

    /**
     * 「削除／解除」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_btnDelete(HikazeiNenkinKenJohoDiv div) {
        div.setHiddenModel(削除解除モード);
        div.getShoSaiPanel().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「新規」ボタンの処理です。
     *
     * @param div HikazeiNenkinKenJohoDiv
     * @return ResponseData<HikazeiNenkinKenJohoDiv>
     */
    public ResponseData<HikazeiNenkinKenJohoDiv> onClick_btnCreate(HikazeiNenkinKenJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (削除解除モード.equals(div.getHiddenModel())) {
                return ResponseData.of(div).addMessage(DbdQuestionMessages.編集破棄確認.getMessage()).respond();
            }
            getHandler(div).新規ボタンの処理();
        }
        if (new RString(DbdQuestionMessages.編集破棄確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).新規ボタンの処理();
        }
        return ResponseData.of(div).respond();
    }

    private HikazeiNenkinKenJohoHandler getHandler(HikazeiNenkinKenJohoDiv div) {
        return new HikazeiNenkinKenJohoHandler(div);
    }

    private HikazeiNenkinKenJohoValidationHandler getValidationHandler() {
        return new HikazeiNenkinKenJohoValidationHandler();
    }

}

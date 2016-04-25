/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001Div;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001DivSpec;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.完了;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001TransitionEventName.検索処理へ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001TransitionEventName.検索結果一覧へ;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001Handler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 社会福祉法人等利用者負担軽減申請画面のDivControllerです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class DBD1030001 {

    private static final RString 申請メニューID = new RString("DBDMN21004");
    private static final Decimal DECIMAL_9 = new Decimal("9");
    private static final Decimal DECIMAL_10 = new Decimal("10");
    private static final Decimal DECIMAL_99 = new Decimal("99");
    private static final Decimal DECIMAL_99_9 = new Decimal("99.9");
    private static final Decimal DECIMAL_28 = new Decimal("28.0");
    private static final Decimal DECIMAL_53 = new Decimal("53.0");
    private static final Decimal DECIMAL_50 = new Decimal("50.0");
    private static final Decimal DECIMAL_25 = new Decimal("25.0");
    private static final Decimal DECIMAL_100 = new Decimal("100");
    private static final FlexibleDate FLEXIBLEDDTE_20060701 = new FlexibleDate("20060701");
    private static final FlexibleDate FLEXIBLEDDTE_20110331 = new FlexibleDate("20110331");

    /**
     * 画面初期化
     *
     * @param div DBD1030001Div
     * @return ResponseData<DBD1030001Div>
     */
    public ResponseData<DBD1030001Div> onLoad(DBD1030001Div div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を追加する」（また「承認情報を追加する」）を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnAddShinsei(DBD1030001Div div) {
        getHandler(div).onClick_btnAddShinsei();
        return ResponseData.of(div).setState(詳細);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の修正ボタン」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onSelectByModifyButton(DBD1030001Div div) {
        getHandler(div).onClick_onSelectByModifyButton();
        return ResponseData.of(div).setState(詳細);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の削除ボタン」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onSelectByDeleteButton(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).onClick_onSelectByDeleteButton();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「決定区分」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_radKetteiKubun(DBD1030001Div div) {
        getHandler(div).onClick_radKetteiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「承認しない理由」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onBeforeOpenDialog(DBD1030001Div div) {
        div.getShafukuRiyoshaKeigen().setSubGyomuCode(DataPassingConverter.serialize(SubGyomuCode.DBD介護受給));
        div.getShafukuRiyoshaKeigen().setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧に戻る」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnBackToShinseiList(DBD1030001Div div) {
        if (getHandler(div).is申請情報エリア入力内容がある()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
                getHandler(div).情報エリアクリア();
                div.getDgShinseiList().setDisabled(false);
                div.getShinseiList().setDisplayNone(false);
                div.getShinseiDetail().setDisplayNone(true);
                return ResponseData.of(div).setState(一覧);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        div.getDgShinseiList().setDisabled(false);
        div.getShinseiList().setDisplayNone(false);
        div.getShinseiDetail().setDisplayNone(true);
        return ResponseData.of(div).setState(一覧);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を確定する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnShinseiKakutei(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            申請日の未入力チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getHandler(div).情報を確定();
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「承認情報を確定する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnShoninKakutei(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            承認情報必須入力チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            ResponseData<DBD1030001Div> responseData = 承認情報相関チェック１(div);
            if (responseData != null) {
                return responseData;
            }
            getHandler(div).情報を確定();
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「再検索する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnReSearch(DBD1030001Div div) {
        ViewStateHolder.put(DBD1030001Handler.DBD1030001ViewStateKey.申請一覧情報と状態, null);
        getHandler(div).前排他の解除();
        return ResponseData.of(div).forwardWithEventName(検索処理へ).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「検索結果一覧へ」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnToSearchResult(DBD1030001Div div) {
        getHandler(div).前排他の解除();
        return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を保存する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnUpdate(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            if (!getHandler(div).変更有無チェック()) {
                InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                        DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            RString メニューID = ResponseHolder.getMenuID();
            if (!申請メニューID.equals(メニューID)) {
                getHandler(div).相関チェック２();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).onClick_btnUpdate();
            return ResponseData.of(div).setState(完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を適用日入力する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onBlur(DBD1030001Div div) {
        getHandler(div).onClick_onBlur();
        return ResponseData.of(div).respond();
    }

    private void 承認情報必須入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        申請日の未入力チェック(pairs, div);
        決定区分の未入力チェック(pairs, div);
        決定日の未入力チェック(pairs, div);
        適用日の未入力チェック(pairs, div);
        有効期限の未入力チェック(pairs, div);
    }

    private ValidationMessageControlPairs 申請日の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.申請日の非空チェック)
                .thenAdd(NoInputMessages.申請日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請日の必須入力, div.getTxtShinseiYMD()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 決定区分の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.決定区分の非空チェック)
                .thenAdd(NoInputMessages.決定区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定区分の必須入力, div.getRadKetteiKubun()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 決定日の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.決定日の非空チェック)
                .thenAdd(NoInputMessages.決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日の必須入力, div.getTxtKetteiYMD()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 適用日の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.適用日の非空チェック)
                .thenAdd(NoInputMessages.適用日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.適用日の必須入力, div.getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 有効期限の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.有効期限の非空チェック)
                .thenAdd(NoInputMessages.有効期限の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期限の必須入力, div.getTxtYukoKigenYMD()).build().check(messages));
        return pairs;
    }

    private FlexibleDate get法施工日() {
        RString 法施工日RString = BusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (null == 法施工日RString || 法施工日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(法施工日RString);
    }

    private ResponseData<DBD1030001Div> 承認情報相関チェック１(DBD1030001Div div) {
        FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
        FlexibleDate 法施工日 = get法施工日();
        ShakaiFukushiHojinKeigenService service = ShakaiFukushiHojinKeigenService.createIntance();
        if (!法施工日.isEmpty() && 適用開始日.isBefore(法施工日)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_適用日が法施行前.getMessage());
        }
        FlexibleDate 標準有効期限 = service.estimate有効期限(適用開始日);
        FlexibleDate 有効期限 = div.getTxtYukoKigenYMD().getValue();
        if (標準有効期限.isEmpty() || 標準有効期限.isBefore(有効期限)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_有効期限が年度外.getMessage());
        }
        if (有効期限.isBefore(適用開始日)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_有効期限が適用日以前.getMessage());
        }
        Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
        Decimal 減免率_分母 = div.getTxtKeigenRitsuBunbo().getValue();
        if (減免率_分子.compareTo(減免率_分母) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子が分母より大.getMessage());
        }
        List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
        List<RString> 旧措置ユニット型個室SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
        if (!居宅サービス限定SelectKeys.isEmpty() && !旧措置ユニット型個室SelectKeys.isEmpty()) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択.getMessage());
        }
        ResponseData<DBD1030001Div> responseData = 承認情報相関チェック１_15(
                減免率_分子, 減免率_分母, 適用開始日, 居宅サービス限定SelectKeys, 旧措置ユニット型個室SelectKeys, div);
        if (responseData != null) {
            return null;
        }
        if (!service.canBe利用者(get被保険者番号FromViewState(), 適用開始日)) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
        }
        return null;
    }

    private ResponseData<DBD1030001Div> 承認情報相関チェック１_15(Decimal 減免率_分子, Decimal 減免率_分母, FlexibleDate 適用開始日,
            List<RString> 居宅サービス限定SelectKeys, List<RString> 旧措置ユニット型個室SelectKeys, DBD1030001Div div) {
        FlexibleDate 制度改正施行日_平成１７年１０月改正 = get制度改正施行日_平成１７年１０月改正();
        FlexibleDate 特例措置期間開始日 = get特例措置期間開始日();
        FlexibleDate 特例措置期間終了日 = get特例措置期間終了日();
        if (!制度改正施行日_平成１７年１０月改正.isEmpty() && 適用開始日.isBefore(制度改正施行日_平成１７年１０月改正)) {
            軽減率_分子_分母チェック1(減免率_分子, 減免率_分母);
        } else if (適用開始日.isBefore(FLEXIBLEDDTE_20060701)) {
            軽減率_分子_分母チェック2(減免率_分子, 減免率_分母);
        } else if (特例措置期間開始日.isBeforeOrEquals(適用開始日) && !特例措置期間終了日.isEmpty() && 適用開始日.isBeforeOrEquals(特例措置期間終了日)) {
            ResponseData<DBD1030001Div> responseData = 承認情報相関チェック１_15_1(減免率_分子, 減免率_分母, 居宅サービス限定SelectKeys, div);
            if (responseData != null) {
                return responseData;
            }
        } else if (!居宅サービス限定SelectKeys.isEmpty() || !旧措置ユニット型個室SelectKeys.isEmpty()) {
            ResponseData<DBD1030001Div> responseData = 承認情報相関チェック１_15_2(減免率_分子, 減免率_分母, div);
            if (responseData != null) {
                return responseData;
            }
        } else {
            ResponseData<DBD1030001Div> responseData = 承認情報相関チェック１_15_3(減免率_分子, 減免率_分母, div, 適用開始日);
            if (responseData != null) {
                return responseData;
            }
        }
        return null;
    }

    private ResponseData<DBD1030001Div> 承認情報相関チェック１_15_3(Decimal 減免率_分子,
            Decimal 減免率_分母, DBD1030001Div div, FlexibleDate 適用開始日) {
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        }
        if (減免率_分子.compareTo(DECIMAL_100) == 0 && FLEXIBLEDDTE_20110331.isBefore(適用開始日) && is対象の被保険者が生活保護(div)) {
            WarningMessage message = new WarningMessage(DbdWarningMessages.社会福祉法人減免_非生活保護者_軽減率100.getMessage().getCode(),
                    DbdWarningMessages.社会福祉法人減免_非生活保護者_軽減率100.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else {
            軽減率_分子チェック1(減免率_分子);
        }
        return null;
    }

    private ResponseData<DBD1030001Div> 承認情報相関チェック１_15_2(Decimal 減免率_分子, Decimal 減免率_分母, DBD1030001Div div) {
        if (減免率_分子.compareTo(DECIMAL_25) != 0 && 減免率_分子.compareTo(DECIMAL_50) != 0) {
            WarningMessage message = new WarningMessage(DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage().getCode(),
                    DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        } else {
            軽減率_分子_分母チェック4(減免率_分子, 減免率_分母);
        }
        return null;
    }

    private ResponseData<DBD1030001Div> 承認情報相関チェック１_15_1(Decimal 減免率_分子, Decimal 減免率_分母,
            List<RString> 居宅サービス限定SelectKeys, DBD1030001Div div) {
        if (!居宅サービス限定SelectKeys.isEmpty() || isすべてがチェックオフ(div)) {
            if (減免率_分子.compareTo(DECIMAL_28) != 0 && 減免率_分子.compareTo(DECIMAL_53) != 0) {
                WarningMessage message = new WarningMessage(DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage().getCode(),
                        DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (減免率_分母.compareTo(DECIMAL_100) != 0) {
                throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
            }
        } else {
            軽減率_分子_分母チェック4(減免率_分子, 減免率_分母);
        }
        return null;
    }

    private void 軽減率_分子チェック1(Decimal 減免率_分子) {
        if (減免率_分子.compareTo(Decimal.ONE) < 0 || 減免率_分子.compareTo(DECIMAL_99_9) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は1から99の範囲.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック1(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(Decimal.ZERO) < 0 || 減免率_分子.compareTo(DECIMAL_9) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は1桁整数.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_10) < 0 || 減免率_分母.compareTo(DECIMAL_99) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は2桁整数.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック2(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(DECIMAL_10) < 0 || 減免率_分子.compareTo(DECIMAL_99) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は2桁整数.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック4(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(Decimal.ONE) < 0 || 減免率_分子.compareTo(DECIMAL_99_9) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は1から99の範囲.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        }
    }

    private boolean isすべてがチェックオフ(DBD1030001Div div) {
        List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
        List<RString> 居居住費_食費限定SelectKeys = div.getChkKyojuhiShokuhiGentei().getSelectedKeys();
        List<RString> 旧措置ユニット型個室限定SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
        return !is入力内容がある(居宅サービス限定SelectKeys)
                && !is入力内容がある(居居住費_食費限定SelectKeys)
                && !is入力内容がある(旧措置ユニット型個室限定SelectKeys);
    }

    private boolean is入力内容がある(List<RString> 入力内容) {
        return 入力内容 != null && !入力内容.isEmpty();
    }

    private boolean is対象の被保険者が生活保護(DBD1030001Div div) {
        return SeikatsuhogoManagerFactory.createInstance()
                .get生活保護(get識別コードFromViewState(), GyomuCode.DB介護保険, div.getTxtShinseiYMD().getValue()) != null;
    }

    private ShikibetsuCode get識別コードFromViewState() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        return 識別コード;
    }

    private FlexibleDate get制度改正施行日_平成１７年１０月改正() {
        RString 制度改正施行日RString = BusinessConfig
                .get(ConfigNameDBU.制度改正施行日_平成１７年１０月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (null == 制度改正施行日RString || 制度改正施行日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(制度改正施行日RString);
    }

    private FlexibleDate get特例措置期間開始日() {
        RString 特例措置期間開始日RString = BusinessConfig
                .get(ConfigNameDBD.社会福祉法人軽減_特例措置期間開始日, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (null == 特例措置期間開始日RString || 特例措置期間開始日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(特例措置期間開始日RString);
    }

    private FlexibleDate get特例措置期間終了日() {
        RString 特例措置期間終了日RString = BusinessConfig
                .get(ConfigNameDBD.社会福祉法人軽減_特例措置期間終了日, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (特例措置期間終了日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(特例措置期間終了日RString);
    }

    private HihokenshaNo get被保険者番号FromViewState() {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (null == 被保険者番号) {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        return 被保険者番号;
    }

    private DBD1030001Handler getHandler(DBD1030001Div div) {
        return new DBD1030001Handler(div);
    }

    private static enum NoInputMessages implements IValidationMessage {

        申請日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "申請日"),
        決定区分の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "決定区分"),
        決定日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "決定日"),
        適用日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "適用日"),
        有効期限の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "有効期限"),
        給付率の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "給付率");
        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}

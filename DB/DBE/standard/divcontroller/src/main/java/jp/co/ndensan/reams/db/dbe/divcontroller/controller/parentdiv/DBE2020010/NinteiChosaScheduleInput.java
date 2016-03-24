/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020010;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ninteichosascheduleinput.NinteiChosaSchedule;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010.DBE2020010StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010.DBE2020010TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010.NinteiChosaScheduleInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020010.NinteiChosaScheduleInputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020010.NinteiChosaScheduleInputValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosascheduleinput.NinteiChosaScheduleInputManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 認定調査スケジュール登録10のDIVControllerクラスです。
 */
public class NinteiChosaScheduleInput {

    private static final RString 画面ステート_1 = new RString("1");
    private static final RString 画面ステート_2 = new RString("2");
    private static final RString 画面ステート_3 = new RString("3");
    private static final RString 予約可_KEY = new RString("key0");
    private static final RString 予約不可_KEY = new RString("key1");
    private static final RString 予約可 = new RString("0");
    private static final RString 予約不可 = new RString("1");
    private static final RString 予約状況_仮予約 = new RString("key0");
    private static final RString 予約状況_確定 = new RString("key1");
    private static final RString 予約状況_未定 = new RString("key2");
    private static final RString 対象者区分_申請者 = new RString("0");
    private static final RString 対象者区分_未定者 = new RString("1");
    private static final RString 遷移元画面番号_2 = new RString("2");
    private static final RString 遷移元画面番号_3 = new RString("3");
    private final RString 保存 = new RString("保存");

    private RString 画面ステート;
    private RString temp_画面ステート;
    private RString temp_地区コード;
    private RString temp_市町村コード;
    private RString temp_認定調査委託先コード;
    private RString temp_認定調査委託先名称;
    private RString temp_認定調査員コード;
    private RString temp_認定調査員名称;
    private RString temp_設定日;
    private RString temp_時間枠;
    private RString temp_予約可否;
    private RString temp_予約状況;
    private RString temp_備考;
    private RString temp_被保番号;
    private RString temp_被保険者区分コード;
    private RString temp_保険者;
    private FlexibleDate temp_認定申請日;
    private RString temp_申請区分_申請時;
    private RString temp_氏名;
    private RString temp_カナ氏名;
    private RString temp_場所;
    private RString temp_駐車場;
    private RString temp_立会人1;
    private RString temp_連絡先1;
    private RString temp_立会人2;
    private RString temp_連絡先2;
    private RString temp_対象者メモ;
    private RString temp_申請者管理番号1;
    private static RString temp_申請者管理番号2;
    private static RString temp_申請者管理番号3;
    private static RString temp_対象者区分;
    //この仕様書のtemp_変量使用しない
//    private RString temp_認定調査予定開始時間;
//    private RString temp_認定調査予定終了時間;
//    private RString temp_編集状態;
    private static RString temp_遷移元画面番号;
    private RString temp_調査員状況02;

    /**
     * 認定調査スケジュール登録10初期化の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onLoad(NinteiChosaScheduleInputDiv div) {

        initializeTemp変数();
        setTemp変数();
        getHandler(div).onLoad(temp_申請者管理番号3, temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況,
                temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名, temp_カナ氏名,
                temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
        return ResponseData.of(div).respond();
    }

    private void initializeTemp変数() {
        temp_地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class);
        temp_市町村コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_市町村コード, RString.class);
        temp_認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, RString.class);
        temp_認定調査員コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査員コード, RString.class);
        FlexibleDate 設定日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
        if (設定日 != null && !設定日.isEmpty()) {
            temp_設定日 = new RString(設定日.toString());
        }
        temp_時間枠 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_時間枠, RString.class);
        temp_予約可否 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_予約可否, RString.class);
        temp_予約状況 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_予約状況, RString.class);
        temp_調査員状況02 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_調査員状況02, RString.class);
//        temp_認定調査予定開始時間 = get調査日時(temp_時間枠).split("-").get(0);
//        temp_認定調査予定終了時間 = get調査日時(temp_時間枠).split("-").get(1);
//        temp_編集状態 = new RString("0");
    }

    private void setTemp変数() {
        temp_画面ステート = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        temp_遷移元画面番号 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_画面番号, RString.class);
        if (画面ステート_1.equals(temp_画面ステート) && 遷移元画面番号_2.equals(temp_遷移元画面番号)) {
            temp_申請者管理番号1 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_申請書管理番号2, RString.class);
            temp_申請者管理番号2 = temp_申請者管理番号1;
            temp_申請者管理番号3 = temp_申請者管理番号1;
            set調査員情報Temp変数();
            set対象者調査基本情報Temp変数();
            set対象者個人基本情報Temp変数();
        }
        if (画面ステート_1.equals(temp_画面ステート) && 遷移元画面番号_3.equals(temp_遷移元画面番号)) {
            temp_申請者管理番号1 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_申請書管理番号3, RString.class);
            temp_申請者管理番号3 = temp_申請者管理番号1;
            temp_対象者区分 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_対象者区分, RString.class);
            set対象者調査基本情報Temp変数();
            set対象者個人基本情報Temp変数();
        }
        if (画面ステート_2.equals(temp_画面ステート)) {
            temp_申請者管理番号1 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_申請書管理番号3, RString.class);
            temp_申請者管理番号2 = temp_申請者管理番号1;
            temp_申請者管理番号3 = temp_申請者管理番号1;
            temp_対象者区分 = new RString("0");
            set調査員情報Temp変数();
            set対象者調査基本情報Temp変数();
            set対象者個人基本情報Temp変数();
        }
        if (画面ステート_3.equals(temp_画面ステート)) {
            temp_申請者管理番号1 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_申請書管理番号2, RString.class);
            temp_申請者管理番号2 = temp_申請者管理番号1;
            temp_申請者管理番号3 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_申請書管理番号3, RString.class);
            set調査員情報Temp変数();
            set対象者調査基本情報Temp変数();
            set対象者個人基本情報Temp変数();
        }
    }

    private void set調査員情報Temp変数() {
        NinteiChosaSchedule ninteiChosaSchedule = NinteiChosaScheduleInputManager.createInstance().get調査員情報取得(
                temp_申請者管理番号2, temp_設定日, temp_時間枠, temp_地区コード, temp_認定調査委託先コード, temp_認定調査員コード,
                temp_市町村コード, temp_調査員状況02);
        if (ninteiChosaSchedule != null) {
            temp_地区コード = ninteiChosaSchedule.get地区コード().value();
            temp_市町村コード = ninteiChosaSchedule.get市町村コード().value();
            temp_認定調査委託先コード = ninteiChosaSchedule.get認定調査委託先コード();
            temp_認定調査委託先名称 = ninteiChosaSchedule.get認定調査委託先名称();
            temp_認定調査員コード = ninteiChosaSchedule.get認定調査員コード();
            temp_認定調査員名称 = ninteiChosaSchedule.get認定調査員名称();
            temp_設定日 = new RString(ninteiChosaSchedule.get設定日().toString());
//            temp_認定調査予定開始時間 = ninteiChosaSchedule.get認定調査予定開始時間();
//            temp_認定調査予定終了時間 = ninteiChosaSchedule.get認定調査予定終了時間();
            temp_時間枠 = ninteiChosaSchedule.get時間枠();
            if (ninteiChosaSchedule.is予約可否()) {
                temp_予約可否 = 予約可;
            } else {
                temp_予約可否 = 予約不可;
            }
            temp_予約状況 = ninteiChosaSchedule.get予約状況().value();
            temp_備考 = ninteiChosaSchedule.get備考();
        }
    }

    private void set対象者個人基本情報Temp変数() {
        if (!RString.isNullOrEmpty(temp_申請者管理番号3)) {
            NinteiShinseiJoho ninteiShinseiJoho = NinteiChosaScheduleInputManager.createInstance()
                    .get対象個人基本情報取得(new ShinseishoKanriNo(temp_申請者管理番号3));
            if (ninteiShinseiJoho != null) {
                temp_被保番号 = ninteiShinseiJoho.get被保険者番号();
                temp_被保険者区分コード = ninteiShinseiJoho.get被保険者区分コード();
                temp_保険者 = ninteiShinseiJoho.get被保険者氏名().value();
                temp_認定申請日 = ninteiShinseiJoho.get認定申請年月日();
                temp_申請区分_申請時 = ninteiShinseiJoho.get認定申請区分_申請時_コード().value();
                temp_氏名 = ninteiShinseiJoho.get被保険者氏名().value();
                temp_カナ氏名 = ninteiShinseiJoho.get被保険者氏名カナ().value();
            }
        }
    }

    private void set対象者調査基本情報Temp変数() {
        if (!RString.isNullOrEmpty(temp_申請者管理番号3)) {
            NinteichosaSchedule ninteichosaSchedule = NinteiChosaScheduleInputManager.createInstance().get調査員情報(
                    temp_申請者管理番号2, temp_設定日, temp_時間枠, temp_地区コード, temp_認定調査委託先コード, temp_認定調査員コード,
                    temp_市町村コード, temp_調査員状況02);
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_調査員情報, ninteichosaSchedule);
            if (ninteichosaSchedule != null) {
                temp_場所 = ninteichosaSchedule.get場所();
                temp_駐車場 = ninteichosaSchedule.get駐車場();
                temp_立会人1 = ninteichosaSchedule.get立会人１();
                temp_連絡先1 = ninteichosaSchedule.get連絡先１().value();
                temp_立会人2 = ninteichosaSchedule.get立会人２();
                temp_連絡先2 = ninteichosaSchedule.get連絡先２().value();
                temp_対象者メモ = ninteichosaSchedule.get対象者メモ();
            }
        }
    }

    /**
     * 対象者を検索するボタンOnclickの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onClick_btnSearchTaishosha(NinteiChosaScheduleInputDiv div) {
        画面ステート = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        temp_地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, temp_地区コード);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面ステート, 画面ステート);
        return ResponseData.of(div).forwardWithEventName(DBE2020010TransitionEventName.更新_対象者を検索する).respond();
    }

    /**
     * 前回情報を表示するボタンOnclickの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onClick_BtnZenkayiJyoho(NinteiChosaScheduleInputDiv div) {
        if (!RString.isNullOrEmpty(temp_申請者管理番号3)) {
            ShinseiRirekiJoho shinseiRirekiJoho = NinteiChosaScheduleInputManager.createInstance()
                    .get前回情報(new ShinseishoKanriNo(temp_申請者管理番号3));
            if (shinseiRirekiJoho == null || shinseiRirekiJoho.get前回申請管理番号() == null || shinseiRirekiJoho.get前回申請管理番号().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("前回履歴"));
            } else {
                List<NinteichosaSchedule> list = NinteiChosaScheduleInputManager.createInstance()
                        .get対象調査基本情報取得(new ShinseishoKanriNo(shinseiRirekiJoho.get前回申請管理番号().value())).records();
                getHandler(div).btnZenkayiJyoho(list);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 予約可に変更するの場合の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onClick_RDOFuka_Ka(NinteiChosaScheduleInputDiv div) {
        temp_予約可否 = div.getWariateJokyo().getRadYoyakuKahi().getSelectedKey();
        temp_画面ステート = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (画面ステート_1.equals(temp_画面ステート) && 予約可_KEY.equals(temp_予約可否)) {
            div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(false);
            div.getWariateJokyo().getRadYoyakuJokyo().setSelectedKey(予約状況_未定);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者をクリアするボタンOnclickの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onClick_BtnClear(NinteiChosaScheduleInputDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbeQuestionMessages.クリア確認.getMessage().getCode(),
                    DbeQuestionMessages.クリア確認.getMessage().replace("申請者情報").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbeQuestionMessages.クリア確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            set対象者詳細Grid値Clear(div);
            initializeTemp変数();
            setTemp変数();
            getHandler(div).onLoad(temp_申請者管理番号3, temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況,
                    temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名, temp_カナ氏名,
                    temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
            div.getButtonArea().getBtnSearchTaishosha().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    private void set対象者詳細Grid値Clear(NinteiChosaScheduleInputDiv div) {
        div.getTaishoshaShosai().getTxtHihoBangoNumber().clearValue();
        div.getTaishoshaShosai().getTxtHihoBangoGosu().clearValue();
        div.getTaishoshaShosai().getTxtHokenshaName().clearValue();
        div.getTaishoshaShosai().getTxtNinteiShinseiDate().clearValue();
        div.getTaishoshaShosai().getTxtNinteiShinseiKubun().clearValue();
        div.getTaishoshaShosai().getTxtTaishoshaName().clearValue();
        div.getTaishoshaShosai().getTxtTaishoshaNameKana().clearValue();
        div.getTaishoshaShosai().getTxtBasho().clearValue();
        div.getTaishoshaShosai().getTxtChushajo().clearValue();
        div.getTaishoshaShosai().getTxtTachiainin1().clearValue();
        div.getTaishoshaShosai().getTxtRenrakusaki1().clearValue();
        div.getTaishoshaShosai().getTxtTachiainin2().clearValue();
        div.getTaishoshaShosai().getTxtRenrakusaki2().clearValue();
        div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().clearValue();
    }

    /**
     * スケジュールを保存するボタンOnclickの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onClick_BtnHozon(NinteiChosaScheduleInputDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        画面ステート = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (画面ステート_2.equals(画面ステート)) {
            validationMessages = getValidationHandler(div).スケジュール照会のため保存できませんチェック();
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        temp_予約可否 = div.getWariateJokyo().getRadYoyakuKahi().getSelectedKey();
        temp_備考 = div.getWariateJokyo().getTxtNinteiChosaBiko().getValue();
        temp_予約状況 = div.getWariateJokyo().getRadYoyakuJokyo().getSelectedKey();
        getMessage(div, validationMessages);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = getMessageA(temp_申請者管理番号3, temp_予約可否, temp_予約状況, temp_備考);
            if (message != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if ((ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && !new RString(DbeQuestionMessages.すでに予約済みです_上書保存.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && !new RString(DbeQuestionMessages.予約を上書保存.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) || !ResponseHolder.isReRequest()) {
            QuestionMessage message = getMessageB(temp_申請者管理番号2);
            if (message != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes && saveスケジュール情報(div) == 1) {

            div.getKaigoKanryoMessage().getCcdKaigoKanryoMessage().setMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(保存.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2020010StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 完了ボタンOnclickの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleInputDiv> onClick_KanRyo(NinteiChosaScheduleInputDiv div) {
        FlexibleDate 設定日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
        temp_保険者 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_保険者, RString.class);
        temp_調査員状況02 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_調査員状況02, RString.class);
        temp_認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, RString.class);
        temp_地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class);
        画面ステート = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_設定日, 設定日);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_保険者, temp_保険者);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_調査員状況02, temp_調査員状況02);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, temp_認定調査委託先コード);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, temp_地区コード);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面ステート, 画面ステート);
        if (遷移元画面番号_2.equals(temp_遷移元画面番号) && 画面ステート_3.equals(画面ステート)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020010TransitionEventName.未定者_スケジュール詳細に戻る).respond();
        } else if (遷移元画面番号_2.equals(temp_遷移元画面番号) && 画面ステート_1.equals(画面ステート)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020010TransitionEventName.更新_スケジュール詳細に戻る).respond();
        } else if (遷移元画面番号_3.equals(temp_遷移元画面番号)
                && (画面ステート_1.equals(画面ステート) || 画面ステート_3.equals(画面ステート))) {
            return ResponseData.of(div).forwardWithEventName(DBE2020010TransitionEventName.照会_該当者一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private int saveスケジュール情報(NinteiChosaScheduleInputDiv div) {
        //TODO: 前排他制限の排他Keyがありません。QA898
//            if (true) {
//                throw new ApplicationException(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage());
//            }
        Code 予約状況;
        NinteichosaSchedule ninteichosa = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_調査員情報, NinteichosaSchedule.class);
        if (予約状況_仮予約.equals(div.getWariateJokyo().getRadYoyakuJokyo().getSelectedKey())) {
            予約状況 = new Code("1");
        } else if (予約状況_確定.equals(div.getWariateJokyo().getRadYoyakuJokyo().getSelectedKey())) {
            予約状況 = new Code("2");
        } else {
            予約状況 = new Code("0");
        }
        ShinseishoKanriNo 申請者管理番号3;
        if (予約不可_KEY.equals(div.getWariateJokyo().getRadYoyakuKahi().getSelectedKey()) && !RString.isNullOrEmpty(temp_申請者管理番号3)) {
            申請者管理番号3 = null;
        } else {
            申請者管理番号3 = new ShinseishoKanriNo(temp_申請者管理番号3);
        }
        if (ninteichosa != null) {
            ninteichosa = ninteichosa.createBuilderForEdit().set予約可能フラグ(予約可_KEY.equals(temp_予約可否))
                    .set予約状況(予約状況)
                    .set備考(div.getWariateJokyo().getTxtNinteiChosaBiko().getValue())
                    .set場所(div.getTaishoshaShosai().getTxtBasho().getValue())
                    .set駐車場(div.getTaishoshaShosai().getTxtChushajo().getValue())
                    .set立会人１(div.getTaishoshaShosai().getTxtTachiainin1().getValue())
                    .set連絡先１(new TelNo(div.getTaishoshaShosai().getTxtRenrakusaki1().getValue()))
                    .set立会人２(div.getTaishoshaShosai().getTxtTachiainin2().getValue())
                    .set連絡先２(new TelNo(div.getTaishoshaShosai().getTxtRenrakusaki2().getValue()))
                    .set対象者メモ(div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().getValue())
                    .set申請書管理番号(申請者管理番号3)
                    .build();
            return NinteiChosaScheduleInputManager.createInstance().saveスケジュール情報(ninteichosa);
        }
        return 0;
    }

    private ValidationMessageControlPairs getMessage(NinteiChosaScheduleInputDiv div, ValidationMessageControlPairs validationMessages) {

        if (予約不可_KEY.equals(temp_予約可否) && RString.isNullOrEmpty(temp_備考)) {
            getValidationHandler(div).備考必須入力項目チェック(validationMessages);
        }
        if (予約可_KEY.equals(temp_予約可否) && 予約状況_未定.equals(temp_予約状況) && !RString.isNullOrEmpty(temp_申請者管理番号3)) {
            getValidationHandler(div).申請者予約があるのチェック(validationMessages);
        }
        if (予約可_KEY.equals(temp_予約可否) && 予約状況_仮予約.equals(temp_予約状況) && RString.isNullOrEmpty(temp_申請者管理番号3)) {
            getValidationHandler(div).申請者未指定なので予約状況は未定申請者を指定のチェック(validationMessages);
        }
        if (予約可_KEY.equals(temp_予約可否) && 予約状況_確定.equals(temp_予約状況) && RString.isNullOrEmpty(temp_申請者管理番号3)) {
            getValidationHandler(div).申請者未指定なので予約状況は未定申請者を指定のチェック(validationMessages);
        }
        return validationMessages;
    }

    private QuestionMessage getMessageA(RString temp_申請者管理番号3, RString temp_予約可否, RString temp_予約状況, RString temp_備考) {
        QuestionMessage message = null;
        if (予約不可_KEY.equals(temp_予約可否)) {
            if (!RString.isNullOrEmpty(temp_備考) && !RString.isNullOrEmpty(temp_申請者管理番号3)) {
                message = new QuestionMessage(DbeQuestionMessages.調査員は予約不可なので該当申請が解除.getMessage().getCode(),
                        DbeQuestionMessages.調査員は予約不可なので該当申請が解除.getMessage().evaluate());
            } else if (!RString.isNullOrEmpty(temp_備考) && RString.isNullOrEmpty(temp_申請者管理番号3)) {
                message = new QuestionMessage(DbeQuestionMessages.調査員は予約不可です.getMessage().getCode(),
                        DbeQuestionMessages.調査員は予約不可です.getMessage().evaluate());
            }
        } else {
            if (予約状況_仮予約.equals(temp_予約状況) && !RString.isNullOrEmpty(temp_申請者管理番号3)) {
                message = new QuestionMessage(DbeQuestionMessages.申請者予約状況は仮予約です.getMessage().getCode(),
                        DbeQuestionMessages.申請者予約状況は仮予約です.getMessage().evaluate());
            } else if (予約状況_確定.equals(temp_予約状況) && !RString.isNullOrEmpty(temp_申請者管理番号3)) {
                message = new QuestionMessage(DbeQuestionMessages.申請者予約状況は確定です.getMessage().getCode(),
                        DbeQuestionMessages.申請者予約状況は確定です.getMessage().evaluate());
            } else if (予約状況_未定.equals(temp_予約状況) && RString.isNullOrEmpty(temp_申請者管理番号3)) {
                message = new QuestionMessage(DbeQuestionMessages.予約未定かつ申請者が未指定です.getMessage().getCode(),
                        DbeQuestionMessages.予約未定かつ申請者が未指定です.getMessage().evaluate());
            }
        }
        return message;
    }

    private QuestionMessage getMessageB(RString temp_申請者管理番号2) {
        QuestionMessage message = null;
        if (!RString.isNullOrEmpty(temp_申請者管理番号2)) {
            if (対象者区分_申請者.equals(temp_対象者区分) || 対象者区分_未定者.equals(temp_対象者区分)) {
                message = new QuestionMessage(DbeQuestionMessages.すでに予約済みです_上書保存.getMessage().getCode(),
                        DbeQuestionMessages.すでに予約済みです_上書保存.getMessage().evaluate());
            }
        } else {
            if (対象者区分_申請者.equals(temp_対象者区分) || 対象者区分_未定者.equals(temp_対象者区分)) {
                message = new QuestionMessage(DbeQuestionMessages.予約を上書保存.getMessage().getCode(),
                        DbeQuestionMessages.予約を上書保存.getMessage().evaluate());
            }
        }
        return message;
    }

    private NinteiChosaScheduleInputHandler getHandler(NinteiChosaScheduleInputDiv div) {
        return new NinteiChosaScheduleInputHandler(div);
    }

    private NinteiChosaScheduleInputValidationHandler getValidationHandler(NinteiChosaScheduleInputDiv div) {
        return new NinteiChosaScheduleInputValidationHandler(div);
    }
}

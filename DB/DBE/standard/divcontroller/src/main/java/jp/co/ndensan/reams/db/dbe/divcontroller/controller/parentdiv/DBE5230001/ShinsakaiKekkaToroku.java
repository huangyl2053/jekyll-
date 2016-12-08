/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5230001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisaiMode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaToroku {

    private static final RString HASDATA = new RString("1");
    private static final RString 認定_01 = new RString("認定");
    private static final RString 申請時コード_5 = new RString("5");
    private static final RString 申請時コード_6 = new RString("6");
    private static final RString 審査結果登録 = new RString("審査結果登録");
    private static final RString SHINSEISHOKANRINO = new RString("ShinseishoKanriNo");
    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString 更新申請 = new RString("更新申請");
    private static final RString 新規申請 = new RString("新規申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString CHEAK_1 = new RString("1");
    private static final int 更新申請可能日数 = 61;

    private final ShinsakaiKekkaTorokuManager manager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaToroku() {
        this.manager = ShinsakaiKekkaTorokuManager.createInstance();
    }

    /**
     * 介護認定審査会審査結果登録Divを初期化します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv> 介護認定審査会審査結果登録Div
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onLoad(ShinsakaiKekkaTorokuDiv div) {
        if (!前排他キーのセット(SHINSEISHOKANRINO)) {
            throw new PessimisticLockingException();
        }

        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);

        ShinsakaiKaisaiMode 選択審査会一覧 = ViewStateHolder.get(ViewStateKeys.選択審査会一覧, ShinsakaiKaisaiMode.class);
        div.getTxtShinsakaiName().setValue(選択審査会一覧.get審査会一覧Grid().get(0).get編集合議体名称());
        div.getTxtGogitaiNo().setValue(選択審査会一覧.get審査会一覧Grid().get(0).get合議体名称());
        div.getTxtShinsaTaishosha().setValue(new RString(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会割当済み人数().toString()));
        div.getTxtShinsakaiKaijo().setValue(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会開催場所名称());
        div.getTxtChiku().setValue(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会開催場所名称());
        if (選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会実施人数() != null) {
            div.getTxtTaishoNinzu().setValue(new RString(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会実施人数().toString()));
        }
        div.getTxtKaisaiNichiji().setValue(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会開催年月日());
        div.getTxtKaisaiTimeRange().setFromValue(new RTime(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会開始時刻()));
        div.getTxtKaisaiTimeRange().setToValue(new RTime(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会終了時刻()));
        if (選択審査会一覧.get審査会一覧Grid().get(0).get種類().equals(CHEAK_1)) {
            div.getChkShinsakaiShurui().setIsAllSelectable(true);
        }
        div.getTxtStutas().setValue(選択審査会一覧.get審査会一覧Grid().get(0).get介護認定審査会進捗状況());

        List<ShinsakaiKekkaTorokuBusiness> headList = manager.getヘッドエリア内容検索(開催番号).records();
        List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList = manager.get審査会委員一覧検索(開催番号).records();
        getHandler(div).onLoad(headList, iChiRanList);
        List<ShinsakaiWariateJoho> yoteiJohoList = manager.get介護認定審査会割当情報(開催番号).records();
        Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiKaisaiYoteiJoho = Models.create(yoteiJohoList);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, shinsakaiKaisaiYoteiJoho);
        List<NinteiShinseiJoho> ninteiShinseiJohoList = manager.get要介護認定申請情報(開催番号).records();
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho = Models.create(ninteiShinseiJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, ninteiShinseiJoho);
        List<NinteiKekkaJoho> ninteiKekkaJohoList = manager.get要介護認定結果情報(開催番号).records();
        Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho = Models.create(ninteiKekkaJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定結果情報, ninteiKekkaJoho);
        List<NinteiKanryoJoho> ninteiKanryoJohoList = manager.get要介護認定完了情報(開催番号).records();
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho = Models.create(ninteiKanryoJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定完了情報, ninteiKanryoJoho);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Gridの「選択」ボタンを押下 ＤＢ介護認定審査会割当委員情報」より物理削除です。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_SelectButton(ShinsakaiKekkaTorokuDiv div) {
        if (div.getKobetsuHyojiArea().getBtnToroku().isDisabled()) {
            getHandler(div).setKobetsuHyojiArea();
            return ResponseData.of(div).respond();
        }
        if (HASDATA.equals(div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getUpDateFlag()) && getHandler(div).hasChange()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).setKobetsuHyojiArea();
            }
        } else {
            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 登録ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_KaKuTeiButton(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).設定期間Fromと設定期間Toの前後順(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).有効月数チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).有効月数範囲チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).setTaishoshaIchiran();
        getHandler(div).setKobetsuHyojiAreaClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnBack(ShinsakaiKekkaTorokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5230001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_Save(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).対象者一覧件数チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        ValidationMessageControlPairs validPairs2 = getValidationHandler(div).認定期間チェック(validationMessages);
        if (validPairs2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs2).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            審査結果登録処理(div);
            前排他キーの解除(SHINSEISHOKANRINO);
            div.getKanryoMessagePanel().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace(審査結果登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE5230001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private void 審査結果登録処理(ShinsakaiKekkaTorokuDiv div) {
        List<dgTaishoshaIchiran_Row> rowList = div.getDgTaishoshaIchiran().getDataSource();
        Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho
                = ViewStateHolder.get(ViewStateKeys.要介護認定結果情報, Models.class);
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        for (dgTaishoshaIchiran_Row row : rowList) {
            upd介護認定審査会割当情報(row, 開催番号);
            NinteiKekkaJohoIdentifier dentifier = new NinteiKekkaJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            if (HASDATA.equals(row.getUpDateFlag()) && 認定_01.equals(row.getHanteiKekka())) {
                if (ninteiKekkaJoho.get(dentifier) == null) {
                    ins要介護認定結果情報(row, 開催番号);
                    upd要介護認定申請情報(row);
                } else {
                    upd要介護認定結果情報(row, 開催番号);
                }
            }
            if (HASDATA.equals(row.getUpDateFlag()) && !認定_01.equals(row.getHanteiKekka())) {
                upd要介護認定完了情報(row);
                if (ninteiKekkaJoho.get(dentifier) != null) {
                    del要介護認定結果情報(row);
                }
            }
        }
    }

    private void upd介護認定審査会割当情報(dgTaishoshaIchiran_Row row, RString 開催番号) {
        Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiWariateJohoJoho
                = ViewStateHolder.get(ViewStateKeys.介護認定審査会開催予定情報, Models.class);
        ShinsakaiWariateJohoIdentifier identifier
                = new ShinsakaiWariateJohoIdentifier(開催番号, new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        Code 判定結果 = Code.EMPTY;
        if (!RString.isNullOrEmpty(row.getHanteiKekkaCode())) {
            判定結果 = new Code(row.getHanteiKekkaCode());
        }
        if (HASDATA.equals(row.getUpDateFlag())) {
            ShinsakaiWariateJoho shinsakaiWariateJoho = shinsakaiWariateJohoJoho.get(identifier);
            ShinsakaiWariateJohoBuilder shinsakaiWariate = shinsakaiWariateJoho.createBuilderForEdit();
            shinsakaiWariate.set判定結果コード(判定結果);
            shinsakaiWariateJoho = shinsakaiWariate.build();
            manager.upd介護認定審査会割当情報(shinsakaiWariateJoho);
        }
    }

    private void upd要介護認定申請情報(dgTaishoshaIchiran_Row row) {
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho
                = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, Models.class);
        NinteiShinseiJohoIdentifier identifier
                = new NinteiShinseiJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        Code 法令コード = Code.EMPTY;
        if (!RString.isNullOrEmpty(row.getHanteiKekkaCode())) {
            法令コード = new Code(row.getShinseiKubunLawCode());
        }
        if (申請時コード_5.equals(row.getShinseiKubunShinseijiCode())
                || 申請時コード_6.equals(row.getShinseiKubunShinseijiCode())) {
            法令コード = new Code("4");
        }
        if (HASDATA.equals(row.getUpDateFlag())) {
            NinteiShinseiJoho ninteiShinsei = ninteiShinseiJoho.get(identifier);
            NinteiShinseiJohoBuilder ninteiShinseiBuilder = ninteiShinsei.createBuilderForEdit();
            ninteiShinseiBuilder.set認定申請区分_法令_コード(法令コード);
            ninteiShinsei = ninteiShinseiBuilder.build();
            manager.upd要介護認定申請情報(ninteiShinsei);
        }
    }

    private void ins要介護認定結果情報(dgTaishoshaIchiran_Row row, RString 開催番号) {
        if (HASDATA.equals(row.getUpDateFlag())) {
            NinteiKekkaJoho ninteiKekka = new NinteiKekkaJoho(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            NinteiKekkaJohoBuilder ninteiKekkaBuilder = ninteiKekka.createBuilderForEdit();
            ninteiKekkaBuilder.set二次判定年月日(row.getNijiHanteiDate().getValue());
            RString 二次判定コード = row.getKonkaiNijiHanteiCode();
            if (!RString.isNullOrEmpty(二次判定コード)) {
                ninteiKekkaBuilder.set二次判定要介護状態区分コード(new Code(二次判定コード));
            } else {
                ninteiKekkaBuilder.set二次判定要介護状態区分コード(Code.EMPTY);
            }
            RString 月数 = row.getNinteiKikanTukisu();
            if (!RString.isNullOrEmpty(月数)) {
                ninteiKekkaBuilder.set二次判定認定有効期間(Integer.parseInt(月数.toString()));
            }
            ninteiKekkaBuilder.set二次判定認定有効開始年月日(row.getNinteiKikanKaishi().getValue());
            ninteiKekkaBuilder.set二次判定認定有効終了年月日(row.getNinteiKikanShuryo().getValue());
            ninteiKekkaBuilder.set介護認定審査会開催番号(開催番号);
            ninteiKekkaBuilder.set介護認定審査会意見(row.getHidIken());
            ninteiKekkaBuilder.set一次判定結果変更理由(row.getIchijiHanteiKekkaHenkoRiyu());
            RString 状態像例コード = row.getJotaizoCode();
            if (!RString.isNullOrEmpty(状態像例コード)) {
                ninteiKekkaBuilder.set要介護状態像例コード(new Code(状態像例コード));
            } else {
                ninteiKekkaBuilder.set要介護状態像例コード(Code.EMPTY);
            }
            ninteiKekkaBuilder.set認定審査会意見種類(row.getHidIkenCode());
            ninteiKekkaBuilder.set審査会メモ(row.getHidMemo());
            ninteiKekkaBuilder.set二次判定結果入力方法(new Code("1"));
            ninteiKekkaBuilder.set二次判定結果入力年月日(new FlexibleDate(RDate.getNowDate().toString()));
            ninteiKekka = ninteiKekkaBuilder.build();
            manager.ins要介護認定結果情報(ninteiKekka);
        }
    }

    private void upd要介護認定結果情報(dgTaishoshaIchiran_Row row, RString 開催番号) {
        Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho
                = ViewStateHolder.get(ViewStateKeys.要介護認定結果情報, Models.class);
        NinteiKekkaJohoIdentifier identifier = new NinteiKekkaJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        NinteiKekkaJoho ninteiKekka = ninteiKekkaJoho.get(identifier);
        if (HASDATA.equals(row.getUpDateFlag())) {
            NinteiKekkaJohoBuilder ninteiKekkaBuilder = ninteiKekka.createBuilderForEdit();
            ninteiKekkaBuilder.set二次判定年月日(row.getNijiHanteiDate().getValue());
            RString 二次判定コード = row.getKonkaiNijiHanteiCode();
            if (!RString.isNullOrEmpty(二次判定コード)) {
                ninteiKekkaBuilder.set二次判定要介護状態区分コード(new Code(二次判定コード));
            } else {
                ninteiKekkaBuilder.set二次判定要介護状態区分コード(Code.EMPTY);
            }
            RString 月数 = row.getNinteiKikanTukisu();
            if (!RString.isNullOrEmpty(月数)) {
                ninteiKekkaBuilder.set二次判定認定有効期間(Integer.parseInt(月数.toString()));
            }
            ninteiKekkaBuilder.set二次判定認定有効開始年月日(row.getNinteiKikanKaishi().getValue());
            ninteiKekkaBuilder.set二次判定認定有効終了年月日(row.getNinteiKikanShuryo().getValue());
            ninteiKekkaBuilder.set介護認定審査会開催番号(開催番号);
            ninteiKekkaBuilder.set介護認定審査会意見(row.getHidIken());
            ninteiKekkaBuilder.set一次判定結果変更理由(row.getIchijiHanteiKekkaHenkoRiyu());
            RString 状態像例コード = row.getJotaizoCode();
            if (!RString.isNullOrEmpty(状態像例コード)) {
                ninteiKekkaBuilder.set要介護状態像例コード(new Code(状態像例コード));
            } else {
                ninteiKekkaBuilder.set要介護状態像例コード(Code.EMPTY);
            }
            ninteiKekkaBuilder.set認定審査会意見種類(row.getHidIkenCode());
            ninteiKekkaBuilder.set審査会メモ(row.getHidMemo());
            ninteiKekkaBuilder.set二次判定結果入力方法(new Code("1"));
            ninteiKekkaBuilder.set二次判定結果入力年月日(new FlexibleDate(RDate.getNowDate().toString()));
            ninteiKekka = ninteiKekkaBuilder.build();
            manager.upd要介護認定結果情報(ninteiKekka);
        }
    }

    private void del要介護認定結果情報(dgTaishoshaIchiran_Row row) {
        Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho
                = ViewStateHolder.get(ViewStateKeys.要介護認定結果情報, Models.class);
        NinteiKekkaJohoIdentifier identifier = new NinteiKekkaJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        NinteiKekkaJoho ninteiKekka = ninteiKekkaJoho.get(identifier);
        if (ninteiKekka != null && HASDATA.equals(row.getUpDateFlag())) {
            NinteiKekkaJohoBuilder ninteiKekkaBuilder = ninteiKekka.createBuilderForEdit();
            ninteiKekkaBuilder.set二次判定年月日(row.getNijiHanteiDate().getValue());
            ninteiKekka = ninteiKekkaBuilder.build();
            manager.del要介護認定結果情報(ninteiKekka);
        }
    }

    private void upd要介護認定完了情報(dgTaishoshaIchiran_Row row) {
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho
                = ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class);
        NinteiKanryoJohoIdentifier identifier = new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        NinteiKanryoJoho ninteiKanryo = ninteiKanryoJoho.get(identifier);
        if (HASDATA.equals(row.getUpDateFlag())) {
            NinteiKanryoJohoBuilder ninteiKanryoBuilder = ninteiKanryo.createBuilderForEdit();
            ninteiKanryoBuilder.set認定審査会割当完了年月日(FlexibleDate.EMPTY);
            ninteiKanryo = ninteiKanryoBuilder.build();
            manager.upd要介護認定完了情報(ninteiKanryo);
        }
    }

    /**
     * 「判定結果」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_HanteiKekka(ShinsakaiKekkaTorokuDiv div) {
        boolean hyojiSeigyoFlag = false;
        if (認定_01.equals(div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedValue())) {
            hyojiSeigyoFlag = true;
            getHandler(div).setDdlNijiHanteiHenkouSeigyo(hyojiSeigyoFlag);
        } else {
            getHandler(div).setDdlNijiHanteiHenkouSeigyo(hyojiSeigyoFlag);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NijiHantei(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).setNinteiKikan();
        getHandler(div).setHanteiKekka();

        /**
         * 二次判断が非該当の場合、認定期間の表示制御を設定
         */
        if (div.getDdlNijiHantei().getSelectedKey().equals(非該当)) {
            div.getTxtNinteiKikanFrom().setDisabled(true);
            div.getTxtNinteiKikanTo().setDisabled(true);
        } else {
            div.getTxtNinteiKikanFrom().setDisabled(false);
            div.getTxtNinteiKikanTo().setDisabled(false);
        }

        /**
         * 二次判断が「要介護１」の場合のみ、状態像の入力が必須となるがを設定
         */
        if (div.getDdlNijiHantei().getSelectedKey().equals(要介護1)) {
            div.getDdlJotaiZo().setRequired(true);
            div.getDdlJotaiZo().setDisabled(false);
        } else {
            div.getDdlJotaiZo().setRequired(false);
            div.getDdlJotaiZo().setDisabled(true);
        }
        RString shinseiKubunShinseiji = div.getTxtShinseiKubunShinseiji().getText();
        RString zenkaiNijiHantei = new RString("");
        FlexibleDate zenkaiYukoKikanShuryoDay = new FlexibleDate("");
        if (!div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().size() == 1) {
                zenkaiNijiHantei = div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().get(0).getZenkaiNijiHanteiCode();
            } else {
                zenkaiNijiHantei = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getZenkaiNijiHanteiCode();
            }
        }
        if (!div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().size() == 1) {
                zenkaiYukoKikanShuryoDay = div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().get(0).getZenkaiYukoKikanShuryoDay().getValue();
            } else {
                zenkaiYukoKikanShuryoDay = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getZenkaiYukoKikanShuryoDay().getValue();
            }
        }

        RString nijiHantei = div.getDdlNijiHantei().getSelectedKey();
        FlexibleDate shinseiDay = div.getTxtShinseiDay().getValue();

        /**
         * 申請区分（申請時）と二次判定より、申請区分（法令）を設定
         */
        if (新規申請.equals(shinseiKubunShinseiji)) {
            set申請区分法令At新規申請(nijiHantei, div);
        } else if (更新申請.equals(shinseiKubunShinseiji)) {
            set申請区分法令At更新申請(zenkaiNijiHantei, nijiHantei, div);
        } else if (区分変更申請.equals(shinseiKubunShinseiji)) {
            set申請区分法令At区分変更申請(zenkaiNijiHantei, nijiHantei, shinseiDay, zenkaiYukoKikanShuryoDay, div);
        }
        return ResponseData.of(div).respond();
    }

    private void set申請区分法令At区分変更申請(RString zenkaiNijiHantei, RString nijiHantei,
            FlexibleDate shinseiDay, FlexibleDate zenkaiYukoKikanShuryoDay, ShinsakaiKekkaTorokuDiv div) throws IllegalStateException {
        if (zenkaiNijiHantei.equals(nijiHantei)) {
            if (shinseiDay.plusDay(更新申請可能日数).isBeforeOrEquals(zenkaiYukoKikanShuryoDay)) {
                div.getTxtShinseiKubunLow().setValue(区分変更申請);
            } else {
                div.getTxtShinseiKubunLow().setValue(更新申請);
            }
            return;
        }

        if (is要支援(zenkaiNijiHantei) && is要支援(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(区分変更申請);
        } else if (is要支援(zenkaiNijiHantei) && is要介護(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(新規申請);
        } else if (is要介護(zenkaiNijiHantei) && is要介護(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(区分変更申請);
        } else if (is要介護(zenkaiNijiHantei) && is要支援(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(新規申請);
        }
    }

    private boolean is要介護(RString 二次判定結果コード) {
        return 要介護1.equals(二次判定結果コード) || 要介護2.equals(二次判定結果コード) || 要介護3.equals(二次判定結果コード) || 要介護4.equals(二次判定結果コード) || 要介護5.equals(二次判定結果コード);
    }

    private boolean is要支援(RString 二次判定結果コード) {
        return 要支援1.equals(二次判定結果コード) || 要支援2.equals(二次判定結果コード);
    }

    private void set申請区分法令At更新申請(RString zenkaiNijiHantei, RString nijiHantei, ShinsakaiKekkaTorokuDiv div) {
        if (is要支援(zenkaiNijiHantei) && is要支援(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(更新申請);
        } else if (is要支援(zenkaiNijiHantei) && is要介護(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(新規申請);
        } else if (is要介護(zenkaiNijiHantei) && is要介護(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(更新申請);
        } else if (is要介護(zenkaiNijiHantei) && is要支援(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(新規申請);
        }
    }

    private void set申請区分法令At新規申請(RString nijiHantei, ShinsakaiKekkaTorokuDiv div) {
        if (is要支援(nijiHantei) || is要介護(nijiHantei)) {
            div.getTxtShinseiKubunLow().setValue(新規申請);
        }
    }

    /**
     * 「有効月数」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanMonth(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).setShinsakaiIken();
        return ResponseData.of(div).respond();
    }

    /**
     * メモ定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5101"));
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択したメモ定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtShinsakaiMemo().getValue() == null
                ? RString.EMPTY : div.getTxtShinsakaiMemo().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtShinsakaiMemo().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 意見書定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5201"));
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択した意見書定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtShinsakaiIken().getValue() == null
                ? RString.EMPTY : div.getTxtShinsakaiIken().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtShinsakaiIken().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定結果変更理由ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5103"));
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択した一次判定結果変更理由定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtIchijiHanteiKekkaHenkoRiyu().getValue() == null
                ? RString.EMPTY : div.getTxtIchijiHanteiKekkaHenkoRiyu().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtIchijiHanteiKekkaHenkoRiyu().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査状況照会ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnNinteiChosaJokyoShokai(ShinsakaiKekkaTorokuDiv div) {
        if (!div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().size() == 1) {
                div.setHdnShinseishoKanriNo(div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().get(0).getShinseishoKanriNo());

            } else {
                div.setHdnShinseishoKanriNo(div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getShinseishoKanriNo());
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 1.5次判定ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIchigoHantei(ShinsakaiKekkaTorokuDiv div) {
        if (!div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().size() == 1) {
                ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().get(0).getShinseishoKanriNo());

            } else {
                ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getShinseishoKanriNo());
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間From」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanFrom(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).setNinteiKikanOnFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間To」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanTo(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).setNinteiKikanOnFocus();
        return ResponseData.of(div).respond();
    }

    private boolean 前排他キーのセット(RString 申請書管理番号) {
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除(RString 申請書管理番号) {
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        RealInitialLocker.release(排他キー);
    }

    private ShinsakaiKekkaTorokuHandler getHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuHandler(div);
    }

    private ShinsakaiKekkaTorokuValidationHandler getValidationHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuValidationHandler(div);
    }
}

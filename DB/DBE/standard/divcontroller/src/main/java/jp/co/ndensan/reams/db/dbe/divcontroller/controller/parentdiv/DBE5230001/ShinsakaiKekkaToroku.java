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
import jp.co.ndensan.reams.db.dbe.definition.core.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
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
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosajokyo.NinteiChosaJokyoFinder;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaToroku {

    private static final RString HASDATA = new RString("1");
    private static final RString 審査結果登録 = new RString("審査結果登録");
    private static final RString 排他キーprefix = new RString("DBE審査会審査結果登録_");
    private static final RString 認定調査状況ダイアログ_照会モード = new RString("1");
    private static final int 更新申請可能日数 = 61;
    private static final RString 審査会メモ定型文GroupCode = new RString("5101");
    private static final RString 意見書定型文GroupCode = new RString("5201");
    private static final RString 一次判定結果変更理由定型文GroupCode = new RString("5103");
    private static final Code 二次判定結果入力方法_画面入力 = new Code("1");

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
        if (!前排他キーのセット()) {
            throw new PessimisticLockingException();
        }

        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        List<ShinsakaiKekkaTorokuBusiness> headList = manager.getヘッドエリア内容検索(開催番号).records();
        List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList = manager.get審査会委員一覧検索(開催番号).records();
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.onLoad(headList, iChiRanList);
        handler.clear個別表示欄Value();
        handler.set個別表示欄入力不可();
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
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        dgTaishoshaIchiran_Row 選択行 = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem();
        dgTaishoshaIchiran_Row 更新対象行 = handler.get更新対象row();
        if (更新対象行 == null || !handler.hasChange()) {
            handler.set個別表示欄入力可();
            handler.set個別内容(選択行);
            return ResponseData.of(div).respond();
        }
        if (選択行.getShinsakaiJunjo().equals(更新対象行.getShinsakaiJunjo())) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.set個別表示欄入力可();
            handler.set個別内容(選択行);
            return ResponseData.of(div).respond();
        }
        handler.set選択行(更新対象行.getShinsakaiJunjo());
        return ResponseData.of(div).respond();
    }

    /**
     * 登録ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_KaKuTeiButton(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate個別();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        NinteiShinseiKubunShinsei 申請時申請区分 = handler.get申請時申請区分();
        YokaigoJotaiKubun09 前回二次判定 = handler.get前回二次判定();
        FlexibleDate 前回有効期間終了日 = handler.get前回有効期間終了日();
        YokaigoJotaiKubun09 今回二次判定 = handler.get今回二次判定();
        FlexibleDate 申請日 = div.getTxtShinseiDay().getValue();
        NinteiShinseiKubunHorei 法令申請区分 = get法令申請区分(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        TorisageKubun 取下区分 = get取下区分(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        handler.set更新対象RowFrom個別表示内容(法令申請区分, 取下区分);

        handler.clear個別表示欄Value();
        handler.set個別表示欄入力不可();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力をやめるボタンを押下イベント
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnCancel(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.clear個別表示欄Value();
        handler.set個別表示欄入力不可();
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnBack(ShinsakaiKekkaTorokuDiv div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE5230001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_Save(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate全体();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            審査結果登録処理(div);
            前排他キーの解除();
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
            if (HASDATA.equals(row.getUpDateFlag()) && HanteiKekkaCode.認定.getコード().equals(row.getHanteiKekka())) {
                if (ninteiKekkaJoho.get(dentifier) == null) {
                    ins要介護認定結果情報(row, 開催番号);
                    upd要介護認定申請情報(row);
                } else {
                    upd要介護認定結果情報(row, 開催番号);
                }
            }
            if (HASDATA.equals(row.getUpDateFlag()) && !HanteiKekkaCode.認定.getコード().equals(row.getHanteiKekka())) {
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
        if (HASDATA.equals(row.getUpDateFlag())) {
            NinteiShinseiJoho ninteiShinsei = ninteiShinseiJoho.get(identifier);
            NinteiShinseiJohoBuilder ninteiShinseiBuilder = ninteiShinsei.createBuilderForEdit();
            ninteiShinseiBuilder.set認定申請区分_法令_コード(new Code(new RString(get法令申請区分(row).getコード())));
            ninteiShinseiBuilder.set取下区分コード(get取下区分(row).get取下げ区分コード());
            ninteiShinsei = ninteiShinseiBuilder.build();
            manager.upd要介護認定申請情報(ninteiShinsei);
        }
    }

    private NinteiShinseiKubunHorei get法令申請区分(dgTaishoshaIchiran_Row row) {
        NinteiShinseiKubunShinsei 申請時申請区分 = NinteiShinseiKubunShinsei.toValue(
                Integer.parseInt(row.getShinseiKubunShinseijiCode().toString())
        );
        YokaigoJotaiKubun09 前回二次判定 = YokaigoJotaiKubun09.toValue(row.getZenkaiNijiHantei());
        FlexibleDate 前回有効期間終了日 = row.getZenkaiYukoKikanShuryoDay().getValue();
        YokaigoJotaiKubun09 今回二次判定 = YokaigoJotaiKubun09.toValue(row.getHanteiKekka());
        FlexibleDate 申請日 = row.getShinseiDay().getValue();
        return get法令申請区分(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
    }

    private TorisageKubun get取下区分(dgTaishoshaIchiran_Row row) {
        NinteiShinseiKubunShinsei 申請時申請区分 = NinteiShinseiKubunShinsei.toValue(
                Integer.parseInt(row.getShinseiKubunShinseijiCode().toString())
        );
        YokaigoJotaiKubun09 前回二次判定 = YokaigoJotaiKubun09.toValue(row.getZenkaiNijiHantei());
        FlexibleDate 前回有効期間終了日 = row.getZenkaiYukoKikanShuryoDay().getValue();
        YokaigoJotaiKubun09 今回二次判定 = YokaigoJotaiKubun09.toValue(row.getHanteiKekka());
        FlexibleDate 申請日 = row.getShinseiDay().getValue();
        return get取下区分(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
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
            ninteiKekkaBuilder.set二次判定結果入力方法(二次判定結果入力方法_画面入力);
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
            ninteiKekkaBuilder.set二次判定結果入力方法(二次判定結果入力方法_画面入力);
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
        getHandler(div).set個別入力制御変更from判定結果();
        return ResponseData.of(div).respond();
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NijiHantei(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.set認定期間月数();
        handler.change有効月数に関連するコントロール();
        handler.set認定期間開始日();
        handler.set認定期間終了日();

        handler.set判定結果DDLfrom二次判定();

        if (handler.get今回二次判定() == YokaigoJotaiKubun09.非該当) {
            handler.set認定期間Deisabled(true);
        } else {
            handler.set認定期間Deisabled(false);
        }

        if (handler.get今回二次判定() == YokaigoJotaiKubun09.要介護1) {
            handler.set状態像Deisabled(false);
        } else {
            handler.set状態像Deisabled(true);
        }

        NinteiShinseiKubunShinsei 申請時申請区分 = handler.get申請時申請区分();
        YokaigoJotaiKubun09 前回二次判定 = handler.get前回二次判定();
        FlexibleDate 前回有効期間終了日 = handler.get前回有効期間終了日();
        YokaigoJotaiKubun09 今回二次判定 = handler.get今回二次判定();
        FlexibleDate 申請日 = div.getTxtShinseiDay().getValue();
        NinteiShinseiKubunHorei 法令申請区分 = get法令申請区分(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        TorisageKubun 取下区分 = get取下区分(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        handler.set法令申請区分(法令申請区分);
        handler.set取下区分(取下区分);
        return ResponseData.of(div).respond();
    }

    private NinteiShinseiKubunHorei get法令申請区分(
            NinteiShinseiKubunShinsei 申請時の申請区分,
            YokaigoJotaiKubun09 前回二次判定,
            FlexibleDate 前回有効期間終了日,
            YokaigoJotaiKubun09 今回二次判定,
            FlexibleDate 申請日) {
        return (申請時の申請区分 == NinteiShinseiKubunShinsei.新規申請) ? get申請区分法令At新規申請(今回二次判定)
                : (申請時の申請区分 == NinteiShinseiKubunShinsei.更新申請) ? get申請区分法令At更新申請(前回二次判定, 今回二次判定)
                : (申請時の申請区分 == NinteiShinseiKubunShinsei.区分変更申請) ? get申請区分法令At区分変更申請(前回二次判定, 今回二次判定, 申請日, 前回有効期間終了日)
                : null;
    }

    private NinteiShinseiKubunHorei get申請区分法令At区分変更申請(
            YokaigoJotaiKubun09 前回二次判定結果,
            YokaigoJotaiKubun09 今回二次判定結果,
            FlexibleDate 申請日,
            FlexibleDate 前回有効期間終了日) {
        if (前回二次判定結果.equals(今回二次判定結果)) {
            if (申請日.plusDay(更新申請可能日数).isBeforeOrEquals(前回有効期間終了日)) {
                return NinteiShinseiKubunHorei.区分変更申請;
            }
            return NinteiShinseiKubunHorei.更新申請;
        }
        if (is要支援(前回二次判定結果) && is要支援(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.区分変更申請;
        }
        if (is要支援(前回二次判定結果) && is要介護(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        if (is要介護(前回二次判定結果) && is要介護(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.区分変更申請;
        }
        if (is要介護(前回二次判定結果) && is要支援(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        return null;
    }

    private boolean is要介護(YokaigoJotaiKubun09 二次判定結果) {
        if (二次判定結果 == null) {
            return false;
        }
        return 二次判定結果 == YokaigoJotaiKubun09.要介護1
                || 二次判定結果 == YokaigoJotaiKubun09.要介護2
                || 二次判定結果 == YokaigoJotaiKubun09.要介護3
                || 二次判定結果 == YokaigoJotaiKubun09.要介護4
                || 二次判定結果 == YokaigoJotaiKubun09.要介護5;
    }

    private boolean is要支援(YokaigoJotaiKubun09 二次判定結果) {
        if (二次判定結果 == null) {
            return false;
        }
        return 二次判定結果 == YokaigoJotaiKubun09.要支援1
                || 二次判定結果 == YokaigoJotaiKubun09.要支援2;
    }

    private NinteiShinseiKubunHorei get申請区分法令At更新申請(
            YokaigoJotaiKubun09 前回二次判定結果,
            YokaigoJotaiKubun09 今回二次判定結果) {
        if (is要支援(前回二次判定結果) && is要支援(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.更新申請;
        }
        if (is要支援(前回二次判定結果) && is要介護(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        if (is要介護(前回二次判定結果) && is要介護(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.更新申請;
        }
        if (is要介護(前回二次判定結果) && is要支援(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        return null;
    }

    private NinteiShinseiKubunHorei get申請区分法令At新規申請(YokaigoJotaiKubun09 今回二次判定結果) {
        if (is要支援(今回二次判定結果) || is要介護(今回二次判定結果)) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        return null;
    }

    private TorisageKubun get取下区分(
            NinteiShinseiKubunShinsei 申請時の申請区分,
            YokaigoJotaiKubun09 前回二次判定,
            FlexibleDate 前回有効期間終了日,
            YokaigoJotaiKubun09 今回二次判定,
            FlexibleDate 申請日) {
        if (申請時の申請区分 != NinteiShinseiKubunShinsei.区分変更申請) {
            return TorisageKubun.認定申請有効;
        }
        if (前回二次判定 != 今回二次判定) {
            return TorisageKubun.認定申請有効;
        }
        if (前回有効期間終了日.getBetweenDays(申請日) < 更新申請可能日数) {
            return TorisageKubun.認定申請有効;
        }
        return TorisageKubun.区分変更却下;
    }

    /**
     * 「有効月数」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanMonth(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.change有効月数に関連するコントロール();
        handler.set認定期間開始日();
        handler.set認定期間終了日();
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
        div.setHdnGroupCd(審査会メモ定型文GroupCode);
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
        div.setHdnGroupCd(意見書定型文GroupCode);
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
        div.setHdnGroupCd(一次判定結果変更理由定型文GroupCode);
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
        RString 申請書管理番号 = getHandler(div).get申請書管理番号();
        div.setHdnDialogDisplayModeKey(認定調査状況ダイアログ_照会モード);
        if (申請書管理番号 == null) {
            div.setHdnNinteiChosaJokyo(null);
        } else {
            //div.setHdnShinseishoKanriNo(申請書管理番号);
            NinteiChosaJokyoFinder finder = NinteiChosaJokyoFinder.createInstance();
            NinteiChosaJokyoDataPass konkaiDataPass = finder.get認定調査状況DataPass(new ShinseishoKanriNo(申請書管理番号));
            RDate 予定年月日 = (div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().getValue() == null) ? null
                    : new RDate(div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().getValue().toString());
            konkaiDataPass.set認定審査会予定年月日(予定年月日);
            div.setHdnNinteiChosaJokyo(DataPassingConverter.serialize(konkaiDataPass));
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
        RString 申請書管理番号 = getHandler(div).get申請書管理番号();
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間From」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanFrom(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).set認定期間終了日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間To」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanTo(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).set認定期間月数();
        getHandler(div).change有効月数に関連するコントロール();
        return ResponseData.of(div).respond();
    }

    private boolean 前排他キーのセット() {
        return RealInitialLocker.tryGetLock(create排他キー());
    }

    private void 前排他キーの解除() {
        RealInitialLocker.release(create排他キー());
    }

    private ShinsakaiKekkaTorokuHandler getHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuHandler(div);
    }

    private ShinsakaiKekkaTorokuValidationHandler getValidationHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuValidationHandler(div);
    }

    private LockingKey create排他キー() {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        return new LockingKey(排他キーprefix.concat(開催番号));
    }
}

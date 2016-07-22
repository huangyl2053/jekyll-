/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0050021;

import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanri;
import jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0050011.TaishokensakuJyouken;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021TransitionEventName;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021TransitionEventName.様式４の２;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1DivSpec;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName.検索に戻る;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護保険特別会計経理状況登録_様式４情報Divを制御します。
 *
 * @reamsid_L DBU-1130-020 liangbc
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1 {

    private static final RString 内部処理モード_修正追加 = new RString("修正追加");
    private static final RString 内部処理モード_修正 = new RString("修正");
    private static final RString 内部処理モード_削除 = new RString("削除");
    private static final RString 内部処理モード_追加 = new RString("追加");
    private static final RString ADD = new RString("add");

    /**
     * 介護保険特別会計経理状況登録_様式４を画面初期化処理しました。
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onload(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        handler.onload(get引き継ぎデータ(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 「報告年度」フォーカスロスト処理しました。
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> lostFocus(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 「様式４の２」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnYoshikiyonnoni(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> responseDate = null;
        if (!ResponseHolder.isReRequest()) {
            responseDate = getResponseData_btnYoshikiyonnoni(div);
        }
        if (responseDate != null) {
            return responseDate;
        } else if (内部処理モード_修正追加.equals(div.getGamenMode()) || RString.isNullOrEmpty(div.getGamenMode())) {
            return ResponseData.of(div).forwardWithEventName(様式４の２).parameter(内部処理モード_修正);
        } else {
            return ResponseData.of(div).forwardWithEventName(様式４の２).parameter(div.getGamenMode());
        }
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div>
            getResponseData_btnYoshikiyonnoni(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
        if (内部処理モード_修正.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 修正データ = handler.get修正データ(get引き継ぎデータ(div));
            return 修正データ != null && !修正データ.get詳細データエリア().isEmpty() ? ResponseData.of(div).addMessage(message).respond() : null;
        } else if (内部処理モード_修正追加.equals(div.getShoriMode())
                || 内部処理モード_追加.equals(div.getShoriMode())) {
            return handler.is画面詳細エリア入力有(handler.get画面入力データ(get引き継ぎデータ(div)))
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        }
        return null;
    }

    /**
     * 「様式４の３」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_bntYoskiyonosan(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> responseDate = null;
        if (!ResponseHolder.isReRequest()) {
            responseDate = getResponseData_bntYoskiyonosan(div);
        }
        if (responseDate != null) {
            return responseDate;
        }
        KaigoHokenShoriDateKanri 処理日付管理マスタ = getHandler(div).get処理日付管理マスタ();
        ViewStateHolder.put(TaishokensakuJyouken.ViewStateKey.様式４の３, 処理日付管理マスタ);
        if (内部処理モード_修正追加.equals(div.getGamenMode()) || RString.isNullOrEmpty(div.getGamenMode())) {
            return ResponseData.of(div).forwardWithEventName(DBU0050021TransitionEventName.様式４の３).parameter(内部処理モード_修正);
        } else {
            return ResponseData.of(div).forwardWithEventName(DBU0050021TransitionEventName.様式４の３).parameter(div.getGamenMode());
        }
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div>
            getResponseData_bntYoskiyonosan(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
        if (内部処理モード_修正.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 修正データ = handler.get修正データ(get引き継ぎデータ(div));
            return 修正データ != null && !修正データ.get詳細データエリア().isEmpty() ? ResponseData.of(div).addMessage(message).respond() : null;
        } else if (内部処理モード_修正追加.equals(div.getShoriMode())
                || 内部処理モード_追加.equals(div.getShoriMode())) {
            return handler.is画面詳細エリア入力有(handler.get画面入力データ(get引き継ぎデータ(div)))
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        }
        return null;
    }

    /**
     * 「追加をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnAddUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return handler.is画面詳細エリア入力有(handler.get画面入力データ(get引き継ぎデータ(div)))
                    ? ResponseData.of(div).addMessage(message).respond() : ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
        } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnModUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            return getResponseData_btnModUpdate(div);
        } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div>
            getResponseData_btnModUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
        if (内部処理モード_修正.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 修正データ = handler.get修正データ(get引き継ぎデータ(div));
            return 修正データ != null && !修正データ.get詳細データエリア().isEmpty() ? ResponseData.of(div).addMessage(message).respond()
                    : ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
        } else if (内部処理モード_修正追加.equals(div.getShoriMode())) {
            return handler.is画面詳細エリア入力有(handler.get画面入力データ(get引き継ぎデータ(div)))
                    ? ResponseData.of(div).addMessage(message).respond() : ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnDelUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnSave(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            return getResponseData_btnSave(div);
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).onClick_btnSave(get引き継ぎデータ(div));
            return ResponseData.of(div).setState(DBU0050021StateName.com);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div>
            getResponseData_btnSave(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        KaigoHokenJigyoHokokuNenpo 画面入力データ = handler.get画面入力データ(get引き継ぎデータ(div));
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.処理実行の確認.getMessage().getCode(), UrQuestionMessages.処理実行の確認.getMessage().evaluate());
        if (内部処理モード_追加.equals(div.getShoriMode())) {
            return getResponseData_btnSave_追加(div, 画面入力データ, message);
        } else if (内部処理モード_修正.equals(div.getShoriMode())) {
            return getResponseData_btnSave_修正(div, message);
        } else if (内部処理モード_修正追加.equals(div.getShoriMode())) {
            return getResponseData_btnSave_修正追加(div, 画面入力データ, message);
        } else if (内部処理モード_削除.equals(div.getShoriMode())) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div>
            getResponseData_btnSave_追加(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div,
                    KaigoHokenJigyoHokokuNenpo 画面入力データ, QuestionMessage message) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        if (!handler.is画面詳細エリア入力有(画面入力データ)) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        } else {
            return ResponseData.of(div).addMessage(message).respond();
        }
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> getResponseData_btnSave_修正(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div, QuestionMessage message) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        KaigoHokenJigyoHokokuNenpo 修正データ = handler.get修正データ(get引き継ぎデータ(div));
        if (修正データ != null && !修正データ.get詳細データエリア().isEmpty()) {
            return ResponseData.of(div).addMessage(message).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
    }

    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> getResponseData_btnSave_修正追加(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div, KaigoHokenJigyoHokokuNenpo 画面入力データ, QuestionMessage message) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        if (!handler.is画面詳細エリア入力有(画面入力データ)) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        } else {
            return ResponseData.of(div).addMessage(message).respond();
        }
    }

    /**
     * 「完了する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnComplete(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        return ResponseData.of(div).forwardWithEventName(DBU0050021TransitionEventName.処理完了).respond();
    }

    /**
     * 「報告年度を確定する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnConfirm(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBU0050021ErrorMessages 報告年度必須 = new DBU0050021ErrorMessages(UrErrorMessages.必須, "報告年度");
        messages.add(ValidateChain.validateStart(div).ifNot(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1DivSpec.報告年度必須チェック)
                .thenAdd(報告年度必須).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                報告年度必須, div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM()).build().check(messages));
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).onClick_btnConfirm(get引き継ぎデータ(div));
        return ResponseData.of(div).respond();
    }

    private InsuranceInformation get引き継ぎデータ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        InsuranceInformation 引き継ぎデータ
                = ViewStateHolder.get(TaishokensakuJyouken.ViewStateKey.様式４, InsuranceInformation.class);
        if (null == 引き継ぎデータ) {
            if (div.getDdlShicyoson().isDisplayNone()) {
                引き継ぎデータ = new InsuranceInformation(
                        ADD,
                        LasdecCode.EMPTY,
                        RString.EMPTY);
            } else {
                引き継ぎデータ = new InsuranceInformation(
                        ADD,
                        getHandler(div).get市町村コード(div.getDdlShicyoson().getSelectedKey()),
                        div.getDdlShicyoson().getSelectedValue());
            }
        }
        return 引き継ぎデータ;
    }

    private KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler getHandler(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        return new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler(div);
    }

    private static class DBU0050021ErrorMessages implements IMessageGettable, IValidationMessage {

        private final Message message;

        public DBU0050021ErrorMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

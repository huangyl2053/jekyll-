/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5160001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.DBE5160001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.DBE5160001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.TaishouWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.TaishouWaritsukeDivSpec;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.dgWaritsukeKohoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5160001.TaishouWaritsukeHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会対象者割付クラスです。
 *
 * @reamsid_L DBE-0140-010 liangbc
 */
public class TaishouWaritsuke {

    private static final RString 審査会順番を振りなおす = new RString("btnResetShinsaOrder");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TaishouWaritsukeDiv> onLoad(TaishouWaritsukeDiv div) {
        RString 介護認定審査会番号 = ViewStateHolder.get(ViewStateKeys.介護認定審査会番号, RString.class);
        getHandler(div).initializtion(介護認定審査会番号);
        return ResponseData.of(div).setState(DBE5160001StateName.審査会割付);
    }

    /**
     * 審査会割付で遷移<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TaishouWaritsukeDiv> onStateTransition(TaishouWaritsukeDiv div) {
        if (ResponseHolder.getState().equals(DBE5160001StateName.審査会割付.getName())) {
            getHandler(div).setCommonButtonDisabled();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「簡易割付」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_KanniWaritsuke(TaishouWaritsukeDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            候補者一覧データ空チェック(pairs, div);
            簡易割付人数チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getHandler(div).簡易割付処理();
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("簡易割付")).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「割付」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_Waritsuke(TaishouWaritsukeDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        候補者一覧データ空チェック(pairs, div);
        候補者未選択チェック(pairs, div);
        割付人数チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            for (dgWaritsukeKohoshaIchiran_Row row : div.getDgWaritsukeKohoshaIchiran().getSelectedItems()) {
                if (!getHandler(div).isオブザーバーチェックOK(row)) {
                    return ResponseData.of(div).addMessage(DbeWarningMessages.申請者と介護認定審査会委員に関係.getMessage()).respond();
                }
            }
        }
        if (!ResponseHolder.isReRequest()
                || (new RString(DbeWarningMessages.申請者と介護認定審査会委員に関係.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes))) {
            getHandler(div).割付処理();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「解除」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_BtnWaritsukeKaijo(TaishouWaritsukeDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        対象者一覧データ空チェック(pairs, div);
        対象者未選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).対象者移動();
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会順番を振りなおす」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_BtnResetShinsaOrder(TaishouWaritsukeDiv div) {
        div.getDgTaishoshaIchiran().setSortOrder(RString.EMPTY);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        対象者一覧データ空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).審査会順序を振りなおす();
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会順番を確定する」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_BtnDetermineToShinsakaiOrder(TaishouWaritsukeDiv div) {
        TaishouWaritsukeHandler handler = getHandler(div);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        対象者一覧データ空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            handler.審査会順序確定();
        }
        handler.介護認定審査会割付情報更新();
        handler.対象者一覧検索();
        handler.候補者一覧検索();
        return ResponseData.of(div).respond();
    }

    /**
     * 「登録する」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_BtnRegister(TaishouWaritsukeDiv div) {
        if (is対象者一覧データ空(div)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DBE5160001WarningMessage.対象未選択.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                登録処理(div);
            }
            return ResponseData.of(div).respond();
        } else {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            } else {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
                }
                if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
                    TaishouWaritsukeHandler handler = getHandler(div);
                    handler.介護認定審査会割付情報更新();
                    handler.対象者一覧検索();
                    handler.候補者一覧検索();
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, false);
                }
                return ResponseData.of(div).respond();
            }
        }
    }

    /**
     * 「一覧に戻る」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_BtnBackToIchiran(TaishouWaritsukeDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5160001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「審査会割付を完了する」ボタン押下
     *
     * @param div 介護認定審査会対象者割付
     * @return ResponseData<TaishouWaritsukeDiv>
     */
    public ResponseData<TaishouWaritsukeDiv> onClick_BtnComplete(TaishouWaritsukeDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).介護認定審査会開催予定情報更新(false);
            return ResponseData.of(div).forwardWithEventName(DBE5160001TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private TaishouWaritsukeHandler getHandler(TaishouWaritsukeDiv div) {
        return new TaishouWaritsukeHandler(div);
    }

    private ValidationMessageControlPairs 候補者一覧データ空チェック(ValidationMessageControlPairs pairs, TaishouWaritsukeDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE5160001ErrorMessage 対象データなし = new DBE5160001ErrorMessage(UrErrorMessages.対象データなし_追加メッセージあり, "候補者");
        messages.add(ValidateChain.validateStart(div).ifNot(TaishouWaritsukeDivSpec.候補者一覧データ空チェック)
                .thenAdd(対象データなし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                対象データなし, div.getDgWaritsukeKohoshaIchiran()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 簡易割付人数チェック(ValidationMessageControlPairs pairs, TaishouWaritsukeDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE5160001ErrorMessage 簡易割付不可 = new DBE5160001ErrorMessage(DbeErrorMessages.簡易割付不可);
        messages.add(ValidateChain.validateStart(div).ifNot(TaishouWaritsukeDivSpec.簡易割付人数チェック)
                .thenAdd(簡易割付不可).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                簡易割付不可, div.getBtnJidoWaritsuke()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 候補者未選択チェック(ValidationMessageControlPairs pairs, TaishouWaritsukeDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE5160001ErrorMessage 選択されていない = new DBE5160001ErrorMessage(UrErrorMessages.選択されていない, "候補者");
        messages.add(ValidateChain.validateStart(div).ifNot(TaishouWaritsukeDivSpec.候補者未選択チェック)
                .thenAdd(選択されていない).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                選択されていない, div.getDgWaritsukeKohoshaIchiran()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 対象者一覧データ空チェック(ValidationMessageControlPairs pairs, TaishouWaritsukeDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE5160001ErrorMessage 対象データなし = new DBE5160001ErrorMessage(UrErrorMessages.対象データなし_追加メッセージあり, "対象者");
        messages.add(ValidateChain.validateStart(div).ifNot(TaishouWaritsukeDivSpec.対象者一覧データ空チェック)
                .thenAdd(対象データなし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                対象データなし, div.getDgTaishoshaIchiran()).build().check(messages));
        return pairs;
    }

    private boolean is対象者一覧データ空(TaishouWaritsukeDiv div) {
        return div.getDgTaishoshaIchiran().getDataSource().isEmpty();
    }

    private ValidationMessageControlPairs 対象者未選択チェック(ValidationMessageControlPairs pairs, TaishouWaritsukeDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE5160001ErrorMessage 選択されていない = new DBE5160001ErrorMessage(UrErrorMessages.選択されていない, "対象者");
        messages.add(ValidateChain.validateStart(div).ifNot(TaishouWaritsukeDivSpec.対象者未選択チェック)
                .thenAdd(選択されていない).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                選択されていない, div.getDgTaishoshaIchiran()).build().check(messages));
        return pairs;
    }

    private ValidationMessageControlPairs 割付人数チェック(ValidationMessageControlPairs pairs, TaishouWaritsukeDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE5160001ErrorMessage 割付可能人数は0です_割付不可 = new DBE5160001ErrorMessage(DbeErrorMessages.割付可能人数は0です_割付不可);
        messages.add(ValidateChain.validateStart(div).ifNot(TaishouWaritsukeDivSpec.割付人数チェック)
                .thenAdd(割付可能人数は0です_割付不可).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                割付可能人数は0です_割付不可, div.getBtnWaritsuke()).build().check(messages));
        return pairs;
    }

    private void 登録処理(TaishouWaritsukeDiv div) {
        TaishouWaritsukeHandler handler = getHandler(div);
        handler.介護認定審査会割付情報更新();
        handler.対象者一覧検索();
        handler.候補者一覧検索();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, false);
    }

    private static class DBE5160001ErrorMessage implements IMessageGettable, IValidationMessage {

        private final Message message;

        /**
         * コンストラクト
         *
         * @param message message
         * @param replacements replacements
         */
        public DBE5160001ErrorMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        /**
         * メッセージの取得
         *
         * @return Message
         */
        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static enum DBE5160001WarningMessage implements IMessageGettable {

        対象未選択(0, "対象者が選択されていません。よろしいですか。");

        private final int no;
        private final RString message;

        private DBE5160001WarningMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        /**
         * メッセージの取得
         *
         * @return Message
         */
        @Override
        public Message getMessage() {
            return new WarningMessage(toCode("W", no), this.message.toString());
        }

    }
}

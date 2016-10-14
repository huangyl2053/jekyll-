/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4920001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請連携データ取込のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD_1510-010 liuyl
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler {

    private YogaigoNinteiKekkaRenkeiDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     */
    public YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 取込みファイル内容一覧対象未選択チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 取込みファイル内容一覧対象未選択チェック(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec.取込みファイル内容一覧対象未選択チェック)
                .thenAdd(NoInputMessages.取込みファイル内容一覧対象未選択チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler.NoInputMessages.取込みファイル内容一覧対象未選択チェック,
                div.getDgtorikomidataichiran()).build().check(messages));
        return pairs;
    }

    /**
     * 保険者一致チェック_保険者番号。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保険者一致チェック_保険者番号(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec.保険者一致チェック_保険者番号)
                .thenAdd(NoInputMessages.保険者一致チェック_保険者番号).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler.NoInputMessages.保険者一致チェック_保険者番号,
                div.getDgtorikomidataichiran()).build().check(messages));
        return pairs;
    }

    /**
     * 保険者一致チェック_識別コード。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保険者一致チェック_識別コード(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec.保険者一致チェック_識別コード)
                .thenAdd(NoInputMessages.保険者一致チェック_識別コード).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler.NoInputMessages.保険者一致チェック_識別コード,
                div.getDgtorikomidataichiran()).build().check(messages));
        return pairs;
    }

    /**
     * 日次進捗情報ファイルチェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 日次進捗情報ファイルチェック(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec.ファイルチェック)
                .thenAdd(NoInputMessages.日次進捗情報ファイルチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler.NoInputMessages.日次進捗情報ファイルチェック,
                div.getUploadTool()).build().check(messages));
        return pairs;
    }

    /**
     * 認定結果情報ファイルチェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定結果情報ファイルチェック(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec.ファイルチェック)
                .thenAdd(NoInputMessages.認定結果情報ファイルチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler.NoInputMessages.認定結果情報ファイルチェック,
                div.getUploadTool()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {
        取込みファイル内容一覧対象未選択チェック(UrErrorMessages.選択されていない.getMessage(), "取込みファイル内容一覧対象"),
        保険者一致チェック_保険者番号(UrErrorMessages.不正.getMessage(), "選択されたレコードの保険者番号"),
        保険者一致チェック_識別コード(UrErrorMessages.ファイルREADエラー.getMessage(), "識別コードの混在があります。"),
        日次進捗情報ファイルチェック(UrErrorMessages.不正.getMessage(), "日次進捗情報ファイル"),
        認定結果情報ファイルチェック(UrErrorMessages.不正.getMessage(), "認定結果情報ファイル");
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

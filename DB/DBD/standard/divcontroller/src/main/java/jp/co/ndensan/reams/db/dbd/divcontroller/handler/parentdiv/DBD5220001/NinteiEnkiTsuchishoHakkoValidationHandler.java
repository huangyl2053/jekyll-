/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5220001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001.NinteiEnkiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001.NinteiEnkiTsuchishoHakkoDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定延期通知発行画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public class NinteiEnkiTsuchishoHakkoValidationHandler {

    /**
     * 申請区分の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 申請区分の未入力チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.申請区分の非空チェック)
                .thenAdd(NoInputMessages.申請区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請区分の必須入力, div.getCblShinseiKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 発行有無の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 発行有無の未入力チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.発行有無の非空チェック)
                .thenAdd(NoInputMessages.発行有無の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行有無の必須入力, div.getCblHakkoUmu()).build().check(messages));
        return pairs;
    }

    /**
     * 経過日数の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 経過日数の未入力チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.経過日数の非空チェック)
                .thenAdd(NoInputMessages.経過日数の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.経過日数の必須入力, div.getTxtKeikaNissu()).build().check(messages));
        return pairs;
    }

    /**
     * 経過日数の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 延期決定日の未入力チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.延期決定日の非空チェック)
                .thenAdd(NoInputMessages.延期決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.延期決定日の必須入力, div.getTxtnkiKetteiDate()).build().check(messages));
        return pairs;
    }

    /**
     * 経過日数の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 延期内容_処理見込み日の未入力チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.処理見込み日_開始の非空チェック)
                .thenAdd(NoInputMessages.処理見込み日_開始の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.処理見込み日_開始の必須入力, div.getTxtMikomiDateTsuchisho()).build().check(messages));
        IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
        messages2.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.処理見込み日_終了の非空チェック)
                .thenAdd(NoInputMessages.処理見込み日_終了の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.処理見込み日_終了の必須入力, div.getTxtMikomiDateTsuchisho()).build().check(messages2));
        return pairs;
    }

    /**
     * 経過日数の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 通知書発行日の未入力チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.通知書発行日の非空チェック)
                .thenAdd(NoInputMessages.通知書発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.通知書発行日の必須入力, div.getTxtTsuchishoHakkoDate()).build().check(messages));
        return pairs;
    }

    /**
     * 終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 終了日が開始日以前チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.終了日が開始日以前チェック)
                .thenAdd(NoInputMessages.終了日が開始日以前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.終了日が開始日以前チェック, div.getTxtMikomiDate()).build().check(messages));
        return pairs;
    }

    /**
     * 終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 延期内容_終了日が開始日以前チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.延期内容_終了日が開始日以前チェック)
                .thenAdd(NoInputMessages.終了日が開始日以前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.終了日が開始日以前チェック, div.getTxtMikomiDateTsuchisho()).build().check(messages));
        return pairs;
    }

    /**
     * 終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 発行一覧表_終了日が開始日以前チェック(
            ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NinteiEnkiTsuchishoHakkoDivSpec.発行一覧表_終了日が開始日以前チェック)
                .thenAdd(NoInputMessages.終了日が開始日以前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.終了日が開始日以前チェック, div.getTxtMikomiDateIchiran()).build().check(messages));
        return pairs;
    }

    /**
     * 終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象行を選択チェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.対象行を選択チェック)
                .thenAdd(NoInputMessages.対象行を選択チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象行を選択チェック, div.getDgHakkotaishosha()).build().check(messages));
        return pairs;
    }

    /**
     * 終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新対象のデータがないチェック(ValidationMessageControlPairs pairs, NinteiEnkiTsuchishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiEnkiTsuchishoHakkoDivSpec.更新対象のデータがないチェック)
                .thenAdd(NoInputMessages.更新対象のデータがないチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.更新対象のデータがないチェック, div.getDgHakkotaishosha()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        申請区分の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "申請区分"),
        発行有無の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "発行有無"),
        経過日数の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "経過日数"),
        延期決定日の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "延期決定日"),
        処理見込み日_開始の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "処理見込み日（開始）"),
        処理見込み日_終了の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "処理見込み日（終了）"),
        通知書発行日の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "通知書発行日"),
        終了日が開始日以前チェック(UrErrorMessages.終了日が開始日以前.getMessage()),
        対象行を選択チェック(UrErrorMessages.対象行を選択.getMessage()),
        更新対象のデータがないチェック(UrErrorMessages.更新対象のデータがない.getMessage());
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

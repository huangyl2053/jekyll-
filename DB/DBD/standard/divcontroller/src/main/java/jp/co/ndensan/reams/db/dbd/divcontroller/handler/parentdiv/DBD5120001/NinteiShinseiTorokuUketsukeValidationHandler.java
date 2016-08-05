/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請受付画面画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeValidationHandler {

    /**
     * 開始日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor開始日の必須入力(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.開始日が未入力チェック)
                .thenAdd(NoInputMessages.開始日が未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.開始日が未入力チェック, div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 開始日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor終了日の必須入力(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.終了日が未入力チェック)
                .thenAdd(NoInputMessages.終了日が未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.終了日が未入力チェック, div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 申請日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請日の必須入力(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.申請日が未入力チェック)
                .thenAdd(NoInputMessages.申請日が未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請日が未入力チェック, div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 要介護度の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor要介護度の必須入力(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.要介護度が未入力チェック)
                .thenAdd(NoInputMessages.要介護度が未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.要介護度が未入力チェック, div.getCcdNinteiInput().getNinteiJoho().getTxtYokaigodoCode()).build().check(messages));
        return pairs;
    }

    /**
     * 喪失日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor喪失日の必須入力(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.喪失日が未入力チェック)
                .thenAdd(NoInputMessages.喪失日が未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.喪失日が未入力チェック, div.getCcdShinseiSonotaJohoInput().getTxtSoshitsuDay()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        開始日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "開始日"),
        終了日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "終了日"),
        申請日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "申請日"),
        要介護度が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "要介護度"),
        喪失日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "喪失日"),
        有効期限の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "有効期限"),
        給付率の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "給付率"),
        減免減額_給付率範囲外(DbdErrorMessages.減免減額_給付率範囲外),
        減免減額_適用日が法施行前(DbdErrorMessages.減免減額_適用日が法施行前),
        減免減額_有効期限が年度外(DbdErrorMessages.減免減額_有効期限が年度外),
        減免減額_有効期限が適用日以前(DbdErrorMessages.減免減額_有効期限が適用日以前),
        受給共通_受給者_事業対象者登録なし(DbdErrorMessages.受給共通_受給者_事業対象者登録なし),
        減免減額_適用期間重複(DbdErrorMessages.減免減額_適用期間重複);

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

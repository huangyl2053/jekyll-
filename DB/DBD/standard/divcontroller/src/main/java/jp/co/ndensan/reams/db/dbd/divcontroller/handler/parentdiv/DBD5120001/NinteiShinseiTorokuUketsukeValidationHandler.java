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
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
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

    /**
     * 被保険者台帳に該当なしチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor被保険者台帳に該当なし(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.被保険者台帳に該当なしチェック)
                .thenAdd(NoInputMessages.被保険者台帳に該当なしチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.喪失日が未入力チェック).build().check(messages));
        return pairs;
    }

    /**
     * 開始日と終了日の前後順チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor開始日と終了日の前後順(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.開始日と終了日の前後順チェック)
                .thenAdd(NoInputMessages.開始日と終了日の前後順チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.喪失日が未入力チェック,
                div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD(),
                div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期間が重複チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor有効期間が重複(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.有効期間が重複チェック)
                .thenAdd(NoInputMessages.有効期間が重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期間が重複チェック,
                div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD(),
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo()).build().check(messages));
        return pairs;
    }

    /**
     * 有効認定期間の重複チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor有効認定期間の重複(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.有効認定期間の重複チェック)
                .thenAdd(NoInputMessages.有効認定期間の重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効認定期間の重複チェック).build().check(messages));
        return pairs;
    }

    /**
     * 医療保険情報なしチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor医療保険情報なし(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.医療保険情報なしチェック)
                .thenAdd(NoInputMessages.医療保険情報なしチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.医療保険情報なしチェック).build().check(messages));
        return pairs;
    }

    /**
     * 特定疾病なしチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特定疾病なし(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.特定疾病なしチェック)
                .thenAdd(NoInputMessages.特定疾病なしチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.特定疾病なしチェック).build().check(messages));
        return pairs;
    }

    /**
     * _６０日以前の申請チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor６０日以前の申請(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec._６０日以前の申請チェック)
                .thenAdd(NoInputMessages._６０日以前の申請チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages._６０日以前の申請チェック,
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD(),
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo()).build().check(messages));
        return pairs;
    }

    /**
     * 変更元が_要支援チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor変更元が_要支援(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.変更元が_要支援チェック)
                .thenAdd(NoInputMessages.変更元が_要支援チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.変更元が_要支援チェック).build().check(messages));
        return pairs;
    }

    /**
     * 変更元が_自立チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor変更元が_自立(ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.変更元が_自立チェック)
                .thenAdd(NoInputMessages.変更元が_自立チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.変更元が_自立チェック).build().check(messages));
        return pairs;
    }

    /**
     * 変更元が_自立チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor職権取消_記載_修正_変更申請中のデータあり(
            ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.職権取消_記載_修正_変更申請中のデータありチェック)
                .thenAdd(NoInputMessages.職権取消_記載_修正_変更申請中のデータありチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.職権取消_記載_修正_変更申請中のデータありチェック).build().check(messages));
        return pairs;
    }

    /**
     * 削除回復の対象ではないチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor削除回復の対象ではない(
            ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.削除回復の対象ではないチェック)
                .thenAdd(NoInputMessages.削除回復の対象ではないチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.削除回復の対象ではないチェック).build().check(messages));
        return pairs;
    }

    /**
     * 旧措置者ではなく_自立チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor旧措置者ではなく_自立(
            ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.削除回復の対象ではないチェック)
                .thenAdd(NoInputMessages.旧措置者ではなく_自立チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.旧措置者ではなく_自立チェック, div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo()).build().check(messages));
        return pairs;
    }

    /**
     * 旧措置者ではなく_自立で有効期間記入ありチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor旧措置者ではなく_自立で有効期間記入あり(
            ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.旧措置者ではなく_自立で有効期間記入ありチェック)
                .thenAdd(NoInputMessages.旧措置者ではなく_自立で有効期間記入ありチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.旧措置者ではなく_自立で有効期間記入ありチェック,
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo()).build().check(messages));
        return pairs;
    }

    /**
     * 自立_かつサービス指定ありチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor自立_かつサービス指定あり(
            ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.自立_かつサービス指定ありチェック)
                .thenAdd(NoInputMessages.自立_かつサービス指定ありチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.自立_かつサービス指定ありチェック,
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo()).build().check(messages));
        return pairs;
    }

    /**
     * 却下かつ_自立で異動理由ありチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor却下かつ_自立で異動理由あり(
            ValidationMessageControlPairs pairs, NinteiShinseiTorokuUketsukeDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteiShinseiTorokuUketsukeDivSpec.却下かつ_自立で異動理由ありチェック)
                .thenAdd(NoInputMessages.却下かつ_自立で異動理由ありチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.却下かつ_自立で異動理由ありチェック,
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        開始日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "開始日"),
        終了日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "終了日"),
        申請日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "申請日"),
        要介護度が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "要介護度"),
        喪失日が未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "喪失日"),
        被保険者台帳に該当なしチェック(UrErrorMessages.対象データなし_追加メッセージあり, "被保険者情報"),
        開始日と終了日の前後順チェック(UrWarningMessages.日付の前後関係逆転以降, "開始日", "終了日"),
        有効期間が重複チェック(UrErrorMessages.期間が重複),
        有効認定期間の重複チェック(UrErrorMessages.期間が重複),
        医療保険情報なしチェック(DbdErrorMessages._2号医療保険なし),
        特定疾病なしチェック(DbdErrorMessages._2号特定疾病なし),
        _６０日以前の申請チェック(UrWarningMessages.日付の前後関係逆転以降, "申請日"),
        変更元が_要支援チェック(UrErrorMessages.項目に対する制約, "要介護度変更申請", "要介護1～5間での変更"),
        変更元が_自立チェック(UrErrorMessages.項目に対する制約, "要介護度変更申請", "要支援1～2間での変更"),
        職権取消_記載_修正_変更申請中のデータありチェック(UrErrorMessages.既に存在, "変更申請中のデータ"),
        削除回復の対象ではないチェック(UrErrorMessages.対象データなし_追加メッセージあり, "削除回復対象"),
        旧措置者ではなく_自立チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "旧措置者以外の自立"),
        旧措置者ではなく_自立で有効期間記入ありチェック(UrErrorMessages.入力値が不正_追加メッセージあり, "旧措置でない「自立」かつ有効期間の記入あり"),
        自立_かつサービス指定ありチェック(UrErrorMessages.入力値が不正_追加メッセージあり, "要介護区分が「自立」かつサービス指定あり"),
        却下かつ_自立で異動理由ありチェック(UrErrorMessages.両方の指定は不可, "却下かつ自立", "異動理由が存在"),
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

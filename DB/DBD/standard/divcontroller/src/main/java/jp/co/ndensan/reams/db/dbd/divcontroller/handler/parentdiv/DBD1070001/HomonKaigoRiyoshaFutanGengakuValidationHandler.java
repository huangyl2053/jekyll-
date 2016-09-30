/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.HomonKaigoRiyoshaFutanGengakuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.HomonKaigoRiyoshaFutanGengakuSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 訪問介護利用者負担額減額申請のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3730-010 wangjie2
 */
public class HomonKaigoRiyoshaFutanGengakuValidationHandler {

    /**
     * 申請日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 申請日の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.申請日の非空チェック)
                .thenAdd(NoInputMessages.申請日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請日の必須入力, div.getTxtShinseiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 決定区分の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 決定区分の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.決定区分の非空チェック)
                .thenAdd(NoInputMessages.決定区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定区分の必須入力, div.getDdlKettaiKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 決定日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 決定日の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.決定日の非空チェック)
                .thenAdd(NoInputMessages.決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日の必須入力, div.getTxtKettaiYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 適用日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 適用日の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.適用日の非空チェック)
                .thenAdd(NoInputMessages.適用日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.適用日の必須入力, div.getTxtTekiyoYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期限の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 有効期限の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.有効期限の非空チェック)
                .thenAdd(NoInputMessages.有効期限の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期限の必須入力, div.getTxtYukoKigen()).build().check(messages));
        return pairs;
    }

    /**
     * 給付率の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 給付率の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.給付率の非空チェック)
                .thenAdd(NoInputMessages.給付率の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.給付率の必須入力, div.getTxtKyufuRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 公費受給者番号の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 公費受給者番号の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.公費受給者番号の非空チェック)
                .thenAdd(NoInputMessages.公費受給者番号の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.公費受給者番号の必須入力, div.getTxtKohiJyukyshaNo()).build().check(messages));
        return pairs;
    }

    /**
     * 法別区分の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 法別区分の未入力チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HomonKaigoRiyoshaFutanGengakuSpec.法別区分の非空チェック)
                .thenAdd(NoInputMessages.法別区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.法別区分の必須入力, div.getDdlHobetsuKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 訪問介護利用者負担額減額_給付率範囲外チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 訪問介護利用者負担額減額_給付率範囲外チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuSpec.訪問介護利用者負担額減額_給付率範囲外チェック)
                .thenAdd(NoInputMessages.訪問介護利用者負担額減額_給付率範囲外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.訪問介護利用者負担額減額_給付率範囲外, div.getTxtKyufuRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 訪問介護利用者負担額減額_適用開始日が法施行以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 訪問介護利用者負担額減額_適用開始日が法施行以前チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuSpec.訪問介護利用者負担額減額_適用開始日が法施行以前チェック)
                .thenAdd(NoInputMessages.訪問介護利用者負担額減額_適用開始日が法施行以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.訪問介護利用者負担額減額_適用開始日が法施行以前, div.getTxtKyufuRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 訪問介護利用者負担額減額_適用終了日が年度外チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 訪問介護利用者負担額減額_適用終了日が年度外チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuSpec.訪問介護利用者負担額減額_適用終了日が年度外チェック)
                .thenAdd(NoInputMessages.訪問介護利用者負担額減額_適用終了日が年度外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.訪問介護利用者負担額減額_適用終了日が年度外,
                div.getTxtTekiyoYmd(), div.getTxtYukoKigen()).build().check(messages));
        return pairs;
    }

    /**
     * 訪問介護利用者負担額減額_適用終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 訪問介護利用者負担額減額_適用終了日が開始日以前チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuSpec.訪問介護利用者負担額減額_適用終了日が開始日以前チェック)
                .thenAdd(NoInputMessages.訪問介護利用者負担額減額_適用終了日が開始日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.訪問介護利用者負担額減額_適用終了日が開始日以前,
                div.getTxtTekiyoYmd(), div.getTxtYukoKigen()).build().check(messages));
        return pairs;
    }

    /**
     * 訪問介護利用者負担額減額_適用終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 受給共通_受給者登録なしチェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuSpec.受給共通_受給者登録なしチェック)
                .thenAdd(NoInputMessages.受給共通_受給者_事業対象者登録なし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.受給共通_受給者_事業対象者登録なし, div.getTxtTekiyoYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 訪問介護利用者負担額減額_適用終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 減免減額_適用期間重複チェック(
            ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuSpec.減免減額_適用期間重複チェック)
                .thenAdd(NoInputMessages.減免減額_適用期間重複).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_適用期間重複, div.getDgShinseiList()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        申請日の必須入力(UrErrorMessages.必須.getMessage(), "申請日"),
        法別区分の必須入力(UrErrorMessages.必須.getMessage(), "法別区分"),
        給付率の必須入力(UrErrorMessages.必須.getMessage(), "給付率"),
        決定区分の必須入力(UrErrorMessages.必須.getMessage(), "決定区分"),
        決定日の必須入力(UrErrorMessages.必須.getMessage(), "決定日"),
        適用日の必須入力(UrErrorMessages.必須.getMessage(), "適用日"),
        有効期限の必須入力(UrErrorMessages.必須.getMessage(), "有効期限"),
        公費受給者番号の必須入力(UrErrorMessages.必須.getMessage(), "公費受給者番号"),
        訪問介護利用者負担額減額_給付率範囲外(DbdErrorMessages.減免減額_給付率範囲外.getMessage()),
        訪問介護利用者負担額減額_適用開始日が法施行以前(DbdErrorMessages.減免減額_適用日が法施行前.getMessage()),
        訪問介護利用者負担額減額_適用終了日が年度外(DbdErrorMessages.減免減額_有効期限が年度外.getMessage()),
        訪問介護利用者負担額減額_適用終了日が開始日以前(DbdErrorMessages.減免減額_有効期限が適用日以前.getMessage()),
        受給共通_受給者_事業対象者登録なし(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage()),
        減免減額_適用期間重複(DbdErrorMessages.減免減額_適用期間重複.getMessage());
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

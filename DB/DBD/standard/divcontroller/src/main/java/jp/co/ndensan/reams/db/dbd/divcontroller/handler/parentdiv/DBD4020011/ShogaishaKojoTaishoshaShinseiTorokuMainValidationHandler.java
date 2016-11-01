/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4020011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 障がい者控除対象者申請登録のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler {

    /**
     * 申請日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 申請日の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.申請日の非空チェック)
                .thenAdd(NoInputMessages.申請日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請日の必須入力, div.getTxtShinseiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 決定日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 決定日の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.決定日の非空チェック)
                .thenAdd(NoInputMessages.決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日の必須入力, div.getTxtKettaiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 対象年度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象年度の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.対象年度の非空チェック)
                .thenAdd(NoInputMessages.対象年度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象年度の必須入力, div.getTxtTaishoNendo()).build().check(messages));
        return pairs;
    }

    /**
     * 認知証高齢者自立度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認知証高齢者自立度の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.認知証高齢者自立度の非空チェック)
                .thenAdd(NoInputMessages.認知証高齢者自立度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.認知証高齢者自立度の必須入力, div.getDdlNinchishoKoreishaJiritsudo()).build().check(messages));
        return pairs;
    }

    /**
     * 障がい高齢者自立度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 障がい高齢者自立度の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.障がい高齢者自立度の非空チェック)
                .thenAdd(NoInputMessages.障がい高齢者自立度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.障がい高齢者自立度の必須入力, div.getDdlShogaiKoreishaJiritsudo()).build().check(messages));
        return pairs;
    }

    /**
     * 認定区分の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定区分の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.認定区分の非空チェック)
                .thenAdd(NoInputMessages.認定区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.認定区分の必須入力, div.getDdlNinteiKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 認定内容の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定内容の未入力チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.認定内容の非空チェック)
                .thenAdd(NoInputMessages.認定内容の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.認定内容の必須入力, div.getDdlNinteiNaiyo()).build().check(messages));
        return pairs;
    }

    /**
     * 対象年度重複チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象年度重複チェック(
            ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec.対象年度重複チェック)
                .thenAdd(NoInputMessages.対象年度重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象年度重複チェック, div.getDgShinseiList()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        申請日の必須入力(UrErrorMessages.必須.getMessage(), "申請日"),
        対象年度の必須入力(UrErrorMessages.必須.getMessage(), "対象年度"),
        決定日の必須入力(UrErrorMessages.必須.getMessage(), "決定日"),
        認知証高齢者自立度の必須入力(UrErrorMessages.必須.getMessage(), "認知証高齢者自立度"),
        障がい高齢者自立度の必須入力(UrErrorMessages.必須.getMessage(), "障がい高齢者自立度"),
        認定区分の必須入力(UrErrorMessages.必須.getMessage(), "認定区分"),
        認定内容の必須入力(UrErrorMessages.必須.getMessage(), "認定内容"),
        対象年度重複チェック(UrErrorMessages.既に登録済.getMessage(), "対象年度");
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

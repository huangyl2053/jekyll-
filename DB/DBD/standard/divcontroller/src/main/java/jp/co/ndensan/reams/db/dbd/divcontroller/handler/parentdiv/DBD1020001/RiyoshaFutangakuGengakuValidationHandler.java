/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.RiyoshaFutangakuGengakuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.RiyoshaFutangakuGengakuPanelDivSpec;
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
 * 利用者負担額減額申請のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3600-010 xuyue
 */
public class RiyoshaFutangakuGengakuValidationHandler {

    /**
     * 申請日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請日の必須入力(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.申請日の非空チェック)
                .thenAdd(NoInputMessages.申請日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請日の必須入力, div.getTxtShinseiYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 決定区分の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor決定区分の必須入力(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.決定区分の非空チェック)
                .thenAdd(NoInputMessages.決定区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定区分の必須入力, div.getRadKetteiKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 決定日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor決定日の必須入力(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.決定日の非空チェック)
                .thenAdd(NoInputMessages.決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日の必須入力, div.getTxtKettaiYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 適用日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用日の必須入力(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.適用日の非空チェック)
                .thenAdd(NoInputMessages.適用日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.適用日の必須入力, div.getTxtTekiyoYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期限の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor有効期限の必須入力(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.有効期限の非空チェック)
                .thenAdd(NoInputMessages.有効期限の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期限の必須入力, div.getTxtYukoKigenYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 給付率の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor給付率の必須入力(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.給付率の非空チェック)
                .thenAdd(NoInputMessages.給付率の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.給付率の必須入力, div.getTxtKyufuRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 減免減額_給付率範囲外チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減免減額_給付率範囲外(ValidationMessageControlPairs pairs, RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.減免減額_給付率範囲外のチェック)
                .thenAdd(NoInputMessages.減免減額_給付率範囲外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_給付率範囲外, div.getTxtKyufuRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 利用者負担額減額_適用開始日が法施行以前のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor利用者負担額減額_適用開始日が法施行以前(ValidationMessageControlPairs pairs,
            RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.利用者負担額減額_適用開始日が法施行以前のチェック)
                .thenAdd(NoInputMessages.減免減額_適用日が法施行前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_適用日が法施行前, div.getTxtTekiyoYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 利用者負担額減額_適用終了日が年度外のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor利用者負担額減額_適用終了日が年度外(ValidationMessageControlPairs pairs,
            RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.利用者負担額減額_適用終了日が年度外のチェック)
                .thenAdd(NoInputMessages.減免減額_有効期限が年度外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_有効期限が年度外, div.getTxtYukoKigenYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 利用者負担額減額_適用終了日が開始日以前のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor利用者負担額減額_適用終了日が開始日以前(ValidationMessageControlPairs pairs,
            RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.利用者負担額減額_適用終了日が開始日以前のチェック)
                .thenAdd(NoInputMessages.減免減額_有効期限が適用日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_有効期限が適用日以前, div.getTxtYukoKigenYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 受給共通_受給者登録なしのチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor受給共通_受給者登録なし(ValidationMessageControlPairs pairs,
            RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.受給共通_受給者登録なしのチェック)
                .thenAdd(NoInputMessages.受給共通_受給者_事業対象者登録なし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.受給共通_受給者_事業対象者登録なし, div.getTxtTekiyoYmd()).build().check(messages));
        return pairs;
    }

    /**
     * 適用期間重複なしのチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間重複なし(ValidationMessageControlPairs pairs,
            RiyoshaFutangakuGengakuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RiyoshaFutangakuGengakuPanelDivSpec.適用期間重複なしのチェック)
                .thenAdd(NoInputMessages.減免減額_適用期間重複).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_適用期間重複, div.getRiyoshaFutangakuGengakuShinseiList().getDdlShinseiIchiran()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        申請日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "申請日"),
        決定区分の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "決定区分"),
        決定日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "決定日"),
        適用日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "適用日"),
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go;

import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】1号給付額減額ダイアログのValidationHandler。
 *
 * @reamsid_L DBD-0620-043 panxiaobo
 */
public class KyufuGengaku1GoValidationHandler {

    private final RString 減額免除申請 = new RString("減額免除申請");
    private final RString 給付額減額 = new RString("給付額減額");

    /**
     * 1号給付額減額ダイアログの滞納状況情報チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuGengaku1GoDiv
     * @param shiharaiHohoHenko 支払方法変更管理業務概念
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor滞納状況情報(ValidationMessageControlPairs pairs, KyufuGengaku1GoDiv div, ShiharaiHohoHenko shiharaiHohoHenko) {
        if ((div.getKey_Button().equals(給付額減額))
                && (shiharaiHohoHenko.getShiharaiHohoHenkoTainoList().isEmpty() || div.getTainoHanteiKekka().isEmpty())) {
            pairs.add(new ValidationMessageControlPair(KyufuGengaku1GoValidationHandler.KyufuGengaku1GoMessages.支払方法変更_要滞納状況確定));
        }
        return pairs;
    }

    /**
     * 1号給付額減額ダイアログの適用期間チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuGengaku1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額適用期間チェック(ValidationMessageControlPairs pairs, KyufuGengaku1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(給付額減額)) {
            messages.add(ValidateChain.validateStart(div).ifNot(KyufuGengaku1GoDivSpec.減額適用期間チェック)
                    .thenAdd(KyufuGengaku1GoMessages.期間が不正_追加メッセージあり2).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    KyufuGengaku1GoMessages.期間が不正_追加メッセージあり2,
                    div.getTxtKonkaiKikanKaishiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号給付額減額ダイアログの減額適用期間終了未入力未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuGengaku1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額適用期間終了入力チェック(ValidationMessageControlPairs pairs, KyufuGengaku1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(減額免除申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(KyufuGengaku1GoDivSpec.減額適用期間終了未入力)
                    .thenAdd(KyufuGengaku1GoMessages.減額適用期間終了未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    KyufuGengaku1GoMessages.減額適用期間終了未入力,
                    div.getTxtGengakuTekiyoKikanShuryoYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号給付額減額ダイアログの申請理由未選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuGengaku1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請理由未選択チェック(ValidationMessageControlPairs pairs, KyufuGengaku1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(減額免除申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(KyufuGengaku1GoDivSpec.申請理由未選択)
                    .thenAdd(KyufuGengaku1GoMessages.申請理由未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    KyufuGengaku1GoMessages.申請理由未選択,
                    div.getDdlIMenjoShinseiRiyu()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号給付額減額ダイアログの減額適用期間2チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuGengaku1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額適用期間2チェック(ValidationMessageControlPairs pairs, KyufuGengaku1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(減額免除申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(KyufuGengaku1GoDivSpec.減額適用期間2チェック)
                    .thenAdd(KyufuGengaku1GoMessages.期間が不正_追加メッセージあり2).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    KyufuGengaku1GoMessages.期間が不正_追加メッセージあり2,
                    div.getTxtGengakuTekiyoKikanKaishiYMD()).build().check(messages));
        }
        return pairs;
    }

    private static enum KyufuGengaku1GoMessages implements IValidationMessage {

        支払方法変更_要滞納状況確定(DbdErrorMessages.支払方法変更_要滞納状況確定),
        期間が不正_追加メッセージあり2(UrErrorMessages.期間が不正_追加メッセージあり２, "減額適用期間(開始)", "減額適用期間(終了)"),
        減額適用期間終了未入力(UrErrorMessages.未入力, "減額適用期間終了"),
        申請理由未選択(UrErrorMessages.選択されていない, "申請理由");
        private final Message message;

        private KyufuGengaku1GoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002.ShiharaiHenkoTsuchiHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002.ShiharaiHenkoTsuchiHakkoDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 支払方法変更管理各種通知書発行のValidationHandlerクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class ShiharaiHenkoTsuchiHakkoValidationHandler {

    /**
     * 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor予告発行日(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShiharaiHenkoTsuchiHakkoDivSpec.予告発行日の必須入力)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getYokokuTsuchisho().getTxtYokokuTsuchishoHakkoDate()).
                build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、文書番号は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor予告文書番号(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {
        if (div.getCcdYokokuTsuchishoBunshoNo().get文書番号().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.文書番号の必須入力));
        }
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor変更発行日(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShiharaiHenkoTsuchiHakkoDivSpec.変更発行日の必須入力)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getHenkoTsuchisho().getTxtHenkoTsuchishoHakkoDate()).
                build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、文書番号は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor変更文書番号(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        if (div.getCcdHenkoTsuchishoBunshoNo().get文書番号().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.文書番号の必須入力));
        }
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor控除発行日(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShiharaiHenkoTsuchiHakkoDivSpec.控除発行日の必須入力)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getKojoTsuchisho().getTxtKojoTsuchishoHakkoDate()).
                build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、文書番号は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor控除文書番号(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        if (div.getCcdKojoTsuchishoBunshoNo().get文書番号().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.文書番号の必須入力));
        }
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor差止発行日(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShiharaiHenkoTsuchiHakkoDivSpec.差止発行日の必須入力)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getSashitomeTsuchisho().getTxtSashitomeTsuchishoHakkoDate()).
                build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、文書番号は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor差止文書番号(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        if (div.getCcdSashitomeTsuchishoBunshoNo().get文書番号().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.文書番号の必須入力));
        }
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額発行日(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShiharaiHenkoTsuchiHakkoDivSpec.減額発行日の必須入力)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getGengakuTsuchisho().getTxtGengakuTsuchishoHakkoDate()).
                build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、文書番号は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額文書番号(ValidationMessageControlPairs pairs,
            ShiharaiHenkoTsuchiHakkoDiv div) {

        if (div.getCcdGengakuTsuchishoBunshoNo().get文書番号().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.文書番号の必須入力));
        }
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        発行日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "発行日"),
        文書番号の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "文書番号");
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

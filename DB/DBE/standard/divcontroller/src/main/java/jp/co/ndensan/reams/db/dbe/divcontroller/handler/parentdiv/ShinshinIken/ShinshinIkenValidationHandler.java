/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken.ShinshinIkenDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 心身の意見入力のチェック処理クラスです。
 *
 * @reamsid_L DBE-3000-120 dongyabin
 */
public class ShinshinIkenValidationHandler {

    private final ShinshinIkenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShinshinIkenValidationHandler(ShinshinIkenDiv div) {
        this.div = div;
    }

    /**
     * 確定ンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(validateIro());
        return validPairs;
    }

    private ValidationMessageControlPairs validateIro() {
        IValidationMessages messages = new ControlValidator(div).validate1();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShinshinIkenValidationMessage.認知症周辺症状詳細, div.getNinchishoShuhenShojo())
                .add(ShinshinIkenValidationMessage.認知症周辺症状詳細その他, div.getNinchishoShuhenShojo().getTxtSonotaKinyu())
                .add(ShinshinIkenValidationMessage.その他の症状名, div.getSonotaShojo().getTxtShojomei())
                .add(ShinshinIkenValidationMessage.専門医受診詳細事項, div.getSonotaShojo().getTxtShosaiTokkiJiko())
                .add(ShinshinIkenValidationMessage.四肢欠損部位, div.getKaradaJotai().getTxtShishiKessonBui())
                .add(ShinshinIkenValidationMessage.麻痺部位, div.getKaradaJotai().getChkMigiJoshiMahi())
                .add(ShinshinIkenValidationMessage.麻痺部位, div.getKaradaJotai().getChkMigiKashiMahi())
                .add(ShinshinIkenValidationMessage.麻痺部位, div.getKaradaJotai().getChkHidariJoshiMahi())
                .add(ShinshinIkenValidationMessage.麻痺部位, div.getKaradaJotai().getChkHidariKashiMahi())
                .add(ShinshinIkenValidationMessage.麻痺部位, div.getKaradaJotai().getChkSonotaMahi())
                .add(ShinshinIkenValidationMessage.右上肢麻痺程度, div.getKaradaJotai().getRadMigiJoshiMahiTeido())
                .add(ShinshinIkenValidationMessage.右下肢麻痺程度, div.getKaradaJotai().getRadMigiKashiMahiTeido())
                .add(ShinshinIkenValidationMessage.左上肢麻痺程度, div.getKaradaJotai().getRadHidariJoshiMahiTeido())
                .add(ShinshinIkenValidationMessage.左下肢麻痺程度, div.getKaradaJotai().getRadHidariKashiMahiTeido())
                .add(ShinshinIkenValidationMessage.その他部位麻痺程度, div.getKaradaJotai().getRadSonotaMahiTeido())
                .add(ShinshinIkenValidationMessage.その他部位, div.getKaradaJotai().getTxtSonotaMahiBui())
                .add(ShinshinIkenValidationMessage.筋力の低下部位, div.getKaradaJotai().getTxtKinryokuTeikaBui())
                .add(ShinshinIkenValidationMessage.筋力の低下程度, div.getKaradaJotai().getRadKinryokuTeikaTeido())
                .add(ShinshinIkenValidationMessage.関節の拘縮部位, div.getKaradaJotai().getTxtKansetsuKoshukuBui())
                .add(ShinshinIkenValidationMessage.関節の拘縮程度, div.getKaradaJotai().getRadKansetsuKoshukuTeido())
                .add(ShinshinIkenValidationMessage.関節の痛み部位, div.getKaradaJotai().getTxtKansetsuItamiBui())
                .add(ShinshinIkenValidationMessage.関節の痛み程度, div.getKaradaJotai().getRadKansetsuItamiTeido())
                .add(ShinshinIkenValidationMessage.失調不随意運動詳細部位, div.getKaradaJotai().getChkFuzuiiJoshi())
                .add(ShinshinIkenValidationMessage.失調不随意運動詳細部位, div.getKaradaJotai().getChkFuzuiiKashi())
                .add(ShinshinIkenValidationMessage.失調不随意運動詳細部位, div.getKaradaJotai().getChkTaikan())
                .add(ShinshinIkenValidationMessage.褥瘡部位, div.getKaradaJotai().getTxtJokusoBui())
                .add(ShinshinIkenValidationMessage.褥瘡程度, div.getKaradaJotai().getRadJokusoTeido())
                .add(ShinshinIkenValidationMessage.その他の皮膚疾患部位, div.getKaradaJotai().getTxtSonotaHifuShikkanBui())
                .add(ShinshinIkenValidationMessage.その他の皮膚疾患程度, div.getKaradaJotai().getRadSonotaHifuShikkanTeido())
                .build();
    }

    private static enum ShinshinIkenValidationMessage implements IValidationMessage {

        認知症周辺症状詳細(UrErrorMessages.必須項目_追加メッセージあり, "認知症周辺症状詳細"),
        認知症周辺症状詳細その他(UrErrorMessages.未入力, "認知症周辺症状におけるその他の症状"),
        その他の症状名(UrErrorMessages.必須項目_追加メッセージあり, "その他の症状名"),
        専門医受診詳細事項(UrErrorMessages.必須項目_追加メッセージあり, "専門医受診詳細事項"),
        四肢欠損部位(UrErrorMessages.必須項目_追加メッセージあり, "四肢欠損部位"),
        麻痺部位(UrErrorMessages.必須項目_追加メッセージあり, "麻痺部位"),
        右上肢麻痺程度(UrErrorMessages.必須項目_追加メッセージあり, "右上肢麻痺程度"),
        右下肢麻痺程度(UrErrorMessages.必須項目_追加メッセージあり, "右下肢麻痺程度"),
        左上肢麻痺程度(UrErrorMessages.必須項目_追加メッセージあり, "左上肢麻痺程度"),
        左下肢麻痺程度(UrErrorMessages.必須項目_追加メッセージあり, "左下肢麻痺程度"),
        その他部位麻痺程度(UrErrorMessages.必須項目_追加メッセージあり, "その他部位麻痺程度"),
        その他部位(DbzErrorMessages.必須項目_追加メッセージあり, "その他部位"),
        筋力の低下部位(DbzErrorMessages.必須項目_追加メッセージあり, "筋力の低下部位"),
        筋力の低下程度(DbzErrorMessages.必須項目_追加メッセージあり, "筋力の低下程度"),
        関節の拘縮部位(UrErrorMessages.必須項目_追加メッセージあり, "関節の拘縮部位"),
        関節の拘縮程度(UrErrorMessages.必須項目_追加メッセージあり, "関節の拘縮程度"),
        関節の痛み部位(UrErrorMessages.必須項目_追加メッセージあり, "関節の痛み部位"),
        関節の痛み程度(UrErrorMessages.必須項目_追加メッセージあり, "関節の痛み程度"),
        失調不随意運動詳細部位(UrErrorMessages.必須項目_追加メッセージあり, "失調・不随意運動詳細部位"),
        褥瘡部位(UrErrorMessages.必須項目_追加メッセージあり, "褥瘡部位"),
        褥瘡程度(UrErrorMessages.必須項目_追加メッセージあり, "褥瘡程度"),
        その他の皮膚疾患部位(UrErrorMessages.必須項目_追加メッセージあり, "その他の皮膚疾患部位"),
        その他の皮膚疾患程度(UrErrorMessages.必須項目_追加メッセージあり, "その他の皮膚疾患程度");

        private final Message message;

        private ShinshinIkenValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static class ControlValidator {

        private final ShinshinIkenDiv div;

        public ControlValidator(ShinshinIkenDiv div) {
            this.div = div;
        }

        public IValidationMessages validate1() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShinshinIkenSpec.認知症周辺症状詳細チェック)
                    .thenAdd(ShinshinIkenValidationMessage.認知症周辺症状詳細)
                    .ifNot(ShinshinIkenSpec.認知症周辺症状詳細その他入力チェック)
                    .thenAdd(ShinshinIkenValidationMessage.認知症周辺症状詳細その他)
                    .ifNot(ShinshinIkenSpec.その他の症状名チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他の症状名)
                    .ifNot(ShinshinIkenSpec.専門医受診詳細事項チェック)
                    .thenAdd(ShinshinIkenValidationMessage.専門医受診詳細事項)
                    .ifNot(ShinshinIkenSpec.四肢欠損部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.四肢欠損部位)
                    .ifNot(ShinshinIkenSpec.麻痺チェック)
                    .thenAdd(ShinshinIkenValidationMessage.麻痺部位)
                    .ifNot(ShinshinIkenSpec.麻痺右上肢程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.右上肢麻痺程度)
                    .ifNot(ShinshinIkenSpec.麻痺右下肢程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.右下肢麻痺程度)
                    .ifNot(ShinshinIkenSpec.麻痺左上肢程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.左上肢麻痺程度)
                    .ifNot(ShinshinIkenSpec.麻痺左下肢程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.左下肢麻痺程度)
                    .ifNot(ShinshinIkenSpec.麻痺その他部位程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他部位麻痺程度)
                    .ifNot(ShinshinIkenSpec.その他部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他部位)
                    .ifNot(ShinshinIkenSpec.筋力の低下部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.筋力の低下部位)
                    .ifNot(ShinshinIkenSpec.筋力の低下程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.筋力の低下程度)
                    .ifNot(ShinshinIkenSpec.関節の拘縮部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.関節の拘縮部位)
                    .ifNot(ShinshinIkenSpec.関節の拘縮程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.関節の拘縮程度)
                    .ifNot(ShinshinIkenSpec.関節の痛み部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.関節の痛み部位)
                    .ifNot(ShinshinIkenSpec.関節の痛み程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.関節の痛み程度)
                    .ifNot(ShinshinIkenSpec.失調不随意運動詳細部位必須チェック)
                    .thenAdd(ShinshinIkenValidationMessage.失調不随意運動詳細部位)
                    .ifNot(ShinshinIkenSpec.褥瘡部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.褥瘡部位)
                    .ifNot(ShinshinIkenSpec.褥瘡程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.褥瘡程度)
                    .ifNot(ShinshinIkenSpec.その他の皮膚疾患部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他の皮膚疾患部位)
                    .ifNot(ShinshinIkenSpec.その他の皮膚疾患程度チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他の皮膚疾患程度)
                    .messages());
            return messages;
        }
    }
}

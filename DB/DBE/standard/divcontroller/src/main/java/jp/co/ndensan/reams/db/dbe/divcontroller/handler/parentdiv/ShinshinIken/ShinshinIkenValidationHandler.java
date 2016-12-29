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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 心身の意見入力のチェック処理クラスです。
 * @reamsid_L DBE-3000-120 dongyabin
 */
public class ShinshinIkenValidationHandler {
    
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private final ShinshinIkenDiv div;
    
    /**
     * コンストラクタです。
     * @param div 画面情報
     */
    public ShinshinIkenValidationHandler(ShinshinIkenDiv div) {
        this.div = div;
    }
    
    /**
     * 確定ンを押下するとき、バリデーションチェックを行う。
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        checkKakutei(validPairs);
        return validPairs;
    }

    private void checkKakutei(ValidationMessageControlPairs validPairs) {
        if (div.getRadNinchishoShuhenShojoUmu().getSelectedKey().contains(KEY_1)
                && div.getChkNinchishoShuhenShojo().getSelectedKeys().isEmpty()
                && div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "認知症周辺症状詳細");
        }
        if (div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().contains(KEY_0)
                && div.getTxtSonotaKinyu().getValue().isEmpty()) {
            addMessage(validPairs, "その他の症状名");
        }
        if (div.getRadSenmonJushin().getSelectedKey().contains(KEY_1)
                && div.getTxtShosaiTokkiJiko().getValue().isEmpty()) {
            addMessage(validPairs, "専門医受診詳細事項");
        }
        if (div.getChkShishiKesson().getSelectedKeys().contains(KEY_0)
                && div.getTxtShishiKessonBui().getValue().isEmpty()) {
            addMessage(validPairs, "四肢欠損部位");
        }
        checkKakutei_二(validPairs);
        checkKakutei_三(validPairs);
        checkKakutei_四(validPairs);
    }
    
    private void checkKakutei_二(ValidationMessageControlPairs validPairs) {
        if (div.getChkMahi().getSelectedKeys().contains(KEY_0)
                && div.getChkMigiJoshiMahi().getSelectedKeys().isEmpty()
                && div.getChkHidariJoshiMahi().getSelectedKeys().isEmpty()
                && div.getChkMigiKashiMahi().getSelectedKeys().isEmpty()
                && div.getChkHidariKashiMahi().getSelectedKeys().isEmpty()
                && div.getChkSonotaMahi().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "麻痺部位");
        }
        if (div.getChkMahi().getSelectedKeys().contains(KEY_0)
                && div.getRadMigiJoshiMahiTeido().getSelectedKey().isEmpty()
                && div.getRadHidariJoshiMahiTeido().getSelectedKey().isEmpty()
                && div.getRadMigiKashiMahiTeido().getSelectedKey().isEmpty()
                && div.getRadHidariKashiMahiTeido().getSelectedKey().isEmpty()
                && div.getRadSonotaMahiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "麻痺程度");
        }
    }
    
    private void checkKakutei_三(ValidationMessageControlPairs validPairs) {
        if (div.getChkMigiJoshiMahi().getSelectedKeys().contains(KEY_0)
                && div.getRadMigiJoshiMahiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "右上肢麻痺程度");
        }
        if (div.getChkHidariJoshiMahi().getSelectedKeys().contains(KEY_0)
                && div.getRadHidariJoshiMahiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "左上肢麻痺程度");
        }
        if (div.getChkMigiKashiMahi().getSelectedKeys().contains(KEY_0)
                && div.getRadMigiKashiMahiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "右下肢麻痺程度");
        }
        if (div.getChkHidariKashiMahi().getSelectedKeys().contains(KEY_0)
                && div.getRadHidariKashiMahiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "左下肢麻痺程度");
        }
        if (div.getChkSonotaMahi().getSelectedKeys().contains(KEY_0)
                && div.getTxtSonotaMahiBui().getValue().isEmpty()) {
            addMessage(validPairs, "その他部位");
        }
        if (div.getChkSonotaMahi().getSelectedKeys().contains(KEY_0)
                && div.getRadSonotaMahiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "その他部位麻痺程度");
        }
        if (div.getChkKinryokuTeika().getSelectedKeys().contains(KEY_0)
                && div.getTxtKinryokuTeikaBui().getValue().isEmpty()) {
            addMessage(validPairs, "筋力の低下部位");
        }
        if (div.getChkKinryokuTeika().getSelectedKeys().contains(KEY_0)
                && div.getRadKinryokuTeikaTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "筋力の低下程度");
        }
        if (div.getChkKansetsuKoshuku().getSelectedKeys().contains(KEY_0)
                && div.getTxtKansetsuKoshukuBui().getValue().isEmpty()) {
            addMessage(validPairs, "関節の拘縮部位");
        }
    }
    
    private void checkKakutei_四(ValidationMessageControlPairs validPairs) {
        if (div.getChkKansetsuKoshuku().getSelectedKeys().contains(KEY_0)
                && div.getRadKansetsuKoshukuTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "関節の拘縮程度");
        }
        if (div.getChkKansetsuItami().getSelectedKeys().contains(KEY_0)
                && div.getTxtKansetsuItamiBui().getValue().isEmpty()) {
            addMessage(validPairs, "関節の痛み部位");
        }
        if (div.getChkKansetsuItami().getSelectedKeys().contains(KEY_0)
                && div.getRadKansetsuItamiTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "関節の痛み程度");
        }
        if (div.getChkShicchoFuzuii().getSelectedKeys().contains(KEY_0)
                && div.getChkFuzuiiJoshi().getSelectedKeys().isEmpty()
                && div.getChkFuzuiiKashi().getSelectedKeys().isEmpty()
                && div.getChkTaikan().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "失調・不随意運動詳細部位");
        }
        if (div.getChkJokuso().getSelectedKeys().contains(KEY_0)
                && div.getTxtJokusoBui().getValue().isEmpty()) {
            addMessage(validPairs, "褥瘡部位");
        }
        if (div.getChkJokuso().getSelectedKeys().contains(KEY_0)
                && div.getRadJokusoTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "褥瘡程度");
        }
        if (div.getChkSonotaHifuShikkan().getSelectedKeys().contains(KEY_0)
                && div.getTxtSonotaHifuShikkanBui().getValue().isEmpty()) {
            addMessage(validPairs, "その他の皮膚疾患部位");
        }
        if (div.getChkSonotaHifuShikkan().getSelectedKeys().contains(KEY_0)
                && div.getRadSonotaHifuShikkanTeido().getSelectedKey().isEmpty()) {
            addMessage(validPairs, "その他の皮膚疾患程度");
        }
    }
    
    private void addMessage(ValidationMessageControlPairs validPairs, String replace) {
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須項目_追加メッセージあり, replace)));
    }
    
    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    public ValidationMessageControlPairs validateIro() {
        IValidationMessages messages = new ControlValidator(div).validate1();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShinshinIkenValidationMessage.認知症周辺症状詳細, div.getNinchishoShuhenShojo().getTxtSonotaKinyu())
                .add(ShinshinIkenValidationMessage.その他の症状名, div.getSonotaShojo().getTxtShojomei())
                .add(ShinshinIkenValidationMessage.専門医受診詳細事項, div.getSonotaShojo().getTxtShosaiTokkiJiko())
                .add(ShinshinIkenValidationMessage.四肢欠損部位, div.getKaradaJotai().getTxtShishiKessonBui())
                .add(ShinshinIkenValidationMessage.その他部位, div.getKaradaJotai().getTxtSonotaMahiBui())
                .add(ShinshinIkenValidationMessage.筋力の低下部位, div.getKaradaJotai().getTxtKinryokuTeikaBui())
                .add(ShinshinIkenValidationMessage.関節の拘縮部位, div.getKaradaJotai().getTxtKansetsuKoshukuBui())
                .add(ShinshinIkenValidationMessage.関節の痛み部位, div.getKaradaJotai().getTxtKansetsuItamiBui())
                .add(ShinshinIkenValidationMessage.褥瘡部位, div.getKaradaJotai().getTxtJokusoBui())
                .add(ShinshinIkenValidationMessage.その他の皮膚疾患部位, div.getKaradaJotai().getTxtSonotaHifuShikkanBui())
                .build();
    }

    private static enum ShinshinIkenValidationMessage implements IValidationMessage {

        認知症周辺症状詳細(UrErrorMessages.必須項目_追加メッセージあり, "認知症周辺症状詳細"),
        その他の症状名(UrErrorMessages.必須項目_追加メッセージあり, "その他の症状名"),
        専門医受診詳細事項(UrErrorMessages.必須項目_追加メッセージあり, "専門医受診詳細事項"),
        四肢欠損部位(UrErrorMessages.必須項目_追加メッセージあり, "四肢欠損部位"),
        その他部位(DbzErrorMessages.必須項目_追加メッセージあり, "その他部位"),
        筋力の低下部位(DbzErrorMessages.必須項目_追加メッセージあり, "筋力の低下部位"),
        関節の拘縮部位(UrErrorMessages.必須項目_追加メッセージあり, "関節の拘縮部位"),
        関節の痛み部位(UrErrorMessages.必須項目_追加メッセージあり, "関節の痛み部位"),
        褥瘡部位(UrErrorMessages.必須項目_追加メッセージあり, "褥瘡部位"),
        その他の皮膚疾患部位(UrErrorMessages.必須項目_追加メッセージあり, "その他の皮膚疾患部位");

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
                    .ifNot(ShinshinIkenSpec.その他の症状名チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他の症状名)
                    .ifNot(ShinshinIkenSpec.専門医受診詳細事項チェック)
                    .thenAdd(ShinshinIkenValidationMessage.専門医受診詳細事項)
                    .ifNot(ShinshinIkenSpec.四肢欠損部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.四肢欠損部位)
                    .ifNot(ShinshinIkenSpec.その他部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他部位)
                    .ifNot(ShinshinIkenSpec.筋力の低下部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.筋力の低下部位)
                    .ifNot(ShinshinIkenSpec.関節の拘縮部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.関節の拘縮部位)
                    .ifNot(ShinshinIkenSpec.関節の痛み部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.関節の痛み部位)
                    .ifNot(ShinshinIkenSpec.褥瘡部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.褥瘡部位)
                    .ifNot(ShinshinIkenSpec.その他の皮膚疾患部位チェック)
                    .thenAdd(ShinshinIkenValidationMessage.その他の皮膚疾患部位)
                    .messages());
            return messages;
        }
    }
}

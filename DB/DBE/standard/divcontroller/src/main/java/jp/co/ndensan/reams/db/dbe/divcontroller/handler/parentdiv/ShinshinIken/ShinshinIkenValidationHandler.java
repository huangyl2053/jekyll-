/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken.ShinshinIkenDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 心身の意見入力のチェック処理クラスです。
 */
public class ShinshinIkenValidationHandler {
    
    private static final RString チェックボックス_1 = new RString("key0");
    private static final RString チェックボックス_2 = new RString("key1");
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
        if (div.getChkNinchishoShuhenShojoUmu().getSelectedKeys().contains(チェックボックス_2)
                && div.getChkNinchishoShuhenShojo().getSelectedKeys().isEmpty()
                && div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "認知症周辺症状詳細");
        }
        if (div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtSonotaKinyu().getValue().isEmpty()) {
            addMessage(validPairs, "その他の症状名");
        }
        if (div.getChkSenmonJushin().getSelectedKeys().contains(チェックボックス_2)
                && div.getTxtShosaiTokkiJiko().getValue().isEmpty()) {
            addMessage(validPairs, "専門医受診詳細事項");
        }
        if (div.getChkShishiKesson().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtShishiKessonBui().getValue().isEmpty()) {
            addMessage(validPairs, "四肢欠損部位");
        }
        checkKakutei_二(validPairs);
        checkKakutei_三(validPairs);
        checkKakutei_四(validPairs);
    }
    
    private void checkKakutei_二(ValidationMessageControlPairs validPairs) {
        if (div.getChkMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkMigiJoshiMahi().getSelectedKeys().isEmpty()
                && div.getChkHidariJoshiMahi().getSelectedKeys().isEmpty()
                && div.getChkMigiKashiMahi().getSelectedKeys().isEmpty()
                && div.getChkHidariKashiMahi().getSelectedKeys().isEmpty()
                && div.getChkSonotaMahi().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "麻痺部位");
        }
        if (div.getChkMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkMigiJoshiMahiTeido().getSelectedKeys().isEmpty()
                && div.getChkHidariJoshiMahiTeido().getSelectedKeys().isEmpty()
                && div.getChkMigiKashiMahiTeido().getSelectedKeys().isEmpty()
                && div.getChkHidariKashiMahiTeido().getSelectedKeys().isEmpty()
                && div.getSonotaMahiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "麻痺程度");
        }
    }
    
    private void checkKakutei_三(ValidationMessageControlPairs validPairs) {
        if (div.getChkMigiJoshiMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkMigiJoshiMahiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "右上肢麻痺程度");
        }
        if (div.getChkHidariJoshiMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkHidariJoshiMahiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "左上肢麻痺程度");
        }
        if (div.getChkMigiKashiMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkMigiKashiMahiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "右下肢麻痺程度");
        }
        if (div.getChkHidariKashiMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkHidariKashiMahiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "左下肢麻痺程度");
        }
        if (div.getChkSonotaMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtSonotaMahiBui().getValue().isEmpty()) {
            addMessage(validPairs, "その他部位");
        }
        if (div.getChkSonotaMahi().getSelectedKeys().contains(チェックボックス_1)
                && div.getSonotaMahiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "その他部位麻痺程度");
        }
        if (div.getChkKinryokuTeika().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtKinryokuTeikaBui().getValue().isEmpty()) {
            addMessage(validPairs, "筋力の低下部位");
        }
        if (div.getChkKinryokuTeika().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkKinryokuTeikaTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "筋力の低下程度");
        }
        if (div.getChkKansetsuKoshuku().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtKansetsuKoshukuBui().getValue().isEmpty()) {
            addMessage(validPairs, "関節の拘縮部位");
        }
    }
    
    private void checkKakutei_四(ValidationMessageControlPairs validPairs) {
        if (div.getChkKansetsuKoshuku().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkKansetsuKoshukuTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "関節の拘縮程度");
        }
        if (div.getChkKansetsuItami().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtKansetsuItamiBui().getValue().isEmpty()) {
            addMessage(validPairs, "関節の痛み部位");
        }
        if (div.getChkKansetsuItami().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkKansetsuItamiTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "関節の痛み程度");
        }
        if (div.getChkShicchoFuzuii().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkFuzuiiJoshi().getSelectedKeys().isEmpty()
                && div.getChkFuzuiiKashi().getSelectedKeys().isEmpty()
                && div.getChkTaikan().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "失調・不随意運動詳細部位");
        }
        if (div.getChkJokuso().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtJokusoBui().getValue().isEmpty()) {
            addMessage(validPairs, "褥瘡部位");
        }
        if (div.getChkJokuso().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkJokusoTeido().getSelectedKeys().isEmpty()) {
            addMessage(validPairs, "褥瘡程度");
        }
        if (div.getChkSonotaHifuShikkan().getSelectedKeys().contains(チェックボックス_1)
                && div.getTxtSonotaHifuShikkanBui().getValue().isEmpty()) {
            addMessage(validPairs, "その他の皮膚疾患部位");
        }
        if (div.getChkSonotaHifuShikkan().getSelectedKeys().contains(チェックボックス_1)
                && div.getChkSonotaHifuShikkanTeido().getSelectedKeys().isEmpty()) {
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
    
}

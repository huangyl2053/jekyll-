/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.IkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書作成依頼(手動)のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIraiValidationHandler {

    private final IkenshoSakuseiIraiDiv div;
    private static final RString 主治医医療機関 = new RString("主治医医療機関");
    private static final RString 主治医 = new RString("主治医");
    private static final RString 主治医意見書作成依頼日 = new RString("主治医意見書作成依頼日");
    private static final RString 依頼情報未指定 = new RString("依頼情報未指定ため、依頼書の印刷");
    private static final RString 発行書類 = new RString("発行書類を");
    private static final RString 受診予定開始日 = new RString("受診予定開始日を");
    private static final RString 受診予定終了日 = new RString("受診予定終了日を");
    private static final RString 受診期間_日時指定 = new RString("key0");
    private static final RString 期間指定_期間指定 = new RString("key1");
    private static final RString 受診日 = new RString("受診日を");
    private static final RString 受診時分 = new RString("受診時分を");
    private static final RString SELECTED_KEY3 = new RString("key3");

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書作成依頼(手動)Div
     */
    public IkenshoSakuseiIraiValidationHandler(IkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 選択した帳票を発行のチェックを処理します。
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs check発行() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(印刷書類チェック());
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY3)) {
            validationMessages.add(期間チェック());
            validationMessages.add(受診日が未入力チェック());
        }
        return validationMessages;
    }

    /**
     * 保存のチェックを処理します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check保存() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(主治医医療機関チェック());
        validationMessages.add(主治医チェック());
        return validationMessages;
    }

    private ValidationMessageControlPairs 印刷書類チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getChkIrai().getSelectedKeys().isEmpty() && div.getChkPrint().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                            UrErrorMessages.未指定, 発行書類.toString()), div.getChkIrai(), div.getChkPrint()));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 期間チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (期間指定_期間指定.equals(div.getRadJyushin().getSelectedKey())) {
            if (div.getTxtJyushinKikan().getFromValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                                UrErrorMessages.未指定, 受診予定開始日.toString()), div.getTxtJyushinKikan()));
            }
            if (div.getTxtJyushinKikan().getToValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                                UrErrorMessages.未指定, 受診予定終了日.toString()), div.getTxtJyushinKikan()));
            }
            if (div.getTxtJyushinKikan().getFromValue() != null
                    && div.getTxtJyushinKikan().getToValue() == null
                    && div.getTxtJyushinKikan().getToValue().isBefore(div.getTxtJyushinKikan().getFromValue())) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                                UrErrorMessages.終了日が開始日以前), div.getTxtJyushinKikan()));
            }
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 受診日が未入力チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (受診期間_日時指定.equals(div.getRadJyushin().getSelectedKey())) {
            if (div.getTxtJyushinymd().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                                UrErrorMessages.未指定, 受診日.toString()), div.getTxtJyushinymd()));
            }
            if (div.getTxtJyushintime().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                                UrErrorMessages.未指定, 受診時分.toString()), div.getTxtJyushintime()));
            }
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 主治医医療機関チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdShujiiInput().getIryoKikanCode())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 主治医医療機関.toString())));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 主治医チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdShujiiInput().getShujiiCode())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IkenshoSakuseiIraiValidationHandler.IkenshoSakuseiIraiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 主治医.toString())));
        }
        return validationMessages;
    }

    private static final class IkenshoSakuseiIraiMessages implements IValidationMessage {

        private final Message message;

        private IkenshoSakuseiIraiMessages(IMessageGettable message, String... replaceParam) {
            this.message = message.getMessage().replace(replaceParam);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

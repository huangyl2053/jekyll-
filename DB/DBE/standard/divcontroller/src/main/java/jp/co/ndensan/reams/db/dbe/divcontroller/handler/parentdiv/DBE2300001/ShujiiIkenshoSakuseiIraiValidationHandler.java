/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書作成依頼のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiValidationHandler {

    private final ShujiiIkenshoSakuseiIraiDiv div;
    private static final RString 主治医医療機関 = new RString("主治医医療機関");
    private static final RString 主治医 = new RString("主治医");
    private static final RString 主治医意見書作成依頼日 = new RString("主治医意見書作成依頼日");
    private static final RString 依頼情報未指定 = new RString("依頼情報未指定ため、依頼書の印刷");
    private static final RString 依頼情報未指定保存不可 = new RString("依頼情報未指定ため、依頼書の保存");
    
    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     */
    public ShujiiIkenshoSakuseiIraiValidationHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 依頼のチェックを処理します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 依頼チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(申請者一覧未選択チェック());
        validationMessages.add(主治医医療機関チェック());
        validationMessages.add(主治医チェック());
        validationMessages.add(主治医意見書作成依頼日チェック());
        return validationMessages;
    }

     /**
     * 発行のチェックを処理します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 発行チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(申請者一覧未選択チェック());
        validationMessages.add(選択された申請者チェック());
        return validationMessages;
    }

     /**
     * 保存のチェックを処理します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保存チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(選択された保存チェック());
        return validationMessages;
    }
    
    private ValidationMessageControlPairs 主治医医療機関チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdShujiiIryoKikanAndShujiiInput().getIryoKikanCode())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 主治医医療機関.toString())));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 主治医チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdShujiiIryoKikanAndShujiiInput().getShujiiCode())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 主治医.toString())));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 主治医意見書作成依頼日チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtShujiiIkensahoSakuseiIraiDay().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 主治医意見書作成依頼日.toString()), div.getTxtShujiiIkensahoSakuseiIraiDay()));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 申請者一覧未選択チェック() {
        boolean isSelected = false;
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected()) {
                isSelected = true;
                break;
            }
        }
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!isSelected) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                            UrErrorMessages.対象行を選択), div.getDgShinseishaIchiran()));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 選択された申請者チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && (RString.isNullOrEmpty(row.getShujiiIryoKikan())
                    || RString.isNullOrEmpty(row.getShujii()) || row.getShujiiIkenshoSakuseiIraiDay().getValue() == null)) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                                UrErrorMessages.実行不可, 依頼情報未指定.toString()), div.getBtnIrai()));
                return validationMessages;
            }
        }
        return validationMessages;
    }
    
    private ValidationMessageControlPairs 選択された保存チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && (RString.isNullOrEmpty(row.getShujiiIryoKikan())
                    || RString.isNullOrEmpty(row.getShujii()) || row.getShujiiIkenshoSakuseiIraiDay().getValue() == null)) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                                UrErrorMessages.実行不可, 依頼情報未指定保存不可.toString())));
                return validationMessages;
            }
        }
        return validationMessages;
    }

    /**
     * 排他のチェックを処理します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 排他チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                new ShujiiIkenshoSakuseiIraiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                        UrErrorMessages.排他_バッチ実行中で更新不可)));
        return validationMessages;
    }

    private static final class ShujiiIkenshoSakuseiIraiMessages implements IValidationMessage {

        private final Message message;

        private ShujiiIkenshoSakuseiIraiMessages(IMessageGettable message, String... replaceParam) {
            this.message = message.getMessage().replace(replaceParam);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

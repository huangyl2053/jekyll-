/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1090011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1090011.MishorishaIchiranSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 転入・転出未登録一覧表のHandlerクラスです。
 *
 * @reamsid_L DBU-4110-010 yaodongsheng
 */
public class MishorishaIchiranSakuseiValidationHandler {

    private final MishorishaIchiranSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 転入・転出未登録一覧表Divのエンティティ
     */
    public MishorishaIchiranSakuseiValidationHandler(MishorishaIchiranSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 今バッチ起動のために必要なパラメータをチェックする。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkMsg() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getBatchParamterInfo().getDdlShichoson().getSelectedKey().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.Validate市町村指定,
                    div.getBatchParamterInfo().getDdlShichoson()));
        }
        if (div.getBatchParamterInfo().getChkTennyuSakuseiJiyu().getSelectedKeys().isEmpty()
                && div.getBatchParamterInfo().getChkTenshutsuSakuseiJiyu().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.Validate転出転入作成事由,
                    div.getBatchParamterInfo().getChkTennyuSakuseiJiyu(), div.getBatchParamterInfo().getChkTenshutsuSakuseiJiyu()));
        }
        if (!div.getBatchParamterInfo().getChkTenshutsuSakuseiJiyu().getSelectedKeys().isEmpty()
                && (div.getBatchParamterInfo().getTxtZenkaiKaishi().getValue().isEmpty()
                || div.getBatchParamterInfo().getTxtZenkaiKara().getValue().isEmpty())) {
            if (div.getBatchParamterInfo().getTxtZenkaiKaishi().getValue().isEmpty()) {
                validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.Validate開始終了日,
                        div.getBatchParamterInfo().getTxtZenkaiKaishi()));
            } else if (div.getBatchParamterInfo().getTxtZenkaiKara().getValue().isEmpty()) {
                validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.Validate開始終了日,
                        div.getBatchParamterInfo().getTxtZenkaiKara()));
            } else {
                validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.Validate開始終了日,
                        div.getBatchParamterInfo().getTxtZenkaiKaishi(), div.getBatchParamterInfo().getTxtZenkaiKara()));
            }
        }
        return validationMessages;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate市町村指定(UrErrorMessages.必須項目_追加メッセージあり, "市町村指定が未選択。"),
        Validate転出転入作成事由(UrErrorMessages.必須項目_追加メッセージあり, "転出作成事由か、転入作成事由の内、1つ以上チェックする。"),
        Validate開始終了日(UrErrorMessages.必須項目_追加メッセージあり, "転出作成事由選択時は、開始日・終了日の入力が必須。");
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.JogaishaTorokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 資格取得除外者登録の抽象ValidationHandlerクラスです。
 */
public class JogaishaValidationHandler {

    private final JogaishaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div Div
     */
    public JogaishaValidationHandler(JogaishaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RDate jogaiKaijyoYMD = div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().getValue();
        RDate jogaiTekiyoYMD = div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().getValue();
        if ((jogaiKaijyoYMD == null ? RDate.MIN : jogaiKaijyoYMD).isBefore(jogaiTekiyoYMD == null ? RDate.MIN : jogaiTekiyoYMD)) {
            validationMessages.add(new ValidationMessageControlPair(new JogaishaValidationHandler.RRVMessages(
                    UrErrorMessages.前後関係逆転, "資格除外解除年月日", "資格除外適用年月日")));
        }
        return validationMessages;
    }

    /**
     * 保存するボタン押下の場合、重複チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs juufukuCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new JogaishaValidationHandler.RRVMessages(
                UrErrorMessages.期間が重複)));
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

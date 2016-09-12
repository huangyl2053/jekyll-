/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820032;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細(住特））
 *
 * @reamsid_L DBC-1030-030 quxiaodong
 */
public class KyuhuhiMeisaiJutokuPanelValidationHandler {

    private final KyuhuhiMeisaiJutokuPanelDiv div;
    private static final RString 保険者番号 = new RString("保険者番号");

    /**
     * 初期化
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     */
    public KyuhuhiMeisaiJutokuPanelValidationHandler(KyuhuhiMeisaiJutokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho().
                getHokenjaNo().isEmpty() || div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 保険者番号.toString())));
        }
        return validPairs;
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

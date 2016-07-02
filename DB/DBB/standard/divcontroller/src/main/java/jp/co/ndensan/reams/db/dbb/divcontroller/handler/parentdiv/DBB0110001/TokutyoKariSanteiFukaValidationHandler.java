/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0110001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.TokutyoKariSanteiFukaDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 画面設計_DBBGM33001_特徴仮算定賦課
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokutyoKariSanteiFukaValidationHandler {

    private static final RString 発行日 = new RString("発行日");
    private final TokutyoKariSanteiFukaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TokutyoKariSanteiFukaDiv
     */
    public TokutyoKariSanteiFukaValidationHandler(TokutyoKariSanteiFukaDiv div) {
        this.div = div;
    }

    /**
     * アップロードファイル未指定チェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 発行日未入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        Map<RString, RString> map = div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        RString publishidate = div.getTokutyoKariSanteiFukaChohyoHakko().getTokutyoKariTsuchiKobetsuJoho().
                getTxtTokuKaishiTsuchiHakkoYMD2().getText();
        if (!map.isEmpty() && RString.isNullOrEmpty(publishidate)) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, (発行日.toString()))));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7030011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7030011.TatokureiHenkoTsuchishoHakkoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 他特例施設変更通知書発行のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class TatokureiHenkoTsuchishoHakkoValidationHandler {

    private final TatokureiHenkoTsuchishoHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 他特例施設変更通知書発行Div
     */
    public TatokureiHenkoTsuchishoHakkoValidationHandler(TatokureiHenkoTsuchishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 発行するボタンを押下するとき、出力チェックボックス未入力のチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForReportPublish() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (!div.getTajutokuTekiyoJohoIchiran().getReportPublish().isIsPublish()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.出力チェックボックス));
        }
        return validPairs;
    }


    private static enum RRVMessages implements IValidationMessage {

        出力チェックボックス(UrErrorMessages.必須, "出力チェックボックス");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020003;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209011.DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020003.KyufugakuGengakuHaakuIchiran;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020003.ChishutsuJokenParameterDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付額減額滞納者把握リストハンドラクラスです。
 *
 * @reamsid_L DBD-3610-010 x_lilh
 */
public class DBD2020003ValidationHandler {

    private final ChishutsuJokenParameterDiv div;
    private static final RString 基準日 = new RString("基準日");

    /**
     * コンストラクタです。
     *
     * @param div 支払方法変更滞納者把握リスト画面Div
     */
    public DBD2020003ValidationHandler(ChishutsuJokenParameterDiv div) {
        this.div = div;
    }

    /**
     * バッチ実行前チェックを行う
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs バッチ実行前チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChishutsuJoken().getTxtKijunbi().getValue() == null || div.getChishutsuJoken().getTxtKijunbi().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 基準日.toString())));
        }

        if (is期間が不正(div.getTxtJukyuNinteibiKaishi().getValue(), div.getTxtJukyuNinteibiShuryo().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正)));
        }
        if (is期間が不正(div.getTxtNinteiYukoShuryobiKaishi().getValue(), div.getTxtNinteiYukoShuryobiShuryo().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正)));
        }
        return validPairs;
    }

    /**
     * 実行パラメターを設定します．
     *
     * @return バッチパラメター
     */
    public DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter setBatchParameter() {
        KyufugakuGengakuHaakuIchiran kyufugakuGengakuHaakuIchiran = new KyufugakuGengakuHaakuIchiran();
        return kyufugakuGengakuHaakuIchiran.createKyufuGengakuHaakuIchiranParameter(div);
    }

    private boolean is期間が不正(FlexibleDate 開始日, FlexibleDate 終了日) {
        if (FlexibleDate.EMPTY.equals(開始日) || FlexibleDate.EMPTY.equals(終了日)) {
            return false;
        }
        return !開始日.isBeforeOrEquals(終了日);
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

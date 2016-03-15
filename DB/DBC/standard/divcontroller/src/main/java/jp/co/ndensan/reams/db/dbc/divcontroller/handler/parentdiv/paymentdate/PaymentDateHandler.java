/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.paymentdate;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * PaymentDate_支払日設定のハンドラクラスです。
 */
public class PaymentDateHandler {

    private final PaymentDateDiv div;
    private final RString 事業高額 = new RString("事業高額");
    private final RString 高額介護 = new RString("高額介護");
    private final RString 高額合算 = new RString("高額合算");
    private final RString 償還払 = new RString("償還払");
    private final RString 支払期間FROM = new RString("支払期間FROM");
    private final RString 支払期間TO = new RString("支払期間TO");
    private final RString 開始時間 = new RString("開始時間");
    private final RString 終了時間 = new RString("終了時間");
    private final RString 有 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div PaymentDateDiv
     */
    public PaymentDateHandler(PaymentDateDiv div) {
        this.div = div;
    }

    /**
     * of
     *
     * @param div 画面DIV
     * @return PaymentDateDiv
     */
    public static PaymentDateHandler of(PaymentDateDiv div) {
        return new PaymentDateHandler(div);
    }

    /**
     * 画面初期化
     *
     * @param 支払方法機能区分 RString
     * @param 支払予定日印字有無 RString
     */
    public void onLoad(RString 支払方法機能区分, RString 支払予定日印字有無) {
        if (!有.equals(支払予定日印字有無)) {
            div.getPayToKoza().setDisplayNone(true);
        } else {
            if ((!事業高額.equals(支払方法機能区分))
                    && (!高額介護.equals(支払方法機能区分))
                    && (!高額合算.equals(支払方法機能区分))
                    && (!償還払.equals(支払方法機能区分))) {
                div.getPayToKoza().setDisplayNone(true);
            }
        }
    }

    /**
     * 入力チェック
     *
     * @return ResponseData
     */
    public ValidationMessageControlPairs getCheckMessage() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.get支払期間FROM() != null
                && div.get支払期間TO() != null
                && div.get支払期間TO().isBefore(div.get支払期間FROM())) {

            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbzErrorMessages.期間が不正_未来日付不可, 支払期間FROM.toString(), 支払期間TO.toString()),
                    div.getPayToMadoguchi().getTxtShiharaiDateRange()));

        }
        if (div.get終了時間() != null
                && div.get開始時間() != null
                && div.get終了時間().isBefore(div.get開始時間())) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, 開始時間.toString(), 終了時間.toString()),
                    div.getPayToMadoguchi().getTxtShiharaiKaishiTime(),
                    div.getPayToMadoguchi().getTxtShiharaiShuryoTime()));
        }
        return pairs;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1020011;

import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsushikakuido.NenreitotatsuJoken;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1020011.NenReiTotatsuSearchConditionDiv;
import jp.co.ndensan.reams.db.dba.service.core.nenreitotatsushikakuido.NenreitotatsuShikakuIdo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.neiReiTotatsuSrchConInfo.NenReiTotatsuSrchConInfoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢到達取得のHandlerクラスです。
 *
 * @reamsid_L DBA-0330-050 wangkun
 */
public class NenReiTotatsuSearchConditionHandler {

    private final NenReiTotatsuSearchConditionDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 年齢到達取得Div
     */
    public NenReiTotatsuSearchConditionHandler(NenReiTotatsuSearchConditionDiv div) {
        this.div = div;
    }

    /**
     * 年齢到達取得の初期化します。
     *
     * @param nenreitotatsuJoken 年齢到達条件情報の取得するクラスです
     */
    public void load(NenreitotatsuJoken nenreitotatsuJoken) {
        div.getCcdNenReiTotatsuSearchCondition().setMode_DisplayMode(NenReiTotatsuSrchConInfoDiv.DisplayMode.KensakuInput);
        div.getCcdNenReiTotatsuSearchCondition().getBtnKensaku().setVisible(true);
        div.getCcdNenReiTotatsuSearchCondition().getBtnKensaku().setText(new RString("修正する"));
        div.getCcdNenReiTotatsuSearchCondition().getBtnKensaku().setDisabled(false);
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().setValue(nenreitotatsuJoken.get前回処理期間開始日());
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().setValue(nenreitotatsuJoken.get前回処理期間終了日());
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().setValue(new FlexibleDate(nenreitotatsuJoken.get年齢到達期間開始日()));
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().setValue(new FlexibleDate(nenreitotatsuJoken.get年齢到達期間終了日()));
        set非活性();
    }

    /**
     * 年齢到達期間開始日と年齢到達期間終了日の必須チェックです。
     *
     * @return ValidationMessageControlPairs バリデーション結果
     */
    public ValidationMessageControlPairs 必須チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須項目_追加メッセージあり, "年齢到達期間開始日"),
                    div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom()));
            return validPairs;
        }
        if (div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須項目_追加メッセージあり, "年齢到達期間終了日"),
                    div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo()));
            return validPairs;
        }

        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo()));

        boolean checkFlag = new NenreitotatsuShikakuIdo()
                .checkKaishibiShuryobiJunban(div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().getValue(),
                        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue());
        if (!checkFlag) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり２,
                    "年齢到達期間開始日", "年齢到達期間終了日")));
        }
        if (!div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue()
                .isBeforeOrEquals(FlexibleDate.getNowDate())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり２,
                    "年齢到達期間終了日", "処理日付")));
        }
        boolean checkFlag2 = new NenreitotatsuShikakuIdo()
                .checkKaishibiShuryobiKikanJufuku(div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().getValue(),
                        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().getValue(),
                        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().getValue(),
                        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue());
        if (!checkFlag2) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり２,
                    "前回処理期間終了日", "年齢到達期間開始日")));
        }

        return validPairs;
    }

    private void set非活性() {
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().setDisabled(true);
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

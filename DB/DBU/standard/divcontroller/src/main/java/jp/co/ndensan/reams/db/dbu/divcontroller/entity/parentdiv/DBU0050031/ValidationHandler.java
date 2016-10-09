/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険特別会計経理状況登録_様式４の２のチェッククラスです。
 */
public class ValidationHandler {

    private final YoshikiYonnoniDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険特別会計経理状況登録_様式４の２入力ガイド
     */
    public ValidationHandler(YoshikiYonnoniDiv div) {
        this.div = div;
    }

    /**
     * 報告年度の必須チェック取得処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 報告年度の必須チェック(ValidationMessageControlPairs validPairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnoniSpec.報告年度必須チェック)
                .thenAdd(RRVMessages.Validate報告年度必須).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.Validate報告年度必須, div.getYoshikiYonnoniMeisai().getTxtHokokuYM()).build().check(messages));
    }

    /**
     * 合計値チェック_合計１処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 合計値チェック_合計１(ValidationMessageControlPairs validPairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnoniSpec.合計値チェック_合計１)
                .thenAdd(RRVMessages.入力値が不正).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.入力値が不正, div.getYoshikiYonnoniMeisai().getTxtsainyugokei()).build().check(messages));
    }

    /**
     * 合計値チェック_合計２処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 合計値チェック_合計２(ValidationMessageControlPairs validPairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnoniSpec.合計値チェック_合計２)
                .thenAdd(RRVMessages.入力値が不正).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.入力値が不正, div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei()).build().check(messages));
    }

    /**
     * 歳入の決算額各項目の合計取得処理です。
     *
     * @return 歳入の決算額各項目の合計
     */
    public Decimal get合計値1() {
        return get額(div.getYoshikiYonnoniMeisai().getTxtkaigoshunyu().getValue())
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxttokuteinyushoshunyu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtjiki().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtsotashunyu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtbuntankin().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtfutankin().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshiyohi().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxttesuryo().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtkokko().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxttodofuken().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtzaisannyu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtkifukin().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtchiikishienyobo().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtkurikosu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshichoson().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshonyu().getValue()));
    }

    /**
     * 歳出の決算額各項目の合計取得処理です。
     *
     * @return 歳出の決算額各項目の合計
     */
    public Decimal get合計値2() {
        return get額(div.getYoshikiYonnoniMeisai().getTxtsomu().getValue())
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtitakusabisu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtmitchaku().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtitakugaigoshien().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtjigyosota().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshisetsuseibi().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtkikinsekin().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtkosai().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtyobih().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshoshishutsu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxthokenkanjokuridasu().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshosonota().getValue()))
                .add(get額(div.getYoshikiYonnoniMeisai().getTxtshohi().getValue()));
    }

    private Decimal get額(Decimal 額) {
        if (null == 額) {
            return Decimal.ZERO;
        }
        return 額;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate報告年度必須(UrErrorMessages.必須, "報告年度"),
        入力値が不正(UrErrorMessages.入力値が不正);
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

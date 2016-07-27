/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD2020001.ShiharaiHohoHenkoHaakuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020001.ShiharaiHohoHenkoHaakuIchiran;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001.ShiharaiHohoHenkoHakuListMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001.ShiharaiHohoHenkoHakuListMainDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 支払方法変更滞納者把握リストハンドラクラスです。
 *
 * @reamsid_L DBD-3650-010 x_lilh
 */
public class DBD2020001ValidationHandler {

    private static final RString 年 = new RString("年");
    private static final RString 月 = new RString("月");
    private static final int 月数_12 = 12;
    private static final int MIN = 0;

    private final ShiharaiHohoHenkoHakuListMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 支払方法変更滞納者把握リスト画面Div
     */
    public DBD2020001ValidationHandler(ShiharaiHohoHenkoHakuListMainDiv div) {
        this.div = div;
    }

    /**
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs バッチ実行前チェック() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        return バッチ実行前関連チェック(pairs, div);
    }

    /**
     * 実行パラメターを設定します．
     *
     * @return　バッチパラメター
     */
    public ShiharaiHohoHenkoHaakuIchiranBatchParameter setBatchParameter() {

        ShiharaiHohoHenkoHaakuIchiran shiharaiHohoHenkoHaakuIchiran = new ShiharaiHohoHenkoHaakuIchiran(div);
        return shiharaiHohoHenkoHaakuIchiran.createShiharaiHohoHenkoHaakuIchiranParameter();
    }

    private ValidationMessageControlPairs バッチ実行前関連チェック(ValidationMessageControlPairs pairs, ShiharaiHohoHenkoHakuListMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShiharaiHohoHenkoHakuListMainDivSpec.基準日の非空チェック)
                .thenAdd(NoInputMessages.基準日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.基準日の必須入力, div.getChushutsuJoken().getTxtKijunYMD()).build().check(messages));

        IValidationMessages messages1 = ValidationMessagesFactory.createInstance();
        messages1.add(ValidateChain.validateStart(div).ifNot(ShiharaiHohoHenkoHakuListMainDivSpec.受給認定日抽出期間が不正チェック)
                .thenAdd(NoInputMessages.期間が不正).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.期間が不正, div.getTxtNinteiYMDTo()).build().check(messages1));

        IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
        messages2.add(ValidateChain.validateStart(div).ifNot(ShiharaiHohoHenkoHakuListMainDivSpec.償還支給決定日抽出期間が不正チェック)
                .thenAdd(NoInputMessages.期間が不正).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.期間が不正, div.getTxtShokanKetteiYMDTo()).build().check(messages2));
        return pairs;

    }

    private static enum NoInputMessages implements IValidationMessage {

        基準日の必須入力(UrErrorMessages.必須.getMessage(), "基準日"),
        期間が不正(UrErrorMessages.期間が不正.getMessage());

        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    public RString get支払方法変更期限に対する年月(Decimal month) {
        int monthValue = month.intValue();
        int 年数 = (int) monthValue / 月数_12;
        int 月数 = monthValue % 月数_12;

        StringBuilder builder = new StringBuilder();

        if (MIN != 年数) {
            builder.append(年数);
            builder.append(年);
        }
        if (MIN != 月数) {
            builder.append(月数);
            builder.append(月);
        }
        return new RString(builder.toString());
    }
}

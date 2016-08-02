/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd2020001.ShiharaiHohoHenkoHaakuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020001.ShiharaiHohoHenkoHaakuIchiran;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001.ShiharaiHohoHenkoHakuListMainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
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
    private static final RString 基準日 = new RString("基準日");
    private static final RString 受給認定日抽出 = new RString("受給認定日抽出");
    private static final RString 償還支給決定日抽出 = new RString("償還支給決定日抽出");

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
     * バッチ実行前チェックを行う
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs バッチ実行前チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJoken().getTxtKijunYMD().getValue() == null || div.getChushutsuJoken().getTxtKijunYMD().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 基準日.toString())));
        }

        if (is期間が不正(div.getTxtNinteiDateFrom().getValue(), div.getTxtNinteiYMDTo().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正)));
        }
        if (is期間が不正(div.getTxtShokanKetteiYMDFrom().getValue(), div.getTxtShokanKetteiYMDTo().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正)));
        }
        return validPairs;
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

    /**
     * 実行パラメターを設定します．
     *
     * @return バッチパラメター
     */
    public ShiharaiHohoHenkoHaakuIchiranBatchParameter setBatchParameter() {

        ShiharaiHohoHenkoHaakuIchiran shiharaiHohoHenkoHaakuIchiran = new ShiharaiHohoHenkoHaakuIchiran(div);
        return shiharaiHohoHenkoHaakuIchiran.createShiharaiHohoHenkoHaakuIchiranParameter();
    }

    /**
     * 対応する年月を取得します．
     *
     * @param month 月数
     * @return 対応する年月
     */
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

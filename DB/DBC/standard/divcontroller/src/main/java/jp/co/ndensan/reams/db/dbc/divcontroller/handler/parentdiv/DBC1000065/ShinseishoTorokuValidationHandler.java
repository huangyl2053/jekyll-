/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000065;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065.ShinseishoTorokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 基準収入額適用申請書_異動分作成のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class ShinseishoTorokuValidationHandler {

    private final ShinseishoTorokuDiv div;
    private static final RString 異動分の処理年度 = new RString("異動分の処理年度");
    private static final RString 世帯員把握基準日 = new RString("世帯員把握基準日");
    private static final RString 平成27年度以降 = new RString("平成27年度以降");
    private static final RString 処理年度の範囲 = new RString("処理年度xx8月1日から処理年度xx7月31日の範囲");
    private static final RString 引数_XX = new RString("xx");

    /**
     * コンストラクタです。
     *
     * @param div ShinseishoTorokuDiv
     */
    public ShinseishoTorokuValidationHandler(ShinseishoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 異動分の処理年度のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 処理年度チェックValidate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new ShinseishoTorokuValidationMessages(
                        UrErrorMessages.項目に対する制約, 異動分の処理年度.toString(), 平成27年度以降.toString()), div.getChushutsuJoken2().getTxtShoriNendo()));
        return validPairs;
    }

    /**
     * 異世帯員把握基準日のバリデーションチェック。
     *
     * @param 処理年度 FlexibleYear
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 世帯員把握基準日チェックValidate(FlexibleYear 処理年度) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new ShinseishoTorokuValidationMessages(
                UrErrorMessages.項目に対する制約,
                世帯員把握基準日.toString(), 処理年度の範囲.toString().replace(引数_XX, 処理年度.toDateString())), div.getTxtSetaiinHaakuKijunYMD()));
        return validPairs;
    }

    private static class ShinseishoTorokuValidationMessages implements IValidationMessage {

        private final Message message;

        ShinseishoTorokuValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003.ShinsakaiScheduleHakkoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護認定審査会開催予定登録3のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0130-030 yaodongsheng
 */
public class ShinsakaiScheduleHakkoValidationHandler {

    private static final RString KIKAN = new RString("介護認定審査会開催予定期間");
    private static final RString NIIN = new RString("介護認定審査会委員");
    private static final RString JYOKEN = new RString("発行条件");
    private static final RString NENDO = new RString("年度");
    private static final RString 介護認定審査会スケジュール表鑑 = new RString("key0");
    private final ShinsakaiScheduleHakkoDiv div;
    private final RString スケジュール表 = new RString("key0");
    private final RString スケジュール表_年間 = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div 調査委託先/調査員入力共有子のエンティティ
     */
    public ShinsakaiScheduleHakkoValidationHandler(ShinsakaiScheduleHakkoDiv div) {
        this.div = div;
    }

    /**
     * 印刷対象介護認定審査会委員選択チェックです。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 印刷対象介護認定審査会委員選択チェック() {
        ValidationMessageControlPairs validationMessageControlPairs = new ValidationMessageControlPairs();
        RString 帳票種類 = div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey();
        if (!RString.isNullOrEmpty(帳票種類)
                && スケジュール表.equals(帳票種類)
                && div.getDgShinsakaiScheduleKagami().getSelectedItems().isEmpty()) {
            validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.選択されていない, NIIN.toString()), div.getDgShinsakaiScheduleKagami()));
        }
        return validationMessageControlPairs;
    }

    /**
     * 選択チェックです。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 選択チェック() {
        ValidationMessageControlPairs validationMessageControlPairs = new ValidationMessageControlPairs();
        RString 帳票種類 = div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey();
        if (RString.isNullOrEmpty(帳票種類)) {
            validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.選択されていない, JYOKEN.toString()), div.getShinsakaiScheduleSrch().getRadPrintType()));
        }
        return validationMessageControlPairs;
    }

    /**
     * 年間チェックです。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 年間チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RString 帳票種類 = div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey();
        if (スケジュール表_年間.equals(帳票種類)
                && div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.必須項目_追加メッセージあり, NENDO.toString()), div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo()));
        }
        return validationMessages;
    }

    /**
     * 審査会開催予定期間（開始・終了）のチェック
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 審査会開催予定期間入力チェック() {
        ValidationMessageControlPairs validationMessageControlPairs = new ValidationMessageControlPairs();
        RString 帳票種類 = div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey();
        RDate From期間 = div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue();
        RDate To期間 = div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue();
        if (スケジュール表.equals(帳票種類)) {
            if (From期間 == null || From期間.toDateString().isEmpty() || To期間 == null || To期間.toDateString().isEmpty()) {
                validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                        UrErrorMessages.期間が不正_追加メッセージあり２, "予定期間開始", "予定期間終了"), div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan()));
            }
        }
        return validationMessageControlPairs;
    }

    private static class ShinsakaiScheduleHakkocheckMessages implements IValidationMessage {

        private final Message message;

        public ShinsakaiScheduleHakkocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

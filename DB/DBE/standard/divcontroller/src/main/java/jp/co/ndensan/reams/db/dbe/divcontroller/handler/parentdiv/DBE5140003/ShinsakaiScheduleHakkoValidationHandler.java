/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140003;

import java.util.List;
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
        List<RString> selectKey = div.getShinsakaiScheduleSrch().getChkShinsakaiSchedule().getSelectedKeys();
        List<RString> selectKey_Kagami = div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami().getSelectedKeys();
        if (!selectKey.isEmpty() && 介護認定審査会スケジュール表鑑.equals(selectKey.get(0))
                && div.getDgShinsakaiScheduleKagami().getSelectedItems().isEmpty()) {
            validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.選択されていない, NIIN.toString()), div.getDgShinsakaiScheduleKagami()));
        } else if (!selectKey_Kagami.isEmpty() && 介護認定審査会スケジュール表鑑.equals(selectKey_Kagami.get(0))
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
        if (div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami().getSelectedKeys().isEmpty()
                && div.getShinsakaiScheduleSrch().getChkShinsakaiSchedule().getSelectedKeys().isEmpty()
                && div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleNenkan().getSelectedKeys().isEmpty()) {
            validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.選択されていない, JYOKEN.toString()), div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami()));
            validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.選択されていない, JYOKEN.toString()), div.getShinsakaiScheduleSrch().getChkShinsakaiSchedule()));
            validationMessageControlPairs.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.選択されていない, JYOKEN.toString()), div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleNenkan()));
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
        if (!div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleNenkan().getSelectedKeys().isEmpty()
                && div.getShinsakaiScheduleSrch().getTxtNendo().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiScheduleHakkocheckMessages(
                    UrErrorMessages.必須項目_追加メッセージあり, NENDO.toString()), div.getShinsakaiScheduleSrch().getTxtNendo()));
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
        List<RString> selectKey = div.getShinsakaiScheduleSrch().getChkShinsakaiSchedule().getSelectedKeys();
        List<RString> selectKey_Kagami = div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami().getSelectedKeys();
        RDate From期間 = div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue();
        RDate To期間 = div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue();
        if (!selectKey.isEmpty() || !selectKey_Kagami.isEmpty()) {
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

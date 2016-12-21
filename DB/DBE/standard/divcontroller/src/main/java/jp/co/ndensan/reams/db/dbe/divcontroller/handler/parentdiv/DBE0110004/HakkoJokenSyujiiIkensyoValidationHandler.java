/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110004;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110004.HakkoJokenSyujiiIkensyoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE0110004_主治医意見書に関する帳票発行のバリデーションクラスです
 *
 *
 * @reamsid_L DBE-1390-070 xuyongchao
 */
public class HakkoJokenSyujiiIkensyoValidationHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private final HakkoJokenSyujiiIkensyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenSyujiiIkensyoValidationHandler(HakkoJokenSyujiiIkensyoDiv div) {
        this.div = div;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未選択チェック(ValidationMessageControlPairs validPairs) {
        if ((!div.getChkIraiMishorishaIchiranhyo().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkIraiZumiIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkKakuninIchiranhyo().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkMiteishutsushaIchiran().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkSakuseiIraiHenkoushaIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkSakuseiryoSeikyuIchiranhyo().getSelectedKeys().contains(SELECT_KEY0))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未選択チェック));
        }
        return validPairs;
    }

    /**
     * 未入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未入力チェック(ValidationMessageControlPairs validPairs) {
        if ((!div.getTxtIraiNisu().isDisabled()) && (null == div.getTxtIraiNisu().getValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtShinseiYMD1().isDisabled()) && (null == div.getTxtShinseiYMD1().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtShinsakai2().isDisabled()) && (null == div.getTxtShinsakai2().getValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtShinsaYMD3().isDisabled()) && (null == div.getTxtShinsaYMD3().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtShinseiYMD4().isDisabled()) && (null == div.getTxtShinseiYMD4().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtShoriYMD5().isDisabled()) && (null == div.getTxtShoriYMD5().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtShinseiYMD5().isDisabled()) && (null == div.getTxtShinseiYMD5().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtSeikyuIchiranShoriYMD().isDisabled()) && (null == div.getTxtSeikyuIchiranShoriYMD().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        if ((!div.getTxtJuryoYMD().isDisabled()) && (null == div.getTxtJuryoYMD().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSyujiiIkensyoMessages.未入力チェック));
        }
        return validPairs;
    }

    private static enum HakkoJokenSyujiiIkensyoMessages implements IValidationMessage {

        未入力チェック(UrErrorMessages.未指定, "選択したパネルの条件を"),
        未選択チェック(UrErrorMessages.未指定, "出力帳票を");
        private final Message message;

        private HakkoJokenSyujiiIkensyoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

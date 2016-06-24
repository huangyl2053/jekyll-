/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002.HakkoJokenSinnseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 申請に関する帳票発行のチェッククラスです。
 *
 * @reamsid_L DBE-1390-050 xuyongchao
 */
public class HakkoJokenSinnseiValidationHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");
    private final HakkoJokenSinnseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenSinnseiValidationHandler(HakkoJokenSinnseiDiv div) {
        this.div = div;
    }

    /**
     * 申請日範囲不正チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日範囲不正チェック(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtShinseibi().getFromValue();
        RDate shinnseikato = div.getTxtShinseibi().getToValue();
        if (shinnseikafrom == null) {
            shinnseikafrom = RDate.MIN;
        }
        if (shinnseikato == null) {
            shinnseikato = RDate.MAX;
        }
        if (shinnseikato.isBefore(shinnseikafrom)) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.申請日範囲不正チェック));
        }
        return validPairs;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未選択チェック(ValidationMessageControlPairs validPairs) {
        if ((!div.getChkSakuseiChohyo().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkSakuseiChohyo().getSelectedKeys().contains(SELECT_KEY1))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未選択チェック));
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
        if (div.getRadHakoJyoken().getSelectedKey().contains(SELECT_KEY0)) {
            if ((null == div.getTxtShoriYMD().getFromValue()) || (null == div.getTxtShoriYMD().getToValue())) {
                validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未入力チェック));
            }
        } else {
            if ((null == div.getTxtShinseibi().getFromValue()) || (null == div.getTxtShinseibi().getToValue())) {
                validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未入力チェック));
            }
        }
        return validPairs;
    }

    /**
     * 処理日範囲不正チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 処理日範囲不正チェック(ValidationMessageControlPairs validPairs) {
        RDate shoriYMDfrom = div.getTxtShoriYMD().getFromValue();
        RDate shoriYMDto = div.getTxtShoriYMD().getToValue();
        if (null == shoriYMDfrom) {
            shoriYMDfrom = RDate.MIN;
        }
        if (null == shoriYMDto) {
            shoriYMDto = RDate.MAX;
        }
        if (shoriYMDto.isBefore(shoriYMDfrom)) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.処理日範囲不正チェック));
        }
        return validPairs;
    }

    /**
     * 申請日入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日入力チェック(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtShinseibi().getFromValue();
        RDate shinnseikato = div.getTxtShinseibi().getToValue();
        if (null == shinnseikafrom) {
            shinnseikafrom = RDate.MIN;
        }
        if (null == shinnseikato) {
            shinnseikato = RDate.MAX;
        }
        RString kijyun = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RDate kijyundate = new RDate(kijyun.toString());
        if (!div.getRadHakoJyoken().getSelectedKey().contains(SELECT_KEY0)) {
            int yearsfrom = kijyundate.getBetweenYears(shinnseikafrom);
            int yearsto = kijyundate.getBetweenYears(shinnseikato);
            if ((yearsfrom > 2) || (yearsto > 2)) {
                validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.申請日入力チェック));
            }
        }
        return validPairs;
    }

    private static enum HakkoJokenSinnseiMessages implements IValidationMessage {

        申請日入力チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "申請日From", "申請日To"),
        処理日範囲不正チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "処理日From", "処理日To"),
        申請日範囲不正チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "申請日From", "申請日To"),
        未入力チェック(UrErrorMessages.未指定, "申請日または処理日を"),
        未選択チェック(UrErrorMessages.未指定, "出力帳票を");
        private final Message message;

        private HakkoJokenSinnseiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

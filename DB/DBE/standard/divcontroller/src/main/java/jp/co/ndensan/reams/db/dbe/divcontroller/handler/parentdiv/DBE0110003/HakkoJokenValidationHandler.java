/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003.HakkoJokenDiv;
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
 * 認定調査に関する帳票発行画面のバリデーションクラスです
 *
 *
 * @reamsid_L DBE-1390-060 xuyongchao
 */
public class HakkoJokenValidationHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");
    private final HakkoJokenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenValidationHandler(HakkoJokenDiv div) {
        this.div = div;
    }

    /**
     * 申請日範囲不正チェック1です
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日範囲不正チェック1(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtYoteiMiteishaShinseiYMD().getFromValue();
        RDate shinnseikato = div.getTxtYoteiMiteishaShinseiYMD().getToValue();
        if (!div.getTxtYoteiMiteishaShinseiYMD().isDisabled() && shinnseikato.isBefore(shinnseikafrom)) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.申請日範囲不正チェック));
        }
        return validPairs;
    }

    /**
     * 申請日範囲不正チェック2です
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日範囲不正チェック2(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getFromValue();
        RDate shinnseikato = div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getToValue();
        if (!div.getTxtIraisakiHenkoshaIchiranShinseiYMD().isDisabled() && shinnseikato.isBefore(shinnseikafrom)) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.申請日範囲不正チェック));
        }
        return validPairs;
    }

    /**
     * 申請日範囲不正チェック3です
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日範囲不正チェック3(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtCheckListShinseiYMD().getFromValue();
        RDate shinnseikato = div.getTxtCheckListShinseiYMD().getToValue();
        if (!div.getTxtCheckListShinseiYMD().isDisabled() && shinnseikato.isBefore(shinnseikafrom)) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.申請日範囲不正チェック));
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
        if ((!div.getChkNinteiChosaYoteiMiteishaIchiran().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkNinteiChosaKekkaShujiiIkenshoCheckListJoken().getSelectedKeys().contains(SELECT_KEY0))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.未選択チェック));
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
        if (!div.getTxtYoteiMiteishaShinseiYMD().isDisabled()
                && ((null == div.getTxtYoteiMiteishaShinseiYMD().getFromValue()) || (null == div.getTxtYoteiMiteishaShinseiYMD().getToValue()))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.未入力チェック));
        }
        if (!div.getTxtIraisakiHenkoshaIchiranShinseiYMD().isDisabled()
                && ((null == div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getFromValue())
                || (null == div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getToValue()))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.未入力チェック));
        }
        if (!div.getTxtCheckListShinseiYMD().isDisabled()
                && ((null == div.getTxtCheckListShinseiYMD().getFromValue()) || (null == div.getTxtCheckListShinseiYMD().getToValue()))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.未入力チェック));
        }
        if (!div.getTxtShinsaYMD().isDisabled() && (null == div.getTxtShinsaYMD().getValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.未入力チェック));
        }
        if (!div.getTxtShinsakai().isDisabled() && (null == div.getTxtShinsakai().getValue())) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.未入力チェック));
        }
        return validPairs;
    }

    /**
     * 申請日入力チェック1です
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日入力チェック1(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtYoteiMiteishaShinseiYMD().getFromValue();
        RDate shinnseikato = div.getTxtYoteiMiteishaShinseiYMD().getToValue();
        RString kijyun = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RDate kijyundate = new RDate(kijyun.toString());
        if (!div.getTxtYoteiMiteishaShinseiYMD().isDisabled()) {
            int yearsfrom = kijyundate.getBetweenYears(shinnseikafrom);
            int yearsto = kijyundate.getBetweenYears(shinnseikato);
            if ((yearsfrom > 2) || (yearsto > 2)) {
                validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.申請日入力チェック));
            }
        }
        return validPairs;
    }

    /**
     * 申請日入力チェック2です
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日入力チェック2(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getFromValue();
        RDate shinnseikato = div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getToValue();
        RString kijyun = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RDate kijyundate = new RDate(kijyun.toString());
        if (!div.getTxtIraisakiHenkoshaIchiranShinseiYMD().isDisabled()) {
            int yearsfrom = kijyundate.getBetweenYears(shinnseikafrom);
            int yearsto = kijyundate.getBetweenYears(shinnseikato);
            if ((yearsfrom > 2) || (yearsto > 2)) {
                validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.申請日入力チェック));
            }
        }
        return validPairs;
    }

    /**
     * 申請日入力チェック3です
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日入力チェック3(ValidationMessageControlPairs validPairs) {
        RDate shinnseikafrom = div.getTxtCheckListShinseiYMD().getFromValue();
        RDate shinnseikato = div.getTxtCheckListShinseiYMD().getToValue();
        RString kijyun = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RDate kijyundate = new RDate(kijyun.toString());
        if (!div.getTxtCheckListShinseiYMD().isDisabled()) {
            int yearsfrom = kijyundate.getBetweenYears(shinnseikafrom);
            int yearsto = kijyundate.getBetweenYears(shinnseikato);
            if ((yearsfrom > 2) || (yearsto > 2)) {
                validPairs.add(new ValidationMessageControlPair(HakkoJokenMessages.申請日入力チェック));
            }
        }
        return validPairs;
    }

    private static enum HakkoJokenMessages implements IValidationMessage {

        申請日入力チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "申請日From", "申請日To"),
        申請日範囲不正チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "申請日From", "申請日To"),
        未入力チェック(UrErrorMessages.未指定, "選択したパネルの申請日または審査日または審査会を"),
        未選択チェック(UrErrorMessages.未指定, "出力帳票を");
        private final Message message;

        private HakkoJokenMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110003;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003.HakkoJokenDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

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
        RDate 申請日開始 = div.getTxtYoteiMiteishaShinseiYMD().getFromValue();
        RDate 申請日終了 = div.getTxtYoteiMiteishaShinseiYMD().getToValue();
        RString 切替日 = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RString 照会可能期間 = BusinessConfig.get(ConfigNameDBE.依頼業務照会_申請日_照会可能期間, SubGyomuCode.DBE認定支援);

        if (!RString.isNullOrEmpty(切替日) && !RString.isNullOrEmpty(照会可能期間)) {
            int 遡及可能日数 = Integer.parseInt(照会可能期間.toString());
            RDate 基準日 = new RDate(切替日.toString());
            RDate 遡及限界日 = 基準日.minusDay(遡及可能日数);

            if (!div.getTxtYoteiMiteishaShinseiYMD().isDisabled()) {
                if (申請日開始.isBefore(遡及限界日) || 申請日終了.isBefore(遡及限界日)) {
                    RString 限界日 = 遡及限界日.minusDay(1).seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
                    IraiGyomuShokaiShinseiDateMessage message = new HakkoJokenValidationHandler.IraiGyomuShokaiShinseiDateMessage(DbeErrorMessages.申請日不正_照会不可, 限界日);
                    validPairs.add(new ValidationMessageControlPair(message));
                }
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
        RDate 申請日開始 = div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getFromValue();
        RDate 申請日終了 = div.getTxtIraisakiHenkoshaIchiranShinseiYMD().getToValue();
        RString 切替日 = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RString 照会可能期間 = BusinessConfig.get(ConfigNameDBE.依頼業務照会_申請日_照会可能期間, SubGyomuCode.DBE認定支援);

        if (!RString.isNullOrEmpty(切替日) && !RString.isNullOrEmpty(照会可能期間)) {
            int 遡及可能日数 = Integer.parseInt(照会可能期間.toString());
            RDate 基準日 = new RDate(切替日.toString());
            RDate 遡及限界日 = 基準日.minusDay(遡及可能日数);

            if (!div.getTxtIraisakiHenkoshaIchiranShinseiYMD().isDisabled()) {
                if (申請日開始.isBefore(遡及限界日) || 申請日終了.isBefore(遡及限界日)) {
                    RString 限界日 = 遡及限界日.minusDay(1).seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
                    IraiGyomuShokaiShinseiDateMessage message = new HakkoJokenValidationHandler.IraiGyomuShokaiShinseiDateMessage(DbeErrorMessages.申請日不正_照会不可, 限界日);
                    validPairs.add(new ValidationMessageControlPair(message));
                }
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
        RDate 申請日開始 = div.getTxtCheckListShinseiYMD().getFromValue();
        RDate 申請日終了 = div.getTxtCheckListShinseiYMD().getToValue();
        RString 切替日 = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RString 照会可能期間 = BusinessConfig.get(ConfigNameDBE.依頼業務照会_申請日_照会可能期間, SubGyomuCode.DBE認定支援);

        if (!RString.isNullOrEmpty(切替日) && !RString.isNullOrEmpty(照会可能期間)) {
            int 遡及可能日数 = Integer.parseInt(照会可能期間.toString());
            RDate 基準日 = new RDate(切替日.toString());
            RDate 遡及限界日 = 基準日.minusDay(遡及可能日数);

            if (!div.getTxtCheckListShinseiYMD().isDisabled()) {
                if (申請日開始.isBefore(遡及限界日) || 申請日終了.isBefore(遡及限界日)) {
                    RString 限界日 = 遡及限界日.minusDay(1).seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
                    IraiGyomuShokaiShinseiDateMessage message = new HakkoJokenValidationHandler.IraiGyomuShokaiShinseiDateMessage(DbeErrorMessages.申請日不正_照会不可, 限界日);
                    validPairs.add(new ValidationMessageControlPair(message));
                }
            }
        }
        return validPairs;
    }

    private static final class IraiGyomuShokaiShinseiDateMessage implements IValidationMessage {

        private final Message message;

        private IraiGyomuShokaiShinseiDateMessage(IMessageGettable message, RString replaceParm) {
            this.message = message.getMessage().replace(replaceParm.toString());
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

    private static enum HakkoJokenMessages implements IValidationMessage {

        申請日入力チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "申請日From", "申請日To"),
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

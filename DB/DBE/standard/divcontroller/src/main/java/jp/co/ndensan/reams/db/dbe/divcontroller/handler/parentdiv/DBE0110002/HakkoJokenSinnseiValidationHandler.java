/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002.HakkoJokenSinnseiDiv;
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
 * 申請に関する帳票発行のチェッククラスです。
 *
 * @reamsid_L DBE-1390-050 xuyongchao
 */
public class HakkoJokenSinnseiValidationHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
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
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未選択チェック(ValidationMessageControlPairs validPairs) {
        if ((!div.getChkMonitror().getSelectedKeys().contains(SELECT_KEY0))
                && (!div.getChkShinseishaIchiran().getSelectedKeys().contains(SELECT_KEY0))) {
            validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未選択チェック));
        }
        return validPairs;
    }

    /**
     * 要介護認定申請モニタリスト条件の未入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 要介護認定申請モニタリスト未入力チェック(ValidationMessageControlPairs validPairs) {
        if (div.getChkMonitror().getSelectedKeys().contains(SELECT_KEY0)) {
            if (div.getRadMonitorJoken().getSelectedKey().contains(SELECT_KEY0)) {
                if (null == div.getTxtMonitorShoriYMD().getFromValue() || null == div.getTxtMonitorShoriYMD().getToValue()) {
                    validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未入力チェック));
                }
            } else {
                if (null == div.getTxtMonitorShinseiYMD().getFromValue() || null == div.getTxtMonitorShinseiYMD().getToValue()) {
                    validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未入力チェック));
                }
            }
        }
        return validPairs;
    }

    /**
     * 要介護認定・要支援認定等申請者一覧条件の未入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 要介護認定要支援認定等申請者一覧未入力チェック(ValidationMessageControlPairs validPairs) {
        if (div.getChkShinseishaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            if (div.getRadShinseishaJoken().getSelectedKey().contains(SELECT_KEY0)) {
                if (null == div.getTxtShinseishaShoriYMD().getFromValue() || null == div.getTxtShinseishaShoriYMD().getToValue()) {
                    validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未入力チェック));
                }
            } else {
                if (null == div.getTxtShinseishaShinseiYMD().getFromValue() || null == div.getTxtShinseishaShinseiYMD().getToValue()) {
                    validPairs.add(new ValidationMessageControlPair(HakkoJokenSinnseiMessages.未入力チェック));
                }
            }
        }
        return validPairs;
    }

    /**
     * 要介護認定申請モニタリストの申請日入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 要介護認定申請モニタリスト申請日入力チェック(ValidationMessageControlPairs validPairs) {
        RDate 申請日開始 = div.getTxtMonitorShinseiYMD().getFromValue();
        RDate 申請日終了 = div.getTxtMonitorShinseiYMD().getToValue();
        if (null == 申請日開始) {
            申請日開始 = RDate.MIN;
        }
        if (null == 申請日終了) {
            申請日終了 = RDate.MAX;
        }
        RString 切替日 = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RString 照会可能期間 = BusinessConfig.get(ConfigNameDBE.依頼業務照会_申請日_照会可能期間, SubGyomuCode.DBE認定支援);

        if (!RString.isNullOrEmpty(切替日) && !RString.isNullOrEmpty(照会可能期間)) {
            int 遡及可能日数 = Integer.parseInt(照会可能期間.toString());
            RDate 基準日 = new RDate(切替日.toString());
            RDate 遡及限界日 = 基準日.minusDay(遡及可能日数);
            if (!div.getTxtMonitorShinseiYMD().isDisabled()) {
                if (申請日開始.isBefore(遡及限界日) || 申請日終了.isBefore(遡及限界日)) {
                    RString 限界日 = 遡及限界日.minusDay(1).seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
                    IraiGyomuShokaiShinseiDateMessage message
                            = new HakkoJokenSinnseiValidationHandler.IraiGyomuShokaiShinseiDateMessage(DbeErrorMessages.申請日不正_照会不可, 限界日);
                    validPairs.add(new ValidationMessageControlPair(message));
                }
            }
        }

        return validPairs;
    }

    /**
     * 要介護認定・要支援認定等申請者一覧の申請日入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 要介護認定要支援認定等申請者一覧申請日入力チェック(ValidationMessageControlPairs validPairs) {
        RDate 申請日開始 = div.getTxtShinseishaShinseiYMD().getFromValue();
        RDate 申請日終了 = div.getTxtShinseishaShinseiYMD().getToValue();
        if (null == 申請日開始) {
            申請日開始 = RDate.MIN;
        }
        if (null == 申請日終了) {
            申請日終了 = RDate.MAX;
        }
        RString 切替日 = DbBusinessConfig.get(ConfigNameDBE.Reamsへの切り替え日, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.Reamsへの切り替え日.get名称());
        RString 照会可能期間 = BusinessConfig.get(ConfigNameDBE.依頼業務照会_申請日_照会可能期間, SubGyomuCode.DBE認定支援);

        if (!RString.isNullOrEmpty(切替日) && !RString.isNullOrEmpty(照会可能期間)) {
            int 遡及可能日数 = Integer.parseInt(照会可能期間.toString());
            RDate 基準日 = new RDate(切替日.toString());
            RDate 遡及限界日 = 基準日.minusDay(遡及可能日数);

            if (!div.getTxtShinseishaShinseiYMD().isDisabled()) {
                if (申請日開始.isBefore(遡及限界日) || 申請日終了.isBefore(遡及限界日)) {
                    RString 限界日 = 遡及限界日.minusDay(1).seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
                    IraiGyomuShokaiShinseiDateMessage message
                            = new HakkoJokenSinnseiValidationHandler.IraiGyomuShokaiShinseiDateMessage(DbeErrorMessages.申請日不正_照会不可, 限界日);
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

    private static enum HakkoJokenSinnseiMessages implements IValidationMessage {

        未入力チェック(UrErrorMessages.未指定, "処理日または申請日を"),
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

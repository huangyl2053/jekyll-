package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001;

import java.io.File;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 報告資料発行画面のValidationハンドラークラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public class HokokuShiryoSakuSeiParameterValidationHandler {

    private final HokokuShiryoSakuSeiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HokokuShiryoSakuSeiParameterValidationHandler(HokokuShiryoSakuSeiParameterDiv div) {
        this.div = div;
    }

    /**
     * 対象年度の未入力チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_TaishoNendoNyuryoku(ValidationMessageControlPairs validationMessages) {

        if (!(div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()
                && div.getChkModifyTaishoGeppi().getSelectedKeys().isEmpty())
                && null == div.getTxtTaishoNendo().getValue()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_対象年度));
        }
        return validationMessages;
    }

    /**
     * 「資料の出力を実行する」ボタンを押下するチェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_btnBatchRegisterHokokuShiryo(ValidationMessageControlPairs validationMessages) {
        check_ShutsuryokuChohyo(validationMessages);
        check_ChushutsuJoken(validationMessages);
        check_txtTaishoGappiFrom(validationMessages);
        check_txtTaishoGappiTo(validationMessages);
        check_txtTaishoGappi(validationMessages);
        check_ChkCsvShutsuryoku(validationMessages);
        check_ChkCsvShutsuryokuFile(validationMessages);

        return validationMessages;
    }

    /**
     * 出力帳票の未選択チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_ShutsuryokuChohyo(ValidationMessageControlPairs validationMessages) {

        if (div.getChkShutsuryokuChohyo().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択されていない_出力帳票));
        }
        return validationMessages;
    }

    /**
     * 抽出条件の未選択チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_ChushutsuJoken(ValidationMessageControlPairs validationMessages) {

        if (null == div.getCcdHokenshaList().getSelectedItem()
                && div.getChkHihokenshaKubun().getSelectedKeys().isEmpty()
                && null == div.getTxtTaishoNendo().getValue()
                && div.getDdlGogitaiBango().getSelectedKey().isEmpty()
                && div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()
                && null == div.getTxtKijyunYMD().getValue()
                && div.getChkModifyTaishoGeppi().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択されていない_抽出条件));
        }
        return validationMessages;
    }

    /**
     * 対象年月日Fromの正確性チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_txtTaishoGappiFrom(ValidationMessageControlPairs validationMessages) {

        if (!div.getChkModifyTaishoGeppi().getSelectedKeys().isEmpty()
                && ((div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()
                && div.getTxtTaishoGappi().getFromValue().getYearValue() != div.getTxtTaishoNendo().getValue().getYearValue())
                || (!div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()
                && div.getTxtTaishoGappi().getFromValue().getYearValue() != div.getTxtTaishoNendo().getValue().getYearValue()
                && div.getTxtTaishoGappi().getFromValue().getMonthValue() != Integer.parseInt(div.getDdlTsuki().getSelectedKey().toString())))) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.入力値が不正_追加メッセージあり_対象年月日From));
        }
        return validationMessages;
    }

    /**
     * 対象年月日Toの正確性チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_txtTaishoGappiTo(ValidationMessageControlPairs validationMessages) {

        if (!div.getChkModifyTaishoGeppi().getSelectedKeys().isEmpty()
                && ((div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()
                && div.getTxtTaishoGappi().getToValue().getYearValue() != div.getTxtTaishoNendo().getValue().getYearValue())
                || (!div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()
                && div.getTxtTaishoGappi().getToValue().getYearValue() != div.getTxtTaishoNendo().getValue().getYearValue()
                && div.getTxtTaishoGappi().getToValue().getMonthValue() != Integer.parseInt(div.getDdlTsuki().getSelectedKey().toString())))) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.入力値が不正_追加メッセージあり_対象年月日To));
        }
        return validationMessages;
    }

    /**
     * 対象月日の大小関係チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_txtTaishoGappi(ValidationMessageControlPairs validationMessages) {

        if (div.getTxtTaishoGappi().getToValue() != null && div.getTxtTaishoGappi().getFromValue() != null
                && div.getTxtTaishoGappi().getToValue().isBefore(div.getTxtTaishoGappi().getFromValue())) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.大小関係が不正));
        }
        return validationMessages;
    }

    /**
     * 出力ファイルの未入力チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_ChkCsvShutsuryoku(ValidationMessageControlPairs validationMessages) {

        if (!div.getChkCsvShutsuryoku().getSelectedKeys().isEmpty()
                && RString.isNullOrEmpty(div.getTxtShuturyokuSaki().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_出力ファイル));
        }
        return validationMessages;
    }

    /**
     * 出力ファイル名の存在チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_ChkCsvShutsuryokuFile(ValidationMessageControlPairs validationMessages) {

        if (!div.getChkCsvShutsuryoku().getSelectedKeys().isEmpty()
                && !RString.isNullOrEmpty(div.getTxtShuturyokuSaki().getValue())
                && !new File(div.getTxtShuturyokuSaki().getValue().toString()).exists()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.指定ファイルが存在しない));
        }
        return validationMessages;
    }

    private enum HokokuShiryoSakuSeiParameterValidationMessage implements IValidationMessage {

        必須項目_追加メッセージあり_対象年度(UrErrorMessages.必須項目_追加メッセージあり, "対象年度"),
        選択されていない_出力帳票(UrErrorMessages.選択されていない, "出力帳票"),
        選択されていない_抽出条件(UrErrorMessages.選択されていない, "抽出条件"),
        入力値が不正_追加メッセージあり_対象年月日From(UrErrorMessages.入力値が不正_追加メッセージあり, "対象年月日From"),
        入力値が不正_追加メッセージあり_対象年月日To(UrErrorMessages.入力値が不正_追加メッセージあり, "対象年月日To"),
        大小関係が不正(UrErrorMessages.大小関係が不正, "対象月日"),
        必須項目_追加メッセージあり_出力ファイル(UrErrorMessages.必須項目_追加メッセージあり, "出力ファイル"),
        指定ファイルが存在しない(UrErrorMessages.指定ファイルが存在しない, "出力ファイル名");

        private final Message message;

        private HokokuShiryoSakuSeiParameterValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

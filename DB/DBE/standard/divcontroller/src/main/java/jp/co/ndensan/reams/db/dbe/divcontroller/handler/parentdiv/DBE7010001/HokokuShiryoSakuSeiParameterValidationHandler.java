package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001;

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

    private static final RString KEY_対象年月 = new RString("0");
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
     * 「資料の出力を実行する」ボタンを押下するチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_btnBatchRegisterHokokuShiryo() {
        ValidationMessageControlPairs message = new ValidationMessageControlPairs();
        check_Nengetsu(message);
        check_ShutsuryokuChohyo(message);
        check_ChushutsuJoken(message);
        check_txtTaishoGappi(message);
        check_ChkCsvShutsuryoku(message);
        return message;
    }

    private void check_Nengetsu(ValidationMessageControlPairs validationMessages) {
        if (KEY_対象年月.equals(div.getRadKubun().getSelectedKey()) && div.getTxtNengetsu().getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_対象年月));
            return;
        }
        if (!KEY_対象年月.equals(div.getRadKubun().getSelectedKey())
                && div.getTxtTaishoGappi().getFromValue() == null && div.getTxtTaishoGappi().getToValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_対象年月日));
        }
    }

    private ValidationMessageControlPairs check_ShutsuryokuChohyo(ValidationMessageControlPairs validationMessages) {

        if (div.getChkShutsuryokuChohyo().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択されていない_出力帳票));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check_ChushutsuJoken(ValidationMessageControlPairs validationMessages) {

        if (null == div.getCcdHokenshaList().getSelectedItem()
                && div.getChkHihokenshaKubun().getSelectedKeys().isEmpty()
                && div.getRadKubun().getSelectedKey().isEmpty()
                && div.getDdlGogitaiBango().getSelectedKey().isEmpty()
                && null == div.getTxtKijyunYMD().getValue()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択されていない_抽出条件));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check_txtTaishoGappi(ValidationMessageControlPairs validationMessages) {

        if (div.getTxtTaishoGappi().getToValue() != null && div.getTxtTaishoGappi().getFromValue() != null
                && div.getTxtTaishoGappi().getToValue().isBefore(div.getTxtTaishoGappi().getFromValue())) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.大小関係が不正));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check_ChkCsvShutsuryoku(ValidationMessageControlPairs validationMessages) {

        if (!div.getChkCsvShutsuryoku().getSelectedKeys().isEmpty()
                && RString.isNullOrEmpty(div.getTxtShuturyokuSaki().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_出力ファイル));
        }
        return validationMessages;
    }

    private enum HokokuShiryoSakuSeiParameterValidationMessage implements IValidationMessage {

        必須項目_追加メッセージあり_対象年月(UrErrorMessages.必須項目_追加メッセージあり, "対象年月"),
        必須項目_追加メッセージあり_対象年月日(UrErrorMessages.必須項目_追加メッセージあり, "対象年月日"),
        選択されていない_出力帳票(UrErrorMessages.選択されていない, "出力帳票"),
        選択されていない_抽出条件(UrErrorMessages.選択されていない, "抽出条件"),
        大小関係が不正(UrErrorMessages.大小関係が不正, "対象年月日"),
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

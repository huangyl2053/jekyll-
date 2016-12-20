package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
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
    private static final RString SELECTKEY_KEY0 = new RString("key0");
    private static final RString SELECTKEY_KEY1 = new RString("key1");
    private static final RString KEY_事業状況報告 = new RString("0");
    private static final RString KEY_実施状況報告 = new RString("1");
    private static final RString KEY_審査判定状況 = new RString("2");
    private static final RString KEY_審査判定の変更状況 = new RString("3");
    private static final RString KEY_介護認定審査会集計表_判定別 = new RString("4");
    private static final RString KEY_介護認定審査会集計表_申請区分別 = new RString("5");
    private static final RString KEY_介護認定審査会集計表_現在の状況別 = new RString("6");
    private static final RString KEY_CSV出力 = new RString("0");

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
        check_ChushutsuJoken(message);
        check_txtTaishoGappi(message);
        check_ChkCsvShutsuryoku(message);
        check_ChkShukeiTani(message);
        return message;
    }

    private void check_Nengetsu(ValidationMessageControlPairs validationMessages) {
        boolean flag_対象年月 = false;
        boolean flag_対象年月日 = false;
        if (KEY_事業状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_対象年月 = true;
            flag_対象年月日 = false;
        } else if (KEY_実施状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_審査判定状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_審査判定の変更状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_介護認定審査会集計表_判定別.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_介護認定審査会集計表_申請区分別.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_CSV出力.equals(div.getRadCsvShutsuryoku().getSelectedKey())) {
            flag_対象年月 = false;
            flag_対象年月日 = true;
        } else if (KEY_介護認定審査会集計表_現在の状況別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_対象年月 = false;
            flag_対象年月日 = false;
        }
        if (flag_対象年月 && div.getTxtNengetsu().getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_対象年月));
            return;
        }
        if (flag_対象年月日
                && div.getTxtTaishoGappi().getFromValue() == null && div.getTxtTaishoGappi().getToValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_対象年月日));
        }
    }

    private ValidationMessageControlPairs check_ChushutsuJoken(ValidationMessageControlPairs validationMessages) {

        if (null == div.getCcdHokenshaList().getSelectedItem()
                && div.getChkHihokenshaKubun().getSelectedKeys().isEmpty()
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

        if (!div.getRadCsvShutsuryoku().getSelectedKey().isEmpty()
                && RString.isNullOrEmpty(div.getTxtShuturyokuSaki().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.必須項目_追加メッセージあり_出力ファイル));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check_ChkShukeiTani(ValidationMessageControlPairs validationMessages) {
        if (KEY_実施状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_審査判定の変更状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_介護認定審査会集計表_申請区分別.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_介護認定審査会集計表_現在の状況別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            if (div.getChkShukeiTani().getSelectedKeys().isEmpty()) {
                validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択されていない_集計単位));
            } else if (div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY0)
                    && div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY1)) {
                validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択過多_集計単位));
            }
        } else {
            if (div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY0)
                    && div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY1)) {
                validationMessages.add(new ValidationMessageControlPair(HokokuShiryoSakuSeiParameterValidationMessage.選択過多_集計単位));
            }
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
        指定ファイルが存在しない(UrErrorMessages.指定ファイルが存在しない, "出力ファイル名"),
        選択されていない_集計単位(UrErrorMessages.選択されていない, "集計単位"),
        選択過多_集計単位(DbzErrorMessages.選択過多);

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

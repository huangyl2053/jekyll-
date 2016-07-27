package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710002.ImagePanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定イメージ情報出力のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-1670-011 wangxiaodong
 */
public class ImagePanelValidationHandler {

    private static final RString 調査票 = new RString("1");
    private static final RString 調査票概況 = new RString("2");
    private static final RString 主治医意見書 = new RString("3");
    private static final RString その他資料 = new RString("4");
    private final ImagePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定イメージ情報出力
     */
    public ImagePanelValidationHandler(ImagePanelDiv div) {
        this.div = div;
    }

    /**
     * 要介護認定イメージ情報出力をチェックします。
     *
     * @param 存在するファイル List<RString>
     * @param 存在する調査票概況特記 List<RString>
     * @param 存在する調査票概況 List<RString>
     * @param 存在する主治医意見書 List<RString>
     * @param 存在するその他資料 List<RString>
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs do事前チェック(
            List<RString> 存在するファイル,
            List<RString> 存在する調査票概況特記,
            List<RString> 存在する調査票概況,
            List<RString> 存在する主治医意見書,
            List<RString> 存在するその他資料) {
        if (div.getChkImage().getSelectedKeys().isEmpty()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ImageValidationMessage.出力項目を指定));
            return validationMessages;
        }
        return doチェックByイメージ対象(存在するファイル, 存在する調査票概況特記, 存在する調査票概況, 存在する主治医意見書, 存在するその他資料);
    }

    private ValidationMessageControlPairs doチェックByイメージ対象(
            List<RString> 存在するファイル,
            List<RString> 存在する調査票概況特記ファイル,
            List<RString> 存在する調査票概況ファイル,
            List<RString> 存在する主治医意見書ファイル,
            List<RString> 存在するその他資料ファイル) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (存在するファイル.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ImageValidationMessage.存在しない));
            return validationMessages;
        }
        if (div.getChkImage().getSelectedKeys().contains(調査票) && 存在する調査票概況特記ファイル.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ImageValidationMessage.調査票));
        }
        if (div.getChkImage().getSelectedKeys().contains(調査票概況) && 存在する調査票概況ファイル.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ImageValidationMessage.調査票概況));
        }
        if (div.getChkImage().getSelectedKeys().contains(主治医意見書) && 存在する主治医意見書ファイル.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ImageValidationMessage.主治医意見書));
        }
        if (div.getChkImage().getSelectedKeys().contains(その他資料) && 存在するその他資料ファイル.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ImageValidationMessage.その他資料));
        }
        return validationMessages;
    }

    private enum ImageValidationMessage implements IValidationMessage {

        存在しない(UrErrorMessages.存在しない, "イメージファイル"),
        調査票(UrErrorMessages.存在しない, "調査票(概況+調査票特記)のイメージファイル"),
        調査票概況(UrErrorMessages.存在しない, "調査票概況のイメージファイル"),
        主治医意見書(UrErrorMessages.存在しない, "主治医意見書のイメージファイル"),
        その他資料(UrErrorMessages.存在しない, "その他資料のイメージファイル"),
        出力項目を指定(UrErrorMessages.出力項目を指定);

        private final Message message;

        private ImageValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

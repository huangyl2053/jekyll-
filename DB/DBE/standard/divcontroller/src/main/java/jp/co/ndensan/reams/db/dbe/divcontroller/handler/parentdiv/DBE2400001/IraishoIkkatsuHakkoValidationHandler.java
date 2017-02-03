/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 依頼書一括発行の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0080-010 duanzhanli
 */
public class IraishoIkkatsuHakkoValidationHandler {

    private static final RString STATE_NINTEI = new RString("1");
    private static final RString STATE_SHUJII = new RString("2");
    private static final RString KEY_2 = new RString("key2");
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY2 = new RString("2");

    private final IraishoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 依頼書一括発行Div
     */
    public IraishoIkkatsuHakkoValidationHandler(IraishoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     *
     * 依頼一覧をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs iraiItiranCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (STATE_NINTEI.equals(div.getState())
                && div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.対象行を選択),
                    div.getDgNinteiChosaIraiTaishoIchiran()));
        }
        if (STATE_SHUJII.equals(div.getState())
                && div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.対象行を選択),
                    div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran()));
        }

        return validationMessages;
    }

    /**
     *
     * 印刷帳票選択チェックボックスをチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs printChouhyouSentakuCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (STATE_NINTEI.equals(div.getState()) && isNinteiNoSelected()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.出力項目を指定), div.getNinteiChosaInsatsuChohyoSentaku()));
        }
        if (STATE_SHUJII.equals(div.getState()) && isShujiiNoSelected()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.出力項目を指定), div.getShujiiIkenshoInsatsuChohyo()));
        }

        return validationMessages;
    }

    private boolean isNinteiNoSelected() {
        return is適用なし(div.getChkChosahyoIraisho())
                && is適用なし(div.getChkChosahyoKatamen())
                && is適用なし(div.getChkChosahyoRyomen())
                && is適用なし(div.getChkChosahyoGaikyo())
                && is適用なし(div.getChkChosahyoSai())
                && is適用なし(div.getChkChosahyoTokki())
                && is適用なし(div.getChkChosaIraiHakko())
                && is適用なし(div.getChkChosaIraiRireki());
    }

    private boolean is適用なし(CheckBoxList chk) {
        return !(!chk.getSelectedKeys().isEmpty() && !chk.isDisplayNone());
    }

    private boolean isShujiiNoSelected() {
        return is適用なし(div.getChkIkenshoIraisho())
                && is適用なし(div.getChkIkensho())
                && is適用なし(div.getChkIkenshoSeikyusho())
                && is適用なし(div.getChkIkenshoSeikyuIchiran())
                && is適用なし(div.getChkIkenshoHakkoIchiran())
                && is適用なし(div.getChkIkenshoRirekiIchiran());
    }

    /**
     *
     * 共通日付テキストボックスをチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs commonDateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (KEY_2.equals(div.getRadTeishutsuKigen().getSelectedKey())
                && div.getTxtKyotsuHizuke().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.必須項目_追加メッセージあり, "共通日付"),
                    div.getTxtKyotsuHizuke()));
        }

        return validationMessages;
    }

    public ValidationMessageControlPairs validateTokkijiko() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (STATE_NINTEI.equals(div.getState())) {
            List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
            List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
            List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
            if ((調査票選択selectedKeys.contains(KEY2) || 調査票両面選択selectedKeys.contains(KEY2)) && !委託特記事項選択selectedKeys.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new IraishoIkkatsuHakkoMessages(UrErrorMessages.未指定, "認定調査票(特記事項)は1種類のみ"),
                        div.getChkChosahyoKatamen(), div.getChkChosahyoRyomen(), div.getChkChosahyoTokki()));
            }
        }
        return validPairs;
    }

    public ValidationMessageControlPairs validateIkenshoIraisho() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (STATE_SHUJII.equals(div.getState())) {
            RString 保険者市町村コード = div.getCcdNinteiChosaHokensha().getSelectedItem().get市町村コード().value();
            RString 請求書連動印刷 = DbBusinessConfig.get(
                    ConfigNameDBE.主治医意見書作成請求書連動印刷, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (CONFIGVALUE1.equals(請求書連動印刷)) {
                List<RString> 意見書依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
                List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
                if (意見書依頼書選択selectedKeys.isEmpty() && !請求書選択selectedKeys.isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(new IraishoIkkatsuHakkoMessages(UrErrorMessages.未指定, "主治医意見書作成依頼書を"),
                            div.getChkIkenshoIraisho()));
                } else if (!意見書依頼書選択selectedKeys.isEmpty() && 請求書選択selectedKeys.isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(new IraishoIkkatsuHakkoMessages(UrErrorMessages.未指定, "主治医意見書作成料請求書を"),
                            div.getChkIkenshoSeikyusho()));
                }
            }
        }
        return validPairs;
    }

    private static class IraishoIkkatsuHakkoMessages implements IValidationMessage {

        private final Message message;

        public IraishoIkkatsuHakkoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}

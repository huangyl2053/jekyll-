/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 依頼書・認定調査票(OCR)・主治医意見書印刷のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public class PrintValidationHandler {

    private static final RString KEY0 = new RString("0");
    private static final RString KEY2 = new RString("2");
    private static final RString CONFIGVALUE1 = new RString("1");
    private final ChosaIraishoAndChosahyoAndIkenshoPrintDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 依頼書・認定調査票(OCR)・主治医意見書印刷Div
     */
    public PrintValidationHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        this.div = div;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);

        if (GamenSeniKbn.認定調査依頼.equals(model.get遷移元画面区分())) {
            List<RString> 依頼書選択selectedKeys = div.getChkIraisho().getSelectedKeys();
            List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
            List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
            List<RString> 概況特記選択selectedKeys = div.getChkChosahyoGaikyo().getSelectedKeys();
            List<RString> 差異チェック票選択selectedKeys = div.getChkChosahyoSai().getSelectedKeys();
            List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();

            if (依頼書選択selectedKeys.isEmpty()
                    && 調査票選択selectedKeys.isEmpty()
                    && 調査票両面選択selectedKeys.isEmpty()
                    && 概況特記選択selectedKeys.isEmpty()
                    && 差異チェック票選択selectedKeys.isEmpty()
                    && 委託特記事項選択selectedKeys.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.出力項目を指定), div.getNinteiChosaPrint()));
            }

            if ((調査票選択selectedKeys.contains(KEY2) || 調査票両面選択selectedKeys.contains(KEY2)) && !委託特記事項選択selectedKeys.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.未指定, "認定調査票(特記事項)は1種類のみ"),
                        div.getChkChosahyoKatamen(), div.getChkChosahyoRyomen(), div.getChkChosahyoTokki()));
            }
        } else {
            List<RString> 意見書依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
            List<RString> 意見書選択selectedKeys = div.getChkIkensho().getSelectedKeys();
            List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
            List<RString> 診断命令書選択selectedKeys = div.getChkShindanMeireisho().getSelectedKeys();

            if (意見書依頼書選択selectedKeys.isEmpty()
                    && 意見書選択selectedKeys.isEmpty()
                    && 請求書選択selectedKeys.isEmpty()
                    && 診断命令書選択selectedKeys.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.出力項目を指定), div.getShujiiIkenshoPrint()));
            }

            RString selectKey = div.getRadJyushinKikan().getSelectedKey();
            if (!div.getShindanMeirei().isDisplayNone()) {
                if (KEY0.equals(selectKey)) {
                    if (div.getTxtJyushinymd().getValue() == null) {
                        validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "受診日"), div.getTxtJyushinymd()));
                    }
                    if (div.getTxtJushinTime().getValue() == null) {
                        validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "時分"), div.getTxtJushinTime()));
                    }
                } else {
                    if (div.getTxtJushinKikan().getFromValue() == null) {
                        validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "受診期間(開始日)"), div.getTxtJushinKikan()));
                    }
                    if (div.getTxtJushinKikan().getToValue() == null) {
                        validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "受診期間(終了日)"), div.getTxtJushinKikan()));
                    }
                }

                if (RString.isNullOrEmpty(div.getTxtJushinBasho().getValue())) {
                    validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "受診場所"), div.getTxtJushinBasho()));
                }
            }

            RString 保険者市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            RString 請求書連動印刷 = DbBusinessConfig.get(
                    ConfigNameDBE.主治医意見書作成請求書連動印刷, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (CONFIGVALUE1.equals(請求書連動印刷)) {
                if (意見書依頼書選択selectedKeys.isEmpty() && !請求書選択selectedKeys.isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.選択されていない, "主治医意見書作成料依頼書"), div.getChkIkenshoSeikyusho()));
                } else if (!意見書依頼書選択selectedKeys.isEmpty() && 請求書選択selectedKeys.isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.選択されていない, "依頼書"), div.getChkIkenshoIraisho()));
                }
            }
        }
        RString key = div.getRadTeishutsuKigen().getSelectedKey();
        if (KEY2.equals(key) && div.getTxtKyotsuDay().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "共通日付"), div.getTxtKyotsuDay()));
        }
        return validPairs;
    }

    public ValidationMessageControlPairs validateTokkijiko() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
        List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
        List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
        if ((調査票選択selectedKeys.contains(KEY2) || 調査票両面選択selectedKeys.contains(KEY2)) && !委託特記事項選択selectedKeys.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.未指定, "認定調査票(特記事項)は1種類のみ"),
                    div.getChkChosahyoKatamen(), div.getChkChosahyoRyomen(), div.getChkChosahyoTokki()));
        }
        return validPairs;
    }

    public ValidationMessageControlPairs validateIkenshoIraisho() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 保険者市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        RString 請求書連動印刷 = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書作成請求書連動印刷, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (CONFIGVALUE1.equals(請求書連動印刷)) {
            List<RString> 意見書依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
            if (意見書依頼書選択selectedKeys.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.未指定, "主治医意見書作成依頼書を"),
                        div.getChkIkenshoIraisho()));
            }
        }
        return validPairs;
    }

    private static class ValidationMessages implements IValidationMessage {

        private final Message message;

        public ValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

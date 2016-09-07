/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbe.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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

            List<dgNinteiChosa_Row> rowList = div.getDgNinteiChosa().getSelectedItems();
            if (rowList.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.対象行を選択), div.getDgNinteiChosa()));
            }

            List<RString> chk = div.getChk().getSelectedKeys();
            List<RString> chkChosahyo = div.getChkChosahyo().getSelectedKeys();
            List<RString> chkOcrChosahyo = div.getChkOcrChosahyo().getSelectedKeys();
            List<RString> chkChosahyo2 = div.getChkChosahyo2().getSelectedKeys();

            if (chk.isEmpty()
                    && chkChosahyo.isEmpty()
                    && chkOcrChosahyo.isEmpty()
                    && chkChosahyo2.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.出力項目を指定), div.getChk()));
            }
        } else {
            List<dgShujiiIkensho_Row> rowList = div.getDgShujiiIkensho().getSelectedItems();
            if (rowList.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.対象行を選択), div.getDgShujiiIkensho()));
            }
            List<RString> chkInsatsuIkensho = div.getChkInsatsuIkensho().getSelectedKeys();
            List<RString> chkIkenshoSakusei = div.getChkIkenshoSakuseiIchiran().getSelectedKeys();
            List<RString> chkIkenshoSakuseiryo = div.getChkIkenshoSakuseiryoSeikyusho().getSelectedKeys();
            if (chkInsatsuIkensho.isEmpty()
                    && chkIkenshoSakusei.isEmpty()
                    && chkIkenshoSakuseiryo.isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.出力項目を指定), div.getChkInsatsuIkensho()));
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
        }
        RString key = div.getRadTeishutsuKigen().getSelectedKey();
        if (KEY2.equals(key) && div.getTxtKyotsuDay().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new ValidationMessages(UrErrorMessages.必須項目_追加メッセージあり, "共通日付"), div.getTxtKyotsuDay()));
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

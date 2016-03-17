/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020005;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.NinteiChosaSchedule5MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.dgNinteiChosainList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.chosachiku.ChosaChikuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 地区認定調査員情報の抽象ValidationHandlerクラスです。
 */
public class MainPanelValidationHandler {

    private final NinteiChosaSchedule5MainDiv div;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 地区認定Div
     */
    public MainPanelValidationHandler(NinteiChosaSchedule5MainDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgNinteiChosainList_Row> rowList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();
        if (追加.equals(div.getNinteiChosainInput().getTxtJotai())) {
            if (!div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue().isNullOrEmpty()
                    && div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().getValue().isNullOrEmpty()) {
                validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "認定調査委託先コード")));
            }
            if (!div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue().isNullOrEmpty()
                    && div.getNinteiChosainInput().getTxtNinteiChosainMeisho().getValue().isNullOrEmpty()) {
                validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "認定調査員コード")));
            }
            boolean flg = ChosaChikuManager.createInstance().chosainCheck(new Code(div.getNinteiChosainPanel().getChosaChikuCode()),
                    div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue(),
                    div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue(),
                    new LasdecCode(div.getNinteiChosainPanel().getShichosonCode()));
            if (flg) {
                validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                        UrErrorMessages.既に登録済, "認定調査委託先コードと認定調査員コード")));
            }
            for (dgNinteiChosainList_Row row : rowList) {
                if (row.getNinteiChosaItakusakiCode().equals(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue())
                        && row.getNinteiChosainCode().equals(div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue())) {
                    validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                            UrErrorMessages.既に存在, "認定調査委託先コードと認定調査員コード")));
                }
            }
        }
        if (修正.equals(div.getNinteiChosainInput().getTxtJotai()) && div.getNinteiChosainInput().getHidYusenNo().equals(
                new RString(div.getNinteiChosainInput().getTxtYusenNo().getValue().toString()))
                && div.getNinteiChosainInput().getTxtBiko().getValue().equals(div.getNinteiChosainInput().getHidBiko())) {
            validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                    UrErrorMessages.編集なしで更新不可)));
        }
        return validationMessages;
    }

    /**
     * 保存するボタンが押下の場合、削除実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs btnUpdate_Del() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgNinteiChosainList_Row> rowList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();
        for (dgNinteiChosainList_Row list : rowList) {
            if (削除.equals(list.getJotai())) {
                boolean flg = ChosaChikuManager.createInstance().getCheck(new Code(div.getNinteiChosainPanel().getChosaChikuCode()),
                        list.getNinteiChosaItakusakiCode(), list.getNinteiChosainCode(),
                        new LasdecCode(div.getNinteiChosainPanel().getShichosonCode()));
                if (!flg) {
                    validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                            UrErrorMessages.削除不可, "地区認定調査員情報が他のDBにて使用されている")));
                }
            }
        }
        return validationMessages;
    }

    /**
     * 認定調査員一覧データの編集状態チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定調査員一覧Check() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                UrErrorMessages.編集なしで更新不可)));
        return validationMessages;
    }

    /**
     * データチェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs detaCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new MainPanelValidationHandler.RRVMessages(
                UrErrorMessages.該当データなし)));
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

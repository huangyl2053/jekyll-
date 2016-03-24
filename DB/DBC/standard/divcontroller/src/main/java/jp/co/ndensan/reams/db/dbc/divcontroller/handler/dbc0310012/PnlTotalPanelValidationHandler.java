/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_登録画面入力のチェックHandler。
 */
public class PnlTotalPanelValidationHandler {

    private final PnlTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div PnlTotalPanelDiv
     */
    public PnlTotalPanelValidationHandler(PnlTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(PnlTotalPanelValidationMessages.契約申請受付日未入力,
                        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi())
                .add(PnlTotalPanelValidationMessages.契約申請日未入力,
                        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi())
                .add(PnlTotalPanelValidationMessages.契約事業者番号未入力,
                        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo())
                .add(PnlTotalPanelValidationMessages.決定区分未入力,
                        div.getPnlCommon().getPnlDetail().getRdoKettekubun())
                .add(PnlTotalPanelValidationMessages.不承認理由未入力,
                        div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu())
                .add(PnlTotalPanelValidationMessages.年度未入力,
                        div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear())
                .add(PnlTotalPanelValidationMessages.番号1未入力,
                        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1())
                .add(PnlTotalPanelValidationMessages.番号2未入力,
                        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2())
                .add(PnlTotalPanelValidationMessages.金額不整合チェック,
                        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku(),
                        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku())
                .add(PnlTotalPanelValidationMessages.受領委任契約番号重複チェック,
                        div.getPnlCommon().getPnlDetail().getPnlHidari().getLblKeyakuNo())
                .add(PnlTotalPanelValidationMessages.存在チェック)
                .build();
    }

    private static class ControlValidator {

        private final PnlTotalPanelDiv div;

        public ControlValidator(PnlTotalPanelDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(PnlTotalPanelSpec.契約申請受付日)
                    .thenAdd(PnlTotalPanelValidationMessages.契約申請受付日未入力)
                    .ifNot(PnlTotalPanelSpec.契約申請日)
                    .thenAdd(PnlTotalPanelValidationMessages.契約申請日未入力)
                    .ifNot(PnlTotalPanelSpec.契約事業者番号)
                    .thenAdd(PnlTotalPanelValidationMessages.契約事業者番号未入力)
                    .ifNot(PnlTotalPanelSpec.決定区分)
                    .thenAdd(PnlTotalPanelValidationMessages.決定区分未入力)
                    .ifNot(PnlTotalPanelSpec.不承認理由)
                    .thenAdd(PnlTotalPanelValidationMessages.不承認理由未入力)
                    .ifNot(PnlTotalPanelSpec.年度)
                    .thenAdd(PnlTotalPanelValidationMessages.年度未入力)
                    .ifNot(PnlTotalPanelSpec.番号1)
                    .thenAdd(PnlTotalPanelValidationMessages.番号1未入力)
                    .ifNot(PnlTotalPanelSpec.番号2)
                    .thenAdd(PnlTotalPanelValidationMessages.番号2未入力)
                    .ifNot(PnlTotalPanelSpec.金額)
                    .thenAdd(PnlTotalPanelValidationMessages.金額不整合チェック)
                    .ifNot(PnlTotalPanelSpec.受領委任契約番号)
                    .thenAdd(PnlTotalPanelValidationMessages.受領委任契約番号重複チェック)
                    .ifNot(PnlTotalPanelSpec.存在)
                    .thenAdd(PnlTotalPanelValidationMessages.存在チェック)
                    .messages());
            return messages;
        }
    }

    private static enum PnlTotalPanelValidationMessages implements IValidationMessage {

        契約申請受付日未入力(UrErrorMessages.必須, "契約申請受付日"),
        契約申請日未入力(UrErrorMessages.必須, "契約申請日"),
        契約事業者番号未入力(UrErrorMessages.必須, "契約事業者番号"),
        決定区分未入力(UrErrorMessages.必須, "決定区分"),
        不承認理由未入力(UrErrorMessages.必須, "不承認理由"),
        年度未入力(UrErrorMessages.必須, "年度"),
        番号1未入力(UrErrorMessages.必須, "番号"),
        番号2未入力(UrErrorMessages.必須, "番号"),
        金額不整合チェック(UrErrorMessages.入力値が不正),
        受領委任契約番号重複チェック(UrErrorMessages.既に存在, "受領委任契約番号"),
        存在チェック(UrErrorMessages.既に登録済, "償還受領委任契約者");
        private final Message message;

        PnlTotalPanelValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

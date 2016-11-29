/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査依頼画面のバリデーションチェック処理を定義します。
 *
 * @author n8178
 */
public class NinteiChosaIraiValidationHandler {

    private static final RString MIWARITSUKE = new RString("未割付");

    /**
     * 割付済申請者が未指定かを検査します。
     *
     * @param pairs 割付済申請者が未指定である場合、このクラスにバリデーションメッセージが付与される。
     * @param div 認定調査依頼Div
     * @return 引数で受け取ったpairs
     */
    public ValidationMessageControlPairs validate割付済申請者未指定(ValidationMessageControlPairs pairs, NinteiChosaIraiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChosaIraiSpec.割付済申請者指定チェック)
                .thenAdd(NinteiChosaIraiValidationMessage.割付済申請者未指定).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NinteiChosaIraiValidationMessage.割付済申請者未指定,
                div.getDgWaritsukeZumiShinseishaIchiran())
                .build().check(messages));
        return pairs;
    }

    /**
     * 割り付けた申請者が認定調査依頼未割付かを検査します。
     *
     * @param pairs 割り付けた申請者が認定調査依頼未割付である場合、このクラスにバリデーションメッセージが付与される。
     * @param div 認定調査依頼Div
     * @return 引数で受け取ったpairs
     */
    public ValidationMessageControlPairs validate認定調査依頼未割付(ValidationMessageControlPairs pairs, NinteiChosaIraiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChosaIraiSpec.認定調査依頼割付済チェック)
                .thenAdd(NinteiChosaIraiValidationMessage.認定調査依頼未割付).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NinteiChosaIraiValidationMessage.認定調査依頼未割付,
                div.getDgWaritsukeZumiShinseishaIchiran())
                .build().check(messages));
        return pairs;
    }

    private enum NinnteiChosaIraiSpec implements IPredicate<NinteiChosaIraiDiv> {

        割付済申請者指定チェック {
                    /**
                     * 調査実施日の非空チェックです。
                     *
                     * @param div SaiketukekaTorokuPanelDiv
                     * @return true:調査実施日が非空です、false:調査実施日が空です。
                     */
                    @Override
                    public boolean apply(NinteiChosaIraiDiv div) {
                        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
                        return !selectedItems.isEmpty();
                    }
                },
        認定調査依頼割付済チェック {
                    /**
                     * 調査実施日の妥当性チェックです。
                     *
                     * @param div SaiketukekaTorokuPanelDiv
                     * @return true:調査実施日が妥当です、false:調査実施日が妥当でないです。
                     */
                    @Override
                    public boolean apply(NinteiChosaIraiDiv div) {
                        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
                        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
                            if (MIWARITSUKE.equals(row.getJotai())) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
    }

    private static enum NinteiChosaIraiValidationMessage implements IValidationMessage {

        割付済申請者未指定(DbeErrorMessages.割付済申請者未指定),
        認定調査依頼未割付(DbeErrorMessages.認定調査依頼未割付);
        private final Message message;

        private NinteiChosaIraiValidationMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

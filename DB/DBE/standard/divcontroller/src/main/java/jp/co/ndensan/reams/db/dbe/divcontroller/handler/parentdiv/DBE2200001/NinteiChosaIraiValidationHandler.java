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
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査依頼画面のバリデーションチェック処理を定義します。
 *
 * @author n8178
 */
public class NinteiChosaIraiValidationHandler {

    private static final RString 未割付 = new RString("未割付");
    private final NinteiChosaIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査依頼Div
     */
    public NinteiChosaIraiValidationHandler(NinteiChosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 依頼書等を印刷するボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーションチェック結果
     */
    public ValidationMessageControlPairs validate依頼書等を印刷するボタンクリック() {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(NinteiChosaIraiValidationMessage.割付済申請者未指定, div.getDgWaritsukeZumiShinseishaIchiran())
                .add(NinteiChosaIraiValidationMessage.認定調査依頼未割付, div.getDgWaritsukeZumiShinseishaIchiran())
                .build();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(dictionary.check(ValidateChain.validateStart(div).ifNot(NinnteiChosaIraiSpec.割付済申請者指定チェック)
                .thenAdd(NinteiChosaIraiValidationMessage.割付済申請者未指定).messages()));
        pairs.add(dictionary.check(ValidateChain.validateStart(div).ifNot(NinnteiChosaIraiSpec.認定調査依頼割付済チェック)
                .thenAdd(NinteiChosaIraiValidationMessage.認定調査依頼未割付).messages()));
        return pairs;
    }

    private enum NinnteiChosaIraiSpec implements IPredicate<NinteiChosaIraiDiv> {

        割付済申請者指定チェック {
                    /**
                     * 割付済申請者が指定されているかのチェックです。
                     *
                     * @param div NinteiChosaIraiDiv
                     * @return true:割付済申請者が指定されている場合　false:割付済申請者が指定されていない場合
                     */
                    @Override
                    public boolean apply(NinteiChosaIraiDiv div) {
                        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
                        return !selectedItems.isEmpty();
                    }
                },
        認定調査依頼割付済チェック {
                    /**
                     * 未割付の申請者が選択されていないかのチェックです。
                     *
                     * @param div NinteiChosaIraiDiv
                     * @return true:未割付の申請者が選択されていない場合　false:未割付の申請者が選択されている場合
                     */
                    @Override
                    public boolean apply(NinteiChosaIraiDiv div) {
                        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
                        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
                            if (未割付.equals(row.getJotai())) {
                                return false;
                            }
                        }
                        return true;
                    }
                };
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

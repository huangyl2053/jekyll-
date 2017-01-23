/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgWaritsukeZumiShinseishaIchiran_Row;
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
 * 主治医意見書作成依頼のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiValidationHandler {

    private final ShujiiIkenshoSakuseiIraiDiv div;
    private static final RString 未割付 = new RString("未割付");
    
    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     */
    public ShujiiIkenshoSakuseiIraiValidationHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        this.div = div;
    }
    
    public ValidationMessageControlPairs validate対象者検索ボタンクリック() {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(ShujiiIkenshoSakuseiIraiValidationMessage.主治医医療機関未指定, div.getDgWaritsukeZumiShinseishaIchiran())
                .add(ShujiiIkenshoSakuseiIraiValidationMessage.主治医未指定, div.getDgWaritsukeZumiShinseishaIchiran())
                .build();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(dictionary.check(ValidateChain.validateStart(div).ifNot(ShujiiIkenshoSakuseiIraiSpec.主治医医療機関未入力チェック)
                .thenAdd(ShujiiIkenshoSakuseiIraiValidationMessage.主治医医療機関未指定).messages()));
        pairs.add(dictionary.check(ValidateChain.validateStart(div).ifNot(ShujiiIkenshoSakuseiIraiSpec.主治医未入力チェック)
                .thenAdd(ShujiiIkenshoSakuseiIraiValidationMessage.主治医未指定).messages()));
        return pairs;
    }

    /**
     * 依頼書等を印刷するボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーションチェック結果
     */
    public ValidationMessageControlPairs validate依頼書等を印刷するボタンクリック() {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(ShujiiIkenshoSakuseiIraiValidationMessage.割付済申請者未指定, div.getDgWaritsukeZumiShinseishaIchiran())
                .add(ShujiiIkenshoSakuseiIraiValidationMessage.認定調査依頼未割付, div.getDgWaritsukeZumiShinseishaIchiran())
                .build();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(dictionary.check(ValidateChain.validateStart(div).ifNot(ShujiiIkenshoSakuseiIraiSpec.割付済申請者指定チェック)
                .thenAdd(ShujiiIkenshoSakuseiIraiValidationMessage.割付済申請者未指定).messages()));
        pairs.add(dictionary.check(ValidateChain.validateStart(div).ifNot(ShujiiIkenshoSakuseiIraiSpec.認定調査依頼割付済チェック)
                .thenAdd(ShujiiIkenshoSakuseiIraiValidationMessage.認定調査依頼未割付).messages()));
        return pairs;
    }

    private enum ShujiiIkenshoSakuseiIraiSpec implements IPredicate<ShujiiIkenshoSakuseiIraiDiv> {

        割付済申請者指定チェック {
                    /**
                     * 割付済申請者が指定されているかのチェックです。
                     *
                     * @param div ShujiiIkenshoSakuseiIraiDiv
                     * @return true:割付済申請者が指定されている場合　false:割付済申請者が指定されていない場合
                     */
                    @Override
                    public boolean apply(ShujiiIkenshoSakuseiIraiDiv div) {
                        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
                        return !selectedItems.isEmpty();
                    }
                },
        認定調査依頼割付済チェック {
                    /**
                     * 未割付の申請者が選択されていないかのチェックです。
                     *
                     * @param div ShujiiIkenshoSakuseiIraiDiv
                     * @return true:未割付の申請者が選択されていない場合　false:未割付の申請者が選択されている場合
                     */
                    @Override
                    public boolean apply(ShujiiIkenshoSakuseiIraiDiv div) {
                        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
                        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
                            if (未割付.equals(row.getJotai())) {
                                return false;
                            }
                        }
                        return true;
                    }
                },
        主治医医療機関未入力チェック {
                    /**
                     * 主治医医療機関未入力でないかのチェックです。
                     *
                     * @param div ShujiiIkenshoSakuseiIraiDiv
                     * @return true:主治医医療機関が入力済みの場合　false:主治医医療機関が未入力の場合
                     */
                    @Override
                    public boolean apply(ShujiiIkenshoSakuseiIraiDiv div) {
                        return !RString.isNullOrEmpty(div.getCcdShujiiIryoKikanAndShujiiInput().getIryoKikanCode());
                    }
                },
        主治医未入力チェック {
                    /**
                     * 主治医未入力でないかのチェックです。
                     *
                     * @param div ShujiiIkenshoSakuseiIraiDiv
                     * @return true:主治医が入力済みの場合　false:主治医が未入力の場合
                     */
                    @Override
                    public boolean apply(ShujiiIkenshoSakuseiIraiDiv div) {
                        return !RString.isNullOrEmpty(div.getCcdShujiiIryoKikanAndShujiiInput().getShujiiCode());
                    }
                };
    }

    private static enum ShujiiIkenshoSakuseiIraiValidationMessage implements IValidationMessage {

        割付済申請者未指定(DbeErrorMessages.割付済申請者未指定),
        認定調査依頼未割付(DbeErrorMessages.認定調査依頼未割付),
        主治医医療機関未指定(DbeErrorMessages.主治医医療機関未入力),
        主治医未指定(DbeErrorMessages.主治医未入力);
        private final Message message;

        private ShujiiIkenshoSakuseiIraiValidationMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

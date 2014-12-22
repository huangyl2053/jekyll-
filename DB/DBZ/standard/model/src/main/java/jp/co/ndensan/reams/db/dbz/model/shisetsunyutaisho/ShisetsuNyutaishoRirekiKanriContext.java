/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.入所日が未入力;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.退所日が未入力;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.入所年月日より前;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある;

import jp.co.ndensan.reams.ur.urz.model.validations.IContext;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;

/**
 *
 * @author N3327 三浦 凌
 */
public class ShisetsuNyutaishoRirekiKanriContext implements IContext {

    private final ValidationSpec spec;
    private final ViewExecutionStatus state;
    private final IOptional<ShisetsuNyutaishoModel> 前履歴;
    private final IOptional<ShisetsuNyutaishoModel> 次履歴;
    private final IItemList<ShisetsuNyutaishoModel> 全履歴;

    public ShisetsuNyutaishoRirekiKanriContext(ViewExecutionStatus state, IOptional<ShisetsuNyutaishoModel> 前履歴, IOptional<ShisetsuNyutaishoModel> 次履歴, IItemList<ShisetsuNyutaishoModel> 全履歴) {
        this.state = state;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
        this.全履歴 = 全履歴;
    }

    public ShisetsuNyutaishoRirekiKanriContext(ViewExecutionStatus state, IOptional<ShisetsuNyutaishoModel> 前履歴, IOptional<ShisetsuNyutaishoModel> 次履歴) {
        this.state = state;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
        this.全履歴 = ItemList.empty();
    }

    public ViewExecutionStatus getState() {
        return state;
    }

    public boolean shouldSkipValidation(IValidationMessage message) {
        return !spec.contains(message);
    }

    public IOptional<ShisetsuNyutaishoModel> get前履歴() {
        return this.前履歴;
    }

    public IOptional<ShisetsuNyutaishoModel> get次履歴() {
        return this.次履歴;
    }

    public IItemList<ShisetsuNyutaishoModel> get全履歴() {
        return this.全履歴;
    }

    private enum ValidationSpec {

        追加(ViewExecutionStatus.Add, 入所日が未入力, 入所年月日より前, 入所日と期間が重複する履歴がある, 退所日と期間が重複する履歴がある),
        修正(ViewExecutionStatus.Modify, 入所日が未入力, 入所年月日より前, 退所日と次の履歴データの入所日の期間が重複, 入所日と前の履歴データの退所日の期間が重複),
        なし(ViewExecutionStatus.None, null);

        private final ViewExecutionStatus state;
        private final List<IValidationMessage> messages;

        private ValidationSpec(ViewExecutionStatus state, IValidationMessage message, IValidationMessage... any) {
            this.state = state;
            List<IValidationMessage> list = new ArrayList<>();
            list.add(message);
            list.addAll(Arrays.asList(any));
            this.messages = Collections.unmodifiableList(list);
        }

        boolean contains(IValidationMessage messages) {
            return this.messages.contains(messages);
        }

        ViewExecutionStatus getState() {
            return this.state;
        }

        private static ValidationSpec toValue(ViewExecutionStatus e) {
            for (ValidationSpec value : values()) {
                if (value.getState() == e) {
                    return value;
                }
            }
            return なし;
        }
    }
}

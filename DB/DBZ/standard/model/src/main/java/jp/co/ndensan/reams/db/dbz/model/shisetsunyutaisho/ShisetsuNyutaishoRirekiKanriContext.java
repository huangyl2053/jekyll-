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
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複;
import jp.co.ndensan.reams.ur.urz.model.validations.IContext;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;

/**
 *
 * @author N3327 三浦 凌
 */
public class ShisetsuNyutaishoRirekiKanriContext implements IContext {

    private final ValidationSpec spec;
    private final 城間さんのenum state;
    private final IOptional<ShisetsuNyutaishoModel> 前履歴;
    private final IOptional<ShisetsuNyutaishoModel> 次履歴;

    public ShisetsuNyutaishoRirekiKanriContext(城間さんのenum state, IOptional<ShisetsuNyutaishoModel> 前履歴, IOptional<ShisetsuNyutaishoModel> 次履歴) {
        this.state = state;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
    }

    public 城間さんのenum getState() {
        return state;
    }

    // 城間さんのができたら消す。
    public enum 城間さんのenum {

        Added, Modified;
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

    private enum ValidationSpec {

        追加(城間さんのenum.Added, 入所日と前の履歴データの退所日の期間が重複),
        修正(城間さんのenum.Modified, 入所日と前の履歴データの退所日の期間が重複, 退所日と次の履歴データの入所日の期間が重複);
        private final 城間さんのenum state;
        private final List<IValidationMessage> messages;

        private ValidationSpec(城間さんのenum state, IValidationMessage message, IValidationMessage... any) {
            this.state = state;
            List<IValidationMessage> list = new ArrayList<>();
            list.add(message);
            list.addAll(Arrays.asList(any));
            this.messages = Collections.unmodifiableList(list);
        }

        boolean contains(IValidationMessage messages) {
            return this.messages.contains(messages);
        }

        城間さんのenum getState() {
            return this.state;
        }

        private static ValidationSpec toValue(城間さんのenum e) {
            for (ValidationSpec value : values()) {
                if (value.getState() == e) {
                    return value;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}

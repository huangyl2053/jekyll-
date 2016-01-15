/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.shisetsunyutaisho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.入所年月日より前;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.入所施設コードが未入力;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.入所施設名称が未入力;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.入所日が未入力;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.終了日設定なし;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある;
import static jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;

import jp.co.ndensan.reams.ur.urz.model.context.IContext;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;

/**
 *
 * @author N3327 三浦 凌
 */
public class ShisetsuNyutaishoRirekiKanriContext implements IContext {

    private final ValidationSpec spec;
    private final ViewExecutionStatus state;
    private final RString jigyoshaMeisho;
    private final Optional<ShisetsuNyutaishoModel> 前履歴;
    private final Optional<ShisetsuNyutaishoModel> 次履歴;
    private final IItemList<ShisetsuNyutaishoModel> 全履歴;

    /**
     * コンストラクタ
     *
     * @param state ViewExecutionStatus
     * @param jigyoshaMeisho RString
     * @param 前履歴 ShisetsuNyutaishoModel
     * @param 次履歴 ShisetsuNyutaishoModel
     * @param 全履歴 ShisetsuNyutaishoModelリスト
     */
    public ShisetsuNyutaishoRirekiKanriContext(ViewExecutionStatus state, RString jigyoshaMeisho,
            Optional<ShisetsuNyutaishoModel> 前履歴, Optional<ShisetsuNyutaishoModel> 次履歴, IItemList<ShisetsuNyutaishoModel> 全履歴) {
        this.state = state;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
        this.全履歴 = 全履歴;
    }

    /**
     * コンストラクタ
     *
     * @param state ViewExecutionStatus
     * @param jigyoshaMeisho RString
     * @param 前履歴 ShisetsuNyutaishoModel
     * @param 次履歴 ShisetsuNyutaishoModel
     */
    public ShisetsuNyutaishoRirekiKanriContext(ViewExecutionStatus state, RString jigyoshaMeisho,
            Optional<ShisetsuNyutaishoModel> 前履歴, Optional<ShisetsuNyutaishoModel> 次履歴) {
        this.state = state;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
        this.全履歴 = ItemList.empty();
    }

    /**
     * getState
     *
     * @return ViewExecutionStatus
     */
    public ViewExecutionStatus getState() {
        return state;
    }

    /**
     * shouldSkipValidation
     *
     * @param message IValidationMessage
     * @return boolean
     */
    public boolean shouldSkipValidation(IValidationMessage message) {
        return !spec.contains(message);
    }

    /**
     * getJigyoshaMeisho
     *
     * @return RString
     */
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * get前履歴
     *
     * @return ShisetsuNyutaishoModel
     */
    public Optional<ShisetsuNyutaishoModel> get前履歴() {
        return this.前履歴;
    }

    /**
     * get次履歴
     *
     * @return ShisetsuNyutaishoModel
     */
    public Optional<ShisetsuNyutaishoModel> get次履歴() {
        return this.次履歴;
    }

    /**
     * get全履歴
     *
     * @return ShisetsuNyutaishoModelリスト
     */
    public IItemList<ShisetsuNyutaishoModel> get全履歴() {
        return this.全履歴;
    }

    private enum ValidationSpec {

        追加(ViewExecutionStatus.Add, 入所日が未入力, 終了日設定なし, 入所施設コードが未入力, 入所施設名称が未入力, 入所年月日より前, 入所日と期間が重複する履歴がある, 退所日と期間が重複する履歴がある),
        修正(ViewExecutionStatus.Modify, 入所日が未入力, 終了日設定なし, 入所施設コードが未入力, 入所施設名称が未入力, 入所年月日より前, 退所日と次の履歴データの入所日の期間が重複, 入所日と前の履歴データの退所日の期間が重複),
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

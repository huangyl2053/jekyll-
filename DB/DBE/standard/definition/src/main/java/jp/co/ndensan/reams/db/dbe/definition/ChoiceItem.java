/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnswerResultItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 回答項目（選択項目）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChoiceItem implements IAnswerItem {

    private final IAnswerResultItem[] 選択肢;

    /**
     * インスタンスを生成します。
     *
     * @param 選択肢 選択肢
     */
    public ChoiceItem(IAnswerResultItem[] 選択肢) {
        this.選択肢 = requireNonNull(選択肢, Messages.E00001.replace("選択肢").getMessage());
    }

    @Override
    public IAnswerResultItem toValue(RString 値) {
        for (IAnswerResultItem data : 選択肢) {
            if (data.getCode().equals(値)) {
                return data;
            }
        }
        return null;
    }

    /**
     * 回答結果項目（選択結果項目）のリストを返します。
     *
     * @return 回答結果項目（選択結果項目）のリスト
     */
    public List<IAnswerResultItem> asList() {
        return Arrays.asList(選択肢);
    }
}

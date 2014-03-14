/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査項目に対する選択肢のリストを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class Choices implements IAnsweringItems {

    private final IAnsweringItem[] 選択肢;

    /**
     * インスタンスを生成します。
     *
     * @param 選択肢 選択肢
     */
    public Choices(IAnsweringItem[] 選択肢) {
        this.選択肢 = requireNonNull(選択肢, Messages.E00001.replace("選択肢").getMessage());
    }

    @Override
    public IAnsweringItem toValue(RString 値) {
        for (IAnsweringItem data : 選択肢) {
            if (data.getValue().equals(値)) {
                return data;
            }
        }
        return null;
    }

    @Override
    public List<IAnsweringItem> asList() {
        return Arrays.asList(選択肢);
    }
}

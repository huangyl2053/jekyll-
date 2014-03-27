/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定の各種項目に対する選択肢のリストを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class Choices {

    private final IAnsweringItem[] 選択肢;

    /**
     * インスタンスを生成します。
     *
     * @param 選択肢 選択肢
     */
    public Choices(IAnsweringItem[] 選択肢) {
        this.選択肢 = requireNonNull(選択肢, Messages.E00001.replace("選択肢").getMessage());
    }

    /**
     * 引数の値に該当する回答項目を返します。
     *
     * @param 値 値
     * @return 回答項目
     */
    public IAnsweringItem toValue(RString 値) {
        for (IAnsweringItem data : 選択肢) {
            if (data.getCode().equals(値)) {
                return data;
            }
        }
        return null;
    }

    /**
     * 回答項目のリストを返します。
     *
     * @return 回答項目のリスト
     */
    public List<IAnsweringItem> asList() {
        return Arrays.asList(選択肢);
    }
}

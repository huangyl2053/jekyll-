/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査票を扱うクラスです。
 *
 * @author N8156 宮本 康
 * @param <T> INinteichosaItem
 */
public class Ninteichosahyo<T extends INinteichosaItem> {

    private final Map<NinteichosaItemKubun, T> 調査票定義;
    private final INinteichosaItemGroup[] 調査項目グループ;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票定義 調査票定義
     * @param 調査項目グループ 調査項目グループ
     */
    public Ninteichosahyo(Map<NinteichosaItemKubun, T> 調査票定義, INinteichosaItemGroup[] 調査項目グループ) {
        this.調査票定義 = requireNonNull(調査票定義, Messages.E00001.replace("調査票定義").getMessage());
        this.調査項目グループ = requireNonNull(調査項目グループ, Messages.E00001.replace("調査項目グループ").getMessage());
    }

    /**
     * 引数の調査項目区分に該当する調査項目を返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査項目
     */
    public T get調査項目(NinteichosaItemKubun 調査項目区分) {
        return 調査票定義.get(調査項目区分);
    }

    /**
     * 引数の調査項目グループに該当する調査項目リストを返します。
     *
     * @param 調査項目グループ 調査項目グループ
     * @return 調査項目リスト
     */
    public List<T> get調査項目List(INinteichosaItemGroup 調査項目グループ) {
        List<T> list = new ArrayList<>();
        for (T 調査項目 : 調査票定義.values()) {
            if (調査項目.get調査項目グループ().equals(調査項目グループ)) {
                list.add(調査項目);
            }
        }
        return list;
    }

    /**
     * 全調査項目リストを返します。
     *
     * @return 調査項目リスト
     */
    public List<T> get調査項目ListAll() {
        List<T> list = new ArrayList<>();
        for (T 調査項目 : 調査票定義.values()) {
            list.add(調査項目);
        }
        return list;
    }

    /**
     * 調査項目グループを返します。
     *
     * @return 調査項目グループ
     */
    public INinteichosaItemGroup[] get調査項目グループ() {
        return 調査項目グループ.clone();
    }
}

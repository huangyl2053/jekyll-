/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査票情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 * @param <T> INinteichosaItem
 */
public class Ninteichosahyo<T extends INinteichosaItem> {

    private final Map<ChosahyoItems, T> 調査票項目Map;
    private final IChosahyoItemGroup[] 調査票項目グループ;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票項目Map 調査票項目Map
     * @param 調査票項目グループ 調査票項目グループ
     */
    public Ninteichosahyo(Map<ChosahyoItems, T> 調査票項目Map, IChosahyoItemGroup[] 調査票項目グループ) {
        this.調査票項目Map = requireNonNull(調査票項目Map, Messages.E00001.replace("調査票項目Map").getMessage());
        this.調査票項目グループ = requireNonNull(調査票項目グループ, Messages.E00001.replace("調査票項目グループ").getMessage());
    }

    /**
     * 引数の調査票項目に該当する調査項目情報を返します。
     *
     * @param 調査票項目 調査票項目
     * @return 調査項目情報
     */
    public T get調査項目(ChosahyoItems 調査票項目) {
        return 調査票項目Map.get(調査票項目);
    }

    /**
     * 引数の調査票項目グループに該当する調査項目情報リストを返します。
     *
     * @param 調査票項目グループ 調査票項目グループ
     * @return 調査項目情報リスト
     */
    public List<T> get調査項目List(IChosahyoItemGroup 調査票項目グループ) {
        List<T> list = new ArrayList<>();
        for (T 調査項目 : 調査票項目Map.values()) {
            if (調査項目.get調査票項目グループ().equals(調査票項目グループ)) {
                list.add(調査項目);
            }
        }
        return list;
    }

    /**
     * 全調査項目情報リストを返します。
     *
     * @return 調査項目情報リスト
     */
    public List<T> get調査項目ListAll() {
        List<T> list = new ArrayList<>();
        for (T 調査項目 : 調査票項目Map.values()) {
            list.add(調査項目);
        }
        return list;
    }

    /**
     * 調査票項目グループを返します。
     *
     * @return 調査票項目グループ
     */
    public IChosahyoItemGroup[] get調査票項目グループ() {
        return 調査票項目グループ.clone();
    }
}

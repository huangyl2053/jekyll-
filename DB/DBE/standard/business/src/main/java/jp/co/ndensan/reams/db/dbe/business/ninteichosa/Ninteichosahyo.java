/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaKomoku;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査票の情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class Ninteichosahyo {

    private final Map<ChosaKomoku, INinteichosaKomoku> 調査票項目Map;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票項目Map 調査票項目Map
     */
    public Ninteichosahyo(Map<ChosaKomoku, INinteichosaKomoku> 調査票項目Map) {
        this.調査票項目Map = requireNonNull(調査票項目Map, Messages.E00001.replace("調査票項目Map").getMessage());
    }

    /**
     * 引数の調査項目に該当する調査項目情報を返します。
     *
     * @param 調査項目 調査項目
     * @return 調査項目情報
     */
    public INinteichosaKomoku get調査項目(ChosaKomoku 調査項目) {
        return 調査票項目Map.get(調査項目);
    }

    /**
     * 引数の調査分類に該当する調査項目情報リストを返します。
     *
     * @param 調査分類 調査分類
     * @return 調査項目情報リスト
     */
    public List<INinteichosaKomoku> get調査項目List(ChosaBunrui 調査分類) {
        List<INinteichosaKomoku> list = new ArrayList<>();
        for (INinteichosaKomoku 調査項目 : 調査票項目Map.values()) {
            if (調査項目.get調査分類().equals(調査分類)) {
                list.add(調査項目);
            }
        }
        return list;
    }
}

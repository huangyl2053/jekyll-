/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.gappei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 合併市町村のコレクションクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonCollection implements Iterable<IGappeiShichoson> {

    private final List<IGappeiShichoson> 合併市町村リスト;

    /**
     * コンストラクタです。
     *
     * @param 合併市町村リスト 合併市町村リスト
     * @throws NullPointerException 引数がNullの時
     */
    public GappeiShichosonCollection(List<IGappeiShichoson> 合併市町村リスト) throws NullPointerException {
        this.合併市町村リスト = requireNonNull(合併市町村リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村リスト"));
    }

    /**
     * 合併市町村リストのサイズを返します。
     *
     * @return サイズ
     */
    public int getSize() {
        return 合併市町村リスト.size();
    }

    /**
     * 最新の合併市町村リストを返します。<br/>
     * 同一の旧市町村コードがある場合は、最新の合併市町村のみを対象とします。
     *
     * @return 合併市町村のコレクション
     */
    public GappeiShichosonCollection getLatestList() {
        Map<RString, IGappeiShichoson> map = new HashMap<>();
        for (IGappeiShichoson newData : 合併市町村リスト) {
            IGappeiShichoson oldData = map.get(newData.get旧市町村コード());
            if (oldData == null || oldData.get合併日().isBefore(newData.get合併日())) {
                map.put(newData.get旧市町村コード(), newData);
            }
        }
        return new GappeiShichosonCollection((List) Arrays.asList(map.values().toArray()));
    }

    @Override
    public Iterator<IGappeiShichoson> iterator() {
        return this.合併市町村リスト.iterator();
    }
}

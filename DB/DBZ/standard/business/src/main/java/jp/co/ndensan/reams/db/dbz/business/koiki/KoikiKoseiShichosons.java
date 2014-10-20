/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.koiki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.business.comparator.KoikiKoseiShichosonComparators;
import static java.util.Objects.requireNonNull;

/**
 * 広域構成市町村のコレクションクラスです。<br/>
 * （※別チケットで対応）
 *
 * @author N8156 宮本 康
 */
public class KoikiKoseiShichosons implements Iterable<IKoikiKoseiShichoson> {

    private final List<IKoikiKoseiShichoson> 広域構成市町村リスト;

    /**
     * コンストラクタです。
     *
     * @param 広域構成市町村リスト 広域構成市町村リスト
     * @throws NullPointerException 引数がNullの時
     */
    public KoikiKoseiShichosons(List<IKoikiKoseiShichoson> 広域構成市町村リスト) throws NullPointerException {
        this.広域構成市町村リスト = requireNonNull(広域構成市町村リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("広域構成市町村リスト"));
    }

    /**
     * 最新の広域構成市町村を返します。
     *
     * @return 広域構成市町村
     */
    public IKoikiKoseiShichoson getLatest() {
        if (広域構成市町村リスト.isEmpty()) {
            return null;
        }
        Collections.sort(広域構成市町村リスト, KoikiKoseiShichosonComparators.DESC);
        return 広域構成市町村リスト.get(0);
    }

    /**
     * 最古の広域構成市町村を返します。
     *
     * @return 広域構成市町村
     */
    public IKoikiKoseiShichoson getOldest() {
        if (広域構成市町村リスト.isEmpty()) {
            return null;
        }
        Collections.sort(広域構成市町村リスト, KoikiKoseiShichosonComparators.ASC);
        return 広域構成市町村リスト.get(0);
    }

    @Override
    public Iterator<IKoikiKoseiShichoson> iterator() {
        return this.広域構成市町村リスト.iterator();
    }
}

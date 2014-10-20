/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.gappei;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.business.comparator.GappeiJohoComparators;
import static java.util.Objects.requireNonNull;

/**
 * 合併情報のコレクションクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiJohoCollection implements Iterable<IGappeiJoho> {

    private final List<IGappeiJoho> 合併情報リスト;

    /**
     * コンストラクタです。
     *
     * @param 合併情報リスト 合併情報リスト
     * @throws NullPointerException 引数がNullの時
     */
    public GappeiJohoCollection(List<IGappeiJoho> 合併情報リスト) throws NullPointerException {
        this.合併情報リスト = requireNonNull(合併情報リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報リスト"));
    }

    /**
     * 最新の合併情報を返します。
     *
     * @return 合併情報
     */
    public IGappeiJoho getLatest() {
        if (合併情報リスト.isEmpty()) {
            return null;
        }
        Collections.sort(合併情報リスト, GappeiJohoComparators.DESC);
        return 合併情報リスト.get(0);
    }

    /**
     * 最新の合併情報リストを返します。<br/>
     * 同一の地域番号がある場合は、最新の合併情報のみを対象とします。
     *
     * @return 合併情報のコレクション
     */
    public GappeiJohoCollection getLatestList() {
        Map<RString, IGappeiJoho> map = new HashMap<>();
        for (IGappeiJoho newData : 合併情報リスト) {
            IGappeiJoho oldData = map.get(newData.get地域番号());
            if (oldData == null || oldData.get合併日().isBefore(newData.get合併日())) {
                map.put(newData.get地域番号(), newData);
            }
        }
        return new GappeiJohoCollection((List) Arrays.asList(map.values().toArray()));
    }

    @Override
    public Iterator<IGappeiJoho> iterator() {
        return this.合併情報リスト.iterator();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 被保険者のリストを扱うです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaList implements Iterable {

    private final List<Hihokensha> 被保険者リスト;

    /**
     * 被保険者のlistから、HihokenshaListを生成します。
     *
     * @param hihokenshaList 被保険者のlist
     */
    public HihokenshaList(List<Hihokensha> hihokenshaList) {
        被保険者リスト = Objects.requireNonNull(hihokenshaList,
                Messages.E00003.replace("リスト", "被保険者リスト").getMessage());
    }

    /**
     * 市町村コードと被保険者番号から、該当する被保険者を抽出します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 該当する被保険者
     */
    public Hihokensha get被保険者(ShichosonCode 市町村コード, KaigoHihokenshaNo 被保険者番号) {
        for (Hihokensha 被保険者 : 被保険者リスト) {
            // TODO n3327 三浦凌 Hihokenshaのget被保険者番号()の戻り値をKaigoHihokenshaNoに修正したら、下の条件も直す。
            if (被保険者.get市町村コード().equals(市町村コード) && 被保険者.get被保険者番号().equals(被保険者番号.getValue())) {
                return 被保険者;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("該当する被保険者").getMessage());
    }

    @Override
    public Iterator iterator() {
        return this.被保険者リスト.iterator();
    }

    /**
     * リストの要素数を取得します。
     *
     * @return リストの要素数
     */
    public int size() {
        return 被保険者リスト.size();
    }
}

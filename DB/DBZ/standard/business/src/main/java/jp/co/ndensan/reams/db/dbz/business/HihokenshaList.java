/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.Iterator;
import java.util.List;

/**
 * {@link Hihokensha Hihokensha}のリストを扱います。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaList implements Iterable<Hihokensha> {

    private final List<Hihokensha> list;

    /**
     * {@code List<Hihokensha>}から、HihokenshaListを生成します。
     *
     * @param hihokenshaList {@link Hihokensha 被保険者}の{@link List リスト}
     */
    public HihokenshaList(List<Hihokensha> hihokenshaList) {
        this.list = hihokenshaList;
    }

    /**
     * 被保険者数を返します。
     *
     * @return 被保険者数
     */
    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<Hihokensha> iterator() {
        return this.list.iterator();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteisaikinshorisha;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 複数の{@link NinteiSaikinShorisha}を扱います。
 */
public class NinteiSaikinShorishas implements Serializable, Iterable<NinteiSaikinShorisha> {

    private final Map<RString, NinteiSaikinShorisha> elements;

    /**
     * @param entities 複数の{@link DbT7501NinteiSaikinShorishaEntity}
     */
    public NinteiSaikinShorishas(Iterable<? extends DbT7501NinteiSaikinShorishaEntity> entities) {
        Map<RString, NinteiSaikinShorisha> map = new LinkedHashMap<>();
        for (DbT7501NinteiSaikinShorishaEntity entity : entities) {
            NinteiSaikinShorisha n = new NinteiSaikinShorisha(entity);
            map.put(n.getKey(), n);
        }
        this.elements = Collections.unmodifiableMap(map);
    }

    /**
     * @param key 検索対象のキー
     * @return 指定のキーに該当する{@link NinteiSaikinShorisha}
     */
    public NinteiSaikinShorisha find(RString key) {
        return this.elements.get(key);
    }

    @Override
    public Iterator<NinteiSaikinShorisha> iterator() {
        return this.elements.values().iterator();
    }

}

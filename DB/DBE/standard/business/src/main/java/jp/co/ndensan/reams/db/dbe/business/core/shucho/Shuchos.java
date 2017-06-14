/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shucho;

import java.util.Collections;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 複数の首長名を扱います。
 */
public final class Shuchos {

    private final Map<RString, RString> elements;

    public Shuchos(Map<RString, ? extends RString> elements) {
        this.elements = Collections.unmodifiableMap(elements);
    }

    /**
     * @param 証記載保険者番号 証記載保険者番号
     * @return 首長名
     */
    public RString getNameBy証記載保険者番号(RString 証記載保険者番号) {
        if (elements.containsKey(証記載保険者番号)) {
            return elements.get(証記載保険者番号);
        }
        return RString.EMPTY;
    }

}

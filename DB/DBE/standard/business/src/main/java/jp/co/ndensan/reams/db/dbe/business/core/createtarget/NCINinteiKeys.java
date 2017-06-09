/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NCINinteiKey}を管理します。枝番を連番で振り出します。
 */
public class NCINinteiKeys {

    private final Map<NCINinteiSubKey, LinkedList<NCINinteiKey>> keys;

    /**
     * 空のインスタンスを生成します。
     */
    public NCINinteiKeys() {
        this.keys = new HashMap<>();
    }

    /**
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     * @return 指定の値に対応する新しい枝番を持った{@link NCINinteiKey}
     */
    public NCINinteiKey generateKey(RString 保険者番号, RString 被保険者番号, FlexibleDate 認定申請日) {
        return generateKey(
                new NCINinteiSubKey(
                        保険者番号,
                        被保険者番号,
                        new RString(ObjectUtil.defaultIfNull(認定申請日, FlexibleDate.EMPTY).toString())
                ));
    }

    /**
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     * @return 指定の値に対応する新しい枝番を持った{@link NCINinteiKey}
     */
    public NCINinteiKey generateKey(RString 保険者番号, RString 被保険者番号, RString 認定申請日) {
        return generateKey(new NCINinteiSubKey(保険者番号, 被保険者番号, 認定申請日));
    }

    private NCINinteiKey generateKey(NCINinteiSubKey subKey) {
        NCINinteiKey key = findKey(subKey, keys);
        if (!keys.containsKey(subKey)) {
            keys.put(subKey, new LinkedList<NCINinteiKey>());
        }
        keys.get(subKey).addLast(key);
        return key;
    }

    private static NCINinteiKey findKey(NCINinteiSubKey subKey, Map<NCINinteiSubKey, LinkedList<NCINinteiKey>> keys) {
        return keys.containsKey(subKey) ? keys.get(subKey).getLast().next() : NCINinteiKey.first(subKey);
    }

}

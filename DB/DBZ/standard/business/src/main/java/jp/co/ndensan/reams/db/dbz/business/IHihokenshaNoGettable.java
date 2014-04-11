/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;

/**
 * {@link KaigoHihokenshaNo 介護保険被保険者番号}が取得可能であることをあらわします。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaNoGettable {

    /**
     * 介護保険の被保険者番号を返します。
     *
     * @return {@link KaigoHihokenshaNo 介護保険被保険者番号}
     */
    KaigoHihokenshaNo get被保険者番号();
}

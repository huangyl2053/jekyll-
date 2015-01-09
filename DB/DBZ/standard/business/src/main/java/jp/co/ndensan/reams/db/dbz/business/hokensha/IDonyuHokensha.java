/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.db.dbz.model.hokensha.IHokensha;

/**
 * Reams導入保険者であることを表します。
 *
 * @author N3327 三浦 凌
 */
public interface IDonyuHokensha extends IHokensha {

    /**
     * 保険者の名称を返します。
     *
     * @return 保険者名称
     */
    HokenshaName get保険者名();

    /**
     * 広域保険者かどうかを返します。
     *
     * @return 広域保険者なら{@code true}、そうでないなら{@code false}
     */
    boolean is広域保険者();

    /**
     * {@link HokenshaKosei 保険者構成}を返します。
     *
     * @return {@link HokenshaKosei 保険者構成}
     */
    HokenshaKosei get保険者構成();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;

/**
 * 住所の編集方法を持ちます。
 *
 * @author N3327 三浦 凌
 */
public interface IHowToEditJusho {

    /**
     *
     * @return
     */
    GunNamePrint for群名();

    /**
     *
     * @return
     */
    TodofukenNamePrint for都道府県名();

    /**
     *
     * @return
     */
    ShichosonNamePrint for市町村名();

    /**
     *
     * @return
     */
    KatagakiPrint for方書();

    /**
     *
     * @return
     */
    JushoEditPattern for住所();
}

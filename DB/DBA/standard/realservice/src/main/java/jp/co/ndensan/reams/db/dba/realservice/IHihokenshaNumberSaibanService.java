/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;

/**
 * 被保険者番号を採番するインタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaNumberSaibanService {

    /**
     * 新しい介護保険被保険者番号を採番して返します。
     *
     * @return 介護保険被保険者番号
     */
    KaigoHihokenshaNo createNewNumber();
}

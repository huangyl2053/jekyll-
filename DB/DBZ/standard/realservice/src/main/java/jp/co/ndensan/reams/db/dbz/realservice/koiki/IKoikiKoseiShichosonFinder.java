/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koiki;

import java.util.List;

/**
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichosonFinder {

    /**
     * 旧市町村を含む、広域構成市町村をすべて返します。
     *
     * @return 広域構成市町村(旧市町村を含む)
     */
    List/*<KoikiKoseiShichosonModel>*/ get全広域構成市町村();

    /**
     * 旧市町村を含まない、広域構成市町村をすべて返します。
     *
     * @return 広域構成市町村(旧市町村を含まない)
     */
    List get現広域構成市町村();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.model.hokensha.IKoikiKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;

/**
 * 広域構成市町村に関する情報を取得できます。
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichosonFinder {

    /**
     * 旧市町村を含む、広域構成市町村をすべて返します。
     *
     * @param contains合併旧市町村
     * @return 広域構成市町村(旧市町村を含む)
     */
    IItemList<IKoikiKoseiShichosonMaster> load広域構成市町村(ContainsKyuShichoson contains合併旧市町村);

    /**
     *
     * @param searchCondition
     * @return
     */
    IOptional<IKoikiKoseiShichosonMaster> find構成市町村(IKoikiKoseiShichosonSearchCondition searchCondition);
}

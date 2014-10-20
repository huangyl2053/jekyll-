/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koiki;

import jp.co.ndensan.reams.db.dbz.model.koiki.KoikiKoseiShichosonModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * 広域構成市町村に関する情報を取得できます。
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichosonFinder {

    /**
     * 旧市町村を含む、広域構成市町村をすべて返します。
     *
     * @return 広域構成市町村(旧市町村を含む)
     */
    IItemList<KoikiKoseiShichosonModel> load広域構成市町村(ContainsKyuShichoson contains合併旧市町村);

    /**
     *
     * @param searchCondition
     * @return
     */
    IOptional<KoikiKoseiShichosonModel> find構成市町村(IKoikiKoseiShichosonSearchCondition searchCondition);
}

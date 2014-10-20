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
 * 広域構成市町村を管理します。
 *
 * @author N3327 三浦 凌
 */
public final class KoikiKoseiShichosonManager implements IKoikiKoseiShichosonFinder {

    @Override
    public IItemList<KoikiKoseiShichosonModel> load広域構成市町村(ContainsKyuShichoson contains合併旧市町村) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOptional<KoikiKoseiShichosonModel> find構成市町村(IKoikiKoseiShichosonSearchCondition searchCondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int save(KoikiKoseiShichosonModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

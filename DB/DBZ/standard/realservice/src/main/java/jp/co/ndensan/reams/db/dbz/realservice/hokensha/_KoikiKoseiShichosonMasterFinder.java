/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.util.function.Functions;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.model.hokensha.IKoikiKoseiShichosonMaster;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;

/**
 *
 * @author N3327 三浦 凌
 */
public class _KoikiKoseiShichosonMasterFinder implements IKoikiKoseiShichosonMasterFinder {

    private final KoseiShichosonShishoMasterManager manager;

    _KoikiKoseiShichosonMasterFinder(KoseiShichosonShishoMasterManager manager) {
        this.manager = manager;
    }

    @Override
    public IItemList<IKoikiKoseiShichosonMaster> load広域構成市町村(ContainsKyuShichoson contains合併旧市町村) {
        return manager.load広域構成市町村(contains合併旧市町村).map(Functions.toParent(IKoikiKoseiShichosonMaster.class));
    }

    @Override
    public IOptional<IKoikiKoseiShichosonMaster> find構成市町村(ISearchCondition searchCondition) {
        return manager.find構成市町村(searchCondition).map(Functions.toParent(IKoikiKoseiShichosonMaster.class));
    }
}

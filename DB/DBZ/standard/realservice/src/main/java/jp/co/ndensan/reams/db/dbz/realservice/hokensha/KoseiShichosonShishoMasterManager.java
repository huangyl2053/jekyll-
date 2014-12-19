/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7052KoseiShichosonShishoMasterDac;

/**
 * 広域構成市町村を管理します。
 *
 * @author N3327 三浦 凌
 */
public final class KoseiShichosonShishoMasterManager {

    private final DbT7052KoseiShichosonShishoMasterDac dac;

    /**
     *
     */
    public KoseiShichosonShishoMasterManager() {
        this.dac = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    /**
     *
     */
    KoseiShichosonShishoMasterManager(DbT7052KoseiShichosonShishoMasterDac dac) {
        this.dac = dac;
    }

    public IItemList<KoseiShichosonMasterModel> load広域構成市町村(ContainsKyuShichoson contains合併旧市町村) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IOptional<KoseiShichosonMasterModel> find構成市町村(IKoikiKoseiShichosonSearchCondition searchCondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int save(KoseiShichosonMasterModel model) {
        //model の stateによって、処理を返る。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

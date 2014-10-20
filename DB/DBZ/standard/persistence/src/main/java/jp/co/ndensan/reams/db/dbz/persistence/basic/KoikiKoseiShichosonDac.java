/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.koiki.KoikiKoseiShichosonModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author N3327 三浦 凌
 */
public class KoikiKoseiShichosonDac {

    @InjectSession
    private SqlSession session;

    @Transaction
    public List<KoikiKoseiShichosonModel> select広域構成市町村(boolean contains合併旧市町村) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return Collections.emptyList();
    }

    /**
     *
     * @param criteria
     * @return
     */
    public KoikiKoseiShichosonModel selectForm(ITrueFalseCriteria criteria) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        //本来ならentity,                        本来ならentityに対応するColumnDifinition
        Object result = accessor.select().table((Class<? extends Enum>) null)
                .where(criteria)
                .toObject(Object.class);
        if (result == null) {
            return null;
        }
        return new KoikiKoseiShichosonModel(/*result*/);
    }

}

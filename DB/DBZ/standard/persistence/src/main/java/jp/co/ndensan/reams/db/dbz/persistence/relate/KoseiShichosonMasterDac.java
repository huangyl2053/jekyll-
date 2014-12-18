/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 広域構成市町村マスタのDACです。
 *
 * @author N3327 三浦 凌
 */
public class KoseiShichosonMasterDac {

    @InjectSession
    private SqlSession session;
    private final DbT7051KoseiShichosonMasterDac dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);

    /**
     * @param shichosonType {@link GappeiKyuShichosonKubun}
     * @return KoseiShichosonMasterModels as Itemlist
     */
    @Transaction
    public IItemList<KoseiShichosonMasterModel> selectBy(GappeiKyuShichosonKubun shichosonType) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> result = accessor
                .select()
                .table(DbT7051KoseiShichosonMaster.class)
                .where(eq(gappeiKyuShichosonKubun, shichosonType))
                .toList(DbT7051KoseiShichosonMasterEntity.class);
        return ItemList.of(result).map(toModel());
    }

    /**
     * @param criteria {@link ITrueFalseCriteria}
     * @return KoseiShichosonMasterModels as Itemlist
     */
    @Transaction
    public IItemList<KoseiShichosonMasterModel> selectForm(ITrueFalseCriteria criteria) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> result = accessor
                .select()
                .table(DbT7051KoseiShichosonMaster.class)
                .where(criteria)
                .toList(DbT7051KoseiShichosonMasterEntity.class);
        return ItemList.of(result).map(toModel());
    }

    private IFunction<DbT7051KoseiShichosonMasterEntity, KoseiShichosonMasterModel> toModel() {
        return new IFunction<DbT7051KoseiShichosonMasterEntity, KoseiShichosonMasterModel>() {
            @Override
            public KoseiShichosonMasterModel apply(DbT7051KoseiShichosonMasterEntity t) {
                return new KoseiShichosonMasterModel(t);
            }
        };
    }
}

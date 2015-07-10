/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
public class KoseiShichosonMasterDac implements IModifiable<KoseiShichosonMasterModel> {

    @InjectSession
    private SqlSession session;
    private final DbT7051KoseiShichosonMasterDac dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);

    /**
     * {@link ContainsKyuShichoson 旧市町村を含むか、含まないか}を指定して、構成市町村の情報を検索し、返します。
     *
     * @param containsKyuShichoson {@link ContainsKyuShichoson 旧市町村を含むか、含まないか}
     * @return {@link KoseiShichosonMasterModel 構成市町村情報}のlist
     */
    @Transaction
    public IItemList<KoseiShichosonMasterModel> selectBy(ContainsKyuShichoson containsKyuShichoson) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> result;
        if (containsKyuShichoson.equals(ContainsKyuShichoson.旧市町村を含まない)) {
            result = accessor
                    .select()
                    .table(DbT7051KoseiShichosonMaster.class)
                    .where(not(eq(gappeiKyuShichosonKubun, GappeiKyuShichosonKubun.合併旧市町村.code())))
                    .toList(DbT7051KoseiShichosonMasterEntity.class);
        } else {
            result = dac.selectAll();
        }
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

    /**
     * 指定の{@link LasdecCode}に該当する市町村を検索して、返します。
     * {@link ContainsKyuShichoson}が{@link ContainsKyuShichoson#旧市町村を含む}の場合、旧市町村も検索対象とします。
     *
     * @param code {@link LasdecCode}
     * @param containsKyuShichoson {@link ContainsKyuShichoson 旧市町村を含むか、含まないか}
     * @return {@link KoseiShichosonMasterModel 構成市町村情報}のlist
     */
    @Transaction
    public IItemList<KoseiShichosonMasterModel> selectBy(LasdecCode code, ContainsKyuShichoson containsKyuShichoson) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> result;
        if (containsKyuShichoson.equals(ContainsKyuShichoson.旧市町村を含まない)) {
            result = accessor
                    .select()
                    .table(DbT7051KoseiShichosonMaster.class)
                    .where(and(not(eq(gappeiKyuShichosonKubun, GappeiKyuShichosonKubun.合併旧市町村.code())),
                                    eq(shichosonCode, code)))
                    .toList(DbT7051KoseiShichosonMasterEntity.class);
        } else {
            result = accessor
                    .select()
                    .table(DbT7051KoseiShichosonMaster.class)
                    .where(eq(shichosonCode, code))
                    .toList(DbT7051KoseiShichosonMasterEntity.class);
        }
        return ItemList.of(result).map(toModel());
    }

    /**
     * {@link ITrueFalseCriteria 検索条件}に該当する構成市町村情報をすべて返します。
     *
     * @param criteria {@link ITrueFalseCriteria 検索条件}
     * @return {@link KoseiShichosonMasterModel 構成市町村情報}のlist
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

    @Override
    public int update(KoseiShichosonMasterModel model) {
        int result = 0;
        if (model == null) {
            return result;
        }
        return dac.update(model.getEntity());
    }

    @Override
    public int insert(KoseiShichosonMasterModel model) {
        int result = 0;
        if (model == null) {
            return result;
        }
        result = dac.insert(model.getEntity());
        return result;
    }

    @Override
    public int delete(KoseiShichosonMasterModel model) {
        int result = 0;
        if (model == null) {
            return result;
        }
        result = dac.delete(model.getEntity());
        return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.model.koiki.KoikiKoseiShichosonModel;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 広域構成市町村マスタのDACです。
 *
 * @author N3327 三浦 凌
 */
public class KoikiKoseiShichosonDac {

    @InjectSession
    private SqlSession session;

    /**
     * 広域構成市町村
     *
     * @param shichosonType
     * @return
     */
    @Transaction
    public List<KoikiKoseiShichosonModel> select広域構成市町村(GappeiKyuShichosonKubun shichosonType) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> result = accessor
                .select()
                .table(DbT7051KoseiShichosonMaster.class)
                .where(eq(DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun, shichosonType.code()))
                .toList(DbT7051KoseiShichosonMasterEntity.class);
        return toModelList(result);
    }

    /**
     *
     * @param criteria
     * @return
     */
    public List<KoikiKoseiShichosonModel> selectForm(ITrueFalseCriteria criteria) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> result = accessor
                .select()
                .table(DbT7051KoseiShichosonMaster.class)
                .where(criteria)
                .toList(DbT7051KoseiShichosonMasterEntity.class);
        return toModelList(result);
    }

    private List<KoikiKoseiShichosonModel> toModelList(List<DbT7051KoseiShichosonMasterEntity> entities) {
        List<KoikiKoseiShichosonModel> list = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entities) {
            list.add(new KoikiKoseiShichosonModel(entity));
        }
        return list;
    }
}

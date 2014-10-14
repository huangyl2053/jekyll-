
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * みなし2号者台帳のデータアクセスクラスです。
 *
 * @author n8211 田辺 紘一
 */
public class Minashi2GoshaDaichoDac implements IMinashi2GoshaDaichoDac {

    @InjectSession
    private SqlSession session;

    @Override
    @Transaction
    public List<DbT1012Minashi2GoshaDaichoEntity> select(ITrueFalseCriteria criteria) {
        DbAccessorNormalType selector = new DbAccessorNormalType(session);

        return selector
                .select()
                .table(DbT1012Minashi2GoshaDaicho.class)
                .where(criteria)
                .toList(DbT1012Minashi2GoshaDaichoEntity.class);
    }

    @Override
    @Transaction
    public int insert(DbT1012Minashi2GoshaDaichoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

}

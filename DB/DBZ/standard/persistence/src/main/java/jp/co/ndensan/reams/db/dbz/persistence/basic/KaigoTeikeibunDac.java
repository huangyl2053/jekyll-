/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJoho.*;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 定型文情報を取得するDacです。
 *
 * @author n9606 漢那 憲作
 */
public class KaigoTeikeibunDac implements IReplaceable<DbT7103TeikeibunJohoEntity>,
        IDeletable<DbT7103TeikeibunJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定した定型区分に該当する定型文Entityのリストを取得します。
     *
     * @param teikeiKbn 定型区分
     * @return 定型文EntityのList
     */
    @Transaction
    public List<DbT7103TeikeibunJohoEntity> select(RString teikeiKbn) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT7103TeikeibunJoho.class).
                where(eq(teikeiKubun, teikeiKbn)).
                order(by(teikeibunCd, Order.ASC)).
                toList(DbT7103TeikeibunJohoEntity.class);
    }

    /**
     * 指定した定型区分、定型種別に該当する定型文Entityのリストを取得します。
     *
     * @param teikeiKbn 定型区分
     * @param teikeiShubetsu 定型種別
     * @return 定型文EntityのList
     */
    @Transaction
    public List<DbT7103TeikeibunJohoEntity> select(RString teikeiKbn,
            RString teikeiShubetsu) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT7103TeikeibunJoho.class).
                where(and(eq(teikeiKubun, teikeiKbn),
                                eq(shubetsu, teikeiShubetsu))).
                order(by(teikeibunCd, Order.ASC)).
                toList(DbT7103TeikeibunJohoEntity.class);
    }

    /**
     * 指定した定型区分、定型種別、定型文コードに該当する定型文Entityを取得します。
     *
     * @param teikeiKbn 定型区分
     * @param teikeiShubetsu 定型種別
     * @param teikeibunCode 定型文コード
     * @return 定型文EntityのList
     */
    @Transaction
    public DbT7103TeikeibunJohoEntity select(RString teikeiKbn,
            RString teikeiShubetsu, RString teikeibunCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT7103TeikeibunJoho.class).
                where(and(eq(teikeiKubun, teikeiKbn),
                                eq(shubetsu, teikeiShubetsu),
                                eq(teikeibunCd, teikeibunCode))).
                order(by(teikeibunCd, Order.ASC)).
                toObject(DbT7103TeikeibunJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT7103TeikeibunJohoEntity entity) {
        if (getMatchRowCount(entity) == 0) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    /**
     * 定型文情報に対し、追加を行います。
     *
     * @param entity 定型文Entity
     * @return 追加結果
     */
    @Override
    @Transaction
    public int insert(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);
        return dbAccessor.insert(entity).execute();
    }

    /**
     * 定型文情報に対し、更新を行います。
     *
     * @param entity 定型文Entity
     * @return 更新結果
     */
    @Override
    @Transaction
    public int update(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);
        return dbAccessor.update(entity).execute();
    }

    /**
     * 定型文情報に対し、削除を行います。
     *
     * @param entity 定型文Entity
     * @return 削除結果
     */
    @Override
    @Transaction
    public int delete(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);
        return dbAccessor.deletePhysical(entity).execute();
    }

    /**
     * 定型文情報の件数を取得します。
     *
     * @param entity 定型文Entity
     * @return 取得件数
     */
    private int getMatchRowCount(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);

        return dbAccessor.
                select().
                table(DbT7103TeikeibunJoho.class).
                where(and(eq(DbT7103TeikeibunJoho.teikeiKubun, entity.getTeikeiKubun()),
                                eq(DbT7103TeikeibunJoho.shubetsu, entity.getShubetsu()),
                                eq(DbT7103TeikeibunJoho.teikeibunCd, entity.getTeikeibunCd()))).getCount();
    }
}

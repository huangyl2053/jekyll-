/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJoho.kaigoIryokikanCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関情報　継承のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7011ShujiiIryoKikanJohoDac implements IModifiable<DbT7011ShujiiIryoKikanJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医医療機関情報　継承を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 介護医療機関コード KaigoIryokikanCode
     * @return DbT7011ShujiiIryoKikanJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7011ShujiiIryoKikanJohoEntity selectByKey(
            LasdecCode 市町村コード,
            RString 介護医療機関コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(介護医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医療機関コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kaigoIryokikanCode, 介護医療機関コード))).
                toObject(DbT7011ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * 主治医医療機関情報　継承を全件返します。
     *
     * @return List<DbT7011ShujiiIryoKikanJohoEntity>
     */
    @Transaction
    public List<DbT7011ShujiiIryoKikanJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                toList(DbT7011ShujiiIryoKikanJohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7011ShujiiIryoKikanJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

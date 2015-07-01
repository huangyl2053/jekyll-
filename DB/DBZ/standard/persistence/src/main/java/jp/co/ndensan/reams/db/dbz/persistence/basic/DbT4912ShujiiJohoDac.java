/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4912ShujiiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4912ShujiiJoho.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.IShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給(DBD)用の主治医情報のデータアクセスクラスです。
 *
 * @author n8235 船山洋介
 */
public class DbT4912ShujiiJohoDac implements IModifiable<IShujiiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医情報を取得します。
     *
     * @param 市町村コード shichosonCode
     * @param 主治医医療機関コード shujiiIryokikanCode
     * @param 主治医コード shujiiCode
     * @return Optional<DbT4912ShujiiJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT4912ShujiiJohoEntity> selectByKey(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード,
            ShujiiCode 主治医コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT4912ShujiiJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード),
                                eq(shujiiCode, 主治医コード))).
                toObject(DbT4912ShujiiJohoEntity.class));
    }

    /**
     * 主治医情報を全件返します。
     *
     * @return ItemList<DbT4912ShujiiJohoEntity>
     */
    @Transaction
    public ItemList<DbT4912ShujiiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT4912ShujiiJoho.class).
                toList(DbT4912ShujiiJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(IShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(IShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(IShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

}

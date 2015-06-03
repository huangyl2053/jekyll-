/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJoho;
import static jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJoho.*;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請届出情報のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class DbT5120ShinsakaiShinseitodokedeJohoDac implements IModifiable<DbT5120ShinseitodokedeJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで申請届出情報を取得します。
     *
     * @param 申請書管理番号 shinseishoKanriNo
     * @return DbT5120ShinseitodokedeJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5120ShinseitodokedeJohoEntity> selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5120ShinseitodokedeJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5120ShinseitodokedeJohoEntity.class));
    }

    /**
     * 申請届出情報を全件返します。
     *
     * @return List<DbT5120ShinseitodokedeJohoEntity>
     */
    @Transaction
    public ItemList<DbT5120ShinseitodokedeJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT5120ShinseitodokedeJoho.class).
                toList(DbT5120ShinseitodokedeJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(DbT5120ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5120ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5120ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT5120ShinseitodokedeJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}

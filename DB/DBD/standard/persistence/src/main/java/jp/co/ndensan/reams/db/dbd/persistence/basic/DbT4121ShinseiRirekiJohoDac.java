/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJoho;
import static jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJoho.*;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJohoEntity;
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
 * 申請履歴情報のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class DbT4121ShinseiRirekiJohoDac implements IModifiable<DbT4121ShinseiRirekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで申請履歴情報を取得します。
     *
     * @param 申請管理番号 ShinseishoKanriNo
     * @return DbT4121ShinseiRirekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT4121ShinseiRirekiJohoEntity> selectByKey(
            ShinseishoKanriNo 申請管理番号) throws NullPointerException {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT4121ShinseiRirekiJoho.class).
                where(eq(shinseishoKanriNo, 申請管理番号)).
                toObject(DbT4121ShinseiRirekiJohoEntity.class));
    }

    /**
     * 申請履歴情報を全件返します。
     *
     * @return List<DbT4121ShinseiRirekiJohoEntity>
     */
    @Transaction
    public ItemList<DbT4121ShinseiRirekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT4121ShinseiRirekiJoho.class).
                toList(DbT4121ShinseiRirekiJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(DbT4121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT4121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT4121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT4121ShinseiRirekiJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5121ShinseiRirekiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5121ShinseiRirekiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
public class DbT5121ShinseiRirekiJohoDac implements IModifiable<DbT5121ShinseiRirekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで申請履歴情報を取得します。
     *
     * @param 申請管理番号 ShinseishoKanriNo
     * @return DbT5121ShinseiRirekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5121ShinseiRirekiJohoEntity> selectByKey(
            ShinseishoKanriNo 申請管理番号) throws NullPointerException {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5121ShinseiRirekiJoho.class).
                where(eq(shinseishoKanriNo, 申請管理番号)).
                toObject(DbT5121ShinseiRirekiJohoEntity.class));
    }

    /**
     * 申請履歴情報を全件返します。
     *
     * @return ItemList<DbT5121ShinseiRirekiJohoEntity>
     */
    @Transaction
    public ItemList<DbT5121ShinseiRirekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT5121ShinseiRirekiJoho.class).
                toList(DbT5121ShinseiRirekiJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(DbT5121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    @Transaction
    public int deletePhysical(DbT5121ShinseiRirekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

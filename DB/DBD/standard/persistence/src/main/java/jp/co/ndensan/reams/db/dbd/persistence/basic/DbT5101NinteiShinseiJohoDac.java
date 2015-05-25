/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5101NinteiShinseiJoho;
import static jp.co.ndensan.reams.db.dbd.entity.basic.DbT5101NinteiShinseiJoho.*;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5101NinteiShinseiJohoEntity;
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
 * 要介護認定申請情報のデータアクセスクラスです。
 *
 * @author n8235 船山洋介
 */
public class DbT5101NinteiShinseiJohoDac implements IModifiable<DbT5101NinteiShinseiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定申請情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return DbT5101NinteiShinseiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5101NinteiShinseiJohoEntity> selectByKey(ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5101NinteiShinseiJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5101NinteiShinseiJohoEntity.class));
    }

    /**
     * 要介護認定申請情報を全件返します。
     *
     * @return List<DbT5101NinteiShinseiJohoEntity>
     */
    @Transaction
    public ItemList<DbT5101NinteiShinseiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT5101NinteiShinseiJoho.class).
                toList(DbT5101NinteiShinseiJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(DbT5101NinteiShinseiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5101NinteiShinseiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5101NinteiShinseiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }
}

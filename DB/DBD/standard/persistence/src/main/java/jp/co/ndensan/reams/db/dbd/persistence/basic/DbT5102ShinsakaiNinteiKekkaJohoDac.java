/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbd.entity.basic.DbT5102NinteiKekkaJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class DbT5102ShinsakaiNinteiKekkaJohoDac implements IModifiable<DbT5102NinteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定結果情報を取得します。
     *
     * @param 申請書管理番号 shinseishoKanriNo
     * @return DbT5102NinteiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5102NinteiKekkaJohoEntity> selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5102NinteiKekkaJoho.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5102NinteiKekkaJohoEntity.class));
    }

    /**
     * 要介護認定結果情報を全件返します。
     *
     * @return List<DbT5102NinteiKekkaJohoEntity>
     */
    @Transaction
    public List<DbT5102NinteiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5102NinteiKekkaJoho.class).
                toList(DbT5102NinteiKekkaJohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT5102NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5102NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5102NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT5102NinteiKekkaJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}

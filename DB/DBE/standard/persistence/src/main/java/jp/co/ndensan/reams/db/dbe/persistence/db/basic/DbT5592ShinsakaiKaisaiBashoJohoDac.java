/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJoho.shinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催場所情報のデータアクセスクラスです。
 */
public class DbT5592ShinsakaiKaisaiBashoJohoDac implements ISaveable<DbT5592ShinsakaiKaisaiBashoJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会開催場所情報を取得します。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     * @return DbT5592ShinsakaiKaisaiBashoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5592ShinsakaiKaisaiBashoJohoEntity selectByKey(
            RString 介護認定審査会開催場所コード) throws NullPointerException {
        requireNonNull(介護認定審査会開催場所コード, 
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT5592ShinsakaiKaisaiBashoJoho.class).
                where(eq(shinsakaiKaisaiBashoCode, 介護認定審査会開催場所コード)).
                toObject(DbT5592ShinsakaiKaisaiBashoJohoEntity.class);
    }

    /**
     * 介護認定審査会開催場所情報を全件返します。
     *
     * @return DbT5592ShinsakaiKaisaiBashoJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5592ShinsakaiKaisaiBashoJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5592ShinsakaiKaisaiBashoJoho.class).
                toList(DbT5592ShinsakaiKaisaiBashoJohoEntity.class);
    }

    /**
     * DbT5592ShinsakaiKaisaiBashoJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5592ShinsakaiKaisaiBashoJohoEntity entity) {
        requireNonNull(entity, 
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}

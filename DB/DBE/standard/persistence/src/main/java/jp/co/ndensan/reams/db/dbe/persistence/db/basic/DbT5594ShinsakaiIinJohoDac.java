/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJoho.shinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
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
 * 介護認定審査会委員情報のデータアクセスクラスです。
 */
public class DbT5594ShinsakaiIinJohoDac implements ISaveable<DbT5594ShinsakaiIinJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会委員情報を取得します。
     *
     * @param 介護認定審査会委員コード ShinsakaiIinCode
     * @return DbT5594ShinsakaiIinJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5594ShinsakaiIinJohoEntity selectByKey(
            RString 介護認定審査会委員コード) throws NullPointerException {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5594ShinsakaiIinJoho.class).
                where(eq(shinsakaiIinCode, 介護認定審査会委員コード)).
                toObject(DbT5594ShinsakaiIinJohoEntity.class);
    }

    /**
     * 介護認定審査会委員情報を全件返します。
     *
     * @return DbT5594ShinsakaiIinJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5594ShinsakaiIinJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5594ShinsakaiIinJoho.class).
                toList(DbT5594ShinsakaiIinJohoEntity.class);
    }

    /**
     * DbT5594ShinsakaiIinJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5594ShinsakaiIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 介護認定審査会委員情報delete件数を返します。
     *
     * @param entity 介護認定審査会委員情報テーブルのエンティティ
     * @return int 削除件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int delete(DbT5594ShinsakaiIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.delete(entity).execute();
    }

    /**
     * 介護認定審査会委員情報deletePhysical件数を返します。
     *
     * @param entity 介護認定審査会委員情報テーブルのエンティティ
     * @return int 物理削除件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int deletePhysical(DbT5594ShinsakaiIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.deletePhysical(entity).execute();
    }

    /**
     * 介護認定審査会委員情報更新件数を返します。
     *
     * @param entity 介護認定審査会委員情報テーブルのエンティティ
     * @return int 更新件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int update(DbT5594ShinsakaiIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.update(entity).execute();
    }
}

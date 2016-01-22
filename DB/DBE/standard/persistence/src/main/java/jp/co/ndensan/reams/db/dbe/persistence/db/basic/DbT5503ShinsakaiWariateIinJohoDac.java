/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5101ShinsakaiJoho.shinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJoho.shinsakaiIinCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当委員情報のデータアクセスクラスです。
 */
public class DbT5503ShinsakaiWariateIinJohoDac implements ISaveable<DbT5503ShinsakaiWariateIinJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会割当委員情報を取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5503ShinsakaiWariateIinJohoEntity selectByKey(
            RString 介護認定審査会開催番号,
            RString 介護認定審査会委員コード) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5503ShinsakaiWariateIinJoho.class).
                where(and(
                                eq(shinsakaiKaisaiNo, 介護認定審査会開催番号),
                                eq(shinsakaiIinCode, 介護認定審査会委員コード))).
                toObject(DbT5503ShinsakaiWariateIinJohoEntity.class);
    }

    /**
     * 介護認定審査会割当委員情報を全件返します。
     *
     * @return DbT5503ShinsakaiWariateIinJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5503ShinsakaiWariateIinJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5503ShinsakaiWariateIinJoho.class).
                toList(DbT5503ShinsakaiWariateIinJohoEntity.class);
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5503ShinsakaiWariateIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 介護認定審査会割当委員情報deletePhysical件数を返します。
     *
     * @param entity 介護認定審査会割当委員情報テーブルのエンティティ
     * @return int 物理削除件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int deletePhysical(DbT5503ShinsakaiWariateIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

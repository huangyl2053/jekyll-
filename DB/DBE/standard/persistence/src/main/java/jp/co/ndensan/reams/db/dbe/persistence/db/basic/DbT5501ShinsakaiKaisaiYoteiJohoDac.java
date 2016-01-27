/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJoho.shinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJoho.shinsakaiKaisaiNo;
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
 * 介護認定審査会開催予定情報のデータアクセスクラスです。
 */
public class DbT5501ShinsakaiKaisaiYoteiJohoDac implements ISaveable<DbT5501ShinsakaiKaisaiYoteiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会開催予定情報を取得します。
     *
     * @param 介護認定審査会開催番号 ShinsakaiKaisaiNo
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5501ShinsakaiKaisaiYoteiJohoEntity selectByKey(
            RString 介護認定審査会開催番号) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                where(
                        eq(shinsakaiKaisaiNo, 介護認定審査会開催番号)).
                toObject(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    /**
     * 介護認定審査会開催予定情報を全件返します。
     *
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5501ShinsakaiKaisaiYoteiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                toList(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    /**
     * DbT5501ShinsakaiKaisaiYoteiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

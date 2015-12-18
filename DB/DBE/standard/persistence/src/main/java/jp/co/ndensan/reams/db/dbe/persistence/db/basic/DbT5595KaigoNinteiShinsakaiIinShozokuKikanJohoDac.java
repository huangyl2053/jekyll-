/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.remban;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.shinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
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
 * 介護認定審査会委員所属機関情報のデータアクセスクラスです。
 */
public class DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac implements ISaveable<DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会委員所属機関情報を取得します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 連番 連番
     * @return DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity selectByKey(
            RString 介護認定審査会委員コード,
            int 連番) throws NullPointerException {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.class).
                where(and(
                                eq(shinsakaiIinCode, 介護認定審査会委員コード),
                                eq(remban, 連番))).
                toObject(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity.class);
    }

    /**
     * 介護認定審査会委員所属機関情報を全件返します。
     *
     * @return DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.class).
                toList(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity.class);
    }

    /**
     * DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員所属機関情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityを物理で削除します。
     *
     * @param entity 介護認定審査会委員所属機関情報エンティティ
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員所属機関情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.deletePhysical(entity).execute();
    }
}

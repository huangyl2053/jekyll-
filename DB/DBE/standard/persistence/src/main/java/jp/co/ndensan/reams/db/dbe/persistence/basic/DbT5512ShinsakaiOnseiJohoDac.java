 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJoho.shinsakaiKaisaiNo;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5111ShinsakaiOnseiJoho.renban;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会音声情報のデータアクセスクラスです。
 */
public class DbT5512ShinsakaiOnseiJohoDac implements ISaveable<DbT5512ShinsakaiOnseiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会音声情報を取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     * @return DbT5512ShinsakaiOnseiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5512ShinsakaiOnseiJohoEntity selectByKey(
            int 介護認定審査会開催番号,
            int 連番) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5512ShinsakaiOnseiJoho.class).
                where(and(
                                eq(shinsakaiKaisaiNo, 介護認定審査会開催番号),
                                eq(renban, 連番))).
                toObject(DbT5512ShinsakaiOnseiJohoEntity.class);
    }

    /**
     * 介護認定審査会音声情報を全件返します。
     *
     * @return DbT5512ShinsakaiOnseiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5512ShinsakaiOnseiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5512ShinsakaiOnseiJoho.class).
                toList(DbT5512ShinsakaiOnseiJohoEntity.class);
    }

    /**
     * DbT5512ShinsakaiOnseiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5512ShinsakaiOnseiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会音声情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

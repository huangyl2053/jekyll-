/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.renban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.setaiKijunYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護世帯のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7014KaigoSetaiDac implements IModifiable<DbT7014KaigoSetaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護世帯を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 世帯基準年月日 SetaiKijunYMD
     * @param 連番 Renban
     * @param 処理日時 ShoriTimestamp
     * @return DbT7014KaigoSetaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7014KaigoSetaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 世帯基準年月日,
            int 連番,
            RDateTime 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(世帯基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯基準年月日"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7014KaigoSetai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(setaiKijunYMD, 世帯基準年月日),
                                eq(renban, 連番),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT7014KaigoSetaiEntity.class);
    }

    /**
     * 介護世帯を全件返します。
     *
     * @return List<DbT7014KaigoSetaiEntity>
     */
    @Transaction
    public List<DbT7014KaigoSetaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7014KaigoSetai.class).
                toList(DbT7014KaigoSetaiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7014KaigoSetaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7014KaigoSetaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7014KaigoSetaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7014KaigoSetaiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7014KaigoSetaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

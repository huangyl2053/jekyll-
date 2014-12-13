/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog.errorHyojiRenban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog.renNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog.shoriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域外字変換エラーログのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7034KoikiGaijiHenkanErrorLogDac implements IModifiable<DbT7034KoikiGaijiHenkanErrorLogEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで広域外字変換エラーログを取得します。
     *
     * @param 処理番号 ShoriNo
     * @param 連番 RenNo
     * @param エラー表示連番 ErrorHyojiRenban
     * @return DbT7034KoikiGaijiHenkanErrorLogEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7034KoikiGaijiHenkanErrorLogEntity selectByKey(
            RString 処理番号,
            RString 連番,
            RString エラー表示連番) throws NullPointerException {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(エラー表示連番, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7034KoikiGaijiHenkanErrorLog.class).
                where(and(
                                eq(shoriNo, 処理番号),
                                eq(renNo, 連番),
                                eq(errorHyojiRenban, エラー表示連番))).
                toObject(DbT7034KoikiGaijiHenkanErrorLogEntity.class);
    }

    /**
     * 広域外字変換エラーログを全件返します。
     *
     * @return List<DbT7034KoikiGaijiHenkanErrorLogEntity>
     */
    @Transaction
    public List<DbT7034KoikiGaijiHenkanErrorLogEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7034KoikiGaijiHenkanErrorLog.class).
                toList(DbT7034KoikiGaijiHenkanErrorLogEntity.class);
    }

    /**
     * 広域外字変換エラーログを追加します。
     *
     * @param entity 広域外字変換エラーログ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 広域外字変換エラーログをDBに更新します。
     *
     * @param entity 広域外字変換エラーログ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 広域外字変換エラーログをDBから削除します。（論理削除）
     *
     * @param entity 広域外字変換エラーログ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 広域外字変換エラーログを物理削除。
     *
     * @param entity 広域外字変換エラーログ
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

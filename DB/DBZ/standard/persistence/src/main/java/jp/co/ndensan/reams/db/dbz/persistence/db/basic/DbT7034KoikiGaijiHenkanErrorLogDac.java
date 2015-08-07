/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog.errorHyojiRenban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog.renNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLog.shoriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域外字変換エラーログのデータアクセスクラスです。
 */
public class DbT7034KoikiGaijiHenkanErrorLogDac implements ISaveable<DbT7034KoikiGaijiHenkanErrorLogEntity> {

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
     * DbT7034KoikiGaijiHenkanErrorLogEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("広域外字変換エラーログエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

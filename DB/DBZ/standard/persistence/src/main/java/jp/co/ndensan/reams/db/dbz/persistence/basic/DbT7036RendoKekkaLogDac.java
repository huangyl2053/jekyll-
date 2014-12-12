/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7036RendoKekkaLog;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7036RendoKekkaLog.shoriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7036RendoKekkaLogEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連動結果ログのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7036RendoKekkaLogDac implements IModifiable<DbT7036RendoKekkaLogEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連動結果ログを取得します。
     *
     * @param 処理番号 ShoriNo
     * @return DbT7036RendoKekkaLogEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7036RendoKekkaLogEntity selectByKey(
            RString 処理番号) throws NullPointerException {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7036RendoKekkaLog.class).
                where(
                        eq(shoriNo, 処理番号)).
                toObject(DbT7036RendoKekkaLogEntity.class);
    }

    /**
     * 連動結果ログを全件返します。
     *
     * @return List<DbT7036RendoKekkaLogEntity>
     */
    @Transaction
    public List<DbT7036RendoKekkaLogEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7036RendoKekkaLog.class).
                toList(DbT7036RendoKekkaLogEntity.class);
    }

    /**
     * 連動結果ログを追加します。
     *
     * @param entity 連動結果ログ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7036RendoKekkaLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 連動結果ログをDBに更新します。
     *
     * @param entity 連動結果ログ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7036RendoKekkaLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 連動結果ログをDBから削除します。（論理削除）
     *
     * @param entity 連動結果ログ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7036RendoKekkaLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 連動結果ログを物理削除。
     *
     * @param entity 連動結果ログ
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7036RendoKekkaLogEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

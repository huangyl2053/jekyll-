/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkan.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkan.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併内住特者新旧番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac implements IModifiable<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合併内住特者新旧番号変換テーブルを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity selectByKey(
            ShikibetsuCode 識別コード,
            RString 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7033GappeiNaiJutokushaShinKyuNoHenkan.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class);
    }

    /**
     * 合併内住特者新旧番号変換テーブルを全件返します。
     *
     * @return List<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7033GappeiNaiJutokushaShinKyuNoHenkan.class).
                toList(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class);
    }

    /**
     * 合併内住特者新旧番号変換テーブルを追加します。
     *
     * @param entity 合併内住特者新旧番号変換テーブル
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 合併内住特者新旧番号変換テーブルをDBに更新します。
     *
     * @param entity 合併内住特者新旧番号変換テーブル
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 合併内住特者新旧番号変換テーブルをDBから削除します。（論理削除）
     *
     * @param entity 合併内住特者新旧番号変換テーブル
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 合併内住特者新旧番号変換テーブルを物理削除。
     *
     * @param entity 合併内住特者新旧番号変換テーブル
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

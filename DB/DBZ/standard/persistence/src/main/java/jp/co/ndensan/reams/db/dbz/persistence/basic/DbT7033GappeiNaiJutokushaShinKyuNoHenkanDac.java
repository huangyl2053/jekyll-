/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho.rirekiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併内住特者新旧番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac implements ISaveable<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity> {

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
     * DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併内住特者新旧番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

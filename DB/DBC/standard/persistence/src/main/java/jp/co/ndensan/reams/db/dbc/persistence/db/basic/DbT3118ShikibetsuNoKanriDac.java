/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.shikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.tekiyoKaishiYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準収入額適用管理のデータアクセスクラスです。
 */
public class DbT3118ShikibetsuNoKanriDac implements ISaveable<DbT3118ShikibetsuNoKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで基準収入額適用管理を取得します。
     *
     * @param 識別番号
     * @param 適用開始年月
     * @return DbT3118ShikibetsuNoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3118ShikibetsuNoKanriEntity selectByKey(
            RString 識別番号,
            FlexibleYearMonth 適用開始年月) throws NullPointerException {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                eq(shikibetsuNo, 識別番号),
                                eq(tekiyoKaishiYM, 適用開始年月))).
                toObject(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理を全件返します。
     *
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    @Transaction
    public List<DbT3118ShikibetsuNoKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                toList(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * DbT3118ShikibetsuNoKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3118ShikibetsuNoKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("基準収入額適用管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

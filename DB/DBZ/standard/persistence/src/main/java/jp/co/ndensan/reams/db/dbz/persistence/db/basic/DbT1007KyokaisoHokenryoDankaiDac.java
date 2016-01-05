/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankai;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankai.*;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層保険料段階のデータアクセスクラスです。
 */
public class DbT1007KyokaisoHokenryoDankaiDac implements ISaveable<DbT1007KyokaisoHokenryoDankaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで境界層保険料段階を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 適用開始年月 TekiyoKaishiYM
     * @return DbT1007KyokaisoHokenryoDankaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1007KyokaisoHokenryoDankaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            FlexibleYearMonth 適用開始年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1007KyokaisoHokenryoDankai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(tekiyoKaishiYM, 適用開始年月))).
                toObject(DbT1007KyokaisoHokenryoDankaiEntity.class);
    }

    /**
     * 境界層保険料段階を全件返します。
     *
     * @return List<DbT1007KyokaisoHokenryoDankaiEntity>
     */
    @Transaction
    public List<DbT1007KyokaisoHokenryoDankaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1007KyokaisoHokenryoDankai.class).
                toList(DbT1007KyokaisoHokenryoDankaiEntity.class);
    }

    /**
     * DbT1007KyokaisoHokenryoDankaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層保険料段階エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者番号と履歴番号と論理削除フラグで境界層保険料段階を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 論理削除フラグ boolean
     * @return SearchResult<DbT1007KyokaisoHokenryoDankaiEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public SearchResult<DbT1007KyokaisoHokenryoDankaiEntity> select境界層保険料段階リスト(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            boolean 論理削除フラグ) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1007KyokaisoHokenryoDankaiEntity> entityList = accessor.select().
                table(DbT1007KyokaisoHokenryoDankai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(isDeleted, 論理削除フラグ))).
                toList(DbT1007KyokaisoHokenryoDankaiEntity.class);
        return SearchResult.of(entityList, 0, false);
    }
}

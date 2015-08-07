/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPattern;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPattern.*;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連動パターンのデータアクセスクラスです。
 */
public class DbT7035RendoPatternDac implements ISaveable<DbT7035RendoPatternEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連動パターンを取得します。
     *
     * @param 処理番号 ShoriNo
     * @param 連番 RenNo
     * @return DbT7035RendoPatternEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7035RendoPatternEntity selectByKey(
            LasdecCode 処理番号,
            LasdecCode 連番) throws NullPointerException {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7035RendoPattern.class).
                where(and(
                eq(motoShichosonCode, 処理番号),
                eq(sakiShichosonCode, 連番))).
                toObject(DbT7035RendoPatternEntity.class);
    }

    /**
     * 連動パターンを全件返します。
     *
     * @return List<DbT7035RendoPatternEntity>
     */
    @Transaction
    public List<DbT7035RendoPatternEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7035RendoPattern.class).
                toList(DbT7035RendoPatternEntity.class);
    }

    /**
     * DbT7035RendoPatternEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7035RendoPatternEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連動パターンエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

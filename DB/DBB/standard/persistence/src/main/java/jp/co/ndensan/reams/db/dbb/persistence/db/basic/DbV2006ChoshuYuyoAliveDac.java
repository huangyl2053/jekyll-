/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2006ChoshuYuyo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2006ChoshuYuyo.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2006ChoshuYuyo.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2006ChoshuYuyo.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2006ChoshuYuyo.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課徴収猶予Aliveのデータアクセスクラスです。
 */
public class DbV2006ChoshuYuyoAliveDac implements ISaveable<DbV2006ChoshuYuyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護賦課徴収猶予Aliveを取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @return DbV2006ChoshuYuyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV2006ChoshuYuyoEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2006ChoshuYuyo.class).
                where(and(
                eq(choteiNendo, 調定年度),
                eq(fukaNendo, 賦課年度),
                eq(tsuchishoNo, 通知書番号),
                eq(rirekiNo, 履歴番号))).
                toObject(DbV2006ChoshuYuyoEntity.class);
    }

    /**
     * 介護賦課徴収猶予Aliveを全件返します。
     *
     * @return DbV2006ChoshuYuyoEntityの{@code list}
     */
    @Transaction
    public List<DbV2006ChoshuYuyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2006ChoshuYuyo.class).
                toList(DbV2006ChoshuYuyoEntity.class);
    }

    /**
     * DbV2006ChoshuYuyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV2006ChoshuYuyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

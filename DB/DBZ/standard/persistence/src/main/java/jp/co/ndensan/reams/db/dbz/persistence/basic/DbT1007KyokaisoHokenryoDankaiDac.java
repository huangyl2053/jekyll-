/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankai.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankai.shoriTimeStamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankai.tekiyoKaishiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層保険料段階のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1007KyokaisoHokenryoDankaiDac implements IModifiable<DbT1007KyokaisoHokenryoDankaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで境界層保険料段階を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 ShoriTimeStamp
     * @param 適用開始年月 TekiyoKaishiYM
     * @return DbT1007KyokaisoHokenryoDankaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1007KyokaisoHokenryoDankaiEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時,
            FlexibleYearMonth 適用開始年月) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1007KyokaisoHokenryoDankai.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoriTimeStamp, 処理日時),
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

    @Transaction
    @Override
    public int insert(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1007KyokaisoHokenryoDankaiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

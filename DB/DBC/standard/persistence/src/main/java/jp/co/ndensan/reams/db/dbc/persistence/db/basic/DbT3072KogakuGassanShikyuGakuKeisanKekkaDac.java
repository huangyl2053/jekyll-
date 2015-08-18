/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給額計算結果のデータアクセスクラスです。
 */
public class DbT3072KogakuGassanShikyuGakuKeisanKekkaDac implements ISaveable<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算支給額計算結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 履歴番号 RirekiNo
     * @return DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3072KogakuGassanShikyuGakuKeisanKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * 高額合算支給額計算結果を全件返します。
     *
     * @return List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity>
     */
    @Transaction
    public List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3072KogakuGassanShikyuGakuKeisanKekka.class).
                toList(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

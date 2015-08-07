/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisai;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisai.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
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
 * 住宅改修理由書作成手数料請求明細のデータアクセスクラスです。
 */
public class DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac implements ISaveable<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで住宅改修理由書作成手数料請求明細を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity selectByKey(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3095JutakuKaishuRiyushoTesuryoMeisai.class).
                where(and(
                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                eq(hihokenshaNo, 被保険者番号),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
    }

    /**
     * 住宅改修理由書作成手数料請求明細を全件返します。
     *
     * @return List<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity>
     */
    @Transaction
    public List<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3095JutakuKaishuRiyushoTesuryoMeisai.class).
                toList(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
    }

    /**
     * DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求明細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

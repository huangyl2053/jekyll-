/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.choteiNendo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.fukaNendo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.shuno_Ki_Tsuki;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.tokucho_FuchoKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanri.tsuchishoNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 時効起算日管理のデータアクセスクラスです。
 */
public class DbT4023JikoKisambiKanriDac implements ISaveable<DbT4023JikoKisambiKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで時効起算日管理を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 賦課年度
     * @param 特徴_普徴区分 特徴_普徴区分
     * @param 通知書番号 通知書番号
     * @param 収納期_月 収納期_月
     * @param 履歴番号 履歴番号
     * @return DbT4023JikoKisambiKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4023JikoKisambiKanriEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 特徴_普徴区分,
            TsuchishoNo 通知書番号,
            RString 収納期_月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(特徴_普徴区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴_普徴区分"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(収納期_月, UrSystemErrorMessages.値がnull.getReplacedMessage("収納期_月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4023JikoKisambiKanri.class).
                where(and(
                        eq(shoKisaiHokenshaNo, 証記載保険者番号),
                        eq(hihokenshaNo, 被保険者番号),
                        eq(choteiNendo, 調定年度),
                        eq(fukaNendo, 賦課年度),
                        eq(tokucho_FuchoKubun, 特徴_普徴区分),
                        eq(tsuchishoNo, 通知書番号),
                        eq(shuno_Ki_Tsuki, 収納期_月),
                        eq(rirekiNo, 履歴番号))).
                toObject(DbT4023JikoKisambiKanriEntity.class);
    }

    /**
     * 時効起算日管理を全件返します。
     *
     * @return DbT4023JikoKisambiKanriEntityの{@code list}
     */
    @Transaction
    public List<DbT4023JikoKisambiKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4023JikoKisambiKanri.class).
                toList(DbT4023JikoKisambiKanriEntity.class);
    }

    /**
     * DbT4023JikoKisambiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4023JikoKisambiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
     *
     * DbT4023JikoKisambiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT4023JikoKisambiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日管理エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}

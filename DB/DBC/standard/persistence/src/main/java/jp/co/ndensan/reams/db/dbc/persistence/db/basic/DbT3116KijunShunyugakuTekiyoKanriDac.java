/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.nendo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.setaiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.tekiyoKaishiYMD;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準収入額適用管理のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-022 wangkanglei
 */
public class DbT3116KijunShunyugakuTekiyoKanriDac implements ISaveable<DbT3116KijunShunyugakuTekiyoKanriEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_世帯コード = new RString("世帯コード");
    private static final RString KEY_年度 = new RString("年度");
    private static final RString KEY_履歴番号 = new RString("履歴番号");
    private static final RString KEY_適用開始年月 = new RString("適用開始年月");
    private static final RString KEY_基準収入額適用管理エンティティ = new RString("基準収入額適用管理エンティティ");
    private static final RString KEY_90000 = new RString("90000");

    /**
     * 主キーで基準収入額適用管理を取得します。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 Nendo
     * @param 履歴番号 RirekiNo
     * @param 被保険者番号 HihokenshaNo
     * @return DbT3116KijunShunyugakuTekiyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3116KijunShunyugakuTekiyoKanriEntity selectByKey(
            SetaiCode 世帯コード,
            FlexibleYear 年度,
            int 履歴番号,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_世帯コード.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_年度.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_履歴番号.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(and(
                                eq(setaiCode, 世帯コード),
                                eq(nendo, 年度),
                                eq(rirekiNo, 履歴番号),
                                eq(hihokenshaNo, 被保険者番号))).
                toObject(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理を全件返します。
     *
     * @return List<DbT3116KijunShunyugakuTekiyoKanriEntity>
     */
    @Transaction
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * DbT3116KijunShunyugakuTekiyoKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3116KijunShunyugakuTekiyoKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_基準収入額適用管理エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 基準収入額適用管理マスタを取得します。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 Nendo
     *
     * @return DbT3116KijunShunyugakuTekiyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> selectJouhousootoNendo(
            RString 世帯コード,
            FlexibleYear 年度
    ) throws NullPointerException {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_世帯コード.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_年度.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(and(
                                eq(setaiCode, 世帯コード),
                                eq(nendo, 年度))).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理マスタねんど年度 によっての抽出。
     *
     * @param 年度 Nendo
     *
     * @return DbT3116KijunShunyugakuTekiyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理マスタ(
            FlexibleYear 年度
    ) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_年度.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(
                        eq(nendo, 年度)
                ).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理情報によっての抽出。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 世帯コード SetaiCode
     * @return list
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理情報(
            HihokenshaNo 被保険者番号,
            SetaiCode 世帯コード) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_被保険者番号.toString()));
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_世帯コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(or(and(
                                        eq(hihokenshaNo, 被保険者番号),
                                        eq(setaiCode, 世帯コード)),
                                eq(setaiCode, new SetaiCode(KEY_90000.concat(被保険者番号.getColumnValue())))))
                .order(by(nendo, Order.DESC), by(setaiCode, Order.ASC), by(rirekiNo, Order.DESC))
                .toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理情報BY世帯コードによっての抽出。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 FlexibleYear
     * @param 履歴番号 int
     * @return list
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理情報BY世帯コード(
            SetaiCode 世帯コード,
            FlexibleYear 年度,
            int 履歴番号) throws NullPointerException {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_世帯コード.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_年度.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_履歴番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(and(
                                eq(setaiCode, 世帯コード),
                                eq(nendo, 年度),
                                eq(rirekiNo, 履歴番号)))
                .toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * DbT3116KijunShunyugakuTekiyoKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT3116KijunShunyugakuTekiyoKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_基準収入額適用管理エンティティ.toString()));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 適用開始年月で基準収入額適用管理を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 適用開始年月 FlexibleYearMonth
     * @return list
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> selectBy適用開始年月(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 適用開始年月) throws NullPointerException {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_適用開始年月.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(KEY_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                lt(適用開始年月, tekiyoKaishiYMD)
                        )).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }
}

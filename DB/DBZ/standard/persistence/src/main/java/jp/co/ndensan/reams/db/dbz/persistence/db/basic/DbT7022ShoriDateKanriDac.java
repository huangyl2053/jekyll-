
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.isDeleted;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.kijunTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.nendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.nendoNaiRenban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shoriEdaban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shoriName;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.subGyomuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.taishoShuryoTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付管理マスタのデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-012 cuilin
 */
public class DbT7022ShoriDateKanriDac implements ISaveable<DbT7022ShoriDateKanriEntity> {

    private static final RString 介護住民票個別事項連携情報作成_他社住基 = new RString("介護住民票個別事項連携情報作成【他社住基】");
    private static final RString 定数_基準収入額適用申請書発行 = new RString("基準収入額適用申請書発行");
    private static final RString SUB_CODE = new RString("DBU");
    @InjectSession
    private SqlSession session;
    private static final RString サブ業務コードメッセージ = new RString("サブ業務コード");
    private static final RString 処理名メッセージ = new RString("処理名");
    private static final RString 処理枝番メッセージ = new RString("処理枝番");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 年度メッセージ = new RString("年度");
    private static final RString 年度内連番メッセージ = new RString("年度内連番");
    private static final RString 被保険者証一括発行 = new RString("被保険者証一括発行");
    private static final RString 異動チェックリスト = new RString("異動チェックリスト");
    private static final RString 処理日付管理マスタエンティティ = new RString("処理日付管理マスタエンティティ");
    private static final RString 年度内連番_0 = new RString("0000");
    private static final RString 年度内連番_1 = new RString("0001");
    private static final RString 年度内連番_2 = new RString("0002");
    private static final RString 年度内連番_3 = new RString("0003");
    private static final RString 年度内連番_5 = new RString("0005");
    private static final RString 年度内連番_7 = new RString("0007");
    private static final RString 年度内連番_9 = new RString("0009");
    private static final RString 年度内連番_11 = new RString("0011");
    private static final RString 対象者情報取得月_02 = new RString("02");
    private static final RString 対象者情報取得月_04 = new RString("04");
    private static final RString 対象者情報取得月_05 = new RString("05");
    private static final RString 対象者情報取得月_08 = new RString("08");
    private static final RString 対象者情報取得月_10 = new RString("10");
    private static final RString 対象者情報取得月_12 = new RString("12");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString FORMAT_補00 = new RString("00%s");
    private static final RString 処理枝番_0001 = new RString("0001");

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectByKey(
            SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大基準日時を取得する。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大基準日時(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大基準日時を取得する。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大基準日時(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(kijunTimestamp)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大基準日時を取得する。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select基準日時_MAX(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(kijunTimestamp)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectBySomeKeys(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectBySomeKeysLimits(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectByFourKeys(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 抽出調定日時を取得します。
     *
     * @param サブ業務コード subGyomuCode
     * @param 処理名 shoriName
     * @param 年度 nendo
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectShorikubun(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.ASC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 抽出調定日時を取得します。
     *
     * @param サブ業務コード subGyomuCode
     * @param 処理名 shoriName
     * @param 年度 nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectChoteiNiji(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 抽出調定日時を取得します。
     *
     * @param サブ業務コード subGyomuCode
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectSubGyomuCode(SubGyomuCode サブ業務コード) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(eq(subGyomuCode, サブ業務コード)).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * selectSubGyomuCode 基準年月日を取得します。
     *
     * @param 処理名 shoriName
     * @param 年度 nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKijunYMD(
            RString 処理名,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタを全件返します。
     *
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * DbT7022ShoriDateKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7022ShoriDateKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectTaishoYMD() throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SUB_CODE),
                                eq(shoriName, 介護住民票個別事項連携情報作成_他社住基),
                                eq(shoriEdaban, 年度内連番_0))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKaisiShuryobi() throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBA介護資格),
                                eq(shoriName, 異動チェックリスト))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、対象開始日年月日と対象終了日年月日を取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectkaisyuYMD() throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(eq(subGyomuCode, SubGyomuCode.DBA介護資格),
                                eq(isDeleted, false),
                                eq(shoriName, ShoriName.年齢到達予定者チェックリスト.get名称()),
                                eq(nendo, RDate.getNowDate().getNendo())))
                .order(new OrderBy(shoriEdaban, Order.DESC, NullsOrder.LAST),
                        new OrderBy(nendoNaiRenban, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);

    }

    /**
     * 抽出期間の取得値を取得します。
     *
     * @param 処理枝番 処理枝番
     * @param 市町村コード 導入団体クラスで取得した市町村コード
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectBy抽出期間の取得(RString 処理枝番,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SUB_CODE),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 被保険者証一括発行),
                                eq(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 「再発行する」のselectイベントを取得します。
     *
     * @param 処理枝番 処理枝番
     * @param 導入団体取得 導入団体取得
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectBy再発行(
            List<RString> 処理枝番,
            LasdecCode 導入団体取得) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SUB_CODE),
                                eq(shichosonCode, 導入団体取得),
                                eq(shoriName, 被保険者証一括発行),
                                in(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectChushutsukikan() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SUB_CODE),
                                eq(shoriName, 介護住民票個別事項連携情報作成_他社住基),
                                eq(shoriEdaban, 年度内連番_0))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、前回開始終了日を取得する。
     *
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKaishiShuryoYMD(
            SubGyomuCode サブ業務コード,
            RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 年度 年度
     * @param 処理名 処理名
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況(FlexibleYear 年度, List<RString> 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                in(shoriName, 処理名),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 年度)
                        )).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタ.基準日時を取得します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理名 RString
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKaijun(FlexibleYear 賦課年度, RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 賦課年度),
                                in(shoriName, 処理名))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタ.基準日時を取得します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理名 RString
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKaijun_検索(FlexibleYear 賦課年度, RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 賦課年度),
                                eq(shoriName, 処理名),
                                eq(nendoNaiRenban, 年度内連番_1))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタ.基準日時を取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select基準日時(FlexibleYear 調定年度) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriName, ShoriName.本算定賦課.get名称()),
                                eq(nendoNaiRenban, 年度内連番_1))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタ.基準日時を取得します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理名 RString
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKaijun_処理(FlexibleYear 賦課年度, RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 賦課年度),
                                eq(shoriName, 処理名))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況_賦課(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                or(and(
                                                eq(shoriName, ShoriName.特徴対象者同定.get名称()),
                                                eq(nendoNaiRenban, 年度内連番_2)),
                                        and(
                                                eq(shoriName, ShoriName.依頼金額計算.get名称()),
                                                eq(nendoNaiRenban, 年度内連番_2))),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況_通知書作成(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.本算定賦課.get名称()),
                                eq(nendoNaiRenban, 年度内連番_1),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況_特徴仮算定賦課(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.年度切替.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況_特徴仮算定通知書一括発行(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                or(
                                        eq(shoriName, ShoriName.特徴仮算定賦課.get名称()),
                                        eq(shoriName, ShoriName.特徴平準化計算_6月分.get名称())
                                ),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))
                ).
                toList(DbT7022ShoriDateKanriEntity.class);

    }

    /**
     * 処理日付管理マスタテーブルから、過年度賦課の最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最新の基準日(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.過年度賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、過年度賦課確定の最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select確定の最新の基準日(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.過年度賦課確定.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度内連番を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大年度内連番(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.過年度賦課確定.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度内連番を取得する。
     *
     * @param 賦課年度 賦課年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select異動賦課最大年度内連番(FlexibleYear 賦課年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.異動賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 賦課年度))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度内連番を取得する。
     *
     * @param 市町村識別ID RString
     * @param 処理年度 処理年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select異動広域最大年度内連番(RString 市町村識別ID, FlexibleYear 処理年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, ShoriName.所得引出.get名称()),
                                eq(shoriEdaban, String.format(FORMAT_補00.toString(), 市町村識別ID)),
                                eq(nendo, 処理年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度内連番を取得する。
     *
     * @param 処理年度 処理年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select異動単一最大年度内連番(FlexibleYear 処理年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, ShoriName.所得引出.get名称()),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 処理年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @param 処理名 処理名
     * @param サブ業務コード サブ業務コード
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況_普徴仮算定賦課(FlexibleYear 調定年度, RString 処理名, SubGyomuCode サブ業務コード) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名),
                                eq(subGyomuCode, サブ業務コード),
                                eq(nendo, 調定年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 本算定異動_過年度_抽出開始日時取得する。
     *
     * @param 調定年度 調定年度
     * @param 処理名 処理名
     * @param サブ業務コード サブ業務コード
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select抽出開始日時_本算定異動_過年度(FlexibleYear 調定年度,
            RString 処理名, SubGyomuCode サブ業務コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名),
                                eq(subGyomuCode, サブ業務コード),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC), by(DbT7022ShoriDateKanri.shoriEdaban, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 本算定異動_過年度_処理状況取得する
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理状況_本算定異動_過年度(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.過年度賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriEdaban, 年度内連番_1),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得します。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況_異動賦課(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                or(
                                        eq(shoriName, ShoriName.特徴仮算定賦課.get名称()),
                                        eq(shoriName, ShoriName.普徴仮算定賦課.get名称())
                                ),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(nendoNaiRenban, 年度内連番_1),
                                eq(shoriEdaban, 年度内連番_1))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得します。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理状況_異動通知書作成(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.仮算定異動賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriEdaban, 年度内連番_1))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得します。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select抽出開始日時(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.仮算定異動賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriEdaban, 年度内連番_1))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタから特徴対象者同定のデータを取得します。
     *
     * @param 調定年度 調定年度
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> get特徴対象者同定(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriName, ShoriName.特徴対象者同定.get名称()),
                                eq(nendoNaiRenban, 年度内連番_1))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタから依頼金額計算のデータを取得する。
     *
     * @param 調定年度 調定年度
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> get依頼金額計算(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriName, ShoriName.依頼金額計算.get名称()),
                                eq(nendoNaiRenban, 年度内連番_2))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 前回対象日を取得する。
     *
     * @param 市町村コード 市町村コード
     * @param 処理名 処理名
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select前回対象日(LasdecCode 市町村コード, RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(nendo, RDate.getNowDate().getNendo())))
                .order(new OrderBy(shoriEdaban, Order.DESC, NullsOrder.LAST),
                        new OrderBy(nendoNaiRenban, Order.DESC, NullsOrder.LAST)).
                toObject(DbT7022ShoriDateKanriEntity.class);

    }

    /**
     * 処理日付管理マスタ.最新調定日時を取得します。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectMax基準日(FlexibleYear 調定年度, RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(kijunTimestamp)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriEdaban, 年度内連番_1),
                                eq(nendo, 調定年度),
                                eq(shoriName, 処理名))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから連携（当初）所得情報取得します。
     *
     * @param 年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ_当初所得情報抽出(FlexibleYear 年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, ShoriName.当初所得引出.get名称()),
                                eq(shoriEdaban, 処理枝番_0001),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番_1))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 当初所得引出情報取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ_当初所得引出(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, ShoriName.当初所得引出.get名称()),
                                eq(nendo, 調定年度),
                                not(isNULL(kijunTimestamp)),
                                not(eq(kijunTimestamp, RString.EMPTY)))).
                order(new OrderBy(kijunTimestamp, Order.DESC, NullsOrder.LAST)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 当初所得引出以外情報取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理日付管理マスタ_当初所得引出以外(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                or(and(eq(shoriName, ShoriName.依頼金額計算.get名称()), eq(nendoNaiRenban, 年度内連番_2)),
                                        and(eq(shoriName, ShoriName.特徴異動情報作成.get名称()), eq(nendoNaiRenban, 年度内連番_3)),
                                        and(eq(shoriName, ShoriName.本算定賦課.get名称()), eq(nendoNaiRenban, 年度内連番_1))))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから連携（当初）所得情報取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select特徴平準化8月分処理(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriName, ShoriName.特徴平準化_8月分_確定.get名称()),
                                eq(shoriEdaban, 処理枝番_0001),
                                eq(nendoNaiRenban, 年度内連番_1))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから連携（当初）所得情報取得します。
     *
     * @param 年度 FlexibleYear
     * @param 市町村コード LasdecCode
     * @param 市町村識別ID RString
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ_所得情報抽出連携当初(FlexibleYear 年度, LasdecCode 市町村コード, RString 市町村識別ID) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, ShoriName.当初所得引出.get名称()),
                                eq(shoriEdaban, String.format(FORMAT_補00.toString(), 市町村識別ID)),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番_1))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから連携（異動）所得情報取得します。
     *
     * @param 年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ_異動所得情報抽出(FlexibleYear 年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.所得引出.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 年度),
                                eq(shoriEdaban, 処理枝番_0001))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから連携（異動）所得情報取得します。
     *
     * @param 年度 FlexibleYear
     * @param 市町村コード LasdecCode
     * @param 市町村識別ID RString
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ_所得情報抽出連携異動(FlexibleYear 年度, LasdecCode 市町村コード, RString 市町村識別ID) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, ShoriName.所得引出.get名称()),
                                eq(shoriEdaban, String.format(FORMAT_補00.toString(), 市町村識別ID)),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番_1))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタから処理状況の情報を取得する。
     *
     * @param 年度 FlexibleYear
     * @param 処理名 RString
     * @param 年度連番 RString
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況の情報(FlexibleYear 年度, RString 処理名, RString 年度連番) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度連番))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから捕捉月取得します。
     *
     * @param 年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get特徴捕捉月(FlexibleYear 年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 年度),
                                or(eq(shoriName, ShoriName.特徴依頼情報作成.get名称()),
                                        eq(shoriName, ShoriName.特徴異動情報作成.get名称()))
                        )).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから依頼金額計算状況取得します。
     *
     * @param 年度 FlexibleYear
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> get依頼金額計算状況(FlexibleYear 年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 年度),
                                eq(shoriName, ShoriName.依頼金額計算.get名称()
                                ))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 特徴対象者同定情報取得
     *
     * @param サブ業務コード subGyomuCode
     * @param 処理名 shoriName
     * @param 年度 nendo
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectShoriDateKanri(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.shichosonCode, Order.ASC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理状況一覧情報取得
     *
     * @param サブ業務コード subGyomuCode
     * @param 年度 nendo
     * @param 対象者情報取得月 RString
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況一覧情報(
            SubGyomuCode サブ業務コード,
            FlexibleYear 年度,
            RString 対象者情報取得月) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        ITrueFalseCriteria iTrueFalseCriteria
                = getiTrueFalseCriteria(サブ業務コード, 年度, 対象者情報取得月);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(iTrueFalseCriteria).
                order(by(DbT7022ShoriDateKanri.shichosonCode, Order.ASC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    private ITrueFalseCriteria getiTrueFalseCriteria(
            SubGyomuCode サブ業務コード,
            FlexibleYear 年度,
            RString 対象者情報取得月) {
        ITrueFalseCriteria iTrueFalseCriteria = null;
        if (対象者情報取得月_04.equals(対象者情報取得月)) {
            iTrueFalseCriteria = and(
                    eq(subGyomuCode, サブ業務コード),
                    eq(shoriName, ShoriName.特徴結果情報取込.get名称()),
                    eq(nendo, 年度),
                    eq(nendoNaiRenban, 年度内連番_1));
        } else if (対象者情報取得月_05.equals(対象者情報取得月)) {
            iTrueFalseCriteria = and(
                    eq(subGyomuCode, サブ業務コード),
                    eq(shoriName, ShoriName.特徴対象者情報取込.get名称()),
                    eq(nendo, 年度),
                    eq(nendoNaiRenban, 年度内連番_1));
        } else if (対象者情報取得月_08.equals(対象者情報取得月)) {
            iTrueFalseCriteria = and(
                    eq(subGyomuCode, サブ業務コード),
                    eq(shoriName, ShoriName.特徴結果情報取込.get名称()),
                    eq(nendo, 年度),
                    eq(nendoNaiRenban, 年度内連番_5));
        } else if (対象者情報取得月_10.equals(対象者情報取得月)) {
            iTrueFalseCriteria = and(
                    eq(subGyomuCode, サブ業務コード),
                    eq(shoriName, ShoriName.特徴結果情報取込.get名称()),
                    eq(nendo, 年度),
                    eq(nendoNaiRenban, 年度内連番_7));
        } else if (対象者情報取得月_12.equals(対象者情報取得月)) {
            iTrueFalseCriteria = and(
                    eq(subGyomuCode, サブ業務コード),
                    eq(shoriName, ShoriName.特徴結果情報取込.get名称()),
                    eq(nendo, 年度),
                    eq(nendoNaiRenban, 年度内連番_9));
        } else if (対象者情報取得月_02.equals(対象者情報取得月)) {
            iTrueFalseCriteria = and(
                    eq(subGyomuCode, サブ業務コード),
                    eq(shoriName, ShoriName.特徴結果情報取込.get名称()),
                    eq(nendo, 年度),
                    eq(nendoNaiRenban, 年度内連番_11));
        }
        return iTrueFalseCriteria;
    }

    /**
     * 今回処理内容情報取得
     *
     * @param サブ業務コード subGyomuCode
     * @param 年度 nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select今回処理内容情報(
            SubGyomuCode サブ業務コード,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, ShoriName.特徴対象者同定.get名称()),
                                eq(nendo, 年度),
                                isNULL(kijunTimestamp))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.ASC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから依頼金額計算状況取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get特徴依頼情報作成の基準日時含みエンティティ(SubGyomuCode サブ業務コード,
            RString 処理名, FlexibleYear 年度, RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 特徴対象者同定情報取得
     *
     * @param 処理名 shoriName
     * @param 年度 nendo
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectFor年度内処理済み連番(
            RString 処理名,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.ASC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから依頼金額計算状況取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectFor依頼金額計算基準日取得(SubGyomuCode サブ業務コード,
            RString 処理名, FlexibleYear 年度, RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルからデータを取得します。
     *
     * @param 処理名 ShoriName
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectallbykey(RString 処理名) throws NullPointerException {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                not(or(
                                                isNULL(kijunTimestamp),
                                                eq(kijunTimestamp, RString.EMPTY))))).
                order(by(nendo, Order.DESC), by(nendoNaiRenban, Order.DESC)).limit(2).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日時を更新します。
     *
     * @param 処理名 ShoriName
     * @param 年度内連番 RString
     * @param 年度 Nendo
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select基準日時toupdate(RString 処理名, RString 年度内連番,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                eq(nendoNaiRenban, 年度内連番),
                                eq(nendo, 年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最新調定日時(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.本算定賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最新調定日時過年度賦課(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.過年度賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最新調定日時_仮算定(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.仮算定異動賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最新調定日時_現年度(FlexibleYear 調定年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, ShoriName.異動賦課.get名称()),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * MAX(年度内連番)を取得します。
     *
     * @param 処理名 RString
     * @param サブ業務コード SubGyomuCode
     * @param 年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectMaxNendoNaiRenbanByKey(RString 処理名, SubGyomuCode サブ業務コード,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 年度),
                                not(isNULL(kijunTimestamp)))).
                groupBy(nendo).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * _所得情報アップロードの基準日時を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select基準日時ByKey(
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 特徴送付情報作成（バッチ）の処理対象期間取得
     *
     * @param 年度 Nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理対象期間(FlexibleYear 年度) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, ShoriName.特徴異動情報作成),
                                eq(nendo, 年度))).
                order(by(taishoShuryoTimestamp, Order.DESC)).limit(1)
                .toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタ情報作成するメソッドです。
     *
     * @param 年度 FlexibleYear
     * @return int 取得件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int select処理日付管理マスタ(FlexibleYear 年度) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, 定数_基準収入額適用申請書発行),
                                eq(nendo, 年度))).getCount();
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度内連番を取得する。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理枝番 RString
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大年度内連番BY調定年度(FlexibleYear 調定年度, RString 処理枝番) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, ShoriName.仮算定異動賦課.get名称()),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 調定年度))).
                groupBy(nendo).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから8月特徴開始情報取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ_八月特徴開始情報抽出(FlexibleYear 調定年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                // TODO 設計書に処理名称不正
                                eq(shoriName, ShoriName.依頼金額計算.get名称()),
                                eq(nendo, 調定年度),
                                eq(shoriEdaban, 処理枝番_0001),
                                eq(nendoNaiRenban, 年度内連番_2))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから処理名取得します。
     *
     * @param 年度 FlexibleYear
     * @param 処理名 RString
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get処理名(FlexibleYear 年度, RString 処理名) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(nendo, 年度),
                                eq(shoriName, 処理名))).
                order(by(kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 更正対象給付実績一覧の抽出期間取得
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select抽出期間() throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, ShoriName.特徴結果情報取込.get名称()))).//Error  更正対象給付実績一覧
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理済の有効期間終了月と前回処理日の取得
     *
     * @param 市町村コード
     * @return
     * @throws NullPointerException
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select前回処理日(LasdecCode 市町村コード) throws
            NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBD介護受給),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, ShoriName.更新申請者管理.get名称()),
                                eq(shoriEdaban, 処理枝番))).order(by(nendo, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタから直近の年次負担割合判定処理のデータを取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select直近の年次負担割合判定() throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, ShoriName.年次負担割合判定.get名称()),
                                not(isNULL(kijunTimestamp)))
                ).order(by(DbT7022ShoriDateKanri.nendo, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);

    }

    /**
     * 当初発行チェックの判定処理のデータを取得する。
     *
     * @param 年度 FlexibleYear
     * @param 処理枝番 RString
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select当初発行チェック(FlexibleYear 年度, RString 処理枝番) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, ShoriName.負担割合証発行一括.get名称()),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度))
                ).order(by(DbT7022ShoriDateKanri.nendo, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);

    }
}

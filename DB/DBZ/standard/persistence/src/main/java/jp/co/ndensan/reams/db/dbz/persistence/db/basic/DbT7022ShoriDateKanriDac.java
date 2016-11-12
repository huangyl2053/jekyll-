
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.isDeleted;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.kijunTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.kijunYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.nendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.nendoNaiRenban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shoriEdaban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shoriName;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.subGyomuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.taishoKaishiTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.taishoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.taishoShuryoTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.taishoShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
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

    @InjectSession
    private SqlSession session;
    private static final RString サブ業務コードメッセージ = new RString("サブ業務コード");
    private static final RString 処理名メッセージ = new RString("処理名");
    private static final RString 処理枝番メッセージ = new RString("処理枝番");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 年度メッセージ = new RString("年度");
    private static final RString 年度内連番メッセージ = new RString("年度内連番");
    private static final RString 処理日付管理マスタエンティティ = new RString("処理日付管理マスタエンティティ");
    private static final RString 介護住民票個別事項連携情報作成_他社住基 = new RString("介護住民票個別事項連携情報作成【他社住基】");
    private static final RString 定数_基準収入額適用申請書発行 = new RString("基準収入額適用申請書発行");
    private static final RString 基準収入額適用申請書異動 = new RString("基準収入額適用申請書異動");
    private static final RString 年度内連番_0 = new RString("0000");
    private static final RString 年度内連番_1 = new RString("0001");
    private static final RString 年度内連番_2 = new RString("0002");
    private static final RString 年度内連番_3 = new RString("0003");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString 処理枝番_01 = new RString("01");
    private static final RString 処理枝番_02 = new RString("02");
    private static final RString 処理枝番_03 = new RString("03");
    private static final RString FORMAT_補00 = new RString("00%s");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final RString INDEX_111 = new RString("111");
    private static final RString 年度_0000 = new RString("0000");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    /**
     * 主キーで処理日付管理マスタを削除します。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public void deletePhysicalByKey(
            DbT7022ShoriDateKanriEntity entity) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        accessor.deletePhysical(entity);
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
     * requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
     *
     * DbT7022ShoriDateKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT7022ShoriDateKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
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
                where(eq(
                                subGyomuCode, サブ業務コード)).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
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
     * selectSubGyomuCode 基準年月日を取得します。
     *
     * @param 処理名 shoriName
     * @param 年度 nendo
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectKijunYMD(RString 処理名, FlexibleYear 年度) throws NullPointerException {
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
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select(RString 処理名,
            RString 処理枝番) throws NullPointerException {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
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
    public List<DbT7022ShoriDateKanriEntity> selectFor年度内処理済み連番(RString 処理名, FlexibleYear 年度) throws NullPointerException {
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
                                eq(subGyomuCode, SubGyomuCode.DBU介護統計報告),
                                eq(shoriName, 介護住民票個別事項連携情報作成_他社住基),
                                eq(shoriEdaban, 年度内連番_0))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 年度 年度
     * @param 処理名 処理名
     * @param サブ業務コード サブ業務コード
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況(FlexibleYear 年度, List<RString> 処理名,
            SubGyomuCode サブ業務コード) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                in(shoriName, 処理名),
                                eq(subGyomuCode, サブ業務コード),
                                eq(nendo, 年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
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
     * 処理日付管理マスタ取得件数情報作成するメソッドです。
     *
     * @param 年度 FlexibleYear
     * @return int 取得件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int select処理日付管理マスタ取得件数(FlexibleYear 年度) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, 基準収入額適用申請書異動),
                                eq(nendo, 年度))).getCount();
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
            SubGyomuCode サブ業務コード, RString 処理名, FlexibleYear 年度) throws NullPointerException {
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
     * 処理日付管理マスタテーブルから、過年度賦課の最新の基準日時を取得する。
     *
     * @param 調定年度 調定年度
     * @param 処理名リスト List<RString>
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最新の基準日(FlexibleYear 調定年度, List<RString> 処理名リスト) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                in(shoriName, 処理名リスト),
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
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
    public List<DbT7022ShoriDateKanriEntity> selectShoriDateKanri(SubGyomuCode サブ業務コード, RString 処理名,
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
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名))).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
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
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.shoriEdaban, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
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
    public DbT7022ShoriDateKanriEntity select最大基準日時(SubGyomuCode サブ業務コード, RString 処理名, RString 処理枝番, FlexibleYear 年度) {
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
     * 受給者台帳管理マスタを取得します。
     *
     * @param 市町村コード ShichosonCode
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select前回抽出期間情報の取得(LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBD介護受給),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, ShoriName.受給者台帳.get名称()),
                                eq(nendoNaiRenban, 年度内連番_1))).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 項目に一致で処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @param 市町村コード ShichosonCode
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectBySomeColumns(SubGyomuCode サブ業務コード, RString 処理名, FlexibleYear 年度,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度),
                                eq(shichosonCode, 市町村コード))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @param 処理名 処理名
     * @param 年度内連番 年度内連番
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況(FlexibleYear 調定年度, RString 処理名, RString 年度内連番) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                eq(nendoNaiRenban, 年度内連番),
                                eq(nendo, 調定年度))).
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
     * 抽出期間の取得値を取得します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 市町村コード 市町村コード
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectBy抽出期間の取得(SubGyomuCode サブ業務コード, RString 処理名, List<RString> 処理枝番,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                in(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectBySomeKeys(SubGyomuCode サブ業務コード, RString 処理名, FlexibleYear 年度,
            RString 年度内連番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
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
    public DbT7022ShoriDateKanriEntity selectByFourKeys(SubGyomuCode サブ業務コード, RString 処理名, RString 処理枝番,
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
     * 処理状況一覧情報取得
     *
     * @param 年度 nendo
     * @param 処理名 RString
     * @param 年度内連番 RString
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select処理状況一覧情報(
            FlexibleYear 年度, RString 処理名, RString 年度内連番) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                order(by(DbT7022ShoriDateKanri.shichosonCode, Order.ASC)).
                toList(DbT7022ShoriDateKanriEntity.class);
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
    public DbT7022ShoriDateKanriEntity select今回処理内容情報(SubGyomuCode サブ業務コード, FlexibleYear 年度) throws NullPointerException {
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
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名,
            RString 処理枝番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
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
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(nendo, new RYear(年度_0000))))
                .order(new OrderBy(shoriEdaban, Order.DESC, NullsOrder.LAST),
                        new OrderBy(nendoNaiRenban, Order.DESC, NullsOrder.LAST)).limit(1).
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
                        new OrderBy(nendoNaiRenban, Order.DESC, NullsOrder.LAST)).limit(1).
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
    public List<DbT7022ShoriDateKanriEntity> selectBySomeKeys(SubGyomuCode サブ業務コード, RString 処理名, RString 処理枝番, FlexibleYear 年度,
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
    public DbT7022ShoriDateKanriEntity selectByKey(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
            FlexibleYear 年度, RString 年度内連番) throws NullPointerException {
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

    //**********************************************************************************************************************************************
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
    public DbT7022ShoriDateKanriEntity select基準日時ByKey(LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
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
                                eq(shoriName, ShoriName.依頼金額計算.get名称()),
                                eq(nendo, 調定年度),
                                eq(shoriEdaban, 処理枝番),
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
                                eq(shoriName, ShoriName.更正対象給付実績一覧.get名称()))).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理済の有効期間終了月と前回処理日の取得
     *
     * @param 市町村コード 市町村コード
     * @return 前回処理日
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select前回処理日(LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
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
                                eq(shoriName, ShoriName.年次利用者負担割合判定.get名称()),
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

    /**
     * 前回対象日を取得する。
     *
     * @param 市町村コード LasdecCode
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select前回対象日(LasdecCode 市町村コード) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<RString> 処理枝番List = new ArrayList<>();
        処理枝番List.add(処理枝番_01);
        処理枝番List.add(処理枝番_02);
        処理枝番List.add(処理枝番_03);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, ShoriName.高額サービス費支給決定通知書作成.get名称()),
                                in(shoriEdaban, 処理枝番List),
                                eq(nendo, 年度内連番_0),
                                eq(nendoNaiRenban, 年度内連番_0))).
                order(by(shoriEdaban, Order.ASC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 対象終了日時を取得する。
     *
     * @param 導入形態コード RString
     * @param 市町村コードリスト List<LasdecCode>
     * @param 市町村識別IDリスト List<RString>
     * @param 市町村コード LasdecCode
     * @param 処理年度 FlexibleYear
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selec対象終了日時(RString 導入形態コード,
            List<LasdecCode> 市町村コードリスト,
            List<RString> 市町村識別IDリスト,
            LasdecCode 市町村コード,
            FlexibleYear 処理年度) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            return accessor.selectSpecific(max(nendoNaiRenban), shichosonCode, taishoShuryoTimestamp).
                    table(DbT7022ShoriDateKanri.class).
                    where(and(
                                    eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                    eq(shichosonCode, 市町村コード),
                                    eq(shoriName, ShoriName.所得情報一覧表作成.get名称()),
                                    eq(shoriEdaban, 処理枝番),
                                    eq(nendo, 処理年度)))
                    .groupBy(nendoNaiRenban, shichosonCode, taishoShuryoTimestamp).
                    order(by(shichosonCode, Order.ASC)).
                    toList(DbT7022ShoriDateKanriEntity.class);
        } else if (INDEX_111.equals(導入形態コード)) {
            return accessor.selectSpecific(max(nendoNaiRenban), shichosonCode, taishoShuryoTimestamp).
                    table(DbT7022ShoriDateKanri.class).
                    where(and(
                                    eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                    in(shichosonCode, 市町村コードリスト),
                                    eq(shoriName, ShoriName.所得情報一覧表作成.get名称()),
                                    in(shoriEdaban, 市町村識別IDリスト),
                                    eq(nendo, 処理年度)))
                    .groupBy(nendoNaiRenban, shichosonCode, taishoShuryoTimestamp).
                    order(by(shichosonCode, Order.ASC)).
                    toList(DbT7022ShoriDateKanriEntity.class);
        } else {
            return null;
        }
    }

    /**
     * 対象期間前回を取得する。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity select対象期間前回(SubGyomuCode サブ業務コード, LasdecCode 市町村コード,
            RString 処理名, RString 処理枝番, FlexibleYear 年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(taishoKaishiYMD, taishoKaishiTimestamp, taishoShuryoYMD, taishoShuryoTimestamp).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度))
                ).order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);

    }

    /**
     * 処理日付管理マスタから、過去集計情報を取得です。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタ(SubGyomuCode サブ業務コード, List<RString> 処理名, List<RString> 処理枝番) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                in(shoriName, 処理名),
                                in(shoriEdaban, 処理枝番))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 年度内通番を取得する。
     *
     * @param サブ業務コード サブ業務コード
     * @param 年度 年度
     * @param 処理名 処理名
     * @param 処理枝番List 処理枝番List
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select年度内通番(SubGyomuCode サブ業務コード, RString 年度, RString 処理名, List<RString> 処理枝番List) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(nendo, 年度),
                                eq(shoriName, 処理名),
                                in(shoriEdaban, 処理枝番List))).
                order(by(nendoNaiRenban, Order.DESC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 対象開始日時AND対象終了日時を更新します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select対象開始日時toupdate(SubGyomuCode サブ業務コード, LasdecCode 市町村コード,
            RString 処理名, RString 処理枝番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 ShoriName
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectNendo(SubGyomuCode サブ業務コード, RString 市町村コード,
            RString 処理名) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(nendo).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(shichosonCode, 市町村コード)))
                .groupBy(nendo)
                .order(by(nendo, Order.DESC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select非課税年金対象者情報for広域(SubGyomuCode サブ業務コード, RString 処理名, RString 処理枝番,
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
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 非課税年金対象者情報forチェックを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度内通番 RString
     * @param 年度 Nendo
     * @param 市町村コード LasdecCode
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> select非課税年金対象者情報forチェック(SubGyomuCode サブ業務コード, RString 処理名, RString 年度内通番,
            FlexibleYear 年度, LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度内通番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shoriName, 処理名),
                                eq(nendoNaiRenban, 年度内通番),
                                eq(shichosonCode, 市町村コード),
                                eq(nendo, 年度))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度を取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大年度() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendo)).
                table(DbT7022ShoriDateKanri.class).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度内連番を取得する。
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大年度内連番() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 年次利用者負担割合判定を実施した最新の年度を取得です。
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity get年次の最新実施年度() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, ShoriName.年次利用者負担割合判定.get名称()),
                                not(eq(kijunYMD, FlexibleYear.EMPTY)))).
                order(by(nendo, Order.DESC)).
                limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 年次利用者負担割合判定の実施日時の取得です。
     *
     * @param 年度 FlexibleYear
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity get年次の実施日時(FlexibleYear 年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, ShoriName.年次利用者負担割合判定.get名称()),
                                eq(nendo, 年度))).
                order(by(nendoNaiRenban, Order.DESC)).
                limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 異動分利用者負担割合判定の実施日時の取得です。
     *
     * @param 年度 FlexibleYear
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity get異動の実施日時(FlexibleYear 年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBC介護給付),
                                eq(shoriName, ShoriName.異動分利用者負担割合判定.get名称()),
                                eq(nendo, 年度))).
                order(by(nendoNaiRenban, Order.DESC)).
                limit(1).
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
    public DbT7022ShoriDateKanriEntity getMax基準日(FlexibleYear 調定年度, RString 処理名) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(kijunTimestamp)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriName, 処理名))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 市町村処理日付のデータを取得します。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理枝番 RString
     * @param 処理名List List<RString>
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get市町村処理日付(FlexibleYear 調定年度,
            RString 処理枝番, List<RString> 処理名List) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(nendo, 調定年度),
                                eq(shoriEdaban, 処理枝番),
                                in(shoriName, 処理名List))).
                limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタから処理状況の情報を取得する。
     *
     * @param 年度 FlexibleYear
     * @param 処理名 RString
     * @param 年度連番 RString
     * @param 処理枝番 RString
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select特徴月処理日付(FlexibleYear 年度, RString 処理名, RString 年度連番, RString 処理枝番) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度連番))).
                limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、最大年度の最大年度内連番を取得する。
     *
     * @param 年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select最大年度の最大年度内連番(FlexibleYear 年度) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(nendoNaiRenban)).
                table(DbT7022ShoriDateKanri.class).
                where(
                        eq(nendo, 年度)).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 月構成市町村処理日付の情報を取得する。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理枝番 RString
     * @param 年度内連番 RString
     * @param 処理名List List<RString>
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get月構成市町村処理日付(FlexibleYear 調定年度, RString 処理枝番, RString 年度内連番, List<RString> 処理名List) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriEdaban, 処理枝番),
                                eq(nendo, 調定年度),
                                or(and(eq(shoriName, 処理名List.get(INT_0)), eq(nendoNaiRenban, 年度内連番)),
                                        and(eq(shoriName, 処理名List.get(INT_1)), eq(nendoNaiRenban, 年度内連番_1))
                                ))).
                limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 抽出条件前回処理日付を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select抽出条件前回処理日付(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名,
            RString 処理枝番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.kijunYMD, Order.DESC),
                        by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 処理名 処理名
     * @param 年度内連番 年度内連番
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get処理状況(RString 処理名, RString 年度内連番) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBB介護賦課),
                                eq(shoriName, 処理名),
                                eq(nendoNaiRenban, 年度内連番))).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理日付管理マスタ(SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, 処理名),
                                eq(nendo, 年度_0000),
                                eq(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

}

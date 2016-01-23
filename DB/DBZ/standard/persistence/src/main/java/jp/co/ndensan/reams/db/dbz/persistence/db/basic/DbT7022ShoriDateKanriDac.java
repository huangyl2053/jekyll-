
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
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.nendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.nendoNaiRenban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shoriEdaban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.shoriName;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanri.subGyomuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付管理マスタのデータアクセスクラスです。
 */
public class DbT7022ShoriDateKanriDac implements ISaveable<DbT7022ShoriDateKanriEntity> {

    @InjectSession
    private SqlSession session;

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
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));

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
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理マスタエンティティ"));
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
                                eq(subGyomuCode, "DBU"),
                                eq(shoriName, "介護住民票個別事項連携情報作成【他社住基】"),
                                eq(shoriEdaban, "0000"))).
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
                                eq(subGyomuCode, "DBA"),
                                eq(shoriName, "異動チェックリスト"))).
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
                where(and(eq(isDeleted, false),
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
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, "DBU"),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, "被保険者証一括発行"),
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
            RString 処理枝番,
            LasdecCode 導入団体取得) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, "DBU"),
                                eq(shichosonCode, 導入団体取得),
                                eq(shoriName, "被保険者証一括発行"),
                                in(shoriEdaban, 処理枝番))).
                order(by(DbT7022ShoriDateKanri.kijunTimestamp, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 年度
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理状況_1(FlexibleYear 年度) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                //  to do 検索条件： 処理名　IN 処理名リスト
                                eq(subGyomuCode, "DBB"),
                                eq(nendo, 年度)
                        )).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタテーブルから、処理状況取得する。
     *
     * @param 年度
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select処理状況_2(FlexibleYear 年度) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, "DBB"),
                                eq(nendo, 年度),
                                eq(shoriName, "特徴平準化計算_6月分"))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }
}

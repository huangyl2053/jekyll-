/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.choteiNichiji;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.koseiZengoKubun;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.sakuseiShoriName;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 計算後情報のデータアクセスクラスです。
 */
public class DbT2015KeisangoJohoDac implements ISaveable<DbT2015KeisangoJohoEntity> {

    private static final RString RSTRING_イチ = new RString("1");
    private static final RString RSTRING_ニ = new RString("2");
    private static final int INT_イチ = 1;
    private static final int INT_ニ = 2;

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで計算後情報を取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 更正前後区分 更正前後区分
     * @param 作成処理名 作成処理名
     * @return DbT2015KeisangoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2015KeisangoJohoEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 更正前後区分,
            RString 作成処理名) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(更正前後区分, UrSystemErrorMessages.値がnull.getReplacedMessage("更正前後区分"));
        requireNonNull(作成処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("作成処理名"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2015KeisangoJoho.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(koseiZengoKubun, 更正前後区分),
                                eq(sakuseiShoriName, 作成処理名))).
                toObject(DbT2015KeisangoJohoEntity.class);
    }

    /**
     * 計算後情報を取得します。
     *
     * @param 調定年度 調定年度
     * @param 日付関連_年度サイクル 日付関連_年度サイクル
     * @param 調定日時 調定日時
     * @param 作成処理名 作成処理名
     * @return DbT2015KeisangoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2015KeisangoJohoEntity> select計算後情報(
            FlexibleYear 調定年度,
            RString 日付関連_年度サイクル,
            YMDHMS 調定日時,
            RString 作成処理名) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(日付関連_年度サイクル, UrSystemErrorMessages.値がnull.getReplacedMessage("日付関連_年度サイクル"));
        requireNonNull(調定日時, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日時"));
        requireNonNull(作成処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("作成処理名"));

        FlexibleYear 調定年度minus1 = 調定年度.minusYear(INT_イチ);
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        if (RSTRING_イチ.equals(日付関連_年度サイクル)) {
            return accessor.select().
                    table(DbT2015KeisangoJoho.class).
                    where(and(
                                    eq(choteiNendo, 調定年度),
                                    eq(fukaNendo, 調定年度minus1),
                                    eq(choteiNichiji, 調定日時),
                                    eq(sakuseiShoriName, 作成処理名))).
                    toList(DbT2015KeisangoJohoEntity.class);
        } else if (RSTRING_ニ.equals(日付関連_年度サイクル)) {
            FlexibleYear 調定年度minus2 = 調定年度.minusYear(INT_ニ);
            return accessor.select().
                    table(DbT2015KeisangoJoho.class).
                    where(and(
                                    eq(choteiNendo, 調定年度),
                                    or(
                                            eq(fukaNendo, 調定年度minus2),
                                            eq(fukaNendo, 調定年度minus1)
                                    ),
                                    eq(choteiNichiji, 調定日時),
                                    eq(sakuseiShoriName, 作成処理名))).
                    toList(DbT2015KeisangoJohoEntity.class);
        }
        return null;

    }

    /**
     * 計算後情報を全件返します。
     *
     * @return List<DbT2015KeisangoJohoEntity>
     */
    @Transaction
    public List<DbT2015KeisangoJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2015KeisangoJoho.class).
                toList(DbT2015KeisangoJohoEntity.class);
    }

    /**
     * 処理名の過年度賦課のレコードを返します。
     *
     * @param 作成処理名 RString
     * @return List<DbT2015KeisangoJohoEntity>
     */
    public List<DbT2015KeisangoJohoEntity> selectBy処理名(RString 作成処理名) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2015KeisangoJoho.class).
                where(eq(作成処理名, sakuseiShoriName)).
                toList(DbT2015KeisangoJohoEntity.class);
    }

    /**
     * DbT2015KeisangoJohoEntityを削除します。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT2015KeisangoJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("計算後情報エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT2015KeisangoJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2015KeisangoJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("計算後情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

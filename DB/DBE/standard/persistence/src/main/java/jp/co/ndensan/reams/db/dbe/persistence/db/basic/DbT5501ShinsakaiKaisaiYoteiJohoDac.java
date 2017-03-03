/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催予定情報のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 chengsanyuan
 */
public class DbT5501ShinsakaiKaisaiYoteiJohoDac implements ISaveable<DbT5501ShinsakaiKaisaiYoteiJohoEntity> {

    private static final int INDEX_6 = 6;
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会開催予定情報を取得します。
     *
     * @param 介護認定審査会開催番号 ShinsakaiKaisaiNo
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5501ShinsakaiKaisaiYoteiJohoEntity selectByKey(
            RString 介護認定審査会開催番号) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                where(
                        eq(DbT5501ShinsakaiKaisaiYoteiJoho.shinsakaiKaisaiNo, 介護認定審査会開催番号)).
                toObject(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    /**
     * 年月で介護認定審査会開催予定情報を取得します。
     *
     * @param 年月 年月
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5501ShinsakaiKaisaiYoteiJohoEntity> selectNengetsu(
            RString 年月) throws NullPointerException {
        requireNonNull(年月, UrSystemErrorMessages.値がnull.getReplacedMessage("年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                where(
                        eq(substr(DbT5501ShinsakaiKaisaiYoteiJoho.shinsakaiKaisaiYoteiYMD, 1, INDEX_6), 年月)).
                toList(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    /**
     * 開催場所コードで介護認定審査会開催予定情報を取得します。
     *
     * @param 開催場所コード RString
     * @return List<DbT5501ShinsakaiKaisaiYoteiJohoEntity>
     * @throws NullPointerException 引数がnullの場合
     */
    @Transaction
    public List<DbT5501ShinsakaiKaisaiYoteiJohoEntity> selectBy開催場所コード(
            RString 開催場所コード) throws NullPointerException {
        requireNonNull(開催場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("開催場所コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                where(
                        eq(DbT5501ShinsakaiKaisaiYoteiJoho.shinsakaiKaisaiYoteiBashoCode, 開催場所コード)).
                toList(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    /**
     * 介護認定審査会開催予定情報を全件返します。
     *
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5501ShinsakaiKaisaiYoteiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                toList(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    /**
     * DbT5501ShinsakaiKaisaiYoteiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報エンティティ"));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 合議体番号で介護認定審査会開催予定情報の件数を取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int selectByGogitaiNO(
            int 合議体番号) throws NullPointerException {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                where(
                        eq(DbT5501ShinsakaiKaisaiYoteiJoho.gogitaiNo, 合議体番号)
                ).getCount();
    }
    
    /**
     * 合議体番号,合議体有効期間で介護認定審査会開催予定情報の件数を取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @param 合議体有効期間終了年月日 合議体有効期間終了年月日
     * @return 件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int countYoteiJoho(
            int 合議体番号, FlexibleDate 合議体有効期間開始年月日, FlexibleDate 合議体有効期間終了年月日) throws NullPointerException {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5501ShinsakaiKaisaiYoteiJoho.class).
                where(and(
                        eq(DbT5501ShinsakaiKaisaiYoteiJoho.gogitaiNo, 合議体番号),
                        leq(DbT5501ShinsakaiKaisaiYoteiJoho.shinsakaiKaisaiYoteiYMD, 合議体有効期間終了年月日),
                        leq(合議体有効期間開始年月日, DbT5501ShinsakaiKaisaiYoteiJoho.shinsakaiKaisaiYoteiYMD))).getCount();
    }
}

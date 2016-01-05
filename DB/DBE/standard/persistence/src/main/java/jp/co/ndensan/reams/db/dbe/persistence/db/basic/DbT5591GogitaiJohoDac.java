/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJoho.gogitaiNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJoho.gogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体情報のデータアクセスクラスです。
 */
public class DbT5591GogitaiJohoDac implements ISaveable<DbT5591GogitaiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合議体情報を取得します。
     *
     * @param 合議体番号 GogitaiNo
     * @param 合議体有効期間開始年月日 GogitaiYukoKikanKaishiYMD
     * @return DbT5591GogitaiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5591GogitaiJohoEntity selectByKey(
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日) throws NullPointerException {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        requireNonNull(合議体有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間開始年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5591GogitaiJoho.class).
                where(and(
                                eq(gogitaiNo, 合議体番号),
                                eq(gogitaiYukoKikanKaishiYMD, 合議体有効期間開始年月日))).
                toObject(DbT5591GogitaiJohoEntity.class);
    }

    /**
     * 合議体情報を全件返します。
     *
     * @return DbT5591GogitaiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5591GogitaiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5591GogitaiJoho.class).
                toList(DbT5591GogitaiJohoEntity.class);
    }

    /**
     * DbT5591GogitaiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5591GogitaiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 合議体番号の重複をチェックします。
     *
     * @param 合議体番号 GogitaiNo
     * @return int
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int selectgogitaiNoJuuhukuByKey(
            int 合議体番号) throws NullPointerException {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT5591GogitaiJoho.class).
                where(
                        eq(gogitaiNo, 合議体番号)).
                getCount();
    }

    /**
     * 合議体情報deletePhysical件数を返します。
     *
     * @param entity 合議体情報テーブルのエンティティ
     * @return int 物理削除件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int deletePhysical(DbT5591GogitaiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

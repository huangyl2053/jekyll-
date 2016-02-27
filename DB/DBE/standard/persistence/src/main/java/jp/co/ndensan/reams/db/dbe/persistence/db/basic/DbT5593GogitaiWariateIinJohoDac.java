/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJoho.gogitaiNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJoho.shinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当委員情報のデータアクセスクラスです。
 */
public class DbT5593GogitaiWariateIinJohoDac implements ISaveable<DbT5593GogitaiWariateIinJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合議体割当委員情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return DbT5593GogitaiWariateIinJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5593GogitaiWariateIinJohoEntity selectByKey(
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日,
            RString 介護認定審査会委員コード) throws NullPointerException {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        requireNonNull(合議体有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間開始年月日"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5593GogitaiWariateIinJoho.class).
                where(and(
                                eq(gogitaiNo, 合議体番号),
                                eq(gogitaiYukoKikanKaishiYMD, 合議体有効期間開始年月日),
                                eq(shinsakaiIinCode, 介護認定審査会委員コード))).
                toObject(DbT5593GogitaiWariateIinJohoEntity.class);
    }

    /**
     * 合議体割当委員情報を全件返します。
     *
     * @return DbT5593GogitaiWariateIinJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5593GogitaiWariateIinJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5593GogitaiWariateIinJoho.class).
                toList(DbT5593GogitaiWariateIinJohoEntity.class);
    }

    /**
     * DbT5593GogitaiWariateIinJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5593GogitaiWariateIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 合議体割当委員情報deletePhysical件数を返します。
     *
     * @param entity 合議体割当委員情報エンティティ
     * @return int 物理削除件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int deletePhysical(DbT5593GogitaiWariateIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * 主キーで合議体割当委員情報の件数を取得します。
     *
     * @param 合議体番号 合議体番号
     * @return int
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int selectByGogitaiNO(int 合議体番号) throws NullPointerException {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5593GogitaiWariateIinJoho.class).
                where(eq(gogitaiNo, 合議体番号)).getCount();
    }
}

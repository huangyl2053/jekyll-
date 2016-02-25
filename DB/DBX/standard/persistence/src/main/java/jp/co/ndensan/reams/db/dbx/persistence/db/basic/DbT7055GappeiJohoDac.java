/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJoho;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJoho.chiikiNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJoho.gappeiYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併情報のデータアクセスクラスです。
 */
public class DbT7055GappeiJohoDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合併情報を取得します。
     *
     * @param 合併年月日 GappeiYMD
     * @param 地域番号 ChiikiNo
     * @return DbT7055GappeiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7055GappeiJohoEntity selectByKey(
            FlexibleDate 合併年月日,
            RString 地域番号) throws NullPointerException {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7055GappeiJoho.class).
                where(and(
                                eq(gappeiYMD, 合併年月日),
                                eq(chiikiNo, 地域番号))).
                toObject(DbT7055GappeiJohoEntity.class);
    }

    /**
     * 合併情報を全件返します。
     *
     * @return DbT7055GappeiJohoEntityのlist
     */
    @Transaction
    public List<DbT7055GappeiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7055GappeiJoho.class).
                toList(DbT7055GappeiJohoEntity.class);
    }

    /**
     * 最新の合併情報を返します。
     *
     * @param 市町村コード LasdecCode
     * @return DbT7055GappeiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7055GappeiJohoEntity selectTopOneByShichosonCode(LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7055GappeiJoho.class).
                where(eq(DbT7055GappeiJoho.shichosonCode, 市町村コード)).
                order(by(DbT7055GappeiJoho.chiikiNo, Order.DESC)).
                limit(1).
                toObject(DbT7055GappeiJohoEntity.class);
    }

    /**
     * 指定地域番号よりも小さい地域番号を持つ合併情報を返します。 (同値は含まない。)
     *
     * @param 地域番号 RString
     * @return List<DbT7055GappeiJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7055GappeiJohoEntity> selectByLtChiikiNo(RString 地域番号) throws NullPointerException {
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7055GappeiJoho.class).
                where(lt(DbT7055GappeiJoho.chiikiNo, 地域番号)).
                toList(DbT7055GappeiJohoEntity.class);
    }

    /**
     * 旧市町村コード付加終了年月日を返します。
     *
     * @return DbT7055GappeiJohoEntity
     */
    @Transaction
    public DbT7055GappeiJohoEntity get旧市町村コード付加終了年月日() {
        DbAccessorNormalType dbAcessor = new DbAccessorNormalType(session);

        return dbAcessor.select().
                table(DbT7055GappeiJoho.class).
                order(by(DbT7055GappeiJoho.gappeiYMD, Order.DESC)).
                limit(1).
                toObject(DbT7055GappeiJohoEntity.class);
    }

    /**
     * DbT7055GappeiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7055GappeiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT7055GappeiJohoEntityをInsertします。
     *
     * @param entity DbT7055GappeiJohoEntity
     * @return 登録件数
     */
    public int insert(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * DbT7055GappeiJohoEntityをUpdateします。
     *
     * @param entity DbT7055GappeiJohoEntity
     * @return 更新件数
     */
    public int update(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * DbT7055GappeiJohoEntityを削除します。
     *
     * @param entity DbT7055GappeiJohoEntity
     * @return 削除件数
     */
    public int delete(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * DbT7055GappeiJohoEntityを物理削除します。
     *
     * @param entity DbT7055GappeiJohoEntity
     * @return 削除件数
     */
    public int deletePhysical(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 合併情報Listを取得する。
     *
     * @param 地域番号 地域番号
     * @return 合併情報List
     */
    @Transaction
    public List<DbT7055GappeiJohoEntity> getGappeiJohoList(RString 地域番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(chiikiNo, shichosonCode).
                table(DbT7055GappeiJoho.class).
                where(lt(chiikiNo, 地域番号)).
                order(new OrderBy(chiikiNo, Order.DESC, NullsOrder.LAST)).
                toList(DbT7055GappeiJohoEntity.class);
    }

    /**
     * 最新の地域番号を取得する。
     *
     * @param 市町村コード 市町村コード
     * @return 最新の地域番号
     */
    @Transaction
    public DbT7055GappeiJohoEntity getSaisinNoTiikiNo(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(chiikiNo, shichosonCode).
                table(DbT7055GappeiJoho.class).
                where(eq(shichosonCode, 市町村コード)).
                order(new OrderBy(chiikiNo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT7055GappeiJohoEntity.class);
    }
}

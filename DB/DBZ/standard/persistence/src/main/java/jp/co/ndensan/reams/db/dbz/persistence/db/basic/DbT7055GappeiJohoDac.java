/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJoho.chiikiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJoho.gappeiYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJohoEntity;
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
 * 合併情報のデータアクセスクラスです。
 */
public class DbT7055GappeiJohoDac implements ISaveable<DbT7055GappeiJohoEntity> {

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
     * @return List<DbT7055GappeiJohoEntity>
     */
    @Transaction
    public List<DbT7055GappeiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7055GappeiJoho.class).
                toList(DbT7055GappeiJohoEntity.class);
    }

    /**
     * DbT7055GappeiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7055GappeiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    public int insert(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int deletePhysical(DbT7055GappeiJohoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

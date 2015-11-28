/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.chiikiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.gappeiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.hyojiUmu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.kyuShichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.unyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.unyoShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村のデータアクセスクラスです。
 */
public class DbT7056GappeiShichosonDac implements ISaveable<DbT7056GappeiShichosonEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合併市町村を取得します。
     *
     * @param 合併年月日 GappeiYMD
     * @param 地域番号 ChiikiNo
     * @param 旧市町村コード KyuShichosonCode
     * @return DbT7056GappeiShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7056GappeiShichosonEntity selectByKey(
            FlexibleDate 合併年月日,
            RString 地域番号,
            LasdecCode 旧市町村コード) throws NullPointerException {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                where(and(
                                eq(gappeiYMD, 合併年月日),
                                eq(chiikiNo, 地域番号),
                                eq(kyuShichosonCode, 旧市町村コード))).
                toObject(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * 合併市町村選択情報を取得します。
     *
     * @param 基準日
     * @return　List<DbT7056GappeiShichosonEntity>
     *
     */
    @Transaction
    public List<DbT7056GappeiShichosonEntity> selectfor合併市町村選択情報の取得処理(
            FlexibleDate 基準日) throws NullPointerException {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                where(and(eq(hyojiUmu, new RString("1")),
                                leq(unyoKaishiYMD, 基準日),
                                leq(基準日, unyoShuryoYMD))).
                order(by(gappeiYMD, Order.DESC),
                        by(kyuShichosonCode)).
                toList(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * 合併市町村を全件返します。
     *
     * @return List<DbT7056GappeiShichosonEntity>
     */
    @Transaction
    public List<DbT7056GappeiShichosonEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                toList(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * DbT7056GappeiShichosonEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7056GappeiShichosonEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    public int insert(DbT7056GappeiShichosonEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(DbT7056GappeiShichosonEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(DbT7056GappeiShichosonEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public int deletePhysical(DbT7056GappeiShichosonEntity entity) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichoson;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichoson.chosaChikuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichoson.jiChikuFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichoson.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichoson.yusenNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地区市町村のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 linghuhang
 */
public class DbT5224ChikuShichosonDac implements ISaveable<DbT5224ChikuShichosonEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで地区市町村を取得します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return DbT5224ChikuShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5224ChikuShichosonEntity selectByKey(
            Code 調査地区コード,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5224ChikuShichoson.class).
                where(and(
                                eq(chosaChikuCode, 調査地区コード),
                                eq(shichosonCode, 市町村コード))).
                toObject(DbT5224ChikuShichosonEntity.class);
    }

    /**
     * 地区市町村を全件返します。
     *
     * @return DbT5224ChikuShichosonEntityの{@code list}
     */
    @Transaction
    public List<DbT5224ChikuShichosonEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5224ChikuShichoson.class).
                toList(DbT5224ChikuShichosonEntity.class);
    }

    /**
     * DbT5224ChikuShichosonEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5224ChikuShichosonEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 対象地区ドロップダウンリスト値取得します。
     *
     * @return DbT5224ChikuShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5224ChikuShichosonEntity> selectByjiChikuFlag() throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(DbT5224ChikuShichoson.chosaChikuCode).
                table(DbT5224ChikuShichoson.class).
                where((eq(jiChikuFlag, true))).groupBy(DbT5224ChikuShichoson.chosaChikuCode).
                toList(DbT5224ChikuShichosonEntity.class);
    }

    /**
     * 対象地区ドロップダウンリスト値取得します。
     *
     * @param 市町村コード 市町村コード
     * @return DbT5224ChikuShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5224ChikuShichosonEntity> selectByShichosonCode(LasdecCode 市町村コード) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(DbT5224ChikuShichoson.chosaChikuCode).
                table(DbT5224ChikuShichoson.class).
                where((eq(shichosonCode, 市町村コード))).
                toList(DbT5224ChikuShichosonEntity.class);
    }

    /**
     * 地区市町村を返します。
     *
     * @param 調査地区コード 調査地区コード
     * @return DbT5224ChikuShichosonEntity{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5224ChikuShichosonEntity> select地区市町村(Code 調査地区コード) throws NullPointerException {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5224ChikuShichoson.class).
                where(eq(chosaChikuCode, 調査地区コード)).order(by(yusenNo, Order.ASC)).
                toList(DbT5224ChikuShichosonEntity.class);
    }
}

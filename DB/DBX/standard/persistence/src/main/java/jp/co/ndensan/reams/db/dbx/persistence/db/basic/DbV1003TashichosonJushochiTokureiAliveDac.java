/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokurei;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokurei.edaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokurei.idoYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokurei.shikibetsuCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例者台帳管理Aliveのデータアクセスクラスです。
 */
public class DbV1003TashichosonJushochiTokureiAliveDac implements ISaveable<DbV1003TashichosonJushochiTokureiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで他市町村住所地特例者台帳管理Aliveを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return DbV1003TashichosonJushochiTokureiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1003TashichosonJushochiTokureiEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbV1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 識別コードで他市町村住所地特例者台帳管理Aliveを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbV1003TashichosonJushochiTokureiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1003TashichosonJushochiTokureiEntity selectByShikibetsuCode(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbV1003TashichosonJushochiTokurei.class)
                .where(eq(shikibetsuCode, 識別コード))
                .order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST), new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST))
                .toObject(DbV1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 他市町村住所地特例者台帳管理Aliveを全件返します。
     *
     * @return List<DbV1003TashichosonJushochiTokureiEntity>
     */
    @Transaction
    public List<DbV1003TashichosonJushochiTokureiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1003TashichosonJushochiTokurei.class).
                toList(DbV1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * DbV1003TashichosonJushochiTokureiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV1003TashichosonJushochiTokureiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例者台帳管理Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

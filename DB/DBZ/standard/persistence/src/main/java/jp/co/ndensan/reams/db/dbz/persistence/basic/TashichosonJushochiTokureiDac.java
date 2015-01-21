/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IPersistable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokurei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokurei.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例のデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class TashichosonJushochiTokureiDac implements IPersistable<DbT1003TashichosonJushochiTokureiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで他市町村住所地特例を取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 ShoriTimeStamp
     * @return DbT1003TashichosonJushochiTokureiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1003TashichosonJushochiTokureiEntity selectByKey(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shikibetsuCode, 識別コード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 他市町村住所地特例を全件返します。
     *
     * @return List<DbT1003TashichosonJushochiTokureiEntity>
     */
    @Transaction
    public List<DbT1003TashichosonJushochiTokureiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1003TashichosonJushochiTokureiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1003TashichosonJushochiTokureiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1003TashichosonJushochiTokureiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

//    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT1003TashichosonJushochiTokureiEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}

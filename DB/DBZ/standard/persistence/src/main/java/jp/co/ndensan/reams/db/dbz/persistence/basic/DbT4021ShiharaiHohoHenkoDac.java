/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenko;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenko.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class DbT4021ShiharaiHohoHenkoDac implements IModifiable<DbT4021ShiharaiHohoHenkoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 shoKisaiHokenshaNo
     * @param 被保険者番号 hihokenshaNo
     * @param 管理区分 kanriKubun
     * @param 処理日時 shoriTimestamp
     * @return DbT4021ShiharaiHohoHenkoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4021ShiharaiHohoHenkoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kanriKubun, 管理区分),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    /**
     * 支払方法変更を全件返します。
     *
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    @Transaction
    public List<DbT4021ShiharaiHohoHenkoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT4021ShiharaiHohoHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT4021ShiharaiHohoHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT4021ShiharaiHohoHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT4021ShiharaiHohoHenkoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT4021ShiharaiHohoHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengaku;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengaku.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengaku.kanriKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengaku.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更減額のデータアクセスクラスです。
 */
public class DbT4025ShiharaiHohoHenkoGengakuDac implements ISaveable<DbT4025ShiharaiHohoHenkoGengakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更減額を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @return DbT4025ShiharaiHohoHenkoGengakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4025ShiharaiHohoHenkoGengakuEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4025ShiharaiHohoHenkoGengaku.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kanriKubun, 管理区分),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4025ShiharaiHohoHenkoGengakuEntity.class);
    }

    /**
     * 支払方法変更減額を全件返します。
     *
     * @return DbT4025ShiharaiHohoHenkoGengakuEntityの{@code list}
     */
    @Transaction
    public List<DbT4025ShiharaiHohoHenkoGengakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4025ShiharaiHohoHenkoGengaku.class).
                toList(DbT4025ShiharaiHohoHenkoGengakuEntity.class);
    }

    /**
     * DbT4025ShiharaiHohoHenkoGengakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4025ShiharaiHohoHenkoGengakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

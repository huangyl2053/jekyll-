/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanri;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanri.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanri.shichosonCode;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不均一納期管理のデータアクセスクラスです。
 *
 * @reamsid_L DBB-9999-012 cuilin
 */
public class DbT2016FukinitsuNokiKanriDac implements ISaveable<DbT2016FukinitsuNokiKanriEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 調定年度メッセージ = new RString("調定年度");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 不均一納期管理エンティティ = new RString("不均一納期管理エンティティ");

    /**
     * 主キーで不均一納期管理を取得します。
     *
     * @param 調定年度 FlexibleYear
     * @param 市町村コード LasdecCode
     * @return DbT2016FukinitsuNokiKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2016FukinitsuNokiKanriEntity selectByKey(
            FlexibleYear 調定年度,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2016FukinitsuNokiKanri.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(shichosonCode, 市町村コード))).
                toObject(DbT2016FukinitsuNokiKanriEntity.class);
    }

    /**
     * 不均一納期管理を全件返します。
     *
     * @return List<DbT2016FukinitsuNokiKanriEntity>
     */
    @Transaction
    public List<DbT2016FukinitsuNokiKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2016FukinitsuNokiKanri.class).
                toList(DbT2016FukinitsuNokiKanriEntity.class);
    }

    /**
     * DbT2016FukinitsuNokiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2016FukinitsuNokiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(不均一納期管理エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 市町村コードを取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return List<DbT2016FukinitsuNokiKanriEntity>
     */
    @Transaction
    public List<DbT2016FukinitsuNokiKanriEntity> selectShichosonCode(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度メッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT2016FukinitsuNokiKanri.class).
                where(
                        eq(choteiNendo, 調定年度)
                ).order(by(DbT2016FukinitsuNokiKanri.shichosonCode, Order.ASC)).
                toList(DbT2016FukinitsuNokiKanriEntity.class);
    }
}

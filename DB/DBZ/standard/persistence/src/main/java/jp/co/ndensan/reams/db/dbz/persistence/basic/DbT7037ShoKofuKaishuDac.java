/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho.rirekiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishu.kofuShoShurui;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
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
 * 証交付回収のデータアクセスクラスです。
 */
public class DbT7037ShoKofuKaishuDac implements ISaveable<DbT7037ShoKofuKaishuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで証交付回収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 交付証種類 KofuShoShurui
     * @param 履歴番号 RirekiNo
     * @return DbT7037ShoKofuKaishuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7037ShoKofuKaishuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 交付証種類,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kofuShoShurui, 交付証種類),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * 証交付回収を全件返します。
     *
     * @return List<DbT7037ShoKofuKaishuEntity>
     */
    @Transaction
    public List<DbT7037ShoKofuKaishuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                toList(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * DbT7037ShoKofuKaishuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7037ShoKofuKaishuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

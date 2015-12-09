/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItem.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItem.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItem.remban;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（基本調査素点項目）のデータアクセスクラスです。
 */
public class DbT5212NinteichosahyoKihonChosaScoreItemDac implements ISaveable<DbT5212NinteichosahyoKihonChosaScoreItemEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（基本調査素点項目）を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     * @return DbT5212NinteichosahyoKihonChosaScoreItemEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5212NinteichosahyoKihonChosaScoreItemEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5212NinteichosahyoKihonChosaScoreItem.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 要介護認定調査履歴番号),
                                eq(remban, 連番))).
                toObject(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class);
    }

    /**
     * 認定調査票（基本調査素点項目）を全件返します。
     *
     * @return DbT5212NinteichosahyoKihonChosaScoreItemEntityの{@code list}
     */
    @Transaction
    public List<DbT5212NinteichosahyoKihonChosaScoreItemEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5212NinteichosahyoKihonChosaScoreItem.class).
                toList(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class);
    }

    /**
     * DbT5212NinteichosahyoKihonChosaScoreItemEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5212NinteichosahyoKihonChosaScoreItemEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点項目）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItem;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItem.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItem.remban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItem.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_基本調査_調査項目のデータアクセスクラスです。
 */
public class DbT5211NinteichosahyoChosaItemDac implements ISaveable<DbT5211NinteichosahyoChosaItemEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票_基本調査_調査項目を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     * @return DbT5211NinteichosahyoChosaItemEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5211NinteichosahyoChosaItemEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5211NinteichosahyoChosaItem.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 要介護認定調査履歴番号),
                                eq(remban, 連番))).
                toObject(DbT5211NinteichosahyoChosaItemEntity.class);
    }

    /**
     * 申請書管理番号,要介護認定調査履歴番号で認定調査票_基本調査_調査項目を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @return DbT5211NinteichosahyoChosaItemEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5211NinteichosahyoChosaItemEntity> select調査項目(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5211NinteichosahyoChosaItem.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 要介護認定調査履歴番号))).
                toList(DbT5211NinteichosahyoChosaItemEntity.class);
    }
    
    /**
     * 認定調査票_基本調査_調査項目を全件返します。
     *
     * @return DbT5211NinteichosahyoChosaItemEntityの{@code list}
     */
    @Transaction
    public List<DbT5211NinteichosahyoChosaItemEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5211NinteichosahyoChosaItem.class).
                toList(DbT5211NinteichosahyoChosaItemEntity.class);
    }

    /**
     * DbT5211NinteichosahyoChosaItemEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5211NinteichosahyoChosaItemEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査_調査項目エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5211NinteichosahyoChosaItemEntityを削除します。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT5211NinteichosahyoChosaItemEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査_調査項目エンティティ"));
        entity.setIsDeleted(true);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}

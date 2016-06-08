/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4209NinteichosahyoKinyuItem;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4209NinteichosahyoKinyuItem.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4209NinteichosahyoKinyuItem.remban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4209NinteichosahyoKinyuItem.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_記入項目のデータアクセスクラスです。
 */
public class DbT4209NinteichosahyoKinyuItemDac implements ISaveable<DbT4209NinteichosahyoKinyuItemEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票_概況調査_記入項目を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     * @return DbT4209NinteichosahyoKinyuItemEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4209NinteichosahyoKinyuItemEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4209NinteichosahyoKinyuItem.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(remban, 連番))).
                toObject(DbT4209NinteichosahyoKinyuItemEntity.class);
    }

    /**
     * 認定調査票_概況調査_記入項目を全件返します。
     *
     * @return DbT4209NinteichosahyoKinyuItemEntityの{@code list}
     */
    @Transaction
    public List<DbT4209NinteichosahyoKinyuItemEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4209NinteichosahyoKinyuItem.class).
                toList(DbT4209NinteichosahyoKinyuItemEntity.class);
    }

    /**
     * DbT4209NinteichosahyoKinyuItemEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4209NinteichosahyoKinyuItemEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_記入項目エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

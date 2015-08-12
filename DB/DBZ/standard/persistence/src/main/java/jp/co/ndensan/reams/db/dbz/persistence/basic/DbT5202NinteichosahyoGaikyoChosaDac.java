/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5202NinteichosahyoGaikyoChosa;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT5202NinteichosahyoGaikyoChosa.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT5202NinteichosahyoGaikyoChosa.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）（子）のデータアクセスクラスです。
 */
public class DbT5202NinteichosahyoGaikyoChosaDac implements ISaveable<DbT5202NinteichosahyoGaikyoChosaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（概況調査）（子）を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return DbT5202NinteichosahyoGaikyoChosaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5202NinteichosahyoGaikyoChosaEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5202NinteichosahyoGaikyoChosa.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号))).
                toObject(DbT5202NinteichosahyoGaikyoChosaEntity.class);
    }

    /**
     * 認定調査票（概況調査）（子）を全件返します。
     *
     * @return DbT5202NinteichosahyoGaikyoChosaEntityの{@code list}
     */
    @Transaction
    public List<DbT5202NinteichosahyoGaikyoChosaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5202NinteichosahyoGaikyoChosa.class).
                toList(DbT5202NinteichosahyoGaikyoChosaEntity.class);
    }

    /**
     * DbT5202NinteichosahyoGaikyoChosaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5202NinteichosahyoGaikyoChosaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）（子）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

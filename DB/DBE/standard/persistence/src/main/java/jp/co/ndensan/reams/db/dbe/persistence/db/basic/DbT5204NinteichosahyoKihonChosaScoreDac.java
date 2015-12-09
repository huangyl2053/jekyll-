/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScore.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScore.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
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
 * 認定調査票（基本調査素点）のデータアクセスクラスです。
 */
public class DbT5204NinteichosahyoKihonChosaScoreDac implements ISaveable<DbT5204NinteichosahyoKihonChosaScoreEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（基本調査素点）を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 要介護認定調査履歴番号 NinteichosaRirekiNo
     * @return DbT5204NinteichosahyoKihonChosaScoreEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5204NinteichosahyoKihonChosaScoreEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5204NinteichosahyoKihonChosaScore.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 要介護認定調査履歴番号))).
                toObject(DbT5204NinteichosahyoKihonChosaScoreEntity.class);
    }

    /**
     * 認定調査票（基本調査素点）を全件返します。
     *
     * @return DbT5204NinteichosahyoKihonChosaScoreEntityの{@code list}
     */
    @Transaction
    public List<DbT5204NinteichosahyoKihonChosaScoreEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5204NinteichosahyoKihonChosaScore.class).
                toList(DbT5204NinteichosahyoKihonChosaScoreEntity.class);
    }

    /**
     * DbT5204NinteichosahyoKihonChosaScoreEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5204NinteichosahyoKihonChosaScoreEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

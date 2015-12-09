/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosa;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosa.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosa.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
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
 * 認定調査票（基本調査）のデータアクセスクラスです。
 */
public class DbT5203NinteichosahyoKihonChosaDac implements ISaveable<DbT5203NinteichosahyoKihonChosaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（基本調査）を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 要介護認定調査履歴番号 NinteichosaRirekiNo
     * @return DbT5203NinteichosahyoKihonChosaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5203NinteichosahyoKihonChosaEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5203NinteichosahyoKihonChosa.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 要介護認定調査履歴番号))).
                toObject(DbT5203NinteichosahyoKihonChosaEntity.class);
    }

    /**
     * 認定調査票（基本調査）を全件返します。
     *
     * @return DbT5203NinteichosahyoKihonChosaEntityの{@code list}
     */
    @Transaction
    public List<DbT5203NinteichosahyoKihonChosaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5203NinteichosahyoKihonChosa.class).
                toList(DbT5203NinteichosahyoKihonChosaEntity.class);
    }

    /**
     * DbT5203NinteichosahyoKihonChosaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5203NinteichosahyoKihonChosaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

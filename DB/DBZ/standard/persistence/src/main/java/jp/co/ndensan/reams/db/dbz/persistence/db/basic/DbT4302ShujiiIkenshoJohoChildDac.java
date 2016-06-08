/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4302ShujiiIkenshoJohoChild;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4302ShujiiIkenshoJohoChild.ikenshoIraiRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4302ShujiiIkenshoJohoChild.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4302ShujiiIkenshoJohoChildEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書情報_子のデータアクセスクラスです。
 */
public class DbT4302ShujiiIkenshoJohoChildDac implements ISaveable<DbT4302ShujiiIkenshoJohoChildEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定主治医意見書情報_子を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return DbT4302ShujiiIkenshoJohoChildEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4302ShujiiIkenshoJohoChildEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4302ShujiiIkenshoJohoChild.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ikenshoIraiRirekiNo, 主治医意見書作成依頼履歴番号))).
                toObject(DbT4302ShujiiIkenshoJohoChildEntity.class);
    }

    /**
     * 要介護認定主治医意見書情報_子を全件返します。
     *
     * @return DbT4302ShujiiIkenshoJohoChildEntityの{@code list}
     */
    @Transaction
    public List<DbT4302ShujiiIkenshoJohoChildEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4302ShujiiIkenshoJohoChild.class).
                toList(DbT4302ShujiiIkenshoJohoChildEntity.class);
    }

    /**
     * DbT4302ShujiiIkenshoJohoChildEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4302ShujiiIkenshoJohoChildEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報_子エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

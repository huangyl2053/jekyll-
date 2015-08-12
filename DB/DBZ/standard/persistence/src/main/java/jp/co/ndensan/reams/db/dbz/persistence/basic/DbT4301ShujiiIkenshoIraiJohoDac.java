/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4301ShujiiIkenshoIraiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4301ShujiiIkenshoIraiJoho.ikenshoIraiRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4301ShujiiIkenshoIraiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報のデータアクセスクラスです。
 */
public class DbT4301ShujiiIkenshoIraiJohoDac implements ISaveable<DbT4301ShujiiIkenshoIraiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return DbT4301ShujiiIkenshoIraiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4301ShujiiIkenshoIraiJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4301ShujiiIkenshoIraiJoho.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ikenshoIraiRirekiNo, 主治医意見書作成依頼履歴番号))).
                toObject(DbT4301ShujiiIkenshoIraiJohoEntity.class);
    }

    /**
     * 主治医意見書作成依頼情報を全件返します。
     *
     * @return DbT4301ShujiiIkenshoIraiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4301ShujiiIkenshoIraiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4301ShujiiIkenshoIraiJoho.class).
                toList(DbT4301ShujiiIkenshoIraiJohoEntity.class);
    }

    /**
     * DbT4301ShujiiIkenshoIraiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4301ShujiiIkenshoIraiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

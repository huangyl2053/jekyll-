/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5105NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定完了情報のデータアクセスクラスです。
 */
public class DbT5105NinteiKanryoJohoDac implements ISaveable<DbT5105NinteiKanryoJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定完了情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5105NinteiKanryoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5105NinteiKanryoJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5105NinteiKanryoJoho.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5105NinteiKanryoJohoEntity.class);
    }

    /**
     * 要介護認定完了情報を全件返します。
     *
     * @return DbT5105NinteiKanryoJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5105NinteiKanryoJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5105NinteiKanryoJoho.class).
                toList(DbT5105NinteiKanryoJohoEntity.class);
    }

    /**
     * DbT5105NinteiKanryoJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5105NinteiKanryoJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報のデータアクセスクラスです。
 */
public class DbT5102NinteiKekkaJohoDac implements ISaveable<DbT5102NinteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定結果情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5102NinteiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5102NinteiKekkaJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5102NinteiKekkaJoho.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5102NinteiKekkaJohoEntity.class);
    }

    /**
     * 要介護認定結果情報を全件返します。
     *
     * @return DbT5102NinteiKekkaJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5102NinteiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5102NinteiKekkaJoho.class).
                toList(DbT5102NinteiKekkaJohoEntity.class);
    }

    /**
     * DbT5102NinteiKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5102NinteiKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5102NinteiKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDelete(DbT5102NinteiKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}

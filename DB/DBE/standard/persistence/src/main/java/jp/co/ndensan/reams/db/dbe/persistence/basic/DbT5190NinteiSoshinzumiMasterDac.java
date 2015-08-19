/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMaster;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMasterEntity;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMaster.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定送信済みマスタのデータアクセスクラスです。
 */
public class DbT5190NinteiSoshinzumiMasterDac implements ISaveable<DbT5190NinteiSoshinzumiMasterEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定送信済みマスタを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5190NinteiSoshinzumiMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5190NinteiSoshinzumiMasterEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5190NinteiSoshinzumiMaster.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5190NinteiSoshinzumiMasterEntity.class);
    }

    /**
     * 要介護認定送信済みマスタを全件返します。
     *
     * @return DbT5190NinteiSoshinzumiMasterEntityの{@code list}
     */
    @Transaction
    public List<DbT5190NinteiSoshinzumiMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5190NinteiSoshinzumiMaster.class).
                toList(DbT5190NinteiSoshinzumiMasterEntity.class);
    }

    /**
     * DbT5190NinteiSoshinzumiMasterEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5190NinteiSoshinzumiMasterEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定送信済みマスタエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

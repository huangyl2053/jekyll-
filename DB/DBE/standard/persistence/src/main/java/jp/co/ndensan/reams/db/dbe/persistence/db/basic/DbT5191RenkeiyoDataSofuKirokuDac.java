/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5191RenkeiyoDataSofuKiroku;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5191RenkeiyoDataSofuKiroku.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5191RenkeiyoDataSofuKiroku.shiryoSakuseiYMD;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連携用データ送付記録のデータアクセスクラスです。
 */
public class DbT5191RenkeiyoDataSofuKirokuDac implements ISaveable<DbT5191RenkeiyoDataSofuKirokuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連携用データ送付記録を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 資料作成日 資料作成日
     * @return DbT5191RenkeiyoDataSofuKirokuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5191RenkeiyoDataSofuKirokuEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 資料作成日) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(資料作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("資料作成日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5191RenkeiyoDataSofuKiroku.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(shiryoSakuseiYMD, 資料作成日))).
                toObject(DbT5191RenkeiyoDataSofuKirokuEntity.class);
    }

    /**
     * 連携用データ送付記録を全件返します。
     *
     * @return DbT5191RenkeiyoDataSofuKirokuEntityの{@code list}
     */
    @Transaction
    public List<DbT5191RenkeiyoDataSofuKirokuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5191RenkeiyoDataSofuKiroku.class).
                toList(DbT5191RenkeiyoDataSofuKirokuEntity.class);
    }

    /**
     * DbT5191RenkeiyoDataSofuKirokuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5191RenkeiyoDataSofuKirokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連携用データ送付記録エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4116IchijiHanteiKekkaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4116IchijiHanteiKekkaJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定一次判定結果情報のデータアクセスクラスです。
 */
public class DbT4116IchijiHanteiKekkaJohoDac implements ISaveable<DbT4116IchijiHanteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定一次判定結果情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4116IchijiHanteiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4116IchijiHanteiKekkaJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4116IchijiHanteiKekkaJoho.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT4116IchijiHanteiKekkaJohoEntity.class);
    }

    /**
     * 要介護認定一次判定結果情報を全件返します。
     *
     * @return DbT4116IchijiHanteiKekkaJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4116IchijiHanteiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4116IchijiHanteiKekkaJoho.class).
                toList(DbT4116IchijiHanteiKekkaJohoEntity.class);
    }

    /**
     * DbT4116IchijiHanteiKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4116IchijiHanteiKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

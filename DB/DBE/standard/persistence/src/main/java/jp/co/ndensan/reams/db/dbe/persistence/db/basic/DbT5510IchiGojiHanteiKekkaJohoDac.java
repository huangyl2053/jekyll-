/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定1.5次判定結果情報のデータアクセスクラスです。
 */
public class DbT5510IchiGojiHanteiKekkaJohoDac implements ISaveable<DbT5510IchiGojiHanteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定1.5次判定結果情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5510IchiGojiHanteiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5510IchiGojiHanteiKekkaJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5510IchiGojiHanteiKekkaJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5510IchiGojiHanteiKekkaJohoEntity.class);
    }

    /**
     * 要介護認定1.5次判定結果情報を全件返します。
     *
     * @return DbT5510IchiGojiHanteiKekkaJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5510IchiGojiHanteiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5510IchiGojiHanteiKekkaJoho.class).
                toList(DbT5510IchiGojiHanteiKekkaJohoEntity.class);
    }

    /**
     * DbT5510IchiGojiHanteiKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5510IchiGojiHanteiKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1.5次判定結果情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

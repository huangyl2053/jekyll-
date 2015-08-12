/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5116IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定一次判定結果情報のデータアクセスクラスです。
 */
public class DbT5116IchijiHanteiKekkaJohoDac implements ISaveable<DbT5116IchijiHanteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定一次判定結果情報を取得します。
     *
     *
     * @return DbT5116IchijiHanteiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5116IchijiHanteiKekkaJohoEntity selectByKey() throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5116IchijiHanteiKekkaJoho.class).
                where(null).
                toObject(DbT5116IchijiHanteiKekkaJohoEntity.class);
    }

    /**
     * 要介護認定一次判定結果情報を全件返します。
     *
     * @return DbT5116IchijiHanteiKekkaJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5116IchijiHanteiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5116IchijiHanteiKekkaJoho.class).
                toList(DbT5116IchijiHanteiKekkaJohoEntity.class);
    }

    /**
     * DbT5116IchijiHanteiKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5116IchijiHanteiKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

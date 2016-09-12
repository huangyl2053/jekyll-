/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsu.choteiId;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調定共通のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class UrT0705ChoteiKyotsuDac implements ISaveable<UrT0705ChoteiKyotsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで調定共通を取得します。
     *
     * @param 調定ID ChoteiId
     * @return UrT0705ChoteiKyotsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public UrT0705ChoteiKyotsuEntity selectByKey(
            Long 調定ID) throws NullPointerException {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(UrT0705ChoteiKyotsu.class).
                where(
                        eq(choteiId, 調定ID)).
                toObject(UrT0705ChoteiKyotsuEntity.class);
    }

    /**
     * 調定共通を全件返します。
     *
     * @return List<UrT0705ChoteiKyotsuEntity>
     */
    @Transaction
    public List<UrT0705ChoteiKyotsuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(UrT0705ChoteiKyotsu.class).
                toList(UrT0705ChoteiKyotsuEntity.class);
    }

    /**
     * 登録処理
     *
     * @param entity UrT0705ChoteiKyotsuEntity
     * @return 登録件数
     */
    @Transaction
    public int insert(UrT0705ChoteiKyotsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 更新処理
     *
     * @param entity UrT0705ChoteiKyotsuEntity
     * @return 更新件数
     */
    @Transaction
    public int update(UrT0705ChoteiKyotsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 削除処理
     *
     * @param entity UrT0705ChoteiKyotsuEntity
     * @return 削除件数
     */
    @Transaction
    public int delete(UrT0705ChoteiKyotsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    /**
     * UrT0705ChoteiKyotsuEntityを削除します。状態によってdelete処理に振り分けられます。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int deletePhysicalBy(UrT0705ChoteiKyotsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通（介護継承）エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * UrT0705ChoteiKyotsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(UrT0705ChoteiKyotsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通（介護継承）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

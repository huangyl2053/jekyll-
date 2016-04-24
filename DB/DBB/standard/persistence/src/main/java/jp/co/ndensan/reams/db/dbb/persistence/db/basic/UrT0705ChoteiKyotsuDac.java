/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsu.choteiId;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調定共通（介護継承）のデータアクセスクラスです。
 *
 * @reamsid_L DBB-9999-012 xicongwang
 */
public class UrT0705ChoteiKyotsuDac implements ISaveable<UrT0705ChoteiKyotsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで調定共通（介護継承）を取得します。
     *
     * @param 調定ID 調定ID
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
                where(eq(choteiId, 調定ID)).
                toObject(UrT0705ChoteiKyotsuEntity.class);
    }

    /**
     * 調定共通（介護継承）を全件返します。
     *
     * @return UrT0705ChoteiKyotsuEntityの{@code list}
     */
    @Transaction
    public List<UrT0705ChoteiKyotsuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(UrT0705ChoteiKyotsu.class).
                toList(UrT0705ChoteiKyotsuEntity.class);
    }

    /**
     * UrT0705ChoteiKyotsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(UrT0705ChoteiKyotsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通（介護継承）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManeger;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManeger.kaigoShienSenmoninNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護支援専門員のデータアクセスクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class DbT7064CareManegerDac implements ISaveable<DbT7064CareManegerEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護支援専門員を取得します。
     *
     * @param 介護支援専門員番号 KaigoShienSenmoninNo
     * @return DbT7064CareManegerEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7064CareManegerEntity selectByKey(
            RString 介護支援専門員番号) throws NullPointerException {
        requireNonNull(介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7064CareManeger.class).
                where(eq(kaigoShienSenmoninNo, 介護支援専門員番号)).
                toObject(DbT7064CareManegerEntity.class);
    }

    /**
     * 介護支援専門員を全件返します。
     *
     * @return List<DbT7064CareManegerEntity>
     */
    @Transaction
    public List<DbT7064CareManegerEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7064CareManeger.class).
                toList(DbT7064CareManegerEntity.class);
    }

    /**
     * DbT7064CareManegerEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7064CareManegerEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT7064CareManegerEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。by yuqingzhang
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT7064CareManegerEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * selectByJigyoshaCode
     *
     * @param 事業者番号 事業者番号
     * @return new UnsupportedOperationException
     */
    public List<DbT7064CareManegerEntity> selectByJigyoshaCode(KaigoJigyoshaNo 事業者番号) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster.shichosonShokibetsuID;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタのデータアクセスクラスです。
 */
public class DbT7051KoseiShichosonMasterDac implements ISaveable<DbT7051KoseiShichosonMasterEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで構成市町村マスタを取得します。
     *
     * @param 市町村識別ID ShichosonShokibetsuID
     * @return DbT7051KoseiShichosonMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity selectByKey(
            RString 市町村識別ID) throws NullPointerException {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(shichosonShokibetsuID, 市町村識別ID)).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村マスタを全件返します。
     *
     * @return List<DbT7051KoseiShichosonMasterEntity>
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7051KoseiShichosonMasterEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

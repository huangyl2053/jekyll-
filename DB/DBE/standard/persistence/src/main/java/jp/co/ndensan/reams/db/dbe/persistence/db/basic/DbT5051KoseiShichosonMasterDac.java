/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMaster.kanyuYMD;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMaster.ridatsuYMD;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMaster.shichosonShokibetsuID;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタのデータアクセスクラスです。
 */
public class DbT5051KoseiShichosonMasterDac implements ISaveable<DbT5051KoseiShichosonMasterEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで構成市町村マスタを取得します。
     *
     * @param 市町村識別ID ShichosonShokibetsuID
     * @return DbT5051KoseiShichosonMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5051KoseiShichosonMasterEntity selectByKey(
            RString 市町村識別ID) throws NullPointerException {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5051KoseiShichosonMaster.class).
                where(
                        eq(shichosonShokibetsuID, 市町村識別ID)).
                toObject(DbT5051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村マスタを全件返します。
     *
     * @return DbT5051KoseiShichosonMasterEntityの{@code list}
     */
    @Transaction
    public List<DbT5051KoseiShichosonMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5051KoseiShichosonMaster.class).
                toList(DbT5051KoseiShichosonMasterEntity.class);
    }

    /**
     * DbT5051KoseiShichosonMasterEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5051KoseiShichosonMasterEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタエンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 所在保険者リスト情報取得。
     *
     * @param systemDate システム年月日
     * @return List<DbT7051KoseiShichosonMasterEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5051KoseiShichosonMasterEntity> selectByGappeiKyuShichosonKubun(
            RDate systemDate) throws NullPointerException {
        requireNonNull(systemDate, UrSystemErrorMessages.値がnull.getReplacedMessage("システム年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT5051KoseiShichosonMaster.class).
                where(and(eq(gappeiKyuShichosonKubun, "0"),
                                leq(kanyuYMD, systemDate),
                                leq(systemDate, ridatsuYMD))).
                toList(DbT5051KoseiShichosonMasterEntity.class);
    }
}

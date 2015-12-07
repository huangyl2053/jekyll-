/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMaster.kanyuYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMaster.ridatsuYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMaster.shichosonShokibetsuID;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT7051KoseiShichosonMasterMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
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
     * @param 市町村識別ID 市町村識別ID
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
     * @return DbT7051KoseiShichosonMasterEntityの{@code list}
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

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 旧市町村コード情報Listを取得する。
     *
     * @param 地域番号の一桁目 地域番号の一桁目
     * @return 旧市町村コード情報List
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> getKouikiKyuShichosonCodeJohoList(RString 地域番号の一桁目) {
        requireNonNull(地域番号の一桁目, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号の一桁目"));
        IDbT7051KoseiShichosonMasterMapper mapper = session.getMapper(IDbT7051KoseiShichosonMasterMapper.class);
        return mapper.getKouikiKyuShichosonCodeJohoList(地域番号の一桁目);
    }

    /**
     * 所在保険者リスト情報取得を取得.
     *
     * @param systemDate
     * @return DbT7051KoseiShichosonMasterEntityの{@code list}
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectByKoseiShichosonMasterList(RDate systemDate) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(
                                eq(gappeiKyuShichosonKubun, '0'),
                                leq(kanyuYMD, systemDate),
                                not(isNULL(ridatsuYMD)))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

}

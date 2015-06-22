/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT5051KoseiShichosonMaster.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.relate.IKoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタのデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class DbT5051KoseiShichosonMasterDac implements IModifiable<IKoseiShichosonMasterEntity> {

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
    public Optional<DbT5051KoseiShichosonMasterEntity> selectByKey(
            RString 市町村識別ID) throws NullPointerException {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5051KoseiShichosonMaster.class).
                where(
                        eq(shichosonShokibetsuID, 市町村識別ID)).
                toObject(DbT5051KoseiShichosonMasterEntity.class));
    }

    /**
     * 証記載保険者番号で構成市町村マスタを取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @return DbT5051KoseiShichosonMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5051KoseiShichosonMasterEntity> selectByKey(ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5051KoseiShichosonMaster.class).
                where(
                        eq(shoKisaiHokenshaNo, 証記載保険者番号)).
                toList(DbT5051KoseiShichosonMasterEntity.class).get(0));
    }

    /**
     * 市町村コードで構成市町村マスタを取得します。
     *
     * @param 市町村コード LasdecCode
     * @return DbT5051KoseiShichosonMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5051KoseiShichosonMasterEntity> selectByKey(
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5051KoseiShichosonMaster.class).
                where(
                        eq(shichosonCode, 市町村コード)).
                toList(DbT5051KoseiShichosonMasterEntity.class).get(0));
    }

    /**
     * 構成市町村マスタを全件返します。
     *
     * @return List<DbT5051KoseiShichosonMasterEntity>
     */
    @Transaction
    public List<DbT5051KoseiShichosonMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5051KoseiShichosonMaster.class).
                toList(DbT5051KoseiShichosonMasterEntity.class);
    }

    @Transaction
    @Override
    public int insert(IKoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(IKoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(IKoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT5051KoseiShichosonMasterEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}

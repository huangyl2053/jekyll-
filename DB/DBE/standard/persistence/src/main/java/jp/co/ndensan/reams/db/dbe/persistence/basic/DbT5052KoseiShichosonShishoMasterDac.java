/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMaster;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMaster.shichosonCode;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMaster.shishoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村支所マスタのデータアクセスクラスです。
 */
public class DbT5052KoseiShichosonShishoMasterDac implements ISaveable<DbT5052KoseiShichosonShishoMasterEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで構成市町村支所マスタを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return DbT5052KoseiShichosonShishoMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5052KoseiShichosonShishoMasterEntity selectByKey(
            LasdecCode 市町村コード,
            ShishoCode 支所コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5052KoseiShichosonShishoMaster.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shishoCode, 支所コード))).
                toObject(DbT5052KoseiShichosonShishoMasterEntity.class);
    }

    /**
     * 構成市町村支所マスタを全件返します。
     *
     * @return DbT5052KoseiShichosonShishoMasterEntityの{@code list}
     */
    @Transaction
    public List<DbT5052KoseiShichosonShishoMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5052KoseiShichosonShishoMaster.class).
                toList(DbT5052KoseiShichosonShishoMasterEntity.class);
    }

    /**
     * DbT5052KoseiShichosonShishoMasterEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5052KoseiShichosonShishoMasterEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村支所マスタエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

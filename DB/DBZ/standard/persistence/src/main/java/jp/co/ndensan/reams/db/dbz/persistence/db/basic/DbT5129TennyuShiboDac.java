/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5129TennyuShibo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5129TennyuShiboEntity;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaicho.shinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入・死亡情報のデータアクセスクラスです。
 */
public class DbT5129TennyuShiboDac implements ISaveable<DbT5129TennyuShiboEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで転入・死亡情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5129TennyuShiboEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5129TennyuShiboEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5129TennyuShibo.class).
                where(
                        eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5129TennyuShiboEntity.class);
    }

    /**
     * 転入・死亡情報を全件返します。
     *
     * @return DbT5129TennyuShiboEntityの{@code list}
     */
    @Transaction
    public List<DbT5129TennyuShiboEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5129TennyuShibo.class).
                toList(DbT5129TennyuShiboEntity.class);
    }

    /**
     * DbT5129TennyuShiboEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5129TennyuShiboEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転入・死亡情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

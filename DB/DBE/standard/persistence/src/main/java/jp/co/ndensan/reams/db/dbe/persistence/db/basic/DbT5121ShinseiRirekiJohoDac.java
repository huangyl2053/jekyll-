/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJoho.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJoho.zenkaiShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請履歴情報のデータアクセスクラスです。
 */
public class DbT5121ShinseiRirekiJohoDac implements ISaveable<DbT5121ShinseiRirekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで申請履歴情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @return DbT5121ShinseiRirekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5121ShinseiRirekiJohoEntity selectByKey(
            ShinseishoKanriNo 申請管理番号) throws NullPointerException {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5121ShinseiRirekiJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請管理番号)).
                toObject(DbT5121ShinseiRirekiJohoEntity.class);
    }

    /**
     * 申請履歴情報を全件返します。
     *
     * @return DbT5121ShinseiRirekiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5121ShinseiRirekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5121ShinseiRirekiJoho.class).
                toList(DbT5121ShinseiRirekiJohoEntity.class);
    }

    /**
     * DbT5121ShinseiRirekiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5121ShinseiRirekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請履歴情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで申請履歴情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @return DbT5121ShinseiRirekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5121ShinseiRirekiJohoEntity> select前回申請管理番号(
            ShinseishoKanriNo 申請管理番号) throws NullPointerException {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5121ShinseiRirekiJoho.class).
                where(
                        eq(zenkaiShinseishoKanriNo, 申請管理番号)).
                toList(DbT5121ShinseiRirekiJohoEntity.class);
    }
}

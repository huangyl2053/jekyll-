/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請届出情報のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public class DbT4121ShinseiRirekiJohoUketsukeDac implements ISaveable<DbT4121ShinseiRirekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで申請履歴情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @return DbT4121ShinseiRirekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4121ShinseiRirekiJohoEntity selectByKey(
            ShinseishoKanriNo 申請管理番号) throws NullPointerException {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4121ShinseiRirekiJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請管理番号)).
                toObject(DbT4121ShinseiRirekiJohoEntity.class);
    }

    /**
     * 申請履歴情報を全件返します。
     *
     * @return DbT4121ShinseiRirekiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4121ShinseiRirekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4121ShinseiRirekiJoho.class).
                toList(DbT4121ShinseiRirekiJohoEntity.class);
    }

    /**
     * DbT4121ShinseiRirekiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4121ShinseiRirekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請履歴情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで申請履歴情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @return DbT4121ShinseiRirekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT4121ShinseiRirekiJohoEntity> select前回申請管理番号(
            ShinseishoKanriNo 申請管理番号) throws NullPointerException {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4121ShinseiRirekiJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請管理番号)).
                toList(DbT4121ShinseiRirekiJohoEntity.class);
    }
}

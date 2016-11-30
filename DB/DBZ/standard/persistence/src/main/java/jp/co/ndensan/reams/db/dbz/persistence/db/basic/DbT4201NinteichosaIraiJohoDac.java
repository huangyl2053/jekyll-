/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJoho.ninteichosaIraiRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報のデータアクセスクラスです。
 */
public class DbT4201NinteichosaIraiJohoDac implements ISaveable<DbT4201NinteichosaIraiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 認定調査依頼情報のモバイルデータ出力済フラグを出力済みで更新する。
     *
     * @param entity DbT4201NinteichosaIraiJohoEntity
     */
    @Transaction
    public void updateDbt4201johon(DbT4201NinteichosaIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        accessor.update(entity);
    }

    /**
     * 要介護認定申請情報のモバイルデータ出力済フラグを出力済みで更新する。
     *
     * @param entity DbT4101NinteiShinseiJohoEntity
     */
    @Transaction
    public void updateDbt4101johon(DbT4101NinteiShinseiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        accessor.update(entity);
    }

    /**
     * 主キーで認定調査依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return DbT4201NinteichosaIraiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4201NinteichosaIraiJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4201NinteichosaIraiJoho.class).
                where(and(
                        eq(shinseishoKanriNo, 申請書管理番号),
                        eq(ninteichosaIraiRirekiNo, 認定調査依頼履歴番号))).
                toObject(DbT4201NinteichosaIraiJohoEntity.class);
    }

    /**
     * 認定調査依頼情報を全件返します。
     *
     * @return DbT4201NinteichosaIraiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4201NinteichosaIraiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4201NinteichosaIraiJoho.class).
                toList(DbT4201NinteichosaIraiJohoEntity.class);
    }

    /**
     * DbT4201NinteichosaIraiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4201NinteichosaIraiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

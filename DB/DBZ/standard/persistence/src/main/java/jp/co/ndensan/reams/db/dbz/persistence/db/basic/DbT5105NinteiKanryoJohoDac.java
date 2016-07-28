/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ichijiHanteiKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ikenshoSakuseiIraiKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ikenshoTorokuKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.maskingKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ninteiShinsakaiKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ninteiShinseiJohoTorokuKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ninteichosaIraiKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.ninteichosaKanryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定完了情報のデータアクセスクラスです。
 */
public class DbT5105NinteiKanryoJohoDac implements ISaveable<DbT5105NinteiKanryoJohoEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString SHINSEISHOKANRINO = new RString("申請書管理番号");

    /**
     * 主キーで要介護認定完了情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5105NinteiKanryoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5105NinteiKanryoJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(SHINSEISHOKANRINO.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5105NinteiKanryoJoho.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5105NinteiKanryoJohoEntity.class);
    }

    /**
     * ShinseishoKanriNoで要介護認定完了情報を取得します。値が空でないかどうかを確認します
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5105NinteiKanryoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5105NinteiKanryoJohoEntity selectByShinseishoKanriNo(
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(SHINSEISHOKANRINO.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5105NinteiKanryoJoho.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                not(eq(ninteiShinseiJohoTorokuKanryoYMD, null)),
                                not(eq(ninteichosaKanryoYMD, null)),
                                not(eq(ninteichosaIraiKanryoYMD, null)),
                                not(eq(ikenshoSakuseiIraiKanryoYMD, null)),
                                not(eq(ikenshoTorokuKanryoYMD, null)),
                                not(eq(ichijiHanteiKanryoYMD, null)),
                                not(eq(maskingKanryoYMD, null)),
                                not(eq(ninteiShinsakaiKanryoYMD, null))
                        )).
                toObject(DbT5105NinteiKanryoJohoEntity.class);
    }

    /**
     * 要介護認定完了情報を全件返します。
     *
     * @return DbT5105NinteiKanryoJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5105NinteiKanryoJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5105NinteiKanryoJoho.class).
                toList(DbT5105NinteiKanryoJohoEntity.class);
    }

    /**
     * DbT5105NinteiKanryoJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5105NinteiKanryoJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

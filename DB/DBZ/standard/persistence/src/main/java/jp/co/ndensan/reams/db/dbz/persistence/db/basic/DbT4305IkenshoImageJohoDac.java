/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJoho.ChoyoID;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJoho.iraiRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJoho.genponMaskKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定意見書イメージ情報のデータアクセスクラスです。
 */
public class DbT4305IkenshoImageJohoDac implements ISaveable<DbT4305IkenshoImageJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定意見書イメージ情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 帳票ID 帳票ID
     * @param マスキングデータ区分 マスキングデータ区分
     * @param 取込みページ番号 取込みページ番号
     * @return DbT4305IkenshoImageJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4305IkenshoImageJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            Code 帳票ID,
            RString マスキングデータ区分,
            int 取込みページ番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        requireNonNull(マスキングデータ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("マスキングデータ区分"));
        requireNonNull(取込みページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込みページ番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4305IkenshoImageJoho.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(iraiRirekiNo, 主治医意見書作成依頼履歴番号),
                                eq(ChoyoID, 帳票ID),
                                eq(genponMaskKubun, マスキングデータ区分))).
                //                                eq(torikomiPageNo, 取込みページ番号))).
                toObject(DbT4305IkenshoImageJohoEntity.class);
    }

    /**
     * 要介護認定意見書イメージ情報を全件返します。
     *
     * @return DbT4305IkenshoImageJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4305IkenshoImageJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4305IkenshoImageJoho.class).
                toList(DbT4305IkenshoImageJohoEntity.class);
    }

    /**
     * DbT4305IkenshoImageJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4305IkenshoImageJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定意見書イメージ情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

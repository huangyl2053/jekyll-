/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4208NinteichosahyoServiceJokyoFlagChild;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4208NinteichosahyoServiceJokyoFlagChild.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4208NinteichosahyoServiceJokyoFlagChild.remban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4208NinteichosahyoServiceJokyoFlagChild.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4208NinteichosahyoServiceJokyoFlagChildEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_サービス_子の状況フラグのデータアクセスクラスです。
 */
public class DbT4208NinteichosahyoServiceJokyoFlagChildDac implements ISaveable<DbT4208NinteichosahyoServiceJokyoFlagChildEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票_概況調査_サービス_子の状況フラグを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     * @return DbT4208NinteichosahyoServiceJokyoFlagChildEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4208NinteichosahyoServiceJokyoFlagChildEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4208NinteichosahyoServiceJokyoFlagChild.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(remban, 連番))).
                toObject(DbT4208NinteichosahyoServiceJokyoFlagChildEntity.class);
    }

    /**
     * 認定調査票_概況調査_サービス_子の状況フラグを全件返します。
     *
     * @return DbT4208NinteichosahyoServiceJokyoFlagChildEntityの{@code list}
     */
    @Transaction
    public List<DbT4208NinteichosahyoServiceJokyoFlagChildEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4208NinteichosahyoServiceJokyoFlagChild.class).
                toList(DbT4208NinteichosahyoServiceJokyoFlagChildEntity.class);
    }

    /**
     * DbT4208NinteichosahyoServiceJokyoFlagChildEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4208NinteichosahyoServiceJokyoFlagChildEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_サービス_子の状況フラグエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

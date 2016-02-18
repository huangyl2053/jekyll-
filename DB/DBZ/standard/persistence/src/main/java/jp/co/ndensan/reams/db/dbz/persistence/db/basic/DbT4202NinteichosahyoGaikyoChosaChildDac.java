/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaChild;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaChild.gaikyoChosaTextImageKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaChild.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaChild.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaChildEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_子のデータアクセスクラスです。
 */
public class DbT4202NinteichosahyoGaikyoChosaChildDac implements ISaveable<DbT4202NinteichosahyoGaikyoChosaChildEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票_概況調査_子を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況調査テキストイメージ区分 概況調査テキストイメージ区分
     * @return DbT4202NinteichosahyoGaikyoChosaChildEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4202NinteichosahyoGaikyoChosaChildEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査テキストイメージ区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4202NinteichosahyoGaikyoChosaChild.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(gaikyoChosaTextImageKubun, 概況調査テキストイメージ区分))).
                toObject(DbT4202NinteichosahyoGaikyoChosaChildEntity.class);
    }

    /**
     * 認定調査票_概況調査_子を全件返します。
     *
     * @return DbT4202NinteichosahyoGaikyoChosaChildEntityの{@code list}
     */
    @Transaction
    public List<DbT4202NinteichosahyoGaikyoChosaChildEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4202NinteichosahyoGaikyoChosaChild.class).
                toList(DbT4202NinteichosahyoGaikyoChosaChildEntity.class);
    }

    /**
     * DbT4202NinteichosahyoGaikyoChosaChildEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4202NinteichosahyoGaikyoChosaChildEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_子エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

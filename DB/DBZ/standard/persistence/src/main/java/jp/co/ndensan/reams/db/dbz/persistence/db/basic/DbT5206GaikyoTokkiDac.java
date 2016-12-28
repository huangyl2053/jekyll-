/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokki;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokki.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokki.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokki.gaikyoTokkiTextImageKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokki.genponMaskKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況特記のデータアクセスクラスです。
 */
public class DbT5206GaikyoTokkiDac implements ISaveable<DbT5206GaikyoTokkiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票_概況特記を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     * @deprecated 主キーに原本マスク区分が追加されたことにより別メソッドを作成
     * @return DbT5206GaikyoTokkiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5206GaikyoTokkiEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況特記テキストイメージ区分) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(概況特記テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記テキストイメージ区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5206GaikyoTokki.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(gaikyoTokkiTextImageKubun, 概況特記テキストイメージ区分))).
                toObject(DbT5206GaikyoTokkiEntity.class);
    }

    /**
     * 主キーで認定調査票_概況特記を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     * @param 原本マスク区分 原本マスク区分
     * @return DbT5206GaikyoTokkiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5206GaikyoTokkiEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況特記テキストイメージ区分,
            Code 原本マスク区分) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(概況特記テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記テキストイメージ区分"));
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5206GaikyoTokki.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(gaikyoTokkiTextImageKubun, 概況特記テキストイメージ区分),
                                eq(genponMaskKubun, 原本マスク区分))).
                toObject(DbT5206GaikyoTokkiEntity.class);
    }

    /**
     * 認定調査票_概況特記を全件返します。
     *
     * @return DbT5206GaikyoTokkiEntityの{@code list}
     */
    @Transaction
    public List<DbT5206GaikyoTokkiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5206GaikyoTokki.class).
                toList(DbT5206GaikyoTokkiEntity.class);
    }

    /**
     * DbT5206GaikyoTokkiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5206GaikyoTokkiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況特記エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

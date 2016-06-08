/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild.genponMaskKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild.ninteichosaTokkijikoNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild.ninteichosaTokkijikoRemban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChild.tokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4205NinteichosahyoTokkijikoChildEntity;
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
 * 認定調査票_特記情報_子のデータアクセスクラスです。
 */
public class DbT4205NinteichosahyoTokkijikoChildDac implements ISaveable<DbT4205NinteichosahyoTokkijikoChildEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票_特記情報_子を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 認定調査特記事項番号 RString
     * @param 認定調査特記事項連番 int
     * @param 特記事項テキスト_イメージ区分 RString
     * @param 原本マスク区分 Code
     * @return DbT4205NinteichosahyoTokkijikoChildEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4205NinteichosahyoTokkijikoChildEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 認定調査特記事項番号,
            int 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(認定調査特記事項番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項番号"));
        requireNonNull(認定調査特記事項連番, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項連番"));
        requireNonNull(特記事項テキスト_イメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項テキスト_イメージ区分"));
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4205NinteichosahyoTokkijikoChild.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(ninteichosaTokkijikoNo, 認定調査特記事項番号),
                                eq(ninteichosaTokkijikoRemban, 認定調査特記事項連番),
                                eq(tokkijikoTextImageKubun, 特記事項テキスト_イメージ区分),
                                eq(genponMaskKubun, 原本マスク区分))).
                toObject(DbT4205NinteichosahyoTokkijikoChildEntity.class);
    }

    /**
     * 認定調査票_特記情報_子を全件返します。
     *
     * @return DbT4205NinteichosahyoTokkijikoChildEntityの{@code list}
     */
    @Transaction
    public List<DbT4205NinteichosahyoTokkijikoChildEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4205NinteichosahyoTokkijikoChild.class).
                toList(DbT4205NinteichosahyoTokkijikoChildEntity.class);
    }

    /**
     * DbT4205NinteichosahyoTokkijikoChildEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4205NinteichosahyoTokkijikoChildEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_特記情報_子エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

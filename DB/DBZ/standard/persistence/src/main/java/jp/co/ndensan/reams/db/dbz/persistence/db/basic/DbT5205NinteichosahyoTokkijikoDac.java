/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.genponMaskKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.ninteichosaTokkijikoNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.ninteichosaTokkijikoRemban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.tokkiJiko;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijiko.tokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（特記情報）のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public class DbT5205NinteichosahyoTokkijikoDac implements ISaveable<DbT5205NinteichosahyoTokkijikoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（特記情報）を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @param 特記事項テキスト_イメージ区分 特記事項テキスト_イメージ区分
     * @param 原本マスク区分 原本マスク区分
     * @return DbT5205NinteichosahyoTokkijikoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5205NinteichosahyoTokkijikoEntity selectByKey(
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
        requireNonNull(特記事項テキスト_イメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項テキスト_イメージ区分")
        );
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5205NinteichosahyoTokkijiko.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(ninteichosaTokkijikoNo, 認定調査特記事項番号),
                                eq(ninteichosaTokkijikoRemban, 認定調査特記事項連番),
                                eq(tokkijikoTextImageKubun, 特記事項テキスト_イメージ区分
                                ),
                                eq(genponMaskKubun, 原本マスク区分)
                        )).
                toObject(DbT5205NinteichosahyoTokkijikoEntity.class);
    }

    /**
     * 認定調査票（特記情報）を全件返します。
     *
     * @return DbT5205NinteichosahyoTokkijikoEntityの{@code list}
     */
    @Transaction
    public List<DbT5205NinteichosahyoTokkijikoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5205NinteichosahyoTokkijiko.class).
                toList(DbT5205NinteichosahyoTokkijikoEntity.class);
    }

    /**
     * DbT5205NinteichosahyoTokkijikoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5205NinteichosahyoTokkijikoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（特記情報）エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
//        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 認定調査特記事項照会画面初期化時の検索処理。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return DbT5205NinteichosahyoTokkijikoEntity
     */
    @Transaction
    public List<DbT5205NinteichosahyoTokkijikoEntity> selectBy申請書管理番号_認定調査依頼履歴番号_認定調査特記事項番号(
            ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, List<RString> 認定調査特記事項番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        if (!認定調査特記事項番号.isEmpty()) {
            return accessor.selectSpecific(ninteichosaTokkijikoNo,
                    ninteichosaTokkijikoRemban,
                    tokkijikoTextImageKubun,
                    genponMaskKubun,
                    tokkiJiko).
                    table(DbT5205NinteichosahyoTokkijiko.class).
                    where(and(
                                    eq(shinseishoKanriNo, 申請書管理番号),
                                    eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                    in(ninteichosaTokkijikoNo, 認定調査特記事項番号)
                            )).order(
                            by(ninteichosaTokkijikoNo),
                            by(ninteichosaTokkijikoRemban)).
                    toList(DbT5205NinteichosahyoTokkijikoEntity.class);
        } else {
            return accessor.selectSpecific(ninteichosaTokkijikoNo,
                    ninteichosaTokkijikoRemban,
                    tokkijikoTextImageKubun,
                    genponMaskKubun,
                    tokkiJiko).
                    table(DbT5205NinteichosahyoTokkijiko.class).
                    where(and(
                                    eq(shinseishoKanriNo, 申請書管理番号),
                                    eq(ninteichosaRirekiNo, 認定調査依頼履歴番号)
                            )).order(
                            by(ninteichosaTokkijikoNo),
                            by(ninteichosaTokkijikoRemban)).
                    toList(DbT5205NinteichosahyoTokkijikoEntity.class);
        }
    }

    /**
     * 申請書管理番号And認定調査依頼履歴番号で認定調査票（特記情報）を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @return List<DbT5205NinteichosahyoTokkijikoEntity>
     */
    @Transaction
    public List<DbT5205NinteichosahyoTokkijikoEntity> selectBy申請書管理番号And認定調査依頼履歴番号(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5205NinteichosahyoTokkijiko.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号)
                        )).order(by(ninteichosaTokkijikoNo), by(ninteichosaTokkijikoRemban)).toList(DbT5205NinteichosahyoTokkijikoEntity.class);

    }
}

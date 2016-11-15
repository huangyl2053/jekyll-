/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.ninteiChosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.ninteiChosainCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.ninteiShinseiShinseijiKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.ninteiShinseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.nyushoShisetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.shujiiCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.shujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報のデータアクセスクラスです。
 *
 * @author n8235 船山洋介
 */
public class DbT5101NinteiShinseiJohoDac implements ISaveable<DbT5101NinteiShinseiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定申請情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return DbT5101NinteiShinseiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5101NinteiShinseiJohoEntity selectByKey(ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5101NinteiShinseiJoho.class).
                where(
                        eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5101NinteiShinseiJohoEntity.class);
    }

    /**
     * 要介護認定申請情報を全件返します。
     *
     * @return List<DbT5101NinteiShinseiJohoEntity>
     */
    @Transaction
    public ItemList<DbT5101NinteiShinseiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT5101NinteiShinseiJoho.class).
                toList(DbT5101NinteiShinseiJohoEntity.class));
    }

    /**
     * DbT5101NinteiShinseiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5101NinteiShinseiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * get申請書情報by申請書管理番号
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報
     */
    @Transaction
    public DbT5101NinteiShinseiJohoEntity get申請書情報by申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(ninteiChosaItakusakiCode, ninteiChosainCode, shujiiIryokikanCode, shujiiCode, nyushoShisetsuCode).
                table(DbT5101NinteiShinseiJoho.class).
                where(eq(shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5101NinteiShinseiJohoEntity.class);
    }

    /**
     * 「証記載保険者番号、被保険者番号、認定申請年月日、認定申請区分_申請時_コード」を指定し、要介護認定申請情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請年月日 認定申請年月日
     * @param 認定申請区分_申請時_コード 認定申請区分_申請時_コード
     * @return DbT5101NinteiShinseiJohoEntity
     */
    @Transaction
    public List<DbT5101NinteiShinseiJohoEntity> get要介護認定申請情報ForCheck(RString 証記載保険者番号, RString 被保険者番号,
            FlexibleDate 認定申請年月日, Code 認定申請区分_申請時_コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5101NinteiShinseiJoho.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(ninteiShinseiYMD, 認定申請年月日),
                                eq(ninteiShinseiShinseijiKubunCode, 認定申請区分_申請時_コード))).
                toList(DbT5101NinteiShinseiJohoEntity.class);
    }
}

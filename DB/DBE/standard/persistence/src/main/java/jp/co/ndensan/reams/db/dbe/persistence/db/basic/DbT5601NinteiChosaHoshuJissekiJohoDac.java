/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJoho.ninteichosaIraiRirekiNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJoho.ninteichosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJoho.ninteichosainCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査報酬実績情報のデータアクセスクラスです。
 *
 * @reamsid_L DBE-9999-011 wanghui
 */
public class DbT5601NinteiChosaHoshuJissekiJohoDac implements ISaveable<DbT5601NinteiChosaHoshuJissekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査報酬実績情報を取得します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return DbT5601NinteiChosaHoshuJissekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5601NinteiChosaHoshuJissekiJohoEntity selectByKey(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) throws NullPointerException {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5601NinteiChosaHoshuJissekiJoho.class).
                where(and(
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード),
                                eq(ninteichosainCode, 認定調査員コード),
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaIraiRirekiNo, 認定調査依頼履歴番号))).
                toObject(DbT5601NinteiChosaHoshuJissekiJohoEntity.class);
    }

    /**
     * 認定調査報酬実績情報を全件返します。
     *
     * @return DbT5601NinteiChosaHoshuJissekiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5601NinteiChosaHoshuJissekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5601NinteiChosaHoshuJissekiJoho.class).
                toList(DbT5601NinteiChosaHoshuJissekiJohoEntity.class);
    }

    /**
     * DbT5601NinteiChosaHoshuJissekiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5601NinteiChosaHoshuJissekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬実績情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT1005KaigoJogaiTokureiTaishoShisetsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT5601NinteiChosaHoshuJissekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬実績情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 認定調査委託料入力実績情報を返します。
     *
     * @param 認定調査委託先コード 認定調査員コード
     * @param 認定調査員コード 認定調査員コード
     * @return DbT5601NinteiChosaHoshuJissekiJohoEntity{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5601NinteiChosaHoshuJissekiJohoEntity> select報酬実績情報(
            RString 認定調査委託先コード,
            RString 認定調査員コード) throws NullPointerException {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbT5601NinteiChosaHoshuJissekiJoho.class).
                where(and(
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード),
                                eq(ninteichosainCode, 認定調査員コード))).
                toList(DbT5601NinteiChosaHoshuJissekiJohoEntity.class);
    }
}

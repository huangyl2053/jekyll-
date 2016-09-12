/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.chosaChikuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.ninteiChosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.ninteiChosainCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.yusenNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地区認定調査員のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 zhangzhiming
 */
public class DbT5223ChikuNinteiChosainDac implements ISaveable<DbT5223ChikuNinteiChosainEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで地区認定調査員を取得します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @return DbT5223ChikuNinteiChosainEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5223ChikuNinteiChosainEntity selectByKey(
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5223ChikuNinteiChosain.class).
                where(and(
                                eq(chosaChikuCode, 調査地区コード),
                                eq(ninteiChosaItakusakiCode, 認定調査委託先コード),
                                eq(ninteiChosainCode, 認定調査員コード),
                                eq(shichosonCode, 市町村コード))).
                toObject(DbT5223ChikuNinteiChosainEntity.class);
    }

    /**
     * 地区認定調査員を全件返します。
     *
     * @return DbT5223ChikuNinteiChosainEntityの{@code list}
     */
    @Transaction
    public List<DbT5223ChikuNinteiChosainEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5223ChikuNinteiChosain.class).
                toList(DbT5223ChikuNinteiChosainEntity.class);
    }

    /**
     * 地区認定調査員を全件返します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return DbT5223ChikuNinteiChosainEntityの{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5223ChikuNinteiChosainEntity> selec地区認定調査員(Code 調査地区コード,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5223ChikuNinteiChosain.class).
                where(and(
                                eq(chosaChikuCode, 調査地区コード),
                                eq(shichosonCode, 市町村コード))).order(by(yusenNo, Order.ASC)).
                toList(DbT5223ChikuNinteiChosainEntity.class);
    }

    /**
     * DbT5223ChikuNinteiChosainEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5223ChikuNinteiChosainEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5223ChikuNinteiChosainEntityを物理削除します。
     *
     * @param entity entity
     * @return 物理削除件数
     */
    @Transaction
    public int delete(DbT5223ChikuNinteiChosainEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員情報エンティティ"));
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}

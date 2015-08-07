/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaisha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaisha.*;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格取得除外者のデータアクセスクラスです。
 */
public class DbT1009ShikakuShutokuJogaishaDac implements ISaveable<DbT1009ShikakuShutokuJogaishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで資格取得除外者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbT1009ShikakuShutokuJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1009ShikakuShutokuJogaishaEntity selectByKey(
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                where(and(
                eq(shikibetsuCode, 識別コード),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * 資格取得除外者を全件返します。
     *
     * @return List<DbT1009ShikakuShutokuJogaishaEntity>
     */
    @Transaction
    public List<DbT1009ShikakuShutokuJogaishaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                toList(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * DbT1009ShikakuShutokuJogaishaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1009ShikakuShutokuJogaishaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJoho.kamokuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJoho.ketteiYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護支払情報のデータアクセスクラスです。
 */
public class DbT7004KaigoShiharaiJohoDac implements ISaveable<DbT7004KaigoShiharaiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護支払情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 科目コード KamokuCode
     * @param 決定年月日 KetteiYMD
     * @return DbT7004KaigoShiharaiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7004KaigoShiharaiJohoEntity selectByKey(
            ShikibetsuCode 識別コード,
            KamokuCode 科目コード,
            FlexibleDate 決定年月日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(科目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("科目コード"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7004KaigoShiharaiJoho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(kamokuCode, 科目コード),
                                eq(ketteiYMD, 決定年月日))).
                toObject(DbT7004KaigoShiharaiJohoEntity.class);
    }

    /**
     * 介護支払情報を全件返します。
     *
     * @return List<DbT7004KaigoShiharaiJohoEntity>
     */
    @Transaction
    public List<DbT7004KaigoShiharaiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7004KaigoShiharaiJoho.class).
                toList(DbT7004KaigoShiharaiJohoEntity.class);
    }

    /**
     * DbT7004KaigoShiharaiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7004KaigoShiharaiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支払情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

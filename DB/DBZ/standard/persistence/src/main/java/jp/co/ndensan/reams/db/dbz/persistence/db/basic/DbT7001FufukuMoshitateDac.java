/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitate;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitate.genshobunsHihokennshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitate.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitate.shinsaSeikyuTodokedeYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不服審査申立情報のデータアクセスクラスです。
 */
public class DbT7001FufukuMoshitateDac implements ISaveable<DbT7001FufukuMoshitateEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで不服審査申立情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunsHihokennshaNo
     * @param 審査請求届出日 ShinsaSeikyuTodokedeYMD
     * @return DbT7001FufukuMoshitateEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7001FufukuMoshitateEntity selectByKey(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7001FufukuMoshitate.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(genshobunsHihokennshaNo, 原処分被保険者番号),
                                eq(shinsaSeikyuTodokedeYMD, 審査請求届出日))).
                toObject(DbT7001FufukuMoshitateEntity.class);
    }

    /**
     * 不服審査申立情報を全件返します。
     *
     * @return List<DbT7001FufukuMoshitateEntity>
     */
    @Transaction
    public List<DbT7001FufukuMoshitateEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7001FufukuMoshitate.class).
                toList(DbT7001FufukuMoshitateEntity.class);
    }

    /**
     * DbT7001FufukuMoshitateEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7001FufukuMoshitateEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("不服審査申立情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
    
     /**
     * 主キーで不服審査申立情報を取得します。
     *
     * @param 識別コード　ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunsHihokennshaNo
     * @return List<DbT7001FufukuMoshitateEntity>
     */
    @Transaction
    public List<DbT7001FufukuMoshitateEntity> select一覧情報取得(ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7001FufukuMoshitate.class).
                where(and(eq(shikibetsuCode, 識別コード),
                                eq(genshobunsHihokennshaNo, 原処分被保険者番号))).
                order(by(DbT7001FufukuMoshitate.shinsaSeikyuTodokedeYMD, Order.DESC)).
                toList(DbT7001FufukuMoshitateEntity.class);
    }
}

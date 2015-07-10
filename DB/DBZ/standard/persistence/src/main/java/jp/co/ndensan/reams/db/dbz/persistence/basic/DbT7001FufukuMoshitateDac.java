/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitate;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitate.genshobunsHihokennshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitate.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitate.shinsaSeikyuTodokedeYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitate.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不服審査申立情報のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7001FufukuMoshitateDac implements IModifiable<DbT7001FufukuMoshitateEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで不服審査申立情報を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunsHihokennshaNo
     * @param 審査請求届出日 ShinsaSeikyuTodokedeYMD
     * @return DbT7001FufukuMoshitateEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7001FufukuMoshitateEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7001FufukuMoshitate.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
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

    @Transaction
    @Override
    public int insert(DbT7001FufukuMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7001FufukuMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7001FufukuMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7001FufukuMoshitateEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7001FufukuMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

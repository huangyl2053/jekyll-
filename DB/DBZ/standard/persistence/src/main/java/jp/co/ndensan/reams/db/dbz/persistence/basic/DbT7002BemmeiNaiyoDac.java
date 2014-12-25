/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyo.bemmeishoSakuseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyo.genshobunHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyo.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyo.shinsaseikyuTodokedeYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyo.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyoEntity;
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
 * 弁明内容のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7002BemmeiNaiyoDac implements IModifiable<DbT7002BemmeiNaiyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで弁明内容を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunHihokenshaNo
     * @param 審査請求届出日 ShinsaseikyuTodokedeYMD
     * @param 弁明書作成日 BemmeishoSakuseiYMD
     * @return DbT7002BemmeiNaiyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7002BemmeiNaiyoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7002BemmeiNaiyo.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikibetsuCode, 識別コード),
                                eq(genshobunHihokenshaNo, 原処分被保険者番号),
                                eq(shinsaseikyuTodokedeYMD, 審査請求届出日),
                                eq(bemmeishoSakuseiYMD, 弁明書作成日))).
                toObject(DbT7002BemmeiNaiyoEntity.class);
    }

    /**
     * 弁明内容を全件返します。
     *
     * @return List<DbT7002BemmeiNaiyoEntity>
     */
    @Transaction
    public List<DbT7002BemmeiNaiyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7002BemmeiNaiyo.class).
                toList(DbT7002BemmeiNaiyoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7002BemmeiNaiyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7002BemmeiNaiyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7002BemmeiNaiyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7002BemmeiNaiyoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7002BemmeiNaiyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

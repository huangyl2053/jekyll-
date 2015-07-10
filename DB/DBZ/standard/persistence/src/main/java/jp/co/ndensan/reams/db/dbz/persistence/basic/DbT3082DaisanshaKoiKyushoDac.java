/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyusho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyusho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyusho.kyushoSeikyuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyusho.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyusho.todokedeKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為求償のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3082DaisanshaKoiKyushoDac implements IModifiable<DbT3082DaisanshaKoiKyushoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護第三者行為求償を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 第三者行為求償請求番号 KyushoSeikyuNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3082DaisanshaKoiKyushoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3082DaisanshaKoiKyushoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3082DaisanshaKoiKyusho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(todokedeKanriNo, 第三者行為届出管理番号),
                                eq(kyushoSeikyuNo, 第三者行為求償請求番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3082DaisanshaKoiKyushoEntity.class);
    }

    /**
     * 介護第三者行為求償を全件返します。
     *
     * @return List<DbT3082DaisanshaKoiKyushoEntity>
     */
    @Transaction
    public List<DbT3082DaisanshaKoiKyushoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3082DaisanshaKoiKyusho.class).
                toList(DbT3082DaisanshaKoiKyushoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3082DaisanshaKoiKyushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3082DaisanshaKoiKyushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3082DaisanshaKoiKyushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3082DaisanshaKoiKyushoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3082DaisanshaKoiKyushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

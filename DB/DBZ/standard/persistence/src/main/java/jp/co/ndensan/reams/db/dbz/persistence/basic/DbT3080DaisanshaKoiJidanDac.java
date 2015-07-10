/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidan.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidan.jidanHokokushoUketukeYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidan.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidan.todokedeKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為示談のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3080DaisanshaKoiJidanDac implements IModifiable<DbT3080DaisanshaKoiJidanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護第三者行為示談を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 示談報告書受付年月日 JidanHokokushoUketukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3080DaisanshaKoiJidanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3080DaisanshaKoiJidanEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            FlexibleDate 示談報告書受付年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(示談報告書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書受付年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3080DaisanshaKoiJidan.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(todokedeKanriNo, 第三者行為届出管理番号),
                                eq(jidanHokokushoUketukeYMD, 示談報告書受付年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3080DaisanshaKoiJidanEntity.class);
    }

    /**
     * 介護第三者行為示談を全件返します。
     *
     * @return List<DbT3080DaisanshaKoiJidanEntity>
     */
    @Transaction
    public List<DbT3080DaisanshaKoiJidanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3080DaisanshaKoiJidan.class).
                toList(DbT3080DaisanshaKoiJidanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3080DaisanshaKoiJidanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3080DaisanshaKoiJidanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3080DaisanshaKoiJidanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3080DaisanshaKoiJidanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3080DaisanshaKoiJidanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

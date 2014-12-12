/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.kyushoSeikyuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.serviceTeikyoJigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.todokedeKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為求償明細のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3083DaisanshaKoiKyushoMeisaiDac implements IModifiable<DbT3083DaisanshaKoiKyushoMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護第三者行為求償明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 第三者行為求償請求番号 KyushoSeikyuNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param サービス提供事業者番号 ServiceTeikyoJigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 処理日時 ShoriTimestamp
     * @return DbT3083DaisanshaKoiKyushoMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3083DaisanshaKoiKyushoMeisaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3083DaisanshaKoiKyushoMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(todokedeKanriNo, 第三者行為届出管理番号),
                                eq(kyushoSeikyuNo, 第三者行為求償請求番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(serviceTeikyoJigyoshaNo, サービス提供事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3083DaisanshaKoiKyushoMeisaiEntity.class);
    }

    /**
     * 介護第三者行為求償明細を全件返します。
     *
     * @return List<DbT3083DaisanshaKoiKyushoMeisaiEntity>
     */
    @Transaction
    public List<DbT3083DaisanshaKoiKyushoMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3083DaisanshaKoiKyushoMeisai.class).
                toList(DbT3083DaisanshaKoiKyushoMeisaiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3083DaisanshaKoiKyushoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3083DaisanshaKoiKyushoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3083DaisanshaKoiKyushoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3083DaisanshaKoiKyushoMeisaiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3083DaisanshaKoiKyushoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

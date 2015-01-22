/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGaku.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGaku.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGaku.tekiyoKaishiYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGaku.yoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuEntity;
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
 * 介護予防・日常生活支援総合事業種類支給限度額のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7118SogoJigyoShuruiShikyuGendoGakuDac implements IModifiable<DbT7118SogoJigyoShuruiShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護予防・日常生活支援総合事業種類支給限度額を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT7118SogoJigyoShuruiShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7118SogoJigyoShuruiShikyuGendoGakuEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7118SogoJigyoShuruiShikyuGendoGaku.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額を全件返します。
     *
     * @return List<DbT7118SogoJigyoShuruiShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7118SogoJigyoShuruiShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7118SogoJigyoShuruiShikyuGendoGaku.class).
                toList(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額を追加します。
     *
     * @param entity 介護予防・日常生活支援総合事業種類支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額をDBに更新します。
     *
     * @param entity 介護予防・日常生活支援総合事業種類支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額をDBから削除します。（論理削除）
     *
     * @param entity 介護予防・日常生活支援総合事業種類支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 介護予防・日常生活支援総合事業種類支給限度額を物理削除。
     *
     * @param entity 介護予防・日常生活支援総合事業種類支給限度額
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}

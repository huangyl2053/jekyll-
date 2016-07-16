/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGaku.tekiyoKaishiYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGaku.yoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護予防・日常生活支援総合事業区分支給限度額のデータアクセスクラスです。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class DbT7117SogoJigyoKubunShikyuGendoGakuDac implements ISaveable<DbT7117SogoJigyoKubunShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護予防・日常生活支援総合事業区分支給限度額を取得します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7117SogoJigyoKubunShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7117SogoJigyoKubunShikyuGendoGakuEntity selectByKey(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7117SogoJigyoKubunShikyuGendoGaku.class).
                where(and(
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class);
    }

    /**
     * 介護予防・日常生活支援総合事業区分支給限度額を全件返します。
     *
     * @return List<DbT7117SogoJigyoKubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7117SogoJigyoKubunShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7117SogoJigyoKubunShikyuGendoGaku.class).
                toList(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class);
    }

    /**
     * 介護予防・日常生活支援総合事業区分支給限度額適用開始日の降順を全件返します。
     *
     * @return List<DbT7117SogoJigyoKubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7117SogoJigyoKubunShikyuGendoGakuEntity> selectAllDesc() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7117SogoJigyoKubunShikyuGendoGaku.class).
                order(by(DbT7117SogoJigyoKubunShikyuGendoGaku.tekiyoKaishiYM, Order.DESC)).
                toList(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class);
    }

    /**
     * DbT7117SogoJigyoKubunShikyuGendoGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業区分支給限度額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

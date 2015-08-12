/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha.rirekiNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku.tekiyoKaishuYM;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT7114UwanoseServiceShuruiShikyuGendoGaku.yoKaigoJotaiKubun;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT7119ServiceCode.serviceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービス種類支給限度額のデータアクセスクラスです。
 */
public class DbT7111ServiceShuruiShikyuGendoGakuDac implements ISaveable<DbT7111ServiceShuruiShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでサービス種類支給限度額を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishuYM
     * @param 履歴番号 RirekiNo
     * @return DbT7111ServiceShuruiShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7111ServiceShuruiShikyuGendoGakuEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishuYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * サービス種類支給限度額を全件返します。
     *
     * @return List<DbT7111ServiceShuruiShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7111ServiceShuruiShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                toList(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * DbT7111ServiceShuruiShikyuGendoGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類支給限度額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}

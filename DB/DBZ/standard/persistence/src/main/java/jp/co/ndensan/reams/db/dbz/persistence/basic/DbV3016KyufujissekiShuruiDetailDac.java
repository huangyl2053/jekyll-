/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.hokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.inputShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.kokanShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.recodeShubetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetail.toshiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績種類詳細のデータアクセスクラスです。
 */
public class DbV3016KyufujissekiShuruiDetailDac implements ISaveable<DbV3016KyufujissekiShuruiDetailEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付実績種類詳細を取得します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @return DbV3016KyufujissekiShuruiDetailEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV3016KyufujissekiShuruiDetailEntity selectByKey(
            ShikibetsuCode 交換情報識別番号,
            ShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3016KyufujissekiShuruiDetail.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(hokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshoNo, 事業所番号),
                                eq(toshiNo, 通し番号))).
                toObject(DbV3016KyufujissekiShuruiDetailEntity.class);
    }

    /**
     * 給付実績種類詳細を全件返します。
     *
     * @return DbV3016KyufujissekiShuruiDetailEntityの{@code list}
     */
    @Transaction
    public List<DbV3016KyufujissekiShuruiDetailEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3016KyufujissekiShuruiDetail.class).
                toList(DbV3016KyufujissekiShuruiDetailEntity.class);
    }

    /**
     * DbV3016KyufujissekiShuruiDetailEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV3016KyufujissekiShuruiDetailEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績種類詳細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}

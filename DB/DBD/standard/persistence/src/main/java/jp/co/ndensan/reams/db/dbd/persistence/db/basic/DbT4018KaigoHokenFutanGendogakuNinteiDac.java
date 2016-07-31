/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei.ketteiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei.tekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNintei.tekiyoShuryoYMD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険負担限度額認定のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-013 wangchao
 */
public class DbT4018KaigoHokenFutanGendogakuNinteiDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return DbT4018KaigoHokenFutanGendogakuNinteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4018KaigoHokenFutanGendogakuNinteiEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4018KaigoHokenFutanGendogakuNintei.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4018KaigoHokenFutanGendogakuNinteiEntity.class);
    }

    /**
     * 被保険者番号より、負担限度額認定情報の件数を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int get負担限度額認定情報の件数(HihokenshaNo 被保険者番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4018KaigoHokenFutanGendogakuNintei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(isNULL(ketteiKubun)),
                                not(eq(ketteiKubun, RString.EMPTY)))).
                getCount();
    }

    /**
     * 被保険者番号より、負担限度額認定の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @param 決定区分 決定区分
     * @return DbT4018KaigoHokenFutanGendogakuNinteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4018KaigoHokenFutanGendogakuNinteiEntity get利用者負担額減額(HihokenshaNo 被保険者番号, FlexibleDate 基準日, RString 決定区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4018KaigoHokenFutanGendogakuNintei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(tekiyoKaishiYMD, 基準日),
                                leq(基準日, tekiyoShuryoYMD),
                                eq(ketteiKubun, 決定区分))).
                order(by(rirekiNo, DESC)).
                limit(1).
                toObject(DbT4018KaigoHokenFutanGendogakuNinteiEntity.class);

    }
}

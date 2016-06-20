/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishosha;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT4037HikazeNenkinTaishoshaMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 非課税年金対象者のデータアクセスクラスです。
 *
 *
 */
public class DbT4037HikazeNenkinTaishoshaDac {

    @InjectSession
    private SqlSession session;

    /**
     * 全て履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年度 年度
     * @return List<DbT4037HikazeNenkinTaishoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT4037HikazeNenkinTaishoshaEntity> select全て履歴(RString 被保険者番号, RYear 年度) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4037HikazeNenkinTaishosha.class).
                where(
                        and(
                                eq(DbT4037HikazeNenkinTaishosha.hihokenshano, 被保険者番号),
                                eq(DbT4037HikazeNenkinTaishosha.dttaishoy, new RString(年度.minusYear(1).toString())))).
                order(new OrderBy(DbT4037HikazeNenkinTaishosha.dtsakuseiymd, Order.DESC, NullsOrder.FIRST)).
                toList(DbT4037HikazeNenkinTaishoshaEntity.class);
    }

    /**
     * 同一年金単位最新履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年度 年度
     * @return List<DbT4037HikazeNenkinTaishoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT4037HikazeNenkinTaishoshaEntity> select同一年金単位最新履歴(RString 被保険者番号, RString 年度) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        IDbT4037HikazeNenkinTaishoshaMapper mapper = session.getMapper(IDbT4037HikazeNenkinTaishoshaMapper.class);

        return mapper.select同一年金単位最新履歴(被保険者番号, 年度);
    }
}

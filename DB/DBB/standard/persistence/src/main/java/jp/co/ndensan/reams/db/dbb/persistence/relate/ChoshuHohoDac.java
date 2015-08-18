/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.relate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2001ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2001ChoshuHohoEntity;
import static jp.co.ndensan.reams.db.dbb.entity.basic.DbT2005KibetsuGemmen.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorList.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorList.hihokenshaNo;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 徴収方法のデータアクセスクラスです。
 *
 * @author n3317 塚田 萌
 */
public class ChoshuHohoDac implements IModifiable<ChoshuHoho> {

    @InjectSession
    private SqlSession session;
    private final DbT2001ChoshuHohoDac 徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);

    /**
     * 引数に該当する徴収方法情報のうち、直近データを１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return ChoshuHoho
     */
    @Transaction
    public Optional<ChoshuHoho> select徴収方法Recently(FukaNendo 賦課年度, HihokenshaNo 被保険者番号) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2001ChoshuHohoEntity> entities = accessor.select().
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度.value()),
                                eq(hihokenshaNo, 被保険者番号))).
                order(
                        by(shoriTimestamp, Order.DESC)).
                toList(DbT2001ChoshuHohoEntity.class);

        return createModel(entities.isEmpty() ? null : entities.get(0));
    }

    private Optional<ChoshuHoho> createModel(DbT2001ChoshuHohoEntity 徴収方法エンティティ) {
        if (徴収方法エンティティ == null) {
            return Optional.empty();
        }

        return Optional.of(new ChoshuHoho(徴収方法エンティティ));
    }

    @Override
    public int insert(ChoshuHoho data) {

        int result = 0;

        if (data == null) {
            return result;
        }
        result = 徴収方法Dac.insert(data.getEntity());

        return result;
    }

    @Override
    public int update(ChoshuHoho data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        result = 徴収方法Dac.update(data.getEntity());

        return result;
    }

    @Override
    public int delete(ChoshuHoho data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        result = 徴収方法Dac.delete(data.getEntity());

        return result;
    }
}

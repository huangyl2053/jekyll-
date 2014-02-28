/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.entity.basic.UrT0517Ishi;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 介護医師情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorDac implements IKaigoDoctorDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<KaigoDoctorEntity> select(ITrueFalseCriteria criteria) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(criteria)
                .toList(KaigoDoctorEntity.class);
    }

    @Override
    public KaigoDoctorEntity select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(and(
                eq(shichosonCode, 市町村コード),
                eq(kaigoIryokikanCode, 介護医療機関コード),
                eq(kaigoIshiCode, 介護医師コード)))
                .toObject(KaigoDoctorEntity.class);
    }

    @Override
    public KaigoDoctorEntity select(
            ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード, IshiJokyo 医師の状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(and(
                eq(shichosonCode, 市町村コード),
                eq(kaigoIryokikanCode, 介護医療機関コード),
                eq(kaigoIshiCode, 介護医師コード),
                eq(shujiiJokyo, 医師の状況.is有効())))
                .toObject(KaigoDoctorEntity.class);
    }

    @Override
    public List<KaigoDoctorEntity> select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(and(
                eq(shichosonCode, 市町村コード),
                eq(kaigoIryokikanCode, 介護医療機関コード)))
                .toList(KaigoDoctorEntity.class);
    }

    @Override
    public List<KaigoDoctorEntity> select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IshiJokyo 医師の状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(and(
                eq(shichosonCode, 市町村コード),
                eq(kaigoIryokikanCode, 介護医療機関コード),
                eq(shujiiJokyo, 医師の状況.is有効())))
                .toList(KaigoDoctorEntity.class);
    }

    @Override
    public List<KaigoDoctorEntity> select(ShichosonCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(eq(shichosonCode, 市町村コード))
                .toList(KaigoDoctorEntity.class);
    }

    @Override
    public List<KaigoDoctorEntity> select(ShichosonCode 市町村コード, IshiJokyo 医師の状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.kaigoIshiCode))
                .where(and(
                eq(shichosonCode, 市町村コード),
                eq(shujiiJokyo, 医師の状況.is有効())))
                .toList(KaigoDoctorEntity.class);
    }
}

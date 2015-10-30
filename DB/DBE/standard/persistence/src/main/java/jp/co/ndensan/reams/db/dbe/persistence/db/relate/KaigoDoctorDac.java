/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigodoctorcode.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode.KaigoIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;

/**
 * 介護医師情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorDac {
    //TODO　介護医師はなくなるため、暫定的にコメントアウト。実装作業にはいった差異にこのクラスを削除する。

//    @InjectSession
//    private SqlSession session;
    public List<KaigoDoctorEntity> select(ITrueFalseCriteria criteria) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(criteria)
//                .toList(KaigoDoctorEntity.class);
//        List<KaigoDoctorEntity> kaigoDoctorList = new ArrayList<>();
        return new ArrayList<>();
    }

    public KaigoDoctorEntity select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(and(
//                                eq(shichosonCode, 市町村コード),
//                                eq(kaigoIryokikanCode, 介護医療機関コード),
//                                eq(kaigoIshiCode, 介護医師コード)))
//                .toObject(KaigoDoctorEntity.class);
        return new KaigoDoctorEntity();
    }

    public KaigoDoctorEntity select(
            LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード, IshiJokyo 医師の状況) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(and(
//                                eq(shichosonCode, 市町村コード),
//                                eq(kaigoIryokikanCode, 介護医療機関コード),
//                                eq(kaigoIshiCode, 介護医師コード),
//                                eq(shujiiJokyo, 医師の状況.有効)))
//                .toObject(KaigoDoctorEntity.class);
        return new KaigoDoctorEntity();
    }

    public List<KaigoDoctorEntity> select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(and(
//                                eq(shichosonCode, 市町村コード),
//                                eq(kaigoIryokikanCode, 介護医療機関コード)))
//                .toList(KaigoDoctorEntity.class);
//        List<KaigoDoctorEntity> kaigoDoctorList = new ArrayList<>();
        return new ArrayList<>();
    }

    public List<KaigoDoctorEntity> select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IshiJokyo 医師の状況) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(and(
//                                eq(shichosonCode, 市町村コード),
//                                eq(kaigoIryokikanCode, 介護医療機関コード),
//                                eq(shujiiJokyo, 医師の状況.有効)))
//                .toList(KaigoDoctorEntity.class);
//        List<KaigoDoctorEntity> kaigoDoctorList = new ArrayList<>();
        return new ArrayList<>();
    }

    public List<KaigoDoctorEntity> select(LasdecCode 市町村コード) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(eq(shichosonCode, 市町村コード))
//                .toList(KaigoDoctorEntity.class);
//        List<KaigoDoctorEntity> kaigoDoctorList = new ArrayList<>();
        return new ArrayList<>();
    }

    public List<KaigoDoctorEntity> select(LasdecCode 市町村コード, IshiJokyo 医師の状況) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select()
//                .table(DbT7012ShujiiJoho.class)
//                .leftJoin(UrT0517Ishi.class, using(DbT7012ShujiiJoho.ishiShikibetsuNo))
//                .where(and(
//                                eq(shichosonCode, 市町村コード),
//                                eq(shujiiJokyo, 医師の状況.有効)))
//                .toList(KaigoDoctorEntity.class);
//        List<KaigoDoctorEntity> kaigoDoctorList = new ArrayList<>();
        return new ArrayList<>();
    }
}

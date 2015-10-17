/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7011ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7011ShujiiIryoKikanJoho.iryokikanJokyo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7011ShujiiIryoKikanJoho.kaigoIryokikanCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7011ShujiiIryoKikanJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.iryokikan.UrT0516IryoKikan;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.using;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 業務共通の医療機関、講座、介護業務独自の主治医医療機関の情報を取得するデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikanDac implements IKaigoIryoKikanDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<KaigoIryoKikanEntity> select(ITrueFalseCriteria criteria) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516IryoKikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(criteria).
                toList(KaigoIryoKikanEntity.class);
    }

    @Override
    public KaigoIryoKikanEntity select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516IryoKikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(and(eq(shichosonCode, 市町村コード), eq(kaigoIryokikanCode, 介護医療機関コード))).
                toObject(KaigoIryoKikanEntity.class);
    }

    @Override
    public KaigoIryoKikanEntity select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IryoKikanJokyo 医療機関状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516IryoKikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(and(eq(shichosonCode, 市町村コード), eq(kaigoIryokikanCode, 介護医療機関コード),
                                eq(iryokikanJokyo, 医療機関状況.is有効()))).
                toObject(KaigoIryoKikanEntity.class);
    }

    @Override
    public List<KaigoIryoKikanEntity> select(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516IryoKikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(eq(shichosonCode, 市町村コード)).
                toList(KaigoIryoKikanEntity.class);
    }

    @Override
    public List<KaigoIryoKikanEntity> select(LasdecCode 市町村コード, IryoKikanJokyo 医療機関状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516IryoKikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(and(eq(shichosonCode, 市町村コード), eq(iryokikanJokyo, 医療機関状況.is有効()))).
                toList(KaigoIryoKikanEntity.class);
    }
}

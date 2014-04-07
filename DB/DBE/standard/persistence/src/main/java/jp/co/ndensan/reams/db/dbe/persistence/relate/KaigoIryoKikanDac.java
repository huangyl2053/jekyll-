/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.entity.basic.UrT0516Iryokikan;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

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
                leftJoin(UrT0516Iryokikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(criteria).
                toList(KaigoIryoKikanEntity.class);
    }

    @Override
    public KaigoIryoKikanEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516Iryokikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(and(eq(shoKisaiHokenshaNo, 証記載保険者番号), eq(kaigoIryokikanCode, 介護医療機関コード))).
                toObject(KaigoIryoKikanEntity.class);
    }

    @Override
    public KaigoIryoKikanEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, IryoKikanJokyo 医療機関状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516Iryokikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(and(eq(shoKisaiHokenshaNo, 証記載保険者番号), eq(kaigoIryokikanCode, 介護医療機関コード),
                eq(iryokikanJokyo, 医療機関状況.is有効()))).
                toObject(KaigoIryoKikanEntity.class);
    }

    @Override
    public List<KaigoIryoKikanEntity> select(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516Iryokikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(eq(shoKisaiHokenshaNo, 証記載保険者番号)).
                toList(KaigoIryoKikanEntity.class);
    }

    @Override
    public List<KaigoIryoKikanEntity> select(ShoKisaiHokenshaNo 証記載保険者番号, IryoKikanJokyo 医療機関状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                leftJoin(UrT0516Iryokikan.class, using(DbT7011ShujiiIryoKikanJoho.iryokikanCode)).
                where(and(eq(shoKisaiHokenshaNo, 証記載保険者番号), eq(iryokikanJokyo, 医療機関状況.is有効()))).
                toList(KaigoIryoKikanEntity.class);
    }
}

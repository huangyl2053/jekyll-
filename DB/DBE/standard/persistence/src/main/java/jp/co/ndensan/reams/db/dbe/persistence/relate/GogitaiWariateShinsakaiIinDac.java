/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.*;

/**
 * 合議体割当情報と、それに割り当てられている審査会委員の情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateShinsakaiIinDac implements IGogitaiWariateShinsakaiIinDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<GogitaiWariateShinsakaiIinEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .order(by(gogitaiNo, DESC), by(gogitaiYukoKikanKaishiYMD, ASC))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }

    @Override
    public List<GogitaiWariateShinsakaiIinEntity> select(GogitaiNo 合議体番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .where(eq(gogitaiNo, 合議体番号.value()))
                .order(by(gogitaiYukoKikanKaishiYMD, ASC))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }

    @Override
    public List<GogitaiWariateShinsakaiIinEntity> select(GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .where(and(leq(gogitaiYukoKikanKaishiYMD, 合議体有効期間開始年月日.value()), leq(合議体有効期間開始年月日.value(), gogitaiYukoKikanShuryoYMD)))
                .order(by(gogitaiNo, DESC))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }

    @Override
    public List<GogitaiWariateShinsakaiIinEntity> select(GogitaiNo 合議体番号, GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .where(and(eq(gogitaiNo, 合議体番号.value()), eq(gogitaiYukoKikanKaishiYMD, 合議体有効期間開始年月日.value())))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }
}

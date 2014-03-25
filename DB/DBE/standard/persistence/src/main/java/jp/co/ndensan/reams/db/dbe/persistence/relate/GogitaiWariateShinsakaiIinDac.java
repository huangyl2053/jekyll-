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
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当情報と、それに割り当てられている審査会委員の情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateShinsakaiIinDac {

    @InjectSession
    private SqlSession session;

    /**
     * すべての合議体の情報と、それぞれに割り当てられている審査会委員をすべて取得します。
     *
     * @return 合議体割当委員のList
     */
    @Transaction
    public List<GogitaiWariateShinsakaiIinEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .order(by(gogitaiNo, ASC), by(gogitaiYukoKikanKaishiYMD, DESC))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }

    /**
     * 合議体番号を指定し、合議体の履歴と、それぞれに割り当てられた審査会委員の情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 合議体割当委員のList
     */
    @Transaction
    public List<GogitaiWariateShinsakaiIinEntity> select(GogitaiNo 合議体番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .where(eq(gogitaiNo, 合議体番号.value()))
                .order(by(gogitaiYukoKikanKaishiYMD, DESC))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }

    /**
     * 合議体有効期間開始年月日を指定し、指定した日付時点で有効な合議体と、それぞれに割り当てられている審査会委員の情報を取得します。
     *
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 合議体割当委員のList
     */
    @Transaction
    public List<GogitaiWariateShinsakaiIinEntity> select(GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .leftJoin(DbT5103GogitaiJoho.class,
                using(DbT5107GogitaiWariateIinJoho.gogitaiNo, DbT5107GogitaiWariateIinJoho.gogitaiYukoKikanKaishiYMD))
                .leftJoin(DbT5104ShinsakaiKaisaiBashoJoho.class, using(DbT5103GogitaiJoho.shinsakaiKaisaiBashoCode))
                .where(and(leq(gogitaiYukoKikanKaishiYMD, 合議体有効期間開始年月日.value()), leq(合議体有効期間開始年月日.value(), gogitaiYukoKikanShuryoYMD)))
                .order(by(gogitaiNo, ASC))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }

    /**
     * 合議体番号と合議体有効期間開始年月日を指定し、1つの合議体情報と、それに割り当てられた審査会委員の情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 合議体割当委員のList
     */
    @Transaction
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

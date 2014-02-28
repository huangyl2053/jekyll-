/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 合議体割当情報と、それに割り当てられている審査会委員の情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateShinsakaiIinDac implements IGogitaiWariateShinsakaiIinDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<GogitaiWariateShinsakaiIinEntity> select(GogitaiNo 合議体番号, FlexibleDate 合議体有効期間開始年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class, using(DbT5107GogitaiWariateIinJoho.shinsakaiIinCode))
                .where(and(eq(gogitaiNo, 合議体番号.value()), eq(gogitaiYukoKikanKaishiYMD, 合議体有効期間開始年月日)))
                .toList(GogitaiWariateShinsakaiIinEntity.class);
    }
}

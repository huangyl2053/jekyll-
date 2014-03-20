/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate.helper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当委員の情報を取得する、テスト用DACです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateSelector {

    @InjectSession
    private SqlSession session;

    /**
     * 合議体番号と合議体有効開始年月日を受け取り、合議体に割り当てられた委員のリストを返します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効開始年月日 合議体有効開始年月日
     * @return 合議体割当委員List
     */
    @Transaction
    public List<DbT5107GogitaiWariateIinJohoEntity> select(GogitaiNo 合議体番号, FlexibleDate 合議体有効開始年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5107GogitaiWariateIinJoho.class)
                .where(and(eq(gogitaiNo, 合議体番号.value()), eq(gogitaiYukoKikanKaishiYMD, 合議体有効開始年月日)))
                .toList(DbT5107GogitaiWariateIinJohoEntity.class);
    }
}

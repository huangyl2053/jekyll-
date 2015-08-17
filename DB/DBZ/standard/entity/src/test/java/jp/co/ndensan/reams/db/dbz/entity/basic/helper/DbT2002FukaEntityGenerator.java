/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8187
 */
public final class DbT2002FukaEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("1990");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1991");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("12345");
    public static final RDateTime DEFAULT_処理日時 = RDateTime.MIN;
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("123456");
    public static final FlexibleDate DEFAULT_賦課期日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_更正月 = new RString("10");
    public static final RDateTime DEFAULT_調定日時 = RDateTime.MIN;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2002FukaEntityGenerator() {
    }

    public static DbT2002FukaEntity createDbT2002FukaEntity() {
        DbT2002FukaEntity entity = new DbT2002FukaEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setChoteiTimestamp(DEFAULT_処理日時);
        return entity;
    }
}

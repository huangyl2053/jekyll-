/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護期別徴収猶予エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2007KibetsuChoshuYuyoEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("2014");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final RString DEFAULT_徴収方法 = new RString("1");
    public static final int DEFAULT_期 = 1;
    public static final FlexibleDate DEFAULT_徴収猶予開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_徴収猶予終了年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2007KibetsuChoshuYuyoEntityGenerator() {
    }

    public static DbT2007KibetsuChoshuYuyoEntity createDbT2007KibetsuChoshuYuyoEntity() {
        DbT2007KibetsuChoshuYuyoEntity entity = new DbT2007KibetsuChoshuYuyoEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setChoshuHoho(DEFAULT_徴収方法);
        entity.setKi(DEFAULT_期);
        entity.setYuyoStartYMD(DEFAULT_徴収猶予開始年月日);
        entity.setYuyoEndYMD(DEFAULT_徴収猶予終了年月日);
        return entity;
    }
}

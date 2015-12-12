/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護期別徴収猶予エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2007KibetsuChoshuYuyoEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("2014");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("1234567890123456");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(1);
    public static final RString DEFAULT_徴収方法 = new RString("1");
    public static final int DEFAULT_期 = 1;
    public static final FlexibleDate DEFAULT_徴収猶予開始日 = new FlexibleDate("20141216");
    public static final FlexibleDate DEFAULT_徴収猶予終了日 = new FlexibleDate("20141216");

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
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setChoshuHoho(DEFAULT_徴収方法);
        entity.setKi(DEFAULT_期);
        entity.setYuyoStartYMD(DEFAULT_徴収猶予開始日);
        entity.setYuyoEndYMD(DEFAULT_徴収猶予終了日);
        return entity;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護期別エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8156 宮本 康
 */
public final class DbT2003KibetsuEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("2014");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("00000000000000000001");
    public static final RDateTime DEFAULT_処理日時 = RDateTime.MAX;
    public static final RString DEFAULT_徴収方法 = new RString("1");
    public static final int DEFAULT_期 = 1;
    public static final Long DEFAULT_調定ID = 1L;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2003KibetsuEntityGenerator() {
    }

    public static DbT2003KibetsuEntity createDbT2003KibetsuEntity() {
        DbT2003KibetsuEntity entity = new DbT2003KibetsuEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setChoshuHoho(DEFAULT_徴収方法);
        entity.setKi(DEFAULT_期);
        entity.setChoteiId(DEFAULT_調定ID);
        return entity;
    }
}

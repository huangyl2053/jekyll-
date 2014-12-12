/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護賦課徴収猶予エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2006ChoshuYuyoEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("2014");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final FlexibleDate DEFAULT_徴収猶予申請年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_徴収猶予決定年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_徴収猶予取消年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_徴収猶予状態区分 = new RString("1");
    public static final RString DEFAULT_徴収猶予作成区分 = new RString("1");
    public static final RString DEFAULT_申請事由 = new RString("1");
    public static final Code DEFAULT_徴収猶予事由ｺｰﾄﾞ = new Code("3");
    public static final RString DEFAULT_徴収猶予事由 = new RString("1");
    public static final Code DEFAULT_徴収猶予取消事由ｺｰﾄﾞ = new Code("3");
    public static final RString DEFAULT_徴収猶予取消事由 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2006ChoshuYuyoEntityGenerator() {
    }

    public static DbT2006ChoshuYuyoEntity createDbT2006ChoshuYuyoEntity() {
        DbT2006ChoshuYuyoEntity entity = new DbT2006ChoshuYuyoEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShinseiYMD(DEFAULT_徴収猶予申請年月日);
        entity.setKetteiYMD(DEFAULT_徴収猶予決定年月日);
        entity.setTorikeshiYMD(DEFAULT_徴収猶予取消年月日);
        entity.setJotaiKubun(DEFAULT_徴収猶予状態区分);
        entity.setSakuseiKubun(DEFAULT_徴収猶予作成区分);
        entity.setShinseiJiyu(DEFAULT_申請事由);
        entity.setYuyoJiyuCode(DEFAULT_徴収猶予事由ｺｰﾄﾞ);
        entity.setYuyoJiyu(DEFAULT_徴収猶予事由);
        entity.setYuyoTorikeshiJiyuCode(DEFAULT_徴収猶予取消事由ｺｰﾄﾞ);
        entity.setYuyoTorikeshiJiyu(DEFAULT_徴収猶予取消事由);
        return entity;
    }
}

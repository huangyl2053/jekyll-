/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課徴収猶予エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2006ChoshuYuyoEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("1990");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_徴収猶予申請年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_徴収猶予決定年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_徴収猶予取消年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_徴収猶予状態区分 = new RString("1");
    public static final RString DEFAULT_徴収猶予作成区分 = new RString("1");
    public static final RString DEFAULT_申請事由 = new RString("Data");
    public static final Code DEFAULT_徴収猶予種類コード = new Code();
    public static final RString DEFAULT_徴収猶予事由 = new RString("Data");
    public static final Code DEFAULT_徴収猶予取消種類コード = new Code();
    public static final RString DEFAULT_徴収猶予取消事由 = new RString("Data");

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
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShinseiYMD(DEFAULT_徴収猶予申請年月日);
        entity.setKetteiYMD(DEFAULT_徴収猶予決定年月日);
        entity.setTorikeshiYMD(DEFAULT_徴収猶予取消年月日);
        entity.setJotaiKubun(DEFAULT_徴収猶予状態区分);
        entity.setSakuseiKubun(DEFAULT_徴収猶予作成区分);
        entity.setShinseiJiyu(DEFAULT_申請事由);
        entity.setYuyoJiyuCode(DEFAULT_徴収猶予種類コード);
        entity.setYuyoJiyu(DEFAULT_徴収猶予事由);
        entity.setYuyoTorikeshiJiyuCode(DEFAULT_徴収猶予取消種類コード);
        entity.setYuyoTorikeshiJiyu(DEFAULT_徴収猶予取消事由);
        return entity;
    }
}

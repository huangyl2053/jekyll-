/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課減免エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2004GemmenEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("2014");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final FlexibleDate DEFAULT_減免申請年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_減免決定年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_減免取消年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_減免状態区分 = new RString("1");
    public static final RString DEFAULT_減免作成区分 = new RString("1");
    public static final RString DEFAULT_申請事由 = new RString("1");
    public static final Code DEFAULT_減免事由ｺｰﾄﾞ = new Code("3");
    public static final RString DEFAULT_減免事由 = new RString("1");
    public static final Code DEFAULT_減免取消事由ｺｰﾄﾞ = new Code("3");
    public static final RString DEFAULT_減免取消事由 = new RString("1");
    public static final Decimal DEFAULT_申請減免額 = new Decimal(1);
    public static final Decimal DEFAULT_決定減免額 = new Decimal(1);
    public static final Decimal DEFAULT_取消減免額 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2004GemmenEntityGenerator() {
    }

    public static DbT2004GemmenEntity createDbT2004GemmenEntity() {
        DbT2004GemmenEntity entity = new DbT2004GemmenEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShinseiYMD(DEFAULT_減免申請年月日);
        entity.setKetteiYMD(DEFAULT_減免決定年月日);
        entity.setTorikeshiYMD(DEFAULT_減免取消年月日);
        entity.setJotaiKubun(DEFAULT_減免状態区分);
        entity.setSakuseiKubun(DEFAULT_減免作成区分);
        entity.setShinseiJiyu(DEFAULT_申請事由);
        entity.setGemmenJiyuCode(DEFAULT_減免事由ｺｰﾄﾞ);
        entity.setGemmenJiyu(DEFAULT_減免事由);
        entity.setGemmenTorikeshiJiyuCode(DEFAULT_減免取消事由ｺｰﾄﾞ);
        entity.setGemmenTorikeshiJiyu(DEFAULT_減免取消事由);
        entity.setShinseiGemmenGaku(DEFAULT_申請減免額);
        entity.setKetteiGemmenGaku(DEFAULT_決定減免額);
        entity.setTorikeshiGemmenGaku(DEFAULT_取消減免額);
        return entity;
    }
}

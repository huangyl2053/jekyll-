/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課減免エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2004GemmenEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("1990");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_減免申請日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_減免決定日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_減免取消日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_減免状態区分 = new RString("Data");
    public static final RString DEFAULT_減免作成区分 = new RString("Data");
    public static final RString DEFAULT_申請事由 = new RString("Data");
    public static final Code DEFAULT_減免種類コード = new Code();
    public static final RString DEFAULT_減免事由 = new RString("Data");
    public static final Code DEFAULT_減免取消種類コード = new Code();
    public static final RString DEFAULT_減免取消事由 = new RString("Data");
    public static final Decimal DEFAULT_申請減免額 = new Decimal(0);
    public static final Decimal DEFAULT_決定減免額 = new Decimal(0);
    public static final Decimal DEFAULT_取消減免額 = new Decimal(0);

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
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShinseiYMD(DEFAULT_減免申請日);
        entity.setKetteiYMD(DEFAULT_減免決定日);
        entity.setTorikeshiYMD(DEFAULT_減免取消日);
        entity.setJotaiKubun(DEFAULT_減免状態区分);
        entity.setSakuseiKubun(DEFAULT_減免作成区分);
        entity.setShinseiJiyu(DEFAULT_申請事由);
        entity.setGemmenJiyuCode(DEFAULT_減免種類コード);
        entity.setGemmenJiyu(DEFAULT_減免事由);
        entity.setGemmenTorikeshiJiyuCode(DEFAULT_減免取消種類コード);
        entity.setGemmenTorikeshiJiyu(DEFAULT_減免取消事由);
        entity.setShinseiGemmenGaku(DEFAULT_申請減免額);
        entity.setKetteiGemmenGaku(DEFAULT_決定減免額);
        entity.setTorikeshiGemmenGaku(DEFAULT_取消減免額);
        return entity;
    }
}

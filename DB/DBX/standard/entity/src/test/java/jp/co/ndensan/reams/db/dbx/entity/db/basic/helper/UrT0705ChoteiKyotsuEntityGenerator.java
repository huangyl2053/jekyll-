/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調定共通エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8156 宮本 康
 */
public final class UrT0705ChoteiKyotsuEntityGenerator {

    public static final Long DEFAULT_調定ID = 1L;
    public static final Long DEFAULT_収納ID = 1L;
    public static final RYear DEFAULT_会計年度 = new RYear("2014");
    public static final RYear DEFAULT_処理年度 = new RYear("2014");
    public static final int DEFAULT_処理番号 = 1;
    public static final int DEFAULT_更正回数 = 1;
    public static final RString DEFAULT_調定事由コード = new RString("1");
    public static final RDate DEFAULT_調定日 = new RDate("20140101");
    public static final Decimal DEFAULT_調定額 = new Decimal("1000");
    public static final Decimal DEFAULT_消費税額 = new Decimal("100");
    public static final RDate DEFAULT_納期限 = new RDate("20140101");
    public static final RDate DEFAULT_法定納期限等 = new RDate("20140101");
    public static final boolean DEFAULT_賦課処理状況 = true;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private UrT0705ChoteiKyotsuEntityGenerator() {
    }

    public static UrT0705ChoteiKyotsuEntity createUrT0705ChoteiKyotsuEntity() {
        UrT0705ChoteiKyotsuEntity entity = new UrT0705ChoteiKyotsuEntity();
        entity.setChoteiId(DEFAULT_調定ID);
        entity.setShunoId(DEFAULT_収納ID);
        entity.setKaikeiNendo(DEFAULT_会計年度);
        entity.setShoriNendo(DEFAULT_処理年度);
        entity.setShoriNo(DEFAULT_処理番号);
        entity.setKoseiKaisu(DEFAULT_更正回数);
        entity.setChoteiJiyuCode(DEFAULT_調定事由コード);
        entity.setChoteiYMD(DEFAULT_調定日);
        entity.setChoteigaku(DEFAULT_調定額);
        entity.setShohizei(DEFAULT_消費税額);
        entity.setNokigenYMD(DEFAULT_納期限);
        entity.setHoteiNokigenToYMD(DEFAULT_法定納期限等);
        entity.setFukaShoriJokyo(DEFAULT_賦課処理状況);
        return entity;
    }
}

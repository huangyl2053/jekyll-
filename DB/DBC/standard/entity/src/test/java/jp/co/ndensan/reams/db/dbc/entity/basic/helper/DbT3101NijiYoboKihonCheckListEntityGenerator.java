/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二次予防基本チェックリストエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3101NijiYoboKihonCheckListEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_記入年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_質問事項１ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項３ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項４ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項５ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項６ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項７ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項８ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項９ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１０ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１１ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１２身長 = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１２体重 = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１３ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１４ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１５ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１６ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１７ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１８ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項１９ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２０ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２１ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２２ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２３ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２４ = new Decimal(0);
    public static final Decimal DEFAULT_質問事項２５ = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3101NijiYoboKihonCheckListEntityGenerator() {
    }

    public static DbT3101NijiYoboKihonCheckListEntity createDbT3101NijiYoboKihonCheckListEntity() {
        DbT3101NijiYoboKihonCheckListEntity entity = new DbT3101NijiYoboKihonCheckListEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKinyuYMD(DEFAULT_記入年月日);
        entity.setShitsumonJiko01(DEFAULT_質問事項１);
        entity.setShitsumonJiko02(DEFAULT_質問事項２);
        entity.setShitsumonJiko03(DEFAULT_質問事項３);
        entity.setShitsumonJiko04(DEFAULT_質問事項４);
        entity.setShitsumonJiko05(DEFAULT_質問事項５);
        entity.setShitsumonJiko06(DEFAULT_質問事項６);
        entity.setShitsumonJiko07(DEFAULT_質問事項７);
        entity.setShitsumonJiko08(DEFAULT_質問事項８);
        entity.setShitsumonJiko09(DEFAULT_質問事項９);
        entity.setShitsumonJiko10(DEFAULT_質問事項１０);
        entity.setShitsumonJiko11(DEFAULT_質問事項１１);
        entity.setShitsumonJiko12Shincho(DEFAULT_質問事項１２身長);
        entity.setShitsumonJiko12Taiju(DEFAULT_質問事項１２体重);
        entity.setShitsumonJiko13(DEFAULT_質問事項１３);
        entity.setShitsumonJiko14(DEFAULT_質問事項１４);
        entity.setShitsumonJiko15(DEFAULT_質問事項１５);
        entity.setShitsumonJiko16(DEFAULT_質問事項１６);
        entity.setShitsumonJiko17(DEFAULT_質問事項１７);
        entity.setShitsumonJiko18(DEFAULT_質問事項１８);
        entity.setShitsumonJiko19(DEFAULT_質問事項１９);
        entity.setShitsumonJiko20(DEFAULT_質問事項２０);
        entity.setShitsumonJiko21(DEFAULT_質問事項２１);
        entity.setShitsumonJiko22(DEFAULT_質問事項２２);
        entity.setShitsumonJiko23(DEFAULT_質問事項２３);
        entity.setShitsumonJiko24(DEFAULT_質問事項２４);
        entity.setShitsumonJiko25(DEFAULT_質問事項２５);
        return entity;
    }
}

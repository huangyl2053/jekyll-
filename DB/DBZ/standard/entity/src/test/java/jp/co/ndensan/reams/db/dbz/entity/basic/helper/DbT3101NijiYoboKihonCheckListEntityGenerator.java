/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二次予防基本チェックリストエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3101NijiYoboKihonCheckListEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_記入年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_質問事項１ = 1;
    public static final int DEFAULT_質問事項２ = 1;
    public static final int DEFAULT_質問事項３ = 1;
    public static final int DEFAULT_質問事項４ = 1;
    public static final int DEFAULT_質問事項５ = 1;
    public static final int DEFAULT_質問事項６ = 1;
    public static final int DEFAULT_質問事項７ = 1;
    public static final int DEFAULT_質問事項８ = 1;
    public static final int DEFAULT_質問事項９ = 1;
    public static final int DEFAULT_質問事項１０ = 1;
    public static final int DEFAULT_質問事項１１ = 1;
    public static final Decimal DEFAULT_質問事項１２身長 = new Decimal(90);
    public static final Decimal DEFAULT_質問事項１２体重 = new Decimal(65);
    public static final int DEFAULT_質問事項１３ = 1;
    public static final int DEFAULT_質問事項１４ = 1;
    public static final int DEFAULT_質問事項１５ = 1;
    public static final int DEFAULT_質問事項１６ = 1;
    public static final int DEFAULT_質問事項１７ = 1;
    public static final int DEFAULT_質問事項１８ = 1;
    public static final int DEFAULT_質問事項１９ = 1;
    public static final int DEFAULT_質問事項２０ = 1;
    public static final int DEFAULT_質問事項２１ = 1;
    public static final int DEFAULT_質問事項２２ = 1;
    public static final int DEFAULT_質問事項２３ = 1;
    public static final int DEFAULT_質問事項２４ = 1;
    public static final int DEFAULT_質問事項２５ = 1;

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
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

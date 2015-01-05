/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2002FukaEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("2014");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("0000000002"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final SetaiCode DEFAULT_世帯コード = new SetaiCode(new RString("2"));
    public static final int DEFAULT_世帯員数 = 1;
    public static final FlexibleDate DEFAULT_賦課期日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_課税区分 = new RString("1");
    public static final RString DEFAULT_世帯課税区分 = new RString("1");
    public static final Decimal DEFAULT_合計所得金額 = new Decimal(1);
    public static final Decimal DEFAULT_公的年金収入額 = new Decimal(1);
    public static final RString DEFAULT_保険料段階 = new RString("1");
    public static final RString DEFAULT_保険料算定段階1 = new RString("1");
    public static final Decimal DEFAULT_算定年額保険料1 = new Decimal(1);
    public static final FlexibleYearMonth DEFAULT_月割開始年月1 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_月割終了年月1 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_保険料算定段階2 = new RString("1");
    public static final Decimal DEFAULT_算定年額保険料2 = new Decimal(1);
    public static final FlexibleYearMonth DEFAULT_月割開始年月2 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_月割終了年月2 = new FlexibleYearMonth(new RString("201406"));
    public static final RDateTime DEFAULT_調定日時 = RDateTime.of(2014, 4, 15, 10, 20);
    public static final RString DEFAULT_調定事由1 = new RString("1");
    public static final RString DEFAULT_調定事由2 = new RString("1");
    public static final RString DEFAULT_調定事由3 = new RString("1");
    public static final RString DEFAULT_調定事由4 = new RString("1");
    public static final RString DEFAULT_更正月 = new RString("1");
    public static final Decimal DEFAULT_減免前介護保険料_年額 = new Decimal(1);
    public static final Decimal DEFAULT_減免額 = new Decimal(1);
    public static final Decimal DEFAULT_確定介護保険料_年額 = new Decimal(1);
    public static final RString DEFAULT_保険料段階_仮算定時 = new RString("1");
    public static final RDateTime DEFAULT_徴収方法処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final RDateTime DEFAULT_異動基準日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2002FukaEntityGenerator() {
    }

    public static DbT2002FukaEntity createDbT2002FukaEntity() {
        DbT2002FukaEntity entity = new DbT2002FukaEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setSetaiCode(DEFAULT_世帯コード);
        entity.setSetaiInsu(DEFAULT_世帯員数);
        entity.setFukaYMD(DEFAULT_賦課期日);
        entity.setKazeiKubun(DEFAULT_課税区分);
        entity.setSetaikazeiKubun(DEFAULT_世帯課税区分);
        entity.setGokeiShotokuGaku(DEFAULT_合計所得金額);
        entity.setNenkinShunyuGaku(DEFAULT_公的年金収入額);
        entity.setHokenryoDankai(DEFAULT_保険料段階);
        entity.setHokenryoDankai1(DEFAULT_保険料算定段階1);
        entity.setNengakuHokenryo1(DEFAULT_算定年額保険料1);
        entity.setTsukiwariStartYM1(DEFAULT_月割開始年月1);
        entity.setTsukiwariEndYM1(DEFAULT_月割終了年月1);
        entity.setHokenryoDankai2(DEFAULT_保険料算定段階2);
        entity.setNengakuHokenryo2(DEFAULT_算定年額保険料2);
        entity.setTsukiwariStartYM2(DEFAULT_月割開始年月2);
        entity.setTsukiwariEndYM2(DEFAULT_月割終了年月2);
        entity.setChoteiTimestamp(DEFAULT_調定日時);
        entity.setChoteiJiyu1(DEFAULT_調定事由1);
        entity.setChoteiJiyu2(DEFAULT_調定事由2);
        entity.setChoteiJiyu3(DEFAULT_調定事由3);
        entity.setChoteiJiyu4(DEFAULT_調定事由4);
        entity.setKoseiM(DEFAULT_更正月);
        entity.setGemmenMaeHokenryo(DEFAULT_減免前介護保険料_年額);
        entity.setGemmenGaku(DEFAULT_減免額);
        entity.setKakuteiHokenryo(DEFAULT_確定介護保険料_年額);
        entity.setHokenryoDankaiKarisanntei(DEFAULT_保険料段階_仮算定時);
        entity.setChoshuHohoShoriTimestamp(DEFAULT_徴収方法処理日時);
        entity.setIdoKijunTimestamp(DEFAULT_異動基準日時);
        return entity;
    }
}

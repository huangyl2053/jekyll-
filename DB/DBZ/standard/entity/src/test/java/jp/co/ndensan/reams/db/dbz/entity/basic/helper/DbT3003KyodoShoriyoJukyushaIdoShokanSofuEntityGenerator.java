/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 共同処理用受給者異動償還送付エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator {

    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_異動区分コード = new RString("1");
    public static final RString DEFAULT_受給者異動事由 = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_保険給付支払一時差止開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_保険給付支払一時差止終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_保険給付支払一時差止区分コード = new RString("1");
    public static final Decimal DEFAULT_保険給付支払一時差止金額 = new Decimal(1);
    public static final boolean DEFAULT_訂正連絡票フラグ = false;
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator() {
    }

    public static DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity() {
        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
        entity.setIdoYMD(DEFAULT_異動年月日);
        entity.setIdoKubunCode(DEFAULT_異動区分コード);
        entity.setJukyushaIdoJiyu(DEFAULT_受給者異動事由);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setSyoriTimestamp(DEFAULT_処理日時);
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(DEFAULT_保険給付支払一時差止開始年月日);
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(DEFAULT_保険給付支払一時差止終了年月日);
        entity.setHokenkyufuIchijiSashitomeKubunCode(DEFAULT_保険給付支払一時差止区分コード);
        entity.setHokenkyufuIchijiSashitomeKingaku(DEFAULT_保険給付支払一時差止金額);
        entity.setTeiseiRenrakuhyoFlag(DEFAULT_訂正連絡票フラグ);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
